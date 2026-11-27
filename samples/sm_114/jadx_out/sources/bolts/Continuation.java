package bolts;

/* JADX INFO: loaded from: classes.dex */
public interface Continuation<TTaskResult, TContinuationResult> {
    TContinuationResult then(bolts.Task<TTaskResult> task) throws java.lang.Exception;
}
