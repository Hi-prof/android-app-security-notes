package com.dcloud.zxing2.oned;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class CodaBarWriter extends com.dcloud.zxing2.oned.OneDimensionalCodeWriter {
    private static final char[] ALT_START_END_CHARS = {'T', 'N', '*', 'E'};
    private static final char[] CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED = {'/', com.taobao.weex.el.parse.Operators.CONDITION_IF_MIDDLE, '+', com.taobao.weex.el.parse.Operators.DOT};
    private static final char DEFAULT_GUARD;
    private static final char[] START_END_CHARS;

    static {
        char[] cArr = {'A', 'B', 'C', 'D'};
        START_END_CHARS = cArr;
        DEFAULT_GUARD = cArr[0];
    }

    @Override // com.dcloud.zxing2.oned.OneDimensionalCodeWriter
    public boolean[] encode(java.lang.String str) {
        int i;
        if (str.length() < 2) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            char c = DEFAULT_GUARD;
            sb.append(c);
            sb.append(str);
            sb.append(c);
            str = sb.toString();
        } else {
            char upperCase = java.lang.Character.toUpperCase(str.charAt(0));
            char upperCase2 = java.lang.Character.toUpperCase(str.charAt(str.length() - 1));
            char[] cArr = START_END_CHARS;
            boolean zArrayContains = com.dcloud.zxing2.oned.CodaBarReader.arrayContains(cArr, upperCase);
            boolean zArrayContains2 = com.dcloud.zxing2.oned.CodaBarReader.arrayContains(cArr, upperCase2);
            char[] cArr2 = ALT_START_END_CHARS;
            boolean zArrayContains3 = com.dcloud.zxing2.oned.CodaBarReader.arrayContains(cArr2, upperCase);
            boolean zArrayContains4 = com.dcloud.zxing2.oned.CodaBarReader.arrayContains(cArr2, upperCase2);
            if (zArrayContains) {
                if (!zArrayContains2) {
                    throw new java.lang.IllegalArgumentException("Invalid start/end guards: " + str);
                }
            } else if (!zArrayContains3) {
                if (zArrayContains2 || zArrayContains4) {
                    throw new java.lang.IllegalArgumentException("Invalid start/end guards: " + str);
                }
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                char c2 = DEFAULT_GUARD;
                sb2.append(c2);
                sb2.append(str);
                sb2.append(c2);
                str = sb2.toString();
            } else if (!zArrayContains4) {
                throw new java.lang.IllegalArgumentException("Invalid start/end guards: " + str);
            }
        }
        int i2 = 20;
        for (int i3 = 1; i3 < str.length() - 1; i3++) {
            if (java.lang.Character.isDigit(str.charAt(i3)) || str.charAt(i3) == '-' || str.charAt(i3) == '$') {
                i2 += 9;
            } else {
                if (!com.dcloud.zxing2.oned.CodaBarReader.arrayContains(CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED, str.charAt(i3))) {
                    throw new java.lang.IllegalArgumentException("Cannot encode : '" + str.charAt(i3) + com.taobao.weex.el.parse.Operators.SINGLE_QUOTE);
                }
                i2 += 10;
            }
        }
        boolean[] zArr = new boolean[i2 + (str.length() - 1)];
        int i4 = 0;
        for (int i5 = 0; i5 < str.length(); i5++) {
            char upperCase3 = java.lang.Character.toUpperCase(str.charAt(i5));
            if (i5 == 0 || i5 == str.length() - 1) {
                if (upperCase3 == '*') {
                    upperCase3 = 'C';
                } else if (upperCase3 == 'E') {
                    upperCase3 = 'D';
                } else if (upperCase3 == 'N') {
                    upperCase3 = 'B';
                } else if (upperCase3 == 'T') {
                    upperCase3 = 'A';
                }
            }
            int i6 = 0;
            while (true) {
                char[] cArr3 = com.dcloud.zxing2.oned.CodaBarReader.ALPHABET;
                if (i6 >= cArr3.length) {
                    i = 0;
                    break;
                }
                if (upperCase3 == cArr3[i6]) {
                    i = com.dcloud.zxing2.oned.CodaBarReader.CHARACTER_ENCODINGS[i6];
                    break;
                }
                i6++;
            }
            int i7 = 0;
            boolean z = true;
            while (true) {
                int i8 = 0;
                while (i7 < 7) {
                    zArr[i4] = z;
                    i4++;
                    if (((i >> (6 - i7)) & 1) == 0 || i8 == 1) {
                        z = !z;
                        i7++;
                    } else {
                        i8++;
                    }
                }
                break;
            }
            if (i5 < str.length() - 1) {
                zArr[i4] = false;
                i4++;
            }
        }
        return zArr;
    }
}
