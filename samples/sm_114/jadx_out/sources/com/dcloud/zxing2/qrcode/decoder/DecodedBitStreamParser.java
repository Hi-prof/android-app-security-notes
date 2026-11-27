package com.dcloud.zxing2.qrcode.decoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class DecodedBitStreamParser {
    private static final char[] ALPHANUMERIC_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ', '$', com.taobao.weex.utils.WXUtils.PERCENT, '*', '+', '-', com.taobao.weex.el.parse.Operators.DOT, '/', com.taobao.weex.el.parse.Operators.CONDITION_IF_MIDDLE};
    private static final int GB2312_SUBSET = 1;

    private DecodedBitStreamParser() {
    }

    static com.dcloud.zxing2.common.DecoderResult decode(byte[] bArr, com.dcloud.zxing2.qrcode.decoder.Version version, com.dcloud.zxing2.qrcode.decoder.ErrorCorrectionLevel errorCorrectionLevel, java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) throws com.dcloud.zxing2.FormatException {
        byte[] bArr2 = bArr;
        com.dcloud.zxing2.common.BitSource bitSource = new com.dcloud.zxing2.common.BitSource(bArr2);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(50);
        java.util.ArrayList arrayList = new java.util.ArrayList(1);
        java.lang.String strDecodeByteSegment = "";
        com.dcloud.zxing2.common.CharacterSetECI characterSetECIByValue = null;
        int bits = -1;
        int bits2 = -1;
        boolean z = false;
        while (true) {
            try {
                com.dcloud.zxing2.qrcode.decoder.Mode modeForBits = bitSource.available() < 4 ? com.dcloud.zxing2.qrcode.decoder.Mode.TERMINATOR : com.dcloud.zxing2.qrcode.decoder.Mode.forBits(bitSource.readBits(4));
                com.dcloud.zxing2.qrcode.decoder.Mode mode = com.dcloud.zxing2.qrcode.decoder.Mode.TERMINATOR;
                if (modeForBits != mode) {
                    if (modeForBits == com.dcloud.zxing2.qrcode.decoder.Mode.FNC1_FIRST_POSITION || modeForBits == com.dcloud.zxing2.qrcode.decoder.Mode.FNC1_SECOND_POSITION) {
                        z = true;
                    } else if (modeForBits == com.dcloud.zxing2.qrcode.decoder.Mode.STRUCTURED_APPEND) {
                        if (bitSource.available() < 16) {
                            throw com.dcloud.zxing2.FormatException.getFormatInstance();
                        }
                        bits = bitSource.readBits(8);
                        bits2 = bitSource.readBits(8);
                    } else if (modeForBits == com.dcloud.zxing2.qrcode.decoder.Mode.ECI) {
                        characterSetECIByValue = com.dcloud.zxing2.common.CharacterSetECI.getCharacterSetECIByValue(parseECIValue(bitSource));
                        if (characterSetECIByValue == null) {
                            throw com.dcloud.zxing2.FormatException.getFormatInstance();
                        }
                    } else if (modeForBits == com.dcloud.zxing2.qrcode.decoder.Mode.HANZI) {
                        int bits3 = bitSource.readBits(4);
                        int bits4 = bitSource.readBits(modeForBits.getCharacterCountBits(version));
                        if (bits3 == 1) {
                            decodeHanziSegment(bitSource, sb, bits4);
                        }
                    } else {
                        int bits5 = bitSource.readBits(modeForBits.getCharacterCountBits(version));
                        if (modeForBits == com.dcloud.zxing2.qrcode.decoder.Mode.NUMERIC) {
                            decodeNumericSegment(bitSource, sb, bits5);
                        } else if (modeForBits == com.dcloud.zxing2.qrcode.decoder.Mode.ALPHANUMERIC) {
                            decodeAlphanumericSegment(bitSource, sb, bits5, z);
                        } else if (modeForBits == com.dcloud.zxing2.qrcode.decoder.Mode.BYTE) {
                            strDecodeByteSegment = decodeByteSegment(bitSource, sb, bits5, characterSetECIByValue, arrayList, map);
                        } else {
                            if (modeForBits != com.dcloud.zxing2.qrcode.decoder.Mode.KANJI) {
                                throw com.dcloud.zxing2.FormatException.getFormatInstance();
                            }
                            decodeKanjiSegment(bitSource, sb, bits5);
                        }
                    }
                }
                if (modeForBits == mode) {
                    java.lang.String string = sb.toString();
                    if (arrayList.isEmpty()) {
                        arrayList = null;
                    }
                    com.dcloud.zxing2.common.DecoderResult decoderResult = new com.dcloud.zxing2.common.DecoderResult(bArr2, string, arrayList, errorCorrectionLevel != null ? errorCorrectionLevel.toString() : null, bits, bits2);
                    decoderResult.textCharset = strDecodeByteSegment;
                    return decoderResult;
                }
                bArr2 = bArr;
            } catch (java.lang.IllegalArgumentException unused) {
                throw com.dcloud.zxing2.FormatException.getFormatInstance();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006a  */
    private static void decodeAlphanumericSegment(com.dcloud.zxing2.common.BitSource bitSource, java.lang.StringBuilder sb, int i, boolean z) throws com.dcloud.zxing2.FormatException {
        while (i > 1) {
            if (bitSource.available() < 11) {
                throw com.dcloud.zxing2.FormatException.getFormatInstance();
            }
            int bits = bitSource.readBits(11);
            sb.append(toAlphaNumericChar(bits / 45));
            sb.append(toAlphaNumericChar(bits % 45));
            i -= 2;
        }
        if (i == 1) {
            if (bitSource.available() < 6) {
                throw com.dcloud.zxing2.FormatException.getFormatInstance();
            }
            sb.append(toAlphaNumericChar(bitSource.readBits(6)));
        }
        if (z) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1) {
                        int i2 = length + 1;
                        if (sb.charAt(i2) == '%') {
                            sb.deleteCharAt(i2);
                        } else {
                            sb.setCharAt(length, (char) 29);
                        }
                    } else {
                        sb.setCharAt(length, (char) 29);
                    }
                }
            }
        }
    }

    private static java.lang.String decodeByteSegment(com.dcloud.zxing2.common.BitSource bitSource, java.lang.StringBuilder sb, int i, com.dcloud.zxing2.common.CharacterSetECI characterSetECI, java.util.Collection<byte[]> collection, java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) throws com.dcloud.zxing2.FormatException {
        if (i * 8 > bitSource.available()) {
            throw com.dcloud.zxing2.FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) bitSource.readBits(8);
        }
        java.lang.String strGuessEncoding = characterSetECI == null ? com.dcloud.zxing2.common.StringUtils.guessEncoding(bArr, map) : characterSetECI.name();
        try {
            sb.append(new java.lang.String(bArr, strGuessEncoding));
            collection.add(bArr);
            return strGuessEncoding;
        } catch (java.io.UnsupportedEncodingException unused) {
            throw com.dcloud.zxing2.FormatException.getFormatInstance();
        }
    }

    private static void decodeHanziSegment(com.dcloud.zxing2.common.BitSource bitSource, java.lang.StringBuilder sb, int i) throws com.dcloud.zxing2.FormatException {
        if (i * 13 > bitSource.available()) {
            throw com.dcloud.zxing2.FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i * 2];
        int i2 = 0;
        while (i > 0) {
            int bits = bitSource.readBits(13);
            int i3 = (bits % 96) | ((bits / 96) << 8);
            int i4 = i3 + (i3 < 959 ? 41377 : 42657);
            bArr[i2] = (byte) ((i4 >> 8) & 255);
            bArr[i2 + 1] = (byte) (i4 & 255);
            i2 += 2;
            i--;
        }
        try {
            sb.append(new java.lang.String(bArr, com.dcloud.zxing2.common.StringUtils.GB2312));
        } catch (java.io.UnsupportedEncodingException unused) {
            throw com.dcloud.zxing2.FormatException.getFormatInstance();
        }
    }

    private static void decodeKanjiSegment(com.dcloud.zxing2.common.BitSource bitSource, java.lang.StringBuilder sb, int i) throws com.dcloud.zxing2.FormatException {
        if (i * 13 > bitSource.available()) {
            throw com.dcloud.zxing2.FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i * 2];
        int i2 = 0;
        while (i > 0) {
            int bits = bitSource.readBits(13);
            int i3 = (bits % 192) | ((bits / 192) << 8);
            int i4 = i3 + (i3 < 7936 ? 33088 : 49472);
            bArr[i2] = (byte) (i4 >> 8);
            bArr[i2 + 1] = (byte) i4;
            i2 += 2;
            i--;
        }
        try {
            sb.append(new java.lang.String(bArr, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException unused) {
            throw com.dcloud.zxing2.FormatException.getFormatInstance();
        }
    }

    private static void decodeNumericSegment(com.dcloud.zxing2.common.BitSource bitSource, java.lang.StringBuilder sb, int i) throws com.dcloud.zxing2.FormatException {
        while (i >= 3) {
            if (bitSource.available() < 10) {
                throw com.dcloud.zxing2.FormatException.getFormatInstance();
            }
            int bits = bitSource.readBits(10);
            if (bits >= 1000) {
                throw com.dcloud.zxing2.FormatException.getFormatInstance();
            }
            sb.append(toAlphaNumericChar(bits / 100));
            sb.append(toAlphaNumericChar((bits / 10) % 10));
            sb.append(toAlphaNumericChar(bits % 10));
            i -= 3;
        }
        if (i == 2) {
            if (bitSource.available() < 7) {
                throw com.dcloud.zxing2.FormatException.getFormatInstance();
            }
            int bits2 = bitSource.readBits(7);
            if (bits2 >= 100) {
                throw com.dcloud.zxing2.FormatException.getFormatInstance();
            }
            sb.append(toAlphaNumericChar(bits2 / 10));
            sb.append(toAlphaNumericChar(bits2 % 10));
            return;
        }
        if (i == 1) {
            if (bitSource.available() < 4) {
                throw com.dcloud.zxing2.FormatException.getFormatInstance();
            }
            int bits3 = bitSource.readBits(4);
            if (bits3 >= 10) {
                throw com.dcloud.zxing2.FormatException.getFormatInstance();
            }
            sb.append(toAlphaNumericChar(bits3));
        }
    }

    private static int parseECIValue(com.dcloud.zxing2.common.BitSource bitSource) throws com.dcloud.zxing2.FormatException {
        int bits = bitSource.readBits(8);
        if ((bits & 128) == 0) {
            return bits & kotlinx.coroutines.scheduling.WorkQueueKt.MASK;
        }
        if ((bits & 192) == 128) {
            return bitSource.readBits(8) | ((bits & 63) << 8);
        }
        if ((bits & 224) == 192) {
            return bitSource.readBits(16) | ((bits & 31) << 16);
        }
        throw com.dcloud.zxing2.FormatException.getFormatInstance();
    }

    private static char toAlphaNumericChar(int i) throws com.dcloud.zxing2.FormatException {
        char[] cArr = ALPHANUMERIC_CHARS;
        if (i < cArr.length) {
            return cArr[i];
        }
        throw com.dcloud.zxing2.FormatException.getFormatInstance();
    }
}
