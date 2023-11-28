package z.cash.demoapp.utils

import uniffi.zcash.ZcashAccountId
import uniffi.zcash.ZcashConsensusParameters

object Constants {

    /**
     * Here is the seed used primarily to create a wallet
     */
    val SEED: List<UByte> = listOf(70,85,17,24,57,110,39,48,123,19,180,141,93,49,140,98,
        144,43,13,213,37,118,54,238,112,74,177,221,133,28,45,55,140,5,130,134,247,180,
        72,223).map { it.toUByte() }

    // this should be set as a height antecedent to any operation done
    // with the wallet being restored with the seed above.
    const val WALLET_BIRTHDAY_HEIGHT: Long = 2610659L

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

    const val MAX_UTXOS = 10

    const val RECIPIENT_ADDRESS = "ztestsapling1yfp9e7m2xze0zkhhj7y6k26gepwa6z3a27kq3ngxpl455vp26dv7jc9cv2wa3phngyz967qj88h"
}