package com.facebook.drawee.generic;

/* JADX INFO: loaded from: classes.dex */
public class GenericDraweeHierarchy implements com.facebook.drawee.interfaces.SettableDraweeHierarchy {
    private static final int ACTUAL_IMAGE_INDEX = 2;
    private static final int BACKGROUND_IMAGE_INDEX = 0;
    private static final int FAILURE_IMAGE_INDEX = 5;
    private static final int OVERLAY_IMAGES_INDEX = 6;
    private static final int PLACEHOLDER_IMAGE_INDEX = 1;
    private static final int PROGRESS_BAR_IMAGE_INDEX = 3;
    private static final int RETRY_IMAGE_INDEX = 4;
    private final com.facebook.drawee.drawable.ForwardingDrawable mActualImageWrapper;
    private final android.graphics.drawable.Drawable mEmptyActualImageDrawable;
    private final com.facebook.drawee.drawable.FadeDrawable mFadeDrawable;
    private final android.content.res.Resources mResources;

    @javax.annotation.Nullable
    private com.facebook.drawee.generic.RoundingParams mRoundingParams;
    private final com.facebook.drawee.generic.RootDrawable mTopLevelDrawable;

    GenericDraweeHierarchy(com.facebook.drawee.generic.GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder) {
        android.graphics.drawable.ColorDrawable colorDrawable = new android.graphics.drawable.ColorDrawable(0);
        this.mEmptyActualImageDrawable = colorDrawable;
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("GenericDraweeHierarchy()");
        }
        this.mResources = genericDraweeHierarchyBuilder.getResources();
        this.mRoundingParams = genericDraweeHierarchyBuilder.getRoundingParams();
        com.facebook.drawee.drawable.ForwardingDrawable forwardingDrawable = new com.facebook.drawee.drawable.ForwardingDrawable(colorDrawable);
        this.mActualImageWrapper = forwardingDrawable;
        int i = 1;
        int size = genericDraweeHierarchyBuilder.getOverlays() != null ? genericDraweeHierarchyBuilder.getOverlays().size() : 1;
        int i2 = (size == 0 ? 1 : size) + (genericDraweeHierarchyBuilder.getPressedStateOverlay() != null ? 1 : 0);
        android.graphics.drawable.Drawable[] drawableArr = new android.graphics.drawable.Drawable[i2 + 6];
        drawableArr[0] = buildBranch(genericDraweeHierarchyBuilder.getBackground(), null);
        drawableArr[1] = buildBranch(genericDraweeHierarchyBuilder.getPlaceholderImage(), genericDraweeHierarchyBuilder.getPlaceholderImageScaleType());
        drawableArr[2] = buildActualImageBranch(forwardingDrawable, genericDraweeHierarchyBuilder.getActualImageScaleType(), genericDraweeHierarchyBuilder.getActualImageFocusPoint(), genericDraweeHierarchyBuilder.getActualImageColorFilter());
        drawableArr[3] = buildBranch(genericDraweeHierarchyBuilder.getProgressBarImage(), genericDraweeHierarchyBuilder.getProgressBarImageScaleType());
        drawableArr[4] = buildBranch(genericDraweeHierarchyBuilder.getRetryImage(), genericDraweeHierarchyBuilder.getRetryImageScaleType());
        drawableArr[5] = buildBranch(genericDraweeHierarchyBuilder.getFailureImage(), genericDraweeHierarchyBuilder.getFailureImageScaleType());
        if (i2 > 0) {
            if (genericDraweeHierarchyBuilder.getOverlays() != null) {
                java.util.Iterator<android.graphics.drawable.Drawable> it = genericDraweeHierarchyBuilder.getOverlays().iterator();
                i = 0;
                while (it.hasNext()) {
                    drawableArr[i + 6] = buildBranch(it.next(), null);
                    i++;
                }
            }
            if (genericDraweeHierarchyBuilder.getPressedStateOverlay() != null) {
                drawableArr[i + 6] = buildBranch(genericDraweeHierarchyBuilder.getPressedStateOverlay(), null);
            }
        }
        com.facebook.drawee.drawable.FadeDrawable fadeDrawable = new com.facebook.drawee.drawable.FadeDrawable(drawableArr, false, 2);
        this.mFadeDrawable = fadeDrawable;
        fadeDrawable.setTransitionDuration(genericDraweeHierarchyBuilder.getFadeDuration());
        com.facebook.drawee.generic.RootDrawable rootDrawable = new com.facebook.drawee.generic.RootDrawable(com.facebook.drawee.generic.WrappingUtils.maybeWrapWithRoundedOverlayColor(fadeDrawable, this.mRoundingParams));
        this.mTopLevelDrawable = rootDrawable;
        rootDrawable.mutate();
        resetFade();
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
    }

    @javax.annotation.Nullable
    private android.graphics.drawable.Drawable buildActualImageBranch(android.graphics.drawable.Drawable drawable, @javax.annotation.Nullable com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType, @javax.annotation.Nullable android.graphics.PointF pointF, @javax.annotation.Nullable android.graphics.ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return com.facebook.drawee.generic.WrappingUtils.maybeWrapWithScaleType(drawable, scaleType, pointF);
    }

    @javax.annotation.Nullable
    private android.graphics.drawable.Drawable buildBranch(@javax.annotation.Nullable android.graphics.drawable.Drawable drawable, @javax.annotation.Nullable com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        return com.facebook.drawee.generic.WrappingUtils.maybeWrapWithScaleType(com.facebook.drawee.generic.WrappingUtils.maybeApplyLeafRounding(drawable, this.mRoundingParams, this.mResources), scaleType);
    }

    private void resetActualImages() {
        this.mActualImageWrapper.setDrawable(this.mEmptyActualImageDrawable);
    }

    private void resetFade() {
        com.facebook.drawee.drawable.FadeDrawable fadeDrawable = this.mFadeDrawable;
        if (fadeDrawable != null) {
            fadeDrawable.beginBatchMode();
            this.mFadeDrawable.fadeInAllLayers();
            fadeOutBranches();
            fadeInLayer(1);
            this.mFadeDrawable.finishTransitionImmediately();
            this.mFadeDrawable.endBatchMode();
        }
    }

    private void fadeOutBranches() {
        fadeOutLayer(1);
        fadeOutLayer(2);
        fadeOutLayer(3);
        fadeOutLayer(4);
        fadeOutLayer(5);
    }

    private void fadeInLayer(int i) {
        if (i >= 0) {
            this.mFadeDrawable.fadeInLayer(i);
        }
    }

    private void fadeOutLayer(int i) {
        if (i >= 0) {
            this.mFadeDrawable.fadeOutLayer(i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setProgress(float f) {
        android.graphics.drawable.Drawable drawable = this.mFadeDrawable.getDrawable(3);
        if (drawable == 0) {
            return;
        }
        if (f >= 0.999f) {
            if (drawable instanceof android.graphics.drawable.Animatable) {
                ((android.graphics.drawable.Animatable) drawable).stop();
            }
            fadeOutLayer(3);
        } else {
            if (drawable instanceof android.graphics.drawable.Animatable) {
                ((android.graphics.drawable.Animatable) drawable).start();
            }
            fadeInLayer(3);
        }
        drawable.setLevel(java.lang.Math.round(f * 10000.0f));
    }

    @Override // com.facebook.drawee.interfaces.DraweeHierarchy
    public android.graphics.drawable.Drawable getTopLevelDrawable() {
        return this.mTopLevelDrawable;
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void reset() {
        resetActualImages();
        resetFade();
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void setImage(android.graphics.drawable.Drawable drawable, float f, boolean z) {
        android.graphics.drawable.Drawable drawableMaybeApplyLeafRounding = com.facebook.drawee.generic.WrappingUtils.maybeApplyLeafRounding(drawable, this.mRoundingParams, this.mResources);
        drawableMaybeApplyLeafRounding.mutate();
        this.mActualImageWrapper.setDrawable(drawableMaybeApplyLeafRounding);
        this.mFadeDrawable.beginBatchMode();
        fadeOutBranches();
        fadeInLayer(2);
        setProgress(f);
        if (z) {
            this.mFadeDrawable.finishTransitionImmediately();
        }
        this.mFadeDrawable.endBatchMode();
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void setProgress(float f, boolean z) {
        if (this.mFadeDrawable.getDrawable(3) == null) {
            return;
        }
        this.mFadeDrawable.beginBatchMode();
        setProgress(f);
        if (z) {
            this.mFadeDrawable.finishTransitionImmediately();
        }
        this.mFadeDrawable.endBatchMode();
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void setFailure(java.lang.Throwable th) {
        this.mFadeDrawable.beginBatchMode();
        fadeOutBranches();
        if (this.mFadeDrawable.getDrawable(5) != null) {
            fadeInLayer(5);
        } else {
            fadeInLayer(1);
        }
        this.mFadeDrawable.endBatchMode();
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void setRetry(java.lang.Throwable th) {
        this.mFadeDrawable.beginBatchMode();
        fadeOutBranches();
        if (this.mFadeDrawable.getDrawable(4) != null) {
            fadeInLayer(4);
        } else {
            fadeInLayer(1);
        }
        this.mFadeDrawable.endBatchMode();
    }

    @Override // com.facebook.drawee.interfaces.SettableDraweeHierarchy
    public void setControllerOverlay(@javax.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        this.mTopLevelDrawable.setControllerOverlay(drawable);
    }

    @Override // com.facebook.drawee.interfaces.DraweeHierarchy
    public android.graphics.Rect getBounds() {
        return this.mTopLevelDrawable.getBounds();
    }

    private com.facebook.drawee.drawable.DrawableParent getParentDrawableAtIndex(int i) {
        com.facebook.drawee.drawable.DrawableParent drawableParentForIndex = this.mFadeDrawable.getDrawableParentForIndex(i);
        if (drawableParentForIndex.getDrawable() instanceof com.facebook.drawee.drawable.MatrixDrawable) {
            drawableParentForIndex = (com.facebook.drawee.drawable.MatrixDrawable) drawableParentForIndex.getDrawable();
        }
        return drawableParentForIndex.getDrawable() instanceof com.facebook.drawee.drawable.ScaleTypeDrawable ? (com.facebook.drawee.drawable.ScaleTypeDrawable) drawableParentForIndex.getDrawable() : drawableParentForIndex;
    }

    private void setChildDrawableAtIndex(int i, @javax.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        if (drawable == null) {
            this.mFadeDrawable.setDrawable(i, null);
        } else {
            getParentDrawableAtIndex(i).setDrawable(com.facebook.drawee.generic.WrappingUtils.maybeApplyLeafRounding(drawable, this.mRoundingParams, this.mResources));
        }
    }

    private com.facebook.drawee.drawable.ScaleTypeDrawable getScaleTypeDrawableAtIndex(int i) {
        com.facebook.drawee.drawable.DrawableParent parentDrawableAtIndex = getParentDrawableAtIndex(i);
        if (parentDrawableAtIndex instanceof com.facebook.drawee.drawable.ScaleTypeDrawable) {
            return (com.facebook.drawee.drawable.ScaleTypeDrawable) parentDrawableAtIndex;
        }
        return com.facebook.drawee.generic.WrappingUtils.wrapChildWithScaleType(parentDrawableAtIndex, com.facebook.drawee.drawable.ScalingUtils.ScaleType.FIT_XY);
    }

    private boolean hasScaleTypeDrawableAtIndex(int i) {
        return getParentDrawableAtIndex(i) instanceof com.facebook.drawee.drawable.ScaleTypeDrawable;
    }

    public void setFadeDuration(int i) {
        this.mFadeDrawable.setTransitionDuration(i);
    }

    public int getFadeDuration() {
        return this.mFadeDrawable.getTransitionDuration();
    }

    public void setActualImageFocusPoint(android.graphics.PointF pointF) {
        com.facebook.common.internal.Preconditions.checkNotNull(pointF);
        getScaleTypeDrawableAtIndex(2).setFocusPoint(pointF);
    }

    public void setActualImageScaleType(com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        com.facebook.common.internal.Preconditions.checkNotNull(scaleType);
        getScaleTypeDrawableAtIndex(2).setScaleType(scaleType);
    }

    @javax.annotation.Nullable
    public com.facebook.drawee.drawable.ScalingUtils.ScaleType getActualImageScaleType() {
        if (hasScaleTypeDrawableAtIndex(2)) {
            return getScaleTypeDrawableAtIndex(2).getScaleType();
        }
        return null;
    }

    @javax.annotation.Nullable
    public android.graphics.PointF getActualImageFocusPoint() {
        if (hasScaleTypeDrawableAtIndex(2)) {
            return getScaleTypeDrawableAtIndex(2).getFocusPoint();
        }
        return null;
    }

    public void setActualImageColorFilter(@javax.annotation.Nullable android.graphics.ColorFilter colorFilter) {
        this.mActualImageWrapper.setColorFilter(colorFilter);
    }

    public void getActualImageBounds(android.graphics.RectF rectF) {
        this.mActualImageWrapper.getTransformedBounds(rectF);
    }

    public void setPlaceholderImage(@javax.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        setChildDrawableAtIndex(1, drawable);
    }

    public void setPlaceholderImage(android.graphics.drawable.Drawable drawable, com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        setChildDrawableAtIndex(1, drawable);
        getScaleTypeDrawableAtIndex(1).setScaleType(scaleType);
    }

    public boolean hasPlaceholderImage() {
        return this.mFadeDrawable.getDrawable(1) != null;
    }

    public void setPlaceholderImageFocusPoint(android.graphics.PointF pointF) {
        com.facebook.common.internal.Preconditions.checkNotNull(pointF);
        getScaleTypeDrawableAtIndex(1).setFocusPoint(pointF);
    }

    public void setPlaceholderImage(int i) {
        setPlaceholderImage(this.mResources.getDrawable(i));
    }

    public void setPlaceholderImage(int i, com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        setPlaceholderImage(this.mResources.getDrawable(i), scaleType);
    }

    public void setFailureImage(@javax.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        setChildDrawableAtIndex(5, drawable);
    }

    public void setFailureImage(android.graphics.drawable.Drawable drawable, com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        setChildDrawableAtIndex(5, drawable);
        getScaleTypeDrawableAtIndex(5).setScaleType(scaleType);
    }

    public void setFailureImage(int i) {
        setFailureImage(this.mResources.getDrawable(i));
    }

    public void setFailureImage(int i, com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        setFailureImage(this.mResources.getDrawable(i), scaleType);
    }

    public void setRetryImage(@javax.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        setChildDrawableAtIndex(4, drawable);
    }

    public void setRetryImage(android.graphics.drawable.Drawable drawable, com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        setChildDrawableAtIndex(4, drawable);
        getScaleTypeDrawableAtIndex(4).setScaleType(scaleType);
    }

    public void setRetryImage(int i) {
        setRetryImage(this.mResources.getDrawable(i));
    }

    public void setRetryImage(int i, com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        setRetryImage(this.mResources.getDrawable(i), scaleType);
    }

    public void setProgressBarImage(@javax.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        setChildDrawableAtIndex(3, drawable);
    }

    public void setProgressBarImage(android.graphics.drawable.Drawable drawable, com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        setChildDrawableAtIndex(3, drawable);
        getScaleTypeDrawableAtIndex(3).setScaleType(scaleType);
    }

    public void setProgressBarImage(int i) {
        setProgressBarImage(this.mResources.getDrawable(i));
    }

    public void setProgressBarImage(int i, com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        setProgressBarImage(this.mResources.getDrawable(i), scaleType);
    }

    public void setBackgroundImage(@javax.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        setChildDrawableAtIndex(0, drawable);
    }

    public void setOverlayImage(int i, @javax.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        com.facebook.common.internal.Preconditions.checkArgument(i >= 0 && i + 6 < this.mFadeDrawable.getNumberOfLayers(), "The given index does not correspond to an overlay image.");
        setChildDrawableAtIndex(i + 6, drawable);
    }

    public void setOverlayImage(@javax.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        setOverlayImage(0, drawable);
    }

    public void setRoundingParams(@javax.annotation.Nullable com.facebook.drawee.generic.RoundingParams roundingParams) {
        this.mRoundingParams = roundingParams;
        com.facebook.drawee.generic.WrappingUtils.updateOverlayColorRounding(this.mTopLevelDrawable, roundingParams);
        for (int i = 0; i < this.mFadeDrawable.getNumberOfLayers(); i++) {
            com.facebook.drawee.generic.WrappingUtils.updateLeafRounding(getParentDrawableAtIndex(i), this.mRoundingParams, this.mResources);
        }
    }

    @javax.annotation.Nullable
    public com.facebook.drawee.generic.RoundingParams getRoundingParams() {
        return this.mRoundingParams;
    }

    public boolean hasImage() {
        return this.mActualImageWrapper.getDrawable() != this.mEmptyActualImageDrawable;
    }

    public void setOnFadeListener(com.facebook.fresco.ui.common.OnFadeListener onFadeListener) {
        this.mFadeDrawable.setOnFadeListener(onFadeListener);
    }
}
