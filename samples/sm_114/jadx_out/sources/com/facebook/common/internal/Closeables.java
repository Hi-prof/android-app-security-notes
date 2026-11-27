package com.facebook.common.internal;

/* JADX INFO: loaded from: classes.dex */
public final class Closeables {
    static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(com.facebook.common.internal.Closeables.class.getName());

    private Closeables() {
    }

    public static void close(@javax.annotation.Nullable java.io.Closeable closeable, boolean z) throws java.io.IOException {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (java.io.IOException e) {
            if (z) {
                logger.log(java.util.logging.Level.WARNING, "IOException thrown while closing Closeable.", (java.lang.Throwable) e);
                return;
            }
            throw e;
        }
    }

    public static void closeQuietly(@javax.annotation.Nullable java.io.InputStream inputStream) {
        try {
            close(inputStream, true);
        } catch (java.io.IOException e) {
            throw new java.lang.AssertionError(e);
        }
    }

    public static void closeQuietly(@javax.annotation.Nullable java.io.Reader reader) {
        try {
            close(reader, true);
        } catch (java.io.IOException e) {
            throw new java.lang.AssertionError(e);
        }
    }
}
