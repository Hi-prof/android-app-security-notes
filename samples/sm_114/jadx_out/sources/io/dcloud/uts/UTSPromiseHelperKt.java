package io.dcloud.uts;

/* JADX INFO: compiled from: UTSPromiseHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002\u001a\u001c\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u0002H\u0005H\u0086@¢\u0006\u0002\u0010\u0007\u001a\"\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\bH\u0086@¢\u0006\u0002\u0010\t\u001a\"\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000bH\u0086@¢\u0006\u0002\u0010\f\u001a(\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000b\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\bH\u0086@¢\u0006\u0002\u0010\t\u001a \u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000b\"\u0004\b\u0000\u0010\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000b\u001a7\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00050\b\"\u0004\b\u0000\u0010\u00052\u001e\u0010\u000f\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0010¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"wrapError", "Lio/dcloud/uts/UTSError;", androidx.core.app.NotificationCompat.CATEGORY_ERROR, "", "await", "T", "promise", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/dcloud/uts/UTSPromise;", "(Lio/dcloud/uts/UTSPromise;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "def", "Lkotlinx/coroutines/Deferred;", "(Lkotlinx/coroutines/Deferred;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toDeferred", "wrapUTSPromise", "fn", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;)Lio/dcloud/uts/UTSPromise;", "utsplugin_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class UTSPromiseHelperKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> kotlinx.coroutines.Deferred<T> toDeferred(kotlinx.coroutines.Deferred<? extends T> def) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(def, "def");
        return def;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final io.dcloud.uts.UTSError wrapError(java.lang.Object obj) {
        if (obj instanceof io.dcloud.uts.UTSError) {
            return (io.dcloud.uts.UTSError) obj;
        }
        return new io.dcloud.uts.HolderUTSError(obj);
    }

    public static final <T> java.lang.Object await(T t, kotlin.coroutines.Continuation<? super T> continuation) throws java.lang.Throwable {
        kotlin.coroutines.SafeContinuation safeContinuation = new kotlin.coroutines.SafeContinuation(kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(continuation));
        final kotlin.coroutines.SafeContinuation safeContinuation2 = safeContinuation;
        io.dcloud.uts.UTSPromise.then$default(io.dcloud.uts.UTSPromise.INSTANCE.resolve(t), new kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit>() { // from class: io.dcloud.uts.UTSPromiseHelperKt$await$2$1
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ kotlin.Unit invoke2(java.lang.Object obj) {
                invoke2(obj);
                return kotlin.Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(java.lang.Object obj) {
                kotlin.coroutines.Continuation<T> continuation2 = safeContinuation2;
                kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
                continuation2.resumeWith(kotlin.Result.m541constructorimpl(obj));
            }
        }, (kotlin.Function) null, 2, (java.lang.Object) null).m523catch(new kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit>() { // from class: io.dcloud.uts.UTSPromiseHelperKt$await$2$2
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ kotlin.Unit invoke2(java.lang.Object obj) {
                invoke2(obj);
                return kotlin.Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(java.lang.Object obj) {
                kotlin.coroutines.Continuation<T> continuation2 = safeContinuation2;
                kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
                continuation2.resumeWith(kotlin.Result.m541constructorimpl(kotlin.ResultKt.createFailure(io.dcloud.uts.UTSPromiseHelperKt.wrapError(obj))));
            }
        });
        java.lang.Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static final <T> java.lang.Object await(io.dcloud.uts.UTSPromise<T> uTSPromise, kotlin.coroutines.Continuation<? super T> continuation) throws java.lang.Throwable {
        kotlin.coroutines.SafeContinuation safeContinuation = new kotlin.coroutines.SafeContinuation(kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(continuation));
        final kotlin.coroutines.SafeContinuation safeContinuation2 = safeContinuation;
        kotlin.jvm.internal.Intrinsics.checkNotNull(uTSPromise);
        io.dcloud.uts.UTSPromise.then$default(uTSPromise, new kotlin.jvm.functions.Function1<T, kotlin.Unit>() { // from class: io.dcloud.uts.UTSPromiseHelperKt$await$4$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ kotlin.Unit invoke2(java.lang.Object obj) {
                invoke2(obj);
                return kotlin.Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(T t) {
                kotlin.coroutines.Continuation<T> continuation2 = safeContinuation2;
                kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
                continuation2.resumeWith(kotlin.Result.m541constructorimpl(t));
            }
        }, (kotlin.Function) null, 2, (java.lang.Object) null).m523catch(new kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit>() { // from class: io.dcloud.uts.UTSPromiseHelperKt$await$4$2
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ kotlin.Unit invoke2(java.lang.Object obj) {
                invoke2(obj);
                return kotlin.Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(java.lang.Object obj) {
                kotlin.coroutines.Continuation<T> continuation2 = safeContinuation2;
                kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
                continuation2.resumeWith(kotlin.Result.m541constructorimpl(kotlin.ResultKt.createFailure(io.dcloud.uts.UTSPromiseHelperKt.wrapError(obj))));
            }
        });
        java.lang.Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> java.lang.Object await(kotlinx.coroutines.Deferred<? extends T> deferred, kotlin.coroutines.Continuation<? super T> continuation) {
        return deferred.await(continuation);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: io.dcloud.uts.UTSPromiseHelperKt$toDeferred$2, reason: invalid class name */
    /* JADX INFO: compiled from: UTSPromiseHelper.kt */
    @kotlin.Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "io.dcloud.uts.UTSPromiseHelperKt$toDeferred$2", f = "UTSPromiseHelper.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2<T> extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super T>, java.lang.Object> {
        final /* synthetic */ io.dcloud.uts.UTSPromise<T> $promise;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(io.dcloud.uts.UTSPromise<T> uTSPromise, kotlin.coroutines.Continuation<? super io.dcloud.uts.UTSPromiseHelperKt.AnonymousClass2> continuation) {
            super(2, continuation);
            this.$promise = uTSPromise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object obj, kotlin.coroutines.Continuation<?> continuation) {
            return new io.dcloud.uts.UTSPromiseHelperKt.AnonymousClass2(this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final java.lang.Object invoke(kotlinx.coroutines.CoroutineScope coroutineScope, kotlin.coroutines.Continuation<? super T> continuation) {
            return ((io.dcloud.uts.UTSPromiseHelperKt.AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object obj) throws java.lang.Throwable {
            java.lang.Object coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.ResultKt.throwOnFailure(obj);
                return obj;
            }
            kotlin.ResultKt.throwOnFailure(obj);
            this.label = 1;
            java.lang.Object objAwait = io.dcloud.uts.UTSPromiseHelperKt.await((io.dcloud.uts.UTSPromise) this.$promise, (kotlin.coroutines.Continuation) this);
            return objAwait == coroutine_suspended ? coroutine_suspended : objAwait;
        }
    }

    public static final <T> java.lang.Object toDeferred(io.dcloud.uts.UTSPromise<T> uTSPromise, kotlin.coroutines.Continuation<? super kotlinx.coroutines.Deferred<? extends T>> continuation) {
        return kotlinx.coroutines.BuildersKt__Builders_commonKt.async$default(kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(io.dcloud.uts.UTSAndroid.INSTANCE.getDomCoroutineDispatcher()), null, null, new io.dcloud.uts.UTSPromiseHelperKt.AnonymousClass2(uTSPromise, null), 3, null);
    }

    public static final <T> io.dcloud.uts.UTSPromise<T> wrapUTSPromise(final kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<java.lang.Object>, ? extends java.lang.Object> fn) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fn, "fn");
        return new io.dcloud.uts.UTSPromise<>(new kotlin.jvm.functions.Function2() { // from class: io.dcloud.uts.UTSPromiseHelperKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2) {
                return io.dcloud.uts.UTSPromiseHelperKt.wrapUTSPromise$lambda$2(fn, (kotlin.jvm.functions.Function1) obj, (kotlin.jvm.functions.Function1) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit wrapUTSPromise$lambda$2(kotlin.jvm.functions.Function1 function1, kotlin.jvm.functions.Function1 resolve, kotlin.jvm.functions.Function1 reject) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(resolve, "resolve");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(reject, "reject");
        kotlinx.coroutines.BuildersKt__Builders_commonKt.async$default(kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(io.dcloud.uts.UTSAndroid.INSTANCE.getDomCoroutineDispatcher()), null, null, new io.dcloud.uts.UTSPromiseHelperKt$wrapUTSPromise$1$1(function1, resolve, reject, null), 3, null);
        return kotlin.Unit.INSTANCE;
    }
}
