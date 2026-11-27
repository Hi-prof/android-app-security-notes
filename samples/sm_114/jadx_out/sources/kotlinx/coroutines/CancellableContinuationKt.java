package kotlinx.coroutines;

/* JADX INFO: compiled from: CancellableContinuation.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000\u001a0\u0010\u0005\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0086H¢\u0006\u0002\u0010\n\u001a0\u0010\u000b\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0001\u0012\u0004\u0012\u00020\t0\u0007H\u0080H¢\u0006\u0002\u0010\n\u001a\u0018\u0010\f\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\r\u001a\u00020\u000eH\u0007\u001a \u0010\u000f\u001a\u00020\t\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¨\u0006\u0012"}, d2 = {"getOrCreateCancellableContinuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "delegate", "Lkotlin/coroutines/Continuation;", "suspendCancellableCoroutine", io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_BLOCK, "Lkotlin/Function1;", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "suspendCancellableCoroutineReusable", "disposeOnCancellation", "handle", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCancellation", "handler", "Lkotlinx/coroutines/CancelHandler;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class CancellableContinuationKt {
    public static final <T> void invokeOnCancellation(kotlinx.coroutines.CancellableContinuation<? super T> cancellableContinuation, kotlinx.coroutines.CancelHandler cancelHandler) {
        if (!(cancellableContinuation instanceof kotlinx.coroutines.CancellableContinuationImpl)) {
            throw new java.lang.UnsupportedOperationException("third-party implementation of CancellableContinuation is not supported");
        }
        ((kotlinx.coroutines.CancellableContinuationImpl) cancellableContinuation).invokeOnCancellationInternal$kotlinx_coroutines_core(cancelHandler);
    }

    private static final <T> java.lang.Object suspendCancellableCoroutine$$forInline(kotlin.jvm.functions.Function1<? super kotlinx.coroutines.CancellableContinuation<? super T>, kotlin.Unit> function1, kotlin.coroutines.Continuation<? super T> continuation) {
        kotlinx.coroutines.CancellableContinuationImpl cancellableContinuationImpl = new kotlinx.coroutines.CancellableContinuationImpl(kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        function1.invoke2(cancellableContinuationImpl);
        java.lang.Object result = cancellableContinuationImpl.getResult();
        if (result == kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final <T> java.lang.Object suspendCancellableCoroutine(kotlin.jvm.functions.Function1<? super kotlinx.coroutines.CancellableContinuation<? super T>, kotlin.Unit> function1, kotlin.coroutines.Continuation<? super T> continuation) {
        kotlinx.coroutines.CancellableContinuationImpl cancellableContinuationImpl = new kotlinx.coroutines.CancellableContinuationImpl(kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        function1.invoke2(cancellableContinuationImpl);
        java.lang.Object result = cancellableContinuationImpl.getResult();
        if (result == kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private static final <T> java.lang.Object suspendCancellableCoroutineReusable$$forInline(kotlin.jvm.functions.Function1<? super kotlinx.coroutines.CancellableContinuationImpl<? super T>, kotlin.Unit> function1, kotlin.coroutines.Continuation<? super T> continuation) {
        kotlinx.coroutines.CancellableContinuationImpl orCreateCancellableContinuation = getOrCreateCancellableContinuation(kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(continuation));
        try {
            function1.invoke2(orCreateCancellableContinuation);
            java.lang.Object result = orCreateCancellableContinuation.getResult();
            if (result == kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        } catch (java.lang.Throwable th) {
            orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw th;
        }
    }

    public static final <T> java.lang.Object suspendCancellableCoroutineReusable(kotlin.jvm.functions.Function1<? super kotlinx.coroutines.CancellableContinuationImpl<? super T>, kotlin.Unit> function1, kotlin.coroutines.Continuation<? super T> continuation) {
        kotlinx.coroutines.CancellableContinuationImpl orCreateCancellableContinuation = getOrCreateCancellableContinuation(kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(continuation));
        try {
            function1.invoke2(orCreateCancellableContinuation);
            java.lang.Object result = orCreateCancellableContinuation.getResult();
            if (result == kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        } catch (java.lang.Throwable th) {
            orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw th;
        }
    }

    public static final <T> kotlinx.coroutines.CancellableContinuationImpl<T> getOrCreateCancellableContinuation(kotlin.coroutines.Continuation<? super T> continuation) {
        if (!(continuation instanceof kotlinx.coroutines.internal.DispatchedContinuation)) {
            return new kotlinx.coroutines.CancellableContinuationImpl<>(continuation, 1);
        }
        kotlinx.coroutines.CancellableContinuationImpl<T> cancellableContinuationImplClaimReusableCancellableContinuation$kotlinx_coroutines_core = ((kotlinx.coroutines.internal.DispatchedContinuation) continuation).claimReusableCancellableContinuation$kotlinx_coroutines_core();
        if (cancellableContinuationImplClaimReusableCancellableContinuation$kotlinx_coroutines_core != null) {
            if (!cancellableContinuationImplClaimReusableCancellableContinuation$kotlinx_coroutines_core.resetStateReusable()) {
                cancellableContinuationImplClaimReusableCancellableContinuation$kotlinx_coroutines_core = null;
            }
            if (cancellableContinuationImplClaimReusableCancellableContinuation$kotlinx_coroutines_core != null) {
                return cancellableContinuationImplClaimReusableCancellableContinuation$kotlinx_coroutines_core;
            }
        }
        return new kotlinx.coroutines.CancellableContinuationImpl<>(continuation, 2);
    }

    public static final void disposeOnCancellation(kotlinx.coroutines.CancellableContinuation<?> cancellableContinuation, kotlinx.coroutines.DisposableHandle disposableHandle) {
        invokeOnCancellation(cancellableContinuation, new kotlinx.coroutines.DisposeOnCancel(disposableHandle));
    }
}
