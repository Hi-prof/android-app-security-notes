package com.facebook.fresco.animation.bitmap.preparation.ondemandanimation;

/* JADX INFO: compiled from: AnimationLoaderFactory.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/FrameLoaderFactory;", "", "platformBitmapFactory", "Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "maxFpsRender", "", "bufferLengthMilliseconds", "<init>", "(Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;II)V", "createBufferLoader", "Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/FrameLoader;", "cacheKey", "", "bitmapFrameRenderer", "Lcom/facebook/fresco/animation/bitmap/BitmapFrameRenderer;", "animationInformation", "Lcom/facebook/fresco/animation/backend/AnimationInformation;", "Companion", "animated-drawable_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FrameLoaderFactory {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameLoaderFactory.Companion INSTANCE = new com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameLoaderFactory.Companion(null);
    private static final java.util.concurrent.ConcurrentHashMap<java.lang.String, com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.UnusedFrameLoader> UNUSED_FRAME_LOADERS = new java.util.concurrent.ConcurrentHashMap<>();
    private final int bufferLengthMilliseconds;
    private final int maxFpsRender;
    private final com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory platformBitmapFactory;

    public FrameLoaderFactory(com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory platformBitmapFactory, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(platformBitmapFactory, "platformBitmapFactory");
        this.platformBitmapFactory = platformBitmapFactory;
        this.maxFpsRender = i;
        this.bufferLengthMilliseconds = i2;
    }

    public final com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameLoader createBufferLoader(java.lang.String cacheKey, com.facebook.fresco.animation.bitmap.BitmapFrameRenderer bitmapFrameRenderer, com.facebook.fresco.animation.backend.AnimationInformation animationInformation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bitmapFrameRenderer, "bitmapFrameRenderer");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(animationInformation, "animationInformation");
        java.util.concurrent.ConcurrentHashMap<java.lang.String, com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.UnusedFrameLoader> concurrentHashMap = UNUSED_FRAME_LOADERS;
        synchronized (concurrentHashMap) {
            com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.UnusedFrameLoader unusedFrameLoader = concurrentHashMap.get(cacheKey);
            if (unusedFrameLoader != null) {
                concurrentHashMap.remove(cacheKey);
                return unusedFrameLoader.getFrameLoader();
            }
            kotlin.Unit unit = kotlin.Unit.INSTANCE;
            return new com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.BufferFrameLoader(this.platformBitmapFactory, bitmapFrameRenderer, new com.facebook.fresco.animation.bitmap.preparation.loadframe.FpsCompressorInfo(this.maxFpsRender), animationInformation, this.bufferLengthMilliseconds);
        }
    }

    /* JADX INFO: compiled from: AnimationLoaderFactory.kt */
    @kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/FrameLoaderFactory$Companion;", "", "<init>", "()V", "UNUSED_FRAME_LOADERS", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/UnusedFrameLoader;", "saveUnusedFrame", "", "cacheKey", "frameLoader", "Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/FrameLoader;", "clearUnusedUntil", "until", "Ljava/util/Date;", "animated-drawable_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void saveUnusedFrame(java.lang.String cacheKey, com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameLoader frameLoader) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(frameLoader, "frameLoader");
            com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameLoaderFactory.UNUSED_FRAME_LOADERS.put(cacheKey, new com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.UnusedFrameLoader(frameLoader, new java.util.Date()));
        }

        public final void clearUnusedUntil(java.util.Date until) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(until, "until");
            synchronized (com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameLoaderFactory.UNUSED_FRAME_LOADERS) {
                java.util.concurrent.ConcurrentHashMap concurrentHashMap = com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameLoaderFactory.UNUSED_FRAME_LOADERS;
                java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
                for (java.util.Map.Entry entry : concurrentHashMap.entrySet()) {
                    if (((com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.UnusedFrameLoader) entry.getValue()).getInsertedTime().compareTo(until) < 0) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                for (java.util.Map.Entry entry2 : linkedHashMap.entrySet()) {
                    ((com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.UnusedFrameLoader) entry2.getValue()).getFrameLoader().clear();
                    com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameLoaderFactory.UNUSED_FRAME_LOADERS.remove(entry2.getKey());
                }
                kotlin.Unit unit = kotlin.Unit.INSTANCE;
            }
        }
    }
}
