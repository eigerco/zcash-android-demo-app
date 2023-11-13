// Generated by the protocol buffer compiler. DO NOT EDIT!
// source: darkside.proto

// Generated files should ignore deprecation warnings
@file:Suppress("DEPRECATION")
package cash.z.wallet.sdk.internal.rpc;

@kotlin.jvm.JvmName("-initializedarksideBlocksURL")
public inline fun darksideBlocksURL(block: cash.z.wallet.sdk.internal.rpc.DarksideBlocksURLKt.Dsl.() -> kotlin.Unit): cash.z.wallet.sdk.internal.rpc.Darkside.DarksideBlocksURL =
  cash.z.wallet.sdk.internal.rpc.DarksideBlocksURLKt.Dsl._create(cash.z.wallet.sdk.internal.rpc.Darkside.DarksideBlocksURL.newBuilder()).apply { block() }._build()
/**
 * ```
 * DarksideBlocksURL is typically something like:
 * https://raw.githubusercontent.com/zcash-hackworks/darksidewalletd-test-data/master/basic-reorg/before-reorg.txt
 * ```
 *
 * Protobuf type `cash.z.wallet.sdk.rpc.DarksideBlocksURL`
 */
public object DarksideBlocksURLKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: cash.z.wallet.sdk.internal.rpc.Darkside.DarksideBlocksURL.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: cash.z.wallet.sdk.internal.rpc.Darkside.DarksideBlocksURL.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): cash.z.wallet.sdk.internal.rpc.Darkside.DarksideBlocksURL = _builder.build()

    /**
     * `string url = 1;`
     */
    public var url: kotlin.String
      @JvmName("getUrl")
      get() = _builder.getUrl()
      @JvmName("setUrl")
      set(value) {
        _builder.setUrl(value)
      }
    /**
     * `string url = 1;`
     */
    public fun clearUrl() {
      _builder.clearUrl()
    }
  }
}
public inline fun cash.z.wallet.sdk.internal.rpc.Darkside.DarksideBlocksURL.copy(block: `cash.z.wallet.sdk.internal.rpc`.DarksideBlocksURLKt.Dsl.() -> kotlin.Unit): cash.z.wallet.sdk.internal.rpc.Darkside.DarksideBlocksURL =
  `cash.z.wallet.sdk.internal.rpc`.DarksideBlocksURLKt.Dsl._create(this.toBuilder()).apply { block() }._build()

