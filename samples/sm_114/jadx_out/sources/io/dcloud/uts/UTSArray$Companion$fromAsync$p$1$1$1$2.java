package io.dcloud.uts;

/* JADX INFO: compiled from: UTSArray.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "io.dcloud.uts.UTSArray$Companion$fromAsync$p$1$1$1$2", f = "UTSArray.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class UTSArray$Companion$fromAsync$p$1$1$1$2 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
    final /* synthetic */ java.lang.Object $any;
    final /* synthetic */ int $index;
    final /* synthetic */ kotlin.jvm.functions.Function2<java.lang.Object, java.lang.Number, T> $mapFn;
    final /* synthetic */ io.dcloud.uts.UTSArray<T> $utsArray;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    UTSArray$Companion$fromAsync$p$1$1$1$2(java.lang.Object obj, kotlin.jvm.functions.Function2<java.lang.Object, ? super java.lang.Number, ? extends T> function2, int i, io.dcloud.uts.UTSArray<T> uTSArray, kotlin.coroutines.Continuation<? super io.dcloud.uts.UTSArray$Companion$fromAsync$p$1$1$1$2> continuation) {
        super(2, continuation);
        this.$any = obj;
        this.$mapFn = function2;
        this.$index = i;
        this.$utsArray = uTSArray;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object obj, kotlin.coroutines.Continuation<?> continuation) {
        return new io.dcloud.uts.UTSArray$Companion$fromAsync$p$1$1$1$2(this.$any, this.$mapFn, this.$index, this.$utsArray, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final java.lang.Object invoke(kotlinx.coroutines.CoroutineScope coroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return ((io.dcloud.uts.UTSArray$Companion$fromAsync$p$1$1$1$2) create(coroutineScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object obj) {
        kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.ResultKt.throwOnFailure(obj);
        java.lang.Object objInvoke = this.$any;
        kotlin.jvm.functions.Function2<java.lang.Object, java.lang.Number, T> function2 = this.$mapFn;
        if (function2 != 0) {
            objInvoke = function2.invoke(objInvoke, kotlin.coroutines.jvm.internal.Boxing.boxInt(this.$index));
        }
        this.$utsArray.add((T) objInvoke);
        return kotlin.Unit.INSTANCE;
    }
}
