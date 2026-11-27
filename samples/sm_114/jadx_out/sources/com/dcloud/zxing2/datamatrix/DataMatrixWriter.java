package com.dcloud.zxing2.datamatrix;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class DataMatrixWriter implements com.dcloud.zxing2.Writer {
    private static com.dcloud.zxing2.common.BitMatrix convertByteMatrixToBitMatrix(com.dcloud.zxing2.qrcode.encoder.ByteMatrix byteMatrix) {
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        com.dcloud.zxing2.common.BitMatrix bitMatrix = new com.dcloud.zxing2.common.BitMatrix(width, height);
        bitMatrix.clear();
        for (int i = 0; i < width; i++) {
            for (int i2 = 0; i2 < height; i2++) {
                if (byteMatrix.get(i, i2) == 1) {
                    bitMatrix.set(i, i2);
                }
            }
        }
        return bitMatrix;
    }

    private static com.dcloud.zxing2.common.BitMatrix encodeLowLevel(com.dcloud.zxing2.datamatrix.encoder.DefaultPlacement defaultPlacement, com.dcloud.zxing2.datamatrix.encoder.SymbolInfo symbolInfo) {
        int symbolDataWidth = symbolInfo.getSymbolDataWidth();
        int symbolDataHeight = symbolInfo.getSymbolDataHeight();
        com.dcloud.zxing2.qrcode.encoder.ByteMatrix byteMatrix = new com.dcloud.zxing2.qrcode.encoder.ByteMatrix(symbolInfo.getSymbolWidth(), symbolInfo.getSymbolHeight());
        int i = 0;
        for (int i2 = 0; i2 < symbolDataHeight; i2++) {
            if (i2 % symbolInfo.matrixHeight == 0) {
                int i3 = 0;
                for (int i4 = 0; i4 < symbolInfo.getSymbolWidth(); i4++) {
                    byteMatrix.set(i3, i, i4 % 2 == 0);
                    i3++;
                }
                i++;
            }
            int i5 = 0;
            for (int i6 = 0; i6 < symbolDataWidth; i6++) {
                if (i6 % symbolInfo.matrixWidth == 0) {
                    byteMatrix.set(i5, i, true);
                    i5++;
                }
                byteMatrix.set(i5, i, defaultPlacement.getBit(i6, i2));
                int i7 = i5 + 1;
                int i8 = symbolInfo.matrixWidth;
                if (i6 % i8 == i8 - 1) {
                    byteMatrix.set(i7, i, i2 % 2 == 0);
                    i5 += 2;
                } else {
                    i5 = i7;
                }
            }
            int i9 = i + 1;
            int i10 = symbolInfo.matrixHeight;
            if (i2 % i10 == i10 - 1) {
                int i11 = 0;
                for (int i12 = 0; i12 < symbolInfo.getSymbolWidth(); i12++) {
                    byteMatrix.set(i11, i9, true);
                    i11++;
                }
                i += 2;
            } else {
                i = i9;
            }
        }
        return convertByteMatrixToBitMatrix(byteMatrix);
    }

    @Override // com.dcloud.zxing2.Writer
    public com.dcloud.zxing2.common.BitMatrix encode(java.lang.String str, com.dcloud.zxing2.BarcodeFormat barcodeFormat, int i, int i2) {
        return encode(str, barcodeFormat, i, i2, null);
    }

    @Override // com.dcloud.zxing2.Writer
    public com.dcloud.zxing2.common.BitMatrix encode(java.lang.String str, com.dcloud.zxing2.BarcodeFormat barcodeFormat, int i, int i2, java.util.Map<com.dcloud.zxing2.EncodeHintType, ?> map) {
        com.dcloud.zxing2.Dimension dimension;
        if (str.isEmpty()) {
            throw new java.lang.IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != com.dcloud.zxing2.BarcodeFormat.DATA_MATRIX) {
            throw new java.lang.IllegalArgumentException("Can only encode DATA_MATRIX, but got " + barcodeFormat);
        }
        if (i < 0 || i2 < 0) {
            throw new java.lang.IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + i2);
        }
        com.dcloud.zxing2.datamatrix.encoder.SymbolShapeHint symbolShapeHint = com.dcloud.zxing2.datamatrix.encoder.SymbolShapeHint.FORCE_NONE;
        com.dcloud.zxing2.Dimension dimension2 = null;
        if (map != null) {
            com.dcloud.zxing2.datamatrix.encoder.SymbolShapeHint symbolShapeHint2 = (com.dcloud.zxing2.datamatrix.encoder.SymbolShapeHint) map.get(com.dcloud.zxing2.EncodeHintType.DATA_MATRIX_SHAPE);
            if (symbolShapeHint2 != null) {
                symbolShapeHint = symbolShapeHint2;
            }
            com.dcloud.zxing2.Dimension dimension3 = (com.dcloud.zxing2.Dimension) map.get(com.dcloud.zxing2.EncodeHintType.MIN_SIZE);
            if (dimension3 == null) {
                dimension3 = null;
            }
            dimension = (com.dcloud.zxing2.Dimension) map.get(com.dcloud.zxing2.EncodeHintType.MAX_SIZE);
            if (dimension == null) {
                dimension = null;
            }
            dimension2 = dimension3;
        } else {
            dimension = null;
        }
        java.lang.String strEncodeHighLevel = com.dcloud.zxing2.datamatrix.encoder.HighLevelEncoder.encodeHighLevel(str, symbolShapeHint, dimension2, dimension);
        com.dcloud.zxing2.datamatrix.encoder.SymbolInfo symbolInfoLookup = com.dcloud.zxing2.datamatrix.encoder.SymbolInfo.lookup(strEncodeHighLevel.length(), symbolShapeHint, dimension2, dimension, true);
        com.dcloud.zxing2.datamatrix.encoder.DefaultPlacement defaultPlacement = new com.dcloud.zxing2.datamatrix.encoder.DefaultPlacement(com.dcloud.zxing2.datamatrix.encoder.ErrorCorrection.encodeECC200(strEncodeHighLevel, symbolInfoLookup), symbolInfoLookup.getSymbolDataWidth(), symbolInfoLookup.getSymbolDataHeight());
        defaultPlacement.place();
        return encodeLowLevel(defaultPlacement, symbolInfoLookup);
    }
}
