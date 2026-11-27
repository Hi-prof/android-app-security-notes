package kotlin.reflect.jvm.internal.impl.storage;

/* JADX INFO: compiled from: locks.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CancellableSimpleLock extends kotlin.reflect.jvm.internal.impl.storage.DefaultSimpleLock {
    private final java.lang.Runnable checkCancelled;
    private final kotlin.jvm.functions.Function1<java.lang.InterruptedException, kotlin.Unit> interruptedExceptionHandler;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CancellableSimpleLock(java.util.concurrent.locks.Lock lock, java.lang.Runnable checkCancelled, kotlin.jvm.functions.Function1<? super java.lang.InterruptedException, kotlin.Unit> interruptedExceptionHandler) {
        super(lock);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lock, "lock");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(checkCancelled, "checkCancelled");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(interruptedExceptionHandler, "interruptedExceptionHandler");
        this.checkCancelled = checkCancelled;
        this.interruptedExceptionHandler = interruptedExceptionHandler;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CancellableSimpleLock(java.lang.Runnable checkCancelled, kotlin.jvm.functions.Function1<? super java.lang.InterruptedException, kotlin.Unit> interruptedExceptionHandler) {
        this(new java.util.concurrent.locks.ReentrantLock(), checkCancelled, interruptedExceptionHandler);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(checkCancelled, "checkCancelled");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(interruptedExceptionHandler, "interruptedExceptionHandler");
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.DefaultSimpleLock, kotlin.reflect.jvm.internal.impl.storage.SimpleLock
    public void lock() {
        while (!getLock().tryLock(50L, java.util.concurrent.TimeUnit.MILLISECONDS)) {
            try {
                this.checkCancelled.run();
            } catch (java.lang.InterruptedException e) {
                this.interruptedExceptionHandler.invoke(e);
                return;
            }
        }
    }
}
