package net.lingala.zip4j.model;

/* JADX INFO: loaded from: classes2.dex */
public class ArchiveExtraDataRecord extends net.lingala.zip4j.model.ZipHeader {
    private java.lang.String extraFieldData;
    private int extraFieldLength;

    public int getExtraFieldLength() {
        return this.extraFieldLength;
    }

    public void setExtraFieldLength(int i) {
        this.extraFieldLength = i;
    }

    public java.lang.String getExtraFieldData() {
        return this.extraFieldData;
    }

    public void setExtraFieldData(java.lang.String str) {
        this.extraFieldData = str;
    }
}
