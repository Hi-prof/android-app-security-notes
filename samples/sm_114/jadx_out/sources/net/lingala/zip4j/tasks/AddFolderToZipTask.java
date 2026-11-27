package net.lingala.zip4j.tasks;

/* JADX INFO: loaded from: classes2.dex */
public class AddFolderToZipTask extends net.lingala.zip4j.tasks.AbstractAddFileToZipTask<net.lingala.zip4j.tasks.AddFolderToZipTask.AddFolderToZipTaskParameters> {
    public AddFolderToZipTask(net.lingala.zip4j.model.ZipModel zipModel, char[] cArr, net.lingala.zip4j.headers.HeaderWriter headerWriter, net.lingala.zip4j.tasks.AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(zipModel, cArr, headerWriter, asyncTaskParameters);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    public void executeTask(net.lingala.zip4j.tasks.AddFolderToZipTask.AddFolderToZipTaskParameters addFolderToZipTaskParameters, net.lingala.zip4j.progress.ProgressMonitor progressMonitor) throws java.io.IOException {
        java.util.List<java.io.File> filesToAdd = getFilesToAdd(addFolderToZipTaskParameters);
        setDefaultFolderPath(addFolderToZipTaskParameters);
        addFilesToZip(filesToAdd, progressMonitor, addFolderToZipTaskParameters.zipParameters, addFolderToZipTaskParameters.zip4jConfig);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    public long calculateTotalWork(net.lingala.zip4j.tasks.AddFolderToZipTask.AddFolderToZipTaskParameters addFolderToZipTaskParameters) throws net.lingala.zip4j.exception.ZipException {
        java.util.List<java.io.File> filesToAdd = getFilesToAdd(addFolderToZipTaskParameters);
        if (addFolderToZipTaskParameters.zipParameters.isIncludeRootFolder()) {
            filesToAdd.add(addFolderToZipTaskParameters.folderToAdd);
        }
        return calculateWorkForFiles(filesToAdd, addFolderToZipTaskParameters.zipParameters);
    }

    private void setDefaultFolderPath(net.lingala.zip4j.tasks.AddFolderToZipTask.AddFolderToZipTaskParameters addFolderToZipTaskParameters) throws java.io.IOException {
        java.lang.String canonicalPath;
        java.io.File file = addFolderToZipTaskParameters.folderToAdd;
        if (!addFolderToZipTaskParameters.zipParameters.isIncludeRootFolder() || file.getCanonicalFile().getParentFile() == null) {
            canonicalPath = file.getCanonicalPath();
        } else {
            canonicalPath = file.getCanonicalFile().getParentFile().getCanonicalPath();
        }
        addFolderToZipTaskParameters.zipParameters.setDefaultFolderPath(canonicalPath);
    }

    private java.util.List<java.io.File> getFilesToAdd(net.lingala.zip4j.tasks.AddFolderToZipTask.AddFolderToZipTaskParameters addFolderToZipTaskParameters) throws net.lingala.zip4j.exception.ZipException {
        java.util.List<java.io.File> filesInDirectoryRecursive = net.lingala.zip4j.util.FileUtils.getFilesInDirectoryRecursive(addFolderToZipTaskParameters.folderToAdd, addFolderToZipTaskParameters.zipParameters);
        if (addFolderToZipTaskParameters.zipParameters.isIncludeRootFolder()) {
            filesInDirectoryRecursive.add(addFolderToZipTaskParameters.folderToAdd);
        }
        return filesInDirectoryRecursive;
    }

    public static class AddFolderToZipTaskParameters extends net.lingala.zip4j.tasks.AbstractZipTaskParameters {
        private final java.io.File folderToAdd;
        private final net.lingala.zip4j.model.ZipParameters zipParameters;

        public AddFolderToZipTaskParameters(java.io.File file, net.lingala.zip4j.model.ZipParameters zipParameters, net.lingala.zip4j.model.Zip4jConfig zip4jConfig) {
            super(zip4jConfig);
            this.folderToAdd = file;
            this.zipParameters = zipParameters;
        }
    }
}
