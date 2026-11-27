package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: classes.dex */
public class JSONSerializer extends com.alibaba.fastjson.serializer.SerializeFilterable {
    protected final com.alibaba.fastjson.serializer.SerializeConfig config;
    protected com.alibaba.fastjson.serializer.SerialContext context;
    private java.text.DateFormat dateFormat;
    private java.lang.String dateFormatPattern;
    private java.lang.String fastJsonConfigDateFormatPattern;
    private java.lang.String indent;
    private int indentCount;
    protected java.util.Locale locale;
    public final com.alibaba.fastjson.serializer.SerializeWriter out;
    protected java.util.IdentityHashMap<java.lang.Object, com.alibaba.fastjson.serializer.SerialContext> references;
    protected java.util.TimeZone timeZone;

    public JSONSerializer() {
        this(new com.alibaba.fastjson.serializer.SerializeWriter(), com.alibaba.fastjson.serializer.SerializeConfig.getGlobalInstance());
    }

    public JSONSerializer(com.alibaba.fastjson.serializer.SerializeWriter serializeWriter) {
        this(serializeWriter, com.alibaba.fastjson.serializer.SerializeConfig.getGlobalInstance());
    }

    public JSONSerializer(com.alibaba.fastjson.serializer.SerializeConfig serializeConfig) {
        this(new com.alibaba.fastjson.serializer.SerializeWriter(), serializeConfig);
    }

    public JSONSerializer(com.alibaba.fastjson.serializer.SerializeWriter serializeWriter, com.alibaba.fastjson.serializer.SerializeConfig serializeConfig) {
        this.indentCount = 0;
        this.indent = "\t";
        this.references = null;
        this.timeZone = com.alibaba.fastjson.JSON.defaultTimeZone;
        this.locale = com.alibaba.fastjson.JSON.defaultLocale;
        this.out = serializeWriter;
        this.config = serializeConfig;
    }

    public java.lang.String getDateFormatPattern() {
        java.text.DateFormat dateFormat = this.dateFormat;
        if (dateFormat instanceof java.text.SimpleDateFormat) {
            return ((java.text.SimpleDateFormat) dateFormat).toPattern();
        }
        return this.dateFormatPattern;
    }

    public java.text.DateFormat getDateFormat() {
        java.lang.String str;
        if (this.dateFormat == null && (str = this.dateFormatPattern) != null) {
            this.dateFormat = generateDateFormat(str);
        }
        return this.dateFormat;
    }

    private java.text.DateFormat generateDateFormat(java.lang.String str) {
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(str, this.locale);
        simpleDateFormat.setTimeZone(this.timeZone);
        return simpleDateFormat;
    }

    public void setDateFormat(java.text.DateFormat dateFormat) {
        this.dateFormat = dateFormat;
        if (this.dateFormatPattern != null) {
            this.dateFormatPattern = null;
        }
    }

    public void setDateFormat(java.lang.String str) {
        this.dateFormatPattern = str;
        if (this.dateFormat != null) {
            this.dateFormat = null;
        }
    }

    public void setFastJsonConfigDateFormatPattern(java.lang.String str) {
        this.fastJsonConfigDateFormatPattern = str;
    }

    public java.lang.String getFastJsonConfigDateFormatPattern() {
        return this.fastJsonConfigDateFormatPattern;
    }

    public com.alibaba.fastjson.serializer.SerialContext getContext() {
        return this.context;
    }

    public void setContext(com.alibaba.fastjson.serializer.SerialContext serialContext) {
        this.context = serialContext;
    }

    public void setContext(com.alibaba.fastjson.serializer.SerialContext serialContext, java.lang.Object obj, java.lang.Object obj2, int i) {
        setContext(serialContext, obj, obj2, i, 0);
    }

    public void setContext(com.alibaba.fastjson.serializer.SerialContext serialContext, java.lang.Object obj, java.lang.Object obj2, int i, int i2) {
        if (this.out.disableCircularReferenceDetect) {
            return;
        }
        this.context = new com.alibaba.fastjson.serializer.SerialContext(serialContext, obj, obj2, i, i2);
        if (this.references == null) {
            this.references = new java.util.IdentityHashMap<>();
        }
        this.references.put(obj, this.context);
    }

    public void setContext(java.lang.Object obj, java.lang.Object obj2) {
        setContext(this.context, obj, obj2, 0);
    }

    public void popContext() {
        com.alibaba.fastjson.serializer.SerialContext serialContext = this.context;
        if (serialContext != null) {
            this.context = serialContext.parent;
        }
    }

