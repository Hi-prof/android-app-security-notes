package com.alibaba.fastjson.parser.deserializer;

/* JADX INFO: loaded from: classes.dex */
public class MapDeserializer extends com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer implements com.alibaba.fastjson.parser.deserializer.ObjectDeserializer {
    public static com.alibaba.fastjson.parser.deserializer.MapDeserializer instance = new com.alibaba.fastjson.parser.deserializer.MapDeserializer();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj, java.lang.String str, int i) throws java.lang.Throwable {
        java.util.Map<java.lang.Object, java.lang.Object> mapCreateMap;
        com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser2;
        if (type == com.alibaba.fastjson.JSONObject.class && defaultJSONParser.getFieldTypeResolver() == null) {
            return (T) defaultJSONParser.parseObject();
        }
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken(16);
            return null;
        }
        boolean z = (type instanceof java.lang.Class) && "java.util.Collections$UnmodifiableMap".equals(((java.lang.Class) type).getName());
        if ((jSONLexer.getFeatures() & com.alibaba.fastjson.parser.Feature.OrderedField.mask) != 0) {
            mapCreateMap = createMap(type, jSONLexer.getFeatures());
        } else {
            mapCreateMap = createMap(type);
        }
        java.util.Map<java.lang.Object, java.lang.Object> map = mapCreateMap;
        com.alibaba.fastjson.parser.ParseContext context = defaultJSONParser.getContext();
        try {
            defaultJSONParser.setContext(context, map, obj);
            defaultJSONParser2 = defaultJSONParser;
            try {
                java.util.Map map2 = (T) deserialze(defaultJSONParser2, type, obj, map, i);
                if (z) {
                    map2 = (T) java.util.Collections.unmodifiableMap(map2);
                }
                defaultJSONParser2.setContext(context);
                return (T) map2;
            } catch (java.lang.Throwable th) {
                th = th;
                java.lang.Throwable th2 = th;
                defaultJSONParser2.setContext(context);
                throw th2;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            defaultJSONParser2 = defaultJSONParser;
        }
    }

    protected java.lang.Object deserialze(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj, java.util.Map map) {
        return deserialze(defaultJSONParser, type, obj, map, 0);
    }

    protected java.lang.Object deserialze(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj, java.util.Map map, int i) {
        java.lang.reflect.Type type2;
        if (type instanceof java.lang.reflect.ParameterizedType) {
            java.lang.reflect.ParameterizedType parameterizedType = (java.lang.reflect.ParameterizedType) type;
            java.lang.reflect.Type type3 = parameterizedType.getActualTypeArguments()[0];
            if (map.getClass().getName().equals("org.springframework.util.LinkedMultiValueMap")) {
                type2 = java.util.List.class;
            } else {
                type2 = parameterizedType.getActualTypeArguments()[1];
            }
            if (java.lang.String.class == type3) {
                return parseMap(defaultJSONParser, (java.util.Map<java.lang.String, java.lang.Object>) map, type2, obj, i);
            }
            return parseMap(defaultJSONParser, (java.util.Map<java.lang.Object, java.lang.Object>) map, type3, type2, obj);
        }
        return defaultJSONParser.parseObject(map, obj);
    }

    public static java.util.Map parseMap(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.reflect.Type type, java.lang.Object obj) {
        return parseMap(defaultJSONParser, map, type, obj, 0);
    }

    public static java.util.Map parseMap(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.reflect.Type type, java.lang.Object obj, int i) {
        java.lang.String strScanSymbolUnQuoted;
        java.lang.Object object;
        java.lang.Class<?> clsCheckAutoType;
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i2 = jSONLexer.token();
        int i3 = 0;
        if (i2 != 12) {
            if (i2 == 4) {
                java.lang.String strStringVal = jSONLexer.stringVal();
                if (strStringVal.length() == 0 || strStringVal.equals("null")) {
                    return null;
                }
            }
            java.lang.String str = "syntax error, expect {, actual " + jSONLexer.tokenName();
            if (obj instanceof java.lang.String) {
                str = (str + ", fieldName ") + obj;
            }
            java.lang.String str2 = (str + ", ") + jSONLexer.info();
            if (i2 != 4) {
                com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray();
                defaultJSONParser.parseArray(jSONArray, obj);
                if (jSONArray.size() == 1) {
                    java.lang.Object obj2 = jSONArray.get(0);
                    if (obj2 instanceof com.alibaba.fastjson.JSONObject) {
                        return (com.alibaba.fastjson.JSONObject) obj2;
                    }
                }
            }
            throw new com.alibaba.fastjson.JSONException(str2);
        }
        com.alibaba.fastjson.parser.ParseContext context = defaultJSONParser.getContext();
        while (true) {
            try {
                jSONLexer.skipWhitespace();
                char current = jSONLexer.getCurrent();
                if (jSONLexer.isEnabled(com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas)) {
                    while (current == ',') {
                        jSONLexer.next();
                        jSONLexer.skipWhitespace();
                        current = jSONLexer.getCurrent();
                    }
                }
                if (current == '\"') {
                    strScanSymbolUnQuoted = jSONLexer.scanSymbol(defaultJSONParser.getSymbolTable(), '\"');
                    jSONLexer.skipWhitespace();
                    if (jSONLexer.getCurrent() != ':') {
                        throw new com.alibaba.fastjson.JSONException("expect ':' at " + jSONLexer.pos());
                    }
                } else {
                    if (current == '}') {
                        jSONLexer.next();
                        jSONLexer.resetStringPosition();
                        jSONLexer.nextToken(16);
                        defaultJSONParser.setContext(context);
                        return map;
                    }
                    if (current == '\'') {
                        if (!jSONLexer.isEnabled(com.alibaba.fastjson.parser.Feature.AllowSingleQuotes)) {
                            throw new com.alibaba.fastjson.JSONException("syntax error");
                        }
                        strScanSymbolUnQuoted = jSONLexer.scanSymbol(defaultJSONParser.getSymbolTable(), com.taobao.weex.el.parse.Operators.SINGLE_QUOTE);
                        jSONLexer.skipWhitespace();
                        if (jSONLexer.getCurrent() != ':') {
                            throw new com.alibaba.fastjson.JSONException("expect ':' at " + jSONLexer.pos());
                        }
                    } else {
                        if (!jSONLexer.isEnabled(com.alibaba.fastjson.parser.Feature.AllowUnQuotedFieldNames)) {
                            throw new com.alibaba.fastjson.JSONException("syntax error");
                        }
                        strScanSymbolUnQuoted = jSONLexer.scanSymbolUnQuoted(defaultJSONParser.getSymbolTable());
                        jSONLexer.skipWhitespace();
                        char current2 = jSONLexer.getCurrent();
                        if (current2 != ':') {
                            throw new com.alibaba.fastjson.JSONException("expect ':' at " + jSONLexer.pos() + ", actual " + current2);
                        }
                    }
                }
                jSONLexer.next();
                jSONLexer.skipWhitespace();
                jSONLexer.getCurrent();
                jSONLexer.resetStringPosition();
                if (strScanSymbolUnQuoted != com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY || jSONLexer.isEnabled(com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect) || com.alibaba.fastjson.parser.Feature.isEnabled(i, com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect)) {
                    jSONLexer.nextToken();
                    if (i3 != 0) {
                        defaultJSONParser.setContext(context);
                    }
                    if (jSONLexer.token() == 8) {
                        jSONLexer.nextToken();
                        object = null;
                    } else {
                        object = defaultJSONParser.parseObject(type, strScanSymbolUnQuoted);
                    }
                    map.put(strScanSymbolUnQuoted, object);
                    defaultJSONParser.checkMapResolve(map, strScanSymbolUnQuoted);
                    defaultJSONParser.setContext(context, object, strScanSymbolUnQuoted);
                    defaultJSONParser.setContext(context);
                    int i4 = jSONLexer.token();
                    if (i4 != 20 && i4 != 15) {
                        if (i4 == 13) {
                            jSONLexer.nextToken();
                            defaultJSONParser.setContext(context);
                            return map;
                        }
                    }
                    defaultJSONParser.setContext(context);
                    return map;
                }
                java.lang.String strScanSymbol = jSONLexer.scanSymbol(defaultJSONParser.getSymbolTable(), '\"');
                com.alibaba.fastjson.parser.ParserConfig config = defaultJSONParser.getConfig();
                if (strScanSymbol.equals("java.util.HashMap")) {
                    clsCheckAutoType = java.util.HashMap.class;
                } else if (strScanSymbol.equals("java.util.LinkedHashMap")) {
                    clsCheckAutoType = java.util.LinkedHashMap.class;
                } else if (config.isSafeMode()) {
                    clsCheckAutoType = java.util.HashMap.class;
                } else {
                    try {
                        clsCheckAutoType = config.checkAutoType(strScanSymbol, null, jSONLexer.getFeatures());
                    } catch (com.alibaba.fastjson.JSONException unused) {
                        clsCheckAutoType = java.util.HashMap.class;
                    }
                }
                if (!java.util.Map.class.isAssignableFrom(clsCheckAutoType)) {
                    com.alibaba.fastjson.parser.deserializer.ObjectDeserializer deserializer = config.getDeserializer(clsCheckAutoType);
                    jSONLexer.nextToken(16);
                    defaultJSONParser.setResolveStatus(2);
                    if (context != null && !(obj instanceof java.lang.Integer)) {
                        defaultJSONParser.popContext();
                    }
                    java.util.Map map2 = (java.util.Map) deserializer.deserialze(defaultJSONParser, clsCheckAutoType, obj);
                    defaultJSONParser.setContext(context);
                    return map2;
                }
                jSONLexer.nextToken(16);
                if (jSONLexer.token() == 13) {
                    jSONLexer.nextToken(16);
                    defaultJSONParser.setContext(context);
                    return map;
                }
                i3++;
            } catch (java.lang.Throwable th) {
                defaultJSONParser.setContext(context);
                throw th;
            }
        }
    }

    public static java.lang.Object parseMap(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.util.Map<java.lang.Object, java.lang.Object> map, java.lang.reflect.Type type, java.lang.reflect.Type type2, java.lang.Object obj) {
        java.lang.Object objDeserialze;
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() != 12 && jSONLexer.token() != 16) {
            throw new com.alibaba.fastjson.JSONException("syntax error, expect {, actual " + jSONLexer.tokenName());
        }
        com.alibaba.fastjson.parser.deserializer.ObjectDeserializer deserializer = defaultJSONParser.getConfig().getDeserializer(type);
        com.alibaba.fastjson.parser.deserializer.ObjectDeserializer deserializer2 = defaultJSONParser.getConfig().getDeserializer(type2);
        jSONLexer.nextToken(deserializer.getFastMatchToken());
        com.alibaba.fastjson.parser.ParseContext context = defaultJSONParser.getContext();
        while (jSONLexer.token() != 13) {
            try {
                java.lang.Object obj2 = null;
                if (jSONLexer.token() == 4 && jSONLexer.isRef() && !jSONLexer.isEnabled(com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect)) {
                    jSONLexer.nextTokenWithColon(4);
                    if (jSONLexer.token() != 4) {
                        throw new com.alibaba.fastjson.JSONException("illegal ref, " + com.alibaba.fastjson.parser.JSONToken.name(jSONLexer.token()));
                    }
                    java.lang.String strStringVal = jSONLexer.stringVal();
                    if (io.dcloud.common.util.PdrUtil.FILE_PATH_ENTRY_BACK.equals(strStringVal)) {
                        obj2 = context.parent.object;
                    } else if (com.taobao.weex.el.parse.Operators.DOLLAR_STR.equals(strStringVal)) {
                        com.alibaba.fastjson.parser.ParseContext parseContext = context;
                        while (parseContext.parent != null) {
                            parseContext = parseContext.parent;
                        }
                        obj2 = parseContext.object;
                    } else {
                        defaultJSONParser.addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(context, strStringVal));
                        defaultJSONParser.setResolveStatus(1);
                    }
                    jSONLexer.nextToken(13);
                    if (jSONLexer.token() != 13) {
                        throw new com.alibaba.fastjson.JSONException("illegal ref");
                    }
                    jSONLexer.nextToken(16);
                    defaultJSONParser.setContext(context);
                    return obj2;
                }
                if (map.size() == 0 && jSONLexer.token() == 4 && com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY.equals(jSONLexer.stringVal()) && !jSONLexer.isEnabled(com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect)) {
                    jSONLexer.nextTokenWithColon(4);
                    jSONLexer.nextToken(16);
                    if (jSONLexer.token() == 13) {
                        jSONLexer.nextToken();
                        defaultJSONParser.setContext(context);
                        return map;
                    }
                    jSONLexer.nextToken(deserializer.getFastMatchToken());
                }
                if (jSONLexer.token() == 4 && (deserializer instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer)) {
                    java.lang.String strStringVal2 = jSONLexer.stringVal();
                    jSONLexer.nextToken();
                    com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser2 = new com.alibaba.fastjson.parser.DefaultJSONParser(strStringVal2, defaultJSONParser.getConfig(), defaultJSONParser.getLexer().getFeatures());
                    defaultJSONParser2.setDateFormat(defaultJSONParser.getDateFomartPattern());
                    objDeserialze = deserializer.deserialze(defaultJSONParser2, type, null);
                } else {
                    objDeserialze = deserializer.deserialze(defaultJSONParser, type, null);
                }
                if (jSONLexer.token() != 17) {
                    throw new com.alibaba.fastjson.JSONException("syntax error, expect :, actual " + jSONLexer.token());
                }
                jSONLexer.nextToken(deserializer2.getFastMatchToken());
                java.lang.Object objDeserialze2 = deserializer2.deserialze(defaultJSONParser, type2, objDeserialze);
                defaultJSONParser.checkMapResolve(map, objDeserialze);
                map.put(objDeserialze, objDeserialze2);
                if (jSONLexer.token() == 16) {
                    jSONLexer.nextToken(deserializer.getFastMatchToken());
                }
            } catch (java.lang.Throwable th) {
                defaultJSONParser.setContext(context);
                throw th;
            }
        }
        jSONLexer.nextToken(16);
        defaultJSONParser.setContext(context);
        return map;
    }

    public java.util.Map<java.lang.Object, java.lang.Object> createMap(java.lang.reflect.Type type) {
        return createMap(type, com.alibaba.fastjson.JSON.DEFAULT_GENERATE_FEATURE);
    }

    public java.util.Map<java.lang.Object, java.lang.Object> createMap(java.lang.reflect.Type type, int i) {
        if (type == java.util.Properties.class) {
            return new java.util.Properties();
        }
        if (type == java.util.Hashtable.class) {
            return new java.util.Hashtable();
        }
        if (type == java.util.IdentityHashMap.class) {
            return new java.util.IdentityHashMap();
        }
        if (type == java.util.SortedMap.class || type == java.util.TreeMap.class) {
            return new java.util.TreeMap();
        }
        if (type == java.util.concurrent.ConcurrentMap.class || type == java.util.concurrent.ConcurrentHashMap.class) {
            return new java.util.concurrent.ConcurrentHashMap();
        }
        if (type == java.util.Map.class) {
            return (com.alibaba.fastjson.parser.Feature.OrderedField.mask & i) != 0 ? new java.util.LinkedHashMap() : new java.util.HashMap();
        }
        if (type == java.util.HashMap.class) {
            return new java.util.HashMap();
        }
        if (type == java.util.LinkedHashMap.class) {
            return new java.util.LinkedHashMap();
        }
        if (type instanceof java.lang.reflect.ParameterizedType) {
            java.lang.reflect.ParameterizedType parameterizedType = (java.lang.reflect.ParameterizedType) type;
            java.lang.reflect.Type rawType = parameterizedType.getRawType();
            if (java.util.EnumMap.class.equals(rawType)) {
                return new java.util.EnumMap((java.lang.Class) parameterizedType.getActualTypeArguments()[0]);
            }
            return createMap(rawType, i);
        }
        java.lang.Class cls = (java.lang.Class) type;
        if (cls.isInterface()) {
            throw new com.alibaba.fastjson.JSONException("unsupport type " + type);
        }
        if ("java.util.Collections$UnmodifiableMap".equals(cls.getName())) {
            return new java.util.HashMap();
        }
        try {
            return (java.util.Map) cls.newInstance();
        } catch (java.lang.Exception e) {
            throw new com.alibaba.fastjson.JSONException("unsupport type " + type, e);
        }
    }
}
