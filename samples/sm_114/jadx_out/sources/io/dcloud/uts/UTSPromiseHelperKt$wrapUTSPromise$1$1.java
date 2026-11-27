package io.dcloud.uts;

/* JADX INFO: compiled from: UTSPromiseHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "io.dcloud.uts.UTSPromiseHelperKt$wrapUTSPromise$1$1", f = "UTSPromiseHelper.kt", i = {1}, l = {53, com.alibaba.fastjson.asm.Opcodes.DSTORE}, m = "invokeSuspend", n = {"result"}, s = {"L$0"})
final class UTSPromiseHelperKt$wrapUTSPromise$1$1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
    final /* synthetic */ kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<java.lang.Object>, java.lang.Object> $fn;
    final /* synthetic */ kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> $reject;
    final /* synthetic */ kotlin.jvm.functions.Function1<T, kotlin.Unit> $resolve;
    java.lang.Object L$0;
    java.lang.Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    UTSPromiseHelperKt$wrapUTSPromise$1$1(kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<java.lang.Object>, ? extends java.lang.Object> function1, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> function2, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function3, kotlin.coroutines.Continuation<? super io.dcloud.uts.UTSPromiseHelperKt$wrapUTSPromise$1$1> continuation) {
        super(2, continuation);
        this.$fn = function1;
        this.$resolve = function2;
        this.$reject = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object obj, kotlin.coroutines.Continuation<?> continuation) {
        return new io.dcloud.uts.UTSPromiseHelperKt$wrapUTSPromise$1$1(this.$fn, this.$resolve, this.$reject, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final java.lang.Object invoke(kotlinx.coroutines.CoroutineScope coroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return ((io.dcloud.uts.UTSPromiseHelperKt$wrapUTSPromise$1$1) create(coroutineScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object obj) {
        kotlin.jvm.functions.Function1 function1;
        kotlin.jvm.functions.Function1 function2;
        java.lang.Object coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                kotlin.ResultKt.throwOnFailure(obj);
                kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<java.lang.Object>, java.lang.Object> function3 = this.$fn;
                this.label = 1;
                obj = function3.invoke2(this);
                if (obj == coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                kotlin.ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                function2 = (kotlin.jvm.functions.Function1) this.L$1;
                kotlin.ResultKt.throwOnFailure(obj);
            }
            function1 = function2;
            function1.invoke2(obj);
            return kotlin.Unit.INSTANCE;
            function1 = this.$resolve;
            if (obj instanceof io.dcloud.uts.UTSPromise) {
                this.L$0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(obj);
                this.L$1 = function1;
                this.label = 2;
                obj = io.dcloud.uts.UTSPromiseHelperKt.await((io.dcloud.uts.UTSPromise) obj, (kotlin.coroutines.Continuation) this);
                if (obj != coroutine_suspended) {
                    function2 = function1;
                    function1 = function2;
                }
                return coroutine_suspended;
            }
            function1.invoke2(obj);
        } catch (java.lang.Throwable th) {
            this.$reject.invoke2(th);
        }
        return kotlin.Unit.INSTANCE;
    }
}
