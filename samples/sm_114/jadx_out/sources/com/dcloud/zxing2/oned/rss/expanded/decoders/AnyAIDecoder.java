package com.dcloud.zxing2.oned.rss.expanded.decoders;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class AnyAIDecoder extends com.dcloud.zxing2.oned.rss.expanded.decoders.AbstractExpandedDecoder {
    private static final int HEADER_SIZE = 5;

    AnyAIDecoder(com.dcloud.zxing2.common.BitArray bitArray) {
        super(bitArray);
    }

    @Override // com.dcloud.zxing2.oned.rss.expanded.decoders.AbstractExpandedDecoder
    public java.lang.String parseInformation() throws com.dcloud.zxing2.FormatException, com.dcloud.zxing2.NotFoundException {
        return getGeneralDecoder().decodeAllCodes(new java.lang.StringBuilder(), 5);
    }
}
