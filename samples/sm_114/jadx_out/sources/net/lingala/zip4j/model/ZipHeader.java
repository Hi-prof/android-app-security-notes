package net.lingala.zip4j.model;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ZipHeader {
    private net.lingala.zip4j.headers.HeaderSignature signature;

    public net.lingala.zip4j.headers.HeaderSignature getSignature() {
        return this.signature;
    }

    public void setSignature(net.lingala.zip4j.headers.HeaderSignature headerSignature) {
        this.signature = headerSignature;
    }
}
