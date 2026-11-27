package com.dcloud.zxing2.oned;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class Code39Reader extends com.dcloud.zxing2.oned.OneDReader {
    static final java.lang.String ALPHABET_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%";
    static final int ASTERISK_ENCODING;
    static final int[] CHARACTER_ENCODINGS;
    private static final java.lang.String CHECK_DIGIT_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%";
    private final int[] counters;
    private final java.lang.StringBuilder decodeRowResult;
    private final boolean extendedMode;
    private final boolean usingCheckDigit;

    static {
        int[] iArr = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, com.facebook.imageutils.TiffUtil.TIFF_TAG_ORIENTATION, 82, 7, 262, 70, 22, 385, com.alibaba.fastjson.asm.Opcodes.INSTANCEOF, 448, 145, com.facebook.common.statfs.StatFsHelper.DEFAULT_DISK_YELLOW_LEVEL_IN_MB, com.facebook.imageutils.JfifUtil.MARKER_RST0, 133, 388, org.mozilla.universalchardet.prober.distributionanalysis.EUCTWDistributionAnalysis.HIGHBYTE_BEGIN, com.alibaba.fastjson.asm.Opcodes.LCMP, 168, com.alibaba.fastjson.asm.Opcodes.IF_ICMPGE, 138, 42};
        CHARACTER_ENCODINGS = iArr;
        ASTERISK_ENCODING = iArr[39];
    }

    public Code39Reader() {
        this(false);
    }

    private static java.lang.String decodeExtended(java.lang.CharSequence charSequence) throws com.dcloud.zxing2.FormatException {
        int i;
        char c;
        int length = charSequence.length();
        java.lang.StringBuilder sb = new java.lang.StringBuilder(length);
        int i2 = 0;
        while (i2 < length) {
            char cCharAt = charSequence.charAt(i2);
            if (cCharAt == '+' || cCharAt == '$' || cCharAt == '%' || cCharAt == '/') {
                i2++;
                char cCharAt2 = charSequence.charAt(i2);
                if (cCharAt != '$') {
                    if (cCharAt != '%') {
                        if (cCharAt != '+') {
                            if (cCharAt != '/') {
                                c = 0;
                            } else if (cCharAt2 >= 'A' && cCharAt2 <= 'O') {
                                i = cCharAt2 - ' ';
                            } else {
                                if (cCharAt2 != 'Z') {
                                    throw com.dcloud.zxing2.FormatException.getFormatInstance();
                                }
                                c = com.taobao.weex.el.parse.Operators.CONDITION_IF_MIDDLE;
                            }
                            sb.append(c);
                        } else {
                            if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                                throw com.dcloud.zxing2.FormatException.getFormatInstance();
                            }
                            i = cCharAt2 + ' ';
                        }
                    } else if (cCharAt2 >= 'A' && cCharAt2 <= 'E') {
                        i = cCharAt2 - '&';
                    } else {
                        if (cCharAt2 < 'F' || cCharAt2 > 'W') {
                            throw com.dcloud.zxing2.FormatException.getFormatInstance();
                        }
                        i = cCharAt2 - 11;
                    }
                } else {
                    if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                        throw com.dcloud.zxing2.FormatException.getFormatInstance();
                    }
                    i = cCharAt2 - '@';
                }
                c = (char) i;
                sb.append(c);
            } else {
                sb.append(cCharAt);
            }
            i2++;
        }
        return sb.toString();
    }

    private static int[] findAsteriskPattern(com.dcloud.zxing2.common.BitArray bitArray, int[] iArr) throws com.dcloud.zxing2.NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
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
                    if (toNarrowWidePattern(iArr) == ASTERISK_ENCODING && bitArray.isRange(java.lang.Math.max(0, i - ((nextSet - i) / 2)), i, false)) {
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
                return ALPHABET_STRING.charAt(i2);
            }
            i2++;
        }
    }

    private static int toNarrowWidePattern(int[] iArr) {
        int length = iArr.length;
        int i = 0;
        while (true) {
            int i2 = Integer.MAX_VALUE;
            for (int i3 : iArr) {
                if (i3 < i2 && i3 > i) {
                    i2 = i3;
                }
            }
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < length; i7++) {
                int i8 = iArr[i7];
                if (i8 > i2) {
                    i6 |= 1 << ((length - 1) - i7);
                    i4++;
                    i5 += i8;
                }
            }
            if (i4 == 3) {
                for (int i9 = 0; i9 < length && i4 > 0; i9++) {
                    int i10 = iArr[i9];
                    if (i10 > i2) {
                        i4--;
                        if (i10 * 2 >= i5) {
                            return -1;
                        }
                    }
                }
                return i6;
            }
            if (i4 <= 3) {
                return -1;
            }
            i = i2;
        }
    }

    @Override // com.dcloud.zxing2.oned.OneDReader
    public com.dcloud.zxing2.Result decodeRow(int i, com.dcloud.zxing2.common.BitArray bitArray, java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) throws com.dcloud.zxing2.ChecksumException, com.dcloud.zxing2.FormatException, com.dcloud.zxing2.NotFoundException {
        int[] iArr = this.counters;
        java.util.Arrays.fill(iArr, 0);
        java.lang.StringBuilder sb = this.decodeRowResult;
        sb.setLength(0);
        int[] iArrFindAsteriskPattern = findAsteriskPattern(bitArray, iArr);
        int nextSet = bitArray.getNextSet(iArrFindAsteriskPattern[1]);
        int size = bitArray.getSize();
        while (true) {
            com.dcloud.zxing2.oned.OneDReader.recordPattern(bitArray, nextSet, iArr);
            int narrowWidePattern = toNarrowWidePattern(iArr);
            if (narrowWidePattern < 0) {
                throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
            }
            char cPatternToChar = patternToChar(narrowWidePattern);
            sb.append(cPatternToChar);
            int i2 = nextSet;
            for (int i3 : iArr) {
                i2 += i3;
            }
            int nextSet2 = bitArray.getNextSet(i2);
            if (cPatternToChar == '*') {
                sb.setLength(sb.length() - 1);
                int i4 = 0;
                for (int i5 : iArr) {
                    i4 += i5;
                }
                int i6 = (nextSet2 - nextSet) - i4;
                if (nextSet2 != size && i6 * 2 < i4) {
                    throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
                }
                if (this.usingCheckDigit) {
                    int length = sb.length() - 1;
                    int iIndexOf = 0;
                    for (int i7 = 0; i7 < length; i7++) {
                        iIndexOf += CHECK_DIGIT_STRING.indexOf(this.decodeRowResult.charAt(i7));
                    }
                    if (sb.charAt(length) != CHECK_DIGIT_STRING.charAt(iIndexOf % 43)) {
                        throw com.dcloud.zxing2.ChecksumException.getChecksumInstance();
                    }
                    sb.setLength(length);
                }
                if (sb.length() == 0) {
                    throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
                }
                float f = i;
                return new com.dcloud.zxing2.Result(this.extendedMode ? decodeExtended(sb) : sb.toString(), null, new com.dcloud.zxing2.ResultPoint[]{new com.dcloud.zxing2.ResultPoint((iArrFindAsteriskPattern[1] + iArrFindAsteriskPattern[0]) / 2.0f, f), new com.dcloud.zxing2.ResultPoint(nextSet + (i4 / 2.0f), f)}, com.dcloud.zxing2.BarcodeFormat.CODE_39);
            }
            nextSet = nextSet2;
        }
    }

    public Code39Reader(boolean z) {
        this(z, false);
    }

    public Code39Reader(boolean z, boolean z2) {
        this.usingCheckDigit = z;
        this.extendedMode = z2;
        this.decodeRowResult = new java.lang.StringBuilder(20);
        this.counters = new int[9];
    }
}
