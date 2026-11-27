package com.dcloud.zxing2.datamatrix.detector;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class Detector {
    private final com.dcloud.zxing2.common.BitMatrix image;
    private final com.dcloud.zxing2.common.detector.WhiteRectangleDetector rectangleDetector;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private static final class ResultPointsAndTransitions {
        private final com.dcloud.zxing2.ResultPoint from;
        private final com.dcloud.zxing2.ResultPoint to;
        private final int transitions;

        com.dcloud.zxing2.ResultPoint getFrom() {
            return this.from;
        }

        com.dcloud.zxing2.ResultPoint getTo() {
            return this.to;
        }

        public int getTransitions() {
            return this.transitions;
        }

        public java.lang.String toString() {
            return this.from + "/" + this.to + '/' + this.transitions;
        }

        private ResultPointsAndTransitions(com.dcloud.zxing2.ResultPoint resultPoint, com.dcloud.zxing2.ResultPoint resultPoint2, int i) {
            this.from = resultPoint;
            this.to = resultPoint2;
            this.transitions = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private static final class ResultPointsAndTransitionsComparator implements java.util.Comparator<com.dcloud.zxing2.datamatrix.detector.Detector.ResultPointsAndTransitions>, java.io.Serializable {
        private ResultPointsAndTransitionsComparator() {
        }

        @Override // java.util.Comparator
        public int compare(com.dcloud.zxing2.datamatrix.detector.Detector.ResultPointsAndTransitions resultPointsAndTransitions, com.dcloud.zxing2.datamatrix.detector.Detector.ResultPointsAndTransitions resultPointsAndTransitions2) {
            return resultPointsAndTransitions.getTransitions() - resultPointsAndTransitions2.getTransitions();
        }
    }

    public Detector(com.dcloud.zxing2.common.BitMatrix bitMatrix) throws com.dcloud.zxing2.NotFoundException {
        this.image = bitMatrix;
        this.rectangleDetector = new com.dcloud.zxing2.common.detector.WhiteRectangleDetector(bitMatrix);
    }

    private com.dcloud.zxing2.ResultPoint correctTopRight(com.dcloud.zxing2.ResultPoint resultPoint, com.dcloud.zxing2.ResultPoint resultPoint2, com.dcloud.zxing2.ResultPoint resultPoint3, com.dcloud.zxing2.ResultPoint resultPoint4, int i) {
        float f = i;
        float fDistance = distance(resultPoint, resultPoint2) / f;
        float fDistance2 = distance(resultPoint3, resultPoint4);
        com.dcloud.zxing2.ResultPoint resultPoint5 = new com.dcloud.zxing2.ResultPoint(resultPoint4.getX() + (((resultPoint4.getX() - resultPoint3.getX()) / fDistance2) * fDistance), resultPoint4.getY() + (fDistance * ((resultPoint4.getY() - resultPoint3.getY()) / fDistance2)));
        float fDistance3 = distance(resultPoint, resultPoint3) / f;
        float fDistance4 = distance(resultPoint2, resultPoint4);
        com.dcloud.zxing2.ResultPoint resultPoint6 = new com.dcloud.zxing2.ResultPoint(resultPoint4.getX() + (((resultPoint4.getX() - resultPoint2.getX()) / fDistance4) * fDistance3), resultPoint4.getY() + (fDistance3 * ((resultPoint4.getY() - resultPoint2.getY()) / fDistance4)));
        if (isValid(resultPoint5)) {
            if (!isValid(resultPoint6) || java.lang.Math.abs(transitionsBetween(resultPoint3, resultPoint5).getTransitions() - transitionsBetween(resultPoint2, resultPoint5).getTransitions()) <= java.lang.Math.abs(transitionsBetween(resultPoint3, resultPoint6).getTransitions() - transitionsBetween(resultPoint2, resultPoint6).getTransitions())) {
                return resultPoint5;
            }
        } else if (!isValid(resultPoint6)) {
            return null;
        }
        return resultPoint6;
    }

    private com.dcloud.zxing2.ResultPoint correctTopRightRectangular(com.dcloud.zxing2.ResultPoint resultPoint, com.dcloud.zxing2.ResultPoint resultPoint2, com.dcloud.zxing2.ResultPoint resultPoint3, com.dcloud.zxing2.ResultPoint resultPoint4, int i, int i2) {
        float fDistance = distance(resultPoint, resultPoint2) / i;
        float fDistance2 = distance(resultPoint3, resultPoint4);
        com.dcloud.zxing2.ResultPoint resultPoint5 = new com.dcloud.zxing2.ResultPoint(resultPoint4.getX() + (((resultPoint4.getX() - resultPoint3.getX()) / fDistance2) * fDistance), resultPoint4.getY() + (fDistance * ((resultPoint4.getY() - resultPoint3.getY()) / fDistance2)));
        float fDistance3 = distance(resultPoint, resultPoint3) / i2;
        float fDistance4 = distance(resultPoint2, resultPoint4);
        com.dcloud.zxing2.ResultPoint resultPoint6 = new com.dcloud.zxing2.ResultPoint(resultPoint4.getX() + (((resultPoint4.getX() - resultPoint2.getX()) / fDistance4) * fDistance3), resultPoint4.getY() + (fDistance3 * ((resultPoint4.getY() - resultPoint2.getY()) / fDistance4)));
        if (isValid(resultPoint5)) {
            if (!isValid(resultPoint6) || java.lang.Math.abs(i - transitionsBetween(resultPoint3, resultPoint5).getTransitions()) + java.lang.Math.abs(i2 - transitionsBetween(resultPoint2, resultPoint5).getTransitions()) <= java.lang.Math.abs(i - transitionsBetween(resultPoint3, resultPoint6).getTransitions()) + java.lang.Math.abs(i2 - transitionsBetween(resultPoint2, resultPoint6).getTransitions())) {
                return resultPoint5;
            }
        } else if (!isValid(resultPoint6)) {
            return null;
        }
        return resultPoint6;
    }

    private static int distance(com.dcloud.zxing2.ResultPoint resultPoint, com.dcloud.zxing2.ResultPoint resultPoint2) {
        return com.dcloud.zxing2.common.detector.MathUtils.round(com.dcloud.zxing2.ResultPoint.distance(resultPoint, resultPoint2));
    }

    private static void increment(java.util.Map<com.dcloud.zxing2.ResultPoint, java.lang.Integer> map, com.dcloud.zxing2.ResultPoint resultPoint) {
        java.lang.Integer num = map.get(resultPoint);
        map.put(resultPoint, java.lang.Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    private boolean isValid(com.dcloud.zxing2.ResultPoint resultPoint) {
        return resultPoint.getX() >= 0.0f && resultPoint.getX() < ((float) this.image.getWidth()) && resultPoint.getY() > 0.0f && resultPoint.getY() < ((float) this.image.getHeight());
    }

    private static com.dcloud.zxing2.common.BitMatrix sampleGrid(com.dcloud.zxing2.common.BitMatrix bitMatrix, com.dcloud.zxing2.ResultPoint resultPoint, com.dcloud.zxing2.ResultPoint resultPoint2, com.dcloud.zxing2.ResultPoint resultPoint3, com.dcloud.zxing2.ResultPoint resultPoint4, int i, int i2) throws com.dcloud.zxing2.NotFoundException {
        float f = i - 0.5f;
        float f2 = i2 - 0.5f;
        return com.dcloud.zxing2.common.GridSampler.getInstance().sampleGrid(bitMatrix, i, i2, 0.5f, 0.5f, f, 0.5f, f, f2, 0.5f, f2, resultPoint.getX(), resultPoint.getY(), resultPoint4.getX(), resultPoint4.getY(), resultPoint3.getX(), resultPoint3.getY(), resultPoint2.getX(), resultPoint2.getY());
    }

    private com.dcloud.zxing2.datamatrix.detector.Detector.ResultPointsAndTransitions transitionsBetween(com.dcloud.zxing2.ResultPoint resultPoint, com.dcloud.zxing2.ResultPoint resultPoint2) {
        int x = (int) resultPoint.getX();
        int y = (int) resultPoint.getY();
        int x2 = (int) resultPoint2.getX();
        int y2 = (int) resultPoint2.getY();
        int i = 0;
        boolean z = java.lang.Math.abs(y2 - y) > java.lang.Math.abs(x2 - x);
        if (!z) {
            y = x;
            x = y;
            y2 = x2;
            x2 = y2;
        }
        int iAbs = java.lang.Math.abs(y2 - y);
        int iAbs2 = java.lang.Math.abs(x2 - x);
        int i2 = (-iAbs) / 2;
        int i3 = x < x2 ? 1 : -1;
        int i4 = y >= y2 ? -1 : 1;
        boolean z2 = this.image.get(z ? x : y, z ? y : x);
        while (y != y2) {
            boolean z3 = this.image.get(z ? x : y, z ? y : x);
            if (z3 != z2) {
                i++;
                z2 = z3;
            }
            i2 += iAbs2;
            if (i2 > 0) {
                if (x == x2) {
                    break;
                }
                x += i3;
                i2 -= iAbs;
            }
            y += i4;
        }
        return new com.dcloud.zxing2.datamatrix.detector.Detector.ResultPointsAndTransitions(resultPoint, resultPoint2, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public com.dcloud.zxing2.common.DetectorResult detect() throws com.dcloud.zxing2.NotFoundException {
        com.dcloud.zxing2.ResultPoint resultPoint;
        com.dcloud.zxing2.ResultPoint resultPoint2;
        com.dcloud.zxing2.ResultPoint resultPoint3;
        com.dcloud.zxing2.common.BitMatrix bitMatrixSampleGrid;
        com.dcloud.zxing2.ResultPoint[] resultPointArrDetect = this.rectangleDetector.detect();
        com.dcloud.zxing2.ResultPoint resultPoint4 = resultPointArrDetect[0];
        com.dcloud.zxing2.ResultPoint resultPoint5 = resultPointArrDetect[1];
        com.dcloud.zxing2.ResultPoint resultPoint6 = resultPointArrDetect[2];
        com.dcloud.zxing2.ResultPoint resultPoint7 = resultPointArrDetect[3];
        java.util.ArrayList arrayList = new java.util.ArrayList(4);
        arrayList.add(transitionsBetween(resultPoint4, resultPoint5));
        arrayList.add(transitionsBetween(resultPoint4, resultPoint6));
        arrayList.add(transitionsBetween(resultPoint5, resultPoint7));
        arrayList.add(transitionsBetween(resultPoint6, resultPoint7));
        com.dcloud.zxing2.ResultPoint resultPoint8 = null;
        java.util.Collections.sort(arrayList, new com.dcloud.zxing2.datamatrix.detector.Detector.ResultPointsAndTransitionsComparator());
        com.dcloud.zxing2.datamatrix.detector.Detector.ResultPointsAndTransitions resultPointsAndTransitions = (com.dcloud.zxing2.datamatrix.detector.Detector.ResultPointsAndTransitions) arrayList.get(0);
        com.dcloud.zxing2.datamatrix.detector.Detector.ResultPointsAndTransitions resultPointsAndTransitions2 = (com.dcloud.zxing2.datamatrix.detector.Detector.ResultPointsAndTransitions) arrayList.get(1);
        java.util.HashMap map = new java.util.HashMap();
        increment(map, resultPointsAndTransitions.getFrom());
        increment(map, resultPointsAndTransitions.getTo());
        increment(map, resultPointsAndTransitions2.getFrom());
        increment(map, resultPointsAndTransitions2.getTo());
        com.dcloud.zxing2.ResultPoint resultPoint9 = null;
        com.dcloud.zxing2.ResultPoint resultPoint10 = null;
        for (java.util.Map.Entry entry : map.entrySet()) {
            com.dcloud.zxing2.ResultPoint resultPoint11 = (com.dcloud.zxing2.ResultPoint) entry.getKey();
            if (((java.lang.Integer) entry.getValue()).intValue() == 2) {
                resultPoint9 = resultPoint11;
            } else if (resultPoint8 == null) {
                resultPoint8 = resultPoint11;
            } else {
                resultPoint10 = resultPoint11;
            }
        }
        if (resultPoint8 == null || resultPoint9 == null || resultPoint10 == null) {
            throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
        }
        com.dcloud.zxing2.ResultPoint[] resultPointArr = {resultPoint8, resultPoint9, resultPoint10};
        com.dcloud.zxing2.ResultPoint.orderBestPatterns(resultPointArr);
        com.dcloud.zxing2.ResultPoint resultPoint12 = resultPointArr[0];
        com.dcloud.zxing2.ResultPoint resultPoint13 = resultPointArr[1];
        com.dcloud.zxing2.ResultPoint resultPoint14 = resultPointArr[2];
        if (!map.containsKey(resultPoint4)) {
            resultPoint6 = resultPoint4;
        } else if (!map.containsKey(resultPoint5)) {
            resultPoint6 = resultPoint5;
        } else if (map.containsKey(resultPoint6)) {
            resultPoint6 = resultPoint7;
        }
        int transitions = transitionsBetween(resultPoint14, resultPoint6).getTransitions();
        int transitions2 = transitionsBetween(resultPoint12, resultPoint6).getTransitions();
        if ((transitions & 1) == 1) {
            transitions++;
        }
        int i = transitions + 2;
        if ((transitions2 & 1) == 1) {
            transitions2++;
        }
        int i2 = transitions2 + 2;
        if (i * 4 >= i2 * 7 || i2 * 4 >= i * 7) {
            resultPoint = resultPoint12;
            com.dcloud.zxing2.ResultPoint resultPointCorrectTopRightRectangular = correctTopRightRectangular(resultPoint13, resultPoint, resultPoint14, resultPoint6, i, i2);
            if (resultPointCorrectTopRightRectangular != null) {
                resultPoint6 = resultPointCorrectTopRightRectangular;
            }
            int transitions3 = transitionsBetween(resultPoint14, resultPoint6).getTransitions();
            int transitions4 = transitionsBetween(resultPoint, resultPoint6).getTransitions();
            if ((transitions3 & 1) == 1) {
                transitions3++;
            }
            int i3 = transitions3;
            if ((transitions4 & 1) == 1) {
                transitions4++;
            }
            resultPoint2 = resultPoint13;
            resultPoint3 = resultPoint14;
            bitMatrixSampleGrid = sampleGrid(this.image, resultPoint3, resultPoint2, resultPoint, resultPoint6, i3, transitions4);
        } else {
            int iMin = java.lang.Math.min(i2, i);
            resultPoint = resultPoint12;
            com.dcloud.zxing2.ResultPoint resultPointCorrectTopRight = correctTopRight(resultPoint13, resultPoint, resultPoint14, resultPoint6, iMin);
            if (resultPointCorrectTopRight != null) {
                resultPoint6 = resultPointCorrectTopRight;
            }
            int iMax = java.lang.Math.max(transitionsBetween(resultPoint14, resultPoint6).getTransitions(), transitionsBetween(resultPoint, resultPoint6).getTransitions());
            int i4 = iMax + 1;
            if ((i4 & 1) == 1) {
                i4 = iMax + 2;
            }
            int i5 = i4;
            resultPoint2 = resultPoint13;
            resultPoint3 = resultPoint14;
            bitMatrixSampleGrid = sampleGrid(this.image, resultPoint3, resultPoint2, resultPoint, resultPoint6, i5, i5);
        }
        return new com.dcloud.zxing2.common.DetectorResult(bitMatrixSampleGrid, new com.dcloud.zxing2.ResultPoint[]{resultPoint3, resultPoint2, resultPoint, resultPoint6});
    }
}
