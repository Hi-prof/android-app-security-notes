package com.dcloud.zxing2.oned;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class UPCEANExtensionSupport {
    private static final int[] EXTENSION_START_PATTERN = {1, 1, 2};
    private final com.dcloud.zxing2.oned.UPCEANExtension2Support twoSupport = new com.dcloud.zxing2.oned.UPCEANExtension2Support();
    private final com.dcloud.zxing2.oned.UPCEANExtension5Support fiveSupport = new com.dcloud.zxing2.oned.UPCEANExtension5Support();

    UPCEANExtensionSupport() {
    }

    com.dcloud.zxing2.Result decodeRow(int i, com.dcloud.zxing2.common.BitArray bitArray, int i2) throws com.dcloud.zxing2.NotFoundException {
        int[] iArrFindGuardPattern = com.dcloud.zxing2.oned.UPCEANReader.findGuardPattern(bitArray, i2, false, EXTENSION_START_PATTERN);
        try {
            return this.fiveSupport.decodeRow(i, bitArray, iArrFindGuardPattern);
        } catch (com.dcloud.zxing2.ReaderException unused) {
            return this.twoSupport.decodeRow(i, bitArray, iArrFindGuardPattern);
        }
    }
}
