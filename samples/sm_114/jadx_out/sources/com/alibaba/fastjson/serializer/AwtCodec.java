package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: classes.dex */
public class AwtCodec implements com.alibaba.fastjson.serializer.ObjectSerializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer {
    public static final com.alibaba.fastjson.serializer.AwtCodec instance = new com.alibaba.fastjson.serializer.AwtCodec();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    public static boolean support(java.lang.Class<?> cls) {
        return cls == java.awt.Point.class || cls == java.awt.Rectangle.class || cls == java.awt.Font.class || cls == java.awt.Color.class;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.Object obj2, java.lang.reflect.Type type, int i) throws java.io.IOException {
        com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        if (obj instanceof java.awt.Point) {
            java.awt.Point point = (java.awt.Point) obj;
            serializeWriter.writeFieldValue(writeClassName(serializeWriter, java.awt.Point.class, com.taobao.weex.el.parse.Operators.BLOCK_START), com.taobao.weex.common.Constants.Name.X, point.x);
            serializeWriter.writeFieldValue(com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR, com.taobao.weex.common.Constants.Name.Y, point.y);
        } else if (obj instanceof java.awt.Font) {
            java.awt.Font font = (java.awt.Font) obj;
            serializeWriter.writeFieldValue(writeClassName(serializeWriter, java.awt.Font.class, com.taobao.weex.el.parse.Operators.BLOCK_START), "name", font.getName());
            serializeWriter.writeFieldValue(com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR, "style", font.getStyle());
            serializeWriter.writeFieldValue(com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR, io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE, font.getSize());
        } else if (obj instanceof java.awt.Rectangle) {
            java.awt.Rectangle rectangle = (java.awt.Rectangle) obj;
            serializeWriter.writeFieldValue(writeClassName(serializeWriter, java.awt.Rectangle.class, com.taobao.weex.el.parse.Operators.BLOCK_START), com.taobao.weex.common.Constants.Name.X, rectangle.x);
            serializeWriter.writeFieldValue(com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR, com.taobao.weex.common.Constants.Name.Y, rectangle.y);
            serializeWriter.writeFieldValue(com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR, "width", rectangle.width);
            serializeWriter.writeFieldValue(com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR, "height", rectangle.height);
        } else if (obj instanceof java.awt.Color) {
            java.awt.Color color = (java.awt.Color) obj;
            serializeWriter.writeFieldValue(writeClassName(serializeWriter, java.awt.Color.class, com.taobao.weex.el.parse.Operators.BLOCK_START), "r", color.getRed());
            serializeWriter.writeFieldValue(com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR, "g", color.getGreen());
            serializeWriter.writeFieldValue(com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR, "b", color.getBlue());
            if (color.getAlpha() > 0) {
                serializeWriter.writeFieldValue(com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR, "alpha", color.getAlpha());
            }
        } else {
            throw new com.alibaba.fastjson.JSONException("not support awt class : " + obj.getClass().getName());
        }
        serializeWriter.write(125);
    }

