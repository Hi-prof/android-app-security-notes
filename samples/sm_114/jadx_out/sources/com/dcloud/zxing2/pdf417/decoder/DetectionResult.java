package com.dcloud.zxing2.pdf417.decoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class DetectionResult {
    private static final int ADJUST_ROW_NUMBER_SKIP = 2;
    private final int barcodeColumnCount;
    private final com.dcloud.zxing2.pdf417.decoder.BarcodeMetadata barcodeMetadata;
    private com.dcloud.zxing2.pdf417.decoder.BoundingBox boundingBox;
    private final com.dcloud.zxing2.pdf417.decoder.DetectionResultColumn[] detectionResultColumns;

    DetectionResult(com.dcloud.zxing2.pdf417.decoder.BarcodeMetadata barcodeMetadata, com.dcloud.zxing2.pdf417.decoder.BoundingBox boundingBox) {
        this.barcodeMetadata = barcodeMetadata;
        int columnCount = barcodeMetadata.getColumnCount();
        this.barcodeColumnCount = columnCount;
        this.boundingBox = boundingBox;
        this.detectionResultColumns = new com.dcloud.zxing2.pdf417.decoder.DetectionResultColumn[columnCount + 2];
    }

    private void adjustIndicatorColumnRowNumbers(com.dcloud.zxing2.pdf417.decoder.DetectionResultColumn detectionResultColumn) {
        if (detectionResultColumn != null) {
            ((com.dcloud.zxing2.pdf417.decoder.DetectionResultRowIndicatorColumn) detectionResultColumn).adjustCompleteIndicatorColumnRowNumbers(this.barcodeMetadata);
        }
    }

    private static boolean adjustRowNumber(com.dcloud.zxing2.pdf417.decoder.Codeword codeword, com.dcloud.zxing2.pdf417.decoder.Codeword codeword2) {
        if (codeword2 == null || !codeword2.hasValidRowNumber() || codeword2.getBucket() != codeword.getBucket()) {
            return false;
        }
        codeword.setRowNumber(codeword2.getRowNumber());
        return true;
    }

    private static int adjustRowNumberIfValid(int i, int i2, com.dcloud.zxing2.pdf417.decoder.Codeword codeword) {
        if (codeword == null || codeword.hasValidRowNumber()) {
            return i2;
        }
        if (!codeword.isValidRowNumber(i)) {
            return i2 + 1;
        }
        codeword.setRowNumber(i);
        return 0;
    }

    private int adjustRowNumbers() {
        int iAdjustRowNumbersByRow = adjustRowNumbersByRow();
        if (iAdjustRowNumbersByRow == 0) {
            return 0;
        }
        for (int i = 1; i < this.barcodeColumnCount + 1; i++) {
            com.dcloud.zxing2.pdf417.decoder.Codeword[] codewords = this.detectionResultColumns[i].getCodewords();
            for (int i2 = 0; i2 < codewords.length; i2++) {
                com.dcloud.zxing2.pdf417.decoder.Codeword codeword = codewords[i2];
                if (codeword != null && !codeword.hasValidRowNumber()) {
                    adjustRowNumbers(i, i2, codewords);
                }
            }
        }
        return iAdjustRowNumbersByRow;
    }

    private int adjustRowNumbersByRow() {
        adjustRowNumbersFromBothRI();
        return adjustRowNumbersFromLRI() + adjustRowNumbersFromRRI();
    }

    private void adjustRowNumbersFromBothRI() {
        com.dcloud.zxing2.pdf417.decoder.DetectionResultColumn[] detectionResultColumnArr = this.detectionResultColumns;
        com.dcloud.zxing2.pdf417.decoder.DetectionResultColumn detectionResultColumn = detectionResultColumnArr[0];
        if (detectionResultColumn == null || detectionResultColumnArr[this.barcodeColumnCount + 1] == null) {
            return;
        }
        com.dcloud.zxing2.pdf417.decoder.Codeword[] codewords = detectionResultColumn.getCodewords();
        com.dcloud.zxing2.pdf417.decoder.Codeword[] codewords2 = this.detectionResultColumns[this.barcodeColumnCount + 1].getCodewords();
        for (int i = 0; i < codewords.length; i++) {
            com.dcloud.zxing2.pdf417.decoder.Codeword codeword = codewords[i];
            if (codeword != null && codewords2[i] != null && codeword.getRowNumber() == codewords2[i].getRowNumber()) {
                for (int i2 = 1; i2 <= this.barcodeColumnCount; i2++) {
                    com.dcloud.zxing2.pdf417.decoder.Codeword codeword2 = this.detectionResultColumns[i2].getCodewords()[i];
                    if (codeword2 != null) {
                        codeword2.setRowNumber(codewords[i].getRowNumber());
                        if (!codeword2.hasValidRowNumber()) {
                            this.detectionResultColumns[i2].getCodewords()[i] = null;
                        }
                    }
                }
            }
        }
    }

    private int adjustRowNumbersFromLRI() {
        com.dcloud.zxing2.pdf417.decoder.DetectionResultColumn detectionResultColumn = this.detectionResultColumns[0];
        if (detectionResultColumn == null) {
            return 0;
        }
        com.dcloud.zxing2.pdf417.decoder.Codeword[] codewords = detectionResultColumn.getCodewords();
        int i = 0;
        for (int i2 = 0; i2 < codewords.length; i2++) {
            com.dcloud.zxing2.pdf417.decoder.Codeword codeword = codewords[i2];
            if (codeword != null) {
                int rowNumber = codeword.getRowNumber();
                int iAdjustRowNumberIfValid = 0;
                for (int i3 = 1; i3 < this.barcodeColumnCount + 1 && iAdjustRowNumberIfValid < 2; i3++) {
                    com.dcloud.zxing2.pdf417.decoder.Codeword codeword2 = this.detectionResultColumns[i3].getCodewords()[i2];
                    if (codeword2 != null) {
                        iAdjustRowNumberIfValid = adjustRowNumberIfValid(rowNumber, iAdjustRowNumberIfValid, codeword2);
                        if (!codeword2.hasValidRowNumber()) {
                            i++;
                        }
                    }
                }
            }
        }
        return i;
    }

    private int adjustRowNumbersFromRRI() {
        com.dcloud.zxing2.pdf417.decoder.DetectionResultColumn detectionResultColumn = this.detectionResultColumns[this.barcodeColumnCount + 1];
        if (detectionResultColumn == null) {
            return 0;
        }
        com.dcloud.zxing2.pdf417.decoder.Codeword[] codewords = detectionResultColumn.getCodewords();
        int i = 0;
        for (int i2 = 0; i2 < codewords.length; i2++) {
            com.dcloud.zxing2.pdf417.decoder.Codeword codeword = codewords[i2];
            if (codeword != null) {
                int rowNumber = codeword.getRowNumber();
                int iAdjustRowNumberIfValid = 0;
                for (int i3 = this.barcodeColumnCount + 1; i3 > 0 && iAdjustRowNumberIfValid < 2; i3--) {
                    com.dcloud.zxing2.pdf417.decoder.Codeword codeword2 = this.detectionResultColumns[i3].getCodewords()[i2];
                    if (codeword2 != null) {
                        iAdjustRowNumberIfValid = adjustRowNumberIfValid(rowNumber, iAdjustRowNumberIfValid, codeword2);
                        if (!codeword2.hasValidRowNumber()) {
                            i++;
                        }
                    }
                }
            }
        }
        return i;
    }

    int getBarcodeColumnCount() {
        return this.barcodeColumnCount;
    }

    int getBarcodeECLevel() {
        return this.barcodeMetadata.getErrorCorrectionLevel();
    }

    int getBarcodeRowCount() {
        return this.barcodeMetadata.getRowCount();
    }

    com.dcloud.zxing2.pdf417.decoder.BoundingBox getBoundingBox() {
        return this.boundingBox;
    }

    com.dcloud.zxing2.pdf417.decoder.DetectionResultColumn getDetectionResultColumn(int i) {
        return this.detectionResultColumns[i];
    }

    com.dcloud.zxing2.pdf417.decoder.DetectionResultColumn[] getDetectionResultColumns() {
        adjustIndicatorColumnRowNumbers(this.detectionResultColumns[0]);
        adjustIndicatorColumnRowNumbers(this.detectionResultColumns[this.barcodeColumnCount + 1]);
        int i = com.dcloud.zxing2.pdf417.PDF417Common.MAX_CODEWORDS_IN_BARCODE;
        while (true) {
            int iAdjustRowNumbers = adjustRowNumbers();
            if (iAdjustRowNumbers <= 0 || iAdjustRowNumbers >= i) {
                break;
            }
            i = iAdjustRowNumbers;
        }
        return this.detectionResultColumns;
    }

    public void setBoundingBox(com.dcloud.zxing2.pdf417.decoder.BoundingBox boundingBox) {
        this.boundingBox = boundingBox;
    }

    void setDetectionResultColumn(int i, com.dcloud.zxing2.pdf417.decoder.DetectionResultColumn detectionResultColumn) {
        this.detectionResultColumns[i] = detectionResultColumn;
    }

    public java.lang.String toString() {
        com.dcloud.zxing2.pdf417.decoder.DetectionResultColumn[] detectionResultColumnArr = this.detectionResultColumns;
        com.dcloud.zxing2.pdf417.decoder.DetectionResultColumn detectionResultColumn = detectionResultColumnArr[0];
        if (detectionResultColumn == null) {
            detectionResultColumn = detectionResultColumnArr[this.barcodeColumnCount + 1];
        }
        java.util.Formatter formatter = new java.util.Formatter();
        for (int i = 0; i < detectionResultColumn.getCodewords().length; i++) {
            formatter.format("CW %3d:", java.lang.Integer.valueOf(i));
            for (int i2 = 0; i2 < this.barcodeColumnCount + 2; i2++) {
                com.dcloud.zxing2.pdf417.decoder.DetectionResultColumn detectionResultColumn2 = this.detectionResultColumns[i2];
                if (detectionResultColumn2 == null) {
                    formatter.format("    |   ", new java.lang.Object[0]);
                } else {
                    com.dcloud.zxing2.pdf417.decoder.Codeword codeword = detectionResultColumn2.getCodewords()[i];
                    if (codeword == null) {
                        formatter.format("    |   ", new java.lang.Object[0]);
                    } else {
                        formatter.format(" %3d|%3d", java.lang.Integer.valueOf(codeword.getRowNumber()), java.lang.Integer.valueOf(codeword.getValue()));
                    }
                }
            }
            formatter.format("%n", new java.lang.Object[0]);
        }
        java.lang.String string = formatter.toString();
        formatter.close();
        return string;
    }

    private void adjustRowNumbers(int i, int i2, com.dcloud.zxing2.pdf417.decoder.Codeword[] codewordArr) {
        com.dcloud.zxing2.pdf417.decoder.Codeword codeword = codewordArr[i2];
        com.dcloud.zxing2.pdf417.decoder.Codeword[] codewords = this.detectionResultColumns[i - 1].getCodewords();
        com.dcloud.zxing2.pdf417.decoder.DetectionResultColumn detectionResultColumn = this.detectionResultColumns[i + 1];
        com.dcloud.zxing2.pdf417.decoder.Codeword[] codewords2 = detectionResultColumn != null ? detectionResultColumn.getCodewords() : codewords;
        com.dcloud.zxing2.pdf417.decoder.Codeword[] codewordArr2 = new com.dcloud.zxing2.pdf417.decoder.Codeword[14];
        codewordArr2[2] = codewords[i2];
        codewordArr2[3] = codewords2[i2];
        if (i2 > 0) {
            int i3 = i2 - 1;
            codewordArr2[0] = codewordArr[i3];
            codewordArr2[4] = codewords[i3];
            codewordArr2[5] = codewords2[i3];
        }
        if (i2 > 1) {
            int i4 = i2 - 2;
            codewordArr2[8] = codewordArr[i4];
            codewordArr2[10] = codewords[i4];
            codewordArr2[11] = codewords2[i4];
        }
        if (i2 < codewordArr.length - 1) {
            int i5 = i2 + 1;
            codewordArr2[1] = codewordArr[i5];
            codewordArr2[6] = codewords[i5];
            codewordArr2[7] = codewords2[i5];
        }
        if (i2 < codewordArr.length - 2) {
            int i6 = i2 + 2;
            codewordArr2[9] = codewordArr[i6];
            codewordArr2[12] = codewords[i6];
            codewordArr2[13] = codewords2[i6];
        }
        for (int i7 = 0; i7 < 14 && !adjustRowNumber(codeword, codewordArr2[i7]); i7++) {
        }
    }
}
