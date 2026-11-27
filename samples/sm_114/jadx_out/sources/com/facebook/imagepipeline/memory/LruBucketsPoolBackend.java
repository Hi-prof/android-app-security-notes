package com.facebook.imagepipeline.memory;

/* JADX INFO: loaded from: classes.dex */
public abstract class LruBucketsPoolBackend<T> implements com.facebook.imagepipeline.memory.PoolBackend<T> {
    private final java.util.Set<T> mCurrentItems = new java.util.HashSet();
    private final com.facebook.imagepipeline.memory.BucketMap<T> mMap = new com.facebook.imagepipeline.memory.BucketMap<>();

    @Override // com.facebook.imagepipeline.memory.PoolBackend
    @javax.annotation.Nullable
    public T get(int i) {
        return maybeRemoveFromCurrentItems(this.mMap.acquire(i));
    }

    @Override // com.facebook.imagepipeline.memory.PoolBackend
    public void put(T t) {
        boolean zAdd;
        synchronized (this) {
            zAdd = this.mCurrentItems.add(t);
        }
        if (zAdd) {
            this.mMap.release(getSize(t), t);
        }
    }

    @Override // com.facebook.imagepipeline.memory.PoolBackend
    @javax.annotation.Nullable
    public T pop() {
        return maybeRemoveFromCurrentItems(this.mMap.removeFromEnd());
    }

    @javax.annotation.Nullable
    private T maybeRemoveFromCurrentItems(@javax.annotation.Nullable T t) {
        if (t == null) {
            return t;
        }
        synchronized (this) {
            this.mCurrentItems.remove(t);
        }
        return t;
    }

    int valueCount() {
        return this.mMap.valueCount();
    }
}
