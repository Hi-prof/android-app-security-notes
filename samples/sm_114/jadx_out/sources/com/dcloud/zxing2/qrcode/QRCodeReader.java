package com.dcloud.zxing2.qrcode;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class QRCodeReader implements com.dcloud.zxing2.Reader {
    private static final com.dcloud.zxing2.ResultPoint[] NO_POINTS = new com.dcloud.zxing2.ResultPoint[0];
    private final com.dcloud.zxing2.qrcode.decoder.Decoder decoder = new com.dcloud.zxing2.qrcode.decoder.Decoder();
    private android.os.Handler hostHandler;

    private static com.dcloud.zxing2.common.BitMatrix extractPureBits(com.dcloud.zxing2.common.BitMatrix bitMatrix) throws com.dcloud.zxing2.NotFoundException {
        int[] topLeftOnBit = bitMatrix.getTopLeftOnBit();
        int[] bottomRightOnBit = bitMatrix.getBottomRightOnBit();
        if (topLeftOnBit == null || bottomRightOnBit == null) {
            throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
        }
        float fModuleSize = moduleSize(topLeftOnBit, bitMatrix);
        int i = topLeftOnBit[1];
        int i2 = bottomRightOnBit[1];
        int i3 = topLeftOnBit[0];
        int i4 = bottomRightOnBit[0];
        if (i3 >= i4 || i >= i2) {
            throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
        }
        int i5 = i2 - i;
        if (i5 != i4 - i3) {
            i4 = i3 + i5;
        }
        int iRound = java.lang.Math.round(((i4 - i3) + 1) / fModuleSize);
        int iRound2 = java.lang.Math.round((i5 + 1) / fModuleSize);
        if (iRound <= 0 || iRound2 <= 0) {
            throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
        }
        if (iRound2 != iRound) {
            throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
        }
        int i6 = (int) (fModuleSize / 2.0f);
        int i7 = i + i6;
        int i8 = i3 + i6;
        int i9 = (((int) ((iRound - 1) * fModuleSize)) + i8) - i4;
        if (i9 > 0) {
            if (i9 > i6) {
                throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
            }
            i8 -= i9;
        }
        int i10 = (((int) ((iRound2 - 1) * fModuleSize)) + i7) - i2;
        if (i10 > 0) {
            if (i10 > i6) {
                throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
            }
            i7 -= i10;
        }
        com.dcloud.zxing2.common.BitMatrix bitMatrix2 = new com.dcloud.zxing2.common.BitMatrix(iRound, iRound2);
        for (int i11 = 0; i11 < iRound2; i11++) {
            int i12 = ((int) (i11 * fModuleSize)) + i7;
            for (int i13 = 0; i13 < iRound; i13++) {
                if (bitMatrix.get(((int) (i13 * fModuleSize)) + i8, i12)) {
                    bitMatrix2.set(i13, i11);
                }
            }
        }
        return bitMatrix2;
    }

    private static float moduleSize(int[] iArr, com.dcloud.zxing2.common.BitMatrix bitMatrix) throws com.dcloud.zxing2.NotFoundException {
        int height = bitMatrix.getHeight();
        int width = bitMatrix.getWidth();
        int i = iArr[0];
        boolean z = true;
        int i2 = iArr[1];
        int i3 = 0;
        while (i < width && i2 < height) {
            if (z != bitMatrix.get(i, i2)) {
                i3++;
                if (i3 == 5) {
                    break;
                }
                z = !z;
            }
            i++;
            i2++;
        }
        if (i == width || i2 == height) {
            throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
        }
        return (i - iArr[0]) / 7.0f;
    }

    @Override // com.dcloud.zxing2.Reader
    public com.dcloud.zxing2.Result decode(com.dcloud.zxing2.BinaryBitmap binaryBitmap) throws com.dcloud.zxing2.ChecksumException, com.dcloud.zxing2.FormatException, com.dcloud.zxing2.NotFoundException {
        return decode(binaryBitmap, null);
    }

    protected final com.dcloud.zxing2.qrcode.decoder.Decoder getDecoder() {
        return this.decoder;
    }

    @Override // com.dcloud.zxing2.Reader
    public void reset() {
    }

    public void updateHandler(android.os.Handler handler) {
        this.hostHandler = handler;
    }

    @Override // com.dcloud.zxing2.Reader
    public final com.dcloud.zxing2.Result decode(com.dcloud.zxing2.BinaryBitmap binaryBitmap, java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) throws com.dcloud.zxing2.ChecksumException, com.dcloud.zxing2.FormatException, com.dcloud.zxing2.NotFoundException {
        com.dcloud.zxing2.common.DecoderResult decoderResultDecode;
        com.dcloud.zxing2.ResultPoint[] points;
        com.dcloud.zxing2.common.DecoderResult decoderResultDecode2;
        if (map == null || !map.containsKey(com.dcloud.zxing2.DecodeHintType.PURE_BARCODE)) {
            com.dcloud.zxing2.common.DetectorResult detectorResultDetect = new com.dcloud.zxing2.qrcode.detector.Detector(binaryBitmap.getBlackMatrix()).detect(map);
            try {
                decoderResultDecode = this.decoder.decode(detectorResultDetect.getBits(), map);
            } catch (java.lang.Exception unused) {
                if (this.hostHandler != null && detectorResultDetect != null) {
                    android.os.Message message = new android.os.Message();
                    message.what = 1010;
                    message.obj = java.lang.Float.valueOf(detectorResultDetect.moduleSize);
                    this.hostHandler.sendMessage(message);
                }
                decoderResultDecode = null;
            }
            if (decoderResultDecode == null) {
                throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
            }
            com.dcloud.zxing2.common.DecoderResult decoderResult = decoderResultDecode;
            points = detectorResultDetect.getPoints();
            decoderResultDecode2 = decoderResult;
        } else {
            decoderResultDecode2 = this.decoder.decode(extractPureBits(binaryBitmap.getBlackMatrix()), map);
            points = NO_POINTS;
        }
        if (decoderResultDecode2.getOther() instanceof com.dcloud.zxing2.qrcode.decoder.QRCodeDecoderMetaData) {
            ((com.dcloud.zxing2.qrcode.decoder.QRCodeDecoderMetaData) decoderResultDecode2.getOther()).applyMirroredCorrection(points);
        }
        com.dcloud.zxing2.Result result = new com.dcloud.zxing2.Result(decoderResultDecode2.getText(), decoderResultDecode2.getRawBytes(), points, com.dcloud.zxing2.BarcodeFormat.QR_CODE);
        result.textCharset = decoderResultDecode2.textCharset;
        java.util.List<byte[]> byteSegments = decoderResultDecode2.getByteSegments();
        if (byteSegments != null) {
            result.putMetadata(com.dcloud.zxing2.ResultMetadataType.BYTE_SEGMENTS, byteSegments);
        }
        java.lang.String eCLevel = decoderResultDecode2.getECLevel();
        if (eCLevel != null) {
            result.putMetadata(com.dcloud.zxing2.ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
        }
        if (decoderResultDecode2.hasStructuredAppend()) {
            result.putMetadata(com.dcloud.zxing2.ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, java.lang.Integer.valueOf(decoderResultDecode2.getStructuredAppendSequenceNumber()));
            result.putMetadata(com.dcloud.zxing2.ResultMetadataType.STRUCTURED_APPEND_PARITY, java.lang.Integer.valueOf(decoderResultDecode2.getStructuredAppendParity()));
        }
        return result;
    }
}
