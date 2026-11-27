package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: classes.dex */
public class CollectionCodec implements com.alibaba.fastjson.serializer.ObjectSerializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer {
    public static final com.alibaba.fastjson.serializer.CollectionCodec instance = new com.alibaba.fastjson.serializer.CollectionCodec();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 14;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.Object obj2, java.lang.reflect.Type type, int i) throws java.lang.Throwable {
        com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer2;
        java.lang.Throwable th;
        int i2;
        com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull(com.alibaba.fastjson.serializer.SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        java.lang.reflect.Type collectionItemType = (serializeWriter.isEnabled(com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName) || com.alibaba.fastjson.serializer.SerializerFeature.isEnabled(i, com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName)) ? com.alibaba.fastjson.util.TypeUtils.getCollectionItemType(type) : null;
        java.util.Collection collection = (java.util.Collection) obj;
        com.alibaba.fastjson.serializer.SerialContext serialContext = jSONSerializer.context;
        int i3 = 0;
        jSONSerializer.setContext(serialContext, obj, obj2, 0);
        if (serializeWriter.isEnabled(com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName)) {
            if (java.util.HashSet.class.isAssignableFrom(collection.getClass())) {
                serializeWriter.append((java.lang.CharSequence) "Set");
            } else if (java.util.TreeSet.class == collection.getClass()) {
                serializeWriter.append((java.lang.CharSequence) "TreeSet");
            }
        }
        try {
            serializeWriter.append(com.taobao.weex.el.parse.Operators.ARRAY_START);
            for (java.lang.Object obj3 : collection) {
                int i4 = i3 + 1;
                if (i3 != 0) {
                    try {
                        serializeWriter.append(com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR);
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        jSONSerializer2 = jSONSerializer;
                        jSONSerializer2.context = serialContext;
                        throw th;
                    }
                }
                if (obj3 == null) {
                    serializeWriter.writeNull();
                } else {
                    java.lang.Class<?> cls = obj3.getClass();
                    if (cls == java.lang.Integer.class) {
                        serializeWriter.writeInt(((java.lang.Integer) obj3).intValue());
                    } else {
                        if (cls == java.lang.Long.class) {
                            serializeWriter.writeLong(((java.lang.Long) obj3).longValue());
                            if (serializeWriter.isEnabled(com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName)) {
                                serializeWriter.write(76);
                            }
                        } else {
                            com.alibaba.fastjson.serializer.ObjectSerializer objectWriter = jSONSerializer.getObjectWriter(cls);
                            if (com.alibaba.fastjson.serializer.SerializerFeature.isEnabled(i, com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName) && (objectWriter instanceof com.alibaba.fastjson.serializer.JavaBeanSerializer)) {
                                jSONSerializer2 = jSONSerializer;
                                i2 = i;
                                try {
                                    ((com.alibaba.fastjson.serializer.JavaBeanSerializer) objectWriter).writeNoneASM(jSONSerializer2, obj3, java.lang.Integer.valueOf(i3), collectionItemType, i2);
                                } catch (java.lang.Throwable th3) {
                                    th = th3;
                                    th = th;
                                    jSONSerializer2.context = serialContext;
                                    throw th;
                                }
                            } else {
                                jSONSerializer2 = jSONSerializer;
                                i2 = i;
                                objectWriter.write(jSONSerializer2, obj3, java.lang.Integer.valueOf(i3), collectionItemType, i2);
                            }
                        }
                        i3 = i4;
                        jSONSerializer = jSONSerializer2;
                        i = i2;
                    }
                }
                jSONSerializer2 = jSONSerializer;
                i2 = i;
                i3 = i4;
                jSONSerializer = jSONSerializer2;
                i = i2;
            }
            jSONSerializer2 = jSONSerializer;
            serializeWriter.append(com.taobao.weex.el.parse.Operators.ARRAY_END);
            jSONSerializer2.context = serialContext;
        } catch (java.lang.Throwable th4) {
            th = th4;
            jSONSerializer2 = jSONSerializer;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [T, com.alibaba.fastjson.JSONArray, java.util.Collection] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj) {
        java.util.Collection collection;
        if (defaultJSONParser.lexer.token() == 8) {
            defaultJSONParser.lexer.nextToken(16);
            return null;
        }
        if (type == com.alibaba.fastjson.JSONArray.class) {
            ?? r4 = (T) new com.alibaba.fastjson.JSONArray();
            defaultJSONParser.parseArray((java.util.Collection) r4);
            return r4;
        }
        if (defaultJSONParser.lexer.token() == 21) {
            defaultJSONParser.lexer.nextToken();
            collection = (T) com.alibaba.fastjson.util.TypeUtils.createSet(type);
        } else {
            collection = (T) com.alibaba.fastjson.util.TypeUtils.createCollection(type);
        }
        defaultJSONParser.parseArray(com.alibaba.fastjson.util.TypeUtils.getCollectionItemType(type), collection, obj);
        return (T) collection;
    }
}
