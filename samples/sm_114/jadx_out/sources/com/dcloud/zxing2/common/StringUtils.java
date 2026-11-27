package com.dcloud.zxing2.common;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class StringUtils {
    private static final boolean ASSUME_SHIFT_JIS;
    private static final java.lang.String EUC_JP = "EUC_JP";
    public static final java.lang.String GB2312 = "GB2312";
    private static final java.lang.String ISO88591 = "ISO8859_1";
    private static final java.lang.String PLATFORM_DEFAULT_ENCODING;
    public static final java.lang.String SHIFT_JIS = "SJIS";
    public static final java.lang.String UTF8 = "UTF-8";

    static {
        java.lang.String strName = java.nio.charset.Charset.defaultCharset().name();
        PLATFORM_DEFAULT_ENCODING = strName;
        ASSUME_SHIFT_JIS = SHIFT_JIS.equalsIgnoreCase(strName) || EUC_JP.equalsIgnoreCase(strName);
    }

    private StringUtils() {
    }

    /* JADX WARN: Code duplicated, block: B:98:0x00ff  */
    public static java.lang.String guessEncoding(byte[] bArr, java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) {
        boolean z;
        byte[] bArr2 = bArr;
        if (map != null) {
            com.dcloud.zxing2.DecodeHintType decodeHintType = com.dcloud.zxing2.DecodeHintType.CHARACTER_SET;
            if (map.containsKey(decodeHintType)) {
                return map.get(decodeHintType).toString();
            }
        }
        if (map != null && map.containsKey(com.dcloud.zxing2.DecodeHintType.autoDecodeCharset)) {
            return guessEncodingSmart(bArr2);
        }
        int length = bArr2.length;
        boolean z2 = true;
        int i = 0;
        boolean z3 = bArr2.length > 3 && bArr2[0] == -17 && bArr2[1] == -69 && bArr2[2] == -65;
        int i2 = 0;
        boolean z4 = true;
        boolean z5 = true;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i3 < length && (z2 || z4 || z5)) {
            byte b = bArr2[i3];
            int i13 = b & 255;
            if (z5) {
                if (i4 <= 0) {
                    z = z3;
                    if ((b & kotlin.jvm.internal.ByteCompanionObject.MIN_VALUE) != 0) {
                        if ((b & 64) != 0) {
                            int i14 = i4 + 1;
                            if ((b & org.mozilla.universalchardet.prober.HebrewProber.SPACE) == 0) {
                                i6++;
                            } else {
                                i14 = i4 + 2;
                                if ((b & 16) == 0) {
                                    i7++;
                                } else {
                                    i4 += 3;
                                    if ((b & 8) == 0) {
                                        i8++;
                                    }
                                }
                            }
                            i4 = i14;
                        }
                    }
                } else if ((b & kotlin.jvm.internal.ByteCompanionObject.MIN_VALUE) == 0) {
                    z = z3;
                } else {
                    i4--;
                    z = z3;
                }
                z5 = false;
            } else {
                z = z3;
            }
            if (z2) {
                if (i13 > 127 && i13 < 160) {
                    z2 = false;
                } else if (i13 > 159 && (i13 < 192 || i13 == 215 || i13 == 247)) {
                    i10++;
                }
            }
            if (z4) {
                if (i5 > 0) {
                    if (i13 < 64 || i13 == 127 || i13 > 252) {
                        z4 = false;
                    } else {
                        i5--;
                    }
                } else if (i13 == 128 || i13 == 160 || i13 > 239) {
                    z4 = false;
                } else if (i13 <= 160 || i13 >= 224) {
                    if (i13 > 127) {
                        i5++;
                        int i15 = i11 + 1;
                        if (i15 > i) {
                            i = i15;
                            i11 = i;
                        } else {
                            i11 = i15;
                        }
                    } else {
                        i11 = 0;
                    }
                    i12 = 0;
                } else {
                    i2++;
                    int i16 = i12 + 1;
                    if (i16 > i9) {
                        i9 = i16;
                        i12 = i9;
                    } else {
                        i12 = i16;
                    }
                    i11 = 0;
                }
            }
            i3++;
            bArr2 = bArr;
            z3 = z;
        }
        boolean z6 = z3;
        if (z5 && i4 > 0) {
            z5 = false;
        }
        if (z4 && i5 > 0) {
            z4 = false;
        }
        if (z5 && (z6 || i6 + i7 + i8 > 0)) {
            return "UTF-8";
        }
        if (z4 && (ASSUME_SHIFT_JIS || i9 >= 3 || i >= 3)) {
            return SHIFT_JIS;
        }
        if (z2 && z4) {
            return (!(i9 == 2 && i2 == 2) && i10 * 10 < length) ? ISO88591 : SHIFT_JIS;
        }
        if (z2) {
            return ISO88591;
        }
        if (z4) {
            return SHIFT_JIS;
        }
        return z5 ? "UTF-8" : PLATFORM_DEFAULT_ENCODING;
    }

    public static java.lang.String guessEncodingSmart(byte[] bArr) {
        org.mozilla.universalchardet.UniversalDetector universalDetector = new org.mozilla.universalchardet.UniversalDetector();
        universalDetector.handleData(bArr);
        universalDetector.dataEnd();
        java.lang.String detectedCharset = universalDetector.getDetectedCharset();
        universalDetector.reset();
        return !android.text.TextUtils.isEmpty(detectedCharset) ? detectedCharset : GB2312;
    }
}
