package uts.sdk.modules.DCloudUniCreateRequestPermissionListener;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u0019\u001a\u00020\u000b2+\u0010\u001a\u001a'\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0005j\u0002`\fH\u0016J5\u0010\u001b\u001a\u00020\u000b2+\u0010\u001a\u001a'\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0005j\u0002`\u0012H\u0016J5\u0010\u001c\u001a\u00020\u000b2+\u0010\u001a\u001a'\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0005j\u0002`\u0016H\u0016J\b\u0010\u001d\u001a\u00020\u000bH\u0016RC\u0010\u0004\u001a+\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0005j\u0004\u0018\u0001`\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010RC\u0010\u0011\u001a+\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0005j\u0004\u0018\u0001`\u0012X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010RC\u0010\u0015\u001a+\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0005j\u0004\u0018\u0001`\u0016X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010¨\u0006\u001e"}, d2 = {"Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/AndroidPermissionRequestManager;", "Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListener;", "<init>", "()V", "requestCallback", "Lkotlin/Function1;", "Lio/dcloud/uts/UTSArray;", "", "Lkotlin/ParameterName;", "name", "permissions", "", "Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListenerRequestCallback;", "getRequestCallback", "()Lkotlin/jvm/functions/Function1;", "setRequestCallback", "(Lkotlin/jvm/functions/Function1;)V", "confirmCallback", "Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListenerConfirmCallback;", "getConfirmCallback", "setConfirmCallback", "completeCallback", "Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListenerCompleteCallback;", "getCompleteCallback", "setCompleteCallback", "onRequest", com.taobao.weex.bridge.WXBridgeManager.METHOD_CALLBACK, "onConfirm", "onComplete", com.taobao.weex.common.Constants.Value.STOP, "uni-createRequestPermissionListener_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class AndroidPermissionRequestManager implements uts.sdk.modules.DCloudUniCreateRequestPermissionListener.RequestPermissionListener {
    private kotlin.jvm.functions.Function1<? super io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit> completeCallback;
    private kotlin.jvm.functions.Function1<? super io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit> confirmCallback;
    private kotlin.jvm.functions.Function1<? super io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit> requestCallback;

    public kotlin.jvm.functions.Function1<io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit> getRequestCallback() {
        return this.requestCallback;
    }

    public void setRequestCallback(kotlin.jvm.functions.Function1<? super io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit> function1) {
        this.requestCallback = function1;
    }

    public kotlin.jvm.functions.Function1<io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit> getConfirmCallback() {
        return this.confirmCallback;
    }

    public void setConfirmCallback(kotlin.jvm.functions.Function1<? super io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit> function1) {
        this.confirmCallback = function1;
    }

    public kotlin.jvm.functions.Function1<io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit> getCompleteCallback() {
        return this.completeCallback;
    }

    public void setCompleteCallback(kotlin.jvm.functions.Function1<? super io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit> function1) {
        this.completeCallback = function1;
    }

    @Override // uts.sdk.modules.DCloudUniCreateRequestPermissionListener.RequestPermissionListener
    public void onRequest(kotlin.jvm.functions.Function1<? super io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        if (getRequestCallback() == null) {
            setRequestCallback(callback);
        } else {
            io.dcloud.uts.UTSAndroid uTSAndroid = io.dcloud.uts.UTSAndroid.INSTANCE;
            kotlin.jvm.functions.Function1<io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit> requestCallback = getRequestCallback();
            kotlin.jvm.internal.Intrinsics.checkNotNull(requestCallback);
            uTSAndroid.offPermissionRequest(requestCallback);
            setRequestCallback(callback);
        }
        io.dcloud.uts.UTSAndroid uTSAndroid2 = io.dcloud.uts.UTSAndroid.INSTANCE;
        kotlin.jvm.functions.Function1<io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit> requestCallback2 = getRequestCallback();
        kotlin.jvm.internal.Intrinsics.checkNotNull(requestCallback2);
        uTSAndroid2.onPermissionRequest(requestCallback2);
    }

    @Override // uts.sdk.modules.DCloudUniCreateRequestPermissionListener.RequestPermissionListener
    public void onConfirm(kotlin.jvm.functions.Function1<? super io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        if (getConfirmCallback() == null) {
            setConfirmCallback(callback);
        } else {
            io.dcloud.uts.UTSAndroid uTSAndroid = io.dcloud.uts.UTSAndroid.INSTANCE;
            kotlin.jvm.functions.Function1<io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit> confirmCallback = getConfirmCallback();
            kotlin.jvm.internal.Intrinsics.checkNotNull(confirmCallback);
            uTSAndroid.offPermissionConfirm(confirmCallback);
            setConfirmCallback(callback);
        }
        io.dcloud.uts.UTSAndroid uTSAndroid2 = io.dcloud.uts.UTSAndroid.INSTANCE;
        kotlin.jvm.functions.Function1<io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit> confirmCallback2 = getConfirmCallback();
        kotlin.jvm.internal.Intrinsics.checkNotNull(confirmCallback2);
        uTSAndroid2.onPermissionConfirm(confirmCallback2);
    }

    @Override // uts.sdk.modules.DCloudUniCreateRequestPermissionListener.RequestPermissionListener
    public void onComplete(kotlin.jvm.functions.Function1<? super io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        if (getCompleteCallback() == null) {
            setCompleteCallback(callback);
        } else {
            io.dcloud.uts.UTSAndroid uTSAndroid = io.dcloud.uts.UTSAndroid.INSTANCE;
            kotlin.jvm.functions.Function1<io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit> completeCallback = getCompleteCallback();
            kotlin.jvm.internal.Intrinsics.checkNotNull(completeCallback);
            uTSAndroid.offPermissionComplete(completeCallback);
            setCompleteCallback(callback);
        }
        io.dcloud.uts.UTSAndroid uTSAndroid2 = io.dcloud.uts.UTSAndroid.INSTANCE;
        kotlin.jvm.functions.Function1<io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit> completeCallback2 = getCompleteCallback();
        kotlin.jvm.internal.Intrinsics.checkNotNull(completeCallback2);
        uTSAndroid2.onPermissionComplete(completeCallback2);
    }

    @Override // uts.sdk.modules.DCloudUniCreateRequestPermissionListener.RequestPermissionListener
    public void stop() {
        if (getCompleteCallback() != null) {
            io.dcloud.uts.UTSAndroid uTSAndroid = io.dcloud.uts.UTSAndroid.INSTANCE;
            kotlin.jvm.functions.Function1<io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit> completeCallback = getCompleteCallback();
            kotlin.jvm.internal.Intrinsics.checkNotNull(completeCallback);
            uTSAndroid.offPermissionComplete(completeCallback);
            setCompleteCallback(null);
        }
        if (getConfirmCallback() != null) {
            io.dcloud.uts.UTSAndroid uTSAndroid2 = io.dcloud.uts.UTSAndroid.INSTANCE;
            kotlin.jvm.functions.Function1<io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit> confirmCallback = getConfirmCallback();
            kotlin.jvm.internal.Intrinsics.checkNotNull(confirmCallback);
            uTSAndroid2.offPermissionConfirm(confirmCallback);
            setConfirmCallback(null);
        }
        if (getRequestCallback() != null) {
            io.dcloud.uts.UTSAndroid uTSAndroid3 = io.dcloud.uts.UTSAndroid.INSTANCE;
            kotlin.jvm.functions.Function1<io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit> requestCallback = getRequestCallback();
            kotlin.jvm.internal.Intrinsics.checkNotNull(requestCallback);
            uTSAndroid3.offPermissionRequest(requestCallback);
            setRequestCallback(null);
        }
    }
}
