package dc.squareup.okhttp3;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface CookieJar {
    public static final dc.squareup.okhttp3.CookieJar NO_COOKIES = new dc.squareup.okhttp3.CookieJar() { // from class: dc.squareup.okhttp3.CookieJar.1
        @Override // dc.squareup.okhttp3.CookieJar
        public java.util.List<dc.squareup.okhttp3.Cookie> loadForRequest(dc.squareup.okhttp3.HttpUrl httpUrl) {
            return java.util.Collections.EMPTY_LIST;
        }

        @Override // dc.squareup.okhttp3.CookieJar
        public void saveFromResponse(dc.squareup.okhttp3.HttpUrl httpUrl, java.util.List<dc.squareup.okhttp3.Cookie> list) {
        }
    };

    java.util.List<dc.squareup.okhttp3.Cookie> loadForRequest(dc.squareup.okhttp3.HttpUrl httpUrl);

    void saveFromResponse(dc.squareup.okhttp3.HttpUrl httpUrl, java.util.List<dc.squareup.okhttp3.Cookie> list);
}
