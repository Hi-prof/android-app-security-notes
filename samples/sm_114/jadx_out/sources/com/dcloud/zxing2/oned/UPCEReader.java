package com.dcloud.zxing2.oned;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class UPCEReader extends com.dcloud.zxing2.oned.UPCEANReader {
    static final int[] CHECK_DIGIT_ENCODINGS = {56, 52, 50, 49, 44, 38, 35, 42, 41, 37};
    private static final int[] MIDDLE_END_PATTERN = {1, 1, 1, 1, 1, 1};
    private static final int[][] NUMSYS_AND_CHECK_DIGIT_PATTERNS = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};
    private final int[] decodeMiddleCounters = new int[4];

    public static java.lang.String convertUPCEtoUPCA(java.lang.String str) {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(12);
        sb.append(str.charAt(0));
        char c = cArr[5];
        switch (c) {
            case '0':
            case '1':
            case '2':
                sb.append(cArr, 0, 2);
                sb.append(c);
                sb.append("0000");
                sb.append(cArr, 2, 3);
                break;
            case '3':
                sb.append(cArr, 0, 3);
                sb.append("00000");
                sb.append(cArr, 3, 2);
                break;
            case '4':
                sb.append(cArr, 0, 4);
                sb.append("00000");
                sb.append(cArr[4]);
                break;
            default:
                sb.append(cArr, 0, 5);
                sb.append("0000");
                sb.append(c);
                break;
        }
        sb.append(str.charAt(7));
        return sb.toString();
    }

    private static void determineNumSysAndCheckDigit(java.lang.StringBuilder sb, int i) throws com.dcloud.zxing2.NotFoundException {
        for (int i2 = 0; i2 <= 1; i2++) {
            for (int i3 = 0; i3 < 10; i3++) {
                if (i == NUMSYS_AND_CHECK_DIGIT_PATTERNS[i2][i3]) {
                    sb.insert(0, (char) (i2 + 48));
                    sb.append((char) (i3 + 48));
                    return;
                }
            }
        }
        throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
    }

    @Override // com.dcloud.zxing2.oned.UPCEANReader
    protected boolean checkChecksum(java.lang.String str) throws com.dcloud.zxing2.FormatException {
        return super.checkChecksum(convertUPCEtoUPCA(str));
    }

    @Override // com.dcloud.zxing2.oned.UPCEANReader
    protected int[] decodeEnd(com.dcloud.zxing2.common.BitArray bitArray, int i) throws com.dcloud.zxing2.NotFoundException {
        return com.dcloud.zxing2.oned.UPCEANReader.findGuardPattern(bitArray, i, true, MIDDLE_END_PATTERN);
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
        determineNumSysAndCheckDigit(sb, i2);
        return i;
    }

    @Override // com.dcloud.zxing2.oned.UPCEANReader
    com.dcloud.zxing2.BarcodeFormat getBarcodeFormat() {
        return com.dcloud.zxing2.BarcodeFormat.UPC_E;
    }
}
