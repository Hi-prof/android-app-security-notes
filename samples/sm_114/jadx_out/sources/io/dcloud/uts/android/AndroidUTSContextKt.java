package io.dcloud.uts.android;

/* JADX INFO: compiled from: AndroidUTSContext.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001a \u0010\u0005\u001a\u00020\u00012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003H\u0007\u001a\u001c\u0010\u0006\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0003H\u0007\u001a \u0010\b\u001a\u00020\u00012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003H\u0007\u001a\u0016\u0010\t\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0007\u001a\u001a\u0010\u000b\u001a\u00020\u00012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nH\u0007\u001a\u0016\u0010\f\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0007\u001a\u001a\u0010\r\u001a\u00020\u00012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nH\u0007\u001a\u0016\u0010\u000e\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0007\u001a\u0016\u0010\u000f\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0007\u001a\u001a\u0010\u0010\u001a\u00020\u00012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nH\u0007\u001aW\u0010\u0011\u001a\u00020\u00012M\u0010\u0002\u001aI\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0017\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u0012H\u0007\u001a[\u0010\u001a\u001a\u00020\u00012Q\b\u0002\u0010\u0002\u001aK\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0017\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012H\u0007\u001a\u0016\u0010\u001b\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0007\u001a\u001a\u0010\u001c\u001a\u00020\u00012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nH\u0007\u001aa\u0010\u001d\u001a\u00020\u00012W\u0010\u0002\u001aS\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b( \u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\u001e¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0012H\u0007\u001ae\u0010\"\u001a\u00020\u00012[\b\u0002\u0010\u0002\u001aU\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b( \u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\u001e¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012H\u0007\u001a\n\u0010#\u001a\u0004\u0018\u00010$H\u0007\u001a\n\u0010%\u001a\u0004\u0018\u00010&H\u0007\u001a\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u001fH\u0007¨\u0006)"}, d2 = {"onAppConfigChange", "", com.taobao.weex.bridge.WXBridgeManager.METHOD_CALLBACK, "Lkotlin/Function1;", "Lio/dcloud/uts/UTSJSONObject;", "offAppConfigChange", "onAppTrimMemory", "", "offAppTrimMemory", "onAppActivityPause", "Lkotlin/Function0;", "offAppActivityPause", "onAppActivityResume", "offAppActivityResume", "onAppActivityStop", "onAppActivityDestroy", "offAppActivityDestroy", "onAppActivityResult", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", com.taobao.weex.common.WXModule.REQUEST_CODE, com.taobao.weex.common.WXModule.RESULT_CODE, "Landroid/content/Intent;", "data", "offAppActivityResult", "onAppActivityBack", "offAppActivityBack", "onAppActivityRequestPermissionsResult", "", "", "permissions", com.taobao.weex.common.WXModule.GRANT_RESULTS, "offAppActivityRequestPermissionsResult", "getAppContext", "Landroid/content/Context;", "getUniActivity", "Landroid/app/Activity;", "getResourcePath", "resourceName", "utsplugin_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AndroidUTSContextKt {
    @kotlin.Deprecated(message = "当前方法已废弃，未来某个时刻将会被移除", replaceWith = @kotlin.ReplaceWith(expression = "UTSAndroid.onAppConfigChange()", imports = {"io.dcloud.uts.UTSAndroid"}))
    public static final void onAppConfigChange(kotlin.jvm.functions.Function1<? super io.dcloud.uts.UTSJSONObject, kotlin.Unit> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getOnConfigChangedListenFunc().add(callback);
    }

    public static /* synthetic */ void offAppConfigChange$default(kotlin.jvm.functions.Function1 function1, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        offAppConfigChange(function1);
    }

    @kotlin.Deprecated(message = "当前方法已废弃，未来某个时刻将会被移除", replaceWith = @kotlin.ReplaceWith(expression = "UTSAndroid.offAppConfigChange()", imports = {"io.dcloud.uts.UTSAndroid"}))
    public static final void offAppConfigChange(kotlin.jvm.functions.Function1<? super io.dcloud.uts.UTSJSONObject, kotlin.Unit> function1) {
        if (function1 == null) {
            io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getOnConfigChangedListenFunc().clear();
        } else {
            io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getOnConfigChangedListenFunc().remove(function1);
        }
    }

    @kotlin.Deprecated(message = "当前方法已废弃，未来某个时刻将会被移除", replaceWith = @kotlin.ReplaceWith(expression = "UTSAndroid.onAppTrimMemory()", imports = {"io.dcloud.uts.UTSAndroid"}))
    public static final void onAppTrimMemory(kotlin.jvm.functions.Function1<? super java.lang.Number, kotlin.Unit> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getOnTrimMemoryListenFunc().add(callback);
    }

    public static /* synthetic */ void offAppTrimMemory$default(kotlin.jvm.functions.Function1 function1, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        offAppTrimMemory(function1);
    }

    @kotlin.Deprecated(message = "当前方法已废弃，未来某个时刻将会被移除", replaceWith = @kotlin.ReplaceWith(expression = "UTSAndroid.offAppTrimMemory()", imports = {"io.dcloud.uts.UTSAndroid"}))
    public static final void offAppTrimMemory(kotlin.jvm.functions.Function1<? super java.lang.Number, kotlin.Unit> function1) {
        if (function1 == null) {
            io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getOnTrimMemoryListenFunc().clear();
        } else {
            io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getOnTrimMemoryListenFunc().remove(function1);
        }
    }

    @kotlin.Deprecated(message = "当前方法已废弃，未来某个时刻将会被移除", replaceWith = @kotlin.ReplaceWith(expression = "UTSAndroid.onAppActivityPause()", imports = {"io.dcloud.uts.UTSAndroid"}))
    public static final void onAppActivityPause(kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getPauseListenFunc().add(callback);
    }

    public static /* synthetic */ void offAppActivityPause$default(kotlin.jvm.functions.Function0 function0, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        offAppActivityPause(function0);
    }

    @kotlin.Deprecated(message = "当前方法已废弃，未来某个时刻将会被移除", replaceWith = @kotlin.ReplaceWith(expression = "UTSAndroid.offAppActivityPause()", imports = {"io.dcloud.uts.UTSAndroid"}))
    public static final void offAppActivityPause(kotlin.jvm.functions.Function0<kotlin.Unit> function0) {
        if (function0 == null) {
            io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getPauseListenFunc().clear();
        } else {
            io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getPauseListenFunc().remove(function0);
        }
    }

    @kotlin.Deprecated(message = "当前方法已废弃，未来某个时刻将会被移除", replaceWith = @kotlin.ReplaceWith(expression = "UTSAndroid.onAppActivityResume()", imports = {"io.dcloud.uts.UTSAndroid"}))
    public static final void onAppActivityResume(kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getResumeListenFunc().add(callback);
    }

    public static /* synthetic */ void offAppActivityResume$default(kotlin.jvm.functions.Function0 function0, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        offAppActivityResume(function0);
    }

    @kotlin.Deprecated(message = "当前方法已废弃，未来某个时刻将会被移除", replaceWith = @kotlin.ReplaceWith(expression = "UTSAndroid.offAppActivityResume()", imports = {"io.dcloud.uts.UTSAndroid"}))
    public static final void offAppActivityResume(kotlin.jvm.functions.Function0<kotlin.Unit> function0) {
        if (function0 == null) {
            io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getResumeListenFunc().clear();
        } else {
            io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getResumeListenFunc().remove(function0);
        }
    }

    @kotlin.Deprecated(message = "当前方法已废弃，未来某个时刻将会被移除", replaceWith = @kotlin.ReplaceWith(expression = "UTSAndroid.onAppActivityStop()", imports = {"io.dcloud.uts.UTSAndroid"}))
    public static final void onAppActivityStop(kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getStopListenFunc().add(callback);
    }

    @kotlin.Deprecated(message = "当前方法已废弃，未来某个时刻将会被移除", replaceWith = @kotlin.ReplaceWith(expression = "UTSAndroid.onAppActivityDestroy()", imports = {"io.dcloud.uts.UTSAndroid"}))
    public static final void onAppActivityDestroy(kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getDestroyListenFunc().add(callback);
    }

    public static /* synthetic */ void offAppActivityDestroy$default(kotlin.jvm.functions.Function0 function0, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        offAppActivityDestroy(function0);
    }

    @kotlin.Deprecated(message = "当前方法已废弃，未来某个时刻将会被移除", replaceWith = @kotlin.ReplaceWith(expression = "UTSAndroid.offAppActivityDestroy()", imports = {"io.dcloud.uts.UTSAndroid"}))
    public static final void offAppActivityDestroy(kotlin.jvm.functions.Function0<kotlin.Unit> function0) {
        if (function0 == null) {
            io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getDestroyListenFunc().clear();
        } else {
            io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getDestroyListenFunc().remove(function0);
        }
    }

    @kotlin.Deprecated(message = "当前方法已废弃，未来某个时刻将会被移除", replaceWith = @kotlin.ReplaceWith(expression = "UTSAndroid.onAppActivityResult()", imports = {"io.dcloud.uts.UTSAndroid"}))
    public static final void onAppActivityResult(kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Integer, ? super android.content.Intent, kotlin.Unit> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getOnActivityResultListenFunc().add(callback);
    }

    public static /* synthetic */ void offAppActivityResult$default(kotlin.jvm.functions.Function3 function3, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            function3 = null;
        }
        offAppActivityResult(function3);
    }

    @kotlin.Deprecated(message = "当前方法已废弃，未来某个时刻将会被移除", replaceWith = @kotlin.ReplaceWith(expression = "UTSAndroid.offAppActivityResult()", imports = {"io.dcloud.uts.UTSAndroid"}))
    public static final void offAppActivityResult(kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Integer, ? super android.content.Intent, kotlin.Unit> function3) {
        if (function3 == null) {
            io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getOnActivityResultListenFunc().clear();
        } else {
            io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getOnActivityResultListenFunc().remove(function3);
        }
    }

    @kotlin.Deprecated(message = "当前方法已废弃，未来某个时刻将会被移除", replaceWith = @kotlin.ReplaceWith(expression = "UTSAndroid.onAppActivityBack()", imports = {"io.dcloud.uts.UTSAndroid"}))
    public static final void onAppActivityBack(kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getBackListenFunc().add(callback);
    }

    public static /* synthetic */ void offAppActivityBack$default(kotlin.jvm.functions.Function0 function0, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        offAppActivityBack(function0);
    }

    @kotlin.Deprecated(message = "当前方法已废弃，未来某个时刻将会被移除", replaceWith = @kotlin.ReplaceWith(expression = "UTSAndroid.offAppActivityBack()", imports = {"io.dcloud.uts.UTSAndroid"}))
    public static final void offAppActivityBack(kotlin.jvm.functions.Function0<kotlin.Unit> function0) {
        if (function0 == null) {
            io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getBackListenFunc().clear();
        } else {
            io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getBackListenFunc().remove(function0);
        }
    }

    @kotlin.Deprecated(message = "当前方法已废弃，未来某个时刻将会被移除", replaceWith = @kotlin.ReplaceWith(expression = "UTSAndroid.onAppActivityRequestPermissionsResult()", imports = {"io.dcloud.uts.UTSAndroid"}))
    public static final void onAppActivityRequestPermissionsResult(kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.util.List<java.lang.String>, ? super java.util.List<java.lang.Number>, kotlin.Unit> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getPermissionsResultListenFunc().add(callback);
    }

    public static /* synthetic */ void offAppActivityRequestPermissionsResult$default(kotlin.jvm.functions.Function3 function3, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            function3 = null;
        }
        offAppActivityRequestPermissionsResult(function3);
    }

    @kotlin.Deprecated(message = "当前方法已废弃，未来某个时刻将会被移除", replaceWith = @kotlin.ReplaceWith(expression = "UTSAndroid.offAppActivityRequestPermissionsResult()", imports = {"io.dcloud.uts.UTSAndroid"}))
    public static final void offAppActivityRequestPermissionsResult(kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.util.List<java.lang.String>, ? super java.util.List<java.lang.Number>, kotlin.Unit> function3) {
        if (function3 == null) {
            io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getPermissionsResultListenFunc().clear();
        } else {
            io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getPermissionsResultListenFunc().remove(function3);
        }
    }

    @kotlin.Deprecated(message = "当前方法已废弃，未来某个时刻将会被移除", replaceWith = @kotlin.ReplaceWith(expression = "UTSAndroid.getAppContext()", imports = {"io.dcloud.uts.UTSAndroid"}))
    public static final android.content.Context getAppContext() {
        return io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getHostAppContext();
    }

    @kotlin.Deprecated(message = "当前方法已废弃，未来某个时刻将会被移除", replaceWith = @kotlin.ReplaceWith(expression = "UTSAndroid.getUniActivity()", imports = {"io.dcloud.uts.UTSAndroid"}))
    public static final android.app.Activity getUniActivity() {
        if (io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getInstance() == null) {
            return null;
        }
        io.dcloud.feature.weex.WeexInstanceMgr weexInstanceMgrSelf = io.dcloud.feature.weex.WeexInstanceMgr.self();
        io.dcloud.feature.uniapp.AbsSDKInstance androidUTSContext = io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getInstance();
        kotlin.jvm.internal.Intrinsics.checkNotNull(androidUTSContext, "null cannot be cast to non-null type com.taobao.weex.WXSDKInstance");
        return weexInstanceMgrSelf.findWebview((com.taobao.weex.WXSDKInstance) androidUTSContext).getActivity();
    }

    @kotlin.Deprecated(message = "当前方法已废弃，未来某个时刻将会被移除", replaceWith = @kotlin.ReplaceWith(expression = "UTSAndroid.getResourcePath()", imports = {"io.dcloud.uts.UTSAndroid"}))
    public static final java.lang.String getResourcePath(java.lang.String resourceName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(resourceName, "resourceName");
        boolean zIsAppResourcesInAssetsPath = io.dcloud.common.util.AppRuntime.isAppResourcesInAssetsPath(getAppContext(), "");
        java.lang.String str = io.dcloud.common.util.BaseInfo.sCacheFsAppsPath;
        java.lang.String str2 = io.dcloud.common.util.BaseInfo.sDefaultBootApp + "/www/" + resourceName;
        java.lang.String str3 = io.dcloud.feature.internal.sdk.SDK.ANDROID_ASSET + str2;
        if (zIsAppResourcesInAssetsPath) {
            return str3;
        }
        return str + str2;
    }
}
