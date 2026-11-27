package com.dcloud.zxing2.oned;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class ITFWriter extends com.dcloud.zxing2.oned.OneDimensionalCodeWriter {
    private static final int[] START_PATTERN = {1, 1, 1, 1};
    private static final int[] END_PATTERN = {3, 1, 1};

    @Override // com.dcloud.zxing2.oned.OneDimensionalCodeWriter, com.dcloud.zxing2.Writer
    public com.dcloud.zxing2.common.BitMatrix encode(java.lang.String str, com.dcloud.zxing2.BarcodeFormat barcodeFormat, int i, int i2, java.util.Map<com.dcloud.zxing2.EncodeHintType, ?> map) throws com.dcloud.zxing2.WriterException {
        if (barcodeFormat == com.dcloud.zxing2.BarcodeFormat.ITF) {
            return super.encode(str, barcodeFormat, i, i2, map);
        }
        throw new java.lang.IllegalArgumentException("Can only encode ITF, but got " + barcodeFormat);
    }

    @Override // com.dcloud.zxing2.oned.OneDimensionalCodeWriter
    public boolean[] encode(java.lang.String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new java.lang.IllegalArgumentException("The length of the input should be even");
        }
        if (length <= 80) {
            boolean[] zArr = new boolean[(length * 9) + 9];
            int iAppendPattern = com.dcloud.zxing2.oned.OneDimensionalCodeWriter.appendPattern(zArr, 0, START_PATTERN, true);
            for (int i = 0; i < length; i += 2) {
                int iDigit = java.lang.Character.digit(str.charAt(i), 10);
                int iDigit2 = java.lang.Character.digit(str.charAt(i + 1), 10);
                int[] iArr = new int[18];
                for (int i2 = 0; i2 < 5; i2++) {
                    int i3 = i2 * 2;
                    int[][] iArr2 = com.dcloud.zxing2.oned.ITFReader.PATTERNS;
                    iArr[i3] = iArr2[iDigit][i2];
                    iArr[i3 + 1] = iArr2[iDigit2][i2];
                }
                iAppendPattern += com.dcloud.zxing2.oned.OneDimensionalCodeWriter.appendPattern(zArr, iAppendPattern, iArr, true);
            }
            com.dcloud.zxing2.oned.OneDimensionalCodeWriter.appendPattern(zArr, iAppendPattern, END_PATTERN, true);
            return zArr;
        }
        throw new java.lang.IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
    }
}
