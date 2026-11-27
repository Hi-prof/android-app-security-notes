package com.dcloud.zxing2.common;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class DecoderResult {
    private final java.util.List<byte[]> byteSegments;
    private final java.lang.String ecLevel;
    private java.lang.Integer erasures;
    private java.lang.Integer errorsCorrected;
    private java.lang.Object other;
    private final byte[] rawBytes;
    private final int structuredAppendParity;
    private final int structuredAppendSequenceNumber;
    private final java.lang.String text;
    public java.lang.String textCharset;

    public DecoderResult(byte[] bArr, java.lang.String str, java.util.List<byte[]> list, java.lang.String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public java.util.List<byte[]> getByteSegments() {
        return this.byteSegments;
    }

    public java.lang.String getECLevel() {
        return this.ecLevel;
    }

    public java.lang.Integer getErasures() {
        return this.erasures;
    }

    public java.lang.Integer getErrorsCorrected() {
        return this.errorsCorrected;
    }

    public java.lang.Object getOther() {
        return this.other;
    }

    public byte[] getRawBytes() {
        return this.rawBytes;
    }

    public int getStructuredAppendParity() {
        return this.structuredAppendParity;
    }

    public int getStructuredAppendSequenceNumber() {
        return this.structuredAppendSequenceNumber;
    }

    public java.lang.String getText() {
        return this.text;
    }

    public boolean hasStructuredAppend() {
        return this.structuredAppendParity >= 0 && this.structuredAppendSequenceNumber >= 0;
    }

    public void setErasures(java.lang.Integer num) {
        this.erasures = num;
    }

    public void setErrorsCorrected(java.lang.Integer num) {
        this.errorsCorrected = num;
    }

    public void setOther(java.lang.Object obj) {
        this.other = obj;
    }

    public DecoderResult(byte[] bArr, java.lang.String str, java.util.List<byte[]> list, java.lang.String str2, int i, int i2) {
        this.rawBytes = bArr;
        this.text = str;
        this.byteSegments = list;
        this.ecLevel = str2;
        this.structuredAppendParity = i2;
        this.structuredAppendSequenceNumber = i;
    }
}
