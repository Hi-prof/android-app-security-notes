package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: classes.dex */
public interface AutowiredObjectSerializer extends com.alibaba.fastjson.serializer.ObjectSerializer {
    java.util.Set<java.lang.reflect.Type> getAutowiredFor();
}
