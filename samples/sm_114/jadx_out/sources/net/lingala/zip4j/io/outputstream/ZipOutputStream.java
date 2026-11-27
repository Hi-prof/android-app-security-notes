package net.lingala.zip4j.io.outputstream;

/* JADX INFO: loaded from: classes2.dex */
public class ZipOutputStream extends java.io.OutputStream {
    private net.lingala.zip4j.io.outputstream.CompressedOutputStream compressedOutputStream;
    private net.lingala.zip4j.io.outputstream.CountingOutputStream countingOutputStream;
    private java.util.zip.CRC32 crc32;
    private boolean entryClosed;
    private net.lingala.zip4j.model.FileHeader fileHeader;
    private net.lingala.zip4j.headers.FileHeaderFactory fileHeaderFactory;
    private net.lingala.zip4j.headers.HeaderWriter headerWriter;
    private net.lingala.zip4j.model.LocalFileHeader localFileHeader;
    private char[] password;
    private net.lingala.zip4j.util.RawIO rawIO;
    private boolean streamClosed;
    private long uncompressedSizeForThisEntry;
    private net.lingala.zip4j.model.Zip4jConfig zip4jConfig;
    private net.lingala.zip4j.model.ZipModel zipModel;

    public ZipOutputStream(java.io.OutputStream outputStream) throws java.io.IOException {
        this(outputStream, null, null);
    }

    public ZipOutputStream(java.io.OutputStream outputStream, java.nio.charset.Charset charset) throws java.io.IOException {
        this(outputStream, null, charset);
    }

    public ZipOutputStream(java.io.OutputStream outputStream, char[] cArr) throws java.io.IOException {
        this(outputStream, cArr, null);
    }

    public ZipOutputStream(java.io.OutputStream outputStream, char[] cArr, java.nio.charset.Charset charset) throws java.io.IOException {
        this(outputStream, cArr, new net.lingala.zip4j.model.Zip4jConfig(charset, 4096, true), new net.lingala.zip4j.model.ZipModel());
    }

    public ZipOutputStream(java.io.OutputStream outputStream, char[] cArr, net.lingala.zip4j.model.Zip4jConfig zip4jConfig, net.lingala.zip4j.model.ZipModel zipModel) throws java.io.IOException {
        this.fileHeaderFactory = new net.lingala.zip4j.headers.FileHeaderFactory();
        this.headerWriter = new net.lingala.zip4j.headers.HeaderWriter();
        this.crc32 = new java.util.zip.CRC32();
        this.rawIO = new net.lingala.zip4j.util.RawIO();
        this.uncompressedSizeForThisEntry = 0L;
        this.entryClosed = true;
        if (zip4jConfig.getBufferSize() < 512) {
            throw new java.lang.IllegalArgumentException("Buffer size cannot be less than 512 bytes");
        }
        net.lingala.zip4j.io.outputstream.CountingOutputStream countingOutputStream = new net.lingala.zip4j.io.outputstream.CountingOutputStream(outputStream);
        this.countingOutputStream = countingOutputStream;
        this.password = cArr;
        this.zip4jConfig = zip4jConfig;
        this.zipModel = initializeZipModel(zipModel, countingOutputStream);
        this.streamClosed = false;
        writeSplitZipHeaderIfApplicable();
    }

