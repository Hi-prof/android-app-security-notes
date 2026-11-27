package com.alibaba.fastjson.parser.deserializer;

/* JADX INFO: loaded from: classes.dex */
public class JavaObjectDeserializer implements com.alibaba.fastjson.parser.deserializer.ObjectDeserializer {
    public static final com.alibaba.fastjson.parser.deserializer.JavaObjectDeserializer instance = new com.alibaba.fastjson.parser.deserializer.JavaObjectDeserializer();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj) {
        if (type instanceof java.lang.reflect.GenericArrayType) {
            java.lang.reflect.Type genericComponentType = ((java.lang.reflect.GenericArrayType) type).getGenericComponentType();
            if (genericComponentType instanceof java.lang.reflect.TypeVariable) {
                genericComponentType = ((java.lang.reflect.TypeVariable) genericComponentType).getBounds()[0];
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            defaultJSONParser.parseArray(genericComponentType, arrayList);
            T t = (T) ((java.lang.Object[]) java.lang.reflect.Array.newInstance(com.alibaba.fastjson.util.TypeUtils.getRawClass(genericComponentType), arrayList.size()));
            arrayList.toArray((java.lang.Object[]) t);
            return t;
        }
        if ((type instanceof java.lang.Class) && type != java.lang.Object.class && type != java.io.Serializable.class && type != java.lang.Cloneable.class && type != java.io.Closeable.class && type != java.lang.Comparable.class) {
            return (T) defaultJSONParser.parseObject(type);
        }
        return (T) defaultJSONParser.parse(obj);
    }
}
