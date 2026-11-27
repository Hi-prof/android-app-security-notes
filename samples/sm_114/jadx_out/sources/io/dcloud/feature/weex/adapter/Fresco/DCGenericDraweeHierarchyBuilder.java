package io.dcloud.feature.weex.adapter.Fresco;

/* JADX INFO: loaded from: classes2.dex */
public class DCGenericDraweeHierarchyBuilder {
    public static final int DEFAULT_FADE_DURATION = 300;
    private android.graphics.ColorFilter mActualImageColorFilter;
    private android.graphics.PointF mActualImageFocusPoint;
    private android.graphics.Matrix mActualImageMatrix;
    private com.facebook.drawee.drawable.ScalingUtils.ScaleType mActualImageScaleType;
    private android.graphics.drawable.Drawable mBackground;
    private float mDesiredAspectRatio;
    private int mFadeDuration;
    private android.graphics.drawable.Drawable mFailureImage;
    private com.facebook.drawee.drawable.ScalingUtils.ScaleType mFailureImageScaleType;
    private java.util.List<android.graphics.drawable.Drawable> mOverlays;
    private android.graphics.drawable.Drawable mPlaceholderImage;
    private com.facebook.drawee.drawable.ScalingUtils.ScaleType mPlaceholderImageScaleType;
    private android.graphics.drawable.Drawable mPressedStateOverlay;
    private android.graphics.drawable.Drawable mProgressBarImage;
    private com.facebook.drawee.drawable.ScalingUtils.ScaleType mProgressBarImageScaleType;
    private android.content.res.Resources mResources;
    private android.graphics.drawable.Drawable mRetryImage;
    private com.facebook.drawee.drawable.ScalingUtils.ScaleType mRetryImageScaleType;
    private com.facebook.drawee.generic.RoundingParams mRoundingParams;
    public static final com.facebook.drawee.drawable.ScalingUtils.ScaleType DEFAULT_SCALE_TYPE = com.facebook.drawee.drawable.ScalingUtils.ScaleType.CENTER_INSIDE;
    public static final com.facebook.drawee.drawable.ScalingUtils.ScaleType DEFAULT_ACTUAL_IMAGE_SCALE_TYPE = com.facebook.drawee.drawable.ScalingUtils.ScaleType.CENTER_CROP;

    public DCGenericDraweeHierarchyBuilder(android.content.res.Resources resources) {
        this.mResources = resources;
        init();
    }

