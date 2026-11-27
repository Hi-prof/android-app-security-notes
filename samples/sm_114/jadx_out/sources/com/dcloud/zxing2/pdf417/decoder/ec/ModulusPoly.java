package com.dcloud.zxing2.pdf417.decoder.ec;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class ModulusPoly {
    private final int[] coefficients;
    private final com.dcloud.zxing2.pdf417.decoder.ec.ModulusGF field;

    ModulusPoly(com.dcloud.zxing2.pdf417.decoder.ec.ModulusGF modulusGF, int[] iArr) {
        if (iArr.length == 0) {
            throw new java.lang.IllegalArgumentException();
        }
        this.field = modulusGF;
        int length = iArr.length;
        int i = 1;
        if (length <= 1 || iArr[0] != 0) {
            this.coefficients = iArr;
            return;
        }
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.coefficients = new int[]{0};
            return;
        }
        int i2 = length - i;
        int[] iArr2 = new int[i2];
        this.coefficients = iArr2;
        java.lang.System.arraycopy(iArr, i, iArr2, 0, i2);
    }

    com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly add(com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly modulusPoly) {
        if (!this.field.equals(modulusPoly.field)) {
            throw new java.lang.IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (isZero()) {
            return modulusPoly;
        }
        if (modulusPoly.isZero()) {
            return this;
        }
        int[] iArr = this.coefficients;
        int[] iArr2 = modulusPoly.coefficients;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        java.lang.System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i = length; i < iArr.length; i++) {
            iArr3[i] = this.field.add(iArr2[i - length], iArr[i]);
        }
        return new com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly(this.field, iArr3);
    }

    com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly[] divide(com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly modulusPoly) {
        if (!this.field.equals(modulusPoly.field)) {
            throw new java.lang.IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (modulusPoly.isZero()) {
            throw new java.lang.IllegalArgumentException("Divide by 0");
        }
        com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly zero = this.field.getZero();
        int iInverse = this.field.inverse(modulusPoly.getCoefficient(modulusPoly.getDegree()));
        com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly modulusPolySubtract = this;
        while (modulusPolySubtract.getDegree() >= modulusPoly.getDegree() && !modulusPolySubtract.isZero()) {
            int degree = modulusPolySubtract.getDegree() - modulusPoly.getDegree();
            int iMultiply = this.field.multiply(modulusPolySubtract.getCoefficient(modulusPolySubtract.getDegree()), iInverse);
            com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly modulusPolyMultiplyByMonomial = modulusPoly.multiplyByMonomial(degree, iMultiply);
            zero = zero.add(this.field.buildMonomial(degree, iMultiply));
            modulusPolySubtract = modulusPolySubtract.subtract(modulusPolyMultiplyByMonomial);
        }
        return new com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly[]{zero, modulusPolySubtract};
    }

    int evaluateAt(int i) {
        if (i == 0) {
            return getCoefficient(0);
        }
        int[] iArr = this.coefficients;
        int length = iArr.length;
        if (i != 1) {
            int iAdd = iArr[0];
            for (int i2 = 1; i2 < length; i2++) {
                com.dcloud.zxing2.pdf417.decoder.ec.ModulusGF modulusGF = this.field;
                iAdd = modulusGF.add(modulusGF.multiply(i, iAdd), this.coefficients[i2]);
            }
            return iAdd;
        }
        int iAdd2 = 0;
        for (int i3 : iArr) {
            iAdd2 = this.field.add(iAdd2, i3);
        }
        return iAdd2;
    }

    int getCoefficient(int i) {
        int[] iArr = this.coefficients;
        return iArr[(iArr.length - 1) - i];
    }

    int[] getCoefficients() {
        return this.coefficients;
    }

    int getDegree() {
        return this.coefficients.length - 1;
    }

    boolean isZero() {
        return this.coefficients[0] == 0;
    }

    com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly multiply(com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly modulusPoly) {
        if (!this.field.equals(modulusPoly.field)) {
            throw new java.lang.IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (isZero() || modulusPoly.isZero()) {
            return this.field.getZero();
        }
        int[] iArr = this.coefficients;
        int length = iArr.length;
        int[] iArr2 = modulusPoly.coefficients;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            for (int i3 = 0; i3 < length2; i3++) {
                int i4 = i + i3;
                com.dcloud.zxing2.pdf417.decoder.ec.ModulusGF modulusGF = this.field;
                iArr3[i4] = modulusGF.add(iArr3[i4], modulusGF.multiply(i2, iArr2[i3]));
            }
        }
        return new com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly(this.field, iArr3);
    }

    com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly multiplyByMonomial(int i, int i2) {
        if (i < 0) {
            throw new java.lang.IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.field.getZero();
        }
        int length = this.coefficients.length;
        int[] iArr = new int[i + length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.field.multiply(this.coefficients[i3], i2);
        }
        return new com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly(this.field, iArr);
    }

    com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly negative() {
        int length = this.coefficients.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = this.field.subtract(0, this.coefficients[i]);
        }
        return new com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly(this.field, iArr);
    }

    com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly subtract(com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly modulusPoly) {
        if (this.field.equals(modulusPoly.field)) {
            return modulusPoly.isZero() ? this : add(modulusPoly.negative());
        }
        throw new java.lang.IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(getDegree() * 8);
        for (int degree = getDegree(); degree >= 0; degree--) {
            int coefficient = getCoefficient(degree);
            if (coefficient != 0) {
                if (coefficient < 0) {
                    sb.append(" - ");
                    coefficient = -coefficient;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (degree == 0 || coefficient != 1) {
                    sb.append(coefficient);
                }
                if (degree != 0) {
                    if (degree == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(degree);
                    }
                }
            }
        }
        return sb.toString();
    }

    com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly multiply(int i) {
        if (i == 0) {
            return this.field.getZero();
        }
        if (i == 1) {
            return this;
        }
        int length = this.coefficients.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.field.multiply(this.coefficients[i2], i);
        }
        return new com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly(this.field, iArr);
    }
}
