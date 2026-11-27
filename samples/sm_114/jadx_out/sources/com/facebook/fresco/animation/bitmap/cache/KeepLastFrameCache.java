package com.facebook.fresco.animation.bitmap.cache;

/* JADX INFO: compiled from: KeepLastFrameCache.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u0005H\u0016J(\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0011\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u0005H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J&\u0010\u0018\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J&\u0010\u001b\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0012\u0010\u001c\u001a\u00020\u00172\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u001d\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/facebook/fresco/animation/bitmap/cache/KeepLastFrameCache;", "Lcom/facebook/fresco/animation/bitmap/BitmapFrameCache;", "<init>", "()V", "lastFrameNumber", "", "frameCacheListener", "Lcom/facebook/fresco/animation/bitmap/BitmapFrameCache$FrameCacheListener;", "lastBitmapReference", "Lcom/facebook/common/references/CloseableReference;", "Landroid/graphics/Bitmap;", "getCachedFrame", "frameNumber", "getFallbackFrame", "getBitmapToReuseForFrame", "width", "height", "contains", "", "sizeInBytes", "getSizeInBytes", "()I", "clear", "", "onFrameRendered", "bitmapReference", "frameType", "onFramePrepared", "setFrameCacheListener", "closeAndResetLastBitmapReference", "Companion", "animated-drawable_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class KeepLastFrameCache implements com.facebook.fresco.animation.bitmap.BitmapFrameCache {
    private static final int FRAME_NUMBER_UNSET = -1;
    private com.facebook.fresco.animation.bitmap.BitmapFrameCache.FrameCacheListener frameCacheListener;
    private com.facebook.common.references.CloseableReference<android.graphics.Bitmap> lastBitmapReference;
    private int lastFrameNumber = -1;

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public void onFramePrepared(int frameNumber, com.facebook.common.references.CloseableReference<android.graphics.Bitmap> bitmapReference, int frameType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bitmapReference, "bitmapReference");
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public boolean isAnimationReady() {
        return com.facebook.fresco.animation.bitmap.BitmapFrameCache.DefaultImpls.isAnimationReady(this);
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public boolean onAnimationPrepared(java.util.Map<java.lang.Integer, ? extends com.facebook.common.references.CloseableReference<android.graphics.Bitmap>> map) {
        return com.facebook.fresco.animation.bitmap.BitmapFrameCache.DefaultImpls.onAnimationPrepared(this, map);
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized com.facebook.common.references.CloseableReference<android.graphics.Bitmap> getCachedFrame(int frameNumber) {
        return this.lastFrameNumber == frameNumber ? com.facebook.common.references.CloseableReference.cloneOrNull(this.lastBitmapReference) : null;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized com.facebook.common.references.CloseableReference<android.graphics.Bitmap> getFallbackFrame(int frameNumber) {
        return com.facebook.common.references.CloseableReference.cloneOrNull(this.lastBitmapReference);
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized com.facebook.common.references.CloseableReference<android.graphics.Bitmap> getBitmapToReuseForFrame(int frameNumber, int width, int height) {
        com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReferenceCloneOrNull;
        try {
            closeableReferenceCloneOrNull = com.facebook.common.references.CloseableReference.cloneOrNull(this.lastBitmapReference);
            closeAndResetLastBitmapReference();
        } catch (java.lang.Throwable th) {
            closeAndResetLastBitmapReference();
            throw th;
        }
        return closeableReferenceCloneOrNull;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized boolean contains(int frameNumber) {
        return frameNumber == this.lastFrameNumber && com.facebook.common.references.CloseableReference.isValid(this.lastBitmapReference);
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized int getSizeInBytes() {
        int sizeInBytes;
        com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReference = this.lastBitmapReference;
        if (closeableReference == null) {
            sizeInBytes = 0;
        } else {
            kotlin.jvm.internal.Intrinsics.checkNotNull(closeableReference);
            sizeInBytes = com.facebook.imageutils.BitmapUtil.getSizeInBytes(closeableReference.get());
        }
        return sizeInBytes;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized void clear() {
        closeAndResetLastBitmapReference();
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized void onFrameRendered(int frameNumber, com.facebook.common.references.CloseableReference<android.graphics.Bitmap> bitmapReference, int frameType) {
        com.facebook.fresco.animation.bitmap.BitmapFrameCache.FrameCacheListener frameCacheListener;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bitmapReference, "bitmapReference");
        if (this.lastBitmapReference != null) {
            android.graphics.Bitmap bitmap = bitmapReference.get();
            com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReference = this.lastBitmapReference;
            if (kotlin.jvm.internal.Intrinsics.areEqual(bitmap, closeableReference != null ? closeableReference.get() : null)) {
                return;
            }
        }
        com.facebook.common.references.CloseableReference.closeSafely(this.lastBitmapReference);
        int i = this.lastFrameNumber;
        if (i != -1 && (frameCacheListener = this.frameCacheListener) != null) {
            frameCacheListener.onFrameEvicted(this, i);
        }
        this.lastBitmapReference = com.facebook.common.references.CloseableReference.cloneOrNull(bitmapReference);
        com.facebook.fresco.animation.bitmap.BitmapFrameCache.FrameCacheListener frameCacheListener2 = this.frameCacheListener;
        if (frameCacheListener2 != null) {
            frameCacheListener2.onFrameCached(this, frameNumber);
        }
        this.lastFrameNumber = frameNumber;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public void setFrameCacheListener(com.facebook.fresco.animation.bitmap.BitmapFrameCache.FrameCacheListener frameCacheListener) {
        this.frameCacheListener = frameCacheListener;
    }

    private final synchronized void closeAndResetLastBitmapReference() {
        com.facebook.fresco.animation.bitmap.BitmapFrameCache.FrameCacheListener frameCacheListener;
        int i = this.lastFrameNumber;
        if (i != -1 && (frameCacheListener = this.frameCacheListener) != null) {
            frameCacheListener.onFrameEvicted(this, i);
        }
        com.facebook.common.references.CloseableReference.closeSafely(this.lastBitmapReference);
        this.lastBitmapReference = null;
        this.lastFrameNumber = -1;
    }
}
