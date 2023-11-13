package cash.z.wallet.sdk.`internal`.rpc

import cash.z.wallet.sdk.`internal`.rpc.DarksideStreamerGrpc.getServiceDescriptor
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
 * cash.z.wallet.sdk.rpc.DarksideStreamer.
 */
public object DarksideStreamerGrpcKt {
  public const val SERVICE_NAME: String = DarksideStreamerGrpc.SERVICE_NAME

  @JvmStatic
  public val serviceDescriptor: ServiceDescriptor
    get() = getServiceDescriptor()

  public val resetMethod: MethodDescriptor<Darkside.DarksideMetaState, Service.Empty>
    @JvmStatic
    get() = DarksideStreamerGrpc.getResetMethod()

  public val stageBlocksStreamMethod: MethodDescriptor<Darkside.DarksideBlock, Service.Empty>
    @JvmStatic
    get() = DarksideStreamerGrpc.getStageBlocksStreamMethod()

  public val stageBlocksMethod: MethodDescriptor<Darkside.DarksideBlocksURL, Service.Empty>
    @JvmStatic
    get() = DarksideStreamerGrpc.getStageBlocksMethod()

  public val stageBlocksCreateMethod: MethodDescriptor<Darkside.DarksideEmptyBlocks, Service.Empty>
    @JvmStatic
    get() = DarksideStreamerGrpc.getStageBlocksCreateMethod()

  public val stageTransactionsStreamMethod: MethodDescriptor<Service.RawTransaction, Service.Empty>
    @JvmStatic
    get() = DarksideStreamerGrpc.getStageTransactionsStreamMethod()

  public val stageTransactionsMethod:
      MethodDescriptor<Darkside.DarksideTransactionsURL, Service.Empty>
    @JvmStatic
    get() = DarksideStreamerGrpc.getStageTransactionsMethod()

  public val applyStagedMethod: MethodDescriptor<Darkside.DarksideHeight, Service.Empty>
    @JvmStatic
    get() = DarksideStreamerGrpc.getApplyStagedMethod()

  public val getIncomingTransactionsMethod: MethodDescriptor<Service.Empty, Service.RawTransaction>
    @JvmStatic
    get() = DarksideStreamerGrpc.getGetIncomingTransactionsMethod()

  public val clearIncomingTransactionsMethod: MethodDescriptor<Service.Empty, Service.Empty>
    @JvmStatic
    get() = DarksideStreamerGrpc.getClearIncomingTransactionsMethod()

  public val addAddressUtxoMethod: MethodDescriptor<Service.GetAddressUtxosReply, Service.Empty>
    @JvmStatic
    get() = DarksideStreamerGrpc.getAddAddressUtxoMethod()

  public val clearAddressUtxoMethod: MethodDescriptor<Service.Empty, Service.Empty>
    @JvmStatic
    get() = DarksideStreamerGrpc.getClearAddressUtxoMethod()

  public val addTreeStateMethod: MethodDescriptor<Service.TreeState, Service.Empty>
    @JvmStatic
    get() = DarksideStreamerGrpc.getAddTreeStateMethod()

  public val removeTreeStateMethod: MethodDescriptor<Service.BlockID, Service.Empty>
    @JvmStatic
    get() = DarksideStreamerGrpc.getRemoveTreeStateMethod()

  public val clearAllTreeStatesMethod: MethodDescriptor<Service.Empty, Service.Empty>
    @JvmStatic
    get() = DarksideStreamerGrpc.getClearAllTreeStatesMethod()

