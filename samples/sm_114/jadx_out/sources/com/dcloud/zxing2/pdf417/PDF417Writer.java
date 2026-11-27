package com.dcloud.zxing2.pdf417;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class PDF417Writer implements com.dcloud.zxing2.Writer {
    static final int DEFAULT_ERROR_CORRECTION_LEVEL = 2;
    static final int WHITE_SPACE = 30;

    private static com.dcloud.zxing2.common.BitMatrix bitMatrixFromEncoder(com.dcloud.zxing2.pdf417.encoder.PDF417 pdf417, java.lang.String str, int i, int i2, int i3, int i4) throws com.dcloud.zxing2.WriterException {
        boolean z;
        pdf417.generateBarcodeLogic(str, i);
        byte[][] scaledMatrix = pdf417.getBarcodeMatrix().getScaledMatrix(1, 4);
        if ((i3 > i2) ^ (scaledMatrix[0].length < scaledMatrix.length)) {
            scaledMatrix = rotateArray(scaledMatrix);
            z = true;
        } else {
            z = false;
        }
        int length = i2 / scaledMatrix[0].length;
        int length2 = i3 / scaledMatrix.length;
        if (length >= length2) {
            length = length2;
        }
        if (length <= 1) {
            return bitMatrixFrombitArray(scaledMatrix, i4);
        }
        byte[][] scaledMatrix2 = pdf417.getBarcodeMatrix().getScaledMatrix(length, length * 4);
        if (z) {
            scaledMatrix2 = rotateArray(scaledMatrix2);
        }
        return bitMatrixFrombitArray(scaledMatrix2, i4);
    }

    private static com.dcloud.zxing2.common.BitMatrix bitMatrixFrombitArray(byte[][] bArr, int i) {
        int i2 = i * 2;
        com.dcloud.zxing2.common.BitMatrix bitMatrix = new com.dcloud.zxing2.common.BitMatrix(bArr[0].length + i2, bArr.length + i2);
        bitMatrix.clear();
        int height = (bitMatrix.getHeight() - i) - 1;
        int i3 = 0;
        while (i3 < bArr.length) {
            for (int i4 = 0; i4 < bArr[0].length; i4++) {
                if (bArr[i3][i4] == 1) {
                    bitMatrix.set(i4 + i, height);
                }
            }
            i3++;
            height--;
        }
        return bitMatrix;
    }

    private static byte[][] rotateArray(byte[][] bArr) {
        byte[][] bArr2 = (byte[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) java.lang.Byte.TYPE, bArr[0].length, bArr.length);
        for (int i = 0; i < bArr.length; i++) {
            int length = (bArr.length - i) - 1;
            for (int i2 = 0; i2 < bArr[0].length; i2++) {
                bArr2[i2][length] = bArr[i][i2];
            }
        }
        return bArr2;
    }

    @Override // com.dcloud.zxing2.Writer
    public com.dcloud.zxing2.common.BitMatrix encode(java.lang.String str, com.dcloud.zxing2.BarcodeFormat barcodeFormat, int i, int i2, java.util.Map<com.dcloud.zxing2.EncodeHintType, ?> map) throws com.dcloud.zxing2.WriterException {
        int i3;
        int i4;
        if (barcodeFormat != com.dcloud.zxing2.BarcodeFormat.PDF_417) {
            throw new java.lang.IllegalArgumentException("Can only encode PDF_417, but got " + barcodeFormat);
        }
        com.dcloud.zxing2.pdf417.encoder.PDF417 pdf417 = new com.dcloud.zxing2.pdf417.encoder.PDF417();
        if (map != null) {
            com.dcloud.zxing2.EncodeHintType encodeHintType = com.dcloud.zxing2.EncodeHintType.PDF417_COMPACT;
            if (map.containsKey(encodeHintType)) {
                pdf417.setCompact(java.lang.Boolean.valueOf(map.get(encodeHintType).toString()).booleanValue());
            }
            com.dcloud.zxing2.EncodeHintType encodeHintType2 = com.dcloud.zxing2.EncodeHintType.PDF417_COMPACTION;
            if (map.containsKey(encodeHintType2)) {
                pdf417.setCompaction(com.dcloud.zxing2.pdf417.encoder.Compaction.valueOf(map.get(encodeHintType2).toString()));
            }
            com.dcloud.zxing2.EncodeHintType encodeHintType3 = com.dcloud.zxing2.EncodeHintType.PDF417_DIMENSIONS;
            if (map.containsKey(encodeHintType3)) {
                com.dcloud.zxing2.pdf417.encoder.Dimensions dimensions = (com.dcloud.zxing2.pdf417.encoder.Dimensions) map.get(encodeHintType3);
                pdf417.setDimensions(dimensions.getMaxCols(), dimensions.getMinCols(), dimensions.getMaxRows(), dimensions.getMinRows());
            }
            com.dcloud.zxing2.EncodeHintType encodeHintType4 = com.dcloud.zxing2.EncodeHintType.MARGIN;
            int i5 = map.containsKey(encodeHintType4) ? java.lang.Integer.parseInt(map.get(encodeHintType4).toString()) : 30;
            com.dcloud.zxing2.EncodeHintType encodeHintType5 = com.dcloud.zxing2.EncodeHintType.ERROR_CORRECTION;
            int i6 = map.containsKey(encodeHintType5) ? java.lang.Integer.parseInt(map.get(encodeHintType5).toString()) : 2;
            com.dcloud.zxing2.EncodeHintType encodeHintType6 = com.dcloud.zxing2.EncodeHintType.CHARACTER_SET;
            if (map.containsKey(encodeHintType6)) {
                pdf417.setEncoding(java.nio.charset.Charset.forName(map.get(encodeHintType6).toString()));
            }
            i4 = i5;
            i3 = i6;
        } else {
            i3 = 2;
            i4 = 30;
        }
        return bitMatrixFromEncoder(pdf417, str, i3, i, i2, i4);
    }

    @Override // com.dcloud.zxing2.Writer
    public com.dcloud.zxing2.common.BitMatrix encode(java.lang.String str, com.dcloud.zxing2.BarcodeFormat barcodeFormat, int i, int i2) throws com.dcloud.zxing2.WriterException {
        return encode(str, barcodeFormat, i, i2, null);
    }
}
