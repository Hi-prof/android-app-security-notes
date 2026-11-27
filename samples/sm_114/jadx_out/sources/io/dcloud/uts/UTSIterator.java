package io.dcloud.uts;

/* JADX INFO: compiled from: UTSIterator.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0010H\u0096\u0002J\u000e\u0010\u0003\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0015R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lio/dcloud/uts/UTSIterator;", "T", "", "next", "Lkotlin/Function0;", "Lio/dcloud/uts/UTSIteratorResult;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "getNext", "()Lkotlin/jvm/functions/Function0;", "cacheNext", "getCacheNext", "()Lio/dcloud/uts/UTSIteratorResult;", "setCacheNext", "(Lio/dcloud/uts/UTSIteratorResult;)V", "hasNext", "", "getHasNext", "()Z", "setHasNext", "(Z)V", "()Ljava/lang/Object;", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class UTSIterator<T> implements java.util.Iterator<T>, kotlin.jvm.internal.markers.KMappedMarker {
    private io.dcloud.uts.UTSIteratorResult<T> cacheNext;
    private boolean hasNext;
    private final kotlin.jvm.functions.Function0<io.dcloud.uts.UTSIteratorResult<T>> next;

    @Override // java.util.Iterator
    public void remove() {
        throw new java.lang.UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public UTSIterator(kotlin.jvm.functions.Function0<io.dcloud.uts.UTSIteratorResult<T>> next) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(next, "next");
        this.next = next;
        kotlin.jvm.internal.Intrinsics.checkNotNull(next);
        io.dcloud.uts.UTSIteratorResult<T> uTSIteratorResultInvoke = next.invoke();
        this.cacheNext = uTSIteratorResultInvoke;
        kotlin.jvm.internal.Intrinsics.checkNotNull(uTSIteratorResultInvoke);
        this.hasNext = !uTSIteratorResultInvoke.getDone();
    }

    public final kotlin.jvm.functions.Function0<io.dcloud.uts.UTSIteratorResult<T>> getNext() {
        return this.next;
    }

    public final io.dcloud.uts.UTSIteratorResult<T> getCacheNext() {
        return this.cacheNext;
    }

    public final void setCacheNext(io.dcloud.uts.UTSIteratorResult<T> uTSIteratorResult) {
        this.cacheNext = uTSIteratorResult;
    }

    public final boolean getHasNext() {
        return this.hasNext;
    }

    public final void setHasNext(boolean z) {
        this.hasNext = z;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // java.util.Iterator
    public T next() {
        io.dcloud.uts.UTSIteratorResult<T> uTSIteratorResult = this.cacheNext;
        if (uTSIteratorResult != null) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(uTSIteratorResult);
            T value = uTSIteratorResult.getValue();
            kotlin.jvm.functions.Function0<io.dcloud.uts.UTSIteratorResult<T>> function0 = this.next;
            kotlin.jvm.internal.Intrinsics.checkNotNull(function0);
            io.dcloud.uts.UTSIteratorResult<T> uTSIteratorResultInvoke = function0.invoke();
            this.cacheNext = uTSIteratorResultInvoke;
            kotlin.jvm.internal.Intrinsics.checkNotNull(uTSIteratorResultInvoke);
            this.hasNext = !uTSIteratorResultInvoke.getDone();
            return value;
        }
        kotlin.jvm.functions.Function0<io.dcloud.uts.UTSIteratorResult<T>> function1 = this.next;
        kotlin.jvm.internal.Intrinsics.checkNotNull(function1);
        io.dcloud.uts.UTSIteratorResult<T> uTSIteratorResultInvoke2 = function1.invoke();
        if (uTSIteratorResultInvoke2.getDone()) {
            this.hasNext = false;
        }
        return uTSIteratorResultInvoke2.getValue();
    }
}
