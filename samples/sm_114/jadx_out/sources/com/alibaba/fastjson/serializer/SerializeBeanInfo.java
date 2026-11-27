package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: classes.dex */
public class SerializeBeanInfo {
    protected final java.lang.Class<?> beanType;
    protected int features;
    protected final com.alibaba.fastjson.util.FieldInfo[] fields;
    protected final com.alibaba.fastjson.annotation.JSONType jsonType;
    protected final com.alibaba.fastjson.util.FieldInfo[] sortedFields;
    protected final java.lang.String typeKey;
    protected final java.lang.String typeName;

    public SerializeBeanInfo(java.lang.Class<?> cls, com.alibaba.fastjson.annotation.JSONType jSONType, java.lang.String str, java.lang.String str2, int i, com.alibaba.fastjson.util.FieldInfo[] fieldInfoArr, com.alibaba.fastjson.util.FieldInfo[] fieldInfoArr2) {
        this.beanType = cls;
        this.jsonType = jSONType;
        this.typeName = str;
        this.typeKey = str2;
        this.features = i;
        this.fields = fieldInfoArr;
        this.sortedFields = fieldInfoArr2;
    }
}
