package com.dcloud.zxing2.pdf417.decoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class BarcodeMetadata {
    private final int columnCount;
    private final int errorCorrectionLevel;
    private final int rowCount;
    private final int rowCountLowerPart;
    private final int rowCountUpperPart;

    BarcodeMetadata(int i, int i2, int i3, int i4) {
        this.columnCount = i;
        this.errorCorrectionLevel = i4;
        this.rowCountUpperPart = i2;
        this.rowCountLowerPart = i3;
        this.rowCount = i2 + i3;
    }

    int getColumnCount() {
        return this.columnCount;
    }

    int getErrorCorrectionLevel() {
        return this.errorCorrectionLevel;
    }

    int getRowCount() {
        return this.rowCount;
    }

    int getRowCountLowerPart() {
        return this.rowCountLowerPart;
    }

    int getRowCountUpperPart() {
        return this.rowCountUpperPart;
    }
}
