package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: classes.dex */
public class ArraySerializer implements com.alibaba.fastjson.serializer.ObjectSerializer {
    private final com.alibaba.fastjson.serializer.ObjectSerializer compObjectSerializer;
    private final java.lang.Class<?> componentType;

    public ArraySerializer(java.lang.Class<?> cls, com.alibaba.fastjson.serializer.ObjectSerializer objectSerializer) {
        this.componentType = cls;
        this.compObjectSerializer = objectSerializer;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public final void write(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.Object obj2, java.lang.reflect.Type type, int i) throws java.lang.Throwable {
        com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer2;
        java.lang.Throwable th;
        com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull(com.alibaba.fastjson.serializer.SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        java.lang.Object[] objArr = (java.lang.Object[]) obj;
        int length = objArr.length;
        com.alibaba.fastjson.serializer.SerialContext serialContext = jSONSerializer.context;
        int i2 = 0;
        jSONSerializer.setContext(serialContext, obj, obj2, 0);
        try {
            serializeWriter.append(com.taobao.weex.el.parse.Operators.ARRAY_START);
            while (i2 < length) {
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
                java.lang.Object obj3 = objArr[i2];
                if (obj3 == null) {
                    if (serializeWriter.isEnabled(com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty) && (obj instanceof java.lang.String[])) {
                        serializeWriter.writeString("");
                    } else {
                        serializeWriter.append((java.lang.CharSequence) "null");
                    }
                    jSONSerializer2 = jSONSerializer;
                } else if (obj3.getClass() == this.componentType) {
                    jSONSerializer2 = jSONSerializer;
                    this.compObjectSerializer.write(jSONSerializer2, obj3, java.lang.Integer.valueOf(i2), null, 0);
                } else {
                    jSONSerializer2 = jSONSerializer;
                    jSONSerializer2.getObjectWriter(obj3.getClass()).write(jSONSerializer2, obj3, java.lang.Integer.valueOf(i2), null, 0);
                }
                try {
                    i2++;
                    jSONSerializer = jSONSerializer2;
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    th = th;
                    jSONSerializer2.context = serialContext;
                    throw th;
                }
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
