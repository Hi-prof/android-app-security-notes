package com.dcloud.zxing2.aztec.encoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class AztecCode {
    private int codeWords;
    private boolean compact;
    private int layers;
    private com.dcloud.zxing2.common.BitMatrix matrix;
    private int size;

    public int getCodeWords() {
        return this.codeWords;
    }

    public int getLayers() {
        return this.layers;
    }

    public com.dcloud.zxing2.common.BitMatrix getMatrix() {
        return this.matrix;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isCompact() {
        return this.compact;
    }

    public void setCodeWords(int i) {
        this.codeWords = i;
    }

    public void setCompact(boolean z) {
        this.compact = z;
    }

    public void setLayers(int i) {
        this.layers = i;
    }

    public void setMatrix(com.dcloud.zxing2.common.BitMatrix bitMatrix) {
        this.matrix = bitMatrix;
    }

    public void setSize(int i) {
        this.size = i;
    }
}
