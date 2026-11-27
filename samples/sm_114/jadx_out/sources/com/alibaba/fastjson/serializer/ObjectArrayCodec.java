package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: classes.dex */
public class ObjectArrayCodec implements com.alibaba.fastjson.serializer.ObjectSerializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer {
    public static final com.alibaba.fastjson.serializer.ObjectArrayCodec instance = new com.alibaba.fastjson.serializer.ObjectArrayCodec();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 14;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public final void write(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.Object obj2, java.lang.reflect.Type type, int i) throws java.io.IOException {
        com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = jSONSerializer.out;
        java.lang.Object[] objArr = (java.lang.Object[]) obj;
        if (obj == null) {
            serializeWriter.writeNull(com.alibaba.fastjson.serializer.SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        int length = objArr.length;
        int i2 = length - 1;
        if (i2 == -1) {
            serializeWriter.append((java.lang.CharSequence) "[]");
            return;
        }
        com.alibaba.fastjson.serializer.SerialContext serialContext = jSONSerializer.context;
        jSONSerializer.setContext(serialContext, obj, obj2, 0);
        try {
            serializeWriter.append(com.taobao.weex.el.parse.Operators.ARRAY_START);
            if (serializeWriter.isEnabled(com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat)) {
                jSONSerializer.incrementIndent();
                jSONSerializer.println();
                for (int i3 = 0; i3 < length; i3++) {
                    if (i3 != 0) {
                        serializeWriter.write(44);
                        jSONSerializer.println();
                    }
                    jSONSerializer.writeWithFieldName(objArr[i3], java.lang.Integer.valueOf(i3));
                }
                jSONSerializer.decrementIdent();
                jSONSerializer.println();
                serializeWriter.write(93);
                return;
            }
            com.alibaba.fastjson.serializer.ObjectSerializer objectWriter = null;
            java.lang.Class<?> cls = null;
            for (int i4 = 0; i4 < i2; i4++) {
                java.lang.Object obj3 = objArr[i4];
                if (obj3 == null) {
                    serializeWriter.append((java.lang.CharSequence) "null,");
                } else {
                    if (jSONSerializer.containsReference(obj3)) {
                        jSONSerializer.writeReference(obj3);
                    } else {
                        java.lang.Class<?> cls2 = obj3.getClass();
                        if (cls2 == cls) {
                            objectWriter.write(jSONSerializer, obj3, java.lang.Integer.valueOf(i4), null, 0);
                        } else {
                            objectWriter = jSONSerializer.getObjectWriter(cls2);
                            objectWriter.write(jSONSerializer, obj3, java.lang.Integer.valueOf(i4), null, 0);
                            cls = cls2;
                        }
                    }
                    serializeWriter.append(com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR);
                }
            }
            java.lang.Object obj4 = objArr[i2];
            if (obj4 == null) {
                serializeWriter.append((java.lang.CharSequence) "null]");
            } else {
                if (jSONSerializer.containsReference(obj4)) {
                    jSONSerializer.writeReference(obj4);
                } else {
                    jSONSerializer.writeWithFieldName(obj4, java.lang.Integer.valueOf(i2));
                }
                serializeWriter.append(com.taobao.weex.el.parse.Operators.ARRAY_END);
            }
        } finally {
            jSONSerializer.context = serialContext;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1, types: [T, byte[]] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj) {
        java.lang.reflect.Type componentType;
        java.lang.Class cls;
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token();
        java.lang.reflect.Type type2 = null;
        if (i == 8) {
            jSONLexer.nextToken(16);
            return null;
        }
        if (i == 4 || i == 26) {
            ?? r8 = (T) jSONLexer.bytesValue();
            jSONLexer.nextToken(16);
            if (r8.length != 0 || type == byte[].class) {
                return r8;
            }
            return null;
        }
        if (type instanceof java.lang.reflect.GenericArrayType) {
            componentType = ((java.lang.reflect.GenericArrayType) type).getGenericComponentType();
            if (componentType instanceof java.lang.reflect.TypeVariable) {
                java.lang.reflect.TypeVariable typeVariable = (java.lang.reflect.TypeVariable) componentType;
                java.lang.reflect.Type type3 = defaultJSONParser.getContext().type;
                if (type3 instanceof java.lang.reflect.ParameterizedType) {
                    java.lang.reflect.ParameterizedType parameterizedType = (java.lang.reflect.ParameterizedType) type3;
                    java.lang.reflect.Type rawType = parameterizedType.getRawType();
                    if (rawType instanceof java.lang.Class) {
                        java.lang.reflect.TypeVariable<java.lang.Class<T>>[] typeParameters = ((java.lang.Class) rawType).getTypeParameters();
                        for (int i2 = 0; i2 < typeParameters.length; i2++) {
                            if (typeParameters[i2].getName().equals(typeVariable.getName())) {
                                type2 = parameterizedType.getActualTypeArguments()[i2];
                            }
                        }
                    }
                    if (type2 instanceof java.lang.Class) {
                        cls = (java.lang.Class) type2;
                    } else {
                        cls = java.lang.Object.class;
                    }
                } else {
                    cls = com.alibaba.fastjson.util.TypeUtils.getClass(typeVariable.getBounds()[0]);
                }
            } else {
                cls = com.alibaba.fastjson.util.TypeUtils.getClass(componentType);
            }
        } else {
            componentType = ((java.lang.Class) type).getComponentType();
            cls = componentType;
        }
        com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray();
        defaultJSONParser.parseArray(componentType, jSONArray, obj);
        return (T) toObjectArray(defaultJSONParser, cls, jSONArray);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0054  */
    private <T> T toObjectArray(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.Class<?> cls, com.alibaba.fastjson.JSONArray jSONArray) {
        java.lang.Object objCast;
        if (jSONArray == null) {
            return null;
        }
        int size = jSONArray.size();
        T t = (T) java.lang.reflect.Array.newInstance(cls, size);
        for (int i = 0; i < size; i++) {
            java.lang.Object objectArray = jSONArray.get(i);
            if (objectArray == jSONArray) {
                java.lang.reflect.Array.set(t, i, t);
            } else if (cls.isArray()) {
                if (!cls.isInstance(objectArray)) {
                    objectArray = toObjectArray(defaultJSONParser, cls, (com.alibaba.fastjson.JSONArray) objectArray);
                }
                java.lang.reflect.Array.set(t, i, objectArray);
            } else {
                if (objectArray instanceof com.alibaba.fastjson.JSONArray) {
                    com.alibaba.fastjson.JSONArray jSONArray2 = (com.alibaba.fastjson.JSONArray) objectArray;
                    int size2 = jSONArray2.size();
                    boolean z = false;
                    for (int i2 = 0; i2 < size2; i2++) {
                        if (jSONArray2.get(i2) == jSONArray) {
                            jSONArray2.set(i, t);
                            z = true;
                        }
                    }
                    if (z) {
                        objCast = jSONArray2.toArray();
                    } else {
                        objCast = null;
                    }
                } else {
                    objCast = null;
                }
                if (objCast == null) {
                    objCast = com.alibaba.fastjson.util.TypeUtils.cast(objectArray, (java.lang.Class<java.lang.Object>) cls, defaultJSONParser.getConfig());
                }
                java.lang.reflect.Array.set(t, i, objCast);
            }
        }
        jSONArray.setRelatedArray(t);
        jSONArray.setComponentType(cls);
        return t;
    }
}
