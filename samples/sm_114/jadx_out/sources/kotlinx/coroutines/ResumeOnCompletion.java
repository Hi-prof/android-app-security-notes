package kotlinx.coroutines;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/ResumeOnCompletion;", "Lkotlinx/coroutines/JobNode;", "continuation", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/coroutines/Continuation;)V", "invoke", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class ResumeOnCompletion extends kotlinx.coroutines.JobNode {
    private final kotlin.coroutines.Continuation<kotlin.Unit> continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public ResumeOnCompletion(kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        this.continuation = continuation;
    }

    @Override // kotlinx.coroutines.InternalCompletionHandler
    public void invoke(java.lang.Throwable cause) {
        kotlin.coroutines.Continuation<kotlin.Unit> continuation = this.continuation;
        kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
        continuation.resumeWith(kotlin.Result.m541constructorimpl(kotlin.Unit.INSTANCE));
    }
}
