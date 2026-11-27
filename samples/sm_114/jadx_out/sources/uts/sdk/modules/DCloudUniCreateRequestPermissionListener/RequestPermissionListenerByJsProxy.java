package uts.sdk.modules.DCloudUniCreateRequestPermissionListener;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016R\u001a\u0010\u0006\u001a\u00020\u0003X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005¨\u0006\u0011"}, d2 = {"Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListenerByJsProxy;", "", "ins", "Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListener;", "<init>", "(Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListener;)V", "__instance", "get__instance", "()Luts/sdk/modules/DCloudUniCreateRequestPermissionListener/RequestPermissionListener;", "set__instance", "onRequestByJs", "", com.taobao.weex.bridge.WXBridgeManager.METHOD_CALLBACK, "Lio/dcloud/uts/UTSCallback;", "onConfirmByJs", "onCompleteByJs", "stopByJs", "uni-createRequestPermissionListener_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class RequestPermissionListenerByJsProxy {
    public uts.sdk.modules.DCloudUniCreateRequestPermissionListener.RequestPermissionListener __instance;

    public uts.sdk.modules.DCloudUniCreateRequestPermissionListener.RequestPermissionListener get__instance() {
        uts.sdk.modules.DCloudUniCreateRequestPermissionListener.RequestPermissionListener requestPermissionListener = this.__instance;
        if (requestPermissionListener != null) {
            return requestPermissionListener;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("__instance");
        return null;
    }

    public void set__instance(uts.sdk.modules.DCloudUniCreateRequestPermissionListener.RequestPermissionListener requestPermissionListener) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(requestPermissionListener, "<set-?>");
        this.__instance = requestPermissionListener;
    }

    public RequestPermissionListenerByJsProxy(uts.sdk.modules.DCloudUniCreateRequestPermissionListener.RequestPermissionListener ins) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(ins, "ins");
        set__instance(ins);
    }

    public void onRequestByJs(final io.dcloud.uts.UTSCallback callback) {
        java.lang.Object fnJS;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        uts.sdk.modules.DCloudUniCreateRequestPermissionListener.RequestPermissionListener requestPermissionListener = get__instance();
        if (callback.getFnJS() != null) {
            fnJS = callback.getFnJS();
        } else {
            callback.setFnJS(new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniCreateRequestPermissionListener.RequestPermissionListenerByJsProxy$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: invoke */
                public final java.lang.Object invoke2(java.lang.Object obj) {
                    return uts.sdk.modules.DCloudUniCreateRequestPermissionListener.RequestPermissionListenerByJsProxy.onRequestByJs$lambda$0(callback, (io.dcloud.uts.UTSArray) obj);
                }
            });
            fnJS = callback.getFnJS();
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(fnJS, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"permissions\")] io.dcloud.uts.UTSArray<kotlin.String>, kotlin.Unit>");
        requestPermissionListener.onRequest((kotlin.jvm.functions.Function1) kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(fnJS, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit onRequestByJs$lambda$0(io.dcloud.uts.UTSCallback uTSCallback, io.dcloud.uts.UTSArray<java.lang.String> uTSArray) {
        uTSCallback.invoke(uTSArray);
        return kotlin.Unit.INSTANCE;
    }

    public void onConfirmByJs(final io.dcloud.uts.UTSCallback callback) {
        java.lang.Object fnJS;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        uts.sdk.modules.DCloudUniCreateRequestPermissionListener.RequestPermissionListener requestPermissionListener = get__instance();
        if (callback.getFnJS() != null) {
            fnJS = callback.getFnJS();
        } else {
            callback.setFnJS(new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniCreateRequestPermissionListener.RequestPermissionListenerByJsProxy$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: invoke */
                public final java.lang.Object invoke2(java.lang.Object obj) {
                    return uts.sdk.modules.DCloudUniCreateRequestPermissionListener.RequestPermissionListenerByJsProxy.onConfirmByJs$lambda$1(callback, (io.dcloud.uts.UTSArray) obj);
                }
            });
            fnJS = callback.getFnJS();
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(fnJS, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"permissions\")] io.dcloud.uts.UTSArray<kotlin.String>, kotlin.Unit>");
        requestPermissionListener.onConfirm((kotlin.jvm.functions.Function1) kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(fnJS, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit onConfirmByJs$lambda$1(io.dcloud.uts.UTSCallback uTSCallback, io.dcloud.uts.UTSArray<java.lang.String> uTSArray) {
        uTSCallback.invoke(uTSArray);
        return kotlin.Unit.INSTANCE;
    }

    public void onCompleteByJs(final io.dcloud.uts.UTSCallback callback) {
        java.lang.Object fnJS;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        uts.sdk.modules.DCloudUniCreateRequestPermissionListener.RequestPermissionListener requestPermissionListener = get__instance();
        if (callback.getFnJS() != null) {
            fnJS = callback.getFnJS();
        } else {
            callback.setFnJS(new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniCreateRequestPermissionListener.RequestPermissionListenerByJsProxy$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: invoke */
                public final java.lang.Object invoke2(java.lang.Object obj) {
                    return uts.sdk.modules.DCloudUniCreateRequestPermissionListener.RequestPermissionListenerByJsProxy.onCompleteByJs$lambda$2(callback, (io.dcloud.uts.UTSArray) obj);
                }
            });
            fnJS = callback.getFnJS();
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(fnJS, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"permissions\")] io.dcloud.uts.UTSArray<kotlin.String>, kotlin.Unit>");
        requestPermissionListener.onComplete((kotlin.jvm.functions.Function1) kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(fnJS, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit onCompleteByJs$lambda$2(io.dcloud.uts.UTSCallback uTSCallback, io.dcloud.uts.UTSArray<java.lang.String> uTSArray) {
        uTSCallback.invoke(uTSArray);
        return kotlin.Unit.INSTANCE;
    }

    public void stopByJs() {
        get__instance().stop();
    }
}
