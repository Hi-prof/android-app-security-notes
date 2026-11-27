package dc.squareup;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class HttpConstants {
    private static java.lang.String defaultUAConstants = "";

    public static java.lang.String getDefaultUA() {
        return defaultUAConstants;
    }

    public static void setUA(java.lang.String str) {
        defaultUAConstants = str;
    }
}
