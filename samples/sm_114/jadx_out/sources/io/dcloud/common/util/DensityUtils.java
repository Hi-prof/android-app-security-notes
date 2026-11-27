package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class DensityUtils {
    public static int dip2px(android.content.Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int dp2px(android.content.Context context, float f) {
        return (int) android.util.TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static float px2dp(android.content.Context context, float f) {
        return f / context.getResources().getDisplayMetrics().density;
    }

    public static float px2sp(android.content.Context context, float f) {
        return f / context.getResources().getDisplayMetrics().scaledDensity;
    }

    public static int sp2px(android.content.Context context, float f) {
        return (int) android.util.TypedValue.applyDimension(2, f, context.getResources().getDisplayMetrics());
    }
}
