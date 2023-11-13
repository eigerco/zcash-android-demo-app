package cash.z.wallet.sdk.`internal`.rpc

import cash.z.wallet.sdk.`internal`.rpc.CompactTxStreamerGrpc.getServiceDescriptor
import io.grpc.CallOptions
import io.grpc.CallOptions.DEFAULT
import io.grpc.Channel
import io.grpc.Metadata
import io.grpc.MethodDescriptor
import io.grpc.ServerServiceDefinition
import io.grpc.ServerServiceDefinition.builder
import io.grpc.ServiceDescriptor
import io.grpc.Status.UNIMPLEMENTED
import io.grpc.StatusException
import io.grpc.kotlin.AbstractCoroutineServerImpl
import io.grpc.kotlin.AbstractCoroutineStub
import io.grpc.kotlin.ClientCalls.clientStreamingRpc
import io.grpc.kotlin.ClientCalls.serverStreamingRpc
import io.grpc.kotlin.ClientCalls.unaryRpc
import io.grpc.kotlin.ServerCalls.clientStreamingServerMethodDefinition
import io.grpc.kotlin.ServerCalls.serverStreamingServerMethodDefinition
import io.grpc.kotlin.ServerCalls.unaryServerMethodDefinition
import io.grpc.kotlin.StubFor
import kotlin.String
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic
import kotlinx.coroutines.flow.Flow

/**
 * Holder for Kotlin coroutine-based client and server APIs for
 * cash.z.wallet.sdk.rpc.CompactTxStreamer.
 */
public object CompactTxStreamerGrpcKt {
  public const val SERVICE_NAME: String = CompactTxStreamerGrpc.SERVICE_NAME

  @JvmStatic
  public val serviceDescriptor: ServiceDescriptor
    get() = getServiceDescriptor()

  public val getLatestBlockMethod: MethodDescriptor<Service.ChainSpec, Service.BlockID>
    @JvmStatic
    get() = CompactTxStreamerGrpc.getGetLatestBlockMethod()

  public val getBlockMethod: MethodDescriptor<Service.BlockID, CompactFormats.CompactBlock>
    @JvmStatic
    get() = CompactTxStreamerGrpc.getGetBlockMethod()

  public val getBlockNullifiersMethod:
      MethodDescriptor<Service.BlockID, CompactFormats.CompactBlock>
    @JvmStatic
    get() = CompactTxStreamerGrpc.getGetBlockNullifiersMethod()

  public val getBlockRangeMethod: MethodDescriptor<Service.BlockRange, CompactFormats.CompactBlock>
    @JvmStatic
    get() = CompactTxStreamerGrpc.getGetBlockRangeMethod()

  public val getBlockRangeNullifiersMethod:
      MethodDescriptor<Service.BlockRange, CompactFormats.CompactBlock>
    @JvmStatic
    get() = CompactTxStreamerGrpc.getGetBlockRangeNullifiersMethod()

  public val getTransactionMethod: MethodDescriptor<Service.TxFilter, Service.RawTransaction>
    @JvmStatic
    get() = CompactTxStreamerGrpc.getGetTransactionMethod()

  public val sendTransactionMethod: MethodDescriptor<Service.RawTransaction, Service.SendResponse>
    @JvmStatic
    get() = CompactTxStreamerGrpc.getSendTransactionMethod()

  public val getTaddressTxidsMethod:
      MethodDescriptor<Service.TransparentAddressBlockFilter, Service.RawTransaction>
    @JvmStatic
    get() = CompactTxStreamerGrpc.getGetTaddressTxidsMethod()

  public val getTaddressBalanceMethod: MethodDescriptor<Service.AddressList, Service.Balance>
    @JvmStatic
    get() = CompactTxStreamerGrpc.getGetTaddressBalanceMethod()

  public val getTaddressBalanceStreamMethod: MethodDescriptor<Service.Address, Service.Balance>
    @JvmStatic
    get() = CompactTxStreamerGrpc.getGetTaddressBalanceStreamMethod()

