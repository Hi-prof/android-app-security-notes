package com.dcloud.zxing2.oned;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public abstract class OneDimensionalCodeWriter implements com.dcloud.zxing2.Writer {
    protected static int appendPattern(boolean[] zArr, int i, int[] iArr, boolean z) {
        int i2 = 0;
        for (int i3 : iArr) {
            int i4 = 0;
            while (i4 < i3) {
                zArr[i] = z;
                i4++;
                i++;
            }
            i2 += i3;
            z = !z;
        }
        return i2;
    }

    private static com.dcloud.zxing2.common.BitMatrix renderResult(boolean[] zArr, int i, int i2, int i3) {
        int length = zArr.length;
        int i4 = i3 + length;
        int iMax = java.lang.Math.max(i, i4);
        int iMax2 = java.lang.Math.max(1, i2);
        int i5 = iMax / i4;
        int i6 = (iMax - (length * i5)) / 2;
        com.dcloud.zxing2.common.BitMatrix bitMatrix = new com.dcloud.zxing2.common.BitMatrix(iMax, iMax2);
        int i7 = 0;
        while (i7 < length) {
            if (zArr[i7]) {
                bitMatrix.setRegion(i6, 0, i5, iMax2);
            }
            i7++;
            i6 += i5;
        }
        return bitMatrix;
    }

    @Override // com.dcloud.zxing2.Writer
    public final com.dcloud.zxing2.common.BitMatrix encode(java.lang.String str, com.dcloud.zxing2.BarcodeFormat barcodeFormat, int i, int i2) throws com.dcloud.zxing2.WriterException {
        return encode(str, barcodeFormat, i, i2, null);
    }

    public abstract boolean[] encode(java.lang.String str);

    public int getDefaultMargin() {
        return 10;
    }

    @Override // com.dcloud.zxing2.Writer
    public com.dcloud.zxing2.common.BitMatrix encode(java.lang.String str, com.dcloud.zxing2.BarcodeFormat barcodeFormat, int i, int i2, java.util.Map<com.dcloud.zxing2.EncodeHintType, ?> map) throws com.dcloud.zxing2.WriterException {
        if (str.isEmpty()) {
            throw new java.lang.IllegalArgumentException("Found empty contents");
        }
        if (i < 0 || i2 < 0) {
            throw new java.lang.IllegalArgumentException("Negative size is not allowed. Input: " + i + 'x' + i2);
        }
        int defaultMargin = getDefaultMargin();
        if (map != null) {
            com.dcloud.zxing2.EncodeHintType encodeHintType = com.dcloud.zxing2.EncodeHintType.MARGIN;
            if (map.containsKey(encodeHintType)) {
                defaultMargin = java.lang.Integer.parseInt(map.get(encodeHintType).toString());
            }
        }
        return renderResult(encode(str), i, i2, defaultMargin);
    }
}
