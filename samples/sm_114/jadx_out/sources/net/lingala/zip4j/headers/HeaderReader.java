package net.lingala.zip4j.headers;

/* JADX INFO: loaded from: classes2.dex */
public class HeaderReader {
    private net.lingala.zip4j.model.ZipModel zipModel;
    private final net.lingala.zip4j.util.RawIO rawIO = new net.lingala.zip4j.util.RawIO();
    private final byte[] intBuff = new byte[4];

    public net.lingala.zip4j.model.ZipModel readAllHeaders(java.io.RandomAccessFile randomAccessFile, net.lingala.zip4j.model.Zip4jConfig zip4jConfig) throws java.io.IOException {
        if (randomAccessFile.length() == 0) {
            return new net.lingala.zip4j.model.ZipModel();
        }
        if (randomAccessFile.length() < 22) {
            throw new net.lingala.zip4j.exception.ZipException("Zip file size less than minimum expected zip file size. Probably not a zip file or a corrupted zip file");
        }
        net.lingala.zip4j.model.ZipModel zipModel = new net.lingala.zip4j.model.ZipModel();
        this.zipModel = zipModel;
        try {
            zipModel.setEndOfCentralDirectoryRecord(readEndOfCentralDirectoryRecord(randomAccessFile, this.rawIO, zip4jConfig));
            if (this.zipModel.getEndOfCentralDirectoryRecord().getTotalNumberOfEntriesInCentralDirectory() == 0) {
                return this.zipModel;
            }
            net.lingala.zip4j.model.ZipModel zipModel2 = this.zipModel;
            zipModel2.setZip64EndOfCentralDirectoryLocator(readZip64EndOfCentralDirectoryLocator(randomAccessFile, this.rawIO, zipModel2.getEndOfCentralDirectoryRecord().getOffsetOfEndOfCentralDirectory()));
            if (this.zipModel.isZip64Format()) {
                this.zipModel.setZip64EndOfCentralDirectoryRecord(readZip64EndCentralDirRec(randomAccessFile, this.rawIO));
                if (this.zipModel.getZip64EndOfCentralDirectoryRecord() != null && this.zipModel.getZip64EndOfCentralDirectoryRecord().getNumberOfThisDisk() > 0) {
                    this.zipModel.setSplitArchive(true);
                } else {
                    this.zipModel.setSplitArchive(false);
                }
            }
            this.zipModel.setCentralDirectory(readCentralDirectory(randomAccessFile, this.rawIO, zip4jConfig.getCharset()));
            return this.zipModel;
        } catch (net.lingala.zip4j.exception.ZipException e) {
            throw e;
        } catch (java.io.IOException e2) {
            e2.printStackTrace();
            throw new net.lingala.zip4j.exception.ZipException("Zip headers not found. Probably not a zip file or a corrupted zip file", e2);
        }
    }

    private net.lingala.zip4j.model.EndOfCentralDirectoryRecord readEndOfCentralDirectoryRecord(java.io.RandomAccessFile randomAccessFile, net.lingala.zip4j.util.RawIO rawIO, net.lingala.zip4j.model.Zip4jConfig zip4jConfig) throws java.io.IOException {
        long jLocateOffsetOfEndOfCentralDirectory = locateOffsetOfEndOfCentralDirectory(randomAccessFile);
        seekInCurrentPart(randomAccessFile, 4 + jLocateOffsetOfEndOfCentralDirectory);
        net.lingala.zip4j.model.EndOfCentralDirectoryRecord endOfCentralDirectoryRecord = new net.lingala.zip4j.model.EndOfCentralDirectoryRecord();
        endOfCentralDirectoryRecord.setSignature(net.lingala.zip4j.headers.HeaderSignature.END_OF_CENTRAL_DIRECTORY);
        endOfCentralDirectoryRecord.setNumberOfThisDisk(rawIO.readShortLittleEndian(randomAccessFile));
        endOfCentralDirectoryRecord.setNumberOfThisDiskStartOfCentralDir(rawIO.readShortLittleEndian(randomAccessFile));
        endOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectoryOnThisDisk(rawIO.readShortLittleEndian(randomAccessFile));
        endOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectory(rawIO.readShortLittleEndian(randomAccessFile));
        endOfCentralDirectoryRecord.setSizeOfCentralDirectory(rawIO.readIntLittleEndian(randomAccessFile));
        endOfCentralDirectoryRecord.setOffsetOfEndOfCentralDirectory(jLocateOffsetOfEndOfCentralDirectory);
        randomAccessFile.readFully(this.intBuff);
        endOfCentralDirectoryRecord.setOffsetOfStartOfCentralDirectory(rawIO.readLongLittleEndian(this.intBuff, 0));
        endOfCentralDirectoryRecord.setComment(readZipComment(randomAccessFile, rawIO.readShortLittleEndian(randomAccessFile), zip4jConfig.getCharset()));
        this.zipModel.setSplitArchive(endOfCentralDirectoryRecord.getNumberOfThisDisk() > 0);
        return endOfCentralDirectoryRecord;
    }

