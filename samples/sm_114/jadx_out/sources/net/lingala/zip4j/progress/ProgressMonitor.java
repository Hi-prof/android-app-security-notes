package net.lingala.zip4j.progress;

/* JADX INFO: loaded from: classes2.dex */
public class ProgressMonitor {
    private boolean cancelAllTasks;
    private net.lingala.zip4j.progress.ProgressMonitor.Task currentTask;
    private java.lang.Exception exception;
    private java.lang.String fileName;
    private boolean pause;
    private int percentDone;
    private net.lingala.zip4j.progress.ProgressMonitor.Result result;
    private net.lingala.zip4j.progress.ProgressMonitor.State state;
    private long totalWork;
    private long workCompleted;

    public enum Result {
        SUCCESS,
        WORK_IN_PROGRESS,
        ERROR,
        CANCELLED
    }

    public enum State {
        READY,
        BUSY
    }

    public enum Task {
        NONE,
        ADD_ENTRY,
        REMOVE_ENTRY,
        CALCULATE_CRC,
        EXTRACT_ENTRY,
        MERGE_ZIP_FILES,
        SET_COMMENT,
        RENAME_FILE
    }

    public ProgressMonitor() {
        reset();
    }

    public void updateWorkCompleted(long j) {
        long j2 = this.workCompleted + j;
        this.workCompleted = j2;
        long j3 = this.totalWork;
        if (j3 > 0) {
            int i = (int) ((j2 * 100) / j3);
            this.percentDone = i;
            if (i > 100) {
                this.percentDone = 100;
            }
        }
        while (this.pause) {
            try {
                java.lang.Thread.sleep(150L);
            } catch (java.lang.InterruptedException unused) {
            }
        }
    }

    public void endProgressMonitor() {
        this.result = net.lingala.zip4j.progress.ProgressMonitor.Result.SUCCESS;
        this.percentDone = 100;
        reset();
    }

    public void endProgressMonitor(java.lang.Exception exc) {
        this.result = net.lingala.zip4j.progress.ProgressMonitor.Result.ERROR;
        this.exception = exc;
        reset();
    }

    public void fullReset() {
        reset();
        this.fileName = null;
        this.totalWork = 0L;
        this.workCompleted = 0L;
        this.percentDone = 0;
    }

    private void reset() {
        this.currentTask = net.lingala.zip4j.progress.ProgressMonitor.Task.NONE;
        this.state = net.lingala.zip4j.progress.ProgressMonitor.State.READY;
    }

    public net.lingala.zip4j.progress.ProgressMonitor.State getState() {
        return this.state;
    }

    public void setState(net.lingala.zip4j.progress.ProgressMonitor.State state) {
        this.state = state;
    }

    public long getTotalWork() {
        return this.totalWork;
    }

    public void setTotalWork(long j) {
        this.totalWork = j;
    }

    public long getWorkCompleted() {
        return this.workCompleted;
    }

    public int getPercentDone() {
        return this.percentDone;
    }

    public void setPercentDone(int i) {
        this.percentDone = i;
    }

    public net.lingala.zip4j.progress.ProgressMonitor.Task getCurrentTask() {
        return this.currentTask;
    }

    public void setCurrentTask(net.lingala.zip4j.progress.ProgressMonitor.Task task) {
        this.currentTask = task;
    }

    public java.lang.String getFileName() {
        return this.fileName;
    }

    public void setFileName(java.lang.String str) {
        this.fileName = str;
    }

    public net.lingala.zip4j.progress.ProgressMonitor.Result getResult() {
        return this.result;
    }

    public void setResult(net.lingala.zip4j.progress.ProgressMonitor.Result result) {
        this.result = result;
    }

    public java.lang.Exception getException() {
        return this.exception;
    }

    public void setException(java.lang.Exception exc) {
        this.exception = exc;
    }

    public boolean isCancelAllTasks() {
        return this.cancelAllTasks;
    }

    public void setCancelAllTasks(boolean z) {
        this.cancelAllTasks = z;
    }

    public boolean isPause() {
        return this.pause;
    }

    public void setPause(boolean z) {
        this.pause = z;
    }
}
