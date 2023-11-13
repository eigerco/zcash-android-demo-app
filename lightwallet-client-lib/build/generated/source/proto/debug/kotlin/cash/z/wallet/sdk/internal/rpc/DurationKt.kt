// Generated by the protocol buffer compiler. DO NOT EDIT!
// source: service.proto

// Generated files should ignore deprecation warnings
@file:Suppress("DEPRECATION")
package cash.z.wallet.sdk.internal.rpc;

@kotlin.jvm.JvmName("-initializeduration")
public inline fun duration(block: cash.z.wallet.sdk.internal.rpc.DurationKt.Dsl.() -> kotlin.Unit): cash.z.wallet.sdk.internal.rpc.Service.Duration =
  cash.z.wallet.sdk.internal.rpc.DurationKt.Dsl._create(cash.z.wallet.sdk.internal.rpc.Service.Duration.newBuilder()).apply { block() }._build()
/**
 * ```
 * Duration is currently used only for testing, so that the Ping rpc
 * can simulate a delay, to create many simultaneous connections. Units
 * are microseconds.
 * ```
 *
 * Protobuf type `cash.z.wallet.sdk.rpc.Duration`
 */
public object DurationKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: cash.z.wallet.sdk.internal.rpc.Service.Duration.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: cash.z.wallet.sdk.internal.rpc.Service.Duration.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): cash.z.wallet.sdk.internal.rpc.Service.Duration = _builder.build()

    /**
     * <code>int64 intervalUs = 1;</code>
     */
    public var intervalUs: kotlin.Long
      @JvmName("getIntervalUs")
      get() = _builder.getIntervalUs()
      @JvmName("setIntervalUs")
      set(value) {
        _builder.setIntervalUs(value)
      }
    /**
     * `int64 intervalUs = 1;`
     */
    public fun clearIntervalUs() {
      _builder.clearIntervalUs()
    }
  }
}
public inline fun cash.z.wallet.sdk.internal.rpc.Service.Duration.copy(block: `cash.z.wallet.sdk.internal.rpc`.DurationKt.Dsl.() -> kotlin.Unit): cash.z.wallet.sdk.internal.rpc.Service.Duration =
  `cash.z.wallet.sdk.internal.rpc`.DurationKt.Dsl._create(this.toBuilder()).apply { block() }._build()
