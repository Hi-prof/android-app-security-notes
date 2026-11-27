package kotlin.reflect.jvm.internal.impl.storage;

/* JADX INFO: compiled from: locks.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmptySimpleLock implements kotlin.reflect.jvm.internal.impl.storage.SimpleLock {
    public static final kotlin.reflect.jvm.internal.impl.storage.EmptySimpleLock INSTANCE = new kotlin.reflect.jvm.internal.impl.storage.EmptySimpleLock();

    @Override // kotlin.reflect.jvm.internal.impl.storage.SimpleLock
    public void lock() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.SimpleLock
    public void unlock() {
    }

    private EmptySimpleLock() {
    }
}
