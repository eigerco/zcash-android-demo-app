// Generated by the protocol buffer compiler. DO NOT EDIT!
// source: compact_formats.proto

// Generated files should ignore deprecation warnings
@file:Suppress("DEPRECATION")
package cash.z.wallet.sdk.internal.rpc;

@kotlin.jvm.JvmName("-initializechainMetadata")
public inline fun chainMetadata(block: cash.z.wallet.sdk.internal.rpc.ChainMetadataKt.Dsl.() -> kotlin.Unit): cash.z.wallet.sdk.internal.rpc.CompactFormats.ChainMetadata =
  cash.z.wallet.sdk.internal.rpc.ChainMetadataKt.Dsl._create(cash.z.wallet.sdk.internal.rpc.CompactFormats.ChainMetadata.newBuilder()).apply { block() }._build()
/**
 * ```
 * ChainMetadata represents information about the state of the chain as of a given block.
 * ```
 *
 * Protobuf type `cash.z.wallet.sdk.rpc.ChainMetadata`
 */
public object ChainMetadataKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: cash.z.wallet.sdk.internal.rpc.CompactFormats.ChainMetadata.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: cash.z.wallet.sdk.internal.rpc.CompactFormats.ChainMetadata.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): cash.z.wallet.sdk.internal.rpc.CompactFormats.ChainMetadata = _builder.build()

    /**
     * <pre>
     * the size of the Sapling note commitment tree as of the end of this block
     * </pre>
     *
     * <code>uint32 saplingCommitmentTreeSize = 1;</code>
     */
    public var saplingCommitmentTreeSize: kotlin.Int
      @JvmName("getSaplingCommitmentTreeSize")
      get() = _builder.getSaplingCommitmentTreeSize()
      @JvmName("setSaplingCommitmentTreeSize")
      set(value) {
        _builder.setSaplingCommitmentTreeSize(value)
      }
    /**
     * ```
     * the size of the Sapling note commitment tree as of the end of this block
     * ```
     *
     * `uint32 saplingCommitmentTreeSize = 1;`
     */
    public fun clearSaplingCommitmentTreeSize() {
      _builder.clearSaplingCommitmentTreeSize()
    }

    /**
     * <pre>
     * the size of the Orchard note commitment tree as of the end of this block
     * </pre>
     *
     * <code>uint32 orchardCommitmentTreeSize = 2;</code>
     */
    public var orchardCommitmentTreeSize: kotlin.Int
      @JvmName("getOrchardCommitmentTreeSize")
      get() = _builder.getOrchardCommitmentTreeSize()
      @JvmName("setOrchardCommitmentTreeSize")
      set(value) {
        _builder.setOrchardCommitmentTreeSize(value)
      }
    /**
     * ```
     * the size of the Orchard note commitment tree as of the end of this block
     * ```
     *
     * `uint32 orchardCommitmentTreeSize = 2;`
     */
    public fun clearOrchardCommitmentTreeSize() {
      _builder.clearOrchardCommitmentTreeSize()
    }
  }
}
public inline fun cash.z.wallet.sdk.internal.rpc.CompactFormats.ChainMetadata.copy(block: `cash.z.wallet.sdk.internal.rpc`.ChainMetadataKt.Dsl.() -> kotlin.Unit): cash.z.wallet.sdk.internal.rpc.CompactFormats.ChainMetadata =
  `cash.z.wallet.sdk.internal.rpc`.ChainMetadataKt.Dsl._create(this.toBuilder()).apply { block() }._build()
