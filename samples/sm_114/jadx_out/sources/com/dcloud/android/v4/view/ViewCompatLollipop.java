package com.dcloud.android.v4.view;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class ViewCompatLollipop {
    ViewCompatLollipop() {
    }

    public static com.dcloud.android.v4.view.WindowInsetsCompat dispatchApplyWindowInsets(android.view.View view, com.dcloud.android.v4.view.WindowInsetsCompat windowInsetsCompat) {
        android.view.WindowInsets windowInsetsUnwrap;
        android.view.WindowInsets windowInsetsDispatchApplyWindowInsets;
        return (!(windowInsetsCompat instanceof com.dcloud.android.v4.view.WindowInsetsCompatApi21) || (windowInsetsDispatchApplyWindowInsets = view.dispatchApplyWindowInsets((windowInsetsUnwrap = ((com.dcloud.android.v4.view.WindowInsetsCompatApi21) windowInsetsCompat).unwrap()))) == windowInsetsUnwrap) ? windowInsetsCompat : new com.dcloud.android.v4.view.WindowInsetsCompatApi21(windowInsetsDispatchApplyWindowInsets);
    }

    public static boolean dispatchNestedFling(android.view.View view, float f, float f2, boolean z) {
        return view.dispatchNestedFling(f, f2, z);
    }

    public static boolean dispatchNestedPreFling(android.view.View view, float f, float f2) {
        return view.dispatchNestedPreFling(f, f2);
    }

    public static boolean dispatchNestedPreScroll(android.view.View view, int i, int i2, int[] iArr, int[] iArr2) {
        return view.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public static boolean dispatchNestedScroll(android.view.View view, int i, int i2, int i3, int i4, int[] iArr) {
        return view.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    static android.content.res.ColorStateList getBackgroundTintList(android.view.View view) {
        return view.getBackgroundTintList();
    }

    static android.graphics.PorterDuff.Mode getBackgroundTintMode(android.view.View view) {
        return view.getBackgroundTintMode();
    }

    public static float getElevation(android.view.View view) {
        return view.getElevation();
    }

    public static java.lang.String getTransitionName(android.view.View view) {
        return view.getTransitionName();
    }

    public static float getTranslationZ(android.view.View view) {
        return view.getTranslationZ();
    }

    public static float getZ(android.view.View view) {
        return view.getZ();
    }

    public static boolean hasNestedScrollingParent(android.view.View view) {
        return view.hasNestedScrollingParent();
    }

    public static boolean isImportantForAccessibility(android.view.View view) {
        return view.isImportantForAccessibility();
    }

    public static boolean isNestedScrollingEnabled(android.view.View view) {
        return view.isNestedScrollingEnabled();
    }

    public static com.dcloud.android.v4.view.WindowInsetsCompat onApplyWindowInsets(android.view.View view, com.dcloud.android.v4.view.WindowInsetsCompat windowInsetsCompat) {
        android.view.WindowInsets windowInsetsUnwrap;
        android.view.WindowInsets windowInsetsOnApplyWindowInsets;
        return (!(windowInsetsCompat instanceof com.dcloud.android.v4.view.WindowInsetsCompatApi21) || (windowInsetsOnApplyWindowInsets = view.onApplyWindowInsets((windowInsetsUnwrap = ((com.dcloud.android.v4.view.WindowInsetsCompatApi21) windowInsetsCompat).unwrap()))) == windowInsetsUnwrap) ? windowInsetsCompat : new com.dcloud.android.v4.view.WindowInsetsCompatApi21(windowInsetsOnApplyWindowInsets);
    }

    public static void requestApplyInsets(android.view.View view) {
        view.requestApplyInsets();
    }

    static void setBackgroundTintList(android.view.View view, android.content.res.ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
    }

    static void setBackgroundTintMode(android.view.View view, android.graphics.PorterDuff.Mode mode) {
        view.setBackgroundTintMode(mode);
    }

    public static void setElevation(android.view.View view, float f) {
        view.setElevation(f);
    }

    public static void setNestedScrollingEnabled(android.view.View view, boolean z) {
        view.setNestedScrollingEnabled(z);
    }

    public static void setOnApplyWindowInsetsListener(android.view.View view, final com.dcloud.android.v4.view.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        view.setOnApplyWindowInsetsListener(new android.view.View.OnApplyWindowInsetsListener() { // from class: com.dcloud.android.v4.view.ViewCompatLollipop.1
            @Override // android.view.View.OnApplyWindowInsetsListener
            public android.view.WindowInsets onApplyWindowInsets(android.view.View view2, android.view.WindowInsets windowInsets) {
                return ((com.dcloud.android.v4.view.WindowInsetsCompatApi21) onApplyWindowInsetsListener.onApplyWindowInsets(view2, new com.dcloud.android.v4.view.WindowInsetsCompatApi21(windowInsets))).unwrap();
            }
        });
    }

    public static void setTransitionName(android.view.View view, java.lang.String str) {
        view.setTransitionName(str);
    }

    public static void setTranslationZ(android.view.View view, float f) {
        view.setTranslationZ(f);
    }

    public static boolean startNestedScroll(android.view.View view, int i) {
        return view.startNestedScroll(i);
    }

    public static void stopNestedScroll(android.view.View view) {
        view.stopNestedScroll();
    }
}
