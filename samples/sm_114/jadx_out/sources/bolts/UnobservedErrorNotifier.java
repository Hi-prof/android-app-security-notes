package bolts;

/* JADX INFO: loaded from: classes.dex */
class UnobservedErrorNotifier {
    private bolts.Task<?> task;

    public UnobservedErrorNotifier(bolts.Task<?> task) {
        this.task = task;
    }

    protected void finalize() throws java.lang.Throwable {
        bolts.Task.UnobservedExceptionHandler unobservedExceptionHandler;
        try {
            bolts.Task<?> task = this.task;
            if (task != null && (unobservedExceptionHandler = bolts.Task.getUnobservedExceptionHandler()) != null) {
                unobservedExceptionHandler.unobservedException(task, new bolts.UnobservedTaskException(task.getError()));
            }
        } finally {
            super.finalize();
        }
    }

    public void setObserved() {
        this.task = null;
    }
}
