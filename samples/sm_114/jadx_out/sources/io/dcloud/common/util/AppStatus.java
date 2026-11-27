package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class AppStatus {
    public static final int ACTIVE = 1;
    public static final int STOPPED = 0;
    public static final int UN_ACTIVIE = 2;
    private static java.util.HashMap<java.lang.String, java.lang.Integer> sMaps = new java.util.HashMap<>();

    public static int getAppStatus(java.lang.String str) {
        if (sMaps.containsKey(str)) {
            return sMaps.get(str).intValue();
        }
        return 0;
    }

    public static void setAppStatus(java.lang.String str, int i) {
        sMaps.put(str, java.lang.Integer.valueOf(i));
    }
}
