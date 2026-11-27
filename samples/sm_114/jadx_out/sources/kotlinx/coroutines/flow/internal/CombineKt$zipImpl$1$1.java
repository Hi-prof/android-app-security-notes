package kotlinx.coroutines.flow.internal;

/* JADX INFO: compiled from: Combine.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1", f = "Combine.kt", i = {0, 0}, l = {123}, m = "invokeSuspend", n = {"second", "collectJob"}, s = {"L$0", "L$1"})
final class CombineKt$zipImpl$1$1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
    final /* synthetic */ kotlinx.coroutines.flow.Flow<T1> $flow;
    final /* synthetic */ kotlinx.coroutines.flow.Flow<T2> $flow2;
    final /* synthetic */ kotlinx.coroutines.flow.FlowCollector<R> $this_unsafeFlow;
    final /* synthetic */ kotlin.jvm.functions.Function3<T1, T2, kotlin.coroutines.Continuation<? super R>, java.lang.Object> $transform;
    private /* synthetic */ java.lang.Object L$0;
    java.lang.Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CombineKt$zipImpl$1$1(kotlinx.coroutines.flow.Flow<? extends T2> flow, kotlinx.coroutines.flow.Flow<? extends T1> flow2, kotlinx.coroutines.flow.FlowCollector<? super R> flowCollector, kotlin.jvm.functions.Function3<? super T1, ? super T2, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function3, kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1> continuation) {
        super(2, continuation);
        this.$flow2 = flow;
        this.$flow = flow2;
        this.$this_unsafeFlow = flowCollector;
        this.$transform = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object obj, kotlin.coroutines.Continuation<?> continuation) {
        kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1 combineKt$zipImpl$1$1 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1(this.$flow2, this.$flow, this.$this_unsafeFlow, this.$transform, continuation);
        combineKt$zipImpl$1$1.L$0 = obj;
        return combineKt$zipImpl$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final java.lang.Object invoke(kotlinx.coroutines.CoroutineScope coroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return ((kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1) create(coroutineScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object obj) throws java.lang.Throwable {
        final kotlinx.coroutines.CompletableJob completableJobJob$default;
        kotlinx.coroutines.channels.ReceiveChannel receiveChannel;
        java.lang.Object coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            kotlin.ResultKt.throwOnFailure(obj);
            kotlinx.coroutines.CoroutineScope coroutineScope = (kotlinx.coroutines.CoroutineScope) this.L$0;
            kotlinx.coroutines.channels.ReceiveChannel receiveChannelProduce$default = kotlinx.coroutines.channels.ProduceKt.produce$default(coroutineScope, null, 0, new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1(this.$flow2, null), 3, null);
            completableJobJob$default = kotlinx.coroutines.JobKt__JobKt.Job$default((kotlinx.coroutines.Job) null, 1, (java.lang.Object) null);
            kotlin.jvm.internal.Intrinsics.checkNotNull(receiveChannelProduce$default, "null cannot be cast to non-null type kotlinx.coroutines.channels.SendChannel<*>");
            ((kotlinx.coroutines.channels.SendChannel) receiveChannelProduce$default).invokeOnClose(new kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit>() { // from class: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.1
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
                    if (completableJobJob$default.isActive()) {
                        completableJobJob$default.cancel((java.util.concurrent.CancellationException) new kotlinx.coroutines.flow.internal.AbortFlowException(completableJobJob$default));
                    }
                }
            });
            try {
                try {
                    kotlin.coroutines.CoroutineContext coroutineContext = coroutineScope.getCoroutineContext();
                    java.lang.Object objThreadContextElements = kotlinx.coroutines.internal.ThreadContextKt.threadContextElements(coroutineContext);
                    kotlin.coroutines.CoroutineContext coroutineContextPlus = coroutineScope.getCoroutineContext().plus(completableJobJob$default);
                    kotlin.Unit unit = kotlin.Unit.INSTANCE;
                    try {
                        this.L$0 = receiveChannelProduce$default;
                        this.L$1 = completableJobJob$default;
                        this.label = 1;
                        if (kotlinx.coroutines.flow.internal.ChannelFlowKt.withContextUndispatched$default(coroutineContextPlus, unit, null, new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.AnonymousClass2(this.$flow, coroutineContext, objThreadContextElements, receiveChannelProduce$default, this.$this_unsafeFlow, this.$transform, completableJobJob$default, null), this, 4, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel = receiveChannelProduce$default;
                    } catch (kotlinx.coroutines.flow.internal.AbortFlowException e) {
                        e = e;
                        completableJobJob$default = completableJobJob$default;
                        receiveChannel = receiveChannelProduce$default;
                        kotlinx.coroutines.flow.internal.FlowExceptions_commonKt.checkOwnership(e, completableJobJob$default);
                    }
                } catch (kotlinx.coroutines.flow.internal.AbortFlowException e2) {
                    e = e2;
                }
            } catch (java.lang.Throwable th) {
                th = th;
                receiveChannel = receiveChannelProduce$default;
                kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.cancel$default(receiveChannel, (java.util.concurrent.CancellationException) null, 1, (java.lang.Object) null);
                throw th;
            }
        } else {
            if (i != 1) {
                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            completableJobJob$default = (kotlinx.coroutines.CompletableJob) this.L$1;
            receiveChannel = (kotlinx.coroutines.channels.ReceiveChannel) this.L$0;
            try {
                try {
                    kotlin.ResultKt.throwOnFailure(obj);
                } catch (kotlinx.coroutines.flow.internal.AbortFlowException e3) {
                    e = e3;
                    kotlinx.coroutines.flow.internal.FlowExceptions_commonKt.checkOwnership(e, completableJobJob$default);
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.cancel$default(receiveChannel, (java.util.concurrent.CancellationException) null, 1, (java.lang.Object) null);
                throw th;
            }
        }
        kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.cancel$default(receiveChannel, (java.util.concurrent.CancellationException) null, 1, (java.lang.Object) null);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: Combine.kt */
    @kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "it"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2", f = "Combine.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlin.Unit, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
        final /* synthetic */ java.lang.Object $cnt;
        final /* synthetic */ kotlinx.coroutines.CompletableJob $collectJob;
        final /* synthetic */ kotlinx.coroutines.flow.Flow<T1> $flow;
        final /* synthetic */ kotlin.coroutines.CoroutineContext $scopeContext;
        final /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel<java.lang.Object> $second;
        final /* synthetic */ kotlinx.coroutines.flow.FlowCollector<R> $this_unsafeFlow;
        final /* synthetic */ kotlin.jvm.functions.Function3<T1, T2, kotlin.coroutines.Continuation<? super R>, java.lang.Object> $transform;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(kotlinx.coroutines.flow.Flow<? extends T1> flow, kotlin.coroutines.CoroutineContext coroutineContext, java.lang.Object obj, kotlinx.coroutines.channels.ReceiveChannel<? extends java.lang.Object> receiveChannel, kotlinx.coroutines.flow.FlowCollector<? super R> flowCollector, kotlin.jvm.functions.Function3<? super T1, ? super T2, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function3, kotlinx.coroutines.CompletableJob completableJob, kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.AnonymousClass2> continuation) {
            super(2, continuation);
            this.$flow = flow;
            this.$scopeContext = coroutineContext;
            this.$cnt = obj;
            this.$second = receiveChannel;
            this.$this_unsafeFlow = flowCollector;
            this.$transform = function3;
            this.$collectJob = completableJob;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object obj, kotlin.coroutines.Continuation<?> continuation) {
            return new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.AnonymousClass2(this.$flow, this.$scopeContext, this.$cnt, this.$second, this.$this_unsafeFlow, this.$transform, this.$collectJob, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final java.lang.Object invoke(kotlin.Unit unit, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
            return ((kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.AnonymousClass2) create(unit, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: Combine.kt */
        @kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.FlowCollector {
            final /* synthetic */ java.lang.Object $cnt;
            final /* synthetic */ kotlinx.coroutines.CompletableJob $collectJob;
            final /* synthetic */ kotlin.coroutines.CoroutineContext $scopeContext;
            final /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel<java.lang.Object> $second;
            final /* synthetic */ kotlinx.coroutines.flow.FlowCollector<R> $this_unsafeFlow;
            final /* synthetic */ kotlin.jvm.functions.Function3<T1, T2, kotlin.coroutines.Continuation<? super R>, java.lang.Object> $transform;

            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(kotlin.coroutines.CoroutineContext coroutineContext, java.lang.Object obj, kotlinx.coroutines.channels.ReceiveChannel<? extends java.lang.Object> receiveChannel, kotlinx.coroutines.flow.FlowCollector<? super R> flowCollector, kotlin.jvm.functions.Function3<? super T1, ? super T2, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function3, kotlinx.coroutines.CompletableJob completableJob) {
                this.$scopeContext = coroutineContext;
                this.$cnt = obj;
                this.$second = receiveChannel;
                this.$this_unsafeFlow = flowCollector;
                this.$transform = function3;
                this.$collectJob = completableJob;
            }

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: Combine.kt */
            @kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "it"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1", f = "Combine.kt", i = {}, l = {126, 129, 129}, m = "invokeSuspend", n = {}, s = {})
            static final class C00831 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlin.Unit, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
                final /* synthetic */ kotlinx.coroutines.CompletableJob $collectJob;
                final /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel<java.lang.Object> $second;
                final /* synthetic */ kotlinx.coroutines.flow.FlowCollector<R> $this_unsafeFlow;
                final /* synthetic */ kotlin.jvm.functions.Function3<T1, T2, kotlin.coroutines.Continuation<? super R>, java.lang.Object> $transform;
                final /* synthetic */ T1 $value;
                java.lang.Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C00831(kotlinx.coroutines.channels.ReceiveChannel<? extends java.lang.Object> receiveChannel, kotlinx.coroutines.flow.FlowCollector<? super R> flowCollector, kotlin.jvm.functions.Function3<? super T1, ? super T2, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> function3, T1 t1, kotlinx.coroutines.CompletableJob completableJob, kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.AnonymousClass2.AnonymousClass1.C00831> continuation) {
                    super(2, continuation);
                    this.$second = receiveChannel;
                    this.$this_unsafeFlow = flowCollector;
                    this.$transform = function3;
                    this.$value = t1;
                    this.$collectJob = completableJob;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object obj, kotlin.coroutines.Continuation<?> continuation) {
                    return new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.AnonymousClass2.AnonymousClass1.C00831(this.$second, this.$this_unsafeFlow, this.$transform, this.$value, this.$collectJob, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final java.lang.Object invoke(kotlin.Unit unit, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
                    return ((kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.AnonymousClass2.AnonymousClass1.C00831) create(unit, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
                }

                /* JADX WARN: Code restructure failed: missing block: B:28:0x0076, code lost:
                
                    if (r1.emit(r9, r8) == r0) goto L29;
                 */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r1v5, types: [kotlinx.coroutines.flow.FlowCollector] */
                /* JADX WARN: Type inference failed for: r1v8 */
                /* JADX WARN: Type inference failed for: r1v9 */
                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
                    /*
                        r8 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r1 = r8.label
                        r2 = 0
                        r3 = 3
                        r4 = 2
                        r5 = 1
                        if (r1 == 0) goto L30
                        if (r1 == r5) goto L26
                        if (r1 == r4) goto L1e
                        if (r1 != r3) goto L16
                        kotlin.ResultKt.throwOnFailure(r9)
                        goto L79
                    L16:
                        java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r9.<init>(r0)
                        throw r9
                    L1e:
                        java.lang.Object r1 = r8.L$0
                        kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                        kotlin.ResultKt.throwOnFailure(r9)
                        goto L6b
                    L26:
                        kotlin.ResultKt.throwOnFailure(r9)
                        kotlinx.coroutines.channels.ChannelResult r9 = (kotlinx.coroutines.channels.ChannelResult) r9
                        java.lang.Object r9 = r9.getHolder()
                        goto L41
                    L30:
                        kotlin.ResultKt.throwOnFailure(r9)
                        kotlinx.coroutines.channels.ReceiveChannel<java.lang.Object> r9 = r8.$second
                        r1 = r8
                        kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                        r8.label = r5
                        java.lang.Object r9 = r9.mo2094receiveCatchingJP2dKIU(r1)
                        if (r9 != r0) goto L41
                        goto L78
                    L41:
                        kotlinx.coroutines.CompletableJob r1 = r8.$collectJob
                        boolean r5 = r9 instanceof kotlinx.coroutines.channels.ChannelResult.Failed
                        if (r5 == 0) goto L55
                        java.lang.Throwable r9 = kotlinx.coroutines.channels.ChannelResult.m2105exceptionOrNullimpl(r9)
                        if (r9 != 0) goto L54
                        kotlinx.coroutines.flow.internal.AbortFlowException r9 = new kotlinx.coroutines.flow.internal.AbortFlowException
                        r9.<init>(r1)
                        java.lang.Throwable r9 = (java.lang.Throwable) r9
                    L54:
                        throw r9
                    L55:
                        kotlinx.coroutines.flow.FlowCollector<R> r1 = r8.$this_unsafeFlow
                        kotlin.jvm.functions.Function3<T1, T2, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r5 = r8.$transform
                        T1 r6 = r8.$value
                        kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL
                        if (r9 != r7) goto L60
                        r9 = r2
                    L60:
                        r8.L$0 = r1
                        r8.label = r4
                        java.lang.Object r9 = r5.invoke(r6, r9, r8)
                        if (r9 != r0) goto L6b
                        goto L78
                    L6b:
                        r4 = r8
                        kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                        r8.L$0 = r2
                        r8.label = r3
                        java.lang.Object r9 = r1.emit(r9, r4)
                        if (r9 != r0) goto L79
                    L78:
                        return r0
                    L79:
                        kotlin.Unit r9 = kotlin.Unit.INSTANCE
                        return r9
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.AnonymousClass2.AnonymousClass1.C00831.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0014  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            public final java.lang.Object emit(T1 t1, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
                kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$emit$1 combineKt$zipImpl$1$1$2$1$emit$1;
                if (continuation instanceof kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$emit$1) {
                    combineKt$zipImpl$1$1$2$1$emit$1 = (kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$emit$1) continuation;
                    if ((combineKt$zipImpl$1$1$2$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                        combineKt$zipImpl$1$1$2$1$emit$1.label -= Integer.MIN_VALUE;
                    } else {
                        combineKt$zipImpl$1$1$2$1$emit$1 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$emit$1(this, continuation);
                    }
                } else {
                    combineKt$zipImpl$1$1$2$1$emit$1 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$emit$1(this, continuation);
                }
                java.lang.Object obj = combineKt$zipImpl$1$1$2$1$emit$1.result;
                java.lang.Object coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = combineKt$zipImpl$1$1$2$1$emit$1.label;
                if (i == 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    kotlin.coroutines.CoroutineContext coroutineContext = this.$scopeContext;
                    kotlin.Unit unit = kotlin.Unit.INSTANCE;
                    java.lang.Object obj2 = this.$cnt;
                    kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.AnonymousClass2.AnonymousClass1.C00831 c00831 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.AnonymousClass2.AnonymousClass1.C00831(this.$second, this.$this_unsafeFlow, this.$transform, t1, this.$collectJob, null);
                    combineKt$zipImpl$1$1$2$1$emit$1.label = 1;
                    if (kotlinx.coroutines.flow.internal.ChannelFlowKt.withContextUndispatched(coroutineContext, unit, obj2, c00831, combineKt$zipImpl$1$1$2$1$emit$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.ResultKt.throwOnFailure(obj);
                }
                return kotlin.Unit.INSTANCE;
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object obj) {
            java.lang.Object coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                kotlin.ResultKt.throwOnFailure(obj);
                kotlinx.coroutines.flow.Flow<T1> flow = this.$flow;
                kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.AnonymousClass2.AnonymousClass1 anonymousClass1 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.AnonymousClass2.AnonymousClass1(this.$scopeContext, this.$cnt, this.$second, this.$this_unsafeFlow, this.$transform, this.$collectJob);
                this.label = 1;
                if (flow.collect(anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.ResultKt.throwOnFailure(obj);
            }
            return kotlin.Unit.INSTANCE;
        }
    }
}
