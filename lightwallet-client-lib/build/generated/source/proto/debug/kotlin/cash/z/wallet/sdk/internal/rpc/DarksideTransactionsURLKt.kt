// Generated by the protocol buffer compiler. DO NOT EDIT!
// source: darkside.proto

// Generated files should ignore deprecation warnings
@file:Suppress("DEPRECATION")
package cash.z.wallet.sdk.internal.rpc;

@kotlin.jvm.JvmName("-initializedarksideTransactionsURL")
public inline fun darksideTransactionsURL(block: cash.z.wallet.sdk.internal.rpc.DarksideTransactionsURLKt.Dsl.() -> kotlin.Unit): cash.z.wallet.sdk.internal.rpc.Darkside.DarksideTransactionsURL =
  cash.z.wallet.sdk.internal.rpc.DarksideTransactionsURLKt.Dsl._create(cash.z.wallet.sdk.internal.rpc.Darkside.DarksideTransactionsURL.newBuilder()).apply { block() }._build()
/**
 * ```
 * DarksideTransactionsURL refers to an HTTP source that contains a list
 * of hex-encoded transactions, one per line, that are to be associated
 * with the given height (fake-mined into the block at that height)
 * ```
 *
 * Protobuf type `cash.z.wallet.sdk.rpc.DarksideTransactionsURL`
 */
public object DarksideTransactionsURLKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: cash.z.wallet.sdk.internal.rpc.Darkside.DarksideTransactionsURL.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: cash.z.wallet.sdk.internal.rpc.Darkside.DarksideTransactionsURL.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): cash.z.wallet.sdk.internal.rpc.Darkside.DarksideTransactionsURL = _builder.build()

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
     * `string url = 2;`
     */
    public var url: kotlin.String
      @JvmName("getUrl")
      get() = _builder.getUrl()
      @JvmName("setUrl")
      set(value) {
        _builder.setUrl(value)
      }
    /**
     * `string url = 2;`
     */
    public fun clearUrl() {
      _builder.clearUrl()
    }
  }
}
public inline fun cash.z.wallet.sdk.internal.rpc.Darkside.DarksideTransactionsURL.copy(block: `cash.z.wallet.sdk.internal.rpc`.DarksideTransactionsURLKt.Dsl.() -> kotlin.Unit): cash.z.wallet.sdk.internal.rpc.Darkside.DarksideTransactionsURL =
  `cash.z.wallet.sdk.internal.rpc`.DarksideTransactionsURLKt.Dsl._create(this.toBuilder()).apply { block() }._build()
