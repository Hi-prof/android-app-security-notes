package com.dcloud.zxing2.qrcode.decoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class QRCodeDecoderMetaData {
    private final boolean mirrored;

    QRCodeDecoderMetaData(boolean z) {
        this.mirrored = z;
    }

    public void applyMirroredCorrection(com.dcloud.zxing2.ResultPoint[] resultPointArr) {
        if (!this.mirrored || resultPointArr == null || resultPointArr.length < 3) {
            return;
        }
        com.dcloud.zxing2.ResultPoint resultPoint = resultPointArr[0];
        resultPointArr[0] = resultPointArr[2];
        resultPointArr[2] = resultPoint;
    }

    public boolean isMirrored() {
        return this.mirrored;
    }
}
