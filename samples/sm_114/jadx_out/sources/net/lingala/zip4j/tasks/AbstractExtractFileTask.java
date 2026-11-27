package net.lingala.zip4j.tasks;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractExtractFileTask<T> extends net.lingala.zip4j.tasks.AsyncZipTask<T> {
    private final net.lingala.zip4j.model.UnzipParameters unzipParameters;
    private final net.lingala.zip4j.model.ZipModel zipModel;

    public AbstractExtractFileTask(net.lingala.zip4j.model.ZipModel zipModel, net.lingala.zip4j.model.UnzipParameters unzipParameters, net.lingala.zip4j.tasks.AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(asyncTaskParameters);
        this.zipModel = zipModel;
        this.unzipParameters = unzipParameters;
    }

    protected void extractFile(net.lingala.zip4j.io.inputstream.ZipInputStream zipInputStream, net.lingala.zip4j.model.FileHeader fileHeader, java.lang.String str, java.lang.String str2, net.lingala.zip4j.progress.ProgressMonitor progressMonitor, byte[] bArr) throws java.lang.Exception {
        boolean zIsSymbolicLink = isSymbolicLink(fileHeader);
        if (!zIsSymbolicLink || this.unzipParameters.isExtractSymbolicLinks()) {
            if (!str.endsWith(net.lingala.zip4j.util.InternalZipConstants.FILE_SEPARATOR)) {
                str = str + net.lingala.zip4j.util.InternalZipConstants.FILE_SEPARATOR;
            }
            java.io.File fileDetermineOutputFile = determineOutputFile(fileHeader, str, str2);
            progressMonitor.setFileName(fileDetermineOutputFile.getAbsolutePath());
            assertCanonicalPathsAreSame(fileDetermineOutputFile, str, fileHeader);
            verifyNextEntry(zipInputStream, fileHeader);
            if (fileHeader.isDirectory()) {
                if (!fileDetermineOutputFile.exists() && !fileDetermineOutputFile.mkdirs()) {
                    throw new net.lingala.zip4j.exception.ZipException("Could not create directory: " + fileDetermineOutputFile);
                }
            } else if (zIsSymbolicLink) {
                createSymLink(zipInputStream, fileHeader, fileDetermineOutputFile, progressMonitor);
            } else {
                checkOutputDirectoryStructure(fileDetermineOutputFile);
                unzipFile(zipInputStream, fileDetermineOutputFile, progressMonitor, bArr);
            }
            if (zIsSymbolicLink) {
                return;
            }
            net.lingala.zip4j.util.UnzipUtil.applyFileAttributes(fileHeader, fileDetermineOutputFile);
        }
    }

    private void assertCanonicalPathsAreSame(java.io.File file, java.lang.String str, net.lingala.zip4j.model.FileHeader fileHeader) throws java.io.IOException {
        java.lang.String canonicalPath = file.getCanonicalPath();
        if (file.isDirectory() && !canonicalPath.endsWith(net.lingala.zip4j.util.InternalZipConstants.FILE_SEPARATOR)) {
            canonicalPath = canonicalPath + net.lingala.zip4j.util.InternalZipConstants.FILE_SEPARATOR;
        }
        java.lang.String canonicalPath2 = new java.io.File(str).getCanonicalPath();
        if (!canonicalPath2.endsWith(net.lingala.zip4j.util.InternalZipConstants.FILE_SEPARATOR)) {
            canonicalPath2 = canonicalPath2 + net.lingala.zip4j.util.InternalZipConstants.FILE_SEPARATOR;
        }
        if (canonicalPath.startsWith(canonicalPath2)) {
            return;
        }
        throw new net.lingala.zip4j.exception.ZipException("illegal file name that breaks out of the target directory: " + fileHeader.getFileName());
    }

    private boolean isSymbolicLink(net.lingala.zip4j.model.FileHeader fileHeader) {
        byte[] externalFileAttributes = fileHeader.getExternalFileAttributes();
        if (externalFileAttributes == null || externalFileAttributes.length < 4) {
            return false;
        }
        return net.lingala.zip4j.util.BitUtils.isBitSet(externalFileAttributes[3], 5);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x002d  */
    private void unzipFile(net.lingala.zip4j.io.inputstream.ZipInputStream zipInputStream, java.io.File file, net.lingala.zip4j.progress.ProgressMonitor progressMonitor, byte[] bArr) throws java.lang.Exception {
        try {
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
            while (true) {
                try {
                    int i = zipInputStream.read(bArr);
                    if (i != -1) {
                        fileOutputStream.write(bArr, 0, i);
                        progressMonitor.updateWorkCompleted(i);
                        verifyIfTaskIsCancelled();
                    } else {
                        fileOutputStream.close();
                        return;
                    }
                } catch (java.lang.Throwable th) {
                    try {
                        fileOutputStream.close();
                    } catch (java.lang.Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
                if (file.exists()) {
                    file.delete();
                }
                throw e;
            }
        } catch (java.lang.Exception e) {
            if (file.exists()) {
                file.delete();
            }
            throw e;
        }
    }

    private void createSymLink(net.lingala.zip4j.io.inputstream.ZipInputStream zipInputStream, net.lingala.zip4j.model.FileHeader fileHeader, java.io.File file, net.lingala.zip4j.progress.ProgressMonitor progressMonitor) throws java.io.IOException {
        java.lang.String str = new java.lang.String(readCompleteEntry(zipInputStream, fileHeader, progressMonitor));
        if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
            throw new net.lingala.zip4j.exception.ZipException("Could not create parent directories");
        }
        try {
            java.nio.file.Path path = java.nio.file.Paths.get(str, new java.lang.String[0]);
            if (file.exists() && !file.delete()) {
                throw new net.lingala.zip4j.exception.ZipException("Could not delete existing symlink " + file);
            }
            java.nio.file.Files.createSymbolicLink(file.toPath(), path, new java.nio.file.attribute.FileAttribute[0]);
        } catch (java.lang.NoSuchMethodError unused) {
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
            try {
                fileOutputStream.write(str.getBytes());
                fileOutputStream.close();
            } catch (java.lang.Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (java.lang.Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    private byte[] readCompleteEntry(net.lingala.zip4j.io.inputstream.ZipInputStream zipInputStream, net.lingala.zip4j.model.FileHeader fileHeader, net.lingala.zip4j.progress.ProgressMonitor progressMonitor) throws java.io.IOException {
        int uncompressedSize = (int) fileHeader.getUncompressedSize();
        byte[] bArr = new byte[uncompressedSize];
        if (zipInputStream.read(bArr) != uncompressedSize) {
            throw new net.lingala.zip4j.exception.ZipException("Could not read complete entry");
        }
        progressMonitor.updateWorkCompleted(uncompressedSize);
        return bArr;
    }

    private void verifyNextEntry(net.lingala.zip4j.io.inputstream.ZipInputStream zipInputStream, net.lingala.zip4j.model.FileHeader fileHeader) throws java.io.IOException {
        if (net.lingala.zip4j.util.BitUtils.isBitSet(fileHeader.getGeneralPurposeFlag()[0], 6)) {
            throw new net.lingala.zip4j.exception.ZipException("Entry with name " + fileHeader.getFileName() + " is encrypted with Strong Encryption. Zip4j does not support Strong Encryption, as this is patented.");
        }
        net.lingala.zip4j.model.LocalFileHeader nextEntry = zipInputStream.getNextEntry(fileHeader, false);
        if (nextEntry == null) {
            throw new net.lingala.zip4j.exception.ZipException("Could not read corresponding local file header for file header: " + fileHeader.getFileName());
        }
        if (!fileHeader.getFileName().equals(nextEntry.getFileName())) {
            throw new net.lingala.zip4j.exception.ZipException("File header and local file header mismatch");
        }
    }

    private void checkOutputDirectoryStructure(java.io.File file) throws net.lingala.zip4j.exception.ZipException {
        if (file.getParentFile().exists() || file.getParentFile().mkdirs()) {
            return;
        }
        throw new net.lingala.zip4j.exception.ZipException("Unable to create parent directories: " + file.getParentFile());
    }

    private java.io.File determineOutputFile(net.lingala.zip4j.model.FileHeader fileHeader, java.lang.String str, java.lang.String str2) {
        java.lang.String fileName = fileHeader.getFileName();
        if (!net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(str2)) {
            str2 = fileName;
        }
        return new java.io.File(str, getFileNameWithSystemFileSeparators(str2));
    }

    private java.lang.String getFileNameWithSystemFileSeparators(java.lang.String str) {
        return str.replaceAll(":\\\\", "_").replaceAll("[/\\\\]", java.util.regex.Matcher.quoteReplacement(net.lingala.zip4j.util.InternalZipConstants.FILE_SEPARATOR));
    }

    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    protected net.lingala.zip4j.progress.ProgressMonitor.Task getTask() {
        return net.lingala.zip4j.progress.ProgressMonitor.Task.EXTRACT_ENTRY;
    }

    public net.lingala.zip4j.model.ZipModel getZipModel() {
        return this.zipModel;
    }
}
