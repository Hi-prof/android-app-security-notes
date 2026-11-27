package com.dcloud.zxing2.oned;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class EAN13Writer extends com.dcloud.zxing2.oned.UPCEANWriter {
    private static final int CODE_WIDTH = 95;

    @Override // com.dcloud.zxing2.oned.OneDimensionalCodeWriter, com.dcloud.zxing2.Writer
    public com.dcloud.zxing2.common.BitMatrix encode(java.lang.String str, com.dcloud.zxing2.BarcodeFormat barcodeFormat, int i, int i2, java.util.Map<com.dcloud.zxing2.EncodeHintType, ?> map) throws com.dcloud.zxing2.WriterException {
        if (barcodeFormat == com.dcloud.zxing2.BarcodeFormat.EAN_13) {
            return super.encode(str, barcodeFormat, i, i2, map);
        }
        throw new java.lang.IllegalArgumentException("Can only encode EAN_13, but got " + barcodeFormat);
    }

    @Override // com.dcloud.zxing2.oned.OneDimensionalCodeWriter
    public boolean[] encode(java.lang.String str) {
        if (str.length() == 13) {
            try {
                if (com.dcloud.zxing2.oned.UPCEANReader.checkStandardUPCEANChecksum(str)) {
                    int i = com.dcloud.zxing2.oned.EAN13Reader.FIRST_DIGIT_ENCODINGS[java.lang.Integer.parseInt(str.substring(0, 1))];
                    boolean[] zArr = new boolean[CODE_WIDTH];
                    int iAppendPattern = com.dcloud.zxing2.oned.OneDimensionalCodeWriter.appendPattern(zArr, 0, com.dcloud.zxing2.oned.UPCEANReader.START_END_PATTERN, true);
                    int i2 = 1;
                    while (i2 <= 6) {
                        int i3 = i2 + 1;
                        int i4 = java.lang.Integer.parseInt(str.substring(i2, i3));
                        if (((i >> (6 - i2)) & 1) == 1) {
                            i4 += 10;
                        }
                        iAppendPattern += com.dcloud.zxing2.oned.OneDimensionalCodeWriter.appendPattern(zArr, iAppendPattern, com.dcloud.zxing2.oned.UPCEANReader.L_AND_G_PATTERNS[i4], false);
                        i2 = i3;
                    }
                    int iAppendPattern2 = iAppendPattern + com.dcloud.zxing2.oned.OneDimensionalCodeWriter.appendPattern(zArr, iAppendPattern, com.dcloud.zxing2.oned.UPCEANReader.MIDDLE_PATTERN, false);
                    int i5 = 7;
                    while (i5 <= 12) {
                        int i6 = i5 + 1;
                        iAppendPattern2 += com.dcloud.zxing2.oned.OneDimensionalCodeWriter.appendPattern(zArr, iAppendPattern2, com.dcloud.zxing2.oned.UPCEANReader.L_PATTERNS[java.lang.Integer.parseInt(str.substring(i5, i6))], true);
                        i5 = i6;
                    }
                    com.dcloud.zxing2.oned.OneDimensionalCodeWriter.appendPattern(zArr, iAppendPattern2, com.dcloud.zxing2.oned.UPCEANReader.START_END_PATTERN, true);
                    return zArr;
                }
                throw new java.lang.IllegalArgumentException("Contents do not pass checksum");
            } catch (com.dcloud.zxing2.FormatException unused) {
                throw new java.lang.IllegalArgumentException("Illegal contents");
            }
        }
        throw new java.lang.IllegalArgumentException("Requested contents should be 13 digits long, but got " + str.length());
    }
}
