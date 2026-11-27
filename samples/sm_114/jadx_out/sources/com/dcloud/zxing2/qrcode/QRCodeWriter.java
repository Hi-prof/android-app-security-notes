package com.dcloud.zxing2.qrcode;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class QRCodeWriter implements com.dcloud.zxing2.Writer {
    private static final int QUIET_ZONE_SIZE = 4;

    private static com.dcloud.zxing2.common.BitMatrix renderResult(com.dcloud.zxing2.qrcode.encoder.QRCode qRCode, int i, int i2, int i3) {
        com.dcloud.zxing2.qrcode.encoder.ByteMatrix matrix = qRCode.getMatrix();
        if (matrix == null) {
            throw new java.lang.IllegalStateException();
        }
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        int i4 = i3 * 2;
        int i5 = width + i4;
        int i6 = i4 + height;
        int iMax = java.lang.Math.max(i, i5);
        int iMax2 = java.lang.Math.max(i2, i6);
        int iMin = java.lang.Math.min(iMax / i5, iMax2 / i6);
        int i7 = (iMax - (width * iMin)) / 2;
        int i8 = (iMax2 - (height * iMin)) / 2;
        com.dcloud.zxing2.common.BitMatrix bitMatrix = new com.dcloud.zxing2.common.BitMatrix(iMax, iMax2);
        int i9 = 0;
        while (i9 < height) {
            int i10 = i7;
            int i11 = 0;
            while (i11 < width) {
                if (matrix.get(i11, i9) == 1) {
                    bitMatrix.setRegion(i10, i8, iMin, iMin);
                }
                i11++;
                i10 += iMin;
            }
            i9++;
            i8 += iMin;
        }
        return bitMatrix;
    }

    @Override // com.dcloud.zxing2.Writer
    public com.dcloud.zxing2.common.BitMatrix encode(java.lang.String str, com.dcloud.zxing2.BarcodeFormat barcodeFormat, int i, int i2) throws com.dcloud.zxing2.WriterException {
        return encode(str, barcodeFormat, i, i2, null);
    }

    @Override // com.dcloud.zxing2.Writer
    public com.dcloud.zxing2.common.BitMatrix encode(java.lang.String str, com.dcloud.zxing2.BarcodeFormat barcodeFormat, int i, int i2, java.util.Map<com.dcloud.zxing2.EncodeHintType, ?> map) throws com.dcloud.zxing2.WriterException {
        if (str.isEmpty()) {
            throw new java.lang.IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != com.dcloud.zxing2.BarcodeFormat.QR_CODE) {
            throw new java.lang.IllegalArgumentException("Can only encode QR_CODE, but got " + barcodeFormat);
        }
        if (i < 0 || i2 < 0) {
            throw new java.lang.IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + i2);
        }
        com.dcloud.zxing2.qrcode.decoder.ErrorCorrectionLevel errorCorrectionLevelValueOf = com.dcloud.zxing2.qrcode.decoder.ErrorCorrectionLevel.L;
        int i3 = 4;
        if (map != null) {
            com.dcloud.zxing2.EncodeHintType encodeHintType = com.dcloud.zxing2.EncodeHintType.ERROR_CORRECTION;
            if (map.containsKey(encodeHintType)) {
                errorCorrectionLevelValueOf = com.dcloud.zxing2.qrcode.decoder.ErrorCorrectionLevel.valueOf(map.get(encodeHintType).toString());
            }
            com.dcloud.zxing2.EncodeHintType encodeHintType2 = com.dcloud.zxing2.EncodeHintType.MARGIN;
            if (map.containsKey(encodeHintType2)) {
                i3 = java.lang.Integer.parseInt(map.get(encodeHintType2).toString());
            }
        }
        return renderResult(com.dcloud.zxing2.qrcode.encoder.Encoder.encode(str, errorCorrectionLevelValueOf, map), i, i2, i3);
    }
}
