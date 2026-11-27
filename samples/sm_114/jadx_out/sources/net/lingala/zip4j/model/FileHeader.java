package net.lingala.zip4j.model;

/* JADX INFO: loaded from: classes2.dex */
public class FileHeader extends net.lingala.zip4j.model.AbstractFileHeader {
    private int diskNumberStart;
    private byte[] externalFileAttributes;
    private java.lang.String fileComment;
    private int fileCommentLength = 0;
    private byte[] internalFileAttributes;
    private long offsetLocalHeader;
    private int versionMadeBy;

    public FileHeader() {
        setSignature(net.lingala.zip4j.headers.HeaderSignature.CENTRAL_DIRECTORY);
    }

    public int getVersionMadeBy() {
        return this.versionMadeBy;
    }

    public void setVersionMadeBy(int i) {
        this.versionMadeBy = i;
    }

    public int getFileCommentLength() {
        return this.fileCommentLength;
    }

    public void setFileCommentLength(int i) {
        this.fileCommentLength = i;
    }

    public int getDiskNumberStart() {
        return this.diskNumberStart;
    }

    public void setDiskNumberStart(int i) {
        this.diskNumberStart = i;
    }

    public byte[] getInternalFileAttributes() {
        return this.internalFileAttributes;
    }

    public void setInternalFileAttributes(byte[] bArr) {
        this.internalFileAttributes = bArr;
    }

    public byte[] getExternalFileAttributes() {
        return this.externalFileAttributes;
    }

    public void setExternalFileAttributes(byte[] bArr) {
        this.externalFileAttributes = bArr;
    }

    public long getOffsetLocalHeader() {
        return this.offsetLocalHeader;
    }

    public void setOffsetLocalHeader(long j) {
        this.offsetLocalHeader = j;
    }

    public java.lang.String getFileComment() {
        return this.fileComment;
    }

    public void setFileComment(java.lang.String str) {
        this.fileComment = str;
    }

    public java.lang.String toString() {
        return getFileName();
    }

    @Override // net.lingala.zip4j.model.AbstractFileHeader
    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && super.equals(obj) && determineOffsetOfLocalFileHeader(this) == determineOffsetOfLocalFileHeader((net.lingala.zip4j.model.FileHeader) obj);
    }

    public int hashCode() {
        return java.util.Objects.hash(getFileName(), java.lang.Long.valueOf(determineOffsetOfLocalFileHeader(this)));
    }

    private long determineOffsetOfLocalFileHeader(net.lingala.zip4j.model.FileHeader fileHeader) {
        if (fileHeader.getZip64ExtendedInfo() != null) {
            return fileHeader.getZip64ExtendedInfo().getOffsetLocalHeader();
        }
        return fileHeader.getOffsetLocalHeader();
    }
}
