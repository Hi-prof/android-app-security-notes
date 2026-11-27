package com.dcloud.zxing2.oned;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class Code93Writer extends com.dcloud.zxing2.oned.OneDimensionalCodeWriter {
    protected static int appendPattern(boolean[] zArr, int i, int[] iArr, boolean z) {
        int length = iArr.length;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i + 1;
            zArr[i] = iArr[i2] != 0;
            i2++;
            i = i3;
        }
        return 9;
    }

    private static int computeChecksumIndex(java.lang.String str, int i) {
        int iIndexOf = 0;
        int i2 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i2;
            i2++;
            if (i2 > i) {
                i2 = 1;
            }
        }
        return iIndexOf % 47;
    }

    private static void toIntArray(int i, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            int i3 = 1;
            if (((1 << (8 - i2)) & i) == 0) {
                i3 = 0;
            }
            iArr[i2] = i3;
        }
    }

    @Override // com.dcloud.zxing2.oned.OneDimensionalCodeWriter, com.dcloud.zxing2.Writer
    public com.dcloud.zxing2.common.BitMatrix encode(java.lang.String str, com.dcloud.zxing2.BarcodeFormat barcodeFormat, int i, int i2, java.util.Map<com.dcloud.zxing2.EncodeHintType, ?> map) throws com.dcloud.zxing2.WriterException {
        if (barcodeFormat == com.dcloud.zxing2.BarcodeFormat.CODE_93) {
            return super.encode(str, barcodeFormat, i, i2, map);
        }
        throw new java.lang.IllegalArgumentException("Can only encode CODE_93, but got " + barcodeFormat);
    }

    @Override // com.dcloud.zxing2.oned.OneDimensionalCodeWriter
    public boolean[] encode(java.lang.String str) {
        int length = str.length();
        if (length <= 80) {
            int[] iArr = new int[9];
            boolean[] zArr = new boolean[((str.length() + 4) * 9) + 1];
            toIntArray(com.dcloud.zxing2.oned.Code93Reader.CHARACTER_ENCODINGS[47], iArr);
            int iAppendPattern = appendPattern(zArr, 0, iArr, true);
            for (int i = 0; i < length; i++) {
                toIntArray(com.dcloud.zxing2.oned.Code93Reader.CHARACTER_ENCODINGS["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(i))], iArr);
                iAppendPattern += appendPattern(zArr, iAppendPattern, iArr, true);
            }
            int iComputeChecksumIndex = computeChecksumIndex(str, 20);
            int[] iArr2 = com.dcloud.zxing2.oned.Code93Reader.CHARACTER_ENCODINGS;
            toIntArray(iArr2[iComputeChecksumIndex], iArr);
            int iAppendPattern2 = iAppendPattern + appendPattern(zArr, iAppendPattern, iArr, true);
            toIntArray(iArr2[computeChecksumIndex(str + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(iComputeChecksumIndex), 15)], iArr);
            int iAppendPattern3 = iAppendPattern2 + appendPattern(zArr, iAppendPattern2, iArr, true);
            toIntArray(iArr2[47], iArr);
            zArr[iAppendPattern3 + appendPattern(zArr, iAppendPattern3, iArr, true)] = true;
            return zArr;
        }
        throw new java.lang.IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
    }
}
