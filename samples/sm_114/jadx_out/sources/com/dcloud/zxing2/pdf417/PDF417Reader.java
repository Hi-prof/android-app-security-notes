package com.dcloud.zxing2.pdf417;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class PDF417Reader implements com.dcloud.zxing2.Reader, com.dcloud.zxing2.multi.MultipleBarcodeReader {
    private static int getMaxCodewordWidth(com.dcloud.zxing2.ResultPoint[] resultPointArr) {
        return java.lang.Math.max(java.lang.Math.max(getMaxWidth(resultPointArr[0], resultPointArr[4]), (getMaxWidth(resultPointArr[6], resultPointArr[2]) * 17) / 18), java.lang.Math.max(getMaxWidth(resultPointArr[1], resultPointArr[5]), (getMaxWidth(resultPointArr[7], resultPointArr[3]) * 17) / 18));
    }

    private static int getMaxWidth(com.dcloud.zxing2.ResultPoint resultPoint, com.dcloud.zxing2.ResultPoint resultPoint2) {
        if (resultPoint == null || resultPoint2 == null) {
            return 0;
        }
        return (int) java.lang.Math.abs(resultPoint.getX() - resultPoint2.getX());
    }

    private static int getMinCodewordWidth(com.dcloud.zxing2.ResultPoint[] resultPointArr) {
        return java.lang.Math.min(java.lang.Math.min(getMinWidth(resultPointArr[0], resultPointArr[4]), (getMinWidth(resultPointArr[6], resultPointArr[2]) * 17) / 18), java.lang.Math.min(getMinWidth(resultPointArr[1], resultPointArr[5]), (getMinWidth(resultPointArr[7], resultPointArr[3]) * 17) / 18));
    }

    private static int getMinWidth(com.dcloud.zxing2.ResultPoint resultPoint, com.dcloud.zxing2.ResultPoint resultPoint2) {
        if (resultPoint == null || resultPoint2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) java.lang.Math.abs(resultPoint.getX() - resultPoint2.getX());
    }

    @Override // com.dcloud.zxing2.Reader
    public com.dcloud.zxing2.Result decode(com.dcloud.zxing2.BinaryBitmap binaryBitmap) throws com.dcloud.zxing2.ChecksumException, com.dcloud.zxing2.FormatException, com.dcloud.zxing2.NotFoundException {
        return decode(binaryBitmap, null);
    }

    @Override // com.dcloud.zxing2.multi.MultipleBarcodeReader
    public com.dcloud.zxing2.Result[] decodeMultiple(com.dcloud.zxing2.BinaryBitmap binaryBitmap) throws com.dcloud.zxing2.NotFoundException {
        return decodeMultiple(binaryBitmap, null);
    }

    @Override // com.dcloud.zxing2.Reader
    public void reset() {
    }

    @Override // com.dcloud.zxing2.Reader
    public com.dcloud.zxing2.Result decode(com.dcloud.zxing2.BinaryBitmap binaryBitmap, java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) throws com.dcloud.zxing2.ChecksumException, com.dcloud.zxing2.FormatException, com.dcloud.zxing2.NotFoundException {
        com.dcloud.zxing2.Result result;
        com.dcloud.zxing2.Result[] resultArrDecode = decode(binaryBitmap, map, false);
        if (resultArrDecode == null || resultArrDecode.length == 0 || (result = resultArrDecode[0]) == null) {
            throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
        }
        return result;
    }

    @Override // com.dcloud.zxing2.multi.MultipleBarcodeReader
    public com.dcloud.zxing2.Result[] decodeMultiple(com.dcloud.zxing2.BinaryBitmap binaryBitmap, java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) throws com.dcloud.zxing2.NotFoundException {
        try {
            return decode(binaryBitmap, map, true);
        } catch (com.dcloud.zxing2.ChecksumException | com.dcloud.zxing2.FormatException unused) {
            throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
        }
    }

    private static com.dcloud.zxing2.Result[] decode(com.dcloud.zxing2.BinaryBitmap binaryBitmap, java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map, boolean z) throws com.dcloud.zxing2.ChecksumException, com.dcloud.zxing2.FormatException, com.dcloud.zxing2.NotFoundException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.dcloud.zxing2.pdf417.detector.PDF417DetectorResult pDF417DetectorResultDetect = com.dcloud.zxing2.pdf417.detector.Detector.detect(binaryBitmap, map, z);
        for (com.dcloud.zxing2.ResultPoint[] resultPointArr : pDF417DetectorResultDetect.getPoints()) {
            com.dcloud.zxing2.common.DecoderResult decoderResultDecode = com.dcloud.zxing2.pdf417.decoder.PDF417ScanningDecoder.decode(pDF417DetectorResultDetect.getBits(), resultPointArr[4], resultPointArr[5], resultPointArr[6], resultPointArr[7], getMinCodewordWidth(resultPointArr), getMaxCodewordWidth(resultPointArr));
            com.dcloud.zxing2.Result result = new com.dcloud.zxing2.Result(decoderResultDecode.getText(), decoderResultDecode.getRawBytes(), resultPointArr, com.dcloud.zxing2.BarcodeFormat.PDF_417);
            result.putMetadata(com.dcloud.zxing2.ResultMetadataType.ERROR_CORRECTION_LEVEL, decoderResultDecode.getECLevel());
            com.dcloud.zxing2.pdf417.PDF417ResultMetadata pDF417ResultMetadata = (com.dcloud.zxing2.pdf417.PDF417ResultMetadata) decoderResultDecode.getOther();
            if (pDF417ResultMetadata != null) {
                result.putMetadata(com.dcloud.zxing2.ResultMetadataType.PDF417_EXTRA_METADATA, pDF417ResultMetadata);
            }
            arrayList.add(result);
        }
        return (com.dcloud.zxing2.Result[]) arrayList.toArray(new com.dcloud.zxing2.Result[arrayList.size()]);
    }
}
