package com.dcloud.zxing2.oned;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class UPCEANExtension5Support {
    private static final int[] CHECK_DIGIT_ENCODINGS = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};
    private final int[] decodeMiddleCounters = new int[4];
    private final java.lang.StringBuilder decodeRowStringBuffer = new java.lang.StringBuilder();

    UPCEANExtension5Support() {
    }

    private static int determineCheckDigit(int i) throws com.dcloud.zxing2.NotFoundException {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i == CHECK_DIGIT_ENCODINGS[i2]) {
                return i2;
            }
        }
        throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
    }

    private static int extensionChecksum(java.lang.CharSequence charSequence) {
        int length = charSequence.length();
        int iCharAt = 0;
        for (int i = length - 2; i >= 0; i -= 2) {
            iCharAt += charSequence.charAt(i) - '0';
        }
        int iCharAt2 = iCharAt * 3;
        for (int i2 = length - 1; i2 >= 0; i2 -= 2) {
            iCharAt2 += charSequence.charAt(i2) - '0';
        }
        return (iCharAt2 * 3) % 10;
    }

    private static java.lang.String parseExtension5String(java.lang.String str) {
        java.lang.String str2;
        java.lang.String strValueOf;
        char cCharAt = str.charAt(0);
        if (cCharAt == '0') {
            str2 = "£";
        } else if (cCharAt != '5') {
            str2 = "";
            if (cCharAt == '9') {
                if ("90000".equals(str)) {
                    return null;
                }
                if ("99991".equals(str)) {
                    return "0.00";
                }
                if ("99990".equals(str)) {
                    return "Used";
                }
            }
        } else {
            str2 = com.taobao.weex.el.parse.Operators.DOLLAR_STR;
        }
        int i = java.lang.Integer.parseInt(str.substring(1));
        java.lang.String strValueOf2 = java.lang.String.valueOf(i / 100);
        int i2 = i % 100;
        if (i2 < 10) {
            strValueOf = com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT + i2;
        } else {
            strValueOf = java.lang.String.valueOf(i2);
        }
        return str2 + strValueOf2 + com.taobao.weex.el.parse.Operators.DOT + strValueOf;
    }

    private static java.util.Map<com.dcloud.zxing2.ResultMetadataType, java.lang.Object> parseExtensionString(java.lang.String str) {
        java.lang.String extension5String;
        if (str.length() != 5 || (extension5String = parseExtension5String(str)) == null) {
            return null;
        }
        java.util.EnumMap enumMap = new java.util.EnumMap(com.dcloud.zxing2.ResultMetadataType.class);
        enumMap.put(com.dcloud.zxing2.ResultMetadataType.SUGGESTED_PRICE, extension5String);
        return enumMap;
    }

    int decodeMiddle(com.dcloud.zxing2.common.BitArray bitArray, int[] iArr, java.lang.StringBuilder sb) throws com.dcloud.zxing2.NotFoundException {
        int[] iArr2 = this.decodeMiddleCounters;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int size = bitArray.getSize();
        int nextUnset = iArr[1];
        int i = 0;
        for (int i2 = 0; i2 < 5 && nextUnset < size; i2++) {
            int iDecodeDigit = com.dcloud.zxing2.oned.UPCEANReader.decodeDigit(bitArray, iArr2, nextUnset, com.dcloud.zxing2.oned.UPCEANReader.L_AND_G_PATTERNS);
            sb.append((char) ((iDecodeDigit % 10) + 48));
            for (int i3 : iArr2) {
                nextUnset += i3;
            }
            if (iDecodeDigit >= 10) {
                i |= 1 << (4 - i2);
            }
            if (i2 != 4) {
                nextUnset = bitArray.getNextUnset(bitArray.getNextSet(nextUnset));
            }
        }
        if (sb.length() != 5) {
            throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
        }
        if (extensionChecksum(sb.toString()) == determineCheckDigit(i)) {
            return nextUnset;
        }
        throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
    }

    com.dcloud.zxing2.Result decodeRow(int i, com.dcloud.zxing2.common.BitArray bitArray, int[] iArr) throws com.dcloud.zxing2.NotFoundException {
        java.lang.StringBuilder sb = this.decodeRowStringBuffer;
        sb.setLength(0);
        int iDecodeMiddle = decodeMiddle(bitArray, iArr, sb);
        java.lang.String string = sb.toString();
        java.util.Map<com.dcloud.zxing2.ResultMetadataType, java.lang.Object> extensionString = parseExtensionString(string);
        float f = i;
        com.dcloud.zxing2.Result result = new com.dcloud.zxing2.Result(string, null, new com.dcloud.zxing2.ResultPoint[]{new com.dcloud.zxing2.ResultPoint((iArr[0] + iArr[1]) / 2.0f, f), new com.dcloud.zxing2.ResultPoint(iDecodeMiddle, f)}, com.dcloud.zxing2.BarcodeFormat.UPC_EAN_EXTENSION);
        if (extensionString != null) {
            result.putAllMetadata(extensionString);
        }
        return result;
    }
}