  public val getMempoolTxMethod: MethodDescriptor<Service.Exclude, CompactFormats.CompactTx>
    @JvmStatic
    get() = CompactTxStreamerGrpc.getGetMempoolTxMethod()

  public val getMempoolStreamMethod: MethodDescriptor<Service.Empty, Service.RawTransaction>
    @JvmStatic
    get() = CompactTxStreamerGrpc.getGetMempoolStreamMethod()

  public val getTreeStateMethod: MethodDescriptor<Service.BlockID, Service.TreeState>
    @JvmStatic
    get() = CompactTxStreamerGrpc.getGetTreeStateMethod()

  public val getLatestTreeStateMethod: MethodDescriptor<Service.Empty, Service.TreeState>
    @JvmStatic
    get() = CompactTxStreamerGrpc.getGetLatestTreeStateMethod()

  public val getSubtreeRootsMethod:
      MethodDescriptor<Service.GetSubtreeRootsArg, Service.SubtreeRoot>
    @JvmStatic
    get() = CompactTxStreamerGrpc.getGetSubtreeRootsMethod()

  public val getAddressUtxosMethod:
      MethodDescriptor<Service.GetAddressUtxosArg, Service.GetAddressUtxosReplyList>
    @JvmStatic
    get() = CompactTxStreamerGrpc.getGetAddressUtxosMethod()

  public val getAddressUtxosStreamMethod:
      MethodDescriptor<Service.GetAddressUtxosArg, Service.GetAddressUtxosReply>
    @JvmStatic
    get() = CompactTxStreamerGrpc.getGetAddressUtxosStreamMethod()

  public val getLightdInfoMethod: MethodDescriptor<Service.Empty, Service.LightdInfo>
    @JvmStatic
    get() = CompactTxStreamerGrpc.getGetLightdInfoMethod()

  public val pingMethod: MethodDescriptor<Service.Duration, Service.PingResponse>
    @JvmStatic
    get() = CompactTxStreamerGrpc.getPingMethod()