    protected char writeClassName(com.alibaba.fastjson.serializer.SerializeWriter serializeWriter, java.lang.Class<?> cls, char c) {
        if (!serializeWriter.isEnabled(com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName)) {
            return c;
        }
        serializeWriter.write(123);
        serializeWriter.writeFieldName(com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY);
        serializeWriter.writeString(cls.getName());
        return com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj) {
        T t;
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken(16);
            return null;
        }
        if (jSONLexer.token() != 12 && jSONLexer.token() != 16) {
            throw new com.alibaba.fastjson.JSONException("syntax error");
        }
        jSONLexer.nextToken();
        if (type == java.awt.Point.class) {
            t = (T) parsePoint(defaultJSONParser, obj);
        } else if (type == java.awt.Rectangle.class) {
            t = (T) parseRectangle(defaultJSONParser);
        } else if (type == java.awt.Color.class) {
            t = (T) parseColor(defaultJSONParser);
        } else if (type == java.awt.Font.class) {
            t = (T) parseFont(defaultJSONParser);
        } else {
            throw new com.alibaba.fastjson.JSONException("not support awt class : " + type);
        }
        com.alibaba.fastjson.parser.ParseContext context = defaultJSONParser.getContext();
        defaultJSONParser.setContext(t, obj);
        defaultJSONParser.setContext(context);
        return t;
    }

    protected java.awt.Font parseFont(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser) {
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = defaultJSONParser.lexer;
        int iIntValue = 0;
        java.lang.String strStringVal = null;
        int iIntValue2 = 0;
        while (jSONLexer.token() != 13) {
            if (jSONLexer.token() == 4) {
                java.lang.String strStringVal2 = jSONLexer.stringVal();
                jSONLexer.nextTokenWithColon(2);
                if (strStringVal2.equalsIgnoreCase("name")) {
                    if (jSONLexer.token() == 4) {
                        strStringVal = jSONLexer.stringVal();
                        jSONLexer.nextToken();
                    } else {
                        throw new com.alibaba.fastjson.JSONException("syntax error");
                    }
                } else if (strStringVal2.equalsIgnoreCase("style")) {
                    if (jSONLexer.token() == 2) {
                        iIntValue = jSONLexer.intValue();
                        jSONLexer.nextToken();
                    } else {
                        throw new com.alibaba.fastjson.JSONException("syntax error");
                    }
                } else if (strStringVal2.equalsIgnoreCase(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE)) {
                    if (jSONLexer.token() == 2) {
                        iIntValue2 = jSONLexer.intValue();
                        jSONLexer.nextToken();
                    } else {
                        throw new com.alibaba.fastjson.JSONException("syntax error");
                    }
                } else {
                    throw new com.alibaba.fastjson.JSONException("syntax error, " + strStringVal2);
                }
                if (jSONLexer.token() == 16) {
                    jSONLexer.nextToken(4);
                }
            } else {
                throw new com.alibaba.fastjson.JSONException("syntax error");
            }
        }
        jSONLexer.nextToken();
        return new java.awt.Font(strStringVal, iIntValue, iIntValue2);
    }

    protected java.awt.Color parseColor(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser) {
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (jSONLexer.token() != 13) {
            if (jSONLexer.token() == 4) {
                java.lang.String strStringVal = jSONLexer.stringVal();
                jSONLexer.nextTokenWithColon(2);
                if (jSONLexer.token() == 2) {
                    int iIntValue = jSONLexer.intValue();
                    jSONLexer.nextToken();
                    if (strStringVal.equalsIgnoreCase("r")) {
                        i = iIntValue;
                    } else if (strStringVal.equalsIgnoreCase("g")) {
                        i2 = iIntValue;
                    } else if (strStringVal.equalsIgnoreCase("b")) {
                        i3 = iIntValue;
                    } else {
                        if (!strStringVal.equalsIgnoreCase("alpha")) {
                            throw new com.alibaba.fastjson.JSONException("syntax error, " + strStringVal);
                        }
                        i4 = iIntValue;
                    }
                    if (jSONLexer.token() == 16) {
                        jSONLexer.nextToken(4);
                    }
                } else {
                    throw new com.alibaba.fastjson.JSONException("syntax error");
                }
            } else {
                throw new com.alibaba.fastjson.JSONException("syntax error");
            }
        }
        jSONLexer.nextToken();
        return new java.awt.Color(i, i2, i3, i4);
    }

    protected java.awt.Rectangle parseRectangle(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser) {
        int iFloatValue;
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (jSONLexer.token() != 13) {
            if (jSONLexer.token() == 4) {
                java.lang.String strStringVal = jSONLexer.stringVal();
                jSONLexer.nextTokenWithColon(2);
                int i5 = jSONLexer.token();
                if (i5 == 2) {
                    iFloatValue = jSONLexer.intValue();
                    jSONLexer.nextToken();
                } else if (i5 == 3) {
                    iFloatValue = (int) jSONLexer.floatValue();
                    jSONLexer.nextToken();
                } else {
                    throw new com.alibaba.fastjson.JSONException("syntax error");
                }
                if (strStringVal.equalsIgnoreCase(com.taobao.weex.common.Constants.Name.X)) {
                    i = iFloatValue;
                } else if (strStringVal.equalsIgnoreCase(com.taobao.weex.common.Constants.Name.Y)) {
                    i2 = iFloatValue;
                } else if (strStringVal.equalsIgnoreCase("width")) {
                    i3 = iFloatValue;
                } else {
                    if (!strStringVal.equalsIgnoreCase("height")) {
                        throw new com.alibaba.fastjson.JSONException("syntax error, " + strStringVal);
                    }
                    i4 = iFloatValue;
                }
                if (jSONLexer.token() == 16) {
                    jSONLexer.nextToken(4);
                }
            } else {
                throw new com.alibaba.fastjson.JSONException("syntax error");
            }
        }
        jSONLexer.nextToken();
        return new java.awt.Rectangle(i, i2, i3, i4);
    }

    protected java.awt.Point parsePoint(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.Object obj) {
        int iFloatValue;
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i = 0;
        int i2 = 0;
        while (jSONLexer.token() != 13) {
            if (jSONLexer.token() == 4) {
                java.lang.String strStringVal = jSONLexer.stringVal();
                if (com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY.equals(strStringVal)) {
                    defaultJSONParser.acceptType("java.awt.Point");
                } else {
                    if ("$ref".equals(strStringVal)) {
                        return (java.awt.Point) parseRef(defaultJSONParser, obj);
                    }
                    jSONLexer.nextTokenWithColon(2);
                    int i3 = jSONLexer.token();
                    if (i3 == 2) {
                        iFloatValue = jSONLexer.intValue();
                        jSONLexer.nextToken();
                    } else if (i3 == 3) {
                        iFloatValue = (int) jSONLexer.floatValue();
                        jSONLexer.nextToken();
                    } else {
                        throw new com.alibaba.fastjson.JSONException("syntax error : " + jSONLexer.tokenName());
                    }
                    if (strStringVal.equalsIgnoreCase(com.taobao.weex.common.Constants.Name.X)) {
                        i = iFloatValue;
                    } else {
                        if (!strStringVal.equalsIgnoreCase(com.taobao.weex.common.Constants.Name.Y)) {
                            throw new com.alibaba.fastjson.JSONException("syntax error, " + strStringVal);
                        }
                        i2 = iFloatValue;
                    }
                    if (jSONLexer.token() == 16) {
                        jSONLexer.nextToken(4);
                    }
                }
            } else {
                throw new com.alibaba.fastjson.JSONException("syntax error");
            }
        }
        jSONLexer.nextToken();
        return new java.awt.Point(i, i2);
    }

    private java.lang.Object parseRef(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.Object obj) {
        com.alibaba.fastjson.parser.JSONLexer lexer = defaultJSONParser.getLexer();
        lexer.nextTokenWithColon(4);
        java.lang.String strStringVal = lexer.stringVal();
        defaultJSONParser.setContext(defaultJSONParser.getContext(), obj);
        defaultJSONParser.addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(defaultJSONParser.getContext(), strStringVal));
        defaultJSONParser.popContext();
        defaultJSONParser.setResolveStatus(1);
        lexer.nextToken(13);
        defaultJSONParser.accept(13);
        return null;
    }
}
