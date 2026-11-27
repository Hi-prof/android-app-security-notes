package io.dcloud.uts.android;

/* JADX INFO: compiled from: AndroidUTSContext.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010J\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010K\u001a\u00020\u001aJ\u001c\u0010L\u001a\u00020\u001a2\u0006\u0010M\u001a\u0002012\f\u00102\u001a\b\u0012\u0004\u0012\u00020100R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fRg\u0010\u0010\u001aO\u0012K\u0012I\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0017\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a0\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR&\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0 0\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR&\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0 0\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001c\"\u0004\b%\u0010\u001eR&\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0 0\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001c\"\u0004\b(\u0010\u001eR&\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0 0\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001c\"\u0004\b+\u0010\u001eR&\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0 0\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001c\"\u0004\b.\u0010\u001eRq\u0010/\u001aY\u0012U\u0012S\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020100¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(2\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020300¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\u001a0\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001c\"\u0004\b6\u0010\u001eR;\u00107\u001a#\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u001103¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u001a080\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001c\"\u0004\b;\u0010\u001eR;\u0010<\u001a#\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110=¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(>\u0012\u0004\u0012\u00020\u001a080\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u001c\"\u0004\b@\u0010\u001eR&\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0 0\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u001c\"\u0004\bC\u0010\u001eR)\u0010D\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020100\u0012\u0004\u0012\u00020\u001a080\u0011¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u001cR)\u0010F\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020100\u0012\u0004\u0012\u00020\u001a080\u0011¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\u001cR)\u0010H\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020100\u0012\u0004\u0012\u00020\u001a080\u0011¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u001c¨\u0006N"}, d2 = {"Lio/dcloud/uts/android/AndroidUTSContext;", "", "<init>", "()V", "hostAppContext", "Landroid/content/Context;", "getHostAppContext", "()Landroid/content/Context;", "setHostAppContext", "(Landroid/content/Context;)V", "instance", "Lio/dcloud/feature/uniapp/AbsSDKInstance;", "getInstance", "()Lio/dcloud/feature/uniapp/AbsSDKInstance;", "setInstance", "(Lio/dcloud/feature/uniapp/AbsSDKInstance;)V", "onActivityResultListenFunc", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", com.taobao.weex.common.WXModule.REQUEST_CODE, com.taobao.weex.common.WXModule.RESULT_CODE, "Landroid/content/Intent;", "data", "", "getOnActivityResultListenFunc", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "setOnActivityResultListenFunc", "(Ljava/util/concurrent/CopyOnWriteArrayList;)V", "destroyListenFunc", "Lkotlin/Function0;", "getDestroyListenFunc", "setDestroyListenFunc", "pauseListenFunc", "getPauseListenFunc", "setPauseListenFunc", "resumeListenFunc", "getResumeListenFunc", "setResumeListenFunc", "stopListenFunc", "getStopListenFunc", "setStopListenFunc", "backListenFunc", "getBackListenFunc", "setBackListenFunc", "permissionsResultListenFunc", "Lio/dcloud/uts/UTSArray;", "", "permissions", "", com.taobao.weex.common.WXModule.GRANT_RESULTS, "getPermissionsResultListenFunc", "setPermissionsResultListenFunc", "onTrimMemoryListenFunc", "Lkotlin/Function1;", androidtranscoder.format.MediaFormatExtraConstants.KEY_LEVEL, "getOnTrimMemoryListenFunc", "setOnTrimMemoryListenFunc", "onConfigChangedListenFunc", "Lio/dcloud/uts/UTSJSONObject;", com.alibaba.android.bindingx.core.internal.BindingXConstants.KEY_CONFIG, "getOnConfigChangedListenFunc", "setOnConfigChangedListenFunc", "onCreateListenFunc", "getOnCreateListenFunc", "setOnCreateListenFunc", "permissionRequestFunc", "getPermissionRequestFunc", "permissionConfirmFunc", "getPermissionConfirmFunc", "permissionRequestFinishedFunc", "getPermissionRequestFinishedFunc", "initContext", "initApp", "permission", "type", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AndroidUTSContext {
    private static android.content.Context hostAppContext;
    private static io.dcloud.feature.uniapp.AbsSDKInstance instance;
    public static final io.dcloud.uts.android.AndroidUTSContext INSTANCE = new io.dcloud.uts.android.AndroidUTSContext();
    private static java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function3<java.lang.Integer, java.lang.Integer, android.content.Intent, kotlin.Unit>> onActivityResultListenFunc = new java.util.concurrent.CopyOnWriteArrayList<>();
    private static java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function0<kotlin.Unit>> destroyListenFunc = new java.util.concurrent.CopyOnWriteArrayList<>();
    private static java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function0<kotlin.Unit>> pauseListenFunc = new java.util.concurrent.CopyOnWriteArrayList<>();
    private static java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function0<kotlin.Unit>> resumeListenFunc = new java.util.concurrent.CopyOnWriteArrayList<>();
    private static java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function0<kotlin.Unit>> stopListenFunc = new java.util.concurrent.CopyOnWriteArrayList<>();
    private static java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function0<kotlin.Unit>> backListenFunc = new java.util.concurrent.CopyOnWriteArrayList<>();
    private static java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function3<java.lang.Integer, io.dcloud.uts.UTSArray<java.lang.String>, io.dcloud.uts.UTSArray<java.lang.Number>, kotlin.Unit>> permissionsResultListenFunc = new java.util.concurrent.CopyOnWriteArrayList<>();
    private static java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function1<java.lang.Number, kotlin.Unit>> onTrimMemoryListenFunc = new java.util.concurrent.CopyOnWriteArrayList<>();
    private static java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function1<io.dcloud.uts.UTSJSONObject, kotlin.Unit>> onConfigChangedListenFunc = new java.util.concurrent.CopyOnWriteArrayList<>();
    private static java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function0<kotlin.Unit>> onCreateListenFunc = new java.util.concurrent.CopyOnWriteArrayList<>();
    private static final java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function1<io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit>> permissionRequestFunc = new java.util.concurrent.CopyOnWriteArrayList<>();
    private static final java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function1<io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit>> permissionConfirmFunc = new java.util.concurrent.CopyOnWriteArrayList<>();
    private static final java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function1<io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit>> permissionRequestFinishedFunc = new java.util.concurrent.CopyOnWriteArrayList<>();

    private AndroidUTSContext() {
    }

    public final android.content.Context getHostAppContext() {
        return hostAppContext;
    }

    public final void setHostAppContext(android.content.Context context) {
        hostAppContext = context;
    }

    public final io.dcloud.feature.uniapp.AbsSDKInstance getInstance() {
        return instance;
    }

    public final void setInstance(io.dcloud.feature.uniapp.AbsSDKInstance absSDKInstance) {
        instance = absSDKInstance;
    }

    public final java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function3<java.lang.Integer, java.lang.Integer, android.content.Intent, kotlin.Unit>> getOnActivityResultListenFunc() {
        return onActivityResultListenFunc;
    }

    public final void setOnActivityResultListenFunc(java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function3<java.lang.Integer, java.lang.Integer, android.content.Intent, kotlin.Unit>> copyOnWriteArrayList) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(copyOnWriteArrayList, "<set-?>");
        onActivityResultListenFunc = copyOnWriteArrayList;
    }

    public final java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function0<kotlin.Unit>> getDestroyListenFunc() {
        return destroyListenFunc;
    }

    public final void setDestroyListenFunc(java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function0<kotlin.Unit>> copyOnWriteArrayList) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(copyOnWriteArrayList, "<set-?>");
        destroyListenFunc = copyOnWriteArrayList;
    }

    public final java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function0<kotlin.Unit>> getPauseListenFunc() {
        return pauseListenFunc;
    }

    public final void setPauseListenFunc(java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function0<kotlin.Unit>> copyOnWriteArrayList) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(copyOnWriteArrayList, "<set-?>");
        pauseListenFunc = copyOnWriteArrayList;
    }

    public final java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function0<kotlin.Unit>> getResumeListenFunc() {
        return resumeListenFunc;
    }

    public final void setResumeListenFunc(java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function0<kotlin.Unit>> copyOnWriteArrayList) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(copyOnWriteArrayList, "<set-?>");
        resumeListenFunc = copyOnWriteArrayList;
    }

    public final java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function0<kotlin.Unit>> getStopListenFunc() {
        return stopListenFunc;
    }

    public final void setStopListenFunc(java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function0<kotlin.Unit>> copyOnWriteArrayList) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(copyOnWriteArrayList, "<set-?>");
        stopListenFunc = copyOnWriteArrayList;
    }

    public final java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function0<kotlin.Unit>> getBackListenFunc() {
        return backListenFunc;
    }

    public final void setBackListenFunc(java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function0<kotlin.Unit>> copyOnWriteArrayList) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(copyOnWriteArrayList, "<set-?>");
        backListenFunc = copyOnWriteArrayList;
    }

    public final java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function3<java.lang.Integer, io.dcloud.uts.UTSArray<java.lang.String>, io.dcloud.uts.UTSArray<java.lang.Number>, kotlin.Unit>> getPermissionsResultListenFunc() {
        return permissionsResultListenFunc;
    }

    public final void setPermissionsResultListenFunc(java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function3<java.lang.Integer, io.dcloud.uts.UTSArray<java.lang.String>, io.dcloud.uts.UTSArray<java.lang.Number>, kotlin.Unit>> copyOnWriteArrayList) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(copyOnWriteArrayList, "<set-?>");
        permissionsResultListenFunc = copyOnWriteArrayList;
    }

    public final java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function1<java.lang.Number, kotlin.Unit>> getOnTrimMemoryListenFunc() {
        return onTrimMemoryListenFunc;
    }

    public final void setOnTrimMemoryListenFunc(java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function1<java.lang.Number, kotlin.Unit>> copyOnWriteArrayList) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(copyOnWriteArrayList, "<set-?>");
        onTrimMemoryListenFunc = copyOnWriteArrayList;
    }

    public final java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function1<io.dcloud.uts.UTSJSONObject, kotlin.Unit>> getOnConfigChangedListenFunc() {
        return onConfigChangedListenFunc;
    }

    public final void setOnConfigChangedListenFunc(java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function1<io.dcloud.uts.UTSJSONObject, kotlin.Unit>> copyOnWriteArrayList) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(copyOnWriteArrayList, "<set-?>");
        onConfigChangedListenFunc = copyOnWriteArrayList;
    }

    public final java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function0<kotlin.Unit>> getOnCreateListenFunc() {
        return onCreateListenFunc;
    }

    public final void setOnCreateListenFunc(java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function0<kotlin.Unit>> copyOnWriteArrayList) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(copyOnWriteArrayList, "<set-?>");
        onCreateListenFunc = copyOnWriteArrayList;
    }

    public final java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function1<io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit>> getPermissionRequestFunc() {
        return permissionRequestFunc;
    }

    public final java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function1<io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit>> getPermissionConfirmFunc() {
        return permissionConfirmFunc;
    }

    public final java.util.concurrent.CopyOnWriteArrayList<kotlin.jvm.functions.Function1<io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit>> getPermissionRequestFinishedFunc() {
        return permissionRequestFinishedFunc;
    }

    public final void initContext(io.dcloud.feature.uniapp.AbsSDKInstance instance2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(instance2, "instance");
        hostAppContext = instance2.getContext().getApplicationContext();
        instance = instance2;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [io.dcloud.uts.android.AndroidUTSContext$initApp$2] */
    public final void initApp() {
        io.dcloud.common.DHInterface.message.ActionBus.getInstance().observeAction(new io.dcloud.common.DHInterface.message.AbsActionObserver(new io.dcloud.common.DHInterface.message.IObserveAble() { // from class: io.dcloud.uts.android.AndroidUTSContext.initApp.2
            @Override // io.dcloud.common.DHInterface.message.IObserveAble
            public io.dcloud.common.DHInterface.message.EnumUniqueID getActionObserverID() {
                return io.dcloud.common.DHInterface.message.EnumUniqueID.FEATURE_UTS;
            }
        }) { // from class: io.dcloud.uts.android.AndroidUTSContext.initApp.1
            {
                super(anonymousClass2);
            }

            @Override // io.dcloud.common.DHInterface.message.AbsActionObserver
            public boolean handleMessage(io.dcloud.common.DHInterface.message.action.IAction t) {
                if (t instanceof io.dcloud.common.DHInterface.message.action.AppOnTrimMemoryAction) {
                    java.util.Iterator<kotlin.jvm.functions.Function1<java.lang.Number, kotlin.Unit>> it = io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getOnTrimMemoryListenFunc().iterator();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                    while (it.hasNext()) {
                        it.next().invoke2(java.lang.Integer.valueOf(((io.dcloud.common.DHInterface.message.action.AppOnTrimMemoryAction) t).getLevel()));
                    }
                    return true;
                }
                if (t instanceof io.dcloud.common.DHInterface.message.action.AppOnConfigChangedAction) {
                    java.util.Iterator<kotlin.jvm.functions.Function1<io.dcloud.uts.UTSJSONObject, kotlin.Unit>> it2 = io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getOnConfigChangedListenFunc().iterator();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                    while (it2.hasNext()) {
                        kotlin.jvm.functions.Function1<io.dcloud.uts.UTSJSONObject, kotlin.Unit> next = it2.next();
                        io.dcloud.uts.UTSJSONObject uTSJSONObject = new io.dcloud.uts.UTSJSONObject();
                        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSONObject.parseObject(com.alibaba.fastjson.JSON.toJSONString(((io.dcloud.common.DHInterface.message.action.AppOnConfigChangedAction) t).getConfig()));
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(object, "parseObject(...)");
                        uTSJSONObject.fillJSON(object);
                        next.invoke2(uTSJSONObject);
                    }
                    return true;
                }
                if (t instanceof io.dcloud.common.DHInterface.message.action.WebActivityOnDestroyAction) {
                    java.util.Iterator<kotlin.jvm.functions.Function0<kotlin.Unit>> it3 = io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getDestroyListenFunc().iterator();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
                    while (it3.hasNext()) {
                        it3.next().invoke();
                    }
                    io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getDestroyListenFunc().clear();
                    io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getPauseListenFunc().clear();
                    io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getResumeListenFunc().clear();
                    io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getStopListenFunc().clear();
                    io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getBackListenFunc().clear();
                    io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getPermissionsResultListenFunc().clear();
                    io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getOnTrimMemoryListenFunc().clear();
                    io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getOnConfigChangedListenFunc().clear();
                    io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getPermissionRequestFunc().clear();
                    io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getPermissionConfirmFunc().clear();
                    io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getPermissionRequestFinishedFunc().clear();
                    io.dcloud.common.DHInterface.message.ActionBus.getInstance().stopObserve(io.dcloud.common.DHInterface.message.EnumUniqueID.FEATURE_UTS);
                    return true;
                }
                if (!(t instanceof io.dcloud.common.DHInterface.message.action.PermissionRequestAction)) {
                    return false;
                }
                io.dcloud.uts.android.AndroidUTSContext androidUTSContext = io.dcloud.uts.android.AndroidUTSContext.INSTANCE;
                io.dcloud.common.DHInterface.message.action.PermissionRequestAction permissionRequestAction = (io.dcloud.common.DHInterface.message.action.PermissionRequestAction) t;
                java.lang.String type = permissionRequestAction.getType();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                io.dcloud.uts.UTSArray.Companion companion = io.dcloud.uts.UTSArray.INSTANCE;
                java.lang.String[] permissions = permissionRequestAction.getPermissions();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(permissions, "getPermissions(...)");
                androidUTSContext.permission(type, companion.fromNative(permissions));
                return false;
            }
        });
    }

    public final void permission(java.lang.String type, io.dcloud.uts.UTSArray<java.lang.String> permissions) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(permissions, "permissions");
        if (kotlin.jvm.internal.Intrinsics.areEqual(type, io.dcloud.common.DHInterface.message.action.PermissionRequestAction.TYPE_REQUEST)) {
            java.util.Iterator<kotlin.jvm.functions.Function1<io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit>> it = permissionRequestFunc.iterator();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                it.next().invoke2(permissions);
            }
            return;
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(type, io.dcloud.common.DHInterface.message.action.PermissionRequestAction.TYPE_CONFIRM)) {
            java.util.Iterator<kotlin.jvm.functions.Function1<io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit>> it2 = permissionConfirmFunc.iterator();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
            while (it2.hasNext()) {
                it2.next().invoke2(permissions);
            }
            return;
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(type, io.dcloud.common.DHInterface.message.action.PermissionRequestAction.TYPE_COMPLETE)) {
            java.util.Iterator<kotlin.jvm.functions.Function1<io.dcloud.uts.UTSArray<java.lang.String>, kotlin.Unit>> it3 = permissionRequestFinishedFunc.iterator();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
            while (it3.hasNext()) {
                it3.next().invoke2(permissions);
            }
        }
    }
}
