/**
 * Autogenerated by Thrift Compiler (0.12.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.microsoft.thrifty.test.gen;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})

public class UnionWithDefault extends org.apache.thrift.TUnion<UnionWithDefault, UnionWithDefault._Fields> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("UnionWithDefault");
  private static final org.apache.thrift.protocol.TField TEXT_FIELD_DESC = new org.apache.thrift.protocol.TField("Text", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField INT_FIELD_DESC = new org.apache.thrift.protocol.TField("Int", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField REAL_FIELD_DESC = new org.apache.thrift.protocol.TField("Real", org.apache.thrift.protocol.TType.DOUBLE, (short)3);

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TEXT((short)1, "Text"),
    INT((short)2, "Int"),
    REAL((short)3, "Real");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // TEXT
          return TEXT;
        case 2: // INT
          return INT;
        case 3: // REAL
          return REAL;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TEXT, new org.apache.thrift.meta_data.FieldMetaData("Text", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.INT, new org.apache.thrift.meta_data.FieldMetaData("Int", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.REAL, new org.apache.thrift.meta_data.FieldMetaData("Real", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(UnionWithDefault.class, metaDataMap);
  }

  public UnionWithDefault() {
    super(_Fields.REAL, 3.1400000000000001);
  }

  public UnionWithDefault(_Fields setField, java.lang.Object value) {
    super(setField, value);
  }

  public UnionWithDefault(UnionWithDefault other) {
    super(other);
  }
  public UnionWithDefault deepCopy() {
    return new UnionWithDefault(this);
  }

  public static UnionWithDefault Text(java.lang.String value) {
    UnionWithDefault x = new UnionWithDefault();
    x.setText(value);
    return x;
  }

  public static UnionWithDefault Int(int value) {
    UnionWithDefault x = new UnionWithDefault();
    x.setInt(value);
    return x;
  }

  public static UnionWithDefault Real(double value) {
    UnionWithDefault x = new UnionWithDefault();
    x.setReal(value);
    return x;
  }


  @Override
  protected void checkType(_Fields setField, java.lang.Object value) throws java.lang.ClassCastException {
    switch (setField) {
      case TEXT:
        if (value instanceof java.lang.String) {
          break;
        }
        throw new java.lang.ClassCastException("Was expecting value of type java.lang.String for field 'Text', but got " + value.getClass().getSimpleName());
      case INT:
        if (value instanceof java.lang.Integer) {
          break;
        }
        throw new java.lang.ClassCastException("Was expecting value of type java.lang.Integer for field 'Int', but got " + value.getClass().getSimpleName());
      case REAL:
        if (value instanceof java.lang.Double) {
          break;
        }
        throw new java.lang.ClassCastException("Was expecting value of type java.lang.Double for field 'Real', but got " + value.getClass().getSimpleName());
      default:
        throw new java.lang.IllegalArgumentException("Unknown field id " + setField);
    }
  }

  @Override
  protected java.lang.Object standardSchemeReadValue(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TField field) throws org.apache.thrift.TException {
    _Fields setField = _Fields.findByThriftId(field.id);
    if (setField != null) {
      switch (setField) {
        case TEXT:
          if (field.type == TEXT_FIELD_DESC.type) {
            java.lang.String Text;
            Text = iprot.readString();
            return Text;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case INT:
          if (field.type == INT_FIELD_DESC.type) {
            java.lang.Integer Int;
            Int = iprot.readI32();
            return Int;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case REAL:
          if (field.type == REAL_FIELD_DESC.type) {
            java.lang.Double Real;
            Real = iprot.readDouble();
            return Real;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        default:
          throw new java.lang.IllegalStateException("setField wasn't null, but didn't match any of the case statements!");
      }
    } else {
      org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
      return null;
    }
  }

  @Override
  protected void standardSchemeWriteValue(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    switch (setField_) {
      case TEXT:
        java.lang.String Text = (java.lang.String)value_;
        oprot.writeString(Text);
        return;
      case INT:
        java.lang.Integer Int = (java.lang.Integer)value_;
        oprot.writeI32(Int);
        return;
      case REAL:
        java.lang.Double Real = (java.lang.Double)value_;
        oprot.writeDouble(Real);
        return;
      default:
        throw new java.lang.IllegalStateException("Cannot write union with unknown field " + setField_);
    }
  }

  @Override
  protected java.lang.Object tupleSchemeReadValue(org.apache.thrift.protocol.TProtocol iprot, short fieldID) throws org.apache.thrift.TException {
    _Fields setField = _Fields.findByThriftId(fieldID);
    if (setField != null) {
      switch (setField) {
        case TEXT:
          java.lang.String Text;
          Text = iprot.readString();
          return Text;
        case INT:
          java.lang.Integer Int;
          Int = iprot.readI32();
          return Int;
        case REAL:
          java.lang.Double Real;
          Real = iprot.readDouble();
          return Real;
        default:
          throw new java.lang.IllegalStateException("setField wasn't null, but didn't match any of the case statements!");
      }
    } else {
      throw new org.apache.thrift.protocol.TProtocolException("Couldn't find a field with field id " + fieldID);
    }
  }

  @Override
  protected void tupleSchemeWriteValue(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    switch (setField_) {
      case TEXT:
        java.lang.String Text = (java.lang.String)value_;
        oprot.writeString(Text);
        return;
      case INT:
        java.lang.Integer Int = (java.lang.Integer)value_;
        oprot.writeI32(Int);
        return;
      case REAL:
        java.lang.Double Real = (java.lang.Double)value_;
        oprot.writeDouble(Real);
        return;
      default:
        throw new java.lang.IllegalStateException("Cannot write union with unknown field " + setField_);
    }
  }

  @Override
  protected org.apache.thrift.protocol.TField getFieldDesc(_Fields setField) {
    switch (setField) {
      case TEXT:
        return TEXT_FIELD_DESC;
      case INT:
        return INT_FIELD_DESC;
      case REAL:
        return REAL_FIELD_DESC;
      default:
        throw new java.lang.IllegalArgumentException("Unknown field id " + setField);
    }
  }

  @Override
  protected org.apache.thrift.protocol.TStruct getStructDesc() {
    return STRUCT_DESC;
  }

  @Override
  protected _Fields enumForId(short id) {
    return _Fields.findByThriftIdOrThrow(id);
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }


  public java.lang.String getText() {
    if (getSetField() == _Fields.TEXT) {
      return (java.lang.String)getFieldValue();
    } else {
      throw new java.lang.RuntimeException("Cannot get field 'Text' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setText(java.lang.String value) {
    if (value == null) throw new java.lang.NullPointerException();
    setField_ = _Fields.TEXT;
    value_ = value;
  }

  public int getInt() {
    if (getSetField() == _Fields.INT) {
      return (java.lang.Integer)getFieldValue();
    } else {
      throw new java.lang.RuntimeException("Cannot get field 'Int' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setInt(int value) {
    setField_ = _Fields.INT;
    value_ = value;
  }

  public double getReal() {
    if (getSetField() == _Fields.REAL) {
      return (java.lang.Double)getFieldValue();
    } else {
      throw new java.lang.RuntimeException("Cannot get field 'Real' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setReal(double value) {
    setField_ = _Fields.REAL;
    value_ = value;
  }

  public boolean isSetText() {
    return setField_ == _Fields.TEXT;
  }


  public boolean isSetInt() {
    return setField_ == _Fields.INT;
  }


  public boolean isSetReal() {
    return setField_ == _Fields.REAL;
  }


  public boolean equals(java.lang.Object other) {
    if (other instanceof UnionWithDefault) {
      return equals((UnionWithDefault)other);
    } else {
      return false;
    }
  }

  public boolean equals(UnionWithDefault other) {
    return other != null && getSetField() == other.getSetField() && getFieldValue().equals(other.getFieldValue());
  }

  @Override
  public int compareTo(UnionWithDefault other) {
    int lastComparison = org.apache.thrift.TBaseHelper.compareTo(getSetField(), other.getSetField());
    if (lastComparison == 0) {
      return org.apache.thrift.TBaseHelper.compareTo(getFieldValue(), other.getFieldValue());
    }
    return lastComparison;
  }


  @Override
  public int hashCode() {
    java.util.List<java.lang.Object> list = new java.util.ArrayList<java.lang.Object>();
    list.add(this.getClass().getName());
    org.apache.thrift.TFieldIdEnum setField = getSetField();
    if (setField != null) {
      list.add(setField.getThriftFieldId());
      java.lang.Object value = getFieldValue();
      if (value instanceof org.apache.thrift.TEnum) {
        list.add(((org.apache.thrift.TEnum)getFieldValue()).getValue());
      } else {
        list.add(value);
      }
    }
    return list.hashCode();
  }
  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }


  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }


}
