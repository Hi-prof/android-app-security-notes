package com.dcloud.zxing2.oned;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class Code39Writer extends com.dcloud.zxing2.oned.OneDimensionalCodeWriter {
    private static void toIntArray(int i, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            int i3 = 1;
            if (((1 << (8 - i2)) & i) != 0) {
                i3 = 2;
            }
            iArr[i2] = i3;
        }
    }

    @Override // com.dcloud.zxing2.oned.OneDimensionalCodeWriter, com.dcloud.zxing2.Writer
    public com.dcloud.zxing2.common.BitMatrix encode(java.lang.String str, com.dcloud.zxing2.BarcodeFormat barcodeFormat, int i, int i2, java.util.Map<com.dcloud.zxing2.EncodeHintType, ?> map) throws com.dcloud.zxing2.WriterException {
        if (barcodeFormat == com.dcloud.zxing2.BarcodeFormat.CODE_39) {
            return super.encode(str, barcodeFormat, i, i2, map);
        }
        throw new java.lang.IllegalArgumentException("Can only encode CODE_39, but got " + barcodeFormat);
    }

    @Override // com.dcloud.zxing2.oned.OneDimensionalCodeWriter
    public boolean[] encode(java.lang.String str) {
        int length = str.length();
        if (length <= 80) {
            int[] iArr = new int[9];
            int i = length + 25;
            for (int i2 = 0; i2 < length; i2++) {
                int iIndexOf = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(str.charAt(i2));
                if (iIndexOf >= 0) {
                    toIntArray(com.dcloud.zxing2.oned.Code39Reader.CHARACTER_ENCODINGS[iIndexOf], iArr);
                    for (int i3 = 0; i3 < 9; i3++) {
                        i += iArr[i3];
                    }
                } else {
                    throw new java.lang.IllegalArgumentException("Bad contents: " + str);
                }
            }
            boolean[] zArr = new boolean[i];
            toIntArray(com.dcloud.zxing2.oned.Code39Reader.ASTERISK_ENCODING, iArr);
            int iAppendPattern = com.dcloud.zxing2.oned.OneDimensionalCodeWriter.appendPattern(zArr, 0, iArr, true);
            int[] iArr2 = {1};
            int iAppendPattern2 = iAppendPattern + com.dcloud.zxing2.oned.OneDimensionalCodeWriter.appendPattern(zArr, iAppendPattern, iArr2, false);
            for (int i4 = 0; i4 < length; i4++) {
                toIntArray(com.dcloud.zxing2.oned.Code39Reader.CHARACTER_ENCODINGS["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(str.charAt(i4))], iArr);
                int iAppendPattern3 = iAppendPattern2 + com.dcloud.zxing2.oned.OneDimensionalCodeWriter.appendPattern(zArr, iAppendPattern2, iArr, true);
                iAppendPattern2 = iAppendPattern3 + com.dcloud.zxing2.oned.OneDimensionalCodeWriter.appendPattern(zArr, iAppendPattern3, iArr2, false);
            }
            toIntArray(com.dcloud.zxing2.oned.Code39Reader.ASTERISK_ENCODING, iArr);
            com.dcloud.zxing2.oned.OneDimensionalCodeWriter.appendPattern(zArr, iAppendPattern2, iArr, true);
            return zArr;
        }
        throw new java.lang.IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
    }
}
