package net.lingala.zip4j.tasks;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AsyncZipTask<T> {
    private final java.util.concurrent.ExecutorService executorService;
    private final net.lingala.zip4j.progress.ProgressMonitor progressMonitor;
    private final boolean runInThread;

    protected abstract long calculateTotalWork(T t) throws net.lingala.zip4j.exception.ZipException;

    protected abstract void executeTask(T t, net.lingala.zip4j.progress.ProgressMonitor progressMonitor) throws java.io.IOException;

    protected abstract net.lingala.zip4j.progress.ProgressMonitor.Task getTask();

    public AsyncZipTask(net.lingala.zip4j.tasks.AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        this.progressMonitor = asyncTaskParameters.progressMonitor;
        this.runInThread = asyncTaskParameters.runInThread;
        this.executorService = asyncTaskParameters.executorService;
    }

    public void execute(final T t) throws net.lingala.zip4j.exception.ZipException {
        if (this.runInThread && net.lingala.zip4j.progress.ProgressMonitor.State.BUSY.equals(this.progressMonitor.getState())) {
            throw new net.lingala.zip4j.exception.ZipException("invalid operation - Zip4j is in busy state");
        }
        initProgressMonitor();
        if (this.runInThread) {
            this.progressMonitor.setTotalWork(calculateTotalWork(t));
            this.executorService.execute(new java.lang.Runnable() { // from class: net.lingala.zip4j.tasks.AsyncZipTask.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        net.lingala.zip4j.tasks.AsyncZipTask asyncZipTask = net.lingala.zip4j.tasks.AsyncZipTask.this;
                        asyncZipTask.performTaskWithErrorHandling(t, asyncZipTask.progressMonitor);
                    } catch (net.lingala.zip4j.exception.ZipException unused) {
                    } finally {
                        net.lingala.zip4j.tasks.AsyncZipTask.this.executorService.shutdown();
                    }
                }
            });
            return;
        }
        performTaskWithErrorHandling(t, this.progressMonitor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performTaskWithErrorHandling(T t, net.lingala.zip4j.progress.ProgressMonitor progressMonitor) throws net.lingala.zip4j.exception.ZipException {
        try {
            executeTask(t, progressMonitor);
            progressMonitor.endProgressMonitor();
        } catch (net.lingala.zip4j.exception.ZipException e) {
            progressMonitor.endProgressMonitor(e);
            throw e;
        } catch (java.lang.Exception e2) {
            progressMonitor.endProgressMonitor(e2);
            throw new net.lingala.zip4j.exception.ZipException(e2);
        }
    }

    protected void verifyIfTaskIsCancelled() throws net.lingala.zip4j.exception.ZipException {
        if (this.progressMonitor.isCancelAllTasks()) {
            this.progressMonitor.setResult(net.lingala.zip4j.progress.ProgressMonitor.Result.CANCELLED);
            this.progressMonitor.setState(net.lingala.zip4j.progress.ProgressMonitor.State.READY);
            throw new net.lingala.zip4j.exception.ZipException("Task cancelled", net.lingala.zip4j.exception.ZipException.Type.TASK_CANCELLED_EXCEPTION);
        }
    }

    private void initProgressMonitor() {
        this.progressMonitor.fullReset();
        this.progressMonitor.setState(net.lingala.zip4j.progress.ProgressMonitor.State.BUSY);
        this.progressMonitor.setCurrentTask(getTask());
    }

    public static class AsyncTaskParameters {
        private final java.util.concurrent.ExecutorService executorService;
        private final net.lingala.zip4j.progress.ProgressMonitor progressMonitor;
        private final boolean runInThread;

        public AsyncTaskParameters(java.util.concurrent.ExecutorService executorService, boolean z, net.lingala.zip4j.progress.ProgressMonitor progressMonitor) {
            this.executorService = executorService;
            this.runInThread = z;
            this.progressMonitor = progressMonitor;
        }
    }
}
