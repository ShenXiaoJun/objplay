// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/devtools/remoteexecution/v1test/remote_execution.proto

package com.google.devtools.remoteexecution.v1test;

/**
 * <pre>
 * A single request message for
 * [ContentAddressableStorage.BatchUpdateBlobs][google.devtools.remoteexecution.v1test.ContentAddressableStorage.BatchUpdateBlobs].
 * </pre>
 *
 * Protobuf type {@code google.devtools.remoteexecution.v1test.UpdateBlobRequest}
 */
public  final class UpdateBlobRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:google.devtools.remoteexecution.v1test.UpdateBlobRequest)
    UpdateBlobRequestOrBuilder {
  // Use UpdateBlobRequest.newBuilder() to construct.
  private UpdateBlobRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UpdateBlobRequest() {
    data_ = com.google.protobuf.ByteString.EMPTY;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private UpdateBlobRequest(
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
            com.google.devtools.remoteexecution.v1test.Digest.Builder subBuilder = null;
            if (contentDigest_ != null) {
              subBuilder = contentDigest_.toBuilder();
            }
            contentDigest_ = input.readMessage(com.google.devtools.remoteexecution.v1test.Digest.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(contentDigest_);
              contentDigest_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {

            data_ = input.readBytes();
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
    return com.google.devtools.remoteexecution.v1test.RemoteExecutionProto.internal_static_google_devtools_remoteexecution_v1test_UpdateBlobRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.devtools.remoteexecution.v1test.RemoteExecutionProto.internal_static_google_devtools_remoteexecution_v1test_UpdateBlobRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.devtools.remoteexecution.v1test.UpdateBlobRequest.class, com.google.devtools.remoteexecution.v1test.UpdateBlobRequest.Builder.class);
  }

  public static final int CONTENT_DIGEST_FIELD_NUMBER = 1;
  private com.google.devtools.remoteexecution.v1test.Digest contentDigest_;
  /**
   * <pre>
   * The digest of the blob. This MUST be the digest of `data`.
   * </pre>
   *
   * <code>.google.devtools.remoteexecution.v1test.Digest content_digest = 1;</code>
   */
  public boolean hasContentDigest() {
    return contentDigest_ != null;
  }
  /**
   * <pre>
   * The digest of the blob. This MUST be the digest of `data`.
   * </pre>
   *
   * <code>.google.devtools.remoteexecution.v1test.Digest content_digest = 1;</code>
   */
  public com.google.devtools.remoteexecution.v1test.Digest getContentDigest() {
    return contentDigest_ == null ? com.google.devtools.remoteexecution.v1test.Digest.getDefaultInstance() : contentDigest_;
  }
  /**
   * <pre>
   * The digest of the blob. This MUST be the digest of `data`.
   * </pre>
   *
   * <code>.google.devtools.remoteexecution.v1test.Digest content_digest = 1;</code>
   */
  public com.google.devtools.remoteexecution.v1test.DigestOrBuilder getContentDigestOrBuilder() {
    return getContentDigest();
  }

  public static final int DATA_FIELD_NUMBER = 2;
  private com.google.protobuf.ByteString data_;
  /**
   * <pre>
   * The raw binary data.
   * </pre>
   *
   * <code>bytes data = 2;</code>
   */
  public com.google.protobuf.ByteString getData() {
    return data_;
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
    if (contentDigest_ != null) {
      output.writeMessage(1, getContentDigest());
    }
    if (!data_.isEmpty()) {
      output.writeBytes(2, data_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (contentDigest_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getContentDigest());
    }
    if (!data_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(2, data_);
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
    if (!(obj instanceof com.google.devtools.remoteexecution.v1test.UpdateBlobRequest)) {
      return super.equals(obj);
    }
    com.google.devtools.remoteexecution.v1test.UpdateBlobRequest other = (com.google.devtools.remoteexecution.v1test.UpdateBlobRequest) obj;

    boolean result = true;
    result = result && (hasContentDigest() == other.hasContentDigest());
    if (hasContentDigest()) {
      result = result && getContentDigest()
          .equals(other.getContentDigest());
    }
    result = result && getData()
        .equals(other.getData());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasContentDigest()) {
      hash = (37 * hash) + CONTENT_DIGEST_FIELD_NUMBER;
      hash = (53 * hash) + getContentDigest().hashCode();
    }
    hash = (37 * hash) + DATA_FIELD_NUMBER;
    hash = (53 * hash) + getData().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.devtools.remoteexecution.v1test.UpdateBlobRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.devtools.remoteexecution.v1test.UpdateBlobRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.devtools.remoteexecution.v1test.UpdateBlobRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.devtools.remoteexecution.v1test.UpdateBlobRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.devtools.remoteexecution.v1test.UpdateBlobRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.devtools.remoteexecution.v1test.UpdateBlobRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.devtools.remoteexecution.v1test.UpdateBlobRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.google.devtools.remoteexecution.v1test.UpdateBlobRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.devtools.remoteexecution.v1test.UpdateBlobRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.google.devtools.remoteexecution.v1test.UpdateBlobRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.devtools.remoteexecution.v1test.UpdateBlobRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.google.devtools.remoteexecution.v1test.UpdateBlobRequest parseFrom(
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
  public static Builder newBuilder(com.google.devtools.remoteexecution.v1test.UpdateBlobRequest prototype) {
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
   * A single request message for
   * [ContentAddressableStorage.BatchUpdateBlobs][google.devtools.remoteexecution.v1test.ContentAddressableStorage.BatchUpdateBlobs].
   * </pre>
   *
   * Protobuf type {@code google.devtools.remoteexecution.v1test.UpdateBlobRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:google.devtools.remoteexecution.v1test.UpdateBlobRequest)
      com.google.devtools.remoteexecution.v1test.UpdateBlobRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.google.devtools.remoteexecution.v1test.RemoteExecutionProto.internal_static_google_devtools_remoteexecution_v1test_UpdateBlobRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.devtools.remoteexecution.v1test.RemoteExecutionProto.internal_static_google_devtools_remoteexecution_v1test_UpdateBlobRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.devtools.remoteexecution.v1test.UpdateBlobRequest.class, com.google.devtools.remoteexecution.v1test.UpdateBlobRequest.Builder.class);
    }

    // Construct using com.google.devtools.remoteexecution.v1test.UpdateBlobRequest.newBuilder()
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
      if (contentDigestBuilder_ == null) {
        contentDigest_ = null;
      } else {
        contentDigest_ = null;
        contentDigestBuilder_ = null;
      }
      data_ = com.google.protobuf.ByteString.EMPTY;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.google.devtools.remoteexecution.v1test.RemoteExecutionProto.internal_static_google_devtools_remoteexecution_v1test_UpdateBlobRequest_descriptor;
    }

    public com.google.devtools.remoteexecution.v1test.UpdateBlobRequest getDefaultInstanceForType() {
      return com.google.devtools.remoteexecution.v1test.UpdateBlobRequest.getDefaultInstance();
    }

    public com.google.devtools.remoteexecution.v1test.UpdateBlobRequest build() {
      com.google.devtools.remoteexecution.v1test.UpdateBlobRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.google.devtools.remoteexecution.v1test.UpdateBlobRequest buildPartial() {
      com.google.devtools.remoteexecution.v1test.UpdateBlobRequest result = new com.google.devtools.remoteexecution.v1test.UpdateBlobRequest(this);
      if (contentDigestBuilder_ == null) {
        result.contentDigest_ = contentDigest_;
      } else {
        result.contentDigest_ = contentDigestBuilder_.build();
      }
      result.data_ = data_;
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
      if (other instanceof com.google.devtools.remoteexecution.v1test.UpdateBlobRequest) {
        return mergeFrom((com.google.devtools.remoteexecution.v1test.UpdateBlobRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.devtools.remoteexecution.v1test.UpdateBlobRequest other) {
      if (other == com.google.devtools.remoteexecution.v1test.UpdateBlobRequest.getDefaultInstance()) return this;
      if (other.hasContentDigest()) {
        mergeContentDigest(other.getContentDigest());
      }
      if (other.getData() != com.google.protobuf.ByteString.EMPTY) {
        setData(other.getData());
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
      com.google.devtools.remoteexecution.v1test.UpdateBlobRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.google.devtools.remoteexecution.v1test.UpdateBlobRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.google.devtools.remoteexecution.v1test.Digest contentDigest_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.devtools.remoteexecution.v1test.Digest, com.google.devtools.remoteexecution.v1test.Digest.Builder, com.google.devtools.remoteexecution.v1test.DigestOrBuilder> contentDigestBuilder_;
    /**
     * <pre>
     * The digest of the blob. This MUST be the digest of `data`.
     * </pre>
     *
     * <code>.google.devtools.remoteexecution.v1test.Digest content_digest = 1;</code>
     */
    public boolean hasContentDigest() {
      return contentDigestBuilder_ != null || contentDigest_ != null;
    }
    /**
     * <pre>
     * The digest of the blob. This MUST be the digest of `data`.
     * </pre>
     *
     * <code>.google.devtools.remoteexecution.v1test.Digest content_digest = 1;</code>
     */
    public com.google.devtools.remoteexecution.v1test.Digest getContentDigest() {
      if (contentDigestBuilder_ == null) {
        return contentDigest_ == null ? com.google.devtools.remoteexecution.v1test.Digest.getDefaultInstance() : contentDigest_;
      } else {
        return contentDigestBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * The digest of the blob. This MUST be the digest of `data`.
     * </pre>
     *
     * <code>.google.devtools.remoteexecution.v1test.Digest content_digest = 1;</code>
     */
    public Builder setContentDigest(com.google.devtools.remoteexecution.v1test.Digest value) {
      if (contentDigestBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        contentDigest_ = value;
        onChanged();
      } else {
        contentDigestBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <pre>
     * The digest of the blob. This MUST be the digest of `data`.
     * </pre>
     *
     * <code>.google.devtools.remoteexecution.v1test.Digest content_digest = 1;</code>
     */
    public Builder setContentDigest(
        com.google.devtools.remoteexecution.v1test.Digest.Builder builderForValue) {
      if (contentDigestBuilder_ == null) {
        contentDigest_ = builderForValue.build();
        onChanged();
      } else {
        contentDigestBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <pre>
     * The digest of the blob. This MUST be the digest of `data`.
     * </pre>
     *
     * <code>.google.devtools.remoteexecution.v1test.Digest content_digest = 1;</code>
     */
    public Builder mergeContentDigest(com.google.devtools.remoteexecution.v1test.Digest value) {
      if (contentDigestBuilder_ == null) {
        if (contentDigest_ != null) {
          contentDigest_ =
            com.google.devtools.remoteexecution.v1test.Digest.newBuilder(contentDigest_).mergeFrom(value).buildPartial();
        } else {
          contentDigest_ = value;
        }
        onChanged();
      } else {
        contentDigestBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <pre>
     * The digest of the blob. This MUST be the digest of `data`.
     * </pre>
     *
     * <code>.google.devtools.remoteexecution.v1test.Digest content_digest = 1;</code>
     */
    public Builder clearContentDigest() {
      if (contentDigestBuilder_ == null) {
        contentDigest_ = null;
        onChanged();
      } else {
        contentDigest_ = null;
        contentDigestBuilder_ = null;
      }

      return this;
    }
    /**
     * <pre>
     * The digest of the blob. This MUST be the digest of `data`.
     * </pre>
     *
     * <code>.google.devtools.remoteexecution.v1test.Digest content_digest = 1;</code>
     */
    public com.google.devtools.remoteexecution.v1test.Digest.Builder getContentDigestBuilder() {
      
      onChanged();
      return getContentDigestFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * The digest of the blob. This MUST be the digest of `data`.
     * </pre>
     *
     * <code>.google.devtools.remoteexecution.v1test.Digest content_digest = 1;</code>
     */
    public com.google.devtools.remoteexecution.v1test.DigestOrBuilder getContentDigestOrBuilder() {
      if (contentDigestBuilder_ != null) {
        return contentDigestBuilder_.getMessageOrBuilder();
      } else {
        return contentDigest_ == null ?
            com.google.devtools.remoteexecution.v1test.Digest.getDefaultInstance() : contentDigest_;
      }
    }
    /**
     * <pre>
     * The digest of the blob. This MUST be the digest of `data`.
     * </pre>
     *
     * <code>.google.devtools.remoteexecution.v1test.Digest content_digest = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.devtools.remoteexecution.v1test.Digest, com.google.devtools.remoteexecution.v1test.Digest.Builder, com.google.devtools.remoteexecution.v1test.DigestOrBuilder> 
        getContentDigestFieldBuilder() {
      if (contentDigestBuilder_ == null) {
        contentDigestBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.devtools.remoteexecution.v1test.Digest, com.google.devtools.remoteexecution.v1test.Digest.Builder, com.google.devtools.remoteexecution.v1test.DigestOrBuilder>(
                getContentDigest(),
                getParentForChildren(),
                isClean());
        contentDigest_ = null;
      }
      return contentDigestBuilder_;
    }

    private com.google.protobuf.ByteString data_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <pre>
     * The raw binary data.
     * </pre>
     *
     * <code>bytes data = 2;</code>
     */
    public com.google.protobuf.ByteString getData() {
      return data_;
    }
    /**
     * <pre>
     * The raw binary data.
     * </pre>
     *
     * <code>bytes data = 2;</code>
     */
    public Builder setData(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      data_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * The raw binary data.
     * </pre>
     *
     * <code>bytes data = 2;</code>
     */
    public Builder clearData() {
      
      data_ = getDefaultInstance().getData();
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


    // @@protoc_insertion_point(builder_scope:google.devtools.remoteexecution.v1test.UpdateBlobRequest)
  }

  // @@protoc_insertion_point(class_scope:google.devtools.remoteexecution.v1test.UpdateBlobRequest)
  private static final com.google.devtools.remoteexecution.v1test.UpdateBlobRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.google.devtools.remoteexecution.v1test.UpdateBlobRequest();
  }

  public static com.google.devtools.remoteexecution.v1test.UpdateBlobRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UpdateBlobRequest>
      PARSER = new com.google.protobuf.AbstractParser<UpdateBlobRequest>() {
    public UpdateBlobRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new UpdateBlobRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UpdateBlobRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UpdateBlobRequest> getParserForType() {
    return PARSER;
  }

  public com.google.devtools.remoteexecution.v1test.UpdateBlobRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
