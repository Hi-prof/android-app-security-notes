package com.alibaba.fastjson.parser.deserializer;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractDateDeserializer extends com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer implements com.alibaba.fastjson.parser.deserializer.ObjectDeserializer {
    protected abstract <T> T cast(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj, java.lang.Object obj2);

    @Override // com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj) {
        return (T) deserialze(defaultJSONParser, type, obj, null, 0);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj, java.lang.String str, int i) {
        java.lang.Object objValueOf;
        java.lang.Object obj2;
        java.lang.Object time;
        java.text.SimpleDateFormat simpleDateFormat;
        java.lang.Object obj3;
        java.text.SimpleDateFormat simpleDateFormat2;
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 2) {
            long jLongValue = jSONLexer.longValue();
            jSONLexer.nextToken(16);
            if ("unixtime".equals(str)) {
                jLongValue *= 1000;
            }
            objValueOf = java.lang.Long.valueOf(jLongValue);
        } else {
            java.lang.Object obj4 = null;
            if (jSONLexer.token() == 4) {
                java.lang.String strStringVal = jSONLexer.stringVal();
                if (str != null) {
                    if ("yyyy-MM-dd HH:mm:ss.SSSSSSSSS".equals(str) && (type instanceof java.lang.Class) && ((java.lang.Class) type).getName().equals("java.sql.Timestamp")) {
                        return (T) com.alibaba.fastjson.util.TypeUtils.castToTimestamp(strStringVal);
                    }
                    try {
                        simpleDateFormat = new java.text.SimpleDateFormat(str, defaultJSONParser.lexer.getLocale());
                    } catch (java.lang.IllegalArgumentException e) {
                        if (str.contains("T")) {
                            try {
                                simpleDateFormat = new java.text.SimpleDateFormat(str.replaceAll("T", "'T'"), defaultJSONParser.lexer.getLocale());
                            } catch (java.lang.IllegalArgumentException unused) {
                                throw e;
                            }
                        } else {
                            simpleDateFormat = null;
                        }
                    }
                    if (com.alibaba.fastjson.JSON.defaultTimeZone != null) {
                        simpleDateFormat.setTimeZone(defaultJSONParser.lexer.getTimeZone());
                    }
                    try {
                        obj3 = simpleDateFormat.parse(strStringVal);
                    } catch (java.text.ParseException unused2) {
                        obj3 = null;
                    }
                    if (obj3 == null && com.alibaba.fastjson.JSON.defaultLocale == java.util.Locale.CHINA) {
                        try {
                            simpleDateFormat2 = new java.text.SimpleDateFormat(str, java.util.Locale.US);
                        } catch (java.lang.IllegalArgumentException e2) {
                            simpleDateFormat2 = simpleDateFormat;
                            if (str.contains("T")) {
                                try {
                                    simpleDateFormat2 = new java.text.SimpleDateFormat(str.replaceAll("T", "'T'"), defaultJSONParser.lexer.getLocale());
                                } catch (java.lang.IllegalArgumentException unused3) {
                                    throw e2;
                                }
                            }
                        }
                        simpleDateFormat2.setTimeZone(defaultJSONParser.lexer.getTimeZone());
                        try {
                            obj3 = simpleDateFormat2.parse(strStringVal);
                        } catch (java.text.ParseException unused4) {
                            obj3 = null;
                        }
                    }
                    if (obj3 != null) {
                        obj4 = obj3;
                    } else if (str.equals("yyyy-MM-dd'T'HH:mm:ss.SSS") && strStringVal.length() == 19) {
                        try {
                            java.text.SimpleDateFormat simpleDateFormat3 = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", com.alibaba.fastjson.JSON.defaultLocale);
                            simpleDateFormat3.setTimeZone(com.alibaba.fastjson.JSON.defaultTimeZone);
                            obj4 = simpleDateFormat3.parse(strStringVal);
                        } catch (java.text.ParseException unused5) {
                        }
                    }
                }
                if (obj4 == null) {
                    jSONLexer.nextToken(16);
                    if (jSONLexer.isEnabled(com.alibaba.fastjson.parser.Feature.AllowISO8601DateFormat)) {
                        com.alibaba.fastjson.parser.JSONScanner jSONScanner = new com.alibaba.fastjson.parser.JSONScanner(strStringVal);
                        if (jSONScanner.scanISO8601DateIfMatch()) {
                            obj2 = strStringVal;
                            time = strStringVal;
                            time = jSONScanner.getCalendar().getTime();
                        }
                        obj2 = strStringVal;
                        time = strStringVal;
                        jSONScanner.close();
                        obj2 = time;
                    }
                    obj2 = strStringVal;
                    objValueOf = obj2;
                } else {
                    objValueOf = obj4;
                }
            } else if (jSONLexer.token() == 8) {
                jSONLexer.nextToken();
                objValueOf = obj4;
            } else if (jSONLexer.token() == 12) {
                jSONLexer.nextToken();
                if (jSONLexer.token() == 4) {
                    if (com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY.equals(jSONLexer.stringVal())) {
                        jSONLexer.nextToken();
                        defaultJSONParser.accept(17);
                        java.lang.reflect.Type typeCheckAutoType = defaultJSONParser.getConfig().checkAutoType(jSONLexer.stringVal(), null, jSONLexer.getFeatures());
                        if (typeCheckAutoType != null) {
                            type = typeCheckAutoType;
                        }
                        defaultJSONParser.accept(4);
                        defaultJSONParser.accept(16);
                    }
                    jSONLexer.nextTokenWithColon(2);
                    if (jSONLexer.token() == 2) {
                        long jLongValue2 = jSONLexer.longValue();
                        jSONLexer.nextToken();
                        java.lang.Object objValueOf2 = java.lang.Long.valueOf(jLongValue2);
                        defaultJSONParser.accept(13);
                        objValueOf = objValueOf2;
                    } else {
                        throw new com.alibaba.fastjson.JSONException("syntax error : " + jSONLexer.tokenName());
                    }
                } else {
                    throw new com.alibaba.fastjson.JSONException("syntax error");
                }
            } else if (defaultJSONParser.getResolveStatus() == 2) {
                defaultJSONParser.setResolveStatus(0);
                defaultJSONParser.accept(16);
                if (jSONLexer.token() == 4) {
                    if (!"val".equals(jSONLexer.stringVal())) {
                        throw new com.alibaba.fastjson.JSONException("syntax error");
                    }
                    jSONLexer.nextToken();
                    defaultJSONParser.accept(17);
                    java.lang.Object obj5 = defaultJSONParser.parse();
                    defaultJSONParser.accept(13);
                    objValueOf = obj5;
                } else {
                    throw new com.alibaba.fastjson.JSONException("syntax error");
                }
            } else {
                objValueOf = defaultJSONParser.parse();
            }
        }
        return (T) cast(defaultJSONParser, type, obj, objValueOf);
    }
}
