package io.dcloud.ep;

/* JADX INFO: compiled from: r8-map-id-b089b3ef14a7698b6fddd362455d593b6c2b269fff47748e8001e74ff4f7bd31 */
/* JADX INFO: loaded from: classes2.dex */
class K {

    /* JADX INFO: compiled from: r8-map-id-b089b3ef14a7698b6fddd362455d593b6c2b269fff47748e8001e74ff4f7bd31 */
    public interface a {
        java.lang.String a(java.lang.String str);
    }

    static {
        java.lang.System.loadLibrary("so");
    }

    K() {
    }

    public static java.lang.String j(io.dcloud.ep.K.a aVar) {
        return aVar.a(key());
    }

    public static native java.lang.String key();
}
