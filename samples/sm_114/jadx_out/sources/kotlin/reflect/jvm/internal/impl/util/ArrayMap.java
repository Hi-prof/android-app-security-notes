package kotlin.reflect.jvm.internal.impl.util;

/* JADX INFO: compiled from: ArrayMap.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ArrayMap<T> implements java.lang.Iterable<T>, kotlin.jvm.internal.markers.KMappedMarker {
    public /* synthetic */ ArrayMap(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract T get(int i);

    public abstract int getSize();

    @Override // java.lang.Iterable
    public java.util.Iterator<T> iterator() {
        throw new java.lang.UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public abstract void set(int i, T t);

    private ArrayMap() {
    }
}
