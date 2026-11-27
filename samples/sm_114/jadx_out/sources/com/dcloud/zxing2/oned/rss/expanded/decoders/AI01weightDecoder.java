package com.dcloud.zxing2.oned.rss.expanded.decoders;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
abstract class AI01weightDecoder extends com.dcloud.zxing2.oned.rss.expanded.decoders.AI01decoder {
    AI01weightDecoder(com.dcloud.zxing2.common.BitArray bitArray) {
        super(bitArray);
    }

    protected abstract void addWeightCode(java.lang.StringBuilder sb, int i);

    protected abstract int checkWeight(int i);

    protected final void encodeCompressedWeight(java.lang.StringBuilder sb, int i, int i2) {
        int iExtractNumericValueFromBitArray = getGeneralDecoder().extractNumericValueFromBitArray(i, i2);
        addWeightCode(sb, iExtractNumericValueFromBitArray);
        int iCheckWeight = checkWeight(iExtractNumericValueFromBitArray);
        int i3 = 100000;
        for (int i4 = 0; i4 < 5; i4++) {
            if (iCheckWeight / i3 == 0) {
                sb.append('0');
            }
            i3 /= 10;
        }
        sb.append(iCheckWeight);
    }
}