    public void putNextEntry(net.lingala.zip4j.model.ZipParameters zipParameters) throws java.io.IOException {
        verifyZipParameters(zipParameters);
        net.lingala.zip4j.model.ZipParameters zipParametersCloneAndPrepareZipParameters = cloneAndPrepareZipParameters(zipParameters);
        initializeAndWriteFileHeader(zipParametersCloneAndPrepareZipParameters);
        this.compressedOutputStream = initializeCompressedOutputStream(zipParametersCloneAndPrepareZipParameters);
        this.entryClosed = false;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws java.io.IOException {
        write(new byte[]{(byte) i});
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws java.io.IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
        ensureStreamOpen();
        this.crc32.update(bArr, i, i2);
        this.compressedOutputStream.write(bArr, i, i2);
        this.uncompressedSizeForThisEntry += (long) i2;
    }

    public net.lingala.zip4j.model.FileHeader closeEntry() throws java.io.IOException {
        this.compressedOutputStream.closeEntry();
        long compressedSize = this.compressedOutputStream.getCompressedSize();
        this.fileHeader.setCompressedSize(compressedSize);
        this.localFileHeader.setCompressedSize(compressedSize);
        this.fileHeader.setUncompressedSize(this.uncompressedSizeForThisEntry);
        this.localFileHeader.setUncompressedSize(this.uncompressedSizeForThisEntry);
        if (writeCrc(this.fileHeader)) {
            this.fileHeader.setCrc(this.crc32.getValue());
            this.localFileHeader.setCrc(this.crc32.getValue());
        }
        this.zipModel.getLocalFileHeaders().add(this.localFileHeader);
        this.zipModel.getCentralDirectory().getFileHeaders().add(this.fileHeader);
        if (this.localFileHeader.isDataDescriptorExists()) {
            this.headerWriter.writeExtendedLocalHeader(this.localFileHeader, this.countingOutputStream);
        }
        reset();
        this.entryClosed = true;
        return this.fileHeader;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.lang.Throwable {
        if (!this.entryClosed) {
            closeEntry();
        }
        this.zipModel.getEndOfCentralDirectoryRecord().setOffsetOfStartOfCentralDirectory(this.countingOutputStream.getNumberOfBytesWritten());
        this.headerWriter.finalizeZipFile(this.zipModel, this.countingOutputStream, this.zip4jConfig.getCharset());
        this.countingOutputStream.close();
        this.streamClosed = true;
    }

    public void setComment(java.lang.String str) throws java.io.IOException {
        ensureStreamOpen();
        this.zipModel.getEndOfCentralDirectoryRecord().setComment(str);
    }

    private void ensureStreamOpen() throws java.io.IOException {
        if (this.streamClosed) {
            throw new java.io.IOException("Stream is closed");
        }
    }

    private net.lingala.zip4j.model.ZipModel initializeZipModel(net.lingala.zip4j.model.ZipModel zipModel, net.lingala.zip4j.io.outputstream.CountingOutputStream countingOutputStream) {
        if (zipModel == null) {
            zipModel = new net.lingala.zip4j.model.ZipModel();
        }
        if (countingOutputStream.isSplitZipFile()) {
            zipModel.setSplitArchive(true);
            zipModel.setSplitLength(countingOutputStream.getSplitLength());
        }
        return zipModel;
    }

    private void initializeAndWriteFileHeader(net.lingala.zip4j.model.ZipParameters zipParameters) throws java.io.IOException {
        net.lingala.zip4j.model.FileHeader fileHeaderGenerateFileHeader = this.fileHeaderFactory.generateFileHeader(zipParameters, this.countingOutputStream.isSplitZipFile(), this.countingOutputStream.getCurrentSplitFileCounter(), this.zip4jConfig.getCharset(), this.rawIO);
        this.fileHeader = fileHeaderGenerateFileHeader;
        fileHeaderGenerateFileHeader.setOffsetLocalHeader(this.countingOutputStream.getOffsetForNextEntry());
        net.lingala.zip4j.model.LocalFileHeader localFileHeaderGenerateLocalFileHeader = this.fileHeaderFactory.generateLocalFileHeader(this.fileHeader);
        this.localFileHeader = localFileHeaderGenerateLocalFileHeader;
        this.headerWriter.writeLocalFileHeader(this.zipModel, localFileHeaderGenerateLocalFileHeader, this.countingOutputStream, this.zip4jConfig.getCharset());
    }

    private void reset() throws java.io.IOException {
        this.uncompressedSizeForThisEntry = 0L;
        this.crc32.reset();
        this.compressedOutputStream.close();
    }

    private void writeSplitZipHeaderIfApplicable() throws java.io.IOException {
        if (this.countingOutputStream.isSplitZipFile()) {
            this.rawIO.writeIntLittleEndian(this.countingOutputStream, (int) net.lingala.zip4j.headers.HeaderSignature.SPLIT_ZIP.getValue());
        }
    }

    private net.lingala.zip4j.io.outputstream.CompressedOutputStream initializeCompressedOutputStream(net.lingala.zip4j.model.ZipParameters zipParameters) throws java.io.IOException {
        return initializeCompressedOutputStream(initializeCipherOutputStream(new net.lingala.zip4j.io.outputstream.ZipEntryOutputStream(this.countingOutputStream), zipParameters), zipParameters);
    }

    private net.lingala.zip4j.io.outputstream.CipherOutputStream<?> initializeCipherOutputStream(net.lingala.zip4j.io.outputstream.ZipEntryOutputStream zipEntryOutputStream, net.lingala.zip4j.model.ZipParameters zipParameters) throws java.io.IOException {
        if (!zipParameters.isEncryptFiles()) {
            return new net.lingala.zip4j.io.outputstream.NoCipherOutputStream(zipEntryOutputStream, zipParameters, null);
        }
        char[] cArr = this.password;
        if (cArr == null || cArr.length == 0) {
            throw new net.lingala.zip4j.exception.ZipException("password not set");
        }
        if (zipParameters.getEncryptionMethod() == net.lingala.zip4j.model.enums.EncryptionMethod.AES) {
            return new net.lingala.zip4j.io.outputstream.AesCipherOutputStream(zipEntryOutputStream, zipParameters, this.password, this.zip4jConfig.isUseUtf8CharsetForPasswords());
        }
        if (zipParameters.getEncryptionMethod() == net.lingala.zip4j.model.enums.EncryptionMethod.ZIP_STANDARD) {
            return new net.lingala.zip4j.io.outputstream.ZipStandardCipherOutputStream(zipEntryOutputStream, zipParameters, this.password, this.zip4jConfig.isUseUtf8CharsetForPasswords());
        }
        if (zipParameters.getEncryptionMethod() == net.lingala.zip4j.model.enums.EncryptionMethod.ZIP_STANDARD_VARIANT_STRONG) {
            throw new net.lingala.zip4j.exception.ZipException(net.lingala.zip4j.model.enums.EncryptionMethod.ZIP_STANDARD_VARIANT_STRONG + " encryption method is not supported");
        }
        throw new net.lingala.zip4j.exception.ZipException("Invalid encryption method");
    }

    private net.lingala.zip4j.io.outputstream.CompressedOutputStream initializeCompressedOutputStream(net.lingala.zip4j.io.outputstream.CipherOutputStream<?> cipherOutputStream, net.lingala.zip4j.model.ZipParameters zipParameters) {
        if (zipParameters.getCompressionMethod() == net.lingala.zip4j.model.enums.CompressionMethod.DEFLATE) {
            return new net.lingala.zip4j.io.outputstream.DeflaterOutputStream(cipherOutputStream, zipParameters.getCompressionLevel(), this.zip4jConfig.getBufferSize());
        }
        return new net.lingala.zip4j.io.outputstream.StoreOutputStream(cipherOutputStream);
    }

    private void verifyZipParameters(net.lingala.zip4j.model.ZipParameters zipParameters) {
        if (net.lingala.zip4j.util.Zip4jUtil.isStringNullOrEmpty(zipParameters.getFileNameInZip())) {
            throw new java.lang.IllegalArgumentException("fileNameInZip is null or empty");
        }
        if (zipParameters.getCompressionMethod() == net.lingala.zip4j.model.enums.CompressionMethod.STORE && zipParameters.getEntrySize() < 0 && !net.lingala.zip4j.util.FileUtils.isZipEntryDirectory(zipParameters.getFileNameInZip()) && zipParameters.isWriteExtendedLocalFileHeader()) {
            throw new java.lang.IllegalArgumentException("uncompressed size should be set for zip entries of compression type store");
        }
    }

    private boolean writeCrc(net.lingala.zip4j.model.FileHeader fileHeader) {
        if (fileHeader.isEncrypted() && fileHeader.getEncryptionMethod().equals(net.lingala.zip4j.model.enums.EncryptionMethod.AES)) {
            return fileHeader.getAesExtraDataRecord().getAesVersion().equals(net.lingala.zip4j.model.enums.AesVersion.ONE);
        }
        return true;
    }

    private net.lingala.zip4j.model.ZipParameters cloneAndPrepareZipParameters(net.lingala.zip4j.model.ZipParameters zipParameters) {
        net.lingala.zip4j.model.ZipParameters zipParameters2 = new net.lingala.zip4j.model.ZipParameters(zipParameters);
        if (net.lingala.zip4j.util.FileUtils.isZipEntryDirectory(zipParameters.getFileNameInZip())) {
            zipParameters2.setWriteExtendedLocalFileHeader(false);
            zipParameters2.setCompressionMethod(net.lingala.zip4j.model.enums.CompressionMethod.STORE);
            zipParameters2.setEncryptFiles(false);
            zipParameters2.setEntrySize(0L);
        }
        if (zipParameters.getLastModifiedFileTime() <= 0) {
            zipParameters2.setLastModifiedFileTime(java.lang.System.currentTimeMillis());
        }
        return zipParameters2;
    }
}
