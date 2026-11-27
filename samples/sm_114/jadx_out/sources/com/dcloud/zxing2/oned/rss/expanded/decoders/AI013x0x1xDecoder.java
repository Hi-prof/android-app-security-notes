package com.dcloud.zxing2.oned.rss.expanded.decoders;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class AI013x0x1xDecoder extends com.dcloud.zxing2.oned.rss.expanded.decoders.AI01weightDecoder {
    private static final int DATE_SIZE = 16;
    private static final int HEADER_SIZE = 8;
    private static final int WEIGHT_SIZE = 20;
    private final java.lang.String dateCode;
    private final java.lang.String firstAIdigits;

    AI013x0x1xDecoder(com.dcloud.zxing2.common.BitArray bitArray, java.lang.String str, java.lang.String str2) {
        super(bitArray);
        this.dateCode = str2;
        this.firstAIdigits = str;
    }

    private void encodeCompressedDate(java.lang.StringBuilder sb, int i) {
        int iExtractNumericValueFromBitArray = getGeneralDecoder().extractNumericValueFromBitArray(i, 16);
        if (iExtractNumericValueFromBitArray == 38400) {
            return;
        }
        sb.append(com.taobao.weex.el.parse.Operators.BRACKET_START);
        sb.append(this.dateCode);
        sb.append(com.taobao.weex.el.parse.Operators.BRACKET_END);
        int i2 = iExtractNumericValueFromBitArray % 32;
        int i3 = iExtractNumericValueFromBitArray / 32;
        int i4 = (i3 % 12) + 1;
        int i5 = i3 / 12;
        if (i5 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i5);
        if (i4 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i4);
        if (i2 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i2);
    }

    @Override // com.dcloud.zxing2.oned.rss.expanded.decoders.AI01weightDecoder
    protected void addWeightCode(java.lang.StringBuilder sb, int i) {
        sb.append(com.taobao.weex.el.parse.Operators.BRACKET_START);
        sb.append(this.firstAIdigits);
        sb.append(i / 100000);
        sb.append(com.taobao.weex.el.parse.Operators.BRACKET_END);
    }

    @Override // com.dcloud.zxing2.oned.rss.expanded.decoders.AI01weightDecoder
    protected int checkWeight(int i) {
        return i % 100000;
    }

    @Override // com.dcloud.zxing2.oned.rss.expanded.decoders.AbstractExpandedDecoder
    public java.lang.String parseInformation() throws com.dcloud.zxing2.NotFoundException {
        if (getInformation().getSize() != 84) {
            throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        encodeCompressedGtin(sb, 8);
        encodeCompressedWeight(sb, 48, 20);
        encodeCompressedDate(sb, 68);
        return sb.toString();
    }
}
