package com.facebook.drawee.drawable;

/* JADX INFO: loaded from: classes.dex */
public class ScaleTypeDrawable extends com.facebook.drawee.drawable.ForwardingDrawable {

    @javax.annotation.Nullable
    android.graphics.Matrix mDrawMatrix;

    @javax.annotation.Nullable
    android.graphics.PointF mFocusPoint;
    com.facebook.drawee.drawable.ScalingUtils.ScaleType mScaleType;

    @javax.annotation.Nullable
    java.lang.Object mScaleTypeState;
    private android.graphics.Matrix mTempMatrix;
    int mUnderlyingHeight;
    int mUnderlyingWidth;

    public ScaleTypeDrawable(@javax.annotation.Nullable android.graphics.drawable.Drawable drawable, com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        super(drawable);
        this.mFocusPoint = null;
        this.mUnderlyingWidth = 0;
        this.mUnderlyingHeight = 0;
        this.mTempMatrix = new android.graphics.Matrix();
        this.mScaleType = scaleType;
    }

    public ScaleTypeDrawable(@javax.annotation.Nullable android.graphics.drawable.Drawable drawable, com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType, @javax.annotation.Nullable android.graphics.PointF pointF) {
        super(drawable);
        this.mFocusPoint = null;
        this.mUnderlyingWidth = 0;
        this.mUnderlyingHeight = 0;
        this.mTempMatrix = new android.graphics.Matrix();
        this.mScaleType = scaleType;
        this.mFocusPoint = pointF;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable
    @javax.annotation.Nullable
    public android.graphics.drawable.Drawable setCurrent(@javax.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        android.graphics.drawable.Drawable current = super.setCurrent(drawable);
        configureBounds();
        return current;
    }

    public com.facebook.drawee.drawable.ScalingUtils.ScaleType getScaleType() {
        return this.mScaleType;
    }

    public void setScaleType(com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        if (com.facebook.common.internal.Objects.equal(this.mScaleType, scaleType)) {
            return;
        }
        this.mScaleType = scaleType;
        this.mScaleTypeState = null;
        configureBounds();
        invalidateSelf();
    }

    @javax.annotation.Nullable
    public android.graphics.PointF getFocusPoint() {
        return this.mFocusPoint;
    }

    public void setFocusPoint(@javax.annotation.Nullable android.graphics.PointF pointF) {
        if (com.facebook.common.internal.Objects.equal(this.mFocusPoint, pointF)) {
            return;
        }
        if (pointF == null) {
            this.mFocusPoint = null;
        } else {
            if (this.mFocusPoint == null) {
                this.mFocusPoint = new android.graphics.PointF();
            }
            this.mFocusPoint.set(pointF);
        }
        configureBounds();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        configureBoundsIfUnderlyingChanged();
        if (this.mDrawMatrix != null) {
            int iSave = canvas.save();
            canvas.clipRect(getBounds());
            canvas.concat(this.mDrawMatrix);
            super.draw(canvas);
            canvas.restoreToCount(iSave);
            return;
        }
        super.draw(canvas);
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(android.graphics.Rect rect) {
        configureBounds();
    }

    private void configureBoundsIfUnderlyingChanged() {
        com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType = this.mScaleType;
        boolean z = false;
        if (scaleType instanceof com.facebook.drawee.drawable.ScalingUtils.StatefulScaleType) {
            java.lang.Object state = ((com.facebook.drawee.drawable.ScalingUtils.StatefulScaleType) scaleType).getState();
            z = state == null || !state.equals(this.mScaleTypeState);
            this.mScaleTypeState = state;
        }
        android.graphics.drawable.Drawable current = getCurrent();
        if (current == null) {
            return;
        }
        if (this.mUnderlyingWidth == current.getIntrinsicWidth() && this.mUnderlyingHeight == current.getIntrinsicHeight() && !z) {
            return;
        }
        configureBounds();
    }

    void configureBounds() {
        android.graphics.drawable.Drawable current = getCurrent();
        if (current == null) {
            this.mUnderlyingHeight = 0;
            this.mUnderlyingWidth = 0;
            this.mDrawMatrix = null;
            return;
        }
        android.graphics.Rect bounds = getBounds();
        int iWidth = bounds.width();
        int iHeight = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.mUnderlyingWidth = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.mUnderlyingHeight = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
            return;
        }
        if (intrinsicWidth == iWidth && intrinsicHeight == iHeight) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
            return;
        }
        if (this.mScaleType == com.facebook.drawee.drawable.ScalingUtils.ScaleType.FIT_XY) {
            current.setBounds(bounds);
            this.mDrawMatrix = null;
            return;
        }
        current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        this.mTempMatrix.reset();
        com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType = this.mScaleType;
        android.graphics.Matrix matrix = this.mTempMatrix;
        android.graphics.PointF pointF = this.mFocusPoint;
        float f = pointF != null ? pointF.x : 0.5f;
        android.graphics.PointF pointF2 = this.mFocusPoint;
        scaleType.getTransform(matrix, bounds, intrinsicWidth, intrinsicHeight, f, pointF2 != null ? pointF2.y : 0.5f);
        this.mDrawMatrix = this.mTempMatrix;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, com.facebook.drawee.drawable.TransformCallback
    public void getTransform(android.graphics.Matrix matrix) {
        getParentTransform(matrix);
        configureBoundsIfUnderlyingChanged();
        android.graphics.Matrix matrix2 = this.mDrawMatrix;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
    }
}
