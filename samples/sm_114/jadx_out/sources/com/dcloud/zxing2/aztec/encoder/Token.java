package com.dcloud.zxing2.aztec.encoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
abstract class Token {
    static final com.dcloud.zxing2.aztec.encoder.Token EMPTY = new com.dcloud.zxing2.aztec.encoder.SimpleToken(null, 0, 0);
    private final com.dcloud.zxing2.aztec.encoder.Token previous;

    Token(com.dcloud.zxing2.aztec.encoder.Token token) {
        this.previous = token;
    }

    final com.dcloud.zxing2.aztec.encoder.Token add(int i, int i2) {
        return new com.dcloud.zxing2.aztec.encoder.SimpleToken(this, i, i2);
    }

    final com.dcloud.zxing2.aztec.encoder.Token addBinaryShift(int i, int i2) {
        return new com.dcloud.zxing2.aztec.encoder.BinaryShiftToken(this, i, i2);
    }

    abstract void appendTo(com.dcloud.zxing2.common.BitArray bitArray, byte[] bArr);

    final com.dcloud.zxing2.aztec.encoder.Token getPrevious() {
        return this.previous;
    }
}
