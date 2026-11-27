package net.lingala.zip4j.model;

/* JADX INFO: loaded from: classes2.dex */
public class LocalFileHeader extends net.lingala.zip4j.model.AbstractFileHeader {
    private byte[] extraField;
    private long offsetStartOfData;
    private boolean writeCompressedSizeInZip64ExtraRecord;

    public LocalFileHeader() {
        setSignature(net.lingala.zip4j.headers.HeaderSignature.LOCAL_FILE_HEADER);
    }

    public byte[] getExtraField() {
        return this.extraField;
    }

    public void setExtraField(byte[] bArr) {
        this.extraField = bArr;
    }

    public long getOffsetStartOfData() {
        return this.offsetStartOfData;
    }

    public void setOffsetStartOfData(long j) {
        this.offsetStartOfData = j;
    }

    public boolean isWriteCompressedSizeInZip64ExtraRecord() {
        return this.writeCompressedSizeInZip64ExtraRecord;
    }

    public void setWriteCompressedSizeInZip64ExtraRecord(boolean z) {
        this.writeCompressedSizeInZip64ExtraRecord = z;
    }
}
