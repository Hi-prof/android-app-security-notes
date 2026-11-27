package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: classes.dex */
public class FieldSerializer implements java.lang.Comparable<com.alibaba.fastjson.serializer.FieldSerializer> {
    protected boolean browserCompatible;
    protected boolean disableCircularReferenceDetect;
    private final java.lang.String double_quoted_fieldPrefix;
    protected int features;
    protected com.alibaba.fastjson.serializer.BeanContext fieldContext;
    public final com.alibaba.fastjson.util.FieldInfo fieldInfo;
    private java.lang.String format;
    protected boolean persistenceXToMany;
    private com.alibaba.fastjson.serializer.FieldSerializer.RuntimeSerializerInfo runtimeInfo;
    protected boolean serializeUsing = false;
    private java.lang.String single_quoted_fieldPrefix;
    private java.lang.String un_quoted_fieldPrefix;
    protected boolean writeEnumUsingName;
    protected boolean writeEnumUsingToString;
    protected final boolean writeNull;

    public FieldSerializer(java.lang.Class<?> cls, com.alibaba.fastjson.util.FieldInfo fieldInfo) {
        boolean z;
        com.alibaba.fastjson.annotation.JSONType jSONType;
        this.writeEnumUsingToString = false;
        this.writeEnumUsingName = false;
        this.disableCircularReferenceDetect = false;
        this.persistenceXToMany = false;
        this.fieldInfo = fieldInfo;
        this.fieldContext = new com.alibaba.fastjson.serializer.BeanContext(cls, fieldInfo);
        if (cls != null && (jSONType = (com.alibaba.fastjson.annotation.JSONType) com.alibaba.fastjson.util.TypeUtils.getAnnotation(cls, com.alibaba.fastjson.annotation.JSONType.class)) != null) {
            for (com.alibaba.fastjson.serializer.SerializerFeature serializerFeature : jSONType.serialzeFeatures()) {
                if (serializerFeature == com.alibaba.fastjson.serializer.SerializerFeature.WriteEnumUsingToString) {
                    this.writeEnumUsingToString = true;
                } else if (serializerFeature == com.alibaba.fastjson.serializer.SerializerFeature.WriteEnumUsingName) {
                    this.writeEnumUsingName = true;
                } else if (serializerFeature == com.alibaba.fastjson.serializer.SerializerFeature.DisableCircularReferenceDetect) {
                    this.disableCircularReferenceDetect = true;
                } else if (serializerFeature == com.alibaba.fastjson.serializer.SerializerFeature.BrowserCompatible) {
                    this.features |= com.alibaba.fastjson.serializer.SerializerFeature.BrowserCompatible.mask;
                    this.browserCompatible = true;
                } else if (serializerFeature == com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue) {
                    this.features |= com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue.mask;
                }
            }
        }
        fieldInfo.setAccessible();
        this.double_quoted_fieldPrefix = io.dcloud.common.util.JSUtil.QUOTE + fieldInfo.name + "\":";
        com.alibaba.fastjson.annotation.JSONField annotation = fieldInfo.getAnnotation();
        if (annotation != null) {
            com.alibaba.fastjson.serializer.SerializerFeature[] serializerFeatureArrSerialzeFeatures = annotation.serialzeFeatures();
            int length = serializerFeatureArrSerialzeFeatures.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                } else {
                    if ((serializerFeatureArrSerialzeFeatures[i].getMask() & com.alibaba.fastjson.serializer.SerializerFeature.WRITE_MAP_NULL_FEATURES) != 0) {
                        z = true;
                        break;
                    }
                    i++;
                }
            }
            java.lang.String str = annotation.format();
            this.format = str;
            if (str.trim().length() == 0) {
                this.format = null;
            }
            for (com.alibaba.fastjson.serializer.SerializerFeature serializerFeature2 : annotation.serialzeFeatures()) {
                if (serializerFeature2 == com.alibaba.fastjson.serializer.SerializerFeature.WriteEnumUsingToString) {
                    this.writeEnumUsingToString = true;
                } else if (serializerFeature2 == com.alibaba.fastjson.serializer.SerializerFeature.WriteEnumUsingName) {
                    this.writeEnumUsingName = true;
                } else if (serializerFeature2 == com.alibaba.fastjson.serializer.SerializerFeature.DisableCircularReferenceDetect) {
                    this.disableCircularReferenceDetect = true;
                } else if (serializerFeature2 == com.alibaba.fastjson.serializer.SerializerFeature.BrowserCompatible) {
                    this.browserCompatible = true;
                }
            }
            this.features = com.alibaba.fastjson.serializer.SerializerFeature.of(annotation.serialzeFeatures()) | this.features;
        } else {
            z = false;
        }
        this.writeNull = z;
        this.persistenceXToMany = com.alibaba.fastjson.util.TypeUtils.isAnnotationPresentOneToMany(fieldInfo.method) || com.alibaba.fastjson.util.TypeUtils.isAnnotationPresentManyToMany(fieldInfo.method);
    }

    public void writePrefix(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer) throws java.io.IOException {
        com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = jSONSerializer.out;
        if (serializeWriter.quoteFieldNames) {
            if (com.alibaba.fastjson.serializer.SerializerFeature.isEnabled(serializeWriter.features, this.fieldInfo.serialzeFeatures, com.alibaba.fastjson.serializer.SerializerFeature.UseSingleQuotes)) {
                if (this.single_quoted_fieldPrefix == null) {
                    this.single_quoted_fieldPrefix = "'" + this.fieldInfo.name + "':";
                }
                serializeWriter.write(this.single_quoted_fieldPrefix);
                return;
            }
            serializeWriter.write(this.double_quoted_fieldPrefix);
            return;
        }
        if (this.un_quoted_fieldPrefix == null) {
            this.un_quoted_fieldPrefix = this.fieldInfo.name + ":";
        }
        serializeWriter.write(this.un_quoted_fieldPrefix);
    }

    public java.lang.Object getPropertyValueDirect(java.lang.Object obj) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        java.lang.Object obj2 = this.fieldInfo.get(obj);
        if (!this.persistenceXToMany || com.alibaba.fastjson.util.TypeUtils.isHibernateInitialized(obj2)) {
            return obj2;
        }
        return null;
    }

    public java.lang.Object getPropertyValue(java.lang.Object obj) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        java.lang.Object obj2 = this.fieldInfo.get(obj);
        if (this.format == null || obj2 == null) {
            return obj2;
        }
        if (this.fieldInfo.fieldClass != java.util.Date.class && this.fieldInfo.fieldClass != java.sql.Date.class) {
            return obj2;
        }
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(this.format, com.alibaba.fastjson.JSON.defaultLocale);
        simpleDateFormat.setTimeZone(com.alibaba.fastjson.JSON.defaultTimeZone);
        return simpleDateFormat.format(obj2);
    }

    @Override // java.lang.Comparable
    public int compareTo(com.alibaba.fastjson.serializer.FieldSerializer fieldSerializer) {
        return this.fieldInfo.compareTo(fieldSerializer.fieldInfo);
    }

    /* JADX WARN: Code duplicated, block: B:45:0x0082  */
    public void writeValue(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj) throws java.lang.Exception {
        com.alibaba.fastjson.serializer.ObjectSerializer objectWriter;
        java.lang.Object obj2;
        java.lang.Class<?> cls;
        com.alibaba.fastjson.serializer.ObjectSerializer objectWriter2;
        if (this.runtimeInfo == null) {
            if (obj == null) {
                cls = this.fieldInfo.fieldClass;
                if (cls == java.lang.Byte.TYPE) {
                    cls = java.lang.Byte.class;
                } else if (cls == java.lang.Short.TYPE) {
                    cls = java.lang.Short.class;
                } else if (cls == java.lang.Integer.TYPE) {
                    cls = java.lang.Integer.class;
                } else if (cls == java.lang.Long.TYPE) {
                    cls = java.lang.Long.class;
                } else if (cls == java.lang.Float.TYPE) {
                    cls = java.lang.Float.class;
                } else if (cls == java.lang.Double.TYPE) {
                    cls = java.lang.Double.class;
                } else if (cls == java.lang.Boolean.TYPE) {
                    cls = java.lang.Boolean.class;
                }
            } else {
                cls = obj.getClass();
            }
            com.alibaba.fastjson.annotation.JSONField annotation = this.fieldInfo.getAnnotation();
            if (annotation != null && annotation.serializeUsing() != java.lang.Void.class) {
                objectWriter2 = (com.alibaba.fastjson.serializer.ObjectSerializer) annotation.serializeUsing().newInstance();
                this.serializeUsing = true;
            } else {
                if (this.format == null) {
                    objectWriter2 = null;
                } else if (cls == java.lang.Double.TYPE || cls == java.lang.Double.class) {
                    objectWriter2 = new com.alibaba.fastjson.serializer.DoubleSerializer(this.format);
                } else if (cls == java.lang.Float.TYPE || cls == java.lang.Float.class) {
                    objectWriter2 = new com.alibaba.fastjson.serializer.FloatCodec(this.format);
                } else {
                    objectWriter2 = null;
                }
                if (objectWriter2 == null) {
                    objectWriter2 = jSONSerializer.getObjectWriter(cls);
                }
            }
            this.runtimeInfo = new com.alibaba.fastjson.serializer.FieldSerializer.RuntimeSerializerInfo(objectWriter2, cls);
        }
        com.alibaba.fastjson.serializer.FieldSerializer.RuntimeSerializerInfo runtimeSerializerInfo = this.runtimeInfo;
        int i = (this.disableCircularReferenceDetect ? this.fieldInfo.serialzeFeatures | com.alibaba.fastjson.serializer.SerializerFeature.DisableCircularReferenceDetect.mask : this.fieldInfo.serialzeFeatures) | this.features;
        if (obj == null) {
            com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = jSONSerializer.out;
            if (this.fieldInfo.fieldClass == java.lang.Object.class && serializeWriter.isEnabled(com.alibaba.fastjson.serializer.SerializerFeature.WRITE_MAP_NULL_FEATURES)) {
                serializeWriter.writeNull();
                return;
            }
            java.lang.Class<?> cls2 = runtimeSerializerInfo.runtimeFieldClass;
            if (java.lang.Number.class.isAssignableFrom(cls2)) {
                serializeWriter.writeNull(this.features, com.alibaba.fastjson.serializer.SerializerFeature.WriteNullNumberAsZero.mask);
                return;
            }
            if (java.lang.String.class == cls2) {
                serializeWriter.writeNull(this.features, com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty.mask);
                return;
            }
            if (java.lang.Boolean.class == cls2) {
                serializeWriter.writeNull(this.features, com.alibaba.fastjson.serializer.SerializerFeature.WriteNullBooleanAsFalse.mask);
                return;
            }
            if (java.util.Collection.class.isAssignableFrom(cls2) || cls2.isArray()) {
                serializeWriter.writeNull(this.features, com.alibaba.fastjson.serializer.SerializerFeature.WriteNullListAsEmpty.mask);
                return;
            }
            com.alibaba.fastjson.serializer.ObjectSerializer objectSerializer = runtimeSerializerInfo.fieldSerializer;
            if (serializeWriter.isEnabled(com.alibaba.fastjson.serializer.SerializerFeature.WRITE_MAP_NULL_FEATURES) && (objectSerializer instanceof com.alibaba.fastjson.serializer.JavaBeanSerializer)) {
                serializeWriter.writeNull();
                return;
            } else {
                objectSerializer.write(jSONSerializer, null, this.fieldInfo.name, this.fieldInfo.fieldType, i);
                return;
            }
        }
        if (this.fieldInfo.isEnum) {
            if (this.writeEnumUsingName) {
                jSONSerializer.out.writeString(((java.lang.Enum) obj).name());
                return;
            } else if (this.writeEnumUsingToString) {
                jSONSerializer.out.writeString(((java.lang.Enum) obj).toString());
                return;
            }
        }
        java.lang.Class<?> cls3 = obj.getClass();
        if (cls3 == runtimeSerializerInfo.runtimeFieldClass || this.serializeUsing) {
            objectWriter = runtimeSerializerInfo.fieldSerializer;
        } else {
            objectWriter = jSONSerializer.getObjectWriter(cls3);
        }
        com.alibaba.fastjson.serializer.ObjectSerializer objectSerializer2 = objectWriter;
        java.lang.String str = this.format;
        if (str != null && !(objectSerializer2 instanceof com.alibaba.fastjson.serializer.DoubleSerializer) && !(objectSerializer2 instanceof com.alibaba.fastjson.serializer.FloatCodec)) {
            if (objectSerializer2 instanceof com.alibaba.fastjson.serializer.ContextObjectSerializer) {
                ((com.alibaba.fastjson.serializer.ContextObjectSerializer) objectSerializer2).write(jSONSerializer, obj, this.fieldContext);
                return;
            } else {
                jSONSerializer.writeWithFormat(obj, str);
                return;
            }
        }
        if (!this.fieldInfo.unwrapped) {
            obj2 = obj;
        } else {
            if (objectSerializer2 instanceof com.alibaba.fastjson.serializer.JavaBeanSerializer) {
                ((com.alibaba.fastjson.serializer.JavaBeanSerializer) objectSerializer2).write(jSONSerializer, obj, this.fieldInfo.name, this.fieldInfo.fieldType, i, true);
                return;
            }
            obj2 = obj;
            if (objectSerializer2 instanceof com.alibaba.fastjson.serializer.MapSerializer) {
                ((com.alibaba.fastjson.serializer.MapSerializer) objectSerializer2).write(jSONSerializer, obj2, this.fieldInfo.name, this.fieldInfo.fieldType, i, true);
                return;
            }
        }
        if ((this.features & com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName.mask) != 0 && cls3 != this.fieldInfo.fieldClass && (objectSerializer2 instanceof com.alibaba.fastjson.serializer.JavaBeanSerializer)) {
            ((com.alibaba.fastjson.serializer.JavaBeanSerializer) objectSerializer2).write(jSONSerializer, obj2, this.fieldInfo.name, this.fieldInfo.fieldType, i, false);
            return;
        }
        if (this.browserCompatible && (this.fieldInfo.fieldClass == java.lang.Long.TYPE || this.fieldInfo.fieldClass == java.lang.Long.class)) {
            long jLongValue = ((java.lang.Long) obj2).longValue();
            if (jLongValue > 9007199254740991L || jLongValue < -9007199254740991L) {
                jSONSerializer.getWriter().writeString(java.lang.Long.toString(jLongValue));
                return;
            }
        }
        objectSerializer2.write(jSONSerializer, obj2, this.fieldInfo.name, this.fieldInfo.fieldType, i);
    }

    static class RuntimeSerializerInfo {
        final com.alibaba.fastjson.serializer.ObjectSerializer fieldSerializer;
        final java.lang.Class<?> runtimeFieldClass;

        public RuntimeSerializerInfo(com.alibaba.fastjson.serializer.ObjectSerializer objectSerializer, java.lang.Class<?> cls) {
            this.fieldSerializer = objectSerializer;
            this.runtimeFieldClass = cls;
        }
    }
}
