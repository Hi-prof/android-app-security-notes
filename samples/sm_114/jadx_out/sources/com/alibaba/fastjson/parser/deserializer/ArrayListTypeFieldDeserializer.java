package com.alibaba.fastjson.parser.deserializer;

/* JADX INFO: loaded from: classes.dex */
public class ArrayListTypeFieldDeserializer extends com.alibaba.fastjson.parser.deserializer.FieldDeserializer {
    private com.alibaba.fastjson.parser.deserializer.ObjectDeserializer deserializer;
    private int itemFastMatchToken;
    private final java.lang.reflect.Type itemType;

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public int getFastMatchToken() {
        return 14;
    }

    public ArrayListTypeFieldDeserializer(com.alibaba.fastjson.parser.ParserConfig parserConfig, java.lang.Class<?> cls, com.alibaba.fastjson.util.FieldInfo fieldInfo) {
        super(cls, fieldInfo);
        if (fieldInfo.fieldType instanceof java.lang.reflect.ParameterizedType) {
            java.lang.reflect.Type type = ((java.lang.reflect.ParameterizedType) fieldInfo.fieldType).getActualTypeArguments()[0];
            if (type instanceof java.lang.reflect.WildcardType) {
                java.lang.reflect.Type[] upperBounds = ((java.lang.reflect.WildcardType) type).getUpperBounds();
                if (upperBounds.length == 1) {
                    type = upperBounds[0];
                }
            }
            this.itemType = type;
            return;
        }
        this.itemType = java.lang.Object.class;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public void parseField(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.Object obj, java.lang.reflect.Type type, java.util.Map<java.lang.String, java.lang.Object> map) {
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = jSONLexer.token();
        if (i == 8 || (i == 4 && jSONLexer.stringVal().length() == 0)) {
            if (obj == null) {
                map.put(this.fieldInfo.name, null);
                return;
            } else {
                setValue(obj, (java.lang.String) null);
                return;
            }
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.alibaba.fastjson.parser.ParseContext context = defaultJSONParser.getContext();
        defaultJSONParser.setContext(context, obj, this.fieldInfo.name);
        parseArray(defaultJSONParser, type, arrayList);
        defaultJSONParser.setContext(context);
        if (obj == null) {
            map.put(this.fieldInfo.name, arrayList);
        } else {
            setValue(obj, arrayList);
        }
    }

    public final void parseArray(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.util.Collection collection) {
        java.lang.Class cls;
        int i;
        java.lang.reflect.Type typeIntern;
        int i2;
        java.lang.reflect.Type type2 = this.itemType;
        com.alibaba.fastjson.parser.deserializer.ObjectDeserializer deserializer = this.deserializer;
        int i3 = 0;
        if (type instanceof java.lang.reflect.ParameterizedType) {
            if (type2 instanceof java.lang.reflect.TypeVariable) {
                java.lang.reflect.TypeVariable typeVariable = (java.lang.reflect.TypeVariable) type2;
                java.lang.reflect.ParameterizedType parameterizedType = (java.lang.reflect.ParameterizedType) type;
                cls = parameterizedType.getRawType() instanceof java.lang.Class ? (java.lang.Class) parameterizedType.getRawType() : null;
                if (cls == null) {
                    i2 = -1;
                    break;
                }
                int length = cls.getTypeParameters().length;
                i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        i2 = -1;
                        break;
                    } else if (cls.getTypeParameters()[i2].getName().equals(typeVariable.getName())) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 != -1) {
                    typeIntern = parameterizedType.getActualTypeArguments()[i2];
                    if (!typeIntern.equals(this.itemType)) {
                        deserializer = defaultJSONParser.getConfig().getDeserializer(typeIntern);
                    }
                    type2 = typeIntern;
                }
            } else if (type2 instanceof java.lang.reflect.ParameterizedType) {
                java.lang.reflect.ParameterizedType parameterizedType2 = (java.lang.reflect.ParameterizedType) type2;
                java.lang.reflect.Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
                if (actualTypeArguments.length == 1) {
                    java.lang.reflect.Type type3 = actualTypeArguments[0];
                    if (type3 instanceof java.lang.reflect.TypeVariable) {
                        java.lang.reflect.TypeVariable typeVariable2 = (java.lang.reflect.TypeVariable) type3;
                        java.lang.reflect.ParameterizedType parameterizedType3 = (java.lang.reflect.ParameterizedType) type;
                        cls = parameterizedType3.getRawType() instanceof java.lang.Class ? (java.lang.Class) parameterizedType3.getRawType() : null;
                        if (cls == null) {
                            i = -1;
                            break;
                        }
                        int length2 = cls.getTypeParameters().length;
                        i = 0;
                        while (true) {
                            if (i >= length2) {
                                i = -1;
                                break;
                            } else if (cls.getTypeParameters()[i].getName().equals(typeVariable2.getName())) {
                                break;
                            } else {
                                i++;
                            }
                        }
                        if (i != -1) {
                            actualTypeArguments[0] = parameterizedType3.getActualTypeArguments()[i];
                            typeIntern = com.alibaba.fastjson.TypeReference.intern(new com.alibaba.fastjson.util.ParameterizedTypeImpl(actualTypeArguments, parameterizedType2.getOwnerType(), parameterizedType2.getRawType()));
                            type2 = typeIntern;
                        }
                    }
                }
            }
        } else if ((type2 instanceof java.lang.reflect.TypeVariable) && (type instanceof java.lang.Class)) {
            java.lang.Class cls2 = (java.lang.Class) type;
            java.lang.reflect.TypeVariable typeVariable3 = (java.lang.reflect.TypeVariable) type2;
            cls2.getTypeParameters();
            int length3 = cls2.getTypeParameters().length;
            for (int i4 = 0; i4 < length3; i4++) {
                java.lang.reflect.TypeVariable typeVariable4 = cls2.getTypeParameters()[i4];
                if (typeVariable4.getName().equals(typeVariable3.getName())) {
                    java.lang.reflect.Type[] bounds = typeVariable4.getBounds();
                    if (bounds.length != 1) {
                        break;
                    }
                    type2 = bounds[0];
                    break;
                }
            }
        }
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i5 = jSONLexer.token();
        if (i5 == 14) {
            if (deserializer == null) {
                deserializer = defaultJSONParser.getConfig().getDeserializer(type2);
                this.deserializer = deserializer;
                this.itemFastMatchToken = deserializer.getFastMatchToken();
            }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer objectDeserializer = deserializer;
            jSONLexer.nextToken(this.itemFastMatchToken);
            while (true) {
                if (jSONLexer.isEnabled(com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas)) {
                    while (jSONLexer.token() == 16) {
                        jSONLexer.nextToken();
                    }
                }
                if (jSONLexer.token() != 15) {
                    collection.add(objectDeserializer.deserialze(defaultJSONParser, type2, java.lang.Integer.valueOf(i3)));
                    defaultJSONParser.checkListResolve(collection);
                    if (jSONLexer.token() == 16) {
                        jSONLexer.nextToken(this.itemFastMatchToken);
                    }
                    i3++;
                } else {
                    jSONLexer.nextToken(16);
                    return;
                }
            }
        } else if (i5 == 4 && this.fieldInfo.unwrapped) {
            java.lang.String strStringVal = jSONLexer.stringVal();
            jSONLexer.nextToken();
            new com.alibaba.fastjson.parser.DefaultJSONParser(strStringVal).parseArray(collection);
        } else {
            if (deserializer == null) {
                deserializer = defaultJSONParser.getConfig().getDeserializer(type2);
                this.deserializer = deserializer;
            }
            collection.add(deserializer.deserialze(defaultJSONParser, type2, 0));
            defaultJSONParser.checkListResolve(collection);
        }
    }
}
