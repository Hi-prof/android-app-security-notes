package androidx.activity;

/* JADX INFO: compiled from: EdgeToEdge.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B3\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0010\nJ\u0015\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\tH\u0000¢\u0006\u0002\b\u0012J\u0015\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\tH\u0000¢\u0006\u0002\b\u0014R\u0014\u0010\u0004\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u0016"}, d2 = {"Landroidx/activity/SystemBarStyle;", "", "lightScrim", "", "darkScrim", "nightMode", "detectDarkMode", "Lkotlin/Function1;", "Landroid/content/res/Resources;", "", "(IIILkotlin/jvm/functions/Function1;)V", "getDarkScrim$activity_release", "()I", "getDetectDarkMode$activity_release", "()Lkotlin/jvm/functions/Function1;", "getNightMode$activity_release", "getScrim", "isDark", "getScrim$activity_release", "getScrimWithEnforcedContrast", "getScrimWithEnforcedContrast$activity_release", "Companion", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SystemBarStyle {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final androidx.activity.SystemBarStyle.Companion INSTANCE = new androidx.activity.SystemBarStyle.Companion(null);
    private final int darkScrim;
    private final kotlin.jvm.functions.Function1<android.content.res.Resources, java.lang.Boolean> detectDarkMode;
    private final int lightScrim;
    private final int nightMode;

    public /* synthetic */ SystemBarStyle(int i, int i2, int i3, kotlin.jvm.functions.Function1 function1, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, function1);
    }

    @kotlin.jvm.JvmStatic
    public static final androidx.activity.SystemBarStyle auto(int i, int i2) {
        return INSTANCE.auto(i, i2);
    }

    @kotlin.jvm.JvmStatic
    public static final androidx.activity.SystemBarStyle auto(int i, int i2, kotlin.jvm.functions.Function1<? super android.content.res.Resources, java.lang.Boolean> function1) {
        return INSTANCE.auto(i, i2, function1);
    }

    @kotlin.jvm.JvmStatic
    public static final androidx.activity.SystemBarStyle dark(int i) {
        return INSTANCE.dark(i);
    }

    @kotlin.jvm.JvmStatic
    public static final androidx.activity.SystemBarStyle light(int i, int i2) {
        return INSTANCE.light(i, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SystemBarStyle(int i, int i2, int i3, kotlin.jvm.functions.Function1<? super android.content.res.Resources, java.lang.Boolean> function1) {
        this.lightScrim = i;
        this.darkScrim = i2;
        this.nightMode = i3;
        this.detectDarkMode = function1;
    }

    /* JADX INFO: renamed from: getDarkScrim$activity_release, reason: from getter */
    public final int getDarkScrim() {
        return this.darkScrim;
    }

    /* JADX INFO: renamed from: getNightMode$activity_release, reason: from getter */
    public final int getNightMode() {
        return this.nightMode;
    }

    public final kotlin.jvm.functions.Function1<android.content.res.Resources, java.lang.Boolean> getDetectDarkMode$activity_release() {
        return this.detectDarkMode;
    }

    /* JADX INFO: compiled from: EdgeToEdge.kt */
    @kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0007J\u0012\u0010\f\u001a\u00020\u00042\b\b\u0001\u0010\r\u001a\u00020\u0006H\u0007J\u001c\u0010\u000e\u001a\u00020\u00042\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\u000f"}, d2 = {"Landroidx/activity/SystemBarStyle$Companion;", "", "()V", "auto", "Landroidx/activity/SystemBarStyle;", "lightScrim", "", "darkScrim", "detectDarkMode", "Lkotlin/Function1;", "Landroid/content/res/Resources;", "", io.dcloud.common.ui.blur.DCBlurDraweeView.DARK, "scrim", io.dcloud.common.ui.blur.DCBlurDraweeView.LIGHT, "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @kotlin.jvm.JvmStatic
        public final androidx.activity.SystemBarStyle auto(int i, int i2) {
            return auto$default(this, i, i2, null, 4, null);
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ androidx.activity.SystemBarStyle auto$default(androidx.activity.SystemBarStyle.Companion companion, int i, int i2, kotlin.jvm.functions.Function1 function1, int i3, java.lang.Object obj) {
            if ((i3 & 4) != 0) {
                function1 = new kotlin.jvm.functions.Function1<android.content.res.Resources, java.lang.Boolean>() { // from class: androidx.activity.SystemBarStyle$Companion$auto$1
                    @Override // kotlin.jvm.functions.Function1
                    public final java.lang.Boolean invoke(android.content.res.Resources resources) {
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(resources, "resources");
                        return java.lang.Boolean.valueOf((resources.getConfiguration().uiMode & 48) == 32);
                    }
                };
            }
            return companion.auto(i, i2, function1);
        }

        @kotlin.jvm.JvmStatic
        public final androidx.activity.SystemBarStyle auto(int lightScrim, int darkScrim, kotlin.jvm.functions.Function1<? super android.content.res.Resources, java.lang.Boolean> detectDarkMode) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(detectDarkMode, "detectDarkMode");
            return new androidx.activity.SystemBarStyle(lightScrim, darkScrim, 0, detectDarkMode, null);
        }

        @kotlin.jvm.JvmStatic
        public final androidx.activity.SystemBarStyle dark(int scrim) {
            return new androidx.activity.SystemBarStyle(scrim, scrim, 2, new kotlin.jvm.functions.Function1<android.content.res.Resources, java.lang.Boolean>() { // from class: androidx.activity.SystemBarStyle$Companion$dark$1
                @Override // kotlin.jvm.functions.Function1
                public final java.lang.Boolean invoke(android.content.res.Resources resources) {
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(resources, "<anonymous parameter 0>");
                    return true;
                }
            }, null);
        }

        @kotlin.jvm.JvmStatic
        public final androidx.activity.SystemBarStyle light(int scrim, int darkScrim) {
            return new androidx.activity.SystemBarStyle(scrim, darkScrim, 1, new kotlin.jvm.functions.Function1<android.content.res.Resources, java.lang.Boolean>() { // from class: androidx.activity.SystemBarStyle$Companion$light$1
                @Override // kotlin.jvm.functions.Function1
                public final java.lang.Boolean invoke(android.content.res.Resources resources) {
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(resources, "<anonymous parameter 0>");
                    return false;
                }
            }, null);
        }
    }

    public final int getScrim$activity_release(boolean isDark) {
        return isDark ? this.darkScrim : this.lightScrim;
    }

    public final int getScrimWithEnforcedContrast$activity_release(boolean isDark) {
        if (this.nightMode == 0) {
            return 0;
        }
        if (isDark) {
            return this.darkScrim;
        }
        return this.lightScrim;
    }
}
