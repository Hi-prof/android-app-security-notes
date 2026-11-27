package io.dcloud.feature.barcode2.decoding;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class BitmapLuminanceSource extends com.dcloud.zxing2.LuminanceSource {
    private byte[] bitmapPixels;

    protected BitmapLuminanceSource(android.graphics.Bitmap bitmap) {
        super(bitmap.getWidth(), bitmap.getHeight());
        int width = bitmap.getWidth() * bitmap.getHeight();
        int[] iArr = new int[width];
        this.bitmapPixels = new byte[bitmap.getWidth() * bitmap.getHeight()];
        bitmap.getPixels(iArr, 0, getWidth(), 0, 0, getWidth(), getHeight());
        for (int i = 0; i < width; i++) {
            this.bitmapPixels[i] = (byte) iArr[i];
        }
    }

    @Override // com.dcloud.zxing2.LuminanceSource
    public byte[] getMatrix() {
        return this.bitmapPixels;
    }

    @Override // com.dcloud.zxing2.LuminanceSource
    public byte[] getRow(int i, byte[] bArr) {
        java.lang.System.arraycopy(this.bitmapPixels, i * getWidth(), bArr, 0, getWidth());
        return bArr;
    }
}
