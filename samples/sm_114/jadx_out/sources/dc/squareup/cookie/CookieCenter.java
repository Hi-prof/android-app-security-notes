package dc.squareup.cookie;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class CookieCenter {
    static java.util.List<dc.squareup.cookie.CookieCenter.ICookieProvider> providers = new java.util.ArrayList();

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface ICookieProvider {
        boolean addCookie(java.lang.String str, java.lang.String str2);

        java.lang.String getCookieByUrl(java.lang.String str);

        boolean removeAllCookie();

        boolean removeSessionCookie();
    }

    public static java.lang.String getCookies(java.lang.String str) {
        for (dc.squareup.cookie.CookieCenter.ICookieProvider iCookieProvider : providers) {
            if (iCookieProvider != null) {
                java.lang.String cookieByUrl = iCookieProvider.getCookieByUrl(str);
                if (!android.text.TextUtils.isEmpty(cookieByUrl)) {
                    return cookieByUrl;
                }
            }
        }
        return null;
    }

    public static void putCookies(java.lang.String str, java.lang.String str2) {
        for (dc.squareup.cookie.CookieCenter.ICookieProvider iCookieProvider : providers) {
            if (iCookieProvider != null) {
                iCookieProvider.addCookie(str, str2);
            }
        }
    }

    public static synchronized void registerProvider(dc.squareup.cookie.CookieCenter.ICookieProvider iCookieProvider) {
        providers.add(iCookieProvider);
    }

    public static java.lang.String removeAllCookie() {
        for (dc.squareup.cookie.CookieCenter.ICookieProvider iCookieProvider : providers) {
            if (iCookieProvider != null) {
                iCookieProvider.removeAllCookie();
            }
        }
        return null;
    }

    public static java.lang.String removeSessionCookie() {
        for (dc.squareup.cookie.CookieCenter.ICookieProvider iCookieProvider : providers) {
            if (iCookieProvider != null) {
                iCookieProvider.removeSessionCookie();
            }
        }
        return null;
    }

    public static synchronized void unRegisterProvider(dc.squareup.cookie.CookieCenter.ICookieProvider iCookieProvider) {
        providers.remove(iCookieProvider);
    }
}
