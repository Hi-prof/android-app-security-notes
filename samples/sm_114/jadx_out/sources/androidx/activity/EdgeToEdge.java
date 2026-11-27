package androidx.activity;

/* JADX INFO: compiled from: EdgeToEdge.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u000b\u001a\u00020\f*\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0002\b\u0011\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001c\u0010\u0006\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005\"\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"DefaultDarkScrim", "", "getDefaultDarkScrim$annotations", "()V", "getDefaultDarkScrim", "()I", "DefaultLightScrim", "getDefaultLightScrim$annotations", "getDefaultLightScrim", "Impl", "Landroidx/activity/EdgeToEdgeImpl;", "enableEdgeToEdge", "", "Landroidx/activity/ComponentActivity;", "statusBarStyle", "Landroidx/activity/SystemBarStyle;", "navigationBarStyle", io.dcloud.common.adapter.ui.webview.WebLoadEvent.ENABLE, "activity_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class EdgeToEdge {
    private static androidx.activity.EdgeToEdgeImpl Impl;
    private static final int DefaultLightScrim = android.graphics.Color.argb(230, 255, 255, 255);
    private static final int DefaultDarkScrim = android.graphics.Color.argb(128, 27, 27, 27);

    public static final void enable(androidx.activity.ComponentActivity componentActivity) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        enable$default(componentActivity, null, null, 3, null);
    }

    public static final void enable(androidx.activity.ComponentActivity componentActivity, androidx.activity.SystemBarStyle statusBarStyle) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(statusBarStyle, "statusBarStyle");
        enable$default(componentActivity, statusBarStyle, null, 2, null);
    }

    public static /* synthetic */ void getDefaultDarkScrim$annotations() {
    }

    public static /* synthetic */ void getDefaultLightScrim$annotations() {
    }

    public static final int getDefaultLightScrim() {
        return DefaultLightScrim;
    }

    public static final int getDefaultDarkScrim() {
        return DefaultDarkScrim;
    }

    public static /* synthetic */ void enable$default(androidx.activity.ComponentActivity componentActivity, androidx.activity.SystemBarStyle systemBarStyle, androidx.activity.SystemBarStyle systemBarStyle2, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            systemBarStyle = androidx.activity.SystemBarStyle.Companion.auto$default(androidx.activity.SystemBarStyle.INSTANCE, 0, 0, null, 4, null);
        }
        if ((i & 2) != 0) {
            systemBarStyle2 = androidx.activity.SystemBarStyle.Companion.auto$default(androidx.activity.SystemBarStyle.INSTANCE, DefaultLightScrim, DefaultDarkScrim, null, 4, null);
        }
        enable(componentActivity, systemBarStyle, systemBarStyle2);
    }

    public static final void enable(androidx.activity.ComponentActivity componentActivity, androidx.activity.SystemBarStyle statusBarStyle, androidx.activity.SystemBarStyle navigationBarStyle) {
        androidx.activity.EdgeToEdgeApi21 edgeToEdgeApi21;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(statusBarStyle, "statusBarStyle");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(navigationBarStyle, "navigationBarStyle");
        android.view.View decorView = componentActivity.getWindow().getDecorView();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        kotlin.jvm.functions.Function1<android.content.res.Resources, java.lang.Boolean> detectDarkMode$activity_release = statusBarStyle.getDetectDarkMode$activity_release();
        android.content.res.Resources resources = decorView.getResources();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(resources, "view.resources");
        boolean zBooleanValue = detectDarkMode$activity_release.invoke2(resources).booleanValue();
        kotlin.jvm.functions.Function1<android.content.res.Resources, java.lang.Boolean> detectDarkMode$activity_release2 = navigationBarStyle.getDetectDarkMode$activity_release();
        android.content.res.Resources resources2 = decorView.getResources();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(resources2, "view.resources");
        boolean zBooleanValue2 = detectDarkMode$activity_release2.invoke2(resources2).booleanValue();
        androidx.activity.EdgeToEdgeImpl edgeToEdgeImpl = Impl;
        if (edgeToEdgeImpl == null) {
            if (android.os.Build.VERSION.SDK_INT >= 30) {
                edgeToEdgeApi21 = new androidx.activity.EdgeToEdgeApi30();
            } else if (android.os.Build.VERSION.SDK_INT >= 29) {
                edgeToEdgeApi21 = new androidx.activity.EdgeToEdgeApi29();
            } else if (android.os.Build.VERSION.SDK_INT >= 28) {
                edgeToEdgeApi21 = new androidx.activity.EdgeToEdgeApi28();
            } else if (android.os.Build.VERSION.SDK_INT >= 26) {
                edgeToEdgeApi21 = new androidx.activity.EdgeToEdgeApi26();
            } else if (android.os.Build.VERSION.SDK_INT >= 23) {
                edgeToEdgeApi21 = new androidx.activity.EdgeToEdgeApi23();
            } else {
                edgeToEdgeApi21 = new androidx.activity.EdgeToEdgeApi21();
                Impl = edgeToEdgeApi21;
            }
            edgeToEdgeImpl = edgeToEdgeApi21;
        }
        androidx.activity.EdgeToEdgeImpl edgeToEdgeImpl2 = edgeToEdgeImpl;
        android.view.Window window = componentActivity.getWindow();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(window, "window");
        edgeToEdgeImpl2.setUp(statusBarStyle, navigationBarStyle, window, decorView, zBooleanValue, zBooleanValue2);
        android.view.Window window2 = componentActivity.getWindow();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(window2, "window");
        edgeToEdgeImpl2.adjustLayoutInDisplayCutoutMode(window2);
    }
}
