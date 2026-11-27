package com.bumptech.glide.util.pool;

/* JADX INFO: loaded from: classes.dex */
public final class GlideTrace {
    private static final java.util.concurrent.atomic.AtomicInteger COOKIE_CREATOR = null;
    private static final int MAX_LENGTH = 127;
    private static final boolean TRACING_ENABLED = false;

    public static void beginSection(java.lang.String str) {
    }

    public static int beginSectionAsync(java.lang.String str) {
        return -1;
    }

    public static void beginSectionFormat(java.lang.String str, java.lang.Object obj) {
    }

    public static void beginSectionFormat(java.lang.String str, java.lang.Object obj, java.lang.Object obj2) {
    }

    public static void beginSectionFormat(java.lang.String str, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
    }

    public static void endSection() {
    }

    public static void endSectionAsync(java.lang.String str, int i) {
    }

    private GlideTrace() {
    }

    private static java.lang.String truncateTag(java.lang.String str) {
        return str.length() > 127 ? str.substring(0, 126) : str;
    }
}
