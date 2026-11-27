package net.lingala.zip4j.util;

/* JADX INFO: loaded from: classes2.dex */
public class UnzipUtil {
    public static net.lingala.zip4j.io.inputstream.ZipInputStream createZipInputStream(net.lingala.zip4j.model.ZipModel zipModel, net.lingala.zip4j.model.FileHeader fileHeader, char[] cArr) throws java.io.IOException {
        net.lingala.zip4j.io.inputstream.SplitFileInputStream splitFileInputStreamCreateSplitInputStream;
        try {
            splitFileInputStreamCreateSplitInputStream = createSplitInputStream(zipModel);
            try {
                splitFileInputStreamCreateSplitInputStream.prepareExtractionForFileHeader(fileHeader);
                net.lingala.zip4j.io.inputstream.ZipInputStream zipInputStream = new net.lingala.zip4j.io.inputstream.ZipInputStream(splitFileInputStreamCreateSplitInputStream, cArr);
                if (zipInputStream.getNextEntry(fileHeader, false) != null) {
                    return zipInputStream;
                }
                throw new net.lingala.zip4j.exception.ZipException("Could not locate local file header for corresponding file header");
            } catch (java.io.IOException e) {
                e = e;
                if (splitFileInputStreamCreateSplitInputStream != null) {
                    splitFileInputStreamCreateSplitInputStream.close();
                }
                throw e;
            }
        } catch (java.io.IOException e2) {
            e = e2;
            splitFileInputStreamCreateSplitInputStream = null;
        }
    }

    public static void applyFileAttributes(net.lingala.zip4j.model.FileHeader fileHeader, java.io.File file) {
        try {
            java.nio.file.Path path = file.toPath();
            net.lingala.zip4j.util.FileUtils.setFileAttributes(path, fileHeader.getExternalFileAttributes());
            net.lingala.zip4j.util.FileUtils.setFileLastModifiedTime(path, fileHeader.getLastModifiedTime());
        } catch (java.lang.NoSuchMethodError unused) {
            net.lingala.zip4j.util.FileUtils.setFileLastModifiedTimeWithoutNio(file, fileHeader.getLastModifiedTime());
        }
    }

    public static net.lingala.zip4j.io.inputstream.SplitFileInputStream createSplitInputStream(net.lingala.zip4j.model.ZipModel zipModel) throws java.io.IOException {
        if (zipModel.getZipFile().getName().endsWith(net.lingala.zip4j.util.InternalZipConstants.SEVEN_ZIP_SPLIT_FILE_EXTENSION_PATTERN)) {
            return new net.lingala.zip4j.io.inputstream.NumberedSplitFileInputStream(zipModel.getZipFile());
        }
        return new net.lingala.zip4j.io.inputstream.ZipStandardSplitFileInputStream(zipModel.getZipFile(), zipModel.isSplitArchive(), zipModel.getEndOfCentralDirectoryRecord().getNumberOfThisDisk());
    }
}
