package net.lingala.zip4j.headers;

/* JADX INFO: loaded from: classes2.dex */
public class FileHeaderFactory {
    public net.lingala.zip4j.model.FileHeader generateFileHeader(net.lingala.zip4j.model.ZipParameters zipParameters, boolean z, int i, java.nio.charset.Charset charset, net.lingala.zip4j.util.RawIO rawIO) throws net.lingala.zip4j.exception.ZipException {
        net.lingala.zip4j.model.FileHeader fileHeader = new net.lingala.zip4j.model.FileHeader();
        fileHeader.setSignature(net.lingala.zip4j.headers.HeaderSignature.CENTRAL_DIRECTORY);
        fileHeader.setVersionMadeBy(net.lingala.zip4j.util.ZipVersionUtils.determineVersionMadeBy(zipParameters, rawIO));
        fileHeader.setVersionNeededToExtract(net.lingala.zip4j.util.ZipVersionUtils.determineVersionNeededToExtract(zipParameters).getCode());
        if (zipParameters.isEncryptFiles() && zipParameters.getEncryptionMethod() == net.lingala.zip4j.model.enums.EncryptionMethod.AES) {
            fileHeader.setCompressionMethod(net.lingala.zip4j.model.enums.CompressionMethod.AES_INTERNAL_ONLY);
            fileHeader.setAesExtraDataRecord(generateAESExtraDataRecord(zipParameters));
            fileHeader.setExtraFieldLength(fileHeader.getExtraFieldLength() + 11);
        } else {
            fileHeader.setCompressionMethod(zipParameters.getCompressionMethod());
        }
        if (zipParameters.isEncryptFiles()) {
            if (zipParameters.getEncryptionMethod() == null || zipParameters.getEncryptionMethod() == net.lingala.zip4j.model.enums.EncryptionMethod.NONE) {
                throw new net.lingala.zip4j.exception.ZipException("Encryption method has to be set when encryptFiles flag is set in zip parameters");
            }
            fileHeader.setEncrypted(true);
            fileHeader.setEncryptionMethod(zipParameters.getEncryptionMethod());
        }
        java.lang.String strValidateAndGetFileName = validateAndGetFileName(zipParameters.getFileNameInZip());
        fileHeader.setFileName(strValidateAndGetFileName);
        fileHeader.setFileNameLength(determineFileNameLength(strValidateAndGetFileName, charset));
        if (!z) {
            i = 0;
        }
        fileHeader.setDiskNumberStart(i);
        fileHeader.setLastModifiedTime(net.lingala.zip4j.util.Zip4jUtil.epochToExtendedDosTime(zipParameters.getLastModifiedFileTime()));
        boolean zIsZipEntryDirectory = net.lingala.zip4j.util.FileUtils.isZipEntryDirectory(strValidateAndGetFileName);
        fileHeader.setDirectory(zIsZipEntryDirectory);
        fileHeader.setExternalFileAttributes(net.lingala.zip4j.util.FileUtils.getDefaultFileAttributes(zIsZipEntryDirectory));
        if (zipParameters.isWriteExtendedLocalFileHeader() && zipParameters.getEntrySize() == -1) {
            fileHeader.setUncompressedSize(0L);
        } else {
            fileHeader.setUncompressedSize(zipParameters.getEntrySize());
        }
        if (zipParameters.isEncryptFiles() && zipParameters.getEncryptionMethod() == net.lingala.zip4j.model.enums.EncryptionMethod.ZIP_STANDARD) {
            fileHeader.setCrc(zipParameters.getEntryCRC());
        }
        fileHeader.setGeneralPurposeFlag(determineGeneralPurposeBitFlag(fileHeader.isEncrypted(), zipParameters, charset));
        fileHeader.setDataDescriptorExists(zipParameters.isWriteExtendedLocalFileHeader());
        fileHeader.setFileComment(zipParameters.getFileComment());
        return fileHeader;
    }

    public net.lingala.zip4j.model.LocalFileHeader generateLocalFileHeader(net.lingala.zip4j.model.FileHeader fileHeader) {
        net.lingala.zip4j.model.LocalFileHeader localFileHeader = new net.lingala.zip4j.model.LocalFileHeader();
        localFileHeader.setSignature(net.lingala.zip4j.headers.HeaderSignature.LOCAL_FILE_HEADER);
        localFileHeader.setVersionNeededToExtract(fileHeader.getVersionNeededToExtract());
        localFileHeader.setCompressionMethod(fileHeader.getCompressionMethod());
        localFileHeader.setLastModifiedTime(fileHeader.getLastModifiedTime());
        localFileHeader.setUncompressedSize(fileHeader.getUncompressedSize());
        localFileHeader.setFileNameLength(fileHeader.getFileNameLength());
        localFileHeader.setFileName(fileHeader.getFileName());
        localFileHeader.setEncrypted(fileHeader.isEncrypted());
        localFileHeader.setEncryptionMethod(fileHeader.getEncryptionMethod());
        localFileHeader.setAesExtraDataRecord(fileHeader.getAesExtraDataRecord());
        localFileHeader.setCrc(fileHeader.getCrc());
        localFileHeader.setCompressedSize(fileHeader.getCompressedSize());
        localFileHeader.setGeneralPurposeFlag((byte[]) fileHeader.getGeneralPurposeFlag().clone());
        localFileHeader.setDataDescriptorExists(fileHeader.isDataDescriptorExists());
        localFileHeader.setExtraFieldLength(fileHeader.getExtraFieldLength());
        return localFileHeader;
    }

