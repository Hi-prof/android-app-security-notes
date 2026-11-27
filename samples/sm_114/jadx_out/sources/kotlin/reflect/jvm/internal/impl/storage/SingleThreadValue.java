package kotlin.reflect.jvm.internal.impl.storage;

/* JADX INFO: loaded from: classes2.dex */
class SingleThreadValue<T> {
    private final java.lang.Thread thread = java.lang.Thread.currentThread();
    private final T value;

    SingleThreadValue(T t) {
        this.value = t;
    }

    public boolean hasValue() {
        return this.thread == java.lang.Thread.currentThread();
    }

    public T getValue() {
        if (!hasValue()) {
            throw new java.lang.IllegalStateException("No value in this thread (hasValue should be checked before)");
        }
        return this.value;
    }
}
