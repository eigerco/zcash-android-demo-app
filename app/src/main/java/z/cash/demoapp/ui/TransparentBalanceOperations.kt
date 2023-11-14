package z.cash.demoapp.ui

import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.runBlocking
import uniffi.zcash.ZcashOrchardAddress
import uniffi.zcash.ZcashPaymentAddress
import uniffi.zcash.ZcashTransparentAddress
import z.cash.demoapp.utils.Constants
import z.cash.demoapp.utils.LightWalletClient

enum class AddressType {
    TRANSPARENT, SAPLING, ORCHARD, UNIFIED, INVALID
}

object TransparentBalanceOperations {

    fun isValidTransparentAddress(address: String): Boolean {
        return getAddressType(address) == AddressType.TRANSPARENT
    }

    fun getBalanceFromTransparentAddress(address: String): Long {
        return runBlocking {
            LightWalletClient
                .getUtxos(address)
                .map { u -> u.valueZat }
                .reduce { acc, v -> v + acc }
        }
    }

    /**
     * This is an exemplary function to show how to decide whose type
     * is the address being given as a string. There was not a good way
     * to solve the issue with the boundaries that UniFFI impose,
     * so we had to work around this. Maybe a good issue for a PR!
     */
    private fun getAddressType(addr: String): AddressType {
        val transparentAddress =
            try {
                ZcashTransparentAddress.decode(Constants.PARAMS, addr)
            } catch(_: Throwable) {
                null
            }

        val saplingAddress =
            try {
                ZcashPaymentAddress.decode(Constants.PARAMS, addr)
            } catch(_: Throwable) {
                null
            }

        val orchardAddress =
            try {
                val rawBytes = addr.toByteArray().map { it.toUByte()}
                ZcashOrchardAddress.fromRawAddressBytes(rawBytes)
            } catch(_: Throwable) {
                null
            }

        val unifiedAddress =
            try {
                val rawBytes = addr.toByteArray().map { it.toUByte()}
                ZcashOrchardAddress.fromRawAddressBytes(rawBytes)
            } catch(_: Throwable) {
                null
            }

        return if(transparentAddress != null ) {
            AddressType.TRANSPARENT
        } else if(saplingAddress != null ) {
            AddressType.SAPLING
        } else if(orchardAddress != null ) {
            AddressType.ORCHARD
        } else if(unifiedAddress != null ) {
            AddressType.UNIFIED
        } else {
            AddressType.INVALID
        }
    }
}