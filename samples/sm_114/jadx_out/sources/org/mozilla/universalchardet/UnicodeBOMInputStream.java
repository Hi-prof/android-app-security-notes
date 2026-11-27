package org.mozilla.universalchardet;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class UnicodeBOMInputStream extends java.io.InputStream {
    private final org.mozilla.universalchardet.UnicodeBOMInputStream.BOM bom;
    private final java.io.PushbackInputStream in;
    private boolean skipped;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static final class BOM {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final byte[] bytes;
        private final java.lang.String description;
        public static final org.mozilla.universalchardet.UnicodeBOMInputStream.BOM NONE = new org.mozilla.universalchardet.UnicodeBOMInputStream.BOM(new byte[0], "NONE");
        public static final org.mozilla.universalchardet.UnicodeBOMInputStream.BOM UTF_8 = new org.mozilla.universalchardet.UnicodeBOMInputStream.BOM(new byte[]{-17, -69, -65}, "UTF-8");
        public static final org.mozilla.universalchardet.UnicodeBOMInputStream.BOM UTF_16_LE = new org.mozilla.universalchardet.UnicodeBOMInputStream.BOM(new byte[]{-1, -2}, "UTF-16 little-endian");
        public static final org.mozilla.universalchardet.UnicodeBOMInputStream.BOM UTF_16_BE = new org.mozilla.universalchardet.UnicodeBOMInputStream.BOM(new byte[]{-2, -1}, "UTF-16 big-endian");
        public static final org.mozilla.universalchardet.UnicodeBOMInputStream.BOM UTF_32_LE = new org.mozilla.universalchardet.UnicodeBOMInputStream.BOM(new byte[]{-1, -2, 0, 0}, "UTF-32 little-endian");
        public static final org.mozilla.universalchardet.UnicodeBOMInputStream.BOM UTF_32_BE = new org.mozilla.universalchardet.UnicodeBOMInputStream.BOM(new byte[]{0, 0, -2, -1}, "UTF-32 big-endian");

        private BOM(byte[] bArr, java.lang.String str) {
            this.bytes = bArr;
            this.description = str;
        }

        public final byte[] getBytes() {
            byte[] bArr = this.bytes;
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            java.lang.System.arraycopy(bArr, 0, bArr2, 0, length);
            return bArr2;
        }

        public final java.lang.String toString() {
            return this.description;
        }
    }

    public UnicodeBOMInputStream(java.io.InputStream inputStream) throws java.io.IOException {
        this(inputStream, true);
    }

    @Override // java.io.InputStream
    public int available() throws java.io.IOException {
        return this.in.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.in.close();
    }

    public final org.mozilla.universalchardet.UnicodeBOMInputStream.BOM getBOM() {
        return this.bom;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        this.in.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.in.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws java.io.IOException {
        this.skipped = true;
        return this.in.read();
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws java.io.IOException {
        this.in.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) throws java.io.IOException {
        this.skipped = true;
        return this.in.skip(j);
    }

    public final synchronized org.mozilla.universalchardet.UnicodeBOMInputStream skipBOM() throws java.io.IOException {
        if (this.skipped) {
            return this;
        }
        long length = this.bom.bytes.length;
        for (long jSkip = this.in.skip(length); jSkip < length; jSkip++) {
            this.in.read();
        }
        this.skipped = true;
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x004a  */
    /* JADX WARN: Code duplicated, block: B:34:0x0061  */
    /* JADX WARN: Code duplicated, block: B:36:0x0065  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:40:0x0070  */
    /* JADX WARN: Code duplicated, block: B:43:0x0079  */
    public UnicodeBOMInputStream(java.io.InputStream inputStream, boolean z) throws java.io.IOException {
        byte b;
        this.skipped = false;
        if (inputStream == null) {
            throw new java.lang.NullPointerException("invalid input stream: null is not allowed");
        }
        java.io.PushbackInputStream pushbackInputStream = new java.io.PushbackInputStream(inputStream, 4);
        this.in = pushbackInputStream;
        byte[] bArr = new byte[4];
        int i = pushbackInputStream.read(bArr);
        if (i == 2) {
            b = bArr[0];
            if (b != -1 && bArr[1] == -2) {
                this.bom = org.mozilla.universalchardet.UnicodeBOMInputStream.BOM.UTF_16_LE;
            } else if (b == -2 || bArr[1] != -1) {
                this.bom = org.mozilla.universalchardet.UnicodeBOMInputStream.BOM.NONE;
            } else {
                this.bom = org.mozilla.universalchardet.UnicodeBOMInputStream.BOM.UTF_16_BE;
            }
        } else if (i == 3) {
            if (bArr[0] != -17 && bArr[1] == -69 && bArr[2] == -65) {
                this.bom = org.mozilla.universalchardet.UnicodeBOMInputStream.BOM.UTF_8;
            } else {
                b = bArr[0];
                if (b != -1) {
                    if (b == -2) {
                        this.bom = org.mozilla.universalchardet.UnicodeBOMInputStream.BOM.NONE;
                    } else {
                        this.bom = org.mozilla.universalchardet.UnicodeBOMInputStream.BOM.NONE;
                    }
                } else if (b == -2) {
                    this.bom = org.mozilla.universalchardet.UnicodeBOMInputStream.BOM.NONE;
                } else {
                    this.bom = org.mozilla.universalchardet.UnicodeBOMInputStream.BOM.NONE;
                }
            }
        } else if (i == 4) {
            byte b2 = bArr[0];
            if (b2 == -1 && bArr[1] == -2 && bArr[2] == 0 && bArr[3] == 0) {
                this.bom = org.mozilla.universalchardet.UnicodeBOMInputStream.BOM.UTF_32_LE;
            } else if (b2 == 0 && bArr[1] == 0 && bArr[2] == -2 && bArr[3] == -1) {
                this.bom = org.mozilla.universalchardet.UnicodeBOMInputStream.BOM.UTF_32_BE;
            } else if (bArr[0] != -17) {
                b = bArr[0];
                if (b != -1) {
                    if (b == -2) {
                        this.bom = org.mozilla.universalchardet.UnicodeBOMInputStream.BOM.NONE;
                    } else {
                        this.bom = org.mozilla.universalchardet.UnicodeBOMInputStream.BOM.NONE;
                    }
                } else if (b == -2) {
                    this.bom = org.mozilla.universalchardet.UnicodeBOMInputStream.BOM.NONE;
                } else {
                    this.bom = org.mozilla.universalchardet.UnicodeBOMInputStream.BOM.NONE;
                }
            } else {
                b = bArr[0];
                if (b != -1) {
                    if (b == -2) {
                        this.bom = org.mozilla.universalchardet.UnicodeBOMInputStream.BOM.NONE;
                    } else {
                        this.bom = org.mozilla.universalchardet.UnicodeBOMInputStream.BOM.NONE;
                    }
                } else if (b == -2) {
                    this.bom = org.mozilla.universalchardet.UnicodeBOMInputStream.BOM.NONE;
                } else {
                    this.bom = org.mozilla.universalchardet.UnicodeBOMInputStream.BOM.NONE;
                }
            }
        } else {
            this.bom = org.mozilla.universalchardet.UnicodeBOMInputStream.BOM.NONE;
        }
        if (i > 0) {
            pushbackInputStream.unread(bArr, 0, i);
        }
        if (z) {
            skipBOM();
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws java.io.IOException {
        this.skipped = true;
        return this.in.read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        this.skipped = true;
        return this.in.read(bArr, i, i2);
    }
}
