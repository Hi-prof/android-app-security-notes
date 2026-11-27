package com.facebook.imagepipeline.cache;

/* JADX INFO: compiled from: CountingMemoryCacheInspector.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0002\n\u000bB\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\tR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/facebook/imagepipeline/cache/CountingMemoryCacheInspector;", "K", "V", "", "countingBitmapCache", "Lcom/facebook/imagepipeline/cache/CountingMemoryCache;", "<init>", "(Lcom/facebook/imagepipeline/cache/CountingMemoryCache;)V", "dumpCacheContent", "Lcom/facebook/imagepipeline/cache/CountingMemoryCacheInspector$DumpInfo;", "DumpInfoEntry", "DumpInfo", "imagepipeline-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CountingMemoryCacheInspector<K, V> {
    private final com.facebook.imagepipeline.cache.CountingMemoryCache<K, V> countingBitmapCache;

    public CountingMemoryCacheInspector(com.facebook.imagepipeline.cache.CountingMemoryCache<K, V> countingBitmapCache) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(countingBitmapCache, "countingBitmapCache");
        this.countingBitmapCache = countingBitmapCache;
    }

    /* JADX INFO: compiled from: CountingMemoryCacheInspector.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00028\u0002\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000b\u001a\u00020\fR\u0012\u0010\u0004\u001a\u00028\u00028\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/facebook/imagepipeline/cache/CountingMemoryCacheInspector$DumpInfoEntry;", "K", "V", "", io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_KEY, "valueRef", "Lcom/facebook/common/references/CloseableReference;", "<init>", "(Ljava/lang/Object;Lcom/facebook/common/references/CloseableReference;)V", "Ljava/lang/Object;", "value", "release", "", "imagepipeline-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class DumpInfoEntry<K, V> {
        public final K key;
        public final com.facebook.common.references.CloseableReference<V> value;

        public DumpInfoEntry(K k, com.facebook.common.references.CloseableReference<V> closeableReference) {
            if (k != null) {
                this.key = k;
                this.value = com.facebook.common.references.CloseableReference.cloneOrNull(closeableReference);
                return;
            }
            throw new java.lang.IllegalStateException("Required value was null.".toString());
        }

        public final void release() {
            com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) this.value);
        }
    }

    /* JADX INFO: compiled from: CountingMemoryCacheInspector.kt */
    @kotlin.Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0015\u001a\u00020\u0016R\u0010\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00100\u000f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00100\u000f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00030\u00138\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/facebook/imagepipeline/cache/CountingMemoryCacheInspector$DumpInfo;", "K", "V", "", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE, "", "lruSize", "params", "Lcom/facebook/imagepipeline/cache/MemoryCacheParams;", "<init>", "(IILcom/facebook/imagepipeline/cache/MemoryCacheParams;)V", "maxSize", "maxEntriesCount", "maxEntrySize", "lruEntries", "", "Lcom/facebook/imagepipeline/cache/CountingMemoryCacheInspector$DumpInfoEntry;", "sharedEntries", "otherEntries", "", "Landroid/graphics/Bitmap;", "release", "", "imagepipeline-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class DumpInfo<K, V> {
        public final java.util.List<com.facebook.imagepipeline.cache.CountingMemoryCacheInspector.DumpInfoEntry<K, V>> lruEntries;
        public final int lruSize;
        public final int maxEntriesCount;
        public final int maxEntrySize;
        public final int maxSize;
        public final java.util.Map<android.graphics.Bitmap, java.lang.Object> otherEntries;
        public final java.util.List<com.facebook.imagepipeline.cache.CountingMemoryCacheInspector.DumpInfoEntry<K, V>> sharedEntries;
        public final int size;

        public DumpInfo(int i, int i2, com.facebook.imagepipeline.cache.MemoryCacheParams params) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(params, "params");
            this.maxSize = params.maxCacheSize;
            this.maxEntriesCount = params.maxCacheEntries;
            this.maxEntrySize = params.maxCacheEntrySize;
            this.size = i;
            this.lruSize = i2;
            this.lruEntries = new java.util.ArrayList();
            this.sharedEntries = new java.util.ArrayList();
            this.otherEntries = new java.util.HashMap();
        }

        public final void release() {
            java.util.Iterator<com.facebook.imagepipeline.cache.CountingMemoryCacheInspector.DumpInfoEntry<K, V>> it = this.lruEntries.iterator();
            while (it.hasNext()) {
                it.next().release();
            }
            java.util.Iterator<com.facebook.imagepipeline.cache.CountingMemoryCacheInspector.DumpInfoEntry<K, V>> it2 = this.sharedEntries.iterator();
            while (it2.hasNext()) {
                it2.next().release();
            }
        }
    }

    public final com.facebook.imagepipeline.cache.CountingMemoryCacheInspector.DumpInfo<K, V> dumpCacheContent() {
        synchronized (this.countingBitmapCache) {
            int sizeInBytes = this.countingBitmapCache.getSizeInBytes();
            int evictionQueueSizeInBytes = this.countingBitmapCache.getEvictionQueueSizeInBytes();
            com.facebook.imagepipeline.cache.MemoryCacheParams memoryCacheParams = this.countingBitmapCache.getMemoryCacheParams();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(memoryCacheParams, "getMemoryCacheParams(...)");
            com.facebook.imagepipeline.cache.CountingMemoryCacheInspector.DumpInfo<K, V> dumpInfo = new com.facebook.imagepipeline.cache.CountingMemoryCacheInspector.DumpInfo<>(sizeInBytes, evictionQueueSizeInBytes, memoryCacheParams);
            com.facebook.imagepipeline.cache.CountingLruMap<K, com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> cachedEntries = this.countingBitmapCache.getCachedEntries();
            if (cachedEntries == null) {
                return dumpInfo;
            }
            java.util.ArrayList<java.util.Map.Entry<K, com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>>> matchingEntries = cachedEntries.getMatchingEntries(null);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(matchingEntries, "getMatchingEntries(...)");
            java.util.Iterator<java.util.Map.Entry<K, com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>>> it = matchingEntries.iterator();
            while (it.hasNext()) {
                com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> value = it.next().getValue();
                com.facebook.imagepipeline.cache.CountingMemoryCacheInspector.DumpInfoEntry<K, V> dumpInfoEntry = new com.facebook.imagepipeline.cache.CountingMemoryCacheInspector.DumpInfoEntry<>(value.key, value.valueRef);
                if (value.clientCount > 0) {
                    dumpInfo.sharedEntries.add(dumpInfoEntry);
                } else {
                    dumpInfo.lruEntries.add(dumpInfoEntry);
                }
            }
            java.util.Map<android.graphics.Bitmap, java.lang.Object> otherEntries = this.countingBitmapCache.getOtherEntries();
            if (otherEntries != null) {
                for (java.util.Map.Entry<android.graphics.Bitmap, java.lang.Object> entry : otherEntries.entrySet()) {
                    if (entry != null && !entry.getKey().isRecycled()) {
                        dumpInfo.otherEntries.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            return dumpInfo;
        }
    }
}