    public final boolean isWriteClassName(java.lang.reflect.Type type, java.lang.Object obj) {
        if (!this.out.isEnabled(com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName)) {
            return false;
        }
        if (type != null || !this.out.isEnabled(com.alibaba.fastjson.serializer.SerializerFeature.NotWriteRootClassName)) {
            return true;
        }
        com.alibaba.fastjson.serializer.SerialContext serialContext = this.context;
        return (serialContext == null || serialContext.parent == null) ? false : true;
    }

    public boolean containsReference(java.lang.Object obj) {
        com.alibaba.fastjson.serializer.SerialContext serialContext;
        java.util.IdentityHashMap<java.lang.Object, com.alibaba.fastjson.serializer.SerialContext> identityHashMap = this.references;
        if (identityHashMap == null || (serialContext = identityHashMap.get(obj)) == null || obj == java.util.Collections.EMPTY_MAP) {
            return false;
        }
        java.lang.Object obj2 = serialContext.fieldName;
        return obj2 == null || (obj2 instanceof java.lang.Integer) || (obj2 instanceof java.lang.String);
    }

    public void writeReference(java.lang.Object obj) {
        com.alibaba.fastjson.serializer.SerialContext serialContext = this.context;
        if (obj == serialContext.object) {
            this.out.write("{\"$ref\":\"@\"}");
            return;
        }
        com.alibaba.fastjson.serializer.SerialContext serialContext2 = serialContext.parent;
        if (serialContext2 != null && obj == serialContext2.object) {
            this.out.write("{\"$ref\":\"..\"}");
            return;
        }
        while (serialContext.parent != null) {
            serialContext = serialContext.parent;
        }
        if (obj == serialContext.object) {
            this.out.write("{\"$ref\":\"$\"}");
            return;
        }
        this.out.write("{\"$ref\":\"");
        this.out.write(this.references.get(obj).toString());
        this.out.write("\"}");
    }

    public boolean checkValue(com.alibaba.fastjson.serializer.SerializeFilterable serializeFilterable) {
        if (this.valueFilters != null && this.valueFilters.size() > 0) {
            return true;
        }
        if (this.contextValueFilters != null && this.contextValueFilters.size() > 0) {
            return true;
        }
        if (serializeFilterable.valueFilters == null || serializeFilterable.valueFilters.size() <= 0) {
            return (serializeFilterable.contextValueFilters != null && serializeFilterable.contextValueFilters.size() > 0) || this.out.writeNonStringValueAsString;
        }
        return true;
    }

    public boolean hasNameFilters(com.alibaba.fastjson.serializer.SerializeFilterable serializeFilterable) {
        if (this.nameFilters == null || this.nameFilters.size() <= 0) {
            return serializeFilterable.nameFilters != null && serializeFilterable.nameFilters.size() > 0;
        }
        return true;
    }

    public boolean hasPropertyFilters(com.alibaba.fastjson.serializer.SerializeFilterable serializeFilterable) {
        if (this.propertyFilters == null || this.propertyFilters.size() <= 0) {
            return serializeFilterable.propertyFilters != null && serializeFilterable.propertyFilters.size() > 0;
        }
        return true;
    }

    public int getIndentCount() {
        return this.indentCount;
    }

    public void incrementIndent() {
        this.indentCount++;
    }

    public void decrementIdent() {
        this.indentCount--;
    }

    public void println() {
        this.out.write(10);
        for (int i = 0; i < this.indentCount; i++) {
            this.out.write(this.indent);
        }
    }

    public com.alibaba.fastjson.serializer.SerializeWriter getWriter() {
        return this.out;
    }

    public java.lang.String toString() {
        return this.out.toString();
    }

    public void config(com.alibaba.fastjson.serializer.SerializerFeature serializerFeature, boolean z) {
        this.out.config(serializerFeature, z);
    }

    public boolean isEnabled(com.alibaba.fastjson.serializer.SerializerFeature serializerFeature) {
        return this.out.isEnabled(serializerFeature);
    }

    public void writeNull() {
        this.out.writeNull();
    }

    public com.alibaba.fastjson.serializer.SerializeConfig getMapping() {
        return this.config;
    }

    public static void write(java.io.Writer writer, java.lang.Object obj) {
        com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = new com.alibaba.fastjson.serializer.SerializeWriter();
        try {
            try {
                new com.alibaba.fastjson.serializer.JSONSerializer(serializeWriter).write(obj);
                serializeWriter.writeTo(writer);
                serializeWriter.close();
            } catch (java.io.IOException e) {
                throw new com.alibaba.fastjson.JSONException(e.getMessage(), e);
            }
        } catch (java.lang.Throwable th) {
            serializeWriter.close();
            throw th;
        }
    }

    public static void write(com.alibaba.fastjson.serializer.SerializeWriter serializeWriter, java.lang.Object obj) {
        new com.alibaba.fastjson.serializer.JSONSerializer(serializeWriter).write(obj);
    }

