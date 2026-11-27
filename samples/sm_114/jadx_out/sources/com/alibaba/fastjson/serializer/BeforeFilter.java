package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: classes.dex */
public abstract class BeforeFilter implements com.alibaba.fastjson.serializer.SerializeFilter {
    private static final java.lang.ThreadLocal<com.alibaba.fastjson.serializer.JSONSerializer> serializerLocal = new java.lang.ThreadLocal<>();
    private static final java.lang.ThreadLocal<java.lang.Character> seperatorLocal = new java.lang.ThreadLocal<>();
    private static final java.lang.Character COMMA = java.lang.Character.valueOf(com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR);

    public abstract void writeBefore(java.lang.Object obj);

    final char writeBefore(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, char c) {
        java.lang.ThreadLocal<com.alibaba.fastjson.serializer.JSONSerializer> threadLocal = serializerLocal;
        com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer2 = threadLocal.get();
        threadLocal.set(jSONSerializer);
        java.lang.ThreadLocal<java.lang.Character> threadLocal2 = seperatorLocal;
        threadLocal2.set(java.lang.Character.valueOf(c));
        writeBefore(obj);
        threadLocal.set(jSONSerializer2);
        return threadLocal2.get().charValue();
    }

    protected final void writeKeyValue(java.lang.String str, java.lang.Object obj) {
        com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer = serializerLocal.get();
        java.lang.ThreadLocal<java.lang.Character> threadLocal = seperatorLocal;
        char cCharValue = threadLocal.get().charValue();
        boolean zContainsKey = jSONSerializer.references.containsKey(obj);
        jSONSerializer.writeKeyValue(cCharValue, str, obj);
        if (!zContainsKey) {
            jSONSerializer.references.remove(obj);
        }
        if (cCharValue != ',') {
            threadLocal.set(COMMA);
        }
    }
}
