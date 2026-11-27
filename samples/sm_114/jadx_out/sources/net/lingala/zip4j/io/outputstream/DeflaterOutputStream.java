package net.lingala.zip4j.io.outputstream;

/* JADX INFO: loaded from: classes2.dex */
class DeflaterOutputStream extends net.lingala.zip4j.io.outputstream.CompressedOutputStream {
    private byte[] buff;
    protected java.util.zip.Deflater deflater;

    public DeflaterOutputStream(net.lingala.zip4j.io.outputstream.CipherOutputStream<?> cipherOutputStream, net.lingala.zip4j.model.enums.CompressionLevel compressionLevel, int i) {
        super(cipherOutputStream);
        this.deflater = new java.util.zip.Deflater(compressionLevel.getLevel(), true);
        this.buff = new byte[i];
    }

    @Override // net.lingala.zip4j.io.outputstream.CompressedOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws java.io.IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // net.lingala.zip4j.io.outputstream.CompressedOutputStream, java.io.OutputStream
    public void write(int i) throws java.io.IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }

    @Override // net.lingala.zip4j.io.outputstream.CompressedOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
        this.deflater.setInput(bArr, i, i2);
        while (!this.deflater.needsInput()) {
            deflate();
        }
    }

    private void deflate() throws java.io.IOException {
        java.util.zip.Deflater deflater = this.deflater;
        byte[] bArr = this.buff;
        int iDeflate = deflater.deflate(bArr, 0, bArr.length);
        if (iDeflate > 0) {
            super.write(this.buff, 0, iDeflate);
        }
    }

    @Override // net.lingala.zip4j.io.outputstream.CompressedOutputStream
    public void closeEntry() throws java.io.IOException {
        if (!this.deflater.finished()) {
            this.deflater.finish();
            while (!this.deflater.finished()) {
                deflate();
            }
        }
        this.deflater.end();
        super.closeEntry();
    }
}
