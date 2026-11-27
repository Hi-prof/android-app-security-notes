package com.facebook.imagepipeline.animated.impl;

/* JADX INFO: loaded from: classes.dex */
public class AnimatedFrameCache {
    private final com.facebook.imagepipeline.cache.CountingMemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> mBackingCache;
    private final com.facebook.cache.common.CacheKey mImageCacheKey;
    private final java.util.LinkedHashSet<com.facebook.cache.common.CacheKey> mFreeItemsPool = new java.util.LinkedHashSet<>();
    private final com.facebook.imagepipeline.cache.CountingMemoryCache.EntryStateObserver<com.facebook.cache.common.CacheKey> mEntryStateObserver = new com.facebook.imagepipeline.cache.CountingMemoryCache.EntryStateObserver<com.facebook.cache.common.CacheKey>() { // from class: com.facebook.imagepipeline.animated.impl.AnimatedFrameCache.1
        @Override // com.facebook.imagepipeline.cache.CountingMemoryCache.EntryStateObserver
        public void onExclusivityChanged(com.facebook.cache.common.CacheKey cacheKey, boolean z) {
            com.facebook.imagepipeline.animated.impl.AnimatedFrameCache.this.onReusabilityChange(cacheKey, z);
        }
    };

    static class FrameKey implements com.facebook.cache.common.CacheKey {
        private final int mFrameIndex;
        private final com.facebook.cache.common.CacheKey mImageCacheKey;

        @Override // com.facebook.cache.common.CacheKey
        @javax.annotation.Nullable
        /* JADX INFO: renamed from: getUriString */
        public java.lang.String getAnimationUriString() {
            return null;
        }

        @Override // com.facebook.cache.common.CacheKey
        public boolean isResourceIdForDebugging() {
            return false;
        }

        public FrameKey(com.facebook.cache.common.CacheKey cacheKey, int i) {
            this.mImageCacheKey = cacheKey;
            this.mFrameIndex = i;
        }

        @Override // com.facebook.cache.common.CacheKey
        public java.lang.String toString() {
            return com.facebook.common.internal.Objects.toStringHelper(this).add("imageCacheKey", this.mImageCacheKey).add("frameIndex", this.mFrameIndex).toString();
        }

        @Override // com.facebook.cache.common.CacheKey
        public boolean equals(@javax.annotation.Nullable java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof com.facebook.imagepipeline.animated.impl.AnimatedFrameCache.FrameKey) {
                com.facebook.imagepipeline.animated.impl.AnimatedFrameCache.FrameKey frameKey = (com.facebook.imagepipeline.animated.impl.AnimatedFrameCache.FrameKey) obj;
                if (this.mFrameIndex == frameKey.mFrameIndex && this.mImageCacheKey.equals(frameKey.mImageCacheKey)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.facebook.cache.common.CacheKey
        public int hashCode() {
            return (this.mImageCacheKey.hashCode() * androidx.core.view.PointerIconCompat.TYPE_ALL_SCROLL) + this.mFrameIndex;
        }

        @Override // com.facebook.cache.common.CacheKey
        public boolean containsUri(android.net.Uri uri) {
            return this.mImageCacheKey.containsUri(uri);
        }
    }

    public AnimatedFrameCache(com.facebook.cache.common.CacheKey cacheKey, com.facebook.imagepipeline.cache.CountingMemoryCache<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.CloseableImage> countingMemoryCache) {
        this.mImageCacheKey = cacheKey;
        this.mBackingCache = countingMemoryCache;
    }

    public synchronized void onReusabilityChange(com.facebook.cache.common.CacheKey cacheKey, boolean z) {
        try {
            if (z) {
                this.mFreeItemsPool.add(cacheKey);
            } else {
                this.mFreeItemsPool.remove(cacheKey);
            }
        } catch (java.lang.Throwable th) {
            throw th;
        }
    }

    @javax.annotation.Nullable
    public com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> cache(int i, com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReference) {
        return this.mBackingCache.cache(keyFor(i), closeableReference, this.mEntryStateObserver);
    }

    @javax.annotation.Nullable
    public com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> get(int i) {
        return this.mBackingCache.get(keyFor(i));
    }

    public boolean contains(int i) {
        return this.mBackingCache.contains(keyFor(i));
    }

    @javax.annotation.Nullable
    public com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> getForReuse() {
        com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReferenceReuse;
        do {
            com.facebook.cache.common.CacheKey cacheKeyPopFirstFreeItemKey = popFirstFreeItemKey();
            if (cacheKeyPopFirstFreeItemKey == null) {
                return null;
            }
            closeableReferenceReuse = this.mBackingCache.reuse(cacheKeyPopFirstFreeItemKey);
        } while (closeableReferenceReuse == null);
        return closeableReferenceReuse;
    }

    @javax.annotation.Nullable
    private synchronized com.facebook.cache.common.CacheKey popFirstFreeItemKey() {
        com.facebook.cache.common.CacheKey next;
        java.util.Iterator<com.facebook.cache.common.CacheKey> it = this.mFreeItemsPool.iterator();
        if (it.hasNext()) {
            next = it.next();
            it.remove();
        } else {
            next = null;
        }
        return next;
    }

    private com.facebook.imagepipeline.animated.impl.AnimatedFrameCache.FrameKey keyFor(int i) {
        return new com.facebook.imagepipeline.animated.impl.AnimatedFrameCache.FrameKey(this.mImageCacheKey, i);
    }
}
