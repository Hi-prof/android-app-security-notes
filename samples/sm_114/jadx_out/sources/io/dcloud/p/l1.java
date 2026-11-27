package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class l1 {
    public static boolean a(android.content.Context context) {
        int i = android.os.Build.VERSION.SDK_INT;
        return (i >= 29 && context.getApplicationInfo().targetSdkVersion >= 29) || i >= 30;
    }
}
