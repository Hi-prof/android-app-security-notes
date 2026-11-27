package net.lingala.zip4j.io.inputstream;

/* JADX INFO: loaded from: classes2.dex */
public class ZipInputStream extends java.io.InputStream {
    private boolean canSkipExtendedLocalFileHeader;
    private java.util.zip.CRC32 crc32;
    private net.lingala.zip4j.io.inputstream.DecompressedInputStream decompressedInputStream;
    private byte[] endOfEntryBuffer;
    private boolean entryEOFReached;
    private net.lingala.zip4j.headers.HeaderReader headerReader;
    private java.io.PushbackInputStream inputStream;
    private net.lingala.zip4j.model.LocalFileHeader localFileHeader;
    private char[] password;
    private net.lingala.zip4j.util.PasswordCallback passwordCallback;
    private boolean streamClosed;
    private net.lingala.zip4j.model.Zip4jConfig zip4jConfig;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZipInputStream(java.io.InputStream inputStream) {
        this(inputStream, (char[]) null, (java.nio.charset.Charset) null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZipInputStream(java.io.InputStream inputStream, java.nio.charset.Charset charset) {
        this(inputStream, (char[]) null, charset);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZipInputStream(java.io.InputStream inputStream, char[] cArr) {
        this(inputStream, cArr, (java.nio.charset.Charset) null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZipInputStream(java.io.InputStream inputStream, net.lingala.zip4j.util.PasswordCallback passwordCallback) {
        this(inputStream, passwordCallback, (java.nio.charset.Charset) null);
    }

    public ZipInputStream(java.io.InputStream inputStream, char[] cArr, java.nio.charset.Charset charset) {
        this(inputStream, cArr, new net.lingala.zip4j.model.Zip4jConfig(charset, 4096, true));
    }

    public ZipInputStream(java.io.InputStream inputStream, net.lingala.zip4j.util.PasswordCallback passwordCallback, java.nio.charset.Charset charset) {
        this(inputStream, passwordCallback, new net.lingala.zip4j.model.Zip4jConfig(charset, 4096, true));
    }

    public ZipInputStream(java.io.InputStream inputStream, char[] cArr, net.lingala.zip4j.model.Zip4jConfig zip4jConfig) {
        this(inputStream, cArr, null, zip4jConfig);
    }

    public ZipInputStream(java.io.InputStream inputStream, net.lingala.zip4j.util.PasswordCallback passwordCallback, net.lingala.zip4j.model.Zip4jConfig zip4jConfig) {
        this(inputStream, null, passwordCallback, zip4jConfig);
    }

    private ZipInputStream(java.io.InputStream inputStream, char[] cArr, net.lingala.zip4j.util.PasswordCallback passwordCallback, net.lingala.zip4j.model.Zip4jConfig zip4jConfig) {
        this.headerReader = new net.lingala.zip4j.headers.HeaderReader();
        this.crc32 = new java.util.zip.CRC32();
        this.canSkipExtendedLocalFileHeader = false;
        this.streamClosed = false;
        this.entryEOFReached = false;
        if (zip4jConfig.getBufferSize() < 512) {
            throw new java.lang.IllegalArgumentException("Buffer size cannot be less than 512 bytes");
        }
        this.inputStream = new java.io.PushbackInputStream(inputStream, zip4jConfig.getBufferSize());
        this.password = cArr;
        this.passwordCallback = passwordCallback;
        this.zip4jConfig = zip4jConfig;
    }

    public net.lingala.zip4j.model.LocalFileHeader getNextEntry() throws java.io.IOException {
        return getNextEntry(null, true);
    }

    public net.lingala.zip4j.model.LocalFileHeader getNextEntry(net.lingala.zip4j.model.FileHeader fileHeader, boolean z) throws java.io.IOException {
        net.lingala.zip4j.util.PasswordCallback passwordCallback;
        if (this.localFileHeader != null && z) {
            readUntilEndOfEntry();
        }
        net.lingala.zip4j.model.LocalFileHeader localFileHeader = this.headerReader.readLocalFileHeader(this.inputStream, this.zip4jConfig.getCharset());
        this.localFileHeader = localFileHeader;
        if (localFileHeader == null) {
            return null;
        }
        if (localFileHeader.isEncrypted() && this.password == null && (passwordCallback = this.passwordCallback) != null) {
            setPassword(passwordCallback.getPassword());
        }
        verifyLocalFileHeader(this.localFileHeader);
        this.crc32.reset();
        if (fileHeader != null) {
            this.localFileHeader.setCrc(fileHeader.getCrc());
            this.localFileHeader.setCompressedSize(fileHeader.getCompressedSize());
            this.localFileHeader.setUncompressedSize(fileHeader.getUncompressedSize());
            this.localFileHeader.setDirectory(fileHeader.isDirectory());
            this.canSkipExtendedLocalFileHeader = true;
        } else {
            this.canSkipExtendedLocalFileHeader = false;
        }
        this.decompressedInputStream = initializeEntryInputStream(this.localFileHeader);
        this.entryEOFReached = false;
        return this.localFileHeader;
    }

    @Override // java.io.InputStream
    public int read() throws java.io.IOException {
        byte[] bArr = new byte[1];
        if (read(bArr) == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws java.io.IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        if (this.streamClosed) {
            throw new java.io.IOException("Stream closed");
        }
        if (i2 < 0) {
            throw new java.lang.IllegalArgumentException("Negative read length");
        }
        if (i2 == 0) {
            return 0;
        }
        if (this.localFileHeader == null) {
            return -1;
        }
        try {
            int i3 = this.decompressedInputStream.read(bArr, i, i2);
            if (i3 == -1) {
                endOfCompressedDataReached();
                return i3;
            }
            this.crc32.update(bArr, i, i3);
            return i3;
        } catch (java.io.IOException e) {
            if (isEncryptionMethodZipStandard(this.localFileHeader)) {
                throw new net.lingala.zip4j.exception.ZipException(e.getMessage(), e.getCause(), net.lingala.zip4j.exception.ZipException.Type.WRONG_PASSWORD);
            }
            throw e;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        if (this.streamClosed) {
            return;
        }
        net.lingala.zip4j.io.inputstream.DecompressedInputStream decompressedInputStream = this.decompressedInputStream;
        if (decompressedInputStream != null) {
            decompressedInputStream.close();
        }
        this.streamClosed = true;
    }

    @Override // java.io.InputStream
    public int available() throws java.io.IOException {
        assertStreamOpen();
        return !this.entryEOFReached ? 1 : 0;
    }

    public void setPassword(char[] cArr) {
        this.password = cArr;
    }

    private void endOfCompressedDataReached() throws java.io.IOException {
        this.decompressedInputStream.endOfEntryReached(this.inputStream, this.decompressedInputStream.pushBackInputStreamIfNecessary(this.inputStream));
        readExtendedLocalFileHeaderIfPresent();
        verifyCrc();
        resetFields();
        this.entryEOFReached = true;
    }

    private net.lingala.zip4j.io.inputstream.DecompressedInputStream initializeEntryInputStream(net.lingala.zip4j.model.LocalFileHeader localFileHeader) throws java.io.IOException {
        return initializeDecompressorForThisEntry(initializeCipherInputStream(new net.lingala.zip4j.io.inputstream.ZipEntryInputStream(this.inputStream, getCompressedSize(localFileHeader)), localFileHeader), localFileHeader);
    }

    private net.lingala.zip4j.io.inputstream.CipherInputStream<?> initializeCipherInputStream(net.lingala.zip4j.io.inputstream.ZipEntryInputStream zipEntryInputStream, net.lingala.zip4j.model.LocalFileHeader localFileHeader) throws java.io.IOException {
        if (!localFileHeader.isEncrypted()) {
            return new net.lingala.zip4j.io.inputstream.NoCipherInputStream(zipEntryInputStream, localFileHeader, this.password, this.zip4jConfig.getBufferSize());
        }
        if (localFileHeader.getEncryptionMethod() == net.lingala.zip4j.model.enums.EncryptionMethod.AES) {
            return new net.lingala.zip4j.io.inputstream.AesCipherInputStream(zipEntryInputStream, localFileHeader, this.password, this.zip4jConfig.getBufferSize(), this.zip4jConfig.isUseUtf8CharsetForPasswords());
        }
        if (localFileHeader.getEncryptionMethod() == net.lingala.zip4j.model.enums.EncryptionMethod.ZIP_STANDARD) {
            return new net.lingala.zip4j.io.inputstream.ZipStandardCipherInputStream(zipEntryInputStream, localFileHeader, this.password, this.zip4jConfig.getBufferSize(), this.zip4jConfig.isUseUtf8CharsetForPasswords());
        }
        throw new net.lingala.zip4j.exception.ZipException(java.lang.String.format("Entry [%s] Strong Encryption not supported", localFileHeader.getFileName()), net.lingala.zip4j.exception.ZipException.Type.UNSUPPORTED_ENCRYPTION);
    }

    private net.lingala.zip4j.io.inputstream.DecompressedInputStream initializeDecompressorForThisEntry(net.lingala.zip4j.io.inputstream.CipherInputStream<?> cipherInputStream, net.lingala.zip4j.model.LocalFileHeader localFileHeader) throws net.lingala.zip4j.exception.ZipException {
        if (net.lingala.zip4j.util.Zip4jUtil.getCompressionMethod(localFileHeader) == net.lingala.zip4j.model.enums.CompressionMethod.DEFLATE) {
            return new net.lingala.zip4j.io.inputstream.InflaterInputStream(cipherInputStream, this.zip4jConfig.getBufferSize());
        }
        return new net.lingala.zip4j.io.inputstream.StoreInputStream(cipherInputStream);
    }

    private void readExtendedLocalFileHeaderIfPresent() throws java.io.IOException {
        if (!this.localFileHeader.isDataDescriptorExists() || this.canSkipExtendedLocalFileHeader) {
            return;
        }
        net.lingala.zip4j.model.DataDescriptor dataDescriptor = this.headerReader.readDataDescriptor(this.inputStream, checkIfZip64ExtraDataRecordPresentInLFH(this.localFileHeader.getExtraDataRecords()));
        this.localFileHeader.setCompressedSize(dataDescriptor.getCompressedSize());
        this.localFileHeader.setUncompressedSize(dataDescriptor.getUncompressedSize());
        this.localFileHeader.setCrc(dataDescriptor.getCrc());
    }

    private void verifyLocalFileHeader(net.lingala.zip4j.model.LocalFileHeader localFileHeader) throws java.io.IOException {
        if (isEntryDirectory(localFileHeader.getFileName()) || localFileHeader.getCompressionMethod() != net.lingala.zip4j.model.enums.CompressionMethod.STORE || localFileHeader.getUncompressedSize() >= 0) {
            return;
        }
        throw new java.io.IOException("Invalid local file header for: " + localFileHeader.getFileName() + ". Uncompressed size has to be set for entry of compression type store which is not a directory");
    }

    private boolean checkIfZip64ExtraDataRecordPresentInLFH(java.util.List<net.lingala.zip4j.model.ExtraDataRecord> list) {
        if (list == null) {
            return false;
        }
        java.util.Iterator<net.lingala.zip4j.model.ExtraDataRecord> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().getHeader() == net.lingala.zip4j.headers.HeaderSignature.ZIP64_EXTRA_FIELD_SIGNATURE.getValue()) {
                return true;
            }
        }
        return false;
    }

    private void verifyCrc() throws java.io.IOException {
        if ((this.localFileHeader.getEncryptionMethod() == net.lingala.zip4j.model.enums.EncryptionMethod.AES && this.localFileHeader.getAesExtraDataRecord().getAesVersion().equals(net.lingala.zip4j.model.enums.AesVersion.TWO)) || this.localFileHeader.getCrc() == this.crc32.getValue()) {
            return;
        }
        net.lingala.zip4j.exception.ZipException.Type type = net.lingala.zip4j.exception.ZipException.Type.CHECKSUM_MISMATCH;
        if (isEncryptionMethodZipStandard(this.localFileHeader)) {
            type = net.lingala.zip4j.exception.ZipException.Type.WRONG_PASSWORD;
        }
        throw new net.lingala.zip4j.exception.ZipException("Reached end of entry, but crc verification failed for " + this.localFileHeader.getFileName(), type);
    }

    private void resetFields() {
        this.localFileHeader = null;
        this.crc32.reset();
    }

    private boolean isEntryDirectory(java.lang.String str) {
        return str.endsWith("/") || str.endsWith("\\");
    }

    private long getCompressedSize(net.lingala.zip4j.model.LocalFileHeader localFileHeader) throws net.lingala.zip4j.exception.ZipException {
        if (net.lingala.zip4j.util.Zip4jUtil.getCompressionMethod(localFileHeader).equals(net.lingala.zip4j.model.enums.CompressionMethod.STORE)) {
            return localFileHeader.getUncompressedSize();
        }
        if (!localFileHeader.isDataDescriptorExists() || this.canSkipExtendedLocalFileHeader) {
            return localFileHeader.getCompressedSize() - ((long) getEncryptionHeaderSize(localFileHeader));
        }
        return -1L;
    }

    private int getEncryptionHeaderSize(net.lingala.zip4j.model.LocalFileHeader localFileHeader) throws net.lingala.zip4j.exception.ZipException {
        if (!localFileHeader.isEncrypted()) {
            return 0;
        }
        if (localFileHeader.getEncryptionMethod().equals(net.lingala.zip4j.model.enums.EncryptionMethod.AES)) {
            return getAesEncryptionHeaderSize(localFileHeader.getAesExtraDataRecord());
        }
        return localFileHeader.getEncryptionMethod().equals(net.lingala.zip4j.model.enums.EncryptionMethod.ZIP_STANDARD) ? 12 : 0;
    }

    private void readUntilEndOfEntry() throws java.io.IOException {
        if (this.endOfEntryBuffer == null) {
            this.endOfEntryBuffer = new byte[512];
        }
        while (read(this.endOfEntryBuffer) != -1) {
        }
        this.entryEOFReached = true;
    }

    private int getAesEncryptionHeaderSize(net.lingala.zip4j.model.AESExtraDataRecord aESExtraDataRecord) throws net.lingala.zip4j.exception.ZipException {
        if (aESExtraDataRecord == null || aESExtraDataRecord.getAesKeyStrength() == null) {
            throw new net.lingala.zip4j.exception.ZipException("AesExtraDataRecord not found or invalid for Aes encrypted entry");
        }
        return aESExtraDataRecord.getAesKeyStrength().getSaltLength() + 12;
    }

    private boolean isEncryptionMethodZipStandard(net.lingala.zip4j.model.LocalFileHeader localFileHeader) {
        return localFileHeader.isEncrypted() && net.lingala.zip4j.model.enums.EncryptionMethod.ZIP_STANDARD.equals(localFileHeader.getEncryptionMethod());
    }

    private void assertStreamOpen() throws java.io.IOException {
        if (this.streamClosed) {
            throw new java.io.IOException("Stream closed");
        }
    }
}
