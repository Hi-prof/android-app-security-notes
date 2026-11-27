package androidx.activity;

/* JADX INFO: compiled from: EdgeToEdge.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J8\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¨\u0006\u0010"}, d2 = {"Landroidx/activity/EdgeToEdgeBase;", "Landroidx/activity/EdgeToEdgeImpl;", "()V", "adjustLayoutInDisplayCutoutMode", "", "window", "Landroid/view/Window;", "setUp", "statusBarStyle", "Landroidx/activity/SystemBarStyle;", "navigationBarStyle", com.taobao.weex.ui.component.WXBasicComponentType.VIEW, "Landroid/view/View;", "statusBarIsDark", "", "navigationBarIsDark", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
class EdgeToEdgeBase implements androidx.activity.EdgeToEdgeImpl {
    @Override // androidx.activity.EdgeToEdgeImpl
    public void adjustLayoutInDisplayCutoutMode(android.view.Window window) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(window, "window");
    }

    @Override // androidx.activity.EdgeToEdgeImpl
    public void setUp(androidx.activity.SystemBarStyle statusBarStyle, androidx.activity.SystemBarStyle navigationBarStyle, android.view.Window window, android.view.View view, boolean statusBarIsDark, boolean navigationBarIsDark) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(statusBarStyle, "statusBarStyle");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(navigationBarStyle, "navigationBarStyle");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(window, "window");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
    }
}
