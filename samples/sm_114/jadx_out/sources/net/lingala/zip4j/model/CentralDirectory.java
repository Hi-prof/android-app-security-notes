package net.lingala.zip4j.model;

/* JADX INFO: loaded from: classes2.dex */
public class CentralDirectory {
    private java.util.List<net.lingala.zip4j.model.FileHeader> fileHeaders = new java.util.ArrayList();
    private net.lingala.zip4j.model.DigitalSignature digitalSignature = new net.lingala.zip4j.model.DigitalSignature();

    public java.util.List<net.lingala.zip4j.model.FileHeader> getFileHeaders() {
        return this.fileHeaders;
    }

    public void setFileHeaders(java.util.List<net.lingala.zip4j.model.FileHeader> list) {
        this.fileHeaders = list;
    }

    public net.lingala.zip4j.model.DigitalSignature getDigitalSignature() {
        return this.digitalSignature;
    }

    public void setDigitalSignature(net.lingala.zip4j.model.DigitalSignature digitalSignature) {
        this.digitalSignature = digitalSignature;
    }
}
