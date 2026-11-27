package io.dcloud.sdk.core.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class MainHandlerUtil {
    private static volatile android.os.Handler a = new android.os.Handler(android.os.Looper.getMainLooper());

    public static android.os.Handler getMainHandler() {
        if (a == null) {
            synchronized (io.dcloud.sdk.core.util.MainHandlerUtil.class) {
                if (a == null) {
                    a = new android.os.Handler(android.os.Looper.getMainLooper());
                }
            }
        }
        return a;
    }
}
