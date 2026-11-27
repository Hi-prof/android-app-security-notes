package kotlin.reflect.jvm.internal.impl.util;

/* JADX INFO: compiled from: ArrayMap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ArrayMapImpl<T> extends kotlin.reflect.jvm.internal.impl.util.ArrayMap<T> {
    public static final kotlin.reflect.jvm.internal.impl.util.ArrayMapImpl.Companion Companion = new kotlin.reflect.jvm.internal.impl.util.ArrayMapImpl.Companion(null);
    private java.lang.Object[] data;
    private int size;

    /* JADX INFO: compiled from: ArrayMap.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private ArrayMapImpl(java.lang.Object[] objArr, int i) {
        super(null);
        this.data = objArr;
        this.size = i;
    }

    public ArrayMapImpl() {
        this(new java.lang.Object[20], 0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public int getSize() {
        return this.size;
    }

    private final void ensureCapacity(int i) {
        java.lang.Object[] objArr = this.data;
        if (objArr.length > i) {
            return;
        }
        int length = objArr.length;
        do {
            length *= 2;
        } while (length <= i);
        java.lang.Object[] objArrCopyOf = java.util.Arrays.copyOf(this.data, length);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        this.data = objArrCopyOf;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public void set(int i, T value) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
        ensureCapacity(i);
        if (this.data[i] == null) {
            this.size = getSize() + 1;
        }
        this.data[i] = value;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public T get(int i) {
        return (T) kotlin.collections.ArraysKt.getOrNull(this.data, i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap, java.lang.Iterable
    public java.util.Iterator<T> iterator() {
        return new kotlin.collections.AbstractIterator<T>(this) { // from class: kotlin.reflect.jvm.internal.impl.util.ArrayMapImpl.iterator.1
            private int index = -1;
            final /* synthetic */ kotlin.reflect.jvm.internal.impl.util.ArrayMapImpl<T> this$0;

            {
                this.this$0 = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.collections.AbstractIterator
            protected void computeNext() {
                do {
                    int i = this.index + 1;
                    this.index = i;
                    if (i >= ((kotlin.reflect.jvm.internal.impl.util.ArrayMapImpl) this.this$0).data.length) {
                        break;
                    }
                } while (((kotlin.reflect.jvm.internal.impl.util.ArrayMapImpl) this.this$0).data[this.index] == null);
                if (this.index < ((kotlin.reflect.jvm.internal.impl.util.ArrayMapImpl) this.this$0).data.length) {
                    java.lang.Object obj = ((kotlin.reflect.jvm.internal.impl.util.ArrayMapImpl) this.this$0).data[this.index];
                    kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of org.jetbrains.kotlin.util.ArrayMapImpl");
                    setNext(obj);
                    return;
                }
                done();
            }
        };
    }
}
