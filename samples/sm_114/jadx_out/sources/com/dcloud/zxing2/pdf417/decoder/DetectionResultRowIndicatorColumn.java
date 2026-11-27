package com.dcloud.zxing2.pdf417.decoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class DetectionResultRowIndicatorColumn extends com.dcloud.zxing2.pdf417.decoder.DetectionResultColumn {
    private final boolean isLeft;

    DetectionResultRowIndicatorColumn(com.dcloud.zxing2.pdf417.decoder.BoundingBox boundingBox, boolean z) {
        super(boundingBox);
        this.isLeft = z;
    }

    private void removeIncorrectCodewords(com.dcloud.zxing2.pdf417.decoder.Codeword[] codewordArr, com.dcloud.zxing2.pdf417.decoder.BarcodeMetadata barcodeMetadata) {
        for (int i = 0; i < codewordArr.length; i++) {
            com.dcloud.zxing2.pdf417.decoder.Codeword codeword = codewordArr[i];
            if (codeword != null) {
                int value = codeword.getValue() % 30;
                int rowNumber = codeword.getRowNumber();
                if (rowNumber > barcodeMetadata.getRowCount()) {
                    codewordArr[i] = null;
                } else {
                    if (!this.isLeft) {
                        rowNumber += 2;
                    }
                    int i2 = rowNumber % 3;
                    if (i2 != 0) {
                        if (i2 != 1) {
                            if (i2 == 2 && value + 1 != barcodeMetadata.getColumnCount()) {
                                codewordArr[i] = null;
                            }
                        } else if (value / 3 != barcodeMetadata.getErrorCorrectionLevel() || value % 3 != barcodeMetadata.getRowCountLowerPart()) {
                            codewordArr[i] = null;
                        }
                    } else if ((value * 3) + 1 != barcodeMetadata.getRowCountUpperPart()) {
                        codewordArr[i] = null;
                    }
                }
            }
        }
    }

    int adjustCompleteIndicatorColumnRowNumbers(com.dcloud.zxing2.pdf417.decoder.BarcodeMetadata barcodeMetadata) {
        com.dcloud.zxing2.pdf417.decoder.Codeword[] codewords = getCodewords();
        setRowNumbers();
        removeIncorrectCodewords(codewords, barcodeMetadata);
        com.dcloud.zxing2.pdf417.decoder.BoundingBox boundingBox = getBoundingBox();
        com.dcloud.zxing2.ResultPoint topLeft = this.isLeft ? boundingBox.getTopLeft() : boundingBox.getTopRight();
        com.dcloud.zxing2.ResultPoint bottomLeft = this.isLeft ? boundingBox.getBottomLeft() : boundingBox.getBottomRight();
        int iImageRowToCodewordIndex = imageRowToCodewordIndex((int) topLeft.getY());
        int iImageRowToCodewordIndex2 = imageRowToCodewordIndex((int) bottomLeft.getY());
        float rowCount = (iImageRowToCodewordIndex2 - iImageRowToCodewordIndex) / barcodeMetadata.getRowCount();
        int rowNumber = -1;
        int i = 0;
        int iMax = 1;
        while (iImageRowToCodewordIndex < iImageRowToCodewordIndex2) {
            com.dcloud.zxing2.pdf417.decoder.Codeword codeword = codewords[iImageRowToCodewordIndex];
            if (codeword != null) {
                int rowNumber2 = codeword.getRowNumber() - rowNumber;
                if (rowNumber2 == 0) {
                    i++;
                } else {
                    if (rowNumber2 == 1) {
                        iMax = java.lang.Math.max(iMax, i);
                        rowNumber = codeword.getRowNumber();
                    } else if (rowNumber2 < 0 || codeword.getRowNumber() >= barcodeMetadata.getRowCount() || rowNumber2 > iImageRowToCodewordIndex) {
                        codewords[iImageRowToCodewordIndex] = null;
                    } else {
                        if (iMax > 2) {
                            rowNumber2 *= iMax - 2;
                        }
                        boolean z = rowNumber2 >= iImageRowToCodewordIndex;
                        for (int i2 = 1; i2 <= rowNumber2 && !z; i2++) {
                            z = codewords[iImageRowToCodewordIndex - i2] != null;
                        }
                        if (z) {
                            codewords[iImageRowToCodewordIndex] = null;
                        } else {
                            rowNumber = codeword.getRowNumber();
                        }
                    }
                    i = 1;
                }
            }
            iImageRowToCodewordIndex++;
        }
        return (int) (((double) rowCount) + 0.5d);
    }

    int adjustIncompleteIndicatorColumnRowNumbers(com.dcloud.zxing2.pdf417.decoder.BarcodeMetadata barcodeMetadata) {
        com.dcloud.zxing2.pdf417.decoder.BoundingBox boundingBox = getBoundingBox();
        com.dcloud.zxing2.ResultPoint topLeft = this.isLeft ? boundingBox.getTopLeft() : boundingBox.getTopRight();
        com.dcloud.zxing2.ResultPoint bottomLeft = this.isLeft ? boundingBox.getBottomLeft() : boundingBox.getBottomRight();
        int iImageRowToCodewordIndex = imageRowToCodewordIndex((int) topLeft.getY());
        int iImageRowToCodewordIndex2 = imageRowToCodewordIndex((int) bottomLeft.getY());
        float rowCount = (iImageRowToCodewordIndex2 - iImageRowToCodewordIndex) / barcodeMetadata.getRowCount();
        com.dcloud.zxing2.pdf417.decoder.Codeword[] codewords = getCodewords();
        int rowNumber = -1;
        int i = 0;
        int iMax = 1;
        while (iImageRowToCodewordIndex < iImageRowToCodewordIndex2) {
            com.dcloud.zxing2.pdf417.decoder.Codeword codeword = codewords[iImageRowToCodewordIndex];
            if (codeword != null) {
                codeword.setRowNumberAsRowIndicatorColumn();
                int rowNumber2 = codeword.getRowNumber() - rowNumber;
                if (rowNumber2 == 0) {
                    i++;
                } else {
                    if (rowNumber2 == 1) {
                        iMax = java.lang.Math.max(iMax, i);
                        rowNumber = codeword.getRowNumber();
                    } else if (codeword.getRowNumber() >= barcodeMetadata.getRowCount()) {
                        codewords[iImageRowToCodewordIndex] = null;
                    } else {
                        rowNumber = codeword.getRowNumber();
                    }
                    i = 1;
                }
            }
            iImageRowToCodewordIndex++;
        }
        return (int) (((double) rowCount) + 0.5d);
    }

    com.dcloud.zxing2.pdf417.decoder.BarcodeMetadata getBarcodeMetadata() {
        com.dcloud.zxing2.pdf417.decoder.Codeword[] codewords = getCodewords();
        com.dcloud.zxing2.pdf417.decoder.BarcodeValue barcodeValue = new com.dcloud.zxing2.pdf417.decoder.BarcodeValue();
        com.dcloud.zxing2.pdf417.decoder.BarcodeValue barcodeValue2 = new com.dcloud.zxing2.pdf417.decoder.BarcodeValue();
        com.dcloud.zxing2.pdf417.decoder.BarcodeValue barcodeValue3 = new com.dcloud.zxing2.pdf417.decoder.BarcodeValue();
        com.dcloud.zxing2.pdf417.decoder.BarcodeValue barcodeValue4 = new com.dcloud.zxing2.pdf417.decoder.BarcodeValue();
        for (com.dcloud.zxing2.pdf417.decoder.Codeword codeword : codewords) {
            if (codeword != null) {
                codeword.setRowNumberAsRowIndicatorColumn();
                int value = codeword.getValue() % 30;
                int rowNumber = codeword.getRowNumber();
                if (!this.isLeft) {
                    rowNumber += 2;
                }
                int i = rowNumber % 3;
                if (i == 0) {
                    barcodeValue2.setValue((value * 3) + 1);
                } else if (i == 1) {
                    barcodeValue4.setValue(value / 3);
                    barcodeValue3.setValue(value % 3);
                } else if (i == 2) {
                    barcodeValue.setValue(value + 1);
                }
            }
        }
        if (barcodeValue.getValue().length == 0 || barcodeValue2.getValue().length == 0 || barcodeValue3.getValue().length == 0 || barcodeValue4.getValue().length == 0 || barcodeValue.getValue()[0] < 1 || barcodeValue2.getValue()[0] + barcodeValue3.getValue()[0] < 3 || barcodeValue2.getValue()[0] + barcodeValue3.getValue()[0] > 90) {
            return null;
        }
        com.dcloud.zxing2.pdf417.decoder.BarcodeMetadata barcodeMetadata = new com.dcloud.zxing2.pdf417.decoder.BarcodeMetadata(barcodeValue.getValue()[0], barcodeValue2.getValue()[0], barcodeValue3.getValue()[0], barcodeValue4.getValue()[0]);
        removeIncorrectCodewords(codewords, barcodeMetadata);
        return barcodeMetadata;
    }

    int[] getRowHeights() throws com.dcloud.zxing2.FormatException {
        int rowNumber;
        com.dcloud.zxing2.pdf417.decoder.BarcodeMetadata barcodeMetadata = getBarcodeMetadata();
        if (barcodeMetadata == null) {
            return null;
        }
        adjustIncompleteIndicatorColumnRowNumbers(barcodeMetadata);
        int rowCount = barcodeMetadata.getRowCount();
        int[] iArr = new int[rowCount];
        for (com.dcloud.zxing2.pdf417.decoder.Codeword codeword : getCodewords()) {
            if (codeword != null && (rowNumber = codeword.getRowNumber()) < rowCount) {
                iArr[rowNumber] = iArr[rowNumber] + 1;
            }
        }
        return iArr;
    }

    boolean isLeft() {
        return this.isLeft;
    }

    void setRowNumbers() {
        for (com.dcloud.zxing2.pdf417.decoder.Codeword codeword : getCodewords()) {
            if (codeword != null) {
                codeword.setRowNumberAsRowIndicatorColumn();
            }
        }
    }

    @Override // com.dcloud.zxing2.pdf417.decoder.DetectionResultColumn
    public java.lang.String toString() {
        return "IsLeft: " + this.isLeft + '\n' + super.toString();
    }
}
