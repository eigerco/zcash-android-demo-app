// Generated by the protocol buffer compiler. DO NOT EDIT!
// source: service.proto

// Generated files should ignore deprecation warnings
@file:Suppress("DEPRECATION")
package cash.z.wallet.sdk.internal.rpc;

@kotlin.jvm.JvmName("-initializeempty")
public inline fun empty(block: cash.z.wallet.sdk.internal.rpc.EmptyKt.Dsl.() -> kotlin.Unit): cash.z.wallet.sdk.internal.rpc.Service.Empty =
  cash.z.wallet.sdk.internal.rpc.EmptyKt.Dsl._create(cash.z.wallet.sdk.internal.rpc.Service.Empty.newBuilder()).apply { block() }._build()
/**
 * ```
 * Empty is for gRPCs that take no arguments, currently only GetLightdInfo.
 * ```
 *
 * Protobuf type `cash.z.wallet.sdk.rpc.Empty`
 */
public object EmptyKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: cash.z.wallet.sdk.internal.rpc.Service.Empty.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: cash.z.wallet.sdk.internal.rpc.Service.Empty.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): cash.z.wallet.sdk.internal.rpc.Service.Empty = _builder.build()
  }
}
public inline fun cash.z.wallet.sdk.internal.rpc.Service.Empty.copy(block: `cash.z.wallet.sdk.internal.rpc`.EmptyKt.Dsl.() -> kotlin.Unit): cash.z.wallet.sdk.internal.rpc.Service.Empty =
  `cash.z.wallet.sdk.internal.rpc`.EmptyKt.Dsl._create(this.toBuilder()).apply { block() }._build()

