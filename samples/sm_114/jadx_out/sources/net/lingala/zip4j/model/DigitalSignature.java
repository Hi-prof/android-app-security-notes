package net.lingala.zip4j.model;

/* JADX INFO: loaded from: classes2.dex */
public class DigitalSignature extends net.lingala.zip4j.model.ZipHeader {
    private java.lang.String signatureData;
    private int sizeOfData;

    public int getSizeOfData() {
        return this.sizeOfData;
    }

    public void setSizeOfData(int i) {
        this.sizeOfData = i;
    }

    public java.lang.String getSignatureData() {
        return this.signatureData;
    }

    public void setSignatureData(java.lang.String str) {
        this.signatureData = str;
    }
}
