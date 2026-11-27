package io.dcloud.uts;

/* JADX INFO: compiled from: UTSArray.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "io.dcloud.uts.UTSArray$Companion$fromAsync$p$1$1", f = "UTSArray.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class UTSArray$Companion$fromAsync$p$1$1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
    final /* synthetic */ io.dcloud.uts.UTSValueIterable<?> $list;
    final /* synthetic */ kotlin.jvm.functions.Function2<java.lang.Object, java.lang.Number, T> $mapFn;
    final /* synthetic */ kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> $rejectParam;
    final /* synthetic */ kotlin.jvm.functions.Function1<io.dcloud.uts.UTSArray<T>, kotlin.Unit> $resolveParam;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    UTSArray$Companion$fromAsync$p$1$1(io.dcloud.uts.UTSValueIterable<?> uTSValueIterable, kotlin.jvm.functions.Function1<? super io.dcloud.uts.UTSArray<T>, kotlin.Unit> function1, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function2, kotlin.jvm.functions.Function2<java.lang.Object, ? super java.lang.Number, ? extends T> function3, kotlin.coroutines.Continuation<? super io.dcloud.uts.UTSArray$Companion$fromAsync$p$1$1> continuation) {
        super(2, continuation);
        this.$list = uTSValueIterable;
        this.$resolveParam = function1;
        this.$rejectParam = function2;
        this.$mapFn = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object obj, kotlin.coroutines.Continuation<?> continuation) {
        return new io.dcloud.uts.UTSArray$Companion$fromAsync$p$1$1(this.$list, this.$resolveParam, this.$rejectParam, this.$mapFn, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final java.lang.Object invoke(kotlinx.coroutines.CoroutineScope coroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return ((io.dcloud.uts.UTSArray$Companion$fromAsync$p$1$1) create(coroutineScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object obj) throws java.lang.InterruptedException {
        kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.ResultKt.throwOnFailure(obj);
        io.dcloud.uts.UTSArray uTSArray = new io.dcloud.uts.UTSArray();
        java.util.Iterator itWithIndex = kotlin.collections.CollectionsKt.withIndex(this.$list.valueIterator());
        kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function1 = this.$rejectParam;
        kotlin.jvm.functions.Function2<java.lang.Object, java.lang.Number, T> function2 = this.$mapFn;
        while (itWithIndex.hasNext()) {
            kotlin.collections.IndexedValue indexedValue = (kotlin.collections.IndexedValue) itWithIndex.next();
            int index = indexedValue.getIndex();
            java.lang.Object objComponent2 = indexedValue.component2();
            if (objComponent2 instanceof io.dcloud.uts.UTSPromise) {
                kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking$default(null, new io.dcloud.uts.UTSArray$Companion$fromAsync$p$1$1$1$1(objComponent2, uTSArray, function1, null), 1, null);
            } else {
                kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking$default(null, new io.dcloud.uts.UTSArray$Companion$fromAsync$p$1$1$1$2(objComponent2, function2, index, uTSArray, null), 1, null);
            }
        }
        this.$resolveParam.invoke2((io.dcloud.uts.UTSArray<T>) uTSArray);
        return kotlin.Unit.INSTANCE;
    }
}
