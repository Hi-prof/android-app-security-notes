package com.alibaba.fastjson.parser.deserializer;

/* JADX INFO: loaded from: classes.dex */
public class DefaultFieldDeserializer extends com.alibaba.fastjson.parser.deserializer.FieldDeserializer {
    protected boolean customDeserilizer;
    protected com.alibaba.fastjson.parser.deserializer.ObjectDeserializer fieldValueDeserilizer;

    public DefaultFieldDeserializer(com.alibaba.fastjson.parser.ParserConfig parserConfig, java.lang.Class<?> cls, com.alibaba.fastjson.util.FieldInfo fieldInfo) {
        super(cls, fieldInfo);
        boolean z = false;
        this.customDeserilizer = false;
        com.alibaba.fastjson.annotation.JSONField annotation = fieldInfo.getAnnotation();
        if (annotation != null) {
            java.lang.Class<?> clsDeserializeUsing = annotation.deserializeUsing();
            if (clsDeserializeUsing != null && clsDeserializeUsing != java.lang.Void.class) {
                z = true;
            }
            this.customDeserilizer = z;
        }
    }

    public com.alibaba.fastjson.parser.deserializer.ObjectDeserializer getFieldValueDeserilizer(com.alibaba.fastjson.parser.ParserConfig parserConfig) {
        if (this.fieldValueDeserilizer == null) {
            com.alibaba.fastjson.annotation.JSONField annotation = this.fieldInfo.getAnnotation();
            if (annotation != null && annotation.deserializeUsing() != java.lang.Void.class) {
                try {
                    this.fieldValueDeserilizer = (com.alibaba.fastjson.parser.deserializer.ObjectDeserializer) annotation.deserializeUsing().newInstance();
                } catch (java.lang.Exception e) {
                    throw new com.alibaba.fastjson.JSONException("create deserializeUsing ObjectDeserializer error", e);
                }
            } else {
                this.fieldValueDeserilizer = parserConfig.getDeserializer(this.fieldInfo.fieldClass, this.fieldInfo.fieldType);
            }
        }
        return this.fieldValueDeserilizer;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public void parseField(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.Object obj, java.lang.reflect.Type type, java.util.Map<java.lang.String, java.lang.Object> map) {
        com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser2;
        java.lang.Object objDeserialze;
        if (this.fieldValueDeserilizer == null) {
            getFieldValueDeserilizer(defaultJSONParser.getConfig());
        }
        com.alibaba.fastjson.parser.deserializer.ObjectDeserializer deserializer = this.fieldValueDeserilizer;
        java.lang.reflect.Type fieldType = this.fieldInfo.fieldType;
        if (type instanceof java.lang.reflect.ParameterizedType) {
            com.alibaba.fastjson.parser.ParseContext context = defaultJSONParser.getContext();
            if (context != null) {
                context.type = type;
            }
            if (fieldType != type) {
                fieldType = com.alibaba.fastjson.util.FieldInfo.getFieldType(this.clazz, type, fieldType);
                if (deserializer instanceof com.alibaba.fastjson.parser.deserializer.JavaObjectDeserializer) {
                    deserializer = defaultJSONParser.getConfig().getDeserializer(fieldType);
                }
            }
        }
        java.lang.reflect.Type type2 = fieldType;
        if ((deserializer instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) && this.fieldInfo.parserFeatures != 0) {
            objDeserialze = ((com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) deserializer).deserialze(defaultJSONParser, type2, this.fieldInfo.name, this.fieldInfo.parserFeatures);
            defaultJSONParser2 = defaultJSONParser;
        } else if ((this.fieldInfo.format != null || this.fieldInfo.parserFeatures != 0) && (deserializer instanceof com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer)) {
            defaultJSONParser2 = defaultJSONParser;
            objDeserialze = ((com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer) deserializer).deserialze(defaultJSONParser2, type2, this.fieldInfo.name, this.fieldInfo.format, this.fieldInfo.parserFeatures);
        } else {
            defaultJSONParser2 = defaultJSONParser;
            objDeserialze = deserializer.deserialze(defaultJSONParser2, type2, this.fieldInfo.name);
        }
        if ((objDeserialze instanceof byte[]) && ("gzip".equals(this.fieldInfo.format) || "gzip,base64".equals(this.fieldInfo.format))) {
            try {
                java.util.zip.GZIPInputStream gZIPInputStream = new java.util.zip.GZIPInputStream(new java.io.ByteArrayInputStream((byte[]) objDeserialze));
                java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                while (true) {
                    byte[] bArr = new byte[1024];
                    int i = gZIPInputStream.read(bArr);
                    if (i == -1) {
                        break;
                    } else if (i > 0) {
                        byteArrayOutputStream.write(bArr, 0, i);
                    }
                }
                objDeserialze = byteArrayOutputStream.toByteArray();
            } catch (java.io.IOException e) {
                throw new com.alibaba.fastjson.JSONException("unzip bytes error.", e);
            }
        }
        if (defaultJSONParser2.getResolveStatus() == 1) {
            com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask lastResolveTask = defaultJSONParser2.getLastResolveTask();
            lastResolveTask.fieldDeserializer = this;
            lastResolveTask.ownerContext = defaultJSONParser2.getContext();
            defaultJSONParser2.setResolveStatus(0);
            return;
        }
        if (obj == null) {
            map.put(this.fieldInfo.name, objDeserialze);
        } else {
            setValue(obj, objDeserialze);
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public int getFastMatchToken() {
        com.alibaba.fastjson.parser.deserializer.ObjectDeserializer objectDeserializer = this.fieldValueDeserilizer;
        if (objectDeserializer != null) {
            return objectDeserializer.getFastMatchToken();
        }
        return 2;
    }

    public void parseFieldUnwrapped(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.Object obj, java.lang.reflect.Type type, java.util.Map<java.lang.String, java.lang.Object> map) {
        throw new com.alibaba.fastjson.JSONException("TODO");
    }
}
