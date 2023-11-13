// Generated by the protocol buffer compiler. DO NOT EDIT!
// source: service.proto

// Generated files should ignore deprecation warnings
@file:Suppress("DEPRECATION")
package cash.z.wallet.sdk.internal.rpc;

@kotlin.jvm.JvmName("-initializegetAddressUtxosArg")
public inline fun getAddressUtxosArg(block: cash.z.wallet.sdk.internal.rpc.GetAddressUtxosArgKt.Dsl.() -> kotlin.Unit): cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosArg =
  cash.z.wallet.sdk.internal.rpc.GetAddressUtxosArgKt.Dsl._create(cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosArg.newBuilder()).apply { block() }._build()
/**
 * ```
 * Results are sorted by height, which makes it easy to issue another
 * request that picks up from where the previous left off.
 * ```
 *
 * Protobuf type `cash.z.wallet.sdk.rpc.GetAddressUtxosArg`
 */
public object GetAddressUtxosArgKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosArg.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosArg.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosArg = _builder.build()

    /**
     * An uninstantiable, behaviorless type to represent the field in
     * generics.
     */
    @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
    public class AddressesProxy private constructor() : com.google.protobuf.kotlin.DslProxy()
    /**
     * `repeated string addresses = 1;`
     * @return A list containing the addresses.
     */
    public val addresses: com.google.protobuf.kotlin.DslList<kotlin.String, AddressesProxy>
    @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
      get() = com.google.protobuf.kotlin.DslList(
        _builder.getAddressesList()
      )
    /**
     * `repeated string addresses = 1;`
     * @param value The addresses to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addAddresses")
    public fun com.google.protobuf.kotlin.DslList<kotlin.String, AddressesProxy>.add(value: kotlin.String) {
      _builder.addAddresses(value)
    }
    /**
     * `repeated string addresses = 1;`
     * @param value The addresses to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignAddresses")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<kotlin.String, AddressesProxy>.plusAssign(value: kotlin.String) {
      add(value)
    }
    /**
     * `repeated string addresses = 1;`
     * @param values The addresses to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addAllAddresses")
    public fun com.google.protobuf.kotlin.DslList<kotlin.String, AddressesProxy>.addAll(values: kotlin.collections.Iterable<kotlin.String>) {
      _builder.addAllAddresses(values)
    }
    /**
     * `repeated string addresses = 1;`
     * @param values The addresses to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignAllAddresses")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<kotlin.String, AddressesProxy>.plusAssign(values: kotlin.collections.Iterable<kotlin.String>) {
      addAll(values)
    }
    /**
     * `repeated string addresses = 1;`
     * @param index The index to set the value at.
     * @param value The addresses to set.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("setAddresses")
    public operator fun com.google.protobuf.kotlin.DslList<kotlin.String, AddressesProxy>.set(index: kotlin.Int, value: kotlin.String) {
      _builder.setAddresses(index, value)
    }/**
     * `repeated string addresses = 1;`
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("clearAddresses")
    public fun com.google.protobuf.kotlin.DslList<kotlin.String, AddressesProxy>.clear() {
      _builder.clearAddresses()
    }
    /**
     * <code>uint64 startHeight = 2;</code>
     */
    public var startHeight: kotlin.Long
      @JvmName("getStartHeight")
      get() = _builder.getStartHeight()
      @JvmName("setStartHeight")
      set(value) {
        _builder.setStartHeight(value)
      }
    /**
     * `uint64 startHeight = 2;`
     */
    public fun clearStartHeight() {
      _builder.clearStartHeight()
    }

    /**
     * <pre>
     * zero means unlimited
     * </pre>
     *
     * <code>uint32 maxEntries = 3;</code>
     */
    public var maxEntries: kotlin.Int
      @JvmName("getMaxEntries")
      get() = _builder.getMaxEntries()
      @JvmName("setMaxEntries")
      set(value) {
        _builder.setMaxEntries(value)
      }
    /**
     * ```
     * zero means unlimited
     * ```
     *
     * `uint32 maxEntries = 3;`
     */
    public fun clearMaxEntries() {
      _builder.clearMaxEntries()
    }
  }
}
public inline fun cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosArg.copy(block: `cash.z.wallet.sdk.internal.rpc`.GetAddressUtxosArgKt.Dsl.() -> kotlin.Unit): cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosArg =
  `cash.z.wallet.sdk.internal.rpc`.GetAddressUtxosArgKt.Dsl._create(this.toBuilder()).apply { block() }._build()

