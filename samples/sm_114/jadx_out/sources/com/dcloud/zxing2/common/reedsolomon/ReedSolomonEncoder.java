package com.dcloud.zxing2.common.reedsolomon;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class ReedSolomonEncoder {
    private final java.util.List<com.dcloud.zxing2.common.reedsolomon.GenericGFPoly> cachedGenerators;
    private final com.dcloud.zxing2.common.reedsolomon.GenericGF field;

    public ReedSolomonEncoder(com.dcloud.zxing2.common.reedsolomon.GenericGF genericGF) {
        this.field = genericGF;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.cachedGenerators = arrayList;
        arrayList.add(new com.dcloud.zxing2.common.reedsolomon.GenericGFPoly(genericGF, new int[]{1}));
    }

    private com.dcloud.zxing2.common.reedsolomon.GenericGFPoly buildGenerator(int i) {
        if (i >= this.cachedGenerators.size()) {
            java.util.List<com.dcloud.zxing2.common.reedsolomon.GenericGFPoly> list = this.cachedGenerators;
            com.dcloud.zxing2.common.reedsolomon.GenericGFPoly genericGFPolyMultiply = list.get(list.size() - 1);
            for (int size = this.cachedGenerators.size(); size <= i; size++) {
                com.dcloud.zxing2.common.reedsolomon.GenericGF genericGF = this.field;
                genericGFPolyMultiply = genericGFPolyMultiply.multiply(new com.dcloud.zxing2.common.reedsolomon.GenericGFPoly(genericGF, new int[]{1, genericGF.exp((size - 1) + genericGF.getGeneratorBase())}));
                this.cachedGenerators.add(genericGFPolyMultiply);
            }
        }
        return this.cachedGenerators.get(i);
    }

    public void encode(int[] iArr, int i) {
        if (i == 0) {
            throw new java.lang.IllegalArgumentException("No error correction bytes");
        }
        int length = iArr.length - i;
        if (length <= 0) {
            throw new java.lang.IllegalArgumentException("No data bytes provided");
        }
        com.dcloud.zxing2.common.reedsolomon.GenericGFPoly genericGFPolyBuildGenerator = buildGenerator(i);
        int[] iArr2 = new int[length];
        java.lang.System.arraycopy(iArr, 0, iArr2, 0, length);
        int[] coefficients = new com.dcloud.zxing2.common.reedsolomon.GenericGFPoly(this.field, iArr2).multiplyByMonomial(i, 1).divide(genericGFPolyBuildGenerator)[1].getCoefficients();
        int length2 = i - coefficients.length;
        for (int i2 = 0; i2 < length2; i2++) {
            iArr[length + i2] = 0;
        }
        java.lang.System.arraycopy(coefficients, 0, iArr, length + length2, coefficients.length);
    }
}
