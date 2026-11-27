package uts.sdk.modules.DCloudUniNetwork;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0002J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Luts/sdk/modules/DCloudUniNetwork/DownloadController;", "", "<init>", "()V", "downloadExecutorService", "Ljava/util/concurrent/ExecutorService;", "downloadFile", "Luts/sdk/modules/DCloudUniNetwork/DownloadTask;", "options", "Luts/sdk/modules/DCloudUniNetwork/DownloadFileOptions;", "listener", "Luts/sdk/modules/DCloudUniNetwork/NetworkDownloadFileListener;", "createDownloadClient", "Lokhttp3/OkHttpClient;", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_OPTION, "createDownloadRequest", "Lokhttp3/Request;", "Companion", "uni-network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class DownloadController {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final uts.sdk.modules.DCloudUniNetwork.DownloadController.Companion INSTANCE = new uts.sdk.modules.DCloudUniNetwork.DownloadController.Companion(null);
    private static uts.sdk.modules.DCloudUniNetwork.DownloadController instance;
    private java.util.concurrent.ExecutorService downloadExecutorService;

    public uts.sdk.modules.DCloudUniNetwork.DownloadTask downloadFile(uts.sdk.modules.DCloudUniNetwork.DownloadFileOptions options, uts.sdk.modules.DCloudUniNetwork.NetworkDownloadFileListener listener) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(options, "options");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listener, "listener");
        okhttp3.OkHttpClient okHttpClientCreateDownloadClient = createDownloadClient(options);
        okhttp3.Request requestCreateDownloadRequest = createDownloadRequest(options, listener);
        if (requestCreateDownloadRequest == null) {
            return new uts.sdk.modules.DCloudUniNetwork.NetworkDownloadTaskImpl(null, listener);
        }
        okhttp3.Call callNewCall = okHttpClientCreateDownloadClient.newCall(requestCreateDownloadRequest);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(callNewCall, "newCall(...)");
        java.lang.String filePath = options.getFilePath();
        if (filePath == null) {
            filePath = "";
        }
        callNewCall.enqueue(new uts.sdk.modules.DCloudUniNetwork.SimpleDownloadCallback(listener, filePath));
        return new uts.sdk.modules.DCloudUniNetwork.NetworkDownloadTaskImpl(callNewCall, listener);
    }

    private final okhttp3.OkHttpClient createDownloadClient(uts.sdk.modules.DCloudUniNetwork.DownloadFileOptions option) {
        long jLongValue;
        okhttp3.OkHttpClient.Builder builder = new okhttp3.OkHttpClient.Builder();
        if (option.getTimeout() != null) {
            java.lang.Number timeout = option.getTimeout();
            kotlin.jvm.internal.Intrinsics.checkNotNull(timeout);
            jLongValue = timeout.longValue();
        } else {
            jLongValue = 120000;
        }
        builder.connectTimeout(jLongValue, java.util.concurrent.TimeUnit.MILLISECONDS);
        builder.readTimeout(jLongValue, java.util.concurrent.TimeUnit.MILLISECONDS);
        builder.writeTimeout(jLongValue, java.util.concurrent.TimeUnit.MILLISECONDS);
        builder.addInterceptor(new uts.sdk.modules.DCloudUniNetwork.CookieInterceptor());
        if (this.downloadExecutorService == null) {
            this.downloadExecutorService = java.util.concurrent.Executors.newFixedThreadPool(10);
        }
        builder.dispatcher(new okhttp3.Dispatcher(this.downloadExecutorService));
        okhttp3.OkHttpClient okHttpClientBuild = builder.build();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(okHttpClientBuild, "build(...)");
        return okHttpClientBuild;
    }

    private final okhttp3.Request createDownloadRequest(uts.sdk.modules.DCloudUniNetwork.DownloadFileOptions options, uts.sdk.modules.DCloudUniNetwork.NetworkDownloadFileListener listener) {
        okhttp3.Request.Builder builder = new okhttp3.Request.Builder();
        boolean z = false;
        try {
            builder.url(options.getUrl());
            io.dcloud.uts.UTSJSONObject header = options.getHeader();
            io.dcloud.uts.Map<java.lang.String, java.lang.Object> map = header != null ? header.toMap() : null;
            if (map != null) {
                for (java.util.Map.Entry entry : ((java.util.Map) io.dcloud.uts.UTSIteratorKt.resolveUTSKeyIterator(map)).entrySet()) {
                    java.lang.String str = (java.lang.String) entry.getKey();
                    java.lang.Object value = entry.getValue();
                    if (!z && kotlin.text.StringsKt.equals(str, io.dcloud.common.DHInterface.IWebview.USER_AGENT, true)) {
                        z = true;
                    }
                    if (value != null) {
                        builder.addHeader(str, "" + io.dcloud.uts.NumberKt.toString_number_nullable(value, (java.lang.Number) 10));
                    }
                }
            }
            if (!z) {
                io.dcloud.uts.UTSAndroid uTSAndroid = io.dcloud.uts.UTSAndroid.INSTANCE;
                android.content.Context appContext = io.dcloud.uts.UTSAndroid.INSTANCE.getAppContext();
                kotlin.jvm.internal.Intrinsics.checkNotNull(appContext);
                builder.header(io.dcloud.common.DHInterface.IWebview.USER_AGENT, io.dcloud.uts.NumberKt.toString_number_nullable$default(uTSAndroid.getWebViewInfo(appContext).get("ua"), (java.lang.Number) null, 1, (java.lang.Object) null));
            }
            return builder.build();
        } catch (java.lang.Exception e) {
            io.dcloud.uts.UTSJSONObject uTSJSONObject_uO = io.dcloud.uts.UTSJSONObjectKt._uO(new kotlin.Pair[0]);
            uTSJSONObject_uO.set("statusCode", "-1");
            uTSJSONObject_uO.set("errorCode", "-1");
            uTSJSONObject_uO.set("errorMsg", "invalid URL");
            uTSJSONObject_uO.set("cause", new io.dcloud.uniapp.SourceError(io.dcloud.uts.NumberKt.toString_number_nullable$default(e.getCause(), (java.lang.Number) null, 1, (java.lang.Object) null)));
            if (listener != null) {
                listener.onComplete(uTSJSONObject_uO);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: index.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Luts/sdk/modules/DCloudUniNetwork/DownloadController$Companion;", "", "<init>", "()V", "instance", "Luts/sdk/modules/DCloudUniNetwork/DownloadController;", "getInstance", "uni-network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final uts.sdk.modules.DCloudUniNetwork.DownloadController getInstance() {
            if (uts.sdk.modules.DCloudUniNetwork.DownloadController.instance == null) {
                uts.sdk.modules.DCloudUniNetwork.DownloadController.instance = new uts.sdk.modules.DCloudUniNetwork.DownloadController();
            }
            uts.sdk.modules.DCloudUniNetwork.DownloadController downloadController = uts.sdk.modules.DCloudUniNetwork.DownloadController.instance;
            kotlin.jvm.internal.Intrinsics.checkNotNull(downloadController);
            return downloadController;
        }
    }
}
