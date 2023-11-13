// Generated by the protocol buffer compiler. DO NOT EDIT!
// source: service.proto

// Generated files should ignore deprecation warnings
@file:Suppress("DEPRECATION")
package cash.z.wallet.sdk.internal.rpc;

@kotlin.jvm.JvmName("-initializeblockRange")
public inline fun blockRange(block: cash.z.wallet.sdk.internal.rpc.BlockRangeKt.Dsl.() -> kotlin.Unit): cash.z.wallet.sdk.internal.rpc.Service.BlockRange =
  cash.z.wallet.sdk.internal.rpc.BlockRangeKt.Dsl._create(cash.z.wallet.sdk.internal.rpc.Service.BlockRange.newBuilder()).apply { block() }._build()
/**
 * ```
 * BlockRange specifies a series of blocks from start to end inclusive.
 * Both BlockIDs must be heights; specification by hash is not yet supported.
 * ```
 *
 * Protobuf type `cash.z.wallet.sdk.rpc.BlockRange`
 */
public object BlockRangeKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: cash.z.wallet.sdk.internal.rpc.Service.BlockRange.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: cash.z.wallet.sdk.internal.rpc.Service.BlockRange.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): cash.z.wallet.sdk.internal.rpc.Service.BlockRange = _builder.build()

    /**
     * `.cash.z.wallet.sdk.rpc.BlockID start = 1;`
     */
    public var start: cash.z.wallet.sdk.internal.rpc.Service.BlockID
      @JvmName("getStart")
      get() = _builder.getStart()
      @JvmName("setStart")
      set(value) {
        _builder.setStart(value)
      }
    /**
     * `.cash.z.wallet.sdk.rpc.BlockID start = 1;`
     */
    public fun clearStart() {
      _builder.clearStart()
    }
    /**
     * `.cash.z.wallet.sdk.rpc.BlockID start = 1;`
     * @return Whether the start field is set.
     */
    public fun hasStart(): kotlin.Boolean {
      return _builder.hasStart()
    }

    /**
     * `.cash.z.wallet.sdk.rpc.BlockID end = 2;`
     */
    public var end: cash.z.wallet.sdk.internal.rpc.Service.BlockID
      @JvmName("getEnd")
      get() = _builder.getEnd()
      @JvmName("setEnd")
      set(value) {
        _builder.setEnd(value)
      }
    /**
     * `.cash.z.wallet.sdk.rpc.BlockID end = 2;`
     */
    public fun clearEnd() {
      _builder.clearEnd()
    }
    /**
     * `.cash.z.wallet.sdk.rpc.BlockID end = 2;`
     * @return Whether the end field is set.
     */
    public fun hasEnd(): kotlin.Boolean {
      return _builder.hasEnd()
    }
  }
}
public inline fun cash.z.wallet.sdk.internal.rpc.Service.BlockRange.copy(block: `cash.z.wallet.sdk.internal.rpc`.BlockRangeKt.Dsl.() -> kotlin.Unit): cash.z.wallet.sdk.internal.rpc.Service.BlockRange =
  `cash.z.wallet.sdk.internal.rpc`.BlockRangeKt.Dsl._create(this.toBuilder()).apply { block() }._build()

public val cash.z.wallet.sdk.internal.rpc.Service.BlockRangeOrBuilder.startOrNull: cash.z.wallet.sdk.internal.rpc.Service.BlockID?
  get() = if (hasStart()) getStart() else null

public val cash.z.wallet.sdk.internal.rpc.Service.BlockRangeOrBuilder.endOrNull: cash.z.wallet.sdk.internal.rpc.Service.BlockID?
  get() = if (hasEnd()) getEnd() else null