  /**
   * A stub for issuing RPCs to a(n) cash.z.wallet.sdk.rpc.DarksideStreamer service as suspending
   * coroutines.
   */
  @StubFor(DarksideStreamerGrpc::class)
  public class DarksideStreamerCoroutineStub @JvmOverloads constructor(
    channel: Channel,
    callOptions: CallOptions = DEFAULT,
  ) : AbstractCoroutineStub<DarksideStreamerCoroutineStub>(channel, callOptions) {
    override fun build(channel: Channel, callOptions: CallOptions): DarksideStreamerCoroutineStub =
        DarksideStreamerCoroutineStub(channel, callOptions)

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
    public suspend fun reset(request: Darkside.DarksideMetaState, headers: Metadata = Metadata()):
        Service.Empty = unaryRpc(
      channel,
      DarksideStreamerGrpc.getResetMethod(),
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
    public suspend fun stageBlocksStream(requests: Flow<Darkside.DarksideBlock>, headers: Metadata =
        Metadata()): Service.Empty = clientStreamingRpc(
      channel,
      DarksideStreamerGrpc.getStageBlocksStreamMethod(),
      requests,
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
    public suspend fun stageBlocks(request: Darkside.DarksideBlocksURL, headers: Metadata =
        Metadata()): Service.Empty = unaryRpc(
      channel,
      DarksideStreamerGrpc.getStageBlocksMethod(),
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
    public suspend fun stageBlocksCreate(request: Darkside.DarksideEmptyBlocks, headers: Metadata =
        Metadata()): Service.Empty = unaryRpc(
      channel,
      DarksideStreamerGrpc.getStageBlocksCreateMethod(),
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
    public suspend fun stageTransactionsStream(requests: Flow<Service.RawTransaction>,
        headers: Metadata = Metadata()): Service.Empty = clientStreamingRpc(
      channel,
      DarksideStreamerGrpc.getStageTransactionsStreamMethod(),
      requests,
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
    public suspend fun stageTransactions(request: Darkside.DarksideTransactionsURL,
        headers: Metadata = Metadata()): Service.Empty = unaryRpc(
      channel,
      DarksideStreamerGrpc.getStageTransactionsMethod(),
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
    public suspend fun applyStaged(request: Darkside.DarksideHeight, headers: Metadata =
        Metadata()): Service.Empty = unaryRpc(
      channel,
      DarksideStreamerGrpc.getApplyStagedMethod(),
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
    public fun getIncomingTransactions(request: Service.Empty, headers: Metadata = Metadata()):
        Flow<Service.RawTransaction> = serverStreamingRpc(
      channel,
      DarksideStreamerGrpc.getGetIncomingTransactionsMethod(),
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
    public suspend fun clearIncomingTransactions(request: Service.Empty, headers: Metadata =
        Metadata()): Service.Empty = unaryRpc(
      channel,
      DarksideStreamerGrpc.getClearIncomingTransactionsMethod(),
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
    public suspend fun addAddressUtxo(request: Service.GetAddressUtxosReply, headers: Metadata =
        Metadata()): Service.Empty = unaryRpc(
      channel,
      DarksideStreamerGrpc.getAddAddressUtxoMethod(),
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
    public suspend fun clearAddressUtxo(request: Service.Empty, headers: Metadata = Metadata()):
        Service.Empty = unaryRpc(
      channel,
      DarksideStreamerGrpc.getClearAddressUtxoMethod(),
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
    public suspend fun addTreeState(request: Service.TreeState, headers: Metadata = Metadata()):
        Service.Empty = unaryRpc(
      channel,
      DarksideStreamerGrpc.getAddTreeStateMethod(),
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
    public suspend fun removeTreeState(request: Service.BlockID, headers: Metadata = Metadata()):
        Service.Empty = unaryRpc(
      channel,
      DarksideStreamerGrpc.getRemoveTreeStateMethod(),
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
    public suspend fun clearAllTreeStates(request: Service.Empty, headers: Metadata = Metadata()):
        Service.Empty = unaryRpc(
      channel,
      DarksideStreamerGrpc.getClearAllTreeStatesMethod(),
      request,
      callOptions,
      headers
    )
  }

  /**
   * Skeletal implementation of the cash.z.wallet.sdk.rpc.DarksideStreamer service based on Kotlin
   * coroutines.
   */
  public abstract class DarksideStreamerCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    /**
     * Returns the response to an RPC for cash.z.wallet.sdk.rpc.DarksideStreamer.Reset.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun reset(request: Darkside.DarksideMetaState): Service.Empty = throw
        StatusException(UNIMPLEMENTED.withDescription("Method cash.z.wallet.sdk.rpc.DarksideStreamer.Reset is unimplemented"))

    /**
     * Returns the response to an RPC for cash.z.wallet.sdk.rpc.DarksideStreamer.StageBlocksStream.
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
    public open suspend fun stageBlocksStream(requests: Flow<Darkside.DarksideBlock>): Service.Empty
        = throw
        StatusException(UNIMPLEMENTED.withDescription("Method cash.z.wallet.sdk.rpc.DarksideStreamer.StageBlocksStream is unimplemented"))

    /**
     * Returns the response to an RPC for cash.z.wallet.sdk.rpc.DarksideStreamer.StageBlocks.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun stageBlocks(request: Darkside.DarksideBlocksURL): Service.Empty = throw
        StatusException(UNIMPLEMENTED.withDescription("Method cash.z.wallet.sdk.rpc.DarksideStreamer.StageBlocks is unimplemented"))

    /**
     * Returns the response to an RPC for cash.z.wallet.sdk.rpc.DarksideStreamer.StageBlocksCreate.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun stageBlocksCreate(request: Darkside.DarksideEmptyBlocks): Service.Empty
        = throw
        StatusException(UNIMPLEMENTED.withDescription("Method cash.z.wallet.sdk.rpc.DarksideStreamer.StageBlocksCreate is unimplemented"))

    /**
     * Returns the response to an RPC for
     * cash.z.wallet.sdk.rpc.DarksideStreamer.StageTransactionsStream.
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
    public open suspend fun stageTransactionsStream(requests: Flow<Service.RawTransaction>):
        Service.Empty = throw
        StatusException(UNIMPLEMENTED.withDescription("Method cash.z.wallet.sdk.rpc.DarksideStreamer.StageTransactionsStream is unimplemented"))

    /**
     * Returns the response to an RPC for cash.z.wallet.sdk.rpc.DarksideStreamer.StageTransactions.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun stageTransactions(request: Darkside.DarksideTransactionsURL):
        Service.Empty = throw
        StatusException(UNIMPLEMENTED.withDescription("Method cash.z.wallet.sdk.rpc.DarksideStreamer.StageTransactions is unimplemented"))

    /**
     * Returns the response to an RPC for cash.z.wallet.sdk.rpc.DarksideStreamer.ApplyStaged.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun applyStaged(request: Darkside.DarksideHeight): Service.Empty = throw
        StatusException(UNIMPLEMENTED.withDescription("Method cash.z.wallet.sdk.rpc.DarksideStreamer.ApplyStaged is unimplemented"))

    /**
     * Returns a [Flow] of responses to an RPC for
     * cash.z.wallet.sdk.rpc.DarksideStreamer.GetIncomingTransactions.
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
    public open fun getIncomingTransactions(request: Service.Empty): Flow<Service.RawTransaction> =
        throw
        StatusException(UNIMPLEMENTED.withDescription("Method cash.z.wallet.sdk.rpc.DarksideStreamer.GetIncomingTransactions is unimplemented"))

    /**
     * Returns the response to an RPC for
     * cash.z.wallet.sdk.rpc.DarksideStreamer.ClearIncomingTransactions.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun clearIncomingTransactions(request: Service.Empty): Service.Empty = throw
        StatusException(UNIMPLEMENTED.withDescription("Method cash.z.wallet.sdk.rpc.DarksideStreamer.ClearIncomingTransactions is unimplemented"))

    /**
     * Returns the response to an RPC for cash.z.wallet.sdk.rpc.DarksideStreamer.AddAddressUtxo.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun addAddressUtxo(request: Service.GetAddressUtxosReply): Service.Empty =
        throw
        StatusException(UNIMPLEMENTED.withDescription("Method cash.z.wallet.sdk.rpc.DarksideStreamer.AddAddressUtxo is unimplemented"))

    /**
     * Returns the response to an RPC for cash.z.wallet.sdk.rpc.DarksideStreamer.ClearAddressUtxo.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun clearAddressUtxo(request: Service.Empty): Service.Empty = throw
        StatusException(UNIMPLEMENTED.withDescription("Method cash.z.wallet.sdk.rpc.DarksideStreamer.ClearAddressUtxo is unimplemented"))

    /**
     * Returns the response to an RPC for cash.z.wallet.sdk.rpc.DarksideStreamer.AddTreeState.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun addTreeState(request: Service.TreeState): Service.Empty = throw
        StatusException(UNIMPLEMENTED.withDescription("Method cash.z.wallet.sdk.rpc.DarksideStreamer.AddTreeState is unimplemented"))

    /**
     * Returns the response to an RPC for cash.z.wallet.sdk.rpc.DarksideStreamer.RemoveTreeState.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun removeTreeState(request: Service.BlockID): Service.Empty = throw
        StatusException(UNIMPLEMENTED.withDescription("Method cash.z.wallet.sdk.rpc.DarksideStreamer.RemoveTreeState is unimplemented"))

    /**
     * Returns the response to an RPC for cash.z.wallet.sdk.rpc.DarksideStreamer.ClearAllTreeStates.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun clearAllTreeStates(request: Service.Empty): Service.Empty = throw
        StatusException(UNIMPLEMENTED.withDescription("Method cash.z.wallet.sdk.rpc.DarksideStreamer.ClearAllTreeStates is unimplemented"))

    final override fun bindService(): ServerServiceDefinition = builder(getServiceDescriptor())
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = DarksideStreamerGrpc.getResetMethod(),
      implementation = ::reset
    ))
      .addMethod(clientStreamingServerMethodDefinition(
      context = this.context,
      descriptor = DarksideStreamerGrpc.getStageBlocksStreamMethod(),
      implementation = ::stageBlocksStream
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = DarksideStreamerGrpc.getStageBlocksMethod(),
      implementation = ::stageBlocks
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = DarksideStreamerGrpc.getStageBlocksCreateMethod(),
      implementation = ::stageBlocksCreate
    ))
      .addMethod(clientStreamingServerMethodDefinition(
      context = this.context,
      descriptor = DarksideStreamerGrpc.getStageTransactionsStreamMethod(),
      implementation = ::stageTransactionsStream
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = DarksideStreamerGrpc.getStageTransactionsMethod(),
      implementation = ::stageTransactions
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = DarksideStreamerGrpc.getApplyStagedMethod(),
      implementation = ::applyStaged
    ))
      .addMethod(serverStreamingServerMethodDefinition(
      context = this.context,
      descriptor = DarksideStreamerGrpc.getGetIncomingTransactionsMethod(),
      implementation = ::getIncomingTransactions
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = DarksideStreamerGrpc.getClearIncomingTransactionsMethod(),
      implementation = ::clearIncomingTransactions
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = DarksideStreamerGrpc.getAddAddressUtxoMethod(),
      implementation = ::addAddressUtxo
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = DarksideStreamerGrpc.getClearAddressUtxoMethod(),
      implementation = ::clearAddressUtxo
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = DarksideStreamerGrpc.getAddTreeStateMethod(),
      implementation = ::addTreeState
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = DarksideStreamerGrpc.getRemoveTreeStateMethod(),
      implementation = ::removeTreeState
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = DarksideStreamerGrpc.getClearAllTreeStatesMethod(),
      implementation = ::clearAllTreeStates
    )).build()
  }
}
