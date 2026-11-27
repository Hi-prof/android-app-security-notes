package com.facebook.drawee.drawable;

/* JADX INFO: loaded from: classes.dex */
public class ForwardingDrawable extends android.graphics.drawable.Drawable implements android.graphics.drawable.Drawable.Callback, com.facebook.drawee.drawable.TransformCallback, com.facebook.drawee.drawable.TransformAwareDrawable, com.facebook.drawee.drawable.DrawableParent {
    private static final android.graphics.Matrix sTempTransform = new android.graphics.Matrix();

    @javax.annotation.Nullable
    private android.graphics.drawable.Drawable mCurrentDelegate;
    private final com.facebook.drawee.drawable.DrawableProperties mDrawableProperties = new com.facebook.drawee.drawable.DrawableProperties();

    @javax.annotation.Nullable
    protected com.facebook.drawee.drawable.TransformCallback mTransformCallback;

    public ForwardingDrawable(@javax.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        this.mCurrentDelegate = drawable;
        com.facebook.drawee.drawable.DrawableUtils.setCallbacks(drawable, this, this);
    }

    @javax.annotation.Nullable
    public android.graphics.drawable.Drawable setCurrent(@javax.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        android.graphics.drawable.Drawable currentWithoutInvalidate = setCurrentWithoutInvalidate(drawable);
        invalidateSelf();
        return currentWithoutInvalidate;
    }

    @javax.annotation.Nullable
    protected android.graphics.drawable.Drawable setCurrentWithoutInvalidate(@javax.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        android.graphics.drawable.Drawable drawable2 = this.mCurrentDelegate;
        com.facebook.drawee.drawable.DrawableUtils.setCallbacks(drawable2, null, null);
        com.facebook.drawee.drawable.DrawableUtils.setCallbacks(drawable, null, null);
        com.facebook.drawee.drawable.DrawableUtils.setDrawableProperties(drawable, this.mDrawableProperties);
        com.facebook.drawee.drawable.DrawableUtils.copyProperties(drawable, this);
        com.facebook.drawee.drawable.DrawableUtils.setCallbacks(drawable, this, this);
        this.mCurrentDelegate = drawable;
        return drawable2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        android.graphics.drawable.Drawable drawable = this.mCurrentDelegate;
        if (drawable == null) {
            return 0;
        }
        return drawable.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mDrawableProperties.setAlpha(i);
        android.graphics.drawable.Drawable drawable = this.mCurrentDelegate;
        if (drawable != null) {
            drawable.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@javax.annotation.Nullable android.graphics.ColorFilter colorFilter) {
        this.mDrawableProperties.setColorFilter(colorFilter);
        android.graphics.drawable.Drawable drawable = this.mCurrentDelegate;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.mDrawableProperties.setDither(z);
        android.graphics.drawable.Drawable drawable = this.mCurrentDelegate;
        if (drawable != null) {
            drawable.setDither(z);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.mDrawableProperties.setFilterBitmap(z);
        android.graphics.drawable.Drawable drawable = this.mCurrentDelegate;
        if (drawable != null) {
            drawable.setFilterBitmap(z);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        android.graphics.drawable.Drawable drawable = this.mCurrentDelegate;
        return drawable == null ? visible : drawable.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(android.graphics.Rect rect) {
        android.graphics.drawable.Drawable drawable = this.mCurrentDelegate;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @javax.annotation.Nullable
    public android.graphics.drawable.Drawable.ConstantState getConstantState() {
        android.graphics.drawable.Drawable drawable = this.mCurrentDelegate;
        if (drawable == null) {
            return super.getConstantState();
        }
        return drawable.getConstantState();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        android.graphics.drawable.Drawable drawable = this.mCurrentDelegate;
        if (drawable == null) {
            return false;
        }
        return drawable.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        android.graphics.drawable.Drawable drawable = this.mCurrentDelegate;
        if (drawable == null) {
            return super.onStateChange(iArr);
        }
        return drawable.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        android.graphics.drawable.Drawable drawable = this.mCurrentDelegate;
        if (drawable == null) {
            return super.onLevelChange(i);
        }
        return drawable.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        android.graphics.drawable.Drawable drawable = this.mCurrentDelegate;
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        android.graphics.drawable.Drawable drawable = this.mCurrentDelegate;
        if (drawable == null) {
            return super.getIntrinsicWidth();
        }
        return drawable.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        android.graphics.drawable.Drawable drawable = this.mCurrentDelegate;
        if (drawable == null) {
            return super.getIntrinsicHeight();
        }
        return drawable.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(android.graphics.Rect rect) {
        android.graphics.drawable.Drawable drawable = this.mCurrentDelegate;
        if (drawable == null) {
            return super.getPadding(rect);
        }
        return drawable.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public android.graphics.drawable.Drawable mutate() {
        android.graphics.drawable.Drawable drawable = this.mCurrentDelegate;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    @javax.annotation.Nullable
    public android.graphics.drawable.Drawable getCurrent() {
        return this.mCurrentDelegate;
    }

    @Override // com.facebook.drawee.drawable.DrawableParent
    @javax.annotation.Nullable
    public android.graphics.drawable.Drawable setDrawable(@javax.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        return setCurrent(drawable);
    }

    @Override // com.facebook.drawee.drawable.DrawableParent
    @javax.annotation.Nullable
    public android.graphics.drawable.Drawable getDrawable() {
        return getCurrent();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(android.graphics.drawable.Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(android.graphics.drawable.Drawable drawable, java.lang.Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(android.graphics.drawable.Drawable drawable, java.lang.Runnable runnable) {
        unscheduleSelf(runnable);
    }

    @Override // com.facebook.drawee.drawable.TransformAwareDrawable
    public void setTransformCallback(@javax.annotation.Nullable com.facebook.drawee.drawable.TransformCallback transformCallback) {
        this.mTransformCallback = transformCallback;
    }

    protected void getParentTransform(android.graphics.Matrix matrix) {
        com.facebook.drawee.drawable.TransformCallback transformCallback = this.mTransformCallback;
        if (transformCallback != null) {
            transformCallback.getTransform(matrix);
        } else {
            matrix.reset();
        }
    }

    @Override // com.facebook.drawee.drawable.TransformCallback
    public void getTransform(android.graphics.Matrix matrix) {
        getParentTransform(matrix);
    }

    @Override // com.facebook.drawee.drawable.TransformCallback
    public void getRootBounds(android.graphics.RectF rectF) {
        com.facebook.drawee.drawable.TransformCallback transformCallback = this.mTransformCallback;
        if (transformCallback != null) {
            transformCallback.getRootBounds(rectF);
        } else {
            rectF.set(getBounds());
        }
    }

    public void getTransformedBounds(android.graphics.RectF rectF) {
        android.graphics.Matrix matrix = sTempTransform;
        getParentTransform(matrix);
        rectF.set(getBounds());
        matrix.mapRect(rectF);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        android.graphics.drawable.Drawable drawable = this.mCurrentDelegate;
        if (drawable != null) {
            drawable.setHotspot(f, f2);
        }
    }
}
