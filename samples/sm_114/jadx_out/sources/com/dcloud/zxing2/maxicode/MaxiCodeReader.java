package com.dcloud.zxing2.maxicode;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class MaxiCodeReader implements com.dcloud.zxing2.Reader {
    private static final int MATRIX_HEIGHT = 33;
    private static final int MATRIX_WIDTH = 30;
    private static final com.dcloud.zxing2.ResultPoint[] NO_POINTS = new com.dcloud.zxing2.ResultPoint[0];
    private final com.dcloud.zxing2.maxicode.decoder.Decoder decoder = new com.dcloud.zxing2.maxicode.decoder.Decoder();

    private static com.dcloud.zxing2.common.BitMatrix extractPureBits(com.dcloud.zxing2.common.BitMatrix bitMatrix) throws com.dcloud.zxing2.NotFoundException {
        int[] enclosingRectangle = bitMatrix.getEnclosingRectangle();
        if (enclosingRectangle == null) {
            throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
        }
        int i = enclosingRectangle[0];
        int i2 = enclosingRectangle[1];
        int i3 = enclosingRectangle[2];
        int i4 = enclosingRectangle[3];
        com.dcloud.zxing2.common.BitMatrix bitMatrix2 = new com.dcloud.zxing2.common.BitMatrix(30, 33);
        for (int i5 = 0; i5 < 33; i5++) {
            int i6 = (((i5 * i4) + (i4 / 2)) / 33) + i2;
            for (int i7 = 0; i7 < 30; i7++) {
                if (bitMatrix.get(((((i7 * i3) + (i3 / 2)) + (((i5 & 1) * i3) / 2)) / 30) + i, i6)) {
                    bitMatrix2.set(i7, i5);
                }
            }
        }
        return bitMatrix2;
    }

    @Override // com.dcloud.zxing2.Reader
    public com.dcloud.zxing2.Result decode(com.dcloud.zxing2.BinaryBitmap binaryBitmap) throws com.dcloud.zxing2.ChecksumException, com.dcloud.zxing2.FormatException, com.dcloud.zxing2.NotFoundException {
        return decode(binaryBitmap, null);
    }

    @Override // com.dcloud.zxing2.Reader
    public void reset() {
    }

    @Override // com.dcloud.zxing2.Reader
    public com.dcloud.zxing2.Result decode(com.dcloud.zxing2.BinaryBitmap binaryBitmap, java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) throws com.dcloud.zxing2.ChecksumException, com.dcloud.zxing2.FormatException, com.dcloud.zxing2.NotFoundException {
        if (map == null || !map.containsKey(com.dcloud.zxing2.DecodeHintType.PURE_BARCODE)) {
            throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
        }
        com.dcloud.zxing2.common.DecoderResult decoderResultDecode = this.decoder.decode(extractPureBits(binaryBitmap.getBlackMatrix()), map);
        com.dcloud.zxing2.Result result = new com.dcloud.zxing2.Result(decoderResultDecode.getText(), decoderResultDecode.getRawBytes(), NO_POINTS, com.dcloud.zxing2.BarcodeFormat.MAXICODE);
        java.lang.String eCLevel = decoderResultDecode.getECLevel();
        if (eCLevel != null) {
            result.putMetadata(com.dcloud.zxing2.ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
        }
        return result;
    }
}
