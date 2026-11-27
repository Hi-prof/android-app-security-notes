package io.dcloud.sdk.core.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class AdSizeUtil {
    private static float a(android.content.Context context, int i) {
        return i / context.getResources().getDisplayMetrics().density;
    }

    public static float convertHeight(int i, android.content.Context context, boolean z) {
        if (i > 0) {
            return z ? a(context, i) : i;
        }
        return 0.0f;
    }

    public static float convertSize(int i, android.content.Context context, boolean z, boolean z2) {
        if (i > 0) {
            return z ? a(context, i) : i;
        }
        if (!z2) {
            return 0.0f;
        }
        int i2 = context.getResources().getDisplayMetrics().widthPixels;
        return z ? a(context, i2) : i2;
    }

    public static int pxFromDp(float f, android.util.DisplayMetrics displayMetrics) {
        return java.lang.Math.round(android.util.TypedValue.applyDimension(1, f, displayMetrics));
    }
}
