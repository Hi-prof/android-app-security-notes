package com.dcloud.zxing2.qrcode.detector;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class FinderPatternInfo {
    private final com.dcloud.zxing2.qrcode.detector.FinderPattern bottomLeft;
    private final com.dcloud.zxing2.qrcode.detector.FinderPattern topLeft;
    private final com.dcloud.zxing2.qrcode.detector.FinderPattern topRight;

    public FinderPatternInfo(com.dcloud.zxing2.qrcode.detector.FinderPattern[] finderPatternArr) {
        this.bottomLeft = finderPatternArr[0];
        this.topLeft = finderPatternArr[1];
        this.topRight = finderPatternArr[2];
    }

    public com.dcloud.zxing2.qrcode.detector.FinderPattern getBottomLeft() {
        return this.bottomLeft;
    }

    public com.dcloud.zxing2.qrcode.detector.FinderPattern getTopLeft() {
        return this.topLeft;
    }

    public com.dcloud.zxing2.qrcode.detector.FinderPattern getTopRight() {
        return this.topRight;
    }
}
