package net.lingala.zip4j.headers;

/* JADX INFO: loaded from: classes2.dex */
public class HeaderWriter {
    private static final short AES_EXTRA_DATA_RECORD_SIZE = 11;
    private static final short ZIP64_EXTRA_DATA_RECORD_SIZE_FH = 28;
    private static final short ZIP64_EXTRA_DATA_RECORD_SIZE_LFH = 16;
    private final net.lingala.zip4j.util.RawIO rawIO = new net.lingala.zip4j.util.RawIO();
    private final byte[] longBuff = new byte[8];
    private final byte[] intBuff = new byte[4];

    public void writeLocalFileHeader(net.lingala.zip4j.model.ZipModel zipModel, net.lingala.zip4j.model.LocalFileHeader localFileHeader, java.io.OutputStream outputStream, java.nio.charset.Charset charset) throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            this.rawIO.writeIntLittleEndian(byteArrayOutputStream, (int) localFileHeader.getSignature().getValue());
            this.rawIO.writeShortLittleEndian(byteArrayOutputStream, localFileHeader.getVersionNeededToExtract());
            byteArrayOutputStream.write(localFileHeader.getGeneralPurposeFlag());
            this.rawIO.writeShortLittleEndian(byteArrayOutputStream, localFileHeader.getCompressionMethod().getCode());
            this.rawIO.writeLongLittleEndian(this.longBuff, 0, localFileHeader.getLastModifiedTime());
            byteArrayOutputStream.write(this.longBuff, 0, 4);
            this.rawIO.writeLongLittleEndian(this.longBuff, 0, localFileHeader.getCrc());
            byteArrayOutputStream.write(this.longBuff, 0, 4);
            boolean z = localFileHeader.getCompressedSize() >= net.lingala.zip4j.util.InternalZipConstants.ZIP_64_SIZE_LIMIT || localFileHeader.getUncompressedSize() >= net.lingala.zip4j.util.InternalZipConstants.ZIP_64_SIZE_LIMIT;
            if (z) {
                this.rawIO.writeLongLittleEndian(this.longBuff, 0, net.lingala.zip4j.util.InternalZipConstants.ZIP_64_SIZE_LIMIT);
                byteArrayOutputStream.write(this.longBuff, 0, 4);
                byteArrayOutputStream.write(this.longBuff, 0, 4);
                zipModel.setZip64Format(true);
                localFileHeader.setWriteCompressedSizeInZip64ExtraRecord(true);
            } else {
                this.rawIO.writeLongLittleEndian(this.longBuff, 0, localFileHeader.getCompressedSize());
                byteArrayOutputStream.write(this.longBuff, 0, 4);
                this.rawIO.writeLongLittleEndian(this.longBuff, 0, localFileHeader.getUncompressedSize());
                byteArrayOutputStream.write(this.longBuff, 0, 4);
                localFileHeader.setWriteCompressedSizeInZip64ExtraRecord(false);
            }
            byte[] bytesFromString = new byte[0];
            if (net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(localFileHeader.getFileName())) {
                bytesFromString = net.lingala.zip4j.headers.HeaderUtil.getBytesFromString(localFileHeader.getFileName(), charset);
            }
            this.rawIO.writeShortLittleEndian(byteArrayOutputStream, bytesFromString.length);
            int i = z ? 20 : 0;
            if (localFileHeader.getAesExtraDataRecord() != null) {
                i += 11;
            }
            this.rawIO.writeShortLittleEndian(byteArrayOutputStream, i);
            if (bytesFromString.length > 0) {
                byteArrayOutputStream.write(bytesFromString);
            }
            if (z) {
                this.rawIO.writeShortLittleEndian(byteArrayOutputStream, (int) net.lingala.zip4j.headers.HeaderSignature.ZIP64_EXTRA_FIELD_SIGNATURE.getValue());
                this.rawIO.writeShortLittleEndian(byteArrayOutputStream, 16);
                this.rawIO.writeLongLittleEndian(byteArrayOutputStream, localFileHeader.getUncompressedSize());
                this.rawIO.writeLongLittleEndian(byteArrayOutputStream, localFileHeader.getCompressedSize());
            }
            if (localFileHeader.getAesExtraDataRecord() != null) {
                net.lingala.zip4j.model.AESExtraDataRecord aesExtraDataRecord = localFileHeader.getAesExtraDataRecord();
                this.rawIO.writeShortLittleEndian(byteArrayOutputStream, (int) aesExtraDataRecord.getSignature().getValue());
                this.rawIO.writeShortLittleEndian(byteArrayOutputStream, aesExtraDataRecord.getDataSize());
                this.rawIO.writeShortLittleEndian(byteArrayOutputStream, aesExtraDataRecord.getAesVersion().getVersionNumber());
                byteArrayOutputStream.write(net.lingala.zip4j.headers.HeaderUtil.getBytesFromString(aesExtraDataRecord.getVendorID(), charset));
                byteArrayOutputStream.write(new byte[]{(byte) aesExtraDataRecord.getAesKeyStrength().getRawCode()});
                this.rawIO.writeShortLittleEndian(byteArrayOutputStream, aesExtraDataRecord.getCompressionMethod().getCode());
            }
            outputStream.write(byteArrayOutputStream.toByteArray());
            byteArrayOutputStream.close();
        } catch (java.lang.Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void writeExtendedLocalHeader(net.lingala.zip4j.model.LocalFileHeader localFileHeader, java.io.OutputStream outputStream) throws java.io.IOException {
        if (localFileHeader == null || outputStream == null) {
            throw new net.lingala.zip4j.exception.ZipException("input parameters is null, cannot write extended local header");
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            this.rawIO.writeIntLittleEndian(byteArrayOutputStream, (int) net.lingala.zip4j.headers.HeaderSignature.EXTRA_DATA_RECORD.getValue());
            this.rawIO.writeLongLittleEndian(this.longBuff, 0, localFileHeader.getCrc());
            byteArrayOutputStream.write(this.longBuff, 0, 4);
            if (localFileHeader.isWriteCompressedSizeInZip64ExtraRecord()) {
                this.rawIO.writeLongLittleEndian(byteArrayOutputStream, localFileHeader.getCompressedSize());
                this.rawIO.writeLongLittleEndian(byteArrayOutputStream, localFileHeader.getUncompressedSize());
            } else {
                this.rawIO.writeLongLittleEndian(this.longBuff, 0, localFileHeader.getCompressedSize());
                byteArrayOutputStream.write(this.longBuff, 0, 4);
                this.rawIO.writeLongLittleEndian(this.longBuff, 0, localFileHeader.getUncompressedSize());
                byteArrayOutputStream.write(this.longBuff, 0, 4);
            }
            outputStream.write(byteArrayOutputStream.toByteArray());
            byteArrayOutputStream.close();
        } catch (java.lang.Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x003f A[Catch: all -> 0x00b8, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x00b8, blocks: (B:5:0x0009, B:28:0x00a3, B:15:0x003f, B:18:0x004d, B:21:0x005b, B:27:0x008e, B:26:0x007f), top: B:47:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:17:0x0045 A[Catch: all -> 0x003a, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x003a, blocks: (B:9:0x0028, B:17:0x0045, B:20:0x0053, B:24:0x006b), top: B:49:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0053 A[Catch: all -> 0x003a, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x003a, blocks: (B:9:0x0028, B:17:0x0045, B:20:0x0053, B:24:0x006b), top: B:49:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x006b A[Catch: all -> 0x003a, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x003a, blocks: (B:9:0x0028, B:17:0x0045, B:20:0x0053, B:24:0x006b), top: B:49:0x0028 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x007f A[Catch: all -> 0x00b8, TRY_ENTER, TryCatch #1 {all -> 0x00b8, blocks: (B:5:0x0009, B:28:0x00a3, B:15:0x003f, B:18:0x004d, B:21:0x005b, B:27:0x008e, B:26:0x007f), top: B:47:0x0009 }] */
    public void finalizeZipFile(net.lingala.zip4j.model.ZipModel zipModel, java.io.OutputStream outputStream, java.nio.charset.Charset charset) throws java.lang.Throwable {
        java.lang.Throwable th;
        if (zipModel == null || outputStream == null) {
            throw new net.lingala.zip4j.exception.ZipException("input parameters is null, cannot finalize zip file");
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            processHeaderData(zipModel, outputStream);
            long offsetOfCentralDirectory = getOffsetOfCentralDirectory(zipModel);
            writeCentralDirectory(zipModel, byteArrayOutputStream, this.rawIO, charset);
            int size = byteArrayOutputStream.size();
            if (!zipModel.isZip64Format() && offsetOfCentralDirectory < net.lingala.zip4j.util.InternalZipConstants.ZIP_64_SIZE_LIMIT) {
                try {
                    if (zipModel.getCentralDirectory().getFileHeaders().size() >= 65535) {
                        if (zipModel.getZip64EndOfCentralDirectoryRecord() == null) {
                            zipModel.setZip64EndOfCentralDirectoryRecord(new net.lingala.zip4j.model.Zip64EndOfCentralDirectoryRecord());
                        }
                        if (zipModel.getZip64EndOfCentralDirectoryLocator() == null) {
                            zipModel.setZip64EndOfCentralDirectoryLocator(new net.lingala.zip4j.model.Zip64EndOfCentralDirectoryLocator());
                        }
                        zipModel.getZip64EndOfCentralDirectoryLocator().setOffsetZip64EndOfCentralDirectoryRecord(((long) size) + offsetOfCentralDirectory);
                        if (isSplitZipFile(outputStream)) {
                            int currentSplitFileCounter = getCurrentSplitFileCounter(outputStream);
                            zipModel.getZip64EndOfCentralDirectoryLocator().setNumberOfDiskStartOfZip64EndOfCentralDirectoryRecord(currentSplitFileCounter);
                            zipModel.getZip64EndOfCentralDirectoryLocator().setTotalNumberOfDiscs(currentSplitFileCounter + 1);
                        } else {
                            zipModel.getZip64EndOfCentralDirectoryLocator().setNumberOfDiskStartOfZip64EndOfCentralDirectoryRecord(0);
                            zipModel.getZip64EndOfCentralDirectoryLocator().setTotalNumberOfDiscs(1);
                        }
                        net.lingala.zip4j.model.Zip64EndOfCentralDirectoryRecord zip64EndOfCentralDirectoryRecordBuildZip64EndOfCentralDirectoryRecord = buildZip64EndOfCentralDirectoryRecord(zipModel, size, offsetOfCentralDirectory);
                        zipModel.setZip64EndOfCentralDirectoryRecord(zip64EndOfCentralDirectoryRecordBuildZip64EndOfCentralDirectoryRecord);
                        writeZip64EndOfCentralDirectoryRecord(zip64EndOfCentralDirectoryRecordBuildZip64EndOfCentralDirectoryRecord, byteArrayOutputStream, this.rawIO);
                        writeZip64EndOfCentralDirectoryLocator(zipModel.getZip64EndOfCentralDirectoryLocator(), byteArrayOutputStream, this.rawIO);
                    }
                    writeEndOfCentralDirectoryRecord(zipModel, size, offsetOfCentralDirectory, byteArrayOutputStream, this.rawIO, charset);
                    writeZipHeaderBytes(zipModel, outputStream, byteArrayOutputStream.toByteArray(), charset);
                    byteArrayOutputStream.close();
                    return;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            } else {
                if (zipModel.getZip64EndOfCentralDirectoryRecord() == null) {
                    zipModel.setZip64EndOfCentralDirectoryRecord(new net.lingala.zip4j.model.Zip64EndOfCentralDirectoryRecord());
                }
                if (zipModel.getZip64EndOfCentralDirectoryLocator() == null) {
                    zipModel.setZip64EndOfCentralDirectoryLocator(new net.lingala.zip4j.model.Zip64EndOfCentralDirectoryLocator());
                }
                zipModel.getZip64EndOfCentralDirectoryLocator().setOffsetZip64EndOfCentralDirectoryRecord(((long) size) + offsetOfCentralDirectory);
                if (isSplitZipFile(outputStream)) {
                    int currentSplitFileCounter2 = getCurrentSplitFileCounter(outputStream);
                    zipModel.getZip64EndOfCentralDirectoryLocator().setNumberOfDiskStartOfZip64EndOfCentralDirectoryRecord(currentSplitFileCounter2);
                    zipModel.getZip64EndOfCentralDirectoryLocator().setTotalNumberOfDiscs(currentSplitFileCounter2 + 1);
                } else {
                    zipModel.getZip64EndOfCentralDirectoryLocator().setNumberOfDiskStartOfZip64EndOfCentralDirectoryRecord(0);
                    zipModel.getZip64EndOfCentralDirectoryLocator().setTotalNumberOfDiscs(1);
                }
                net.lingala.zip4j.model.Zip64EndOfCentralDirectoryRecord zip64EndOfCentralDirectoryRecordBuildZip64EndOfCentralDirectoryRecord2 = buildZip64EndOfCentralDirectoryRecord(zipModel, size, offsetOfCentralDirectory);
                zipModel.setZip64EndOfCentralDirectoryRecord(zip64EndOfCentralDirectoryRecordBuildZip64EndOfCentralDirectoryRecord2);
                writeZip64EndOfCentralDirectoryRecord(zip64EndOfCentralDirectoryRecordBuildZip64EndOfCentralDirectoryRecord2, byteArrayOutputStream, this.rawIO);
                writeZip64EndOfCentralDirectoryLocator(zipModel.getZip64EndOfCentralDirectoryLocator(), byteArrayOutputStream, this.rawIO);
                try {
                    writeEndOfCentralDirectoryRecord(zipModel, size, offsetOfCentralDirectory, byteArrayOutputStream, this.rawIO, charset);
                    writeZipHeaderBytes(zipModel, outputStream, byteArrayOutputStream.toByteArray(), charset);
                    byteArrayOutputStream.close();
                    return;
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    th = th;
                    byteArrayOutputStream.close();
                    throw th;
                }
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
        }
        try {
            byteArrayOutputStream.close();
            throw th;
        } catch (java.lang.Throwable th5) {
            th.addSuppressed(th5);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x003b A[Catch: all -> 0x008a, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x008a, blocks: (B:5:0x0009, B:22:0x0075, B:15:0x003b, B:18:0x0049, B:21:0x0057), top: B:45:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:17:0x0041 A[Catch: all -> 0x0037, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0037, blocks: (B:9:0x0025, B:17:0x0041, B:20:0x004f), top: B:41:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x004f A[Catch: all -> 0x0037, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0037, blocks: (B:9:0x0025, B:17:0x0041, B:20:0x004f), top: B:41:0x0025 }] */
    public void finalizeZipFileWithoutValidations(net.lingala.zip4j.model.ZipModel zipModel, java.io.OutputStream outputStream, java.nio.charset.Charset charset) throws java.lang.Throwable {
        java.lang.Throwable th;
        if (zipModel == null || outputStream == null) {
            throw new net.lingala.zip4j.exception.ZipException("input parameters is null, cannot finalize zip file without validations");
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            long offsetOfCentralDirectory = getOffsetOfCentralDirectory(zipModel);
            writeCentralDirectory(zipModel, byteArrayOutputStream, this.rawIO, charset);
            int size = byteArrayOutputStream.size();
            if (!zipModel.isZip64Format() && offsetOfCentralDirectory < net.lingala.zip4j.util.InternalZipConstants.ZIP_64_SIZE_LIMIT) {
                try {
                    if (zipModel.getCentralDirectory().getFileHeaders().size() >= 65535) {
                        if (zipModel.getZip64EndOfCentralDirectoryRecord() == null) {
                            zipModel.setZip64EndOfCentralDirectoryRecord(new net.lingala.zip4j.model.Zip64EndOfCentralDirectoryRecord());
                        }
                        if (zipModel.getZip64EndOfCentralDirectoryLocator() == null) {
                            zipModel.setZip64EndOfCentralDirectoryLocator(new net.lingala.zip4j.model.Zip64EndOfCentralDirectoryLocator());
                        }
                        zipModel.getZip64EndOfCentralDirectoryLocator().setOffsetZip64EndOfCentralDirectoryRecord(((long) size) + offsetOfCentralDirectory);
                        net.lingala.zip4j.model.Zip64EndOfCentralDirectoryRecord zip64EndOfCentralDirectoryRecordBuildZip64EndOfCentralDirectoryRecord = buildZip64EndOfCentralDirectoryRecord(zipModel, size, offsetOfCentralDirectory);
                        zipModel.setZip64EndOfCentralDirectoryRecord(zip64EndOfCentralDirectoryRecordBuildZip64EndOfCentralDirectoryRecord);
                        writeZip64EndOfCentralDirectoryRecord(zip64EndOfCentralDirectoryRecordBuildZip64EndOfCentralDirectoryRecord, byteArrayOutputStream, this.rawIO);
                        writeZip64EndOfCentralDirectoryLocator(zipModel.getZip64EndOfCentralDirectoryLocator(), byteArrayOutputStream, this.rawIO);
                    }
                    writeEndOfCentralDirectoryRecord(zipModel, size, offsetOfCentralDirectory, byteArrayOutputStream, this.rawIO, charset);
                    writeZipHeaderBytes(zipModel, outputStream, byteArrayOutputStream.toByteArray(), charset);
                    byteArrayOutputStream.close();
                    return;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            } else {
                if (zipModel.getZip64EndOfCentralDirectoryRecord() == null) {
                    zipModel.setZip64EndOfCentralDirectoryRecord(new net.lingala.zip4j.model.Zip64EndOfCentralDirectoryRecord());
                }
                if (zipModel.getZip64EndOfCentralDirectoryLocator() == null) {
                    zipModel.setZip64EndOfCentralDirectoryLocator(new net.lingala.zip4j.model.Zip64EndOfCentralDirectoryLocator());
                }
                zipModel.getZip64EndOfCentralDirectoryLocator().setOffsetZip64EndOfCentralDirectoryRecord(((long) size) + offsetOfCentralDirectory);
                net.lingala.zip4j.model.Zip64EndOfCentralDirectoryRecord zip64EndOfCentralDirectoryRecordBuildZip64EndOfCentralDirectoryRecord2 = buildZip64EndOfCentralDirectoryRecord(zipModel, size, offsetOfCentralDirectory);
                zipModel.setZip64EndOfCentralDirectoryRecord(zip64EndOfCentralDirectoryRecordBuildZip64EndOfCentralDirectoryRecord2);
                writeZip64EndOfCentralDirectoryRecord(zip64EndOfCentralDirectoryRecordBuildZip64EndOfCentralDirectoryRecord2, byteArrayOutputStream, this.rawIO);
                writeZip64EndOfCentralDirectoryLocator(zipModel.getZip64EndOfCentralDirectoryLocator(), byteArrayOutputStream, this.rawIO);
                try {
                    writeEndOfCentralDirectoryRecord(zipModel, size, offsetOfCentralDirectory, byteArrayOutputStream, this.rawIO, charset);
                    writeZipHeaderBytes(zipModel, outputStream, byteArrayOutputStream.toByteArray(), charset);
                    byteArrayOutputStream.close();
                    return;
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    th = th;
                    byteArrayOutputStream.close();
                    throw th;
                }
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
        }
        try {
            byteArrayOutputStream.close();
            throw th;
        } catch (java.lang.Throwable th5) {
            th.addSuppressed(th5);
            throw th;
        }
    }

    public void updateLocalFileHeader(net.lingala.zip4j.model.FileHeader fileHeader, net.lingala.zip4j.model.ZipModel zipModel, net.lingala.zip4j.io.outputstream.SplitOutputStream splitOutputStream) throws java.io.IOException {
        net.lingala.zip4j.io.outputstream.SplitOutputStream splitOutputStream2;
        boolean z;
        java.lang.String str;
        java.lang.String str2;
        if (fileHeader == null || zipModel == null) {
            throw new net.lingala.zip4j.exception.ZipException("invalid input parameters, cannot update local file header");
        }
        if (fileHeader.getDiskNumberStart() != splitOutputStream.getCurrentSplitFileCounter()) {
            java.lang.String parent = zipModel.getZipFile().getParent();
            java.lang.String zipFileNameWithoutExtension = net.lingala.zip4j.util.FileUtils.getZipFileNameWithoutExtension(zipModel.getZipFile().getName());
            if (parent == null) {
                str = "";
            } else {
                str = parent + java.lang.System.getProperty("file.separator");
            }
            z = true;
            if (fileHeader.getDiskNumberStart() < 9) {
                str2 = str + zipFileNameWithoutExtension + ".z0" + (fileHeader.getDiskNumberStart() + 1);
            } else {
                str2 = str + zipFileNameWithoutExtension + ".z" + (fileHeader.getDiskNumberStart() + 1);
            }
            splitOutputStream2 = new net.lingala.zip4j.io.outputstream.SplitOutputStream(new java.io.File(str2));
        } else {
            splitOutputStream2 = splitOutputStream;
            z = false;
        }
        long filePointer = splitOutputStream2.getFilePointer();
        splitOutputStream2.seek(fileHeader.getOffsetLocalHeader() + 14);
        this.rawIO.writeLongLittleEndian(this.longBuff, 0, fileHeader.getCrc());
        splitOutputStream2.write(this.longBuff, 0, 4);
        updateFileSizesInLocalFileHeader(splitOutputStream2, fileHeader);
        if (z) {
            splitOutputStream2.close();
        } else {
            splitOutputStream.seek(filePointer);
        }
    }

    private void updateFileSizesInLocalFileHeader(net.lingala.zip4j.io.outputstream.SplitOutputStream splitOutputStream, net.lingala.zip4j.model.FileHeader fileHeader) throws java.io.IOException {
        if (fileHeader.getUncompressedSize() >= net.lingala.zip4j.util.InternalZipConstants.ZIP_64_SIZE_LIMIT) {
            this.rawIO.writeLongLittleEndian(this.longBuff, 0, net.lingala.zip4j.util.InternalZipConstants.ZIP_64_SIZE_LIMIT);
            splitOutputStream.write(this.longBuff, 0, 4);
            splitOutputStream.write(this.longBuff, 0, 4);
            int fileNameLength = fileHeader.getFileNameLength() + 8;
            if (splitOutputStream.skipBytes(fileNameLength) != fileNameLength) {
                throw new net.lingala.zip4j.exception.ZipException("Unable to skip " + fileNameLength + " bytes to update LFH");
            }
            this.rawIO.writeLongLittleEndian(splitOutputStream, fileHeader.getUncompressedSize());
            this.rawIO.writeLongLittleEndian(splitOutputStream, fileHeader.getCompressedSize());
            return;
        }
        this.rawIO.writeLongLittleEndian(this.longBuff, 0, fileHeader.getCompressedSize());
        splitOutputStream.write(this.longBuff, 0, 4);
        this.rawIO.writeLongLittleEndian(this.longBuff, 0, fileHeader.getUncompressedSize());
        splitOutputStream.write(this.longBuff, 0, 4);
    }

    private boolean isSplitZipFile(java.io.OutputStream outputStream) {
        if (outputStream instanceof net.lingala.zip4j.io.outputstream.SplitOutputStream) {
            return ((net.lingala.zip4j.io.outputstream.SplitOutputStream) outputStream).isSplitZipFile();
        }
        if (outputStream instanceof net.lingala.zip4j.io.outputstream.CountingOutputStream) {
            return ((net.lingala.zip4j.io.outputstream.CountingOutputStream) outputStream).isSplitZipFile();
        }
        return false;
    }

    private int getCurrentSplitFileCounter(java.io.OutputStream outputStream) {
        if (outputStream instanceof net.lingala.zip4j.io.outputstream.SplitOutputStream) {
            return ((net.lingala.zip4j.io.outputstream.SplitOutputStream) outputStream).getCurrentSplitFileCounter();
        }
        return ((net.lingala.zip4j.io.outputstream.CountingOutputStream) outputStream).getCurrentSplitFileCounter();
    }

    private void writeZipHeaderBytes(net.lingala.zip4j.model.ZipModel zipModel, java.io.OutputStream outputStream, byte[] bArr, java.nio.charset.Charset charset) throws java.lang.Throwable {
        if (bArr == null) {
            throw new net.lingala.zip4j.exception.ZipException("invalid buff to write as zip headers");
        }
        if ((outputStream instanceof net.lingala.zip4j.io.outputstream.CountingOutputStream) && ((net.lingala.zip4j.io.outputstream.CountingOutputStream) outputStream).checkBuffSizeAndStartNextSplitFile(bArr.length)) {
            finalizeZipFile(zipModel, outputStream, charset);
        } else {
            outputStream.write(bArr);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void processHeaderData(net.lingala.zip4j.model.ZipModel zipModel, java.io.OutputStream outputStream) throws java.io.IOException {
        int currentSplitFileCounter;
        if (outputStream instanceof net.lingala.zip4j.io.outputstream.OutputStreamWithSplitZipSupport) {
            net.lingala.zip4j.io.outputstream.OutputStreamWithSplitZipSupport outputStreamWithSplitZipSupport = (net.lingala.zip4j.io.outputstream.OutputStreamWithSplitZipSupport) outputStream;
            zipModel.getEndOfCentralDirectoryRecord().setOffsetOfStartOfCentralDirectory(outputStreamWithSplitZipSupport.getFilePointer());
            currentSplitFileCounter = outputStreamWithSplitZipSupport.getCurrentSplitFileCounter();
        } else {
            currentSplitFileCounter = 0;
        }
        if (zipModel.isZip64Format()) {
            if (zipModel.getZip64EndOfCentralDirectoryRecord() == null) {
                zipModel.setZip64EndOfCentralDirectoryRecord(new net.lingala.zip4j.model.Zip64EndOfCentralDirectoryRecord());
            }
            if (zipModel.getZip64EndOfCentralDirectoryLocator() == null) {
                zipModel.setZip64EndOfCentralDirectoryLocator(new net.lingala.zip4j.model.Zip64EndOfCentralDirectoryLocator());
            }
            zipModel.getZip64EndOfCentralDirectoryRecord().setOffsetStartCentralDirectoryWRTStartDiskNumber(zipModel.getEndOfCentralDirectoryRecord().getOffsetOfStartOfCentralDirectory());
            zipModel.getZip64EndOfCentralDirectoryLocator().setNumberOfDiskStartOfZip64EndOfCentralDirectoryRecord(currentSplitFileCounter);
            zipModel.getZip64EndOfCentralDirectoryLocator().setTotalNumberOfDiscs(currentSplitFileCounter + 1);
        }
        zipModel.getEndOfCentralDirectoryRecord().setNumberOfThisDisk(currentSplitFileCounter);
        zipModel.getEndOfCentralDirectoryRecord().setNumberOfThisDiskStartOfCentralDir(currentSplitFileCounter);
    }

    private void writeCentralDirectory(net.lingala.zip4j.model.ZipModel zipModel, java.io.ByteArrayOutputStream byteArrayOutputStream, net.lingala.zip4j.util.RawIO rawIO, java.nio.charset.Charset charset) throws net.lingala.zip4j.exception.ZipException {
        if (zipModel.getCentralDirectory() == null || zipModel.getCentralDirectory().getFileHeaders() == null || zipModel.getCentralDirectory().getFileHeaders().size() <= 0) {
            return;
        }
        java.util.Iterator<net.lingala.zip4j.model.FileHeader> it = zipModel.getCentralDirectory().getFileHeaders().iterator();
        while (it.hasNext()) {
            writeFileHeader(zipModel, it.next(), byteArrayOutputStream, rawIO, charset);
        }
    }

    private void writeFileHeader(net.lingala.zip4j.model.ZipModel zipModel, net.lingala.zip4j.model.FileHeader fileHeader, java.io.ByteArrayOutputStream byteArrayOutputStream, net.lingala.zip4j.util.RawIO rawIO, java.nio.charset.Charset charset) throws net.lingala.zip4j.exception.ZipException {
        if (fileHeader == null) {
            throw new net.lingala.zip4j.exception.ZipException("input parameters is null, cannot write local file header");
        }
        try {
            byte[] bArr = {0, 0};
            boolean zIsZip64Entry = isZip64Entry(fileHeader);
            rawIO.writeIntLittleEndian(byteArrayOutputStream, (int) fileHeader.getSignature().getValue());
            rawIO.writeShortLittleEndian(byteArrayOutputStream, fileHeader.getVersionMadeBy());
            rawIO.writeShortLittleEndian(byteArrayOutputStream, fileHeader.getVersionNeededToExtract());
            byteArrayOutputStream.write(fileHeader.getGeneralPurposeFlag());
            rawIO.writeShortLittleEndian(byteArrayOutputStream, fileHeader.getCompressionMethod().getCode());
            rawIO.writeLongLittleEndian(this.longBuff, 0, fileHeader.getLastModifiedTime());
            byteArrayOutputStream.write(this.longBuff, 0, 4);
            rawIO.writeLongLittleEndian(this.longBuff, 0, fileHeader.getCrc());
            byteArrayOutputStream.write(this.longBuff, 0, 4);
            if (zIsZip64Entry) {
                rawIO.writeLongLittleEndian(this.longBuff, 0, net.lingala.zip4j.util.InternalZipConstants.ZIP_64_SIZE_LIMIT);
                byteArrayOutputStream.write(this.longBuff, 0, 4);
                byteArrayOutputStream.write(this.longBuff, 0, 4);
                zipModel.setZip64Format(true);
            } else {
                rawIO.writeLongLittleEndian(this.longBuff, 0, fileHeader.getCompressedSize());
                byteArrayOutputStream.write(this.longBuff, 0, 4);
                rawIO.writeLongLittleEndian(this.longBuff, 0, fileHeader.getUncompressedSize());
                byteArrayOutputStream.write(this.longBuff, 0, 4);
            }
            byte[] bytesFromString = new byte[0];
            if (net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(fileHeader.getFileName())) {
                bytesFromString = net.lingala.zip4j.headers.HeaderUtil.getBytesFromString(fileHeader.getFileName(), charset);
            }
            rawIO.writeShortLittleEndian(byteArrayOutputStream, bytesFromString.length);
            byte[] bArr2 = new byte[4];
            if (zIsZip64Entry) {
                rawIO.writeLongLittleEndian(this.longBuff, 0, net.lingala.zip4j.util.InternalZipConstants.ZIP_64_SIZE_LIMIT);
                java.lang.System.arraycopy(this.longBuff, 0, bArr2, 0, 4);
            } else {
                rawIO.writeLongLittleEndian(this.longBuff, 0, fileHeader.getOffsetLocalHeader());
                java.lang.System.arraycopy(this.longBuff, 0, bArr2, 0, 4);
            }
            rawIO.writeShortLittleEndian(byteArrayOutputStream, calculateExtraDataRecordsSize(fileHeader, zIsZip64Entry));
            java.lang.String fileComment = fileHeader.getFileComment();
            byte[] bytesFromString2 = new byte[0];
            if (net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(fileComment)) {
                bytesFromString2 = net.lingala.zip4j.headers.HeaderUtil.getBytesFromString(fileComment, charset);
            }
            rawIO.writeShortLittleEndian(byteArrayOutputStream, bytesFromString2.length);
            if (zIsZip64Entry) {
                rawIO.writeIntLittleEndian(this.intBuff, 0, 65535);
                byteArrayOutputStream.write(this.intBuff, 0, 2);
            } else {
                rawIO.writeShortLittleEndian(byteArrayOutputStream, fileHeader.getDiskNumberStart());
            }
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(fileHeader.getExternalFileAttributes());
            byteArrayOutputStream.write(bArr2);
            if (bytesFromString.length > 0) {
                byteArrayOutputStream.write(bytesFromString);
            }
            if (zIsZip64Entry) {
                zipModel.setZip64Format(true);
                rawIO.writeShortLittleEndian(byteArrayOutputStream, (int) net.lingala.zip4j.headers.HeaderSignature.ZIP64_EXTRA_FIELD_SIGNATURE.getValue());
                rawIO.writeShortLittleEndian(byteArrayOutputStream, 28);
                rawIO.writeLongLittleEndian(byteArrayOutputStream, fileHeader.getUncompressedSize());
                rawIO.writeLongLittleEndian(byteArrayOutputStream, fileHeader.getCompressedSize());
                rawIO.writeLongLittleEndian(byteArrayOutputStream, fileHeader.getOffsetLocalHeader());
                rawIO.writeIntLittleEndian(byteArrayOutputStream, fileHeader.getDiskNumberStart());
            }
            if (fileHeader.getAesExtraDataRecord() != null) {
                net.lingala.zip4j.model.AESExtraDataRecord aesExtraDataRecord = fileHeader.getAesExtraDataRecord();
                rawIO.writeShortLittleEndian(byteArrayOutputStream, (int) aesExtraDataRecord.getSignature().getValue());
                rawIO.writeShortLittleEndian(byteArrayOutputStream, aesExtraDataRecord.getDataSize());
                rawIO.writeShortLittleEndian(byteArrayOutputStream, aesExtraDataRecord.getAesVersion().getVersionNumber());
                byteArrayOutputStream.write(net.lingala.zip4j.headers.HeaderUtil.getBytesFromString(aesExtraDataRecord.getVendorID(), charset));
                byteArrayOutputStream.write(new byte[]{(byte) aesExtraDataRecord.getAesKeyStrength().getRawCode()});
                rawIO.writeShortLittleEndian(byteArrayOutputStream, aesExtraDataRecord.getCompressionMethod().getCode());
            }
            writeRemainingExtraDataRecordsIfPresent(fileHeader, byteArrayOutputStream);
            if (bytesFromString2.length > 0) {
                byteArrayOutputStream.write(bytesFromString2);
            }
        } catch (java.lang.Exception e) {
            throw new net.lingala.zip4j.exception.ZipException(e);
        }
    }

    private int calculateExtraDataRecordsSize(net.lingala.zip4j.model.FileHeader fileHeader, boolean z) {
        int sizeOfData = z ? 32 : 0;
        if (fileHeader.getAesExtraDataRecord() != null) {
            sizeOfData += 11;
        }
        if (fileHeader.getExtraDataRecords() != null) {
            for (net.lingala.zip4j.model.ExtraDataRecord extraDataRecord : fileHeader.getExtraDataRecords()) {
                if (extraDataRecord.getHeader() != net.lingala.zip4j.headers.HeaderSignature.AES_EXTRA_DATA_RECORD.getValue() && extraDataRecord.getHeader() != net.lingala.zip4j.headers.HeaderSignature.ZIP64_EXTRA_FIELD_SIGNATURE.getValue()) {
                    sizeOfData += extraDataRecord.getSizeOfData() + 4;
                }
            }
        }
        return sizeOfData;
    }

    private void writeRemainingExtraDataRecordsIfPresent(net.lingala.zip4j.model.FileHeader fileHeader, java.io.OutputStream outputStream) throws java.io.IOException {
        if (fileHeader.getExtraDataRecords() == null || fileHeader.getExtraDataRecords().size() == 0) {
            return;
        }
        for (net.lingala.zip4j.model.ExtraDataRecord extraDataRecord : fileHeader.getExtraDataRecords()) {
            if (extraDataRecord.getHeader() != net.lingala.zip4j.headers.HeaderSignature.AES_EXTRA_DATA_RECORD.getValue() && extraDataRecord.getHeader() != net.lingala.zip4j.headers.HeaderSignature.ZIP64_EXTRA_FIELD_SIGNATURE.getValue()) {
                this.rawIO.writeShortLittleEndian(outputStream, (int) extraDataRecord.getHeader());
                this.rawIO.writeShortLittleEndian(outputStream, extraDataRecord.getSizeOfData());
                if (extraDataRecord.getSizeOfData() > 0 && extraDataRecord.getData() != null) {
                    outputStream.write(extraDataRecord.getData());
                }
            }
        }
    }

    private void writeZip64EndOfCentralDirectoryRecord(net.lingala.zip4j.model.Zip64EndOfCentralDirectoryRecord zip64EndOfCentralDirectoryRecord, java.io.ByteArrayOutputStream byteArrayOutputStream, net.lingala.zip4j.util.RawIO rawIO) throws java.io.IOException {
        rawIO.writeIntLittleEndian(byteArrayOutputStream, (int) zip64EndOfCentralDirectoryRecord.getSignature().getValue());
        rawIO.writeLongLittleEndian(byteArrayOutputStream, zip64EndOfCentralDirectoryRecord.getSizeOfZip64EndCentralDirectoryRecord());
        rawIO.writeShortLittleEndian(byteArrayOutputStream, zip64EndOfCentralDirectoryRecord.getVersionMadeBy());
        rawIO.writeShortLittleEndian(byteArrayOutputStream, zip64EndOfCentralDirectoryRecord.getVersionNeededToExtract());
        rawIO.writeIntLittleEndian(byteArrayOutputStream, zip64EndOfCentralDirectoryRecord.getNumberOfThisDisk());
        rawIO.writeIntLittleEndian(byteArrayOutputStream, zip64EndOfCentralDirectoryRecord.getNumberOfThisDiskStartOfCentralDirectory());
        rawIO.writeLongLittleEndian(byteArrayOutputStream, zip64EndOfCentralDirectoryRecord.getTotalNumberOfEntriesInCentralDirectoryOnThisDisk());
        rawIO.writeLongLittleEndian(byteArrayOutputStream, zip64EndOfCentralDirectoryRecord.getTotalNumberOfEntriesInCentralDirectory());
        rawIO.writeLongLittleEndian(byteArrayOutputStream, zip64EndOfCentralDirectoryRecord.getSizeOfCentralDirectory());
        rawIO.writeLongLittleEndian(byteArrayOutputStream, zip64EndOfCentralDirectoryRecord.getOffsetStartCentralDirectoryWRTStartDiskNumber());
    }

    private void writeZip64EndOfCentralDirectoryLocator(net.lingala.zip4j.model.Zip64EndOfCentralDirectoryLocator zip64EndOfCentralDirectoryLocator, java.io.ByteArrayOutputStream byteArrayOutputStream, net.lingala.zip4j.util.RawIO rawIO) throws java.io.IOException {
        rawIO.writeIntLittleEndian(byteArrayOutputStream, (int) net.lingala.zip4j.headers.HeaderSignature.ZIP64_END_CENTRAL_DIRECTORY_LOCATOR.getValue());
        rawIO.writeIntLittleEndian(byteArrayOutputStream, zip64EndOfCentralDirectoryLocator.getNumberOfDiskStartOfZip64EndOfCentralDirectoryRecord());
        rawIO.writeLongLittleEndian(byteArrayOutputStream, zip64EndOfCentralDirectoryLocator.getOffsetZip64EndOfCentralDirectoryRecord());
        rawIO.writeIntLittleEndian(byteArrayOutputStream, zip64EndOfCentralDirectoryLocator.getTotalNumberOfDiscs());
    }

    private void writeEndOfCentralDirectoryRecord(net.lingala.zip4j.model.ZipModel zipModel, int i, long j, java.io.ByteArrayOutputStream byteArrayOutputStream, net.lingala.zip4j.util.RawIO rawIO, java.nio.charset.Charset charset) throws java.io.IOException {
        byte[] bArr = new byte[8];
        rawIO.writeIntLittleEndian(byteArrayOutputStream, (int) net.lingala.zip4j.headers.HeaderSignature.END_OF_CENTRAL_DIRECTORY.getValue());
        rawIO.writeShortLittleEndian(byteArrayOutputStream, zipModel.getEndOfCentralDirectoryRecord().getNumberOfThisDisk());
        rawIO.writeShortLittleEndian(byteArrayOutputStream, zipModel.getEndOfCentralDirectoryRecord().getNumberOfThisDiskStartOfCentralDir());
        long size = zipModel.getCentralDirectory().getFileHeaders().size();
        long jCountNumberOfFileHeaderEntriesOnDisk = zipModel.isSplitArchive() ? countNumberOfFileHeaderEntriesOnDisk(zipModel.getCentralDirectory().getFileHeaders(), zipModel.getEndOfCentralDirectoryRecord().getNumberOfThisDisk()) : size;
        if (jCountNumberOfFileHeaderEntriesOnDisk > 65535) {
            jCountNumberOfFileHeaderEntriesOnDisk = 65535;
        }
        rawIO.writeShortLittleEndian(byteArrayOutputStream, (int) jCountNumberOfFileHeaderEntriesOnDisk);
        if (size > 65535) {
            size = 65535;
        }
        rawIO.writeShortLittleEndian(byteArrayOutputStream, (int) size);
        rawIO.writeIntLittleEndian(byteArrayOutputStream, i);
        if (j > net.lingala.zip4j.util.InternalZipConstants.ZIP_64_SIZE_LIMIT) {
            rawIO.writeLongLittleEndian(bArr, 0, net.lingala.zip4j.util.InternalZipConstants.ZIP_64_SIZE_LIMIT);
            byteArrayOutputStream.write(bArr, 0, 4);
        } else {
            rawIO.writeLongLittleEndian(bArr, 0, j);
            byteArrayOutputStream.write(bArr, 0, 4);
        }
        java.lang.String comment = zipModel.getEndOfCentralDirectoryRecord().getComment();
        if (net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(comment)) {
            byte[] bytesFromString = net.lingala.zip4j.headers.HeaderUtil.getBytesFromString(comment, charset);
            rawIO.writeShortLittleEndian(byteArrayOutputStream, bytesFromString.length);
            byteArrayOutputStream.write(bytesFromString);
            return;
        }
        rawIO.writeShortLittleEndian(byteArrayOutputStream, 0);
    }

    private long countNumberOfFileHeaderEntriesOnDisk(java.util.List<net.lingala.zip4j.model.FileHeader> list, int i) throws net.lingala.zip4j.exception.ZipException {
        if (list == null) {
            throw new net.lingala.zip4j.exception.ZipException("file headers are null, cannot calculate number of entries on this disk");
        }
        java.util.Iterator<net.lingala.zip4j.model.FileHeader> it = list.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (it.next().getDiskNumberStart() == i) {
                i2++;
            }
        }
        return i2;
    }

    private boolean isZip64Entry(net.lingala.zip4j.model.FileHeader fileHeader) {
        return fileHeader.getCompressedSize() >= net.lingala.zip4j.util.InternalZipConstants.ZIP_64_SIZE_LIMIT || fileHeader.getUncompressedSize() >= net.lingala.zip4j.util.InternalZipConstants.ZIP_64_SIZE_LIMIT || fileHeader.getOffsetLocalHeader() >= net.lingala.zip4j.util.InternalZipConstants.ZIP_64_SIZE_LIMIT || fileHeader.getDiskNumberStart() >= 65535;
    }

    private long getOffsetOfCentralDirectory(net.lingala.zip4j.model.ZipModel zipModel) {
        if (zipModel.isZip64Format() && zipModel.getZip64EndOfCentralDirectoryRecord() != null && zipModel.getZip64EndOfCentralDirectoryRecord().getOffsetStartCentralDirectoryWRTStartDiskNumber() != -1) {
            return zipModel.getZip64EndOfCentralDirectoryRecord().getOffsetStartCentralDirectoryWRTStartDiskNumber();
        }
        return zipModel.getEndOfCentralDirectoryRecord().getOffsetOfStartOfCentralDirectory();
    }

    private net.lingala.zip4j.model.Zip64EndOfCentralDirectoryRecord buildZip64EndOfCentralDirectoryRecord(net.lingala.zip4j.model.ZipModel zipModel, int i, long j) throws net.lingala.zip4j.exception.ZipException {
        net.lingala.zip4j.model.Zip64EndOfCentralDirectoryRecord zip64EndOfCentralDirectoryRecord = new net.lingala.zip4j.model.Zip64EndOfCentralDirectoryRecord();
        zip64EndOfCentralDirectoryRecord.setSignature(net.lingala.zip4j.headers.HeaderSignature.ZIP64_END_CENTRAL_DIRECTORY_RECORD);
        zip64EndOfCentralDirectoryRecord.setSizeOfZip64EndCentralDirectoryRecord(44L);
        if (zipModel.getCentralDirectory() != null && zipModel.getCentralDirectory().getFileHeaders() != null && zipModel.getCentralDirectory().getFileHeaders().size() > 0) {
            net.lingala.zip4j.model.FileHeader fileHeader = zipModel.getCentralDirectory().getFileHeaders().get(0);
            zip64EndOfCentralDirectoryRecord.setVersionMadeBy(fileHeader.getVersionMadeBy());
            zip64EndOfCentralDirectoryRecord.setVersionNeededToExtract(fileHeader.getVersionNeededToExtract());
        }
        zip64EndOfCentralDirectoryRecord.setNumberOfThisDisk(zipModel.getEndOfCentralDirectoryRecord().getNumberOfThisDisk());
        zip64EndOfCentralDirectoryRecord.setNumberOfThisDiskStartOfCentralDirectory(zipModel.getEndOfCentralDirectoryRecord().getNumberOfThisDiskStartOfCentralDir());
        long size = zipModel.getCentralDirectory().getFileHeaders().size();
        zip64EndOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectoryOnThisDisk(zipModel.isSplitArchive() ? countNumberOfFileHeaderEntriesOnDisk(zipModel.getCentralDirectory().getFileHeaders(), zipModel.getEndOfCentralDirectoryRecord().getNumberOfThisDisk()) : size);
        zip64EndOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectory(size);
        zip64EndOfCentralDirectoryRecord.setSizeOfCentralDirectory(i);
        zip64EndOfCentralDirectoryRecord.setOffsetStartCentralDirectoryWRTStartDiskNumber(j);
        return zip64EndOfCentralDirectoryRecord;
    }
}
