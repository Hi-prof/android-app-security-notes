package dc.squareup.okhttp3.internal.http;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class RequestLine {
    private RequestLine() {
    }

    public static java.lang.String get(dc.squareup.okhttp3.Request request, java.net.Proxy.Type type) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(request.method());
        sb.append(' ');
        if (includeAuthorityInRequestLine(request, type)) {
            sb.append(request.url());
        } else {
            sb.append(requestPath(request.url()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean includeAuthorityInRequestLine(dc.squareup.okhttp3.Request request, java.net.Proxy.Type type) {
        return !request.isHttps() && type == java.net.Proxy.Type.HTTP;
    }

    public static java.lang.String requestPath(dc.squareup.okhttp3.HttpUrl httpUrl) {
        java.lang.String strEncodedPath = httpUrl.encodedPath();
        java.lang.String strEncodedQuery = httpUrl.encodedQuery();
        if (strEncodedQuery == null) {
            return strEncodedPath;
        }
        return strEncodedPath + com.taobao.weex.el.parse.Operators.CONDITION_IF + strEncodedQuery;
    }
}
