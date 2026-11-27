package kotlin.reflect.jvm.internal.impl.util;

/* JADX INFO: compiled from: ArrayMap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmptyArrayMap extends kotlin.reflect.jvm.internal.impl.util.ArrayMap {
    public static final kotlin.reflect.jvm.internal.impl.util.EmptyArrayMap INSTANCE = new kotlin.reflect.jvm.internal.impl.util.EmptyArrayMap();

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public java.lang.Void get(int i) {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public int getSize() {
        return 0;
    }

    private EmptyArrayMap() {
        super(null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public void set(int i, java.lang.Void value) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
        throw new java.lang.IllegalStateException();
    }

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.util.EmptyArrayMap$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: ArrayMap.kt */
    public static final class AnonymousClass1 implements java.util.Iterator, kotlin.jvm.internal.markers.KMappedMarker {
        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new java.lang.UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        AnonymousClass1() {
        }

        @Override // java.util.Iterator
        public java.lang.Void next() {
            throw new java.util.NoSuchElementException();
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap, java.lang.Iterable
    public java.util.Iterator iterator() {
        return new kotlin.reflect.jvm.internal.impl.util.EmptyArrayMap.AnonymousClass1();
    }
}
