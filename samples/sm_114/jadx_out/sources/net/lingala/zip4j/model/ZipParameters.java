package net.lingala.zip4j.model;

/* JADX INFO: loaded from: classes2.dex */
public class ZipParameters {
    private net.lingala.zip4j.model.enums.AesKeyStrength aesKeyStrength;
    private net.lingala.zip4j.model.enums.AesVersion aesVersion;
    private net.lingala.zip4j.model.enums.CompressionLevel compressionLevel;
    private net.lingala.zip4j.model.enums.CompressionMethod compressionMethod;
    private java.lang.String defaultFolderPath;
    private boolean encryptFiles;
    private net.lingala.zip4j.model.enums.EncryptionMethod encryptionMethod;
    private long entryCRC;
    private long entrySize;
    private net.lingala.zip4j.model.ExcludeFileFilter excludeFileFilter;
    private java.lang.String fileComment;
    private java.lang.String fileNameInZip;
    private boolean includeRootFolder;
    private long lastModifiedFileTime;
    private boolean overrideExistingFilesInZip;
    private boolean readHiddenFiles;
    private boolean readHiddenFolders;
    private java.lang.String rootFolderNameInZip;
    private net.lingala.zip4j.model.ZipParameters.SymbolicLinkAction symbolicLinkAction;
    private boolean unixMode;
    private boolean writeExtendedLocalFileHeader;

    public enum SymbolicLinkAction {
        INCLUDE_LINK_ONLY,
        INCLUDE_LINKED_FILE_ONLY,
        INCLUDE_LINK_AND_LINKED_FILE
    }

    public ZipParameters() {
        this.compressionMethod = net.lingala.zip4j.model.enums.CompressionMethod.DEFLATE;
        this.compressionLevel = net.lingala.zip4j.model.enums.CompressionLevel.NORMAL;
        this.encryptFiles = false;
        this.encryptionMethod = net.lingala.zip4j.model.enums.EncryptionMethod.NONE;
        this.readHiddenFiles = true;
        this.readHiddenFolders = true;
        this.aesKeyStrength = net.lingala.zip4j.model.enums.AesKeyStrength.KEY_STRENGTH_256;
        this.aesVersion = net.lingala.zip4j.model.enums.AesVersion.TWO;
        this.includeRootFolder = true;
        this.lastModifiedFileTime = 0L;
        this.entrySize = -1L;
        this.writeExtendedLocalFileHeader = true;
        this.overrideExistingFilesInZip = true;
        this.symbolicLinkAction = net.lingala.zip4j.model.ZipParameters.SymbolicLinkAction.INCLUDE_LINKED_FILE_ONLY;
    }

    public ZipParameters(net.lingala.zip4j.model.ZipParameters zipParameters) {
        this.compressionMethod = net.lingala.zip4j.model.enums.CompressionMethod.DEFLATE;
        this.compressionLevel = net.lingala.zip4j.model.enums.CompressionLevel.NORMAL;
        this.encryptFiles = false;
        this.encryptionMethod = net.lingala.zip4j.model.enums.EncryptionMethod.NONE;
        this.readHiddenFiles = true;
        this.readHiddenFolders = true;
        this.aesKeyStrength = net.lingala.zip4j.model.enums.AesKeyStrength.KEY_STRENGTH_256;
        this.aesVersion = net.lingala.zip4j.model.enums.AesVersion.TWO;
        this.includeRootFolder = true;
        this.lastModifiedFileTime = 0L;
        this.entrySize = -1L;
        this.writeExtendedLocalFileHeader = true;
        this.overrideExistingFilesInZip = true;
        this.symbolicLinkAction = net.lingala.zip4j.model.ZipParameters.SymbolicLinkAction.INCLUDE_LINKED_FILE_ONLY;
        this.compressionMethod = zipParameters.getCompressionMethod();
        this.compressionLevel = zipParameters.getCompressionLevel();
        this.encryptFiles = zipParameters.isEncryptFiles();
        this.encryptionMethod = zipParameters.getEncryptionMethod();
        this.readHiddenFiles = zipParameters.isReadHiddenFiles();
        this.readHiddenFolders = zipParameters.isReadHiddenFolders();
        this.aesKeyStrength = zipParameters.getAesKeyStrength();
        this.aesVersion = zipParameters.getAesVersion();
        this.includeRootFolder = zipParameters.isIncludeRootFolder();
        this.entryCRC = zipParameters.getEntryCRC();
        this.defaultFolderPath = zipParameters.getDefaultFolderPath();
        this.fileNameInZip = zipParameters.getFileNameInZip();
        this.lastModifiedFileTime = zipParameters.getLastModifiedFileTime();
        this.entrySize = zipParameters.getEntrySize();
        this.writeExtendedLocalFileHeader = zipParameters.isWriteExtendedLocalFileHeader();
        this.overrideExistingFilesInZip = zipParameters.isOverrideExistingFilesInZip();
        this.rootFolderNameInZip = zipParameters.getRootFolderNameInZip();
        this.fileComment = zipParameters.getFileComment();
        this.symbolicLinkAction = zipParameters.getSymbolicLinkAction();
        this.excludeFileFilter = zipParameters.getExcludeFileFilter();
        this.unixMode = zipParameters.isUnixMode();
    }

