package com.dcloud.zxing2.aztec.encoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class BinaryShiftToken extends com.dcloud.zxing2.aztec.encoder.Token {
    private final short binaryShiftByteCount;
    private final short binaryShiftStart;

    BinaryShiftToken(com.dcloud.zxing2.aztec.encoder.Token token, int i, int i2) {
        super(token);
        this.binaryShiftStart = (short) i;
        this.binaryShiftByteCount = (short) i2;
    }

    @Override // com.dcloud.zxing2.aztec.encoder.Token
    public void appendTo(com.dcloud.zxing2.common.BitArray bitArray, byte[] bArr) {
        int i = 0;
        while (true) {
            short s = this.binaryShiftByteCount;
            if (i >= s) {
                return;
            }
            if (i == 0 || (i == 31 && s <= 62)) {
                bitArray.appendBits(31, 5);
                short s2 = this.binaryShiftByteCount;
                if (s2 > 62) {
                    bitArray.appendBits(s2 - 31, 16);
                } else if (i == 0) {
                    bitArray.appendBits(java.lang.Math.min((int) s2, 31), 5);
                } else {
                    bitArray.appendBits(s2 - 31, 5);
                }
            }
            bitArray.appendBits(bArr[this.binaryShiftStart + i], 8);
            i++;
        }
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(com.taobao.weex.el.parse.Operators.L);
        sb.append((int) this.binaryShiftStart);
        sb.append("::");
        sb.append((this.binaryShiftStart + this.binaryShiftByteCount) - 1);
        sb.append(kotlin.text.Typography.greater);
        return sb.toString();
    }
}
