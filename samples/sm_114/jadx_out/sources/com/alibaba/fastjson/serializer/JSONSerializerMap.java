package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: classes.dex */
@java.lang.Deprecated
public class JSONSerializerMap extends com.alibaba.fastjson.serializer.SerializeConfig {
    public final boolean put(java.lang.Class<?> cls, com.alibaba.fastjson.serializer.ObjectSerializer objectSerializer) {
        return super.put((java.lang.reflect.Type) cls, objectSerializer);
    }
}
