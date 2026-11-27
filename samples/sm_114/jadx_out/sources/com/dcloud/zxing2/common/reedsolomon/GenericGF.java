package com.dcloud.zxing2.common.reedsolomon;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class GenericGF {
    public static final com.dcloud.zxing2.common.reedsolomon.GenericGF AZTEC_DATA_6;
    public static final com.dcloud.zxing2.common.reedsolomon.GenericGF AZTEC_DATA_8;
    public static final com.dcloud.zxing2.common.reedsolomon.GenericGF AZTEC_PARAM;
    public static final com.dcloud.zxing2.common.reedsolomon.GenericGF DATA_MATRIX_FIELD_256;
    public static final com.dcloud.zxing2.common.reedsolomon.GenericGF MAXICODE_FIELD_64;
    public static final com.dcloud.zxing2.common.reedsolomon.GenericGF QR_CODE_FIELD_256;
    private final int[] expTable;
    private final int generatorBase;
    private final int[] logTable;
    private final com.dcloud.zxing2.common.reedsolomon.GenericGFPoly one;
    private final int primitive;
    private final int size;
    private final com.dcloud.zxing2.common.reedsolomon.GenericGFPoly zero;
    public static final com.dcloud.zxing2.common.reedsolomon.GenericGF AZTEC_DATA_12 = new com.dcloud.zxing2.common.reedsolomon.GenericGF(4201, 4096, 1);
    public static final com.dcloud.zxing2.common.reedsolomon.GenericGF AZTEC_DATA_10 = new com.dcloud.zxing2.common.reedsolomon.GenericGF(1033, 1024, 1);

    static {
        com.dcloud.zxing2.common.reedsolomon.GenericGF genericGF = new com.dcloud.zxing2.common.reedsolomon.GenericGF(67, 64, 1);
        AZTEC_DATA_6 = genericGF;
        AZTEC_PARAM = new com.dcloud.zxing2.common.reedsolomon.GenericGF(19, 16, 1);
        QR_CODE_FIELD_256 = new com.dcloud.zxing2.common.reedsolomon.GenericGF(285, 256, 0);
        com.dcloud.zxing2.common.reedsolomon.GenericGF genericGF2 = new com.dcloud.zxing2.common.reedsolomon.GenericGF(301, 256, 1);
        DATA_MATRIX_FIELD_256 = genericGF2;
        AZTEC_DATA_8 = genericGF2;
        MAXICODE_FIELD_64 = genericGF;
    }

    public GenericGF(int i, int i2, int i3) {
        this.primitive = i;
        this.size = i2;
        this.generatorBase = i3;
        this.expTable = new int[i2];
        this.logTable = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.expTable[i5] = i4;
            i4 *= 2;
            if (i4 >= i2) {
                i4 = (i4 ^ i) & (i2 - 1);
            }
        }
        for (int i6 = 0; i6 < i2 - 1; i6++) {
            this.logTable[this.expTable[i6]] = i6;
        }
        this.zero = new com.dcloud.zxing2.common.reedsolomon.GenericGFPoly(this, new int[]{0});
        this.one = new com.dcloud.zxing2.common.reedsolomon.GenericGFPoly(this, new int[]{1});
    }

    static int addOrSubtract(int i, int i2) {
        return i ^ i2;
    }

    com.dcloud.zxing2.common.reedsolomon.GenericGFPoly buildMonomial(int i, int i2) {
        if (i < 0) {
            throw new java.lang.IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.zero;
        }
        int[] iArr = new int[i + 1];
        iArr[0] = i2;
        return new com.dcloud.zxing2.common.reedsolomon.GenericGFPoly(this, iArr);
    }

    int exp(int i) {
        return this.expTable[i];
    }

    public int getGeneratorBase() {
        return this.generatorBase;
    }

    com.dcloud.zxing2.common.reedsolomon.GenericGFPoly getOne() {
        return this.one;
    }

    public int getSize() {
        return this.size;
    }

    com.dcloud.zxing2.common.reedsolomon.GenericGFPoly getZero() {
        return this.zero;
    }

    int inverse(int i) {
        if (i != 0) {
            return this.expTable[(this.size - this.logTable[i]) - 1];
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
        return iArr[(iArr2[i] + iArr2[i2]) % (this.size - 1)];
    }

    public java.lang.String toString() {
        return "GF(0x" + java.lang.Integer.toHexString(this.primitive) + com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR + this.size + com.taobao.weex.el.parse.Operators.BRACKET_END;
    }
}
