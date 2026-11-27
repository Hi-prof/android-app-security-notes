package com.facebook.imagepipeline.cache;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractAdaptiveCountingMemoryCache<K, V> implements com.facebook.imagepipeline.cache.CountingMemoryCache<K, V> {
    static final int DEFAULT_ADAPTIVE_RATE_PROMIL = 10;
    static final int DEFAULT_LFU_FRACTION_PROMIL = 500;
    static final int MAX_FRACTION_PROMIL = 900;
    static final int MIN_FRACTION_PROMIL = 100;
    private static final java.lang.String TAG = "AbstractArcCountingMemoryCache";
    static final int TOTAL_PROMIL = 1000;
    final int mAdaptiveRatePromil;
    private final com.facebook.imagepipeline.cache.MemoryCache.CacheTrimStrategy mCacheTrimStrategy;
    final com.facebook.imagepipeline.cache.CountingLruMap<K, com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> mCachedEntries;
    private final int mFrequentlyUsedThreshold;
    final int mGhostListMaxSize;
    int mLFUFractionPromil;
    private long mLastCacheParamsCheck;
    final com.facebook.imagepipeline.cache.CountingLruMap<K, com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> mLeastFrequentlyUsedExclusiveEntries;
    final com.facebook.imagepipeline.cache.AbstractAdaptiveCountingMemoryCache<K, V>.IntMapArrayList<K> mLeastFrequentlyUsedKeysGhostList;
    protected com.facebook.imagepipeline.cache.MemoryCacheParams mMemoryCacheParams;
    private final com.facebook.common.internal.Supplier<com.facebook.imagepipeline.cache.MemoryCacheParams> mMemoryCacheParamsSupplier;
    final com.facebook.imagepipeline.cache.CountingLruMap<K, com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> mMostFrequentlyUsedExclusiveEntries;
    final java.util.ArrayList<K> mMostFrequentlyUsedKeysGhostList;
    private final com.facebook.imagepipeline.cache.ValueDescriptor<V> mValueDescriptor;

    enum ArrayListType {
        LFU,
        MFU
    }

    protected abstract void logIllegalAdaptiveRate();

    protected abstract void logIllegalLfuFraction();

    public AbstractAdaptiveCountingMemoryCache(com.facebook.common.internal.Supplier<com.facebook.imagepipeline.cache.MemoryCacheParams> supplier, com.facebook.imagepipeline.cache.MemoryCache.CacheTrimStrategy cacheTrimStrategy, com.facebook.imagepipeline.cache.ValueDescriptor<V> valueDescriptor, int i, int i2, int i3, int i4) {
        com.facebook.common.logging.FLog.d(TAG, "Create Adaptive Replacement Cache");
        this.mValueDescriptor = valueDescriptor;
        this.mLeastFrequentlyUsedExclusiveEntries = new com.facebook.imagepipeline.cache.CountingLruMap<>(wrapValueDescriptor(valueDescriptor));
        this.mMostFrequentlyUsedExclusiveEntries = new com.facebook.imagepipeline.cache.CountingLruMap<>(wrapValueDescriptor(valueDescriptor));
        this.mCachedEntries = new com.facebook.imagepipeline.cache.CountingLruMap<>(wrapValueDescriptor(valueDescriptor));
        this.mCacheTrimStrategy = cacheTrimStrategy;
        this.mMemoryCacheParamsSupplier = supplier;
        this.mMemoryCacheParams = (com.facebook.imagepipeline.cache.MemoryCacheParams) com.facebook.common.internal.Preconditions.checkNotNull(supplier.get(), "mMemoryCacheParamsSupplier returned null");
        this.mLastCacheParamsCheck = android.os.SystemClock.uptimeMillis();
        this.mFrequentlyUsedThreshold = i2;
        this.mGhostListMaxSize = i3;
        this.mLeastFrequentlyUsedKeysGhostList = new com.facebook.imagepipeline.cache.AbstractAdaptiveCountingMemoryCache.IntMapArrayList<>(i3);
        this.mMostFrequentlyUsedKeysGhostList = new java.util.ArrayList<>(i3);
        if (i4 < 100 || i4 > 900) {
            this.mLFUFractionPromil = DEFAULT_LFU_FRACTION_PROMIL;
            logIllegalLfuFraction();
        } else {
            this.mLFUFractionPromil = i4;
        }
        if (i <= 0 || i >= 1000) {
            this.mAdaptiveRatePromil = 10;
            logIllegalAdaptiveRate();
        } else {
            this.mAdaptiveRatePromil = i;
        }
    }

    private com.facebook.imagepipeline.cache.ValueDescriptor<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> wrapValueDescriptor(final com.facebook.imagepipeline.cache.ValueDescriptor<V> valueDescriptor) {
        return new com.facebook.imagepipeline.cache.ValueDescriptor<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>>() { // from class: com.facebook.imagepipeline.cache.AbstractAdaptiveCountingMemoryCache.1
            @Override // com.facebook.imagepipeline.cache.ValueDescriptor
            public int getSizeInBytes(com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entry) {
                return valueDescriptor.getSizeInBytes(entry.valueRef.get());
            }
        };
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    @javax.annotation.Nullable
    public com.facebook.common.references.CloseableReference<V> cache(K k, com.facebook.common.references.CloseableReference<V> closeableReference) {
        return cache(k, closeableReference, null);
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    @javax.annotation.Nullable
    public com.facebook.common.references.CloseableReference<V> cache(K k, com.facebook.common.references.CloseableReference<V> closeableReference, @javax.annotation.Nullable com.facebook.imagepipeline.cache.CountingMemoryCache.EntryStateObserver<K> entryStateObserver) {
        com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entryRemove;
        com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entryRemove2;
        com.facebook.common.references.CloseableReference<V> closeableReferenceNewClientReference;
        com.facebook.common.references.CloseableReference<V> closeableReferenceReferenceToClose;
        com.facebook.common.internal.Preconditions.checkNotNull(k);
        com.facebook.common.internal.Preconditions.checkNotNull(closeableReference);
        maybeUpdateCacheParams();
        synchronized (this) {
            entryRemove = this.mLeastFrequentlyUsedExclusiveEntries.remove(k);
            entryRemove2 = this.mMostFrequentlyUsedExclusiveEntries.remove(k);
            com.facebook.common.internal.Preconditions.checkState(entryRemove == null || entryRemove2 == null);
            com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entryRemove3 = this.mCachedEntries.remove(k);
            closeableReferenceNewClientReference = null;
            if (entryRemove3 != null) {
                makeOrphan(entryRemove3);
                closeableReferenceReferenceToClose = referenceToClose(entryRemove3);
            } else {
                closeableReferenceReferenceToClose = null;
            }
            if (canCacheNewValue(closeableReference.get())) {
                com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entryOf = com.facebook.imagepipeline.cache.CountingMemoryCache.Entry.of(k, closeableReference, entryStateObserver);
                java.lang.Integer value = this.mLeastFrequentlyUsedKeysGhostList.getValue(k);
                entryOf.accessCount = value != null ? value.intValue() : 0;
                this.mCachedEntries.put(k, entryOf);
                closeableReferenceNewClientReference = newClientReference(entryOf);
            }
        }
        com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) closeableReferenceReferenceToClose);
        maybeNotifyExclusiveEntryRemoval(entryRemove, entryRemove2);
        maybeEvictEntries();
        return closeableReferenceNewClientReference;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0025  */
    private synchronized boolean canCacheNewValue(V v) {
        boolean z;
        int sizeInBytes = this.mValueDescriptor.getSizeInBytes(v);
        if (sizeInBytes <= this.mMemoryCacheParams.maxCacheEntrySize) {
            z = getInUseCount() <= this.mMemoryCacheParams.maxCacheEntries - 1 && getInUseSizeInBytes() <= this.mMemoryCacheParams.maxCacheSize - sizeInBytes;
        }
        return z;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    @javax.annotation.Nullable
    public com.facebook.common.references.CloseableReference<V> get(K k) {
        com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entryRemove;
        com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entryRemove2;
        com.facebook.common.references.CloseableReference<V> closeableReferenceNewClientReference;
        com.facebook.common.internal.Preconditions.checkNotNull(k);
        synchronized (this) {
            entryRemove = this.mLeastFrequentlyUsedExclusiveEntries.remove(k);
            entryRemove2 = this.mMostFrequentlyUsedExclusiveEntries.remove(k);
            com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entry = this.mCachedEntries.get(k);
            if (entry != null) {
                closeableReferenceNewClientReference = newClientReference(entry);
            } else {
                maybeUpdateCacheFraction(k);
                closeableReferenceNewClientReference = null;
            }
        }
        maybeNotifyExclusiveEntryRemoval(entryRemove, entryRemove2);
        maybeUpdateCacheParams();
        maybeEvictEntries();
        return closeableReferenceNewClientReference;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    @javax.annotation.Nullable
    public V inspect(K k) {
        com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entry = this.mCachedEntries.get(k);
        if (entry == null) {
            return null;
        }
        return entry.valueRef.get();
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public void probe(K k) {
        com.facebook.common.internal.Preconditions.checkNotNull(k);
        synchronized (this) {
            com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entryRemove = this.mLeastFrequentlyUsedExclusiveEntries.remove(k);
            if (entryRemove == null) {
                entryRemove = this.mMostFrequentlyUsedExclusiveEntries.remove(k);
            }
            if (entryRemove != null) {
                increaseAccessCount(entryRemove);
                maybeAddToExclusives(entryRemove);
            }
        }
    }

    private synchronized void maybeUpdateCacheFraction(K k) {
        if (this.mLeastFrequentlyUsedKeysGhostList.contains(k)) {
            int i = this.mLFUFractionPromil;
            int i2 = this.mAdaptiveRatePromil;
            if (i + i2 <= 900) {
                this.mLFUFractionPromil = i + i2;
            }
            this.mLeastFrequentlyUsedKeysGhostList.increaseValueIfExists(k);
        } else if (this.mLFUFractionPromil - this.mAdaptiveRatePromil >= 100 && this.mMostFrequentlyUsedKeysGhostList.contains(k)) {
            this.mLFUFractionPromil -= this.mAdaptiveRatePromil;
        }
    }

    private synchronized com.facebook.common.references.CloseableReference<V> newClientReference(final com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entry) {
        increaseCounters(entry);
        return com.facebook.common.references.CloseableReference.of(entry.valueRef.get(), new com.facebook.common.references.ResourceReleaser<V>() { // from class: com.facebook.imagepipeline.cache.AbstractAdaptiveCountingMemoryCache.2
            @Override // com.facebook.common.references.ResourceReleaser
            public void release(V v) {
                com.facebook.imagepipeline.cache.AbstractAdaptiveCountingMemoryCache.this.releaseClientReference(entry);
            }
        });
    }

    private synchronized void addElementToGhostList(K k, int i, com.facebook.imagepipeline.cache.AbstractAdaptiveCountingMemoryCache.ArrayListType arrayListType) {
        if (arrayListType == com.facebook.imagepipeline.cache.AbstractAdaptiveCountingMemoryCache.ArrayListType.LFU) {
            this.mLeastFrequentlyUsedKeysGhostList.addPair(k, java.lang.Integer.valueOf(i));
        } else {
            if (this.mMostFrequentlyUsedKeysGhostList.size() == this.mGhostListMaxSize) {
                this.mMostFrequentlyUsedKeysGhostList.remove(0);
            }
            this.mMostFrequentlyUsedKeysGhostList.add(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseClientReference(com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entry) {
        boolean zMaybeAddToExclusives;
        com.facebook.common.references.CloseableReference<V> closeableReferenceReferenceToClose;
        com.facebook.common.internal.Preconditions.checkNotNull(entry);
        synchronized (this) {
            decreaseClientCount(entry);
            zMaybeAddToExclusives = maybeAddToExclusives(entry);
            closeableReferenceReferenceToClose = referenceToClose(entry);
        }
        com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) closeableReferenceReferenceToClose);
        if (!zMaybeAddToExclusives) {
            entry = null;
        }
        maybeNotifyExclusiveEntryInsertion(entry);
        maybeUpdateCacheParams();
        maybeEvictEntries();
    }

    private synchronized boolean maybeAddToExclusives(com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entry) {
        if (entry.isOrphan || entry.clientCount != 0) {
            return false;
        }
        if (entry.accessCount > this.mFrequentlyUsedThreshold) {
            this.mMostFrequentlyUsedExclusiveEntries.put(entry.key, entry);
        } else {
            this.mLeastFrequentlyUsedExclusiveEntries.put(entry.key, entry);
        }
        return true;
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    @javax.annotation.Nullable
    public com.facebook.common.references.CloseableReference<V> reuse(K k) {
        com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entryRemove;
        boolean z;
        com.facebook.common.references.CloseableReference<V> closeableReference;
        com.facebook.common.internal.Preconditions.checkNotNull(k);
        synchronized (this) {
            entryRemove = this.mLeastFrequentlyUsedExclusiveEntries.remove(k);
            if (entryRemove == null) {
                entryRemove = this.mMostFrequentlyUsedExclusiveEntries.remove(k);
            }
            z = false;
            if (entryRemove != null) {
                com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entryRemove2 = this.mCachedEntries.remove(k);
                com.facebook.common.internal.Preconditions.checkNotNull(entryRemove2);
                com.facebook.common.internal.Preconditions.checkState(entryRemove2.clientCount == 0);
                closeableReference = entryRemove2.valueRef;
                z = true;
            } else {
                closeableReference = null;
            }
        }
        if (z) {
            maybeNotifyExclusiveEntryRemoval(entryRemove);
        }
        return closeableReference;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public int removeAll(com.facebook.common.internal.Predicate<K> predicate) {
        java.util.ArrayList<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> arrayListRemoveAll;
        java.util.ArrayList<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> arrayListRemoveAll2;
        java.util.ArrayList<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> arrayListRemoveAll3;
        synchronized (this) {
            arrayListRemoveAll = this.mLeastFrequentlyUsedExclusiveEntries.removeAll(predicate);
            arrayListRemoveAll2 = this.mMostFrequentlyUsedExclusiveEntries.removeAll(predicate);
            arrayListRemoveAll3 = this.mCachedEntries.removeAll(predicate);
            makeOrphans(arrayListRemoveAll3);
        }
        maybeClose(arrayListRemoveAll3);
        maybeNotifyExclusiveEntriesRemoval(arrayListRemoveAll, arrayListRemoveAll2);
        maybeUpdateCacheParams();
        maybeEvictEntries();
        return arrayListRemoveAll3.size();
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    public void clear() {
        java.util.ArrayList<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> arrayListClear;
        java.util.ArrayList<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> arrayListClear2;
        java.util.ArrayList<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> arrayListClear3;
        synchronized (this) {
            arrayListClear = this.mLeastFrequentlyUsedExclusiveEntries.clear();
            arrayListClear2 = this.mMostFrequentlyUsedExclusiveEntries.clear();
            arrayListClear3 = this.mCachedEntries.clear();
            makeOrphans(arrayListClear3);
        }
        maybeClose(arrayListClear3);
        maybeNotifyExclusiveEntriesRemoval(arrayListClear, arrayListClear2);
        maybeUpdateCacheParams();
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public synchronized boolean contains(com.facebook.common.internal.Predicate<K> predicate) {
        return !this.mCachedEntries.getMatchingEntries(predicate).isEmpty();
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public synchronized boolean contains(K k) {
        return this.mCachedEntries.contains(k);
    }

    @Override // com.facebook.common.memory.MemoryTrimmable
    public void trim(com.facebook.common.memory.MemoryTrimType memoryTrimType) {
        java.util.ArrayList<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> arrayListTrimExclusivelyOwnedEntries;
        java.util.ArrayList<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> arrayListTrimExclusivelyOwnedEntries2;
        double trimRatio = this.mCacheTrimStrategy.getTrimRatio(memoryTrimType);
        synchronized (this) {
            int sizeInBytes = ((int) (((double) this.mCachedEntries.getSizeInBytes()) * (1.0d - trimRatio))) - getInUseSizeInBytes();
            int i = 0;
            int iMax = java.lang.Math.max(0, sizeInBytes);
            int sizeInBytes2 = this.mMostFrequentlyUsedExclusiveEntries.getSizeInBytes();
            int iMax2 = java.lang.Math.max(0, iMax - sizeInBytes2);
            if (iMax > sizeInBytes2) {
                iMax = sizeInBytes2;
                i = iMax2;
            }
            arrayListTrimExclusivelyOwnedEntries = trimExclusivelyOwnedEntries(Integer.MAX_VALUE, i, this.mLeastFrequentlyUsedExclusiveEntries, com.facebook.imagepipeline.cache.AbstractAdaptiveCountingMemoryCache.ArrayListType.LFU);
            arrayListTrimExclusivelyOwnedEntries2 = trimExclusivelyOwnedEntries(Integer.MAX_VALUE, iMax, this.mMostFrequentlyUsedExclusiveEntries, com.facebook.imagepipeline.cache.AbstractAdaptiveCountingMemoryCache.ArrayListType.MFU);
            makeOrphans(arrayListTrimExclusivelyOwnedEntries, arrayListTrimExclusivelyOwnedEntries2);
        }
        maybeClose(arrayListTrimExclusivelyOwnedEntries, arrayListTrimExclusivelyOwnedEntries2);
        maybeNotifyExclusiveEntriesRemoval(arrayListTrimExclusivelyOwnedEntries, arrayListTrimExclusivelyOwnedEntries2);
        maybeUpdateCacheParams();
        maybeEvictEntries();
    }

    private synchronized void maybeUpdateCacheParams() {
        if (this.mLastCacheParamsCheck + this.mMemoryCacheParams.paramsCheckIntervalMs > android.os.SystemClock.uptimeMillis()) {
            return;
        }
        this.mLastCacheParamsCheck = android.os.SystemClock.uptimeMillis();
        this.mMemoryCacheParams = (com.facebook.imagepipeline.cache.MemoryCacheParams) com.facebook.common.internal.Preconditions.checkNotNull(this.mMemoryCacheParamsSupplier.get(), "mMemoryCacheParamsSupplier returned null");
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    public com.facebook.imagepipeline.cache.MemoryCacheParams getMemoryCacheParams() {
        return this.mMemoryCacheParams;
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    public void maybeEvictEntries() {
        java.util.ArrayList<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> arrayListTrimExclusivelyOwnedEntries;
        java.util.ArrayList<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> arrayListTrimExclusivelyOwnedEntries2;
        synchronized (this) {
            int iMin = java.lang.Math.min(this.mMemoryCacheParams.maxEvictionQueueEntries, this.mMemoryCacheParams.maxCacheEntries - getInUseCount());
            int iMin2 = java.lang.Math.min(this.mMemoryCacheParams.maxEvictionQueueSize, this.mMemoryCacheParams.maxCacheSize - getInUseSizeInBytes());
            int i = this.mLFUFractionPromil;
            int i2 = (int) ((((long) iMin) * ((long) i)) / 1000);
            int i3 = (int) ((((long) iMin2) * ((long) i)) / 1000);
            arrayListTrimExclusivelyOwnedEntries = trimExclusivelyOwnedEntries(i2, i3, this.mLeastFrequentlyUsedExclusiveEntries, com.facebook.imagepipeline.cache.AbstractAdaptiveCountingMemoryCache.ArrayListType.LFU);
            arrayListTrimExclusivelyOwnedEntries2 = trimExclusivelyOwnedEntries(iMin - i2, iMin2 - i3, this.mMostFrequentlyUsedExclusiveEntries, com.facebook.imagepipeline.cache.AbstractAdaptiveCountingMemoryCache.ArrayListType.MFU);
            makeOrphans(arrayListTrimExclusivelyOwnedEntries, arrayListTrimExclusivelyOwnedEntries2);
        }
        maybeClose(arrayListTrimExclusivelyOwnedEntries, arrayListTrimExclusivelyOwnedEntries2);
        maybeNotifyExclusiveEntriesRemoval(arrayListTrimExclusivelyOwnedEntries, arrayListTrimExclusivelyOwnedEntries2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @javax.annotation.Nullable
    private synchronized java.util.ArrayList<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> trimExclusivelyOwnedEntries(int i, int i2, com.facebook.imagepipeline.cache.CountingLruMap<K, com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> countingLruMap, com.facebook.imagepipeline.cache.AbstractAdaptiveCountingMemoryCache.ArrayListType arrayListType) {
        int iMax = java.lang.Math.max(i, 0);
        int iMax2 = java.lang.Math.max(i2, 0);
        if (countingLruMap.getCount() <= iMax && countingLruMap.getSizeInBytes() <= iMax2) {
            return null;
        }
        java.util.ArrayList<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> arrayList = new java.util.ArrayList<>();
        while (true) {
            if (countingLruMap.getCount() <= iMax && countingLruMap.getSizeInBytes() <= iMax2) {
                return arrayList;
            }
            java.lang.Object objCheckNotNull = com.facebook.common.internal.Preconditions.checkNotNull(countingLruMap.getFirstKey());
            addElementToGhostList(objCheckNotNull, ((com.facebook.imagepipeline.cache.CountingMemoryCache.Entry) com.facebook.common.internal.Preconditions.checkNotNull((com.facebook.imagepipeline.cache.CountingMemoryCache.Entry) countingLruMap.get(objCheckNotNull))).accessCount, arrayListType);
            countingLruMap.remove(objCheckNotNull);
            arrayList.add(this.mCachedEntries.remove((K) objCheckNotNull));
        }
    }

    private void maybeClose(@javax.annotation.Nullable java.util.ArrayList<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> arrayList, @javax.annotation.Nullable java.util.ArrayList<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> arrayList2) {
        maybeClose(arrayList);
        maybeClose(arrayList2);
    }

    private void maybeClose(@javax.annotation.Nullable java.util.ArrayList<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> arrayList) {
        if (arrayList != null) {
            java.util.Iterator<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) referenceToClose(it.next()));
            }
        }
    }

    private void maybeNotifyExclusiveEntriesRemoval(@javax.annotation.Nullable java.util.ArrayList<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> arrayList, @javax.annotation.Nullable java.util.ArrayList<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> arrayList2) {
        maybeNotifyExclusiveEntryRemoval(arrayList);
        maybeNotifyExclusiveEntryRemoval(arrayList2);
    }

    private void maybeNotifyExclusiveEntryRemoval(@javax.annotation.Nullable com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entry, @javax.annotation.Nullable com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entry2) {
        maybeNotifyExclusiveEntryRemoval(entry);
        maybeNotifyExclusiveEntryRemoval(entry2);
    }

    private void maybeNotifyExclusiveEntryRemoval(@javax.annotation.Nullable java.util.ArrayList<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> arrayList) {
        if (arrayList != null) {
            java.util.Iterator<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                maybeNotifyExclusiveEntryRemoval(it.next());
            }
        }
    }

    private static <K, V> void maybeNotifyExclusiveEntryRemoval(@javax.annotation.Nullable com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entry) {
        if (entry == null || entry.observer == null) {
            return;
        }
        entry.observer.onExclusivityChanged(entry.key, false);
    }

    private static <K, V> void maybeNotifyExclusiveEntryInsertion(@javax.annotation.Nullable com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entry) {
        if (entry == null || entry.observer == null) {
            return;
        }
        entry.observer.onExclusivityChanged(entry.key, true);
    }

    private synchronized void makeOrphans(@javax.annotation.Nullable java.util.ArrayList<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> arrayList, @javax.annotation.Nullable java.util.ArrayList<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> arrayList2) {
        makeOrphans(arrayList);
        makeOrphans(arrayList2);
    }

    private synchronized void makeOrphans(@javax.annotation.Nullable java.util.ArrayList<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> arrayList) {
        if (arrayList != null) {
            java.util.Iterator<com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                makeOrphan(it.next());
            }
        }
    }

    private synchronized void makeOrphan(com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entry) {
        com.facebook.common.internal.Preconditions.checkNotNull(entry);
        com.facebook.common.internal.Preconditions.checkState(!entry.isOrphan);
        entry.isOrphan = true;
    }

    private synchronized void increaseCounters(com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entry) {
        com.facebook.common.internal.Preconditions.checkNotNull(entry);
        com.facebook.common.internal.Preconditions.checkState(!entry.isOrphan);
        entry.clientCount++;
        increaseAccessCount(entry);
    }

    private synchronized void increaseAccessCount(com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entry) {
        com.facebook.common.internal.Preconditions.checkNotNull(entry);
        com.facebook.common.internal.Preconditions.checkState(!entry.isOrphan);
        entry.accessCount++;
    }

    private synchronized void decreaseClientCount(com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entry) {
        com.facebook.common.internal.Preconditions.checkNotNull(entry);
        com.facebook.common.internal.Preconditions.checkState(entry.clientCount > 0);
        entry.clientCount--;
    }

    @javax.annotation.Nullable
    private synchronized com.facebook.common.references.CloseableReference<V> referenceToClose(com.facebook.imagepipeline.cache.CountingMemoryCache.Entry<K, V> entry) {
        com.facebook.common.internal.Preconditions.checkNotNull(entry);
        return (entry.isOrphan && entry.clientCount == 0) ? entry.valueRef : null;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public synchronized int getCount() {
        return this.mCachedEntries.getCount();
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public synchronized int getSizeInBytes() {
        return this.mCachedEntries.getSizeInBytes();
    }

    public synchronized int getInUseCount() {
        return (this.mCachedEntries.getCount() - this.mLeastFrequentlyUsedExclusiveEntries.getCount()) - this.mMostFrequentlyUsedExclusiveEntries.getCount();
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    public synchronized int getInUseSizeInBytes() {
        return (this.mCachedEntries.getSizeInBytes() - this.mLeastFrequentlyUsedExclusiveEntries.getSizeInBytes()) - this.mMostFrequentlyUsedExclusiveEntries.getSizeInBytes();
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    public synchronized int getEvictionQueueCount() {
        return this.mLeastFrequentlyUsedExclusiveEntries.getCount() + this.mMostFrequentlyUsedExclusiveEntries.getCount();
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    public synchronized int getEvictionQueueSizeInBytes() {
        return this.mLeastFrequentlyUsedExclusiveEntries.getSizeInBytes() + this.mMostFrequentlyUsedExclusiveEntries.getSizeInBytes();
    }

    public java.lang.String reportData() {
        return com.facebook.common.internal.Objects.toStringHelper("CountingMemoryCache").add("cached_entries_count:", this.mCachedEntries.getCount()).add("exclusive_entries_count", getEvictionQueueCount()).toString();
    }

    class IntMapArrayList<E> {
        private final java.util.ArrayList<E> mFirstList;
        private final int mMaxCapacity;
        private final java.util.ArrayList<java.lang.Integer> mSecondList;

        public IntMapArrayList(int i) {
            this.mFirstList = new java.util.ArrayList<>(i);
            this.mSecondList = new java.util.ArrayList<>(i);
            this.mMaxCapacity = i;
        }

        public void addPair(E e, java.lang.Integer num) {
            if (this.mFirstList.size() == this.mMaxCapacity) {
                this.mFirstList.remove(0);
                this.mSecondList.remove(0);
            }
            this.mFirstList.add(e);
            this.mSecondList.add(num);
        }

        public void increaseValueIfExists(E e) {
            int iIndexOf = this.mFirstList.indexOf(e);
            if (iIndexOf < 0) {
                return;
            }
            java.lang.Integer numValueOf = java.lang.Integer.valueOf(this.mSecondList.get(iIndexOf).intValue() + 1);
            int i = this.mMaxCapacity;
            if (iIndexOf == i - 1) {
                this.mSecondList.set(i - 1, numValueOf);
                return;
            }
            this.mFirstList.remove(iIndexOf);
            this.mSecondList.remove(iIndexOf);
            this.mFirstList.add(e);
            this.mSecondList.add(numValueOf);
        }

        @javax.annotation.Nullable
        public java.lang.Integer getValue(E e) {
            int iIndexOf = this.mFirstList.indexOf(e);
            if (iIndexOf < 0) {
                return null;
            }
            return this.mSecondList.get(iIndexOf);
        }

        public boolean contains(E e) {
            return this.mFirstList.contains(e);
        }

        public int size() {
            return this.mFirstList.size();
        }
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    public com.facebook.imagepipeline.cache.CountingLruMap getCachedEntries() {
        return this.mCachedEntries;
    }

    @Override // com.facebook.imagepipeline.cache.CountingMemoryCache
    public java.util.Map<android.graphics.Bitmap, java.lang.Object> getOtherEntries() {
        return java.util.Collections.EMPTY_MAP;
    }
}
