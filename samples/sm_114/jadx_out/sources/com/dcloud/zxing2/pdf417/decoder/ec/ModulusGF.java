package com.dcloud.zxing2.pdf417.decoder.ec;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class ModulusGF {
    public static final com.dcloud.zxing2.pdf417.decoder.ec.ModulusGF PDF417_GF = new com.dcloud.zxing2.pdf417.decoder.ec.ModulusGF(com.dcloud.zxing2.pdf417.PDF417Common.NUMBER_OF_CODEWORDS, 3);
    private final int[] expTable;
    private final int[] logTable;
    private final int modulus;
    private final com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly one;
    private final com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly zero;

    private ModulusGF(int i, int i2) {
        this.modulus = i;
        this.expTable = new int[i];
        this.logTable = new int[i];
        int i3 = 1;
        for (int i4 = 0; i4 < i; i4++) {
            this.expTable[i4] = i3;
            i3 = (i3 * i2) % i;
        }
        for (int i5 = 0; i5 < i - 1; i5++) {
            this.logTable[this.expTable[i5]] = i5;
        }
        this.zero = new com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly(this, new int[]{0});
        this.one = new com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly(this, new int[]{1});
    }

    int add(int i, int i2) {
        return (i + i2) % this.modulus;
    }

    com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly buildMonomial(int i, int i2) {
        if (i < 0) {
            throw new java.lang.IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.zero;
        }
        int[] iArr = new int[i + 1];
        iArr[0] = i2;
        return new com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly(this, iArr);
    }

    int exp(int i) {
        return this.expTable[i];
    }

    com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly getOne() {
        return this.one;
    }

    int getSize() {
        return this.modulus;
    }

    com.dcloud.zxing2.pdf417.decoder.ec.ModulusPoly getZero() {
        return this.zero;
    }

    int inverse(int i) {
        if (i != 0) {
            return this.expTable[(this.modulus - this.logTable[i]) - 1];
        }
        throw new java.lang.ArithmeticException();
    }

    int log(int i) {
        if (i != 0) {
            return this.logTable[i];
        }
        throw new java.lang.IllegalArgumentException();
    }

    int multiply(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        int[] iArr = this.expTable;
        int[] iArr2 = this.logTable;
        return iArr[(iArr2[i] + iArr2[i2]) % (this.modulus - 1)];
    }

    int subtract(int i, int i2) {
        int i3 = this.modulus;
        return ((i + i3) - i2) % i3;
    }
}
