package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
class q4 implements java.io.Closeable {
    private final java.io.InputStream a;
    private final java.nio.charset.Charset b;
    private byte[] c;
    private int d;
    private int e;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a extends java.io.ByteArrayOutputStream {
        a(int i) {
            super(i);
        }

        @Override // java.io.ByteArrayOutputStream
        public java.lang.String toString() {
            int i = ((java.io.ByteArrayOutputStream) this).count;
            if (i > 0) {
                int i2 = i - 1;
                if (((java.io.ByteArrayOutputStream) this).buf[i2] == 13) {
                    i = i2;
                }
            }
            try {
                return new java.lang.String(((java.io.ByteArrayOutputStream) this).buf, 0, i, io.dcloud.p.q4.this.b.name());
            } catch (java.io.UnsupportedEncodingException e) {
                throw new java.lang.AssertionError(e);
            }
        }
    }

    public q4(java.io.InputStream inputStream, java.nio.charset.Charset charset) {
        this(inputStream, 8192, charset);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x002b  */
    public java.lang.String b() {
        int i;
        byte[] bArr;
        int i2;
        synchronized (this.a) {
            if (this.c == null) {
                throw new java.io.IOException("LineReader is closed");
            }
            if (this.d >= this.e) {
                a();
            }
            for (int i3 = this.d; i3 != this.e; i3++) {
                byte[] bArr2 = this.c;
                if (bArr2[i3] == 10) {
                    int i4 = this.d;
                    if (i3 != i4) {
                        i2 = i3 - 1;
                        if (bArr2[i2] != 13) {
                            i2 = i3;
                        }
                    } else {
                        i2 = i3;
                    }
                    java.lang.String str = new java.lang.String(bArr2, i4, i2 - i4, this.b.name());
                    this.d = i3 + 1;
                    return str;
                }
            }
            io.dcloud.p.q4.a aVar = new io.dcloud.p.q4.a((this.e - this.d) + 80);
            loop1: while (true) {
                byte[] bArr3 = this.c;
                int i5 = this.d;
                aVar.write(bArr3, i5, this.e - i5);
                this.e = -1;
                a();
                i = this.d;
                while (i != this.e) {
                    bArr = this.c;
                    if (bArr[i] == 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            int i6 = this.d;
            if (i != i6) {
                aVar.write(bArr, i6, i - i6);
            }
            this.d = i + 1;
            return aVar.toString();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.a) {
            if (this.c != null) {
                this.c = null;
                this.a.close();
            }
        }
    }

    public q4(java.io.InputStream inputStream, int i, java.nio.charset.Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(io.dcloud.p.a5.a)) {
            throw new java.lang.IllegalArgumentException("Unsupported encoding");
        }
        this.a = inputStream;
        this.b = charset;
        this.c = new byte[i];
    }

    private void a() throws java.io.IOException {
        java.io.InputStream inputStream = this.a;
        byte[] bArr = this.c;
        int i = inputStream.read(bArr, 0, bArr.length);
        if (i == -1) {
            throw new java.io.EOFException();
        }
        this.d = 0;
        this.e = i;
    }
}
