package com.dcloud.zxing2.oned.rss.expanded;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class BitArrayBuilder {
    private BitArrayBuilder() {
    }

    static com.dcloud.zxing2.common.BitArray buildBitArray(java.util.List<com.dcloud.zxing2.oned.rss.expanded.ExpandedPair> list) {
        int size = list.size() * 2;
        int i = size - 1;
        if (list.get(list.size() - 1).getRightChar() == null) {
            i = size - 2;
        }
        com.dcloud.zxing2.common.BitArray bitArray = new com.dcloud.zxing2.common.BitArray(i * 12);
        int i2 = 0;
        int value = list.get(0).getRightChar().getValue();
        for (int i3 = 11; i3 >= 0; i3--) {
            if (((1 << i3) & value) != 0) {
                bitArray.set(i2);
            }
            i2++;
        }
        for (int i4 = 1; i4 < list.size(); i4++) {
            com.dcloud.zxing2.oned.rss.expanded.ExpandedPair expandedPair = list.get(i4);
            int value2 = expandedPair.getLeftChar().getValue();
            for (int i5 = 11; i5 >= 0; i5--) {
                if (((1 << i5) & value2) != 0) {
                    bitArray.set(i2);
                }
                i2++;
            }
            if (expandedPair.getRightChar() != null) {
                int value3 = expandedPair.getRightChar().getValue();
                for (int i6 = 11; i6 >= 0; i6--) {
                    if (((1 << i6) & value3) != 0) {
                        bitArray.set(i2);
                    }
                    i2++;
                }
            }
        }
        return bitArray;
    }
}
