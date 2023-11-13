package z.cash.demoapp.db

import uniffi.zcash.ZcashBlockHeight

// Used to contain the transaction extracted from the Wallet database.
data class EncodedTransaction(
    val txId: FirstClassByteArray,
    val raw: FirstClassByteArray,
    val expiryHeight: ZcashBlockHeight?
)
