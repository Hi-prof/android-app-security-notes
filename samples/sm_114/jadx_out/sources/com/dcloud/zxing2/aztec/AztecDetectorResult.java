package com.dcloud.zxing2.aztec;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class AztecDetectorResult extends com.dcloud.zxing2.common.DetectorResult {
    private final boolean compact;
    private final int nbDatablocks;
    private final int nbLayers;

    public AztecDetectorResult(com.dcloud.zxing2.common.BitMatrix bitMatrix, com.dcloud.zxing2.ResultPoint[] resultPointArr, boolean z, int i, int i2) {
        super(bitMatrix, resultPointArr);
        this.compact = z;
        this.nbDatablocks = i;
        this.nbLayers = i2;
    }

    public int getNbDatablocks() {
        return this.nbDatablocks;
    }

    public int getNbLayers() {
        return this.nbLayers;
    }

    public boolean isCompact() {
        return this.compact;
    }
}
