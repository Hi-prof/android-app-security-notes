package com.facebook.fresco.animation.bitmap.wrapper;

/* JADX INFO: compiled from: AnimatedDrawableBackendFrameRenderer.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0018\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/facebook/fresco/animation/bitmap/wrapper/AnimatedDrawableBackendFrameRenderer;", "Lcom/facebook/fresco/animation/bitmap/BitmapFrameRenderer;", "bitmapFrameCache", "Lcom/facebook/fresco/animation/bitmap/BitmapFrameCache;", "animatedDrawableBackend", "Lcom/facebook/imagepipeline/animated/base/AnimatedDrawableBackend;", "isNewRenderImplementation", "", "<init>", "(Lcom/facebook/fresco/animation/bitmap/BitmapFrameCache;Lcom/facebook/imagepipeline/animated/base/AnimatedDrawableBackend;Z)V", "animatedImageCompositor", "Lcom/facebook/imagepipeline/animated/impl/AnimatedImageCompositor;", com.taobao.weex.bridge.WXBridgeManager.METHOD_CALLBACK, "Lcom/facebook/imagepipeline/animated/impl/AnimatedImageCompositor$Callback;", "setBounds", "", "bounds", "Landroid/graphics/Rect;", "intrinsicWidth", "", "getIntrinsicWidth", "()I", "intrinsicHeight", "getIntrinsicHeight", "renderFrame", "frameNumber", "targetBitmap", "Landroid/graphics/Bitmap;", "Companion", "animated-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AnimatedDrawableBackendFrameRenderer implements com.facebook.fresco.animation.bitmap.BitmapFrameRenderer {
    private static final java.lang.Class<?> TAG = com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendFrameRenderer.class;
    private com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend animatedDrawableBackend;
    private com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor animatedImageCompositor;
    private final com.facebook.fresco.animation.bitmap.BitmapFrameCache bitmapFrameCache;
    private final com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback callback;
    private final boolean isNewRenderImplementation;

    public AnimatedDrawableBackendFrameRenderer(com.facebook.fresco.animation.bitmap.BitmapFrameCache bitmapFrameCache, com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend animatedDrawableBackend, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bitmapFrameCache, "bitmapFrameCache");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(animatedDrawableBackend, "animatedDrawableBackend");
        this.bitmapFrameCache = bitmapFrameCache;
        this.animatedDrawableBackend = animatedDrawableBackend;
        this.isNewRenderImplementation = z;
        com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback callback = new com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback() { // from class: com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendFrameRenderer$callback$1
            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback
            public void onIntermediateResult(int frameNumber, android.graphics.Bitmap bitmap) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            }

            @Override // com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback
            public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> getCachedBitmap(int frameNumber) {
                return this.this$0.bitmapFrameCache.getCachedFrame(frameNumber);
            }
        };
        this.callback = callback;
        this.animatedImageCompositor = new com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor(this.animatedDrawableBackend, z, callback);
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameRenderer
    public void setBounds(android.graphics.Rect bounds) {
        com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend animatedDrawableBackendForNewBounds = this.animatedDrawableBackend.forNewBounds(bounds);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(animatedDrawableBackendForNewBounds, "forNewBounds(...)");
        if (animatedDrawableBackendForNewBounds != this.animatedDrawableBackend) {
            this.animatedDrawableBackend = animatedDrawableBackendForNewBounds;
            this.animatedImageCompositor = new com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor(this.animatedDrawableBackend, this.isNewRenderImplementation, this.callback);
        }
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameRenderer
    public int getIntrinsicWidth() {
        return this.animatedDrawableBackend.getWidth();
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameRenderer
    public int getIntrinsicHeight() {
        return this.animatedDrawableBackend.getHeight();
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameRenderer
    public boolean renderFrame(int frameNumber, android.graphics.Bitmap targetBitmap) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(targetBitmap, "targetBitmap");
        try {
            this.animatedImageCompositor.renderFrame(frameNumber, targetBitmap);
            return true;
        } catch (java.lang.IllegalStateException e) {
            com.facebook.common.logging.FLog.e(TAG, e, "Rendering of frame unsuccessful. Frame number: %d", java.lang.Integer.valueOf(frameNumber));
            return false;
        }
    }
}
