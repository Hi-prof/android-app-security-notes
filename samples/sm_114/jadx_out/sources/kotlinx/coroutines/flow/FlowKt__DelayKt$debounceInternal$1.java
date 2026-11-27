package kotlinx.coroutines.flow;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Delay.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "downstream", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {com.facebook.imageutils.JfifUtil.MARKER_RST7, 418}, m = "invokeSuspend", n = {"downstream", "values", "lastValue", "timeoutMillis", "downstream", "values", "lastValue"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
final class FlowKt__DelayKt$debounceInternal$1<T> extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function3<kotlinx.coroutines.CoroutineScope, kotlinx.coroutines.flow.FlowCollector<? super T>, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
    final /* synthetic */ kotlinx.coroutines.flow.Flow<T> $this_debounceInternal;
    final /* synthetic */ kotlin.jvm.functions.Function1<T, java.lang.Long> $timeoutMillisSelector;
    private /* synthetic */ java.lang.Object L$0;
    /* synthetic */ java.lang.Object L$1;
    java.lang.Object L$2;
    java.lang.Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__DelayKt$debounceInternal$1(kotlin.jvm.functions.Function1<? super T, java.lang.Long> function1, kotlinx.coroutines.flow.Flow<? extends T> flow, kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1> continuation) {
        super(3, continuation);
        this.$timeoutMillisSelector = function1;
        this.$this_debounceInternal = flow;
    }

    @Override // kotlin.jvm.functions.Function3
    public final java.lang.Object invoke(kotlinx.coroutines.CoroutineScope coroutineScope, kotlinx.coroutines.flow.FlowCollector<? super T> flowCollector, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$1 = new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1(this.$timeoutMillisSelector, this.$this_debounceInternal, continuation);
        flowKt__DelayKt$debounceInternal$1.L$0 = coroutineScope;
        flowKt__DelayKt$debounceInternal$1.L$1 = flowCollector;
        return flowKt__DelayKt$debounceInternal$1.invokeSuspend(kotlin.Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x006c  */
    /* JADX WARN: Code duplicated, block: B:16:0x0075  */
    /* JADX WARN: Code duplicated, block: B:18:0x007d  */
    /* JADX WARN: Code duplicated, block: B:21:0x0090  */
    /* JADX WARN: Code duplicated, block: B:23:0x0096  */
    /* JADX WARN: Code duplicated, block: B:25:0x009c  */
    /* JADX WARN: Code duplicated, block: B:30:0x00b3 A[PHI: r1 r7 r8 r9
  0x00b3: PHI (r1v3 kotlin.jvm.internal.Ref$LongRef) = (r1v5 kotlin.jvm.internal.Ref$LongRef), (r1v7 kotlin.jvm.internal.Ref$LongRef), (r1v7 kotlin.jvm.internal.Ref$LongRef) binds: [B:29:0x00b1, B:15:0x0073, B:22:0x0094] A[DONT_GENERATE, DONT_INLINE]
  0x00b3: PHI (r7v3 kotlin.jvm.internal.Ref$ObjectRef) = 
  (r7v5 kotlin.jvm.internal.Ref$ObjectRef)
  (r7v6 kotlin.jvm.internal.Ref$ObjectRef)
  (r7v6 kotlin.jvm.internal.Ref$ObjectRef)
 binds: [B:29:0x00b1, B:15:0x0073, B:22:0x0094] A[DONT_GENERATE, DONT_INLINE]
  0x00b3: PHI (r8v3 kotlinx.coroutines.channels.ReceiveChannel) = 
  (r8v5 kotlinx.coroutines.channels.ReceiveChannel)
  (r8v6 kotlinx.coroutines.channels.ReceiveChannel)
  (r8v6 kotlinx.coroutines.channels.ReceiveChannel)
 binds: [B:29:0x00b1, B:15:0x0073, B:22:0x0094] A[DONT_GENERATE, DONT_INLINE]
  0x00b3: PHI (r9v2 kotlinx.coroutines.flow.FlowCollector) = 
  (r9v7 kotlinx.coroutines.flow.FlowCollector)
  (r9v8 kotlinx.coroutines.flow.FlowCollector)
  (r9v8 kotlinx.coroutines.flow.FlowCollector)
 binds: [B:29:0x00b1, B:15:0x0073, B:22:0x0094] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:31:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:35:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:44:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:48:0x0116  */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ae, code lost:
    
        if (r9.emit(r10, r13) == r0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0113, code lost:
    
        if (r9.doSelect(r13) == r0) goto L47;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0113 -> B:7:0x0020). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            Method dump skipped, instruction units count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
