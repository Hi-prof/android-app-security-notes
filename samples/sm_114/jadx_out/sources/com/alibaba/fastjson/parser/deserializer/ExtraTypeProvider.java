package com.alibaba.fastjson.parser.deserializer;

/* JADX INFO: loaded from: classes.dex */
public interface ExtraTypeProvider extends com.alibaba.fastjson.parser.deserializer.ParseProcess {
    java.lang.reflect.Type getExtraType(java.lang.Object obj, java.lang.String str);
}
