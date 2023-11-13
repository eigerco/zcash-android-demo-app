// Generated by the protocol buffer compiler. DO NOT EDIT!
// source: darkside.proto

// Generated files should ignore deprecation warnings
@file:Suppress("DEPRECATION")
package cash.z.wallet.sdk.internal.rpc;

@kotlin.jvm.JvmName("-initializedarksideEmptyBlocks")
public inline fun darksideEmptyBlocks(block: cash.z.wallet.sdk.internal.rpc.DarksideEmptyBlocksKt.Dsl.() -> kotlin.Unit): cash.z.wallet.sdk.internal.rpc.Darkside.DarksideEmptyBlocks =
  cash.z.wallet.sdk.internal.rpc.DarksideEmptyBlocksKt.Dsl._create(cash.z.wallet.sdk.internal.rpc.Darkside.DarksideEmptyBlocks.newBuilder()).apply { block() }._build()
/**
 * Protobuf type `cash.z.wallet.sdk.rpc.DarksideEmptyBlocks`
 */
public object DarksideEmptyBlocksKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: cash.z.wallet.sdk.internal.rpc.Darkside.DarksideEmptyBlocks.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: cash.z.wallet.sdk.internal.rpc.Darkside.DarksideEmptyBlocks.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): cash.z.wallet.sdk.internal.rpc.Darkside.DarksideEmptyBlocks = _builder.build()

    /**
     * <code>int32 height = 1;</code>
     */
    public var height: kotlin.Int
      @JvmName("getHeight")
      get() = _builder.getHeight()
      @JvmName("setHeight")
      set(value) {
        _builder.setHeight(value)
      }
    /**
     * `int32 height = 1;`
     */
    public fun clearHeight() {
      _builder.clearHeight()
    }

    /**
     * <code>int32 nonce = 2;</code>
     */
    public var nonce: kotlin.Int
      @JvmName("getNonce")
      get() = _builder.getNonce()
      @JvmName("setNonce")
      set(value) {
        _builder.setNonce(value)
      }
    /**
     * `int32 nonce = 2;`
     */
    public fun clearNonce() {
      _builder.clearNonce()
    }

    /**
     * <code>int32 count = 3;</code>
     */
    public var count: kotlin.Int
      @JvmName("getCount")
      get() = _builder.getCount()
      @JvmName("setCount")
      set(value) {
        _builder.setCount(value)
      }
    /**
     * `int32 count = 3;`
     */
    public fun clearCount() {
      _builder.clearCount()
    }
  }
}
public inline fun cash.z.wallet.sdk.internal.rpc.Darkside.DarksideEmptyBlocks.copy(block: `cash.z.wallet.sdk.internal.rpc`.DarksideEmptyBlocksKt.Dsl.() -> kotlin.Unit): cash.z.wallet.sdk.internal.rpc.Darkside.DarksideEmptyBlocks =
  `cash.z.wallet.sdk.internal.rpc`.DarksideEmptyBlocksKt.Dsl._create(this.toBuilder()).apply { block() }._build()

