package com.dcloud.zxing2.oned;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class UPCEANExtension2Support {
    private final int[] decodeMiddleCounters = new int[4];
    private final java.lang.StringBuilder decodeRowStringBuffer = new java.lang.StringBuilder();

    UPCEANExtension2Support() {
    }

    private static java.util.Map<com.dcloud.zxing2.ResultMetadataType, java.lang.Object> parseExtensionString(java.lang.String str) {
        if (str.length() != 2) {
            return null;
        }
        java.util.EnumMap enumMap = new java.util.EnumMap(com.dcloud.zxing2.ResultMetadataType.class);
        enumMap.put(com.dcloud.zxing2.ResultMetadataType.ISSUE_NUMBER, java.lang.Integer.valueOf(str));
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
        for (int i2 = 0; i2 < 2 && nextUnset < size; i2++) {
            int iDecodeDigit = com.dcloud.zxing2.oned.UPCEANReader.decodeDigit(bitArray, iArr2, nextUnset, com.dcloud.zxing2.oned.UPCEANReader.L_AND_G_PATTERNS);
            sb.append((char) ((iDecodeDigit % 10) + 48));
            for (int i3 : iArr2) {
                nextUnset += i3;
            }
            if (iDecodeDigit >= 10) {
                i |= 1 << (1 - i2);
            }
            if (i2 != 1) {
                nextUnset = bitArray.getNextUnset(bitArray.getNextSet(nextUnset));
            }
        }
        if (sb.length() != 2) {
            throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
        }
        if (java.lang.Integer.parseInt(sb.toString()) % 4 == i) {
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
