package com.dcloud.zxing2.oned.rss.expanded.decoders;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class BlockParsedResult {
    private final com.dcloud.zxing2.oned.rss.expanded.decoders.DecodedInformation decodedInformation;
    private final boolean finished;

    BlockParsedResult(boolean z) {
        this(null, z);
    }

    com.dcloud.zxing2.oned.rss.expanded.decoders.DecodedInformation getDecodedInformation() {
        return this.decodedInformation;
    }

    boolean isFinished() {
        return this.finished;
    }

    BlockParsedResult(com.dcloud.zxing2.oned.rss.expanded.decoders.DecodedInformation decodedInformation, boolean z) {
        this.finished = z;
        this.decodedInformation = decodedInformation;
    }
}
