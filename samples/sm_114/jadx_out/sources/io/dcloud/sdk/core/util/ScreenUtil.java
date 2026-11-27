package io.dcloud.sdk.core.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class ScreenUtil {
    public static int dh(android.content.Context context) {
        if (context == null) {
            return 0;
        }
        return context.getApplicationContext().getResources().getDisplayMetrics().heightPixels;
    }

    public static int dw(android.content.Context context) {
        if (context == null) {
            return 0;
        }
        return context.getApplicationContext().getResources().getDisplayMetrics().widthPixels;
    }
}
