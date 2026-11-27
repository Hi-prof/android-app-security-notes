package io.dcloud.uts;

/* JADX INFO: compiled from: JSON.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u00010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u0002H\u0005\"\u0006\b\u0000\u0010\u0005\u0018\u0001*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086\b¢\u0006\u0002\u0010\tJ,\u0010\u0004\u001a\u0004\u0018\u0001H\u0005\"\u0006\b\u0000\u0010\u0005\u0018\u00012\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0087\b¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0004\u001a\u0004\u0018\u0001H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0010J1\u0010\u0004\u001a\u0004\u0018\u0001H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0012\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001f\u001a\u00020\bH\u0007J\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007J3\u0010 \u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\u00012\u000e\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00172\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\b$J\u0012\u0010 \u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0007Jd\u0010 \u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\u00012D\b\u0002\u0010%\u001a>\u0012\u0013\u0012\u00110\b¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(*\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010&j\u0004\u0018\u0001`+2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0001H\u0007J\u0012\u0010,\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001f\u001a\u00020\bH\u0007J,\u0010,\u001a\u0004\u0018\u0001H\u0005\"\u0006\b\u0000\u0010\u0005\u0018\u00012\u0006\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0087\b¢\u0006\u0004\b-\u0010\rJ\u0016\u0010.\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00172\u0006\u0010\u001f\u001a\u00020\bH\u0007J&\u0010.\u001a\n\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u0017\"\u0006\b\u0000\u0010\u0005\u0018\u00012\u0006\u0010\u001f\u001a\u00020\bH\u0087\b¢\u0006\u0002\b/R\u0011\u0010\u001a\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\n \u001e*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lio/dcloud/uts/JSON;", "", "<init>", "()V", "parse", "T", "Lio/dcloud/uts/gson/Gson;", "json", "", "(Lio/dcloud/uts/gson/Gson;Ljava/lang/String;)Ljava/lang/Object;", "ignoreError", "", "parseType", "(Ljava/lang/String;Z)Ljava/lang/Object;", "typeOfT", "Ljava/lang/reflect/Type;", "(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/lang/reflect/Type;Z)Ljava/lang/Object;", "convertJSONObject", "Lio/dcloud/uts/UTSJSONObject;", "inputObject", "Lcom/alibaba/fastjson/JSONObject;", "convertJSONArray", "Lio/dcloud/uts/UTSArray;", "jsonArray", "Lcom/alibaba/fastjson/JSONArray;", "cacheParseGson", "getCacheParseGson", "()Lio/dcloud/uts/gson/Gson;", "hostAnyType", "kotlin.jvm.PlatformType", "inputString", "stringify", "sourceInput", "replacerArray", "space", "stringify_replacerArray", "replacer", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_KEY, "value", "Lio/dcloud/uts/stringifyReplacer;", "parseObject", "parseObjectType", "parseArray", "parseArrayType", "JSON_SKIP_OBJECT", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class JSON {
    public static final io.dcloud.uts.JSON INSTANCE = new io.dcloud.uts.JSON();
    private static final io.dcloud.uts.gson.Gson cacheParseGson;
    private static final java.lang.reflect.Type hostAnyType;

    private JSON() {
    }

    /* JADX INFO: compiled from: JSON.kt */
    @kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/dcloud/uts/JSON$JSON_SKIP_OBJECT;", "", "<init>", "()V", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class JSON_SKIP_OBJECT {
        public static final io.dcloud.uts.JSON.JSON_SKIP_OBJECT INSTANCE = new io.dcloud.uts.JSON.JSON_SKIP_OBJECT();

        private JSON_SKIP_OBJECT() {
        }
    }

    public final /* synthetic */ <T> T parse(io.dcloud.uts.gson.Gson gson, java.lang.String json) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(gson, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(json, "json");
        kotlin.jvm.internal.Intrinsics.needClassReification();
        return (T) gson.fromJson(json, new io.dcloud.uts.gson.reflect.TypeToken<T>() { // from class: io.dcloud.uts.JSON.parse.1
        }.getType());
    }

    public static /* synthetic */ java.lang.Object parseType$default(java.lang.String json, boolean z, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(json, "json");
        kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(4, "T");
        if (kotlin.jvm.internal.Intrinsics.areEqual("String", java.lang.Object.class.getSimpleName())) {
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(1, "T");
            return json;
        }
        io.dcloud.uts.ObjectKt.getGlobalError().put(java.lang.Thread.currentThread().getName(), null);
        try {
            io.dcloud.uts.gson.Gson cacheParseGson2 = INSTANCE.getCacheParseGson();
            kotlin.jvm.internal.Intrinsics.needClassReification();
            return cacheParseGson2.fromJson(json, new io.dcloud.uts.JSON$parse$$inlined$parse$1().getType());
        } catch (java.lang.Exception e) {
            if (!z) {
                io.dcloud.uts.ObjectKt.getGlobalError().put(java.lang.Thread.currentThread().getName(), e);
            }
            return null;
        }
    }

    @kotlin.jvm.JvmStatic
    public static final /* synthetic */ <T> T parseType(java.lang.String json, boolean ignoreError) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(json, "json");
        kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(4, "T");
        if (kotlin.jvm.internal.Intrinsics.areEqual("String", java.lang.Object.class.getSimpleName())) {
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(1, "T");
            return (T) json;
        }
        io.dcloud.uts.ObjectKt.getGlobalError().put(java.lang.Thread.currentThread().getName(), null);
        try {
            io.dcloud.uts.gson.Gson cacheParseGson2 = INSTANCE.getCacheParseGson();
            kotlin.jvm.internal.Intrinsics.needClassReification();
            return (T) cacheParseGson2.fromJson(json, new io.dcloud.uts.JSON$parse$$inlined$parse$1().getType());
        } catch (java.lang.Exception e) {
            if (!ignoreError) {
                io.dcloud.uts.ObjectKt.getGlobalError().put(java.lang.Thread.currentThread().getName(), e);
            }
            return null;
        }
    }

    @kotlin.jvm.JvmStatic
    public static final <T> T parse(java.lang.String json, java.lang.reflect.Type typeOfT) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(json, "json");
        return (T) parse(json, typeOfT, false);
    }

    public static /* synthetic */ java.lang.Object parse$default(java.lang.String str, java.lang.reflect.Type type, boolean z, int i, java.lang.Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return parse(str, type, z);
    }

    @kotlin.jvm.JvmStatic
    public static final <T> T parse(java.lang.String json, java.lang.reflect.Type typeOfT, boolean ignoreError) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(json, "json");
        if ((typeOfT instanceof java.lang.Class) && java.lang.String.class.isAssignableFrom((java.lang.Class) typeOfT)) {
            return (T) json;
        }
        io.dcloud.uts.ObjectKt.getGlobalError().put(java.lang.Thread.currentThread().getName(), null);
        try {
            return (T) cacheParseGson.fromJson(json, typeOfT);
        } catch (java.lang.Exception e) {
            if (!ignoreError) {
                io.dcloud.uts.ObjectKt.getGlobalError().put(java.lang.Thread.currentThread().getName(), e);
            }
            return null;
        }
    }

    public final io.dcloud.uts.UTSJSONObject convertJSONObject(com.alibaba.fastjson.JSONObject inputObject) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(inputObject, "inputObject");
        io.dcloud.uts.UTSJSONObject uTSJSONObject = new io.dcloud.uts.UTSJSONObject();
        for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : inputObject.entrySet()) {
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(entry, "next(...)");
            java.util.Map.Entry<java.lang.String, java.lang.Object> entry2 = entry;
            java.lang.Object value = entry2.getValue();
            if (value instanceof com.alibaba.fastjson.JSONObject) {
                uTSJSONObject.getDynamicJSONFields().put(entry2.getKey(), convertJSONObject((com.alibaba.fastjson.JSONObject) value));
            } else if (value instanceof com.alibaba.fastjson.JSONArray) {
                uTSJSONObject.getDynamicJSONFields().put(entry2.getKey(), convertJSONArray((com.alibaba.fastjson.JSONArray) value));
            } else {
                uTSJSONObject.getDynamicJSONFields().put(entry2.getKey(), value);
            }
        }
        return uTSJSONObject;
    }

    public final io.dcloud.uts.UTSArray<?> convertJSONArray(com.alibaba.fastjson.JSONArray jsonArray) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
        io.dcloud.uts.UTSArray<?> uTSArray = new io.dcloud.uts.UTSArray<>();
        for (java.lang.Object objConvertJSONArray : jsonArray) {
            if (objConvertJSONArray instanceof com.alibaba.fastjson.JSONObject) {
                objConvertJSONArray = INSTANCE.convertJSONObject((com.alibaba.fastjson.JSONObject) objConvertJSONArray);
            } else if (objConvertJSONArray instanceof com.alibaba.fastjson.JSONArray) {
                objConvertJSONArray = INSTANCE.convertJSONArray((com.alibaba.fastjson.JSONArray) objConvertJSONArray);
            }
            uTSArray.add(objConvertJSONArray);
        }
        return uTSArray;
    }

    static {
        io.dcloud.uts.gson.Gson gsonCreate = new io.dcloud.uts.gson.GsonBuilder().setObjectToNumberStrategy(io.dcloud.uts.gson.ToNumberPolicy.UTS_Number).registerTypeAdapter(io.dcloud.uts.UTSJSONObject.class, new io.dcloud.uts.UTSJsonDeserializer()).create();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(gsonCreate, "create(...)");
        cacheParseGson = gsonCreate;
        hostAnyType = new io.dcloud.uts.gson.reflect.TypeToken<java.lang.Object>() { // from class: io.dcloud.uts.JSON$hostAnyType$1
        }.getType();
    }

    public final io.dcloud.uts.gson.Gson getCacheParseGson() {
        return cacheParseGson;
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Object parse(java.lang.String inputString) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(inputString, "inputString");
        return parse(inputString, false);
    }

    public static /* synthetic */ java.lang.Object parse$default(java.lang.String str, boolean z, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return parse(str, z);
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.Object parse(java.lang.String inputString, boolean ignoreError) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(inputString, "inputString");
        io.dcloud.uts.ObjectKt.getGlobalError().put(java.lang.Thread.currentThread().getName(), null);
        if (kotlin.text.StringsKt.isBlank(inputString)) {
            if (!ignoreError) {
                io.dcloud.uts.ObjectKt.getGlobalError().put(java.lang.Thread.currentThread().getName(), new java.lang.IllegalArgumentException("JSON.parse error: input text is empty"));
            }
            return null;
        }
        try {
            return cacheParseGson.fromJson(inputString, hostAnyType);
        } catch (java.lang.Exception e) {
            if (!ignoreError) {
                io.dcloud.uts.ObjectKt.getGlobalError().put(java.lang.Thread.currentThread().getName(), e);
            }
            return null;
        }
    }

    public static /* synthetic */ java.lang.String stringify_replacerArray$default(java.lang.Object obj, io.dcloud.uts.UTSArray uTSArray, java.lang.Object obj2, int i, java.lang.Object obj3) {
        if ((i & 4) != 0) {
            obj2 = null;
        }
        return stringify_replacerArray(obj, uTSArray, obj2);
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.String stringify_replacerArray(java.lang.Object sourceInput, final io.dcloud.uts.UTSArray<java.lang.Object> replacerArray, java.lang.Object space) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(replacerArray, "replacerArray");
        return stringify(sourceInput, new kotlin.jvm.functions.Function2() { // from class: io.dcloud.uts.JSON$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2) {
                return io.dcloud.uts.JSON.stringify$lambda$1(replacerArray, obj, obj2);
            }
        }, space);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Object stringify$lambda$1(io.dcloud.uts.UTSArray<java.lang.Object> uTSArray, java.lang.Object obj, java.lang.Object obj2) {
        return (kotlin.jvm.internal.Intrinsics.areEqual(obj, "") || uTSArray.contains(obj)) ? obj2 : io.dcloud.uts.JSON.JSON_SKIP_OBJECT.INSTANCE;
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.String stringify(java.lang.Object sourceInput) {
        return stringify(sourceInput, null, null);
    }

    public static /* synthetic */ java.lang.String stringify$default(java.lang.Object obj, kotlin.jvm.functions.Function2 function2, java.lang.Object obj2, int i, java.lang.Object obj3) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            obj2 = null;
        }
        return stringify(obj, function2, obj2);
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.String stringify(java.lang.Object sourceInput, kotlin.jvm.functions.Function2<? super java.lang.String, java.lang.Object, ? extends java.lang.Object> replacer, java.lang.Object space) {
        if (replacer != null) {
            sourceInput = replacer.invoke("", sourceInput);
        }
        if (sourceInput == null) {
            java.lang.String string = io.dcloud.uts.gson.JsonNull.INSTANCE.toString();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
        if (sourceInput instanceof kotlin.Function) {
            return "";
        }
        if (sourceInput instanceof java.lang.Number) {
            if (io.dcloud.uts.UTSNumber.INSTANCE.isNaN(sourceInput)) {
                java.lang.String string2 = io.dcloud.uts.gson.JsonNull.INSTANCE.toString();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                return string2;
            }
            if (kotlin.jvm.internal.Intrinsics.areEqual(sourceInput, java.lang.Double.valueOf(Double.POSITIVE_INFINITY)) || kotlin.jvm.internal.Intrinsics.areEqual(sourceInput, java.lang.Float.valueOf(Float.POSITIVE_INFINITY)) || kotlin.jvm.internal.Intrinsics.areEqual(sourceInput, java.lang.Double.valueOf(Double.NEGATIVE_INFINITY)) || kotlin.jvm.internal.Intrinsics.areEqual(sourceInput, java.lang.Float.valueOf(Float.NEGATIVE_INFINITY))) {
                java.lang.String string3 = io.dcloud.uts.gson.JsonNull.INSTANCE.toString();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
                return string3;
            }
            return io.dcloud.uts.android.ClassLogWrapper.INSTANCE.wrapNumberText(sourceInput);
        }
        if (sourceInput instanceof com.alibaba.fastjson.JSONObject) {
            java.lang.String jSONString = ((com.alibaba.fastjson.JSONObject) sourceInput).toJSONString();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(...)");
            return jSONString;
        }
        io.dcloud.uts.gson.JsonElement jsonElementEncode = new io.dcloud.uts.android.UTSGsonEncoder().encode(sourceInput, replacer);
        if (jsonElementEncode == null) {
            java.lang.String string4 = io.dcloud.uts.gson.JsonNull.INSTANCE.toString();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string4, "toString(...)");
            return string4;
        }
        if (space == null) {
            java.lang.String string5 = jsonElementEncode.toString();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string5, "toString(...)");
            return string5;
        }
        if (space instanceof java.lang.Number) {
            int iIntValue = ((java.lang.Number) space).intValue();
            if (iIntValue > 0) {
                java.lang.String string6 = jsonElementEncode.toString(io.dcloud.uts.StringKt.repeat(com.taobao.weex.el.parse.Operators.SPACE_STR, java.lang.Integer.valueOf(iIntValue <= 10 ? iIntValue : 10)));
                kotlin.jvm.internal.Intrinsics.checkNotNull(string6);
                return string6;
            }
            java.lang.String string7 = jsonElementEncode.toString();
            kotlin.jvm.internal.Intrinsics.checkNotNull(string7);
            return string7;
        }
        if (space instanceof java.lang.String) {
            java.lang.String strSubstring = (java.lang.String) space;
            if (strSubstring.length() > 10) {
                strSubstring = io.dcloud.uts.StringKt.substring(strSubstring, (java.lang.Number) 0, (java.lang.Number) 10);
            }
            java.lang.String string8 = jsonElementEncode.toString(strSubstring);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string8, "toString(...)");
            return string8;
        }
        java.lang.String string9 = jsonElementEncode.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string9, "toString(...)");
        return string9;
    }

    @kotlin.jvm.JvmStatic
    public static final io.dcloud.uts.UTSJSONObject parseObject(java.lang.String inputString) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(inputString, "inputString");
        java.lang.Object obj = parse(inputString);
        if (obj != null && (obj instanceof io.dcloud.uts.UTSJSONObject)) {
            return (io.dcloud.uts.UTSJSONObject) obj;
        }
        return null;
    }

    public static /* synthetic */ java.lang.Object parseObjectType$default(java.lang.String inputString, boolean z, int i, java.lang.Object obj) {
        java.lang.String strFromJson;
        if ((i & 2) != 0) {
            z = false;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(inputString, "inputString");
        io.dcloud.uts.JSON json = INSTANCE;
        kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(4, "T");
        if (kotlin.jvm.internal.Intrinsics.areEqual("String", java.lang.Object.class.getSimpleName())) {
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(1, "T");
            strFromJson = inputString;
        } else {
            io.dcloud.uts.ObjectKt.getGlobalError().put(java.lang.Thread.currentThread().getName(), null);
            try {
                io.dcloud.uts.gson.Gson cacheParseGson2 = json.getCacheParseGson();
                kotlin.jvm.internal.Intrinsics.needClassReification();
                strFromJson = cacheParseGson2.fromJson(inputString, new io.dcloud.uts.JSON$parseObject$$inlined$parseType$1().getType());
            } catch (java.lang.Exception e) {
                if (!z) {
                    io.dcloud.uts.ObjectKt.getGlobalError().put(java.lang.Thread.currentThread().getName(), e);
                }
                strFromJson = null;
            }
        }
        if (strFromJson == null) {
            return null;
        }
        return strFromJson;
    }

    @kotlin.jvm.JvmStatic
    public static final /* synthetic */ <T> T parseObjectType(java.lang.String inputString, boolean ignoreError) {
        T t;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(inputString, "inputString");
        io.dcloud.uts.JSON json = INSTANCE;
        kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(4, "T");
        if (kotlin.jvm.internal.Intrinsics.areEqual("String", java.lang.Object.class.getSimpleName())) {
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(1, "T");
            t = (T) inputString;
        } else {
            io.dcloud.uts.ObjectKt.getGlobalError().put(java.lang.Thread.currentThread().getName(), null);
            try {
                io.dcloud.uts.gson.Gson cacheParseGson2 = json.getCacheParseGson();
                kotlin.jvm.internal.Intrinsics.needClassReification();
                t = (T) cacheParseGson2.fromJson(inputString, new io.dcloud.uts.JSON$parseObject$$inlined$parseType$1().getType());
            } catch (java.lang.Exception e) {
                if (!ignoreError) {
                    io.dcloud.uts.ObjectKt.getGlobalError().put(java.lang.Thread.currentThread().getName(), e);
                }
                t = null;
            }
        }
        if (t == null) {
            return null;
        }
        return t;
    }

    @kotlin.jvm.JvmStatic
    public static final io.dcloud.uts.UTSArray<?> parseArray(java.lang.String inputString) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(inputString, "inputString");
        java.lang.Object obj = parse(inputString);
        if (obj != null && (obj instanceof io.dcloud.uts.UTSArray)) {
            return (io.dcloud.uts.UTSArray) obj;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.jvm.JvmStatic
    public static final /* synthetic */ <T> io.dcloud.uts.UTSArray<T> parseArrayType(java.lang.String inputString) {
        java.lang.Object objFromJson;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(inputString, "inputString");
        io.dcloud.uts.JSON json = INSTANCE;
        if (kotlin.jvm.internal.Intrinsics.areEqual("String", "UTSArray")) {
            objFromJson = (io.dcloud.uts.UTSArray) inputString;
        } else {
            io.dcloud.uts.ObjectKt.getGlobalError().put(java.lang.Thread.currentThread().getName(), null);
            try {
                io.dcloud.uts.gson.Gson cacheParseGson2 = json.getCacheParseGson();
                kotlin.jvm.internal.Intrinsics.needClassReification();
                objFromJson = cacheParseGson2.fromJson(inputString, new io.dcloud.uts.gson.reflect.TypeToken<io.dcloud.uts.UTSArray<T>>() { // from class: io.dcloud.uts.JSON$parseArray$$inlined$parseType$default$1
                }.getType());
            } catch (java.lang.Exception e) {
                io.dcloud.uts.ObjectKt.getGlobalError().put(java.lang.Thread.currentThread().getName(), e);
                objFromJson = null;
            }
        }
        io.dcloud.uts.UTSArray<T> uTSArray = (io.dcloud.uts.UTSArray) objFromJson;
        if (uTSArray != null) {
            return uTSArray;
        }
        return null;
    }
}
