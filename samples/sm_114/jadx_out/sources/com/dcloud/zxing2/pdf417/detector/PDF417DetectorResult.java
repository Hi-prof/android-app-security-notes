package com.dcloud.zxing2.pdf417.detector;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class PDF417DetectorResult {
    private final com.dcloud.zxing2.common.BitMatrix bits;
    private final java.util.List<com.dcloud.zxing2.ResultPoint[]> points;

    public PDF417DetectorResult(com.dcloud.zxing2.common.BitMatrix bitMatrix, java.util.List<com.dcloud.zxing2.ResultPoint[]> list) {
        this.bits = bitMatrix;
        this.points = list;
    }

    public com.dcloud.zxing2.common.BitMatrix getBits() {
        return this.bits;
    }

    public java.util.List<com.dcloud.zxing2.ResultPoint[]> getPoints() {
        return this.points;
    }
}
