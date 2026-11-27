package net.lingala.zip4j.tasks;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractAddFileToZipTask<T> extends net.lingala.zip4j.tasks.AsyncZipTask<T> {
    private final net.lingala.zip4j.headers.HeaderWriter headerWriter;
    private final char[] password;
    private final net.lingala.zip4j.model.ZipModel zipModel;

    AbstractAddFileToZipTask(net.lingala.zip4j.model.ZipModel zipModel, char[] cArr, net.lingala.zip4j.headers.HeaderWriter headerWriter, net.lingala.zip4j.tasks.AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(asyncTaskParameters);
        this.zipModel = zipModel;
        this.password = cArr;
        this.headerWriter = headerWriter;
    }

    void addFilesToZip(java.util.List<java.io.File> list, net.lingala.zip4j.progress.ProgressMonitor progressMonitor, net.lingala.zip4j.model.ZipParameters zipParameters, net.lingala.zip4j.model.Zip4jConfig zip4jConfig) throws java.io.IOException {
        net.lingala.zip4j.util.FileUtils.assertFilesExist(list, zipParameters.getSymbolicLinkAction());
        byte[] bArr = new byte[zip4jConfig.getBufferSize()];
        java.util.List<java.io.File> listRemoveFilesIfExists = removeFilesIfExists(list, zipParameters, progressMonitor, zip4jConfig);
        net.lingala.zip4j.io.outputstream.SplitOutputStream splitOutputStream = new net.lingala.zip4j.io.outputstream.SplitOutputStream(this.zipModel.getZipFile(), this.zipModel.getSplitLength());
        try {
            net.lingala.zip4j.io.outputstream.ZipOutputStream zipOutputStreamInitializeOutputStream = initializeOutputStream(splitOutputStream, zip4jConfig);
            try {
                for (java.io.File file : listRemoveFilesIfExists) {
                    verifyIfTaskIsCancelled();
                    net.lingala.zip4j.model.ZipParameters zipParametersCloneAndAdjustZipParameters = cloneAndAdjustZipParameters(zipParameters, file, progressMonitor);
                    progressMonitor.setFileName(file.getAbsolutePath());
                    if (net.lingala.zip4j.util.FileUtils.isSymbolicLink(file) && addSymlink(zipParametersCloneAndAdjustZipParameters)) {
                        addSymlinkToZip(file, zipOutputStreamInitializeOutputStream, zipParametersCloneAndAdjustZipParameters, splitOutputStream);
                        if (net.lingala.zip4j.model.ZipParameters.SymbolicLinkAction.INCLUDE_LINK_ONLY.equals(zipParametersCloneAndAdjustZipParameters.getSymbolicLinkAction())) {
                        }
                    }
                    net.lingala.zip4j.progress.ProgressMonitor progressMonitor2 = progressMonitor;
                    addFileToZip(file, zipOutputStreamInitializeOutputStream, zipParametersCloneAndAdjustZipParameters, splitOutputStream, progressMonitor2, bArr);
                    progressMonitor = progressMonitor2;
                }
                if (zipOutputStreamInitializeOutputStream != null) {
                    zipOutputStreamInitializeOutputStream.close();
                }
                splitOutputStream.close();
            } catch (java.lang.Throwable th) {
                if (zipOutputStreamInitializeOutputStream == null) {
                    throw th;
                }
                try {
                    zipOutputStreamInitializeOutputStream.close();
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
    }

    private void addSymlinkToZip(java.io.File file, net.lingala.zip4j.io.outputstream.ZipOutputStream zipOutputStream, net.lingala.zip4j.model.ZipParameters zipParameters, net.lingala.zip4j.io.outputstream.SplitOutputStream splitOutputStream) throws java.io.IOException {
        net.lingala.zip4j.model.ZipParameters zipParameters2 = new net.lingala.zip4j.model.ZipParameters(zipParameters);
        zipParameters2.setFileNameInZip(replaceFileNameInZip(zipParameters.getFileNameInZip(), file.getName()));
        zipParameters2.setEncryptFiles(false);
        zipParameters2.setCompressionMethod(net.lingala.zip4j.model.enums.CompressionMethod.STORE);
        zipOutputStream.putNextEntry(zipParameters2);
        zipOutputStream.write(net.lingala.zip4j.util.FileUtils.readSymbolicLink(file).getBytes());
        closeEntry(zipOutputStream, splitOutputStream, file, true);
    }

    private void addFileToZip(java.io.File file, net.lingala.zip4j.io.outputstream.ZipOutputStream zipOutputStream, net.lingala.zip4j.model.ZipParameters zipParameters, net.lingala.zip4j.io.outputstream.SplitOutputStream splitOutputStream, net.lingala.zip4j.progress.ProgressMonitor progressMonitor, byte[] bArr) throws java.io.IOException {
        zipOutputStream.putNextEntry(zipParameters);
        if (file.exists() && !file.isDirectory()) {
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
            while (true) {
                try {
                    int i = fileInputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    zipOutputStream.write(bArr, 0, i);
                    progressMonitor.updateWorkCompleted(i);
                    verifyIfTaskIsCancelled();
                } catch (java.lang.Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (java.lang.Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            fileInputStream.close();
        }
        closeEntry(zipOutputStream, splitOutputStream, file, false);
    }

    private void closeEntry(net.lingala.zip4j.io.outputstream.ZipOutputStream zipOutputStream, net.lingala.zip4j.io.outputstream.SplitOutputStream splitOutputStream, java.io.File file, boolean z) throws java.io.IOException {
        net.lingala.zip4j.model.FileHeader fileHeaderCloseEntry = zipOutputStream.closeEntry();
        byte[] fileAttributes = net.lingala.zip4j.util.FileUtils.getFileAttributes(file);
        if (!z) {
            fileAttributes[3] = net.lingala.zip4j.util.BitUtils.unsetBit(fileAttributes[3], 5);
        }
        fileHeaderCloseEntry.setExternalFileAttributes(fileAttributes);
        updateLocalFileHeader(fileHeaderCloseEntry, splitOutputStream);
    }

    long calculateWorkForFiles(java.util.List<java.io.File> list, net.lingala.zip4j.model.ZipParameters zipParameters) throws net.lingala.zip4j.exception.ZipException {
        long length;
        long length2 = 0;
        for (java.io.File file : list) {
            if (file.exists()) {
                if (zipParameters.isEncryptFiles() && zipParameters.getEncryptionMethod() == net.lingala.zip4j.model.enums.EncryptionMethod.ZIP_STANDARD) {
                    length = file.length() * 2;
                } else {
                    length = file.length();
                }
                length2 += length;
                net.lingala.zip4j.model.FileHeader fileHeader = net.lingala.zip4j.headers.HeaderUtil.getFileHeader(getZipModel(), net.lingala.zip4j.util.FileUtils.getRelativeFileName(file, zipParameters));
                if (fileHeader != null) {
                    length2 += getZipModel().getZipFile().length() - fileHeader.getCompressedSize();
                }
            }
        }
        return length2;
    }

    net.lingala.zip4j.io.outputstream.ZipOutputStream initializeOutputStream(net.lingala.zip4j.io.outputstream.SplitOutputStream splitOutputStream, net.lingala.zip4j.model.Zip4jConfig zip4jConfig) throws java.io.IOException {
        if (this.zipModel.getZipFile().exists()) {
            splitOutputStream.seek(net.lingala.zip4j.headers.HeaderUtil.getOffsetStartOfCentralDirectory(this.zipModel));
        }
        return new net.lingala.zip4j.io.outputstream.ZipOutputStream(splitOutputStream, this.password, zip4jConfig, this.zipModel);
    }

    void verifyZipParameters(net.lingala.zip4j.model.ZipParameters zipParameters) throws net.lingala.zip4j.exception.ZipException {
        if (zipParameters == null) {
            throw new net.lingala.zip4j.exception.ZipException("cannot validate zip parameters");
        }
        if (zipParameters.getCompressionMethod() != net.lingala.zip4j.model.enums.CompressionMethod.STORE && zipParameters.getCompressionMethod() != net.lingala.zip4j.model.enums.CompressionMethod.DEFLATE) {
            throw new net.lingala.zip4j.exception.ZipException("unsupported compression type");
        }
        if (zipParameters.isEncryptFiles()) {
            if (zipParameters.getEncryptionMethod() == net.lingala.zip4j.model.enums.EncryptionMethod.NONE) {
                throw new net.lingala.zip4j.exception.ZipException("Encryption method has to be set, when encrypt files flag is set");
            }
            char[] cArr = this.password;
            if (cArr == null || cArr.length <= 0) {
                throw new net.lingala.zip4j.exception.ZipException("input password is empty or null");
            }
            return;
        }
        zipParameters.setEncryptionMethod(net.lingala.zip4j.model.enums.EncryptionMethod.NONE);
    }

    void updateLocalFileHeader(net.lingala.zip4j.model.FileHeader fileHeader, net.lingala.zip4j.io.outputstream.SplitOutputStream splitOutputStream) throws java.io.IOException {
        this.headerWriter.updateLocalFileHeader(fileHeader, getZipModel(), splitOutputStream);
    }

    private net.lingala.zip4j.model.ZipParameters cloneAndAdjustZipParameters(net.lingala.zip4j.model.ZipParameters zipParameters, java.io.File file, net.lingala.zip4j.progress.ProgressMonitor progressMonitor) throws java.io.IOException {
        net.lingala.zip4j.model.ZipParameters zipParameters2 = new net.lingala.zip4j.model.ZipParameters(zipParameters);
        if (file.isDirectory()) {
            zipParameters2.setEntrySize(0L);
        } else {
            zipParameters2.setEntrySize(file.length());
        }
        if (zipParameters.getLastModifiedFileTime() <= 0) {
            zipParameters2.setLastModifiedFileTime(file.lastModified());
        }
        zipParameters2.setWriteExtendedLocalFileHeader(false);
        if (!net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(zipParameters.getFileNameInZip())) {
            zipParameters2.setFileNameInZip(net.lingala.zip4j.util.FileUtils.getRelativeFileName(file, zipParameters));
        }
        if (file.isDirectory()) {
            zipParameters2.setCompressionMethod(net.lingala.zip4j.model.enums.CompressionMethod.STORE);
            zipParameters2.setEncryptionMethod(net.lingala.zip4j.model.enums.EncryptionMethod.NONE);
            zipParameters2.setEncryptFiles(false);
            return zipParameters2;
        }
        if (zipParameters2.isEncryptFiles() && zipParameters2.getEncryptionMethod() == net.lingala.zip4j.model.enums.EncryptionMethod.ZIP_STANDARD) {
            progressMonitor.setCurrentTask(net.lingala.zip4j.progress.ProgressMonitor.Task.CALCULATE_CRC);
            zipParameters2.setEntryCRC(net.lingala.zip4j.util.CrcUtil.computeFileCrc(file, progressMonitor));
            progressMonitor.setCurrentTask(net.lingala.zip4j.progress.ProgressMonitor.Task.ADD_ENTRY);
        }
        if (file.length() == 0) {
            zipParameters2.setCompressionMethod(net.lingala.zip4j.model.enums.CompressionMethod.STORE);
        }
        return zipParameters2;
    }

    private java.util.List<java.io.File> removeFilesIfExists(java.util.List<java.io.File> list, net.lingala.zip4j.model.ZipParameters zipParameters, net.lingala.zip4j.progress.ProgressMonitor progressMonitor, net.lingala.zip4j.model.Zip4jConfig zip4jConfig) throws net.lingala.zip4j.exception.ZipException {
        java.util.ArrayList arrayList = new java.util.ArrayList(list);
        if (this.zipModel.getZipFile().exists()) {
            for (java.io.File file : list) {
                if (!net.lingala.zip4j.util.Zip4jUtil.isStringNotNullAndNotEmpty(file.getName())) {
                    arrayList.remove(file);
                }
                net.lingala.zip4j.model.FileHeader fileHeader = net.lingala.zip4j.headers.HeaderUtil.getFileHeader(this.zipModel, net.lingala.zip4j.util.FileUtils.getRelativeFileName(file, zipParameters));
                if (fileHeader != null) {
                    if (zipParameters.isOverrideExistingFilesInZip()) {
                        progressMonitor.setCurrentTask(net.lingala.zip4j.progress.ProgressMonitor.Task.REMOVE_ENTRY);
                        removeFile(fileHeader, progressMonitor, zip4jConfig);
                        verifyIfTaskIsCancelled();
                        progressMonitor.setCurrentTask(net.lingala.zip4j.progress.ProgressMonitor.Task.ADD_ENTRY);
                    } else {
                        arrayList.remove(file);
                    }
                }
            }
        }
        return arrayList;
    }

    void removeFile(net.lingala.zip4j.model.FileHeader fileHeader, net.lingala.zip4j.progress.ProgressMonitor progressMonitor, net.lingala.zip4j.model.Zip4jConfig zip4jConfig) throws net.lingala.zip4j.exception.ZipException {
        new net.lingala.zip4j.tasks.RemoveFilesFromZipTask(this.zipModel, this.headerWriter, new net.lingala.zip4j.tasks.AsyncZipTask.AsyncTaskParameters(null, false, progressMonitor)).execute(new net.lingala.zip4j.tasks.RemoveFilesFromZipTask.RemoveFilesFromZipTaskParameters(java.util.Collections.singletonList(fileHeader.getFileName()), zip4jConfig));
    }

    private java.lang.String replaceFileNameInZip(java.lang.String str, java.lang.String str2) {
        if (!str.contains("/")) {
            return str2;
        }
        return str.substring(0, str.lastIndexOf("/") + 1) + str2;
    }

    private boolean addSymlink(net.lingala.zip4j.model.ZipParameters zipParameters) {
        return net.lingala.zip4j.model.ZipParameters.SymbolicLinkAction.INCLUDE_LINK_ONLY.equals(zipParameters.getSymbolicLinkAction()) || net.lingala.zip4j.model.ZipParameters.SymbolicLinkAction.INCLUDE_LINK_AND_LINKED_FILE.equals(zipParameters.getSymbolicLinkAction());
    }

    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    protected net.lingala.zip4j.progress.ProgressMonitor.Task getTask() {
        return net.lingala.zip4j.progress.ProgressMonitor.Task.ADD_ENTRY;
    }

    protected net.lingala.zip4j.model.ZipModel getZipModel() {
        return this.zipModel;
    }
}
