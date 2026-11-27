package net.lingala.zip4j.tasks;

/* JADX INFO: loaded from: classes2.dex */
public class ExtractFileTask extends net.lingala.zip4j.tasks.AbstractExtractFileTask<net.lingala.zip4j.tasks.ExtractFileTask.ExtractFileTaskParameters> {
    private char[] password;
    private net.lingala.zip4j.io.inputstream.SplitFileInputStream splitInputStream;

    public ExtractFileTask(net.lingala.zip4j.model.ZipModel zipModel, char[] cArr, net.lingala.zip4j.model.UnzipParameters unzipParameters, net.lingala.zip4j.tasks.AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(zipModel, unzipParameters, asyncTaskParameters);
        this.password = cArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code duplicated, block: B:36:0x006b  */
    /* JADX WARN: Code duplicated, block: B:50:? A[SYNTHETIC] */
    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    public void executeTask(net.lingala.zip4j.tasks.ExtractFileTask.ExtractFileTaskParameters extractFileTaskParameters, net.lingala.zip4j.progress.ProgressMonitor progressMonitor) throws java.lang.Throwable {
        net.lingala.zip4j.tasks.ExtractFileTask extractFileTask;
        java.lang.Throwable th;
        net.lingala.zip4j.io.inputstream.SplitFileInputStream splitFileInputStream;
        java.util.List<net.lingala.zip4j.model.FileHeader> fileHeadersToExtract = getFileHeadersToExtract(extractFileTaskParameters.fileToExtract);
        try {
            try {
                net.lingala.zip4j.io.inputstream.ZipInputStream zipInputStreamCreateZipInputStream = createZipInputStream(extractFileTaskParameters.zip4jConfig);
                try {
                    byte[] bArr = new byte[extractFileTaskParameters.zip4jConfig.getBufferSize()];
                    for (net.lingala.zip4j.model.FileHeader fileHeader : fileHeadersToExtract) {
                        this.splitInputStream.prepareExtractionForFileHeader(fileHeader);
                        extractFileTask = this;
                        net.lingala.zip4j.progress.ProgressMonitor progressMonitor2 = progressMonitor;
                        try {
                            extractFileTask.extractFile(zipInputStreamCreateZipInputStream, fileHeader, extractFileTaskParameters.outputPath, determineNewFileName(extractFileTaskParameters.newFileName, extractFileTaskParameters.fileToExtract, fileHeader), progressMonitor2, bArr);
                            progressMonitor = progressMonitor2;
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            java.lang.Throwable th3 = th;
                            if (zipInputStreamCreateZipInputStream == null) {
                                throw th3;
                            }
                            try {
                                zipInputStreamCreateZipInputStream.close();
                                throw th3;
                            } catch (java.lang.Throwable th4) {
                                th3.addSuppressed(th4);
                                throw th3;
                            }
                        }
                    }
                    if (zipInputStreamCreateZipInputStream != null) {
                        zipInputStreamCreateZipInputStream.close();
                    }
                    net.lingala.zip4j.io.inputstream.SplitFileInputStream splitFileInputStream2 = this.splitInputStream;
                    if (splitFileInputStream2 != null) {
                        splitFileInputStream2.close();
                    }
                } catch (java.lang.Throwable th5) {
                    th = th5;
                    extractFileTask = this;
                }
            } catch (java.lang.Throwable th6) {
                th = th6;
                th = th;
                splitFileInputStream = extractFileTask.splitInputStream;
                if (splitFileInputStream != null) {
                    splitFileInputStream.close();
                    throw th;
                }
                throw th;
            }
        } catch (java.lang.Throwable th7) {
            th = th7;
            extractFileTask = this;
            th = th;
            splitFileInputStream = extractFileTask.splitInputStream;
            if (splitFileInputStream != null) {
                splitFileInputStream.close();
                throw th;
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    public long calculateTotalWork(net.lingala.zip4j.tasks.ExtractFileTask.ExtractFileTaskParameters extractFileTaskParameters) throws net.lingala.zip4j.exception.ZipException {
        return net.lingala.zip4j.headers.HeaderUtil.getTotalUncompressedSizeOfAllFileHeaders(getFileHeadersToExtract(extractFileTaskParameters.fileToExtract));
    }

    private java.util.List<net.lingala.zip4j.model.FileHeader> getFileHeadersToExtract(java.lang.String str) throws net.lingala.zip4j.exception.ZipException {
        if (!net.lingala.zip4j.util.FileUtils.isZipEntryDirectory(str)) {
            net.lingala.zip4j.model.FileHeader fileHeader = net.lingala.zip4j.headers.HeaderUtil.getFileHeader(getZipModel(), str);
            if (fileHeader == null) {
                throw new net.lingala.zip4j.exception.ZipException("No file found with name " + str + " in zip file", net.lingala.zip4j.exception.ZipException.Type.FILE_NOT_FOUND);
            }
            return java.util.Collections.singletonList(fileHeader);
        }
        return net.lingala.zip4j.headers.HeaderUtil.getFileHeadersUnderDirectory(getZipModel().getCentralDirectory().getFileHeaders(), str);
    }

    private net.lingala.zip4j.io.inputstream.ZipInputStream createZipInputStream(net.lingala.zip4j.model.Zip4jConfig zip4jConfig) throws java.io.IOException {
        this.splitInputStream = net.lingala.zip4j.util.UnzipUtil.createSplitInputStream(getZipModel());
        return new net.lingala.zip4j.io.inputstream.ZipInputStream(this.splitInputStream, this.password, zip4jConfig);
    }

    private java.lang.String determineNewFileName(java.lang.String str, java.lang.String str2, net.lingala.zip4j.model.FileHeader fileHeader) {
        if (!net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(str) || !net.lingala.zip4j.util.FileUtils.isZipEntryDirectory(str2)) {
            return str;
        }
        java.lang.String str3 = "/";
        if (str.endsWith("/")) {
            str3 = "";
        }
        return fileHeader.getFileName().replaceFirst(str2, str + str3);
    }

    public static class ExtractFileTaskParameters extends net.lingala.zip4j.tasks.AbstractZipTaskParameters {
        private java.lang.String fileToExtract;
        private java.lang.String newFileName;
        private java.lang.String outputPath;

        public ExtractFileTaskParameters(java.lang.String str, java.lang.String str2, java.lang.String str3, net.lingala.zip4j.model.Zip4jConfig zip4jConfig) {
            super(zip4jConfig);
            this.outputPath = str;
            this.fileToExtract = str2;
            this.newFileName = str3;
        }
    }
}
