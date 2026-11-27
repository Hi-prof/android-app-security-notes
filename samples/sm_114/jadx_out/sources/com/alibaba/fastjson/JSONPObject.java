package com.alibaba.fastjson;

/* JADX INFO: loaded from: classes.dex */
public class JSONPObject implements com.alibaba.fastjson.serializer.JSONSerializable {
    public static java.lang.String SECURITY_PREFIX = "/**/";
    private java.lang.String function;
    private final java.util.List<java.lang.Object> parameters = new java.util.ArrayList();

    public JSONPObject() {
    }

    public JSONPObject(java.lang.String str) {
        this.function = str;
    }

    public java.lang.String getFunction() {
        return this.function;
    }

    public void setFunction(java.lang.String str) {
        this.function = str;
    }

    public java.util.List<java.lang.Object> getParameters() {
        return this.parameters;
    }

    public void addParameter(java.lang.Object obj) {
        this.parameters.add(obj);
    }

    public java.lang.String toJSONString() {
        return toString();
    }

    @Override // com.alibaba.fastjson.serializer.JSONSerializable
    public void write(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.reflect.Type type, int i) throws java.io.IOException {
        com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = jSONSerializer.out;
        if ((com.alibaba.fastjson.serializer.SerializerFeature.BrowserSecure.mask & i) != 0 || serializeWriter.isEnabled(com.alibaba.fastjson.serializer.SerializerFeature.BrowserSecure.mask)) {
            serializeWriter.write(SECURITY_PREFIX);
        }
        serializeWriter.write(this.function);
        serializeWriter.write(40);
        for (int i2 = 0; i2 < this.parameters.size(); i2++) {
            if (i2 != 0) {
                serializeWriter.write(44);
            }
            jSONSerializer.write(this.parameters.get(i2));
        }
        serializeWriter.write(41);
    }

    public java.lang.String toString() {
        return com.alibaba.fastjson.JSON.toJSONString(this);
    }
}
