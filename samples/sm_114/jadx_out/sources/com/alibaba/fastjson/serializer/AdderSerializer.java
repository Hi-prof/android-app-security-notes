package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: classes.dex */
public class AdderSerializer implements com.alibaba.fastjson.serializer.ObjectSerializer {
    public static final com.alibaba.fastjson.serializer.AdderSerializer instance = new com.alibaba.fastjson.serializer.AdderSerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.Object obj2, java.lang.reflect.Type type, int i) throws java.io.IOException {
        com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = jSONSerializer.out;
        if (dc.squareup.okio.Okio$$ExternalSyntheticApiModelOutline0.m422m(obj)) {
            serializeWriter.writeFieldValue(com.taobao.weex.el.parse.Operators.BLOCK_START, "value", dc.squareup.okio.Okio$$ExternalSyntheticApiModelOutline0.m416m(obj).longValue());
            serializeWriter.write(125);
        } else if (dc.squareup.okio.Okio$$ExternalSyntheticApiModelOutline0.m$1(obj)) {
            serializeWriter.writeFieldValue(com.taobao.weex.el.parse.Operators.BLOCK_START, "value", dc.squareup.okio.Okio$$ExternalSyntheticApiModelOutline0.m415m(obj).doubleValue());
            serializeWriter.write(125);
        }
    }
}
