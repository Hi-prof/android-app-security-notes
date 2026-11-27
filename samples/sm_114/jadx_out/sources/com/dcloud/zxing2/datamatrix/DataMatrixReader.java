package com.dcloud.zxing2.datamatrix;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class DataMatrixReader implements com.dcloud.zxing2.Reader {
    private static final com.dcloud.zxing2.ResultPoint[] NO_POINTS = new com.dcloud.zxing2.ResultPoint[0];
    private final com.dcloud.zxing2.datamatrix.decoder.Decoder decoder = new com.dcloud.zxing2.datamatrix.decoder.Decoder();

    private static com.dcloud.zxing2.common.BitMatrix extractPureBits(com.dcloud.zxing2.common.BitMatrix bitMatrix) throws com.dcloud.zxing2.NotFoundException {
        int[] topLeftOnBit = bitMatrix.getTopLeftOnBit();
        int[] bottomRightOnBit = bitMatrix.getBottomRightOnBit();
        if (topLeftOnBit == null || bottomRightOnBit == null) {
            throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
        }
        int iModuleSize = moduleSize(topLeftOnBit, bitMatrix);
        int i = topLeftOnBit[1];
        int i2 = bottomRightOnBit[1];
        int i3 = topLeftOnBit[0];
        int i4 = ((bottomRightOnBit[0] - i3) + 1) / iModuleSize;
        int i5 = ((i2 - i) + 1) / iModuleSize;
        if (i4 <= 0 || i5 <= 0) {
            throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
        }
        int i6 = iModuleSize / 2;
        int i7 = i + i6;
        int i8 = i3 + i6;
        com.dcloud.zxing2.common.BitMatrix bitMatrix2 = new com.dcloud.zxing2.common.BitMatrix(i4, i5);
        for (int i9 = 0; i9 < i5; i9++) {
            int i10 = (i9 * iModuleSize) + i7;
            for (int i11 = 0; i11 < i4; i11++) {
                if (bitMatrix.get((i11 * iModuleSize) + i8, i10)) {
                    bitMatrix2.set(i11, i9);
                }
            }
        }
        return bitMatrix2;
    }

    private static int moduleSize(int[] iArr, com.dcloud.zxing2.common.BitMatrix bitMatrix) throws com.dcloud.zxing2.NotFoundException {
        int width = bitMatrix.getWidth();
        int i = iArr[0];
        int i2 = iArr[1];
        while (i < width && bitMatrix.get(i, i2)) {
            i++;
        }
        if (i == width) {
            throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
        }
        int i3 = i - iArr[0];
        if (i3 != 0) {
            return i3;
        }
        throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
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
        com.dcloud.zxing2.ResultPoint[] points;
        com.dcloud.zxing2.common.DecoderResult decoderResultDecode;
        if (map == null || !map.containsKey(com.dcloud.zxing2.DecodeHintType.PURE_BARCODE)) {
            com.dcloud.zxing2.common.DetectorResult detectorResultDetect = new com.dcloud.zxing2.datamatrix.detector.Detector(binaryBitmap.getBlackMatrix()).detect();
            com.dcloud.zxing2.common.DecoderResult decoderResultDecode2 = this.decoder.decode(detectorResultDetect.getBits());
            points = detectorResultDetect.getPoints();
            decoderResultDecode = decoderResultDecode2;
        } else {
            decoderResultDecode = this.decoder.decode(extractPureBits(binaryBitmap.getBlackMatrix()));
            points = NO_POINTS;
        }
        com.dcloud.zxing2.Result result = new com.dcloud.zxing2.Result(decoderResultDecode.getText(), decoderResultDecode.getRawBytes(), points, com.dcloud.zxing2.BarcodeFormat.DATA_MATRIX);
        java.util.List<byte[]> byteSegments = decoderResultDecode.getByteSegments();
        if (byteSegments != null) {
            result.putMetadata(com.dcloud.zxing2.ResultMetadataType.BYTE_SEGMENTS, byteSegments);
        }
        java.lang.String eCLevel = decoderResultDecode.getECLevel();
        if (eCLevel != null) {
            result.putMetadata(com.dcloud.zxing2.ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
        }
        return result;
    }
}
