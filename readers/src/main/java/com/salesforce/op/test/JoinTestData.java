/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.salesforce.op.test;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class JoinTestData extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"JoinTestData\",\"namespace\":\"com.salesforce.op.test\",\"fields\":[{\"name\":\"sparkId\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"timestamp\",\"type\":[\"long\",\"null\"]},{\"name\":\"description\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"]},{\"name\":\"id\",\"type\":[\"double\",\"null\"]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.String sparkId;
  @Deprecated public java.lang.Long timestamp;
  @Deprecated public java.lang.String description;
  @Deprecated public java.lang.Double id;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public JoinTestData() {}

  /**
   * All-args constructor.
   */
  public JoinTestData(java.lang.String sparkId, java.lang.Long timestamp, java.lang.String description, java.lang.Double id) {
    this.sparkId = sparkId;
    this.timestamp = timestamp;
    this.description = description;
    this.id = id;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return sparkId;
    case 1: return timestamp;
    case 2: return description;
    case 3: return id;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: sparkId = (java.lang.String)value$; break;
    case 1: timestamp = (java.lang.Long)value$; break;
    case 2: description = (java.lang.String)value$; break;
    case 3: id = (java.lang.Double)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'sparkId' field.
   */
  public java.lang.String getSparkId() {
    return sparkId;
  }

  /**
   * Sets the value of the 'sparkId' field.
   * @param value the value to set.
   */
  public void setSparkId(java.lang.String value) {
    this.sparkId = value;
  }

  /**
   * Gets the value of the 'timestamp' field.
   */
  public java.lang.Long getTimestamp() {
    return timestamp;
  }

  /**
   * Sets the value of the 'timestamp' field.
   * @param value the value to set.
   */
  public void setTimestamp(java.lang.Long value) {
    this.timestamp = value;
  }

  /**
   * Gets the value of the 'description' field.
   */
  public java.lang.String getDescription() {
    return description;
  }

  /**
   * Sets the value of the 'description' field.
   * @param value the value to set.
   */
  public void setDescription(java.lang.String value) {
    this.description = value;
  }

  /**
   * Gets the value of the 'id' field.
   */
  public java.lang.Double getId() {
    return id;
  }

  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.Double value) {
    this.id = value;
  }

  /** Creates a new JoinTestData RecordBuilder */
  public static com.salesforce.op.test.JoinTestData.Builder newBuilder() {
    return new com.salesforce.op.test.JoinTestData.Builder();
  }
  
  /** Creates a new JoinTestData RecordBuilder by copying an existing Builder */
  public static com.salesforce.op.test.JoinTestData.Builder newBuilder(com.salesforce.op.test.JoinTestData.Builder other) {
    return new com.salesforce.op.test.JoinTestData.Builder(other);
  }
  
  /** Creates a new JoinTestData RecordBuilder by copying an existing JoinTestData instance */
  public static com.salesforce.op.test.JoinTestData.Builder newBuilder(com.salesforce.op.test.JoinTestData other) {
    return new com.salesforce.op.test.JoinTestData.Builder(other);
  }
  
  /**
   * RecordBuilder for JoinTestData instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<JoinTestData>
    implements org.apache.avro.data.RecordBuilder<JoinTestData> {

    private java.lang.String sparkId;
    private java.lang.Long timestamp;
    private java.lang.String description;
    private java.lang.Double id;

    /** Creates a new Builder */
    private Builder() {
      super(com.salesforce.op.test.JoinTestData.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.salesforce.op.test.JoinTestData.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.sparkId)) {
        this.sparkId = data().deepCopy(fields()[0].schema(), other.sparkId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[1].schema(), other.timestamp);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.description)) {
        this.description = data().deepCopy(fields()[2].schema(), other.description);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.id)) {
        this.id = data().deepCopy(fields()[3].schema(), other.id);
        fieldSetFlags()[3] = true;
      }
    }
    
    /** Creates a Builder by copying an existing JoinTestData instance */
    private Builder(com.salesforce.op.test.JoinTestData other) {
            super(com.salesforce.op.test.JoinTestData.SCHEMA$);
      if (isValidValue(fields()[0], other.sparkId)) {
        this.sparkId = data().deepCopy(fields()[0].schema(), other.sparkId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[1].schema(), other.timestamp);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.description)) {
        this.description = data().deepCopy(fields()[2].schema(), other.description);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.id)) {
        this.id = data().deepCopy(fields()[3].schema(), other.id);
        fieldSetFlags()[3] = true;
      }
    }

    /** Gets the value of the 'sparkId' field */
    public java.lang.String getSparkId() {
      return sparkId;
    }
    
    /** Sets the value of the 'sparkId' field */
    public com.salesforce.op.test.JoinTestData.Builder setSparkId(java.lang.String value) {
      validate(fields()[0], value);
      this.sparkId = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'sparkId' field has been set */
    public boolean hasSparkId() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'sparkId' field */
    public com.salesforce.op.test.JoinTestData.Builder clearSparkId() {
      sparkId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'timestamp' field */
    public java.lang.Long getTimestamp() {
      return timestamp;
    }
    
    /** Sets the value of the 'timestamp' field */
    public com.salesforce.op.test.JoinTestData.Builder setTimestamp(java.lang.Long value) {
      validate(fields()[1], value);
      this.timestamp = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'timestamp' field has been set */
    public boolean hasTimestamp() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'timestamp' field */
    public com.salesforce.op.test.JoinTestData.Builder clearTimestamp() {
      timestamp = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'description' field */
    public java.lang.String getDescription() {
      return description;
    }
    
    /** Sets the value of the 'description' field */
    public com.salesforce.op.test.JoinTestData.Builder setDescription(java.lang.String value) {
      validate(fields()[2], value);
      this.description = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'description' field has been set */
    public boolean hasDescription() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'description' field */
    public com.salesforce.op.test.JoinTestData.Builder clearDescription() {
      description = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'id' field */
    public java.lang.Double getId() {
      return id;
    }
    
    /** Sets the value of the 'id' field */
    public com.salesforce.op.test.JoinTestData.Builder setId(java.lang.Double value) {
      validate(fields()[3], value);
      this.id = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'id' field has been set */
    public boolean hasId() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'id' field */
    public com.salesforce.op.test.JoinTestData.Builder clearId() {
      id = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    public JoinTestData build() {
      try {
        JoinTestData record = new JoinTestData();
        record.sparkId = fieldSetFlags()[0] ? this.sparkId : (java.lang.String) defaultValue(fields()[0]);
        record.timestamp = fieldSetFlags()[1] ? this.timestamp : (java.lang.Long) defaultValue(fields()[1]);
        record.description = fieldSetFlags()[2] ? this.description : (java.lang.String) defaultValue(fields()[2]);
        record.id = fieldSetFlags()[3] ? this.id : (java.lang.Double) defaultValue(fields()[3]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
