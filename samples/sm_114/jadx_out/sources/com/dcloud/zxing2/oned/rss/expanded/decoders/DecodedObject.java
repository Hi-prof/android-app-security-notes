package com.dcloud.zxing2.oned.rss.expanded.decoders;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
abstract class DecodedObject {
    private final int newPosition;

    DecodedObject(int i) {
        this.newPosition = i;
    }

    final int getNewPosition() {
        return this.newPosition;
    }
}
