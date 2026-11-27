package com.dcloud.zxing2.oned.rss.expanded.decoders;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class CurrentParsingState {
    private int position = 0;
    private com.dcloud.zxing2.oned.rss.expanded.decoders.CurrentParsingState.State encoding = com.dcloud.zxing2.oned.rss.expanded.decoders.CurrentParsingState.State.NUMERIC;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private enum State {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    CurrentParsingState() {
    }

    int getPosition() {
        return this.position;
    }

    void incrementPosition(int i) {
        this.position += i;
    }

    boolean isAlpha() {
        return this.encoding == com.dcloud.zxing2.oned.rss.expanded.decoders.CurrentParsingState.State.ALPHA;
    }

    boolean isIsoIec646() {
        return this.encoding == com.dcloud.zxing2.oned.rss.expanded.decoders.CurrentParsingState.State.ISO_IEC_646;
    }

    boolean isNumeric() {
        return this.encoding == com.dcloud.zxing2.oned.rss.expanded.decoders.CurrentParsingState.State.NUMERIC;
    }

    void setAlpha() {
        this.encoding = com.dcloud.zxing2.oned.rss.expanded.decoders.CurrentParsingState.State.ALPHA;
    }

    void setIsoIec646() {
        this.encoding = com.dcloud.zxing2.oned.rss.expanded.decoders.CurrentParsingState.State.ISO_IEC_646;
    }

    void setNumeric() {
        this.encoding = com.dcloud.zxing2.oned.rss.expanded.decoders.CurrentParsingState.State.NUMERIC;
    }

    void setPosition(int i) {
        this.position = i;
    }
}
