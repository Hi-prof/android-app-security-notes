package com.facebook.imagepipeline.animated.impl;

/* JADX INFO: loaded from: classes.dex */
public class AnimatedImageCompositor {
    private final com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend mAnimatedDrawableBackend;
    private final com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback mCallback;
    private final boolean mIsNewRenderImplementation;
    private final android.graphics.Paint mTransparentFillPaint;

    public interface Callback {
        @javax.annotation.Nullable
        com.facebook.common.references.CloseableReference<android.graphics.Bitmap> getCachedBitmap(int i);

        void onIntermediateResult(int i, android.graphics.Bitmap bitmap);
    }

    private enum FrameNeededResult {
        REQUIRED,
        NOT_REQUIRED,
        SKIP,
        ABORT
    }

    public AnimatedImageCompositor(com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend animatedDrawableBackend, boolean z, com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.Callback callback) {
        this.mAnimatedDrawableBackend = animatedDrawableBackend;
        this.mCallback = callback;
        this.mIsNewRenderImplementation = z;
        android.graphics.Paint paint = new android.graphics.Paint();
        this.mTransparentFillPaint = paint;
        paint.setColor(0);
        paint.setStyle(android.graphics.Paint.Style.FILL);
        paint.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC));
    }

    public void renderDeltas(int i, android.graphics.Bitmap bitmap) {
        this.mAnimatedDrawableBackend.renderDeltas(i, new android.graphics.Canvas(bitmap));
    }

    public void renderFrame(int i, android.graphics.Bitmap bitmap) {
        if (this.mIsNewRenderImplementation) {
            renderDeltas(i, bitmap);
            return;
        }
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmap);
        canvas.drawColor(0, android.graphics.PorterDuff.Mode.SRC);
        for (int iPrepareCanvasWithClosestCachedFrame = !isKeyFrame(i) ? prepareCanvasWithClosestCachedFrame(i - 1, canvas) : i; iPrepareCanvasWithClosestCachedFrame < i; iPrepareCanvasWithClosestCachedFrame++) {
            com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo frameInfo = this.mAnimatedDrawableBackend.getFrameInfo(iPrepareCanvasWithClosestCachedFrame);
            com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = frameInfo.disposalMethod;
            if (disposalMethod != com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
                if (frameInfo.blendOperation == com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
                    disposeToBackground(canvas, frameInfo);
                }
                this.mAnimatedDrawableBackend.renderFrame(iPrepareCanvasWithClosestCachedFrame, canvas);
                this.mCallback.onIntermediateResult(iPrepareCanvasWithClosestCachedFrame, bitmap);
                if (disposalMethod == com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                    disposeToBackground(canvas, frameInfo);
                }
            }
        }
        com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo frameInfo2 = this.mAnimatedDrawableBackend.getFrameInfo(i);
        if (frameInfo2.blendOperation == com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND) {
            disposeToBackground(canvas, frameInfo2);
        }
        this.mAnimatedDrawableBackend.renderFrame(i, canvas);
        maybeApplyTransformation(bitmap);
    }

    /* JADX INFO: renamed from: com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$imagepipeline$animated$impl$AnimatedImageCompositor$FrameNeededResult;

        static {
            int[] iArr = new int[com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.FrameNeededResult.values().length];
            $SwitchMap$com$facebook$imagepipeline$animated$impl$AnimatedImageCompositor$FrameNeededResult = iArr;
            try {
                iArr[com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.FrameNeededResult.REQUIRED.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$imagepipeline$animated$impl$AnimatedImageCompositor$FrameNeededResult[com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.FrameNeededResult.NOT_REQUIRED.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$imagepipeline$animated$impl$AnimatedImageCompositor$FrameNeededResult[com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.FrameNeededResult.ABORT.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$facebook$imagepipeline$animated$impl$AnimatedImageCompositor$FrameNeededResult[com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.FrameNeededResult.SKIP.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    private int prepareCanvasWithClosestCachedFrame(int i, android.graphics.Canvas canvas) {
        while (i >= 0) {
            int i2 = com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.AnonymousClass1.$SwitchMap$com$facebook$imagepipeline$animated$impl$AnimatedImageCompositor$FrameNeededResult[isFrameNeededForRendering(i).ordinal()];
            if (i2 == 1) {
                com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo frameInfo = this.mAnimatedDrawableBackend.getFrameInfo(i);
                com.facebook.common.references.CloseableReference<android.graphics.Bitmap> cachedBitmap = this.mCallback.getCachedBitmap(i);
                if (cachedBitmap != null) {
                    try {
                        canvas.drawBitmap(cachedBitmap.get(), 0.0f, 0.0f, (android.graphics.Paint) null);
                        if (frameInfo.disposalMethod == com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
                            disposeToBackground(canvas, frameInfo);
                        }
                        return i + 1;
                    } finally {
                        if (!this.mIsNewRenderImplementation) {
                            cachedBitmap.close();
                        }
                    }
                }
                if (isKeyFrame(i)) {
                    return i;
                }
                i--;
            } else {
                if (i2 == 2) {
                    return i + 1;
                }
                if (i2 == 3) {
                    return i;
                }
                i--;
            }
        }
        return 0;
    }

    private void disposeToBackground(android.graphics.Canvas canvas, com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        canvas.drawRect(animatedDrawableFrameInfo.xOffset, animatedDrawableFrameInfo.yOffset, animatedDrawableFrameInfo.xOffset + animatedDrawableFrameInfo.width, animatedDrawableFrameInfo.yOffset + animatedDrawableFrameInfo.height, this.mTransparentFillPaint);
    }

    private com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.FrameNeededResult isFrameNeededForRendering(int i) {
        com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo frameInfo = this.mAnimatedDrawableBackend.getFrameInfo(i);
        com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod disposalMethod = frameInfo.disposalMethod;
        if (disposalMethod == com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT) {
            return com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.FrameNeededResult.REQUIRED;
        }
        if (disposalMethod == com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND) {
            if (isFullFrame(frameInfo)) {
                return com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.FrameNeededResult.NOT_REQUIRED;
            }
            return com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.FrameNeededResult.REQUIRED;
        }
        if (disposalMethod == com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS) {
            return com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.FrameNeededResult.SKIP;
        }
        return com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor.FrameNeededResult.ABORT;
    }

    private boolean isKeyFrame(int i) {
        if (i == 0) {
            return true;
        }
        com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo frameInfo = this.mAnimatedDrawableBackend.getFrameInfo(i);
        com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo frameInfo2 = this.mAnimatedDrawableBackend.getFrameInfo(i - 1);
        if (frameInfo.blendOperation == com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND && isFullFrame(frameInfo)) {
            return true;
        }
        return frameInfo2.disposalMethod == com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND && isFullFrame(frameInfo2);
    }

    private boolean isFullFrame(com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        return animatedDrawableFrameInfo.xOffset == 0 && animatedDrawableFrameInfo.yOffset == 0 && animatedDrawableFrameInfo.width == this.mAnimatedDrawableBackend.getRenderedWidth() && animatedDrawableFrameInfo.height == this.mAnimatedDrawableBackend.getRenderedHeight();
    }

    private void maybeApplyTransformation(android.graphics.Bitmap bitmap) {
        com.facebook.imagepipeline.transformation.BitmapTransformation bitmapTransformation;
        com.facebook.imagepipeline.animated.base.AnimatedImageResult animatedImageResult = this.mAnimatedDrawableBackend.getAnimatedImageResult();
        if (animatedImageResult == null || (bitmapTransformation = animatedImageResult.getBitmapTransformation()) == null) {
            return;
        }
        bitmapTransformation.transform(bitmap);
    }
}
