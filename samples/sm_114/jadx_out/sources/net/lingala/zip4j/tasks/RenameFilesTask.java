package net.lingala.zip4j.tasks;

/* JADX INFO: loaded from: classes2.dex */
public class RenameFilesTask extends net.lingala.zip4j.tasks.AbstractModifyFileTask<net.lingala.zip4j.tasks.RenameFilesTask.RenameFilesTaskParameters> {
    private final net.lingala.zip4j.headers.HeaderWriter headerWriter;
    private final net.lingala.zip4j.util.RawIO rawIO;
    private final net.lingala.zip4j.model.ZipModel zipModel;

    public RenameFilesTask(net.lingala.zip4j.model.ZipModel zipModel, net.lingala.zip4j.headers.HeaderWriter headerWriter, net.lingala.zip4j.util.RawIO rawIO, net.lingala.zip4j.tasks.AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(asyncTaskParameters);
        this.zipModel = zipModel;
        this.headerWriter = headerWriter;
        this.rawIO = rawIO;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    public void executeTask(net.lingala.zip4j.tasks.RenameFilesTask.RenameFilesTaskParameters renameFilesTaskParameters, net.lingala.zip4j.progress.ProgressMonitor progressMonitor) throws java.io.IOException {
        java.io.RandomAccessFile randomAccessFile;
        java.lang.Throwable th;
        net.lingala.zip4j.io.outputstream.SplitOutputStream splitOutputStream;
        java.lang.Throwable th2;
        java.util.List<net.lingala.zip4j.model.FileHeader> list;
        net.lingala.zip4j.tasks.RenameFilesTask renameFilesTask = this;
        java.util.Map<java.lang.String, java.lang.String> mapFilterNonExistingEntriesAndAddSeparatorIfNeeded = renameFilesTask.filterNonExistingEntriesAndAddSeparatorIfNeeded(renameFilesTaskParameters.fileNamesMap);
        if (mapFilterNonExistingEntriesAndAddSeparatorIfNeeded.size() == 0) {
            return;
        }
        java.io.File temporaryFile = renameFilesTask.getTemporaryFile(renameFilesTask.zipModel.getZipFile().getPath());
        try {
            java.io.RandomAccessFile randomAccessFile2 = new java.io.RandomAccessFile(renameFilesTask.zipModel.getZipFile(), net.lingala.zip4j.model.enums.RandomAccessFileMode.WRITE.getValue());
            try {
                try {
                    net.lingala.zip4j.io.outputstream.SplitOutputStream splitOutputStream2 = new net.lingala.zip4j.io.outputstream.SplitOutputStream(temporaryFile);
                    try {
                        java.nio.charset.Charset charset = renameFilesTaskParameters.zip4jConfig.getCharset();
                        java.util.List<net.lingala.zip4j.model.FileHeader> listCloneAndSortFileHeadersByOffset = renameFilesTask.cloneAndSortFileHeadersByOffset(renameFilesTask.zipModel.getCentralDirectory().getFileHeaders());
                        long jCopyFile = 0;
                        for (net.lingala.zip4j.model.FileHeader fileHeader : listCloneAndSortFileHeadersByOffset) {
                            java.util.Map.Entry<java.lang.String, java.lang.String> correspondingEntryFromMap = renameFilesTask.getCorrespondingEntryFromMap(fileHeader, mapFilterNonExistingEntriesAndAddSeparatorIfNeeded);
                            progressMonitor.setFileName(fileHeader.getFileName());
                            long offsetOfNextEntry = renameFilesTask.getOffsetOfNextEntry(listCloneAndSortFileHeadersByOffset, fileHeader, renameFilesTask.zipModel) - splitOutputStream2.getFilePointer();
                            if (correspondingEntryFromMap == null) {
                                jCopyFile += renameFilesTask.copyFile(randomAccessFile2, splitOutputStream2, jCopyFile, offsetOfNextEntry, progressMonitor, renameFilesTaskParameters.zip4jConfig.getBufferSize());
                                randomAccessFile = randomAccessFile2;
                                splitOutputStream = splitOutputStream2;
                                list = listCloneAndSortFileHeadersByOffset;
                            } else {
                                java.lang.String newFileName = renameFilesTask.getNewFileName(correspondingEntryFromMap.getValue(), correspondingEntryFromMap.getKey(), fileHeader.getFileName());
                                randomAccessFile = randomAccessFile2;
                                try {
                                    byte[] bytesFromString = net.lingala.zip4j.headers.HeaderUtil.getBytesFromString(newFileName, charset);
                                    int length = bytesFromString.length - fileHeader.getFileNameLength();
                                    splitOutputStream = splitOutputStream2;
                                    java.util.List<net.lingala.zip4j.model.FileHeader> list2 = listCloneAndSortFileHeadersByOffset;
                                    long jCopyEntryAndChangeFileName = renameFilesTask.copyEntryAndChangeFileName(bytesFromString, fileHeader, jCopyFile, offsetOfNextEntry, randomAccessFile, splitOutputStream, progressMonitor, renameFilesTaskParameters.zip4jConfig.getBufferSize());
                                    renameFilesTask = this;
                                    renameFilesTask.updateHeadersInZipModel(list2, fileHeader, newFileName, bytesFromString, length);
                                    list = list2;
                                    jCopyFile = jCopyEntryAndChangeFileName;
                                } catch (java.lang.Throwable th3) {
                                    th = th3;
                                    splitOutputStream = splitOutputStream2;
                                    th2 = th;
                                    try {
                                        splitOutputStream.close();
                                        throw th2;
                                    } catch (java.lang.Throwable th4) {
                                        th2.addSuppressed(th4);
                                        throw th2;
                                    }
                                }
                            }
                            try {
                                renameFilesTask.verifyIfTaskIsCancelled();
                                randomAccessFile2 = randomAccessFile;
                                splitOutputStream2 = splitOutputStream;
                                listCloneAndSortFileHeadersByOffset = list;
                            } catch (java.lang.Throwable th5) {
                                th = th5;
                                th2 = th;
                                splitOutputStream.close();
                                throw th2;
                            }
                        }
                        randomAccessFile = randomAccessFile2;
                        splitOutputStream = splitOutputStream2;
                        renameFilesTask.headerWriter.finalizeZipFile(renameFilesTask.zipModel, splitOutputStream, charset);
                        splitOutputStream.close();
                        randomAccessFile.close();
                        renameFilesTask.cleanupFile(true, renameFilesTask.zipModel.getZipFile(), temporaryFile);
                    } catch (java.lang.Throwable th6) {
                        th = th6;
                        randomAccessFile = randomAccessFile2;
                    }
                } catch (java.lang.Throwable th7) {
                    th = th7;
                    th = th;
                    try {
                        randomAccessFile.close();
                        throw th;
                    } catch (java.lang.Throwable th8) {
                        th.addSuppressed(th8);
                        throw th;
                    }
                }
            } catch (java.lang.Throwable th9) {
                th = th9;
                randomAccessFile = randomAccessFile2;
                th = th;
                randomAccessFile.close();
                throw th;
            }
        } catch (java.lang.Throwable th10) {
            renameFilesTask.cleanupFile(false, renameFilesTask.zipModel.getZipFile(), temporaryFile);
            throw th10;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    public long calculateTotalWork(net.lingala.zip4j.tasks.RenameFilesTask.RenameFilesTaskParameters renameFilesTaskParameters) {
        return this.zipModel.getZipFile().length();
    }

    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    protected net.lingala.zip4j.progress.ProgressMonitor.Task getTask() {
        return net.lingala.zip4j.progress.ProgressMonitor.Task.RENAME_FILE;
    }

    private long copyEntryAndChangeFileName(byte[] bArr, net.lingala.zip4j.model.FileHeader fileHeader, long j, long j2, java.io.RandomAccessFile randomAccessFile, java.io.OutputStream outputStream, net.lingala.zip4j.progress.ProgressMonitor progressMonitor, int i) throws java.io.IOException {
        long jCopyFile = j + copyFile(randomAccessFile, outputStream, j, 26L, progressMonitor, i);
        this.rawIO.writeShortLittleEndian(outputStream, bArr.length);
        long j3 = jCopyFile + 2;
        long jCopyFile2 = j3 + copyFile(randomAccessFile, outputStream, j3, 2L, progressMonitor, i);
        outputStream.write(bArr);
        long fileNameLength = jCopyFile2 + ((long) fileHeader.getFileNameLength());
        return fileNameLength + copyFile(randomAccessFile, outputStream, fileNameLength, j2 - (fileNameLength - j), progressMonitor, i);
    }

    private java.util.Map.Entry<java.lang.String, java.lang.String> getCorrespondingEntryFromMap(net.lingala.zip4j.model.FileHeader fileHeader, java.util.Map<java.lang.String, java.lang.String> map) {
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            if (fileHeader.getFileName().startsWith(entry.getKey())) {
                return entry;
            }
        }
        return null;
    }

    private void updateHeadersInZipModel(java.util.List<net.lingala.zip4j.model.FileHeader> list, net.lingala.zip4j.model.FileHeader fileHeader, java.lang.String str, byte[] bArr, int i) throws net.lingala.zip4j.exception.ZipException {
        net.lingala.zip4j.model.FileHeader fileHeader2 = net.lingala.zip4j.headers.HeaderUtil.getFileHeader(this.zipModel, fileHeader.getFileName());
        if (fileHeader2 == null) {
            throw new net.lingala.zip4j.exception.ZipException("could not find any header with name: " + fileHeader.getFileName());
        }
        fileHeader2.setFileName(str);
        fileHeader2.setFileNameLength(bArr.length);
        long j = i;
        updateOffsetsForAllSubsequentFileHeaders(list, this.zipModel, fileHeader2, j);
        this.zipModel.getEndOfCentralDirectoryRecord().setOffsetOfStartOfCentralDirectory(this.zipModel.getEndOfCentralDirectoryRecord().getOffsetOfStartOfCentralDirectory() + j);
        if (this.zipModel.isZip64Format()) {
            this.zipModel.getZip64EndOfCentralDirectoryRecord().setOffsetStartCentralDirectoryWRTStartDiskNumber(this.zipModel.getZip64EndOfCentralDirectoryRecord().getOffsetStartCentralDirectoryWRTStartDiskNumber() + j);
            this.zipModel.getZip64EndOfCentralDirectoryLocator().setOffsetZip64EndOfCentralDirectoryRecord(this.zipModel.getZip64EndOfCentralDirectoryLocator().getOffsetZip64EndOfCentralDirectoryRecord() + j);
        }
    }

    private java.util.Map<java.lang.String, java.lang.String> filterNonExistingEntriesAndAddSeparatorIfNeeded(java.util.Map<java.lang.String, java.lang.String> map) throws net.lingala.zip4j.exception.ZipException {
        net.lingala.zip4j.model.FileHeader fileHeader;
        java.util.HashMap map2 = new java.util.HashMap();
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            if (net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(entry.getKey()) && (fileHeader = net.lingala.zip4j.headers.HeaderUtil.getFileHeader(this.zipModel, entry.getKey())) != null) {
                if (fileHeader.isDirectory() && !entry.getValue().endsWith("/")) {
                    map2.put(entry.getKey(), entry.getValue() + "/");
                } else {
                    map2.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return map2;
    }

    private java.lang.String getNewFileName(java.lang.String str, java.lang.String str2, java.lang.String str3) throws net.lingala.zip4j.exception.ZipException {
        if (str3.equals(str2)) {
            return str;
        }
        if (str3.startsWith(str2)) {
            return str + str3.substring(str2.length());
        }
        throw new net.lingala.zip4j.exception.ZipException("old file name was neither an exact match nor a partial match");
    }

    public static class RenameFilesTaskParameters extends net.lingala.zip4j.tasks.AbstractZipTaskParameters {
        private final java.util.Map<java.lang.String, java.lang.String> fileNamesMap;

        public RenameFilesTaskParameters(java.util.Map<java.lang.String, java.lang.String> map, net.lingala.zip4j.model.Zip4jConfig zip4jConfig) {
            super(zip4jConfig);
            this.fileNamesMap = map;
        }
    }
}
