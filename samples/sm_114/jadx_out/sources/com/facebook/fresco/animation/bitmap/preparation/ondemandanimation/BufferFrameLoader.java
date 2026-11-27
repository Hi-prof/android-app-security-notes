package com.facebook.fresco.animation.bitmap.preparation.ondemandanimation;

/* JADX INFO: compiled from: BufferFrameLoader.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 82\u00020\u0001:\u000278B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ \u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000bH\u0017J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u000bH\u0003J&\u0010%\u001a\u00020&2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000b2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0(H\u0017J\u0010\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020\u000bH\u0016J\b\u0010+\u001a\u00020&H\u0016J\u0018\u0010,\u001a\u00020&2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000bH\u0002J*\u0010-\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u00020\u000bH\u0003J.\u0010/\u001a\u00020&2\f\u00100\u001a\b\u0012\u0004\u0012\u000202012\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000bH\u0002J\u0012\u00103\u001a\u0004\u0018\u0001042\u0006\u0010$\u001a\u00020\u000bH\u0002J\u0012\u0010+\u001a\u00020&*\b\u0012\u0004\u0012\u00020201H\u0002J \u00105\u001a\b\u0012\u0004\u0012\u00020201*\b\u0012\u0004\u0012\u000202012\u0006\u00106\u001a\u000202H\u0002J\f\u0010*\u001a\u00020\u000b*\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/BufferFrameLoader;", "Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/FrameLoader;", "platformBitmapFactory", "Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "bitmapFrameRenderer", "Lcom/facebook/fresco/animation/bitmap/BitmapFrameRenderer;", "fpsCompressor", "Lcom/facebook/fresco/animation/bitmap/preparation/loadframe/FpsCompressorInfo;", "animationInformation", "Lcom/facebook/fresco/animation/backend/AnimationInformation;", "bufferLengthMilliseconds", "", "<init>", "(Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;Lcom/facebook/fresco/animation/bitmap/BitmapFrameRenderer;Lcom/facebook/fresco/animation/bitmap/preparation/loadframe/FpsCompressorInfo;Lcom/facebook/fresco/animation/backend/AnimationInformation;I)V", "getAnimationInformation", "()Lcom/facebook/fresco/animation/backend/AnimationInformation;", "bufferSize", "bufferFramesHash", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/BufferFrameLoader$BufferFrame;", "thresholdFrame", "isFetching", "", "frameSequence", "Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/CircularList;", "lastRenderedFrameNumber", "compressionFrameMap", "", "renderableFrameIndexes", "", "getFrame", "Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/FrameResult;", "frameNumber", "width", "height", "findNearestToRender", "targetFrame", "prepareFrames", "", "onAnimationLoaded", "Lkotlin/Function0;", "compressToFps", "fps", "clear", "loadNextFrames", "extractDemandedFrame", "count", "obtainFrame", "targetBitmap", "Lcom/facebook/common/references/CloseableReference;", "Landroid/graphics/Bitmap;", "findNearestFrame", "Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/AnimationBitmapFrame;", "set", "src", "BufferFrame", "Companion", "animated-drawable_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BufferFrameLoader implements com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameLoader {
    private static final float THRESHOLD_PERCENTAGE = 0.5f;
    private final com.facebook.fresco.animation.backend.AnimationInformation animationInformation;
    private final com.facebook.fresco.animation.bitmap.BitmapFrameRenderer bitmapFrameRenderer;
    private final java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.BufferFrameLoader.BufferFrame> bufferFramesHash;
    private final int bufferLengthMilliseconds;
    private final int bufferSize;
    private java.util.Map<java.lang.Integer, java.lang.Integer> compressionFrameMap;
    private final com.facebook.fresco.animation.bitmap.preparation.loadframe.FpsCompressorInfo fpsCompressor;
    private final com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.CircularList frameSequence;
    private volatile boolean isFetching;
    private int lastRenderedFrameNumber;
    private final com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory platformBitmapFactory;
    private java.util.Set<java.lang.Integer> renderableFrameIndexes;
    private volatile int thresholdFrame;

    public BufferFrameLoader(com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory platformBitmapFactory, com.facebook.fresco.animation.bitmap.BitmapFrameRenderer bitmapFrameRenderer, com.facebook.fresco.animation.bitmap.preparation.loadframe.FpsCompressorInfo fpsCompressor, com.facebook.fresco.animation.backend.AnimationInformation animationInformation, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(platformBitmapFactory, "platformBitmapFactory");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bitmapFrameRenderer, "bitmapFrameRenderer");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fpsCompressor, "fpsCompressor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(animationInformation, "animationInformation");
        this.platformBitmapFactory = platformBitmapFactory;
        this.bitmapFrameRenderer = bitmapFrameRenderer;
        this.fpsCompressor = fpsCompressor;
        this.animationInformation = animationInformation;
        this.bufferLengthMilliseconds = i;
        int iCoerceAtLeast = kotlin.ranges.RangesKt.coerceAtLeast((fps(getAnimationInformation()) * i) / 1000, 1);
        this.bufferSize = iCoerceAtLeast;
        this.bufferFramesHash = new java.util.concurrent.ConcurrentHashMap<>();
        this.frameSequence = new com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.CircularList(getAnimationInformation().getFrameCount());
        this.lastRenderedFrameNumber = -1;
        this.compressionFrameMap = kotlin.collections.MapsKt.emptyMap();
        this.renderableFrameIndexes = kotlin.collections.SetsKt.emptySet();
        compressToFps(fps(getAnimationInformation()));
        this.thresholdFrame = (int) (iCoerceAtLeast * 0.5f);
    }

    @Override // com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameLoader
    public void onStop() {
        com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameLoader.DefaultImpls.onStop(this);
    }

    @Override // com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameLoader
    public com.facebook.fresco.animation.backend.AnimationInformation getAnimationInformation() {
        return this.animationInformation;
    }

    @Override // com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameLoader
    public com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameResult getFrame(int frameNumber, int width, int height) {
        java.lang.Integer num = this.compressionFrameMap.get(java.lang.Integer.valueOf(frameNumber));
        if (num == null) {
            return findNearestToRender(frameNumber);
        }
        int iIntValue = num.intValue();
        this.lastRenderedFrameNumber = iIntValue;
        com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.BufferFrameLoader.BufferFrame bufferFrame = this.bufferFramesHash.get(num);
        if (bufferFrame == null || !bufferFrame.isFrameAvailable()) {
            bufferFrame = null;
        }
        if (bufferFrame != null) {
            if (this.frameSequence.isTargetAhead(this.thresholdFrame, iIntValue, this.bufferSize)) {
                loadNextFrames(width, height);
            }
            return new com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameResult(bufferFrame.getBitmapRef().mo248clone(), com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameResult.FrameType.SUCCESS);
        }
        loadNextFrames(width, height);
        return findNearestToRender(iIntValue);
    }

    private final com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameResult findNearestToRender(int targetFrame) {
        com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.AnimationBitmapFrame animationBitmapFrameFindNearestFrame = findNearestFrame(targetFrame);
        if (animationBitmapFrameFindNearestFrame != null) {
            com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReferenceMo248clone = animationBitmapFrameFindNearestFrame.getBitmap().mo248clone();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(closeableReferenceMo248clone, "clone(...)");
            this.lastRenderedFrameNumber = animationBitmapFrameFindNearestFrame.getFrameNumber();
            return new com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameResult(closeableReferenceMo248clone, com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameResult.FrameType.NEAREST);
        }
        return new com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameResult(null, com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameResult.FrameType.MISSING);
    }

    @Override // com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameLoader
    public void prepareFrames(int width, int height, kotlin.jvm.functions.Function0<kotlin.Unit> onAnimationLoaded) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(onAnimationLoaded, "onAnimationLoaded");
        loadNextFrames(width, height);
        onAnimationLoaded.invoke();
    }

    @Override // com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameLoader
    public void compressToFps(int fps) {
        java.util.Map<java.lang.Integer, java.lang.Integer> mapCalculateReducedIndexes = this.fpsCompressor.calculateReducedIndexes(getAnimationInformation().getLoopDurationMs() * kotlin.ranges.RangesKt.coerceAtLeast(getAnimationInformation().getLoopCount(), 1), getAnimationInformation().getFrameCount(), kotlin.ranges.RangesKt.coerceAtMost(fps, fps(getAnimationInformation())));
        this.compressionFrameMap = mapCalculateReducedIndexes;
        this.renderableFrameIndexes = kotlin.collections.CollectionsKt.toSet(mapCalculateReducedIndexes.values());
    }

    @Override // com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.FrameLoader
    public void clear() {
        java.util.Collection<com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.BufferFrameLoader.BufferFrame> collectionValues = this.bufferFramesHash.values();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
        java.util.Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            ((com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.BufferFrameLoader.BufferFrame) it.next()).release();
        }
        this.bufferFramesHash.clear();
        this.lastRenderedFrameNumber = -1;
    }

    private final void loadNextFrames(final int width, final int height) {
        if (this.isFetching) {
            return;
        }
        this.isFetching = true;
        com.facebook.fresco.animation.bitmap.preparation.loadframe.AnimationLoaderExecutor.INSTANCE.execute(new java.lang.Runnable() { // from class: com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.BufferFrameLoader$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.BufferFrameLoader.loadNextFrames$lambda$2(this.f$0, width, height);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadNextFrames$lambda$2(com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.BufferFrameLoader this$0, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        while (true) {
            com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.BufferFrameLoader bufferFrameLoader = this$0;
            int i3 = i;
            int i4 = i2;
            if (extractDemandedFrame$default(bufferFrameLoader, kotlin.ranges.RangesKt.coerceAtLeast(this$0.lastRenderedFrameNumber, 0), i3, i4, 0, 8, null)) {
                bufferFrameLoader.isFetching = false;
                return;
            } else {
                this$0 = bufferFrameLoader;
                i = i3;
                i2 = i4;
            }
        }
    }

    static /* synthetic */ boolean extractDemandedFrame$default(com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.BufferFrameLoader bufferFrameLoader, int i, int i2, int i3, int i4, int i5, java.lang.Object obj) {
        if ((i5 & 8) != 0) {
            i4 = 0;
        }
        return bufferFrameLoader.extractDemandedFrame(i, i2, i3, i4);
    }

    private final boolean extractDemandedFrame(int targetFrame, int width, int height, int count) throws java.io.IOException {
        int iIntValue;
        com.facebook.common.references.CloseableReference<android.graphics.Bitmap> bitmapRef;
        java.util.List<java.lang.Integer> listSublist = this.frameSequence.sublist(targetFrame, this.bufferSize);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Object obj : listSublist) {
            if (this.renderableFrameIndexes.contains(java.lang.Integer.valueOf(((java.lang.Number) obj).intValue()))) {
                arrayList.add(obj);
            }
        }
        java.util.ArrayList arrayList2 = arrayList;
        java.util.ArrayList arrayList3 = arrayList2;
        java.util.Set set = kotlin.collections.CollectionsKt.toSet(arrayList3);
        java.util.Set<java.lang.Integer> setKeySet = this.bufferFramesHash.keySet();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
        java.util.ArrayDeque arrayDeque = new java.util.ArrayDeque(kotlin.collections.SetsKt.minus((java.util.Set) setKeySet, (java.lang.Iterable) set));
        java.util.Iterator it = arrayList3.iterator();
        while (it.hasNext()) {
            int iIntValue2 = ((java.lang.Number) it.next()).intValue();
            if (this.bufferFramesHash.get(java.lang.Integer.valueOf(iIntValue2)) == null) {
                int i = this.lastRenderedFrameNumber;
                if (i != -1 && !set.contains(java.lang.Integer.valueOf(i))) {
                    return false;
                }
                java.lang.Integer num = (java.lang.Integer) arrayDeque.pollFirst();
                int iIntValue3 = num != null ? num.intValue() : -1;
                com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.BufferFrameLoader.BufferFrame bufferFrame = this.bufferFramesHash.get(java.lang.Integer.valueOf(iIntValue3));
                com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReferenceCloneOrNull = (bufferFrame == null || (bitmapRef = bufferFrame.getBitmapRef()) == null) ? null : bitmapRef.cloneOrNull();
                if (closeableReferenceCloneOrNull == null) {
                    com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReferenceCreateBitmap = this.platformBitmapFactory.createBitmap(width, height);
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(closeableReferenceCreateBitmap, "createBitmap(...)");
                    bufferFrame = new com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.BufferFrameLoader.BufferFrame(closeableReferenceCreateBitmap);
                    closeableReferenceCloneOrNull = bufferFrame.getBitmapRef().mo248clone();
                }
                bufferFrame.setUpdatingFrame(true);
                com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReference = closeableReferenceCloneOrNull;
                try {
                    obtainFrame(closeableReference, iIntValue2, width, height);
                    kotlin.Unit unit = kotlin.Unit.INSTANCE;
                    kotlin.io.CloseableKt.closeFinally(closeableReference, null);
                    this.bufferFramesHash.remove(java.lang.Integer.valueOf(iIntValue3));
                    bufferFrame.setUpdatingFrame(false);
                    this.bufferFramesHash.put(java.lang.Integer.valueOf(iIntValue2), bufferFrame);
                } catch (java.lang.Throwable th) {
                    try {
                        throw th;
                    } catch (java.lang.Throwable th2) {
                        kotlin.io.CloseableKt.closeFinally(closeableReference, th);
                        throw th2;
                    }
                }
            }
        }
        if (arrayList2.isEmpty()) {
            iIntValue = (int) (this.bufferSize * 0.5f);
        } else {
            int size = arrayList2.size();
            iIntValue = ((java.lang.Number) arrayList2.get(kotlin.ranges.RangesKt.coerceIn((int) (size * 0.5f), 0, size - 1))).intValue();
        }
        this.thresholdFrame = iIntValue;
        return true;
    }

    private final void obtainFrame(com.facebook.common.references.CloseableReference<android.graphics.Bitmap> targetBitmap, int targetFrame, int width, int height) throws java.io.IOException {
        com.facebook.common.references.CloseableReference<android.graphics.Bitmap> bitmap;
        com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReferenceCloneOrNull;
        com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.AnimationBitmapFrame animationBitmapFrameFindNearestFrame = findNearestFrame(targetFrame);
        if (animationBitmapFrameFindNearestFrame != null && (bitmap = animationBitmapFrameFindNearestFrame.getBitmap()) != null && (closeableReferenceCloneOrNull = bitmap.cloneOrNull()) != null) {
            com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReference = closeableReferenceCloneOrNull;
            try {
                com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReference2 = closeableReference;
                int frameNumber = animationBitmapFrameFindNearestFrame.getFrameNumber();
                if (frameNumber < targetFrame) {
                    android.graphics.Bitmap bitmap2 = closeableReference2.get();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bitmap2, "get(...)");
                    set(targetBitmap, bitmap2);
                    java.util.Iterator<java.lang.Integer> it = new kotlin.ranges.IntRange(frameNumber + 1, targetFrame).iterator();
                    while (it.hasNext()) {
                        int iNextInt = ((kotlin.collections.IntIterator) it).nextInt();
                        com.facebook.fresco.animation.bitmap.BitmapFrameRenderer bitmapFrameRenderer = this.bitmapFrameRenderer;
                        android.graphics.Bitmap bitmap3 = targetBitmap.get();
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bitmap3, "get(...)");
                        bitmapFrameRenderer.renderFrame(iNextInt, bitmap3);
                    }
                    kotlin.io.CloseableKt.closeFinally(closeableReference, null);
                    return;
                }
                kotlin.Unit unit = kotlin.Unit.INSTANCE;
                kotlin.io.CloseableKt.closeFinally(closeableReference, null);
            } catch (java.lang.Throwable th) {
                try {
                    throw th;
                } catch (java.lang.Throwable th2) {
                    kotlin.io.CloseableKt.closeFinally(closeableReference, th);
                    throw th2;
                }
            }
        }
        clear(targetBitmap);
        java.util.Iterator<java.lang.Integer> it2 = new kotlin.ranges.IntRange(0, targetFrame).iterator();
        while (it2.hasNext()) {
            int iNextInt2 = ((kotlin.collections.IntIterator) it2).nextInt();
            com.facebook.fresco.animation.bitmap.BitmapFrameRenderer bitmapFrameRenderer2 = this.bitmapFrameRenderer;
            android.graphics.Bitmap bitmap4 = targetBitmap.get();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bitmap4, "get(...)");
            bitmapFrameRenderer2.renderFrame(iNextInt2, bitmap4);
        }
    }

    private final com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.AnimationBitmapFrame findNearestFrame(int targetFrame) {
        com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.AnimationBitmapFrame animationBitmapFrame;
        java.util.Iterator<java.lang.Integer> it = new kotlin.ranges.IntRange(0, this.frameSequence.getSize()).iterator();
        do {
            animationBitmapFrame = null;
            if (!it.hasNext()) {
                break;
            }
            int position = this.frameSequence.getPosition(targetFrame - ((kotlin.collections.IntIterator) it).nextInt());
            com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.BufferFrameLoader.BufferFrame bufferFrame = this.bufferFramesHash.get(java.lang.Integer.valueOf(position));
            if (bufferFrame != null) {
                if (!bufferFrame.isFrameAvailable()) {
                    bufferFrame = null;
                }
                if (bufferFrame != null) {
                    animationBitmapFrame = new com.facebook.fresco.animation.bitmap.preparation.ondemandanimation.AnimationBitmapFrame(position, bufferFrame.getBitmapRef());
                }
            }
        } while (animationBitmapFrame == null);
        return animationBitmapFrame;
    }

    private final void clear(com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReference) {
        if (closeableReference.isValid()) {
            new android.graphics.Canvas(closeableReference.get()).drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
        }
    }

    private final com.facebook.common.references.CloseableReference<android.graphics.Bitmap> set(com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReference, android.graphics.Bitmap bitmap) {
        if (closeableReference.isValid() && !kotlin.jvm.internal.Intrinsics.areEqual(closeableReference.get(), bitmap)) {
            android.graphics.Canvas canvas = new android.graphics.Canvas(closeableReference.get());
            canvas.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (android.graphics.Paint) null);
        }
        return closeableReference;
    }

    private final int fps(com.facebook.fresco.animation.backend.AnimationInformation animationInformation) {
        return (int) kotlin.ranges.RangesKt.coerceAtLeast(java.util.concurrent.TimeUnit.SECONDS.toMillis(1L) / ((long) (animationInformation.getLoopDurationMs() / animationInformation.getFrameCount())), 1L);
    }

    /* JADX INFO: compiled from: BufferFrameLoader.kt */
    @kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u000f\u001a\u00020\u0010R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/facebook/fresco/animation/bitmap/preparation/ondemandanimation/BufferFrameLoader$BufferFrame;", "", "bitmapRef", "Lcom/facebook/common/references/CloseableReference;", "Landroid/graphics/Bitmap;", "<init>", "(Lcom/facebook/common/references/CloseableReference;)V", "getBitmapRef", "()Lcom/facebook/common/references/CloseableReference;", "isUpdatingFrame", "", "()Z", "setUpdatingFrame", "(Z)V", "isFrameAvailable", "release", "", "animated-drawable_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class BufferFrame {
        private final com.facebook.common.references.CloseableReference<android.graphics.Bitmap> bitmapRef;
        private boolean isUpdatingFrame;

        public BufferFrame(com.facebook.common.references.CloseableReference<android.graphics.Bitmap> bitmapRef) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bitmapRef, "bitmapRef");
            this.bitmapRef = bitmapRef;
        }

        public final com.facebook.common.references.CloseableReference<android.graphics.Bitmap> getBitmapRef() {
            return this.bitmapRef;
        }

        /* JADX INFO: renamed from: isUpdatingFrame, reason: from getter */
        public final boolean getIsUpdatingFrame() {
            return this.isUpdatingFrame;
        }

        public final void setUpdatingFrame(boolean z) {
            this.isUpdatingFrame = z;
        }

        public final boolean isFrameAvailable() {
            return !this.isUpdatingFrame && this.bitmapRef.isValid();
        }

        public final void release() {
            com.facebook.common.references.CloseableReference.closeSafely(this.bitmapRef);
        }
    }
}
