package com.dcloud.zxing2;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public abstract class LuminanceSource {
    private final int height;
    private final int width;

    protected LuminanceSource(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public com.dcloud.zxing2.LuminanceSource crop(int i, int i2, int i3, int i4) {
        throw new java.lang.UnsupportedOperationException("This luminance source does not support cropping.");
    }

    public final int getHeight() {
        return this.height;
    }

    public abstract byte[] getMatrix();

    public abstract byte[] getRow(int i, byte[] bArr);

    public final int getWidth() {
        return this.width;
    }

    public com.dcloud.zxing2.LuminanceSource invert() {
        return new com.dcloud.zxing2.InvertedLuminanceSource(this);
    }

    public boolean isCropSupported() {
        return false;
    }

    public boolean isRotateSupported() {
        return false;
    }

    public com.dcloud.zxing2.LuminanceSource rotateCounterClockwise() {
        throw new java.lang.UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public com.dcloud.zxing2.LuminanceSource rotateCounterClockwise45() {
        throw new java.lang.UnsupportedOperationException("This luminance source does not support rotation by 45 degrees.");
    }

    public final java.lang.String toString() {
        char c;
        int i = this.width;
        byte[] row = new byte[i];
        java.lang.StringBuilder sb = new java.lang.StringBuilder(this.height * (i + 1));
        for (int i2 = 0; i2 < this.height; i2++) {
            row = getRow(i2, row);
            for (int i3 = 0; i3 < this.width; i3++) {
                int i4 = row[i3] & 255;
                if (i4 < 64) {
                    c = '#';
                } else if (i4 < 128) {
                    c = '+';
                } else {
                    c = i4 < 192 ? com.taobao.weex.el.parse.Operators.DOT : ' ';
                }
                sb.append(c);
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
