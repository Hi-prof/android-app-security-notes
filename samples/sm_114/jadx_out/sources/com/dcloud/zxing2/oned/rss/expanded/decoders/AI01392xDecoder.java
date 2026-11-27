package com.dcloud.zxing2.oned.rss.expanded.decoders;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class AI01392xDecoder extends com.dcloud.zxing2.oned.rss.expanded.decoders.AI01decoder {
    private static final int HEADER_SIZE = 8;
    private static final int LAST_DIGIT_SIZE = 2;

    AI01392xDecoder(com.dcloud.zxing2.common.BitArray bitArray) {
        super(bitArray);
    }

    @Override // com.dcloud.zxing2.oned.rss.expanded.decoders.AbstractExpandedDecoder
    public java.lang.String parseInformation() throws com.dcloud.zxing2.FormatException, com.dcloud.zxing2.NotFoundException {
        if (getInformation().getSize() < 48) {
            throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        encodeCompressedGtin(sb, 8);
        int iExtractNumericValueFromBitArray = getGeneralDecoder().extractNumericValueFromBitArray(48, 2);
        sb.append("(392");
        sb.append(iExtractNumericValueFromBitArray);
        sb.append(com.taobao.weex.el.parse.Operators.BRACKET_END);
        sb.append(getGeneralDecoder().decodeGeneralPurposeField(50, null).getNewString());
        return sb.toString();
    }
}
