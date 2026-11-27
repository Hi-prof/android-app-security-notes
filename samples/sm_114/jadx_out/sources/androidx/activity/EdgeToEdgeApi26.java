package androidx.activity;

/* JADX INFO: compiled from: EdgeToEdge.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0013\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0017¨\u0006\u000f"}, d2 = {"Landroidx/activity/EdgeToEdgeApi26;", "Landroidx/activity/EdgeToEdgeBase;", "()V", "setUp", "", "statusBarStyle", "Landroidx/activity/SystemBarStyle;", "navigationBarStyle", "window", "Landroid/view/Window;", com.taobao.weex.ui.component.WXBasicComponentType.VIEW, "Landroid/view/View;", "statusBarIsDark", "", "navigationBarIsDark", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
class EdgeToEdgeApi26 extends androidx.activity.EdgeToEdgeBase {
    @Override // androidx.activity.EdgeToEdgeBase, androidx.activity.EdgeToEdgeImpl
    public void setUp(androidx.activity.SystemBarStyle statusBarStyle, androidx.activity.SystemBarStyle navigationBarStyle, android.view.Window window, android.view.View view, boolean statusBarIsDark, boolean navigationBarIsDark) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(statusBarStyle, "statusBarStyle");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(navigationBarStyle, "navigationBarStyle");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(window, "window");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
        androidx.core.view.WindowCompat.setDecorFitsSystemWindows(window, false);
        window.setStatusBarColor(statusBarStyle.getScrim$activity_release(statusBarIsDark));
        window.setNavigationBarColor(navigationBarStyle.getScrim$activity_release(navigationBarIsDark));
        androidx.core.view.WindowInsetsControllerCompat windowInsetsControllerCompat = new androidx.core.view.WindowInsetsControllerCompat(window, view);
        windowInsetsControllerCompat.setAppearanceLightStatusBars(!statusBarIsDark);
        windowInsetsControllerCompat.setAppearanceLightNavigationBars(!navigationBarIsDark);
    }
}
