package com.dcloud.zxing2.pdf417.decoder.ec;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class ErrorCorrection {
    private final com.dcloud.zxing2.pdf417.decoder.ec.ModulusGF field = com.dcloud.zxing2.pdf417.decoder.ec.ModulusGF.PDF417_GF;

    private int[] findErrorLocations(com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly modulusPoly) throws com.dcloud.zxing2.ChecksumException {
        int degree = modulusPoly.getDegree();
        int[] iArr = new int[degree];
        int i = 0;
        for (int i2 = 1; i2 < this.field.getSize() && i < degree; i2++) {
            if (modulusPoly.evaluateAt(i2) == 0) {
                iArr[i] = this.field.inverse(i2);
                i++;
            }
        }
        if (i == degree) {
            return iArr;
        }
        throw com.dcloud.zxing2.ChecksumException.getChecksumInstance();
    }

    private int[] findErrorMagnitudes(com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly modulusPoly, com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly modulusPoly2, int[] iArr) {
        int degree = modulusPoly2.getDegree();
        int[] iArr2 = new int[degree];
        for (int i = 1; i <= degree; i++) {
            iArr2[degree - i] = this.field.multiply(i, modulusPoly2.getCoefficient(i));
        }
        com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly modulusPoly3 = new com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly(this.field, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            int iInverse = this.field.inverse(iArr[i2]);
            iArr3[i2] = this.field.multiply(this.field.subtract(0, modulusPoly.evaluateAt(iInverse)), this.field.inverse(modulusPoly3.evaluateAt(iInverse)));
        }
        return iArr3;
    }

    private com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly[] runEuclideanAlgorithm(com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly modulusPoly, com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly modulusPoly2, int i) throws com.dcloud.zxing2.ChecksumException {
        if (modulusPoly.getDegree() >= modulusPoly2.getDegree()) {
            modulusPoly2 = modulusPoly;
            modulusPoly = modulusPoly2;
        }
        com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly zero = this.field.getZero();
        com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly one = this.field.getOne();
        while (true) {
            com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly modulusPoly3 = one;
            com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly modulusPoly4 = zero;
            zero = modulusPoly3;
            if (modulusPoly.getDegree() < i / 2) {
                int coefficient = zero.getCoefficient(0);
                if (coefficient == 0) {
                    throw com.dcloud.zxing2.ChecksumException.getChecksumInstance();
                }
                int iInverse = this.field.inverse(coefficient);
                return new com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly[]{zero.multiply(iInverse), modulusPoly.multiply(iInverse)};
            }
            if (modulusPoly.isZero()) {
                throw com.dcloud.zxing2.ChecksumException.getChecksumInstance();
            }
            com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly zero2 = this.field.getZero();
            int iInverse2 = this.field.inverse(modulusPoly.getCoefficient(modulusPoly.getDegree()));
            while (modulusPoly2.getDegree() >= modulusPoly.getDegree() && !modulusPoly2.isZero()) {
                int degree = modulusPoly2.getDegree() - modulusPoly.getDegree();
                int iMultiply = this.field.multiply(modulusPoly2.getCoefficient(modulusPoly2.getDegree()), iInverse2);
                zero2 = zero2.add(this.field.buildMonomial(degree, iMultiply));
                modulusPoly2 = modulusPoly2.subtract(modulusPoly.multiplyByMonomial(degree, iMultiply));
            }
            one = zero2.multiply(zero).subtract(modulusPoly4).negative();
            com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly modulusPoly5 = modulusPoly2;
            modulusPoly2 = modulusPoly;
            modulusPoly = modulusPoly5;
        }
    }

    public int decode(int[] iArr, int i, int[] iArr2) throws com.dcloud.zxing2.ChecksumException {
        com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly modulusPoly = new com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly(this.field, iArr);
        int[] iArr3 = new int[i];
        boolean z = false;
        for (int i2 = i; i2 > 0; i2--) {
            int iEvaluateAt = modulusPoly.evaluateAt(this.field.exp(i2));
            iArr3[i - i2] = iEvaluateAt;
            if (iEvaluateAt != 0) {
                z = true;
            }
        }
        if (!z) {
            return 0;
        }
        com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly one = this.field.getOne();
        if (iArr2 != null) {
            for (int i3 : iArr2) {
                int iExp = this.field.exp((iArr.length - 1) - i3);
                com.dcloud.zxing2.pdf417.decoder.ec.ModulusGF modulusGF = this.field;
                one = one.multiply(new com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly(modulusGF, new int[]{modulusGF.subtract(0, iExp), 1}));
            }
        }
        com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly[] modulusPolyArrRunEuclideanAlgorithm = runEuclideanAlgorithm(this.field.buildMonomial(i, 1), new com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly(this.field, iArr3), i);
        com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly modulusPoly2 = modulusPolyArrRunEuclideanAlgorithm[0];
        com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly modulusPoly3 = modulusPolyArrRunEuclideanAlgorithm[1];
        int[] iArrFindErrorLocations = findErrorLocations(modulusPoly2);
        int[] iArrFindErrorMagnitudes = findErrorMagnitudes(modulusPoly3, modulusPoly2, iArrFindErrorLocations);
        for (int i4 = 0; i4 < iArrFindErrorLocations.length; i4++) {
            int length = (iArr.length - 1) - this.field.log(iArrFindErrorLocations[i4]);
            if (length < 0) {
                throw com.dcloud.zxing2.ChecksumException.getChecksumInstance();
            }
            iArr[length] = this.field.subtract(iArr[length], iArrFindErrorMagnitudes[i4]);
        }
        return iArrFindErrorLocations.length;
    }
}
