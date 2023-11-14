package z.cash.demoapp.db

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.sqlite.db.SupportSQLiteQueryBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uniffi.zcash.ZcashBlockHeight
import java.util.Locale
import kotlin.coroutines.CoroutineContext

/**
 * This class has a double utility:
 *  - as a container for the findTransactionByTxId, taken from the ECC application SDK
 *  - it is needed to create the database
 *
 *  There is another database for blocks only, but that is handled by librustzcash directly,
 *  and does not need a helper on the Android side.
 */
class WalletDb(val context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    fun destroy() {
        close()
        context.deleteDatabase(DATABASE_NAME)
    }

    override fun onCreate(db: SQLiteDatabase?) {
        //
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        onCreate(db)
    }
    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }
    companion object {
        // If you change the database schema, you must increment the database version.
        const val DATABASE_VERSION = 8
        const val DATABASE_NAME = "WalletDatabase.db"
    }

    @Suppress("LongParameterList")
    private fun <T> SupportSQLiteDatabase.queryAndMap(
        table: String,
        columns: Array<String>? = null,
        selection: String? = null,
        selectionArgs: Array<Any>? = null,
        groupBy: String? = null,
        having: String? = null,
        orderBy: String? = null,
        limit: String? = null,
        offset: String? = null,
        coroutineContext: CoroutineContext = Dispatchers.IO,
        cursorParser: CursorParser<T>
    ) = flow<T> {
        val qb = SupportSQLiteQueryBuilder.builder(table).apply {
            columns(columns)
            selection(selection, selectionArgs)
            having(having)
            groupBy(groupBy)
            orderBy(orderBy)

            if (null != limit) {
                // Counterintuitive but correct. When using the comma syntax, offset comes first.
                // When using the keyword syntax, "LIMIT 1 OFFSET 2" then the offset comes second.
                if (null == offset) {
                    limit(limit)
                } else {
                    limit(String.format(Locale.ROOT, "%s,%s", offset, limit)) // NON-NLS
                }
            }
        }

        query(qb.create()).use {
            it.moveToPosition(-1)
            while (it.moveToNext()) {
                emit(cursorParser.newObject(it))
            }
        }
    }.flowOn(coroutineContext)

    // Librustzcash doesn't have a function for extracting the transaction from the database
    suspend fun findEncodedTransactionByTxId(txId: FirstClassByteArray): EncodedTransaction? {
        val columns = arrayOf(
            TransactionTableDefinition.COLUMN_BLOB_TRANSACTION_ID,
            TransactionTableDefinition.COLUMN_BLOB_RAW,
            TransactionTableDefinition.COLUMN_INTEGER_EXPIRY_HEIGHT
        )

        val SELECTION_TRANSACTION_ID_AND_RAW_NOT_NULL = String.format(
            Locale.ROOT,
            "%s = ? AND %s IS NOT NULL", // $NON-NLS
            TransactionTableDefinition.COLUMN_BLOB_TRANSACTION_ID,
            TransactionTableDefinition.COLUMN_BLOB_RAW
        )

        val databaseFile = context.getDatabasePath(DATABASE_NAME)

        return SupportSqliteOpenHelper
            .openExistingDatabase(context, databaseFile, DATABASE_VERSION)
            .queryAndMap(
                table = TransactionTableDefinition.TABLE_NAME,
                columns = columns,
                selection = SELECTION_TRANSACTION_ID_AND_RAW_NOT_NULL,
                selectionArgs = arrayOf(txId.byteArray)
            ) {
                val rawIndex = it.getColumnIndexOrThrow(TransactionTableDefinition.COLUMN_BLOB_RAW)
                val heightIndex = it.getColumnIndexOrThrow(TransactionTableDefinition.COLUMN_INTEGER_EXPIRY_HEIGHT)

                val raw = it.getBlob(rawIndex)
                val expiryHeight = if (it.isNull(heightIndex)) {
                    null
                } else {
                    ZcashBlockHeight(it.getLong(heightIndex).toUInt())
                }

                EncodedTransaction(
                    txId,
                    FirstClassByteArray(raw),
                    expiryHeight
                )
            }.firstOrNull()
    }

    object TransactionTableDefinition {
        const val TABLE_NAME = "transactions" // $NON-NLS

        const val COLUMN_INTEGER_ID = "id_tx" // $NON-NLS

        const val COLUMN_BLOB_TRANSACTION_ID = "txid" // $NON-NLS

        const val COLUMN_TEXT_CREATED = "created" // $NON-NLS

        const val COLUMN_INTEGER_BLOCK = "block" // $NON-NLS

        const val COLUMN_INTEGER_TX_INDEX = "tx_index" // $NON-NLS

        const val COLUMN_INTEGER_EXPIRY_HEIGHT = "expiry_height" // $NON-NLS

        const val COLUMN_BLOB_RAW = "raw" // $NON-NLS
    }
}

// Utility structures for the above
class FirstClassByteArray(val byteArray: ByteArray) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as FirstClassByteArray

        return byteArray.contentEquals(other.byteArray)
    }

    override fun hashCode() = byteArray.contentHashCode()

    override fun toString(): String {
        return "FirstClassByteArray(${byteArray.toHex()})"
    }
}

fun ByteArray.toHex(): String {
    val sb = StringBuilder(size * 2)
    for (b in this) {
        sb.append(String.format(Locale.ROOT, "%02x", b))
    }
    return sb.toString()
}


fun interface CursorParser<T> {
    /**
     * Extracts an object from a Cursor.  This method assumes that the Cursor contains all the needed columns and
     * that the Cursor is positioned to a row that is ready to be read. This method, in turn, will not mutate
     * the Cursor or move the Cursor position.
     *
     * @param cursor Cursor from a query to a contract this parser can handle.
     * @return a new Object.
     * @throws AssertionError If the cursor is closed or the cursor is out of range.
     */
    fun newObject(cursor: Cursor): T
}