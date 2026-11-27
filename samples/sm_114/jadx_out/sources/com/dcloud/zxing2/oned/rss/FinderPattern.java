package com.dcloud.zxing2.oned.rss;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class FinderPattern {
    private final com.dcloud.zxing2.ResultPoint[] resultPoints;
    private final int[] startEnd;
    private final int value;

    public FinderPattern(int i, int[] iArr, int i2, int i3, int i4) {
        this.value = i;
        this.startEnd = iArr;
        float f = i2;
        float f2 = i4;
        this.resultPoints = new com.dcloud.zxing2.ResultPoint[]{new com.dcloud.zxing2.ResultPoint(f, f2), new com.dcloud.zxing2.ResultPoint(i3, f2)};
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof com.dcloud.zxing2.oned.rss.FinderPattern) && this.value == ((com.dcloud.zxing2.oned.rss.FinderPattern) obj).value;
    }

    public com.dcloud.zxing2.ResultPoint[] getResultPoints() {
        return this.resultPoints;
    }

    public int[] getStartEnd() {
        return this.startEnd;
    }

    public int getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value;
    }
}
