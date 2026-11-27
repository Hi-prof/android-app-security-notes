package kotlinx.coroutines.channels;

/* JADX INFO: compiled from: Broadcast.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u009b\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2-\b\u0002\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bj\u0004\u0018\u0001`\u00112/\b\u0001\u0010\u0012\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0013¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\u0018\u001a2\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00192\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¨\u0006\u001a"}, d2 = {"broadcast", "Lkotlinx/coroutines/channels/BroadcastChannel;", "E", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "start", "Lkotlinx/coroutines/CoroutineStart;", "onCompletion", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_BLOCK, "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/BroadcastChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class BroadcastKt {
    public static /* synthetic */ kotlinx.coroutines.channels.BroadcastChannel broadcast$default(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, int i, kotlinx.coroutines.CoroutineStart coroutineStart, int i2, java.lang.Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        if ((i2 & 2) != 0) {
            coroutineStart = kotlinx.coroutines.CoroutineStart.LAZY;
        }
        return broadcast(receiveChannel, i, coroutineStart);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    public static final <E> kotlinx.coroutines.channels.BroadcastChannel<E> broadcast(final kotlinx.coroutines.channels.ReceiveChannel<? extends E> receiveChannel, int i, kotlinx.coroutines.CoroutineStart coroutineStart) {
        return broadcast$default(kotlinx.coroutines.CoroutineScopeKt.plus(kotlinx.coroutines.CoroutineScopeKt.plus(kotlinx.coroutines.GlobalScope.INSTANCE, kotlinx.coroutines.Dispatchers.getUnconfined()), new kotlinx.coroutines.channels.BroadcastKt$broadcast$$inlined$CoroutineExceptionHandler$1(kotlinx.coroutines.CoroutineExceptionHandler.INSTANCE)), null, i, coroutineStart, new kotlin.jvm.functions.Function1<java.lang.Throwable, kotlin.Unit>() { // from class: kotlinx.coroutines.channels.BroadcastKt.broadcast.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ kotlin.Unit invoke2(java.lang.Throwable th) {
                invoke2(th);
                return kotlin.Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(java.lang.Throwable th) {
                kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(receiveChannel, th);
            }
        }, new kotlinx.coroutines.channels.BroadcastKt.AnonymousClass2(receiveChannel, null), 1, null);
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.BroadcastKt$broadcast$2, reason: invalid class name */
    /* JADX INFO: compiled from: Broadcast.kt */
    @kotlin.Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlinx.coroutines.channels.BroadcastKt$broadcast$2", f = "Broadcast.kt", i = {0, 1}, l = {52, 53}, m = "invokeSuspend", n = {"$this$broadcast", "$this$broadcast"}, s = {"L$0", "L$0"})
    static final class AnonymousClass2<E> extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.channels.ProducerScope<? super E>, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
        final /* synthetic */ kotlinx.coroutines.channels.ReceiveChannel<E> $channel;
        private /* synthetic */ java.lang.Object L$0;
        java.lang.Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(kotlinx.coroutines.channels.ReceiveChannel<? extends E> receiveChannel, kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.BroadcastKt.AnonymousClass2> continuation) {
            super(2, continuation);
            this.$channel = receiveChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object obj, kotlin.coroutines.Continuation<?> continuation) {
            kotlinx.coroutines.channels.BroadcastKt.AnonymousClass2 anonymousClass2 = new kotlinx.coroutines.channels.BroadcastKt.AnonymousClass2(this.$channel, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final java.lang.Object invoke(kotlinx.coroutines.channels.ProducerScope<? super E> producerScope, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
            return ((kotlinx.coroutines.channels.BroadcastKt.AnonymousClass2) create(producerScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:15:0x004c  */
        /* JADX WARN: Code duplicated, block: B:18:0x0057  */
        /* JADX WARN: Code duplicated, block: B:21:0x006b  */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0068, code lost:
        
            if (r4.send(r1.next(), r7) == r0) goto L20;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0068 -> B:7:0x0019). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2f
                if (r1 == r3) goto L23
                if (r1 != r2) goto L1b
                java.lang.Object r1 = r7.L$1
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                java.lang.Object r4 = r7.L$0
                kotlinx.coroutines.channels.ProducerScope r4 = (kotlinx.coroutines.channels.ProducerScope) r4
                kotlin.ResultKt.throwOnFailure(r8)
            L19:
                r8 = r4
                goto L3c
            L1b:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L23:
                java.lang.Object r1 = r7.L$1
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                java.lang.Object r4 = r7.L$0
                kotlinx.coroutines.channels.ProducerScope r4 = (kotlinx.coroutines.channels.ProducerScope) r4
                kotlin.ResultKt.throwOnFailure(r8)
                goto L4f
            L2f:
                kotlin.ResultKt.throwOnFailure(r8)
                java.lang.Object r8 = r7.L$0
                kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
                kotlinx.coroutines.channels.ReceiveChannel<E> r1 = r7.$channel
                kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            L3c:
                r4 = r7
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r7.L$0 = r8
                r7.L$1 = r1
                r7.label = r3
                java.lang.Object r4 = r1.hasNext(r4)
                if (r4 != r0) goto L4c
                goto L6a
            L4c:
                r6 = r4
                r4 = r8
                r8 = r6
            L4f:
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                boolean r8 = r8.booleanValue()
                if (r8 == 0) goto L6b
                java.lang.Object r8 = r1.next()
                r5 = r7
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                r7.L$0 = r4
                r7.L$1 = r1
                r7.label = r2
                java.lang.Object r8 = r4.send(r8, r5)
                if (r8 != r0) goto L19
            L6a:
                return r0
            L6b:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BroadcastKt.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static /* synthetic */ kotlinx.coroutines.channels.BroadcastChannel broadcast$default(kotlinx.coroutines.CoroutineScope coroutineScope, kotlin.coroutines.CoroutineContext coroutineContext, int i, kotlinx.coroutines.CoroutineStart coroutineStart, kotlin.jvm.functions.Function1 function1, kotlin.jvm.functions.Function2 function2, int i2, java.lang.Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = kotlin.coroutines.EmptyCoroutineContext.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            i = 1;
        }
        if ((i2 & 4) != 0) {
            coroutineStart = kotlinx.coroutines.CoroutineStart.LAZY;
        }
        if ((i2 & 8) != 0) {
            function1 = null;
        }
        kotlinx.coroutines.CoroutineStart coroutineStart2 = coroutineStart;
        return broadcast(coroutineScope, coroutineContext, i, coroutineStart2, function1, function2);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    public static final <E> kotlinx.coroutines.channels.BroadcastChannel<E> broadcast(kotlinx.coroutines.CoroutineScope coroutineScope, kotlin.coroutines.CoroutineContext coroutineContext, int i, kotlinx.coroutines.CoroutineStart coroutineStart, kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> function1, kotlin.jvm.functions.Function2<? super kotlinx.coroutines.channels.ProducerScope<? super E>, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> function2) {
        kotlinx.coroutines.channels.LazyBroadcastCoroutine broadcastCoroutine;
        kotlin.coroutines.CoroutineContext coroutineContextNewCoroutineContext = kotlinx.coroutines.CoroutineContextKt.newCoroutineContext(coroutineScope, coroutineContext);
        kotlinx.coroutines.channels.BroadcastChannel BroadcastChannel = kotlinx.coroutines.channels.BroadcastChannelKt.BroadcastChannel(i);
        if (coroutineStart.isLazy()) {
            broadcastCoroutine = new kotlinx.coroutines.channels.LazyBroadcastCoroutine(coroutineContextNewCoroutineContext, BroadcastChannel, function2);
        } else {
            broadcastCoroutine = new kotlinx.coroutines.channels.BroadcastCoroutine(coroutineContextNewCoroutineContext, BroadcastChannel, true);
        }
        if (function1 != null) {
            broadcastCoroutine.invokeOnCompletion(function1);
        }
        broadcastCoroutine.start(coroutineStart, broadcastCoroutine, function2);
        return broadcastCoroutine;
    }
}
