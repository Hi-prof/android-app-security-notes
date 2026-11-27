package com.dcloud.zxing2.oned;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class UPCAWriter implements com.dcloud.zxing2.Writer {
    private final com.dcloud.zxing2.oned.EAN13Writer subWriter = new com.dcloud.zxing2.oned.EAN13Writer();

    private static java.lang.String preencode(java.lang.String str) {
        int length = str.length();
        if (length == 11) {
            int iCharAt = 0;
            for (int i = 0; i < 11; i++) {
                iCharAt += (str.charAt(i) - '0') * (i % 2 == 0 ? 3 : 1);
            }
            str = str + ((1000 - iCharAt) % 10);
        } else if (length != 12) {
            throw new java.lang.IllegalArgumentException("Requested contents should be 11 or 12 digits long, but got " + str.length());
        }
        return com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT + str;
    }

    @Override // com.dcloud.zxing2.Writer
    public com.dcloud.zxing2.common.BitMatrix encode(java.lang.String str, com.dcloud.zxing2.BarcodeFormat barcodeFormat, int i, int i2) throws com.dcloud.zxing2.WriterException {
        return encode(str, barcodeFormat, i, i2, null);
    }

    @Override // com.dcloud.zxing2.Writer
    public com.dcloud.zxing2.common.BitMatrix encode(java.lang.String str, com.dcloud.zxing2.BarcodeFormat barcodeFormat, int i, int i2, java.util.Map<com.dcloud.zxing2.EncodeHintType, ?> map) throws com.dcloud.zxing2.WriterException {
        if (barcodeFormat == com.dcloud.zxing2.BarcodeFormat.UPC_A) {
            return this.subWriter.encode(preencode(str), com.dcloud.zxing2.BarcodeFormat.EAN_13, i, i2, map);
        }
        throw new java.lang.IllegalArgumentException("Can only encode UPC-A, but got " + barcodeFormat);
    }
}
