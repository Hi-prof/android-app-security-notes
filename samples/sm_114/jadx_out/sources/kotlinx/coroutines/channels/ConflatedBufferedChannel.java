package kotlinx.coroutines.channels;

/* JADX INFO: compiled from: ConflatedBufferedChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\"\b\u0002\u0010\u0007\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\n¢\u0006\u0002\u0010\u000bJ\u001e\u0010\u000f\u001a\u00020\t2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0016\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00028\u0000H\u0090@¢\u0006\u0004\b\u0017\u0010\u0015J\r\u0010\u0018\u001a\u00020\rH\u0010¢\u0006\u0002\b\u0019J#\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u001b2\u0006\u0010\u0012\u001a\u00028\u0000H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ+\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u001b2\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\rH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010!J+\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\u001b2\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\rH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010!R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBufferedChannel;", "E", "Lkotlinx/coroutines/channels/BufferedChannel;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(ILkotlinx/coroutines/channels/BufferOverflow;Lkotlin/jvm/functions/Function1;)V", "isConflatedDropOldest", "", "()Z", "registerSelectForSend", "select", "Lkotlinx/coroutines/selects/SelectInstance;", com.alibaba.android.bindingx.core.internal.BindingXConstants.KEY_ELEMENT, "", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendBroadcast", "sendBroadcast$kotlinx_coroutines_core", "shouldSendSuspend", "shouldSendSuspend$kotlinx_coroutines_core", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySendDropLatest", "isSendOp", "trySendDropLatest-Mj0NB7M", "(Ljava/lang/Object;Z)Ljava/lang/Object;", "trySendImpl", "trySendImpl-Mj0NB7M", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class ConflatedBufferedChannel<E> extends kotlinx.coroutines.channels.BufferedChannel<E> {
    private final int capacity;
    private final kotlinx.coroutines.channels.BufferOverflow onBufferOverflow;

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    public java.lang.Object send(E e, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return send$suspendImpl((kotlinx.coroutines.channels.ConflatedBufferedChannel) this, (java.lang.Object) e, continuation);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public java.lang.Object sendBroadcast$kotlinx_coroutines_core(E e, kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return sendBroadcast$suspendImpl((kotlinx.coroutines.channels.ConflatedBufferedChannel) this, (java.lang.Object) e, continuation);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public boolean shouldSendSuspend$kotlinx_coroutines_core() {
        return false;
    }

    public /* synthetic */ ConflatedBufferedChannel(int i, kotlinx.coroutines.channels.BufferOverflow bufferOverflow, kotlin.jvm.functions.Function1 function1, int i2, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(i, bufferOverflow, (i2 & 4) != 0 ? null : function1);
    }

    public ConflatedBufferedChannel(int i, kotlinx.coroutines.channels.BufferOverflow bufferOverflow, kotlin.jvm.functions.Function1<? super E, kotlin.Unit> function1) {
        super(i, function1);
        this.capacity = i;
        this.onBufferOverflow = bufferOverflow;
        if (bufferOverflow == kotlinx.coroutines.channels.BufferOverflow.SUSPEND) {
            throw new java.lang.IllegalArgumentException(("This implementation does not support suspension for senders, use " + kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(kotlinx.coroutines.channels.BufferedChannel.class).getSimpleName() + " instead").toString());
        }
        if (i >= 1) {
            return;
        }
        throw new java.lang.IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + i + " was specified").toString());
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    protected boolean isConflatedDropOldest() {
        return this.onBufferOverflow == kotlinx.coroutines.channels.BufferOverflow.DROP_OLDEST;
    }

    static /* synthetic */ <E> java.lang.Object send$suspendImpl(kotlinx.coroutines.channels.ConflatedBufferedChannel<E> conflatedBufferedChannel, E e, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) throws java.lang.Throwable {
        kotlinx.coroutines.internal.UndeliveredElementException undeliveredElementExceptionCallUndeliveredElementCatchingException$default;
        java.lang.Object objM2118trySendImplMj0NB7M = conflatedBufferedChannel.m2118trySendImplMj0NB7M(e, true);
        if (objM2118trySendImplMj0NB7M instanceof kotlinx.coroutines.channels.ChannelResult.Closed) {
            kotlinx.coroutines.channels.ChannelResult.m2105exceptionOrNullimpl(objM2118trySendImplMj0NB7M);
            kotlin.jvm.functions.Function1<E, kotlin.Unit> function1 = conflatedBufferedChannel.onUndeliveredElement;
            if (function1 != null && (undeliveredElementExceptionCallUndeliveredElementCatchingException$default = kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, e, null, 2, null)) != null) {
                kotlin.ExceptionsKt.addSuppressed(undeliveredElementExceptionCallUndeliveredElementCatchingException$default, conflatedBufferedChannel.getSendException());
                throw undeliveredElementExceptionCallUndeliveredElementCatchingException$default;
            }
            throw conflatedBufferedChannel.getSendException();
        }
        return kotlin.Unit.INSTANCE;
    }

    static /* synthetic */ <E> java.lang.Object sendBroadcast$suspendImpl(kotlinx.coroutines.channels.ConflatedBufferedChannel<E> conflatedBufferedChannel, E e, kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        java.lang.Object objM2118trySendImplMj0NB7M = conflatedBufferedChannel.m2118trySendImplMj0NB7M(e, true);
        if (!(objM2118trySendImplMj0NB7M instanceof kotlinx.coroutines.channels.ChannelResult.Failed)) {
            return kotlin.coroutines.jvm.internal.Boxing.boxBoolean(true);
        }
        return kotlin.coroutines.jvm.internal.Boxing.boxBoolean(false);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU */
    public java.lang.Object mo2090trySendJP2dKIU(E element) {
        return m2118trySendImplMj0NB7M(element, false);
    }

    /* JADX INFO: renamed from: trySendImpl-Mj0NB7M, reason: not valid java name */
    private final java.lang.Object m2118trySendImplMj0NB7M(E element, boolean isSendOp) {
        return this.onBufferOverflow == kotlinx.coroutines.channels.BufferOverflow.DROP_LATEST ? m2117trySendDropLatestMj0NB7M(element, isSendOp) : m2096trySendDropOldestJP2dKIU(element);
    }

    /* JADX INFO: renamed from: trySendDropLatest-Mj0NB7M, reason: not valid java name */
    private final java.lang.Object m2117trySendDropLatestMj0NB7M(E element, boolean isSendOp) {
        kotlin.jvm.functions.Function1<E, kotlin.Unit> function1;
        kotlinx.coroutines.internal.UndeliveredElementException undeliveredElementExceptionCallUndeliveredElementCatchingException$default;
        java.lang.Object objMo2090trySendJP2dKIU = super.mo2090trySendJP2dKIU(element);
        if (kotlinx.coroutines.channels.ChannelResult.m2111isSuccessimpl(objMo2090trySendJP2dKIU) || kotlinx.coroutines.channels.ChannelResult.m2109isClosedimpl(objMo2090trySendJP2dKIU)) {
            return objMo2090trySendJP2dKIU;
        }
        if (isSendOp && (function1 = this.onUndeliveredElement) != null && (undeliveredElementExceptionCallUndeliveredElementCatchingException$default = kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, element, null, 2, null)) != null) {
            throw undeliveredElementExceptionCallUndeliveredElementCatchingException$default;
        }
        return kotlinx.coroutines.channels.ChannelResult.INSTANCE.m2116successJP2dKIU(kotlin.Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.BufferedChannel
    protected void registerSelectForSend(kotlinx.coroutines.selects.SelectInstance<?> select, java.lang.Object element) {
        java.lang.Object objMo2090trySendJP2dKIU = mo2090trySendJP2dKIU(element);
        if (!(objMo2090trySendJP2dKIU instanceof kotlinx.coroutines.channels.ChannelResult.Failed)) {
            select.selectInRegistrationPhase(kotlin.Unit.INSTANCE);
        } else {
            if (!(objMo2090trySendJP2dKIU instanceof kotlinx.coroutines.channels.ChannelResult.Closed)) {
                throw new java.lang.IllegalStateException("unreachable".toString());
            }
            kotlinx.coroutines.channels.ChannelResult.m2105exceptionOrNullimpl(objMo2090trySendJP2dKIU);
            select.selectInRegistrationPhase(kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED());
        }
    }
}
