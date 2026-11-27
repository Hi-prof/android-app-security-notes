package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: classes.dex */
public interface JSONSerializable {
    void write(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.reflect.Type type, int i) throws java.io.IOException;
}
