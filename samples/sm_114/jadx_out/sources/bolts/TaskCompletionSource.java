package bolts;

/* JADX INFO: loaded from: classes.dex */
public class TaskCompletionSource<TResult> {
    private final bolts.Task<TResult> task = new bolts.Task<>();

    public bolts.Task<TResult> getTask() {
        return this.task;
    }

    public boolean trySetCancelled() {
        return this.task.trySetCancelled();
    }

    public boolean trySetResult(TResult tresult) {
        return this.task.trySetResult(tresult);
    }

    public boolean trySetError(java.lang.Exception exc) {
        return this.task.trySetError(exc);
    }

    public void setCancelled() {
        if (!trySetCancelled()) {
            throw new java.lang.IllegalStateException("Cannot cancel a completed task.");
        }
    }

    public void setResult(TResult tresult) {
        if (!trySetResult(tresult)) {
            throw new java.lang.IllegalStateException("Cannot set the result of a completed task.");
        }
    }

    public void setError(java.lang.Exception exc) {
        if (!trySetError(exc)) {
            throw new java.lang.IllegalStateException("Cannot set the error on a completed task.");
        }
    }
}
