package com.dcloud.zxing2.oned;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class EAN8Reader extends com.dcloud.zxing2.oned.UPCEANReader {
    private final int[] decodeMiddleCounters = new int[4];

    @Override // com.dcloud.zxing2.oned.UPCEANReader
    protected int decodeMiddle(com.dcloud.zxing2.common.BitArray bitArray, int[] iArr, java.lang.StringBuilder sb) throws com.dcloud.zxing2.NotFoundException {
        int[] iArr2 = this.decodeMiddleCounters;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int size = bitArray.getSize();
        int i = iArr[1];
        for (int i2 = 0; i2 < 4 && i < size; i2++) {
            sb.append((char) (com.dcloud.zxing2.oned.UPCEANReader.decodeDigit(bitArray, iArr2, i, com.dcloud.zxing2.oned.UPCEANReader.L_PATTERNS) + 48));
            for (int i3 : iArr2) {
                i += i3;
            }
        }
        int i4 = com.dcloud.zxing2.oned.UPCEANReader.findGuardPattern(bitArray, i, true, com.dcloud.zxing2.oned.UPCEANReader.MIDDLE_PATTERN)[1];
        for (int i5 = 0; i5 < 4 && i4 < size; i5++) {
            sb.append((char) (com.dcloud.zxing2.oned.UPCEANReader.decodeDigit(bitArray, iArr2, i4, com.dcloud.zxing2.oned.UPCEANReader.L_PATTERNS) + 48));
            for (int i6 : iArr2) {
                i4 += i6;
            }
        }
        return i4;
    }

    @Override // com.dcloud.zxing2.oned.UPCEANReader
    com.dcloud.zxing2.BarcodeFormat getBarcodeFormat() {
        return com.dcloud.zxing2.BarcodeFormat.EAN_8;
    }
}
