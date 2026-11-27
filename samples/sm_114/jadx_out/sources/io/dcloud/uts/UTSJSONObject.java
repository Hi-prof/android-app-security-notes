package io.dcloud.uts;

/* JADX INFO: compiled from: UTSJSONObject.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\t\n\u0002\u0010\u0004\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u0000 a2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005:\u0001aB\u0007¢\u0006\u0004\b\u0006\u0010\u0007B\u001b\b\u0016\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0006\u0010\fB\u0013\b\u0016\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0006\u0010\rJ\n\u0010\u0014\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010(\u001a\u00020)H\u0002J)\u0010*\u001a\u00020)2!\u0010+\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020)0,J\u0018\u00100\u001a\u0004\u0018\u0001H1\"\u0006\b\u0000\u00101\u0018\u0001H\u0086\b¢\u0006\u0002\u00102J\b\u00103\u001a\u000204H\u0007J\u000e\u00105\u001a\u00020)2\u0006\u00106\u001a\u00020\tJ\u0013\u00107\u001a\u0004\u0018\u00010\t2\u0006\u0010.\u001a\u00020\tH\u0096\u0002J\u001b\u00108\u001a\u00020)2\u0006\u0010.\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u00010\tH\u0096\u0002J\u0016\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\t0\"H\u0016J\u0016\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\t0;H\u0016J\u000e\u0010<\u001a\u0002042\u0006\u0010=\u001a\u00020\u0002J\u0014\u0010>\u001a\u00020\u00162\n\u0010?\u001a\u0006\u0012\u0002\b\u00030@H\u0002J\u0019\u0010>\u001a\u00020\u00162\n\u0010A\u001a\u0006\u0012\u0002\b\u00030BH\u0002¢\u0006\u0002\u0010CJ\u0014\u0010D\u001a\u0004\u0018\u00010\t2\b\u0010E\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010F\u001a\u00020GH\u0016J\u000e\u0010H\u001a\u00020)2\u0006\u0010I\u001a\u00020\u0000J\u000e\u0010H\u001a\u00020)2\u0006\u0010I\u001a\u00020\u0003J\u0012\u0010H\u001a\u00020)2\n\u0010I\u001a\u0006\u0012\u0002\b\u00030JJ\u0012\u0010H\u001a\u00020)2\n\u0010I\u001a\u0006\u0012\u0002\b\u00030KJ\u000f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00020MH\u0096\u0002J\b\u0010N\u001a\u00020\u0002H\u0016J\b\u0010O\u001a\u00020\u0002H\u0016J\u0016\u0010P\u001a\b\u0012\u0002\b\u0003\u0018\u00010K2\u0006\u0010=\u001a\u00020\u0002H\u0016J \u0010P\u001a\u0006\u0012\u0002\b\u00030K2\u0006\u0010=\u001a\u00020\u00022\n\u0010Q\u001a\u0006\u0012\u0002\b\u00030KH\u0016J&\u0010P\u001a\n\u0012\u0004\u0012\u0002H1\u0018\u00010K\"\u0006\b\u0000\u00101\u0018\u00012\u0006\u0010=\u001a\u00020\u0002H\u0087\b¢\u0006\u0002\bRJ2\u0010P\u001a\b\u0012\u0004\u0012\u0002H10K\"\u0006\b\u0000\u00101\u0018\u00012\u0006\u0010=\u001a\u00020\u00022\f\u0010Q\u001a\b\u0012\u0004\u0012\u0002H10KH\u0087\b¢\u0006\u0002\bSJ\u0012\u0010T\u001a\u0004\u0018\u00010\u00002\u0006\u0010=\u001a\u00020\u0002H\u0016J\u0018\u0010T\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\u00022\u0006\u0010Q\u001a\u00020\u0000H\u0016J\u0012\u0010U\u001a\u0004\u0018\u00010\u00022\u0006\u0010=\u001a\u00020\u0002H\u0016J\u0018\u0010U\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u00022\u0006\u0010Q\u001a\u00020\u0002H\u0016J\u0012\u0010V\u001a\u0004\u0018\u00010W2\u0006\u0010=\u001a\u00020\u0002H\u0016J\u0018\u0010V\u001a\u00020W2\u0006\u0010=\u001a\u00020\u00022\u0006\u0010Q\u001a\u00020WH\u0016J\u0017\u0010X\u001a\u0004\u0018\u0001042\u0006\u0010=\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010YJ\u0018\u0010X\u001a\u0002042\u0006\u0010=\u001a\u00020\u00022\u0006\u0010Q\u001a\u000204H\u0016J\u0012\u0010Z\u001a\u0004\u0018\u00010\t2\u0006\u0010=\u001a\u00020\u0002H\u0016J\u0018\u0010Z\u001a\u00020\t2\u0006\u0010=\u001a\u00020\u00022\u0006\u0010Q\u001a\u00020\tH\u0016J\u001a\u0010[\u001a\u0004\u0018\u00010\t2\b\u0010\\\u001a\u0004\u0018\u00010\t2\u0006\u0010]\u001a\u00020\u0002J\u001a\u0010[\u001a\u0004\u0018\u00010\t2\b\u0010\\\u001a\u0004\u0018\u00010\t2\u0006\u0010^\u001a\u00020_J\u0012\u0010`\u001a\u0004\u0018\u00010\t2\u0006\u0010=\u001a\u00020\u0002H\u0016R&\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000f\u0010\u0007\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R&\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0016@\u0016X\u0097\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u0007\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR*\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\t0\u001d8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0007\u001a\u0004\b\u001f\u0010 R4\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b#\u0010\u0007\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006b"}, d2 = {"Lio/dcloud/uts/UTSJSONObject;", "", "", "Lio/dcloud/uts/IUTSObject;", "Lio/dcloud/uts/log/LogSelfV2;", "Lio/dcloud/uts/IUTSSourceMap;", "<init>", "()V", "anyObj", "", "sourceMap", "Lio/dcloud/uts/UTSSourceMapPosition;", "(Ljava/lang/Object;Lio/dcloud/uts/UTSSourceMapPosition;)V", "(Ljava/lang/Object;)V", "__$hostSourceMap", "get__$hostSourceMap$annotations", "get__$hostSourceMap", "()Lio/dcloud/uts/UTSSourceMapPosition;", "set__$hostSourceMap", "(Lio/dcloud/uts/UTSSourceMapPosition;)V", "__$getOriginalPosition", "__$arrayContent", "Lcom/alibaba/fastjson/JSONArray;", "get__$arrayContent$annotations", "get__$arrayContent", "()Lcom/alibaba/fastjson/JSONArray;", "set__$arrayContent", "(Lcom/alibaba/fastjson/JSONArray;)V", "dynamicJSONFields", "Lio/dcloud/uts/gson/internal/LinkedTreeMap;", "getDynamicJSONFields$annotations", "getDynamicJSONFields", "()Lio/dcloud/uts/gson/internal/LinkedTreeMap;", "__$cacheCustomFieldMap", "Lio/dcloud/uts/Map;", "get__$cacheCustomFieldMap$annotations", "get__$cacheCustomFieldMap", "()Lio/dcloud/uts/Map;", "set__$cacheCustomFieldMap", "(Lio/dcloud/uts/Map;)V", "initCacheField", "", "forEach", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "parse", "T", "()Ljava/lang/Object;", "isJSONArray", "", "fillJSON", "json", "get", "set", "toMap", "toLogMap", "", "hasOwnProperty", io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_KEY, "wrapToJSONArray", com.taobao.weex.ui.component.WXBasicComponentType.LIST, "", "array", "", "([Ljava/lang/Object;)Lcom/alibaba/fastjson/JSONArray;", "wrapArrayItem", io.dcloud.common.constant.AbsoluteConst.XML_ITEM, "toJSONObject", "Lcom/alibaba/fastjson/JSON;", "mergeOther", "other", "", "Lio/dcloud/uts/UTSArray;", "iterator", "", "toString", "toJSONString", "getArray", "def", "getArray_withType", "getArray_withType_def", "getJSON", "getString", "getNumber", "", "getBoolean", "(Ljava/lang/String;)Ljava/lang/Boolean;", "getAny", "getCanInnerAttribute", "host", "attribute", "index", "", "resolveKeyPath", "Companion", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class UTSJSONObject implements java.lang.Iterable<java.lang.String>, io.dcloud.uts.IUTSObject, io.dcloud.uts.log.LogSelfV2, io.dcloud.uts.IUTSSourceMap, kotlin.jvm.internal.markers.KMappedMarker {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final io.dcloud.uts.UTSJSONObject.Companion INSTANCE = new io.dcloud.uts.UTSJSONObject.Companion(null);

    @io.dcloud.uts.GsonTransparent
    private com.alibaba.fastjson.JSONArray __$arrayContent;

    @io.dcloud.uts.GsonTransparent
    private io.dcloud.uts.Map<java.lang.String, java.lang.Object> __$cacheCustomFieldMap;

    @io.dcloud.uts.GsonTransparent
    private io.dcloud.uts.UTSSourceMapPosition __$hostSourceMap;

    @io.dcloud.uts.GsonTransparent
    private final io.dcloud.uts.gson.internal.LinkedTreeMap<java.lang.String, java.lang.Object> dynamicJSONFields;

    @io.dcloud.uts.UTSJsonTransparent
    public static /* synthetic */ void getDynamicJSONFields$annotations() {
    }

    @io.dcloud.uts.UTSJsonTransparent
    public static /* synthetic */ void get__$arrayContent$annotations() {
    }

    @io.dcloud.uts.UTSJsonTransparent
    public static /* synthetic */ void get__$cacheCustomFieldMap$annotations() {
    }

    @io.dcloud.uts.UTSJsonTransparent
    public static /* synthetic */ void get__$hostSourceMap$annotations() {
    }

    public UTSJSONObject() {
        this.dynamicJSONFields = new io.dcloud.uts.gson.internal.LinkedTreeMap<>();
    }

    /* JADX INFO: compiled from: UTSJSONObject.kt */
    @kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u001f\u0010\t\u001a\u00020\b2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\"\u00020\f¢\u0006\u0002\u0010\rJ,\u0010\t\u001a\u0004\u0018\u0001H\u000e\"\u0006\b\u0000\u0010\u000e\u0018\u00012\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\"\u00020\fH\u0086\b¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/dcloud/uts/UTSJSONObject$Companion;", "", "<init>", "()V", "keys", "Lio/dcloud/uts/UTSArray;", "", "utsObj", "Lio/dcloud/uts/UTSJSONObject;", "assign", "input", "", "Lio/dcloud/uts/IUTSObject;", "([Lio/dcloud/uts/IUTSObject;)Lio/dcloud/uts/UTSJSONObject;", "T", "([Lio/dcloud/uts/IUTSObject;)Ljava/lang/Object;", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final io.dcloud.uts.UTSArray<java.lang.String> keys(io.dcloud.uts.UTSJSONObject utsObj) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(utsObj, "utsObj");
            java.util.Set<java.lang.String> setKeySet = utsObj.toMap().keySet();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
            return new io.dcloud.uts.UTSArray<>(kotlin.collections.CollectionsKt.toList(setKeySet));
        }

        public final io.dcloud.uts.UTSJSONObject assign(io.dcloud.uts.IUTSObject... input) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(input, "input");
            return io.dcloud.uts.Object.INSTANCE.assign((io.dcloud.uts.IUTSObject[]) java.util.Arrays.copyOf(input, input.length));
        }

        /* JADX INFO: renamed from: assign, reason: collision with other method in class */
        public final /* synthetic */ <T> T m518assign(io.dcloud.uts.IUTSObject... input) {
            java.lang.String strFromJson;
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(input, "input");
            java.lang.String jSONString = io.dcloud.uts.Object.INSTANCE.assign((io.dcloud.uts.IUTSObject[]) java.util.Arrays.copyOf(input, input.length)).toJSONString();
            io.dcloud.uts.JSON json = io.dcloud.uts.JSON.INSTANCE;
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(4, "T");
            if (kotlin.jvm.internal.Intrinsics.areEqual("String", java.lang.Object.class.getSimpleName())) {
                kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(1, "T");
                strFromJson = jSONString;
            } else {
                io.dcloud.uts.ObjectKt.getGlobalError().put(java.lang.Thread.currentThread().getName(), null);
                try {
                    io.dcloud.uts.JSON json2 = io.dcloud.uts.JSON.INSTANCE;
                    io.dcloud.uts.gson.Gson cacheParseGson = io.dcloud.uts.JSON.INSTANCE.getCacheParseGson();
                    kotlin.jvm.internal.Intrinsics.needClassReification();
                    strFromJson = cacheParseGson.fromJson(jSONString, new io.dcloud.uts.gson.reflect.TypeToken<T>() { // from class: io.dcloud.uts.UTSJSONObject$Companion$assign$$inlined$parseObjectType$default$1
                    }.getType());
                } catch (java.lang.Exception e) {
                    io.dcloud.uts.ObjectKt.getGlobalError().put(java.lang.Thread.currentThread().getName(), e);
                    strFromJson = null;
                }
            }
            if (strFromJson == null) {
                return null;
            }
            return (T) strFromJson;
        }
    }

    public final io.dcloud.uts.UTSSourceMapPosition get__$hostSourceMap() {
        return this.__$hostSourceMap;
    }

    public final void set__$hostSourceMap(io.dcloud.uts.UTSSourceMapPosition uTSSourceMapPosition) {
        this.__$hostSourceMap = uTSSourceMapPosition;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UTSJSONObject(java.lang.Object obj, io.dcloud.uts.UTSSourceMapPosition sourceMap) {
        this(obj);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sourceMap, "sourceMap");
        this.__$hostSourceMap = sourceMap;
    }

    @Override // io.dcloud.uts.IUTSSourceMap
    /* JADX INFO: renamed from: __$getOriginalPosition, reason: from getter */
    public io.dcloud.uts.UTSSourceMapPosition get__$hostSourceMap() {
        return this.__$hostSourceMap;
    }

    public com.alibaba.fastjson.JSONArray get__$arrayContent() {
        return this.__$arrayContent;
    }

    public void set__$arrayContent(com.alibaba.fastjson.JSONArray jSONArray) {
        this.__$arrayContent = jSONArray;
    }

    public io.dcloud.uts.gson.internal.LinkedTreeMap<java.lang.String, java.lang.Object> getDynamicJSONFields() {
        return this.dynamicJSONFields;
    }

    public final io.dcloud.uts.Map<java.lang.String, java.lang.Object> get__$cacheCustomFieldMap() {
        return this.__$cacheCustomFieldMap;
    }

    public final void set__$cacheCustomFieldMap(io.dcloud.uts.Map<java.lang.String, java.lang.Object> map) {
        this.__$cacheCustomFieldMap = map;
    }

    private final void initCacheField() throws java.lang.IllegalAccessException {
        if (kotlin.jvm.internal.Intrinsics.areEqual(getClass().getName(), "io.dcloud.uts.UTSJSONObject")) {
            this.__$cacheCustomFieldMap = null;
            return;
        }
        if (this.__$cacheCustomFieldMap == null) {
            this.__$cacheCustomFieldMap = new io.dcloud.uts.Map<>();
            java.lang.reflect.Field[] declaredFields = getClass().getDeclaredFields();
            kotlin.jvm.internal.Intrinsics.checkNotNull(declaredFields);
            for (java.lang.reflect.Field field : declaredFields) {
                if (field.getAnnotation(io.dcloud.uts.GsonTransparent.class) == null && (!kotlin.jvm.internal.Intrinsics.areEqual(field.getName(), "Companion") || !(field.get(this) instanceof io.dcloud.uts.UTSJSONObject.Companion))) {
                    field.setAccessible(true);
                    java.lang.Object obj = field.get(this);
                    io.dcloud.uts.Map<java.lang.String, java.lang.Object> map = this.__$cacheCustomFieldMap;
                    kotlin.jvm.internal.Intrinsics.checkNotNull(map);
                    java.lang.String name = field.getName();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    map.set(name, obj);
                }
            }
        }
    }

    public UTSJSONObject(java.lang.Object obj) {
        this();
        if (obj == null) {
            return;
        }
        if (obj instanceof io.dcloud.uts.UTSSourceMapPosition) {
            this.__$hostSourceMap = (io.dcloud.uts.UTSSourceMapPosition) obj;
            return;
        }
        if (!(obj instanceof com.alibaba.fastjson.JSONObject)) {
            if (!(obj instanceof io.dcloud.uts.UTSJSONObject)) {
                if (obj instanceof java.util.Map) {
                    for (java.util.Map.Entry entry : ((java.util.Map) obj).entrySet()) {
                        if (entry.getKey() != null) {
                            if (kotlin.jvm.internal.Intrinsics.areEqual("__$originalPosition", entry.getKey()) && (entry.getValue() instanceof io.dcloud.uts.UTSSourceMapPosition)) {
                                java.lang.Object value = entry.getValue();
                                kotlin.jvm.internal.Intrinsics.checkNotNull(value, "null cannot be cast to non-null type io.dcloud.uts.UTSSourceMapPosition");
                                this.__$hostSourceMap = (io.dcloud.uts.UTSSourceMapPosition) value;
                            } else {
                                getDynamicJSONFields().put(io.dcloud.uts.NumberKt.toString_number_nullable$default(entry.getKey(), (java.lang.Number) null, 1, (java.lang.Object) null), entry.getValue());
                            }
                        }
                    }
                    return;
                }
                return;
            }
            for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry2 : ((io.dcloud.uts.UTSJSONObject) obj).toMap().entrySet()) {
                getDynamicJSONFields().put(entry2.getKey(), entry2.getValue());
            }
            return;
        }
        for (java.util.Map.Entry entry3 : ((java.util.Map) obj).entrySet()) {
            getDynamicJSONFields().put(entry3.getKey(), entry3.getValue());
        }
    }

    public final void forEach(kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        java.util.Iterator<java.util.Map.Entry<java.lang.String, java.lang.Object>> it = toMap().entrySet().iterator();
        while (it.hasNext()) {
            java.lang.Object value = it.next().getValue();
            if (value != null) {
                action.invoke2(value);
            }
        }
    }

    public final /* synthetic */ <T> T parse() {
        java.lang.String jSONString = toJSONObject().toJSONString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(...)");
        kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(4, "T");
        if (kotlin.jvm.internal.Intrinsics.areEqual("String", java.lang.Object.class.getSimpleName())) {
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(1, "T");
            return (T) jSONString;
        }
        io.dcloud.uts.ObjectKt.getGlobalError().put(java.lang.Thread.currentThread().getName(), null);
        try {
            io.dcloud.uts.JSON json = io.dcloud.uts.JSON.INSTANCE;
            io.dcloud.uts.gson.Gson cacheParseGson = io.dcloud.uts.JSON.INSTANCE.getCacheParseGson();
            kotlin.jvm.internal.Intrinsics.needClassReification();
            return (T) cacheParseGson.fromJson(jSONString, new io.dcloud.uts.gson.reflect.TypeToken<T>() { // from class: io.dcloud.uts.UTSJSONObject$parse$$inlined$parseType$default$1
            }.getType());
        } catch (java.lang.Exception e) {
            io.dcloud.uts.ObjectKt.getGlobalError().put(java.lang.Thread.currentThread().getName(), e);
            return null;
        }
    }

    @kotlin.Deprecated(message = "UTSJSONObject never be a array", replaceWith = @kotlin.ReplaceWith(expression = "", imports = {}))
    public final boolean isJSONArray() {
        return get__$arrayContent() != null;
    }

    public final void fillJSON(java.lang.Object json) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(json, "json");
        if (json instanceof com.alibaba.fastjson.JSONArray) {
            set__$arrayContent((com.alibaba.fastjson.JSONArray) json);
            return;
        }
        if (json instanceof com.alibaba.fastjson.JSONObject) {
            set__$arrayContent(null);
            for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : ((com.alibaba.fastjson.JSONObject) json).entrySet()) {
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(entry, "next(...)");
                java.util.Map.Entry<java.lang.String, java.lang.Object> entry2 = entry;
                java.lang.Object value = entry2.getValue();
                if (value instanceof com.alibaba.fastjson.JSONObject) {
                    io.dcloud.uts.gson.internal.LinkedTreeMap<java.lang.String, java.lang.Object> dynamicJSONFields = getDynamicJSONFields();
                    java.lang.String key = entry2.getKey();
                    java.lang.String jSONString = ((com.alibaba.fastjson.JSONObject) value).toJSONString();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(...)");
                    dynamicJSONFields.put(key, io.dcloud.uts.JSON.parse(jSONString));
                } else if (value instanceof com.alibaba.fastjson.JSONArray) {
                    io.dcloud.uts.gson.internal.LinkedTreeMap<java.lang.String, java.lang.Object> dynamicJSONFields2 = getDynamicJSONFields();
                    java.lang.String key2 = entry2.getKey();
                    java.lang.String jSONString2 = ((com.alibaba.fastjson.JSONArray) value).toJSONString();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(jSONString2, "toJSONString(...)");
                    dynamicJSONFields2.put(key2, io.dcloud.uts.JSON.parse(jSONString2));
                } else {
                    getDynamicJSONFields().put(entry2.getKey(), value);
                }
            }
        }
    }

    @Override // io.dcloud.uts.IUTSObject
    public java.lang.Object get(java.lang.Object name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        if (get__$arrayContent() != null) {
            if (!(name instanceof java.lang.Integer)) {
                return null;
            }
            java.lang.Number number = (java.lang.Number) name;
            int iIntValue = number.intValue();
            com.alibaba.fastjson.JSONArray jSONArray = get__$arrayContent();
            kotlin.jvm.internal.Intrinsics.checkNotNull(jSONArray);
            if (iIntValue >= jSONArray.size()) {
                return null;
            }
            com.alibaba.fastjson.JSONArray jSONArray2 = get__$arrayContent();
            kotlin.jvm.internal.Intrinsics.checkNotNull(jSONArray2);
            return jSONArray2.get(number.intValue());
        }
        java.lang.Object obj = getDynamicJSONFields().get(name);
        return obj != null ? obj : toMap().get(name);
    }

    @Override // io.dcloud.uts.IUTSObject
    public void set(java.lang.Object name, java.lang.Object value) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        if (get__$arrayContent() != null) {
            if (name instanceof java.lang.Integer) {
                java.lang.Number number = (java.lang.Number) name;
                int iIntValue = number.intValue();
                com.alibaba.fastjson.JSONArray jSONArray = get__$arrayContent();
                kotlin.jvm.internal.Intrinsics.checkNotNull(jSONArray);
                if (iIntValue < jSONArray.size()) {
                    com.alibaba.fastjson.JSONArray jSONArray2 = get__$arrayContent();
                    kotlin.jvm.internal.Intrinsics.checkNotNull(jSONArray2);
                    jSONArray2.set(number.intValue(), value);
                    return;
                }
                return;
            }
            return;
        }
        getDynamicJSONFields().put(name.toString(), value);
    }

    public io.dcloud.uts.Map<java.lang.String, java.lang.Object> toMap() throws java.lang.IllegalAccessException {
        io.dcloud.uts.Map<java.lang.String, java.lang.Object> map = new io.dcloud.uts.Map<>();
        initCacheField();
        io.dcloud.uts.Map<java.lang.String, java.lang.Object> map2 = this.__$cacheCustomFieldMap;
        if (map2 != null) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(map2);
            map.putAll(map2);
        }
        map.putAll(getDynamicJSONFields());
        return map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.dcloud.uts.log.LogSelfV2
    public java.util.Map<java.lang.String, java.lang.Object> toLogMap() {
        io.dcloud.uts.Map map = new io.dcloud.uts.Map();
        if (get__$arrayContent() == null) {
            for (kotlin.reflect.KProperty1 kProperty1 : kotlin.reflect.full.KClasses.getMemberProperties(kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(getClass()))) {
                kotlin.reflect.jvm.KCallablesJvm.setAccessible(kProperty1, true);
                V vCall = kProperty1.call(this);
                if (kotlin.jvm.internal.Intrinsics.areEqual(kProperty1.getName(), "__$hostSourceMap")) {
                    if (vCall instanceof io.dcloud.uts.UTSSourceMapPosition) {
                        io.dcloud.uts.gson.JsonObject jsonObject = new io.dcloud.uts.gson.JsonObject();
                        io.dcloud.uts.UTSSourceMapPosition uTSSourceMapPosition = (io.dcloud.uts.UTSSourceMapPosition) vCall;
                        jsonObject.addProperty("name", uTSSourceMapPosition.getName());
                        jsonObject.addProperty("file", uTSSourceMapPosition.getFile());
                        jsonObject.addProperty("column", java.lang.Integer.valueOf(uTSSourceMapPosition.getColumn()));
                        jsonObject.addProperty("line", java.lang.Integer.valueOf(uTSSourceMapPosition.getLine()));
                        map.put("__$originalPosition", jsonObject);
                    }
                } else if (kotlin.reflect.full.KAnnotatedElements.findAnnotations(kProperty1, kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(io.dcloud.uts.UTSJsonTransparent.class)).isEmpty()) {
                    if (kotlin.jvm.internal.Intrinsics.areEqual("kotlin.Number", kProperty1.getReturnType().toString())) {
                        map.put(kProperty1.getName(), new io.dcloud.uts.android.UTSLogInfo(vCall, "kotlin.Number", ""));
                    } else {
                        map.put(kProperty1.getName(), vCall);
                    }
                }
            }
            for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : getDynamicJSONFields().entrySet()) {
                map.put(entry.getKey().toString(), entry.getValue());
            }
        }
        return map;
    }

    public final boolean hasOwnProperty(java.lang.String key) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        return toMap().containsKey(key);
    }

    private final com.alibaba.fastjson.JSONArray wrapToJSONArray(java.util.List<?> list) {
        com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray();
        java.util.Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.add(wrapArrayItem(it.next()));
        }
        return jSONArray;
    }

    private final com.alibaba.fastjson.JSONArray wrapToJSONArray(java.lang.Object[] array) {
        com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray();
        for (java.lang.Object obj : array) {
            jSONArray.add(wrapArrayItem(obj));
        }
        return jSONArray;
    }

    private final java.lang.Object wrapArrayItem(java.lang.Object item) throws java.lang.IllegalAccessException {
        if (item instanceof io.dcloud.uts.UTSJSONObject) {
            return ((io.dcloud.uts.UTSJSONObject) item).toJSONObject();
        }
        if (item instanceof java.util.List) {
            return wrapToJSONArray((java.util.List<?>) item);
        }
        if (item instanceof java.lang.Object[]) {
            return wrapToJSONArray((java.lang.Object[]) item);
        }
        if (!(item instanceof com.alibaba.fastjson.JSONObject) && !(item instanceof java.lang.String) && !(item instanceof java.lang.Number) && !(item instanceof java.lang.Boolean) && !(item instanceof java.lang.Character) && item != null) {
            if (item instanceof io.dcloud.uts.json.IJsonStringify) {
                return wrapArrayItem(((io.dcloud.uts.json.IJsonStringify) item).toJSON());
            }
            if (item instanceof io.dcloud.uts.UTSObject) {
                com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
                io.dcloud.uts.UTSObject uTSObject = (io.dcloud.uts.UTSObject) item;
                for (java.lang.String str : uTSObject) {
                    jSONObject.put(str, wrapArrayItem(uTSObject.get(str)));
                }
                return jSONObject;
            }
        }
        return item;
    }

    public com.alibaba.fastjson.JSON toJSONObject() {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : toMap().entrySet()) {
            jSONObject.put(entry.getKey(), wrapArrayItem(entry.getValue()));
        }
        return jSONObject;
    }

    public final void mergeOther(io.dcloud.uts.UTSJSONObject other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        if (other.isJSONArray()) {
            com.alibaba.fastjson.JSON jSONObject = other.toJSONObject();
            kotlin.jvm.internal.Intrinsics.checkNotNull(jSONObject, "null cannot be cast to non-null type com.alibaba.fastjson.JSONArray");
            com.alibaba.fastjson.JSONArray jSONArray = (com.alibaba.fastjson.JSONArray) jSONObject;
            int length = jSONArray.toArray().length;
            for (int i = 0; i < length; i++) {
                getDynamicJSONFields().put(java.lang.String.valueOf(i), jSONArray.get(i));
            }
            return;
        }
        for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : other.toMap().entrySet()) {
            getDynamicJSONFields().put(entry.getKey(), entry.getValue());
        }
    }

    public final void mergeOther(io.dcloud.uts.IUTSObject other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        for (java.lang.String str : other) {
            getDynamicJSONFields().put(str, other.get(str));
        }
    }

    public final void mergeOther(java.util.List<?> other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        int size = other.size();
        for (int i = 0; i < size; i++) {
            getDynamicJSONFields().put(java.lang.String.valueOf(i), other.get(i));
        }
    }

    public final void mergeOther(io.dcloud.uts.UTSArray<?> other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        int size = other.size();
        for (int i = 0; i < size; i++) {
            getDynamicJSONFields().put(java.lang.String.valueOf(i), other.get(i));
        }
    }

    @Override // java.lang.Iterable, io.dcloud.uts.IUTSObject
    public java.util.Iterator<java.lang.String> iterator() {
        return toMap().keySet().iterator();
    }

    public java.lang.String toString() {
        return "[object Object]";
    }

    public java.lang.String toJSONString() {
        java.lang.String jSONString = toJSONObject().toJSONString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(...)");
        return jSONString;
    }

    public io.dcloud.uts.UTSArray<?> getArray(java.lang.String key) throws java.lang.IllegalAccessException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        java.lang.Object objResolveKeyPath = resolveKeyPath(key);
        if (objResolveKeyPath instanceof io.dcloud.uts.UTSArray) {
            return (io.dcloud.uts.UTSArray) objResolveKeyPath;
        }
        return null;
    }

    public io.dcloud.uts.UTSArray<?> getArray(java.lang.String key, io.dcloud.uts.UTSArray<?> def) throws java.lang.IllegalAccessException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(def, "def");
        io.dcloud.uts.UTSArray<?> array = getArray(key);
        return array != null ? array : def;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ <T> io.dcloud.uts.UTSArray<T> getArray_withType(java.lang.String key) throws java.lang.IllegalAccessException {
        java.lang.String strStringify;
        java.lang.Object objFromJson;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        java.lang.Object objResolveKeyPath = resolveKeyPath(key);
        if (!(objResolveKeyPath instanceof io.dcloud.uts.UTSArray)) {
            return null;
        }
        io.dcloud.uts.UTSArray<T> uTSArray = (io.dcloud.uts.UTSArray) objResolveKeyPath;
        kotlin.jvm.internal.Intrinsics.needClassReification();
        if (uTSArray.find(new kotlin.jvm.functions.Function1<?, java.lang.Boolean>() { // from class: io.dcloud.uts.UTSJSONObject$getArray$someEleNoT$1
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public final java.lang.Boolean invoke2(java.lang.Object obj) {
                kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(3, "T");
                return java.lang.Boolean.valueOf(!(obj instanceof java.lang.Object));
            }
        }) == null) {
            return uTSArray;
        }
        if (uTSArray.find(io.dcloud.uts.UTSJSONObject$getArray$someEleNoUTS$1.INSTANCE) != null || (strStringify = io.dcloud.uts.JSON.stringify(objResolveKeyPath)) == 0) {
            return null;
        }
        io.dcloud.uts.JSON json = io.dcloud.uts.JSON.INSTANCE;
        if (kotlin.jvm.internal.Intrinsics.areEqual("String", "UTSArray")) {
            objFromJson = (io.dcloud.uts.UTSArray) strStringify;
        } else {
            io.dcloud.uts.ObjectKt.getGlobalError().put(java.lang.Thread.currentThread().getName(), null);
            try {
                io.dcloud.uts.JSON json2 = io.dcloud.uts.JSON.INSTANCE;
                io.dcloud.uts.gson.Gson cacheParseGson = io.dcloud.uts.JSON.INSTANCE.getCacheParseGson();
                kotlin.jvm.internal.Intrinsics.needClassReification();
                objFromJson = cacheParseGson.fromJson(strStringify, new io.dcloud.uts.gson.reflect.TypeToken<io.dcloud.uts.UTSArray<T>>() { // from class: io.dcloud.uts.UTSJSONObject$getArray$$inlined$parseArrayType$1
                }.getType());
            } catch (java.lang.Exception e) {
                io.dcloud.uts.ObjectKt.getGlobalError().put(java.lang.Thread.currentThread().getName(), e);
                objFromJson = null;
            }
        }
        io.dcloud.uts.UTSArray<T> uTSArray2 = (io.dcloud.uts.UTSArray) objFromJson;
        if (uTSArray2 != null) {
            return uTSArray2;
        }
        return null;
    }

    public io.dcloud.uts.UTSJSONObject getJSON(java.lang.String key) throws java.lang.IllegalAccessException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        java.lang.Object objResolveKeyPath = resolveKeyPath(key);
        if (objResolveKeyPath instanceof io.dcloud.uts.UTSJSONObject) {
            return (io.dcloud.uts.UTSJSONObject) objResolveKeyPath;
        }
        if (!(objResolveKeyPath instanceof com.alibaba.fastjson.JSONObject)) {
            return null;
        }
        io.dcloud.uts.UTSJSONObject uTSJSONObject = new io.dcloud.uts.UTSJSONObject();
        uTSJSONObject.fillJSON(objResolveKeyPath);
        return uTSJSONObject;
    }

    public io.dcloud.uts.UTSJSONObject getJSON(java.lang.String key, io.dcloud.uts.UTSJSONObject def) throws java.lang.IllegalAccessException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(def, "def");
        io.dcloud.uts.UTSJSONObject json = getJSON(key);
        return json != null ? json : def;
    }

    public java.lang.String getString(java.lang.String key) throws java.lang.IllegalAccessException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        java.lang.Object objResolveKeyPath = resolveKeyPath(key);
        if (objResolveKeyPath instanceof java.lang.String) {
            return (java.lang.String) objResolveKeyPath;
        }
        return null;
    }

    public java.lang.String getString(java.lang.String key, java.lang.String def) throws java.lang.IllegalAccessException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(def, "def");
        java.lang.String string = getString(key);
        return string != null ? string : def;
    }

    public java.lang.Number getNumber(java.lang.String key) throws java.lang.IllegalAccessException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        java.lang.Object objResolveKeyPath = resolveKeyPath(key);
        if (objResolveKeyPath instanceof java.lang.Number) {
            return (java.lang.Number) objResolveKeyPath;
        }
        return null;
    }

    public java.lang.Number getNumber(java.lang.String key, java.lang.Number def) throws java.lang.IllegalAccessException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(def, "def");
        java.lang.Number number = getNumber(key);
        return number != null ? number : def;
    }

    public java.lang.Boolean getBoolean(java.lang.String key) throws java.lang.IllegalAccessException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        java.lang.Object objResolveKeyPath = resolveKeyPath(key);
        if (objResolveKeyPath instanceof java.lang.Boolean) {
            return (java.lang.Boolean) objResolveKeyPath;
        }
        return null;
    }

    public boolean getBoolean(java.lang.String key, boolean def) throws java.lang.IllegalAccessException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        java.lang.Boolean bool = getBoolean(key);
        return bool != null ? bool.booleanValue() : def;
    }

    public java.lang.Object getAny(java.lang.String key) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        return resolveKeyPath(key);
    }

    public java.lang.Object getAny(java.lang.String key, java.lang.Object def) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(def, "def");
        java.lang.Object any = getAny(key);
        return any != null ? any : def;
    }

    public final java.lang.Object getCanInnerAttribute(java.lang.Object host, java.lang.String attribute) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(attribute, "attribute");
        if (host instanceof io.dcloud.uts.UTSJSONObject) {
            return ((io.dcloud.uts.UTSJSONObject) host).get(attribute);
        }
        if (host instanceof io.dcloud.uts.IUTSObject) {
            return ((io.dcloud.uts.IUTSObject) host).get(attribute);
        }
        if (host instanceof java.util.Map) {
            return ((java.util.Map) host).get(attribute);
        }
        return null;
    }

    public final java.lang.Object getCanInnerAttribute(java.lang.Object host, int index) {
        if (host instanceof java.util.List) {
            return ((java.util.List) host).get(index);
        }
        if (host instanceof java.lang.Object[]) {
            return ((java.lang.Object[]) host)[index];
        }
        return null;
    }

    public java.lang.Object resolveKeyPath(java.lang.String key) throws java.lang.IllegalAccessException {
        java.lang.Object map;
        java.lang.String value;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        if (kotlin.jvm.internal.Intrinsics.areEqual(getClass().getName(), "io.dcloud.uts.UTSJSONObject")) {
            map = getDynamicJSONFields();
        } else {
            map = toMap();
        }
        java.util.AbstractMap abstractMap = (java.util.AbstractMap) map;
        if (abstractMap.containsKey(key)) {
            return abstractMap.get(key);
        }
        try {
            for (java.lang.String str : kotlin.text.StringsKt.split$default((java.lang.CharSequence) key, new char[]{com.taobao.weex.el.parse.Operators.DOT}, false, 0, 6, (java.lang.Object) null)) {
                kotlin.text.MatchResult matchResultFind$default = kotlin.text.Regex.find$default(new kotlin.text.Regex("(\\w+)((\\[\\d+])+)"), str, 0, 2, null);
                if (matchResultFind$default != null) {
                    kotlin.text.MatchGroup matchGroup = matchResultFind$default.getGroups().get(1);
                    if (matchGroup == null) {
                        value = "";
                    } else {
                        value = matchGroup.getValue();
                    }
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    kotlin.jvm.internal.Intrinsics.checkNotNull(matchGroup);
                    for (java.lang.String str2 : io.dcloud.uts.StringKt.split(io.dcloud.uts.StringKt.replaceAll(io.dcloud.uts.StringKt.substring$default(str, java.lang.Integer.valueOf(matchGroup.getRange().getLast() + 1), null, 2, null), com.taobao.weex.el.parse.Operators.ARRAY_START_STR, ""), com.taobao.weex.el.parse.Operators.ARRAY_END_STR)) {
                        if (str2.length() > 0) {
                            arrayList.add(java.lang.Integer.valueOf(java.lang.Integer.parseInt(str2)));
                        }
                    }
                    java.lang.Object canInnerAttribute = getCanInnerAttribute(map, value);
                    java.util.Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        canInnerAttribute = getCanInnerAttribute(canInnerAttribute, ((java.lang.Number) it.next()).intValue());
                        map = canInnerAttribute;
                    }
                } else {
                    map = getCanInnerAttribute(map, str);
                }
            }
            return map;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ <T> io.dcloud.uts.UTSArray<T> getArray_withType_def(java.lang.String key, io.dcloud.uts.UTSArray<T> def) throws java.lang.IllegalAccessException {
        java.lang.String strStringify;
        java.lang.Object objFromJson;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(def, "def");
        java.lang.Object objResolveKeyPath = resolveKeyPath(key);
        io.dcloud.uts.UTSArray<T> uTSArray = null;
        if (objResolveKeyPath instanceof io.dcloud.uts.UTSArray) {
            io.dcloud.uts.UTSArray<T> uTSArray2 = (io.dcloud.uts.UTSArray) objResolveKeyPath;
            kotlin.jvm.internal.Intrinsics.needClassReification();
            if (uTSArray2.find(new kotlin.jvm.functions.Function1<?, java.lang.Boolean>() { // from class: io.dcloud.uts.UTSJSONObject$getArray$$inlined$getArray_withType$1
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: invoke */
                public final java.lang.Boolean invoke2(java.lang.Object obj) {
                    kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(3, "T");
                    return java.lang.Boolean.valueOf(!(obj instanceof java.lang.Object));
                }
            }) == null) {
                uTSArray = uTSArray2;
            } else if (uTSArray2.find(io.dcloud.uts.UTSJSONObject$getArray$someEleNoUTS$1.INSTANCE) == null && (strStringify = io.dcloud.uts.JSON.stringify(objResolveKeyPath)) != 0) {
                io.dcloud.uts.JSON json = io.dcloud.uts.JSON.INSTANCE;
                if (kotlin.jvm.internal.Intrinsics.areEqual("String", "UTSArray")) {
                    objFromJson = (io.dcloud.uts.UTSArray) strStringify;
                } else {
                    io.dcloud.uts.ObjectKt.getGlobalError().put(java.lang.Thread.currentThread().getName(), null);
                    try {
                        io.dcloud.uts.JSON json2 = io.dcloud.uts.JSON.INSTANCE;
                        io.dcloud.uts.gson.Gson cacheParseGson = io.dcloud.uts.JSON.INSTANCE.getCacheParseGson();
                        kotlin.jvm.internal.Intrinsics.needClassReification();
                        objFromJson = cacheParseGson.fromJson(strStringify, new io.dcloud.uts.gson.reflect.TypeToken<io.dcloud.uts.UTSArray<T>>() { // from class: io.dcloud.uts.UTSJSONObject$getArray$$inlined$getArray_withType$2
                        }.getType());
                    } catch (java.lang.Exception e) {
                        io.dcloud.uts.ObjectKt.getGlobalError().put(java.lang.Thread.currentThread().getName(), e);
                        objFromJson = null;
                    }
                }
                io.dcloud.uts.UTSArray<T> uTSArray3 = (io.dcloud.uts.UTSArray) objFromJson;
                if (uTSArray3 != null) {
                    uTSArray = uTSArray3;
                }
            }
        }
        return uTSArray != null ? uTSArray : def;
    }
}
