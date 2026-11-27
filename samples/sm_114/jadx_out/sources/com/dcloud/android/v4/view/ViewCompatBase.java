package com.dcloud.android.v4.view;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class ViewCompatBase {
    private static final java.lang.String TAG = "ViewCompatBase";
    private static java.lang.reflect.Field sMinHeightField;
    private static boolean sMinHeightFieldFetched;
    private static java.lang.reflect.Field sMinWidthField;
    private static boolean sMinWidthFieldFetched;

    ViewCompatBase() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    static android.content.res.ColorStateList getBackgroundTintList(android.view.View view) {
        if (view instanceof com.dcloud.android.v4.view.TintableBackgroundView) {
            return ((com.dcloud.android.v4.view.TintableBackgroundView) view).getSupportBackgroundTintList();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static android.graphics.PorterDuff.Mode getBackgroundTintMode(android.view.View view) {
        if (view instanceof com.dcloud.android.v4.view.TintableBackgroundView) {
            return ((com.dcloud.android.v4.view.TintableBackgroundView) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    static int getMinimumHeight(android.view.View view) {
        if (!sMinHeightFieldFetched) {
            try {
                java.lang.reflect.Field declaredField = android.view.View.class.getDeclaredField("mMinHeight");
                sMinHeightField = declaredField;
                declaredField.setAccessible(true);
            } catch (java.lang.NoSuchFieldException unused) {
            }
            sMinHeightFieldFetched = true;
        }
        java.lang.reflect.Field field = sMinHeightField;
        if (field == null) {
            return 0;
        }
        try {
            return ((java.lang.Integer) field.get(view)).intValue();
        } catch (java.lang.Exception unused2) {
            return 0;
        }
    }

    static int getMinimumWidth(android.view.View view) {
        if (!sMinWidthFieldFetched) {
            try {
                java.lang.reflect.Field declaredField = android.view.View.class.getDeclaredField("mMinWidth");
                sMinWidthField = declaredField;
                declaredField.setAccessible(true);
            } catch (java.lang.NoSuchFieldException unused) {
            }
            sMinWidthFieldFetched = true;
        }
        java.lang.reflect.Field field = sMinWidthField;
        if (field == null) {
            return 0;
        }
        try {
            return ((java.lang.Integer) field.get(view)).intValue();
        } catch (java.lang.Exception unused2) {
            return 0;
        }
    }

    static boolean isAttachedToWindow(android.view.View view) {
        return view.getWindowToken() != null;
    }

    static boolean isLaidOut(android.view.View view) {
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static void setBackgroundTintList(android.view.View view, android.content.res.ColorStateList colorStateList) {
        if (view instanceof com.dcloud.android.v4.view.TintableBackgroundView) {
            ((com.dcloud.android.v4.view.TintableBackgroundView) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static void setBackgroundTintMode(android.view.View view, android.graphics.PorterDuff.Mode mode) {
        if (view instanceof com.dcloud.android.v4.view.TintableBackgroundView) {
            ((com.dcloud.android.v4.view.TintableBackgroundView) view).setSupportBackgroundTintMode(mode);
        }
    }
}
