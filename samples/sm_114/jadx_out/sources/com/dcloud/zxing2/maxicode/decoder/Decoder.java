package com.dcloud.zxing2.maxicode.decoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class Decoder {
    private static final int ALL = 0;
    private static final int EVEN = 1;
    private static final int ODD = 2;
    private final com.dcloud.zxing2.common.reedsolomon.ReedSolomonDecoder rsDecoder = new com.dcloud.zxing2.common.reedsolomon.ReedSolomonDecoder(com.dcloud.zxing2.common.reedsolomon.GenericGF.MAXICODE_FIELD_64);

    private void correctErrors(byte[] bArr, int i, int i2, int i3, int i4) throws com.dcloud.zxing2.ChecksumException {
        int i5 = i2 + i3;
        int i6 = i4 == 0 ? 1 : 2;
        int[] iArr = new int[i5 / i6];
        for (int i7 = 0; i7 < i5; i7++) {
            if (i4 == 0 || i7 % 2 == i4 - 1) {
                iArr[i7 / i6] = bArr[i7 + i] & 255;
            }
        }
        try {
            this.rsDecoder.decode(iArr, i3 / i6);
            for (int i8 = 0; i8 < i2; i8++) {
                if (i4 == 0 || i8 % 2 == i4 - 1) {
                    bArr[i8 + i] = (byte) iArr[i8 / i6];
                }
            }
        } catch (com.dcloud.zxing2.common.reedsolomon.ReedSolomonException unused) {
            throw com.dcloud.zxing2.ChecksumException.getChecksumInstance();
        }
    }

    public com.dcloud.zxing2.common.DecoderResult decode(com.dcloud.zxing2.common.BitMatrix bitMatrix) throws com.dcloud.zxing2.ChecksumException, com.dcloud.zxing2.FormatException {
        return decode(bitMatrix, null);
    }

    public com.dcloud.zxing2.common.DecoderResult decode(com.dcloud.zxing2.common.BitMatrix bitMatrix, java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) throws com.dcloud.zxing2.ChecksumException, com.dcloud.zxing2.FormatException {
        byte[] bArr;
        byte[] codewords = new com.dcloud.zxing2.maxicode.decoder.BitMatrixParser(bitMatrix).readCodewords();
        correctErrors(codewords, 0, 10, 10, 0);
        int i = codewords[0] & 15;
        if (i == 2 || i == 3 || i == 4) {
            correctErrors(codewords, 20, 84, 40, 1);
            correctErrors(codewords, 20, 84, 40, 2);
            bArr = new byte[94];
        } else {
            if (i != 5) {
                throw com.dcloud.zxing2.FormatException.getFormatInstance();
            }
            correctErrors(codewords, 20, 68, 56, 1);
            correctErrors(codewords, 20, 68, 56, 2);
            bArr = new byte[78];
        }
        java.lang.System.arraycopy(codewords, 0, bArr, 0, 10);
        java.lang.System.arraycopy(codewords, 20, bArr, 10, bArr.length - 10);
        return com.dcloud.zxing2.maxicode.decoder.DecodedBitStreamParser.decode(bArr, i);
    }
}
