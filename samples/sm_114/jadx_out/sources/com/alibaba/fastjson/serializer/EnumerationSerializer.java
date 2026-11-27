package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: classes.dex */
public class EnumerationSerializer implements com.alibaba.fastjson.serializer.ObjectSerializer {
    public static com.alibaba.fastjson.serializer.EnumerationSerializer instance = new com.alibaba.fastjson.serializer.EnumerationSerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.Object obj2, java.lang.reflect.Type type, int i) throws java.lang.Throwable {
        com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer2;
        java.lang.Throwable th;
        com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull(com.alibaba.fastjson.serializer.SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        int i2 = 0;
        java.lang.reflect.Type type2 = (serializeWriter.isEnabled(com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName) && (type instanceof java.lang.reflect.ParameterizedType)) ? ((java.lang.reflect.ParameterizedType) type).getActualTypeArguments()[0] : null;
        java.util.Enumeration enumeration = (java.util.Enumeration) obj;
        com.alibaba.fastjson.serializer.SerialContext serialContext = jSONSerializer.context;
        jSONSerializer.setContext(serialContext, obj, obj2, 0);
        try {
            serializeWriter.append(com.taobao.weex.el.parse.Operators.ARRAY_START);
            while (enumeration.hasMoreElements()) {
                java.lang.Object objNextElement = enumeration.nextElement();
                int i3 = i2 + 1;
                if (i2 != 0) {
                    try {
                        serializeWriter.append(com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR);
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        jSONSerializer2 = jSONSerializer;
                        jSONSerializer2.context = serialContext;
                        throw th;
                    }
                }
                if (objNextElement == null) {
                    serializeWriter.writeNull();
                    jSONSerializer2 = jSONSerializer;
                } else {
                    jSONSerializer2 = jSONSerializer;
                    try {
                        jSONSerializer.getObjectWriter(objNextElement.getClass()).write(jSONSerializer2, objNextElement, java.lang.Integer.valueOf(i2), type2, 0);
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        th = th;
                        jSONSerializer2.context = serialContext;
                        throw th;
                    }
                }
                i2 = i3;
                jSONSerializer = jSONSerializer2;
            }
            jSONSerializer2 = jSONSerializer;
            serializeWriter.append(com.taobao.weex.el.parse.Operators.ARRAY_END);
            jSONSerializer2.context = serialContext;
        } catch (java.lang.Throwable th4) {
            th = th4;
            jSONSerializer2 = jSONSerializer;
        }
    }
}
