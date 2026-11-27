package com.dcloud.zxing2;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class BinaryBitmap {
    private final com.dcloud.zxing2.Binarizer binarizer;
    private com.dcloud.zxing2.common.BitMatrix matrix;

    public BinaryBitmap(com.dcloud.zxing2.Binarizer binarizer) {
        if (binarizer == null) {
            throw new java.lang.IllegalArgumentException("Binarizer must be non-null.");
        }
        this.binarizer = binarizer;
    }

    public com.dcloud.zxing2.BinaryBitmap crop(int i, int i2, int i3, int i4) {
        return new com.dcloud.zxing2.BinaryBitmap(this.binarizer.createBinarizer(this.binarizer.getLuminanceSource().crop(i, i2, i3, i4)));
    }

    public com.dcloud.zxing2.common.BitMatrix getBlackMatrix() throws com.dcloud.zxing2.NotFoundException {
        if (this.matrix == null) {
            this.matrix = this.binarizer.getBlackMatrix();
        }
        return this.matrix;
    }

    public com.dcloud.zxing2.common.BitArray getBlackRow(int i, com.dcloud.zxing2.common.BitArray bitArray) throws com.dcloud.zxing2.NotFoundException {
        return this.binarizer.getBlackRow(i, bitArray);
    }

    public int getHeight() {
        return this.binarizer.getHeight();
    }

    public int getWidth() {
        return this.binarizer.getWidth();
    }

    public boolean isCropSupported() {
        return this.binarizer.getLuminanceSource().isCropSupported();
    }

    public boolean isRotateSupported() {
        return this.binarizer.getLuminanceSource().isRotateSupported();
    }

    public com.dcloud.zxing2.BinaryBitmap rotateCounterClockwise() {
        return new com.dcloud.zxing2.BinaryBitmap(this.binarizer.createBinarizer(this.binarizer.getLuminanceSource().rotateCounterClockwise()));
    }

    public com.dcloud.zxing2.BinaryBitmap rotateCounterClockwise45() {
        return new com.dcloud.zxing2.BinaryBitmap(this.binarizer.createBinarizer(this.binarizer.getLuminanceSource().rotateCounterClockwise45()));
    }

    public java.lang.String toString() {
        try {
            return getBlackMatrix().toString();
        } catch (com.dcloud.zxing2.NotFoundException unused) {
            return "";
        }
    }
}
