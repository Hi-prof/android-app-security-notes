package net.lingala.zip4j.model;

/* JADX INFO: loaded from: classes2.dex */
public class ZipModel implements java.lang.Cloneable {
    private long end;
    private boolean isNestedZipFile;
    private boolean splitArchive;
    private long start;
    private java.io.File zipFile;
    private java.util.List<net.lingala.zip4j.model.LocalFileHeader> localFileHeaders = new java.util.ArrayList();
    private java.util.List<net.lingala.zip4j.model.DataDescriptor> dataDescriptors = new java.util.ArrayList();
    private net.lingala.zip4j.model.ArchiveExtraDataRecord archiveExtraDataRecord = new net.lingala.zip4j.model.ArchiveExtraDataRecord();
    private net.lingala.zip4j.model.CentralDirectory centralDirectory = new net.lingala.zip4j.model.CentralDirectory();
    private net.lingala.zip4j.model.EndOfCentralDirectoryRecord endOfCentralDirectoryRecord = new net.lingala.zip4j.model.EndOfCentralDirectoryRecord();
    private net.lingala.zip4j.model.Zip64EndOfCentralDirectoryLocator zip64EndOfCentralDirectoryLocator = new net.lingala.zip4j.model.Zip64EndOfCentralDirectoryLocator();
    private net.lingala.zip4j.model.Zip64EndOfCentralDirectoryRecord zip64EndOfCentralDirectoryRecord = new net.lingala.zip4j.model.Zip64EndOfCentralDirectoryRecord();
    private boolean isZip64Format = false;
    private long splitLength = -1;

    public java.util.List<net.lingala.zip4j.model.LocalFileHeader> getLocalFileHeaders() {
        return this.localFileHeaders;
    }

    public void setLocalFileHeaders(java.util.List<net.lingala.zip4j.model.LocalFileHeader> list) {
        this.localFileHeaders = list;
    }

    public java.util.List<net.lingala.zip4j.model.DataDescriptor> getDataDescriptors() {
        return this.dataDescriptors;
    }

    public void setDataDescriptors(java.util.List<net.lingala.zip4j.model.DataDescriptor> list) {
        this.dataDescriptors = list;
    }

    public net.lingala.zip4j.model.CentralDirectory getCentralDirectory() {
        return this.centralDirectory;
    }

    public void setCentralDirectory(net.lingala.zip4j.model.CentralDirectory centralDirectory) {
        this.centralDirectory = centralDirectory;
    }

    public net.lingala.zip4j.model.EndOfCentralDirectoryRecord getEndOfCentralDirectoryRecord() {
        return this.endOfCentralDirectoryRecord;
    }

    public void setEndOfCentralDirectoryRecord(net.lingala.zip4j.model.EndOfCentralDirectoryRecord endOfCentralDirectoryRecord) {
        this.endOfCentralDirectoryRecord = endOfCentralDirectoryRecord;
    }

    public net.lingala.zip4j.model.ArchiveExtraDataRecord getArchiveExtraDataRecord() {
        return this.archiveExtraDataRecord;
    }

    public void setArchiveExtraDataRecord(net.lingala.zip4j.model.ArchiveExtraDataRecord archiveExtraDataRecord) {
        this.archiveExtraDataRecord = archiveExtraDataRecord;
    }

    public boolean isSplitArchive() {
        return this.splitArchive;
    }

    public void setSplitArchive(boolean z) {
        this.splitArchive = z;
    }

    public java.io.File getZipFile() {
        return this.zipFile;
    }

    public void setZipFile(java.io.File file) {
        this.zipFile = file;
    }

    public net.lingala.zip4j.model.Zip64EndOfCentralDirectoryLocator getZip64EndOfCentralDirectoryLocator() {
        return this.zip64EndOfCentralDirectoryLocator;
    }

    public void setZip64EndOfCentralDirectoryLocator(net.lingala.zip4j.model.Zip64EndOfCentralDirectoryLocator zip64EndOfCentralDirectoryLocator) {
        this.zip64EndOfCentralDirectoryLocator = zip64EndOfCentralDirectoryLocator;
    }

    public net.lingala.zip4j.model.Zip64EndOfCentralDirectoryRecord getZip64EndOfCentralDirectoryRecord() {
        return this.zip64EndOfCentralDirectoryRecord;
    }

    public void setZip64EndOfCentralDirectoryRecord(net.lingala.zip4j.model.Zip64EndOfCentralDirectoryRecord zip64EndOfCentralDirectoryRecord) {
        this.zip64EndOfCentralDirectoryRecord = zip64EndOfCentralDirectoryRecord;
    }

    public boolean isZip64Format() {
        return this.isZip64Format;
    }

    public void setZip64Format(boolean z) {
        this.isZip64Format = z;
    }

    public boolean isNestedZipFile() {
        return this.isNestedZipFile;
    }

    public void setNestedZipFile(boolean z) {
        this.isNestedZipFile = z;
    }

    public long getStart() {
        return this.start;
    }

    public void setStart(long j) {
        this.start = j;
    }

    public long getEnd() {
        return this.end;
    }

    public void setEnd(long j) {
        this.end = j;
    }

    public long getSplitLength() {
        return this.splitLength;
    }

    public void setSplitLength(long j) {
        this.splitLength = j;
    }

    public java.lang.Object clone() throws java.lang.CloneNotSupportedException {
        return super.clone();
    }
}