  /**
   * A stub for issuing RPCs to a(n) cash.z.wallet.sdk.rpc.CompactTxStreamer service as suspending
   * coroutines.
   */
  @StubFor(CompactTxStreamerGrpc::class)
  public class CompactTxStreamerCoroutineStub @JvmOverloads constructor(
    channel: Channel,
    callOptions: CallOptions = DEFAULT,
  ) : AbstractCoroutineStub<CompactTxStreamerCoroutineStub>(channel, callOptions) {
    override fun build(channel: Channel, callOptions: CallOptions): CompactTxStreamerCoroutineStub =
        CompactTxStreamerCoroutineStub(channel, callOptions)

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun getLatestBlock(request: Service.ChainSpec, headers: Metadata = Metadata()):
        Service.BlockID = unaryRpc(
      channel,
      CompactTxStreamerGrpc.getGetLatestBlockMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun getBlock(request: Service.BlockID, headers: Metadata = Metadata()):
        CompactFormats.CompactBlock = unaryRpc(
      channel,
      CompactTxStreamerGrpc.getGetBlockMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun getBlockNullifiers(request: Service.BlockID, headers: Metadata = Metadata()):
        CompactFormats.CompactBlock = unaryRpc(
      channel,
      CompactTxStreamerGrpc.getGetBlockNullifiersMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Returns a [Flow] that, when collected, executes this RPC and emits responses from the
     * server as they arrive.  That flow finishes normally if the server closes its response with
     * [`Status.OK`][io.grpc.Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    public fun getBlockRange(request: Service.BlockRange, headers: Metadata = Metadata()):
        Flow<CompactFormats.CompactBlock> = serverStreamingRpc(
      channel,
      CompactTxStreamerGrpc.getGetBlockRangeMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Returns a [Flow] that, when collected, executes this RPC and emits responses from the
     * server as they arrive.  That flow finishes normally if the server closes its response with
     * [`Status.OK`][io.grpc.Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    public fun getBlockRangeNullifiers(request: Service.BlockRange, headers: Metadata = Metadata()):
        Flow<CompactFormats.CompactBlock> = serverStreamingRpc(
      channel,
      CompactTxStreamerGrpc.getGetBlockRangeNullifiersMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun getTransaction(request: Service.TxFilter, headers: Metadata = Metadata()):
        Service.RawTransaction = unaryRpc(
      channel,
      CompactTxStreamerGrpc.getGetTransactionMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun sendTransaction(request: Service.RawTransaction, headers: Metadata =
        Metadata()): Service.SendResponse = unaryRpc(
      channel,
      CompactTxStreamerGrpc.getSendTransactionMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Returns a [Flow] that, when collected, executes this RPC and emits responses from the
     * server as they arrive.  That flow finishes normally if the server closes its response with
     * [`Status.OK`][io.grpc.Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    public fun getTaddressTxids(request: Service.TransparentAddressBlockFilter, headers: Metadata =
        Metadata()): Flow<Service.RawTransaction> = serverStreamingRpc(
      channel,
      CompactTxStreamerGrpc.getGetTaddressTxidsMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun getTaddressBalance(request: Service.AddressList, headers: Metadata =
        Metadata()): Service.Balance = unaryRpc(
      channel,
      CompactTxStreamerGrpc.getGetTaddressBalanceMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * This function collects the [Flow] of requests.  If the server terminates the RPC
     * for any reason before collection of requests is complete, the collection of requests
     * will be cancelled.  If the collection of requests completes exceptionally for any other
     * reason, the RPC will be cancelled for that reason and this method will throw that
     * exception.
     *
     * @param requests A [Flow] of request messages.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun getTaddressBalanceStream(requests: Flow<Service.Address>, headers: Metadata =
        Metadata()): Service.Balance = clientStreamingRpc(
      channel,
      CompactTxStreamerGrpc.getGetTaddressBalanceStreamMethod(),
      requests,
      callOptions,
      headers
    )

    /**
     * Returns a [Flow] that, when collected, executes this RPC and emits responses from the
     * server as they arrive.  That flow finishes normally if the server closes its response with
     * [`Status.OK`][io.grpc.Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    public fun getMempoolTx(request: Service.Exclude, headers: Metadata = Metadata()):
        Flow<CompactFormats.CompactTx> = serverStreamingRpc(
      channel,
      CompactTxStreamerGrpc.getGetMempoolTxMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Returns a [Flow] that, when collected, executes this RPC and emits responses from the
     * server as they arrive.  That flow finishes normally if the server closes its response with
     * [`Status.OK`][io.grpc.Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    public fun getMempoolStream(request: Service.Empty, headers: Metadata = Metadata()):
        Flow<Service.RawTransaction> = serverStreamingRpc(
      channel,
      CompactTxStreamerGrpc.getGetMempoolStreamMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun getTreeState(request: Service.BlockID, headers: Metadata = Metadata()):
        Service.TreeState = unaryRpc(
      channel,
      CompactTxStreamerGrpc.getGetTreeStateMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun getLatestTreeState(request: Service.Empty, headers: Metadata = Metadata()):
        Service.TreeState = unaryRpc(
      channel,
      CompactTxStreamerGrpc.getGetLatestTreeStateMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Returns a [Flow] that, when collected, executes this RPC and emits responses from the
     * server as they arrive.  That flow finishes normally if the server closes its response with
     * [`Status.OK`][io.grpc.Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    public fun getSubtreeRoots(request: Service.GetSubtreeRootsArg, headers: Metadata = Metadata()):
        Flow<Service.SubtreeRoot> = serverStreamingRpc(
      channel,
      CompactTxStreamerGrpc.getGetSubtreeRootsMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun getAddressUtxos(request: Service.GetAddressUtxosArg, headers: Metadata =
        Metadata()): Service.GetAddressUtxosReplyList = unaryRpc(
      channel,
      CompactTxStreamerGrpc.getGetAddressUtxosMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Returns a [Flow] that, when collected, executes this RPC and emits responses from the
     * server as they arrive.  That flow finishes normally if the server closes its response with
     * [`Status.OK`][io.grpc.Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    public fun getAddressUtxosStream(request: Service.GetAddressUtxosArg, headers: Metadata =
        Metadata()): Flow<Service.GetAddressUtxosReply> = serverStreamingRpc(
      channel,
      CompactTxStreamerGrpc.getGetAddressUtxosStreamMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun getLightdInfo(request: Service.Empty, headers: Metadata = Metadata()):
        Service.LightdInfo = unaryRpc(
      channel,
      CompactTxStreamerGrpc.getGetLightdInfoMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun ping(request: Service.Duration, headers: Metadata = Metadata()):
        Service.PingResponse = unaryRpc(
      channel,
      CompactTxStreamerGrpc.getPingMethod(),
      request,
      callOptions,
      headers
    )
  }

  /**
   * Skeletal implementation of the cash.z.wallet.sdk.rpc.CompactTxStreamer service based on Kotlin
   * coroutines.
   */
  public abstract class CompactTxStreamerCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    /**
     * Returns the response to an RPC for cash.z.wallet.sdk.rpc.CompactTxStreamer.GetLatestBlock.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun getLatestBlock(request: Service.ChainSpec): Service.BlockID = throw
        StatusException(UNIMPLEMENTED.withDescription("Method cash.z.wallet.sdk.rpc.CompactTxStreamer.GetLatestBlock is unimplemented"))

    /**
     * Returns the response to an RPC for cash.z.wallet.sdk.rpc.CompactTxStreamer.GetBlock.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun getBlock(request: Service.BlockID): CompactFormats.CompactBlock = throw
        StatusException(UNIMPLEMENTED.withDescription("Method cash.z.wallet.sdk.rpc.CompactTxStreamer.GetBlock is unimplemented"))

    /**
     * Returns the response to an RPC for
     * cash.z.wallet.sdk.rpc.CompactTxStreamer.GetBlockNullifiers.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun getBlockNullifiers(request: Service.BlockID):
        CompactFormats.CompactBlock = throw
        StatusException(UNIMPLEMENTED.withDescription("Method cash.z.wallet.sdk.rpc.CompactTxStreamer.GetBlockNullifiers is unimplemented"))

    /**
     * Returns a [Flow] of responses to an RPC for
     * cash.z.wallet.sdk.rpc.CompactTxStreamer.GetBlockRange.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [io.grpc.Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open fun getBlockRange(request: Service.BlockRange): Flow<CompactFormats.CompactBlock> =
        throw
        StatusException(UNIMPLEMENTED.withDescription("Method cash.z.wallet.sdk.rpc.CompactTxStreamer.GetBlockRange is unimplemented"))

    /**
     * Returns a [Flow] of responses to an RPC for
     * cash.z.wallet.sdk.rpc.CompactTxStreamer.GetBlockRangeNullifiers.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [io.grpc.Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open fun getBlockRangeNullifiers(request: Service.BlockRange):
        Flow<CompactFormats.CompactBlock> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method cash.z.wallet.sdk.rpc.CompactTxStreamer.GetBlockRangeNullifiers is unimplemented"))

    /**
     * Returns the response to an RPC for cash.z.wallet.sdk.rpc.CompactTxStreamer.GetTransaction.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun getTransaction(request: Service.TxFilter): Service.RawTransaction =
        throw
        StatusException(UNIMPLEMENTED.withDescription("Method cash.z.wallet.sdk.rpc.CompactTxStreamer.GetTransaction is unimplemented"))

    /**
     * Returns the response to an RPC for cash.z.wallet.sdk.rpc.CompactTxStreamer.SendTransaction.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun sendTransaction(request: Service.RawTransaction): Service.SendResponse =
        throw
        StatusException(UNIMPLEMENTED.withDescription("Method cash.z.wallet.sdk.rpc.CompactTxStreamer.SendTransaction is unimplemented"))

    /**
     * Returns a [Flow] of responses to an RPC for
     * cash.z.wallet.sdk.rpc.CompactTxStreamer.GetTaddressTxids.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [io.grpc.Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open fun getTaddressTxids(request: Service.TransparentAddressBlockFilter):
        Flow<Service.RawTransaction> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method cash.z.wallet.sdk.rpc.CompactTxStreamer.GetTaddressTxids is unimplemented"))

    /**
     * Returns the response to an RPC for
     * cash.z.wallet.sdk.rpc.CompactTxStreamer.GetTaddressBalance.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun getTaddressBalance(request: Service.AddressList): Service.Balance =
        throw
        StatusException(UNIMPLEMENTED.withDescription("Method cash.z.wallet.sdk.rpc.CompactTxStreamer.GetTaddressBalance is unimplemented"))

    /**
     * Returns the response to an RPC for
     * cash.z.wallet.sdk.rpc.CompactTxStreamer.GetTaddressBalanceStream.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param requests A [Flow] of requests from the client.  This flow can be
     *        collected only once and throws [java.lang.IllegalStateException] on attempts to
     * collect
     *        it more than once.
     */
    public open suspend fun getTaddressBalanceStream(requests: Flow<Service.Address>):
        Service.Balance = throw
        StatusException(UNIMPLEMENTED.withDescription("Method cash.z.wallet.sdk.rpc.CompactTxStreamer.GetTaddressBalanceStream is unimplemented"))

    /**
     * Returns a [Flow] of responses to an RPC for
     * cash.z.wallet.sdk.rpc.CompactTxStreamer.GetMempoolTx.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [io.grpc.Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open fun getMempoolTx(request: Service.Exclude): Flow<CompactFormats.CompactTx> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method cash.z.wallet.sdk.rpc.CompactTxStreamer.GetMempoolTx is unimplemented"))

    /**
     * Returns a [Flow] of responses to an RPC for
     * cash.z.wallet.sdk.rpc.CompactTxStreamer.GetMempoolStream.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [io.grpc.Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open fun getMempoolStream(request: Service.Empty): Flow<Service.RawTransaction> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method cash.z.wallet.sdk.rpc.CompactTxStreamer.GetMempoolStream is unimplemented"))

    /**
     * Returns the response to an RPC for cash.z.wallet.sdk.rpc.CompactTxStreamer.GetTreeState.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun getTreeState(request: Service.BlockID): Service.TreeState = throw
        StatusException(UNIMPLEMENTED.withDescription("Method cash.z.wallet.sdk.rpc.CompactTxStreamer.GetTreeState is unimplemented"))

    /**
     * Returns the response to an RPC for
     * cash.z.wallet.sdk.rpc.CompactTxStreamer.GetLatestTreeState.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun getLatestTreeState(request: Service.Empty): Service.TreeState = throw
        StatusException(UNIMPLEMENTED.withDescription("Method cash.z.wallet.sdk.rpc.CompactTxStreamer.GetLatestTreeState is unimplemented"))

    /**
     * Returns a [Flow] of responses to an RPC for
     * cash.z.wallet.sdk.rpc.CompactTxStreamer.GetSubtreeRoots.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [io.grpc.Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open fun getSubtreeRoots(request: Service.GetSubtreeRootsArg): Flow<Service.SubtreeRoot>
        = throw
        StatusException(UNIMPLEMENTED.withDescription("Method cash.z.wallet.sdk.rpc.CompactTxStreamer.GetSubtreeRoots is unimplemented"))

    /**
     * Returns the response to an RPC for cash.z.wallet.sdk.rpc.CompactTxStreamer.GetAddressUtxos.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun getAddressUtxos(request: Service.GetAddressUtxosArg):
        Service.GetAddressUtxosReplyList = throw
        StatusException(UNIMPLEMENTED.withDescription("Method cash.z.wallet.sdk.rpc.CompactTxStreamer.GetAddressUtxos is unimplemented"))

    /**
     * Returns a [Flow] of responses to an RPC for
     * cash.z.wallet.sdk.rpc.CompactTxStreamer.GetAddressUtxosStream.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [io.grpc.Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open fun getAddressUtxosStream(request: Service.GetAddressUtxosArg):
        Flow<Service.GetAddressUtxosReply> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method cash.z.wallet.sdk.rpc.CompactTxStreamer.GetAddressUtxosStream is unimplemented"))

    /**
     * Returns the response to an RPC for cash.z.wallet.sdk.rpc.CompactTxStreamer.GetLightdInfo.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun getLightdInfo(request: Service.Empty): Service.LightdInfo = throw
        StatusException(UNIMPLEMENTED.withDescription("Method cash.z.wallet.sdk.rpc.CompactTxStreamer.GetLightdInfo is unimplemented"))

    /**
     * Returns the response to an RPC for cash.z.wallet.sdk.rpc.CompactTxStreamer.Ping.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun ping(request: Service.Duration): Service.PingResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method cash.z.wallet.sdk.rpc.CompactTxStreamer.Ping is unimplemented"))

    final override fun bindService(): ServerServiceDefinition = builder(getServiceDescriptor())
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = CompactTxStreamerGrpc.getGetLatestBlockMethod(),
      implementation = ::getLatestBlock
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = CompactTxStreamerGrpc.getGetBlockMethod(),
      implementation = ::getBlock
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = CompactTxStreamerGrpc.getGetBlockNullifiersMethod(),
      implementation = ::getBlockNullifiers
    ))
      .addMethod(serverStreamingServerMethodDefinition(
      context = this.context,
      descriptor = CompactTxStreamerGrpc.getGetBlockRangeMethod(),
      implementation = ::getBlockRange
    ))
      .addMethod(serverStreamingServerMethodDefinition(
      context = this.context,
      descriptor = CompactTxStreamerGrpc.getGetBlockRangeNullifiersMethod(),
      implementation = ::getBlockRangeNullifiers
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = CompactTxStreamerGrpc.getGetTransactionMethod(),
      implementation = ::getTransaction
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = CompactTxStreamerGrpc.getSendTransactionMethod(),
      implementation = ::sendTransaction
    ))
      .addMethod(serverStreamingServerMethodDefinition(
      context = this.context,
      descriptor = CompactTxStreamerGrpc.getGetTaddressTxidsMethod(),
      implementation = ::getTaddressTxids
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = CompactTxStreamerGrpc.getGetTaddressBalanceMethod(),
      implementation = ::getTaddressBalance
    ))
      .addMethod(clientStreamingServerMethodDefinition(
      context = this.context,
      descriptor = CompactTxStreamerGrpc.getGetTaddressBalanceStreamMethod(),
      implementation = ::getTaddressBalanceStream
    ))
      .addMethod(serverStreamingServerMethodDefinition(
      context = this.context,
      descriptor = CompactTxStreamerGrpc.getGetMempoolTxMethod(),
      implementation = ::getMempoolTx
    ))
      .addMethod(serverStreamingServerMethodDefinition(
      context = this.context,
      descriptor = CompactTxStreamerGrpc.getGetMempoolStreamMethod(),
      implementation = ::getMempoolStream
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = CompactTxStreamerGrpc.getGetTreeStateMethod(),
      implementation = ::getTreeState
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = CompactTxStreamerGrpc.getGetLatestTreeStateMethod(),
      implementation = ::getLatestTreeState
    ))
      .addMethod(serverStreamingServerMethodDefinition(
      context = this.context,
      descriptor = CompactTxStreamerGrpc.getGetSubtreeRootsMethod(),
      implementation = ::getSubtreeRoots
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = CompactTxStreamerGrpc.getGetAddressUtxosMethod(),
      implementation = ::getAddressUtxos
    ))
      .addMethod(serverStreamingServerMethodDefinition(
      context = this.context,
      descriptor = CompactTxStreamerGrpc.getGetAddressUtxosStreamMethod(),
      implementation = ::getAddressUtxosStream
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = CompactTxStreamerGrpc.getGetLightdInfoMethod(),
      implementation = ::getLightdInfo
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = CompactTxStreamerGrpc.getPingMethod(),
      implementation = ::ping
    )).build()
  }
}
