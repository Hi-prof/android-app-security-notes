package com.dcloud.zxing2.oned;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public abstract class OneDReader implements com.dcloud.zxing2.Reader {
    private com.dcloud.zxing2.Result doDecode(com.dcloud.zxing2.BinaryBitmap binaryBitmap, java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) throws com.dcloud.zxing2.NotFoundException {
        java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map2;
        java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map3 = map;
        int width = binaryBitmap.getWidth();
        int height = binaryBitmap.getHeight();
        com.dcloud.zxing2.common.BitArray bitArray = new com.dcloud.zxing2.common.BitArray(width);
        int i = height >> 1;
        int i2 = 1;
        boolean z = map3 != null && map3.containsKey(com.dcloud.zxing2.DecodeHintType.TRY_HARDER);
        int iMax = java.lang.Math.max(1, height >> (z ? 8 : 5));
        int i3 = z ? height : 15;
        int i4 = 0;
        while (i4 < i3) {
            i4++;
            int i5 = i4 / 2;
            if ((i4 & 1) != 0) {
                i5 = -i5;
            }
            int i6 = (i5 * iMax) + i;
            if (i6 < 0 || i6 >= height) {
                break;
            }
            try {
                bitArray = binaryBitmap.getBlackRow(i6, bitArray);
                int i7 = 0;
                while (i7 < 2) {
                    if (i7 == i2) {
                        bitArray.reverse();
                        if (map3 != null) {
                            com.dcloud.zxing2.DecodeHintType decodeHintType = com.dcloud.zxing2.DecodeHintType.NEED_RESULT_POINT_CALLBACK;
                            if (map3.containsKey(decodeHintType)) {
                                java.util.EnumMap enumMap = new java.util.EnumMap(com.dcloud.zxing2.DecodeHintType.class);
                                enumMap.putAll(map3);
                                enumMap.remove(decodeHintType);
                                map3 = enumMap;
                            }
                        }
                    }
                    try {
                        com.dcloud.zxing2.Result resultDecodeRow = decodeRow(i6, bitArray, map3);
                        if (i7 == i2) {
                            try {
                                resultDecodeRow.putMetadata(com.dcloud.zxing2.ResultMetadataType.ORIENTATION, 180);
                                com.dcloud.zxing2.ResultPoint[] resultPoints = resultDecodeRow.getResultPoints();
                                if (resultPoints != null) {
                                    float f = width;
                                    try {
                                        map2 = map3;
                                        try {
                                            try {
                                                resultPoints[0] = new com.dcloud.zxing2.ResultPoint((f - resultPoints[0].getX()) - 1.0f, resultPoints[0].getY());
                                                resultPoints[1] = new com.dcloud.zxing2.ResultPoint((f - resultPoints[1].getX()) - 1.0f, resultPoints[1].getY());
                                            } catch (com.dcloud.zxing2.ReaderException unused) {
                                                continue;
                                                i7++;
                                                map3 = map2;
                                                width = width;
                                                i2 = 1;
                                            }
                                        } catch (com.dcloud.zxing2.ReaderException unused2) {
                                            i7++;
                                            map3 = map2;
                                            width = width;
                                            i2 = 1;
                                        }
                                    } catch (com.dcloud.zxing2.ReaderException unused3) {
                                        map2 = map3;
                                    }
                                }
                            } catch (com.dcloud.zxing2.ReaderException unused4) {
                                map2 = map3;
                            }
                        }
                        return resultDecodeRow;
                    } catch (com.dcloud.zxing2.ReaderException unused5) {
                        map2 = map3;
                    }
                }
            } catch (com.dcloud.zxing2.NotFoundException unused6) {
                i2 = 1;
            }
        }
        throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
    }

    protected static float patternMatchVariance(int[] iArr, int[] iArr2, float f) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = i;
        float f3 = f2 / i2;
        float f4 = f * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            float f6 = iArr2[i4] * f3;
            float f7 = i5;
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }

    protected static void recordPattern(com.dcloud.zxing2.common.BitArray bitArray, int i, int[] iArr) throws com.dcloud.zxing2.NotFoundException {
        int length = iArr.length;
        int i2 = 0;
        java.util.Arrays.fill(iArr, 0, length, 0);
        int size = bitArray.getSize();
        if (i >= size) {
            throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
        }
        boolean z = !bitArray.get(i);
        while (i < size) {
            if (bitArray.get(i) ^ z) {
                iArr[i2] = iArr[i2] + 1;
            } else {
                i2++;
                if (i2 == length) {
                    break;
                }
                iArr[i2] = 1;
                z = !z;
            }
            i++;
        }
        if (i2 != length) {
            if (i2 != length - 1 || i != size) {
                throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
            }
        }
    }

    protected static void recordPatternInReverse(com.dcloud.zxing2.common.BitArray bitArray, int i, int[] iArr) throws com.dcloud.zxing2.NotFoundException {
        int length = iArr.length;
        boolean z = bitArray.get(i);
        while (i > 0 && length >= 0) {
            i--;
            if (bitArray.get(i) != z) {
                length--;
                z = !z;
            }
        }
        if (length >= 0) {
            throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
        }
        recordPattern(bitArray, i + 1, iArr);
    }

    @Override // com.dcloud.zxing2.Reader
    public com.dcloud.zxing2.Result decode(com.dcloud.zxing2.BinaryBitmap binaryBitmap) throws com.dcloud.zxing2.FormatException, com.dcloud.zxing2.NotFoundException {
        return decode(binaryBitmap, null);
    }

    public abstract com.dcloud.zxing2.Result decodeRow(int i, com.dcloud.zxing2.common.BitArray bitArray, java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) throws com.dcloud.zxing2.ChecksumException, com.dcloud.zxing2.FormatException, com.dcloud.zxing2.NotFoundException;

    @Override // com.dcloud.zxing2.Reader
    public void reset() {
    }

    @Override // com.dcloud.zxing2.Reader
    public com.dcloud.zxing2.Result decode(com.dcloud.zxing2.BinaryBitmap binaryBitmap, java.util.Map<com.dcloud.zxing2.DecodeHintType, ?> map) throws com.dcloud.zxing2.FormatException, com.dcloud.zxing2.NotFoundException {
        try {
            return doDecode(binaryBitmap, map);
        } catch (com.dcloud.zxing2.NotFoundException e) {
            if (map == null || !map.containsKey(com.dcloud.zxing2.DecodeHintType.TRY_HARDER) || !binaryBitmap.isRotateSupported()) {
                throw e;
            }
            com.dcloud.zxing2.BinaryBitmap binaryBitmapRotateCounterClockwise = binaryBitmap.rotateCounterClockwise();
            com.dcloud.zxing2.Result resultDoDecode = doDecode(binaryBitmapRotateCounterClockwise, map);
            java.util.Map<com.dcloud.zxing2.ResultMetadataType, java.lang.Object> resultMetadata = resultDoDecode.getResultMetadata();
            int iIntValue = 270;
            if (resultMetadata != null) {
                com.dcloud.zxing2.ResultMetadataType resultMetadataType = com.dcloud.zxing2.ResultMetadataType.ORIENTATION;
                if (resultMetadata.containsKey(resultMetadataType)) {
                    iIntValue = (((java.lang.Integer) resultMetadata.get(resultMetadataType)).intValue() + 270) % 360;
                }
            }
            resultDoDecode.putMetadata(com.dcloud.zxing2.ResultMetadataType.ORIENTATION, java.lang.Integer.valueOf(iIntValue));
            com.dcloud.zxing2.ResultPoint[] resultPoints = resultDoDecode.getResultPoints();
            if (resultPoints != null) {
                int height = binaryBitmapRotateCounterClockwise.getHeight();
                for (int i = 0; i < resultPoints.length; i++) {
                    resultPoints[i] = new com.dcloud.zxing2.ResultPoint((height - resultPoints[i].getY()) - 1.0f, resultPoints[i].getX());
                }
            }
            return resultDoDecode;
        }
    }
}
