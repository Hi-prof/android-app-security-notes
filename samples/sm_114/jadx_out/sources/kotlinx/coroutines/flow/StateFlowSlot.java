package kotlinx.coroutines.flow;

/* JADX INFO: compiled from: StateFlow.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016J\u000e\u0010\u000b\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\rJ'\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00100\u000f2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\fJ\u0006\u0010\u0013\u001a\u00020\tR\"\u0010\u0004\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowSlot;", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "Lkotlinx/coroutines/flow/StateFlowImpl;", "()V", "_state", "Ljava/util/concurrent/atomic/AtomicReference;", "", "Lkotlinx/coroutines/internal/WorkaroundAtomicReference;", "allocateLocked", "", "flow", "awaitPending", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "freeLocked", "", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/flow/StateFlowImpl;)[Lkotlin/coroutines/Continuation;", "makePending", "takePending", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class StateFlowSlot extends kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlinx.coroutines.flow.StateFlowImpl<?>> {
    private final java.util.concurrent.atomic.AtomicReference<java.lang.Object> _state = new java.util.concurrent.atomic.AtomicReference<>(null);

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public boolean allocateLocked(kotlinx.coroutines.flow.StateFlowImpl<?> flow) {
        if (kotlinx.coroutines.internal.Concurrent_commonKt.getValue(this._state) != null) {
            return false;
        }
        kotlinx.coroutines.internal.Concurrent_commonKt.setValue(this._state, kotlinx.coroutines.flow.StateFlowKt.NONE);
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public kotlin.coroutines.Continuation<kotlin.Unit>[] freeLocked(kotlinx.coroutines.flow.StateFlowImpl<?> flow) {
        kotlinx.coroutines.internal.Concurrent_commonKt.setValue(this._state, null);
        return kotlinx.coroutines.flow.internal.AbstractSharedFlowKt.EMPTY_RESUMES;
    }

    public final void makePending() {
        java.util.concurrent.atomic.AtomicReference<java.lang.Object> atomicReference = this._state;
        while (true) {
            java.lang.Object value = kotlinx.coroutines.internal.Concurrent_commonKt.getValue(atomicReference);
            if (value == null || value == kotlinx.coroutines.flow.StateFlowKt.PENDING) {
                return;
            }
            if (value == kotlinx.coroutines.flow.StateFlowKt.NONE) {
                if (androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this._state, value, kotlinx.coroutines.flow.StateFlowKt.PENDING)) {
                    return;
                }
            } else if (androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this._state, value, kotlinx.coroutines.flow.StateFlowKt.NONE)) {
                kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
                ((kotlinx.coroutines.CancellableContinuationImpl) value).resumeWith(kotlin.Result.m541constructorimpl(kotlin.Unit.INSTANCE));
                return;
            }
        }
    }

    public final boolean takePending() {
        java.lang.Object andSet = this._state.getAndSet(kotlinx.coroutines.flow.StateFlowKt.NONE);
        kotlin.jvm.internal.Intrinsics.checkNotNull(andSet);
        if (kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED() && (andSet instanceof kotlinx.coroutines.CancellableContinuationImpl)) {
            throw new java.lang.AssertionError();
        }
        return andSet == kotlinx.coroutines.flow.StateFlowKt.PENDING;
    }

    public final java.lang.Object awaitPending(kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        kotlinx.coroutines.CancellableContinuationImpl cancellableContinuationImpl = new kotlinx.coroutines.CancellableContinuationImpl(kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        kotlinx.coroutines.CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        if (kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED() && (kotlinx.coroutines.internal.Concurrent_commonKt.getValue(this._state) instanceof kotlinx.coroutines.CancellableContinuationImpl)) {
            throw new java.lang.AssertionError();
        }
        if (!androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this._state, kotlinx.coroutines.flow.StateFlowKt.NONE, cancellableContinuationImpl2)) {
            if (kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED() && kotlinx.coroutines.internal.Concurrent_commonKt.getValue(this._state) != kotlinx.coroutines.flow.StateFlowKt.PENDING) {
                throw new java.lang.AssertionError();
            }
            kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
            cancellableContinuationImpl2.resumeWith(kotlin.Result.m541constructorimpl(kotlin.Unit.INSTANCE));
        }
        java.lang.Object result = cancellableContinuationImpl.getResult();
        if (result == kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : kotlin.Unit.INSTANCE;
    }
}
