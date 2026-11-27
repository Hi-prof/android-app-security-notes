package net.lingala.zip4j.tasks;

/* JADX INFO: loaded from: classes2.dex */
public class AddStreamToZipTask extends net.lingala.zip4j.tasks.AbstractAddFileToZipTask<net.lingala.zip4j.tasks.AddStreamToZipTask.AddStreamToZipTaskParameters> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    public long calculateTotalWork(net.lingala.zip4j.tasks.AddStreamToZipTask.AddStreamToZipTaskParameters addStreamToZipTaskParameters) {
        return 0L;
    }

    public AddStreamToZipTask(net.lingala.zip4j.model.ZipModel zipModel, char[] cArr, net.lingala.zip4j.headers.HeaderWriter headerWriter, net.lingala.zip4j.tasks.AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(zipModel, cArr, headerWriter, asyncTaskParameters);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    public void executeTask(net.lingala.zip4j.tasks.AddStreamToZipTask.AddStreamToZipTaskParameters addStreamToZipTaskParameters, net.lingala.zip4j.progress.ProgressMonitor progressMonitor) throws java.io.IOException {
        verifyZipParameters(addStreamToZipTaskParameters.zipParameters);
        if (!net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(addStreamToZipTaskParameters.zipParameters.getFileNameInZip())) {
            throw new net.lingala.zip4j.exception.ZipException("fileNameInZip has to be set in zipParameters when adding stream");
        }
        removeFileIfExists(getZipModel(), addStreamToZipTaskParameters.zip4jConfig, addStreamToZipTaskParameters.zipParameters.getFileNameInZip(), progressMonitor);
        addStreamToZipTaskParameters.zipParameters.setWriteExtendedLocalFileHeader(true);
        if (addStreamToZipTaskParameters.zipParameters.getCompressionMethod().equals(net.lingala.zip4j.model.enums.CompressionMethod.STORE)) {
            addStreamToZipTaskParameters.zipParameters.setEntrySize(0L);
        }
        net.lingala.zip4j.io.outputstream.SplitOutputStream splitOutputStream = new net.lingala.zip4j.io.outputstream.SplitOutputStream(getZipModel().getZipFile(), getZipModel().getSplitLength());
        try {
            net.lingala.zip4j.io.outputstream.ZipOutputStream zipOutputStreamInitializeOutputStream = initializeOutputStream(splitOutputStream, addStreamToZipTaskParameters.zip4jConfig);
            try {
                byte[] bArr = new byte[addStreamToZipTaskParameters.zip4jConfig.getBufferSize()];
                net.lingala.zip4j.model.ZipParameters zipParameters = addStreamToZipTaskParameters.zipParameters;
                zipOutputStreamInitializeOutputStream.putNextEntry(zipParameters);
                if (!zipParameters.getFileNameInZip().endsWith("/") && !zipParameters.getFileNameInZip().endsWith("\\")) {
                    while (true) {
                        int i = addStreamToZipTaskParameters.inputStream.read(bArr);
                        if (i == -1) {
                            break;
                        } else {
                            zipOutputStreamInitializeOutputStream.write(bArr, 0, i);
                        }
                    }
                }
                net.lingala.zip4j.model.FileHeader fileHeaderCloseEntry = zipOutputStreamInitializeOutputStream.closeEntry();
                if (net.lingala.zip4j.model.enums.CompressionMethod.STORE.equals(net.lingala.zip4j.util.Zip4jUtil.getCompressionMethod(fileHeaderCloseEntry))) {
                    updateLocalFileHeader(fileHeaderCloseEntry, splitOutputStream);
                }
                if (zipOutputStreamInitializeOutputStream != null) {
                    zipOutputStreamInitializeOutputStream.close();
                }
                splitOutputStream.close();
            } catch (java.lang.Throwable th) {
                if (zipOutputStreamInitializeOutputStream != null) {
                    try {
                        zipOutputStreamInitializeOutputStream.close();
                    } catch (java.lang.Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (java.lang.Throwable th3) {
            try {
                splitOutputStream.close();
            } catch (java.lang.Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    private void removeFileIfExists(net.lingala.zip4j.model.ZipModel zipModel, net.lingala.zip4j.model.Zip4jConfig zip4jConfig, java.lang.String str, net.lingala.zip4j.progress.ProgressMonitor progressMonitor) throws net.lingala.zip4j.exception.ZipException {
        net.lingala.zip4j.model.FileHeader fileHeader = net.lingala.zip4j.headers.HeaderUtil.getFileHeader(zipModel, str);
        if (fileHeader != null) {
            removeFile(fileHeader, progressMonitor, zip4jConfig);
        }
    }

    public static class AddStreamToZipTaskParameters extends net.lingala.zip4j.tasks.AbstractZipTaskParameters {
        private final java.io.InputStream inputStream;
        private final net.lingala.zip4j.model.ZipParameters zipParameters;

        public AddStreamToZipTaskParameters(java.io.InputStream inputStream, net.lingala.zip4j.model.ZipParameters zipParameters, net.lingala.zip4j.model.Zip4jConfig zip4jConfig) {
            super(zip4jConfig);
            this.inputStream = inputStream;
            this.zipParameters = zipParameters;
        }
    }
}
