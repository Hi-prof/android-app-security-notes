package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class u2 {
    private static java.lang.String a = "";
    private static boolean b = false;

    public static java.lang.String a(android.content.Context context) {
        java.lang.String strA;
        if (context == null) {
            return a;
        }
        if (!io.dcloud.sdk.poly.base.utils.PrivacyManager.getInstance().d()) {
            return a;
        }
        if (!io.dcloud.p.c0.a().a(context)) {
            return a;
        }
        if (b) {
            return a;
        }
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
        android.net.NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
        android.net.NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
        if (networkInfo.isConnected()) {
            strA = a();
        } else {
            strA = networkInfo2.isConnected() ? a(((android.net.wifi.WifiManager) context.getSystemService("wifi")).getConnectionInfo().getIpAddress()) : null;
        }
        a = strA;
        b = true;
        return strA;
    }

    public static java.lang.String a() {
        try {
            java.util.ArrayList list = java.util.Collections.list(java.net.NetworkInterface.getNetworkInterfaces());
            int size = list.size();
            int i = 0;
            while (i < size) {
                java.lang.Object obj = list.get(i);
                i++;
                java.util.ArrayList list2 = java.util.Collections.list(((java.net.NetworkInterface) obj).getInetAddresses());
                int size2 = list2.size();
                int i2 = 0;
                while (i2 < size2) {
                    java.lang.Object obj2 = list2.get(i2);
                    i2++;
                    java.net.InetAddress inetAddress = (java.net.InetAddress) obj2;
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
            return null;
        } catch (java.net.SocketException unused) {
            return null;
        }
    }

    public static java.lang.String a(int i) {
        return (i & 255) + com.taobao.weex.el.parse.Operators.DOT_STR + ((i >> 8) & 255) + com.taobao.weex.el.parse.Operators.DOT_STR + ((i >> 16) & 255) + com.taobao.weex.el.parse.Operators.DOT_STR + ((i >> 24) & 255);
    }
}
