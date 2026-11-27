package com.facebook.imagepipeline.cache;

/* JADX INFO: loaded from: classes.dex */
public interface CountingMemoryCache<K, V> extends com.facebook.imagepipeline.cache.MemoryCache<K, V>, com.facebook.common.memory.MemoryTrimmable {

    public interface EntryStateObserver<K> {
        void onExclusivityChanged(K k, boolean z);
    }

    @javax.annotation.Nullable
    com.facebook.common.references.CloseableReference<V> cache(K k, com.facebook.common.references.CloseableReference<V> closeableReference, com.facebook.imagepipeline.cache.CountingMemoryCache.EntryStateObserver<K> entryStateObserver);

    void clear();

    @javax.annotation.Nullable
    com.facebook.imagepipeline.cache.CountingLruMap<K, com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> getCachedEntries();

    int getEvictionQueueCount();

    int getEvictionQueueSizeInBytes();

    int getInUseSizeInBytes();

    com.facebook.imagepipeline.cache.MemoryCacheParams getMemoryCacheParams();

    @javax.annotation.Nullable
    java.util.Map<android.graphics.Bitmap, java.lang.Object> getOtherEntries();

    void maybeEvictEntries();

    @javax.annotation.Nullable
    com.facebook.common.references.CloseableReference<V> reuse(K k);

    public static class Entry<K, V> {
        public final K key;

        @javax.annotation.Nullable
        public final com.facebook.imagepipeline.cache.CountingMemoryCache.EntryStateObserver<K> observer;
        public int size;
        public final com.facebook.common.references.CloseableReference<V> valueRef;
        public int clientCount = 0;
        public boolean isOrphan = false;
        public int accessCount = 0;

        private Entry(K k, com.facebook.common.references.CloseableReference<V> closeableReference, @javax.annotation.Nullable com.facebook.imagepipeline.cache.CountingMemoryCache.EntryStateObserver<K> entryStateObserver, int i) {
            this.key = (K) com.facebook.common.internal.Preconditions.checkNotNull(k);
            this.valueRef = (com.facebook.common.references.CloseableReference) com.facebook.common.internal.Preconditions.checkNotNull(com.facebook.common.references.CloseableReference.cloneOrNull(closeableReference));
            this.observer = entryStateObserver;
            this.size = i;
        }

        public static <K, V> com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> of(K k, com.facebook.common.references.CloseableReference<V> closeableReference, @javax.annotation.Nullable com.facebook.imagepipeline.cache.CountingMemoryCache.EntryStateObserver<K> entryStateObserver) {
            return of(k, closeableReference, -1, entryStateObserver);
        }

        public static <K, V> com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> of(K k, com.facebook.common.references.CloseableReference<V> closeableReference, int i, @javax.annotation.Nullable com.facebook.imagepipeline.cache.CountingMemoryCache.EntryStateObserver<K> entryStateObserver) {
            return new com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<>(k, closeableReference, entryStateObserver, i);
        }
    }
}
