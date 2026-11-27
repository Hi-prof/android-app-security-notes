package io.dcloud.common.util.net.http;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class WebkitCookieManagerProxy extends java.net.CookieManager {
    private android.webkit.CookieManager webkitCookieManager;

    public WebkitCookieManagerProxy() {
        this(null, null);
    }

    @Override // java.net.CookieManager, java.net.CookieHandler
    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> get(java.net.URI uri, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map) throws java.io.IOException {
        if (uri == null || map == null) {
            throw new java.lang.IllegalArgumentException("Argument is null");
        }
        java.lang.String string = uri.toString();
        java.util.HashMap map2 = new java.util.HashMap();
        java.lang.String cookie = this.webkitCookieManager.getCookie(string);
        java.lang.String cookies = dc.squareup.cookie.CookieCenter.getCookies(string);
        if (!android.text.TextUtils.isEmpty(cookies)) {
            cookie = cookie + "; " + cookies;
        }
        if (cookie != null) {
            map2.put(io.dcloud.common.DHInterface.IWebview.COOKIE, java.util.Arrays.asList(cookie));
        }
        return map2;
    }

    @Override // java.net.CookieManager
    public java.net.CookieStore getCookieStore() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.net.CookieManager, java.net.CookieHandler
    public void put(java.net.URI uri, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map) throws java.io.IOException {
        if (uri == null || map == null) {
            return;
        }
        java.lang.String string = uri.toString();
        for (java.lang.String str : map.keySet()) {
            if (str != null && (str.equalsIgnoreCase("Set-Cookie2") || str.equalsIgnoreCase(io.dcloud.common.DHInterface.IWebview.SET_COOKIE))) {
                for (java.lang.String str2 : map.get(str)) {
                    this.webkitCookieManager.setCookie(string, str2);
                    dc.squareup.cookie.CookieCenter.putCookies(string, str2);
                }
            }
        }
    }

    public boolean removeAllCookie() {
        this.webkitCookieManager.removeAllCookie();
        dc.squareup.cookie.CookieCenter.removeAllCookie();
        return true;
    }

    public boolean removeSessionCookie() {
        this.webkitCookieManager.removeSessionCookie();
        dc.squareup.cookie.CookieCenter.removeSessionCookie();
        return true;
    }

    public WebkitCookieManagerProxy(java.net.CookieStore cookieStore, java.net.CookiePolicy cookiePolicy) {
        super(null, cookiePolicy);
        this.webkitCookieManager = android.webkit.CookieManager.getInstance();
    }
}
