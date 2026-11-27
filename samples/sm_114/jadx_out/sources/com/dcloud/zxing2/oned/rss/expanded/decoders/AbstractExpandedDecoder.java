package com.dcloud.zxing2.oned.rss.expanded.decoders;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractExpandedDecoder {
    private final com.dcloud.zxing2.oned.rss.expanded.decoders.GeneralAppIdDecoder generalDecoder;
    private final com.dcloud.zxing2.common.BitArray information;

    AbstractExpandedDecoder(com.dcloud.zxing2.common.BitArray bitArray) {
        this.information = bitArray;
        this.generalDecoder = new com.dcloud.zxing2.oned.rss.expanded.decoders.GeneralAppIdDecoder(bitArray);
    }

    public static com.dcloud.zxing2.oned.rss.expanded.decoders.AbstractExpandedDecoder createDecoder(com.dcloud.zxing2.common.BitArray bitArray) {
        if (bitArray.get(1)) {
            return new com.dcloud.zxing2.oned.rss.expanded.decoders.AI01AndOtherAIs(bitArray);
        }
        if (!bitArray.get(2)) {
            return new com.dcloud.zxing2.oned.rss.expanded.decoders.AnyAIDecoder(bitArray);
        }
        int iExtractNumericValueFromBitArray = com.dcloud.zxing2.oned.rss.expanded.decoders.GeneralAppIdDecoder.extractNumericValueFromBitArray(bitArray, 1, 4);
        if (iExtractNumericValueFromBitArray == 4) {
            return new com.dcloud.zxing2.oned.rss.expanded.decoders.AI013103decoder(bitArray);
        }
        if (iExtractNumericValueFromBitArray == 5) {
            return new com.dcloud.zxing2.oned.rss.expanded.decoders.AI01320xDecoder(bitArray);
        }
        int iExtractNumericValueFromBitArray2 = com.dcloud.zxing2.oned.rss.expanded.decoders.GeneralAppIdDecoder.extractNumericValueFromBitArray(bitArray, 1, 5);
        if (iExtractNumericValueFromBitArray2 == 12) {
            return new com.dcloud.zxing2.oned.rss.expanded.decoders.AI01392xDecoder(bitArray);
        }
        if (iExtractNumericValueFromBitArray2 == 13) {
            return new com.dcloud.zxing2.oned.rss.expanded.decoders.AI01393xDecoder(bitArray);
        }
        switch (com.dcloud.zxing2.oned.rss.expanded.decoders.GeneralAppIdDecoder.extractNumericValueFromBitArray(bitArray, 1, 7)) {
            case 56:
                return new com.dcloud.zxing2.oned.rss.expanded.decoders.AI013x0x1xDecoder(bitArray, "310", "11");
            case com.alibaba.fastjson.asm.Opcodes.DSTORE /* 57 */:
                return new com.dcloud.zxing2.oned.rss.expanded.decoders.AI013x0x1xDecoder(bitArray, "320", "11");
            case 58:
                return new com.dcloud.zxing2.oned.rss.expanded.decoders.AI013x0x1xDecoder(bitArray, "310", "13");
            case 59:
                return new com.dcloud.zxing2.oned.rss.expanded.decoders.AI013x0x1xDecoder(bitArray, "320", "13");
            case 60:
                return new com.dcloud.zxing2.oned.rss.expanded.decoders.AI013x0x1xDecoder(bitArray, "310", "15");
            case kotlinx.coroutines.internal.LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                return new com.dcloud.zxing2.oned.rss.expanded.decoders.AI013x0x1xDecoder(bitArray, "320", "15");
            case 62:
                return new com.dcloud.zxing2.oned.rss.expanded.decoders.AI013x0x1xDecoder(bitArray, "310", "17");
            case androidx.core.text.HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                return new com.dcloud.zxing2.oned.rss.expanded.decoders.AI013x0x1xDecoder(bitArray, "320", "17");
            default:
                throw new java.lang.IllegalStateException("unknown decoder: " + bitArray);
        }
    }

    protected final com.dcloud.zxing2.oned.rss.expanded.decoders.GeneralAppIdDecoder getGeneralDecoder() {
        return this.generalDecoder;
    }

    protected final com.dcloud.zxing2.common.BitArray getInformation() {
        return this.information;
    }

    public abstract java.lang.String parseInformation() throws com.dcloud.zxing2.FormatException, com.dcloud.zxing2.NotFoundException;
}
