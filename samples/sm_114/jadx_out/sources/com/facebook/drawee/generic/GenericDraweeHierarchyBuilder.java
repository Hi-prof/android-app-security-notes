package com.facebook.drawee.generic;

/* JADX INFO: loaded from: classes.dex */
public class GenericDraweeHierarchyBuilder {
    public static final int DEFAULT_FADE_DURATION = 300;

    @javax.annotation.Nullable
    private android.graphics.ColorFilter mActualImageColorFilter;

    @javax.annotation.Nullable
    private android.graphics.PointF mActualImageFocusPoint;

    @javax.annotation.Nullable
    private android.graphics.Matrix mActualImageMatrix;

    @javax.annotation.Nullable
    private com.facebook.drawee.drawable.ScalingUtils.ScaleType mActualImageScaleType;

    @javax.annotation.Nullable
    private android.graphics.drawable.Drawable mBackground;
    private float mDesiredAspectRatio;
    private int mFadeDuration;

    @javax.annotation.Nullable
    private android.graphics.drawable.Drawable mFailureImage;

    @javax.annotation.Nullable
    private com.facebook.drawee.drawable.ScalingUtils.ScaleType mFailureImageScaleType;

    @javax.annotation.Nullable
    private java.util.List<android.graphics.drawable.Drawable> mOverlays;

    @javax.annotation.Nullable
    private android.graphics.drawable.Drawable mPlaceholderImage;

    @javax.annotation.Nullable
    private com.facebook.drawee.drawable.ScalingUtils.ScaleType mPlaceholderImageScaleType;

    @javax.annotation.Nullable
    private android.graphics.drawable.Drawable mPressedStateOverlay;

    @javax.annotation.Nullable
    private android.graphics.drawable.Drawable mProgressBarImage;

    @javax.annotation.Nullable
    private com.facebook.drawee.drawable.ScalingUtils.ScaleType mProgressBarImageScaleType;
    private android.content.res.Resources mResources;

    @javax.annotation.Nullable
    private android.graphics.drawable.Drawable mRetryImage;

    @javax.annotation.Nullable
    private com.facebook.drawee.drawable.ScalingUtils.ScaleType mRetryImageScaleType;

    @javax.annotation.Nullable
    private com.facebook.drawee.generic.RoundingParams mRoundingParams;
    public static final com.facebook.drawee.drawable.ScalingUtils.ScaleType DEFAULT_SCALE_TYPE = com.facebook.drawee.drawable.ScalingUtils.ScaleType.CENTER_INSIDE;
    public static final com.facebook.drawee.drawable.ScalingUtils.ScaleType DEFAULT_ACTUAL_IMAGE_SCALE_TYPE = com.facebook.drawee.drawable.ScalingUtils.ScaleType.CENTER_CROP;

    public GenericDraweeHierarchyBuilder(android.content.res.Resources resources) {
        this.mResources = resources;
        init();
    }

    public static com.facebook.drawee.generic.GenericDraweeHierarchyBuilder newInstance(android.content.res.Resources resources) {
        return new com.facebook.drawee.generic.GenericDraweeHierarchyBuilder(resources);
    }

    private void init() {
        this.mFadeDuration = 300;
        this.mDesiredAspectRatio = 0.0f;
        this.mPlaceholderImage = null;
        com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType = DEFAULT_SCALE_TYPE;
        this.mPlaceholderImageScaleType = scaleType;
        this.mRetryImage = null;
        this.mRetryImageScaleType = scaleType;
        this.mFailureImage = null;
        this.mFailureImageScaleType = scaleType;
        this.mProgressBarImage = null;
        this.mProgressBarImageScaleType = scaleType;
        this.mActualImageScaleType = DEFAULT_ACTUAL_IMAGE_SCALE_TYPE;
        this.mActualImageMatrix = null;
        this.mActualImageFocusPoint = null;
        this.mActualImageColorFilter = null;
        this.mBackground = null;
        this.mOverlays = null;
        this.mPressedStateOverlay = null;
        this.mRoundingParams = null;
    }

    public com.facebook.drawee.generic.GenericDraweeHierarchyBuilder reset() {
        init();
        return this;
    }

    public android.content.res.Resources getResources() {
        return this.mResources;
    }

    public com.facebook.drawee.generic.GenericDraweeHierarchyBuilder setFadeDuration(int i) {
        this.mFadeDuration = i;
        return this;
    }

    public int getFadeDuration() {
        return this.mFadeDuration;
    }

    public com.facebook.drawee.generic.GenericDraweeHierarchyBuilder setDesiredAspectRatio(float f) {
        this.mDesiredAspectRatio = f;
        return this;
    }

    public float getDesiredAspectRatio() {
        return this.mDesiredAspectRatio;
    }

