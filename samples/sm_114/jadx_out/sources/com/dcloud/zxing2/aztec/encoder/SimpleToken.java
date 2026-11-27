package com.dcloud.zxing2.aztec.encoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class SimpleToken extends com.dcloud.zxing2.aztec.encoder.Token {
    private final short bitCount;
    private final short value;

    SimpleToken(com.dcloud.zxing2.aztec.encoder.Token token, int i, int i2) {
        super(token);
        this.value = (short) i;
        this.bitCount = (short) i2;
    }

    @Override // com.dcloud.zxing2.aztec.encoder.Token
    void appendTo(com.dcloud.zxing2.common.BitArray bitArray, byte[] bArr) {
        bitArray.appendBits(this.value, this.bitCount);
    }

    public java.lang.String toString() {
        short s = this.value;
        int i = 1 << this.bitCount;
        return com.taobao.weex.el.parse.Operators.L + java.lang.Integer.toBinaryString((s & (i - 1)) | i | (1 << this.bitCount)).substring(1) + kotlin.text.Typography.greater;
    }
}
