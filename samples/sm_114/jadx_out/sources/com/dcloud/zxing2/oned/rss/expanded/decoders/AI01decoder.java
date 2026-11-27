package com.dcloud.zxing2.oned.rss.expanded.decoders;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
abstract class AI01decoder extends com.dcloud.zxing2.oned.rss.expanded.decoders.AbstractExpandedDecoder {
    protected static final int GTIN_SIZE = 40;

    AI01decoder(com.dcloud.zxing2.common.BitArray bitArray) {
        super(bitArray);
    }

    private static void appendCheckDigit(java.lang.StringBuilder sb, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < 13; i3++) {
            int iCharAt = sb.charAt(i3 + i) - '0';
            if ((i3 & 1) == 0) {
                iCharAt *= 3;
            }
            i2 += iCharAt;
        }
        int i4 = 10 - (i2 % 10);
        sb.append(i4 != 10 ? i4 : 0);
    }

    protected final void encodeCompressedGtin(java.lang.StringBuilder sb, int i) {
        sb.append("(01)");
        int length = sb.length();
        sb.append('9');
        encodeCompressedGtinWithoutAI(sb, i, length);
    }

    protected final void encodeCompressedGtinWithoutAI(java.lang.StringBuilder sb, int i, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            int iExtractNumericValueFromBitArray = getGeneralDecoder().extractNumericValueFromBitArray((i3 * 10) + i, 10);
            if (iExtractNumericValueFromBitArray / 100 == 0) {
                sb.append('0');
            }
            if (iExtractNumericValueFromBitArray / 10 == 0) {
                sb.append('0');
            }
            sb.append(iExtractNumericValueFromBitArray);
        }
        appendCheckDigit(sb, i2);
    }
}
