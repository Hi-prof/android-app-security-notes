package com.dcloud.zxing2.aztec.encoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class State {
    static final com.dcloud.zxing2.aztec.encoder.State INITIAL_STATE = new com.dcloud.zxing2.aztec.encoder.State(com.dcloud.zxing2.aztec.encoder.Token.EMPTY, 0, 0, 0);
    private final int binaryShiftByteCount;
    private final int bitCount;
    private final int mode;
    private final com.dcloud.zxing2.aztec.encoder.Token token;

    private State(com.dcloud.zxing2.aztec.encoder.Token token, int i, int i2, int i3) {
        this.token = token;
        this.mode = i;
        this.binaryShiftByteCount = i2;
        this.bitCount = i3;
    }

    com.dcloud.zxing2.aztec.encoder.State addBinaryShiftChar(int i) {
        int i2;
        com.dcloud.zxing2.aztec.encoder.Token tokenAdd = this.token;
        int i3 = this.mode;
        int i4 = this.bitCount;
        if (i3 == 4 || i3 == 2) {
            int i5 = com.dcloud.zxing2.aztec.encoder.HighLevelEncoder.LATCH_TABLE[i3][0];
            int i6 = 65535 & i5;
            int i7 = i5 >> 16;
            tokenAdd = tokenAdd.add(i6, i7);
            i4 += i7;
            i3 = 0;
        }
        int i8 = this.binaryShiftByteCount;
        if (i8 == 0 || i8 == 31) {
            i2 = 18;
        } else {
            i2 = i8 == 62 ? 9 : 8;
        }
        com.dcloud.zxing2.aztec.encoder.State state = new com.dcloud.zxing2.aztec.encoder.State(tokenAdd, i3, i8 + 1, i4 + i2);
        return state.binaryShiftByteCount == 2078 ? state.endBinaryShift(i + 1) : state;
    }

    com.dcloud.zxing2.aztec.encoder.State endBinaryShift(int i) {
        int i2 = this.binaryShiftByteCount;
        return i2 == 0 ? this : new com.dcloud.zxing2.aztec.encoder.State(this.token.addBinaryShift(i - i2, i2), this.mode, 0, this.bitCount);
    }

    int getBinaryShiftByteCount() {
        return this.binaryShiftByteCount;
    }

    int getBitCount() {
        return this.bitCount;
    }

    int getMode() {
        return this.mode;
    }

    com.dcloud.zxing2.aztec.encoder.Token getToken() {
        return this.token;
    }

    boolean isBetterThanOrEqualTo(com.dcloud.zxing2.aztec.encoder.State state) {
        int i;
        int i2 = this.bitCount + (com.dcloud.zxing2.aztec.encoder.HighLevelEncoder.LATCH_TABLE[this.mode][state.mode] >> 16);
        int i3 = state.binaryShiftByteCount;
        if (i3 > 0 && ((i = this.binaryShiftByteCount) == 0 || i > i3)) {
            i2 += 10;
        }
        return i2 <= state.bitCount;
    }

    com.dcloud.zxing2.aztec.encoder.State latchAndAppend(int i, int i2) {
        int i3 = this.bitCount;
        com.dcloud.zxing2.aztec.encoder.Token tokenAdd = this.token;
        int i4 = this.mode;
        if (i != i4) {
            int i5 = com.dcloud.zxing2.aztec.encoder.HighLevelEncoder.LATCH_TABLE[i4][i];
            int i6 = 65535 & i5;
            int i7 = i5 >> 16;
            tokenAdd = tokenAdd.add(i6, i7);
            i3 += i7;
        }
        int i8 = i == 2 ? 4 : 5;
        return new com.dcloud.zxing2.aztec.encoder.State(tokenAdd.add(i2, i8), i, 0, i3 + i8);
    }

    com.dcloud.zxing2.aztec.encoder.State shiftAndAppend(int i, int i2) {
        com.dcloud.zxing2.aztec.encoder.Token token = this.token;
        int i3 = this.mode;
        int i4 = i3 == 2 ? 4 : 5;
        return new com.dcloud.zxing2.aztec.encoder.State(token.add(com.dcloud.zxing2.aztec.encoder.HighLevelEncoder.SHIFT_TABLE[i3][i], i4).add(i2, 5), this.mode, 0, this.bitCount + i4 + 5);
    }

    com.dcloud.zxing2.common.BitArray toBitArray(byte[] bArr) {
        java.util.LinkedList linkedList = new java.util.LinkedList();
        for (com.dcloud.zxing2.aztec.encoder.Token previous = endBinaryShift(bArr.length).token; previous != null; previous = previous.getPrevious()) {
            linkedList.addFirst(previous);
        }
        com.dcloud.zxing2.common.BitArray bitArray = new com.dcloud.zxing2.common.BitArray();
        java.util.Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((com.dcloud.zxing2.aztec.encoder.Token) it.next()).appendTo(bitArray, bArr);
        }
        return bitArray;
    }

    public java.lang.String toString() {
        return io.dcloud.common.util.StringUtil.format("%s bits=%d bytes=%d", com.dcloud.zxing2.aztec.encoder.HighLevelEncoder.MODE_NAMES[this.mode], java.lang.Integer.valueOf(this.bitCount), java.lang.Integer.valueOf(this.binaryShiftByteCount));
    }
}
