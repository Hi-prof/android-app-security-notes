package com.dcloud.zxing2;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public abstract class Binarizer {
    private final com.dcloud.zxing2.LuminanceSource source;

    protected Binarizer(com.dcloud.zxing2.LuminanceSource luminanceSource) {
        this.source = luminanceSource;
    }

    public abstract com.dcloud.zxing2.Binarizer createBinarizer(com.dcloud.zxing2.LuminanceSource luminanceSource);

    public abstract com.dcloud.zxing2.common.BitMatrix getBlackMatrix() throws com.dcloud.zxing2.NotFoundException;

    public abstract com.dcloud.zxing2.common.BitArray getBlackRow(int i, com.dcloud.zxing2.common.BitArray bitArray) throws com.dcloud.zxing2.NotFoundException;

    public final int getHeight() {
        return this.source.getHeight();
    }

    public final com.dcloud.zxing2.LuminanceSource getLuminanceSource() {
        return this.source;
    }

    public final int getWidth() {
        return this.source.getWidth();
    }
}
