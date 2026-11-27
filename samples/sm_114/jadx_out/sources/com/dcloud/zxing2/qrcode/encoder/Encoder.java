package com.dcloud.zxing2.qrcode.encoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class Encoder {
    private static final int[] ALPHANUMERIC_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};
    static final java.lang.String DEFAULT_BYTE_MODE_ENCODING = "ISO-8859-1";

    /* JADX INFO: renamed from: com.dcloud.zxing2.qrcode.encoder.Encoder$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$dcloud$zxing2$qrcode$decoder$Mode;

        static {
            int[] iArr = new int[com.dcloud.zxing2.qrcode.decoder.Mode.values().length];
            $SwitchMap$com$dcloud$zxing2$qrcode$decoder$Mode = iArr;
            try {
                iArr[com.dcloud.zxing2.qrcode.decoder.Mode.NUMERIC.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dcloud$zxing2$qrcode$decoder$Mode[com.dcloud.zxing2.qrcode.decoder.Mode.ALPHANUMERIC.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dcloud$zxing2$qrcode$decoder$Mode[com.dcloud.zxing2.qrcode.decoder.Mode.BYTE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dcloud$zxing2$qrcode$decoder$Mode[com.dcloud.zxing2.qrcode.decoder.Mode.KANJI.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    private Encoder() {
    }

    static void append8BitBytes(java.lang.String str, com.dcloud.zxing2.common.BitArray bitArray, java.lang.String str2) throws com.dcloud.zxing2.WriterException {
        try {
            for (byte b : str.getBytes(str2)) {
                bitArray.appendBits(b, 8);
            }
        } catch (java.io.UnsupportedEncodingException e) {
            throw new com.dcloud.zxing2.WriterException(e);
        }
    }

    static void appendAlphanumericBytes(java.lang.CharSequence charSequence, com.dcloud.zxing2.common.BitArray bitArray) throws com.dcloud.zxing2.WriterException {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int alphanumericCode = getAlphanumericCode(charSequence.charAt(i));
            if (alphanumericCode == -1) {
                throw new com.dcloud.zxing2.WriterException();
            }
            int i2 = i + 1;
            if (i2 < length) {
                int alphanumericCode2 = getAlphanumericCode(charSequence.charAt(i2));
                if (alphanumericCode2 == -1) {
                    throw new com.dcloud.zxing2.WriterException();
                }
                bitArray.appendBits((alphanumericCode * 45) + alphanumericCode2, 11);
                i += 2;
            } else {
                bitArray.appendBits(alphanumericCode, 6);
                i = i2;
            }
        }
    }

    static void appendBytes(java.lang.String str, com.dcloud.zxing2.qrcode.decoder.Mode mode, com.dcloud.zxing2.common.BitArray bitArray, java.lang.String str2) throws com.dcloud.zxing2.WriterException {
        int i = com.dcloud.zxing2.qrcode.encoder.Encoder.AnonymousClass1.$SwitchMap$com$dcloud$zxing2$qrcode$decoder$Mode[mode.ordinal()];
        if (i == 1) {
            appendNumericBytes(str, bitArray);
            return;
        }
        if (i == 2) {
            appendAlphanumericBytes(str, bitArray);
            return;
        }
        if (i == 3) {
            append8BitBytes(str, bitArray, str2);
        } else if (i == 4) {
            appendKanjiBytes(str, bitArray);
        } else {
            throw new com.dcloud.zxing2.WriterException("Invalid mode: " + mode);
        }
    }

    private static void appendECI(com.dcloud.zxing2.common.CharacterSetECI characterSetECI, com.dcloud.zxing2.common.BitArray bitArray) {
        bitArray.appendBits(com.dcloud.zxing2.qrcode.decoder.Mode.ECI.getBits(), 4);
        bitArray.appendBits(characterSetECI.getValue(), 8);
    }

    static void appendKanjiBytes(java.lang.String str, com.dcloud.zxing2.common.BitArray bitArray) throws com.dcloud.zxing2.WriterException {
        int i;
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            for (int i2 = 0; i2 < length; i2 += 2) {
                int i3 = ((bytes[i2] & 255) << 8) | (bytes[i2 + 1] & 255);
                int i4 = 33088;
                if (i3 >= 33088 && i3 <= 40956) {
                    i = i3 - i4;
                } else if (i3 < 57408 || i3 > 60351) {
                    i = -1;
                } else {
                    i4 = 49472;
                    i = i3 - i4;
                }
                if (i == -1) {
                    throw new com.dcloud.zxing2.WriterException("Invalid byte sequence");
                }
                bitArray.appendBits(((i >> 8) * 192) + (i & 255), 13);
            }
        } catch (java.io.UnsupportedEncodingException e) {
            throw new com.dcloud.zxing2.WriterException(e);
        }
    }

    static void appendLengthInfo(int i, com.dcloud.zxing2.qrcode.decoder.Version version, com.dcloud.zxing2.qrcode.decoder.Mode mode, com.dcloud.zxing2.common.BitArray bitArray) throws com.dcloud.zxing2.WriterException {
        int characterCountBits = mode.getCharacterCountBits(version);
        int i2 = 1 << characterCountBits;
        if (i < i2) {
            bitArray.appendBits(i, characterCountBits);
            return;
        }
        throw new com.dcloud.zxing2.WriterException(i + " is bigger than " + (i2 - 1));
    }

    static void appendModeInfo(com.dcloud.zxing2.qrcode.decoder.Mode mode, com.dcloud.zxing2.common.BitArray bitArray) {
        bitArray.appendBits(mode.getBits(), 4);
    }

    static void appendNumericBytes(java.lang.CharSequence charSequence, com.dcloud.zxing2.common.BitArray bitArray) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int iCharAt = charSequence.charAt(i) - '0';
            int i2 = i + 2;
            if (i2 < length) {
                bitArray.appendBits((iCharAt * 100) + ((charSequence.charAt(i + 1) - '0') * 10) + (charSequence.charAt(i2) - '0'), 10);
                i += 3;
            } else {
                i++;
                if (i < length) {
                    bitArray.appendBits((iCharAt * 10) + (charSequence.charAt(i) - '0'), 7);
                    i = i2;
                } else {
                    bitArray.appendBits(iCharAt, 4);
                }
            }
        }
    }

    private static int calculateMaskPenalty(com.dcloud.zxing2.qrcode.encoder.ByteMatrix byteMatrix) {
        return com.dcloud.zxing2.qrcode.encoder.MaskUtil.applyMaskPenaltyRule1(byteMatrix) + com.dcloud.zxing2.qrcode.encoder.MaskUtil.applyMaskPenaltyRule2(byteMatrix) + com.dcloud.zxing2.qrcode.encoder.MaskUtil.applyMaskPenaltyRule3(byteMatrix) + com.dcloud.zxing2.qrcode.encoder.MaskUtil.applyMaskPenaltyRule4(byteMatrix);
    }

    private static int chooseMaskPattern(com.dcloud.zxing2.common.BitArray bitArray, com.dcloud.zxing2.qrcode.decoder.ErrorCorrectionLevel errorCorrectionLevel, com.dcloud.zxing2.qrcode.decoder.Version version, com.dcloud.zxing2.qrcode.encoder.ByteMatrix byteMatrix) throws com.dcloud.zxing2.WriterException {
        int i = Integer.MAX_VALUE;
        int i2 = -1;
        for (int i3 = 0; i3 < 8; i3++) {
            com.dcloud.zxing2.qrcode.encoder.MatrixUtil.buildMatrix(bitArray, errorCorrectionLevel, version, i3, byteMatrix);
            int iCalculateMaskPenalty = calculateMaskPenalty(byteMatrix);
            if (iCalculateMaskPenalty < i) {
                i2 = i3;
                i = iCalculateMaskPenalty;
            }
        }
        return i2;
    }

    public static com.dcloud.zxing2.qrcode.decoder.Mode chooseMode(java.lang.String str) {
        return chooseMode(str, null);
    }

    private static com.dcloud.zxing2.qrcode.decoder.Version chooseVersion(int i, com.dcloud.zxing2.qrcode.decoder.ErrorCorrectionLevel errorCorrectionLevel) throws com.dcloud.zxing2.WriterException {
        for (int i2 = 1; i2 <= 40; i2++) {
            com.dcloud.zxing2.qrcode.decoder.Version versionForNumber = com.dcloud.zxing2.qrcode.decoder.Version.getVersionForNumber(i2);
            if (versionForNumber.getTotalCodewords() - versionForNumber.getECBlocksForLevel(errorCorrectionLevel).getTotalECCodewords() >= (i + 7) / 8) {
                return versionForNumber;
            }
        }
        throw new com.dcloud.zxing2.WriterException("Data too big");
    }

    public static com.dcloud.zxing2.qrcode.encoder.QRCode encode(java.lang.String str, com.dcloud.zxing2.qrcode.decoder.ErrorCorrectionLevel errorCorrectionLevel) throws com.dcloud.zxing2.WriterException {
        return encode(str, errorCorrectionLevel, null);
    }

    static byte[] generateECBytes(byte[] bArr, int i) {
        int length = bArr.length;
        int[] iArr = new int[length + i];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        new com.dcloud.zxing2.common.reedsolomon.ReedSolomonEncoder(com.dcloud.zxing2.common.reedsolomon.GenericGF.QR_CODE_FIELD_256).encode(iArr, i);
        byte[] bArr2 = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr2[i3] = (byte) iArr[length + i3];
        }
        return bArr2;
    }

    static int getAlphanumericCode(int i) {
        int[] iArr = ALPHANUMERIC_TABLE;
        if (i < iArr.length) {
            return iArr[i];
        }
        return -1;
    }

    static void getNumDataBytesAndNumECBytesForBlockID(int i, int i2, int i3, int i4, int[] iArr, int[] iArr2) throws com.dcloud.zxing2.WriterException {
        if (i4 >= i3) {
            throw new com.dcloud.zxing2.WriterException("Block ID too large");
        }
        int i5 = i % i3;
        int i6 = i3 - i5;
        int i7 = i / i3;
        int i8 = i7 + 1;
        int i9 = i2 / i3;
        int i10 = i9 + 1;
        int i11 = i7 - i9;
        int i12 = i8 - i10;
        if (i11 != i12) {
            throw new com.dcloud.zxing2.WriterException("EC bytes mismatch");
        }
        if (i3 != i6 + i5) {
            throw new com.dcloud.zxing2.WriterException("RS blocks mismatch");
        }
        if (i != ((i9 + i11) * i6) + ((i10 + i12) * i5)) {
            throw new com.dcloud.zxing2.WriterException("Total bytes mismatch");
        }
        if (i4 < i6) {
            iArr[0] = i9;
            iArr2[0] = i11;
        } else {
            iArr[0] = i10;
            iArr2[0] = i12;
        }
    }

    static com.dcloud.zxing2.common.BitArray interleaveWithECBytes(com.dcloud.zxing2.common.BitArray bitArray, int i, int i2, int i3) throws com.dcloud.zxing2.WriterException {
        if (bitArray.getSizeInBytes() != i2) {
            throw new com.dcloud.zxing2.WriterException("Number of bits and data bytes does not match");
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(i3);
        int i4 = 0;
        int i5 = 0;
        int iMax = 0;
        int iMax2 = 0;
        while (i4 < i3) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            int i6 = i;
            int i7 = i2;
            int i8 = i3;
            getNumDataBytesAndNumECBytesForBlockID(i6, i7, i8, i4, iArr, iArr2);
            int i9 = iArr[0];
            byte[] bArr = new byte[i9];
            bitArray.toBytes(i5 * 8, bArr, 0, i9);
            byte[] bArrGenerateECBytes = generateECBytes(bArr, iArr2[0]);
            arrayList.add(new com.dcloud.zxing2.qrcode.encoder.BlockPair(bArr, bArrGenerateECBytes));
            iMax2 = java.lang.Math.max(iMax2, i9);
            iMax = java.lang.Math.max(iMax, bArrGenerateECBytes.length);
            i5 += iArr[0];
            i4++;
            i = i6;
            i2 = i7;
            i3 = i8;
        }
        int i10 = i;
        if (i2 != i5) {
            throw new com.dcloud.zxing2.WriterException("Data bytes does not match offset");
        }
        com.dcloud.zxing2.common.BitArray bitArray2 = new com.dcloud.zxing2.common.BitArray();
        for (int i11 = 0; i11 < iMax2; i11++) {
            int size = arrayList.size();
            int i12 = 0;
            while (i12 < size) {
                java.lang.Object obj = arrayList.get(i12);
                i12++;
                byte[] dataBytes = ((com.dcloud.zxing2.qrcode.encoder.BlockPair) obj).getDataBytes();
                if (i11 < dataBytes.length) {
                    bitArray2.appendBits(dataBytes[i11], 8);
                }
            }
        }
        for (int i13 = 0; i13 < iMax; i13++) {
            int size2 = arrayList.size();
            int i14 = 0;
            while (i14 < size2) {
                java.lang.Object obj2 = arrayList.get(i14);
                i14++;
                byte[] errorCorrectionBytes = ((com.dcloud.zxing2.qrcode.encoder.BlockPair) obj2).getErrorCorrectionBytes();
                if (i13 < errorCorrectionBytes.length) {
                    bitArray2.appendBits(errorCorrectionBytes[i13], 8);
                }
            }
        }
        if (i10 == bitArray2.getSizeInBytes()) {
            return bitArray2;
        }
        throw new com.dcloud.zxing2.WriterException("Interleaving error: " + i10 + " and " + bitArray2.getSizeInBytes() + " differ.");
    }

    private static boolean isOnlyDoubleByteKanji(java.lang.String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i = 0; i < length; i += 2) {
                int i2 = bytes[i] & 255;
                if ((i2 < 129 || i2 > 159) && (i2 < 224 || i2 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (java.io.UnsupportedEncodingException unused) {
            return false;
        }
    }

    static void terminateBits(int i, com.dcloud.zxing2.common.BitArray bitArray) throws com.dcloud.zxing2.WriterException {
        int i2 = i * 8;
        if (bitArray.getSize() > i2) {
            throw new com.dcloud.zxing2.WriterException("data bits cannot fit in the QR Code" + bitArray.getSize() + " > " + i2);
        }
        for (int i3 = 0; i3 < 4 && bitArray.getSize() < i2; i3++) {
            bitArray.appendBit(false);
        }
        int size = bitArray.getSize() & 7;
        if (size > 0) {
            while (size < 8) {
                bitArray.appendBit(false);
                size++;
            }
        }
        int sizeInBytes = i - bitArray.getSizeInBytes();
        for (int i4 = 0; i4 < sizeInBytes; i4++) {
            bitArray.appendBits((i4 & 1) == 0 ? 236 : 17, 8);
        }
        if (bitArray.getSize() != i2) {
            throw new com.dcloud.zxing2.WriterException("Bits size does not equal capacity");
        }
    }

    private static com.dcloud.zxing2.qrcode.decoder.Mode chooseMode(java.lang.String str, java.lang.String str2) {
        if ("Shift_JIS".equals(str2) && isOnlyDoubleByteKanji(str)) {
            return com.dcloud.zxing2.qrcode.decoder.Mode.KANJI;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= '0' && cCharAt <= '9') {
                z2 = true;
            } else {
                if (getAlphanumericCode(cCharAt) == -1) {
                    return com.dcloud.zxing2.qrcode.decoder.Mode.BYTE;
                }
                z = true;
            }
        }
        if (z) {
            return com.dcloud.zxing2.qrcode.decoder.Mode.ALPHANUMERIC;
        }
        return z2 ? com.dcloud.zxing2.qrcode.decoder.Mode.NUMERIC : com.dcloud.zxing2.qrcode.decoder.Mode.BYTE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    public static com.dcloud.zxing2.qrcode.encoder.QRCode encode(java.lang.String str, com.dcloud.zxing2.qrcode.decoder.ErrorCorrectionLevel errorCorrectionLevel, java.util.Map<com.dcloud.zxing2.EncodeHintType, ?> map) throws com.dcloud.zxing2.WriterException {
        java.lang.String string;
        com.dcloud.zxing2.common.CharacterSetECI characterSetECIByName;
        if (map != null) {
            com.dcloud.zxing2.EncodeHintType encodeHintType = com.dcloud.zxing2.EncodeHintType.CHARACTER_SET;
            if (map.containsKey(encodeHintType)) {
                string = map.get(encodeHintType).toString();
            } else {
                string = "ISO-8859-1";
            }
        } else {
            string = "ISO-8859-1";
        }
        com.dcloud.zxing2.qrcode.decoder.Mode modeChooseMode = chooseMode(str, string);
        com.dcloud.zxing2.common.BitArray bitArray = new com.dcloud.zxing2.common.BitArray();
        com.dcloud.zxing2.qrcode.decoder.Mode mode = com.dcloud.zxing2.qrcode.decoder.Mode.BYTE;
        if (modeChooseMode == mode && !"ISO-8859-1".equals(string) && (characterSetECIByName = com.dcloud.zxing2.common.CharacterSetECI.getCharacterSetECIByName(string)) != null) {
            appendECI(characterSetECIByName, bitArray);
        }
        appendModeInfo(modeChooseMode, bitArray);
        com.dcloud.zxing2.common.BitArray bitArray2 = new com.dcloud.zxing2.common.BitArray();
        appendBytes(str, modeChooseMode, bitArray2, string);
        com.dcloud.zxing2.qrcode.decoder.Version versionChooseVersion = chooseVersion(bitArray.getSize() + modeChooseMode.getCharacterCountBits(chooseVersion(bitArray.getSize() + modeChooseMode.getCharacterCountBits(com.dcloud.zxing2.qrcode.decoder.Version.getVersionForNumber(1)) + bitArray2.getSize(), errorCorrectionLevel)) + bitArray2.getSize(), errorCorrectionLevel);
        com.dcloud.zxing2.common.BitArray bitArray3 = new com.dcloud.zxing2.common.BitArray();
        bitArray3.appendBitArray(bitArray);
        appendLengthInfo(modeChooseMode == mode ? bitArray2.getSizeInBytes() : str.length(), versionChooseVersion, modeChooseMode, bitArray3);
        bitArray3.appendBitArray(bitArray2);
        com.dcloud.zxing2.qrcode.decoder.Version.ECBlocks eCBlocksForLevel = versionChooseVersion.getECBlocksForLevel(errorCorrectionLevel);
        int totalCodewords = versionChooseVersion.getTotalCodewords() - eCBlocksForLevel.getTotalECCodewords();
        terminateBits(totalCodewords, bitArray3);
        com.dcloud.zxing2.common.BitArray bitArrayInterleaveWithECBytes = interleaveWithECBytes(bitArray3, versionChooseVersion.getTotalCodewords(), totalCodewords, eCBlocksForLevel.getNumBlocks());
        com.dcloud.zxing2.qrcode.encoder.QRCode qRCode = new com.dcloud.zxing2.qrcode.encoder.QRCode();
        qRCode.setECLevel(errorCorrectionLevel);
        qRCode.setMode(modeChooseMode);
        qRCode.setVersion(versionChooseVersion);
        int dimensionForVersion = versionChooseVersion.getDimensionForVersion();
        com.dcloud.zxing2.qrcode.encoder.ByteMatrix byteMatrix = new com.dcloud.zxing2.qrcode.encoder.ByteMatrix(dimensionForVersion, dimensionForVersion);
        int iChooseMaskPattern = chooseMaskPattern(bitArrayInterleaveWithECBytes, errorCorrectionLevel, versionChooseVersion, byteMatrix);
        qRCode.setMaskPattern(iChooseMaskPattern);
        com.dcloud.zxing2.qrcode.encoder.MatrixUtil.buildMatrix(bitArrayInterleaveWithECBytes, errorCorrectionLevel, versionChooseVersion, iChooseMaskPattern, byteMatrix);
        qRCode.setMatrix(byteMatrix);
        return qRCode;
    }
}
