package com.dcloud.zxing2.qrcode.decoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class BitMatrixParser {
    private final com.dcloud.zxing2.common.BitMatrix bitMatrix;
    private boolean mirror;
    private com.dcloud.zxing2.qrcode.decoder.FormatInformation parsedFormatInfo;
    private com.dcloud.zxing2.qrcode.decoder.Version parsedVersion;

    BitMatrixParser(com.dcloud.zxing2.common.BitMatrix bitMatrix) throws com.dcloud.zxing2.FormatException {
        int height = bitMatrix.getHeight();
        if (height < 21 || (height & 3) != 1) {
            throw com.dcloud.zxing2.FormatException.getFormatInstance();
        }
        this.bitMatrix = bitMatrix;
    }

    private int copyBit(int i, int i2, int i3) {
        return this.mirror ? this.bitMatrix.get(i2, i) : this.bitMatrix.get(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    void mirror() {
        int i = 0;
        while (i < this.bitMatrix.getWidth()) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.bitMatrix.getHeight(); i3++) {
                if (this.bitMatrix.get(i, i3) != this.bitMatrix.get(i3, i)) {
                    this.bitMatrix.flip(i3, i);
                    this.bitMatrix.flip(i, i3);
                }
            }
            i = i2;
        }
    }

    byte[] readCodewords() throws com.dcloud.zxing2.FormatException {
        com.dcloud.zxing2.qrcode.decoder.FormatInformation formatInformation = readFormatInformation();
        com.dcloud.zxing2.qrcode.decoder.Version version = readVersion();
        com.dcloud.zxing2.qrcode.decoder.DataMask dataMaskForReference = com.dcloud.zxing2.qrcode.decoder.DataMask.forReference(formatInformation.getDataMask());
        int height = this.bitMatrix.getHeight();
        dataMaskForReference.unmaskBitMatrix(this.bitMatrix, height);
        com.dcloud.zxing2.common.BitMatrix bitMatrixBuildFunctionPattern = version.buildFunctionPattern();
        byte[] bArr = new byte[version.getTotalCodewords()];
        int i = height - 1;
        boolean z = true;
        int i2 = i;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i2 > 0) {
            if (i2 == 6) {
                i2--;
            }
            for (int i6 = 0; i6 < height; i6++) {
                int i7 = z ? i - i6 : i6;
                for (int i8 = 0; i8 < 2; i8++) {
                    int i9 = i2 - i8;
                    if (!bitMatrixBuildFunctionPattern.get(i9, i7)) {
                        i5++;
                        i4 <<= 1;
                        if (this.bitMatrix.get(i9, i7)) {
                            i4 |= 1;
                        }
                        if (i5 == 8) {
                            bArr[i3] = (byte) i4;
                            i3++;
                            i4 = 0;
                            i5 = 0;
                        }
                    }
                }
            }
            z = !z;
            i2 -= 2;
        }
        if (i3 == version.getTotalCodewords()) {
            return bArr;
        }
        throw com.dcloud.zxing2.FormatException.getFormatInstance();
    }

    com.dcloud.zxing2.qrcode.decoder.FormatInformation readFormatInformation() throws com.dcloud.zxing2.FormatException {
        com.dcloud.zxing2.qrcode.decoder.FormatInformation formatInformation = this.parsedFormatInfo;
        if (formatInformation != null) {
            return formatInformation;
        }
        int iCopyBit = 0;
        int iCopyBit2 = 0;
        for (int i = 0; i < 6; i++) {
            iCopyBit2 = copyBit(i, 8, iCopyBit2);
        }
        int iCopyBit3 = copyBit(8, 7, copyBit(8, 8, copyBit(7, 8, iCopyBit2)));
        for (int i2 = 5; i2 >= 0; i2--) {
            iCopyBit3 = copyBit(8, i2, iCopyBit3);
        }
        int height = this.bitMatrix.getHeight();
        int i3 = height - 7;
        for (int i4 = height - 1; i4 >= i3; i4--) {
            iCopyBit = copyBit(8, i4, iCopyBit);
        }
        for (int i5 = height - 8; i5 < height; i5++) {
            iCopyBit = copyBit(i5, 8, iCopyBit);
        }
        com.dcloud.zxing2.qrcode.decoder.FormatInformation formatInformationDecodeFormatInformation = com.dcloud.zxing2.qrcode.decoder.FormatInformation.decodeFormatInformation(iCopyBit3, iCopyBit);
        this.parsedFormatInfo = formatInformationDecodeFormatInformation;
        if (formatInformationDecodeFormatInformation != null) {
            return formatInformationDecodeFormatInformation;
        }
        throw com.dcloud.zxing2.FormatException.getFormatInstance();
    }

    com.dcloud.zxing2.qrcode.decoder.Version readVersion() throws com.dcloud.zxing2.FormatException {
        com.dcloud.zxing2.qrcode.decoder.Version version = this.parsedVersion;
        if (version != null) {
            return version;
        }
        int height = this.bitMatrix.getHeight();
        int i = (height - 17) / 4;
        if (i <= 6) {
            return com.dcloud.zxing2.qrcode.decoder.Version.getVersionForNumber(i);
        }
        int i2 = height - 11;
        int iCopyBit = 0;
        int iCopyBit2 = 0;
        for (int i3 = 5; i3 >= 0; i3--) {
            for (int i4 = height - 9; i4 >= i2; i4--) {
                iCopyBit2 = copyBit(i4, i3, iCopyBit2);
            }
        }
        com.dcloud.zxing2.qrcode.decoder.Version versionDecodeVersionInformation = com.dcloud.zxing2.qrcode.decoder.Version.decodeVersionInformation(iCopyBit2);
        if (versionDecodeVersionInformation != null && versionDecodeVersionInformation.getDimensionForVersion() == height) {
            this.parsedVersion = versionDecodeVersionInformation;
            return versionDecodeVersionInformation;
        }
        for (int i5 = 5; i5 >= 0; i5--) {
            for (int i6 = height - 9; i6 >= i2; i6--) {
                iCopyBit = copyBit(i5, i6, iCopyBit);
            }
        }
        com.dcloud.zxing2.qrcode.decoder.Version versionDecodeVersionInformation2 = com.dcloud.zxing2.qrcode.decoder.Version.decodeVersionInformation(iCopyBit);
        if (versionDecodeVersionInformation2 == null || versionDecodeVersionInformation2.getDimensionForVersion() != height) {
            throw com.dcloud.zxing2.FormatException.getFormatInstance();
        }
        this.parsedVersion = versionDecodeVersionInformation2;
        return versionDecodeVersionInformation2;
    }

    void remask() {
        com.dcloud.zxing2.qrcode.decoder.FormatInformation formatInformation = this.parsedFormatInfo;
        if (formatInformation == null) {
            return;
        }
        com.dcloud.zxing2.qrcode.decoder.DataMask.forReference(formatInformation.getDataMask()).unmaskBitMatrix(this.bitMatrix, this.bitMatrix.getHeight());
    }

    void setMirror(boolean z) {
        this.parsedVersion = null;
        this.parsedFormatInfo = null;
        this.mirror = z;
    }
}
