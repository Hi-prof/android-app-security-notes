package com.dcloud.zxing2.common;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class DetectorResult {
    private final com.dcloud.zxing2.common.BitMatrix bits;
    public float moduleSize = -1.0f;
    private final com.dcloud.zxing2.ResultPoint[] points;

    public DetectorResult(com.dcloud.zxing2.common.BitMatrix bitMatrix, com.dcloud.zxing2.ResultPoint[] resultPointArr) {
        this.bits = bitMatrix;
        this.points = resultPointArr;
    }

    public final com.dcloud.zxing2.common.BitMatrix getBits() {
        return this.bits;
    }

    public final com.dcloud.zxing2.ResultPoint[] getPoints() {
        return this.points;
    }
}
