package com.dcloud.zxing2.qrcode.decoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class DataBlock {
    private final byte[] codewords;
    private final int numDataCodewords;

    private DataBlock(int i, byte[] bArr) {
        this.numDataCodewords = i;
        this.codewords = bArr;
    }

    static com.dcloud.zxing2.qrcode.decoder.DataBlock[] getDataBlocks(byte[] bArr, com.dcloud.zxing2.qrcode.decoder.Version version, com.dcloud.zxing2.qrcode.decoder.ErrorCorrectionLevel errorCorrectionLevel) {
        if (bArr.length != version.getTotalCodewords()) {
            throw new java.lang.IllegalArgumentException();
        }
        com.dcloud.zxing2.qrcode.decoder.Version.ECBlocks eCBlocksForLevel = version.getECBlocksForLevel(errorCorrectionLevel);
        com.dcloud.zxing2.qrcode.decoder.Version.ECB[] eCBlocks = eCBlocksForLevel.getECBlocks();
        int count = 0;
        for (com.dcloud.zxing2.qrcode.decoder.Version.ECB ecb : eCBlocks) {
            count += ecb.getCount();
        }
        com.dcloud.zxing2.qrcode.decoder.DataBlock[] dataBlockArr = new com.dcloud.zxing2.qrcode.decoder.DataBlock[count];
        int i = 0;
        for (com.dcloud.zxing2.qrcode.decoder.Version.ECB ecb2 : eCBlocks) {
            int i2 = 0;
            while (i2 < ecb2.getCount()) {
                int dataCodewords = ecb2.getDataCodewords();
                dataBlockArr[i] = new com.dcloud.zxing2.qrcode.decoder.DataBlock(dataCodewords, new byte[eCBlocksForLevel.getECCodewordsPerBlock() + dataCodewords]);
                i2++;
                i++;
            }
        }
        int length = dataBlockArr[0].codewords.length;
        int i3 = count - 1;
        while (i3 >= 0 && dataBlockArr[i3].codewords.length != length) {
            i3--;
        }
        int i4 = i3 + 1;
        int eCCodewordsPerBlock = length - eCBlocksForLevel.getECCodewordsPerBlock();
        int i5 = 0;
        for (int i6 = 0; i6 < eCCodewordsPerBlock; i6++) {
            int i7 = 0;
            while (i7 < i) {
                dataBlockArr[i7].codewords[i6] = bArr[i5];
                i7++;
                i5++;
            }
        }
        int i8 = i4;
        while (i8 < i) {
            dataBlockArr[i8].codewords[eCCodewordsPerBlock] = bArr[i5];
            i8++;
            i5++;
        }
        int length2 = dataBlockArr[0].codewords.length;
        while (eCCodewordsPerBlock < length2) {
            int i9 = 0;
            while (i9 < i) {
                dataBlockArr[i9].codewords[i9 < i4 ? eCCodewordsPerBlock : eCCodewordsPerBlock + 1] = bArr[i5];
                i9++;
                i5++;
            }
            eCCodewordsPerBlock++;
        }
        return dataBlockArr;
    }

    byte[] getCodewords() {
        return this.codewords;
    }

    int getNumDataCodewords() {
        return this.numDataCodewords;
    }
}
