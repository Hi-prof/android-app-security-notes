package com.facebook.soloader;

/* JADX INFO: loaded from: classes.dex */
class Api18TraceUtils {
    private static final int MAX_SECTION_NAME_LENGTH = 127;

    Api18TraceUtils() {
    }

    public static void beginTraceSection(java.lang.String str, @javax.annotation.Nullable java.lang.String str2, java.lang.String str3) {
        java.lang.String str4 = str + str2 + str3;
        if (str4.length() > 127 && str2 != null) {
            str4 = str + str2.substring(0, (127 - str.length()) - str3.length()) + str3;
        }
        android.os.Trace.beginSection(str4);
    }

    public static void endSection() {
        android.os.Trace.endSection();
    }
}
