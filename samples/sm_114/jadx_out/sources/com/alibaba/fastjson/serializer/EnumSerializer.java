package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: classes.dex */
public class EnumSerializer implements com.alibaba.fastjson.serializer.ObjectSerializer {
    public static final com.alibaba.fastjson.serializer.EnumSerializer instance = new com.alibaba.fastjson.serializer.EnumSerializer();
    private final java.lang.reflect.Member member;

    public EnumSerializer() {
        this.member = null;
    }

    public EnumSerializer(java.lang.reflect.Member member) {
        this.member = member;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.Object obj2, java.lang.reflect.Type type, int i) throws java.io.IOException {
        java.lang.Object objInvoke;
        java.lang.reflect.Member member = this.member;
        if (member == null) {
            jSONSerializer.out.writeEnum((java.lang.Enum) obj);
            return;
        }
        try {
            if (member instanceof java.lang.reflect.Field) {
                objInvoke = ((java.lang.reflect.Field) member).get(obj);
            } else {
                objInvoke = ((java.lang.reflect.Method) member).invoke(obj, null);
            }
            jSONSerializer.write(objInvoke);
        } catch (java.lang.Exception e) {
            throw new com.alibaba.fastjson.JSONException("getEnumValue error", e);
        }
    }
}