    private net.lingala.zip4j.model.CentralDirectory readCentralDirectory(java.io.RandomAccessFile randomAccessFile, net.lingala.zip4j.util.RawIO rawIO, java.nio.charset.Charset charset) throws java.io.IOException {
        net.lingala.zip4j.model.CentralDirectory centralDirectory = new net.lingala.zip4j.model.CentralDirectory();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        long offsetStartOfCentralDirectory = net.lingala.zip4j.headers.HeaderUtil.getOffsetStartOfCentralDirectory(this.zipModel);
        long numberOfEntriesInCentralDirectory = getNumberOfEntriesInCentralDirectory(this.zipModel);
        randomAccessFile.seek(offsetStartOfCentralDirectory);
        int i = 2;
        byte[] bArr = new byte[2];
        byte[] bArr2 = new byte[4];
        int i2 = 0;
        int i3 = 0;
        while (i3 < numberOfEntriesInCentralDirectory) {
            net.lingala.zip4j.model.FileHeader fileHeader = new net.lingala.zip4j.model.FileHeader();
            byte[] bArr3 = bArr2;
            if (rawIO.readIntLittleEndian(randomAccessFile) != net.lingala.zip4j.headers.HeaderSignature.CENTRAL_DIRECTORY.getValue()) {
                throw new net.lingala.zip4j.exception.ZipException("Expected central directory entry not found (#" + (i3 + 1) + com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
            }
            fileHeader.setSignature(net.lingala.zip4j.headers.HeaderSignature.CENTRAL_DIRECTORY);
            fileHeader.setVersionMadeBy(rawIO.readShortLittleEndian(randomAccessFile));
            fileHeader.setVersionNeededToExtract(rawIO.readShortLittleEndian(randomAccessFile));
            byte[] bArr4 = new byte[i];
            randomAccessFile.readFully(bArr4);
            fileHeader.setEncrypted(net.lingala.zip4j.util.BitUtils.isBitSet(bArr4[i2], i2));
            fileHeader.setDataDescriptorExists(net.lingala.zip4j.util.BitUtils.isBitSet(bArr4[i2], 3));
            fileHeader.setFileNameUTF8Encoded(net.lingala.zip4j.util.BitUtils.isBitSet(bArr4[1], 3));
            fileHeader.setGeneralPurposeFlag((byte[]) bArr4.clone());
            fileHeader.setCompressionMethod(net.lingala.zip4j.model.enums.CompressionMethod.getCompressionMethodFromCode(rawIO.readShortLittleEndian(randomAccessFile)));
            fileHeader.setLastModifiedTime(rawIO.readIntLittleEndian(randomAccessFile));
            randomAccessFile.readFully(bArr3);
            fileHeader.setCrc(rawIO.readLongLittleEndian(bArr3, i2));
            int i4 = i3;
            fileHeader.setCompressedSize(rawIO.readLongLittleEndian(randomAccessFile, 4));
            fileHeader.setUncompressedSize(rawIO.readLongLittleEndian(randomAccessFile, 4));
            int shortLittleEndian = rawIO.readShortLittleEndian(randomAccessFile);
            fileHeader.setFileNameLength(shortLittleEndian);
            fileHeader.setExtraFieldLength(rawIO.readShortLittleEndian(randomAccessFile));
            int shortLittleEndian2 = rawIO.readShortLittleEndian(randomAccessFile);
            fileHeader.setFileCommentLength(shortLittleEndian2);
            fileHeader.setDiskNumberStart(rawIO.readShortLittleEndian(randomAccessFile));
            randomAccessFile.readFully(bArr);
            fileHeader.setInternalFileAttributes((byte[]) bArr.clone());
            randomAccessFile.readFully(bArr3);
            fileHeader.setExternalFileAttributes((byte[]) bArr3.clone());
            randomAccessFile.readFully(bArr3);
            long j = numberOfEntriesInCentralDirectory;
            byte[] bArr5 = bArr;
            fileHeader.setOffsetLocalHeader(rawIO.readLongLittleEndian(bArr3, 0));
            if (shortLittleEndian > 0) {
                byte[] bArr6 = new byte[shortLittleEndian];
                randomAccessFile.readFully(bArr6);
                fileHeader.setFileName(net.lingala.zip4j.headers.HeaderUtil.decodeStringWithCharset(bArr6, fileHeader.isFileNameUTF8Encoded(), charset));
                fileHeader.setDirectory(isDirectory(fileHeader.getExternalFileAttributes(), fileHeader.getFileName()));
                readExtraDataRecords(randomAccessFile, fileHeader);
                readZip64ExtendedInfo(fileHeader, rawIO);
                readAesExtraDataRecord(fileHeader, rawIO);
                if (shortLittleEndian2 > 0) {
                    byte[] bArr7 = new byte[shortLittleEndian2];
                    randomAccessFile.readFully(bArr7);
                    fileHeader.setFileComment(net.lingala.zip4j.headers.HeaderUtil.decodeStringWithCharset(bArr7, fileHeader.isFileNameUTF8Encoded(), charset));
                }
                if (fileHeader.isEncrypted()) {
                    if (fileHeader.getAesExtraDataRecord() != null) {
                        fileHeader.setEncryptionMethod(net.lingala.zip4j.model.enums.EncryptionMethod.AES);
                    } else {
                        fileHeader.setEncryptionMethod(net.lingala.zip4j.model.enums.EncryptionMethod.ZIP_STANDARD);
                    }
                }
                arrayList.add(fileHeader);
                i3 = i4 + 1;
                bArr2 = bArr3;
                bArr = bArr5;
                numberOfEntriesInCentralDirectory = j;
                i = 2;
                i2 = 0;
            } else {
                throw new net.lingala.zip4j.exception.ZipException("Invalid entry name in file header");
            }
        }
        centralDirectory.setFileHeaders(arrayList);
        net.lingala.zip4j.model.DigitalSignature digitalSignature = new net.lingala.zip4j.model.DigitalSignature();
        if (rawIO.readIntLittleEndian(randomAccessFile) == net.lingala.zip4j.headers.HeaderSignature.DIGITAL_SIGNATURE.getValue()) {
            digitalSignature.setSignature(net.lingala.zip4j.headers.HeaderSignature.DIGITAL_SIGNATURE);
            digitalSignature.setSizeOfData(rawIO.readShortLittleEndian(randomAccessFile));
            if (digitalSignature.getSizeOfData() > 0) {
                byte[] bArr8 = new byte[digitalSignature.getSizeOfData()];
                randomAccessFile.readFully(bArr8);
                digitalSignature.setSignatureData(new java.lang.String(bArr8));
            }
        }
        return centralDirectory;
    }

    private void readExtraDataRecords(java.io.RandomAccessFile randomAccessFile, net.lingala.zip4j.model.FileHeader fileHeader) throws java.io.IOException {
        int extraFieldLength = fileHeader.getExtraFieldLength();
        if (extraFieldLength <= 0) {
            return;
        }
        fileHeader.setExtraDataRecords(readExtraDataRecords(randomAccessFile, extraFieldLength));
    }

    private void readExtraDataRecords(java.io.InputStream inputStream, net.lingala.zip4j.model.LocalFileHeader localFileHeader) throws java.io.IOException {
        int extraFieldLength = localFileHeader.getExtraFieldLength();
        if (extraFieldLength <= 0) {
            return;
        }
        localFileHeader.setExtraDataRecords(readExtraDataRecords(inputStream, extraFieldLength));
    }

    private java.util.List<net.lingala.zip4j.model.ExtraDataRecord> readExtraDataRecords(java.io.RandomAccessFile randomAccessFile, int i) throws java.io.IOException {
        if (i < 4) {
            if (i <= 0) {
                return null;
            }
            randomAccessFile.skipBytes(i);
            return null;
        }
        byte[] bArr = new byte[i];
        randomAccessFile.read(bArr);
        try {
            return parseExtraDataRecords(bArr, i);
        } catch (java.lang.Exception unused) {
            return java.util.Collections.EMPTY_LIST;
        }
    }

    private java.util.List<net.lingala.zip4j.model.ExtraDataRecord> readExtraDataRecords(java.io.InputStream inputStream, int i) throws java.io.IOException {
        if (i < 4) {
            if (i <= 0) {
                return null;
            }
            inputStream.skip(i);
            return null;
        }
        byte[] bArr = new byte[i];
        net.lingala.zip4j.util.Zip4jUtil.readFully(inputStream, bArr);
        try {
            return parseExtraDataRecords(bArr, i);
        } catch (java.lang.Exception unused) {
            return java.util.Collections.EMPTY_LIST;
        }
    }

    private java.util.List<net.lingala.zip4j.model.ExtraDataRecord> parseExtraDataRecords(byte[] bArr, int i) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i2 = 0;
        while (i2 < i) {
            net.lingala.zip4j.model.ExtraDataRecord extraDataRecord = new net.lingala.zip4j.model.ExtraDataRecord();
            extraDataRecord.setHeader(this.rawIO.readShortLittleEndian(bArr, i2));
            int shortLittleEndian = this.rawIO.readShortLittleEndian(bArr, i2 + 2);
            extraDataRecord.setSizeOfData(shortLittleEndian);
            int i3 = i2 + 4;
            if (shortLittleEndian > 0) {
                byte[] bArr2 = new byte[shortLittleEndian];
                java.lang.System.arraycopy(bArr, i3, bArr2, 0, shortLittleEndian);
                extraDataRecord.setData(bArr2);
            }
            i2 = i3 + shortLittleEndian;
            arrayList.add(extraDataRecord);
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }

    private net.lingala.zip4j.model.Zip64EndOfCentralDirectoryLocator readZip64EndOfCentralDirectoryLocator(java.io.RandomAccessFile randomAccessFile, net.lingala.zip4j.util.RawIO rawIO, long j) throws java.io.IOException {
        net.lingala.zip4j.model.Zip64EndOfCentralDirectoryLocator zip64EndOfCentralDirectoryLocator = new net.lingala.zip4j.model.Zip64EndOfCentralDirectoryLocator();
        setFilePointerToReadZip64EndCentralDirLoc(randomAccessFile, j);
        if (rawIO.readIntLittleEndian(randomAccessFile) == net.lingala.zip4j.headers.HeaderSignature.ZIP64_END_CENTRAL_DIRECTORY_LOCATOR.getValue()) {
            this.zipModel.setZip64Format(true);
            zip64EndOfCentralDirectoryLocator.setSignature(net.lingala.zip4j.headers.HeaderSignature.ZIP64_END_CENTRAL_DIRECTORY_LOCATOR);
            zip64EndOfCentralDirectoryLocator.setNumberOfDiskStartOfZip64EndOfCentralDirectoryRecord(rawIO.readIntLittleEndian(randomAccessFile));
            zip64EndOfCentralDirectoryLocator.setOffsetZip64EndOfCentralDirectoryRecord(rawIO.readLongLittleEndian(randomAccessFile));
            zip64EndOfCentralDirectoryLocator.setTotalNumberOfDiscs(rawIO.readIntLittleEndian(randomAccessFile));
            return zip64EndOfCentralDirectoryLocator;
        }
        this.zipModel.setZip64Format(false);
        return null;
    }

    private net.lingala.zip4j.model.Zip64EndOfCentralDirectoryRecord readZip64EndCentralDirRec(java.io.RandomAccessFile randomAccessFile, net.lingala.zip4j.util.RawIO rawIO) throws java.io.IOException {
        if (this.zipModel.getZip64EndOfCentralDirectoryLocator() == null) {
            throw new net.lingala.zip4j.exception.ZipException("invalid zip64 end of central directory locator");
        }
        long offsetZip64EndOfCentralDirectoryRecord = this.zipModel.getZip64EndOfCentralDirectoryLocator().getOffsetZip64EndOfCentralDirectoryRecord();
        if (offsetZip64EndOfCentralDirectoryRecord < 0) {
            throw new net.lingala.zip4j.exception.ZipException("invalid offset for start of end of central directory record");
        }
        randomAccessFile.seek(offsetZip64EndOfCentralDirectoryRecord);
        net.lingala.zip4j.model.Zip64EndOfCentralDirectoryRecord zip64EndOfCentralDirectoryRecord = new net.lingala.zip4j.model.Zip64EndOfCentralDirectoryRecord();
        if (rawIO.readIntLittleEndian(randomAccessFile) != net.lingala.zip4j.headers.HeaderSignature.ZIP64_END_CENTRAL_DIRECTORY_RECORD.getValue()) {
            throw new net.lingala.zip4j.exception.ZipException("invalid signature for zip64 end of central directory record");
        }
        zip64EndOfCentralDirectoryRecord.setSignature(net.lingala.zip4j.headers.HeaderSignature.ZIP64_END_CENTRAL_DIRECTORY_RECORD);
        zip64EndOfCentralDirectoryRecord.setSizeOfZip64EndCentralDirectoryRecord(rawIO.readLongLittleEndian(randomAccessFile));
        zip64EndOfCentralDirectoryRecord.setVersionMadeBy(rawIO.readShortLittleEndian(randomAccessFile));
        zip64EndOfCentralDirectoryRecord.setVersionNeededToExtract(rawIO.readShortLittleEndian(randomAccessFile));
        zip64EndOfCentralDirectoryRecord.setNumberOfThisDisk(rawIO.readIntLittleEndian(randomAccessFile));
        zip64EndOfCentralDirectoryRecord.setNumberOfThisDiskStartOfCentralDirectory(rawIO.readIntLittleEndian(randomAccessFile));
        zip64EndOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectoryOnThisDisk(rawIO.readLongLittleEndian(randomAccessFile));
        zip64EndOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectory(rawIO.readLongLittleEndian(randomAccessFile));
        zip64EndOfCentralDirectoryRecord.setSizeOfCentralDirectory(rawIO.readLongLittleEndian(randomAccessFile));
        zip64EndOfCentralDirectoryRecord.setOffsetStartCentralDirectoryWRTStartDiskNumber(rawIO.readLongLittleEndian(randomAccessFile));
        long sizeOfZip64EndCentralDirectoryRecord = zip64EndOfCentralDirectoryRecord.getSizeOfZip64EndCentralDirectoryRecord() - 44;
        if (sizeOfZip64EndCentralDirectoryRecord > 0) {
            byte[] bArr = new byte[(int) sizeOfZip64EndCentralDirectoryRecord];
            randomAccessFile.readFully(bArr);
            zip64EndOfCentralDirectoryRecord.setExtensibleDataSector(bArr);
        }
        return zip64EndOfCentralDirectoryRecord;
    }

    private void readZip64ExtendedInfo(net.lingala.zip4j.model.FileHeader fileHeader, net.lingala.zip4j.util.RawIO rawIO) {
        net.lingala.zip4j.model.Zip64ExtendedInfo zip64ExtendedInfo;
        if (fileHeader.getExtraDataRecords() == null || fileHeader.getExtraDataRecords().size() <= 0 || (zip64ExtendedInfo = readZip64ExtendedInfo(fileHeader.getExtraDataRecords(), rawIO, fileHeader.getUncompressedSize(), fileHeader.getCompressedSize(), fileHeader.getOffsetLocalHeader(), fileHeader.getDiskNumberStart())) == null) {
            return;
        }
        fileHeader.setZip64ExtendedInfo(zip64ExtendedInfo);
        if (zip64ExtendedInfo.getUncompressedSize() != -1) {
            fileHeader.setUncompressedSize(zip64ExtendedInfo.getUncompressedSize());
        }
        if (zip64ExtendedInfo.getCompressedSize() != -1) {
            fileHeader.setCompressedSize(zip64ExtendedInfo.getCompressedSize());
        }
        if (zip64ExtendedInfo.getOffsetLocalHeader() != -1) {
            fileHeader.setOffsetLocalHeader(zip64ExtendedInfo.getOffsetLocalHeader());
        }
        if (zip64ExtendedInfo.getDiskNumberStart() != -1) {
            fileHeader.setDiskNumberStart(zip64ExtendedInfo.getDiskNumberStart());
        }
    }

    private void readZip64ExtendedInfo(net.lingala.zip4j.model.LocalFileHeader localFileHeader, net.lingala.zip4j.util.RawIO rawIO) throws net.lingala.zip4j.exception.ZipException {
        net.lingala.zip4j.model.Zip64ExtendedInfo zip64ExtendedInfo;
        if (localFileHeader == null) {
            throw new net.lingala.zip4j.exception.ZipException("file header is null in reading Zip64 Extended Info");
        }
        if (localFileHeader.getExtraDataRecords() == null || localFileHeader.getExtraDataRecords().size() <= 0 || (zip64ExtendedInfo = readZip64ExtendedInfo(localFileHeader.getExtraDataRecords(), rawIO, localFileHeader.getUncompressedSize(), localFileHeader.getCompressedSize(), 0L, 0)) == null) {
            return;
        }
        localFileHeader.setZip64ExtendedInfo(zip64ExtendedInfo);
        if (zip64ExtendedInfo.getUncompressedSize() != -1) {
            localFileHeader.setUncompressedSize(zip64ExtendedInfo.getUncompressedSize());
        }
        if (zip64ExtendedInfo.getCompressedSize() != -1) {
            localFileHeader.setCompressedSize(zip64ExtendedInfo.getCompressedSize());
        }
    }

    private net.lingala.zip4j.model.Zip64ExtendedInfo readZip64ExtendedInfo(java.util.List<net.lingala.zip4j.model.ExtraDataRecord> list, net.lingala.zip4j.util.RawIO rawIO, long j, long j2, long j3, int i) {
        for (net.lingala.zip4j.model.ExtraDataRecord extraDataRecord : list) {
            if (extraDataRecord != null && net.lingala.zip4j.headers.HeaderSignature.ZIP64_EXTRA_FIELD_SIGNATURE.getValue() == extraDataRecord.getHeader()) {
                net.lingala.zip4j.model.Zip64ExtendedInfo zip64ExtendedInfo = new net.lingala.zip4j.model.Zip64ExtendedInfo();
                byte[] data = extraDataRecord.getData();
                if (extraDataRecord.getSizeOfData() <= 0) {
                    return null;
                }
                int i2 = 0;
                if (extraDataRecord.getSizeOfData() > 0 && j == net.lingala.zip4j.util.InternalZipConstants.ZIP_64_SIZE_LIMIT) {
                    zip64ExtendedInfo.setUncompressedSize(rawIO.readLongLittleEndian(data, 0));
                    i2 = 8;
                }
                if (i2 < extraDataRecord.getSizeOfData() && j2 == net.lingala.zip4j.util.InternalZipConstants.ZIP_64_SIZE_LIMIT) {
                    zip64ExtendedInfo.setCompressedSize(rawIO.readLongLittleEndian(data, i2));
                    i2 += 8;
                }
                if (i2 < extraDataRecord.getSizeOfData() && j3 == net.lingala.zip4j.util.InternalZipConstants.ZIP_64_SIZE_LIMIT) {
                    zip64ExtendedInfo.setOffsetLocalHeader(rawIO.readLongLittleEndian(data, i2));
                    i2 += 8;
                }
                if (i2 < extraDataRecord.getSizeOfData() && i == 65535) {
                    zip64ExtendedInfo.setDiskNumberStart(rawIO.readIntLittleEndian(data, i2));
                }
                return zip64ExtendedInfo;
            }
        }
        return null;
    }

    private void setFilePointerToReadZip64EndCentralDirLoc(java.io.RandomAccessFile randomAccessFile, long j) throws java.io.IOException {
        seekInCurrentPart(randomAccessFile, j - 20);
    }

    public net.lingala.zip4j.model.LocalFileHeader readLocalFileHeader(java.io.InputStream inputStream, java.nio.charset.Charset charset) throws java.io.IOException {
        net.lingala.zip4j.model.LocalFileHeader localFileHeader = new net.lingala.zip4j.model.LocalFileHeader();
        byte[] bArr = new byte[4];
        int intLittleEndian = this.rawIO.readIntLittleEndian(inputStream);
        if (intLittleEndian == net.lingala.zip4j.headers.HeaderSignature.TEMPORARY_SPANNING_MARKER.getValue()) {
            intLittleEndian = this.rawIO.readIntLittleEndian(inputStream);
        }
        if (intLittleEndian != net.lingala.zip4j.headers.HeaderSignature.LOCAL_FILE_HEADER.getValue()) {
            return null;
        }
        localFileHeader.setSignature(net.lingala.zip4j.headers.HeaderSignature.LOCAL_FILE_HEADER);
        localFileHeader.setVersionNeededToExtract(this.rawIO.readShortLittleEndian(inputStream));
        byte[] bArr2 = new byte[2];
        if (net.lingala.zip4j.util.Zip4jUtil.readFully(inputStream, bArr2) != 2) {
            throw new net.lingala.zip4j.exception.ZipException("Could not read enough bytes for generalPurposeFlags");
        }
        localFileHeader.setEncrypted(net.lingala.zip4j.util.BitUtils.isBitSet(bArr2[0], 0));
        localFileHeader.setDataDescriptorExists(net.lingala.zip4j.util.BitUtils.isBitSet(bArr2[0], 3));
        boolean z = true;
        localFileHeader.setFileNameUTF8Encoded(net.lingala.zip4j.util.BitUtils.isBitSet(bArr2[1], 3));
        localFileHeader.setGeneralPurposeFlag((byte[]) bArr2.clone());
        localFileHeader.setCompressionMethod(net.lingala.zip4j.model.enums.CompressionMethod.getCompressionMethodFromCode(this.rawIO.readShortLittleEndian(inputStream)));
        localFileHeader.setLastModifiedTime(this.rawIO.readIntLittleEndian(inputStream));
        net.lingala.zip4j.util.Zip4jUtil.readFully(inputStream, bArr);
        localFileHeader.setCrc(this.rawIO.readLongLittleEndian(bArr, 0));
        localFileHeader.setCompressedSize(this.rawIO.readLongLittleEndian(inputStream, 4));
        localFileHeader.setUncompressedSize(this.rawIO.readLongLittleEndian(inputStream, 4));
        int shortLittleEndian = this.rawIO.readShortLittleEndian(inputStream);
        localFileHeader.setFileNameLength(shortLittleEndian);
        localFileHeader.setExtraFieldLength(this.rawIO.readShortLittleEndian(inputStream));
        if (shortLittleEndian > 0) {
            byte[] bArr3 = new byte[shortLittleEndian];
            net.lingala.zip4j.util.Zip4jUtil.readFully(inputStream, bArr3);
            java.lang.String strDecodeStringWithCharset = net.lingala.zip4j.headers.HeaderUtil.decodeStringWithCharset(bArr3, localFileHeader.isFileNameUTF8Encoded(), charset);
            localFileHeader.setFileName(strDecodeStringWithCharset);
            if (!strDecodeStringWithCharset.endsWith("/") && !strDecodeStringWithCharset.endsWith("\\")) {
                z = false;
            }
            localFileHeader.setDirectory(z);
            readExtraDataRecords(inputStream, localFileHeader);
            readZip64ExtendedInfo(localFileHeader, this.rawIO);
            readAesExtraDataRecord(localFileHeader, this.rawIO);
            if (localFileHeader.isEncrypted() && localFileHeader.getEncryptionMethod() != net.lingala.zip4j.model.enums.EncryptionMethod.AES) {
                if (net.lingala.zip4j.util.BitUtils.isBitSet(localFileHeader.getGeneralPurposeFlag()[0], 6)) {
                    localFileHeader.setEncryptionMethod(net.lingala.zip4j.model.enums.EncryptionMethod.ZIP_STANDARD_VARIANT_STRONG);
                    return localFileHeader;
                }
                localFileHeader.setEncryptionMethod(net.lingala.zip4j.model.enums.EncryptionMethod.ZIP_STANDARD);
            }
            return localFileHeader;
        }
        throw new net.lingala.zip4j.exception.ZipException("Invalid entry name in local file header");
    }

    public net.lingala.zip4j.model.DataDescriptor readDataDescriptor(java.io.InputStream inputStream, boolean z) throws java.io.IOException {
        net.lingala.zip4j.model.DataDescriptor dataDescriptor = new net.lingala.zip4j.model.DataDescriptor();
        byte[] bArr = new byte[4];
        net.lingala.zip4j.util.Zip4jUtil.readFully(inputStream, bArr);
        long longLittleEndian = this.rawIO.readLongLittleEndian(bArr, 0);
        if (longLittleEndian == net.lingala.zip4j.headers.HeaderSignature.EXTRA_DATA_RECORD.getValue()) {
            dataDescriptor.setSignature(net.lingala.zip4j.headers.HeaderSignature.EXTRA_DATA_RECORD);
            net.lingala.zip4j.util.Zip4jUtil.readFully(inputStream, bArr);
            dataDescriptor.setCrc(this.rawIO.readLongLittleEndian(bArr, 0));
        } else {
            dataDescriptor.setCrc(longLittleEndian);
        }
        if (z) {
            dataDescriptor.setCompressedSize(this.rawIO.readLongLittleEndian(inputStream));
            dataDescriptor.setUncompressedSize(this.rawIO.readLongLittleEndian(inputStream));
            return dataDescriptor;
        }
        dataDescriptor.setCompressedSize(this.rawIO.readIntLittleEndian(inputStream));
        dataDescriptor.setUncompressedSize(this.rawIO.readIntLittleEndian(inputStream));
        return dataDescriptor;
    }

    private void readAesExtraDataRecord(net.lingala.zip4j.model.AbstractFileHeader abstractFileHeader, net.lingala.zip4j.util.RawIO rawIO) throws net.lingala.zip4j.exception.ZipException {
        net.lingala.zip4j.model.AESExtraDataRecord aesExtraDataRecord;
        if (abstractFileHeader.getExtraDataRecords() == null || abstractFileHeader.getExtraDataRecords().size() <= 0 || (aesExtraDataRecord = readAesExtraDataRecord(abstractFileHeader.getExtraDataRecords(), rawIO)) == null) {
            return;
        }
        abstractFileHeader.setAesExtraDataRecord(aesExtraDataRecord);
        abstractFileHeader.setEncryptionMethod(net.lingala.zip4j.model.enums.EncryptionMethod.AES);
    }

    private net.lingala.zip4j.model.AESExtraDataRecord readAesExtraDataRecord(java.util.List<net.lingala.zip4j.model.ExtraDataRecord> list, net.lingala.zip4j.util.RawIO rawIO) throws net.lingala.zip4j.exception.ZipException {
        if (list == null) {
            return null;
        }
        for (net.lingala.zip4j.model.ExtraDataRecord extraDataRecord : list) {
            if (extraDataRecord != null && extraDataRecord.getHeader() == net.lingala.zip4j.headers.HeaderSignature.AES_EXTRA_DATA_RECORD.getValue()) {
                byte[] data = extraDataRecord.getData();
                if (data == null || data.length != 7) {
                    throw new net.lingala.zip4j.exception.ZipException("corrupt AES extra data records");
                }
                net.lingala.zip4j.model.AESExtraDataRecord aESExtraDataRecord = new net.lingala.zip4j.model.AESExtraDataRecord();
                aESExtraDataRecord.setSignature(net.lingala.zip4j.headers.HeaderSignature.AES_EXTRA_DATA_RECORD);
                aESExtraDataRecord.setDataSize(extraDataRecord.getSizeOfData());
                byte[] data2 = extraDataRecord.getData();
                aESExtraDataRecord.setAesVersion(net.lingala.zip4j.model.enums.AesVersion.getFromVersionNumber(rawIO.readShortLittleEndian(data2, 0)));
                byte[] bArr = new byte[2];
                java.lang.System.arraycopy(data2, 2, bArr, 0, 2);
                aESExtraDataRecord.setVendorID(new java.lang.String(bArr));
                aESExtraDataRecord.setAesKeyStrength(net.lingala.zip4j.model.enums.AesKeyStrength.getAesKeyStrengthFromRawCode(data2[4] & 255));
                aESExtraDataRecord.setCompressionMethod(net.lingala.zip4j.model.enums.CompressionMethod.getCompressionMethodFromCode(rawIO.readShortLittleEndian(data2, 5)));
                return aESExtraDataRecord;
            }
        }
        return null;
    }

    private long getNumberOfEntriesInCentralDirectory(net.lingala.zip4j.model.ZipModel zipModel) {
        if (zipModel.isZip64Format()) {
            return zipModel.getZip64EndOfCentralDirectoryRecord().getTotalNumberOfEntriesInCentralDirectory();
        }
        return zipModel.getEndOfCentralDirectoryRecord().getTotalNumberOfEntriesInCentralDirectory();
    }

    private long locateOffsetOfEndOfCentralDirectory(java.io.RandomAccessFile randomAccessFile) throws java.io.IOException {
        long length = randomAccessFile.length();
        if (length < 22) {
            throw new net.lingala.zip4j.exception.ZipException("Zip file size less than size of zip headers. Probably not a zip file.");
        }
        long j = length - 22;
        seekInCurrentPart(randomAccessFile, j);
        return ((long) this.rawIO.readIntLittleEndian(randomAccessFile)) == net.lingala.zip4j.headers.HeaderSignature.END_OF_CENTRAL_DIRECTORY.getValue() ? j : locateOffsetOfEndOfCentralDirectoryByReverseSeek(randomAccessFile);
    }

    private long locateOffsetOfEndOfCentralDirectoryByReverseSeek(java.io.RandomAccessFile randomAccessFile) throws java.io.IOException {
        long length = randomAccessFile.length() - 22;
        long length2 = randomAccessFile.length();
        long length3 = tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_TOP_BACK_CENTER;
        if (length2 < tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_TOP_BACK_CENTER) {
            length3 = randomAccessFile.length();
        }
        while (length3 > 0 && length > 0) {
            length--;
            seekInCurrentPart(randomAccessFile, length);
            if (this.rawIO.readIntLittleEndian(randomAccessFile) == net.lingala.zip4j.headers.HeaderSignature.END_OF_CENTRAL_DIRECTORY.getValue()) {
                return length;
            }
            length3--;
        }
        throw new net.lingala.zip4j.exception.ZipException("Zip headers not found. Probably not a zip file");
    }

    private void seekInCurrentPart(java.io.RandomAccessFile randomAccessFile, long j) throws java.io.IOException {
        if (randomAccessFile instanceof net.lingala.zip4j.io.inputstream.NumberedSplitRandomAccessFile) {
            ((net.lingala.zip4j.io.inputstream.NumberedSplitRandomAccessFile) randomAccessFile).seekInCurrentPart(j);
        } else {
            randomAccessFile.seek(j);
        }
    }

    private java.lang.String readZipComment(java.io.RandomAccessFile randomAccessFile, int i, java.nio.charset.Charset charset) {
        if (i <= 0) {
            return null;
        }
        try {
            byte[] bArr = new byte[i];
            randomAccessFile.readFully(bArr);
            if (charset == null) {
                charset = net.lingala.zip4j.util.InternalZipConstants.ZIP4J_DEFAULT_CHARSET;
            }
            return net.lingala.zip4j.headers.HeaderUtil.decodeStringWithCharset(bArr, false, charset);
        } catch (java.io.IOException unused) {
            return null;
        }
    }

    public boolean isDirectory(byte[] bArr, java.lang.String str) {
        byte b = bArr[0];
        if (b != 0 && net.lingala.zip4j.util.BitUtils.isBitSet(b, 4)) {
            return true;
        }
        byte b2 = bArr[3];
        if (b2 == 0 || !net.lingala.zip4j.util.BitUtils.isBitSet(b2, 6)) {
            return str != null && (str.endsWith("/") || str.endsWith("\\"));
        }
        return true;
    }
}
