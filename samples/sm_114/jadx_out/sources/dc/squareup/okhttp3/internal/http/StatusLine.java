package dc.squareup.okhttp3.internal.http;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class StatusLine {
    public static final int HTTP_CONTINUE = 100;
    public static final int HTTP_PERM_REDIRECT = 308;
    public static final int HTTP_TEMP_REDIRECT = 307;
    public final int code;
    public final java.lang.String message;
    public final dc.squareup.okhttp3.Protocol protocol;

    public StatusLine(dc.squareup.okhttp3.Protocol protocol, int i, java.lang.String str) {
        this.protocol = protocol;
        this.code = i;
        this.message = str;
    }

    public static dc.squareup.okhttp3.internal.http.StatusLine get(dc.squareup.okhttp3.Response response) {
        return new dc.squareup.okhttp3.internal.http.StatusLine(response.protocol(), response.code(), response.message());
    }

    public static dc.squareup.okhttp3.internal.http.StatusLine parse(java.lang.String str) throws java.io.IOException {
        dc.squareup.okhttp3.Protocol protocol;
        int i;
        java.lang.String strSubstring;
        if (str.startsWith("HTTP/1.")) {
            i = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new java.net.ProtocolException("Unexpected status line: " + str);
            }
            int iCharAt = str.charAt(7) - '0';
            if (iCharAt == 0) {
                protocol = dc.squareup.okhttp3.Protocol.HTTP_1_0;
            } else {
                if (iCharAt != 1) {
                    throw new java.net.ProtocolException("Unexpected status line: " + str);
                }
                protocol = dc.squareup.okhttp3.Protocol.HTTP_1_1;
            }
        } else {
            if (!str.startsWith("ICY ")) {
                throw new java.net.ProtocolException("Unexpected status line: " + str);
            }
            protocol = dc.squareup.okhttp3.Protocol.HTTP_1_0;
            i = 4;
        }
        int i2 = i + 3;
        if (str.length() < i2) {
            throw new java.net.ProtocolException("Unexpected status line: " + str);
        }
        try {
            int i3 = java.lang.Integer.parseInt(str.substring(i, i2));
            if (str.length() <= i2) {
                strSubstring = "";
            } else {
                if (str.charAt(i2) != ' ') {
                    throw new java.net.ProtocolException("Unexpected status line: " + str);
                }
                strSubstring = str.substring(i + 4);
            }
            return new dc.squareup.okhttp3.internal.http.StatusLine(protocol, i3, strSubstring);
        } catch (java.lang.NumberFormatException unused) {
            throw new java.net.ProtocolException("Unexpected status line: " + str);
        }
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.protocol == dc.squareup.okhttp3.Protocol.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.code);
        if (this.message != null) {
            sb.append(' ');
            sb.append(this.message);
        }
        return sb.toString();
    }
}
