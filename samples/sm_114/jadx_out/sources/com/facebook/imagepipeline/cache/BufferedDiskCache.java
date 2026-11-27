package com.facebook.imagepipeline.cache;

/* JADX INFO: compiled from: BufferedDiskCache.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 02\u00020\u0001:\u00010B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00162\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u000e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00162\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0086\u0002J\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00162\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u001e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00162\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0016\u0010#\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u001aJ\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00162\u0006\u0010\u0013\u001a\u00020\u0014J\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0016J\u001e\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00162\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010,\u001a\u00020\u001aH\u0002J\u0012\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u001a\u0010/\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010$\u001a\u0004\u0018\u00010\u001aH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010'\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u00061"}, d2 = {"Lcom/facebook/imagepipeline/cache/BufferedDiskCache;", "", "fileCache", "Lcom/facebook/cache/disk/FileCache;", "pooledByteBufferFactory", "Lcom/facebook/common/memory/PooledByteBufferFactory;", "pooledByteStreams", "Lcom/facebook/common/memory/PooledByteStreams;", "readExecutor", "Ljava/util/concurrent/Executor;", "writeExecutor", "imageCacheStatsTracker", "Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;", "<init>", "(Lcom/facebook/cache/disk/FileCache;Lcom/facebook/common/memory/PooledByteBufferFactory;Lcom/facebook/common/memory/PooledByteStreams;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;)V", "stagingArea", "Lcom/facebook/imagepipeline/cache/StagingArea;", "containsSync", "", io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_KEY, "Lcom/facebook/cache/common/CacheKey;", "contains", "Lbolts/Task;", "containsAsync", "diskCheckSync", "get", "Lcom/facebook/imagepipeline/image/EncodedImage;", "isCancelled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "probe", "Ljava/lang/Void;", "addKeyForAsyncProbing", "", "checkInStagingAreaAndFileCache", "getAsync", "put", "encodedImage", io.dcloud.common.constant.AbsoluteConst.XML_REMOVE, "clearAll", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE, "", "getSize", "()J", "foundPinnedImage", "pinnedImage", "readFromDiskCache", "Lcom/facebook/common/memory/PooledByteBuffer;", "writeToDiskCache", "Companion", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BufferedDiskCache {
    private static final java.lang.Class<?> TAG = com.facebook.imagepipeline.cache.BufferedDiskCache.class;
    private final com.facebook.cache.disk.FileCache fileCache;
    private final com.facebook.imagepipeline.cache.ImageCacheStatsTracker imageCacheStatsTracker;
    private final com.facebook.common.memory.PooledByteBufferFactory pooledByteBufferFactory;
    private final com.facebook.common.memory.PooledByteStreams pooledByteStreams;
    private final java.util.concurrent.Executor readExecutor;
    private final com.facebook.imagepipeline.cache.StagingArea stagingArea;
    private final java.util.concurrent.Executor writeExecutor;

    public BufferedDiskCache(com.facebook.cache.disk.FileCache fileCache, com.facebook.common.memory.PooledByteBufferFactory pooledByteBufferFactory, com.facebook.common.memory.PooledByteStreams pooledByteStreams, java.util.concurrent.Executor readExecutor, java.util.concurrent.Executor writeExecutor, com.facebook.imagepipeline.cache.ImageCacheStatsTracker imageCacheStatsTracker) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fileCache, "fileCache");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pooledByteBufferFactory, "pooledByteBufferFactory");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pooledByteStreams, "pooledByteStreams");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(readExecutor, "readExecutor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(writeExecutor, "writeExecutor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imageCacheStatsTracker, "imageCacheStatsTracker");
        this.fileCache = fileCache;
        this.pooledByteBufferFactory = pooledByteBufferFactory;
        this.pooledByteStreams = pooledByteStreams;
        this.readExecutor = readExecutor;
        this.writeExecutor = writeExecutor;
        this.imageCacheStatsTracker = imageCacheStatsTracker;
        com.facebook.imagepipeline.cache.StagingArea stagingArea = com.facebook.imagepipeline.cache.StagingArea.getInstance();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(stagingArea, "getInstance(...)");
        this.stagingArea = stagingArea;
    }

    public final boolean containsSync(com.facebook.cache.common.CacheKey key) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        return this.stagingArea.containsKey(key) || this.fileCache.hasKeySync(key);
    }

    public final bolts.Task<java.lang.Boolean> contains(com.facebook.cache.common.CacheKey key) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        if (containsSync(key)) {
            bolts.Task<java.lang.Boolean> taskForResult = bolts.Task.forResult(true);
            kotlin.jvm.internal.Intrinsics.checkNotNull(taskForResult);
            return taskForResult;
        }
        return containsAsync(key);
    }

    private final bolts.Task<java.lang.Boolean> containsAsync(final com.facebook.cache.common.CacheKey key) {
        try {
            final java.lang.Object objOnBeforeSubmitWork = com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_containsAsync");
            return bolts.Task.call(new java.util.concurrent.Callable() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final java.lang.Object call() {
                    return com.facebook.imagepipeline.cache.BufferedDiskCache.containsAsync$lambda$0(objOnBeforeSubmitWork, this, key);
                }
            }, this.readExecutor);
        } catch (java.lang.Exception e) {
            com.facebook.common.logging.FLog.w(TAG, e, "Failed to schedule disk-cache read for %s", key.getAnimationUriString());
            return bolts.Task.forError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Boolean containsAsync$lambda$0(java.lang.Object obj, com.facebook.imagepipeline.cache.BufferedDiskCache this$0, com.facebook.cache.common.CacheKey key) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "$key");
        java.lang.Object objOnBeginWork = com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.onBeginWork(obj, null);
        try {
            java.lang.Boolean boolValueOf = java.lang.Boolean.valueOf(this$0.checkInStagingAreaAndFileCache(key));
            com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.onEndWork(objOnBeginWork);
            return boolValueOf;
        } catch (java.lang.Throwable th) {
            try {
                com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.markFailure(obj, th);
                throw th;
            } catch (java.lang.Throwable th2) {
                com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.onEndWork(objOnBeginWork);
                throw th2;
            }
        }
    }

    public final boolean diskCheckSync(com.facebook.cache.common.CacheKey key) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        if (containsSync(key)) {
            return true;
        }
        return checkInStagingAreaAndFileCache(key);
    }

    public final bolts.Task<com.facebook.imagepipeline.image.EncodedImage> get(com.facebook.cache.common.CacheKey key, java.util.concurrent.atomic.AtomicBoolean isCancelled) {
        bolts.Task<com.facebook.imagepipeline.image.EncodedImage> async;
        bolts.Task<com.facebook.imagepipeline.image.EncodedImage> taskFoundPinnedImage;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(isCancelled, "isCancelled");
        com.facebook.imagepipeline.systrace.FrescoSystrace frescoSystrace = com.facebook.imagepipeline.systrace.FrescoSystrace.INSTANCE;
        if (!com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.image.EncodedImage encodedImage = this.stagingArea.get(key);
            return (encodedImage == null || (taskFoundPinnedImage = foundPinnedImage(key, encodedImage)) == null) ? getAsync(key, isCancelled) : taskFoundPinnedImage;
        }
        com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("BufferedDiskCache#get");
        try {
            com.facebook.imagepipeline.image.EncodedImage encodedImage2 = this.stagingArea.get(key);
            if (encodedImage2 == null || (async = foundPinnedImage(key, encodedImage2)) == null) {
                async = getAsync(key, isCancelled);
            }
            return async;
        } finally {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
    }

    public final bolts.Task<java.lang.Void> probe(final com.facebook.cache.common.CacheKey key) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        try {
            final java.lang.Object objOnBeforeSubmitWork = com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_probe");
            return bolts.Task.call(new java.util.concurrent.Callable() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache$$ExternalSyntheticLambda5
                @Override // java.util.concurrent.Callable
                public final java.lang.Object call() {
                    return com.facebook.imagepipeline.cache.BufferedDiskCache.probe$lambda$3(objOnBeforeSubmitWork, this, key);
                }
            }, this.writeExecutor);
        } catch (java.lang.Exception e) {
            com.facebook.common.logging.FLog.w(TAG, e, "Failed to schedule disk-cache probe for %s", key.getAnimationUriString());
            return bolts.Task.forError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Void probe$lambda$3(java.lang.Object obj, com.facebook.imagepipeline.cache.BufferedDiskCache this$0, com.facebook.cache.common.CacheKey key) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "$key");
        java.lang.Object objOnBeginWork = com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.onBeginWork(obj, null);
        try {
            this$0.fileCache.probe(key);
            return null;
        } finally {
            com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.onEndWork(objOnBeginWork);
        }
    }

    public final void addKeyForAsyncProbing(com.facebook.cache.common.CacheKey key) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        this.fileCache.probe(key);
    }

    private final boolean checkInStagingAreaAndFileCache(com.facebook.cache.common.CacheKey key) {
        com.facebook.imagepipeline.image.EncodedImage encodedImage = this.stagingArea.get(key);
        if (encodedImage != null) {
            encodedImage.close();
            com.facebook.common.logging.FLog.v(TAG, "Found image for %s in staging area", key.getAnimationUriString());
            this.imageCacheStatsTracker.onStagingAreaHit(key);
            return true;
        }
        com.facebook.common.logging.FLog.v(TAG, "Did not find image for %s in staging area", key.getAnimationUriString());
        this.imageCacheStatsTracker.onStagingAreaMiss(key);
        try {
            return this.fileCache.hasKey(key);
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    private final bolts.Task<com.facebook.imagepipeline.image.EncodedImage> getAsync(final com.facebook.cache.common.CacheKey key, final java.util.concurrent.atomic.AtomicBoolean isCancelled) {
        try {
            final java.lang.Object objOnBeforeSubmitWork = com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_getAsync");
            return bolts.Task.call(new java.util.concurrent.Callable() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache$$ExternalSyntheticLambda2
                @Override // java.util.concurrent.Callable
                public final java.lang.Object call() {
                    return com.facebook.imagepipeline.cache.BufferedDiskCache.getAsync$lambda$4(objOnBeforeSubmitWork, isCancelled, this, key);
                }
            }, this.readExecutor);
        } catch (java.lang.Exception e) {
            com.facebook.common.logging.FLog.w(TAG, e, "Failed to schedule disk-cache read for %s", key.getAnimationUriString());
            return bolts.Task.forError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.facebook.imagepipeline.image.EncodedImage getAsync$lambda$4(java.lang.Object obj, java.util.concurrent.atomic.AtomicBoolean isCancelled, com.facebook.imagepipeline.cache.BufferedDiskCache this$0, com.facebook.cache.common.CacheKey key) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(isCancelled, "$isCancelled");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "$key");
        java.lang.Object objOnBeginWork = com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.onBeginWork(obj, null);
        try {
            if (isCancelled.get()) {
                throw new java.util.concurrent.CancellationException();
            }
            com.facebook.imagepipeline.image.EncodedImage encodedImage = this$0.stagingArea.get(key);
            if (encodedImage != null) {
                com.facebook.common.logging.FLog.v(TAG, "Found image for %s in staging area", key.getAnimationUriString());
                this$0.imageCacheStatsTracker.onStagingAreaHit(key);
            } else {
                com.facebook.common.logging.FLog.v(TAG, "Did not find image for %s in staging area", key.getAnimationUriString());
                this$0.imageCacheStatsTracker.onStagingAreaMiss(key);
                try {
                    com.facebook.common.memory.PooledByteBuffer fromDiskCache = this$0.readFromDiskCache(key);
                    if (fromDiskCache == null) {
                        com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.onEndWork(objOnBeginWork);
                        return null;
                    }
                    com.facebook.common.references.CloseableReference closeableReferenceOf = com.facebook.common.references.CloseableReference.of(fromDiskCache);
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(closeableReferenceOf, "of(...)");
                    try {
                        com.facebook.imagepipeline.image.EncodedImage encodedImage2 = new com.facebook.imagepipeline.image.EncodedImage((com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer>) closeableReferenceOf);
                        com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) closeableReferenceOf);
                        encodedImage = encodedImage2;
                    } catch (java.lang.Throwable th) {
                        com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) closeableReferenceOf);
                        throw th;
                    }
                } catch (java.lang.Exception unused) {
                    com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.onEndWork(objOnBeginWork);
                    return null;
                }
            }
            if (!java.lang.Thread.interrupted()) {
                com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.onEndWork(objOnBeginWork);
                return encodedImage;
            }
            com.facebook.common.logging.FLog.v(TAG, "Host thread was interrupted, decreasing reference count");
            encodedImage.close();
            throw new java.lang.InterruptedException();
        } catch (java.lang.Throwable th2) {
            try {
                com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.markFailure(obj, th2);
                throw th2;
            } catch (java.lang.Throwable th3) {
                com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.onEndWork(objOnBeginWork);
                throw th3;
            }
        }
    }

    public final void put(final com.facebook.cache.common.CacheKey key, com.facebook.imagepipeline.image.EncodedImage encodedImage) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(encodedImage, "encodedImage");
        com.facebook.imagepipeline.systrace.FrescoSystrace frescoSystrace = com.facebook.imagepipeline.systrace.FrescoSystrace.INSTANCE;
        if (!com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            if (!com.facebook.imagepipeline.image.EncodedImage.isValid(encodedImage)) {
                throw new java.lang.IllegalStateException("Check failed.".toString());
            }
            this.stagingArea.put(key, encodedImage);
            final com.facebook.imagepipeline.image.EncodedImage encodedImageCloneOrNull = com.facebook.imagepipeline.image.EncodedImage.cloneOrNull(encodedImage);
            try {
                final java.lang.Object objOnBeforeSubmitWork = com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_putAsync");
                this.writeExecutor.execute(new java.lang.Runnable() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.facebook.imagepipeline.cache.BufferedDiskCache.put$lambda$6$lambda$5(objOnBeforeSubmitWork, this, key, encodedImageCloneOrNull);
                    }
                });
                return;
            } catch (java.lang.Exception e) {
                com.facebook.common.logging.FLog.w(TAG, e, "Failed to schedule disk-cache write for %s", key.getAnimationUriString());
                this.stagingArea.remove(key, encodedImage);
                com.facebook.imagepipeline.image.EncodedImage.closeSafely(encodedImageCloneOrNull);
                return;
            }
        }
        com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("BufferedDiskCache#put");
        try {
            if (!com.facebook.imagepipeline.image.EncodedImage.isValid(encodedImage)) {
                throw new java.lang.IllegalStateException("Check failed.".toString());
            }
            this.stagingArea.put(key, encodedImage);
            final com.facebook.imagepipeline.image.EncodedImage encodedImageCloneOrNull2 = com.facebook.imagepipeline.image.EncodedImage.cloneOrNull(encodedImage);
            try {
                final java.lang.Object objOnBeforeSubmitWork2 = com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_putAsync");
                this.writeExecutor.execute(new java.lang.Runnable() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.facebook.imagepipeline.cache.BufferedDiskCache.put$lambda$6$lambda$5(objOnBeforeSubmitWork2, this, key, encodedImageCloneOrNull2);
                    }
                });
            } catch (java.lang.Exception e2) {
                com.facebook.common.logging.FLog.w(TAG, e2, "Failed to schedule disk-cache write for %s", key.getAnimationUriString());
                this.stagingArea.remove(key, encodedImage);
                com.facebook.imagepipeline.image.EncodedImage.closeSafely(encodedImageCloneOrNull2);
            }
            kotlin.Unit unit = kotlin.Unit.INSTANCE;
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        } catch (java.lang.Throwable th) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void put$lambda$6$lambda$5(java.lang.Object obj, com.facebook.imagepipeline.cache.BufferedDiskCache this$0, com.facebook.cache.common.CacheKey key, com.facebook.imagepipeline.image.EncodedImage encodedImage) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "$key");
        java.lang.Object objOnBeginWork = com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.onBeginWork(obj, null);
        try {
            this$0.writeToDiskCache(key, encodedImage);
            com.facebook.imagepipeline.cache.StagingArea stagingArea = this$0.stagingArea;
            kotlin.jvm.internal.Intrinsics.checkNotNull(encodedImage);
            stagingArea.remove(key, encodedImage);
            com.facebook.imagepipeline.image.EncodedImage.closeSafely(encodedImage);
            com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.onEndWork(objOnBeginWork);
        } catch (java.lang.Throwable th) {
            try {
                com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.markFailure(obj, th);
                throw th;
            } catch (java.lang.Throwable th2) {
                com.facebook.imagepipeline.cache.StagingArea stagingArea2 = this$0.stagingArea;
                kotlin.jvm.internal.Intrinsics.checkNotNull(encodedImage);
                stagingArea2.remove(key, encodedImage);
                com.facebook.imagepipeline.image.EncodedImage.closeSafely(encodedImage);
                com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.onEndWork(objOnBeginWork);
                throw th2;
            }
        }
    }

    public final bolts.Task<java.lang.Void> remove(final com.facebook.cache.common.CacheKey key) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        this.stagingArea.remove(key);
        try {
            final java.lang.Object objOnBeforeSubmitWork = com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_remove");
            return bolts.Task.call(new java.util.concurrent.Callable() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache$$ExternalSyntheticLambda3
                @Override // java.util.concurrent.Callable
                public final java.lang.Object call() {
                    return com.facebook.imagepipeline.cache.BufferedDiskCache.remove$lambda$7(objOnBeforeSubmitWork, this, key);
                }
            }, this.writeExecutor);
        } catch (java.lang.Exception e) {
            com.facebook.common.logging.FLog.w(TAG, e, "Failed to schedule disk-cache remove for %s", key.getAnimationUriString());
            return bolts.Task.forError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Void remove$lambda$7(java.lang.Object obj, com.facebook.imagepipeline.cache.BufferedDiskCache this$0, com.facebook.cache.common.CacheKey key) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "$key");
        java.lang.Object objOnBeginWork = com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.onBeginWork(obj, null);
        try {
            this$0.stagingArea.remove(key);
            this$0.fileCache.remove(key);
            com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.onEndWork(objOnBeginWork);
            return null;
        } catch (java.lang.Throwable th) {
            try {
                com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.markFailure(obj, th);
                throw th;
            } catch (java.lang.Throwable th2) {
                com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.onEndWork(objOnBeginWork);
                throw th2;
            }
        }
    }

    public final bolts.Task<java.lang.Void> clearAll() {
        this.stagingArea.clearAll();
        final java.lang.Object objOnBeforeSubmitWork = com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_clearAll");
        try {
            return bolts.Task.call(new java.util.concurrent.Callable() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache$$ExternalSyntheticLambda4
                @Override // java.util.concurrent.Callable
                public final java.lang.Object call() {
                    return com.facebook.imagepipeline.cache.BufferedDiskCache.clearAll$lambda$8(objOnBeforeSubmitWork, this);
                }
            }, this.writeExecutor);
        } catch (java.lang.Exception e) {
            com.facebook.common.logging.FLog.w(TAG, e, "Failed to schedule disk-cache clear", new java.lang.Object[0]);
            return bolts.Task.forError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Void clearAll$lambda$8(java.lang.Object obj, com.facebook.imagepipeline.cache.BufferedDiskCache this$0) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        java.lang.Object objOnBeginWork = com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.onBeginWork(obj, null);
        try {
            this$0.stagingArea.clearAll();
            this$0.fileCache.clearAll();
            com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.onEndWork(objOnBeginWork);
            return null;
        } catch (java.lang.Throwable th) {
            try {
                com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.markFailure(obj, th);
                throw th;
            } catch (java.lang.Throwable th2) {
                com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.onEndWork(objOnBeginWork);
                throw th2;
            }
        }
    }

    public final long getSize() {
        return this.fileCache.getSize();
    }

    private final bolts.Task<com.facebook.imagepipeline.image.EncodedImage> foundPinnedImage(com.facebook.cache.common.CacheKey key, com.facebook.imagepipeline.image.EncodedImage pinnedImage) {
        com.facebook.common.logging.FLog.v(TAG, "Found image for %s in staging area", key.getAnimationUriString());
        this.imageCacheStatsTracker.onStagingAreaHit(key);
        bolts.Task<com.facebook.imagepipeline.image.EncodedImage> taskForResult = bolts.Task.forResult(pinnedImage);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(taskForResult, "forResult(...)");
        return taskForResult;
    }

    private final com.facebook.common.memory.PooledByteBuffer readFromDiskCache(com.facebook.cache.common.CacheKey key) throws java.io.IOException {
        try {
            java.lang.Class<?> cls = TAG;
            com.facebook.common.logging.FLog.v(cls, "Disk cache read for %s", key.getAnimationUriString());
            com.facebook.binaryresource.BinaryResource resource = this.fileCache.getResource(key);
            if (resource == null) {
                com.facebook.common.logging.FLog.v(cls, "Disk cache miss for %s", key.getAnimationUriString());
                this.imageCacheStatsTracker.onDiskCacheMiss(key);
                return null;
            }
            com.facebook.common.logging.FLog.v(cls, "Found entry in disk cache for %s", key.getAnimationUriString());
            this.imageCacheStatsTracker.onDiskCacheHit(key);
            java.io.InputStream inputStreamOpenStream = resource.openStream();
            try {
                com.facebook.common.memory.PooledByteBuffer pooledByteBufferNewByteBuffer = this.pooledByteBufferFactory.newByteBuffer(inputStreamOpenStream, (int) resource.size());
                inputStreamOpenStream.close();
                com.facebook.common.logging.FLog.v(cls, "Successful read from disk cache for %s", key.getAnimationUriString());
                return pooledByteBufferNewByteBuffer;
            } catch (java.lang.Throwable th) {
                inputStreamOpenStream.close();
                throw th;
            }
        } catch (java.io.IOException e) {
            com.facebook.common.logging.FLog.w(TAG, e, "Exception reading from cache for %s", key.getAnimationUriString());
            this.imageCacheStatsTracker.onDiskCacheGetFail(key);
            throw e;
        }
    }

    private final void writeToDiskCache(com.facebook.cache.common.CacheKey key, final com.facebook.imagepipeline.image.EncodedImage encodedImage) {
        java.lang.Class<?> cls = TAG;
        com.facebook.common.logging.FLog.v(cls, "About to write to disk-cache for key %s", key.getAnimationUriString());
        try {
            this.fileCache.insert(key, new com.facebook.cache.common.WriterCallback() { // from class: com.facebook.imagepipeline.cache.BufferedDiskCache$$ExternalSyntheticLambda6
                @Override // com.facebook.cache.common.WriterCallback
                public final void write(java.io.OutputStream outputStream) throws java.io.IOException {
                    com.facebook.imagepipeline.cache.BufferedDiskCache.writeToDiskCache$lambda$9(encodedImage, this, outputStream);
                }
            });
            this.imageCacheStatsTracker.onDiskCachePut(key);
            com.facebook.common.logging.FLog.v(cls, "Successful disk-cache write for key %s", key.getAnimationUriString());
        } catch (java.io.IOException e) {
            com.facebook.common.logging.FLog.w(TAG, e, "Failed to write to disk-cache for key %s", key.getAnimationUriString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void writeToDiskCache$lambda$9(com.facebook.imagepipeline.image.EncodedImage encodedImage, com.facebook.imagepipeline.cache.BufferedDiskCache this$0, java.io.OutputStream os) throws java.io.IOException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(os, "os");
        kotlin.jvm.internal.Intrinsics.checkNotNull(encodedImage);
        java.io.InputStream inputStream = encodedImage.getInputStream();
        if (inputStream == null) {
            throw new java.lang.IllegalStateException("Required value was null.".toString());
        }
        this$0.pooledByteStreams.copy(inputStream, os);
    }
}
