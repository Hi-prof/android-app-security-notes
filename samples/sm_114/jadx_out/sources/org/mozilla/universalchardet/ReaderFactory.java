package org.mozilla.universalchardet;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public final class ReaderFactory {
    private ReaderFactory() {
        throw new java.lang.AssertionError("No instances allowed");
    }

    public static java.io.Reader createReaderFromFile(java.io.File file, java.nio.charset.Charset charset) throws java.io.IOException {
        if (charset == null) {
            throw new java.lang.NullPointerException("defaultCharset must be not null");
        }
        java.lang.String strDetectCharset = org.mozilla.universalchardet.UniversalDetector.detectCharset(file);
        if (strDetectCharset != null) {
            charset = java.nio.charset.Charset.forName(strDetectCharset);
        }
        return !charset.toString().contains("UTF") ? new java.io.InputStreamReader(new java.io.BufferedInputStream(new java.io.FileInputStream(file)), charset) : new java.io.InputStreamReader(new org.mozilla.universalchardet.UnicodeBOMInputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(file))), charset);
    }

    public static java.io.Reader createReaderFromFile(java.io.File file) throws java.io.IOException {
        return createReaderFromFile(file, java.nio.charset.Charset.defaultCharset());
    }
}
