package com.dcloud.zxing2.datamatrix.encoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class DataMatrixSymbolInfo144 extends com.dcloud.zxing2.datamatrix.encoder.SymbolInfo {
    DataMatrixSymbolInfo144() {
        super(false, 1558, 620, 22, 22, 36, -1, 62);
    }

    @Override // com.dcloud.zxing2.datamatrix.encoder.SymbolInfo
    public int getDataLengthForInterleavedBlock(int i) {
        return i <= 8 ? 156 : 155;
    }

    @Override // com.dcloud.zxing2.datamatrix.encoder.SymbolInfo
    public int getInterleavedBlockCount() {
        return 10;
    }
}
