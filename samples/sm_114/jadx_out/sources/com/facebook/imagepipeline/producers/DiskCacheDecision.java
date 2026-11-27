package com.facebook.imagepipeline.producers;

/* JADX INFO: compiled from: DiskCacheDecision.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J<\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00052\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bH\u0007¨\u0006\u000e"}, d2 = {"Lcom/facebook/imagepipeline/producers/DiskCacheDecision;", "", "<init>", "()V", "chooseDiskCacheForRequest", "Lcom/facebook/imagepipeline/cache/BufferedDiskCache;", "imageRequest", "Lcom/facebook/imagepipeline/request/ImageRequest;", "smallDiskCache", "defaultDiskCache", "dynamicDiskCaches", "", "", "DiskCacheDecisionNoDiskCacheChosenException", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DiskCacheDecision {
    public static final com.facebook.imagepipeline.producers.DiskCacheDecision INSTANCE = new com.facebook.imagepipeline.producers.DiskCacheDecision();

    private DiskCacheDecision() {
    }

    @kotlin.jvm.JvmStatic
    public static final com.facebook.imagepipeline.cache.BufferedDiskCache chooseDiskCacheForRequest(com.facebook.imagepipeline.request.ImageRequest imageRequest, com.facebook.imagepipeline.cache.BufferedDiskCache smallDiskCache, com.facebook.imagepipeline.cache.BufferedDiskCache defaultDiskCache, java.util.Map<java.lang.String, com.facebook.imagepipeline.cache.BufferedDiskCache> dynamicDiskCaches) {
        java.lang.String diskCacheId;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        if (imageRequest.getCacheChoice() == com.facebook.imagepipeline.request.ImageRequest.CacheChoice.SMALL) {
            return smallDiskCache;
        }
        if (imageRequest.getCacheChoice() == com.facebook.imagepipeline.request.ImageRequest.CacheChoice.DEFAULT) {
            return defaultDiskCache;
        }
        if (imageRequest.getCacheChoice() != com.facebook.imagepipeline.request.ImageRequest.CacheChoice.DYNAMIC || dynamicDiskCaches == null || (diskCacheId = imageRequest.getDiskCacheId()) == null) {
            return null;
        }
        return dynamicDiskCaches.get(diskCacheId);
    }

    /* JADX INFO: compiled from: DiskCacheDecision.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00060\u0002j\u0002`\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/imagepipeline/producers/DiskCacheDecision$DiskCacheDecisionNoDiskCacheChosenException;", "Lkotlin/Exception;", "Ljava/lang/Exception;", "message", "", "<init>", "(Ljava/lang/String;)V", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class DiskCacheDecisionNoDiskCacheChosenException extends java.lang.Exception {
        public DiskCacheDecisionNoDiskCacheChosenException(java.lang.String str) {
            super(str);
        }
    }
}
