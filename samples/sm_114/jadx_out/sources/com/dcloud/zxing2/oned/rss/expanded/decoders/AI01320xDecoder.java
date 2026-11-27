package com.dcloud.zxing2.oned.rss.expanded.decoders;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class AI01320xDecoder extends com.dcloud.zxing2.oned.rss.expanded.decoders.AI013x0xDecoder {
    AI01320xDecoder(com.dcloud.zxing2.common.BitArray bitArray) {
        super(bitArray);
    }

    @Override // com.dcloud.zxing2.oned.rss.expanded.decoders.AI01weightDecoder
    protected void addWeightCode(java.lang.StringBuilder sb, int i) {
        if (i < 10000) {
            sb.append("(3202)");
        } else {
            sb.append("(3203)");
        }
    }

    @Override // com.dcloud.zxing2.oned.rss.expanded.decoders.AI01weightDecoder
    protected int checkWeight(int i) {
        return i < 10000 ? i : i - io.dcloud.feature.gg.dcloud.ADSim.INTISPLSH;
    }
}
