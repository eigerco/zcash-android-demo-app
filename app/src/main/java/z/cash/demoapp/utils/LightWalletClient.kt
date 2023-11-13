package z.cash.demoapp.utils

import cash.z.wallet.sdk.internal.rpc.CompactFormats
import cash.z.wallet.sdk.internal.rpc.CompactTxStreamerGrpcKt
import cash.z.wallet.sdk.internal.rpc.Service
import cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosReply
import com.google.protobuf.ByteString
import io.grpc.ManagedChannelBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asExecutor
import kotlinx.coroutines.flow.Flow

/**
 * This is where all the network calls reside
 * There is no error handling or any other form of error mitigation
 * This is not part of librustzcash, and it is used as a commodity to
 * make contact with the Zcash network using lightwalletd.
 */
object LightWalletClient {

    // This is by default using a remote node, but it is possible to use a local client too.
    private val client = CompactTxStreamerGrpcKt.CompactTxStreamerCoroutineStub(
        ManagedChannelBuilder.forAddress(Constants.NETWORK_ADDRESS, Constants.NETWORK_PORT)
            .useTransportSecurity()
            .executor(Dispatchers.IO.asExecutor())
            .build()
    )

    fun downloadBlockRange(heightRange: ClosedRange<Long>): Flow<CompactFormats.CompactBlock> {
        val startValue = Service.BlockID.newBuilder().setHeight(heightRange.start).build()
        val endValue = Service.BlockID.newBuilder().setHeight(heightRange.endInclusive).build()
        val rangeRequest = Service.BlockRange.newBuilder()
            .setStart(startValue)
            .setEnd(endValue)
            .build()

        return client.getBlockRange(rangeRequest)
    }

    suspend fun getLatestBlockHeight(): Service.BlockID {
        val request = Service.ChainSpec.getDefaultInstance()

        return client.getLatestBlock(request)
    }

    suspend fun getTreeState(value: Long): Service.TreeState {
        val request =  Service.BlockID.newBuilder().setHeight(value).build()

        return client.getTreeState(request)
    }

    suspend fun submitTransaction(transactionData: ByteArray): Service.SendResponse {
        val request = Service.RawTransaction.newBuilder()
            .setData(ByteString.copyFrom(transactionData))
            .build()

        return client.sendTransaction(request)
    }

    suspend fun getTransaction(txHashOrId: ByteString): Service.RawTransaction {
        val request = Service.TxFilter.newBuilder().setHash(txHashOrId).build()

        return client.getTransaction(request)
    }

    fun getUtxos(tAddresses: List<String>): Flow<GetAddressUtxosReply> {

        val getUtxosBuilder = Service.GetAddressUtxosArg.newBuilder()

        getUtxosBuilder.addAllAddresses(tAddresses)

        val request = getUtxosBuilder.build()

        return client.getAddressUtxosStream(request)
    }
}