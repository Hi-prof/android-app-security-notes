package com.dcloud.zxing2.qrcode.detector;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class FinderPattern extends com.dcloud.zxing2.ResultPoint {
    private final int count;
    private final float estimatedModuleSize;

    FinderPattern(float f, float f2, float f3) {
        this(f, f2, f3, 1);
    }

    boolean aboutEquals(float f, float f2, float f3) {
        if (java.lang.Math.abs(f2 - getY()) > f || java.lang.Math.abs(f3 - getX()) > f) {
            return false;
        }
        float fAbs = java.lang.Math.abs(f - this.estimatedModuleSize);
        return fAbs <= 1.0f || fAbs <= this.estimatedModuleSize;
    }

    com.dcloud.zxing2.qrcode.detector.FinderPattern combineEstimate(float f, float f2, float f3) {
        int i = this.count;
        int i2 = i + 1;
        float x = (i * getX()) + f2;
        float f4 = i2;
        return new com.dcloud.zxing2.qrcode.detector.FinderPattern(x / f4, ((this.count * getY()) + f) / f4, ((this.count * this.estimatedModuleSize) + f3) / f4, i2);
    }

    int getCount() {
        return this.count;
    }

    public float getEstimatedModuleSize() {
        return this.estimatedModuleSize;
    }

    private FinderPattern(float f, float f2, float f3, int i) {
        super(f, f2);
        this.estimatedModuleSize = f3;
        this.count = i;
    }
}
