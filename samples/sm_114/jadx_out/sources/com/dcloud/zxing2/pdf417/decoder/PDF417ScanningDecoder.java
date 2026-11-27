package com.dcloud.zxing2.pdf417.decoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class PDF417ScanningDecoder {
    private static final int CODEWORD_SKEW_SIZE = 2;
    private static final int MAX_EC_CODEWORDS = 512;
    private static final int MAX_ERRORS = 3;
    private static final com.dcloud.zxing2.pdf417.decoder.ec.ErrorCorrection errorCorrection = new com.dcloud.zxing2.pdf417.decoder.ec.ErrorCorrection();

    private PDF417ScanningDecoder() {
    }

    private static com.dcloud.zxing2.pdf417.decoder.BoundingBox adjustBoundingBox(com.dcloud.zxing2.pdf417.decoder.DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn) throws com.dcloud.zxing2.FormatException, com.dcloud.zxing2.NotFoundException {
        int[] rowHeights;
        if (detectionResultRowIndicatorColumn == null || (rowHeights = detectionResultRowIndicatorColumn.getRowHeights()) == null) {
            return null;
        }
        int max = getMax(rowHeights);
        int i = 0;
        int i2 = 0;
        for (int i3 : rowHeights) {
            i2 += max - i3;
            if (i3 > 0) {
                break;
            }
        }
        com.dcloud.zxing2.pdf417.decoder.Codeword[] codewords = detectionResultRowIndicatorColumn.getCodewords();
        for (int i4 = 0; i2 > 0 && codewords[i4] == null; i4++) {
            i2--;
        }
        for (int length = rowHeights.length - 1; length >= 0; length--) {
            int i5 = rowHeights[length];
            i += max - i5;
            if (i5 > 0) {
                break;
            }
        }
        for (int length2 = codewords.length - 1; i > 0 && codewords[length2] == null; length2--) {
            i--;
        }
        return detectionResultRowIndicatorColumn.getBoundingBox().addMissingRows(i2, i, detectionResultRowIndicatorColumn.isLeft());
    }

    private static void adjustCodewordCount(com.dcloud.zxing2.pdf417.decoder.DetectionResult detectionResult, com.dcloud.zxing2.pdf417.decoder.BarcodeValue[][] barcodeValueArr) throws com.dcloud.zxing2.NotFoundException {
        int[] value = barcodeValueArr[0][1].getValue();
        int barcodeColumnCount = (detectionResult.getBarcodeColumnCount() * detectionResult.getBarcodeRowCount()) - getNumberOfECCodeWords(detectionResult.getBarcodeECLevel());
        if (value.length != 0) {
            if (value[0] != barcodeColumnCount) {
                barcodeValueArr[0][1].setValue(barcodeColumnCount);
            }
        } else {
            if (barcodeColumnCount < 1 || barcodeColumnCount > 928) {
                throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
            }
            barcodeValueArr[0][1].setValue(barcodeColumnCount);
        }
    }

    private static int adjustCodewordStartColumn(com.dcloud.zxing2.common.BitMatrix bitMatrix, int i, int i2, boolean z, int i3, int i4) {
        int i5 = z ? -1 : 1;
        int i6 = i3;
        for (int i7 = 0; i7 < 2; i7++) {
            while (true) {
                if (((!z || i6 < i) && (z || i6 >= i2)) || z != bitMatrix.get(i6, i4)) {
                    break;
                }
                if (java.lang.Math.abs(i3 - i6) > 2) {
                    return i3;
                }
                i6 += i5;
            }
            i5 = -i5;
            z = !z;
        }
        return i6;
    }

    private static boolean checkCodewordSkew(int i, int i2, int i3) {
        return i2 + (-2) <= i && i <= i3 + 2;
    }

    private static int correctErrors(int[] iArr, int[] iArr2, int i) throws com.dcloud.zxing2.ChecksumException {
        if ((iArr2 == null || iArr2.length <= (i / 2) + 3) && i >= 0 && i <= 512) {
            return errorCorrection.decode(iArr, i, iArr2);
        }
        throw com.dcloud.zxing2.ChecksumException.getChecksumInstance();
    }

    private static com.dcloud.zxing2.pdf417.decoder.BarcodeValue[][] createBarcodeMatrix(com.dcloud.zxing2.pdf417.decoder.DetectionResult detectionResult) throws com.dcloud.zxing2.FormatException {
        int rowNumber;
        com.dcloud.zxing2.pdf417.decoder.BarcodeValue[][] barcodeValueArr = (com.dcloud.zxing2.pdf417.decoder.BarcodeValue[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) com.dcloud.zxing2.pdf417.decoder.BarcodeValue.class, detectionResult.getBarcodeRowCount(), detectionResult.getBarcodeColumnCount() + 2);
        for (com.dcloud.zxing2.pdf417.decoder.BarcodeValue[] barcodeValueArr2 : barcodeValueArr) {
            int i = 0;
            while (true) {
                if (i < barcodeValueArr2.length) {
                    barcodeValueArr2[i] = new com.dcloud.zxing2.pdf417.decoder.BarcodeValue();
                    i++;
                }
            }
        }
        int i2 = 0;
        for (com.dcloud.zxing2.pdf417.decoder.DetectionResultColumn detectionResultColumn : detectionResult.getDetectionResultColumns()) {
            if (detectionResultColumn != null) {
                for (com.dcloud.zxing2.pdf417.decoder.Codeword codeword : detectionResultColumn.getCodewords()) {
                    if (codeword != null && (rowNumber = codeword.getRowNumber()) >= 0 && rowNumber < barcodeValueArr.length) {
                        barcodeValueArr[rowNumber][i2].setValue(codeword.getValue());
                    }
                }
            }
            i2++;
        }
        return barcodeValueArr;
    }

    private static com.dcloud.zxing2.common.DecoderResult createDecoderResult(com.dcloud.zxing2.pdf417.decoder.DetectionResult detectionResult) throws com.dcloud.zxing2.ChecksumException, com.dcloud.zxing2.FormatException, com.dcloud.zxing2.NotFoundException {
        com.dcloud.zxing2.pdf417.decoder.BarcodeValue[][] barcodeValueArrCreateBarcodeMatrix = createBarcodeMatrix(detectionResult);
        adjustCodewordCount(detectionResult, barcodeValueArrCreateBarcodeMatrix);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int[] iArr = new int[detectionResult.getBarcodeRowCount() * detectionResult.getBarcodeColumnCount()];
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        for (int i = 0; i < detectionResult.getBarcodeRowCount(); i++) {
            int i2 = 0;
            while (i2 < detectionResult.getBarcodeColumnCount()) {
                int i3 = i2 + 1;
                int[] value = barcodeValueArrCreateBarcodeMatrix[i][i3].getValue();
                int barcodeColumnCount = (detectionResult.getBarcodeColumnCount() * i) + i2;
                if (value.length == 0) {
                    arrayList.add(java.lang.Integer.valueOf(barcodeColumnCount));
                } else if (value.length == 1) {
                    iArr[barcodeColumnCount] = value[0];
                } else {
                    arrayList3.add(java.lang.Integer.valueOf(barcodeColumnCount));
                    arrayList2.add(value);
                }
                i2 = i3;
            }
        }
        int size = arrayList2.size();
        int[][] iArr2 = new int[size][];
        for (int i4 = 0; i4 < size; i4++) {
            iArr2[i4] = (int[]) arrayList2.get(i4);
        }
        return createDecoderResultFromAmbiguousValues(detectionResult.getBarcodeECLevel(), iArr, com.dcloud.zxing2.pdf417.PDF417Common.toIntArray(arrayList), com.dcloud.zxing2.pdf417.PDF417Common.toIntArray(arrayList3), iArr2);
    }

    private static com.dcloud.zxing2.common.DecoderResult createDecoderResultFromAmbiguousValues(int i, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws com.dcloud.zxing2.ChecksumException, com.dcloud.zxing2.FormatException {
        int length = iArr3.length;
        int[] iArr5 = new int[length];
        int i2 = 100;
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0) {
                throw com.dcloud.zxing2.ChecksumException.getChecksumInstance();
            }
            for (int i4 = 0; i4 < length; i4++) {
                iArr[iArr3[i4]] = iArr4[i4][iArr5[i4]];
            }
            try {
                return decodeCodewords(iArr, i, iArr2);
            } catch (com.dcloud.zxing2.ChecksumException unused) {
                if (length == 0) {
                    throw com.dcloud.zxing2.ChecksumException.getChecksumInstance();
                }
                for (int i5 = 0; i5 < length; i5++) {
                    int i6 = iArr5[i5];
                    if (i6 < iArr4[i5].length - 1) {
                        iArr5[i5] = i6 + 1;
                        break;
                    }
                    iArr5[i5] = 0;
                    if (i5 == length - 1) {
                        throw com.dcloud.zxing2.ChecksumException.getChecksumInstance();
                    }
                }
                i2 = i3;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:59:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:78:0x010b A[SYNTHETIC] */
    public static com.dcloud.zxing2.common.DecoderResult decode(com.dcloud.zxing2.common.BitMatrix bitMatrix, com.dcloud.zxing2.ResultPoint resultPoint, com.dcloud.zxing2.ResultPoint resultPoint2, com.dcloud.zxing2.ResultPoint resultPoint3, com.dcloud.zxing2.ResultPoint resultPoint4, int i, int i2) throws com.dcloud.zxing2.ChecksumException, com.dcloud.zxing2.FormatException, com.dcloud.zxing2.NotFoundException {
        com.dcloud.zxing2.pdf417.decoder.BoundingBox boundingBox;
        com.dcloud.zxing2.pdf417.decoder.DetectionResultColumn detectionResultColumn;
        int i3;
        com.dcloud.zxing2.pdf417.decoder.Codeword codewordDetectCodeword;
        com.dcloud.zxing2.pdf417.decoder.DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn = null;
        com.dcloud.zxing2.pdf417.decoder.BoundingBox boundingBox2 = new com.dcloud.zxing2.pdf417.decoder.BoundingBox(bitMatrix, resultPoint, resultPoint2, resultPoint3, resultPoint4);
        com.dcloud.zxing2.pdf417.decoder.DetectionResultRowIndicatorColumn rowIndicatorColumn = null;
        com.dcloud.zxing2.pdf417.decoder.DetectionResult detectionResultMerge = null;
        int i4 = 0;
        while (true) {
            if (i4 >= 2) {
                boundingBox = boundingBox2;
                break;
            }
            com.dcloud.zxing2.pdf417.decoder.DetectionResultRowIndicatorColumn rowIndicatorColumn2 = resultPoint != null ? getRowIndicatorColumn(bitMatrix, boundingBox2, resultPoint, true, i, i2) : detectionResultRowIndicatorColumn;
            if (resultPoint3 != null) {
                rowIndicatorColumn = getRowIndicatorColumn(bitMatrix, boundingBox2, resultPoint3, false, i, i2);
            }
            boundingBox = boundingBox2;
            detectionResultMerge = merge(rowIndicatorColumn2, rowIndicatorColumn);
            if (detectionResultMerge == null) {
                throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
            }
            if (i4 != 0 || detectionResultMerge.getBoundingBox() == null || (detectionResultMerge.getBoundingBox().getMinY() >= boundingBox.getMinY() && detectionResultMerge.getBoundingBox().getMaxY() <= boundingBox.getMaxY())) {
                detectionResultMerge.setBoundingBox(boundingBox);
                detectionResultRowIndicatorColumn = rowIndicatorColumn2;
                break;
            }
            boundingBox2 = detectionResultMerge.getBoundingBox();
            i4++;
            detectionResultRowIndicatorColumn = rowIndicatorColumn2;
        }
        com.dcloud.zxing2.pdf417.decoder.DetectionResult detectionResult = detectionResultMerge;
        int barcodeColumnCount = detectionResult.getBarcodeColumnCount() + 1;
        detectionResult.setDetectionResultColumn(0, detectionResultRowIndicatorColumn);
        detectionResult.setDetectionResultColumn(barcodeColumnCount, rowIndicatorColumn);
        boolean z = detectionResultRowIndicatorColumn != null;
        int i5 = i;
        int i6 = i2;
        for (int i7 = 1; i7 <= barcodeColumnCount; i7++) {
            int i8 = z ? i7 : barcodeColumnCount - i7;
            if (detectionResult.getDetectionResultColumn(i8) == null) {
                com.dcloud.zxing2.pdf417.decoder.DetectionResultColumn detectionResultRowIndicatorColumn2 = (i8 == 0 || i8 == barcodeColumnCount) ? new com.dcloud.zxing2.pdf417.decoder.DetectionResultRowIndicatorColumn(boundingBox, i8 == 0) : new com.dcloud.zxing2.pdf417.decoder.DetectionResultColumn(boundingBox);
                detectionResult.setDetectionResultColumn(i8, detectionResultRowIndicatorColumn2);
                int i9 = -1;
                int iMin = i5;
                int iMax = i6;
                int minY = boundingBox.getMinY();
                int i10 = -1;
                while (minY <= boundingBox.getMaxY()) {
                    int startColumn = getStartColumn(detectionResult, i8, minY, z);
                    if (startColumn >= 0 && startColumn <= boundingBox.getMaxX()) {
                        i3 = startColumn;
                        detectionResultColumn = detectionResultRowIndicatorColumn2;
                        codewordDetectCodeword = detectCodeword(bitMatrix, boundingBox.getMinX(), boundingBox.getMaxX(), z, i3, minY, iMin, iMax);
                        if (codewordDetectCodeword != null) {
                            detectionResultColumn.setCodeword(minY, codewordDetectCodeword);
                            iMin = java.lang.Math.min(iMin, codewordDetectCodeword.getWidth());
                            iMax = java.lang.Math.max(iMax, codewordDetectCodeword.getWidth());
                            i10 = i3;
                        }
                    } else if (i10 == i9) {
                        detectionResultColumn = detectionResultRowIndicatorColumn2;
                    } else {
                        startColumn = i10;
                        i3 = startColumn;
                        detectionResultColumn = detectionResultRowIndicatorColumn2;
                        codewordDetectCodeword = detectCodeword(bitMatrix, boundingBox.getMinX(), boundingBox.getMaxX(), z, i3, minY, iMin, iMax);
                        if (codewordDetectCodeword != null) {
                            detectionResultColumn.setCodeword(minY, codewordDetectCodeword);
                            iMin = java.lang.Math.min(iMin, codewordDetectCodeword.getWidth());
                            iMax = java.lang.Math.max(iMax, codewordDetectCodeword.getWidth());
                            i10 = i3;
                        }
                    }
                    minY++;
                    detectionResultRowIndicatorColumn2 = detectionResultColumn;
                    i9 = -1;
                }
                i5 = iMin;
                i6 = iMax;
            }
        }
        return createDecoderResult(detectionResult);
    }

    private static com.dcloud.zxing2.common.DecoderResult decodeCodewords(int[] iArr, int i, int[] iArr2) throws com.dcloud.zxing2.ChecksumException, com.dcloud.zxing2.FormatException {
        if (iArr.length == 0) {
            throw com.dcloud.zxing2.FormatException.getFormatInstance();
        }
        int i2 = 1 << (i + 1);
        int iCorrectErrors = correctErrors(iArr, iArr2, i2);
        verifyCodewordCount(iArr, i2);
        com.dcloud.zxing2.common.DecoderResult decoderResultDecode = com.dcloud.zxing2.pdf417.decoder.DecodedBitStreamParser.decode(iArr, java.lang.String.valueOf(i));
        decoderResultDecode.setErrorsCorrected(java.lang.Integer.valueOf(iCorrectErrors));
        decoderResultDecode.setErasures(java.lang.Integer.valueOf(iArr2.length));
        return decoderResultDecode;
    }

    private static com.dcloud.zxing2.pdf417.decoder.Codeword detectCodeword(com.dcloud.zxing2.common.BitMatrix bitMatrix, int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
        int i7;
        int decodedValue;
        int codeword;
        int iAdjustCodewordStartColumn = adjustCodewordStartColumn(bitMatrix, i, i2, z, i3, i4);
        int[] moduleBitCount = getModuleBitCount(bitMatrix, i, i2, z, iAdjustCodewordStartColumn, i4);
        if (moduleBitCount == null) {
            return null;
        }
        int bitCountSum = com.dcloud.zxing2.pdf417.PDF417Common.getBitCountSum(moduleBitCount);
        if (z) {
            i7 = iAdjustCodewordStartColumn + bitCountSum;
        } else {
            for (int i8 = 0; i8 < moduleBitCount.length / 2; i8++) {
                int i9 = moduleBitCount[i8];
                moduleBitCount[i8] = moduleBitCount[(moduleBitCount.length - 1) - i8];
                moduleBitCount[(moduleBitCount.length - 1) - i8] = i9;
            }
            iAdjustCodewordStartColumn -= bitCountSum;
            i7 = iAdjustCodewordStartColumn;
        }
        if (checkCodewordSkew(bitCountSum, i5, i6) && (codeword = com.dcloud.zxing2.pdf417.PDF417Common.getCodeword((decodedValue = com.dcloud.zxing2.pdf417.decoder.PDF417CodewordDecoder.getDecodedValue(moduleBitCount)))) != -1) {
            return new com.dcloud.zxing2.pdf417.decoder.Codeword(iAdjustCodewordStartColumn, i7, getCodewordBucketNumber(decodedValue), codeword);
        }
        return null;
    }

    private static com.dcloud.zxing2.pdf417.decoder.BarcodeMetadata getBarcodeMetadata(com.dcloud.zxing2.pdf417.decoder.DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn, com.dcloud.zxing2.pdf417.decoder.DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2) {
        com.dcloud.zxing2.pdf417.decoder.BarcodeMetadata barcodeMetadata;
        com.dcloud.zxing2.pdf417.decoder.BarcodeMetadata barcodeMetadata2;
        if (detectionResultRowIndicatorColumn == null || (barcodeMetadata = detectionResultRowIndicatorColumn.getBarcodeMetadata()) == null) {
            if (detectionResultRowIndicatorColumn2 == null) {
                return null;
            }
            return detectionResultRowIndicatorColumn2.getBarcodeMetadata();
        }
        if (detectionResultRowIndicatorColumn2 == null || (barcodeMetadata2 = detectionResultRowIndicatorColumn2.getBarcodeMetadata()) == null || barcodeMetadata.getColumnCount() == barcodeMetadata2.getColumnCount() || barcodeMetadata.getErrorCorrectionLevel() == barcodeMetadata2.getErrorCorrectionLevel() || barcodeMetadata.getRowCount() == barcodeMetadata2.getRowCount()) {
            return barcodeMetadata;
        }
        return null;
    }

    private static int[] getBitCountForCodeword(int i) {
        int[] iArr = new int[8];
        int i2 = 0;
        int i3 = 7;
        while (true) {
            int i4 = i & 1;
            if (i4 != i2) {
                i3--;
                if (i3 < 0) {
                    return iArr;
                }
                i2 = i4;
            }
            iArr[i3] = iArr[i3] + 1;
            i >>= 1;
        }
    }

    private static int getCodewordBucketNumber(int i) {
        return getCodewordBucketNumber(getBitCountForCodeword(i));
    }

    private static int getMax(int[] iArr) {
        int iMax = -1;
        for (int i : iArr) {
            iMax = java.lang.Math.max(iMax, i);
        }
        return iMax;
    }

    private static int[] getModuleBitCount(com.dcloud.zxing2.common.BitMatrix bitMatrix, int i, int i2, boolean z, int i3, int i4) {
        int[] iArr = new int[8];
        int i5 = z ? 1 : -1;
        int i6 = 0;
        boolean z2 = z;
        while (true) {
            if (((!z || i3 >= i2) && (z || i3 < i)) || i6 >= 8) {
                break;
            }
            if (bitMatrix.get(i3, i4) == z2) {
                iArr[i6] = iArr[i6] + 1;
                i3 += i5;
            } else {
                i6++;
                z2 = !z2;
            }
        }
        if (i6 == 8 || (((z && i3 == i2) || (!z && i3 == i)) && i6 == 7)) {
            return iArr;
        }
        return null;
    }

    private static int getNumberOfECCodeWords(int i) {
        return 2 << i;
    }

    private static com.dcloud.zxing2.pdf417.decoder.DetectionResultRowIndicatorColumn getRowIndicatorColumn(com.dcloud.zxing2.common.BitMatrix bitMatrix, com.dcloud.zxing2.pdf417.decoder.BoundingBox boundingBox, com.dcloud.zxing2.ResultPoint resultPoint, boolean z, int i, int i2) {
        com.dcloud.zxing2.pdf417.decoder.DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn = new com.dcloud.zxing2.pdf417.decoder.DetectionResultRowIndicatorColumn(boundingBox, z);
        int i3 = 0;
        while (i3 < 2) {
            int i4 = i3 == 0 ? 1 : -1;
            int x = (int) resultPoint.getX();
            for (int y = (int) resultPoint.getY(); y <= boundingBox.getMaxY() && y >= boundingBox.getMinY(); y += i4) {
                com.dcloud.zxing2.pdf417.decoder.Codeword codewordDetectCodeword = detectCodeword(bitMatrix, 0, bitMatrix.getWidth(), z, x, y, i, i2);
                if (codewordDetectCodeword != null) {
                    detectionResultRowIndicatorColumn.setCodeword(y, codewordDetectCodeword);
                    x = z ? codewordDetectCodeword.getStartX() : codewordDetectCodeword.getEndX();
                }
            }
            i3++;
        }
        return detectionResultRowIndicatorColumn;
    }

    private static int getStartColumn(com.dcloud.zxing2.pdf417.decoder.DetectionResult detectionResult, int i, int i2, boolean z) {
        int i3 = z ? 1 : -1;
        int i4 = i - i3;
        com.dcloud.zxing2.pdf417.decoder.Codeword codeword = isValidBarcodeColumn(detectionResult, i4) ? detectionResult.getDetectionResultColumn(i4).getCodeword(i2) : null;
        if (codeword != null) {
            return z ? codeword.getEndX() : codeword.getStartX();
        }
        com.dcloud.zxing2.pdf417.decoder.Codeword codewordNearby = detectionResult.getDetectionResultColumn(i).getCodewordNearby(i2);
        if (codewordNearby != null) {
            return z ? codewordNearby.getStartX() : codewordNearby.getEndX();
        }
        if (isValidBarcodeColumn(detectionResult, i4)) {
            codewordNearby = detectionResult.getDetectionResultColumn(i4).getCodewordNearby(i2);
        }
        if (codewordNearby != null) {
            return z ? codewordNearby.getEndX() : codewordNearby.getStartX();
        }
        int i5 = 0;
        while (true) {
            i -= i3;
            if (!isValidBarcodeColumn(detectionResult, i)) {
                return z ? detectionResult.getBoundingBox().getMinX() : detectionResult.getBoundingBox().getMaxX();
            }
            for (com.dcloud.zxing2.pdf417.decoder.Codeword codeword2 : detectionResult.getDetectionResultColumn(i).getCodewords()) {
                if (codeword2 != null) {
                    return (z ? codeword2.getEndX() : codeword2.getStartX()) + (i3 * i5 * (codeword2.getEndX() - codeword2.getStartX()));
                }
            }
            i5++;
        }
    }

    private static boolean isValidBarcodeColumn(com.dcloud.zxing2.pdf417.decoder.DetectionResult detectionResult, int i) {
        return i >= 0 && i <= detectionResult.getBarcodeColumnCount() + 1;
    }

    private static com.dcloud.zxing2.pdf417.decoder.DetectionResult merge(com.dcloud.zxing2.pdf417.decoder.DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn, com.dcloud.zxing2.pdf417.decoder.DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2) throws com.dcloud.zxing2.FormatException, com.dcloud.zxing2.NotFoundException {
        com.dcloud.zxing2.pdf417.decoder.BarcodeMetadata barcodeMetadata;
        if ((detectionResultRowIndicatorColumn == null && detectionResultRowIndicatorColumn2 == null) || (barcodeMetadata = getBarcodeMetadata(detectionResultRowIndicatorColumn, detectionResultRowIndicatorColumn2)) == null) {
            return null;
        }
        return new com.dcloud.zxing2.pdf417.decoder.DetectionResult(barcodeMetadata, com.dcloud.zxing2.pdf417.decoder.BoundingBox.merge(adjustBoundingBox(detectionResultRowIndicatorColumn), adjustBoundingBox(detectionResultRowIndicatorColumn2)));
    }

    public static java.lang.String toString(com.dcloud.zxing2.pdf417.decoder.BarcodeValue[][] barcodeValueArr) {
        java.util.Formatter formatter = new java.util.Formatter();
        for (int i = 0; i < barcodeValueArr.length; i++) {
            formatter.format("Row %2d: ", java.lang.Integer.valueOf(i));
            int i2 = 0;
            while (true) {
                com.dcloud.zxing2.pdf417.decoder.BarcodeValue[] barcodeValueArr2 = barcodeValueArr[i];
                if (i2 < barcodeValueArr2.length) {
                    com.dcloud.zxing2.pdf417.decoder.BarcodeValue barcodeValue = barcodeValueArr2[i2];
                    if (barcodeValue.getValue().length == 0) {
                        formatter.format("        ", null);
                    } else {
                        formatter.format("%4d(%2d)", java.lang.Integer.valueOf(barcodeValue.getValue()[0]), barcodeValue.getConfidence(barcodeValue.getValue()[0]));
                    }
                    i2++;
                }
            }
            formatter.format("%n", new java.lang.Object[0]);
        }
        java.lang.String string = formatter.toString();
        formatter.close();
        return string;
    }

    private static void verifyCodewordCount(int[] iArr, int i) throws com.dcloud.zxing2.FormatException {
        if (iArr.length < 4) {
            throw com.dcloud.zxing2.FormatException.getFormatInstance();
        }
        int i2 = iArr[0];
        if (i2 > iArr.length) {
            throw com.dcloud.zxing2.FormatException.getFormatInstance();
        }
        if (i2 == 0) {
            if (i >= iArr.length) {
                throw com.dcloud.zxing2.FormatException.getFormatInstance();
            }
            iArr[0] = iArr.length - i;
        }
    }

    private static int getCodewordBucketNumber(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }
}
