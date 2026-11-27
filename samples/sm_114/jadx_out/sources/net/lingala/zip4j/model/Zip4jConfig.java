package net.lingala.zip4j.model;

/* JADX INFO: loaded from: classes2.dex */
public class Zip4jConfig {
    private final int bufferSize;
    private final java.nio.charset.Charset charset;
    private final boolean useUtf8CharsetForPasswords;

    public Zip4jConfig(java.nio.charset.Charset charset, int i, boolean z) {
        this.charset = charset;
        this.bufferSize = i;
        this.useUtf8CharsetForPasswords = z;
    }

    public java.nio.charset.Charset getCharset() {
        return this.charset;
    }

    public int getBufferSize() {
        return this.bufferSize;
    }

    public boolean isUseUtf8CharsetForPasswords() {
        return this.useUtf8CharsetForPasswords;
    }
}
