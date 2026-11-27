package dc.squareup.okhttp3.internal.http;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class HttpMethod {
    private HttpMethod() {
    }

    public static boolean invalidatesCache(java.lang.String str) {
        return str.equals("POST") || str.equals("PATCH") || str.equals("PUT") || str.equals("DELETE") || str.equals("MOVE");
    }

    public static boolean permitsRequestBody(java.lang.String str) {
        return (str.equals("GET") || str.equals("HEAD")) ? false : true;
    }

    public static boolean redirectsToGet(java.lang.String str) {
        return !str.equals("PROPFIND");
    }

    public static boolean redirectsWithBody(java.lang.String str) {
        return str.equals("PROPFIND");
    }

    public static boolean requiresRequestBody(java.lang.String str) {
        return str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
    }
}
