package net.lingala.zip4j.model;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractFileHeader extends net.lingala.zip4j.model.ZipHeader {
    private net.lingala.zip4j.model.AESExtraDataRecord aesExtraDataRecord;
    private net.lingala.zip4j.model.enums.CompressionMethod compressionMethod;
    private boolean dataDescriptorExists;
    private java.util.List<net.lingala.zip4j.model.ExtraDataRecord> extraDataRecords;
    private int extraFieldLength;
    private java.lang.String fileName;
    private int fileNameLength;
    private boolean fileNameUTF8Encoded;
    private byte[] generalPurposeFlag;
    private boolean isDirectory;
    private boolean isEncrypted;
    private long lastModifiedTime;
    private int versionNeededToExtract;
    private net.lingala.zip4j.model.Zip64ExtendedInfo zip64ExtendedInfo;
    private long crc = 0;
    private long compressedSize = 0;
    private long uncompressedSize = 0;
    private net.lingala.zip4j.model.enums.EncryptionMethod encryptionMethod = net.lingala.zip4j.model.enums.EncryptionMethod.NONE;

    public int getVersionNeededToExtract() {
        return this.versionNeededToExtract;
    }

    public void setVersionNeededToExtract(int i) {
        this.versionNeededToExtract = i;
    }

    public byte[] getGeneralPurposeFlag() {
        return this.generalPurposeFlag;
    }

    public void setGeneralPurposeFlag(byte[] bArr) {
        this.generalPurposeFlag = bArr;
    }

    public net.lingala.zip4j.model.enums.CompressionMethod getCompressionMethod() {
        return this.compressionMethod;
    }

    public void setCompressionMethod(net.lingala.zip4j.model.enums.CompressionMethod compressionMethod) {
        this.compressionMethod = compressionMethod;
    }

    public long getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    public void setLastModifiedTime(long j) {
        this.lastModifiedTime = j;
    }

    public long getLastModifiedTimeEpoch() {
        return net.lingala.zip4j.util.Zip4jUtil.dosToExtendedEpochTme(this.lastModifiedTime);
    }

    public long getCrc() {
        return this.crc;
    }

    public void setCrc(long j) {
        this.crc = j;
    }

    public long getCompressedSize() {
        return this.compressedSize;
    }

    public void setCompressedSize(long j) {
        this.compressedSize = j;
    }

    public long getUncompressedSize() {
        return this.uncompressedSize;
    }

    public void setUncompressedSize(long j) {
        this.uncompressedSize = j;
    }

    public int getFileNameLength() {
        return this.fileNameLength;
    }

    public void setFileNameLength(int i) {
        this.fileNameLength = i;
    }

    public int getExtraFieldLength() {
        return this.extraFieldLength;
    }

    public void setExtraFieldLength(int i) {
        this.extraFieldLength = i;
    }

    public java.lang.String getFileName() {
        return this.fileName;
    }

    public void setFileName(java.lang.String str) {
        this.fileName = str;
    }

    public boolean isEncrypted() {
        return this.isEncrypted;
    }

    public void setEncrypted(boolean z) {
        this.isEncrypted = z;
    }

    public net.lingala.zip4j.model.enums.EncryptionMethod getEncryptionMethod() {
        return this.encryptionMethod;
    }

    public void setEncryptionMethod(net.lingala.zip4j.model.enums.EncryptionMethod encryptionMethod) {
        this.encryptionMethod = encryptionMethod;
    }

    public boolean isDataDescriptorExists() {
        return this.dataDescriptorExists;
    }

    public void setDataDescriptorExists(boolean z) {
        this.dataDescriptorExists = z;
    }

    public net.lingala.zip4j.model.Zip64ExtendedInfo getZip64ExtendedInfo() {
        return this.zip64ExtendedInfo;
    }

    public void setZip64ExtendedInfo(net.lingala.zip4j.model.Zip64ExtendedInfo zip64ExtendedInfo) {
        this.zip64ExtendedInfo = zip64ExtendedInfo;
    }

    public net.lingala.zip4j.model.AESExtraDataRecord getAesExtraDataRecord() {
        return this.aesExtraDataRecord;
    }

    public void setAesExtraDataRecord(net.lingala.zip4j.model.AESExtraDataRecord aESExtraDataRecord) {
        this.aesExtraDataRecord = aESExtraDataRecord;
    }

    public boolean isFileNameUTF8Encoded() {
        return this.fileNameUTF8Encoded;
    }

    public void setFileNameUTF8Encoded(boolean z) {
        this.fileNameUTF8Encoded = z;
    }

    public java.util.List<net.lingala.zip4j.model.ExtraDataRecord> getExtraDataRecords() {
        return this.extraDataRecords;
    }

    public void setExtraDataRecords(java.util.List<net.lingala.zip4j.model.ExtraDataRecord> list) {
        this.extraDataRecords = list;
    }

    public boolean isDirectory() {
        return this.isDirectory;
    }

    public void setDirectory(boolean z) {
        this.isDirectory = z;
    }

    public boolean equals(java.lang.Object obj) {
        if (obj != null && (obj instanceof net.lingala.zip4j.model.AbstractFileHeader)) {
            return getFileName().equals(((net.lingala.zip4j.model.AbstractFileHeader) obj).getFileName());
        }
        return false;
    }
}
