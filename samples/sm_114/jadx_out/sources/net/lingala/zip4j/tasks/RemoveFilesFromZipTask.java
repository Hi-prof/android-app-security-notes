package net.lingala.zip4j.tasks;

/* JADX INFO: loaded from: classes2.dex */
public class RemoveFilesFromZipTask extends net.lingala.zip4j.tasks.AbstractModifyFileTask<net.lingala.zip4j.tasks.RemoveFilesFromZipTask.RemoveFilesFromZipTaskParameters> {
    private final net.lingala.zip4j.headers.HeaderWriter headerWriter;
    private final net.lingala.zip4j.model.ZipModel zipModel;

    public RemoveFilesFromZipTask(net.lingala.zip4j.model.ZipModel zipModel, net.lingala.zip4j.headers.HeaderWriter headerWriter, net.lingala.zip4j.tasks.AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(asyncTaskParameters);
        this.zipModel = zipModel;
        this.headerWriter = headerWriter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    public void executeTask(net.lingala.zip4j.tasks.RemoveFilesFromZipTask.RemoveFilesFromZipTaskParameters removeFilesFromZipTaskParameters, net.lingala.zip4j.progress.ProgressMonitor progressMonitor) throws java.io.IOException {
        if (this.zipModel.isSplitArchive()) {
            throw new net.lingala.zip4j.exception.ZipException("This is a split archive. Zip file format does not allow updating split/spanned files");
        }
        java.util.List<java.lang.String> listFilterNonExistingEntries = filterNonExistingEntries(removeFilesFromZipTaskParameters.filesToRemove);
        if (listFilterNonExistingEntries.isEmpty()) {
            return;
        }
        java.io.File temporaryFile = getTemporaryFile(this.zipModel.getZipFile().getPath());
        try {
            net.lingala.zip4j.io.outputstream.SplitOutputStream splitOutputStream = new net.lingala.zip4j.io.outputstream.SplitOutputStream(temporaryFile);
            try {
                java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(this.zipModel.getZipFile(), net.lingala.zip4j.model.enums.RandomAccessFileMode.READ.getValue());
                try {
                    java.util.List<net.lingala.zip4j.model.FileHeader> listCloneAndSortFileHeadersByOffset = cloneAndSortFileHeadersByOffset(this.zipModel.getCentralDirectory().getFileHeaders());
                    long jCopyFile = 0;
                    for (net.lingala.zip4j.model.FileHeader fileHeader : listCloneAndSortFileHeadersByOffset) {
                        long offsetOfNextEntry = getOffsetOfNextEntry(listCloneAndSortFileHeadersByOffset, fileHeader, this.zipModel) - splitOutputStream.getFilePointer();
                        if (shouldEntryBeRemoved(fileHeader, listFilterNonExistingEntries)) {
                            updateHeaders(listCloneAndSortFileHeadersByOffset, fileHeader, offsetOfNextEntry);
                            if (!this.zipModel.getCentralDirectory().getFileHeaders().remove(fileHeader)) {
                                throw new net.lingala.zip4j.exception.ZipException("Could not remove entry from list of central directory headers");
                            }
                            jCopyFile += offsetOfNextEntry;
                        } else {
                            jCopyFile += super.copyFile(randomAccessFile, splitOutputStream, jCopyFile, offsetOfNextEntry, progressMonitor, removeFilesFromZipTaskParameters.zip4jConfig.getBufferSize());
                        }
                        verifyIfTaskIsCancelled();
                    }
                    this.headerWriter.finalizeZipFile(this.zipModel, splitOutputStream, removeFilesFromZipTaskParameters.zip4jConfig.getCharset());
                    randomAccessFile.close();
                    splitOutputStream.close();
                    cleanupFile(true, this.zipModel.getZipFile(), temporaryFile);
                } catch (java.lang.Throwable th) {
                    try {
                        randomAccessFile.close();
                        throw th;
                    } catch (java.lang.Throwable th2) {
                        th.addSuppressed(th2);
                        throw th;
                    }
                }
            } catch (java.lang.Throwable th3) {
                try {
                    splitOutputStream.close();
                    throw th3;
                } catch (java.lang.Throwable th4) {
                    th3.addSuppressed(th4);
                    throw th3;
                }
            }
        } catch (java.lang.Throwable th5) {
            cleanupFile(false, this.zipModel.getZipFile(), temporaryFile);
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    public long calculateTotalWork(net.lingala.zip4j.tasks.RemoveFilesFromZipTask.RemoveFilesFromZipTaskParameters removeFilesFromZipTaskParameters) {
        return this.zipModel.getZipFile().length();
    }

    private java.util.List<java.lang.String> filterNonExistingEntries(java.util.List<java.lang.String> list) throws net.lingala.zip4j.exception.ZipException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.String str : list) {
            if (net.lingala.zip4j.headers.HeaderUtil.getFileHeader(this.zipModel, str) != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    private boolean shouldEntryBeRemoved(net.lingala.zip4j.model.FileHeader fileHeader, java.util.List<java.lang.String> list) {
        for (java.lang.String str : list) {
            if ((str.endsWith("/") && fileHeader.getFileName().startsWith(str)) || fileHeader.getFileName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    private void updateHeaders(java.util.List<net.lingala.zip4j.model.FileHeader> list, net.lingala.zip4j.model.FileHeader fileHeader, long j) throws net.lingala.zip4j.exception.ZipException {
        updateOffsetsForAllSubsequentFileHeaders(list, this.zipModel, fileHeader, negate(j));
        net.lingala.zip4j.model.EndOfCentralDirectoryRecord endOfCentralDirectoryRecord = this.zipModel.getEndOfCentralDirectoryRecord();
        endOfCentralDirectoryRecord.setOffsetOfStartOfCentralDirectory(endOfCentralDirectoryRecord.getOffsetOfStartOfCentralDirectory() - j);
        endOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectory(endOfCentralDirectoryRecord.getTotalNumberOfEntriesInCentralDirectory() - 1);
        if (endOfCentralDirectoryRecord.getTotalNumberOfEntriesInCentralDirectoryOnThisDisk() > 0) {
            endOfCentralDirectoryRecord.setTotalNumberOfEntriesInCentralDirectoryOnThisDisk(endOfCentralDirectoryRecord.getTotalNumberOfEntriesInCentralDirectoryOnThisDisk() - 1);
        }
        if (this.zipModel.isZip64Format()) {
            this.zipModel.getZip64EndOfCentralDirectoryRecord().setOffsetStartCentralDirectoryWRTStartDiskNumber(this.zipModel.getZip64EndOfCentralDirectoryRecord().getOffsetStartCentralDirectoryWRTStartDiskNumber() - j);
            this.zipModel.getZip64EndOfCentralDirectoryRecord().setTotalNumberOfEntriesInCentralDirectoryOnThisDisk(this.zipModel.getZip64EndOfCentralDirectoryRecord().getTotalNumberOfEntriesInCentralDirectory() - 1);
            this.zipModel.getZip64EndOfCentralDirectoryLocator().setOffsetZip64EndOfCentralDirectoryRecord(this.zipModel.getZip64EndOfCentralDirectoryLocator().getOffsetZip64EndOfCentralDirectoryRecord() - j);
        }
    }

    private long negate(long j) {
        if (j != Long.MIN_VALUE) {
            return -j;
        }
        throw new java.lang.ArithmeticException("long overflow");
    }

    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    protected net.lingala.zip4j.progress.ProgressMonitor.Task getTask() {
        return net.lingala.zip4j.progress.ProgressMonitor.Task.REMOVE_ENTRY;
    }

    public static class RemoveFilesFromZipTaskParameters extends net.lingala.zip4j.tasks.AbstractZipTaskParameters {
        private final java.util.List<java.lang.String> filesToRemove;

        public RemoveFilesFromZipTaskParameters(java.util.List<java.lang.String> list, net.lingala.zip4j.model.Zip4jConfig zip4jConfig) {
            super(zip4jConfig);
            this.filesToRemove = list;
        }
    }
}
