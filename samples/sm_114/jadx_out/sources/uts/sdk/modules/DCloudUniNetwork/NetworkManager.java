package uts.sdk.modules.DCloudUniNetwork;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J&\u0010\r\u001a\u0004\u0018\u00010\u000e\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J&\u0010\u000f\u001a\u0004\u0018\u00010\u0010\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\u001eH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Luts/sdk/modules/DCloudUniNetwork/NetworkManager;", "", "<init>", "()V", "requestExecutorService", "Ljava/util/concurrent/ExecutorService;", io.dcloud.feature.uniapp.adapter.AbsURIAdapter.REQUEST, "Luts/sdk/modules/DCloudUniNetwork/RequestTask;", "T", "param", "Luts/sdk/modules/DCloudUniNetwork/RequestOptions;", "listener", "Luts/sdk/modules/DCloudUniNetwork/NetworkRequestListener;", "createRequestClient", "Lokhttp3/OkHttpClient;", "createRequest", "Lokhttp3/Request;", "stringifyQuery", "", "url", "data", "Lio/dcloud/uts/UTSJSONObject;", "uploadFile", "Luts/sdk/modules/DCloudUniNetwork/UploadTask;", "options", "Luts/sdk/modules/DCloudUniNetwork/UploadFileOptions;", "Luts/sdk/modules/DCloudUniNetwork/NetworkUploadFileListener;", "downloadFile", "Luts/sdk/modules/DCloudUniNetwork/DownloadTask;", "Luts/sdk/modules/DCloudUniNetwork/DownloadFileOptions;", "Luts/sdk/modules/DCloudUniNetwork/NetworkDownloadFileListener;", "Companion", "uni-network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class NetworkManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final uts.sdk.modules.DCloudUniNetwork.NetworkManager.Companion INSTANCE = new uts.sdk.modules.DCloudUniNetwork.NetworkManager.Companion(null);
    private static okhttp3.ConnectionPool connectPool;
    private static uts.sdk.modules.DCloudUniNetwork.NetworkManager instance;
    private java.util.concurrent.ExecutorService requestExecutorService;

    public <T> uts.sdk.modules.DCloudUniNetwork.RequestTask request(uts.sdk.modules.DCloudUniNetwork.RequestOptions<T> param, uts.sdk.modules.DCloudUniNetwork.NetworkRequestListener listener) throws java.lang.IllegalAccessException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(param, "param");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listener, "listener");
        if (param.getData() != null && !(param.getData() instanceof io.dcloud.uts.UTSJSONObject) && !kotlin.jvm.internal.Intrinsics.areEqual(io.dcloud.uts.UTSAndroid.INSTANCE.typeof(param.getData()), "string") && !(param.getData() instanceof io.dcloud.uts.ArrayBuffer)) {
            io.dcloud.uts.UTSJSONObject uTSJSONObject_uO = io.dcloud.uts.UTSJSONObjectKt._uO(new kotlin.Pair[0]);
            uTSJSONObject_uO.set("statusCode", "-1");
            uTSJSONObject_uO.set("errorCode", "600008");
            uTSJSONObject_uO.set("errorMsg", "the data parameter type is invalid");
            uTSJSONObject_uO.set("cause", new java.lang.Exception("he data parameter type is invalid"));
            listener.onComplete(uTSJSONObject_uO);
            return new uts.sdk.modules.DCloudUniNetwork.NetworkRequestTaskImpl(null);
        }
        listener.onStart();
        okhttp3.OkHttpClient okHttpClientCreateRequestClient = createRequestClient(param, listener);
        if (okHttpClientCreateRequestClient == null) {
            return new uts.sdk.modules.DCloudUniNetwork.NetworkRequestTaskImpl(null);
        }
        okhttp3.Request requestCreateRequest = createRequest(param, listener);
        if (requestCreateRequest == null) {
            return new uts.sdk.modules.DCloudUniNetwork.NetworkRequestTaskImpl(null);
        }
        okhttp3.Call callNewCall = okHttpClientCreateRequestClient.newCall(requestCreateRequest);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(callNewCall, "newCall(...)");
        uts.sdk.modules.DCloudUniNetwork.NetworkRequestTaskImpl networkRequestTaskImpl = new uts.sdk.modules.DCloudUniNetwork.NetworkRequestTaskImpl(callNewCall);
        java.lang.Boolean enableChunked = param.getEnableChunked();
        callNewCall.enqueue(new uts.sdk.modules.DCloudUniNetwork.SimpleCallback(listener, networkRequestTaskImpl, enableChunked != null ? enableChunked.booleanValue() : false, android.os.Looper.myLooper()));
        return networkRequestTaskImpl;
    }

    public <T> okhttp3.OkHttpClient createRequestClient(uts.sdk.modules.DCloudUniNetwork.RequestOptions<T> param, uts.sdk.modules.DCloudUniNetwork.NetworkRequestListener listener) {
        long jLongValue;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(param, "param");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listener, "listener");
        okhttp3.OkHttpClient.Builder builder = new okhttp3.OkHttpClient.Builder();
        if (param.getTimeout() != null) {
            java.lang.Number timeout = param.getTimeout();
            kotlin.jvm.internal.Intrinsics.checkNotNull(timeout);
            jLongValue = timeout.longValue();
        } else {
            jLongValue = 60000;
        }
        builder.connectTimeout(jLongValue, java.util.concurrent.TimeUnit.MILLISECONDS);
        builder.readTimeout(jLongValue, java.util.concurrent.TimeUnit.MILLISECONDS);
        builder.writeTimeout(jLongValue, java.util.concurrent.TimeUnit.MILLISECONDS);
        builder.protocols(java.util.Collections.singletonList(okhttp3.Protocol.HTTP_1_1));
        builder.addInterceptor(new uts.sdk.modules.DCloudUniNetwork.CookieInterceptor());
        if (param.getFirstIpv4() != null) {
            java.lang.Boolean firstIpv4 = param.getFirstIpv4();
            kotlin.jvm.internal.Intrinsics.checkNotNull(firstIpv4);
            if (firstIpv4.booleanValue()) {
                builder.dns(new uts.sdk.modules.DCloudUniNetwork.OKDns());
            }
        }
        if (connectPool == null) {
            connectPool = new okhttp3.ConnectionPool();
        }
        builder.connectionPool(connectPool);
        if (this.requestExecutorService == null) {
            this.requestExecutorService = java.util.concurrent.Executors.newFixedThreadPool(10);
        }
        builder.dispatcher(new okhttp3.Dispatcher(this.requestExecutorService));
        java.lang.Boolean enableQuic = param.getEnableQuic();
        if (enableQuic != null) {
            enableQuic.booleanValue();
        }
        return builder.build();
    }

    public <T> okhttp3.Request createRequest(uts.sdk.modules.DCloudUniNetwork.RequestOptions<T> param, uts.sdk.modules.DCloudUniNetwork.NetworkRequestListener listener) throws java.lang.IllegalAccessException {
        java.lang.Object objArray;
        java.lang.Object data;
        io.dcloud.uts.UTSJSONObject object;
        boolean z;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(param, "param");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listener, "listener");
        okhttp3.Request.Builder builder = new okhttp3.Request.Builder();
        try {
            builder.url(param.getUrl());
            if (param.getHeader() == null) {
                param.setHeader(io.dcloud.uts.UTSJSONObjectKt._uO(new kotlin.Pair[0]));
            }
            io.dcloud.uts.UTSJSONObject header = param.getHeader();
            kotlin.jvm.internal.Intrinsics.checkNotNull(header);
            com.alibaba.fastjson.JSON jSONObject = header.toJSONObject();
            kotlin.jvm.internal.Intrinsics.checkNotNull(jSONObject, "null cannot be cast to non-null type com.alibaba.fastjson.JSONObject");
            com.alibaba.fastjson.JSONObject jSONObject2 = (com.alibaba.fastjson.JSONObject) jSONObject;
            java.util.Iterator it = ((java.util.Set) io.dcloud.uts.UTSIteratorKt.resolveUTSKeyIterator(jSONObject2.keySet())).iterator();
            java.lang.String string = "application/x-www-form-urlencoded; charset=UTF-8";
            boolean z2 = false;
            boolean z3 = false;
            while (true) {
                objArray = "";
                if (!it.hasNext()) {
                    break;
                }
                it = it;
                java.lang.String str = (java.lang.String) it.next();
                java.lang.String str2 = string;
                if (kotlin.text.StringsKt.equals(str, "Accept-Encoding", true)) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder("");
                    z = z2;
                    sb.append(io.dcloud.uts.NumberKt.toString_number_nullable(jSONObject2.get(str), (java.lang.Number) 10));
                    if (io.dcloud.uts.StringKt.includes$default(io.dcloud.uts.StringKt.toLowerCase(sb.toString()), "gzip", null, 2, null)) {
                        string = str2;
                        z2 = z;
                    }
                } else {
                    z = z2;
                }
                if (kotlin.text.StringsKt.equals(str, io.dcloud.common.util.net.NetWork.CONTENT_TYPE, true)) {
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder("");
                    java.lang.Object obj = jSONObject2.get(str);
                    kotlin.jvm.internal.Intrinsics.checkNotNull(obj);
                    sb2.append(io.dcloud.uts.NumberKt.toString(obj, (java.lang.Number) 10));
                    string = sb2.toString();
                    z2 = true;
                } else {
                    string = str2;
                    z2 = z;
                }
                if (!z3 && kotlin.text.StringsKt.equals(str, io.dcloud.common.DHInterface.IWebview.USER_AGENT, true)) {
                    z3 = true;
                }
                builder.header(str, "" + io.dcloud.uts.NumberKt.toString_number_nullable(jSONObject2.get(str), (java.lang.Number) 10));
            }
            java.lang.String str3 = (z2 || "GET".equals(param.getMethod())) ? string : "application/json";
            if (!z3) {
                io.dcloud.uts.UTSAndroid uTSAndroid = io.dcloud.uts.UTSAndroid.INSTANCE;
                android.content.Context appContext = io.dcloud.uts.UTSAndroid.INSTANCE.getAppContext();
                kotlin.jvm.internal.Intrinsics.checkNotNull(appContext);
                builder.header(io.dcloud.common.DHInterface.IWebview.USER_AGENT, io.dcloud.uts.NumberKt.toString_number_nullable$default(uTSAndroid.getWebViewInfo(appContext).get("ua"), (java.lang.Number) null, 1, (java.lang.Object) null));
            }
            if ("POST".equals(param.getMethod()) || "PUT".equals(param.getMethod()) || "PATCH".equals(param.getMethod()) || "DELETE".equals(param.getMethod())) {
                if (param.getData() != null) {
                    listener.onProgress((java.lang.Number) 0);
                }
                if (param.getData() != null) {
                    if (kotlin.jvm.internal.Intrinsics.areEqual(io.dcloud.uts.UTSAndroid.INSTANCE.typeof(param.getData()), "string")) {
                        java.lang.Object data2 = param.getData();
                        kotlin.jvm.internal.Intrinsics.checkNotNull(data2, "null cannot be cast to non-null type kotlin.String");
                        objArray = (java.lang.String) data2;
                    } else if (param.getData() instanceof io.dcloud.uts.ArrayBuffer) {
                        try {
                            java.lang.Object data3 = param.getData();
                            kotlin.jvm.internal.Intrinsics.checkNotNull(data3, "null cannot be cast to non-null type io.dcloud.uts.ArrayBuffer");
                            objArray = ((io.dcloud.uts.ArrayBuffer) data3).toByteBuffer().array();
                            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(objArray, "array(...)");
                        } catch (java.lang.Exception e) {
                            io.dcloud.uts.UTSJSONObject uTSJSONObject_uO = io.dcloud.uts.UTSJSONObjectKt._uO(new kotlin.Pair[0]);
                            uTSJSONObject_uO.set("statusCode", "-1");
                            uTSJSONObject_uO.set("errorCode", "602001");
                            uTSJSONObject_uO.set("errorMsg", "request system error");
                            uTSJSONObject_uO.set("cause", e);
                            listener.onComplete(uTSJSONObject_uO);
                            return null;
                        }
                    } else if (param.getData() instanceof io.dcloud.uts.UTSJSONObject) {
                        if (io.dcloud.uts.NumberKt.numberEquals(io.dcloud.uts.StringKt.indexOf$default(str3, "application/x-www-form-urlencoded", null, 2, null), 0)) {
                            java.lang.Object data4 = param.getData();
                            kotlin.jvm.internal.Intrinsics.checkNotNull(data4, "null cannot be cast to non-null type io.dcloud.uts.UTSJSONObject");
                            io.dcloud.uts.Map<java.lang.String, java.lang.Object> map = ((io.dcloud.uts.UTSJSONObject) data4).toMap();
                            final io.dcloud.uts.UTSArray uTSArray = new io.dcloud.uts.UTSArray();
                            map.forEach(new kotlin.jvm.functions.Function2() { // from class: uts.sdk.modules.DCloudUniNetwork.NetworkManager$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final java.lang.Object invoke(java.lang.Object obj2, java.lang.Object obj3) {
                                    return uts.sdk.modules.DCloudUniNetwork.NetworkManager.createRequest$lambda$0(uTSArray, obj2, (java.lang.String) obj3);
                                }
                            });
                            objArray = uTSArray.join("&");
                        } else {
                            objArray = io.dcloud.uts.JSON.stringify(param.getData());
                        }
                    }
                }
                if (objArray instanceof byte[]) {
                    builder.method(param.getMethod(), okhttp3.RequestBody.create(okhttp3.MediaType.parse(str3), (byte[]) objArray));
                } else {
                    okhttp3.MediaType mediaType = okhttp3.MediaType.parse(str3);
                    kotlin.jvm.internal.Intrinsics.checkNotNull(objArray, "null cannot be cast to non-null type kotlin.String");
                    builder.method(param.getMethod(), okhttp3.RequestBody.create(mediaType, (java.lang.String) objArray));
                }
                listener.onProgress((java.lang.Number) 100);
            } else if ("HEAD".equals(param.getMethod())) {
                builder.head();
            } else if ("OPTIONS".equals(param.getMethod())) {
                builder.method(param.getMethod(), null);
            } else if ((param.getMethod() == null || "GET".equals(param.getMethod())) && (data = param.getData()) != null) {
                if (kotlin.jvm.internal.Intrinsics.areEqual(io.dcloud.uts.UTSAndroid.INSTANCE.typeof(data), "string")) {
                    object = io.dcloud.uts.JSON.parseObject((java.lang.String) data);
                } else {
                    object = data instanceof io.dcloud.uts.UTSJSONObject ? (io.dcloud.uts.UTSJSONObject) data : null;
                }
                if (object != null) {
                    try {
                        builder.url(stringifyQuery(param.getUrl(), object));
                    } catch (java.lang.Exception e2) {
                        io.dcloud.uts.UTSJSONObject uTSJSONObject_uO2 = io.dcloud.uts.UTSJSONObjectKt._uO(new kotlin.Pair[0]);
                        uTSJSONObject_uO2.set("statusCode", "-1");
                        uTSJSONObject_uO2.set("errorCode", "600009");
                        uTSJSONObject_uO2.set("errorMsg", "invalid URL");
                        uTSJSONObject_uO2.set("cause", e2);
                        listener.onComplete(uTSJSONObject_uO2);
                        return null;
                    }
                }
            }
            return builder.build();
        } catch (java.lang.Exception e3) {
            io.dcloud.uts.UTSJSONObject uTSJSONObject_uO3 = io.dcloud.uts.UTSJSONObjectKt._uO(new kotlin.Pair[0]);
            uTSJSONObject_uO3.set("statusCode", "-1");
            uTSJSONObject_uO3.set("errorCode", "600009");
            uTSJSONObject_uO3.set("errorMsg", "invalid URL");
            uTSJSONObject_uO3.set("cause", e3);
            listener.onComplete(uTSJSONObject_uO3);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit createRequest$lambda$0(io.dcloud.uts.UTSArray<java.lang.String> uTSArray, java.lang.Object obj, java.lang.String str) {
        uTSArray.push(str + '=' + io.dcloud.uts.NumberKt.toString_number_nullable(obj, (java.lang.Number) 10));
        return kotlin.Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [T, java.lang.String] */
    private final java.lang.String stringifyQuery(java.lang.String url, io.dcloud.uts.UTSJSONObject data) {
        java.lang.String str;
        java.lang.String str2;
        io.dcloud.uts.UTSArray<java.lang.String> uTSArraySplit = io.dcloud.uts.StringKt.split(url, "#");
        if (io.dcloud.uts.NumberKt.compareTo(uTSArraySplit.getLength(), (java.lang.Number) 1) > 0) {
            java.lang.String str3 = uTSArraySplit.get(1);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str3, "get(...)");
            str = str3;
        } else {
            str = "";
        }
        java.lang.String str4 = uTSArraySplit.get(0);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str4, "get(...)");
        io.dcloud.uts.UTSArray<java.lang.String> uTSArraySplit2 = io.dcloud.uts.StringKt.split(str4, com.taobao.weex.el.parse.Operators.CONDITION_IF_STRING);
        if (io.dcloud.uts.NumberKt.compareTo(uTSArraySplit2.getLength(), (java.lang.Number) 1) > 0) {
            java.lang.String str5 = uTSArraySplit2.get(1);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str5, "get(...)");
            str2 = str5;
        } else {
            str2 = "";
        }
        java.lang.String str6 = uTSArraySplit2.get(0);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str6, "get(...)");
        java.lang.String str7 = str6;
        io.dcloud.uts.UTSArray<java.lang.String> uTSArraySplit3 = io.dcloud.uts.StringKt.split(str2, "&");
        final io.dcloud.uts.Map map = new io.dcloud.uts.Map();
        uTSArraySplit3.forEach(new kotlin.jvm.functions.Function2() { // from class: uts.sdk.modules.DCloudUniNetwork.NetworkManager$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2) {
                return uts.sdk.modules.DCloudUniNetwork.NetworkManager.stringifyQuery$lambda$1(map, (java.lang.String) obj, (java.lang.Number) obj2);
            }
        });
        data.toMap().forEach(new kotlin.jvm.functions.Function2() { // from class: uts.sdk.modules.DCloudUniNetwork.NetworkManager$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2) {
                return uts.sdk.modules.DCloudUniNetwork.NetworkManager.stringifyQuery$lambda$2(map, obj, (java.lang.String) obj2);
            }
        });
        final kotlin.jvm.internal.Ref.ObjectRef objectRef = new kotlin.jvm.internal.Ref.ObjectRef();
        objectRef.element = "";
        map.forEach(new kotlin.jvm.functions.Function2() { // from class: uts.sdk.modules.DCloudUniNetwork.NetworkManager$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2) {
                return uts.sdk.modules.DCloudUniNetwork.NetworkManager.stringifyQuery$lambda$3(objectRef, (java.lang.String) obj, (java.lang.String) obj2);
            }
        });
        objectRef.element = io.dcloud.uts.StringKt.slice((java.lang.String) objectRef.element, (java.lang.Number) 0, (java.lang.Number) (-1));
        if (((java.lang.String) objectRef.element).length() > 0) {
            str7 = str7 + com.taobao.weex.el.parse.Operators.CONDITION_IF + ((java.lang.String) objectRef.element);
        }
        if (str.length() <= 0) {
            return str7;
        }
        return str7 + '#' + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit stringifyQuery$lambda$1(io.dcloud.uts.Map<java.lang.String, java.lang.String> map, java.lang.String str, java.lang.Number number) {
        io.dcloud.uts.UTSArray<java.lang.String> uTSArraySplit = io.dcloud.uts.StringKt.split(str, "=");
        if (io.dcloud.uts.NumberKt.compareTo(uTSArraySplit.getLength(), (java.lang.Number) 1) > 0) {
            map.put(uTSArraySplit.get(0), uTSArraySplit.get(1));
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit stringifyQuery$lambda$2(io.dcloud.uts.Map<java.lang.String, java.lang.String> map, java.lang.Object obj, java.lang.String str) {
        if (obj == null) {
            obj = "";
        }
        java.lang.String strEncodeURIComponent = io.dcloud.uts.ObjectKt.encodeURIComponent(str);
        kotlin.jvm.internal.Intrinsics.checkNotNull(strEncodeURIComponent);
        if (!(obj instanceof io.dcloud.uts.UTSJSONObject) && !(obj instanceof io.dcloud.uts.UTSArray)) {
            java.lang.String strEncodeURIComponent2 = io.dcloud.uts.ObjectKt.encodeURIComponent("" + io.dcloud.uts.NumberKt.toString_number_nullable(obj, (java.lang.Number) 10));
            kotlin.jvm.internal.Intrinsics.checkNotNull(strEncodeURIComponent2);
            map.put(strEncodeURIComponent, strEncodeURIComponent2);
        } else {
            java.lang.String strEncodeURIComponent3 = io.dcloud.uts.ObjectKt.encodeURIComponent(io.dcloud.uts.JSON.stringify(obj));
            kotlin.jvm.internal.Intrinsics.checkNotNull(strEncodeURIComponent3);
            map.put(strEncodeURIComponent, strEncodeURIComponent3);
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, java.lang.String] */
    public static final kotlin.Unit stringifyQuery$lambda$3(kotlin.jvm.internal.Ref.ObjectRef<java.lang.String> objectRef, java.lang.String str, java.lang.String str2) {
        objectRef.element += str2 + '=' + str + kotlin.text.Typography.amp;
        return kotlin.Unit.INSTANCE;
    }

    public uts.sdk.modules.DCloudUniNetwork.UploadTask uploadFile(uts.sdk.modules.DCloudUniNetwork.UploadFileOptions options, uts.sdk.modules.DCloudUniNetwork.NetworkUploadFileListener listener) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(options, "options");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listener, "listener");
        return uts.sdk.modules.DCloudUniNetwork.UploadController.INSTANCE.getInstance().uploadFile(options, listener);
    }

    public uts.sdk.modules.DCloudUniNetwork.DownloadTask downloadFile(uts.sdk.modules.DCloudUniNetwork.DownloadFileOptions options, uts.sdk.modules.DCloudUniNetwork.NetworkDownloadFileListener listener) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(options, "options");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listener, "listener");
        return uts.sdk.modules.DCloudUniNetwork.DownloadController.INSTANCE.getInstance().downloadFile(options, listener);
    }

    /* JADX INFO: compiled from: index.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Luts/sdk/modules/DCloudUniNetwork/NetworkManager$Companion;", "", "<init>", "()V", "instance", "Luts/sdk/modules/DCloudUniNetwork/NetworkManager;", "connectPool", "Lokhttp3/ConnectionPool;", "getInstance", "uni-network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final uts.sdk.modules.DCloudUniNetwork.NetworkManager getInstance() {
            if (uts.sdk.modules.DCloudUniNetwork.NetworkManager.instance == null) {
                uts.sdk.modules.DCloudUniNetwork.NetworkManager.instance = new uts.sdk.modules.DCloudUniNetwork.NetworkManager();
            }
            uts.sdk.modules.DCloudUniNetwork.NetworkManager networkManager = uts.sdk.modules.DCloudUniNetwork.NetworkManager.instance;
            kotlin.jvm.internal.Intrinsics.checkNotNull(networkManager);
            return networkManager;
        }
    }
}