    public net.lingala.zip4j.model.enums.CompressionMethod getCompressionMethod() {
        return this.compressionMethod;
    }

    public void setCompressionMethod(net.lingala.zip4j.model.enums.CompressionMethod compressionMethod) {
        this.compressionMethod = compressionMethod;
    }

    public boolean isEncryptFiles() {
        return this.encryptFiles;
    }

    public void setEncryptFiles(boolean z) {
        this.encryptFiles = z;
    }

    public net.lingala.zip4j.model.enums.EncryptionMethod getEncryptionMethod() {
        return this.encryptionMethod;
    }

    public void setEncryptionMethod(net.lingala.zip4j.model.enums.EncryptionMethod encryptionMethod) {
        this.encryptionMethod = encryptionMethod;
    }

    public net.lingala.zip4j.model.enums.CompressionLevel getCompressionLevel() {
        return this.compressionLevel;
    }

    public void setCompressionLevel(net.lingala.zip4j.model.enums.CompressionLevel compressionLevel) {
        this.compressionLevel = compressionLevel;
    }

    public boolean isReadHiddenFiles() {
        return this.readHiddenFiles;
    }

    public void setReadHiddenFiles(boolean z) {
        this.readHiddenFiles = z;
    }

    public boolean isReadHiddenFolders() {
        return this.readHiddenFolders;
    }

    public void setReadHiddenFolders(boolean z) {
        this.readHiddenFolders = z;
    }

    public net.lingala.zip4j.model.enums.AesKeyStrength getAesKeyStrength() {
        return this.aesKeyStrength;
    }

    public void setAesKeyStrength(net.lingala.zip4j.model.enums.AesKeyStrength aesKeyStrength) {
        this.aesKeyStrength = aesKeyStrength;
    }

    public net.lingala.zip4j.model.enums.AesVersion getAesVersion() {
        return this.aesVersion;
    }

    public void setAesVersion(net.lingala.zip4j.model.enums.AesVersion aesVersion) {
        this.aesVersion = aesVersion;
    }

    public boolean isIncludeRootFolder() {
        return this.includeRootFolder;
    }

    public void setIncludeRootFolder(boolean z) {
        this.includeRootFolder = z;
    }

    public long getEntryCRC() {
        return this.entryCRC;
    }

    public void setEntryCRC(long j) {
        this.entryCRC = j;
    }

    public java.lang.String getDefaultFolderPath() {
        return this.defaultFolderPath;
    }

    public void setDefaultFolderPath(java.lang.String str) {
        this.defaultFolderPath = str;
    }

    public java.lang.String getFileNameInZip() {
        return this.fileNameInZip;
    }

    public void setFileNameInZip(java.lang.String str) {
        this.fileNameInZip = str;
    }

    public long getLastModifiedFileTime() {
        return this.lastModifiedFileTime;
    }

    public void setLastModifiedFileTime(long j) {
        if (j < 0) {
            this.lastModifiedFileTime = 0L;
        } else {
            this.lastModifiedFileTime = j;
        }
    }

    public long getEntrySize() {
        return this.entrySize;
    }

    public void setEntrySize(long j) {
        this.entrySize = j;
    }

    public boolean isWriteExtendedLocalFileHeader() {
        return this.writeExtendedLocalFileHeader;
    }

    public void setWriteExtendedLocalFileHeader(boolean z) {
        this.writeExtendedLocalFileHeader = z;
    }

    public boolean isOverrideExistingFilesInZip() {
        return this.overrideExistingFilesInZip;
    }

    public void setOverrideExistingFilesInZip(boolean z) {
        this.overrideExistingFilesInZip = z;
    }

    public java.lang.String getRootFolderNameInZip() {
        return this.rootFolderNameInZip;
    }

    public void setRootFolderNameInZip(java.lang.String str) {
        this.rootFolderNameInZip = str;
    }

    public java.lang.String getFileComment() {
        return this.fileComment;
    }

    public void setFileComment(java.lang.String str) {
        this.fileComment = str;
    }

    public net.lingala.zip4j.model.ZipParameters.SymbolicLinkAction getSymbolicLinkAction() {
        return this.symbolicLinkAction;
    }

    public void setSymbolicLinkAction(net.lingala.zip4j.model.ZipParameters.SymbolicLinkAction symbolicLinkAction) {
        this.symbolicLinkAction = symbolicLinkAction;
    }

    public net.lingala.zip4j.model.ExcludeFileFilter getExcludeFileFilter() {
        return this.excludeFileFilter;
    }

    public void setExcludeFileFilter(net.lingala.zip4j.model.ExcludeFileFilter excludeFileFilter) {
        this.excludeFileFilter = excludeFileFilter;
    }

    public boolean isUnixMode() {
        return this.unixMode;
    }

    public void setUnixMode(boolean z) {
        this.unixMode = z;
    }
}
