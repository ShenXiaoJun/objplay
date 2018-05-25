// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/devtools/remoteexecution/v1test/remote_execution.proto

package com.google.devtools.remoteexecution.v1test;

/**
 * <pre>
 * The response message for
 * [Execution.Execute][google.devtools.remoteexecution.v1test.Execution.Execute],
 * which will be contained in the [response field][google.longrunning.Operation.response] of the
 * [Operation][google.longrunning.Operation].
 * </pre>
 *
 * Protobuf type {@code google.devtools.remoteexecution.v1test.ExecuteResponse}
 */
public  final class ExecuteResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:google.devtools.remoteexecution.v1test.ExecuteResponse)
    ExecuteResponseOrBuilder {
  // Use ExecuteResponse.newBuilder() to construct.
  private ExecuteResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ExecuteResponse() {
    cachedResult_ = false;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private ExecuteResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            com.google.devtools.remoteexecution.v1test.ActionResult.Builder subBuilder = null;
            if (result_ != null) {
              subBuilder = result_.toBuilder();
            }
            result_ = input.readMessage(com.google.devtools.remoteexecution.v1test.ActionResult.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(result_);
              result_ = subBuilder.buildPartial();
            }

            break;
          }
          case 16: {

            cachedResult_ = input.readBool();
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.google.devtools.remoteexecution.v1test.RemoteExecutionProto.internal_static_google_devtools_remoteexecution_v1test_ExecuteResponse_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.devtools.remoteexecution.v1test.RemoteExecutionProto.internal_static_google_devtools_remoteexecution_v1test_ExecuteResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.devtools.remoteexecution.v1test.ExecuteResponse.class, com.google.devtools.remoteexecution.v1test.ExecuteResponse.Builder.class);
  }

  public static final int RESULT_FIELD_NUMBER = 1;
  private com.google.devtools.remoteexecution.v1test.ActionResult result_;
  /**
   * <pre>
   * The result of the action.
   * </pre>
   *
   * <code>.google.devtools.remoteexecution.v1test.ActionResult result = 1;</code>
   */
  public boolean hasResult() {
    return result_ != null;
  }
  /**
   * <pre>
   * The result of the action.
   * </pre>
   *
   * <code>.google.devtools.remoteexecution.v1test.ActionResult result = 1;</code>
   */
  public com.google.devtools.remoteexecution.v1test.ActionResult getResult() {
    return result_ == null ? com.google.devtools.remoteexecution.v1test.ActionResult.getDefaultInstance() : result_;
  }
  /**
   * <pre>
   * The result of the action.
   * </pre>
   *
   * <code>.google.devtools.remoteexecution.v1test.ActionResult result = 1;</code>
   */
  public com.google.devtools.remoteexecution.v1test.ActionResultOrBuilder getResultOrBuilder() {
    return getResult();
  }

  public static final int CACHED_RESULT_FIELD_NUMBER = 2;
  private boolean cachedResult_;
  /**
   * <pre>
   * True if the result was served from cache, false if it was executed.
   * </pre>
   *
   * <code>bool cached_result = 2;</code>
   */
  public boolean getCachedResult() {
    return cachedResult_;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (result_ != null) {
      output.writeMessage(1, getResult());
    }
    if (cachedResult_ != false) {
      output.writeBool(2, cachedResult_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (result_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getResult());
    }
    if (cachedResult_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(2, cachedResult_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.google.devtools.remoteexecution.v1test.ExecuteResponse)) {
      return super.equals(obj);
    }
    com.google.devtools.remoteexecution.v1test.ExecuteResponse other = (com.google.devtools.remoteexecution.v1test.ExecuteResponse) obj;

    boolean result = true;
    result = result && (hasResult() == other.hasResult());
    if (hasResult()) {
      result = result && getResult()
          .equals(other.getResult());
    }
    result = result && (getCachedResult()
        == other.getCachedResult());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasResult()) {
      hash = (37 * hash) + RESULT_FIELD_NUMBER;
      hash = (53 * hash) + getResult().hashCode();
    }
    hash = (37 * hash) + CACHED_RESULT_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getCachedResult());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.devtools.remoteexecution.v1test.ExecuteResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.devtools.remoteexecution.v1test.ExecuteResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.devtools.remoteexecution.v1test.ExecuteResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.devtools.remoteexecution.v1test.ExecuteResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.devtools.remoteexecution.v1test.ExecuteResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.devtools.remoteexecution.v1test.ExecuteResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.devtools.remoteexecution.v1test.ExecuteResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.google.devtools.remoteexecution.v1test.ExecuteResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.devtools.remoteexecution.v1test.ExecuteResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.google.devtools.remoteexecution.v1test.ExecuteResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.devtools.remoteexecution.v1test.ExecuteResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.google.devtools.remoteexecution.v1test.ExecuteResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.google.devtools.remoteexecution.v1test.ExecuteResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * The response message for
   * [Execution.Execute][google.devtools.remoteexecution.v1test.Execution.Execute],
   * which will be contained in the [response field][google.longrunning.Operation.response] of the
   * [Operation][google.longrunning.Operation].
   * </pre>
   *
   * Protobuf type {@code google.devtools.remoteexecution.v1test.ExecuteResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:google.devtools.remoteexecution.v1test.ExecuteResponse)
      com.google.devtools.remoteexecution.v1test.ExecuteResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.google.devtools.remoteexecution.v1test.RemoteExecutionProto.internal_static_google_devtools_remoteexecution_v1test_ExecuteResponse_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.devtools.remoteexecution.v1test.RemoteExecutionProto.internal_static_google_devtools_remoteexecution_v1test_ExecuteResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.devtools.remoteexecution.v1test.ExecuteResponse.class, com.google.devtools.remoteexecution.v1test.ExecuteResponse.Builder.class);
    }

    // Construct using com.google.devtools.remoteexecution.v1test.ExecuteResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      if (resultBuilder_ == null) {
        result_ = null;
      } else {
        result_ = null;
        resultBuilder_ = null;
      }
      cachedResult_ = false;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.google.devtools.remoteexecution.v1test.RemoteExecutionProto.internal_static_google_devtools_remoteexecution_v1test_ExecuteResponse_descriptor;
    }

    public com.google.devtools.remoteexecution.v1test.ExecuteResponse getDefaultInstanceForType() {
      return com.google.devtools.remoteexecution.v1test.ExecuteResponse.getDefaultInstance();
    }

    public com.google.devtools.remoteexecution.v1test.ExecuteResponse build() {
      com.google.devtools.remoteexecution.v1test.ExecuteResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.google.devtools.remoteexecution.v1test.ExecuteResponse buildPartial() {
      com.google.devtools.remoteexecution.v1test.ExecuteResponse result = new com.google.devtools.remoteexecution.v1test.ExecuteResponse(this);
      if (resultBuilder_ == null) {
        result.result_ = result_;
      } else {
        result.result_ = resultBuilder_.build();
      }
      result.cachedResult_ = cachedResult_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.google.devtools.remoteexecution.v1test.ExecuteResponse) {
        return mergeFrom((com.google.devtools.remoteexecution.v1test.ExecuteResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.devtools.remoteexecution.v1test.ExecuteResponse other) {
      if (other == com.google.devtools.remoteexecution.v1test.ExecuteResponse.getDefaultInstance()) return this;
      if (other.hasResult()) {
        mergeResult(other.getResult());
      }
      if (other.getCachedResult() != false) {
        setCachedResult(other.getCachedResult());
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.google.devtools.remoteexecution.v1test.ExecuteResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.google.devtools.remoteexecution.v1test.ExecuteResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.google.devtools.remoteexecution.v1test.ActionResult result_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.devtools.remoteexecution.v1test.ActionResult, com.google.devtools.remoteexecution.v1test.ActionResult.Builder, com.google.devtools.remoteexecution.v1test.ActionResultOrBuilder> resultBuilder_;
    /**
     * <pre>
     * The result of the action.
     * </pre>
     *
     * <code>.google.devtools.remoteexecution.v1test.ActionResult result = 1;</code>
     */
    public boolean hasResult() {
      return resultBuilder_ != null || result_ != null;
    }
    /**
     * <pre>
     * The result of the action.
     * </pre>
     *
     * <code>.google.devtools.remoteexecution.v1test.ActionResult result = 1;</code>
     */
    public com.google.devtools.remoteexecution.v1test.ActionResult getResult() {
      if (resultBuilder_ == null) {
        return result_ == null ? com.google.devtools.remoteexecution.v1test.ActionResult.getDefaultInstance() : result_;
      } else {
        return resultBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * The result of the action.
     * </pre>
     *
     * <code>.google.devtools.remoteexecution.v1test.ActionResult result = 1;</code>
     */
    public Builder setResult(com.google.devtools.remoteexecution.v1test.ActionResult value) {
      if (resultBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        result_ = value;
        onChanged();
      } else {
        resultBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <pre>
     * The result of the action.
     * </pre>
     *
     * <code>.google.devtools.remoteexecution.v1test.ActionResult result = 1;</code>
     */
    public Builder setResult(
        com.google.devtools.remoteexecution.v1test.ActionResult.Builder builderForValue) {
      if (resultBuilder_ == null) {
        result_ = builderForValue.build();
        onChanged();
      } else {
        resultBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <pre>
     * The result of the action.
     * </pre>
     *
     * <code>.google.devtools.remoteexecution.v1test.ActionResult result = 1;</code>
     */
    public Builder mergeResult(com.google.devtools.remoteexecution.v1test.ActionResult value) {
      if (resultBuilder_ == null) {
        if (result_ != null) {
          result_ =
            com.google.devtools.remoteexecution.v1test.ActionResult.newBuilder(result_).mergeFrom(value).buildPartial();
        } else {
          result_ = value;
        }
        onChanged();
      } else {
        resultBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <pre>
     * The result of the action.
     * </pre>
     *
     * <code>.google.devtools.remoteexecution.v1test.ActionResult result = 1;</code>
     */
    public Builder clearResult() {
      if (resultBuilder_ == null) {
        result_ = null;
        onChanged();
      } else {
        result_ = null;
        resultBuilder_ = null;
      }

      return this;
    }
    /**
     * <pre>
     * The result of the action.
     * </pre>
     *
     * <code>.google.devtools.remoteexecution.v1test.ActionResult result = 1;</code>
     */
    public com.google.devtools.remoteexecution.v1test.ActionResult.Builder getResultBuilder() {
      
      onChanged();
      return getResultFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * The result of the action.
     * </pre>
     *
     * <code>.google.devtools.remoteexecution.v1test.ActionResult result = 1;</code>
     */
    public com.google.devtools.remoteexecution.v1test.ActionResultOrBuilder getResultOrBuilder() {
      if (resultBuilder_ != null) {
        return resultBuilder_.getMessageOrBuilder();
      } else {
        return result_ == null ?
            com.google.devtools.remoteexecution.v1test.ActionResult.getDefaultInstance() : result_;
      }
    }
    /**
     * <pre>
     * The result of the action.
     * </pre>
     *
     * <code>.google.devtools.remoteexecution.v1test.ActionResult result = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.devtools.remoteexecution.v1test.ActionResult, com.google.devtools.remoteexecution.v1test.ActionResult.Builder, com.google.devtools.remoteexecution.v1test.ActionResultOrBuilder> 
        getResultFieldBuilder() {
      if (resultBuilder_ == null) {
        resultBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.devtools.remoteexecution.v1test.ActionResult, com.google.devtools.remoteexecution.v1test.ActionResult.Builder, com.google.devtools.remoteexecution.v1test.ActionResultOrBuilder>(
                getResult(),
                getParentForChildren(),
                isClean());
        result_ = null;
      }
      return resultBuilder_;
    }

    private boolean cachedResult_ ;
    /**
     * <pre>
     * True if the result was served from cache, false if it was executed.
     * </pre>
     *
     * <code>bool cached_result = 2;</code>
     */
    public boolean getCachedResult() {
      return cachedResult_;
    }
    /**
     * <pre>
     * True if the result was served from cache, false if it was executed.
     * </pre>
     *
     * <code>bool cached_result = 2;</code>
     */
    public Builder setCachedResult(boolean value) {
      
      cachedResult_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * True if the result was served from cache, false if it was executed.
     * </pre>
     *
     * <code>bool cached_result = 2;</code>
     */
    public Builder clearCachedResult() {
      
      cachedResult_ = false;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:google.devtools.remoteexecution.v1test.ExecuteResponse)
  }

  // @@protoc_insertion_point(class_scope:google.devtools.remoteexecution.v1test.ExecuteResponse)
  private static final com.google.devtools.remoteexecution.v1test.ExecuteResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.google.devtools.remoteexecution.v1test.ExecuteResponse();
  }

  public static com.google.devtools.remoteexecution.v1test.ExecuteResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ExecuteResponse>
      PARSER = new com.google.protobuf.AbstractParser<ExecuteResponse>() {
    public ExecuteResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new ExecuteResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ExecuteResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ExecuteResponse> getParserForType() {
    return PARSER;
  }

  public com.google.devtools.remoteexecution.v1test.ExecuteResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
