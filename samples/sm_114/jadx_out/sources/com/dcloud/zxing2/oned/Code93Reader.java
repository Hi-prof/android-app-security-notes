package com.dcloud.zxing2.oned;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class Code93Reader extends com.dcloud.zxing2.oned.OneDReader {
    private static final int ASTERISK_ENCODING;
    static final int[] CHARACTER_ENCODINGS;
    static final java.lang.String ALPHABET_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*";
    private static final char[] ALPHABET = ALPHABET_STRING.toCharArray();
    private final java.lang.StringBuilder decodeRowResult = new java.lang.StringBuilder(20);
    private final int[] counters = new int[6];

    static {
        int[] iArr = {276, 328, 324, 322, 296, 292, 290, 336, com.facebook.imageutils.TiffUtil.TIFF_TAG_ORIENTATION, 266, 424, 420, 418, 404, 402, 394, 360, 356, 354, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, 422, 406, 410, 364, 358, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, 350};
        CHARACTER_ENCODINGS = iArr;
        ASTERISK_ENCODING = iArr[47];
    }

    private static void checkChecksums(java.lang.CharSequence charSequence) throws com.dcloud.zxing2.ChecksumException {
        int length = charSequence.length();
        checkOneChecksum(charSequence, length - 2, 20);
        checkOneChecksum(charSequence, length - 1, 15);
    }

    private static void checkOneChecksum(java.lang.CharSequence charSequence, int i, int i2) throws com.dcloud.zxing2.ChecksumException {
        int iIndexOf = 0;
        int i3 = 1;
        for (int i4 = i - 1; i4 >= 0; i4--) {
            iIndexOf += ALPHABET_STRING.indexOf(charSequence.charAt(i4)) * i3;
            i3++;
            if (i3 > i2) {
                i3 = 1;
            }
        }
        if (charSequence.charAt(i) != ALPHABET[iIndexOf % 47]) {
            throw com.dcloud.zxing2.ChecksumException.getChecksumInstance();
        }
    }

    private static java.lang.String decodeExtended(java.lang.CharSequence charSequence) throws com.dcloud.zxing2.FormatException {
        int i;
        char c;
        int length = charSequence.length();
        java.lang.StringBuilder sb = new java.lang.StringBuilder(length);
        int i2 = 0;
        while (i2 < length) {
            char cCharAt = charSequence.charAt(i2);
            if (cCharAt >= 'a' && cCharAt <= 'd') {
                if (i2 >= length - 1) {
                    throw com.dcloud.zxing2.FormatException.getFormatInstance();
                }
                i2++;
                char cCharAt2 = charSequence.charAt(i2);
                switch (cCharAt) {
                    case org.mozilla.universalchardet.prober.CharsetProber.ASCII_A /* 97 */:
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            throw com.dcloud.zxing2.FormatException.getFormatInstance();
                        }
                        i = cCharAt2 - '@';
                        c = (char) i;
                        sb.append(c);
                        break;
                    case 'b':
                        if (cCharAt2 >= 'A' && cCharAt2 <= 'E') {
                            i = cCharAt2 - '&';
                        } else if (cCharAt2 >= 'F' && cCharAt2 <= 'J') {
                            i = cCharAt2 - 11;
                        } else if (cCharAt2 < 'K' || cCharAt2 > 'O') {
                            if (cCharAt2 >= 'P' && cCharAt2 <= 'S') {
                                i = cCharAt2 + '+';
                            } else {
                                if (cCharAt2 < 'T' || cCharAt2 > 'Z') {
                                    throw com.dcloud.zxing2.FormatException.getFormatInstance();
                                }
                                c = 127;
                            }
                            sb.append(c);
                        } else {
                            i = cCharAt2 + 16;
                        }
                        c = (char) i;
                        sb.append(c);
                        break;
                    case 'c':
                        if (cCharAt2 >= 'A' && cCharAt2 <= 'O') {
                            i = cCharAt2 - ' ';
                            c = (char) i;
                        } else {
                            if (cCharAt2 != 'Z') {
                                throw com.dcloud.zxing2.FormatException.getFormatInstance();
                            }
                            c = com.taobao.weex.el.parse.Operators.CONDITION_IF_MIDDLE;
                        }
                        sb.append(c);
                        break;
                    case 'd':
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            throw com.dcloud.zxing2.FormatException.getFormatInstance();
                        }
                        i = cCharAt2 + ' ';
                        c = (char) i;
                        sb.append(c);
                        break;
                    default:
                        c = 0;
                        sb.append(c);
                        break;
                }
            } else {
                sb.append(cCharAt);
            }
            i2++;
        }
        return sb.toString();
    }

    private int[] findAsteriskPattern(com.dcloud.zxing2.common.BitArray bitArray) throws com.dcloud.zxing2.NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        java.util.Arrays.fill(this.counters, 0);
        int[] iArr = this.counters;
        int length = iArr.length;
        int i = nextSet;
        boolean z = false;
        int i2 = 0;
        while (nextSet < size) {
            if (bitArray.get(nextSet) ^ z) {
                iArr[i2] = iArr[i2] + 1;
            } else {
                int i3 = length - 1;
                if (i2 != i3) {
                    i2++;
                } else {
                    if (toPattern(iArr) == ASTERISK_ENCODING) {
                        return new int[]{i, nextSet};
                    }
                    i += iArr[0] + iArr[1];
                    int i4 = length - 2;
                    java.lang.System.arraycopy(iArr, 2, iArr, 0, i4);
                    iArr[i4] = 0;
                    iArr[i3] = 0;
                    i2--;
                }
                iArr[i2] = 1;
                z = !z;
            }
            nextSet++;
        }
        throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
    }

    private static char patternToChar(int i) throws com.dcloud.zxing2.NotFoundException {
        int i2 = 0;
        while (true) {
            int[] iArr = CHARACTER_ENCODINGS;
            if (i2 >= iArr.length) {
                throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
            }
            if (iArr[i2] == i) {
                return ALPHABET[i2];
            }
            i2++;
        }
    }

    private static int toPattern(int[] iArr) {
        int length = iArr.length;
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            int iRound = java.lang.Math.round((iArr[i4] * 9.0f) / i);
            if (iRound < 1 || iRound > 4) {
                return -1;
            }
            if ((i4 & 1) == 0) {
                for (int i5 = 0; i5 < iRound; i5++) {
                    i3 = (i3 << 1) | 1;
                }
            } else {
                i3 <<= iRound;
            }
        }
        return i3;
    }

    @Override // com.dcloud.zxing2.oned.OneDReader
    public com.dcloud.zxing2.Result decodeRow(int i, com.dcloud.zxing2.common.BitArray bitArray, java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) throws com.dcloud.zxing2.ChecksumException, com.dcloud.zxing2.FormatException, com.dcloud.zxing2.NotFoundException {
        int[] iArrFindAsteriskPattern = findAsteriskPattern(bitArray);
        int nextSet = bitArray.getNextSet(iArrFindAsteriskPattern[1]);
        int size = bitArray.getSize();
        int[] iArr = this.counters;
        java.util.Arrays.fill(iArr, 0);
        java.lang.StringBuilder sb = this.decodeRowResult;
        sb.setLength(0);
        while (true) {
            com.dcloud.zxing2.oned.OneDReader.recordPattern(bitArray, nextSet, iArr);
            int pattern = toPattern(iArr);
            if (pattern < 0) {
                throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
            }
            char cPatternToChar = patternToChar(pattern);
            sb.append(cPatternToChar);
            int i2 = nextSet;
            for (int i3 : iArr) {
                i2 += i3;
            }
            int nextSet2 = bitArray.getNextSet(i2);
            if (cPatternToChar == '*') {
                sb.deleteCharAt(sb.length() - 1);
                int i4 = 0;
                for (int i5 : iArr) {
                    i4 += i5;
                }
                if (nextSet2 == size || !bitArray.get(nextSet2)) {
                    throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
                }
                if (sb.length() < 2) {
                    throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
                }
                checkChecksums(sb);
                sb.setLength(sb.length() - 2);
                float f = i;
                return new com.dcloud.zxing2.Result(decodeExtended(sb), null, new com.dcloud.zxing2.ResultPoint[]{new com.dcloud.zxing2.ResultPoint((iArrFindAsteriskPattern[1] + iArrFindAsteriskPattern[0]) / 2.0f, f), new com.dcloud.zxing2.ResultPoint(nextSet + (i4 / 2.0f), f)}, com.dcloud.zxing2.BarcodeFormat.CODE_93);
            }
            nextSet = nextSet2;
        }
    }
}
