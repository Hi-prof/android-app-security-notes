package net.lingala.zip4j.tasks;

/* JADX INFO: loaded from: classes2.dex */
public class SetCommentTask extends net.lingala.zip4j.tasks.AsyncZipTask<net.lingala.zip4j.tasks.SetCommentTask.SetCommentTaskTaskParameters> {
    private final net.lingala.zip4j.model.ZipModel zipModel;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    public long calculateTotalWork(net.lingala.zip4j.tasks.SetCommentTask.SetCommentTaskTaskParameters setCommentTaskTaskParameters) {
        return 0L;
    }

    public SetCommentTask(net.lingala.zip4j.model.ZipModel zipModel, net.lingala.zip4j.tasks.AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(asyncTaskParameters);
        this.zipModel = zipModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    public void executeTask(net.lingala.zip4j.tasks.SetCommentTask.SetCommentTaskTaskParameters setCommentTaskTaskParameters, net.lingala.zip4j.progress.ProgressMonitor progressMonitor) throws java.io.IOException {
        if (setCommentTaskTaskParameters.comment == null) {
            throw new net.lingala.zip4j.exception.ZipException("comment is null, cannot update Zip file with comment");
        }
        net.lingala.zip4j.model.EndOfCentralDirectoryRecord endOfCentralDirectoryRecord = this.zipModel.getEndOfCentralDirectoryRecord();
        endOfCentralDirectoryRecord.setComment(setCommentTaskTaskParameters.comment);
        net.lingala.zip4j.io.outputstream.SplitOutputStream splitOutputStream = new net.lingala.zip4j.io.outputstream.SplitOutputStream(this.zipModel.getZipFile());
        try {
            if (this.zipModel.isZip64Format()) {
                splitOutputStream.seek(this.zipModel.getZip64EndOfCentralDirectoryRecord().getOffsetStartCentralDirectoryWRTStartDiskNumber());
            } else {
                splitOutputStream.seek(endOfCentralDirectoryRecord.getOffsetOfStartOfCentralDirectory());
            }
            new net.lingala.zip4j.headers.HeaderWriter().finalizeZipFileWithoutValidations(this.zipModel, splitOutputStream, setCommentTaskTaskParameters.zip4jConfig.getCharset());
            splitOutputStream.close();
        } catch (java.lang.Throwable th) {
            try {
                splitOutputStream.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // net.lingala.zip4j.tasks.AsyncZipTask
    protected net.lingala.zip4j.progress.ProgressMonitor.Task getTask() {
        return net.lingala.zip4j.progress.ProgressMonitor.Task.SET_COMMENT;
    }

    public static class SetCommentTaskTaskParameters extends net.lingala.zip4j.tasks.AbstractZipTaskParameters {
        private java.lang.String comment;

        public SetCommentTaskTaskParameters(java.lang.String str, net.lingala.zip4j.model.Zip4jConfig zip4jConfig) {
            super(zip4jConfig);
            this.comment = str;
        }
    }
}