    public com.facebook.drawee.generic.GenericDraweeHierarchyBuilder setPlaceholderImage(@javax.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        this.mPlaceholderImage = drawable;
        return this;
    }

    public com.facebook.drawee.generic.GenericDraweeHierarchyBuilder setPlaceholderImage(int i) {
        this.mPlaceholderImage = this.mResources.getDrawable(i);
        return this;
    }

    @javax.annotation.Nullable
    public android.graphics.drawable.Drawable getPlaceholderImage() {
        return this.mPlaceholderImage;
    }

    public com.facebook.drawee.generic.GenericDraweeHierarchyBuilder setPlaceholderImageScaleType(@javax.annotation.Nullable com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        this.mPlaceholderImageScaleType = scaleType;
        return this;
    }

    @javax.annotation.Nullable
    public com.facebook.drawee.drawable.ScalingUtils.ScaleType getPlaceholderImageScaleType() {
        return this.mPlaceholderImageScaleType;
    }

    public com.facebook.drawee.generic.GenericDraweeHierarchyBuilder setPlaceholderImage(android.graphics.drawable.Drawable drawable, @javax.annotation.Nullable com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        this.mPlaceholderImage = drawable;
        this.mPlaceholderImageScaleType = scaleType;
        return this;
    }

    public com.facebook.drawee.generic.GenericDraweeHierarchyBuilder setPlaceholderImage(int i, @javax.annotation.Nullable com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        this.mPlaceholderImage = this.mResources.getDrawable(i);
        this.mPlaceholderImageScaleType = scaleType;
        return this;
    }

    public com.facebook.drawee.generic.GenericDraweeHierarchyBuilder setRetryImage(@javax.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        this.mRetryImage = drawable;
        return this;
    }

    public com.facebook.drawee.generic.GenericDraweeHierarchyBuilder setRetryImage(int i) {
        this.mRetryImage = this.mResources.getDrawable(i);
        return this;
    }

    @javax.annotation.Nullable
    public android.graphics.drawable.Drawable getRetryImage() {
        return this.mRetryImage;
    }

    public com.facebook.drawee.generic.GenericDraweeHierarchyBuilder setRetryImageScaleType(@javax.annotation.Nullable com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        this.mRetryImageScaleType = scaleType;
        return this;
    }

    @javax.annotation.Nullable
    public com.facebook.drawee.drawable.ScalingUtils.ScaleType getRetryImageScaleType() {
        return this.mRetryImageScaleType;
    }

    public com.facebook.drawee.generic.GenericDraweeHierarchyBuilder setRetryImage(android.graphics.drawable.Drawable drawable, @javax.annotation.Nullable com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        this.mRetryImage = drawable;
        this.mRetryImageScaleType = scaleType;
        return this;
    }

    public com.facebook.drawee.generic.GenericDraweeHierarchyBuilder setRetryImage(int i, @javax.annotation.Nullable com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        this.mRetryImage = this.mResources.getDrawable(i);
        this.mRetryImageScaleType = scaleType;
        return this;
    }

    public com.facebook.drawee.generic.GenericDraweeHierarchyBuilder setFailureImage(@javax.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        this.mFailureImage = drawable;
        return this;
    }

    public com.facebook.drawee.generic.GenericDraweeHierarchyBuilder setFailureImage(int i) {
        this.mFailureImage = this.mResources.getDrawable(i);
        return this;
    }

    @javax.annotation.Nullable
    public android.graphics.drawable.Drawable getFailureImage() {
        return this.mFailureImage;
    }

    public com.facebook.drawee.generic.GenericDraweeHierarchyBuilder setFailureImageScaleType(@javax.annotation.Nullable com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        this.mFailureImageScaleType = scaleType;
        return this;
    }

    @javax.annotation.Nullable
    public com.facebook.drawee.drawable.ScalingUtils.ScaleType getFailureImageScaleType() {
        return this.mFailureImageScaleType;
    }

    public com.facebook.drawee.generic.GenericDraweeHierarchyBuilder setFailureImage(android.graphics.drawable.Drawable drawable, @javax.annotation.Nullable com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        this.mFailureImage = drawable;
        this.mFailureImageScaleType = scaleType;
        return this;
    }

    public com.facebook.drawee.generic.GenericDraweeHierarchyBuilder setFailureImage(int i, @javax.annotation.Nullable com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        this.mFailureImage = this.mResources.getDrawable(i);
        this.mFailureImageScaleType = scaleType;
        return this;
    }

    public com.facebook.drawee.generic.GenericDraweeHierarchyBuilder setProgressBarImage(@javax.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        this.mProgressBarImage = drawable;
        return this;
    }

    public com.facebook.drawee.generic.GenericDraweeHierarchyBuilder setProgressBarImage(int i) {
        this.mProgressBarImage = this.mResources.getDrawable(i);
        return this;
    }

