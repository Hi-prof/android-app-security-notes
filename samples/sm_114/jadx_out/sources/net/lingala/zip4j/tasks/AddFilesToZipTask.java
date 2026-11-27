package net.lingala.zip4j.tasks;

/* JADX INFO: loaded from: classes2.dex */
public class AddFilesToZipTask extends net.lingala.zip4j.tasks.AbstractAddFileToZipTask<net.lingala.zip4j.tasks.AddFilesToZipTask.AddFilesToZipTaskParameters> {
    public AddFilesToZipTask(net.lingala.zip4j.model.ZipModel zipModel, char[] cArr, net.lingala.zip4j.headers.HeaderWriter headerWriter, net.lingala.zip4j.tasks.AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(zipModel, cArr, headerWriter, asyncTaskParameters);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    public void executeTask(net.lingala.zip4j.tasks.AddFilesToZipTask.AddFilesToZipTaskParameters addFilesToZipTaskParameters, net.lingala.zip4j.progress.ProgressMonitor progressMonitor) throws java.io.IOException {
        verifyZipParameters(addFilesToZipTaskParameters.zipParameters);
        addFilesToZip(determineActualFilesToAdd(addFilesToZipTaskParameters), progressMonitor, addFilesToZipTaskParameters.zipParameters, addFilesToZipTaskParameters.zip4jConfig);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    public long calculateTotalWork(net.lingala.zip4j.tasks.AddFilesToZipTask.AddFilesToZipTaskParameters addFilesToZipTaskParameters) throws net.lingala.zip4j.exception.ZipException {
        return calculateWorkForFiles(addFilesToZipTaskParameters.filesToAdd, addFilesToZipTaskParameters.zipParameters);
    }

    private java.util.List<java.io.File> determineActualFilesToAdd(net.lingala.zip4j.tasks.AddFilesToZipTask.AddFilesToZipTaskParameters addFilesToZipTaskParameters) throws net.lingala.zip4j.exception.ZipException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.io.File file : addFilesToZipTaskParameters.filesToAdd) {
            arrayList.add(file);
            boolean zIsSymbolicLink = net.lingala.zip4j.util.FileUtils.isSymbolicLink(file);
            net.lingala.zip4j.model.ZipParameters.SymbolicLinkAction symbolicLinkAction = addFilesToZipTaskParameters.zipParameters.getSymbolicLinkAction();
            if (zIsSymbolicLink && !net.lingala.zip4j.model.ZipParameters.SymbolicLinkAction.INCLUDE_LINK_ONLY.equals(symbolicLinkAction)) {
                arrayList.addAll(net.lingala.zip4j.util.FileUtils.getFilesInDirectoryRecursive(file, addFilesToZipTaskParameters.zipParameters));
            }
        }
        return arrayList;
    }

    @Override // net.lingala.zip4j.tasks.AbstractAddFileToZipTask, net.lingala.zip4j.tasks.AsyncZipTask
    protected net.lingala.zip4j.progress.ProgressMonitor.Task getTask() {
        return super.getTask();
    }

    public static class AddFilesToZipTaskParameters extends net.lingala.zip4j.tasks.AbstractZipTaskParameters {
        private final java.util.List<java.io.File> filesToAdd;
        private final net.lingala.zip4j.model.ZipParameters zipParameters;

        public AddFilesToZipTaskParameters(java.util.List<java.io.File> list, net.lingala.zip4j.model.ZipParameters zipParameters, net.lingala.zip4j.model.Zip4jConfig zip4jConfig) {
            super(zip4jConfig);
            this.filesToAdd = list;
            this.zipParameters = zipParameters;
        }
    }
}
