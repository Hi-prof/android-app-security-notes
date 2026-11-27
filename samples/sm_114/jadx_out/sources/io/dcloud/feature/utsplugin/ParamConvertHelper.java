package io.dcloud.feature.utsplugin;

/* JADX INFO: compiled from: ParamConvertHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0016\u0018\u0000 :2\u00020\u0001:\u0001:B5\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u00108\u001a\u0004\u0018\u00010\u00012\b\u00109\u001a\u0004\u0018\u00010\u0001R\u0014\u0010\r\u001a\u00020\u0003X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0003X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u0003X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u001a\u0010\u0014\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\u001a\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001a\u0010\u001c\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001a\u0010\u001e\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\u001a\u0010 \u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017R\u001a\u0010\"\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\u001c\u0010$\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R \u0010)\u001a\b\u0012\u0002\b\u0003\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u00104\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00105\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0015\"\u0004\b7\u0010\u0017¨\u0006;"}, d2 = {"Lio/dcloud/feature/utsplugin/ParamConvertHelper;", "", "classTypeName", "", "actualTypeArguments", "", "Ljava/lang/reflect/Type;", "hostCallback", "Lcom/taobao/weex/bridge/JSCallback;", "isKeepAlive", "", "<init>", "(Ljava/lang/String;[Ljava/lang/reflect/Type;Lcom/taobao/weex/bridge/JSCallback;Z)V", "UTSCallbackType", "getUTSCallbackType", "()Ljava/lang/String;", "UTSObjectType", "getUTSObjectType", "StringClassFlag", "getStringClassFlag", "isUTSCallback", "()Z", "setUTSCallback", "(Z)V", "isUTSObject", "setUTSObject", "isPrimitive", "setPrimitive", "isListType", "setListType", "isUTSArray", "setUTSArray", "isMapType", "setMapType", "isAnyType", "setAnyType", "mHostCallback", "getMHostCallback", "()Lcom/taobao/weex/bridge/JSCallback;", "setMHostCallback", "(Lcom/taobao/weex/bridge/JSCallback;)V", "tClass", "Ljava/lang/Class;", "getTClass", "()Ljava/lang/Class;", "setTClass", "(Ljava/lang/Class;)V", "hostTypeArguments", "getHostTypeArguments", "()[Ljava/lang/reflect/Type;", "setHostTypeArguments", "([Ljava/lang/reflect/Type;)V", "[Ljava/lang/reflect/Type;", "mIsKeepAlive", "getMIsKeepAlive", "setMIsKeepAlive", "getInstance", "value", "Companion", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class ParamConvertHelper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final io.dcloud.feature.utsplugin.ParamConvertHelper.Companion INSTANCE = new io.dcloud.feature.utsplugin.ParamConvertHelper.Companion(null);
    private final java.lang.String StringClassFlag;
    private final java.lang.String UTSCallbackType;
    private final java.lang.String UTSObjectType;
    private java.lang.reflect.Type[] hostTypeArguments;
    private boolean isAnyType;
    private boolean isListType;
    private boolean isMapType;
    private boolean isPrimitive;
    private boolean isUTSArray;
    private boolean isUTSCallback;
    private boolean isUTSObject;
    private com.taobao.weex.bridge.JSCallback mHostCallback;
    private boolean mIsKeepAlive;
    private java.lang.Class<?> tClass;

    /* JADX INFO: compiled from: ParamConvertHelper.kt */
    @kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005¨\u0006\u000f"}, d2 = {"Lio/dcloud/feature/utsplugin/ParamConvertHelper$Companion;", "", "<init>", "()V", "typeNameCompat", "", "type", "Ljava/lang/reflect/Type;", "isPrimitiveType", "", "classTypeName", "isListType", "isUTSArray", "isMapType", "isAnyType", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final java.lang.String typeNameCompat(java.lang.reflect.Type type) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
            if (type instanceof java.lang.Class) {
                java.lang.String name = ((java.lang.Class) type).getName();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                return name;
            }
            if (type instanceof java.lang.reflect.ParameterizedType) {
                java.lang.reflect.ParameterizedType parameterizedType = (java.lang.reflect.ParameterizedType) type;
                java.lang.reflect.Type rawType = parameterizedType.getRawType();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(rawType, "getRawType(...)");
                java.lang.String strTypeNameCompat = typeNameCompat(rawType);
                java.lang.reflect.Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(actualTypeArguments, "getActualTypeArguments(...)");
                return strTypeNameCompat + kotlin.text.Typography.less + kotlin.collections.ArraysKt.joinToString$default(actualTypeArguments, ", ", (java.lang.CharSequence) null, (java.lang.CharSequence) null, 0, (java.lang.CharSequence) null, new kotlin.jvm.functions.Function1() { // from class: io.dcloud.feature.utsplugin.ParamConvertHelper$Companion$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    /* JADX INFO: renamed from: invoke */
                    public final java.lang.Object invoke2(java.lang.Object obj) {
                        return io.dcloud.feature.utsplugin.ParamConvertHelper.Companion.typeNameCompat$lambda$0((java.lang.reflect.Type) obj);
                    }
                }, 30, (java.lang.Object) null) + kotlin.text.Typography.greater;
            }
            return type.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.lang.CharSequence typeNameCompat$lambda$0(java.lang.reflect.Type type) {
            io.dcloud.feature.utsplugin.ParamConvertHelper.Companion companion = io.dcloud.feature.utsplugin.ParamConvertHelper.INSTANCE;
            kotlin.jvm.internal.Intrinsics.checkNotNull(type);
            return companion.typeNameCompat(type);
        }

        public final boolean isPrimitiveType(java.lang.String classTypeName) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classTypeName, "classTypeName");
            return kotlin.jvm.internal.Intrinsics.areEqual("int", classTypeName) || kotlin.jvm.internal.Intrinsics.areEqual("byte", classTypeName) || kotlin.jvm.internal.Intrinsics.areEqual("float", classTypeName) || kotlin.jvm.internal.Intrinsics.areEqual("double", classTypeName) || kotlin.jvm.internal.Intrinsics.areEqual("short", classTypeName) || kotlin.jvm.internal.Intrinsics.areEqual("kotlin.Int", classTypeName) || kotlin.jvm.internal.Intrinsics.areEqual("kotlin.Long", classTypeName) || kotlin.jvm.internal.Intrinsics.areEqual("kotlin.Double", classTypeName) || kotlin.jvm.internal.Intrinsics.areEqual("kotlin.Float", classTypeName) || kotlin.jvm.internal.Intrinsics.areEqual("kotlin.Byte", classTypeName) || kotlin.jvm.internal.Intrinsics.areEqual("kotlin.String", classTypeName) || kotlin.jvm.internal.Intrinsics.areEqual("java.lang.Number", classTypeName) || kotlin.jvm.internal.Intrinsics.areEqual("java.lang.String", classTypeName) || kotlin.jvm.internal.Intrinsics.areEqual("java.lang.Boolean", classTypeName) || kotlin.jvm.internal.Intrinsics.areEqual("java.lang.Byte", classTypeName) || kotlin.jvm.internal.Intrinsics.areEqual("boolean", classTypeName) || kotlin.jvm.internal.Intrinsics.areEqual("long", classTypeName);
        }

        public final boolean isListType(java.lang.String classTypeName) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classTypeName, "classTypeName");
            return kotlin.text.StringsKt.startsWith$default(classTypeName, "java.util.List", false, 2, (java.lang.Object) null);
        }

        public final boolean isUTSArray(java.lang.String classTypeName) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classTypeName, "classTypeName");
            return kotlin.text.StringsKt.startsWith$default(classTypeName, "io.dcloud.uts.UTSArray", false, 2, (java.lang.Object) null);
        }

        public final boolean isMapType(java.lang.String classTypeName) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classTypeName, "classTypeName");
            return kotlin.jvm.internal.Intrinsics.areEqual(classTypeName, "java.util.LinkedHashMap") || kotlin.jvm.internal.Intrinsics.areEqual(classTypeName, "io.dcloud.uts.Map");
        }

        public final boolean isAnyType(java.lang.String classTypeName) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classTypeName, "classTypeName");
            return kotlin.jvm.internal.Intrinsics.areEqual(classTypeName, "java.lang.Object") || kotlin.jvm.internal.Intrinsics.areEqual(classTypeName, "kotlin.Any");
        }
    }

    public final java.lang.String getUTSCallbackType() {
        return this.UTSCallbackType;
    }

    public final java.lang.String getUTSObjectType() {
        return this.UTSObjectType;
    }

    public final java.lang.String getStringClassFlag() {
        return this.StringClassFlag;
    }

    /* JADX INFO: renamed from: isUTSCallback, reason: from getter */
    public final boolean getIsUTSCallback() {
        return this.isUTSCallback;
    }

    public final void setUTSCallback(boolean z) {
        this.isUTSCallback = z;
    }

    /* JADX INFO: renamed from: isUTSObject, reason: from getter */
    public final boolean getIsUTSObject() {
        return this.isUTSObject;
    }

    public final void setUTSObject(boolean z) {
        this.isUTSObject = z;
    }

    /* JADX INFO: renamed from: isPrimitive, reason: from getter */
    public final boolean getIsPrimitive() {
        return this.isPrimitive;
    }

    public final void setPrimitive(boolean z) {
        this.isPrimitive = z;
    }

    /* JADX INFO: renamed from: isListType, reason: from getter */
    public final boolean getIsListType() {
        return this.isListType;
    }

    public final void setListType(boolean z) {
        this.isListType = z;
    }

    /* JADX INFO: renamed from: isUTSArray, reason: from getter */
    public final boolean getIsUTSArray() {
        return this.isUTSArray;
    }

    public final void setUTSArray(boolean z) {
        this.isUTSArray = z;
    }

    /* JADX INFO: renamed from: isMapType, reason: from getter */
    public final boolean getIsMapType() {
        return this.isMapType;
    }

    public final void setMapType(boolean z) {
        this.isMapType = z;
    }

    /* JADX INFO: renamed from: isAnyType, reason: from getter */
    public final boolean getIsAnyType() {
        return this.isAnyType;
    }

    public final void setAnyType(boolean z) {
        this.isAnyType = z;
    }

    public final com.taobao.weex.bridge.JSCallback getMHostCallback() {
        return this.mHostCallback;
    }

    public final void setMHostCallback(com.taobao.weex.bridge.JSCallback jSCallback) {
        this.mHostCallback = jSCallback;
    }

    public final java.lang.Class<?> getTClass() {
        return this.tClass;
    }

    public final void setTClass(java.lang.Class<?> cls) {
        this.tClass = cls;
    }

    public final java.lang.reflect.Type[] getHostTypeArguments() {
        return this.hostTypeArguments;
    }

    public final void setHostTypeArguments(java.lang.reflect.Type[] typeArr) {
        this.hostTypeArguments = typeArr;
    }

    public final boolean getMIsKeepAlive() {
        return this.mIsKeepAlive;
    }

    public final void setMIsKeepAlive(boolean z) {
        this.mIsKeepAlive = z;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0088  */
    public ParamConvertHelper(java.lang.String classTypeName, java.lang.reflect.Type[] typeArr, com.taobao.weex.bridge.JSCallback jSCallback, boolean z) throws java.lang.ClassNotFoundException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classTypeName, "classTypeName");
        this.UTSCallbackType = "io.dcloud.uts.UTSCallback";
        this.UTSObjectType = "io.dcloud.uts.UTSJSONObject";
        this.StringClassFlag = "java.lang.String";
        this.mIsKeepAlive = z;
        this.hostTypeArguments = typeArr;
        if (kotlin.jvm.internal.Intrinsics.areEqual("io.dcloud.uts.UTSJSONObject", classTypeName)) {
            this.isUTSObject = true;
            return;
        }
        io.dcloud.feature.utsplugin.ParamConvertHelper.Companion companion = INSTANCE;
        if (companion.isPrimitiveType(classTypeName)) {
            this.isPrimitive = true;
            return;
        }
        if (companion.isListType(classTypeName)) {
            this.isListType = true;
            return;
        }
        if (companion.isUTSArray(classTypeName)) {
            this.isUTSArray = true;
            return;
        }
        if (companion.isAnyType(classTypeName)) {
            this.isAnyType = true;
            return;
        }
        if (companion.isMapType(classTypeName)) {
            this.isMapType = true;
            return;
        }
        java.lang.Class<?> cls = java.lang.Class.forName(classTypeName);
        this.tClass = cls;
        kotlin.jvm.internal.Intrinsics.checkNotNull(cls);
        if (kotlin.jvm.internal.Intrinsics.areEqual("io.dcloud.uts.UTSCallback", cls.getName())) {
            this.isUTSCallback = true;
        } else {
            java.lang.Class<?> cls2 = this.tClass;
            kotlin.jvm.internal.Intrinsics.checkNotNull(cls2);
            if (!cls2.isPrimitive()) {
                java.lang.Class<?> cls3 = this.tClass;
                kotlin.jvm.internal.Intrinsics.checkNotNull(cls3);
                if (kotlin.jvm.internal.Intrinsics.areEqual("java.lang.String", cls3.getName())) {
                    this.isPrimitive = true;
                } else {
                    this.isUTSCallback = false;
                    this.isPrimitive = false;
                }
            } else {
                this.isPrimitive = true;
            }
        }
        this.mHostCallback = jSCallback;
    }

    public /* synthetic */ ParamConvertHelper(java.lang.String str, java.lang.reflect.Type[] typeArr, com.taobao.weex.bridge.JSCallback jSCallback, boolean z, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(str, typeArr, jSCallback, (i & 8) != 0 ? false : z);
    }

    /* JADX WARN: Code duplicated, block: B:149:0x0311 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:150:0x0312  */
    /* JADX WARN: Code duplicated, block: B:153:0x0325  */
    /* JADX WARN: Code duplicated, block: B:164:0x0369  */
    /* JADX WARN: Code duplicated, block: B:201:0x0410 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:205:0x0401 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:218:0x0341 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:219:0x0363 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:220:0x034c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:224:0x0376 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:226:0x031f A[SYNTHETIC] */
    public final java.lang.Object getInstance(java.lang.Object value) {
        java.lang.reflect.Type[] typeArr;
        java.lang.Object obj;
        java.util.Iterator it;
        java.lang.reflect.Field field;
        java.lang.String name;
        java.lang.Class<?> type;
        java.lang.String name2;
        io.dcloud.feature.utsplugin.ParamConvertHelper.Companion companion;
        java.lang.reflect.Type[] actualTypeArguments;
        java.lang.Object objNewInstance;
        java.lang.reflect.Type[] typeArr2;
        com.alibaba.fastjson.JSONArray array;
        io.dcloud.uts.UTSCallback uTSCallback;
        java.lang.reflect.Type[] typeArr3 = null;
        objNewInstance = null;
        objNewInstance = null;
        objNewInstance = null;
        objNewInstance = null;
        java.lang.Object objNewInstance2 = null;
        uTSArray = null;
        io.dcloud.uts.UTSArray uTSArray = null;
        typeArr3 = null;
        typeArr3 = null;
        if (value == null || kotlin.jvm.internal.Intrinsics.areEqual("UTSNull", value)) {
            return null;
        }
        if (this.isUTSObject) {
            io.dcloud.uts.UTSJSONObject uTSJSONObject = new io.dcloud.uts.UTSJSONObject();
            com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(value.toString());
            kotlin.jvm.internal.Intrinsics.checkNotNull(object);
            uTSJSONObject.fillJSON(object);
            return uTSJSONObject;
        }
        if (this.isMapType) {
            com.alibaba.fastjson.JSONObject object2 = com.alibaba.fastjson.JSON.parseObject(value.toString());
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(object2, "parseObject(...)");
            return new java.util.LinkedHashMap(kotlin.collections.MapsKt.toMap(object2));
        }
        if (this.isAnyType) {
            if (value instanceof com.alibaba.fastjson.JSONObject) {
                return new io.dcloud.uts.UTSJSONObject(value);
            }
            if (value instanceof com.alibaba.fastjson.JSONArray) {
                return new io.dcloud.uts.UTSArray((java.util.List) value);
            }
        } else {
            boolean z = this.isPrimitive;
            if (!z && !this.isListType && !this.isUTSArray && this.tClass == null) {
                return null;
            }
            if (this.isUTSCallback) {
                java.lang.Integer intOrNull = kotlin.text.StringsKt.toIntOrNull(value.toString());
                if (intOrNull != null) {
                    int iIntValue = intOrNull.intValue();
                    if (this.mIsKeepAlive && (uTSCallback = io.dcloud.feature.utsplugin.ParamConvertHelperKt.getUtsCallbackCache().get(intOrNull)) != null) {
                        uTSCallback.setHostCallback(this.mHostCallback);
                        return uTSCallback;
                    }
                    if (iIntValue == -1) {
                        return null;
                    }
                    try {
                        java.lang.Class<?> cls = this.tClass;
                        kotlin.jvm.internal.Intrinsics.checkNotNull(cls);
                        objNewInstance2 = cls.getConstructor(com.taobao.weex.bridge.JSCallback.class, java.lang.Integer.TYPE, java.lang.String.class).newInstance(this.mHostCallback, intOrNull, "");
                    } catch (java.lang.IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (java.lang.InstantiationException e2) {
                        e2.printStackTrace();
                    } catch (java.lang.NoSuchMethodException e3) {
                        e3.printStackTrace();
                    } catch (java.lang.reflect.InvocationTargetException e4) {
                        e4.printStackTrace();
                    }
                    if (this.mIsKeepAlive) {
                        java.util.Map<java.lang.Integer, io.dcloud.uts.UTSCallback> utsCallbackCache = io.dcloud.feature.utsplugin.ParamConvertHelperKt.getUtsCallbackCache();
                        kotlin.jvm.internal.Intrinsics.checkNotNull(objNewInstance2, "null cannot be cast to non-null type io.dcloud.uts.UTSCallback");
                        utsCallbackCache.put(intOrNull, (io.dcloud.uts.UTSCallback) objNewInstance2);
                    }
                }
                return objNewInstance2;
            }
            if (!z) {
                if (this.isUTSArray) {
                    if (!(value instanceof com.alibaba.fastjson.JSONArray)) {
                        return null;
                    }
                    java.lang.reflect.Type[] typeArr4 = this.hostTypeArguments;
                    if (typeArr4 != null && typeArr4.length != 0) {
                        uTSArray = new io.dcloud.uts.UTSArray();
                        io.dcloud.feature.utsplugin.ParamConvertHelper.Companion companion2 = INSTANCE;
                        java.lang.reflect.Type[] typeArr5 = this.hostTypeArguments;
                        kotlin.jvm.internal.Intrinsics.checkNotNull(typeArr5);
                        io.dcloud.feature.utsplugin.ParamConvertHelper paramConvertHelper = new io.dcloud.feature.utsplugin.ParamConvertHelper(companion2.typeNameCompat(typeArr5[0]), null, null, false, 8, null);
                        java.util.Iterator it2 = ((java.lang.Iterable) value).iterator();
                        while (it2.hasNext()) {
                            uTSArray.add(paramConvertHelper.getInstance(it2.next()));
                        }
                    }
                    return uTSArray;
                }
                if (this.isListType) {
                    if (value instanceof com.alibaba.fastjson.JSONArray) {
                        return kotlin.collections.CollectionsKt.toList((java.lang.Iterable) value);
                    }
                    if ((value instanceof java.lang.String) && (array = com.alibaba.fastjson.JSON.parseArray((java.lang.String) value)) != null) {
                        return kotlin.collections.CollectionsKt.toList(array);
                    }
                }
                com.alibaba.fastjson.JSONObject object3 = com.alibaba.fastjson.JSONObject.parseObject(value.toString());
                if (object3 == null) {
                    return null;
                }
                java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
                try {
                    java.lang.Class<?> cls2 = this.tClass;
                    if (cls2 != null) {
                        kotlin.jvm.internal.Intrinsics.checkNotNull(cls2);
                        if (!kotlin.jvm.JvmClassMappingKt.getKotlinClass(cls2).getConstructors().isEmpty()) {
                            java.lang.Class<?> cls3 = this.tClass;
                            kotlin.jvm.internal.Intrinsics.checkNotNull(cls3);
                            try {
                                if (kotlin.jvm.JvmClassMappingKt.getKotlinClass(cls3).getConstructors().size() == 1) {
                                    java.lang.Class<?> cls4 = this.tClass;
                                    kotlin.jvm.internal.Intrinsics.checkNotNull(cls4);
                                    kotlin.reflect.KFunction kFunction = (kotlin.reflect.KFunction) kotlin.collections.CollectionsKt.first(kotlin.jvm.JvmClassMappingKt.getKotlinClass(cls4).getConstructors());
                                    if (!kFunction.getParameters().isEmpty()) {
                                        java.util.Map<java.lang.String, java.lang.Object> innerMap = object3.getInnerMap();
                                        java.util.List<kotlin.reflect.KParameter> parameters = kFunction.getParameters();
                                        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(kotlin.ranges.RangesKt.coerceAtLeast(kotlin.collections.MapsKt.mapCapacity(kotlin.collections.CollectionsKt.collectionSizeOrDefault(parameters, 10)), 16));
                                        for (java.lang.Object obj2 : parameters) {
                                            java.util.LinkedHashMap linkedHashMap2 = linkedHashMap;
                                            kotlin.reflect.KParameter kParameter = (kotlin.reflect.KParameter) obj2;
                                            java.lang.Object paramConvertHelper2 = innerMap.get(kParameter.getName());
                                            if (paramConvertHelper2 == null || kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(paramConvertHelper2.getClass()).getSupertypes().contains(kParameter.getType()) || kotlin.jvm.internal.Intrinsics.areEqual(kotlin.reflect.full.KClassifiers.createType$default(kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(paramConvertHelper2.getClass()), null, false, null, 7, null), kParameter.getType())) {
                                                typeArr2 = typeArr3;
                                            } else if (kotlin.jvm.internal.Intrinsics.areEqual(kParameter.getType().getClassifier(), kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(io.dcloud.uts.UTSArray.class)) && (paramConvertHelper2 instanceof com.alibaba.fastjson.JSONArray)) {
                                                kotlin.reflect.KType type2 = kParameter.getType().getArguments().get(0).getType();
                                                kotlin.jvm.internal.Intrinsics.checkNotNull(type2);
                                                io.dcloud.feature.utsplugin.ParamConvertHelper paramConvertHelper3 = new io.dcloud.feature.utsplugin.ParamConvertHelper(type2.toString(), null, null, false, 8, null);
                                                io.dcloud.uts.UTSArray uTSArray2 = new io.dcloud.uts.UTSArray();
                                                java.util.Iterator it3 = ((java.lang.Iterable) paramConvertHelper2).iterator();
                                                while (it3.hasNext()) {
                                                    java.lang.reflect.Type[] typeArr6 = typeArr3;
                                                    uTSArray2.add(paramConvertHelper3.getInstance(it3.next()));
                                                    typeArr3 = typeArr6;
                                                }
                                                typeArr2 = typeArr3;
                                                paramConvertHelper2 = uTSArray2;
                                            } else {
                                                typeArr2 = typeArr3;
                                                if (paramConvertHelper2 instanceof com.alibaba.fastjson.JSONObject) {
                                                    paramConvertHelper2 = new io.dcloud.feature.utsplugin.ParamConvertHelper(INSTANCE.typeNameCompat(kotlin.reflect.jvm.ReflectJvmMapping.getJavaType(kParameter.getType())), null, null, false, 8, null).getInstance(paramConvertHelper2);
                                                }
                                            }
                                            if (kParameter.getName() != null) {
                                                java.lang.String name3 = kParameter.getName();
                                                kotlin.jvm.internal.Intrinsics.checkNotNull(name3);
                                                linkedHashSet.add(name3);
                                            }
                                            linkedHashMap2.put(obj2, paramConvertHelper2);
                                            typeArr3 = typeArr2;
                                        }
                                        typeArr = typeArr3;
                                        objNewInstance = kFunction.callBy(linkedHashMap);
                                    } else {
                                        typeArr = null;
                                        objNewInstance = kFunction.call(new java.lang.Object[0]);
                                    }
                                } else {
                                    typeArr = null;
                                    java.lang.Class<?> cls5 = this.tClass;
                                    kotlin.jvm.internal.Intrinsics.checkNotNull(cls5);
                                    objNewInstance = cls5.newInstance();
                                }
                                obj = objNewInstance;
                            } catch (java.lang.IllegalAccessException e5) {
                                e = e5;
                                e.printStackTrace();
                                obj = typeArr;
                            } catch (java.lang.InstantiationException e6) {
                                e = e6;
                                e.printStackTrace();
                                obj = typeArr;
                            }
                        }
                        if (obj == null) {
                            return typeArr;
                        }
                        java.lang.Class<?> cls6 = this.tClass;
                        kotlin.jvm.internal.Intrinsics.checkNotNull(cls6);
                        it = kotlin.jvm.internal.ArrayIteratorKt.iterator(cls6.getDeclaredFields());
                        while (it.hasNext()) {
                            field = (java.lang.reflect.Field) it.next();
                            name = field.getName();
                            type = field.getType();
                            name2 = field.getType().getName();
                            if (object3.containsKey(name)) {
                                field.setAccessible(true);
                                if (kotlin.jvm.internal.Intrinsics.areEqual(this.UTSCallbackType, name2)) {
                                    int intValue = object3.getIntValue(name);
                                    com.taobao.weex.bridge.JSCallback jSCallback = this.mHostCallback;
                                    kotlin.jvm.internal.Intrinsics.checkNotNull(name);
                                    try {
                                        field.set(obj, new io.dcloud.uts.UTSCallback(jSCallback, intValue, name));
                                    } catch (java.lang.IllegalAccessException e7) {
                                        e7.printStackTrace();
                                    }
                                } else if (type.isPrimitive()) {
                                    field.set(obj, object3.get(name));
                                } else {
                                    companion = INSTANCE;
                                    kotlin.jvm.internal.Intrinsics.checkNotNull(name2);
                                    if (companion.isPrimitiveType(name2)) {
                                        try {
                                            field.set(obj, object3.get(name));
                                        } catch (java.lang.IllegalAccessException e8) {
                                            e8.printStackTrace();
                                        }
                                    } else if (!(object3.get(name) instanceof java.lang.Boolean) || (object3.get(name) instanceof java.lang.Number)) {
                                        try {
                                            field.set(obj, object3.get(name));
                                        } catch (java.lang.IllegalAccessException e9) {
                                            e9.printStackTrace();
                                        }
                                    } else if (kotlin.jvm.internal.Intrinsics.areEqual("io.dcloud.uts.UTSArray", name2)) {
                                        new io.dcloud.feature.utsplugin.ParamConvertHelper(name2, null, this.mHostCallback, false, 8, null);
                                        if (field.getGenericType() instanceof java.lang.reflect.ParameterizedType) {
                                            java.lang.reflect.Type genericType = field.getGenericType();
                                            kotlin.jvm.internal.Intrinsics.checkNotNull(genericType, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
                                            actualTypeArguments = ((java.lang.reflect.ParameterizedType) genericType).getActualTypeArguments();
                                        } else {
                                            actualTypeArguments = typeArr;
                                        }
                                        try {
                                            field.set(obj, new io.dcloud.feature.utsplugin.ParamConvertHelper(name2, actualTypeArguments, this.mHostCallback, false, 8, null).getInstance(object3.get(name)));
                                        } catch (java.lang.IllegalAccessException e10) {
                                            e10.printStackTrace();
                                        }
                                    } else {
                                        java.lang.String name4 = field.getType().getName();
                                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name4, "getName(...)");
                                        try {
                                            field.set(obj, new io.dcloud.feature.utsplugin.ParamConvertHelper(name4, null, this.mHostCallback, false, 8, null).getInstance(object3.get(name)));
                                        } catch (java.lang.IllegalAccessException e11) {
                                            e11.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }
                        return obj;
                    }
                    typeArr = null;
                } catch (java.lang.IllegalAccessException e12) {
                    e = e12;
                    typeArr = typeArr3;
                } catch (java.lang.InstantiationException e13) {
                    e = e13;
                    typeArr = typeArr3;
                }
                obj = typeArr;
                if (obj == null) {
                    return typeArr;
                }
                java.lang.Class<?> cls7 = this.tClass;
                kotlin.jvm.internal.Intrinsics.checkNotNull(cls7);
                it = kotlin.jvm.internal.ArrayIteratorKt.iterator(cls7.getDeclaredFields());
                while (it.hasNext()) {
                    field = (java.lang.reflect.Field) it.next();
                    name = field.getName();
                    type = field.getType();
                    name2 = field.getType().getName();
                    if (object3.containsKey(name)) {
                        field.setAccessible(true);
                        if (kotlin.jvm.internal.Intrinsics.areEqual(this.UTSCallbackType, name2)) {
                            int intValue2 = object3.getIntValue(name);
                            com.taobao.weex.bridge.JSCallback jSCallback2 = this.mHostCallback;
                            kotlin.jvm.internal.Intrinsics.checkNotNull(name);
                            field.set(obj, new io.dcloud.uts.UTSCallback(jSCallback2, intValue2, name));
                        } else if (type.isPrimitive()) {
                            companion = INSTANCE;
                            kotlin.jvm.internal.Intrinsics.checkNotNull(name2);
                            if (companion.isPrimitiveType(name2)) {
                                field.set(obj, object3.get(name));
                            } else if (!(object3.get(name) instanceof java.lang.Boolean)) {
                                field.set(obj, object3.get(name));
                            } else {
                                field.set(obj, object3.get(name));
                            }
                        } else {
                            field.set(obj, object3.get(name));
                        }
                    }
                }
                return obj;
            }
        }
        return value;
    }
}