    public static io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder newInstance(android.content.res.Resources resources) {
        return new io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder(resources);
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

    public io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder reset() {
        init();
        return this;
    }

    public android.content.res.Resources getResources() {
        return this.mResources;
    }

    public io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder setFadeDuration(int i) {
        this.mFadeDuration = i;
        return this;
    }

    public int getFadeDuration() {
        return this.mFadeDuration;
    }

    public io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder setDesiredAspectRatio(float f) {
        this.mDesiredAspectRatio = f;
        return this;
    }

    public float getDesiredAspectRatio() {
        return this.mDesiredAspectRatio;
    }

    public io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder setPlaceholderImage(android.graphics.drawable.Drawable drawable) {
        this.mPlaceholderImage = drawable;
        return this;
    }

    public io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder setPlaceholderImage(int i) {
        this.mPlaceholderImage = this.mResources.getDrawable(i);
        return this;
    }

    public android.graphics.drawable.Drawable getPlaceholderImage() {
        return this.mPlaceholderImage;
    }

    public io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder setPlaceholderImageScaleType(com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        this.mPlaceholderImageScaleType = scaleType;
        return this;
    }

    public com.facebook.drawee.drawable.ScalingUtils.ScaleType getPlaceholderImageScaleType() {
        return this.mPlaceholderImageScaleType;
    }

    public io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder setPlaceholderImage(android.graphics.drawable.Drawable drawable, com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        this.mPlaceholderImage = drawable;
        this.mPlaceholderImageScaleType = scaleType;
        return this;
    }

    public io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder setPlaceholderImage(int i, com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        this.mPlaceholderImage = this.mResources.getDrawable(i);
        this.mPlaceholderImageScaleType = scaleType;
        return this;
    }

    public io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder setRetryImage(android.graphics.drawable.Drawable drawable) {
        this.mRetryImage = drawable;
        return this;
    }

    public io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder setRetryImage(int i) {
        this.mRetryImage = this.mResources.getDrawable(i);
        return this;
    }

    public android.graphics.drawable.Drawable getRetryImage() {
        return this.mRetryImage;
    }

    public io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder setRetryImageScaleType(com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        this.mRetryImageScaleType = scaleType;
        return this;
    }

    public com.facebook.drawee.drawable.ScalingUtils.ScaleType getRetryImageScaleType() {
        return this.mRetryImageScaleType;
    }

    public io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder setRetryImage(android.graphics.drawable.Drawable drawable, com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        this.mRetryImage = drawable;
        this.mRetryImageScaleType = scaleType;
        return this;
    }

    public io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder setRetryImage(int i, com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        this.mRetryImage = this.mResources.getDrawable(i);
        this.mRetryImageScaleType = scaleType;
        return this;
    }

    public io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder setFailureImage(android.graphics.drawable.Drawable drawable) {
        this.mFailureImage = drawable;
        return this;
    }

    public io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder setFailureImage(int i) {
        this.mFailureImage = this.mResources.getDrawable(i);
        return this;
    }

    public android.graphics.drawable.Drawable getFailureImage() {
        return this.mFailureImage;
    }

    public io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder setFailureImageScaleType(com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        this.mFailureImageScaleType = scaleType;
        return this;
    }

    public com.facebook.drawee.drawable.ScalingUtils.ScaleType getFailureImageScaleType() {
        return this.mFailureImageScaleType;
    }

    public io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder setFailureImage(android.graphics.drawable.Drawable drawable, com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        this.mFailureImage = drawable;
        this.mFailureImageScaleType = scaleType;
        return this;
    }

    public io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder setFailureImage(int i, com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        this.mFailureImage = this.mResources.getDrawable(i);
        this.mFailureImageScaleType = scaleType;
        return this;
    }

    public io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder setProgressBarImage(android.graphics.drawable.Drawable drawable) {
        this.mProgressBarImage = drawable;
        return this;
    }

    public io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder setProgressBarImage(int i) {
        this.mProgressBarImage = this.mResources.getDrawable(i);
        return this;
    }

    public android.graphics.drawable.Drawable getProgressBarImage() {
        return this.mProgressBarImage;
    }

    public io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder setProgressBarImageScaleType(com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        this.mProgressBarImageScaleType = scaleType;
        return this;
    }

    public com.facebook.drawee.drawable.ScalingUtils.ScaleType getProgressBarImageScaleType() {
        return this.mProgressBarImageScaleType;
    }

    public io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder setProgressBarImage(android.graphics.drawable.Drawable drawable, com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        this.mProgressBarImage = drawable;
        this.mProgressBarImageScaleType = scaleType;
        return this;
    }

    public io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder setProgressBarImage(int i, com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        this.mProgressBarImage = this.mResources.getDrawable(i);
        this.mProgressBarImageScaleType = scaleType;
        return this;
    }

    public io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder setActualImageScaleType(com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        this.mActualImageScaleType = scaleType;
        this.mActualImageMatrix = null;
        return this;
    }

    public com.facebook.drawee.drawable.ScalingUtils.ScaleType getActualImageScaleType() {
        return this.mActualImageScaleType;
    }

    public io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder setActualImageFocusPoint(android.graphics.PointF pointF) {
        this.mActualImageFocusPoint = pointF;
        return this;
    }

    public android.graphics.PointF getActualImageFocusPoint() {
        return this.mActualImageFocusPoint;
    }

    public io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder setActualImageColorFilter(android.graphics.ColorFilter colorFilter) {
        this.mActualImageColorFilter = colorFilter;
        return this;
    }

    public android.graphics.ColorFilter getActualImageColorFilter() {
        return this.mActualImageColorFilter;
    }

    public io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder setBackground(android.graphics.drawable.Drawable drawable) {
        this.mBackground = drawable;
        return this;
    }

    public android.graphics.drawable.Drawable getBackground() {
        return this.mBackground;
    }

    public io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder setOverlays(java.util.List<android.graphics.drawable.Drawable> list) {
        this.mOverlays = list;
        return this;
    }

    public io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder setOverlay(android.graphics.drawable.Drawable drawable) {
        if (drawable == null) {
            this.mOverlays = null;
            return this;
        }
        this.mOverlays = java.util.Arrays.asList(drawable);
        return this;
    }

    public java.util.List<android.graphics.drawable.Drawable> getOverlays() {
        return this.mOverlays;
    }

    public io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder setPressedStateOverlay(android.graphics.drawable.Drawable drawable) {
        if (drawable == null) {
            this.mPressedStateOverlay = null;
            return this;
        }
        android.graphics.drawable.StateListDrawable stateListDrawable = new android.graphics.drawable.StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, drawable);
        this.mPressedStateOverlay = stateListDrawable;
        return this;
    }

    public android.graphics.drawable.Drawable getPressedStateOverlay() {
        return this.mPressedStateOverlay;
    }

    public io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchyBuilder setRoundingParams(com.facebook.drawee.generic.RoundingParams roundingParams) {
        this.mRoundingParams = roundingParams;
        return this;
    }

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

    public io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchy build() {
        validate();
        return new io.dcloud.feature.weex.adapter.Fresco.DCGenericDraweeHierarchy(this);
    }
}
