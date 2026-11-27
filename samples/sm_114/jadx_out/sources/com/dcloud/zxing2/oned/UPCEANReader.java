package com.dcloud.zxing2.oned;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public abstract class UPCEANReader extends com.dcloud.zxing2.oned.OneDReader {
    static final int[][] L_AND_G_PATTERNS;
    static final int[][] L_PATTERNS;
    private static final float MAX_AVG_VARIANCE = 0.48f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.7f;
    static final int[] START_END_PATTERN = {1, 1, 1};
    static final int[] MIDDLE_PATTERN = {1, 1, 1, 1, 1};
    static final int[] END_PATTERN = {1, 1, 1, 1, 1, 1};
    private final java.lang.StringBuilder decodeRowStringBuffer = new java.lang.StringBuilder(20);
    private final com.dcloud.zxing2.oned.UPCEANExtensionSupport extensionReader = new com.dcloud.zxing2.oned.UPCEANExtensionSupport();
    private final com.dcloud.zxing2.oned.EANManufacturerOrgSupport eanManSupport = new com.dcloud.zxing2.oned.EANManufacturerOrgSupport();

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        L_PATTERNS = iArr;
        int[][] iArr2 = new int[20][];
        L_AND_G_PATTERNS = iArr2;
        java.lang.System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i = 10; i < 20; i++) {
            int[] iArr3 = L_PATTERNS[i - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i2 = 0; i2 < iArr3.length; i2++) {
                iArr4[i2] = iArr3[(iArr3.length - i2) - 1];
            }
            L_AND_G_PATTERNS[i] = iArr4;
        }
    }

    protected UPCEANReader() {
    }

    static boolean checkStandardUPCEANChecksum(java.lang.CharSequence charSequence) throws com.dcloud.zxing2.FormatException {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        for (int i2 = length - 2; i2 >= 0; i2 -= 2) {
            int iCharAt = charSequence.charAt(i2) - '0';
            if (iCharAt < 0 || iCharAt > 9) {
                throw com.dcloud.zxing2.FormatException.getFormatInstance();
            }
            i += iCharAt;
        }
        int i3 = i * 3;
        for (int i4 = length - 1; i4 >= 0; i4 -= 2) {
            int iCharAt2 = charSequence.charAt(i4) - '0';
            if (iCharAt2 < 0 || iCharAt2 > 9) {
                throw com.dcloud.zxing2.FormatException.getFormatInstance();
            }
            i3 += iCharAt2;
        }
        return i3 % 10 == 0;
    }

    static int decodeDigit(com.dcloud.zxing2.common.BitArray bitArray, int[] iArr, int i, int[][] iArr2) throws com.dcloud.zxing2.NotFoundException {
        com.dcloud.zxing2.oned.OneDReader.recordPattern(bitArray, i, iArr);
        int length = iArr2.length;
        float f = MAX_AVG_VARIANCE;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            float fPatternMatchVariance = com.dcloud.zxing2.oned.OneDReader.patternMatchVariance(iArr, iArr2[i3], MAX_INDIVIDUAL_VARIANCE);
            if (fPatternMatchVariance < f) {
                i2 = i3;
                f = fPatternMatchVariance;
            }
        }
        if (i2 >= 0) {
            return i2;
        }
        throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
    }

    static int[] findGuardPattern(com.dcloud.zxing2.common.BitArray bitArray, int i, boolean z, int[] iArr) throws com.dcloud.zxing2.NotFoundException {
        return findGuardPattern(bitArray, i, z, iArr, new int[iArr.length]);
    }

    static int[] findStartGuardPattern(com.dcloud.zxing2.common.BitArray bitArray) throws com.dcloud.zxing2.NotFoundException {
        int[] iArr = new int[START_END_PATTERN.length];
        int[] iArrFindGuardPattern = null;
        boolean zIsRange = false;
        int i = 0;
        while (!zIsRange) {
            int[] iArr2 = START_END_PATTERN;
            java.util.Arrays.fill(iArr, 0, iArr2.length, 0);
            iArrFindGuardPattern = findGuardPattern(bitArray, i, false, iArr2, iArr);
            int i2 = iArrFindGuardPattern[0];
            int i3 = iArrFindGuardPattern[1];
            int i4 = i2 - (i3 - i2);
            if (i4 >= 0) {
                zIsRange = bitArray.isRange(i4, i2, false);
            }
            i = i3;
        }
        return iArrFindGuardPattern;
    }

    boolean checkChecksum(java.lang.String str) throws com.dcloud.zxing2.FormatException {
        return checkStandardUPCEANChecksum(str);
    }

    int[] decodeEnd(com.dcloud.zxing2.common.BitArray bitArray, int i) throws com.dcloud.zxing2.NotFoundException {
        return findGuardPattern(bitArray, i, false, START_END_PATTERN);
    }

    protected abstract int decodeMiddle(com.dcloud.zxing2.common.BitArray bitArray, int[] iArr, java.lang.StringBuilder sb) throws com.dcloud.zxing2.NotFoundException;

    @Override // com.dcloud.zxing2.oned.OneDReader
    public com.dcloud.zxing2.Result decodeRow(int i, com.dcloud.zxing2.common.BitArray bitArray, java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) throws com.dcloud.zxing2.ChecksumException, com.dcloud.zxing2.FormatException, com.dcloud.zxing2.NotFoundException {
        return decodeRow(i, bitArray, findStartGuardPattern(bitArray), map);
    }

    abstract com.dcloud.zxing2.BarcodeFormat getBarcodeFormat();

    private static int[] findGuardPattern(com.dcloud.zxing2.common.BitArray bitArray, int i, boolean z, int[] iArr, int[] iArr2) throws com.dcloud.zxing2.NotFoundException {
        int length = iArr.length;
        int size = bitArray.getSize();
        int nextUnset = z ? bitArray.getNextUnset(i) : bitArray.getNextSet(i);
        boolean z2 = z;
        int i2 = 0;
        int i3 = nextUnset;
        while (nextUnset < size) {
            if (bitArray.get(nextUnset) ^ z2) {
                iArr2[i2] = iArr2[i2] + 1;
            } else {
                int i4 = length - 1;
                if (i2 != i4) {
                    i2++;
                } else {
                    if (com.dcloud.zxing2.oned.OneDReader.patternMatchVariance(iArr2, iArr, MAX_INDIVIDUAL_VARIANCE) < MAX_AVG_VARIANCE) {
                        return new int[]{i3, nextUnset};
                    }
                    i3 += iArr2[0] + iArr2[1];
                    int i5 = length - 2;
                    java.lang.System.arraycopy(iArr2, 2, iArr2, 0, i5);
                    iArr2[i5] = 0;
                    iArr2[i4] = 0;
                    i2--;
                }
                iArr2[i2] = 1;
                z2 = !z2;
            }
            nextUnset++;
        }
        throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
    }

    public com.dcloud.zxing2.Result decodeRow(int i, com.dcloud.zxing2.common.BitArray bitArray, int[] iArr, java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) throws com.dcloud.zxing2.ChecksumException, com.dcloud.zxing2.FormatException, com.dcloud.zxing2.NotFoundException {
        int length;
        java.lang.String strLookupCountryIdentifier;
        com.dcloud.zxing2.ResultPointCallback resultPointCallback = map == null ? null : (com.dcloud.zxing2.ResultPointCallback) map.get(com.dcloud.zxing2.DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        int i2 = 0;
        if (resultPointCallback != null) {
            resultPointCallback.foundPossibleResultPoint(new com.dcloud.zxing2.ResultPoint((iArr[0] + iArr[1]) / 2.0f, i));
        }
        java.lang.StringBuilder sb = this.decodeRowStringBuffer;
        sb.setLength(0);
        int iDecodeMiddle = decodeMiddle(bitArray, iArr, sb);
        if (resultPointCallback != null) {
            resultPointCallback.foundPossibleResultPoint(new com.dcloud.zxing2.ResultPoint(iDecodeMiddle, i));
        }
        int[] iArrDecodeEnd = decodeEnd(bitArray, iDecodeMiddle);
        if (resultPointCallback != null) {
            resultPointCallback.foundPossibleResultPoint(new com.dcloud.zxing2.ResultPoint((iArrDecodeEnd[0] + iArrDecodeEnd[1]) / 2.0f, i));
        }
        int i3 = iArrDecodeEnd[1];
        int i4 = (i3 - iArrDecodeEnd[0]) + i3;
        if (i4 >= bitArray.getSize() || !bitArray.isRange(i3, i4, false)) {
            throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
        }
        java.lang.String string = sb.toString();
        if (string.length() < 8) {
            throw com.dcloud.zxing2.FormatException.getFormatInstance();
        }
        if (!checkChecksum(string)) {
            throw com.dcloud.zxing2.ChecksumException.getChecksumInstance();
        }
        float f = (iArr[1] + iArr[0]) / 2.0f;
        float f2 = (iArrDecodeEnd[1] + iArrDecodeEnd[0]) / 2.0f;
        com.dcloud.zxing2.BarcodeFormat barcodeFormat = getBarcodeFormat();
        float f3 = i;
        com.dcloud.zxing2.Result result = new com.dcloud.zxing2.Result(string, null, new com.dcloud.zxing2.ResultPoint[]{new com.dcloud.zxing2.ResultPoint(f, f3), new com.dcloud.zxing2.ResultPoint(f2, f3)}, barcodeFormat);
        try {
            com.dcloud.zxing2.Result resultDecodeRow = this.extensionReader.decodeRow(i, bitArray, iArrDecodeEnd[1]);
            result.putMetadata(com.dcloud.zxing2.ResultMetadataType.UPC_EAN_EXTENSION, resultDecodeRow.getText());
            result.putAllMetadata(resultDecodeRow.getResultMetadata());
            result.addResultPoints(resultDecodeRow.getResultPoints());
            length = resultDecodeRow.getText().length();
        } catch (com.dcloud.zxing2.ReaderException unused) {
            length = 0;
        }
        int[] iArr2 = map != null ? (int[]) map.get(com.dcloud.zxing2.DecodeHintType.ALLOWED_EAN_EXTENSIONS) : null;
        if (iArr2 != null) {
            int length2 = iArr2.length;
            while (true) {
                if (i2 >= length2) {
                    throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
                }
                if (length == iArr2[i2]) {
                    break;
                }
                i2++;
            }
        }
        if ((barcodeFormat == com.dcloud.zxing2.BarcodeFormat.EAN_13 || barcodeFormat == com.dcloud.zxing2.BarcodeFormat.UPC_A) && (strLookupCountryIdentifier = this.eanManSupport.lookupCountryIdentifier(string)) != null) {
            result.putMetadata(com.dcloud.zxing2.ResultMetadataType.POSSIBLE_COUNTRY, strLookupCountryIdentifier);
        }
        return result;
    }
}
