package kotlinx.coroutines;

/* JADX INFO: compiled from: Delay.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u000e\u0010\u0005\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010\u0007\u001a\u0016\u0010\u0000\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u000b\u001a\u001b\u0010\u0000\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000b\u001a\u0016\u0010\u000f\u001a\u00020\n*\u00020\rH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, d2 = {io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_DELAY, "Lkotlinx/coroutines/Delay;", "Lkotlin/coroutines/CoroutineContext;", "getDelay", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Delay;", "awaitCancellation", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "timeMillis", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "duration", "Lkotlin/time/Duration;", "delay-VtjQ1oo", "toDelayMillis", "toDelayMillis-LRDsOJo", "(J)J", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class DelayKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.DelayKt$awaitCancellation$1, reason: invalid class name */
    /* JADX INFO: compiled from: Delay.kt */
    @kotlin.Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlinx.coroutines.DelayKt", f = "Delay.kt", i = {}, l = {com.alibaba.fastjson.asm.Opcodes.IF_ICMPNE}, m = "awaitCancellation", n = {}, s = {})
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.ContinuationImpl {
        int label;
        /* synthetic */ java.lang.Object result;

        AnonymousClass1(kotlin.coroutines.Continuation<? super kotlinx.coroutines.DelayKt.AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return kotlinx.coroutines.DelayKt.awaitCancellation(this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final java.lang.Object awaitCancellation(kotlin.coroutines.Continuation<?> continuation) {
        kotlinx.coroutines.DelayKt.AnonymousClass1 anonymousClass1;
        if (continuation instanceof kotlinx.coroutines.DelayKt.AnonymousClass1) {
            anonymousClass1 = (kotlinx.coroutines.DelayKt.AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new kotlinx.coroutines.DelayKt.AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new kotlinx.coroutines.DelayKt.AnonymousClass1(continuation);
        }
        java.lang.Object obj = anonymousClass1.result;
        java.lang.Object coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            kotlin.ResultKt.throwOnFailure(obj);
            anonymousClass1.label = 1;
            kotlinx.coroutines.DelayKt.AnonymousClass1 anonymousClass2 = anonymousClass1;
            kotlinx.coroutines.CancellableContinuationImpl cancellableContinuationImpl = new kotlinx.coroutines.CancellableContinuationImpl(kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(anonymousClass2), 1);
            cancellableContinuationImpl.initCancellability();
            java.lang.Object result = cancellableContinuationImpl.getResult();
            if (result == kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(anonymousClass2);
            }
            if (result == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.ResultKt.throwOnFailure(obj);
        }
        throw new kotlin.KotlinNothingValueException();
    }

    public static final java.lang.Object delay(long j, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        if (j <= 0) {
            return kotlin.Unit.INSTANCE;
        }
        kotlinx.coroutines.CancellableContinuationImpl cancellableContinuationImpl = new kotlinx.coroutines.CancellableContinuationImpl(kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        kotlinx.coroutines.CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        if (j < Long.MAX_VALUE) {
            getDelay(cancellableContinuationImpl2.getContext()).mo2147scheduleResumeAfterDelay(j, cancellableContinuationImpl2);
        }
        java.lang.Object result = cancellableContinuationImpl.getResult();
        if (result == kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: delay-VtjQ1oo, reason: not valid java name */
    public static final java.lang.Object m2078delayVtjQ1oo(long j, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        java.lang.Object objDelay = delay(m2079toDelayMillisLRDsOJo(j), continuation);
        return objDelay == kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDelay : kotlin.Unit.INSTANCE;
    }

    public static final kotlinx.coroutines.Delay getDelay(kotlin.coroutines.CoroutineContext coroutineContext) {
        kotlin.coroutines.CoroutineContext.Element element = coroutineContext.get(kotlin.coroutines.ContinuationInterceptor.INSTANCE);
        kotlinx.coroutines.Delay delay = element instanceof kotlinx.coroutines.Delay ? (kotlinx.coroutines.Delay) element : null;
        return delay == null ? kotlinx.coroutines.DefaultExecutorKt.getDefaultDelay() : delay;
    }

    /* JADX INFO: renamed from: toDelayMillis-LRDsOJo, reason: not valid java name */
    public static final long m2079toDelayMillisLRDsOJo(long j) {
        boolean zM1964isPositiveimpl = kotlin.time.Duration.m1964isPositiveimpl(j);
        if (zM1964isPositiveimpl) {
            kotlin.time.Duration.Companion companion = kotlin.time.Duration.INSTANCE;
            return kotlin.time.Duration.m1948getInWholeMillisecondsimpl(kotlin.time.Duration.m1966plusLRDsOJo(j, kotlin.time.DurationKt.toDuration(999999L, kotlin.time.DurationUnit.NANOSECONDS)));
        }
        if (zM1964isPositiveimpl) {
            throw new kotlin.NoWhenBranchMatchedException();
        }
        return 0L;
    }
}
