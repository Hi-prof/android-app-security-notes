package com.dcloud.zxing2.pdf417.encoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class BarcodeMatrix {
    private int currentRow;
    private final int height;
    private final com.dcloud.zxing2.pdf417.encoder.BarcodeRow[] matrix;
    private final int width;

    BarcodeMatrix(int i, int i2) {
        this.matrix = new com.dcloud.zxing2.pdf417.encoder.BarcodeRow[i];
        for (int i3 = 0; i3 < i; i3++) {
            this.matrix[i3] = new com.dcloud.zxing2.pdf417.encoder.BarcodeRow(((i2 + 4) * 17) + 1);
        }
        this.width = i2 * 17;
        this.height = i;
        this.currentRow = -1;
    }

    com.dcloud.zxing2.pdf417.encoder.BarcodeRow getCurrentRow() {
        return this.matrix[this.currentRow];
    }

    public byte[][] getMatrix() {
        return getScaledMatrix(1, 1);
    }

    public byte[][] getScaledMatrix(int i, int i2) {
        int i3 = this.height * i2;
        byte[][] bArr = (byte[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) java.lang.Byte.TYPE, i3, this.width * i);
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[(i3 - i4) - 1] = this.matrix[i4 / i2].getScaledRow(i);
        }
        return bArr;
    }

    void set(int i, int i2, byte b) {
        this.matrix[i2].set(i, b);
    }

    void startRow() {
        this.currentRow++;
    }
}
