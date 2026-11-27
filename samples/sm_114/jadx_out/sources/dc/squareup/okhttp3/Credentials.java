package dc.squareup.okhttp3;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class Credentials {
    private Credentials() {
    }

    public static java.lang.String basic(java.lang.String str, java.lang.String str2) {
        return basic(str, str2, dc.squareup.okhttp3.internal.Util.ISO_8859_1);
    }

    public static java.lang.String basic(java.lang.String str, java.lang.String str2, java.nio.charset.Charset charset) {
        return "Basic " + dc.squareup.okio.ByteString.encodeString(str + ":" + str2, charset).base64();
    }
}
