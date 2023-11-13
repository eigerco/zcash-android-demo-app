// Generated by the protocol buffer compiler. DO NOT EDIT!
// source: service.proto

// Generated files should ignore deprecation warnings
@file:Suppress("DEPRECATION")
package cash.z.wallet.sdk.internal.rpc;

@kotlin.jvm.JvmName("-initializegetAddressUtxosReply")
public inline fun getAddressUtxosReply(block: cash.z.wallet.sdk.internal.rpc.GetAddressUtxosReplyKt.Dsl.() -> kotlin.Unit): cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosReply =
  cash.z.wallet.sdk.internal.rpc.GetAddressUtxosReplyKt.Dsl._create(cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosReply.newBuilder()).apply { block() }._build()
/**
 * Protobuf type `cash.z.wallet.sdk.rpc.GetAddressUtxosReply`
 */
public object GetAddressUtxosReplyKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosReply.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosReply.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosReply = _builder.build()

    /**
     * `string address = 6;`
     */
    public var address: kotlin.String
      @JvmName("getAddress")
      get() = _builder.getAddress()
      @JvmName("setAddress")
      set(value) {
        _builder.setAddress(value)
      }
    /**
     * `string address = 6;`
     */
    public fun clearAddress() {
      _builder.clearAddress()
    }

    /**
     * <code>bytes txid = 1;</code>
     */
    public var txid: com.google.protobuf.ByteString
      @JvmName("getTxid")
      get() = _builder.getTxid()
      @JvmName("setTxid")
      set(value) {
        _builder.setTxid(value)
      }
    /**
     * `bytes txid = 1;`
     */
    public fun clearTxid() {
      _builder.clearTxid()
    }

    /**
     * <code>int32 index = 2;</code>
     */
    public var index: kotlin.Int
      @JvmName("getIndex")
      get() = _builder.getIndex()
      @JvmName("setIndex")
      set(value) {
        _builder.setIndex(value)
      }
    /**
     * `int32 index = 2;`
     */
    public fun clearIndex() {
      _builder.clearIndex()
    }

    /**
     * <code>bytes script = 3;</code>
     */
    public var script: com.google.protobuf.ByteString
      @JvmName("getScript")
      get() = _builder.getScript()
      @JvmName("setScript")
      set(value) {
        _builder.setScript(value)
      }
    /**
     * `bytes script = 3;`
     */
    public fun clearScript() {
      _builder.clearScript()
    }

    /**
     * <code>int64 valueZat = 4;</code>
     */
    public var valueZat: kotlin.Long
      @JvmName("getValueZat")
      get() = _builder.getValueZat()
      @JvmName("setValueZat")
      set(value) {
        _builder.setValueZat(value)
      }
    /**
     * `int64 valueZat = 4;`
     */
    public fun clearValueZat() {
      _builder.clearValueZat()
    }

    /**
     * <code>uint64 height = 5;</code>
     */
    public var height: kotlin.Long
      @JvmName("getHeight")
      get() = _builder.getHeight()
      @JvmName("setHeight")
      set(value) {
        _builder.setHeight(value)
      }
    /**
     * `uint64 height = 5;`
     */
    public fun clearHeight() {
      _builder.clearHeight()
    }
  }
}
public inline fun cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosReply.copy(block: `cash.z.wallet.sdk.internal.rpc`.GetAddressUtxosReplyKt.Dsl.() -> kotlin.Unit): cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosReply =
  `cash.z.wallet.sdk.internal.rpc`.GetAddressUtxosReplyKt.Dsl._create(this.toBuilder()).apply { block() }._build()

