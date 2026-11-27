package com.dcloud.zxing2.multi;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface MultipleBarcodeReader {
    com.dcloud.zxing2.Result[] decodeMultiple(com.dcloud.zxing2.BinaryBitmap binaryBitmap) throws com.dcloud.zxing2.NotFoundException;

    com.dcloud.zxing2.Result[] decodeMultiple(com.dcloud.zxing2.BinaryBitmap binaryBitmap, java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) throws com.dcloud.zxing2.NotFoundException;
}
