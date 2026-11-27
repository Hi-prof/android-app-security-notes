package com.dcloud.zxing2.multi;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class GenericMultipleBarcodeReader implements com.dcloud.zxing2.multi.MultipleBarcodeReader {
    private static final int MAX_DEPTH = 4;
    private static final int MIN_DIMENSION_TO_RECUR = 100;
    private final com.dcloud.zxing2.Reader delegate;

    public GenericMultipleBarcodeReader(com.dcloud.zxing2.Reader reader) {
        this.delegate = reader;
    }

    private void doDecodeMultiple(com.dcloud.zxing2.BinaryBitmap binaryBitmap, java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map, java.util.List<com.dcloud.zxing2.Result> list, int i, int i2, int i3) {
        int i4;
        if (i3 > 4) {
            return;
        }
        try {
            com.dcloud.zxing2.Result resultDecode = this.delegate.decode(binaryBitmap, map);
            java.util.Iterator<com.dcloud.zxing2.Result> it = list.iterator();
            do {
                if (!it.hasNext()) {
                    list.add(translateResultPoints(resultDecode, i, i2));
                    break;
                }
            } while (!it.next().getText().equals(resultDecode.getText()));
            com.dcloud.zxing2.ResultPoint[] resultPoints = resultDecode.getResultPoints();
            if (resultPoints == null || resultPoints.length == 0) {
                return;
            }
            int width = binaryBitmap.getWidth();
            int height = binaryBitmap.getHeight();
            float f = width;
            float f2 = height;
            float f3 = 0.0f;
            float f4 = 0.0f;
            for (com.dcloud.zxing2.ResultPoint resultPoint : resultPoints) {
                if (resultPoint != null) {
                    float x = resultPoint.getX();
                    float y = resultPoint.getY();
                    if (x < f) {
                        f = x;
                    }
                    if (y < f2) {
                        f2 = y;
                    }
                    if (x > f3) {
                        f3 = x;
                    }
                    if (y > f4) {
                        f4 = y;
                    }
                }
            }
            if (f > 100.0f) {
                i4 = 0;
                doDecodeMultiple(binaryBitmap.crop(0, 0, (int) f, height), map, list, i, i2, i3 + 1);
            } else {
                i4 = 0;
            }
            if (f2 > 100.0f) {
                doDecodeMultiple(binaryBitmap.crop(i4, i4, width, (int) f2), map, list, i, i2, i3 + 1);
            }
            if (f3 < width - 100) {
                int i5 = (int) f3;
                doDecodeMultiple(binaryBitmap.crop(i5, 0, width - i5, height), map, list, i + i5, i2, i3 + 1);
            }
            if (f4 < height - 100) {
                int i6 = (int) f4;
                doDecodeMultiple(binaryBitmap.crop(0, i6, width, height - i6), map, list, i, i2 + i6, i3 + 1);
            }
        } catch (com.dcloud.zxing2.ReaderException unused) {
        }
    }

    private static com.dcloud.zxing2.Result translateResultPoints(com.dcloud.zxing2.Result result, int i, int i2) {
        com.dcloud.zxing2.ResultPoint[] resultPoints = result.getResultPoints();
        if (resultPoints == null) {
            return result;
        }
        com.dcloud.zxing2.ResultPoint[] resultPointArr = new com.dcloud.zxing2.ResultPoint[resultPoints.length];
        for (int i3 = 0; i3 < resultPoints.length; i3++) {
            com.dcloud.zxing2.ResultPoint resultPoint = resultPoints[i3];
            if (resultPoint != null) {
                resultPointArr[i3] = new com.dcloud.zxing2.ResultPoint(resultPoint.getX() + i, resultPoint.getY() + i2);
            }
        }
        com.dcloud.zxing2.Result result2 = new com.dcloud.zxing2.Result(result.getText(), result.getRawBytes(), resultPointArr, result.getBarcodeFormat());
        result2.putAllMetadata(result.getResultMetadata());
        return result2;
    }

    @Override // com.dcloud.zxing2.multi.MultipleBarcodeReader
    public com.dcloud.zxing2.Result[] decodeMultiple(com.dcloud.zxing2.BinaryBitmap binaryBitmap) throws com.dcloud.zxing2.NotFoundException {
        return decodeMultiple(binaryBitmap, null);
    }

    @Override // com.dcloud.zxing2.multi.MultipleBarcodeReader
    public com.dcloud.zxing2.Result[] decodeMultiple(com.dcloud.zxing2.BinaryBitmap binaryBitmap, java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) throws com.dcloud.zxing2.NotFoundException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        doDecodeMultiple(binaryBitmap, map, arrayList, 0, 0, 0);
        if (arrayList.isEmpty()) {
            throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
        }
        return (com.dcloud.zxing2.Result[]) arrayList.toArray(new com.dcloud.zxing2.Result[arrayList.size()]);
    }
}
