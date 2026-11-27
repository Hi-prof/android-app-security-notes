package com.dcloud.zxing2.oned;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class EAN13Reader extends com.dcloud.zxing2.oned.UPCEANReader {
    static final int[] FIRST_DIGIT_ENCODINGS = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};
    private final int[] decodeMiddleCounters = new int[4];

    private static void determineFirstDigit(java.lang.StringBuilder sb, int i) throws com.dcloud.zxing2.NotFoundException {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i == FIRST_DIGIT_ENCODINGS[i2]) {
                sb.insert(0, (char) (i2 + 48));
                return;
            }
        }
        throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
    }

    @Override // com.dcloud.zxing2.oned.UPCEANReader
    protected int decodeMiddle(com.dcloud.zxing2.common.BitArray bitArray, int[] iArr, java.lang.StringBuilder sb) throws com.dcloud.zxing2.NotFoundException {
        int[] iArr2 = this.decodeMiddleCounters;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int size = bitArray.getSize();
        int i = iArr[1];
        int i2 = 0;
        for (int i3 = 0; i3 < 6 && i < size; i3++) {
            int iDecodeDigit = com.dcloud.zxing2.oned.UPCEANReader.decodeDigit(bitArray, iArr2, i, com.dcloud.zxing2.oned.UPCEANReader.L_AND_G_PATTERNS);
            sb.append((char) ((iDecodeDigit % 10) + 48));
            for (int i4 : iArr2) {
                i += i4;
            }
            if (iDecodeDigit >= 10) {
                i2 |= 1 << (5 - i3);
            }
        }
        determineFirstDigit(sb, i2);
        int i5 = com.dcloud.zxing2.oned.UPCEANReader.findGuardPattern(bitArray, i, true, com.dcloud.zxing2.oned.UPCEANReader.MIDDLE_PATTERN)[1];
        for (int i6 = 0; i6 < 6 && i5 < size; i6++) {
            sb.append((char) (com.dcloud.zxing2.oned.UPCEANReader.decodeDigit(bitArray, iArr2, i5, com.dcloud.zxing2.oned.UPCEANReader.L_PATTERNS) + 48));
            for (int i7 : iArr2) {
                i5 += i7;
            }
        }
        return i5;
    }

    @Override // com.dcloud.zxing2.oned.UPCEANReader
    com.dcloud.zxing2.BarcodeFormat getBarcodeFormat() {
        return com.dcloud.zxing2.BarcodeFormat.EAN_13;
    }
}
