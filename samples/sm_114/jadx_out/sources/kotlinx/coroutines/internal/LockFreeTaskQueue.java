package kotlinx.coroutines.internal;

/* JADX INFO: compiled from: LockFreeTaskQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0004J&\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0017\"\u0004\b\u0001\u0010\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00180\u001aJ\r\u0010\u001b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u001cR\u001f\u0010\u0006\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u00000\bj\b\u0012\u0004\u0012\u00028\u0000`\t0\u0007X\u0082\u0004R\u0011\u0010\n\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "E", "", "singleConsumer", "", "(Z)V", "_cur", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "Lkotlinx/coroutines/internal/Core;", "isEmpty", "()Z", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE, "", "getSize", "()I", "addLast", com.alibaba.android.bindingx.core.internal.BindingXConstants.KEY_ELEMENT, "(Ljava/lang/Object;)Z", io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE, "", "isClosed", "map", "", "R", "transform", "Lkotlin/Function1;", "removeFirstOrNull", "()Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class LockFreeTaskQueue<E> {
    private static final /* synthetic */ java.util.concurrent.atomic.AtomicReferenceFieldUpdater _cur$volatile$FU = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlinx.coroutines.internal.LockFreeTaskQueue.class, java.lang.Object.class, "_cur$volatile");
    private volatile /* synthetic */ java.lang.Object _cur$volatile;

    private final /* synthetic */ java.lang.Object get_cur$volatile() {
        return this._cur$volatile;
    }

    private final /* synthetic */ void loop$atomicfu(java.lang.Object obj, java.util.concurrent.atomic.AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> function1) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    private final /* synthetic */ void set_cur$volatile(java.lang.Object obj) {
        this._cur$volatile = obj;
    }

    public LockFreeTaskQueue(boolean z) {
        this._cur$volatile = new kotlinx.coroutines.internal.LockFreeTaskQueueCore(8, z);
    }

    public final boolean isEmpty() {
        return ((kotlinx.coroutines.internal.LockFreeTaskQueueCore) _cur$volatile$FU.get(this)).isEmpty();
    }

    public final int getSize() {
        return ((kotlinx.coroutines.internal.LockFreeTaskQueueCore) _cur$volatile$FU.get(this)).getSize();
    }

    public final void close() {
        java.util.concurrent.atomic.AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _cur$volatile$FU;
        while (true) {
            kotlinx.coroutines.internal.LockFreeTaskQueueCore lockFreeTaskQueueCore = (kotlinx.coroutines.internal.LockFreeTaskQueueCore) atomicReferenceFieldUpdater.get(this);
            if (lockFreeTaskQueueCore.close()) {
                return;
            } else {
                androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_cur$volatile$FU, this, lockFreeTaskQueueCore, lockFreeTaskQueueCore.next());
            }
        }
    }

    public final boolean addLast(E element) {
        java.util.concurrent.atomic.AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _cur$volatile$FU;
        while (true) {
            kotlinx.coroutines.internal.LockFreeTaskQueueCore lockFreeTaskQueueCore = (kotlinx.coroutines.internal.LockFreeTaskQueueCore) atomicReferenceFieldUpdater.get(this);
            int iAddLast = lockFreeTaskQueueCore.addLast(element);
            if (iAddLast == 0) {
                return true;
            }
            if (iAddLast == 1) {
                androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_cur$volatile$FU, this, lockFreeTaskQueueCore, lockFreeTaskQueueCore.next());
            } else if (iAddLast == 2) {
                return false;
            }
        }
    }

    public final E removeFirstOrNull() {
        java.util.concurrent.atomic.AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _cur$volatile$FU;
        while (true) {
            kotlinx.coroutines.internal.LockFreeTaskQueueCore lockFreeTaskQueueCore = (kotlinx.coroutines.internal.LockFreeTaskQueueCore) atomicReferenceFieldUpdater.get(this);
            E e = (E) lockFreeTaskQueueCore.removeFirstOrNull();
            if (e != kotlinx.coroutines.internal.LockFreeTaskQueueCore.REMOVE_FROZEN) {
                return e;
            }
            androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_cur$volatile$FU, this, lockFreeTaskQueueCore, lockFreeTaskQueueCore.next());
        }
    }

    public final <R> java.util.List<R> map(kotlin.jvm.functions.Function1<? super E, ? extends R> transform) {
        return ((kotlinx.coroutines.internal.LockFreeTaskQueueCore) _cur$volatile$FU.get(this)).map(transform);
    }

    public final boolean isClosed() {
        return ((kotlinx.coroutines.internal.LockFreeTaskQueueCore) _cur$volatile$FU.get(this)).isClosed();
    }
}
