package com.dcloud.zxing2.qrcode.detector;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class Detector {
    private final com.dcloud.zxing2.common.BitMatrix image;
    private com.dcloud.zxing2.ResultPointCallback resultPointCallback;

    public Detector(com.dcloud.zxing2.common.BitMatrix bitMatrix) {
        this.image = bitMatrix;
    }

    private float calculateModuleSizeOneWay(com.dcloud.zxing2.ResultPoint resultPoint, com.dcloud.zxing2.ResultPoint resultPoint2) {
        float fSizeOfBlackWhiteBlackRunBothWays = sizeOfBlackWhiteBlackRunBothWays((int) resultPoint.getX(), (int) resultPoint.getY(), (int) resultPoint2.getX(), (int) resultPoint2.getY());
        float fSizeOfBlackWhiteBlackRunBothWays2 = sizeOfBlackWhiteBlackRunBothWays((int) resultPoint2.getX(), (int) resultPoint2.getY(), (int) resultPoint.getX(), (int) resultPoint.getY());
        if (java.lang.Float.isNaN(fSizeOfBlackWhiteBlackRunBothWays)) {
            return fSizeOfBlackWhiteBlackRunBothWays2 / 7.0f;
        }
        return java.lang.Float.isNaN(fSizeOfBlackWhiteBlackRunBothWays2) ? fSizeOfBlackWhiteBlackRunBothWays / 7.0f : (fSizeOfBlackWhiteBlackRunBothWays + fSizeOfBlackWhiteBlackRunBothWays2) / 14.0f;
    }

    private static int computeDimension(com.dcloud.zxing2.ResultPoint resultPoint, com.dcloud.zxing2.ResultPoint resultPoint2, com.dcloud.zxing2.ResultPoint resultPoint3, float f) throws com.dcloud.zxing2.NotFoundException {
        int iRound = (com.dcloud.zxing2.common.detector.MathUtils.round(com.dcloud.zxing2.ResultPoint.distance(resultPoint, resultPoint2) / f) + com.dcloud.zxing2.common.detector.MathUtils.round(com.dcloud.zxing2.ResultPoint.distance(resultPoint, resultPoint3) / f)) / 2;
        int i = iRound + 7;
        int i2 = i & 3;
        if (i2 == 0) {
            return iRound + 8;
        }
        if (i2 == 2) {
            return iRound + 6;
        }
        if (i2 != 3) {
            return i;
        }
        throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
    }

    private static com.dcloud.zxing2.common.PerspectiveTransform createTransform(com.dcloud.zxing2.ResultPoint resultPoint, com.dcloud.zxing2.ResultPoint resultPoint2, com.dcloud.zxing2.ResultPoint resultPoint3, com.dcloud.zxing2.ResultPoint resultPoint4, int i) {
        float x;
        float y;
        float f;
        float f2 = i - 3.5f;
        if (resultPoint4 != null) {
            x = resultPoint4.getX();
            y = resultPoint4.getY();
            f = f2 - 3.0f;
        } else {
            x = (resultPoint2.getX() - resultPoint.getX()) + resultPoint3.getX();
            y = (resultPoint2.getY() - resultPoint.getY()) + resultPoint3.getY();
            f = f2;
        }
        return com.dcloud.zxing2.common.PerspectiveTransform.quadrilateralToQuadrilateral(3.5f, 3.5f, f2, 3.5f, f, f, 3.5f, f2, resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY(), x, y, resultPoint3.getX(), resultPoint3.getY());
    }

    private static com.dcloud.zxing2.common.BitMatrix sampleGrid(com.dcloud.zxing2.common.BitMatrix bitMatrix, com.dcloud.zxing2.common.PerspectiveTransform perspectiveTransform, int i) throws com.dcloud.zxing2.NotFoundException {
        return com.dcloud.zxing2.common.GridSampler.getInstance().sampleGrid(bitMatrix, i, i, perspectiveTransform);
    }

    private float sizeOfBlackWhiteBlackRun(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = 1;
        boolean z = java.lang.Math.abs(i4 - i2) > java.lang.Math.abs(i3 - i);
        if (z) {
            i6 = i;
            i5 = i2;
            i8 = i3;
            i7 = i4;
        } else {
            i5 = i;
            i6 = i2;
            i7 = i3;
            i8 = i4;
        }
        int iAbs = java.lang.Math.abs(i7 - i5);
        int iAbs2 = java.lang.Math.abs(i8 - i6);
        int i10 = (-iAbs) / 2;
        int i11 = i5 < i7 ? 1 : -1;
        int i12 = i6 < i8 ? 1 : -1;
        int i13 = i7 + i11;
        int i14 = i5;
        int i15 = i6;
        int i16 = 0;
        while (i14 != i13) {
            boolean z2 = z;
            int i17 = iAbs;
            if ((i16 == i9) == this.image.get(z ? i15 : i14, z ? i14 : i15)) {
                if (i16 == 2) {
                    return com.dcloud.zxing2.common.detector.MathUtils.distance(i14, i15, i5, i6);
                }
                i16++;
            }
            i10 += iAbs2;
            if (i10 > 0) {
                if (i15 == i8) {
                    break;
                }
                i15 += i12;
                i10 -= i17;
            }
            i14 += i11;
            iAbs = i17;
            z = z2;
            i9 = 1;
        }
        if (i16 == 2) {
            return com.dcloud.zxing2.common.detector.MathUtils.distance(i13, i8, i5, i6);
        }
        return Float.NaN;
    }

    private float sizeOfBlackWhiteBlackRunBothWays(int i, int i2, int i3, int i4) {
        float width;
        float height;
        float fSizeOfBlackWhiteBlackRun = sizeOfBlackWhiteBlackRun(i, i2, i3, i4);
        int width2 = i - (i3 - i);
        int height2 = 0;
        if (width2 < 0) {
            width = i / (i - width2);
            width2 = 0;
        } else if (width2 >= this.image.getWidth()) {
            width = ((this.image.getWidth() - 1) - i) / (width2 - i);
            width2 = this.image.getWidth() - 1;
        } else {
            width = 1.0f;
        }
        float f = i2;
        int i5 = (int) (f - ((i4 - i2) * width));
        if (i5 < 0) {
            height = f / (i2 - i5);
        } else if (i5 >= this.image.getHeight()) {
            height = ((this.image.getHeight() - 1) - i2) / (i5 - i2);
            height2 = this.image.getHeight() - 1;
        } else {
            height2 = i5;
            height = 1.0f;
        }
        return (fSizeOfBlackWhiteBlackRun + sizeOfBlackWhiteBlackRun(i, i2, (int) (i + ((width2 - i) * height)), height2)) - 1.0f;
    }

    protected final float calculateModuleSize(com.dcloud.zxing2.ResultPoint resultPoint, com.dcloud.zxing2.ResultPoint resultPoint2, com.dcloud.zxing2.ResultPoint resultPoint3) {
        return (calculateModuleSizeOneWay(resultPoint, resultPoint2) + calculateModuleSizeOneWay(resultPoint, resultPoint3)) / 2.0f;
    }

    public com.dcloud.zxing2.common.DetectorResult detect() throws com.dcloud.zxing2.FormatException, com.dcloud.zxing2.NotFoundException {
        return detect(null);
    }

    protected final com.dcloud.zxing2.qrcode.detector.AlignmentPattern findAlignmentInRegion(float f, int i, int i2, float f2) throws com.dcloud.zxing2.NotFoundException {
        int i3 = (int) (f2 * f);
        int iMax = java.lang.Math.max(0, i - i3);
        int iMin = java.lang.Math.min(this.image.getWidth() - 1, i + i3) - iMax;
        float f3 = 3.0f * f;
        if (iMin < f3) {
            throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
        }
        int iMax2 = java.lang.Math.max(0, i2 - i3);
        int iMin2 = java.lang.Math.min(this.image.getHeight() - 1, i2 + i3) - iMax2;
        if (iMin2 >= f3) {
            return new com.dcloud.zxing2.qrcode.detector.AlignmentPatternFinder(this.image, iMax, iMax2, iMin, iMin2, f, this.resultPointCallback).find();
        }
        throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
    }

    protected final com.dcloud.zxing2.common.BitMatrix getImage() {
        return this.image;
    }

    protected final com.dcloud.zxing2.ResultPointCallback getResultPointCallback() {
        return this.resultPointCallback;
    }

    protected final com.dcloud.zxing2.common.DetectorResult processFinderPatternInfo(com.dcloud.zxing2.qrcode.detector.FinderPatternInfo finderPatternInfo) throws com.dcloud.zxing2.FormatException, com.dcloud.zxing2.NotFoundException {
        com.dcloud.zxing2.qrcode.detector.AlignmentPattern alignmentPatternFindAlignmentInRegion;
        com.dcloud.zxing2.qrcode.detector.FinderPattern topLeft = finderPatternInfo.getTopLeft();
        com.dcloud.zxing2.qrcode.detector.FinderPattern topRight = finderPatternInfo.getTopRight();
        com.dcloud.zxing2.qrcode.detector.FinderPattern bottomLeft = finderPatternInfo.getBottomLeft();
        float fCalculateModuleSize = calculateModuleSize(topLeft, topRight, bottomLeft);
        if (fCalculateModuleSize < 1.0f) {
            throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
        }
        int iComputeDimension = computeDimension(topLeft, topRight, bottomLeft, fCalculateModuleSize);
        com.dcloud.zxing2.qrcode.decoder.Version provisionalVersionForDimension = com.dcloud.zxing2.qrcode.decoder.Version.getProvisionalVersionForDimension(iComputeDimension);
        int dimensionForVersion = provisionalVersionForDimension.getDimensionForVersion() - 7;
        if (provisionalVersionForDimension.getAlignmentPatternCenters().length <= 0) {
            alignmentPatternFindAlignmentInRegion = null;
            break;
        }
        float x = (topRight.getX() - topLeft.getX()) + bottomLeft.getX();
        float y = (topRight.getY() - topLeft.getY()) + bottomLeft.getY();
        float f = 1.0f - (3.0f / dimensionForVersion);
        int x2 = (int) (topLeft.getX() + ((x - topLeft.getX()) * f));
        int y2 = (int) (topLeft.getY() + (f * (y - topLeft.getY())));
        int i = 4;
        while (true) {
            if (i > 16) {
                alignmentPatternFindAlignmentInRegion = null;
                break;
            }
            try {
                alignmentPatternFindAlignmentInRegion = findAlignmentInRegion(fCalculateModuleSize, x2, y2, i);
                break;
            } catch (com.dcloud.zxing2.NotFoundException unused) {
                i <<= 1;
            }
        }
        com.dcloud.zxing2.common.DetectorResult detectorResult = new com.dcloud.zxing2.common.DetectorResult(sampleGrid(this.image, createTransform(topLeft, topRight, bottomLeft, alignmentPatternFindAlignmentInRegion, iComputeDimension), iComputeDimension), alignmentPatternFindAlignmentInRegion == null ? new com.dcloud.zxing2.ResultPoint[]{bottomLeft, topLeft, topRight} : new com.dcloud.zxing2.ResultPoint[]{bottomLeft, topLeft, topRight, alignmentPatternFindAlignmentInRegion});
        detectorResult.moduleSize = fCalculateModuleSize;
        return detectorResult;
    }

    public final com.dcloud.zxing2.common.DetectorResult detect(java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) throws com.dcloud.zxing2.FormatException, com.dcloud.zxing2.NotFoundException {
        com.dcloud.zxing2.ResultPointCallback resultPointCallback = map == null ? null : (com.dcloud.zxing2.ResultPointCallback) map.get(com.dcloud.zxing2.DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        this.resultPointCallback = resultPointCallback;
        return processFinderPatternInfo(new com.dcloud.zxing2.qrcode.detector.FinderPatternFinder(this.image, resultPointCallback).find(map));
    }
}
