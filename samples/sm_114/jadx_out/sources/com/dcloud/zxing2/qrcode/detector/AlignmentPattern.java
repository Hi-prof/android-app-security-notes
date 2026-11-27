package com.dcloud.zxing2.qrcode.detector;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class AlignmentPattern extends com.dcloud.zxing2.ResultPoint {
    private final float estimatedModuleSize;

    AlignmentPattern(float f, float f2, float f3) {
        super(f, f2);
        this.estimatedModuleSize = f3;
    }

    boolean aboutEquals(float f, float f2, float f3) {
        if (java.lang.Math.abs(f2 - getY()) > f || java.lang.Math.abs(f3 - getX()) > f) {
            return false;
        }
        float fAbs = java.lang.Math.abs(f - this.estimatedModuleSize);
        return fAbs <= 1.0f || fAbs <= this.estimatedModuleSize;
    }

    com.dcloud.zxing2.qrcode.detector.AlignmentPattern combineEstimate(float f, float f2, float f3) {
        return new com.dcloud.zxing2.qrcode.detector.AlignmentPattern((getX() + f2) / 2.0f, (getY() + f) / 2.0f, (this.estimatedModuleSize + f3) / 2.0f);
    }
}