    @javax.annotation.Nullable
    public android.graphics.drawable.Drawable getProgressBarImage() {
        return this.mProgressBarImage;
    }

    public com.facebook.drawee.generic.GenericDraweeHierarchyBuilder setProgressBarImageScaleType(@javax.annotation.Nullable com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        this.mProgressBarImageScaleType = scaleType;
        return this;
    }

    @javax.annotation.Nullable
    public com.facebook.drawee.drawable.ScalingUtils.ScaleType getProgressBarImageScaleType() {
        return this.mProgressBarImageScaleType;
    }

    public com.facebook.drawee.generic.GenericDraweeHierarchyBuilder setProgressBarImage(android.graphics.drawable.Drawable drawable, @javax.annotation.Nullable com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        this.mProgressBarImage = drawable;
        this.mProgressBarImageScaleType = scaleType;
        return this;
    }

    public com.facebook.drawee.generic.GenericDraweeHierarchyBuilder setProgressBarImage(int i, @javax.annotation.Nullable com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        this.mProgressBarImage = this.mResources.getDrawable(i);
        this.mProgressBarImageScaleType = scaleType;
        return this;
    }

    public com.facebook.drawee.generic.GenericDraweeHierarchyBuilder setActualImageScaleType(@javax.annotation.Nullable com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        this.mActualImageScaleType = scaleType;
        this.mActualImageMatrix = null;
        return this;
    }

    @javax.annotation.Nullable
    public com.facebook.drawee.drawable.ScalingUtils.ScaleType getActualImageScaleType() {
        return this.mActualImageScaleType;
    }

    public com.facebook.drawee.generic.GenericDraweeHierarchyBuilder setActualImageFocusPoint(@javax.annotation.Nullable android.graphics.PointF pointF) {
        this.mActualImageFocusPoint = pointF;
        return this;
    }

    @javax.annotation.Nullable
    public android.graphics.PointF getActualImageFocusPoint() {
        return this.mActualImageFocusPoint;
    }

    public com.facebook.drawee.generic.GenericDraweeHierarchyBuilder setActualImageColorFilter(@javax.annotation.Nullable android.graphics.ColorFilter colorFilter) {
        this.mActualImageColorFilter = colorFilter;
        return this;
    }

    @javax.annotation.Nullable
    public android.graphics.ColorFilter getActualImageColorFilter() {
        return this.mActualImageColorFilter;
    }

    public com.facebook.drawee.generic.GenericDraweeHierarchyBuilder setBackground(@javax.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        this.mBackground = drawable;
        return this;
    }

    @javax.annotation.Nullable
    public android.graphics.drawable.Drawable getBackground() {
        return this.mBackground;
    }

    public com.facebook.drawee.generic.GenericDraweeHierarchyBuilder setOverlays(@javax.annotation.Nullable java.util.List<android.graphics.drawable.Drawable> list) {
        this.mOverlays = list;
        return this;
    }

    public com.facebook.drawee.generic.GenericDraweeHierarchyBuilder setOverlay(@javax.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        if (drawable == null) {
            this.mOverlays = null;
            return this;
        }
        this.mOverlays = java.util.Arrays.asList(drawable);
        return this;
    }

    @javax.annotation.Nullable
    public java.util.List<android.graphics.drawable.Drawable> getOverlays() {
        return this.mOverlays;
    }

    public com.facebook.drawee.generic.GenericDraweeHierarchyBuilder setPressedStateOverlay(@javax.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        if (drawable == null) {
            this.mPressedStateOverlay = null;
            return this;
        }
        android.graphics.drawable.StateListDrawable stateListDrawable = new android.graphics.drawable.StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, drawable);
        this.mPressedStateOverlay = stateListDrawable;
        return this;
    }

    @javax.annotation.Nullable
    public android.graphics.drawable.Drawable getPressedStateOverlay() {
        return this.mPressedStateOverlay;
    }

    public com.facebook.drawee.generic.GenericDraweeHierarchyBuilder setRoundingParams(@javax.annotation.Nullable com.facebook.drawee.generic.RoundingParams roundingParams) {
        this.mRoundingParams = roundingParams;
        return this;
    }

    @javax.annotation.Nullable
    public com.facebook.drawee.generic.RoundingParams getRoundingParams() {
        return this.mRoundingParams;
    }

    private void validate() {
        java.util.List<android.graphics.drawable.Drawable> list = this.mOverlays;
        if (list != null) {
            java.util.Iterator<android.graphics.drawable.Drawable> it = list.iterator();
            while (it.hasNext()) {
                com.facebook.common.internal.Preconditions.checkNotNull(it.next());
            }
        }
    }

    public com.facebook.drawee.generic.GenericDraweeHierarchy build() {
        validate();
        return new com.facebook.drawee.generic.GenericDraweeHierarchy(this);
    }
}
