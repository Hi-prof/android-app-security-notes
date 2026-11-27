package com.dcloud.zxing2.multi.qrcode.detector;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class MultiFinderPatternFinder extends com.dcloud.zxing2.qrcode.detector.FinderPatternFinder {
    private static final float DIFF_MODSIZE_CUTOFF = 0.5f;
    private static final float DIFF_MODSIZE_CUTOFF_PERCENT = 0.05f;
    private static final com.dcloud.zxing2.qrcode.detector.FinderPatternInfo[] EMPTY_RESULT_ARRAY = new com.dcloud.zxing2.qrcode.detector.FinderPatternInfo[0];
    private static final float MAX_MODULE_COUNT_PER_EDGE = 180.0f;
    private static final float MIN_MODULE_COUNT_PER_EDGE = 9.0f;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private static final class ModuleSizeComparator implements java.util.Comparator<com.dcloud.zxing2.qrcode.detector.FinderPattern>, java.io.Serializable {
        private ModuleSizeComparator() {
        }

        @Override // java.util.Comparator
        public int compare(com.dcloud.zxing2.qrcode.detector.FinderPattern finderPattern, com.dcloud.zxing2.qrcode.detector.FinderPattern finderPattern2) {
            double estimatedModuleSize = finderPattern2.getEstimatedModuleSize() - finderPattern.getEstimatedModuleSize();
            if (estimatedModuleSize < 0.0d) {
                return -1;
            }
            return estimatedModuleSize > 0.0d ? 1 : 0;
        }
    }

    MultiFinderPatternFinder(com.dcloud.zxing2.common.BitMatrix bitMatrix) {
        super(bitMatrix);
    }

    private com.dcloud.zxing2.qrcode.detector.FinderPattern[][] selectMutipleBestPatterns() throws com.dcloud.zxing2.NotFoundException {
        java.util.List<com.dcloud.zxing2.qrcode.detector.FinderPattern> possibleCenters = getPossibleCenters();
        int size = possibleCenters.size();
        int i = 3;
        if (size < 3) {
            throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
        }
        if (size == 3) {
            return new com.dcloud.zxing2.qrcode.detector.FinderPattern[][]{new com.dcloud.zxing2.qrcode.detector.FinderPattern[]{possibleCenters.get(0), possibleCenters.get(1), possibleCenters.get(2)}};
        }
        java.util.Collections.sort(possibleCenters, new com.dcloud.zxing2.multi.qrcode.detector.MultiFinderPatternFinder.ModuleSizeComparator());
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i2 = 0;
        while (i2 < size - 2) {
            com.dcloud.zxing2.qrcode.detector.FinderPattern finderPattern = possibleCenters.get(i2);
            if (finderPattern != null) {
                int i3 = i2 + 1;
                while (i3 < size - 1) {
                    com.dcloud.zxing2.qrcode.detector.FinderPattern finderPattern2 = possibleCenters.get(i3);
                    if (finderPattern2 != null) {
                        float estimatedModuleSize = (finderPattern.getEstimatedModuleSize() - finderPattern2.getEstimatedModuleSize()) / java.lang.Math.min(finderPattern.getEstimatedModuleSize(), finderPattern2.getEstimatedModuleSize());
                        float f = 0.05f;
                        float f2 = 0.5f;
                        if (java.lang.Math.abs(finderPattern.getEstimatedModuleSize() - finderPattern2.getEstimatedModuleSize()) > 0.5f && estimatedModuleSize >= 0.05f) {
                            break;
                        }
                        int i4 = i3 + 1;
                        while (true) {
                            if (i4 >= size) {
                                break;
                                break;
                            }
                            com.dcloud.zxing2.qrcode.detector.FinderPattern finderPattern3 = possibleCenters.get(i4);
                            if (finderPattern3 != null) {
                                float estimatedModuleSize2 = (finderPattern2.getEstimatedModuleSize() - finderPattern3.getEstimatedModuleSize()) / java.lang.Math.min(finderPattern2.getEstimatedModuleSize(), finderPattern3.getEstimatedModuleSize());
                                if (java.lang.Math.abs(finderPattern2.getEstimatedModuleSize() - finderPattern3.getEstimatedModuleSize()) > f2 && estimatedModuleSize2 >= f) {
                                    break;
                                }
                                com.dcloud.zxing2.qrcode.detector.FinderPattern[] finderPatternArr = new com.dcloud.zxing2.qrcode.detector.FinderPattern[i];
                                finderPatternArr[0] = finderPattern;
                                finderPatternArr[1] = finderPattern2;
                                finderPatternArr[2] = finderPattern3;
                                com.dcloud.zxing2.ResultPoint.orderBestPatterns(finderPatternArr);
                                com.dcloud.zxing2.qrcode.detector.FinderPatternInfo finderPatternInfo = new com.dcloud.zxing2.qrcode.detector.FinderPatternInfo(finderPatternArr);
                                float fDistance = com.dcloud.zxing2.ResultPoint.distance(finderPatternInfo.getTopLeft(), finderPatternInfo.getBottomLeft());
                                float fDistance2 = com.dcloud.zxing2.ResultPoint.distance(finderPatternInfo.getTopRight(), finderPatternInfo.getBottomLeft());
                                float fDistance3 = com.dcloud.zxing2.ResultPoint.distance(finderPatternInfo.getTopLeft(), finderPatternInfo.getTopRight());
                                float estimatedModuleSize3 = (fDistance + fDistance3) / (finderPattern.getEstimatedModuleSize() * 2.0f);
                                if (estimatedModuleSize3 <= MAX_MODULE_COUNT_PER_EDGE && estimatedModuleSize3 >= MIN_MODULE_COUNT_PER_EDGE && java.lang.Math.abs((fDistance - fDistance3) / java.lang.Math.min(fDistance, fDistance3)) < 0.1f) {
                                    float fSqrt = (float) java.lang.Math.sqrt((fDistance * fDistance) + (fDistance3 * fDistance3));
                                    if (java.lang.Math.abs((fDistance2 - fSqrt) / java.lang.Math.min(fDistance2, fSqrt)) < 0.1f) {
                                        arrayList.add(finderPatternArr);
                                    }
                                }
                            }
                            i4++;
                            i = 3;
                            f = 0.05f;
                            f2 = 0.5f;
                        }
                    } else {
                        break;
                    }
                    i3++;
                    i = 3;
                }
            }
            i2++;
            i = 3;
        }
        if (arrayList.isEmpty()) {
            throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
        }
        return (com.dcloud.zxing2.qrcode.detector.FinderPattern[][]) arrayList.toArray(new com.dcloud.zxing2.qrcode.detector.FinderPattern[arrayList.size()][]);
    }

    public com.dcloud.zxing2.qrcode.detector.FinderPatternInfo[] findMulti(java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) throws com.dcloud.zxing2.NotFoundException {
        boolean z = map != null && map.containsKey(com.dcloud.zxing2.DecodeHintType.TRY_HARDER);
        boolean z2 = map != null && map.containsKey(com.dcloud.zxing2.DecodeHintType.PURE_BARCODE);
        com.dcloud.zxing2.common.BitMatrix image = getImage();
        int height = image.getHeight();
        int width = image.getWidth();
        int i = (int) ((height / 228.0f) * 3.0f);
        if (i < 3 || z) {
            i = 3;
        }
        int[] iArr = new int[5];
        for (int i2 = i - 1; i2 < height; i2 += i) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < width; i4++) {
                if (image.get(i4, i2)) {
                    if ((i3 & 1) == 1) {
                        i3++;
                    }
                    iArr[i3] = iArr[i3] + 1;
                } else if ((i3 & 1) != 0) {
                    iArr[i3] = iArr[i3] + 1;
                } else if (i3 != 4) {
                    i3++;
                    iArr[i3] = iArr[i3] + 1;
                } else if (com.dcloud.zxing2.qrcode.detector.FinderPatternFinder.foundPatternCross(iArr) && handlePossibleCenter(iArr, i2, i4, z2)) {
                    iArr[0] = 0;
                    iArr[1] = 0;
                    iArr[2] = 0;
                    iArr[3] = 0;
                    iArr[4] = 0;
                    i3 = 0;
                } else {
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = iArr[4];
                    iArr[3] = 1;
                    iArr[4] = 0;
                    i3 = 3;
                }
            }
            if (com.dcloud.zxing2.qrcode.detector.FinderPatternFinder.foundPatternCross(iArr)) {
                handlePossibleCenter(iArr, i2, width, z2);
            }
        }
        com.dcloud.zxing2.qrcode.detector.FinderPattern[][] finderPatternArrSelectMutipleBestPatterns = selectMutipleBestPatterns();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.dcloud.zxing2.qrcode.detector.FinderPattern[] finderPatternArr : finderPatternArrSelectMutipleBestPatterns) {
            com.dcloud.zxing2.ResultPoint.orderBestPatterns(finderPatternArr);
            arrayList.add(new com.dcloud.zxing2.qrcode.detector.FinderPatternInfo(finderPatternArr));
        }
        return arrayList.isEmpty() ? EMPTY_RESULT_ARRAY : (com.dcloud.zxing2.qrcode.detector.FinderPatternInfo[]) arrayList.toArray(new com.dcloud.zxing2.qrcode.detector.FinderPatternInfo[arrayList.size()]);
    }

    MultiFinderPatternFinder(com.dcloud.zxing2.common.BitMatrix bitMatrix, com.dcloud.zxing2.ResultPointCallback resultPointCallback) {
        super(bitMatrix, resultPointCallback);
    }
}
