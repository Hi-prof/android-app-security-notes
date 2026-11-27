package net.lingala.zip4j.tasks;

/* JADX INFO: loaded from: classes2.dex */
public class ExtractAllFilesTask extends net.lingala.zip4j.tasks.AbstractExtractFileTask<net.lingala.zip4j.tasks.ExtractAllFilesTask.ExtractAllFilesTaskParameters> {
    private final char[] password;
    private net.lingala.zip4j.io.inputstream.SplitFileInputStream splitInputStream;

    public ExtractAllFilesTask(net.lingala.zip4j.model.ZipModel zipModel, char[] cArr, net.lingala.zip4j.model.UnzipParameters unzipParameters, net.lingala.zip4j.tasks.AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(zipModel, unzipParameters, asyncTaskParameters);
        this.password = cArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code duplicated, block: B:41:0x007f  */
    /* JADX WARN: Code duplicated, block: B:43:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:? A[Catch: all -> 0x0076, SYNTHETIC, TRY_LEAVE, TryCatch #1 {all -> 0x0076, blocks: (B:34:0x0075, B:33:0x0072, B:20:0x005c, B:29:0x006c), top: B:45:0x0000, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:61:? A[SYNTHETIC] */
    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    public void executeTask(net.lingala.zip4j.tasks.ExtractAllFilesTask.ExtractAllFilesTaskParameters extractAllFilesTaskParameters, net.lingala.zip4j.progress.ProgressMonitor progressMonitor) throws java.lang.Throwable {
        net.lingala.zip4j.tasks.ExtractAllFilesTask extractAllFilesTask;
        java.lang.Throwable th;
        net.lingala.zip4j.io.inputstream.SplitFileInputStream splitFileInputStream;
        java.lang.Throwable th2;
        try {
            try {
                net.lingala.zip4j.io.inputstream.ZipInputStream zipInputStreamPrepareZipInputStream = prepareZipInputStream(extractAllFilesTaskParameters.zip4jConfig);
                try {
                    for (net.lingala.zip4j.model.FileHeader fileHeader : getZipModel().getCentralDirectory().getFileHeaders()) {
                        if (fileHeader.getFileName().startsWith("__MACOSX")) {
                            try {
                                progressMonitor.updateWorkCompleted(fileHeader.getUncompressedSize());
                            } catch (java.lang.Throwable th3) {
                                th2 = th3;
                                extractAllFilesTask = this;
                                if (zipInputStreamPrepareZipInputStream != null) {
                                    throw th2;
                                }
                                try {
                                    zipInputStreamPrepareZipInputStream.close();
                                    throw th2;
                                } catch (java.lang.Throwable th4) {
                                    th2.addSuppressed(th4);
                                    throw th2;
                                }
                            }
                        } else {
                            this.splitInputStream.prepareExtractionForFileHeader(fileHeader);
                            extractAllFilesTask = this;
                            net.lingala.zip4j.progress.ProgressMonitor progressMonitor2 = progressMonitor;
                            try {
                                extractAllFilesTask.extractFile(zipInputStreamPrepareZipInputStream, fileHeader, extractAllFilesTaskParameters.outputPath, null, progressMonitor2, new byte[extractAllFilesTaskParameters.zip4jConfig.getBufferSize()]);
                                verifyIfTaskIsCancelled();
                                progressMonitor = progressMonitor2;
                            } catch (java.lang.Throwable th5) {
                                th = th5;
                                th2 = th;
                                if (zipInputStreamPrepareZipInputStream != null) {
                                    throw th2;
                                }
                                zipInputStreamPrepareZipInputStream.close();
                                throw th2;
                            }
                        }
                    }
                    if (zipInputStreamPrepareZipInputStream != null) {
                        zipInputStreamPrepareZipInputStream.close();
                    }
                    net.lingala.zip4j.io.inputstream.SplitFileInputStream splitFileInputStream2 = this.splitInputStream;
                    if (splitFileInputStream2 != null) {
                        splitFileInputStream2.close();
                    }
                } catch (java.lang.Throwable th6) {
                    th = th6;
                    extractAllFilesTask = this;
                }
            } catch (java.lang.Throwable th7) {
                th = th7;
                th = th;
                splitFileInputStream = extractAllFilesTask.splitInputStream;
                if (splitFileInputStream != null) {
                    splitFileInputStream.close();
                    throw th;
                }
                throw th;
            }
        } catch (java.lang.Throwable th8) {
            th = th8;
            extractAllFilesTask = this;
            th = th;
            splitFileInputStream = extractAllFilesTask.splitInputStream;
            if (splitFileInputStream != null) {
                splitFileInputStream.close();
                throw th;
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    public long calculateTotalWork(net.lingala.zip4j.tasks.ExtractAllFilesTask.ExtractAllFilesTaskParameters extractAllFilesTaskParameters) {
        return net.lingala.zip4j.headers.HeaderUtil.getTotalUncompressedSizeOfAllFileHeaders(getZipModel().getCentralDirectory().getFileHeaders());
    }

    private net.lingala.zip4j.io.inputstream.ZipInputStream prepareZipInputStream(net.lingala.zip4j.model.Zip4jConfig zip4jConfig) throws java.io.IOException {
        this.splitInputStream = net.lingala.zip4j.util.UnzipUtil.createSplitInputStream(getZipModel());
        net.lingala.zip4j.model.FileHeader firstFileHeader = getFirstFileHeader(getZipModel());
        if (firstFileHeader != null) {
            this.splitInputStream.prepareExtractionForFileHeader(firstFileHeader);
        }
        return new net.lingala.zip4j.io.inputstream.ZipInputStream(this.splitInputStream, this.password, zip4jConfig);
    }

    private net.lingala.zip4j.model.FileHeader getFirstFileHeader(net.lingala.zip4j.model.ZipModel zipModel) {
        if (zipModel.getCentralDirectory() == null || zipModel.getCentralDirectory().getFileHeaders() == null || zipModel.getCentralDirectory().getFileHeaders().size() == 0) {
            return null;
        }
        return zipModel.getCentralDirectory().getFileHeaders().get(0);
    }

    public static class ExtractAllFilesTaskParameters extends net.lingala.zip4j.tasks.AbstractZipTaskParameters {
        private final java.lang.String outputPath;

        public ExtractAllFilesTaskParameters(java.lang.String str, net.lingala.zip4j.model.Zip4jConfig zip4jConfig) {
            super(zip4jConfig);
            this.outputPath = str;
        }
    }
}
