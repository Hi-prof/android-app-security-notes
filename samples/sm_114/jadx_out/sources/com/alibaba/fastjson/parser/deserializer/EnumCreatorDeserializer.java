package com.alibaba.fastjson.parser.deserializer;

/* JADX INFO: loaded from: classes.dex */
public class EnumCreatorDeserializer implements com.alibaba.fastjson.parser.deserializer.ObjectDeserializer {
    private final java.lang.reflect.Method creator;
    private final java.lang.Class paramType;

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 0;
    }

    public EnumCreatorDeserializer(java.lang.reflect.Method method) {
        this.creator = method;
        this.paramType = method.getParameterTypes()[0];
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj) {
        try {
            return (T) this.creator.invoke(null, defaultJSONParser.parseObject((java.lang.Class) this.paramType));
        } catch (java.lang.IllegalAccessException e) {
            throw new com.alibaba.fastjson.JSONException("parse enum error", e);
        } catch (java.lang.reflect.InvocationTargetException e2) {
            throw new com.alibaba.fastjson.JSONException("parse enum error", e2);
        }
    }
}
