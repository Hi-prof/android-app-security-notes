package com.dcloud.zxing2.oned.rss.expanded.decoders;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class DecodedInformation extends com.dcloud.zxing2.oned.rss.expanded.decoders.DecodedObject {
    private final java.lang.String newString;
    private final boolean remaining;
    private final int remainingValue;

    DecodedInformation(int i, java.lang.String str) {
        super(i);
        this.newString = str;
        this.remaining = false;
        this.remainingValue = 0;
    }

    java.lang.String getNewString() {
        return this.newString;
    }

    int getRemainingValue() {
        return this.remainingValue;
    }

    boolean isRemaining() {
        return this.remaining;
    }

    DecodedInformation(int i, java.lang.String str, int i2) {
        super(i);
        this.remaining = true;
        this.remainingValue = i2;
        this.newString = str;
    }
}