    private byte[] determineGeneralPurposeBitFlag(boolean z, net.lingala.zip4j.model.ZipParameters zipParameters, java.nio.charset.Charset charset) {
        byte[] bArr = new byte[2];
        bArr[0] = generateFirstGeneralPurposeByte(z, zipParameters);
        if (charset != null && !net.lingala.zip4j.util.InternalZipConstants.CHARSET_UTF_8.equals(charset)) {
            return bArr;
        }
        bArr[1] = net.lingala.zip4j.util.BitUtils.setBit(bArr[1], 3);
        return bArr;
    }

    private byte generateFirstGeneralPurposeByte(boolean z, net.lingala.zip4j.model.ZipParameters zipParameters) {
        byte bit = z ? net.lingala.zip4j.util.BitUtils.setBit((byte) 0, 0) : (byte) 0;
        if (net.lingala.zip4j.model.enums.CompressionMethod.DEFLATE.equals(zipParameters.getCompressionMethod())) {
            if (net.lingala.zip4j.model.enums.CompressionLevel.NORMAL.equals(zipParameters.getCompressionLevel())) {
                bit = net.lingala.zip4j.util.BitUtils.unsetBit(net.lingala.zip4j.util.BitUtils.unsetBit(bit, 1), 2);
            } else if (net.lingala.zip4j.model.enums.CompressionLevel.MAXIMUM.equals(zipParameters.getCompressionLevel())) {
                bit = net.lingala.zip4j.util.BitUtils.unsetBit(net.lingala.zip4j.util.BitUtils.setBit(bit, 1), 2);
            } else if (net.lingala.zip4j.model.enums.CompressionLevel.FAST.equals(zipParameters.getCompressionLevel())) {
                bit = net.lingala.zip4j.util.BitUtils.setBit(net.lingala.zip4j.util.BitUtils.unsetBit(bit, 1), 2);
            } else if (net.lingala.zip4j.model.enums.CompressionLevel.FASTEST.equals(zipParameters.getCompressionLevel()) || net.lingala.zip4j.model.enums.CompressionLevel.ULTRA.equals(zipParameters.getCompressionLevel())) {
                bit = net.lingala.zip4j.util.BitUtils.setBit(net.lingala.zip4j.util.BitUtils.setBit(bit, 1), 2);
            }
        }
        return zipParameters.isWriteExtendedLocalFileHeader() ? net.lingala.zip4j.util.BitUtils.setBit(bit, 3) : bit;
    }

    private java.lang.String validateAndGetFileName(java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        if (net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            return str;
        }
        throw new net.lingala.zip4j.exception.ZipException("fileNameInZip is null or empty");
    }

    private net.lingala.zip4j.model.AESExtraDataRecord generateAESExtraDataRecord(net.lingala.zip4j.model.ZipParameters zipParameters) throws net.lingala.zip4j.exception.ZipException {
        net.lingala.zip4j.model.AESExtraDataRecord aESExtraDataRecord = new net.lingala.zip4j.model.AESExtraDataRecord();
        if (zipParameters.getAesVersion() != null) {
            aESExtraDataRecord.setAesVersion(zipParameters.getAesVersion());
        }
        if (zipParameters.getAesKeyStrength() == net.lingala.zip4j.model.enums.AesKeyStrength.KEY_STRENGTH_128) {
            aESExtraDataRecord.setAesKeyStrength(net.lingala.zip4j.model.enums.AesKeyStrength.KEY_STRENGTH_128);
        } else if (zipParameters.getAesKeyStrength() == net.lingala.zip4j.model.enums.AesKeyStrength.KEY_STRENGTH_192) {
            aESExtraDataRecord.setAesKeyStrength(net.lingala.zip4j.model.enums.AesKeyStrength.KEY_STRENGTH_192);
        } else if (zipParameters.getAesKeyStrength() == net.lingala.zip4j.model.enums.AesKeyStrength.KEY_STRENGTH_256) {
            aESExtraDataRecord.setAesKeyStrength(net.lingala.zip4j.model.enums.AesKeyStrength.KEY_STRENGTH_256);
        } else {
            throw new net.lingala.zip4j.exception.ZipException("invalid AES key strength");
        }
        aESExtraDataRecord.setCompressionMethod(zipParameters.getCompressionMethod());
        return aESExtraDataRecord;
    }

    private int determineFileNameLength(java.lang.String str, java.nio.charset.Charset charset) {
        return net.lingala.zip4j.headers.HeaderUtil.getBytesFromString(str, charset).length;
    }
}
