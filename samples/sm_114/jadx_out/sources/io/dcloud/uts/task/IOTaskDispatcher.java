package io.dcloud.uts.task;

/* JADX INFO: compiled from: IOTaskDispatcher.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u0004\u001a\u00020\u00052#\u0010\u0006\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00050\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\f"}, d2 = {"Lio/dcloud/uts/task/IOTaskDispatcher;", "Lio/dcloud/uts/task/UTSTaskDispatcher;", "<init>", "()V", "async", "", "action", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "param", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IOTaskDispatcher extends io.dcloud.uts.task.UTSTaskDispatcher {
    public IOTaskDispatcher() {
        super(null);
    }

    /* JADX INFO: renamed from: io.dcloud.uts.task.IOTaskDispatcher$async$1, reason: invalid class name */
    /* JADX INFO: compiled from: IOTaskDispatcher.kt */
    @kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "io.dcloud.uts.task.IOTaskDispatcher$async$1", f = "IOTaskDispatcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
        final /* synthetic */ kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> $action;
        final /* synthetic */ java.lang.Object $param;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function1, java.lang.Object obj, kotlin.coroutines.Continuation<? super io.dcloud.uts.task.IOTaskDispatcher.AnonymousClass1> continuation) {
            super(2, continuation);
            this.$action = function1;
            this.$param = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object obj, kotlin.coroutines.Continuation<?> continuation) {
            return new io.dcloud.uts.task.IOTaskDispatcher.AnonymousClass1(this.$action, this.$param, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final java.lang.Object invoke(kotlinx.coroutines.CoroutineScope coroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
            return ((io.dcloud.uts.task.IOTaskDispatcher.AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object obj) {
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.ResultKt.throwOnFailure(obj);
            this.$action.invoke2(this.$param);
            return kotlin.Unit.INSTANCE;
        }
    }

    @Override // io.dcloud.uts.task.UTSTaskDispatcher
    public void async(kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> action, java.lang.Object param) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(kotlinx.coroutines.Dispatchers.getIO()), null, null, new io.dcloud.uts.task.IOTaskDispatcher.AnonymousClass1(action, param, null), 3, null);
    }
}
