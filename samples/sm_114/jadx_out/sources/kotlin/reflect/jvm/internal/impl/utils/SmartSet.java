package kotlin.reflect.jvm.internal.impl.utils;

/* JADX INFO: compiled from: SmartSet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SmartSet<T> extends kotlin.collections.AbstractMutableSet<T> {
    public static final kotlin.reflect.jvm.internal.impl.utils.SmartSet.Companion Companion = new kotlin.reflect.jvm.internal.impl.utils.SmartSet.Companion(null);
    private java.lang.Object data;
    private int size;

    public /* synthetic */ SmartSet(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @kotlin.jvm.JvmStatic
    public static final <T> kotlin.reflect.jvm.internal.impl.utils.SmartSet<T> create() {
        return Companion.create();
    }

    /* JADX INFO: compiled from: SmartSet.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @kotlin.jvm.JvmStatic
        public final <T> kotlin.reflect.jvm.internal.impl.utils.SmartSet<T> create() {
            return new kotlin.reflect.jvm.internal.impl.utils.SmartSet<>(null);
        }

        @kotlin.jvm.JvmStatic
        public final <T> kotlin.reflect.jvm.internal.impl.utils.SmartSet<T> create(java.util.Collection<? extends T> set) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(set, "set");
            kotlin.reflect.jvm.internal.impl.utils.SmartSet<T> smartSet = new kotlin.reflect.jvm.internal.impl.utils.SmartSet<>(null);
            smartSet.addAll(set);
            return smartSet;
        }
    }

    private SmartSet() {
    }

    @Override // kotlin.collections.AbstractMutableSet
    public int getSize() {
        return this.size;
    }

    public void setSize(int i) {
        this.size = i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public java.util.Iterator<T> iterator() {
        if (size() == 0) {
            return java.util.Collections.EMPTY_SET.iterator();
        }
        if (size() == 1) {
            return new kotlin.reflect.jvm.internal.impl.utils.SmartSet.SingletonIterator(this.data);
        }
        if (size() < 5) {
            java.lang.Object obj = this.data;
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            return new kotlin.reflect.jvm.internal.impl.utils.SmartSet.ArrayIterator((java.lang.Object[]) obj);
        }
        java.lang.Object obj2 = this.data;
        kotlin.jvm.internal.Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
        return kotlin.jvm.internal.TypeIntrinsics.asMutableSet(obj2).iterator();
    }

    @Override // kotlin.collections.AbstractMutableSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(T t) {
        java.lang.Object obj;
        if (size() == 0) {
            this.data = t;
        } else if (size() == 1) {
            if (kotlin.jvm.internal.Intrinsics.areEqual(this.data, t)) {
                return false;
            }
            this.data = new java.lang.Object[]{this.data, t};
        } else if (size() < 5) {
            java.lang.Object obj2 = this.data;
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            java.lang.Object[] objArr = (java.lang.Object[]) obj2;
            if (kotlin.collections.ArraysKt.contains(objArr, t)) {
                return false;
            }
            if (size() == 4) {
                java.util.LinkedHashSet linkedHashSetLinkedSetOf = kotlin.collections.SetsKt.linkedSetOf(java.util.Arrays.copyOf(objArr, objArr.length));
                linkedHashSetLinkedSetOf.add(t);
                obj = linkedHashSetLinkedSetOf;
            } else {
                java.lang.Object[] objArrCopyOf = java.util.Arrays.copyOf(objArr, size() + 1);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
                objArrCopyOf[objArrCopyOf.length - 1] = t;
                obj = objArrCopyOf;
            }
            this.data = obj;
        } else {
            java.lang.Object obj3 = this.data;
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
            if (!kotlin.jvm.internal.TypeIntrinsics.asMutableSet(obj3).add(t)) {
                return false;
            }
        }
        setSize(size() + 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.data = null;
        setSize(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(java.lang.Object obj) {
        if (size() == 0) {
            return false;
        }
        if (size() == 1) {
            return kotlin.jvm.internal.Intrinsics.areEqual(this.data, obj);
        }
        if (size() < 5) {
            java.lang.Object obj2 = this.data;
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            return kotlin.collections.ArraysKt.contains((java.lang.Object[]) obj2, obj);
        }
        java.lang.Object obj3 = this.data;
        kotlin.jvm.internal.Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.collections.Set<T of org.jetbrains.kotlin.utils.SmartSet>");
        return ((java.util.Set) obj3).contains(obj);
    }

    /* JADX INFO: compiled from: SmartSet.kt */
    private static final class SingletonIterator<T> implements java.util.Iterator<T>, kotlin.jvm.internal.markers.KMutableIterator {
        private final T element;
        private boolean hasNext = true;

        public SingletonIterator(T t) {
            this.element = t;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.hasNext) {
                this.hasNext = false;
                return this.element;
            }
            throw new java.util.NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.hasNext;
        }

        @Override // java.util.Iterator
        public java.lang.Void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    /* JADX INFO: compiled from: SmartSet.kt */
    private static final class ArrayIterator<T> implements java.util.Iterator<T>, kotlin.jvm.internal.markers.KMutableIterator {
        private final java.util.Iterator<T> arrayIterator;

        public ArrayIterator(T[] array) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(array, "array");
            this.arrayIterator = kotlin.jvm.internal.ArrayIteratorKt.iterator(array);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.arrayIterator.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.arrayIterator.next();
        }

        @Override // java.util.Iterator
        public java.lang.Void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }
}
