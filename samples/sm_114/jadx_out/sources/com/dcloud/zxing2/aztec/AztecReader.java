package com.dcloud.zxing2.aztec;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class AztecReader implements com.dcloud.zxing2.Reader {
    @Override // com.dcloud.zxing2.Reader
    public com.dcloud.zxing2.Result decode(com.dcloud.zxing2.BinaryBitmap binaryBitmap) throws com.dcloud.zxing2.FormatException, com.dcloud.zxing2.NotFoundException {
        return decode(binaryBitmap, null);
    }

    @Override // com.dcloud.zxing2.Reader
    public void reset() {
    }

    @Override // com.dcloud.zxing2.Reader
    public com.dcloud.zxing2.Result decode(com.dcloud.zxing2.BinaryBitmap binaryBitmap, java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) throws com.dcloud.zxing2.FormatException, com.dcloud.zxing2.NotFoundException {
        com.dcloud.zxing2.ResultPoint[] points;
        com.dcloud.zxing2.ResultPoint[] points2;
        com.dcloud.zxing2.FormatException formatException;
        com.dcloud.zxing2.ResultPointCallback resultPointCallback;
        com.dcloud.zxing2.aztec.detector.Detector detector = new com.dcloud.zxing2.aztec.detector.Detector(binaryBitmap.getBlackMatrix());
        com.dcloud.zxing2.common.DecoderResult decoderResultDecode = null;
        try {
            com.dcloud.zxing2.aztec.AztecDetectorResult aztecDetectorResultDetect = detector.detect(false);
            points = aztecDetectorResultDetect.getPoints();
            try {
                points2 = points;
                formatException = null;
                decoderResultDecode = new com.dcloud.zxing2.aztec.decoder.Decoder().decode(aztecDetectorResultDetect);
                e = null;
            } catch (com.dcloud.zxing2.FormatException e) {
                e = e;
                points2 = points;
                formatException = e;
                e = null;
            } catch (com.dcloud.zxing2.NotFoundException e2) {
                e = e2;
                points2 = points;
                formatException = null;
            }
        } catch (com.dcloud.zxing2.FormatException e3) {
            e = e3;
            points = null;
        } catch (com.dcloud.zxing2.NotFoundException e4) {
            e = e4;
            points = null;
        }
        if (decoderResultDecode == null) {
            try {
                com.dcloud.zxing2.aztec.AztecDetectorResult aztecDetectorResultDetect2 = detector.detect(true);
                points2 = aztecDetectorResultDetect2.getPoints();
                decoderResultDecode = new com.dcloud.zxing2.aztec.decoder.Decoder().decode(aztecDetectorResultDetect2);
            } catch (com.dcloud.zxing2.FormatException | com.dcloud.zxing2.NotFoundException e5) {
                if (e != null) {
                    throw e;
                }
                if (formatException != null) {
                    throw formatException;
                }
                throw e5;
            }
        }
        if (map != null && (resultPointCallback = (com.dcloud.zxing2.ResultPointCallback) map.get(com.dcloud.zxing2.DecodeHintType.NEED_RESULT_POINT_CALLBACK)) != null) {
            for (com.dcloud.zxing2.ResultPoint resultPoint : points2) {
                resultPointCallback.foundPossibleResultPoint(resultPoint);
            }
        }
        com.dcloud.zxing2.Result result = new com.dcloud.zxing2.Result(decoderResultDecode.getText(), decoderResultDecode.getRawBytes(), points2, com.dcloud.zxing2.BarcodeFormat.AZTEC);
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
