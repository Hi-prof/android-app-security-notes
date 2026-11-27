package net.lingala.zip4j.util;

/* JADX INFO: loaded from: classes2.dex */
public class ZipVersionUtils {
    public static int determineVersionMadeBy(net.lingala.zip4j.model.ZipParameters zipParameters, net.lingala.zip4j.util.RawIO rawIO) {
        byte[] bArr = {net.lingala.zip4j.headers.VersionMadeBy.SPECIFICATION_VERSION.getCode(), net.lingala.zip4j.headers.VersionMadeBy.UNIX.getCode()};
        if (net.lingala.zip4j.util.FileUtils.isWindows() && !zipParameters.isUnixMode()) {
            bArr[1] = net.lingala.zip4j.headers.VersionMadeBy.WINDOWS.getCode();
        }
        return rawIO.readShortLittleEndian(bArr, 0);
    }

    public static net.lingala.zip4j.headers.VersionNeededToExtract determineVersionNeededToExtract(net.lingala.zip4j.model.ZipParameters zipParameters) {
        net.lingala.zip4j.headers.VersionNeededToExtract versionNeededToExtract = net.lingala.zip4j.headers.VersionNeededToExtract.DEFAULT;
        if (zipParameters.getCompressionMethod() == net.lingala.zip4j.model.enums.CompressionMethod.DEFLATE) {
            versionNeededToExtract = net.lingala.zip4j.headers.VersionNeededToExtract.DEFLATE_COMPRESSED;
        }
        if (zipParameters.getEntrySize() > net.lingala.zip4j.util.InternalZipConstants.ZIP_64_SIZE_LIMIT) {
            versionNeededToExtract = net.lingala.zip4j.headers.VersionNeededToExtract.ZIP_64_FORMAT;
        }
        return (zipParameters.isEncryptFiles() && zipParameters.getEncryptionMethod().equals(net.lingala.zip4j.model.enums.EncryptionMethod.AES)) ? net.lingala.zip4j.headers.VersionNeededToExtract.AES_ENCRYPTED : versionNeededToExtract;
    }
}
