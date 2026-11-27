package com.dcloud.zxing2.oned;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class EAN8Writer extends com.dcloud.zxing2.oned.UPCEANWriter {
    private static final int CODE_WIDTH = 67;

    @Override // com.dcloud.zxing2.oned.OneDimensionalCodeWriter, com.dcloud.zxing2.Writer
    public com.dcloud.zxing2.common.BitMatrix encode(java.lang.String str, com.dcloud.zxing2.BarcodeFormat barcodeFormat, int i, int i2, java.util.Map<com.dcloud.zxing2.EncodeHintType, ?> map) throws com.dcloud.zxing2.WriterException {
        if (barcodeFormat == com.dcloud.zxing2.BarcodeFormat.EAN_8) {
            return super.encode(str, barcodeFormat, i, i2, map);
        }
        throw new java.lang.IllegalArgumentException("Can only encode EAN_8, but got " + barcodeFormat);
    }

    @Override // com.dcloud.zxing2.oned.OneDimensionalCodeWriter
    public boolean[] encode(java.lang.String str) {
        if (str.length() == 8) {
            boolean[] zArr = new boolean[CODE_WIDTH];
            int iAppendPattern = com.dcloud.zxing2.oned.OneDimensionalCodeWriter.appendPattern(zArr, 0, com.dcloud.zxing2.oned.UPCEANReader.START_END_PATTERN, true);
            int i = 0;
            while (i <= 3) {
                int i2 = i + 1;
                iAppendPattern += com.dcloud.zxing2.oned.OneDimensionalCodeWriter.appendPattern(zArr, iAppendPattern, com.dcloud.zxing2.oned.UPCEANReader.L_PATTERNS[java.lang.Integer.parseInt(str.substring(i, i2))], false);
                i = i2;
            }
            int iAppendPattern2 = iAppendPattern + com.dcloud.zxing2.oned.OneDimensionalCodeWriter.appendPattern(zArr, iAppendPattern, com.dcloud.zxing2.oned.UPCEANReader.MIDDLE_PATTERN, false);
            int i3 = 4;
            while (i3 <= 7) {
                int i4 = i3 + 1;
                iAppendPattern2 += com.dcloud.zxing2.oned.OneDimensionalCodeWriter.appendPattern(zArr, iAppendPattern2, com.dcloud.zxing2.oned.UPCEANReader.L_PATTERNS[java.lang.Integer.parseInt(str.substring(i3, i4))], true);
                i3 = i4;
            }
            com.dcloud.zxing2.oned.OneDimensionalCodeWriter.appendPattern(zArr, iAppendPattern2, com.dcloud.zxing2.oned.UPCEANReader.START_END_PATTERN, true);
            return zArr;
        }
        throw new java.lang.IllegalArgumentException("Requested contents should be 8 digits long, but got " + str.length());
    }
}
