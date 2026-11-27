package uts.sdk.modules.DCloudUniNetwork;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0016\u0010\u001a\u001a\u00020\u000f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000bH\u0016J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R?\u0010\b\u001a'\u0012#\u0012!\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\nj\u0002`\u00100\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Luts/sdk/modules/DCloudUniNetwork/DownloadNetworkListener;", "Luts/sdk/modules/DCloudUniNetwork/NetworkDownloadFileListener;", "param", "Luts/sdk/modules/DCloudUniNetwork/DownloadFileOptions;", "<init>", "(Luts/sdk/modules/DCloudUniNetwork/DownloadFileOptions;)V", "completed", "", "progressListeners", "Ljava/util/ArrayList;", "Lkotlin/Function1;", "Luts/sdk/modules/DCloudUniNetwork/OnProgressDownloadResult;", "Lkotlin/ParameterName;", "name", "result", "", "Luts/sdk/modules/DCloudUniNetwork/DownloadFileProgressUpdateCallback;", "getProgressListeners", "()Ljava/util/ArrayList;", "setProgressListeners", "(Ljava/util/ArrayList;)V", "looper", "Landroid/os/Looper;", "task", "Luts/sdk/modules/DCloudUniNetwork/DownloadTask;", "setTask", "executeCompletionTask", com.taobao.weex.bridge.WXBridgeManager.METHOD_CALLBACK, "Lkotlin/Function0;", "onProgress", "progressUpdate", "onComplete", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_OPTION, "Lio/dcloud/uts/UTSJSONObject;", "uni-network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class DownloadNetworkListener implements uts.sdk.modules.DCloudUniNetwork.NetworkDownloadFileListener {
    private boolean completed;
    private android.os.Looper looper;
    private uts.sdk.modules.DCloudUniNetwork.DownloadFileOptions param;
    private java.util.ArrayList<kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniNetwork.OnProgressDownloadResult, kotlin.Unit>> progressListeners;
    private uts.sdk.modules.DCloudUniNetwork.DownloadTask task;

    @Override // uts.sdk.modules.DCloudUniNetwork.NetworkDownloadFileListener
    public java.util.ArrayList<kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniNetwork.OnProgressDownloadResult, kotlin.Unit>> getProgressListeners() {
        return this.progressListeners;
    }

    @Override // uts.sdk.modules.DCloudUniNetwork.NetworkDownloadFileListener
    public void setProgressListeners(java.util.ArrayList<kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniNetwork.OnProgressDownloadResult, kotlin.Unit>> arrayList) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.progressListeners = arrayList;
    }

    public DownloadNetworkListener(uts.sdk.modules.DCloudUniNetwork.DownloadFileOptions param) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(param, "param");
        this.progressListeners = new java.util.ArrayList<>();
        this.param = param;
        android.os.Looper looperMyLooper = android.os.Looper.myLooper();
        this.looper = looperMyLooper == null ? android.os.Looper.getMainLooper() : looperMyLooper;
    }

    public void setTask(uts.sdk.modules.DCloudUniNetwork.DownloadTask task) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(task, "task");
        this.task = task;
    }

    private final void executeCompletionTask(final kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
        new uts.sdk.modules.DCloudUniNetwork.RunnableTask__1(this.looper, new kotlin.jvm.functions.Function0() { // from class: uts.sdk.modules.DCloudUniNetwork.DownloadNetworkListener$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return uts.sdk.modules.DCloudUniNetwork.DownloadNetworkListener.executeCompletionTask$lambda$0(callback, this);
            }
        }).execute();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit executeCompletionTask$lambda$0(kotlin.jvm.functions.Function0<kotlin.Unit> function0, uts.sdk.modules.DCloudUniNetwork.DownloadNetworkListener downloadNetworkListener) {
        try {
            function0.invoke();
            return kotlin.Unit.INSTANCE;
        } finally {
            uts.sdk.modules.DCloudUniNetwork.DownloadTask downloadTask = downloadNetworkListener.task;
            if (downloadTask != null) {
                io.dcloud.uts.UTSAndroid.INSTANCE.destroyInstance(downloadTask);
                downloadNetworkListener.task = null;
            }
        }
    }

    @Override // uts.sdk.modules.DCloudUniNetwork.NetworkDownloadFileListener
    public void onProgress(final uts.sdk.modules.DCloudUniNetwork.OnProgressDownloadResult progressUpdate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(progressUpdate, "progressUpdate");
        if (getProgressListeners().size() != 0) {
            new uts.sdk.modules.DCloudUniNetwork.RunnableTask__1(this.looper, new kotlin.jvm.functions.Function0() { // from class: uts.sdk.modules.DCloudUniNetwork.DownloadNetworkListener$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return uts.sdk.modules.DCloudUniNetwork.DownloadNetworkListener.onProgress$lambda$2(this.f$0, progressUpdate);
                }
            }).execute();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit onProgress$lambda$2(uts.sdk.modules.DCloudUniNetwork.DownloadNetworkListener downloadNetworkListener, uts.sdk.modules.DCloudUniNetwork.OnProgressDownloadResult onProgressDownloadResult) {
        for (int i = 0; i < downloadNetworkListener.getProgressListeners().size(); i++) {
            kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniNetwork.OnProgressDownloadResult, kotlin.Unit> function1 = downloadNetworkListener.getProgressListeners().get(i);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(function1, "get(...)");
            function1.invoke2(onProgressDownloadResult);
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, uts.sdk.modules.DCloudUniNetwork.DownloadFileOptions] */
    /* JADX WARN: Type inference failed for: r3v0, types: [T, uts.sdk.modules.DCloudUniNetwork.DownloadFileSuccess] */
    /* JADX WARN: Type inference failed for: r4v0, types: [T, uts.sdk.modules.DCloudUniNetwork.DownloadFileFailImpl] */
    @Override // uts.sdk.modules.DCloudUniNetwork.NetworkDownloadFileListener
    public void onComplete(io.dcloud.uts.UTSJSONObject option) {
        java.lang.String str;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(option, "option");
        if (this.completed) {
            return;
        }
        this.completed = true;
        final kotlin.jvm.internal.Ref.ObjectRef objectRef = new kotlin.jvm.internal.Ref.ObjectRef();
        objectRef.element = this.param;
        if (objectRef.element != 0) {
            java.lang.Object obj = option.get("errorMsg");
            if (obj != null) {
                java.lang.Object obj2 = option.get("errorCode");
                kotlin.jvm.internal.Intrinsics.checkNotNull(obj2);
                int i = java.lang.Integer.parseInt((java.lang.String) obj2);
                final kotlin.jvm.internal.Ref.ObjectRef objectRef2 = new kotlin.jvm.internal.Ref.ObjectRef();
                objectRef2.element = new uts.sdk.modules.DCloudUniNetwork.DownloadFileFailImpl(uts.sdk.modules.DCloudUniNetwork.IndexKt.getErrcode(java.lang.Integer.valueOf(i)));
                ((uts.sdk.modules.DCloudUniNetwork.DownloadFileFailImpl) objectRef2.element).setErrMsg((java.lang.String) obj);
                java.lang.Object obj3 = option.get("cause");
                if (obj3 != null) {
                    ((uts.sdk.modules.DCloudUniNetwork.DownloadFileFailImpl) objectRef2.element).setCause((io.dcloud.uniapp.SourceError) obj3);
                }
                executeCompletionTask(new kotlin.jvm.functions.Function0() { // from class: uts.sdk.modules.DCloudUniNetwork.DownloadNetworkListener$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final java.lang.Object invoke() {
                        return uts.sdk.modules.DCloudUniNetwork.DownloadNetworkListener.onComplete$lambda$3(objectRef, objectRef2);
                    }
                });
                return;
            }
            java.lang.Object obj4 = option.get("tempFilePath");
            if (obj4 == null) {
                str = "";
            } else {
                str = (java.lang.String) obj4;
            }
            java.lang.Object obj5 = option.get("statusCode");
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj5);
            int i2 = java.lang.Integer.parseInt((java.lang.String) obj5);
            final kotlin.jvm.internal.Ref.ObjectRef objectRef3 = new kotlin.jvm.internal.Ref.ObjectRef();
            objectRef3.element = new uts.sdk.modules.DCloudUniNetwork.DownloadFileSuccess(str, java.lang.Integer.valueOf(i2));
            executeCompletionTask(new kotlin.jvm.functions.Function0() { // from class: uts.sdk.modules.DCloudUniNetwork.DownloadNetworkListener$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return uts.sdk.modules.DCloudUniNetwork.DownloadNetworkListener.onComplete$lambda$4(objectRef, objectRef3);
                }
            });
            return;
        }
        executeCompletionTask(new kotlin.jvm.functions.Function0() { // from class: uts.sdk.modules.DCloudUniNetwork.DownloadNetworkListener$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return kotlin.Unit.INSTANCE;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit onComplete$lambda$3(kotlin.jvm.internal.Ref.ObjectRef<uts.sdk.modules.DCloudUniNetwork.DownloadFileOptions> objectRef, kotlin.jvm.internal.Ref.ObjectRef<uts.sdk.modules.DCloudUniNetwork.DownloadFileFailImpl> objectRef2) {
        if (objectRef.element != null) {
            kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniNetwork.DownloadFileFail, kotlin.Unit> fail = objectRef.element.getFail();
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
    public static final kotlin.Unit onComplete$lambda$4(kotlin.jvm.internal.Ref.ObjectRef<uts.sdk.modules.DCloudUniNetwork.DownloadFileOptions> objectRef, kotlin.jvm.internal.Ref.ObjectRef<uts.sdk.modules.DCloudUniNetwork.DownloadFileSuccess> objectRef2) {
        if (objectRef.element != null) {
            kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniNetwork.DownloadFileSuccess, kotlin.Unit> success = objectRef.element.getSuccess();
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
}
