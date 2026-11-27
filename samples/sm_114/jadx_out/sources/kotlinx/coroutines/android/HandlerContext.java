package kotlinx.coroutines.android;

/* JADX INFO: compiled from: HandlerDispatcher.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001c\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\u0013j\u0002`\u0014H\u0002J\u001c\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\u0013j\u0002`\u0014H\u0016J\u0013\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\n\u0010\u0012\u001a\u00060\u0013j\u0002`\u00142\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001e\u0010 \u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\"H\u0016J\b\u0010#\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u0000X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lkotlinx/coroutines/android/HandlerContext;", "Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/Delay;", "handler", "Landroid/os/Handler;", "name", "", "(Landroid/os/Handler;Ljava/lang/String;)V", "invokeImmediately", "", "(Landroid/os/Handler;Ljava/lang/String;Z)V", "immediate", "getImmediate", "()Lkotlinx/coroutines/android/HandlerContext;", "cancelOnRejection", "", "context", "Lkotlin/coroutines/CoroutineContext;", io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_BLOCK, "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatch", "equals", "other", "", "hashCode", "", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "isDispatchNeeded", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "kotlinx-coroutines-android"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class HandlerContext extends kotlinx.coroutines.android.HandlerDispatcher implements kotlinx.coroutines.Delay {
    private final android.os.Handler handler;
    private final kotlinx.coroutines.android.HandlerContext immediate;
    private final boolean invokeImmediately;
    private final java.lang.String name;

    private HandlerContext(android.os.Handler handler, java.lang.String str, boolean z) {
        super(null);
        this.handler = handler;
        this.name = str;
        this.invokeImmediately = z;
        this.immediate = z ? this : new kotlinx.coroutines.android.HandlerContext(handler, str, true);
    }

    public /* synthetic */ HandlerContext(android.os.Handler handler, java.lang.String str, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(handler, (i & 2) != 0 ? null : str);
    }

    public HandlerContext(android.os.Handler handler, java.lang.String str) {
        this(handler, str, false);
    }

    @Override // kotlinx.coroutines.android.HandlerDispatcher, kotlinx.coroutines.MainCoroutineDispatcher
    public kotlinx.coroutines.android.HandlerContext getImmediate() {
        return this.immediate;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(kotlin.coroutines.CoroutineContext context) {
        return (this.invokeImmediately && kotlin.jvm.internal.Intrinsics.areEqual(android.os.Looper.myLooper(), this.handler.getLooper())) ? false : true;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    /* JADX INFO: renamed from: dispatch */
    public void mo2146dispatch(kotlin.coroutines.CoroutineContext context, java.lang.Runnable block) {
        if (this.handler.post(block)) {
            return;
        }
        cancelOnRejection(context, block);
    }

    @Override // kotlinx.coroutines.android.HandlerDispatcher, kotlinx.coroutines.Delay
    public kotlinx.coroutines.DisposableHandle invokeOnTimeout(long timeMillis, final java.lang.Runnable block, kotlin.coroutines.CoroutineContext context) {
        if (this.handler.postDelayed(block, kotlin.ranges.RangesKt.coerceAtMost(timeMillis, kotlin.time.DurationKt.MAX_MILLIS))) {
            return new kotlinx.coroutines.DisposableHandle() { // from class: kotlinx.coroutines.android.HandlerContext$$ExternalSyntheticLambda0
                @Override // kotlinx.coroutines.DisposableHandle
                public final void dispose() {
                    kotlinx.coroutines.android.HandlerContext.invokeOnTimeout$lambda$2(this.f$0, block);
                }
            };
        }
        cancelOnRejection(context, block);
        return kotlinx.coroutines.NonDisposableHandle.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeOnTimeout$lambda$2(kotlinx.coroutines.android.HandlerContext handlerContext, java.lang.Runnable runnable) {
        handlerContext.handler.removeCallbacks(runnable);
    }

    private final void cancelOnRejection(kotlin.coroutines.CoroutineContext context, java.lang.Runnable block) {
        kotlinx.coroutines.JobKt.cancel(context, new java.util.concurrent.CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        kotlinx.coroutines.Dispatchers.getIO().mo2146dispatch(context, block);
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher
    public java.lang.String toString() {
        java.lang.String stringInternalImpl = toStringInternalImpl();
        if (stringInternalImpl != null) {
            return stringInternalImpl;
        }
        java.lang.String string = this.name;
        if (string == null) {
            string = this.handler.toString();
        }
        if (!this.invokeImmediately) {
            return string;
        }
        return string + ".immediate";
    }

    public boolean equals(java.lang.Object other) {
        if (!(other instanceof kotlinx.coroutines.android.HandlerContext)) {
            return false;
        }
        kotlinx.coroutines.android.HandlerContext handlerContext = (kotlinx.coroutines.android.HandlerContext) other;
        return handlerContext.handler == this.handler && handlerContext.invokeImmediately == this.invokeImmediately;
    }

    public int hashCode() {
        return java.lang.System.identityHashCode(this.handler) ^ (this.invokeImmediately ? 1231 : 1237);
    }

    @Override // kotlinx.coroutines.Delay
    /* JADX INFO: renamed from: scheduleResumeAfterDelay */
    public void mo2147scheduleResumeAfterDelay(long timeMillis, final kotlinx.coroutines.CancellableContinuation<? super kotlin.Unit> continuation) {
        final java.lang.Runnable runnable = new java.lang.Runnable() { // from class: kotlinx.coroutines.android.HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                continuation.resumeUndispatched(this, kotlin.Unit.INSTANCE);
            }
        };
        if (this.handler.postDelayed(runnable, kotlin.ranges.RangesKt.coerceAtMost(timeMillis, kotlin.time.DurationKt.MAX_MILLIS))) {
            continuation.invokeOnCancellation(new kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit>() { // from class: kotlinx.coroutines.android.HandlerContext.scheduleResumeAfterDelay.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.Unit invoke(java.lang.Throwable th) {
                    invoke2(th);
                    return kotlin.Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(java.lang.Throwable th) {
                    kotlinx.coroutines.android.HandlerContext.this.handler.removeCallbacks(runnable);
                }
            });
        } else {
            cancelOnRejection(continuation.getContext(), runnable);
        }
    }
}
