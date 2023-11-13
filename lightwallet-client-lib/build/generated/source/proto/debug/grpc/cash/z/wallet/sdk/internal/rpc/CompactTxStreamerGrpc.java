package cash.z.wallet.sdk.internal.rpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.59.0)",
    comments = "Source: service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CompactTxStreamerGrpc {

  private CompactTxStreamerGrpc() {}

  public static final java.lang.String SERVICE_NAME = "cash.z.wallet.sdk.rpc.CompactTxStreamer";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.ChainSpec,
      cash.z.wallet.sdk.internal.rpc.Service.BlockID> getGetLatestBlockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLatestBlock",
      requestType = cash.z.wallet.sdk.internal.rpc.Service.ChainSpec.class,
      responseType = cash.z.wallet.sdk.internal.rpc.Service.BlockID.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.ChainSpec,
      cash.z.wallet.sdk.internal.rpc.Service.BlockID> getGetLatestBlockMethod() {
    io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.ChainSpec, cash.z.wallet.sdk.internal.rpc.Service.BlockID> getGetLatestBlockMethod;
    if ((getGetLatestBlockMethod = CompactTxStreamerGrpc.getGetLatestBlockMethod) == null) {
      synchronized (CompactTxStreamerGrpc.class) {
        if ((getGetLatestBlockMethod = CompactTxStreamerGrpc.getGetLatestBlockMethod) == null) {
          CompactTxStreamerGrpc.getGetLatestBlockMethod = getGetLatestBlockMethod =
              io.grpc.MethodDescriptor.<cash.z.wallet.sdk.internal.rpc.Service.ChainSpec, cash.z.wallet.sdk.internal.rpc.Service.BlockID>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetLatestBlock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  cash.z.wallet.sdk.internal.rpc.Service.ChainSpec.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  cash.z.wallet.sdk.internal.rpc.Service.BlockID.getDefaultInstance()))
              .build();
        }
      }
    }
    return getGetLatestBlockMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.BlockID,
      cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock> getGetBlockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBlock",
      requestType = cash.z.wallet.sdk.internal.rpc.Service.BlockID.class,
      responseType = cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.BlockID,
      cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock> getGetBlockMethod() {
    io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.BlockID, cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock> getGetBlockMethod;
    if ((getGetBlockMethod = CompactTxStreamerGrpc.getGetBlockMethod) == null) {
      synchronized (CompactTxStreamerGrpc.class) {
        if ((getGetBlockMethod = CompactTxStreamerGrpc.getGetBlockMethod) == null) {
          CompactTxStreamerGrpc.getGetBlockMethod = getGetBlockMethod =
              io.grpc.MethodDescriptor.<cash.z.wallet.sdk.internal.rpc.Service.BlockID, cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBlock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  cash.z.wallet.sdk.internal.rpc.Service.BlockID.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock.getDefaultInstance()))
              .build();
        }
      }
    }
    return getGetBlockMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.BlockID,
      cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock> getGetBlockNullifiersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBlockNullifiers",
      requestType = cash.z.wallet.sdk.internal.rpc.Service.BlockID.class,
      responseType = cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.BlockID,
      cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock> getGetBlockNullifiersMethod() {
    io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.BlockID, cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock> getGetBlockNullifiersMethod;
    if ((getGetBlockNullifiersMethod = CompactTxStreamerGrpc.getGetBlockNullifiersMethod) == null) {
      synchronized (CompactTxStreamerGrpc.class) {
        if ((getGetBlockNullifiersMethod = CompactTxStreamerGrpc.getGetBlockNullifiersMethod) == null) {
          CompactTxStreamerGrpc.getGetBlockNullifiersMethod = getGetBlockNullifiersMethod =
              io.grpc.MethodDescriptor.<cash.z.wallet.sdk.internal.rpc.Service.BlockID, cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBlockNullifiers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  cash.z.wallet.sdk.internal.rpc.Service.BlockID.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock.getDefaultInstance()))
              .build();
        }
      }
    }
    return getGetBlockNullifiersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.BlockRange,
      cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock> getGetBlockRangeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBlockRange",
      requestType = cash.z.wallet.sdk.internal.rpc.Service.BlockRange.class,
      responseType = cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.BlockRange,
      cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock> getGetBlockRangeMethod() {
    io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.BlockRange, cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock> getGetBlockRangeMethod;
    if ((getGetBlockRangeMethod = CompactTxStreamerGrpc.getGetBlockRangeMethod) == null) {
      synchronized (CompactTxStreamerGrpc.class) {
        if ((getGetBlockRangeMethod = CompactTxStreamerGrpc.getGetBlockRangeMethod) == null) {
          CompactTxStreamerGrpc.getGetBlockRangeMethod = getGetBlockRangeMethod =
              io.grpc.MethodDescriptor.<cash.z.wallet.sdk.internal.rpc.Service.BlockRange, cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBlockRange"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  cash.z.wallet.sdk.internal.rpc.Service.BlockRange.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock.getDefaultInstance()))
              .build();
        }
      }
    }
    return getGetBlockRangeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.BlockRange,
      cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock> getGetBlockRangeNullifiersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBlockRangeNullifiers",
      requestType = cash.z.wallet.sdk.internal.rpc.Service.BlockRange.class,
      responseType = cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.BlockRange,
      cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock> getGetBlockRangeNullifiersMethod() {
    io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.BlockRange, cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock> getGetBlockRangeNullifiersMethod;
    if ((getGetBlockRangeNullifiersMethod = CompactTxStreamerGrpc.getGetBlockRangeNullifiersMethod) == null) {
      synchronized (CompactTxStreamerGrpc.class) {
        if ((getGetBlockRangeNullifiersMethod = CompactTxStreamerGrpc.getGetBlockRangeNullifiersMethod) == null) {
          CompactTxStreamerGrpc.getGetBlockRangeNullifiersMethod = getGetBlockRangeNullifiersMethod =
              io.grpc.MethodDescriptor.<cash.z.wallet.sdk.internal.rpc.Service.BlockRange, cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBlockRangeNullifiers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  cash.z.wallet.sdk.internal.rpc.Service.BlockRange.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock.getDefaultInstance()))
              .build();
        }
      }
    }
    return getGetBlockRangeNullifiersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.TxFilter,
      cash.z.wallet.sdk.internal.rpc.Service.RawTransaction> getGetTransactionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTransaction",
      requestType = cash.z.wallet.sdk.internal.rpc.Service.TxFilter.class,
      responseType = cash.z.wallet.sdk.internal.rpc.Service.RawTransaction.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.TxFilter,
      cash.z.wallet.sdk.internal.rpc.Service.RawTransaction> getGetTransactionMethod() {
    io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.TxFilter, cash.z.wallet.sdk.internal.rpc.Service.RawTransaction> getGetTransactionMethod;
    if ((getGetTransactionMethod = CompactTxStreamerGrpc.getGetTransactionMethod) == null) {
      synchronized (CompactTxStreamerGrpc.class) {
        if ((getGetTransactionMethod = CompactTxStreamerGrpc.getGetTransactionMethod) == null) {
          CompactTxStreamerGrpc.getGetTransactionMethod = getGetTransactionMethod =
              io.grpc.MethodDescriptor.<cash.z.wallet.sdk.internal.rpc.Service.TxFilter, cash.z.wallet.sdk.internal.rpc.Service.RawTransaction>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTransaction"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  cash.z.wallet.sdk.internal.rpc.Service.TxFilter.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  cash.z.wallet.sdk.internal.rpc.Service.RawTransaction.getDefaultInstance()))
              .build();
        }
      }
    }
    return getGetTransactionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.RawTransaction,
      cash.z.wallet.sdk.internal.rpc.Service.SendResponse> getSendTransactionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendTransaction",
      requestType = cash.z.wallet.sdk.internal.rpc.Service.RawTransaction.class,
      responseType = cash.z.wallet.sdk.internal.rpc.Service.SendResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.RawTransaction,
      cash.z.wallet.sdk.internal.rpc.Service.SendResponse> getSendTransactionMethod() {
    io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.RawTransaction, cash.z.wallet.sdk.internal.rpc.Service.SendResponse> getSendTransactionMethod;
    if ((getSendTransactionMethod = CompactTxStreamerGrpc.getSendTransactionMethod) == null) {
      synchronized (CompactTxStreamerGrpc.class) {
        if ((getSendTransactionMethod = CompactTxStreamerGrpc.getSendTransactionMethod) == null) {
          CompactTxStreamerGrpc.getSendTransactionMethod = getSendTransactionMethod =
              io.grpc.MethodDescriptor.<cash.z.wallet.sdk.internal.rpc.Service.RawTransaction, cash.z.wallet.sdk.internal.rpc.Service.SendResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendTransaction"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  cash.z.wallet.sdk.internal.rpc.Service.RawTransaction.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  cash.z.wallet.sdk.internal.rpc.Service.SendResponse.getDefaultInstance()))
              .build();
        }
      }
    }
    return getSendTransactionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.TransparentAddressBlockFilter,
      cash.z.wallet.sdk.internal.rpc.Service.RawTransaction> getGetTaddressTxidsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTaddressTxids",
      requestType = cash.z.wallet.sdk.internal.rpc.Service.TransparentAddressBlockFilter.class,
      responseType = cash.z.wallet.sdk.internal.rpc.Service.RawTransaction.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.TransparentAddressBlockFilter,
      cash.z.wallet.sdk.internal.rpc.Service.RawTransaction> getGetTaddressTxidsMethod() {
    io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.TransparentAddressBlockFilter, cash.z.wallet.sdk.internal.rpc.Service.RawTransaction> getGetTaddressTxidsMethod;
    if ((getGetTaddressTxidsMethod = CompactTxStreamerGrpc.getGetTaddressTxidsMethod) == null) {
      synchronized (CompactTxStreamerGrpc.class) {
        if ((getGetTaddressTxidsMethod = CompactTxStreamerGrpc.getGetTaddressTxidsMethod) == null) {
          CompactTxStreamerGrpc.getGetTaddressTxidsMethod = getGetTaddressTxidsMethod =
              io.grpc.MethodDescriptor.<cash.z.wallet.sdk.internal.rpc.Service.TransparentAddressBlockFilter, cash.z.wallet.sdk.internal.rpc.Service.RawTransaction>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTaddressTxids"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  cash.z.wallet.sdk.internal.rpc.Service.TransparentAddressBlockFilter.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  cash.z.wallet.sdk.internal.rpc.Service.RawTransaction.getDefaultInstance()))
              .build();
        }
      }
    }
    return getGetTaddressTxidsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.AddressList,
      cash.z.wallet.sdk.internal.rpc.Service.Balance> getGetTaddressBalanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTaddressBalance",
      requestType = cash.z.wallet.sdk.internal.rpc.Service.AddressList.class,
      responseType = cash.z.wallet.sdk.internal.rpc.Service.Balance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.AddressList,
      cash.z.wallet.sdk.internal.rpc.Service.Balance> getGetTaddressBalanceMethod() {
    io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.AddressList, cash.z.wallet.sdk.internal.rpc.Service.Balance> getGetTaddressBalanceMethod;
    if ((getGetTaddressBalanceMethod = CompactTxStreamerGrpc.getGetTaddressBalanceMethod) == null) {
      synchronized (CompactTxStreamerGrpc.class) {
        if ((getGetTaddressBalanceMethod = CompactTxStreamerGrpc.getGetTaddressBalanceMethod) == null) {
          CompactTxStreamerGrpc.getGetTaddressBalanceMethod = getGetTaddressBalanceMethod =
              io.grpc.MethodDescriptor.<cash.z.wallet.sdk.internal.rpc.Service.AddressList, cash.z.wallet.sdk.internal.rpc.Service.Balance>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTaddressBalance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  cash.z.wallet.sdk.internal.rpc.Service.AddressList.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  cash.z.wallet.sdk.internal.rpc.Service.Balance.getDefaultInstance()))
              .build();
        }
      }
    }
    return getGetTaddressBalanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.Address,
      cash.z.wallet.sdk.internal.rpc.Service.Balance> getGetTaddressBalanceStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTaddressBalanceStream",
      requestType = cash.z.wallet.sdk.internal.rpc.Service.Address.class,
      responseType = cash.z.wallet.sdk.internal.rpc.Service.Balance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.Address,
      cash.z.wallet.sdk.internal.rpc.Service.Balance> getGetTaddressBalanceStreamMethod() {
    io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.Address, cash.z.wallet.sdk.internal.rpc.Service.Balance> getGetTaddressBalanceStreamMethod;
    if ((getGetTaddressBalanceStreamMethod = CompactTxStreamerGrpc.getGetTaddressBalanceStreamMethod) == null) {
      synchronized (CompactTxStreamerGrpc.class) {
        if ((getGetTaddressBalanceStreamMethod = CompactTxStreamerGrpc.getGetTaddressBalanceStreamMethod) == null) {
          CompactTxStreamerGrpc.getGetTaddressBalanceStreamMethod = getGetTaddressBalanceStreamMethod =
              io.grpc.MethodDescriptor.<cash.z.wallet.sdk.internal.rpc.Service.Address, cash.z.wallet.sdk.internal.rpc.Service.Balance>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTaddressBalanceStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  cash.z.wallet.sdk.internal.rpc.Service.Address.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  cash.z.wallet.sdk.internal.rpc.Service.Balance.getDefaultInstance()))
              .build();
        }
      }
    }
    return getGetTaddressBalanceStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.Exclude,
      cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactTx> getGetMempoolTxMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMempoolTx",
      requestType = cash.z.wallet.sdk.internal.rpc.Service.Exclude.class,
      responseType = cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactTx.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.Exclude,
      cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactTx> getGetMempoolTxMethod() {
    io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.Exclude, cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactTx> getGetMempoolTxMethod;
    if ((getGetMempoolTxMethod = CompactTxStreamerGrpc.getGetMempoolTxMethod) == null) {
      synchronized (CompactTxStreamerGrpc.class) {
        if ((getGetMempoolTxMethod = CompactTxStreamerGrpc.getGetMempoolTxMethod) == null) {
          CompactTxStreamerGrpc.getGetMempoolTxMethod = getGetMempoolTxMethod =
              io.grpc.MethodDescriptor.<cash.z.wallet.sdk.internal.rpc.Service.Exclude, cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactTx>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMempoolTx"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  cash.z.wallet.sdk.internal.rpc.Service.Exclude.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactTx.getDefaultInstance()))
              .build();
        }
      }
    }
    return getGetMempoolTxMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.Empty,
      cash.z.wallet.sdk.internal.rpc.Service.RawTransaction> getGetMempoolStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMempoolStream",
      requestType = cash.z.wallet.sdk.internal.rpc.Service.Empty.class,
      responseType = cash.z.wallet.sdk.internal.rpc.Service.RawTransaction.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.Empty,
      cash.z.wallet.sdk.internal.rpc.Service.RawTransaction> getGetMempoolStreamMethod() {
    io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.Empty, cash.z.wallet.sdk.internal.rpc.Service.RawTransaction> getGetMempoolStreamMethod;
    if ((getGetMempoolStreamMethod = CompactTxStreamerGrpc.getGetMempoolStreamMethod) == null) {
      synchronized (CompactTxStreamerGrpc.class) {
        if ((getGetMempoolStreamMethod = CompactTxStreamerGrpc.getGetMempoolStreamMethod) == null) {
          CompactTxStreamerGrpc.getGetMempoolStreamMethod = getGetMempoolStreamMethod =
              io.grpc.MethodDescriptor.<cash.z.wallet.sdk.internal.rpc.Service.Empty, cash.z.wallet.sdk.internal.rpc.Service.RawTransaction>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMempoolStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  cash.z.wallet.sdk.internal.rpc.Service.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  cash.z.wallet.sdk.internal.rpc.Service.RawTransaction.getDefaultInstance()))
              .build();
        }
      }
    }
    return getGetMempoolStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.BlockID,
      cash.z.wallet.sdk.internal.rpc.Service.TreeState> getGetTreeStateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTreeState",
      requestType = cash.z.wallet.sdk.internal.rpc.Service.BlockID.class,
      responseType = cash.z.wallet.sdk.internal.rpc.Service.TreeState.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.BlockID,
      cash.z.wallet.sdk.internal.rpc.Service.TreeState> getGetTreeStateMethod() {
    io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.BlockID, cash.z.wallet.sdk.internal.rpc.Service.TreeState> getGetTreeStateMethod;
    if ((getGetTreeStateMethod = CompactTxStreamerGrpc.getGetTreeStateMethod) == null) {
      synchronized (CompactTxStreamerGrpc.class) {
        if ((getGetTreeStateMethod = CompactTxStreamerGrpc.getGetTreeStateMethod) == null) {
          CompactTxStreamerGrpc.getGetTreeStateMethod = getGetTreeStateMethod =
              io.grpc.MethodDescriptor.<cash.z.wallet.sdk.internal.rpc.Service.BlockID, cash.z.wallet.sdk.internal.rpc.Service.TreeState>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTreeState"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  cash.z.wallet.sdk.internal.rpc.Service.BlockID.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  cash.z.wallet.sdk.internal.rpc.Service.TreeState.getDefaultInstance()))
              .build();
        }
      }
    }
    return getGetTreeStateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.Empty,
      cash.z.wallet.sdk.internal.rpc.Service.TreeState> getGetLatestTreeStateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLatestTreeState",
      requestType = cash.z.wallet.sdk.internal.rpc.Service.Empty.class,
      responseType = cash.z.wallet.sdk.internal.rpc.Service.TreeState.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.Empty,
      cash.z.wallet.sdk.internal.rpc.Service.TreeState> getGetLatestTreeStateMethod() {
    io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.Empty, cash.z.wallet.sdk.internal.rpc.Service.TreeState> getGetLatestTreeStateMethod;
    if ((getGetLatestTreeStateMethod = CompactTxStreamerGrpc.getGetLatestTreeStateMethod) == null) {
      synchronized (CompactTxStreamerGrpc.class) {
        if ((getGetLatestTreeStateMethod = CompactTxStreamerGrpc.getGetLatestTreeStateMethod) == null) {
          CompactTxStreamerGrpc.getGetLatestTreeStateMethod = getGetLatestTreeStateMethod =
              io.grpc.MethodDescriptor.<cash.z.wallet.sdk.internal.rpc.Service.Empty, cash.z.wallet.sdk.internal.rpc.Service.TreeState>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetLatestTreeState"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  cash.z.wallet.sdk.internal.rpc.Service.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  cash.z.wallet.sdk.internal.rpc.Service.TreeState.getDefaultInstance()))
              .build();
        }
      }
    }
    return getGetLatestTreeStateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.GetSubtreeRootsArg,
      cash.z.wallet.sdk.internal.rpc.Service.SubtreeRoot> getGetSubtreeRootsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSubtreeRoots",
      requestType = cash.z.wallet.sdk.internal.rpc.Service.GetSubtreeRootsArg.class,
      responseType = cash.z.wallet.sdk.internal.rpc.Service.SubtreeRoot.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.GetSubtreeRootsArg,
      cash.z.wallet.sdk.internal.rpc.Service.SubtreeRoot> getGetSubtreeRootsMethod() {
    io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.GetSubtreeRootsArg, cash.z.wallet.sdk.internal.rpc.Service.SubtreeRoot> getGetSubtreeRootsMethod;
    if ((getGetSubtreeRootsMethod = CompactTxStreamerGrpc.getGetSubtreeRootsMethod) == null) {
      synchronized (CompactTxStreamerGrpc.class) {
        if ((getGetSubtreeRootsMethod = CompactTxStreamerGrpc.getGetSubtreeRootsMethod) == null) {
          CompactTxStreamerGrpc.getGetSubtreeRootsMethod = getGetSubtreeRootsMethod =
              io.grpc.MethodDescriptor.<cash.z.wallet.sdk.internal.rpc.Service.GetSubtreeRootsArg, cash.z.wallet.sdk.internal.rpc.Service.SubtreeRoot>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSubtreeRoots"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  cash.z.wallet.sdk.internal.rpc.Service.GetSubtreeRootsArg.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  cash.z.wallet.sdk.internal.rpc.Service.SubtreeRoot.getDefaultInstance()))
              .build();
        }
      }
    }
    return getGetSubtreeRootsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosArg,
      cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosReplyList> getGetAddressUtxosMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAddressUtxos",
      requestType = cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosArg.class,
      responseType = cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosReplyList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosArg,
      cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosReplyList> getGetAddressUtxosMethod() {
    io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosArg, cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosReplyList> getGetAddressUtxosMethod;
    if ((getGetAddressUtxosMethod = CompactTxStreamerGrpc.getGetAddressUtxosMethod) == null) {
      synchronized (CompactTxStreamerGrpc.class) {
        if ((getGetAddressUtxosMethod = CompactTxStreamerGrpc.getGetAddressUtxosMethod) == null) {
          CompactTxStreamerGrpc.getGetAddressUtxosMethod = getGetAddressUtxosMethod =
              io.grpc.MethodDescriptor.<cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosArg, cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosReplyList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAddressUtxos"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosArg.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosReplyList.getDefaultInstance()))
              .build();
        }
      }
    }
    return getGetAddressUtxosMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosArg,
      cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosReply> getGetAddressUtxosStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAddressUtxosStream",
      requestType = cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosArg.class,
      responseType = cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosArg,
      cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosReply> getGetAddressUtxosStreamMethod() {
    io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosArg, cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosReply> getGetAddressUtxosStreamMethod;
    if ((getGetAddressUtxosStreamMethod = CompactTxStreamerGrpc.getGetAddressUtxosStreamMethod) == null) {
      synchronized (CompactTxStreamerGrpc.class) {
        if ((getGetAddressUtxosStreamMethod = CompactTxStreamerGrpc.getGetAddressUtxosStreamMethod) == null) {
          CompactTxStreamerGrpc.getGetAddressUtxosStreamMethod = getGetAddressUtxosStreamMethod =
              io.grpc.MethodDescriptor.<cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosArg, cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAddressUtxosStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosArg.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosReply.getDefaultInstance()))
              .build();
        }
      }
    }
    return getGetAddressUtxosStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.Empty,
      cash.z.wallet.sdk.internal.rpc.Service.LightdInfo> getGetLightdInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLightdInfo",
      requestType = cash.z.wallet.sdk.internal.rpc.Service.Empty.class,
      responseType = cash.z.wallet.sdk.internal.rpc.Service.LightdInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.Empty,
      cash.z.wallet.sdk.internal.rpc.Service.LightdInfo> getGetLightdInfoMethod() {
    io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.Empty, cash.z.wallet.sdk.internal.rpc.Service.LightdInfo> getGetLightdInfoMethod;
    if ((getGetLightdInfoMethod = CompactTxStreamerGrpc.getGetLightdInfoMethod) == null) {
      synchronized (CompactTxStreamerGrpc.class) {
        if ((getGetLightdInfoMethod = CompactTxStreamerGrpc.getGetLightdInfoMethod) == null) {
          CompactTxStreamerGrpc.getGetLightdInfoMethod = getGetLightdInfoMethod =
              io.grpc.MethodDescriptor.<cash.z.wallet.sdk.internal.rpc.Service.Empty, cash.z.wallet.sdk.internal.rpc.Service.LightdInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetLightdInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  cash.z.wallet.sdk.internal.rpc.Service.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  cash.z.wallet.sdk.internal.rpc.Service.LightdInfo.getDefaultInstance()))
              .build();
        }
      }
    }
    return getGetLightdInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.Duration,
      cash.z.wallet.sdk.internal.rpc.Service.PingResponse> getPingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Ping",
      requestType = cash.z.wallet.sdk.internal.rpc.Service.Duration.class,
      responseType = cash.z.wallet.sdk.internal.rpc.Service.PingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.Duration,
      cash.z.wallet.sdk.internal.rpc.Service.PingResponse> getPingMethod() {
    io.grpc.MethodDescriptor<cash.z.wallet.sdk.internal.rpc.Service.Duration, cash.z.wallet.sdk.internal.rpc.Service.PingResponse> getPingMethod;
    if ((getPingMethod = CompactTxStreamerGrpc.getPingMethod) == null) {
      synchronized (CompactTxStreamerGrpc.class) {
        if ((getPingMethod = CompactTxStreamerGrpc.getPingMethod) == null) {
          CompactTxStreamerGrpc.getPingMethod = getPingMethod =
              io.grpc.MethodDescriptor.<cash.z.wallet.sdk.internal.rpc.Service.Duration, cash.z.wallet.sdk.internal.rpc.Service.PingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Ping"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  cash.z.wallet.sdk.internal.rpc.Service.Duration.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  cash.z.wallet.sdk.internal.rpc.Service.PingResponse.getDefaultInstance()))
              .build();
        }
      }
    }
    return getPingMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CompactTxStreamerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CompactTxStreamerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CompactTxStreamerStub>() {
        @java.lang.Override
        public CompactTxStreamerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CompactTxStreamerStub(channel, callOptions);
        }
      };
    return CompactTxStreamerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CompactTxStreamerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CompactTxStreamerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CompactTxStreamerBlockingStub>() {
        @java.lang.Override
        public CompactTxStreamerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CompactTxStreamerBlockingStub(channel, callOptions);
        }
      };
    return CompactTxStreamerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CompactTxStreamerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CompactTxStreamerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CompactTxStreamerFutureStub>() {
        @java.lang.Override
        public CompactTxStreamerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CompactTxStreamerFutureStub(channel, callOptions);
        }
      };
    return CompactTxStreamerFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     * Return the height of the tip of the best chain
     * </pre>
     */
    default void getLatestBlock(cash.z.wallet.sdk.internal.rpc.Service.ChainSpec request,
        io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.BlockID> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetLatestBlockMethod(), responseObserver);
    }

    /**
     * <pre>
     * Return the compact block corresponding to the given block identifier
     * </pre>
     */
    default void getBlock(cash.z.wallet.sdk.internal.rpc.Service.BlockID request,
        io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBlockMethod(), responseObserver);
    }

    /**
     * <pre>
     * Same as GetBlock except actions contain only nullifiers
     * </pre>
     */
    default void getBlockNullifiers(cash.z.wallet.sdk.internal.rpc.Service.BlockID request,
        io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBlockNullifiersMethod(), responseObserver);
    }

    /**
     * <pre>
     * Return a list of consecutive compact blocks
     * </pre>
     */
    default void getBlockRange(cash.z.wallet.sdk.internal.rpc.Service.BlockRange request,
        io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBlockRangeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Same as GetBlockRange except actions contain only nullifiers
     * </pre>
     */
    default void getBlockRangeNullifiers(cash.z.wallet.sdk.internal.rpc.Service.BlockRange request,
        io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBlockRangeNullifiersMethod(), responseObserver);
    }

    /**
     * <pre>
     * Return the requested full (not compact) transaction (as from zcashd)
     * </pre>
     */
    default void getTransaction(cash.z.wallet.sdk.internal.rpc.Service.TxFilter request,
        io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.RawTransaction> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTransactionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Submit the given transaction to the Zcash network
     * </pre>
     */
    default void sendTransaction(cash.z.wallet.sdk.internal.rpc.Service.RawTransaction request,
        io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.SendResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendTransactionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Return the txids corresponding to the given t-address within the given block range
     * </pre>
     */
    default void getTaddressTxids(cash.z.wallet.sdk.internal.rpc.Service.TransparentAddressBlockFilter request,
        io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.RawTransaction> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTaddressTxidsMethod(), responseObserver);
    }

    /**
     */
    default void getTaddressBalance(cash.z.wallet.sdk.internal.rpc.Service.AddressList request,
        io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.Balance> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTaddressBalanceMethod(), responseObserver);
    }

    /**
     */
    default io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.Address> getTaddressBalanceStream(
        io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.Balance> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getGetTaddressBalanceStreamMethod(), responseObserver);
    }

    /**
     * <pre>
     * Return the compact transactions currently in the mempool; the results
     * can be a few seconds out of date. If the Exclude list is empty, return
     * all transactions; otherwise return all *except* those in the Exclude list
     * (if any); this allows the client to avoid receiving transactions that it
     * already has (from an earlier call to this rpc). The transaction IDs in the
     * Exclude list can be shortened to any number of bytes to make the request
     * more bandwidth-efficient; if two or more transactions in the mempool
     * match a shortened txid, they are all sent (none is excluded). Transactions
     * in the exclude list that don't exist in the mempool are ignored.
     * </pre>
     */
    default void getMempoolTx(cash.z.wallet.sdk.internal.rpc.Service.Exclude request,
        io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactTx> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMempoolTxMethod(), responseObserver);
    }

    /**
     * <pre>
     * Return a stream of current Mempool transactions. This will keep the output stream open while
     * there are mempool transactions. It will close the returned stream when a new block is mined.
     * </pre>
     */
    default void getMempoolStream(cash.z.wallet.sdk.internal.rpc.Service.Empty request,
        io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.RawTransaction> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMempoolStreamMethod(), responseObserver);
    }

    /**
     * <pre>
     * GetTreeState returns the note commitment tree state corresponding to the given block.
     * See section 3.7 of the Zcash protocol specification. It returns several other useful
     * values also (even though they can be obtained using GetBlock).
     * The block can be specified by either height or hash.
     * </pre>
     */
    default void getTreeState(cash.z.wallet.sdk.internal.rpc.Service.BlockID request,
        io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.TreeState> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTreeStateMethod(), responseObserver);
    }

    /**
     */
    default void getLatestTreeState(cash.z.wallet.sdk.internal.rpc.Service.Empty request,
        io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.TreeState> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetLatestTreeStateMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns a stream of information about roots of subtrees of the Sapling and Orchard
     * note commitment trees.
     * </pre>
     */
    default void getSubtreeRoots(cash.z.wallet.sdk.internal.rpc.Service.GetSubtreeRootsArg request,
        io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.SubtreeRoot> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSubtreeRootsMethod(), responseObserver);
    }

    /**
     */
    default void getAddressUtxos(cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosArg request,
        io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosReplyList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAddressUtxosMethod(), responseObserver);
    }

    /**
     */
    default void getAddressUtxosStream(cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosArg request,
        io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAddressUtxosStreamMethod(), responseObserver);
    }

    /**
     * <pre>
     * Return information about this lightwalletd instance and the blockchain
     * </pre>
     */
    default void getLightdInfo(cash.z.wallet.sdk.internal.rpc.Service.Empty request,
        io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.LightdInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetLightdInfoMethod(), responseObserver);
    }

    /**
     * <pre>
     * Testing-only, requires lightwalletd --ping-very-insecure (do not enable in production)
     * </pre>
     */
    default void ping(cash.z.wallet.sdk.internal.rpc.Service.Duration request,
        io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.PingResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPingMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CompactTxStreamer.
   */
  public static abstract class CompactTxStreamerImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CompactTxStreamerGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CompactTxStreamer.
   */
  public static final class CompactTxStreamerStub
      extends io.grpc.stub.AbstractAsyncStub<CompactTxStreamerStub> {
    private CompactTxStreamerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CompactTxStreamerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CompactTxStreamerStub(channel, callOptions);
    }

    /**
     * <pre>
     * Return the height of the tip of the best chain
     * </pre>
     */
    public void getLatestBlock(cash.z.wallet.sdk.internal.rpc.Service.ChainSpec request,
        io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.BlockID> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLatestBlockMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Return the compact block corresponding to the given block identifier
     * </pre>
     */
    public void getBlock(cash.z.wallet.sdk.internal.rpc.Service.BlockID request,
        io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBlockMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Same as GetBlock except actions contain only nullifiers
     * </pre>
     */
    public void getBlockNullifiers(cash.z.wallet.sdk.internal.rpc.Service.BlockID request,
        io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBlockNullifiersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Return a list of consecutive compact blocks
     * </pre>
     */
    public void getBlockRange(cash.z.wallet.sdk.internal.rpc.Service.BlockRange request,
        io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetBlockRangeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Same as GetBlockRange except actions contain only nullifiers
     * </pre>
     */
    public void getBlockRangeNullifiers(cash.z.wallet.sdk.internal.rpc.Service.BlockRange request,
        io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetBlockRangeNullifiersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Return the requested full (not compact) transaction (as from zcashd)
     * </pre>
     */
    public void getTransaction(cash.z.wallet.sdk.internal.rpc.Service.TxFilter request,
        io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.RawTransaction> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTransactionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Submit the given transaction to the Zcash network
     * </pre>
     */
    public void sendTransaction(cash.z.wallet.sdk.internal.rpc.Service.RawTransaction request,
        io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.SendResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendTransactionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Return the txids corresponding to the given t-address within the given block range
     * </pre>
     */
    public void getTaddressTxids(cash.z.wallet.sdk.internal.rpc.Service.TransparentAddressBlockFilter request,
        io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.RawTransaction> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetTaddressTxidsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTaddressBalance(cash.z.wallet.sdk.internal.rpc.Service.AddressList request,
        io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.Balance> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTaddressBalanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.Address> getTaddressBalanceStream(
        io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.Balance> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getGetTaddressBalanceStreamMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Return the compact transactions currently in the mempool; the results
     * can be a few seconds out of date. If the Exclude list is empty, return
     * all transactions; otherwise return all *except* those in the Exclude list
     * (if any); this allows the client to avoid receiving transactions that it
     * already has (from an earlier call to this rpc). The transaction IDs in the
     * Exclude list can be shortened to any number of bytes to make the request
     * more bandwidth-efficient; if two or more transactions in the mempool
     * match a shortened txid, they are all sent (none is excluded). Transactions
     * in the exclude list that don't exist in the mempool are ignored.
     * </pre>
     */
    public void getMempoolTx(cash.z.wallet.sdk.internal.rpc.Service.Exclude request,
        io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactTx> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetMempoolTxMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Return a stream of current Mempool transactions. This will keep the output stream open while
     * there are mempool transactions. It will close the returned stream when a new block is mined.
     * </pre>
     */
    public void getMempoolStream(cash.z.wallet.sdk.internal.rpc.Service.Empty request,
        io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.RawTransaction> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetMempoolStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * GetTreeState returns the note commitment tree state corresponding to the given block.
     * See section 3.7 of the Zcash protocol specification. It returns several other useful
     * values also (even though they can be obtained using GetBlock).
     * The block can be specified by either height or hash.
     * </pre>
     */
    public void getTreeState(cash.z.wallet.sdk.internal.rpc.Service.BlockID request,
        io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.TreeState> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTreeStateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getLatestTreeState(cash.z.wallet.sdk.internal.rpc.Service.Empty request,
        io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.TreeState> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLatestTreeStateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns a stream of information about roots of subtrees of the Sapling and Orchard
     * note commitment trees.
     * </pre>
     */
    public void getSubtreeRoots(cash.z.wallet.sdk.internal.rpc.Service.GetSubtreeRootsArg request,
        io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.SubtreeRoot> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetSubtreeRootsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAddressUtxos(cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosArg request,
        io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosReplyList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAddressUtxosMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAddressUtxosStream(cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosArg request,
        io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetAddressUtxosStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Return information about this lightwalletd instance and the blockchain
     * </pre>
     */
    public void getLightdInfo(cash.z.wallet.sdk.internal.rpc.Service.Empty request,
        io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.LightdInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLightdInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Testing-only, requires lightwalletd --ping-very-insecure (do not enable in production)
     * </pre>
     */
    public void ping(cash.z.wallet.sdk.internal.rpc.Service.Duration request,
        io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.PingResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPingMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CompactTxStreamer.
   */
  public static final class CompactTxStreamerBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CompactTxStreamerBlockingStub> {
    private CompactTxStreamerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CompactTxStreamerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CompactTxStreamerBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Return the height of the tip of the best chain
     * </pre>
     */
    public cash.z.wallet.sdk.internal.rpc.Service.BlockID getLatestBlock(cash.z.wallet.sdk.internal.rpc.Service.ChainSpec request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLatestBlockMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Return the compact block corresponding to the given block identifier
     * </pre>
     */
    public cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock getBlock(cash.z.wallet.sdk.internal.rpc.Service.BlockID request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBlockMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Same as GetBlock except actions contain only nullifiers
     * </pre>
     */
    public cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock getBlockNullifiers(cash.z.wallet.sdk.internal.rpc.Service.BlockID request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBlockNullifiersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Return a list of consecutive compact blocks
     * </pre>
     */
    public java.util.Iterator<cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock> getBlockRange(
        cash.z.wallet.sdk.internal.rpc.Service.BlockRange request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetBlockRangeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Same as GetBlockRange except actions contain only nullifiers
     * </pre>
     */
    public java.util.Iterator<cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock> getBlockRangeNullifiers(
        cash.z.wallet.sdk.internal.rpc.Service.BlockRange request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetBlockRangeNullifiersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Return the requested full (not compact) transaction (as from zcashd)
     * </pre>
     */
    public cash.z.wallet.sdk.internal.rpc.Service.RawTransaction getTransaction(cash.z.wallet.sdk.internal.rpc.Service.TxFilter request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTransactionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Submit the given transaction to the Zcash network
     * </pre>
     */
    public cash.z.wallet.sdk.internal.rpc.Service.SendResponse sendTransaction(cash.z.wallet.sdk.internal.rpc.Service.RawTransaction request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendTransactionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Return the txids corresponding to the given t-address within the given block range
     * </pre>
     */
    public java.util.Iterator<cash.z.wallet.sdk.internal.rpc.Service.RawTransaction> getTaddressTxids(
        cash.z.wallet.sdk.internal.rpc.Service.TransparentAddressBlockFilter request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetTaddressTxidsMethod(), getCallOptions(), request);
    }

    /**
     */
    public cash.z.wallet.sdk.internal.rpc.Service.Balance getTaddressBalance(cash.z.wallet.sdk.internal.rpc.Service.AddressList request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTaddressBalanceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Return the compact transactions currently in the mempool; the results
     * can be a few seconds out of date. If the Exclude list is empty, return
     * all transactions; otherwise return all *except* those in the Exclude list
     * (if any); this allows the client to avoid receiving transactions that it
     * already has (from an earlier call to this rpc). The transaction IDs in the
     * Exclude list can be shortened to any number of bytes to make the request
     * more bandwidth-efficient; if two or more transactions in the mempool
     * match a shortened txid, they are all sent (none is excluded). Transactions
     * in the exclude list that don't exist in the mempool are ignored.
     * </pre>
     */
    public java.util.Iterator<cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactTx> getMempoolTx(
        cash.z.wallet.sdk.internal.rpc.Service.Exclude request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetMempoolTxMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Return a stream of current Mempool transactions. This will keep the output stream open while
     * there are mempool transactions. It will close the returned stream when a new block is mined.
     * </pre>
     */
    public java.util.Iterator<cash.z.wallet.sdk.internal.rpc.Service.RawTransaction> getMempoolStream(
        cash.z.wallet.sdk.internal.rpc.Service.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetMempoolStreamMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * GetTreeState returns the note commitment tree state corresponding to the given block.
     * See section 3.7 of the Zcash protocol specification. It returns several other useful
     * values also (even though they can be obtained using GetBlock).
     * The block can be specified by either height or hash.
     * </pre>
     */
    public cash.z.wallet.sdk.internal.rpc.Service.TreeState getTreeState(cash.z.wallet.sdk.internal.rpc.Service.BlockID request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTreeStateMethod(), getCallOptions(), request);
    }

    /**
     */
    public cash.z.wallet.sdk.internal.rpc.Service.TreeState getLatestTreeState(cash.z.wallet.sdk.internal.rpc.Service.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLatestTreeStateMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns a stream of information about roots of subtrees of the Sapling and Orchard
     * note commitment trees.
     * </pre>
     */
    public java.util.Iterator<cash.z.wallet.sdk.internal.rpc.Service.SubtreeRoot> getSubtreeRoots(
        cash.z.wallet.sdk.internal.rpc.Service.GetSubtreeRootsArg request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetSubtreeRootsMethod(), getCallOptions(), request);
    }

    /**
     */
    public cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosReplyList getAddressUtxos(cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosArg request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAddressUtxosMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosReply> getAddressUtxosStream(
        cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosArg request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetAddressUtxosStreamMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Return information about this lightwalletd instance and the blockchain
     * </pre>
     */
    public cash.z.wallet.sdk.internal.rpc.Service.LightdInfo getLightdInfo(cash.z.wallet.sdk.internal.rpc.Service.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLightdInfoMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Testing-only, requires lightwalletd --ping-very-insecure (do not enable in production)
     * </pre>
     */
    public cash.z.wallet.sdk.internal.rpc.Service.PingResponse ping(cash.z.wallet.sdk.internal.rpc.Service.Duration request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPingMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CompactTxStreamer.
   */
  public static final class CompactTxStreamerFutureStub
      extends io.grpc.stub.AbstractFutureStub<CompactTxStreamerFutureStub> {
    private CompactTxStreamerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CompactTxStreamerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CompactTxStreamerFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Return the height of the tip of the best chain
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<cash.z.wallet.sdk.internal.rpc.Service.BlockID> getLatestBlock(
        cash.z.wallet.sdk.internal.rpc.Service.ChainSpec request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLatestBlockMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Return the compact block corresponding to the given block identifier
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock> getBlock(
        cash.z.wallet.sdk.internal.rpc.Service.BlockID request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBlockMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Same as GetBlock except actions contain only nullifiers
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock> getBlockNullifiers(
        cash.z.wallet.sdk.internal.rpc.Service.BlockID request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBlockNullifiersMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Return the requested full (not compact) transaction (as from zcashd)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<cash.z.wallet.sdk.internal.rpc.Service.RawTransaction> getTransaction(
        cash.z.wallet.sdk.internal.rpc.Service.TxFilter request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTransactionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Submit the given transaction to the Zcash network
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<cash.z.wallet.sdk.internal.rpc.Service.SendResponse> sendTransaction(
        cash.z.wallet.sdk.internal.rpc.Service.RawTransaction request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendTransactionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cash.z.wallet.sdk.internal.rpc.Service.Balance> getTaddressBalance(
        cash.z.wallet.sdk.internal.rpc.Service.AddressList request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTaddressBalanceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * GetTreeState returns the note commitment tree state corresponding to the given block.
     * See section 3.7 of the Zcash protocol specification. It returns several other useful
     * values also (even though they can be obtained using GetBlock).
     * The block can be specified by either height or hash.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<cash.z.wallet.sdk.internal.rpc.Service.TreeState> getTreeState(
        cash.z.wallet.sdk.internal.rpc.Service.BlockID request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTreeStateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cash.z.wallet.sdk.internal.rpc.Service.TreeState> getLatestTreeState(
        cash.z.wallet.sdk.internal.rpc.Service.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLatestTreeStateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosReplyList> getAddressUtxos(
        cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosArg request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAddressUtxosMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Return information about this lightwalletd instance and the blockchain
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<cash.z.wallet.sdk.internal.rpc.Service.LightdInfo> getLightdInfo(
        cash.z.wallet.sdk.internal.rpc.Service.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLightdInfoMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Testing-only, requires lightwalletd --ping-very-insecure (do not enable in production)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<cash.z.wallet.sdk.internal.rpc.Service.PingResponse> ping(
        cash.z.wallet.sdk.internal.rpc.Service.Duration request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPingMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_LATEST_BLOCK = 0;
  private static final int METHODID_GET_BLOCK = 1;
  private static final int METHODID_GET_BLOCK_NULLIFIERS = 2;
  private static final int METHODID_GET_BLOCK_RANGE = 3;
  private static final int METHODID_GET_BLOCK_RANGE_NULLIFIERS = 4;
  private static final int METHODID_GET_TRANSACTION = 5;
  private static final int METHODID_SEND_TRANSACTION = 6;
  private static final int METHODID_GET_TADDRESS_TXIDS = 7;
  private static final int METHODID_GET_TADDRESS_BALANCE = 8;
  private static final int METHODID_GET_MEMPOOL_TX = 9;
  private static final int METHODID_GET_MEMPOOL_STREAM = 10;
  private static final int METHODID_GET_TREE_STATE = 11;
  private static final int METHODID_GET_LATEST_TREE_STATE = 12;
  private static final int METHODID_GET_SUBTREE_ROOTS = 13;
  private static final int METHODID_GET_ADDRESS_UTXOS = 14;
  private static final int METHODID_GET_ADDRESS_UTXOS_STREAM = 15;
  private static final int METHODID_GET_LIGHTD_INFO = 16;
  private static final int METHODID_PING = 17;
  private static final int METHODID_GET_TADDRESS_BALANCE_STREAM = 18;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_LATEST_BLOCK:
          serviceImpl.getLatestBlock((cash.z.wallet.sdk.internal.rpc.Service.ChainSpec) request,
              (io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.BlockID>) responseObserver);
          break;
        case METHODID_GET_BLOCK:
          serviceImpl.getBlock((cash.z.wallet.sdk.internal.rpc.Service.BlockID) request,
              (io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock>) responseObserver);
          break;
        case METHODID_GET_BLOCK_NULLIFIERS:
          serviceImpl.getBlockNullifiers((cash.z.wallet.sdk.internal.rpc.Service.BlockID) request,
              (io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock>) responseObserver);
          break;
        case METHODID_GET_BLOCK_RANGE:
          serviceImpl.getBlockRange((cash.z.wallet.sdk.internal.rpc.Service.BlockRange) request,
              (io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock>) responseObserver);
          break;
        case METHODID_GET_BLOCK_RANGE_NULLIFIERS:
          serviceImpl.getBlockRangeNullifiers((cash.z.wallet.sdk.internal.rpc.Service.BlockRange) request,
              (io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock>) responseObserver);
          break;
        case METHODID_GET_TRANSACTION:
          serviceImpl.getTransaction((cash.z.wallet.sdk.internal.rpc.Service.TxFilter) request,
              (io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.RawTransaction>) responseObserver);
          break;
        case METHODID_SEND_TRANSACTION:
          serviceImpl.sendTransaction((cash.z.wallet.sdk.internal.rpc.Service.RawTransaction) request,
              (io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.SendResponse>) responseObserver);
          break;
        case METHODID_GET_TADDRESS_TXIDS:
          serviceImpl.getTaddressTxids((cash.z.wallet.sdk.internal.rpc.Service.TransparentAddressBlockFilter) request,
              (io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.RawTransaction>) responseObserver);
          break;
        case METHODID_GET_TADDRESS_BALANCE:
          serviceImpl.getTaddressBalance((cash.z.wallet.sdk.internal.rpc.Service.AddressList) request,
              (io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.Balance>) responseObserver);
          break;
        case METHODID_GET_MEMPOOL_TX:
          serviceImpl.getMempoolTx((cash.z.wallet.sdk.internal.rpc.Service.Exclude) request,
              (io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactTx>) responseObserver);
          break;
        case METHODID_GET_MEMPOOL_STREAM:
          serviceImpl.getMempoolStream((cash.z.wallet.sdk.internal.rpc.Service.Empty) request,
              (io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.RawTransaction>) responseObserver);
          break;
        case METHODID_GET_TREE_STATE:
          serviceImpl.getTreeState((cash.z.wallet.sdk.internal.rpc.Service.BlockID) request,
              (io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.TreeState>) responseObserver);
          break;
        case METHODID_GET_LATEST_TREE_STATE:
          serviceImpl.getLatestTreeState((cash.z.wallet.sdk.internal.rpc.Service.Empty) request,
              (io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.TreeState>) responseObserver);
          break;
        case METHODID_GET_SUBTREE_ROOTS:
          serviceImpl.getSubtreeRoots((cash.z.wallet.sdk.internal.rpc.Service.GetSubtreeRootsArg) request,
              (io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.SubtreeRoot>) responseObserver);
          break;
        case METHODID_GET_ADDRESS_UTXOS:
          serviceImpl.getAddressUtxos((cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosArg) request,
              (io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosReplyList>) responseObserver);
          break;
        case METHODID_GET_ADDRESS_UTXOS_STREAM:
          serviceImpl.getAddressUtxosStream((cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosArg) request,
              (io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosReply>) responseObserver);
          break;
        case METHODID_GET_LIGHTD_INFO:
          serviceImpl.getLightdInfo((cash.z.wallet.sdk.internal.rpc.Service.Empty) request,
              (io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.LightdInfo>) responseObserver);
          break;
        case METHODID_PING:
          serviceImpl.ping((cash.z.wallet.sdk.internal.rpc.Service.Duration) request,
              (io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.PingResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_TADDRESS_BALANCE_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getTaddressBalanceStream(
              (io.grpc.stub.StreamObserver<cash.z.wallet.sdk.internal.rpc.Service.Balance>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetLatestBlockMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              cash.z.wallet.sdk.internal.rpc.Service.ChainSpec,
              cash.z.wallet.sdk.internal.rpc.Service.BlockID>(
                service, METHODID_GET_LATEST_BLOCK)))
        .addMethod(
          getGetBlockMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              cash.z.wallet.sdk.internal.rpc.Service.BlockID,
              cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock>(
                service, METHODID_GET_BLOCK)))
        .addMethod(
          getGetBlockNullifiersMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              cash.z.wallet.sdk.internal.rpc.Service.BlockID,
              cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock>(
                service, METHODID_GET_BLOCK_NULLIFIERS)))
        .addMethod(
          getGetBlockRangeMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              cash.z.wallet.sdk.internal.rpc.Service.BlockRange,
              cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock>(
                service, METHODID_GET_BLOCK_RANGE)))
        .addMethod(
          getGetBlockRangeNullifiersMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              cash.z.wallet.sdk.internal.rpc.Service.BlockRange,
              cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactBlock>(
                service, METHODID_GET_BLOCK_RANGE_NULLIFIERS)))
        .addMethod(
          getGetTransactionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              cash.z.wallet.sdk.internal.rpc.Service.TxFilter,
              cash.z.wallet.sdk.internal.rpc.Service.RawTransaction>(
                service, METHODID_GET_TRANSACTION)))
        .addMethod(
          getSendTransactionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              cash.z.wallet.sdk.internal.rpc.Service.RawTransaction,
              cash.z.wallet.sdk.internal.rpc.Service.SendResponse>(
                service, METHODID_SEND_TRANSACTION)))
        .addMethod(
          getGetTaddressTxidsMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              cash.z.wallet.sdk.internal.rpc.Service.TransparentAddressBlockFilter,
              cash.z.wallet.sdk.internal.rpc.Service.RawTransaction>(
                service, METHODID_GET_TADDRESS_TXIDS)))
        .addMethod(
          getGetTaddressBalanceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              cash.z.wallet.sdk.internal.rpc.Service.AddressList,
              cash.z.wallet.sdk.internal.rpc.Service.Balance>(
                service, METHODID_GET_TADDRESS_BALANCE)))
        .addMethod(
          getGetTaddressBalanceStreamMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              cash.z.wallet.sdk.internal.rpc.Service.Address,
              cash.z.wallet.sdk.internal.rpc.Service.Balance>(
                service, METHODID_GET_TADDRESS_BALANCE_STREAM)))
        .addMethod(
          getGetMempoolTxMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              cash.z.wallet.sdk.internal.rpc.Service.Exclude,
              cash.z.wallet.sdk.internal.rpc.CompactFormats.CompactTx>(
                service, METHODID_GET_MEMPOOL_TX)))
        .addMethod(
          getGetMempoolStreamMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              cash.z.wallet.sdk.internal.rpc.Service.Empty,
              cash.z.wallet.sdk.internal.rpc.Service.RawTransaction>(
                service, METHODID_GET_MEMPOOL_STREAM)))
        .addMethod(
          getGetTreeStateMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              cash.z.wallet.sdk.internal.rpc.Service.BlockID,
              cash.z.wallet.sdk.internal.rpc.Service.TreeState>(
                service, METHODID_GET_TREE_STATE)))
        .addMethod(
          getGetLatestTreeStateMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              cash.z.wallet.sdk.internal.rpc.Service.Empty,
              cash.z.wallet.sdk.internal.rpc.Service.TreeState>(
                service, METHODID_GET_LATEST_TREE_STATE)))
        .addMethod(
          getGetSubtreeRootsMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              cash.z.wallet.sdk.internal.rpc.Service.GetSubtreeRootsArg,
              cash.z.wallet.sdk.internal.rpc.Service.SubtreeRoot>(
                service, METHODID_GET_SUBTREE_ROOTS)))
        .addMethod(
          getGetAddressUtxosMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosArg,
              cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosReplyList>(
                service, METHODID_GET_ADDRESS_UTXOS)))
        .addMethod(
          getGetAddressUtxosStreamMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosArg,
              cash.z.wallet.sdk.internal.rpc.Service.GetAddressUtxosReply>(
                service, METHODID_GET_ADDRESS_UTXOS_STREAM)))
        .addMethod(
          getGetLightdInfoMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              cash.z.wallet.sdk.internal.rpc.Service.Empty,
              cash.z.wallet.sdk.internal.rpc.Service.LightdInfo>(
                service, METHODID_GET_LIGHTD_INFO)))
        .addMethod(
          getPingMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              cash.z.wallet.sdk.internal.rpc.Service.Duration,
              cash.z.wallet.sdk.internal.rpc.Service.PingResponse>(
                service, METHODID_PING)))
        .build();
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CompactTxStreamerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .addMethod(getGetLatestBlockMethod())
              .addMethod(getGetBlockMethod())
              .addMethod(getGetBlockNullifiersMethod())
              .addMethod(getGetBlockRangeMethod())
              .addMethod(getGetBlockRangeNullifiersMethod())
              .addMethod(getGetTransactionMethod())
              .addMethod(getSendTransactionMethod())
              .addMethod(getGetTaddressTxidsMethod())
              .addMethod(getGetTaddressBalanceMethod())
              .addMethod(getGetTaddressBalanceStreamMethod())
              .addMethod(getGetMempoolTxMethod())
              .addMethod(getGetMempoolStreamMethod())
              .addMethod(getGetTreeStateMethod())
              .addMethod(getGetLatestTreeStateMethod())
              .addMethod(getGetSubtreeRootsMethod())
              .addMethod(getGetAddressUtxosMethod())
              .addMethod(getGetAddressUtxosStreamMethod())
              .addMethod(getGetLightdInfoMethod())
              .addMethod(getPingMethod())
              .build();
        }
      }
    }
    return result;
  }
}
