package kotlinx.coroutines;

/* JADX INFO: compiled from: Interruptible.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0006\u0010\u0015\u001a\u00020\rR\t\u0010\u0005\u001a\u00020\u0006X\u0082\u0004R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/ThreadState;", "Lkotlinx/coroutines/InternalCompletionHandler;", "job", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;)V", "_state", "Lkotlinx/atomicfu/AtomicInt;", "cancelHandle", "Lkotlinx/coroutines/DisposableHandle;", "targetThread", "Ljava/lang/Thread;", "kotlin.jvm.PlatformType", "clearInterrupt", "", "invalidState", "", "state", "", "invoke", "cause", "", "setup", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class ThreadState implements kotlinx.coroutines.InternalCompletionHandler {
    private static final /* synthetic */ java.util.concurrent.atomic.AtomicIntegerFieldUpdater _state$volatile$FU = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(kotlinx.coroutines.ThreadState.class, "_state$volatile");
    private volatile /* synthetic */ int _state$volatile;
    private kotlinx.coroutines.DisposableHandle cancelHandle;
    private final kotlinx.coroutines.Job job;
    private final java.lang.Thread targetThread = java.lang.Thread.currentThread();

    private final /* synthetic */ int get_state$volatile() {
        return this._state$volatile;
    }

    private final /* synthetic */ void loop$atomicfu(java.lang.Object obj, java.util.concurrent.atomic.AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> function1) {
        while (true) {
            function1.invoke(java.lang.Integer.valueOf(atomicIntegerFieldUpdater.get(obj)));
        }
    }

    private final /* synthetic */ void set_state$volatile(int i) {
        this._state$volatile = i;
    }

    public ThreadState(kotlinx.coroutines.Job job) {
        this.job = job;
    }

    public final void setup() {
        int i;
        this.cancelHandle = kotlinx.coroutines.JobKt.invokeOnCompletion(this.job, true, true, this);
        java.util.concurrent.atomic.AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _state$volatile$FU;
        do {
            i = atomicIntegerFieldUpdater.get(this);
            if (i != 0) {
                if (i == 2 || i == 3) {
                    return;
                }
                invalidState(i);
                throw new kotlin.KotlinNothingValueException();
            }
        } while (!_state$volatile$FU.compareAndSet(this, i, 0));
    }

    public final void clearInterrupt() {
        java.util.concurrent.atomic.AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _state$volatile$FU;
        while (true) {
            int i = atomicIntegerFieldUpdater.get(this);
            if (i != 0) {
                if (i != 2) {
                    if (i == 3) {
                        java.lang.Thread.interrupted();
                        return;
                    } else {
                        invalidState(i);
                        throw new kotlin.KotlinNothingValueException();
                    }
                }
            } else if (_state$volatile$FU.compareAndSet(this, i, 1)) {
                kotlinx.coroutines.DisposableHandle disposableHandle = this.cancelHandle;
                if (disposableHandle != null) {
                    disposableHandle.dispose();
                    return;
                }
                return;
            }
        }
    }

    @Override // kotlinx.coroutines.InternalCompletionHandler
    public void invoke(java.lang.Throwable cause) {
        int i;
        java.util.concurrent.atomic.AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _state$volatile$FU;
        do {
            i = atomicIntegerFieldUpdater.get(this);
            if (i != 0) {
                if (i == 1 || i == 2 || i == 3) {
                    return;
                }
                invalidState(i);
                throw new kotlin.KotlinNothingValueException();
            }
        } while (!_state$volatile$FU.compareAndSet(this, i, 2));
        this.targetThread.interrupt();
        _state$volatile$FU.set(this, 3);
    }

    private final java.lang.Void invalidState(int state) {
        throw new java.lang.IllegalStateException(("Illegal state " + state).toString());
    }
}
