package com.facebook.imagepipeline.cache;

/* JADX INFO: loaded from: classes.dex */
public class StagingArea {
    private static final java.lang.Class<?> TAG = com.facebook.imagepipeline.cache.StagingArea.class;
    private java.util.Map<com.facebook.cache.common.CacheKey, com.facebook.imagepipeline.image.EncodedImage> mMap = new java.util.HashMap();

    private StagingArea() {
    }

    public static com.facebook.imagepipeline.cache.StagingArea getInstance() {
        return new com.facebook.imagepipeline.cache.StagingArea();
    }

    public synchronized void put(com.facebook.cache.common.CacheKey cacheKey, com.facebook.imagepipeline.image.EncodedImage encodedImage) {
        com.facebook.common.internal.Preconditions.checkNotNull(cacheKey);
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(com.facebook.imagepipeline.image.EncodedImage.isValid(encodedImage)));
        com.facebook.imagepipeline.image.EncodedImage.closeSafely(this.mMap.put(cacheKey, com.facebook.imagepipeline.image.EncodedImage.cloneOrNull(encodedImage)));
        logStats();
    }

    public void clearAll() {
        java.util.ArrayList arrayList;
        synchronized (this) {
            arrayList = new java.util.ArrayList(this.mMap.values());
            this.mMap.clear();
        }
        for (int i = 0; i < arrayList.size(); i++) {
            com.facebook.imagepipeline.image.EncodedImage encodedImage = (com.facebook.imagepipeline.image.EncodedImage) arrayList.get(i);
            if (encodedImage != null) {
                encodedImage.close();
            }
        }
    }

    public boolean remove(com.facebook.cache.common.CacheKey cacheKey) {
        com.facebook.imagepipeline.image.EncodedImage encodedImageRemove;
        com.facebook.common.internal.Preconditions.checkNotNull(cacheKey);
        synchronized (this) {
            encodedImageRemove = this.mMap.remove(cacheKey);
        }
        if (encodedImageRemove == null) {
            return false;
        }
        try {
            return encodedImageRemove.isValid();
        } finally {
            encodedImageRemove.close();
        }
    }

    public synchronized boolean remove(com.facebook.cache.common.CacheKey cacheKey, com.facebook.imagepipeline.image.EncodedImage encodedImage) {
        com.facebook.common.internal.Preconditions.checkNotNull(cacheKey);
        com.facebook.common.internal.Preconditions.checkNotNull(encodedImage);
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(com.facebook.imagepipeline.image.EncodedImage.isValid(encodedImage)));
        com.facebook.imagepipeline.image.EncodedImage encodedImage2 = this.mMap.get(cacheKey);
        if (encodedImage2 == null) {
            return false;
        }
        com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer> byteBufferRef = encodedImage2.getByteBufferRef();
        com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer> byteBufferRef2 = encodedImage.getByteBufferRef();
        if (byteBufferRef != null && byteBufferRef2 != null) {
            try {
                if (byteBufferRef.get() == byteBufferRef2.get()) {
                    this.mMap.remove(cacheKey);
                    com.facebook.common.references.CloseableReference.closeSafely(byteBufferRef2);
                    com.facebook.common.references.CloseableReference.closeSafely(byteBufferRef);
                    com.facebook.imagepipeline.image.EncodedImage.closeSafely(encodedImage2);
                    logStats();
                    return true;
                }
            } catch (java.lang.Throwable th) {
                com.facebook.common.references.CloseableReference.closeSafely(byteBufferRef2);
                com.facebook.common.references.CloseableReference.closeSafely(byteBufferRef);
                com.facebook.imagepipeline.image.EncodedImage.closeSafely(encodedImage2);
                throw th;
            }
        }
        com.facebook.common.references.CloseableReference.closeSafely(byteBufferRef2);
        com.facebook.common.references.CloseableReference.closeSafely(byteBufferRef);
        com.facebook.imagepipeline.image.EncodedImage.closeSafely(encodedImage2);
        return false;
    }

    @javax.annotation.Nullable
    public synchronized com.facebook.imagepipeline.image.EncodedImage get(com.facebook.cache.common.CacheKey cacheKey) {
        com.facebook.common.internal.Preconditions.checkNotNull(cacheKey);
        com.facebook.imagepipeline.image.EncodedImage encodedImageCloneOrNull = this.mMap.get(cacheKey);
        if (encodedImageCloneOrNull != null) {
            synchronized (encodedImageCloneOrNull) {
                if (!com.facebook.imagepipeline.image.EncodedImage.isValid(encodedImageCloneOrNull)) {
                    this.mMap.remove(cacheKey);
                    com.facebook.common.logging.FLog.w(TAG, "Found closed reference %d for key %s (%d)", java.lang.Integer.valueOf(java.lang.System.identityHashCode(encodedImageCloneOrNull)), cacheKey.getAnimationUriString(), java.lang.Integer.valueOf(java.lang.System.identityHashCode(cacheKey)));
                    return null;
                }
                encodedImageCloneOrNull = com.facebook.imagepipeline.image.EncodedImage.cloneOrNull(encodedImageCloneOrNull);
            }
        }
        return encodedImageCloneOrNull;
    }

    public synchronized boolean containsKey(com.facebook.cache.common.CacheKey cacheKey) {
        com.facebook.common.internal.Preconditions.checkNotNull(cacheKey);
        if (!this.mMap.containsKey(cacheKey)) {
            return false;
        }
        com.facebook.imagepipeline.image.EncodedImage encodedImage = this.mMap.get(cacheKey);
        synchronized (encodedImage) {
            if (com.facebook.imagepipeline.image.EncodedImage.isValid(encodedImage)) {
                return true;
            }
            this.mMap.remove(cacheKey);
            com.facebook.common.logging.FLog.w(TAG, "Found closed reference %d for key %s (%d)", java.lang.Integer.valueOf(java.lang.System.identityHashCode(encodedImage)), cacheKey.getAnimationUriString(), java.lang.Integer.valueOf(java.lang.System.identityHashCode(cacheKey)));
            return false;
        }
    }

    private synchronized void logStats() {
        com.facebook.common.logging.FLog.v(TAG, "Count = %d", java.lang.Integer.valueOf(this.mMap.size()));
    }
}
