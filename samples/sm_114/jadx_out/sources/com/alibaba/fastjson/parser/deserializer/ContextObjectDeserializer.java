package com.alibaba.fastjson.parser.deserializer;

/* JADX INFO: loaded from: classes.dex */
public abstract class ContextObjectDeserializer implements com.alibaba.fastjson.parser.deserializer.ObjectDeserializer {
    public abstract <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj, java.lang.String str, int i);

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj) {
        return (T) deserialze(defaultJSONParser, type, obj, null, 0);
    }
}
