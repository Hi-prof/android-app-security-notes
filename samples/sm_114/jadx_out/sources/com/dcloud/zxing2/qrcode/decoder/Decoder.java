package com.dcloud.zxing2.qrcode.decoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class Decoder {
    private final com.dcloud.zxing2.common.reedsolomon.ReedSolomonDecoder rsDecoder = new com.dcloud.zxing2.common.reedsolomon.ReedSolomonDecoder(com.dcloud.zxing2.common.reedsolomon.GenericGF.QR_CODE_FIELD_256);

    private void correctErrors(byte[] bArr, int i) throws com.dcloud.zxing2.ChecksumException {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        try {
            this.rsDecoder.decode(iArr, bArr.length - i);
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3] = (byte) iArr[i3];
            }
        } catch (com.dcloud.zxing2.common.reedsolomon.ReedSolomonException unused) {
            throw com.dcloud.zxing2.ChecksumException.getChecksumInstance();
        }
    }

    public com.dcloud.zxing2.common.DecoderResult decode(boolean[][] zArr) throws com.dcloud.zxing2.ChecksumException, com.dcloud.zxing2.FormatException {
        return decode(zArr, (java.util.Map<com.dcloud.zxing2.DecodeHintType, ?>) null);
    }

    public com.dcloud.zxing2.common.DecoderResult decode(boolean[][] zArr, java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) throws com.dcloud.zxing2.ChecksumException, com.dcloud.zxing2.FormatException {
        int length = zArr.length;
        com.dcloud.zxing2.common.BitMatrix bitMatrix = new com.dcloud.zxing2.common.BitMatrix(length);
        for (int i = 0; i < length; i++) {
            for (int i2 = 0; i2 < length; i2++) {
                if (zArr[i][i2]) {
                    bitMatrix.set(i2, i);
                }
            }
        }
        return decode(bitMatrix, map);
    }

    public com.dcloud.zxing2.common.DecoderResult decode(com.dcloud.zxing2.common.BitMatrix bitMatrix) throws com.dcloud.zxing2.ChecksumException, com.dcloud.zxing2.FormatException {
        return decode(bitMatrix, (java.util.Map<com.dcloud.zxing2.DecodeHintType, ?>) null);
    }

    public com.dcloud.zxing2.common.DecoderResult decode(com.dcloud.zxing2.common.BitMatrix bitMatrix, java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) throws com.dcloud.zxing2.ChecksumException, com.dcloud.zxing2.FormatException {
        com.dcloud.zxing2.ChecksumException e;
        com.dcloud.zxing2.qrcode.decoder.BitMatrixParser bitMatrixParser = new com.dcloud.zxing2.qrcode.decoder.BitMatrixParser(bitMatrix);
        com.dcloud.zxing2.FormatException formatException = null;
        try {
            return decode(bitMatrixParser, map);
        } catch (com.dcloud.zxing2.ChecksumException e2) {
            e = e2;
            try {
                bitMatrixParser.remask();
                bitMatrixParser.setMirror(true);
                bitMatrixParser.readVersion();
                bitMatrixParser.readFormatInformation();
                bitMatrixParser.mirror();
                com.dcloud.zxing2.common.DecoderResult decoderResultDecode = decode(bitMatrixParser, map);
                decoderResultDecode.setOther(new com.dcloud.zxing2.qrcode.decoder.QRCodeDecoderMetaData(true));
                return decoderResultDecode;
            } catch (com.dcloud.zxing2.ChecksumException | com.dcloud.zxing2.FormatException e3) {
                if (formatException != null) {
                    throw formatException;
                }
                if (e != null) {
                    throw e;
                }
                throw e3;
            }
        } catch (com.dcloud.zxing2.FormatException e4) {
            e = null;
            formatException = e4;
            bitMatrixParser.remask();
            bitMatrixParser.setMirror(true);
            bitMatrixParser.readVersion();
            bitMatrixParser.readFormatInformation();
            bitMatrixParser.mirror();
            com.dcloud.zxing2.common.DecoderResult decoderResultDecode2 = decode(bitMatrixParser, map);
            decoderResultDecode2.setOther(new com.dcloud.zxing2.qrcode.decoder.QRCodeDecoderMetaData(true));
            return decoderResultDecode2;
        }
    }

    private com.dcloud.zxing2.common.DecoderResult decode(com.dcloud.zxing2.qrcode.decoder.BitMatrixParser bitMatrixParser, java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) throws com.dcloud.zxing2.ChecksumException, com.dcloud.zxing2.FormatException {
        com.dcloud.zxing2.qrcode.decoder.Version version = bitMatrixParser.readVersion();
        com.dcloud.zxing2.qrcode.decoder.ErrorCorrectionLevel errorCorrectionLevel = bitMatrixParser.readFormatInformation().getErrorCorrectionLevel();
        com.dcloud.zxing2.qrcode.decoder.DataBlock[] dataBlocks = com.dcloud.zxing2.qrcode.decoder.DataBlock.getDataBlocks(bitMatrixParser.readCodewords(), version, errorCorrectionLevel);
        int numDataCodewords = 0;
        for (com.dcloud.zxing2.qrcode.decoder.DataBlock dataBlock : dataBlocks) {
            numDataCodewords += dataBlock.getNumDataCodewords();
        }
        byte[] bArr = new byte[numDataCodewords];
        int i = 0;
        for (com.dcloud.zxing2.qrcode.decoder.DataBlock dataBlock2 : dataBlocks) {
            byte[] codewords = dataBlock2.getCodewords();
            int numDataCodewords2 = dataBlock2.getNumDataCodewords();
            correctErrors(codewords, numDataCodewords2);
            int i2 = 0;
            while (i2 < numDataCodewords2) {
                bArr[i] = codewords[i2];
                i2++;
                i++;
            }
        }
        return com.dcloud.zxing2.qrcode.decoder.DecodedBitStreamParser.decode(bArr, version, errorCorrectionLevel, map);
    }
}
