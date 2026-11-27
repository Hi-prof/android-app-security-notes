package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class NetworkTypeUtil {
    public static final int NETWORK_TYPE_2G = 4;
    public static final int NETWORK_TYPE_3G = 5;
    public static final int NETWORK_TYPE_4G = 6;
    public static final int NETWORK_TYPE_DISABLED = 1;
    public static final int NETWORK_TYPE_LINE = 2;
    public static final int NETWORK_TYPE_UNKONWN = 0;
    public static final int NETWORK_TYPE_WIFI = 3;

    public static java.lang.String getCurrentAPN(android.content.Context context) {
        android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return (activeNetworkInfo == null || activeNetworkInfo.getType() != 0) ? "" : activeNetworkInfo.getExtraInfo();
    }

    public static int getNetworkType(android.content.Context context) {
        if (io.dcloud.common.util.AppRuntime.hasPrivacyForNotShown(context) || androidx.core.content.ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") != 0) {
            return 0;
        }
        android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return 1;
        }
        if (activeNetworkInfo.getType() != 0) {
            return activeNetworkInfo.getType() == 1 ? 3 : 0;
        }
        switch (activeNetworkInfo.getSubtype()) {
            case 1:
            case 2:
            case 4:
                return 4;
            case 3:
            case 5:
            case 6:
            case 8:
            case 12:
                return 5;
            case 7:
            case 14:
            case 16:
            default:
                return 0;
            case 9:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
                return 6;
        }
    }

    public static boolean isWifiProxy(android.content.Context context) {
        java.lang.String property = java.lang.System.getProperty("http.proxyHost");
        java.lang.String property2 = java.lang.System.getProperty("http.proxyPort");
        if (property2 == null) {
            property2 = "-1";
        }
        return (android.text.TextUtils.isEmpty(property) || java.lang.Integer.parseInt(property2) == -1) ? false : true;
    }
}
