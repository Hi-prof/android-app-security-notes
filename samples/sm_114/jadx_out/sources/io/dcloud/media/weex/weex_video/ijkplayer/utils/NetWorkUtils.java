package io.dcloud.media.weex.weex_video.ijkplayer.utils;

/* JADX INFO: loaded from: classes2.dex */
public class NetWorkUtils {
    public static final java.lang.String NETWORK_TYPE_2G = "2g";
    public static final java.lang.String NETWORK_TYPE_3G = "eg";
    public static final java.lang.String NETWORK_TYPE_DISCONNECT = "disconnect";
    public static final java.lang.String NETWORK_TYPE_UNKNOWN = "unknown";
    public static final java.lang.String NETWORK_TYPE_WAP = "wap";
    public static final java.lang.String NETWORK_TYPE_WIFI = "wifi";

    public static int getNetworkType(android.content.Context context) {
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
        android.net.NetworkInfo activeNetworkInfo = connectivityManager == null ? null : connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    public static java.lang.String getNetworkTypeName(android.content.Context context) {
        android.net.NetworkInfo activeNetworkInfo;
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            return "disconnect";
        }
        java.lang.String typeName = activeNetworkInfo.getTypeName();
        if ("WIFI".equalsIgnoreCase(typeName)) {
            return "wifi";
        }
        if ("MOBILE".equalsIgnoreCase(typeName)) {
            if (android.text.TextUtils.isEmpty(android.net.Proxy.getDefaultHost())) {
                return isFastMobileNetwork(context) ? "eg" : "2g";
            }
            return "wap";
        }
        return "unknown";
    }

    private static boolean isFastMobileNetwork(android.content.Context context) {
        android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return false;
        }
        switch (telephonyManager.getNetworkType()) {
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
            case 14:
            case 15:
                return true;
            case 4:
            case 7:
            case 11:
            default:
                return false;
        }
    }

    public static boolean isNetworkAvailable(android.content.Context context) {
        try {
            android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isMobileConnected(android.content.Context context) {
        android.net.NetworkInfo networkInfo;
        if (context == null || (networkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(0)) == null || !networkInfo.isAvailable()) {
            return false;
        }
        return networkInfo.isConnected();
    }

    public static boolean isWifiConnected(android.content.Context context) {
        android.net.NetworkInfo networkInfo;
        if (context == null || (networkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1)) == null || !networkInfo.isAvailable()) {
            return false;
        }
        return networkInfo.isConnected();
    }
}
