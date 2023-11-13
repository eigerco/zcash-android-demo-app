package z.cash.demoapp.utils

import uniffi.zcash.ZcashAccountId
import uniffi.zcash.ZcashConsensusParameters

object Constants {

    // Here is the seed used primarily to create a wallet
    val SEED: List<UByte> = listOf()

//        listOf(69,85,17,24,57,110,39,48,123,19,180,141,93,49,140,98,144,43,13,213,37,118,54,238,112,74,
//        178,221,133,28,45,55,140,5,130,134,247,180,72,223,127,7,246,235,216,196,189,207,205,224,130,6,22,67,
//        197,189,118,235,46,96,58,198,3,110).map {it.toUByte() }

    // this should be set as a height antecedent to any operation done
    // with the wallet being restored with the seed above.
    const val WALLET_BIRTHDAY_HEIGHT: Long = 0L

    // This is a global parameter because here we assume that the app uses either the test or main net.
    val PARAMS = ZcashConsensusParameters.TEST_NETWORK

    // For the demo we use the lightwalletd node
    const val NETWORK_ADDRESS = "lightwalletd.testnet.electriccoin.co"
    const val NETWORK_PORT = 9067

    // This property is useful when interacting with the database,
    // the lower the easier it is to get updates.
    const val MIN_CONFIRMATIONS = 1u

    // assuming there is always only one account in the database
    val ACCOUNT_ID = ZcashAccountId(0u)

    const val LAST_TX_ID_LABEL = "last-tx-id"
    const val CACHE_LABEL = "transactions"

    const val MAX_BLOCKS_TO_SCAN = 60L

    const val RECIPIENT_ADDRESS = "0x..."
}