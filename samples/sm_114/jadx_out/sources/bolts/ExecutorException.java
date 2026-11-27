package bolts;

/* JADX INFO: loaded from: classes.dex */
public class ExecutorException extends java.lang.RuntimeException {
    public ExecutorException(java.lang.Exception exc) {
        super("An exception was thrown by an Executor", exc);
    }
}