    public final void write(java.lang.Object obj) {
        if (obj == null) {
            this.out.writeNull();
            return;
        }
        try {
            getObjectWriter(obj.getClass()).write(this, obj, null, null, 0);
        } catch (java.io.IOException e) {
            throw new com.alibaba.fastjson.JSONException(e.getMessage(), e);
        }
    }

    public final void writeAs(java.lang.Object obj, java.lang.Class cls) {
        if (obj == null) {
            this.out.writeNull();
            return;
        }
        try {
            getObjectWriter(cls).write(this, obj, null, null, 0);
        } catch (java.io.IOException e) {
            throw new com.alibaba.fastjson.JSONException(e.getMessage(), e);
        }
    }

    public final void writeWithFieldName(java.lang.Object obj, java.lang.Object obj2) {
        writeWithFieldName(obj, obj2, null, 0);
    }

    protected final void writeKeyValue(char c, java.lang.String str, java.lang.Object obj) {
        if (c != 0) {
            this.out.write(c);
        }
        this.out.writeFieldName(str);
        write(obj);
    }

    public final void writeWithFieldName(java.lang.Object obj, java.lang.Object obj2, java.lang.reflect.Type type, int i) {
        try {
            if (obj == null) {
                this.out.writeNull();
            } else {
                getObjectWriter(obj.getClass()).write(this, obj, obj2, type, i);
            }
        } catch (java.io.IOException e) {
            throw new com.alibaba.fastjson.JSONException(e.getMessage(), e);
        }
    }

    public final void writeWithFormat(java.lang.Object obj, java.lang.String str) {
        java.util.zip.GZIPOutputStream gZIPOutputStream;
        if (obj instanceof java.util.Date) {
            if ("unixtime".equals(str)) {
                this.out.writeInt((int) (((java.util.Date) obj).getTime() / 1000));
                return;
            }
            if ("millis".equals(str)) {
                this.out.writeLong(((java.util.Date) obj).getTime());
                return;
            }
            java.text.DateFormat dateFormat = getDateFormat();
            if (dateFormat == null) {
                if (str != null) {
                    try {
                        dateFormat = generateDateFormat(str);
                    } catch (java.lang.IllegalArgumentException unused) {
                        dateFormat = generateDateFormat(str.replaceAll("T", "'T'"));
                    }
                } else {
                    java.lang.String str2 = this.fastJsonConfigDateFormatPattern;
                    if (str2 != null) {
                        dateFormat = generateDateFormat(str2);
                    } else {
                        dateFormat = generateDateFormat(com.alibaba.fastjson.JSON.DEFFAULT_DATE_FORMAT);
                    }
                }
            }
            this.out.writeString(dateFormat.format((java.util.Date) obj));
            return;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if ("gzip".equals(str) || "gzip,base64".equals(str)) {
                java.util.zip.GZIPOutputStream gZIPOutputStream2 = null;
                try {
                    try {
                        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                        if (bArr.length < 512) {
                            gZIPOutputStream = new java.util.zip.GZIPOutputStream(byteArrayOutputStream, bArr.length);
                        } else {
                            gZIPOutputStream = new java.util.zip.GZIPOutputStream(byteArrayOutputStream);
                        }
                        gZIPOutputStream2 = gZIPOutputStream;
                        gZIPOutputStream2.write(bArr);
                        gZIPOutputStream2.finish();
                        this.out.writeByteArray(byteArrayOutputStream.toByteArray());
                        com.alibaba.fastjson.util.IOUtils.close(gZIPOutputStream2);
                        return;
                    } catch (java.io.IOException e) {
                        throw new com.alibaba.fastjson.JSONException("write gzipBytes error", e);
                    }
                } catch (java.lang.Throwable th) {
                    com.alibaba.fastjson.util.IOUtils.close(gZIPOutputStream2);
                    throw th;
                }
            }
            if ("hex".equals(str)) {
                this.out.writeHex(bArr);
                return;
            } else {
                this.out.writeByteArray(bArr);
                return;
            }
        }
        if (obj instanceof java.util.Collection) {
            java.util.Collection collection = (java.util.Collection) obj;
            java.util.Iterator it = collection.iterator();
            this.out.write(91);
            for (int i = 0; i < collection.size(); i++) {
                java.lang.Object next = it.next();
                if (i != 0) {
                    this.out.write(44);
                }
                writeWithFormat(next, str);
            }
            this.out.write(93);
            return;
        }
        write(obj);
    }

    public final void write(java.lang.String str) {
        com.alibaba.fastjson.serializer.StringCodec.instance.write(this, str);
    }

    public com.alibaba.fastjson.serializer.ObjectSerializer getObjectWriter(java.lang.Class<?> cls) {
        return this.config.getObjectWriter(cls);
    }

    public void close() {
        this.out.close();
    }
}
