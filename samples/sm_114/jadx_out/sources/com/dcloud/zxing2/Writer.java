package com.dcloud.zxing2;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface Writer {
    com.dcloud.zxing2.common.BitMatrix encode(java.lang.String str, com.dcloud.zxing2.BarcodeFormat barcodeFormat, int i, int i2) throws com.dcloud.zxing2.WriterException;

    com.dcloud.zxing2.common.BitMatrix encode(java.lang.String str, com.dcloud.zxing2.BarcodeFormat barcodeFormat, int i, int i2, java.util.Map<com.dcloud.zxing2.EncodeHintType, ?> map) throws com.dcloud.zxing2.WriterException;
}
