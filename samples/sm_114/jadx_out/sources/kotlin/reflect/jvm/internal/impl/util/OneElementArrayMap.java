package kotlin.reflect.jvm.internal.impl.util;

/* JADX INFO: compiled from: ArrayMap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OneElementArrayMap<T> extends kotlin.reflect.jvm.internal.impl.util.ArrayMap<T> {
    private final int index;
    private final T value;

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public int getSize() {
        return 1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OneElementArrayMap(T value, int i) {
        super(null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
        this.index = i;
    }

    public final int getIndex() {
        return this.index;
    }

    public final T getValue() {
        return this.value;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public void set(int i, T value) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
        throw new java.lang.IllegalStateException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public T get(int i) {
        if (i == this.index) {
            return this.value;
        }
        return null;
    }

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.util.OneElementArrayMap$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: ArrayMap.kt */
    public static final class AnonymousClass1 implements java.util.Iterator<T>, kotlin.jvm.internal.markers.KMappedMarker {
        private boolean notVisited = true;
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.util.OneElementArrayMap<T> this$0;

        @Override // java.util.Iterator
        public void remove() {
            throw new java.lang.UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        AnonymousClass1(kotlin.reflect.jvm.internal.impl.util.OneElementArrayMap<T> oneElementArrayMap) {
            this.this$0 = oneElementArrayMap;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.notVisited;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.notVisited) {
                this.notVisited = false;
                return this.this$0.getValue();
            }
            throw new java.util.NoSuchElementException();
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap, java.lang.Iterable
    public java.util.Iterator<T> iterator() {
        return new kotlin.reflect.jvm.internal.impl.util.OneElementArrayMap.AnonymousClass1(this);
    }
}
