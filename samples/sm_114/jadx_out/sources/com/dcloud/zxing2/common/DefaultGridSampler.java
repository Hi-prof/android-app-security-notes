package com.dcloud.zxing2.common;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultGridSampler extends com.dcloud.zxing2.common.GridSampler {
    @Override // com.dcloud.zxing2.common.GridSampler
    public com.dcloud.zxing2.common.BitMatrix sampleGrid(com.dcloud.zxing2.common.BitMatrix bitMatrix, int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) throws com.dcloud.zxing2.NotFoundException {
        return sampleGrid(bitMatrix, i, i2, com.dcloud.zxing2.common.PerspectiveTransform.quadrilateralToQuadrilateral(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16));
    }

    @Override // com.dcloud.zxing2.common.GridSampler
    public com.dcloud.zxing2.common.BitMatrix sampleGrid(com.dcloud.zxing2.common.BitMatrix bitMatrix, int i, int i2, com.dcloud.zxing2.common.PerspectiveTransform perspectiveTransform) throws com.dcloud.zxing2.NotFoundException {
        if (i > 0 && i2 > 0) {
            com.dcloud.zxing2.common.BitMatrix bitMatrix2 = new com.dcloud.zxing2.common.BitMatrix(i, i2);
            int i3 = i * 2;
            float[] fArr = new float[i3];
            for (int i4 = 0; i4 < i2; i4++) {
                float f = i4 + 0.5f;
                for (int i5 = 0; i5 < i3; i5 += 2) {
                    fArr[i5] = (i5 / 2) + 0.5f;
                    fArr[i5 + 1] = f;
                }
                perspectiveTransform.transformPoints(fArr);
                com.dcloud.zxing2.common.GridSampler.checkAndNudgePoints(bitMatrix, fArr);
                for (int i6 = 0; i6 < i3; i6 += 2) {
                    try {
                        if (bitMatrix.get((int) fArr[i6], (int) fArr[i6 + 1])) {
                            bitMatrix2.set(i6 / 2, i4);
                        }
                    } catch (java.lang.ArrayIndexOutOfBoundsException unused) {
                        throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
                    }
                }
            }
            return bitMatrix2;
        }
        throw com.dcloud.zxing2.NotFoundException.getNotFoundInstance();
    }
}
