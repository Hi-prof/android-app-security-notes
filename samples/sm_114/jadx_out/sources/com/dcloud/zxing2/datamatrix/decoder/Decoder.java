package com.dcloud.zxing2.datamatrix.decoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class Decoder {
    private final com.dcloud.zxing2.common.reedsolomon.ReedSolomonDecoder rsDecoder = new com.dcloud.zxing2.common.reedsolomon.ReedSolomonDecoder(com.dcloud.zxing2.common.reedsolomon.GenericGF.DATA_MATRIX_FIELD_256);

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
        int length = zArr.length;
        com.dcloud.zxing2.common.BitMatrix bitMatrix = new com.dcloud.zxing2.common.BitMatrix(length);
        for (int i = 0; i < length; i++) {
            for (int i2 = 0; i2 < length; i2++) {
                if (zArr[i][i2]) {
                    bitMatrix.set(i2, i);
                }
            }
        }
        return decode(bitMatrix);
    }

    public com.dcloud.zxing2.common.DecoderResult decode(com.dcloud.zxing2.common.BitMatrix bitMatrix) throws com.dcloud.zxing2.ChecksumException, com.dcloud.zxing2.FormatException {
        com.dcloud.zxing2.datamatrix.decoder.BitMatrixParser bitMatrixParser = new com.dcloud.zxing2.datamatrix.decoder.BitMatrixParser(bitMatrix);
        com.dcloud.zxing2.datamatrix.decoder.DataBlock[] dataBlocks = com.dcloud.zxing2.datamatrix.decoder.DataBlock.getDataBlocks(bitMatrixParser.readCodewords(), bitMatrixParser.getVersion());
        int length = dataBlocks.length;
        int numDataCodewords = 0;
        for (com.dcloud.zxing2.datamatrix.decoder.DataBlock dataBlock : dataBlocks) {
            numDataCodewords += dataBlock.getNumDataCodewords();
        }
        byte[] bArr = new byte[numDataCodewords];
        for (int i = 0; i < length; i++) {
            com.dcloud.zxing2.datamatrix.decoder.DataBlock dataBlock2 = dataBlocks[i];
            byte[] codewords = dataBlock2.getCodewords();
            int numDataCodewords2 = dataBlock2.getNumDataCodewords();
            correctErrors(codewords, numDataCodewords2);
            for (int i2 = 0; i2 < numDataCodewords2; i2++) {
                bArr[(i2 * length) + i] = codewords[i2];
            }
        }
        return com.dcloud.zxing2.datamatrix.decoder.DecodedBitStreamParser.decode(bArr);
    }
}
