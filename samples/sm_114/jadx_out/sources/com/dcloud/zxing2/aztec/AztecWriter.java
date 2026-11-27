package com.dcloud.zxing2.aztec;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class AztecWriter implements com.dcloud.zxing2.Writer {
    private static final java.nio.charset.Charset DEFAULT_CHARSET = java.nio.charset.Charset.forName(net.lingala.zip4j.util.InternalZipConstants.AES_HASH_CHARSET);

    private static com.dcloud.zxing2.common.BitMatrix renderResult(com.dcloud.zxing2.aztec.encoder.AztecCode aztecCode, int i, int i2) {
        com.dcloud.zxing2.common.BitMatrix matrix = aztecCode.getMatrix();
        if (matrix == null) {
            throw new java.lang.IllegalStateException();
        }
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        int iMax = java.lang.Math.max(i, width);
        int iMax2 = java.lang.Math.max(i2, height);
        int iMin = java.lang.Math.min(iMax / width, iMax2 / height);
        int i3 = (iMax - (width * iMin)) / 2;
        int i4 = (iMax2 - (height * iMin)) / 2;
        com.dcloud.zxing2.common.BitMatrix bitMatrix = new com.dcloud.zxing2.common.BitMatrix(iMax, iMax2);
        int i5 = 0;
        while (i5 < height) {
            int i6 = i3;
            int i7 = 0;
            while (i7 < width) {
                if (matrix.get(i7, i5)) {
                    bitMatrix.setRegion(i6, i4, iMin, iMin);
                }
                i7++;
                i6 += iMin;
            }
            i5++;
            i4 += iMin;
        }
        return bitMatrix;
    }

    @Override // com.dcloud.zxing2.Writer
    public com.dcloud.zxing2.common.BitMatrix encode(java.lang.String str, com.dcloud.zxing2.BarcodeFormat barcodeFormat, int i, int i2) {
        return encode(str, barcodeFormat, i, i2, null);
    }

    @Override // com.dcloud.zxing2.Writer
    public com.dcloud.zxing2.common.BitMatrix encode(java.lang.String str, com.dcloud.zxing2.BarcodeFormat barcodeFormat, int i, int i2, java.util.Map<com.dcloud.zxing2.EncodeHintType, ?> map) {
        java.nio.charset.Charset charset;
        int i3;
        int i4;
        java.nio.charset.Charset charsetForName = DEFAULT_CHARSET;
        if (map != null) {
            com.dcloud.zxing2.EncodeHintType encodeHintType = com.dcloud.zxing2.EncodeHintType.CHARACTER_SET;
            if (map.containsKey(encodeHintType)) {
                charsetForName = java.nio.charset.Charset.forName(map.get(encodeHintType).toString());
            }
            com.dcloud.zxing2.EncodeHintType encodeHintType2 = com.dcloud.zxing2.EncodeHintType.ERROR_CORRECTION;
            int i5 = map.containsKey(encodeHintType2) ? java.lang.Integer.parseInt(map.get(encodeHintType2).toString()) : 33;
            com.dcloud.zxing2.EncodeHintType encodeHintType3 = com.dcloud.zxing2.EncodeHintType.AZTEC_LAYERS;
            if (map.containsKey(encodeHintType3)) {
                int i6 = java.lang.Integer.parseInt(map.get(encodeHintType3).toString());
                str = str;
                barcodeFormat = barcodeFormat;
                i = i;
                i2 = i2;
                charset = charsetForName;
                i3 = i5;
                i4 = i6;
            } else {
                charset = charsetForName;
                i3 = i5;
            }
            return encode(str, barcodeFormat, i, i2, charset, i3, i4);
        }
        charset = charsetForName;
        i3 = 33;
        i4 = 0;
        return encode(str, barcodeFormat, i, i2, charset, i3, i4);
    }

    private static com.dcloud.zxing2.common.BitMatrix encode(java.lang.String str, com.dcloud.zxing2.BarcodeFormat barcodeFormat, int i, int i2, java.nio.charset.Charset charset, int i3, int i4) {
        if (barcodeFormat == com.dcloud.zxing2.BarcodeFormat.AZTEC) {
            return renderResult(com.dcloud.zxing2.aztec.encoder.Encoder.encode(str.getBytes(charset), i3, i4), i, i2);
        }
        throw new java.lang.IllegalArgumentException("Can only encode AZTEC, but got " + barcodeFormat);
    }
}
