package io.dcloud.uts;

/* JADX INFO: compiled from: UTSArray.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "io.dcloud.uts.UTSArray$Companion$fromAsync$p$1$1$1$1", f = "UTSArray.kt", i = {0}, l = {io.dcloud.common.DHInterface.IMgr.WindowEvent.WINDOW_ANIMATION_END}, m = "invokeSuspend", n = {"promiseReal"}, s = {"L$0"})
final class UTSArray$Companion$fromAsync$p$1$1$1$1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
    final /* synthetic */ java.lang.Object $any;
    final /* synthetic */ kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> $rejectParam;
    final /* synthetic */ io.dcloud.uts.UTSArray<T> $utsArray;
    java.lang.Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UTSArray$Companion$fromAsync$p$1$1$1$1(java.lang.Object obj, io.dcloud.uts.UTSArray<T> uTSArray, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function1, kotlin.coroutines.Continuation<? super io.dcloud.uts.UTSArray$Companion$fromAsync$p$1$1$1$1> continuation) {
        super(2, continuation);
        this.$any = obj;
        this.$utsArray = uTSArray;
        this.$rejectParam = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object obj, kotlin.coroutines.Continuation<?> continuation) {
        return new io.dcloud.uts.UTSArray$Companion$fromAsync$p$1$1$1$1(this.$any, this.$utsArray, this.$rejectParam, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final java.lang.Object invoke(kotlinx.coroutines.CoroutineScope coroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return ((io.dcloud.uts.UTSArray$Companion$fromAsync$p$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object obj) throws java.lang.Throwable {
        java.lang.Object coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            kotlin.ResultKt.throwOnFailure(obj);
            io.dcloud.uts.UTSPromise uTSPromise = (io.dcloud.uts.UTSPromise) this.$any;
            final kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function1 = this.$rejectParam;
            io.dcloud.uts.UTSPromise uTSPromiseM523catch = uTSPromise.m523catch(new kotlin.jvm.functions.Function1() { // from class: io.dcloud.uts.UTSArray$Companion$fromAsync$p$1$1$1$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: invoke */
                public final java.lang.Object invoke2(java.lang.Object obj2) {
                    return io.dcloud.uts.UTSArray$Companion$fromAsync$p$1$1$1$1.invokeSuspend$lambda$0(function1, obj2);
                }
            });
            this.L$0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(uTSPromiseM523catch);
            this.label = 1;
            obj = io.dcloud.uts.UTSPromiseHelperKt.await(uTSPromiseM523catch, (kotlin.coroutines.Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.ResultKt.throwOnFailure(obj);
        }
        this.$utsArray.add((T) obj);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit invokeSuspend$lambda$0(kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function1, java.lang.Object obj) {
        function1.invoke2(obj);
        return kotlin.Unit.INSTANCE;
    }
}
