package net.lingala.zip4j.headers;

/* JADX INFO: loaded from: classes2.dex */
public class HeaderUtil {
    public static net.lingala.zip4j.model.FileHeader getFileHeader(net.lingala.zip4j.model.ZipModel zipModel, java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        net.lingala.zip4j.model.FileHeader fileHeaderWithExactMatch = getFileHeaderWithExactMatch(zipModel, str);
        if (fileHeaderWithExactMatch != null) {
            return fileHeaderWithExactMatch;
        }
        java.lang.String strReplaceAll = str.replaceAll("\\\\", "/");
        net.lingala.zip4j.model.FileHeader fileHeaderWithExactMatch2 = getFileHeaderWithExactMatch(zipModel, strReplaceAll);
        return fileHeaderWithExactMatch2 == null ? getFileHeaderWithExactMatch(zipModel, strReplaceAll.replaceAll("/", "\\\\")) : fileHeaderWithExactMatch2;
    }

    public static java.lang.String decodeStringWithCharset(byte[] bArr, boolean z, java.nio.charset.Charset charset) {
        if (charset != null) {
            return new java.lang.String(bArr, charset);
        }
        if (z) {
            return new java.lang.String(bArr, net.lingala.zip4j.util.InternalZipConstants.CHARSET_UTF_8);
        }
        try {
            return new java.lang.String(bArr, net.lingala.zip4j.util.InternalZipConstants.ZIP_STANDARD_CHARSET_NAME);
        } catch (java.io.UnsupportedEncodingException unused) {
            return new java.lang.String(bArr);
        }
    }

    public static byte[] getBytesFromString(java.lang.String str, java.nio.charset.Charset charset) {
        if (charset == null) {
            return str.getBytes(net.lingala.zip4j.util.InternalZipConstants.ZIP4J_DEFAULT_CHARSET);
        }
        return str.getBytes(charset);
    }

    public static long getOffsetStartOfCentralDirectory(net.lingala.zip4j.model.ZipModel zipModel) {
        if (zipModel.isZip64Format()) {
            return zipModel.getZip64EndOfCentralDirectoryRecord().getOffsetStartCentralDirectoryWRTStartDiskNumber();
        }
        return zipModel.getEndOfCentralDirectoryRecord().getOffsetOfStartOfCentralDirectory();
    }

    public static java.util.List<net.lingala.zip4j.model.FileHeader> getFileHeadersUnderDirectory(java.util.List<net.lingala.zip4j.model.FileHeader> list, java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (net.lingala.zip4j.model.FileHeader fileHeader : list) {
            if (fileHeader.getFileName().startsWith(str)) {
                arrayList.add(fileHeader);
            }
        }
        return arrayList;
    }

    public static long getTotalUncompressedSizeOfAllFileHeaders(java.util.List<net.lingala.zip4j.model.FileHeader> list) {
        long uncompressedSize;
        long j = 0;
        for (net.lingala.zip4j.model.FileHeader fileHeader : list) {
            if (fileHeader.getZip64ExtendedInfo() != null && fileHeader.getZip64ExtendedInfo().getUncompressedSize() > 0) {
                uncompressedSize = fileHeader.getZip64ExtendedInfo().getUncompressedSize();
            } else {
                uncompressedSize = fileHeader.getUncompressedSize();
            }
            j += uncompressedSize;
        }
        return j;
    }

    private static net.lingala.zip4j.model.FileHeader getFileHeaderWithExactMatch(net.lingala.zip4j.model.ZipModel zipModel, java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        if (zipModel == null) {
            throw new net.lingala.zip4j.exception.ZipException("zip model is null, cannot determine file header with exact match for fileName: " + str);
        }
        if (!net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new net.lingala.zip4j.exception.ZipException("file name is null, cannot determine file header with exact match for fileName: " + str);
        }
        if (zipModel.getCentralDirectory() == null) {
            throw new net.lingala.zip4j.exception.ZipException("central directory is null, cannot determine file header with exact match for fileName: " + str);
        }
        if (zipModel.getCentralDirectory().getFileHeaders() == null) {
            throw new net.lingala.zip4j.exception.ZipException("file Headers are null, cannot determine file header with exact match for fileName: " + str);
        }
        if (zipModel.getCentralDirectory().getFileHeaders().size() == 0) {
            return null;
        }
        for (net.lingala.zip4j.model.FileHeader fileHeader : zipModel.getCentralDirectory().getFileHeaders()) {
            java.lang.String fileName = fileHeader.getFileName();
            if (net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(fileName) && str.equals(fileName)) {
                return fileHeader;
            }
        }
        return null;
    }
}
