package io.dcloud.common.util.net.http;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class CookieManager {
    public static void initCookieConfig(android.content.Context context) {
        android.webkit.CookieSyncManager.createInstance(context);
        android.webkit.CookieManager.getInstance().setAcceptCookie(true);
        java.net.CookieHandler.setDefault(new io.dcloud.common.util.net.http.WebkitCookieManagerProxy(null, java.net.CookiePolicy.ACCEPT_ALL));
    }
}
