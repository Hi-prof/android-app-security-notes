package com.dcloud.zxing2;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class Result {
    private final com.dcloud.zxing2.BarcodeFormat format;
    private final byte[] rawBytes;
    private java.util.Map<com.dcloud.zxing2.ResultMetadataType, java.lang.Object> resultMetadata;
    private com.dcloud.zxing2.ResultPoint[] resultPoints;
    private final java.lang.String text;
    public java.lang.String textCharset;
    private final long timestamp;

    public Result(java.lang.String str, byte[] bArr, com.dcloud.zxing2.ResultPoint[] resultPointArr, com.dcloud.zxing2.BarcodeFormat barcodeFormat) {
        this(str, bArr, resultPointArr, barcodeFormat, java.lang.System.currentTimeMillis());
    }

    public void addResultPoints(com.dcloud.zxing2.ResultPoint[] resultPointArr) {
        com.dcloud.zxing2.ResultPoint[] resultPointArr2 = this.resultPoints;
        if (resultPointArr2 == null) {
            this.resultPoints = resultPointArr;
            return;
        }
        if (resultPointArr == null || resultPointArr.length <= 0) {
            return;
        }
        com.dcloud.zxing2.ResultPoint[] resultPointArr3 = new com.dcloud.zxing2.ResultPoint[resultPointArr2.length + resultPointArr.length];
        java.lang.System.arraycopy(resultPointArr2, 0, resultPointArr3, 0, resultPointArr2.length);
        java.lang.System.arraycopy(resultPointArr, 0, resultPointArr3, resultPointArr2.length, resultPointArr.length);
        this.resultPoints = resultPointArr3;
    }

    public com.dcloud.zxing2.BarcodeFormat getBarcodeFormat() {
        return this.format;
    }

    public byte[] getRawBytes() {
        return this.rawBytes;
    }

    public java.util.Map<com.dcloud.zxing2.ResultMetadataType, java.lang.Object> getResultMetadata() {
        return this.resultMetadata;
    }

    public com.dcloud.zxing2.ResultPoint[] getResultPoints() {
        return this.resultPoints;
    }

    public java.lang.String getText() {
        return this.text;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void putAllMetadata(java.util.Map<com.dcloud.zxing2.ResultMetadataType, java.lang.Object> map) {
        if (map != null) {
            java.util.Map<com.dcloud.zxing2.ResultMetadataType, java.lang.Object> map2 = this.resultMetadata;
            if (map2 == null) {
                this.resultMetadata = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public void putMetadata(com.dcloud.zxing2.ResultMetadataType resultMetadataType, java.lang.Object obj) {
        if (this.resultMetadata == null) {
            this.resultMetadata = new java.util.EnumMap(com.dcloud.zxing2.ResultMetadataType.class);
        }
        this.resultMetadata.put(resultMetadataType, obj);
    }

    public java.lang.String toString() {
        return this.text;
    }

    public Result(java.lang.String str, byte[] bArr, com.dcloud.zxing2.ResultPoint[] resultPointArr, com.dcloud.zxing2.BarcodeFormat barcodeFormat, long j) {
        this.text = str;
        this.rawBytes = bArr;
        this.resultPoints = resultPointArr;
        this.format = barcodeFormat;
        this.resultMetadata = null;
        this.timestamp = j;
    }
}
