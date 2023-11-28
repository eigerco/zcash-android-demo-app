package z.cash.demoapp.utils

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

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

}