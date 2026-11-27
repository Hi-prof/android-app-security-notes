package com.facebook.fresco.animation.bitmap;

/* JADX INFO: compiled from: BitmapAnimationBackend.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u0000 X2\u00020\u00012\u00020\u0002:\u0003VWXBO\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010+\u001a\u00020,2\b\u0010'\u001a\u0004\u0018\u00010(J\b\u0010-\u001a\u00020 H\u0016J\u0010\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u00020 H\u0016J\b\u00100\u001a\u00020 H\u0016J\b\u00101\u001a\u00020 H\u0016J\b\u00102\u001a\u00020 H\u0016J\b\u00103\u001a\u00020 H\u0016J \u00104\u001a\u00020\f2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u0010/\u001a\u00020 H\u0016J \u00109\u001a\u00020\f2\u0006\u00107\u001a\u0002082\u0006\u0010/\u001a\u00020 2\u0006\u0010:\u001a\u00020 H\u0002J\u0012\u0010;\u001a\u00020,2\b\b\u0001\u0010<\u001a\u00020 H\u0016J\u0012\u0010=\u001a\u00020,2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0012\u0010@\u001a\u00020,2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010A\u001a\u00020 H\u0016J\b\u0010B\u001a\u00020 H\u0016J\b\u0010C\u001a\u00020 H\u0016J\b\u0010D\u001a\u00020,H\u0016J\b\u0010E\u001a\u00020,H\u0016J\b\u0010F\u001a\u00020,H\u0016J\u0012\u0010G\u001a\u00020,2\b\u0010H\u001a\u0004\u0018\u00010*H\u0016J\b\u0010I\u001a\u00020,H\u0002J \u0010J\u001a\u00020\f2\u0006\u0010/\u001a\u00020 2\u000e\u0010K\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010LH\u0002J(\u0010N\u001a\u00020\f2\u0006\u0010/\u001a\u00020 2\u0006\u0010O\u001a\u00020M2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020QH\u0002J \u0010S\u001a\u00020,2\u0006\u0010/\u001a\u00020 2\u0006\u0010O\u001a\u00020M2\u0006\u00107\u001a\u000208H\u0002J0\u0010T\u001a\u00020\f2\u0006\u0010/\u001a\u00020 2\u000e\u0010U\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010L2\u0006\u00107\u001a\u0002082\u0006\u0010:\u001a\u00020 H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lcom/facebook/fresco/animation/bitmap/BitmapAnimationBackend;", "Lcom/facebook/fresco/animation/backend/AnimationBackend;", "Lcom/facebook/fresco/animation/backend/AnimationBackendDelegateWithInactivityCheck$InactivityListener;", "platformBitmapFactory", "Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;", "bitmapFrameCache", "Lcom/facebook/fresco/animation/bitmap/BitmapFrameCache;", "animationInformation", "Lcom/facebook/fresco/animation/backend/AnimationInformation;", "bitmapFrameRenderer", "Lcom/facebook/fresco/animation/bitmap/BitmapFrameRenderer;", "isNewRenderImplementation", "", "bitmapFramePreparationStrategy", "Lcom/facebook/fresco/animation/bitmap/preparation/BitmapFramePreparationStrategy;", "bitmapFramePreparer", "Lcom/facebook/fresco/animation/bitmap/preparation/BitmapFramePreparer;", "roundingOptions", "Lcom/facebook/fresco/vito/options/RoundingOptions;", "<init>", "(Lcom/facebook/imagepipeline/bitmaps/PlatformBitmapFactory;Lcom/facebook/fresco/animation/bitmap/BitmapFrameCache;Lcom/facebook/fresco/animation/backend/AnimationInformation;Lcom/facebook/fresco/animation/bitmap/BitmapFrameRenderer;ZLcom/facebook/fresco/animation/bitmap/preparation/BitmapFramePreparationStrategy;Lcom/facebook/fresco/animation/bitmap/preparation/BitmapFramePreparer;Lcom/facebook/fresco/vito/options/RoundingOptions;)V", "cornerRadii", "", "getCornerRadii", "()[F", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "paint", "Landroid/graphics/Paint;", "bounds", "Landroid/graphics/Rect;", "bitmapWidth", "", "bitmapHeight", io.dcloud.common.constant.AbsoluteConst.XML_PATH, "Landroid/graphics/Path;", "matrix", "Landroid/graphics/Matrix;", "pathFrameNumber", "frameListener", "Lcom/facebook/fresco/animation/bitmap/BitmapAnimationBackend$FrameListener;", "animationListener", "Lcom/facebook/fresco/animation/backend/AnimationBackend$Listener;", "setFrameListener", "", "getFrameCount", "getFrameDurationMs", "frameNumber", "width", "height", "getLoopDurationMs", "getLoopCount", "drawFrame", "parent", "Landroid/graphics/drawable/Drawable;", "canvas", "Landroid/graphics/Canvas;", "drawFrameOrFallback", "frameType", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setBounds", "getIntrinsicWidth", "getIntrinsicHeight", "getSizeInBytes", "clear", "preloadAnimation", "onInactive", "setAnimationListener", "listener", "updateBitmapDimensions", "renderFrameInBitmap", "targetBitmap", "Lcom/facebook/common/references/CloseableReference;", "Landroid/graphics/Bitmap;", "updatePath", "bitmap", "currentBoundsWidth", "", "currentBoundsHeight", "drawBitmap", "drawBitmapAndCache", "bitmapReference", "FrameListener", "FrameType", "Companion", "animated-drawable_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BitmapAnimationBackend implements com.facebook.fresco.animation.backend.AnimationBackend, com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck.InactivityListener {
    public static final int FRAME_TYPE_CACHED = 0;
    public static final int FRAME_TYPE_CREATED = 2;
    public static final int FRAME_TYPE_FALLBACK = 3;
    public static final int FRAME_TYPE_REUSED = 1;
    public static final int FRAME_TYPE_UNKNOWN = -1;
    private final com.facebook.fresco.animation.backend.AnimationInformation animationInformation;
    private com.facebook.fresco.animation.backend.AnimationBackend.Listener animationListener;
    private final android.graphics.Bitmap.Config bitmapConfig;
    private final com.facebook.fresco.animation.bitmap.BitmapFrameCache bitmapFrameCache;
    private final com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparationStrategy bitmapFramePreparationStrategy;
    private final com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparer bitmapFramePreparer;
    private final com.facebook.fresco.animation.bitmap.BitmapFrameRenderer bitmapFrameRenderer;
    private int bitmapHeight;
    private int bitmapWidth;
    private android.graphics.Rect bounds;
    private final float[] cornerRadii;
    private com.facebook.fresco.animation.bitmap.BitmapAnimationBackend.FrameListener frameListener;
    private final boolean isNewRenderImplementation;
    private final android.graphics.Matrix matrix;
    private final android.graphics.Paint paint;
    private final android.graphics.Path path;
    private int pathFrameNumber;
    private final com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory platformBitmapFactory;
    private static final java.lang.Class<com.facebook.fresco.animation.bitmap.BitmapAnimationBackend> TAG = com.facebook.fresco.animation.bitmap.BitmapAnimationBackend.class;

    /* JADX INFO: compiled from: BitmapAnimationBackend.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/facebook/fresco/animation/bitmap/BitmapAnimationBackend$FrameListener;", "", "onDrawFrameStart", "", "backend", "Lcom/facebook/fresco/animation/bitmap/BitmapAnimationBackend;", "frameNumber", "", "onFrameDrawn", "frameType", "onFrameDropped", "animated-drawable_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface FrameListener {
        void onDrawFrameStart(com.facebook.fresco.animation.bitmap.BitmapAnimationBackend backend, int frameNumber);

        void onFrameDrawn(com.facebook.fresco.animation.bitmap.BitmapAnimationBackend backend, int frameNumber, int frameType);

        void onFrameDropped(com.facebook.fresco.animation.bitmap.BitmapAnimationBackend backend, int frameNumber);
    }

    /* JADX INFO: compiled from: BitmapAnimationBackend.kt */
    @kotlin.Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/facebook/fresco/animation/bitmap/BitmapAnimationBackend$FrameType;", "", "animated-drawable_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(kotlin.annotation.AnnotationRetention.SOURCE)
    public @interface FrameType {
    }

    public BitmapAnimationBackend(com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory platformBitmapFactory, com.facebook.fresco.animation.bitmap.BitmapFrameCache bitmapFrameCache, com.facebook.fresco.animation.backend.AnimationInformation animationInformation, com.facebook.fresco.animation.bitmap.BitmapFrameRenderer bitmapFrameRenderer, boolean z, com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparationStrategy bitmapFramePreparationStrategy, com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparer bitmapFramePreparer, com.facebook.fresco.vito.options.RoundingOptions roundingOptions) {
        float[] cornerRadii;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(platformBitmapFactory, "platformBitmapFactory");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bitmapFrameCache, "bitmapFrameCache");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(animationInformation, "animationInformation");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bitmapFrameRenderer, "bitmapFrameRenderer");
        this.platformBitmapFactory = platformBitmapFactory;
        this.bitmapFrameCache = bitmapFrameCache;
        this.animationInformation = animationInformation;
        this.bitmapFrameRenderer = bitmapFrameRenderer;
        this.isNewRenderImplementation = z;
        this.bitmapFramePreparationStrategy = bitmapFramePreparationStrategy;
        this.bitmapFramePreparer = bitmapFramePreparer;
        if (roundingOptions == null) {
            cornerRadii = null;
        } else if (roundingOptions.getCornerRadius() != 0.0f) {
            float[] fArr = new float[8];
            kotlin.collections.ArraysKt.fill$default(fArr, roundingOptions.getCornerRadius(), 0, 0, 6, (java.lang.Object) null);
            cornerRadii = fArr;
        } else {
            cornerRadii = roundingOptions.getCornerRadii();
        }
        this.cornerRadii = cornerRadii;
        this.bitmapConfig = android.graphics.Bitmap.Config.ARGB_8888;
        this.paint = new android.graphics.Paint(6);
        this.path = new android.graphics.Path();
        this.matrix = new android.graphics.Matrix();
        this.pathFrameNumber = -1;
        updateBitmapDimensions();
    }

    public /* synthetic */ BitmapAnimationBackend(com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory platformBitmapFactory, com.facebook.fresco.animation.bitmap.BitmapFrameCache bitmapFrameCache, com.facebook.fresco.animation.backend.AnimationInformation animationInformation, com.facebook.fresco.animation.bitmap.BitmapFrameRenderer bitmapFrameRenderer, boolean z, com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparationStrategy bitmapFramePreparationStrategy, com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparer bitmapFramePreparer, com.facebook.fresco.vito.options.RoundingOptions roundingOptions, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(platformBitmapFactory, bitmapFrameCache, animationInformation, bitmapFrameRenderer, z, bitmapFramePreparationStrategy, bitmapFramePreparer, (i & 128) != 0 ? null : roundingOptions);
    }

    public final float[] getCornerRadii() {
        return this.cornerRadii;
    }

    public final void setFrameListener(com.facebook.fresco.animation.bitmap.BitmapAnimationBackend.FrameListener frameListener) {
        this.frameListener = frameListener;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameCount() {
        return this.animationInformation.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameDurationMs(int frameNumber) {
        return this.animationInformation.getFrameDurationMs(frameNumber);
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int width() {
        return this.animationInformation.width();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int height() {
        return this.animationInformation.height();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getLoopDurationMs() {
        return this.animationInformation.getLoopDurationMs();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getLoopCount() {
        return this.animationInformation.getLoopCount();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public boolean drawFrame(android.graphics.drawable.Drawable parent, android.graphics.Canvas canvas, int frameNumber) throws java.lang.Throwable {
        com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparer bitmapFramePreparer;
        com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparationStrategy bitmapFramePreparationStrategy;
        com.facebook.fresco.animation.bitmap.BitmapAnimationBackend.FrameListener frameListener;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parent, "parent");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(canvas, "canvas");
        com.facebook.fresco.animation.bitmap.BitmapAnimationBackend.FrameListener frameListener2 = this.frameListener;
        if (frameListener2 != null) {
            frameListener2.onDrawFrameStart(this, frameNumber);
        }
        boolean zDrawFrameOrFallback = drawFrameOrFallback(canvas, frameNumber, 0);
        if (!zDrawFrameOrFallback && (frameListener = this.frameListener) != null) {
            frameListener.onFrameDropped(this, frameNumber);
        }
        if (!this.isNewRenderImplementation && (bitmapFramePreparer = this.bitmapFramePreparer) != null && (bitmapFramePreparationStrategy = this.bitmapFramePreparationStrategy) != null) {
            com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparationStrategy.DefaultImpls.prepareFrames$default(bitmapFramePreparationStrategy, bitmapFramePreparer, this.bitmapFrameCache, this, frameNumber, null, 16, null);
        }
        return zDrawFrameOrFallback;
    }

    private final boolean drawFrameOrFallback(android.graphics.Canvas canvas, int frameNumber, int frameType) throws java.lang.Throwable {
        com.facebook.common.references.CloseableReference<android.graphics.Bitmap> cachedFrame;
        boolean zDrawBitmapAndCache;
        com.facebook.common.references.CloseableReference<android.graphics.Bitmap> closeableReference = null;
        try {
            boolean z = false;
            int i = 1;
            if (this.isNewRenderImplementation) {
                com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparationStrategy bitmapFramePreparationStrategy = this.bitmapFramePreparationStrategy;
                com.facebook.common.references.CloseableReference<android.graphics.Bitmap> bitmapFrame = bitmapFramePreparationStrategy != null ? bitmapFramePreparationStrategy.getBitmapFrame(frameNumber, canvas.getWidth(), canvas.getHeight()) : null;
                if (bitmapFrame != null) {
                    try {
                        if (bitmapFrame.isValid()) {
                            android.graphics.Bitmap bitmap = bitmapFrame.get();
                            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bitmap, "get(...)");
                            drawBitmap(frameNumber, bitmap, canvas);
                            com.facebook.common.references.CloseableReference.closeSafely(bitmapFrame);
                            return true;
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        closeableReference = bitmapFrame;
                    }
                }
                com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparationStrategy bitmapFramePreparationStrategy2 = this.bitmapFramePreparationStrategy;
                if (bitmapFramePreparationStrategy2 != null) {
                    bitmapFramePreparationStrategy2.prepareFrames(canvas.getWidth(), canvas.getHeight(), null);
                }
                com.facebook.common.references.CloseableReference.closeSafely(bitmapFrame);
                return false;
            }
            if (frameType == 0) {
                cachedFrame = this.bitmapFrameCache.getCachedFrame(frameNumber);
                zDrawBitmapAndCache = drawBitmapAndCache(frameNumber, cachedFrame, canvas, 0);
            } else if (frameType == 1) {
                cachedFrame = this.bitmapFrameCache.getBitmapToReuseForFrame(frameNumber, this.bitmapWidth, this.bitmapHeight);
                if (renderFrameInBitmap(frameNumber, cachedFrame) && drawBitmapAndCache(frameNumber, cachedFrame, canvas, 1)) {
                    z = true;
                }
                zDrawBitmapAndCache = z;
                i = 2;
            } else if (frameType == 2) {
                try {
                    cachedFrame = this.platformBitmapFactory.createBitmap(this.bitmapWidth, this.bitmapHeight, this.bitmapConfig);
                    if (renderFrameInBitmap(frameNumber, cachedFrame) && drawBitmapAndCache(frameNumber, cachedFrame, canvas, 2)) {
                        z = true;
                    }
                    zDrawBitmapAndCache = z;
                    i = 3;
                } catch (java.lang.RuntimeException e) {
                    com.facebook.common.logging.FLog.w(TAG, "Failed to create frame bitmap", e);
                    com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) null);
                    return false;
                }
            } else {
                if (frameType != 3) {
                    com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) null);
                    return false;
                }
                cachedFrame = this.bitmapFrameCache.getFallbackFrame(frameNumber);
                zDrawBitmapAndCache = drawBitmapAndCache(frameNumber, cachedFrame, canvas, 3);
                i = -1;
            }
            com.facebook.common.references.CloseableReference.closeSafely(cachedFrame);
            return (zDrawBitmapAndCache || i == -1) ? zDrawBitmapAndCache : drawFrameOrFallback(canvas, frameNumber, i);
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
        com.facebook.common.references.CloseableReference.closeSafely(closeableReference);
        throw th;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setAlpha(int alpha) {
        this.paint.setAlpha(alpha);
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setBounds(android.graphics.Rect bounds) {
        this.bounds = bounds;
        this.bitmapFrameRenderer.setBounds(bounds);
        updateBitmapDimensions();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    /* JADX INFO: renamed from: getIntrinsicWidth, reason: from getter */
    public int getBitmapWidth() {
        return this.bitmapWidth;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    /* JADX INFO: renamed from: getIntrinsicHeight, reason: from getter */
    public int getBitmapHeight() {
        return this.bitmapHeight;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getSizeInBytes() {
        return this.bitmapFrameCache.getSizeInBytes();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void clear() {
        if (this.isNewRenderImplementation) {
            com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparationStrategy bitmapFramePreparationStrategy = this.bitmapFramePreparationStrategy;
            if (bitmapFramePreparationStrategy != null) {
                bitmapFramePreparationStrategy.clearFrames();
                return;
            }
            return;
        }
        this.bitmapFrameCache.clear();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void preloadAnimation() {
        com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparer bitmapFramePreparer;
        if (!this.isNewRenderImplementation && (bitmapFramePreparer = this.bitmapFramePreparer) != null) {
            com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparationStrategy bitmapFramePreparationStrategy = this.bitmapFramePreparationStrategy;
            if (bitmapFramePreparationStrategy != null) {
                bitmapFramePreparationStrategy.prepareFrames(bitmapFramePreparer, this.bitmapFrameCache, this, 0, new kotlin.jvm.functions.Function0() { // from class: com.facebook.fresco.animation.bitmap.BitmapAnimationBackend$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final java.lang.Object invoke() {
                        return com.facebook.fresco.animation.bitmap.BitmapAnimationBackend.preloadAnimation$lambda$1(this.f$0);
                    }
                });
                return;
            }
            return;
        }
        com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparationStrategy bitmapFramePreparationStrategy2 = this.bitmapFramePreparationStrategy;
        if (bitmapFramePreparationStrategy2 != null) {
            bitmapFramePreparationStrategy2.prepareFrames(this.animationInformation.width(), this.animationInformation.height(), new kotlin.jvm.functions.Function0() { // from class: com.facebook.fresco.animation.bitmap.BitmapAnimationBackend$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return com.facebook.fresco.animation.bitmap.BitmapAnimationBackend.preloadAnimation$lambda$2(this.f$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit preloadAnimation$lambda$1(com.facebook.fresco.animation.bitmap.BitmapAnimationBackend this$0) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.facebook.fresco.animation.backend.AnimationBackend.Listener listener = this$0.animationListener;
        if (listener != null) {
            listener.onAnimationLoaded();
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit preloadAnimation$lambda$2(com.facebook.fresco.animation.bitmap.BitmapAnimationBackend this$0) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.facebook.fresco.animation.backend.AnimationBackend.Listener listener = this$0.animationListener;
        if (listener != null) {
            listener.onAnimationLoaded();
        }
        return kotlin.Unit.INSTANCE;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck.InactivityListener
    public void onInactive() {
        if (this.isNewRenderImplementation) {
            com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparationStrategy bitmapFramePreparationStrategy = this.bitmapFramePreparationStrategy;
            if (bitmapFramePreparationStrategy != null) {
                bitmapFramePreparationStrategy.onStop();
                return;
            }
            return;
        }
        clear();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setAnimationListener(com.facebook.fresco.animation.backend.AnimationBackend.Listener listener) {
        this.animationListener = listener;
    }

    private final void updateBitmapDimensions() {
        int intrinsicWidth = this.bitmapFrameRenderer.getIntrinsicWidth();
        this.bitmapWidth = intrinsicWidth;
        if (intrinsicWidth == -1) {
            android.graphics.Rect rect = this.bounds;
            this.bitmapWidth = rect != null ? rect.width() : -1;
        }
        int intrinsicHeight = this.bitmapFrameRenderer.getIntrinsicHeight();
        this.bitmapHeight = intrinsicHeight;
        if (intrinsicHeight == -1) {
            android.graphics.Rect rect2 = this.bounds;
            this.bitmapHeight = rect2 != null ? rect2.height() : -1;
        }
    }

    private final boolean renderFrameInBitmap(int frameNumber, com.facebook.common.references.CloseableReference<android.graphics.Bitmap> targetBitmap) {
        if (targetBitmap == null || !targetBitmap.isValid()) {
            return false;
        }
        com.facebook.fresco.animation.bitmap.BitmapFrameRenderer bitmapFrameRenderer = this.bitmapFrameRenderer;
        android.graphics.Bitmap bitmap = targetBitmap.get();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bitmap, "get(...)");
        boolean zRenderFrame = bitmapFrameRenderer.renderFrame(frameNumber, bitmap);
        if (!zRenderFrame) {
            com.facebook.common.references.CloseableReference.closeSafely(targetBitmap);
        }
        return zRenderFrame;
    }

    private final boolean updatePath(int frameNumber, android.graphics.Bitmap bitmap, float currentBoundsWidth, float currentBoundsHeight) {
        if (this.cornerRadii == null) {
            return false;
        }
        if (frameNumber == this.pathFrameNumber) {
            return true;
        }
        android.graphics.BitmapShader bitmapShader = new android.graphics.BitmapShader(bitmap, android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP);
        this.matrix.setRectToRect(new android.graphics.RectF(0.0f, 0.0f, this.bitmapWidth, this.bitmapHeight), new android.graphics.RectF(0.0f, 0.0f, currentBoundsWidth, currentBoundsHeight), android.graphics.Matrix.ScaleToFit.FILL);
        bitmapShader.setLocalMatrix(this.matrix);
        this.paint.setShader(bitmapShader);
        this.path.addRoundRect(new android.graphics.RectF(0.0f, 0.0f, currentBoundsWidth, currentBoundsHeight), this.cornerRadii, android.graphics.Path.Direction.CW);
        this.pathFrameNumber = frameNumber;
        return true;
    }

    private final void drawBitmap(int frameNumber, android.graphics.Bitmap bitmap, android.graphics.Canvas canvas) {
        android.graphics.Rect rect = this.bounds;
        if (rect == null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.paint);
        } else if (updatePath(frameNumber, bitmap, rect.width(), rect.height())) {
            canvas.drawPath(this.path, this.paint);
        } else {
            canvas.drawBitmap(bitmap, (android.graphics.Rect) null, rect, this.paint);
        }
    }

    private final boolean drawBitmapAndCache(int frameNumber, com.facebook.common.references.CloseableReference<android.graphics.Bitmap> bitmapReference, android.graphics.Canvas canvas, int frameType) {
        if (bitmapReference == null || !com.facebook.common.references.CloseableReference.isValid(bitmapReference)) {
            return false;
        }
        android.graphics.Bitmap bitmap = bitmapReference.get();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bitmap, "get(...)");
        drawBitmap(frameNumber, bitmap, canvas);
        if (frameType != 3 && !this.isNewRenderImplementation) {
            this.bitmapFrameCache.onFrameRendered(frameNumber, bitmapReference, frameType);
        }
        com.facebook.fresco.animation.bitmap.BitmapAnimationBackend.FrameListener frameListener = this.frameListener;
        if (frameListener == null) {
            return true;
        }
        frameListener.onFrameDrawn(this, frameNumber, frameType);
        return true;
    }
}
