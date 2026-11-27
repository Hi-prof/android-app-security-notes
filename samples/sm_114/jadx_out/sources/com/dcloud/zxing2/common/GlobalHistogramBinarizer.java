package com.dcloud.zxing2.common;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class GlobalHistogramBinarizer extends com.dcloud.zxing2.Binarizer {
    private static final byte[] EMPTY = new byte[0];
    private static final int LUMINANCE_BITS = 5;
    private static final int LUMINANCE_BUCKETS = 32;
    private static final int LUMINANCE_SHIFT = 3;
    private final int[] buckets;
    private byte[] luminances;

    public GlobalHistogramBinarizer(com.dcloud.zxing2.LuminanceSource luminanceSource) {
        super(luminanceSource);
        this.luminances = EMPTY;
        this.buckets = new int[32];
    }

    private static int estimateBlackPoint(int[] iArr) throws com.dcloud.zxing2.NotFoundException {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            if (i5 > i) {
                i3 = i4;
                i = i5;
            }
            if (i5 > i2) {
                i2 = i5;
            }
        }
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = i8 - i3;
            int i10 = iArr[i8] * i9 * i9;
            if (i10 > i7) {
                i6 = i8;
                i7 = i10;
            }
        }
        if (i3 <= i6) {
            int i11 = i3;
            i3 = i6;
            i6 = i11;
        }
        if (i3 - i6 <= length / 16) {
            throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
        }
        int i12 = i3 - 1;
        int i13 = i12;
        int i14 = -1;
        while (i12 > i6) {
            int i15 = i12 - i6;
            int i16 = i15 * i15 * (i3 - i12) * (i2 - iArr[i12]);
            if (i16 > i14) {
                i13 = i12;
                i14 = i16;
            }
            i12--;
        }
        return i13 << 3;
    }

    private void initArrays(int i) {
        if (this.luminances.length < i) {
            this.luminances = new byte[i];
        }
        for (int i2 = 0; i2 < 32; i2++) {
            this.buckets[i2] = 0;
        }
    }

    @Override // com.dcloud.zxing2.Binarizer
    public com.dcloud.zxing2.Binarizer createBinarizer(com.dcloud.zxing2.LuminanceSource luminanceSource) {
        return new com.dcloud.zxing2.common.GlobalHistogramBinarizer(luminanceSource);
    }

    @Override // com.dcloud.zxing2.Binarizer
    public com.dcloud.zxing2.common.BitMatrix getBlackMatrix() throws com.dcloud.zxing2.NotFoundException {
        com.dcloud.zxing2.LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        int height = luminanceSource.getHeight();
        com.dcloud.zxing2.common.BitMatrix bitMatrix = new com.dcloud.zxing2.common.BitMatrix(width, height);
        initArrays(width);
        int[] iArr = this.buckets;
        for (int i = 1; i < 5; i++) {
            byte[] row = luminanceSource.getRow((height * i) / 5, this.luminances);
            int i2 = (width * 4) / 5;
            for (int i3 = width / 5; i3 < i2; i3++) {
                int i4 = (row[i3] & 255) >> 3;
                iArr[i4] = iArr[i4] + 1;
            }
        }
        int iEstimateBlackPoint = estimateBlackPoint(iArr);
        byte[] matrix = luminanceSource.getMatrix();
        for (int i5 = 0; i5 < height; i5++) {
            int i6 = i5 * width;
            for (int i7 = 0; i7 < width; i7++) {
                if ((matrix[i6 + i7] & 255) < iEstimateBlackPoint) {
                    bitMatrix.set(i7, i5);
                }
            }
        }
        return bitMatrix;
    }

    @Override // com.dcloud.zxing2.Binarizer
    public com.dcloud.zxing2.common.BitArray getBlackRow(int i, com.dcloud.zxing2.common.BitArray bitArray) throws com.dcloud.zxing2.NotFoundException {
        com.dcloud.zxing2.LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        if (bitArray == null || bitArray.getSize() < width) {
            bitArray = new com.dcloud.zxing2.common.BitArray(width);
        } else {
            bitArray.clear();
        }
        initArrays(width);
        byte[] row = luminanceSource.getRow(i, this.luminances);
        int[] iArr = this.buckets;
        for (int i2 = 0; i2 < width; i2++) {
            int i3 = (row[i2] & 255) >> 3;
            iArr[i3] = iArr[i3] + 1;
        }
        int iEstimateBlackPoint = estimateBlackPoint(iArr);
        int i4 = row[0] & 255;
        int i5 = row[1] & 255;
        int i6 = 1;
        while (i6 < width - 1) {
            int i7 = i6 + 1;
            int i8 = row[i7] & 255;
            if ((((i5 * 4) - i4) - i8) / 2 < iEstimateBlackPoint) {
                bitArray.set(i6);
            }
            i4 = i5;
            i6 = i7;
            i5 = i8;
        }
        return bitArray;
    }
}
