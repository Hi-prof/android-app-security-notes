package com.dcloud.zxing2.datamatrix.decoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class DataBlock {
    private final byte[] codewords;
    private final int numDataCodewords;

    private DataBlock(int i, byte[] bArr) {
        this.numDataCodewords = i;
        this.codewords = bArr;
    }

    static com.dcloud.zxing2.datamatrix.decoder.DataBlock[] getDataBlocks(byte[] bArr, com.dcloud.zxing2.datamatrix.decoder.Version version) {
        com.dcloud.zxing2.datamatrix.decoder.Version.ECBlocks eCBlocks = version.getECBlocks();
        com.dcloud.zxing2.datamatrix.decoder.Version.ECB[] eCBlocks2 = eCBlocks.getECBlocks();
        int count = 0;
        for (com.dcloud.zxing2.datamatrix.decoder.Version.ECB ecb : eCBlocks2) {
            count += ecb.getCount();
        }
        com.dcloud.zxing2.datamatrix.decoder.DataBlock[] dataBlockArr = new com.dcloud.zxing2.datamatrix.decoder.DataBlock[count];
        int i = 0;
        for (com.dcloud.zxing2.datamatrix.decoder.Version.ECB ecb2 : eCBlocks2) {
            int i2 = 0;
            while (i2 < ecb2.getCount()) {
                int dataCodewords = ecb2.getDataCodewords();
                dataBlockArr[i] = new com.dcloud.zxing2.datamatrix.decoder.DataBlock(dataCodewords, new byte[eCBlocks.getECCodewords() + dataCodewords]);
                i2++;
                i++;
            }
        }
        int length = dataBlockArr[0].codewords.length - eCBlocks.getECCodewords();
        int i3 = length - 1;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = 0;
            while (i6 < i) {
                dataBlockArr[i6].codewords[i5] = bArr[i4];
                i6++;
                i4++;
            }
        }
        boolean z = version.getVersionNumber() == 24;
        int i7 = z ? 8 : i;
        int i8 = 0;
        while (i8 < i7) {
            dataBlockArr[i8].codewords[i3] = bArr[i4];
            i8++;
            i4++;
        }
        int length2 = dataBlockArr[0].codewords.length;
        while (length < length2) {
            int i9 = 0;
            while (i9 < i) {
                int i10 = z ? (i9 + 8) % i : i9;
                dataBlockArr[i10].codewords[(!z || i10 <= 7) ? length : length - 1] = bArr[i4];
                i9++;
                i4++;
            }
            length++;
        }
        if (i4 == bArr.length) {
            return dataBlockArr;
        }
        throw new java.lang.IllegalArgumentException();
    }

    byte[] getCodewords() {
        return this.codewords;
    }

    int getNumDataCodewords() {
        return this.numDataCodewords;
    }
}
