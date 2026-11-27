package io.dcloud.uts.android;

/* JADX INFO: compiled from: UTSGsonEncoder.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000f\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JX\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012D\b\u0002\u0010\u0007\u001a>\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\bj\u0004\u0018\u0001`\u000e¨\u0006\u0011"}, d2 = {"Lio/dcloud/uts/android/UTSGsonEncoder;", "", "<init>", "()V", "encode", "Lio/dcloud/uts/gson/JsonElement;", "obj", "replacer", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_KEY, "value", "Lio/dcloud/uts/stringifyReplacer;", "Companion", "EncodeType", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UTSGsonEncoder {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final io.dcloud.uts.android.UTSGsonEncoder.Companion INSTANCE = new io.dcloud.uts.android.UTSGsonEncoder.Companion(null);
    private static java.util.List<io.dcloud.uts.android.UTSGsonEncoder.EncodeType> allType;

    /* JADX INFO: compiled from: UTSGsonEncoder.kt */
    @kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H&Jf\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012B\u0010\t\u001a>\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\nj\u0004\u0018\u0001`\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0011H&¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lio/dcloud/uts/android/UTSGsonEncoder$EncodeType;", "", "typeName", "", "isType", "", "obj", "getTypeGsonInstance", "Lio/dcloud/uts/gson/JsonElement;", "replacer", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_KEY, "value", "Lio/dcloud/uts/stringifyReplacer;", "hostStock", "", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface EncodeType {
        io.dcloud.uts.gson.JsonElement getTypeGsonInstance(java.lang.Object obj, kotlin.jvm.functions.Function2<? super java.lang.String, java.lang.Object, ? extends java.lang.Object> replacer, java.util.Set<java.lang.Object> hostStock);

        boolean isType(java.lang.Object obj);

        java.lang.String typeName();
    }

    /* JADX INFO: compiled from: UTSGsonEncoder.kt */
    @kotlin.Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jf\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00012B\u0010\n\u001a>\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000bj\u0004\u0018\u0001`\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lio/dcloud/uts/android/UTSGsonEncoder$Companion;", "", "<init>", "()V", "allType", "", "Lio/dcloud/uts/android/UTSGsonEncoder$EncodeType;", "getGsonElement", "Lio/dcloud/uts/gson/JsonElement;", "input", "replacer", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_KEY, "value", "Lio/dcloud/uts/stringifyReplacer;", "inputStock", "", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final io.dcloud.uts.gson.JsonElement getGsonElement(java.lang.Object input, kotlin.jvm.functions.Function2<? super java.lang.String, java.lang.Object, ? extends java.lang.Object> replacer, java.util.Set<java.lang.Object> inputStock) {
            io.dcloud.uts.gson.JsonElement typeGsonInstance = null;
            if (input instanceof kotlin.Function) {
                return null;
            }
            if (input == null) {
                return io.dcloud.uts.gson.JsonNull.INSTANCE;
            }
            if (inputStock.contains(input)) {
                io.dcloud.uts.console.error("JSON stringify 错误 : Converting circular structure to JSON ");
                inputStock.remove(input);
                return io.dcloud.uts.gson.JsonNull.INSTANCE;
            }
            inputStock.add(input);
            for (io.dcloud.uts.android.UTSGsonEncoder.EncodeType encodeType : io.dcloud.uts.android.UTSGsonEncoder.allType) {
                if (encodeType.isType(input)) {
                    typeGsonInstance = encodeType.getTypeGsonInstance(input, replacer, inputStock);
                    break;
                }
            }
            inputStock.remove(input);
            return typeGsonInstance != null ? typeGsonInstance : new io.dcloud.uts.gson.JsonObject();
        }
    }

    static {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        allType = arrayList;
        arrayList.add(new io.dcloud.uts.android.UTSGsonEncoder.EncodeType() { // from class: io.dcloud.uts.android.UTSGsonEncoder.Companion.1
            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public java.lang.String typeName() {
                return "json基础数据类型";
            }

            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public boolean isType(java.lang.Object obj) {
                return obj == null || (obj instanceof java.lang.String) || (obj instanceof java.lang.Character) || (obj instanceof java.lang.Boolean) || (obj instanceof java.lang.Number);
            }

            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public io.dcloud.uts.gson.JsonElement getTypeGsonInstance(java.lang.Object obj, kotlin.jvm.functions.Function2<? super java.lang.String, java.lang.Object, ? extends java.lang.Object> replacer, java.util.Set<java.lang.Object> hostStock) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(hostStock, "hostStock");
                if (obj == null) {
                    return io.dcloud.uts.gson.JsonNull.INSTANCE;
                }
                if (obj instanceof java.lang.Number) {
                    if (io.dcloud.uts.UTSNumber.INSTANCE.isNaN(obj)) {
                        return io.dcloud.uts.gson.JsonNull.INSTANCE;
                    }
                    if (kotlin.jvm.internal.Intrinsics.areEqual(obj, java.lang.Double.valueOf(Double.POSITIVE_INFINITY)) || kotlin.jvm.internal.Intrinsics.areEqual(obj, java.lang.Float.valueOf(Float.POSITIVE_INFINITY)) || kotlin.jvm.internal.Intrinsics.areEqual(obj, java.lang.Double.valueOf(Double.NEGATIVE_INFINITY)) || kotlin.jvm.internal.Intrinsics.areEqual(obj, java.lang.Float.valueOf(Float.NEGATIVE_INFINITY))) {
                        return io.dcloud.uts.gson.JsonNull.INSTANCE;
                    }
                    return new io.dcloud.uts.gson.JsonPrimitive((java.lang.Number) obj);
                }
                if (obj instanceof java.lang.String) {
                    return new io.dcloud.uts.gson.JsonPrimitive((java.lang.String) obj);
                }
                if (obj instanceof java.lang.Character) {
                    return new io.dcloud.uts.gson.JsonPrimitive((java.lang.Character) obj);
                }
                if (obj instanceof java.lang.Boolean) {
                    return new io.dcloud.uts.gson.JsonPrimitive((java.lang.Boolean) obj);
                }
                return io.dcloud.uts.gson.JsonNull.INSTANCE;
            }
        });
        allType.add(new io.dcloud.uts.android.UTSGsonEncoder.EncodeType() { // from class: io.dcloud.uts.android.UTSGsonEncoder.Companion.2
            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public java.lang.String typeName() {
                return "JsonSelf";
            }

            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public boolean isType(java.lang.Object obj) {
                return obj instanceof io.dcloud.uts.json.IJsonStringify;
            }

            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public io.dcloud.uts.gson.JsonElement getTypeGsonInstance(java.lang.Object obj, kotlin.jvm.functions.Function2<? super java.lang.String, java.lang.Object, ? extends java.lang.Object> replacer, java.util.Set<java.lang.Object> hostStock) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(hostStock, "hostStock");
                if (obj instanceof io.dcloud.uts.json.IJsonStringify) {
                    return io.dcloud.uts.android.UTSGsonEncoder.INSTANCE.getGsonElement(((io.dcloud.uts.json.IJsonStringify) obj).toJSON(), replacer, hostStock);
                }
                return io.dcloud.uts.gson.JsonNull.INSTANCE;
            }
        });
        allType.add(new io.dcloud.uts.android.UTSGsonEncoder.EncodeType() { // from class: io.dcloud.uts.android.UTSGsonEncoder.Companion.3
            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public java.lang.String typeName() {
                return "gson-内置对象";
            }

            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public boolean isType(java.lang.Object obj) {
                return obj instanceof io.dcloud.uts.gson.JsonElement;
            }

            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public io.dcloud.uts.gson.JsonElement getTypeGsonInstance(java.lang.Object obj, kotlin.jvm.functions.Function2<? super java.lang.String, java.lang.Object, ? extends java.lang.Object> replacer, java.util.Set<java.lang.Object> hostStock) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(hostStock, "hostStock");
                if (obj instanceof io.dcloud.uts.gson.JsonElement) {
                    return (io.dcloud.uts.gson.JsonElement) obj;
                }
                io.dcloud.uts.gson.JsonNull INSTANCE2 = io.dcloud.uts.gson.JsonNull.INSTANCE;
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(INSTANCE2, "INSTANCE");
                return INSTANCE2;
            }
        });
        allType.add(new io.dcloud.uts.android.UTSGsonEncoder.EncodeType() { // from class: io.dcloud.uts.android.UTSGsonEncoder.Companion.4
            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public java.lang.String typeName() {
                return "json-容器数据类型";
            }

            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public boolean isType(java.lang.Object obj) {
                return (obj instanceof io.dcloud.uts.UTSArray) || (obj instanceof io.dcloud.uts.UTSJSONObject) || (obj instanceof java.util.List) || (obj instanceof java.lang.Object[]) || (obj instanceof java.util.Set) || (obj instanceof java.util.Map);
            }

            /* JADX WARN: Code duplicated, block: B:14:0x0039 A[PHI: r2
  0x0039: PHI (r2v12 java.lang.Object) = (r2v11 java.lang.Object), (r2v13 java.lang.Object) binds: [B:10:0x0026, B:12:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
            /* JADX WARN: Code duplicated, block: B:27:0x006d A[PHI: r4
  0x006d: PHI (r4v1 java.lang.Object) = (r4v0 java.lang.Object), (r4v2 java.lang.Object) binds: [B:23:0x005a, B:25:0x006a] A[DONT_GENERATE, DONT_INLINE]] */
            /* JADX WARN: Code duplicated, block: B:43:0x00b0 A[PHI: r2
  0x00b0: PHI (r2v7 java.lang.Object) = (r2v6 java.lang.Object), (r2v8 java.lang.Object) binds: [B:39:0x009d, B:41:0x00ad] A[DONT_GENERATE, DONT_INLINE]] */
            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public io.dcloud.uts.gson.JsonElement getTypeGsonInstance(java.lang.Object obj, kotlin.jvm.functions.Function2<? super java.lang.String, java.lang.Object, ? extends java.lang.Object> replacer, java.util.Set<java.lang.Object> hostStock) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(hostStock, "hostStock");
                int i = 0;
                if (obj instanceof io.dcloud.uts.UTSArray) {
                    io.dcloud.uts.gson.JsonArray jsonArray = new io.dcloud.uts.gson.JsonArray();
                    for (java.lang.Object objInvoke : (java.lang.Iterable) obj) {
                        int i2 = i + 1;
                        if (i < 0) {
                            kotlin.collections.CollectionsKt.throwIndexOverflow();
                        }
                        if (replacer == null) {
                            jsonArray.add(io.dcloud.uts.android.UTSGsonEncoder.INSTANCE.getGsonElement(objInvoke, replacer, hostStock));
                        } else {
                            objInvoke = replacer.invoke(java.lang.String.valueOf(i), objInvoke);
                            if (!kotlin.jvm.internal.Intrinsics.areEqual(objInvoke, io.dcloud.uts.JSON.JSON_SKIP_OBJECT.INSTANCE)) {
                                jsonArray.add(io.dcloud.uts.android.UTSGsonEncoder.INSTANCE.getGsonElement(objInvoke, replacer, hostStock));
                            }
                        }
                        i = i2;
                    }
                    return jsonArray;
                }
                if (obj instanceof java.lang.Object[]) {
                    io.dcloud.uts.gson.JsonArray jsonArray2 = new io.dcloud.uts.gson.JsonArray();
                    java.lang.Object[] objArr = (java.lang.Object[]) obj;
                    int length = objArr.length;
                    int i3 = 0;
                    while (i < length) {
                        java.lang.Object objInvoke2 = objArr[i];
                        int i4 = i3 + 1;
                        if (replacer == null) {
                            jsonArray2.add(io.dcloud.uts.android.UTSGsonEncoder.INSTANCE.getGsonElement(objInvoke2, replacer, hostStock));
                        } else {
                            objInvoke2 = replacer.invoke(java.lang.String.valueOf(i3), objInvoke2);
                            if (!kotlin.jvm.internal.Intrinsics.areEqual(objInvoke2, io.dcloud.uts.JSON.JSON_SKIP_OBJECT.INSTANCE)) {
                                jsonArray2.add(io.dcloud.uts.android.UTSGsonEncoder.INSTANCE.getGsonElement(objInvoke2, replacer, hostStock));
                            }
                        }
                        i++;
                        i3 = i4;
                    }
                    return jsonArray2;
                }
                if (obj instanceof java.util.List) {
                    io.dcloud.uts.gson.JsonArray jsonArray3 = new io.dcloud.uts.gson.JsonArray();
                    for (java.lang.Object objInvoke3 : (java.lang.Iterable) obj) {
                        int i5 = i + 1;
                        if (i < 0) {
                            kotlin.collections.CollectionsKt.throwIndexOverflow();
                        }
                        if (replacer == null) {
                            jsonArray3.add(io.dcloud.uts.android.UTSGsonEncoder.INSTANCE.getGsonElement(objInvoke3, replacer, hostStock));
                        } else {
                            objInvoke3 = replacer.invoke(java.lang.String.valueOf(i), objInvoke3);
                            if (!kotlin.jvm.internal.Intrinsics.areEqual(objInvoke3, io.dcloud.uts.JSON.JSON_SKIP_OBJECT.INSTANCE)) {
                                jsonArray3.add(io.dcloud.uts.android.UTSGsonEncoder.INSTANCE.getGsonElement(objInvoke3, replacer, hostStock));
                            }
                        }
                        i = i5;
                    }
                    return jsonArray3;
                }
                if (obj instanceof java.util.Set) {
                    return new io.dcloud.uts.gson.JsonObject();
                }
                if (obj instanceof java.util.Map) {
                    return new io.dcloud.uts.gson.JsonObject();
                }
                if (obj instanceof io.dcloud.uts.UTSJSONObject) {
                    io.dcloud.uts.gson.JsonObject jsonObject = new io.dcloud.uts.gson.JsonObject();
                    for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : ((io.dcloud.uts.UTSJSONObject) obj).toMap().entrySet()) {
                        java.lang.Object value = entry.getValue();
                        if (replacer != null) {
                            value = replacer.invoke(entry.getKey(), entry.getValue());
                            if (kotlin.jvm.internal.Intrinsics.areEqual(value, io.dcloud.uts.JSON.JSON_SKIP_OBJECT.INSTANCE)) {
                            }
                        }
                        io.dcloud.uts.gson.JsonElement gsonElement = io.dcloud.uts.android.UTSGsonEncoder.INSTANCE.getGsonElement(value, replacer, hostStock);
                        if (gsonElement != null) {
                            jsonObject.add(entry.getKey(), gsonElement);
                        }
                    }
                    return jsonObject;
                }
                io.dcloud.uts.gson.JsonNull INSTANCE2 = io.dcloud.uts.gson.JsonNull.INSTANCE;
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(INSTANCE2, "INSTANCE");
                return INSTANCE2;
            }
        });
        allType.add(new io.dcloud.uts.android.UTSGsonEncoder.EncodeType() { // from class: io.dcloud.uts.android.UTSGsonEncoder.Companion.5
            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public java.lang.String typeName() {
                return "json-开发者自定义类型";
            }

            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public boolean isType(java.lang.Object obj) {
                return obj instanceof io.dcloud.uts.UTSObject;
            }

            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public io.dcloud.uts.gson.JsonElement getTypeGsonInstance(java.lang.Object obj, kotlin.jvm.functions.Function2<? super java.lang.String, java.lang.Object, ? extends java.lang.Object> replacer, java.util.Set<java.lang.Object> hostStock) throws java.lang.IllegalAccessException {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(hostStock, "hostStock");
                io.dcloud.uts.gson.JsonObject jsonObject = new io.dcloud.uts.gson.JsonObject();
                if (obj instanceof io.dcloud.uts.UTSObject) {
                    io.dcloud.uts.UTSObject uTSObject = (io.dcloud.uts.UTSObject) obj;
                    for (java.lang.String str : uTSObject) {
                        java.lang.Object objInvoke = uTSObject.get(str);
                        if (replacer != null) {
                            objInvoke = replacer.invoke(str, uTSObject.get(str));
                            if (kotlin.jvm.internal.Intrinsics.areEqual(objInvoke, io.dcloud.uts.JSON.JSON_SKIP_OBJECT.INSTANCE)) {
                            }
                        }
                        io.dcloud.uts.gson.JsonElement gsonElement = io.dcloud.uts.android.UTSGsonEncoder.INSTANCE.getGsonElement(objInvoke, replacer, hostStock);
                        if (gsonElement != null) {
                            jsonObject.add(str, gsonElement);
                        }
                    }
                    return jsonObject;
                }
                io.dcloud.uts.gson.JsonNull INSTANCE2 = io.dcloud.uts.gson.JsonNull.INSTANCE;
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(INSTANCE2, "INSTANCE");
                return INSTANCE2;
            }
        });
        allType.add(new io.dcloud.uts.android.UTSGsonEncoder.EncodeType() { // from class: io.dcloud.uts.android.UTSGsonEncoder.Companion.6
            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public java.lang.String typeName() {
                return "json-可枚举接口";
            }

            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public boolean isType(java.lang.Object obj) {
                return obj instanceof io.dcloud.uts.UTSKeyIterable;
            }

            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public io.dcloud.uts.gson.JsonElement getTypeGsonInstance(java.lang.Object obj, kotlin.jvm.functions.Function2<? super java.lang.String, java.lang.Object, ? extends java.lang.Object> replacer, java.util.Set<java.lang.Object> hostStock) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(hostStock, "hostStock");
                io.dcloud.uts.gson.JsonObject jsonObject = new io.dcloud.uts.gson.JsonObject();
                if (obj instanceof io.dcloud.uts.UTSKeyIterable) {
                    io.dcloud.uts.UTSKeyIterable uTSKeyIterable = (io.dcloud.uts.UTSKeyIterable) obj;
                    io.dcloud.uts.UTSIterator<java.lang.String> uTSIteratorKeyIterator = uTSKeyIterable.keyIterator();
                    while (uTSIteratorKeyIterator.hasNext()) {
                        java.lang.String next = uTSIteratorKeyIterator.next();
                        java.lang.Object objInvoke = uTSKeyIterable.get(next);
                        if (replacer != null) {
                            objInvoke = replacer.invoke(next, objInvoke);
                            if (kotlin.jvm.internal.Intrinsics.areEqual(objInvoke, io.dcloud.uts.JSON.JSON_SKIP_OBJECT.INSTANCE)) {
                            }
                        }
                        io.dcloud.uts.gson.JsonElement gsonElement = io.dcloud.uts.android.UTSGsonEncoder.INSTANCE.getGsonElement(objInvoke, replacer, hostStock);
                        if (gsonElement != null) {
                            jsonObject.add(next, gsonElement);
                        }
                    }
                    return jsonObject;
                }
                io.dcloud.uts.gson.JsonNull INSTANCE2 = io.dcloud.uts.gson.JsonNull.INSTANCE;
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(INSTANCE2, "INSTANCE");
                return INSTANCE2;
            }
        });
        allType.add(new io.dcloud.uts.android.UTSGsonEncoder.EncodeType() { // from class: io.dcloud.uts.android.UTSGsonEncoder.Companion.7
            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public java.lang.String typeName() {
                return "UTS 内置对象";
            }

            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public boolean isType(java.lang.Object obj) {
                return (obj instanceof io.dcloud.uts.Date) || (obj instanceof io.dcloud.uts.UTSCallback) || (obj instanceof io.dcloud.uts.UTSRegExp);
            }

            @Override // io.dcloud.uts.android.UTSGsonEncoder.EncodeType
            public io.dcloud.uts.gson.JsonElement getTypeGsonInstance(java.lang.Object obj, kotlin.jvm.functions.Function2<? super java.lang.String, java.lang.Object, ? extends java.lang.Object> replacer, java.util.Set<java.lang.Object> hostStock) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(hostStock, "hostStock");
                if (obj == null) {
                    io.dcloud.uts.gson.JsonNull INSTANCE2 = io.dcloud.uts.gson.JsonNull.INSTANCE;
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(INSTANCE2, "INSTANCE");
                    return INSTANCE2;
                }
                if (obj instanceof io.dcloud.uts.Date) {
                    return new io.dcloud.uts.gson.JsonPrimitive(((io.dcloud.uts.Date) obj).toISOString());
                }
                if (obj instanceof io.dcloud.uts.UTSCallback) {
                    return new io.dcloud.uts.gson.JsonPrimitive(((io.dcloud.uts.UTSCallback) obj).toString());
                }
                if (obj instanceof io.dcloud.uts.UTSRegExp) {
                    return new io.dcloud.uts.gson.JsonObject();
                }
                io.dcloud.uts.gson.JsonNull INSTANCE3 = io.dcloud.uts.gson.JsonNull.INSTANCE;
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(INSTANCE3, "INSTANCE");
                return INSTANCE3;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ io.dcloud.uts.gson.JsonElement encode$default(io.dcloud.uts.android.UTSGsonEncoder uTSGsonEncoder, java.lang.Object obj, kotlin.jvm.functions.Function2 function2, int i, java.lang.Object obj2) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        return uTSGsonEncoder.encode(obj, function2);
    }

    public final io.dcloud.uts.gson.JsonElement encode(java.lang.Object obj, kotlin.jvm.functions.Function2<? super java.lang.String, java.lang.Object, ? extends java.lang.Object> replacer) {
        return INSTANCE.getGsonElement(obj, replacer, new java.util.HashSet());
    }
}
