// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: app_base.proto

package moonbox.protocol.protobuf;

/**
 * Protobuf type {@code moonbox.ExecutionRequestPB}
 */
public  final class ExecutionRequestPB extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:moonbox.ExecutionRequestPB)
    ExecutionRequestPBOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ExecutionRequestPB.newBuilder() to construct.
  private ExecutionRequestPB(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ExecutionRequestPB() {
    sessionId_ = "";
    sqls_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    fetchSize_ = 0;
    maxRows_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ExecutionRequestPB(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            sessionId_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();
            if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
              sqls_ = new com.google.protobuf.LazyStringArrayList();
              mutable_bitField0_ |= 0x00000002;
            }
            sqls_.add(s);
            break;
          }
          case 24: {

            fetchSize_ = input.readInt32();
            break;
          }
          case 32: {

            maxRows_ = input.readInt32();
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
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
      if (((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
        sqls_ = sqls_.getUnmodifiableView();
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return moonbox.protocol.protobuf.AppBase.internal_static_moonbox_ExecutionRequestPB_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return moonbox.protocol.protobuf.AppBase.internal_static_moonbox_ExecutionRequestPB_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            moonbox.protocol.protobuf.ExecutionRequestPB.class, moonbox.protocol.protobuf.ExecutionRequestPB.Builder.class);
  }

  private int bitField0_;
  public static final int SESSION_ID_FIELD_NUMBER = 1;
  private volatile java.lang.Object sessionId_;
  /**
   * <code>string session_id = 1;</code>
   */
  public java.lang.String getSessionId() {
    java.lang.Object ref = sessionId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      sessionId_ = s;
      return s;
    }
  }
  /**
   * <code>string session_id = 1;</code>
   */
  public com.google.protobuf.ByteString
      getSessionIdBytes() {
    java.lang.Object ref = sessionId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      sessionId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SQLS_FIELD_NUMBER = 2;
  private com.google.protobuf.LazyStringList sqls_;
  /**
   * <code>repeated string sqls = 2;</code>
   */
  public com.google.protobuf.ProtocolStringList
      getSqlsList() {
    return sqls_;
  }
  /**
   * <code>repeated string sqls = 2;</code>
   */
  public int getSqlsCount() {
    return sqls_.size();
  }
  /**
   * <code>repeated string sqls = 2;</code>
   */
  public java.lang.String getSqls(int index) {
    return sqls_.get(index);
  }
  /**
   * <code>repeated string sqls = 2;</code>
   */
  public com.google.protobuf.ByteString
      getSqlsBytes(int index) {
    return sqls_.getByteString(index);
  }

  public static final int FETCH_SIZE_FIELD_NUMBER = 3;
  private int fetchSize_;
  /**
   * <code>int32 fetch_size = 3;</code>
   */
  public int getFetchSize() {
    return fetchSize_;
  }

  public static final int MAX_ROWS_FIELD_NUMBER = 4;
  private int maxRows_;
  /**
   * <code>int32 max_rows = 4;</code>
   */
  public int getMaxRows() {
    return maxRows_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getSessionIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, sessionId_);
    }
    for (int i = 0; i < sqls_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, sqls_.getRaw(i));
    }
    if (fetchSize_ != 0) {
      output.writeInt32(3, fetchSize_);
    }
    if (maxRows_ != 0) {
      output.writeInt32(4, maxRows_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getSessionIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, sessionId_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < sqls_.size(); i++) {
        dataSize += computeStringSizeNoTag(sqls_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getSqlsList().size();
    }
    if (fetchSize_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, fetchSize_);
    }
    if (maxRows_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, maxRows_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof moonbox.protocol.protobuf.ExecutionRequestPB)) {
      return super.equals(obj);
    }
    moonbox.protocol.protobuf.ExecutionRequestPB other = (moonbox.protocol.protobuf.ExecutionRequestPB) obj;

    boolean result = true;
    result = result && getSessionId()
        .equals(other.getSessionId());
    result = result && getSqlsList()
        .equals(other.getSqlsList());
    result = result && (getFetchSize()
        == other.getFetchSize());
    result = result && (getMaxRows()
        == other.getMaxRows());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + SESSION_ID_FIELD_NUMBER;
    hash = (53 * hash) + getSessionId().hashCode();
    if (getSqlsCount() > 0) {
      hash = (37 * hash) + SQLS_FIELD_NUMBER;
      hash = (53 * hash) + getSqlsList().hashCode();
    }
    hash = (37 * hash) + FETCH_SIZE_FIELD_NUMBER;
    hash = (53 * hash) + getFetchSize();
    hash = (37 * hash) + MAX_ROWS_FIELD_NUMBER;
    hash = (53 * hash) + getMaxRows();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static moonbox.protocol.protobuf.ExecutionRequestPB parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static moonbox.protocol.protobuf.ExecutionRequestPB parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static moonbox.protocol.protobuf.ExecutionRequestPB parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static moonbox.protocol.protobuf.ExecutionRequestPB parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static moonbox.protocol.protobuf.ExecutionRequestPB parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static moonbox.protocol.protobuf.ExecutionRequestPB parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static moonbox.protocol.protobuf.ExecutionRequestPB parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static moonbox.protocol.protobuf.ExecutionRequestPB parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static moonbox.protocol.protobuf.ExecutionRequestPB parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static moonbox.protocol.protobuf.ExecutionRequestPB parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static moonbox.protocol.protobuf.ExecutionRequestPB parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static moonbox.protocol.protobuf.ExecutionRequestPB parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(moonbox.protocol.protobuf.ExecutionRequestPB prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
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
   * Protobuf type {@code moonbox.ExecutionRequestPB}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:moonbox.ExecutionRequestPB)
      moonbox.protocol.protobuf.ExecutionRequestPBOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return moonbox.protocol.protobuf.AppBase.internal_static_moonbox_ExecutionRequestPB_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return moonbox.protocol.protobuf.AppBase.internal_static_moonbox_ExecutionRequestPB_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              moonbox.protocol.protobuf.ExecutionRequestPB.class, moonbox.protocol.protobuf.ExecutionRequestPB.Builder.class);
    }

    // Construct using moonbox.protocol.protobuf.ExecutionRequestPB.newBuilder()
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
    @java.lang.Override
    public Builder clear() {
      super.clear();
      sessionId_ = "";

      sqls_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000002);
      fetchSize_ = 0;

      maxRows_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return moonbox.protocol.protobuf.AppBase.internal_static_moonbox_ExecutionRequestPB_descriptor;
    }

    @java.lang.Override
    public moonbox.protocol.protobuf.ExecutionRequestPB getDefaultInstanceForType() {
      return moonbox.protocol.protobuf.ExecutionRequestPB.getDefaultInstance();
    }

    @java.lang.Override
    public moonbox.protocol.protobuf.ExecutionRequestPB build() {
      moonbox.protocol.protobuf.ExecutionRequestPB result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public moonbox.protocol.protobuf.ExecutionRequestPB buildPartial() {
      moonbox.protocol.protobuf.ExecutionRequestPB result = new moonbox.protocol.protobuf.ExecutionRequestPB(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.sessionId_ = sessionId_;
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        sqls_ = sqls_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000002);
      }
      result.sqls_ = sqls_;
      result.fetchSize_ = fetchSize_;
      result.maxRows_ = maxRows_;
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof moonbox.protocol.protobuf.ExecutionRequestPB) {
        return mergeFrom((moonbox.protocol.protobuf.ExecutionRequestPB)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(moonbox.protocol.protobuf.ExecutionRequestPB other) {
      if (other == moonbox.protocol.protobuf.ExecutionRequestPB.getDefaultInstance()) return this;
      if (!other.getSessionId().isEmpty()) {
        sessionId_ = other.sessionId_;
        onChanged();
      }
      if (!other.sqls_.isEmpty()) {
        if (sqls_.isEmpty()) {
          sqls_ = other.sqls_;
          bitField0_ = (bitField0_ & ~0x00000002);
        } else {
          ensureSqlsIsMutable();
          sqls_.addAll(other.sqls_);
        }
        onChanged();
      }
      if (other.getFetchSize() != 0) {
        setFetchSize(other.getFetchSize());
      }
      if (other.getMaxRows() != 0) {
        setMaxRows(other.getMaxRows());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      moonbox.protocol.protobuf.ExecutionRequestPB parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (moonbox.protocol.protobuf.ExecutionRequestPB) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object sessionId_ = "";
    /**
     * <code>string session_id = 1;</code>
     */
    public java.lang.String getSessionId() {
      java.lang.Object ref = sessionId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        sessionId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string session_id = 1;</code>
     */
    public com.google.protobuf.ByteString
        getSessionIdBytes() {
      java.lang.Object ref = sessionId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        sessionId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string session_id = 1;</code>
     */
    public Builder setSessionId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      sessionId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string session_id = 1;</code>
     */
    public Builder clearSessionId() {
      
      sessionId_ = getDefaultInstance().getSessionId();
      onChanged();
      return this;
    }
    /**
     * <code>string session_id = 1;</code>
     */
    public Builder setSessionIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      sessionId_ = value;
      onChanged();
      return this;
    }

    private com.google.protobuf.LazyStringList sqls_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureSqlsIsMutable() {
      if (!((bitField0_ & 0x00000002) == 0x00000002)) {
        sqls_ = new com.google.protobuf.LazyStringArrayList(sqls_);
        bitField0_ |= 0x00000002;
       }
    }
    /**
     * <code>repeated string sqls = 2;</code>
     */
    public com.google.protobuf.ProtocolStringList
        getSqlsList() {
      return sqls_.getUnmodifiableView();
    }
    /**
     * <code>repeated string sqls = 2;</code>
     */
    public int getSqlsCount() {
      return sqls_.size();
    }
    /**
     * <code>repeated string sqls = 2;</code>
     */
    public java.lang.String getSqls(int index) {
      return sqls_.get(index);
    }
    /**
     * <code>repeated string sqls = 2;</code>
     */
    public com.google.protobuf.ByteString
        getSqlsBytes(int index) {
      return sqls_.getByteString(index);
    }
    /**
     * <code>repeated string sqls = 2;</code>
     */
    public Builder setSqls(
        int index, java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureSqlsIsMutable();
      sqls_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string sqls = 2;</code>
     */
    public Builder addSqls(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureSqlsIsMutable();
      sqls_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string sqls = 2;</code>
     */
    public Builder addAllSqls(
        java.lang.Iterable<java.lang.String> values) {
      ensureSqlsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, sqls_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string sqls = 2;</code>
     */
    public Builder clearSqls() {
      sqls_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string sqls = 2;</code>
     */
    public Builder addSqlsBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensureSqlsIsMutable();
      sqls_.add(value);
      onChanged();
      return this;
    }

    private int fetchSize_ ;
    /**
     * <code>int32 fetch_size = 3;</code>
     */
    public int getFetchSize() {
      return fetchSize_;
    }
    /**
     * <code>int32 fetch_size = 3;</code>
     */
    public Builder setFetchSize(int value) {
      
      fetchSize_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 fetch_size = 3;</code>
     */
    public Builder clearFetchSize() {
      
      fetchSize_ = 0;
      onChanged();
      return this;
    }

    private int maxRows_ ;
    /**
     * <code>int32 max_rows = 4;</code>
     */
    public int getMaxRows() {
      return maxRows_;
    }
    /**
     * <code>int32 max_rows = 4;</code>
     */
    public Builder setMaxRows(int value) {
      
      maxRows_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 max_rows = 4;</code>
     */
    public Builder clearMaxRows() {
      
      maxRows_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:moonbox.ExecutionRequestPB)
  }

  // @@protoc_insertion_point(class_scope:moonbox.ExecutionRequestPB)
  private static final moonbox.protocol.protobuf.ExecutionRequestPB DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new moonbox.protocol.protobuf.ExecutionRequestPB();
  }

  public static moonbox.protocol.protobuf.ExecutionRequestPB getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ExecutionRequestPB>
      PARSER = new com.google.protobuf.AbstractParser<ExecutionRequestPB>() {
    @java.lang.Override
    public ExecutionRequestPB parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ExecutionRequestPB(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ExecutionRequestPB> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ExecutionRequestPB> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public moonbox.protocol.protobuf.ExecutionRequestPB getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

