package uts.sdk.modules.DCloudUniNetwork;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\u0010%\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B'\b\u0016\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0016\u0010\u0015\u001a\u00020\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0014H\u0016J*\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u001d0\u001cH\u0016J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u001bH\u0016J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u000eH\u0016J\u0018\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0005\u001a\u00020\bH\u0002J\u001a\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\bH\u0002J\u0018\u0010(\u001a\b\u0012\u0004\u0012\u00020\b0)2\b\u0010*\u001a\u0004\u0018\u00010\u000eH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Luts/sdk/modules/DCloudUniNetwork/RequestNetworkListener;", "T", "Luts/sdk/modules/DCloudUniNetwork/NetworkRequestListener;", "param", "Luts/sdk/modules/DCloudUniNetwork/RequestOptions;", "type", "Ljava/lang/reflect/Type;", "clzName", "", "<init>", "(Luts/sdk/modules/DCloudUniNetwork/RequestOptions;Ljava/lang/reflect/Type;Ljava/lang/String;)V", "completed", "", "headers", "Lio/dcloud/uts/UTSJSONObject;", "looper", "Landroid/os/Looper;", "task", "Luts/sdk/modules/DCloudUniNetwork/RequestTask;", "setTask", "", "executeCompletionTask", com.taobao.weex.bridge.WXBridgeManager.METHOD_CALLBACK, "Lkotlin/Function0;", "onStart", "onHeadersReceived", "statusCode", "", "", "", "onProgress", "progress", "onComplete", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_OPTION, "readAsString", "byteArray", "", "parseData", "", "data", "parseCookie", "Lio/dcloud/uts/UTSArray;", com.taobao.weex.ui.component.WXBasicComponentType.HEADER, "uni-network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class RequestNetworkListener<T> extends uts.sdk.modules.DCloudUniNetwork.NetworkRequestListener {
    private java.lang.String clzName;
    private boolean completed;
    private io.dcloud.uts.UTSJSONObject headers;
    private android.os.Looper looper;
    private uts.sdk.modules.DCloudUniNetwork.RequestOptions<T> param;
    private uts.sdk.modules.DCloudUniNetwork.RequestTask task;
    private java.lang.reflect.Type type;

    @Override // uts.sdk.modules.DCloudUniNetwork.NetworkRequestListener
    public void onProgress(java.lang.Number progress) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(progress, "progress");
    }

    @Override // uts.sdk.modules.DCloudUniNetwork.NetworkRequestListener
    public void onStart() {
    }

    public RequestNetworkListener(uts.sdk.modules.DCloudUniNetwork.RequestOptions<T> param, java.lang.reflect.Type type, java.lang.String clzName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(param, "param");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(clzName, "clzName");
        this.headers = io.dcloud.uts.UTSJSONObjectKt._uO(new kotlin.Pair[0]);
        this.param = param;
        this.type = type;
        this.clzName = clzName;
        android.os.Looper looperMyLooper = android.os.Looper.myLooper();
        this.looper = looperMyLooper == null ? android.os.Looper.getMainLooper() : looperMyLooper;
    }

    public void setTask(uts.sdk.modules.DCloudUniNetwork.RequestTask task) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(task, "task");
        this.task = task;
    }

    private final void executeCompletionTask(final kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
        new uts.sdk.modules.DCloudUniNetwork.RunnableTask__1(this.looper, new kotlin.jvm.functions.Function0() { // from class: uts.sdk.modules.DCloudUniNetwork.RequestNetworkListener$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return uts.sdk.modules.DCloudUniNetwork.RequestNetworkListener.executeCompletionTask$lambda$0(callback, this);
            }
        }).execute();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> kotlin.Unit executeCompletionTask$lambda$0(kotlin.jvm.functions.Function0<kotlin.Unit> function0, uts.sdk.modules.DCloudUniNetwork.RequestNetworkListener<T> requestNetworkListener) {
        try {
            function0.invoke();
            return kotlin.Unit.INSTANCE;
        } finally {
            uts.sdk.modules.DCloudUniNetwork.RequestTask requestTask = ((uts.sdk.modules.DCloudUniNetwork.RequestNetworkListener) requestNetworkListener).task;
            if (requestTask != null) {
                io.dcloud.uts.UTSAndroid.INSTANCE.destroyInstance(requestTask);
                ((uts.sdk.modules.DCloudUniNetwork.RequestNetworkListener) requestNetworkListener).task = null;
            }
        }
    }

    @Override // uts.sdk.modules.DCloudUniNetwork.NetworkRequestListener
    public void onHeadersReceived(java.lang.Number statusCode, java.util.Map<java.lang.String, java.util.List<java.lang.String>> headers) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(statusCode, "statusCode");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(headers, "headers");
        io.dcloud.uts.UTSJSONObject uTSJSONObject_uO = io.dcloud.uts.UTSJSONObjectKt._uO(new kotlin.Pair[0]);
        for (java.util.Map.Entry<java.lang.String, java.util.List<java.lang.String>> entry : headers.entrySet()) {
            java.lang.String key = entry.getKey();
            java.util.List<java.lang.String> value = entry.getValue();
            if (key == null) {
                key = "_";
            }
            if (value.size() != 0) {
                if (value.size() == 1) {
                    uTSJSONObject_uO.set(key, value.get(0));
                } else {
                    uTSJSONObject_uO.set(key, io.dcloud.uts.NumberKt.toString(value, (java.lang.Number) 10));
                }
            }
        }
        this.headers = uTSJSONObject_uO;
    }

    @Override // uts.sdk.modules.DCloudUniNetwork.NetworkRequestListener
    public void onComplete(io.dcloud.uts.UTSJSONObject option) {
        java.lang.String str;
        java.lang.String dataType;
        java.lang.Object objFromByteBuffer;
        java.lang.String dataType2;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(option, "option");
        if (this.completed) {
            return;
        }
        this.completed = true;
        final kotlin.jvm.internal.Ref.ObjectRef objectRef = new kotlin.jvm.internal.Ref.ObjectRef();
        objectRef.element = this.param;
        io.dcloud.uts.UTSJSONObject uTSJSONObject_uO = io.dcloud.uts.UTSJSONObjectKt._uO(new kotlin.Pair[0]);
        if (objectRef.element != null) {
            boolean zAreEqual = kotlin.jvm.internal.Intrinsics.areEqual("-1", option.get("statusCode"));
            java.lang.String str2 = com.taobao.weex.ui.component.WXBasicComponentType.HEADER;
            if (zAreEqual) {
                io.dcloud.uts.UTSJSONObject uTSJSONObject = this.headers;
                if (uTSJSONObject != null) {
                    uTSJSONObject_uO.set(com.taobao.weex.ui.component.WXBasicComponentType.HEADER, uTSJSONObject);
                }
                java.lang.Object obj = option.get("cause");
                kotlin.jvm.internal.Intrinsics.checkNotNull(obj);
                java.lang.Exception exc = (java.lang.Exception) obj;
                java.lang.Object obj2 = option.get("errorMsg");
                kotlin.jvm.internal.Intrinsics.checkNotNull(obj2);
                java.lang.String str3 = (java.lang.String) obj2;
                java.lang.String string_number_nullable$default = io.dcloud.uts.NumberKt.toString_number_nullable$default(exc.getCause(), (java.lang.Number) null, 1, (java.lang.Object) null);
                if (exc.getCause() == null) {
                    string_number_nullable$default = str3;
                }
                java.lang.Object obj3 = option.get("errorCode");
                kotlin.jvm.internal.Intrinsics.checkNotNull(obj3);
                int i = java.lang.Integer.parseInt((java.lang.String) obj3);
                if (io.dcloud.uts.NumberKt.numberEquals(io.dcloud.uts.StringKt.indexOf$default(str3, "timeout", null, 2, null), -1)) {
                    java.lang.String str4 = string_number_nullable$default;
                    if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) str4, (java.lang.CharSequence) "Connection refused", false, 2, (java.lang.Object) null)) {
                        i = 1000;
                    } else if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) str4, (java.lang.CharSequence) "Network is unreachable", false, 2, (java.lang.Object) null)) {
                        i = 600003;
                    } else if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) str4, (java.lang.CharSequence) "invalid URL", false, 2, (java.lang.Object) null)) {
                        i = 600009;
                    }
                } else {
                    i = 5;
                }
                final kotlin.jvm.internal.Ref.ObjectRef objectRef2 = new kotlin.jvm.internal.Ref.ObjectRef();
                objectRef2.element = (T) new uts.sdk.modules.DCloudUniNetwork.RequestFailImpl(uts.sdk.modules.DCloudUniNetwork.IndexKt.getErrcode(java.lang.Integer.valueOf(i)));
                ((uts.sdk.modules.DCloudUniNetwork.RequestFailImpl) objectRef2.element).setCause(new io.dcloud.uniapp.SourceError(string_number_nullable$default));
                executeCompletionTask(new kotlin.jvm.functions.Function0() { // from class: uts.sdk.modules.DCloudUniNetwork.RequestNetworkListener$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final java.lang.Object invoke() {
                        return uts.sdk.modules.DCloudUniNetwork.RequestNetworkListener.onComplete$lambda$1(objectRef, objectRef2);
                    }
                });
                return;
            }
            uTSJSONObject_uO.set("statusCode", option.get("statusCode"));
            if (option.get("originalData") == null) {
                if (((uts.sdk.modules.DCloudUniNetwork.RequestOptions) objectRef.element).getResponseType() != null) {
                    dataType2 = ((uts.sdk.modules.DCloudUniNetwork.RequestOptions) objectRef.element).getResponseType();
                    kotlin.jvm.internal.Intrinsics.checkNotNull(dataType2);
                } else {
                    dataType2 = ((uts.sdk.modules.DCloudUniNetwork.RequestOptions) objectRef.element).getDataType();
                }
                if (kotlin.text.StringsKt.equals("java.lang.Object", this.clzName, true)) {
                    java.lang.Object obj4 = option.get("errorMsg");
                    if (obj4 != null) {
                        java.lang.Object obj5 = option.get("errorMsg");
                        kotlin.jvm.internal.Intrinsics.checkNotNull(obj5);
                        java.lang.Object obj6 = io.dcloud.uts.JSON.parse((java.lang.String) obj5);
                        if (obj6 != null) {
                            uTSJSONObject_uO.set("data", obj6);
                        } else {
                            uTSJSONObject_uO.set("data", obj4);
                        }
                    } else {
                        uTSJSONObject_uO.set("data", "error");
                    }
                } else if (kotlin.text.StringsKt.equals("java.lang.String", this.clzName, true)) {
                    java.lang.Object obj7 = option.get("errorMsg");
                    uTSJSONObject_uO.set("data", obj7 != null ? obj7 : "error");
                } else if (kotlin.text.StringsKt.equals("io.dcloud.uts.ArrayBuffer", this.clzName, true) || kotlin.text.StringsKt.equals("ArrayBuffer", dataType2, true)) {
                    io.dcloud.uts.TextEncoder textEncoder = new io.dcloud.uts.TextEncoder();
                    java.lang.Object obj8 = option.get("errorMsg");
                    uTSJSONObject_uO.set("data", textEncoder.encode((java.lang.String) (obj8 != null ? obj8 : "error")).getBuffer());
                } else {
                    java.lang.Object obj9 = option.get("errorMsg");
                    if (obj9 != null) {
                        java.lang.Object obj10 = io.dcloud.uts.JSON.parse((java.lang.String) obj9, this.type);
                        if (obj10 != null) {
                            uTSJSONObject_uO.set("data", obj10);
                        } else {
                            final kotlin.jvm.internal.Ref.ObjectRef objectRef3 = new kotlin.jvm.internal.Ref.ObjectRef();
                            objectRef3.element = (T) new uts.sdk.modules.DCloudUniNetwork.RequestFailImpl(uts.sdk.modules.DCloudUniNetwork.IndexKt.getErrcode((java.lang.Number) 100002));
                            ((uts.sdk.modules.DCloudUniNetwork.RequestFailImpl) objectRef3.element).setData(obj9);
                            ((uts.sdk.modules.DCloudUniNetwork.RequestFailImpl) objectRef3.element).setCause(new io.dcloud.uniapp.SourceError("Error message parsing failed"));
                            executeCompletionTask(new kotlin.jvm.functions.Function0() { // from class: uts.sdk.modules.DCloudUniNetwork.RequestNetworkListener$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function0
                                public final java.lang.Object invoke() {
                                    return uts.sdk.modules.DCloudUniNetwork.RequestNetworkListener.onComplete$lambda$2(objectRef, objectRef3);
                                }
                            });
                            return;
                        }
                    }
                }
                str = com.taobao.weex.ui.component.WXBasicComponentType.HEADER;
            } else {
                com.alibaba.fastjson.JSON jSONObject = this.headers.toJSONObject();
                kotlin.jvm.internal.Intrinsics.checkNotNull(jSONObject, "null cannot be cast to non-null type com.alibaba.fastjson.JSONObject");
                com.alibaba.fastjson.JSONObject jSONObject2 = (com.alibaba.fastjson.JSONObject) jSONObject;
                java.util.Iterator it = ((java.util.Set) io.dcloud.uts.UTSIteratorKt.resolveUTSKeyIterator(jSONObject2.keySet())).iterator();
                java.lang.String str5 = "";
                while (it.hasNext()) {
                    java.util.Iterator it2 = it;
                    java.lang.String str6 = (java.lang.String) it.next();
                    java.lang.String str7 = str2;
                    if (kotlin.text.StringsKt.equals(str6, io.dcloud.common.util.net.NetWork.CONTENT_TYPE, true)) {
                        java.lang.Object obj11 = jSONObject2.get(str6);
                        kotlin.jvm.internal.Intrinsics.checkNotNull(obj11, "null cannot be cast to non-null type kotlin.String");
                        str5 = (java.lang.String) obj11;
                    }
                    str2 = str7;
                    it = it2;
                }
                str = str2;
                if (((uts.sdk.modules.DCloudUniNetwork.RequestOptions) objectRef.element).getResponseType() != null) {
                    dataType = ((uts.sdk.modules.DCloudUniNetwork.RequestOptions) objectRef.element).getResponseType();
                    kotlin.jvm.internal.Intrinsics.checkNotNull(dataType);
                } else {
                    dataType = ((uts.sdk.modules.DCloudUniNetwork.RequestOptions) objectRef.element).getDataType();
                }
                if (kotlin.text.StringsKt.equals("io.dcloud.uts.ArrayBuffer", this.clzName, true) || kotlin.text.StringsKt.equals("ArrayBuffer", dataType, true)) {
                    java.lang.Object obj12 = option.get("originalData");
                    kotlin.jvm.internal.Intrinsics.checkNotNull(obj12, "null cannot be cast to non-null type kotlin.ByteArray");
                    io.dcloud.uts.ArrayBuffer.Companion companion = io.dcloud.uts.ArrayBuffer.INSTANCE;
                    java.nio.ByteBuffer byteBufferWrap = java.nio.ByteBuffer.wrap((byte[]) obj12);
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(byteBufferWrap, "wrap(...)");
                    objFromByteBuffer = companion.fromByteBuffer(byteBufferWrap);
                } else {
                    java.lang.Object obj13 = option.get("originalData");
                    kotlin.jvm.internal.Intrinsics.checkNotNull(obj13, "null cannot be cast to non-null type kotlin.ByteArray");
                    java.lang.String str8 = str5;
                    objFromByteBuffer = parseData(readAsString((byte[]) obj13, str8), kotlin.jvm.internal.Intrinsics.areEqual(((uts.sdk.modules.DCloudUniNetwork.RequestOptions) objectRef.element).getMethod(), "HEAD") ? "" : dataType == null ? str8 : dataType);
                    if (objFromByteBuffer == null) {
                        final kotlin.jvm.internal.Ref.ObjectRef objectRef4 = new kotlin.jvm.internal.Ref.ObjectRef();
                        objectRef4.element = (T) new uts.sdk.modules.DCloudUniNetwork.RequestFailImpl(uts.sdk.modules.DCloudUniNetwork.IndexKt.getErrcode((java.lang.Number) 100001));
                        if (!kotlin.text.StringsKt.equals("java.lang.Object", this.clzName, true) && !kotlin.text.StringsKt.equals("java.lang.String", this.clzName, true)) {
                            objectRef4.element = (T) new uts.sdk.modules.DCloudUniNetwork.RequestFailImpl(uts.sdk.modules.DCloudUniNetwork.IndexKt.getErrcode((java.lang.Number) 100003));
                        }
                        executeCompletionTask(new kotlin.jvm.functions.Function0() { // from class: uts.sdk.modules.DCloudUniNetwork.RequestNetworkListener$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final java.lang.Object invoke() {
                                return uts.sdk.modules.DCloudUniNetwork.RequestNetworkListener.onComplete$lambda$3(objectRef, objectRef4);
                            }
                        });
                        return;
                    }
                }
                uTSJSONObject_uO.set("data", objFromByteBuffer);
            }
            uts.sdk.modules.DCloudUniNetwork.StatusCode.Companion companion2 = uts.sdk.modules.DCloudUniNetwork.StatusCode.INSTANCE;
            java.lang.Object obj14 = option.get("statusCode");
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj14, "null cannot be cast to non-null type kotlin.String");
            uTSJSONObject_uO.set(com.taobao.weex.http.WXStreamModule.STATUS_TEXT, companion2.getStatus((java.lang.String) obj14));
            io.dcloud.uts.UTSJSONObject uTSJSONObject2 = this.headers;
            java.lang.String str9 = str;
            if (uTSJSONObject2 != null) {
                uTSJSONObject_uO.set(str9, uTSJSONObject2);
            }
            final kotlin.jvm.internal.Ref.ObjectRef objectRef5 = new kotlin.jvm.internal.Ref.ObjectRef();
            java.lang.Object obj15 = uTSJSONObject_uO.get("data");
            java.lang.Object obj16 = uTSJSONObject_uO.get("statusCode");
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj16, "null cannot be cast to non-null type kotlin.String");
            java.lang.Integer numValueOf = java.lang.Integer.valueOf(java.lang.Integer.parseInt((java.lang.String) obj16));
            java.lang.Object obj17 = uTSJSONObject_uO.get(str9);
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj17);
            objectRef5.element = (T) new uts.sdk.modules.DCloudUniNetwork.RequestSuccess(obj15, numValueOf, obj17, uts.sdk.modules.DCloudUniNetwork.NetworkUtil.INSTANCE.parseCookie(this.headers));
            executeCompletionTask(new kotlin.jvm.functions.Function0() { // from class: uts.sdk.modules.DCloudUniNetwork.RequestNetworkListener$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return uts.sdk.modules.DCloudUniNetwork.RequestNetworkListener.onComplete$lambda$4(objectRef, objectRef5);
                }
            });
            return;
        }
        executeCompletionTask(new kotlin.jvm.functions.Function0() { // from class: uts.sdk.modules.DCloudUniNetwork.RequestNetworkListener$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return kotlin.Unit.INSTANCE;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> kotlin.Unit onComplete$lambda$1(kotlin.jvm.internal.Ref.ObjectRef<uts.sdk.modules.DCloudUniNetwork.RequestOptions<T>> objectRef, kotlin.jvm.internal.Ref.ObjectRef<uts.sdk.modules.DCloudUniNetwork.RequestFailImpl> objectRef2) {
        if (objectRef.element != null) {
            kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniNetwork.RequestFail, kotlin.Unit> fail = objectRef.element.getFail();
            if (fail != null) {
                fail.invoke2(objectRef2.element);
            }
            kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete = objectRef.element.getComplete();
            if (complete != null) {
                complete.invoke2(objectRef2.element);
            }
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> kotlin.Unit onComplete$lambda$2(kotlin.jvm.internal.Ref.ObjectRef<uts.sdk.modules.DCloudUniNetwork.RequestOptions<T>> objectRef, kotlin.jvm.internal.Ref.ObjectRef<uts.sdk.modules.DCloudUniNetwork.RequestFailImpl> objectRef2) {
        if (objectRef.element != null) {
            kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniNetwork.RequestFail, kotlin.Unit> fail = objectRef.element.getFail();
            if (fail != null) {
                fail.invoke2(objectRef2.element);
            }
            kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete = objectRef.element.getComplete();
            if (complete != null) {
                complete.invoke2(objectRef2.element);
            }
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> kotlin.Unit onComplete$lambda$3(kotlin.jvm.internal.Ref.ObjectRef<uts.sdk.modules.DCloudUniNetwork.RequestOptions<T>> objectRef, kotlin.jvm.internal.Ref.ObjectRef<uts.sdk.modules.DCloudUniNetwork.RequestFailImpl> objectRef2) {
        if (objectRef.element != null) {
            kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniNetwork.RequestFail, kotlin.Unit> fail = objectRef.element.getFail();
            if (fail != null) {
                fail.invoke2(objectRef2.element);
            }
            kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete = objectRef.element.getComplete();
            if (complete != null) {
                complete.invoke2(objectRef2.element);
            }
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> kotlin.Unit onComplete$lambda$4(kotlin.jvm.internal.Ref.ObjectRef<uts.sdk.modules.DCloudUniNetwork.RequestOptions<T>> objectRef, kotlin.jvm.internal.Ref.ObjectRef<uts.sdk.modules.DCloudUniNetwork.RequestSuccess<T>> objectRef2) {
        if (objectRef.element != null) {
            kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniNetwork.RequestSuccess<T>, kotlin.Unit> success = objectRef.element.getSuccess();
            if (success != null) {
                success.invoke2(objectRef2.element);
            }
            kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> complete = objectRef.element.getComplete();
            if (complete != null) {
                complete.invoke2(objectRef2.element);
            }
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:6:0x002d  */
    private final java.lang.String readAsString(byte[] byteArray, java.lang.String type) {
        java.lang.String strGroup;
        if (type != null) {
            java.util.regex.Pattern charsetPattern = uts.sdk.modules.DCloudUniNetwork.IndexKt.getCharsetPattern();
            java.util.Locale ENGLISH = java.util.Locale.ENGLISH;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
            java.lang.String lowerCase = type.toLowerCase(ENGLISH);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            java.util.regex.Matcher matcher = charsetPattern.matcher(lowerCase);
            if (matcher.find()) {
                strGroup = matcher.group(1);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strGroup, "group(...)");
            } else {
                strGroup = "utf-8";
            }
        } else {
            strGroup = "utf-8";
        }
        try {
            java.nio.charset.Charset charsetForName = java.nio.charset.Charset.forName(strGroup);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(charsetName)");
            return new java.lang.String(byteArray, charsetForName);
        } catch (java.lang.Exception unused) {
            return new java.lang.String(byteArray, kotlin.text.Charsets.UTF_8);
        }
    }

    private final java.lang.Object parseData(java.lang.String data, java.lang.String type) {
        if (!kotlin.text.StringsKt.equals("java.lang.Object", this.clzName, true)) {
            return kotlin.text.StringsKt.equals("java.lang.String", this.clzName, true) ? data : io.dcloud.uts.JSON.parse(data, this.type);
        }
        java.lang.Object objFromJson = null;
        if (!io.dcloud.uts.NumberKt.numberEquals(io.dcloud.uts.StringKt.indexOf$default(type, "json", null, 2, null), -1)) {
            return io.dcloud.uts.JSON.parse(data);
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(type, "jsonp")) {
            if (android.text.TextUtils.isEmpty(data)) {
                return io.dcloud.uts.UTSJSONObjectKt._uO(new kotlin.Pair[0]);
            }
            java.lang.Number numberPlus = io.dcloud.uts.NumberKt.plus(io.dcloud.uts.StringKt.indexOf$default(data, com.taobao.weex.el.parse.Operators.BRACKET_START_STR, null, 2, null), (java.lang.Number) 1);
            java.lang.Number numberIndexOf$default = io.dcloud.uts.StringKt.indexOf$default(data, com.taobao.weex.el.parse.Operators.BRACKET_END_STR, null, 2, null);
            if (io.dcloud.uts.NumberKt.numberEquals(numberPlus, 0) || io.dcloud.uts.NumberKt.compareTo(numberPlus, numberIndexOf$default) >= 0) {
                return io.dcloud.uts.UTSJSONObjectKt._uO(new kotlin.Pair[0]);
            }
            return io.dcloud.uts.JSON.parse(io.dcloud.uts.StringKt.substring(data, numberPlus, numberIndexOf$default));
        }
        try {
            objFromJson = new io.dcloud.uts.gson.Gson().fromJson(data, this.type);
        } catch (java.lang.Throwable unused) {
        }
        return objFromJson == null ? data : objFromJson;
    }

    private final io.dcloud.uts.UTSArray<java.lang.String> parseCookie(io.dcloud.uts.UTSJSONObject header) throws java.lang.IllegalAccessException {
        if (header != null) {
            java.lang.String string = header.getString(io.dcloud.common.DHInterface.IWebview.SET_COOKIE);
            if (string == null) {
                string = header.getString("set-cookie");
            }
            if (string != null) {
                io.dcloud.uts.UTSArray uTSArray = new io.dcloud.uts.UTSArray();
                if (kotlin.jvm.internal.Intrinsics.areEqual(io.dcloud.uts.StringKt.charAt(string, (java.lang.Number) 0), com.taobao.weex.el.parse.Operators.ARRAY_START_STR) && kotlin.jvm.internal.Intrinsics.areEqual(io.dcloud.uts.StringKt.charAt(string, java.lang.Integer.valueOf(string.length() - 1)), com.taobao.weex.el.parse.Operators.ARRAY_END_STR)) {
                    string = io.dcloud.uts.StringKt.slice(string, (java.lang.Number) 1, (java.lang.Number) (-1));
                }
                io.dcloud.uts.UTSArray<java.lang.String> uTSArraySplit = io.dcloud.uts.StringKt.split(string, ";");
                for (java.lang.Number numberInc = (java.lang.Number) 0; io.dcloud.uts.NumberKt.compareTo(numberInc, uTSArraySplit.getLength()) < 0; numberInc = io.dcloud.uts.NumberKt.inc(numberInc)) {
                    if (!io.dcloud.uts.NumberKt.numberEquals(io.dcloud.uts.StringKt.indexOf$default(uTSArraySplit.get(numberInc), "Expires=", null, 2, null), -1) || !io.dcloud.uts.NumberKt.numberEquals(io.dcloud.uts.StringKt.indexOf$default(uTSArraySplit.get(numberInc), "expires=", null, 2, null), -1)) {
                        uTSArray.push(io.dcloud.uts.StringKt.replace(uTSArraySplit.get(numberInc), ",", ""));
                    } else {
                        uTSArray.push(uTSArraySplit.get(numberInc));
                    }
                }
                return io.dcloud.uts.StringKt.split(uTSArray.join(";"), ",");
            }
            return new io.dcloud.uts.UTSArray<>();
        }
        return new io.dcloud.uts.UTSArray<>();
    }
}
