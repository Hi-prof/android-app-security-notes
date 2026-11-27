package com.dcloud.zxing2.datamatrix.encoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class EncoderContext {
    private final java.lang.StringBuilder codewords;
    private com.dcloud.zxing2.Dimension maxSize;
    private com.dcloud.zxing2.Dimension minSize;
    private final java.lang.String msg;
    private int newEncoding;
    int pos;
    private com.dcloud.zxing2.datamatrix.encoder.SymbolShapeHint shape;
    private int skipAtEnd;
    private com.dcloud.zxing2.datamatrix.encoder.SymbolInfo symbolInfo;

    EncoderContext(java.lang.String str) {
        byte[] bytes = str.getBytes(java.nio.charset.Charset.forName(net.lingala.zip4j.util.InternalZipConstants.AES_HASH_CHARSET));
        java.lang.StringBuilder sb = new java.lang.StringBuilder(bytes.length);
        int length = bytes.length;
        for (int i = 0; i < length; i++) {
            char c = (char) (bytes[i] & 255);
            if (c == '?' && str.charAt(i) != '?') {
                throw new java.lang.IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
            sb.append(c);
        }
        this.msg = sb.toString();
        this.shape = com.dcloud.zxing2.datamatrix.encoder.SymbolShapeHint.FORCE_NONE;
        this.codewords = new java.lang.StringBuilder(str.length());
        this.newEncoding = -1;
    }

    private int getTotalMessageCharCount() {
        return this.msg.length() - this.skipAtEnd;
    }

    public int getCodewordCount() {
        return this.codewords.length();
    }

    public java.lang.StringBuilder getCodewords() {
        return this.codewords;
    }

    public char getCurrent() {
        return this.msg.charAt(this.pos);
    }

    public char getCurrentChar() {
        return this.msg.charAt(this.pos);
    }

    public java.lang.String getMessage() {
        return this.msg;
    }

    public int getNewEncoding() {
        return this.newEncoding;
    }

    public int getRemainingCharacters() {
        return getTotalMessageCharCount() - this.pos;
    }

    public com.dcloud.zxing2.datamatrix.encoder.SymbolInfo getSymbolInfo() {
        return this.symbolInfo;
    }

    public boolean hasMoreCharacters() {
        return this.pos < getTotalMessageCharCount();
    }

    public void resetEncoderSignal() {
        this.newEncoding = -1;
    }

    public void resetSymbolInfo() {
        this.symbolInfo = null;
    }

    public void setSizeConstraints(com.dcloud.zxing2.Dimension dimension, com.dcloud.zxing2.Dimension dimension2) {
        this.minSize = dimension;
        this.maxSize = dimension2;
    }

    public void setSkipAtEnd(int i) {
        this.skipAtEnd = i;
    }

    public void setSymbolShape(com.dcloud.zxing2.datamatrix.encoder.SymbolShapeHint symbolShapeHint) {
        this.shape = symbolShapeHint;
    }

    public void signalEncoderChange(int i) {
        this.newEncoding = i;
    }

    public void updateSymbolInfo() {
        updateSymbolInfo(getCodewordCount());
    }

    public void writeCodeword(char c) {
        this.codewords.append(c);
    }

    public void writeCodewords(java.lang.String str) {
        this.codewords.append(str);
    }

    public void updateSymbolInfo(int i) {
        com.dcloud.zxing2.datamatrix.encoder.SymbolInfo symbolInfo = this.symbolInfo;
        if (symbolInfo == null || i > symbolInfo.getDataCapacity()) {
            this.symbolInfo = com.dcloud.zxing2.datamatrix.encoder.SymbolInfo.lookup(i, this.shape, this.minSize, this.maxSize, true);
        }
    }
}
