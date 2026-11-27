package net.lingala.zip4j.model.enums;

/* JADX INFO: loaded from: classes2.dex */
public enum RandomAccessFileMode {
    READ("r"),
    WRITE("rw");

    private java.lang.String value;

    RandomAccessFileMode(java.lang.String str) {
        this.value = str;
    }

    public java.lang.String getValue() {
        return this.value;
    }
}
