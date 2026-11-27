package com.dcloud.zxing2.common.reedsolomon;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class ReedSolomonDecoder {
    private final com.dcloud.zxing2.common.reedsolomon.GenericGF field;

    public ReedSolomonDecoder(com.dcloud.zxing2.common.reedsolomon.GenericGF genericGF) {
        this.field = genericGF;
    }

    private int[] findErrorLocations(com.dcloud.zxing2.common.reedsolomon.GenericGFPoly genericGFPoly) throws com.dcloud.zxing2.common.reedsolomon.ReedSolomonException {
        int degree = genericGFPoly.getDegree();
        if (degree == 1) {
            return new int[]{genericGFPoly.getCoefficient(1)};
        }
        int[] iArr = new int[degree];
        int i = 0;
        for (int i2 = 1; i2 < this.field.getSize() && i < degree; i2++) {
            if (genericGFPoly.evaluateAt(i2) == 0) {
                iArr[i] = this.field.inverse(i2);
                i++;
            }
        }
        if (i == degree) {
            return iArr;
        }
        throw new com.dcloud.zxing2.common.reedsolomon.ReedSolomonException("Error locator degree does not match number of roots");
    }

    private int[] findErrorMagnitudes(com.dcloud.zxing2.common.reedsolomon.GenericGFPoly genericGFPoly, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            int iInverse = this.field.inverse(iArr[i]);
            int iMultiply = 1;
            for (int i2 = 0; i2 < length; i2++) {
                if (i != i2) {
                    int iMultiply2 = this.field.multiply(iArr[i2], iInverse);
                    iMultiply = this.field.multiply(iMultiply, (iMultiply2 & 1) == 0 ? iMultiply2 | 1 : iMultiply2 & (-2));
                }
            }
            iArr2[i] = this.field.multiply(genericGFPoly.evaluateAt(iInverse), this.field.inverse(iMultiply));
            if (this.field.getGeneratorBase() != 0) {
                iArr2[i] = this.field.multiply(iArr2[i], iInverse);
            }
        }
        return iArr2;
    }

    private com.dcloud.zxing2.common.reedsolomon.GenericGFPoly[] runEuclideanAlgorithm(com.dcloud.zxing2.common.reedsolomon.GenericGFPoly genericGFPoly, com.dcloud.zxing2.common.reedsolomon.GenericGFPoly genericGFPoly2, int i) throws com.dcloud.zxing2.common.reedsolomon.ReedSolomonException {
        if (genericGFPoly.getDegree() >= genericGFPoly2.getDegree()) {
            genericGFPoly2 = genericGFPoly;
            genericGFPoly = genericGFPoly2;
        }
        com.dcloud.zxing2.common.reedsolomon.GenericGFPoly zero = this.field.getZero();
        com.dcloud.zxing2.common.reedsolomon.GenericGFPoly one = this.field.getOne();
        while (true) {
            com.dcloud.zxing2.common.reedsolomon.GenericGFPoly genericGFPoly3 = one;
            com.dcloud.zxing2.common.reedsolomon.GenericGFPoly genericGFPoly4 = zero;
            zero = genericGFPoly3;
            if (genericGFPoly.getDegree() < i / 2) {
                int coefficient = zero.getCoefficient(0);
                if (coefficient == 0) {
                    throw new com.dcloud.zxing2.common.reedsolomon.ReedSolomonException("sigmaTilde(0) was zero");
                }
                int iInverse = this.field.inverse(coefficient);
                return new com.dcloud.zxing2.common.reedsolomon.GenericGFPoly[]{zero.multiply(iInverse), genericGFPoly.multiply(iInverse)};
            }
            if (genericGFPoly.isZero()) {
                throw new com.dcloud.zxing2.common.reedsolomon.ReedSolomonException("r_{i-1} was zero");
            }
            com.dcloud.zxing2.common.reedsolomon.GenericGFPoly zero2 = this.field.getZero();
            int iInverse2 = this.field.inverse(genericGFPoly.getCoefficient(genericGFPoly.getDegree()));
            while (genericGFPoly2.getDegree() >= genericGFPoly.getDegree() && !genericGFPoly2.isZero()) {
                int degree = genericGFPoly2.getDegree() - genericGFPoly.getDegree();
                int iMultiply = this.field.multiply(genericGFPoly2.getCoefficient(genericGFPoly2.getDegree()), iInverse2);
                zero2 = zero2.addOrSubtract(this.field.buildMonomial(degree, iMultiply));
                genericGFPoly2 = genericGFPoly2.addOrSubtract(genericGFPoly.multiplyByMonomial(degree, iMultiply));
            }
            one = zero2.multiply(zero).addOrSubtract(genericGFPoly4);
            if (genericGFPoly2.getDegree() >= genericGFPoly.getDegree()) {
                throw new java.lang.IllegalStateException("Division algorithm failed to reduce polynomial?");
            }
            com.dcloud.zxing2.common.reedsolomon.GenericGFPoly genericGFPoly5 = genericGFPoly2;
            genericGFPoly2 = genericGFPoly;
            genericGFPoly = genericGFPoly5;
        }
    }

    public void decode(int[] iArr, int i) throws com.dcloud.zxing2.common.reedsolomon.ReedSolomonException {
        com.dcloud.zxing2.common.reedsolomon.GenericGFPoly genericGFPoly = new com.dcloud.zxing2.common.reedsolomon.GenericGFPoly(this.field, iArr);
        int[] iArr2 = new int[i];
        boolean z = true;
        for (int i2 = 0; i2 < i; i2++) {
            com.dcloud.zxing2.common.reedsolomon.GenericGF genericGF = this.field;
            int iEvaluateAt = genericGFPoly.evaluateAt(genericGF.exp(genericGF.getGeneratorBase() + i2));
            iArr2[(i - 1) - i2] = iEvaluateAt;
            if (iEvaluateAt != 0) {
                z = false;
            }
        }
        if (z) {
            return;
        }
        com.dcloud.zxing2.common.reedsolomon.GenericGFPoly[] genericGFPolyArrRunEuclideanAlgorithm = runEuclideanAlgorithm(this.field.buildMonomial(i, 1), new com.dcloud.zxing2.common.reedsolomon.GenericGFPoly(this.field, iArr2), i);
        com.dcloud.zxing2.common.reedsolomon.GenericGFPoly genericGFPoly2 = genericGFPolyArrRunEuclideanAlgorithm[0];
        com.dcloud.zxing2.common.reedsolomon.GenericGFPoly genericGFPoly3 = genericGFPolyArrRunEuclideanAlgorithm[1];
        int[] iArrFindErrorLocations = findErrorLocations(genericGFPoly2);
        int[] iArrFindErrorMagnitudes = findErrorMagnitudes(genericGFPoly3, iArrFindErrorLocations);
        for (int i3 = 0; i3 < iArrFindErrorLocations.length; i3++) {
            int length = (iArr.length - 1) - this.field.log(iArrFindErrorLocations[i3]);
            if (length < 0) {
                throw new com.dcloud.zxing2.common.reedsolomon.ReedSolomonException("Bad error location");
            }
            iArr[length] = com.dcloud.zxing2.common.reedsolomon.GenericGF.addOrSubtract(iArr[length], iArrFindErrorMagnitudes[i3]);
        }
    }
}
