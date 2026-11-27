package com.dcloud.zxing2;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class InvertedLuminanceSource extends com.dcloud.zxing2.LuminanceSource {
    private final com.dcloud.zxing2.LuminanceSource delegate;

    public InvertedLuminanceSource(com.dcloud.zxing2.LuminanceSource luminanceSource) {
        super(luminanceSource.getWidth(), luminanceSource.getHeight());
        this.delegate = luminanceSource;
    }

    @Override // com.dcloud.zxing2.LuminanceSource
    public com.dcloud.zxing2.LuminanceSource crop(int i, int i2, int i3, int i4) {
        return new com.dcloud.zxing2.InvertedLuminanceSource(this.delegate.crop(i, i2, i3, i4));
    }

    @Override // com.dcloud.zxing2.LuminanceSource
    public byte[] getMatrix() {
        byte[] matrix = this.delegate.getMatrix();
        int width = getWidth() * getHeight();
        byte[] bArr = new byte[width];
        for (int i = 0; i < width; i++) {
            bArr[i] = (byte) (255 - (matrix[i] & 255));
        }
        return bArr;
    }

    @Override // com.dcloud.zxing2.LuminanceSource
    public byte[] getRow(int i, byte[] bArr) {
        byte[] row = this.delegate.getRow(i, bArr);
        int width = getWidth();
        for (int i2 = 0; i2 < width; i2++) {
            row[i2] = (byte) (255 - (row[i2] & 255));
        }
        return row;
    }

    @Override // com.dcloud.zxing2.LuminanceSource
    public com.dcloud.zxing2.LuminanceSource invert() {
        return this.delegate;
    }

    @Override // com.dcloud.zxing2.LuminanceSource
    public boolean isCropSupported() {
        return this.delegate.isCropSupported();
    }

    @Override // com.dcloud.zxing2.LuminanceSource
    public boolean isRotateSupported() {
        return this.delegate.isRotateSupported();
    }

    @Override // com.dcloud.zxing2.LuminanceSource
    public com.dcloud.zxing2.LuminanceSource rotateCounterClockwise() {
        return new com.dcloud.zxing2.InvertedLuminanceSource(this.delegate.rotateCounterClockwise());
    }

    @Override // com.dcloud.zxing2.LuminanceSource
    public com.dcloud.zxing2.LuminanceSource rotateCounterClockwise45() {
        return new com.dcloud.zxing2.InvertedLuminanceSource(this.delegate.rotateCounterClockwise45());
    }
}
