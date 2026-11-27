package com.dcloud.zxing2.oned.rss;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class Pair extends com.dcloud.zxing2.oned.rss.DataCharacter {
    private int count;
    private final com.dcloud.zxing2.oned.rss.FinderPattern finderPattern;

    Pair(int i, int i2, com.dcloud.zxing2.oned.rss.FinderPattern finderPattern) {
        super(i, i2);
        this.finderPattern = finderPattern;
    }

    int getCount() {
        return this.count;
    }

    com.dcloud.zxing2.oned.rss.FinderPattern getFinderPattern() {
        return this.finderPattern;
    }

    void incrementCount() {
        this.count++;
    }
}
