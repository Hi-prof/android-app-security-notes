package com.dcloud.zxing2.oned.rss.expanded.decoders;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
abstract class AI013x0xDecoder extends com.dcloud.zxing2.oned.rss.expanded.decoders.AI01weightDecoder {
    private static final int HEADER_SIZE = 5;
    private static final int WEIGHT_SIZE = 15;

    AI013x0xDecoder(com.dcloud.zxing2.common.BitArray bitArray) {
        super(bitArray);
    }

    @Override // com.dcloud.zxing2.oned.rss.expanded.decoders.AbstractExpandedDecoder
    public java.lang.String parseInformation() throws com.dcloud.zxing2.NotFoundException {
        if (getInformation().getSize() != 60) {
            throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        encodeCompressedGtin(sb, 5);
        encodeCompressedWeight(sb, 45, 15);
        return sb.toString();
    }
}
