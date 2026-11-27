package com.dcloud.zxing2.oned;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class ITFReader extends com.dcloud.zxing2.oned.OneDReader {
    private static final float MAX_AVG_VARIANCE = 0.38f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.78f;
    private static final int N = 1;
    private static final int W = 3;
    private int narrowLineWidth = -1;
    private static final int[] DEFAULT_ALLOWED_LENGTHS = {6, 8, 10, 12, 14};
    private static final int[] START_PATTERN = {1, 1, 1, 1};
    private static final int[] END_PATTERN_REVERSED = {1, 1, 3};
    static final int[][] PATTERNS = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    private static int decodeDigit(int[] iArr) throws com.dcloud.zxing2.NotFoundException {
        int length = PATTERNS.length;
        float f = MAX_AVG_VARIANCE;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            float fPatternMatchVariance = com.dcloud.zxing2.oned.OneDReader.patternMatchVariance(iArr, PATTERNS[i2], MAX_INDIVIDUAL_VARIANCE);
            if (fPatternMatchVariance < f) {
                i = i2;
                f = fPatternMatchVariance;
            }
        }
        if (i >= 0) {
            return i;
        }
        throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
    }

    private static void decodeMiddle(com.dcloud.zxing2.common.BitArray bitArray, int i, int i2, java.lang.StringBuilder sb) throws com.dcloud.zxing2.NotFoundException {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i < i2) {
            com.dcloud.zxing2.oned.OneDReader.recordPattern(bitArray, i, iArr);
            for (int i3 = 0; i3 < 5; i3++) {
                int i4 = i3 * 2;
                iArr2[i3] = iArr[i4];
                iArr3[i3] = iArr[i4 + 1];
            }
            sb.append((char) (decodeDigit(iArr2) + 48));
            sb.append((char) (decodeDigit(iArr3) + 48));
            for (int i5 = 0; i5 < 10; i5++) {
                i += iArr[i5];
            }
        }
    }

    private static int[] findGuardPattern(com.dcloud.zxing2.common.BitArray bitArray, int i, int[] iArr) throws com.dcloud.zxing2.NotFoundException {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int size = bitArray.getSize();
        int i2 = i;
        boolean z = false;
        int i3 = 0;
        while (i < size) {
            if (bitArray.get(i) ^ z) {
                iArr2[i3] = iArr2[i3] + 1;
            } else {
                int i4 = length - 1;
                if (i3 != i4) {
                    i3++;
                } else {
                    if (com.dcloud.zxing2.oned.OneDReader.patternMatchVariance(iArr2, iArr, MAX_INDIVIDUAL_VARIANCE) < MAX_AVG_VARIANCE) {
                        return new int[]{i2, i};
                    }
                    i2 += iArr2[0] + iArr2[1];
                    int i5 = length - 2;
                    java.lang.System.arraycopy(iArr2, 2, iArr2, 0, i5);
                    iArr2[i5] = 0;
                    iArr2[i4] = 0;
                    i3--;
                }
                iArr2[i3] = 1;
                z = !z;
            }
            i++;
        }
        throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
    }

    private static int skipWhiteSpace(com.dcloud.zxing2.common.BitArray bitArray) throws com.dcloud.zxing2.NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        if (nextSet != size) {
            return nextSet;
        }
        throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
    }

    private void validateQuietZone(com.dcloud.zxing2.common.BitArray bitArray, int i) throws com.dcloud.zxing2.NotFoundException {
        int i2 = this.narrowLineWidth * 10;
        if (i2 >= i) {
            i2 = i;
        }
        for (int i3 = i - 1; i2 > 0 && i3 >= 0 && !bitArray.get(i3); i3--) {
            i2--;
        }
        if (i2 != 0) {
            throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
        }
    }

    int[] decodeEnd(com.dcloud.zxing2.common.BitArray bitArray) throws com.dcloud.zxing2.NotFoundException {
        bitArray.reverse();
        try {
            int[] iArrFindGuardPattern = findGuardPattern(bitArray, skipWhiteSpace(bitArray), END_PATTERN_REVERSED);
            validateQuietZone(bitArray, iArrFindGuardPattern[0]);
            int i = iArrFindGuardPattern[0];
            iArrFindGuardPattern[0] = bitArray.getSize() - iArrFindGuardPattern[1];
            iArrFindGuardPattern[1] = bitArray.getSize() - i;
            return iArrFindGuardPattern;
        } finally {
            bitArray.reverse();
        }
    }

    @Override // com.dcloud.zxing2.oned.OneDReader
    public com.dcloud.zxing2.Result decodeRow(int i, com.dcloud.zxing2.common.BitArray bitArray, java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) throws com.dcloud.zxing2.FormatException, com.dcloud.zxing2.NotFoundException {
        boolean z;
        int[] iArrDecodeStart = decodeStart(bitArray);
        int[] iArrDecodeEnd = decodeEnd(bitArray);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(20);
        decodeMiddle(bitArray, iArrDecodeStart[1], iArrDecodeEnd[0], sb);
        java.lang.String string = sb.toString();
        int[] iArr = map != null ? (int[]) map.get(com.dcloud.zxing2.DecodeHintType.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = DEFAULT_ALLOWED_LENGTHS;
        }
        int length = string.length();
        int length2 = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= length2) {
                z = false;
                break;
            }
            int i4 = iArr[i2];
            if (length == i4) {
                z = true;
                break;
            }
            if (i4 > i3) {
                i3 = i4;
            }
            i2++;
        }
        if (!z && length > i3) {
            z = true;
        }
        if (!z) {
            throw com.dcloud.zxing2.FormatException.getFormatInstance();
        }
        float f = i;
        return new com.dcloud.zxing2.Result(string, null, new com.dcloud.zxing2.ResultPoint[]{new com.dcloud.zxing2.ResultPoint(iArrDecodeStart[1], f), new com.dcloud.zxing2.ResultPoint(iArrDecodeEnd[0], f)}, com.dcloud.zxing2.BarcodeFormat.ITF);
    }

    int[] decodeStart(com.dcloud.zxing2.common.BitArray bitArray) throws com.dcloud.zxing2.NotFoundException {
        int[] iArrFindGuardPattern = findGuardPattern(bitArray, skipWhiteSpace(bitArray), START_PATTERN);
        int i = iArrFindGuardPattern[1];
        int i2 = iArrFindGuardPattern[0];
        this.narrowLineWidth = (i - i2) / 4;
        validateQuietZone(bitArray, i2);
        return iArrFindGuardPattern;
    }
}
