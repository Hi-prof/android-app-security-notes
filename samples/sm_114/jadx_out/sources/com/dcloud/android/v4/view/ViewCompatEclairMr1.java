package com.dcloud.android.v4.view;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
class ViewCompatEclairMr1 {
    public static final java.lang.String TAG = "ViewCompat";
    private static java.lang.reflect.Method sChildrenDrawingOrderMethod;

    ViewCompatEclairMr1() {
    }

    public static boolean isOpaque(android.view.View view) {
        return view.isOpaque();
    }

    public static void setChildrenDrawingOrderEnabled(android.view.ViewGroup viewGroup, boolean z) {
        if (sChildrenDrawingOrderMethod == null) {
            try {
                sChildrenDrawingOrderMethod = android.view.ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", java.lang.Boolean.TYPE);
            } catch (java.lang.NoSuchMethodException e) {
                android.util.Log.e(TAG, "Unable to find childrenDrawingOrderEnabled", e);
            }
            sChildrenDrawingOrderMethod.setAccessible(true);
        }
        try {
            sChildrenDrawingOrderMethod.invoke(viewGroup, java.lang.Boolean.valueOf(z));
        } catch (java.lang.IllegalAccessException e2) {
            android.util.Log.e(TAG, "Unable to invoke childrenDrawingOrderEnabled", e2);
        } catch (java.lang.IllegalArgumentException e3) {
            android.util.Log.e(TAG, "Unable to invoke childrenDrawingOrderEnabled", e3);
        } catch (java.lang.reflect.InvocationTargetException e4) {
            android.util.Log.e(TAG, "Unable to invoke childrenDrawingOrderEnabled", e4);
        }
    }
}
