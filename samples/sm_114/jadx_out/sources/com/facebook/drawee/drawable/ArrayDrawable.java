package com.facebook.drawee.drawable;

/* JADX INFO: loaded from: classes.dex */
public class ArrayDrawable extends android.graphics.drawable.Drawable implements android.graphics.drawable.Drawable.Callback, com.facebook.drawee.drawable.TransformCallback, com.facebook.drawee.drawable.TransformAwareDrawable {
    private final com.facebook.drawee.drawable.DrawableParent[] mDrawableParents;
    private final android.graphics.drawable.Drawable[] mLayers;

    @javax.annotation.Nullable
    private com.facebook.drawee.drawable.TransformCallback mTransformCallback;
    private final com.facebook.drawee.drawable.DrawableProperties mDrawableProperties = new com.facebook.drawee.drawable.DrawableProperties();
    private final android.graphics.Rect mTmpRect = new android.graphics.Rect();
    private boolean mIsStateful = false;
    private boolean mIsStatefulCalculated = false;
    private boolean mIsMutated = false;

    public ArrayDrawable(android.graphics.drawable.Drawable[] drawableArr) {
        int i = 0;
        com.facebook.common.internal.Preconditions.checkNotNull(drawableArr);
        this.mLayers = drawableArr;
        while (true) {
            android.graphics.drawable.Drawable[] drawableArr2 = this.mLayers;
            if (i < drawableArr2.length) {
                com.facebook.drawee.drawable.DrawableUtils.setCallbacks(drawableArr2[i], this, this);
                i++;
            } else {
                this.mDrawableParents = new com.facebook.drawee.drawable.DrawableParent[drawableArr2.length];
                return;
            }
        }
    }

    public int getNumberOfLayers() {
        return this.mLayers.length;
    }

    @javax.annotation.Nullable
    public android.graphics.drawable.Drawable getDrawable(int i) {
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(i >= 0));
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(i < this.mLayers.length));
        return this.mLayers[i];
    }

    @javax.annotation.Nullable
    public android.graphics.drawable.Drawable setDrawable(int i, @javax.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(i >= 0));
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(i < this.mLayers.length));
        android.graphics.drawable.Drawable drawable2 = this.mLayers[i];
        if (drawable != drawable2) {
            if (drawable != null && this.mIsMutated) {
                drawable.mutate();
            }
            com.facebook.drawee.drawable.DrawableUtils.setCallbacks(this.mLayers[i], null, null);
            com.facebook.drawee.drawable.DrawableUtils.setCallbacks(drawable, null, null);
            com.facebook.drawee.drawable.DrawableUtils.setDrawableProperties(drawable, this.mDrawableProperties);
            com.facebook.drawee.drawable.DrawableUtils.copyProperties(drawable, this);
            com.facebook.drawee.drawable.DrawableUtils.setCallbacks(drawable, this, this);
            this.mIsStatefulCalculated = false;
            this.mLayers[i] = drawable;
            invalidateSelf();
        }
        return drawable2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i = 0;
        int iMax = -1;
        while (true) {
            android.graphics.drawable.Drawable[] drawableArr = this.mLayers;
            if (i >= drawableArr.length) {
                break;
            }
            android.graphics.drawable.Drawable drawable = drawableArr[i];
            if (drawable != null) {
                iMax = java.lang.Math.max(iMax, drawable.getIntrinsicWidth());
            }
            i++;
        }
        if (iMax > 0) {
            return iMax;
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        int i = 0;
        int iMax = -1;
        while (true) {
            android.graphics.drawable.Drawable[] drawableArr = this.mLayers;
            if (i >= drawableArr.length) {
                break;
            }
            android.graphics.drawable.Drawable drawable = drawableArr[i];
            if (drawable != null) {
                iMax = java.lang.Math.max(iMax, drawable.getIntrinsicHeight());
            }
            i++;
        }
        if (iMax > 0) {
            return iMax;
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(android.graphics.Rect rect) {
        int i = 0;
        while (true) {
            android.graphics.drawable.Drawable[] drawableArr = this.mLayers;
            if (i >= drawableArr.length) {
                return;
            }
            android.graphics.drawable.Drawable drawable = drawableArr[i];
            if (drawable != null) {
                drawable.setBounds(rect);
            }
            i++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (!this.mIsStatefulCalculated) {
            this.mIsStateful = false;
            int i = 0;
            while (true) {
                android.graphics.drawable.Drawable[] drawableArr = this.mLayers;
                boolean z = true;
                if (i >= drawableArr.length) {
                    break;
                }
                android.graphics.drawable.Drawable drawable = drawableArr[i];
                boolean z2 = this.mIsStateful;
                if (drawable == null || !drawable.isStateful()) {
                    z = false;
                }
                this.mIsStateful = z2 | z;
                i++;
            }
            this.mIsStatefulCalculated = true;
        }
        return this.mIsStateful;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int i = 0;
        boolean z = false;
        while (true) {
            android.graphics.drawable.Drawable[] drawableArr = this.mLayers;
            if (i >= drawableArr.length) {
                return z;
            }
            android.graphics.drawable.Drawable drawable = drawableArr[i];
            if (drawable != null && drawable.setState(iArr)) {
                z = true;
            }
            i++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        int i2 = 0;
        boolean z = false;
        while (true) {
            android.graphics.drawable.Drawable[] drawableArr = this.mLayers;
            if (i2 >= drawableArr.length) {
                return z;
            }
            android.graphics.drawable.Drawable drawable = drawableArr[i2];
            if (drawable != null && drawable.setLevel(i)) {
                z = true;
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        int i = 0;
        while (true) {
            android.graphics.drawable.Drawable[] drawableArr = this.mLayers;
            if (i >= drawableArr.length) {
                return;
            }
            android.graphics.drawable.Drawable drawable = drawableArr[i];
            if (drawable != null) {
                drawable.draw(canvas);
            }
            i++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(android.graphics.Rect rect) {
        int i = 0;
        rect.left = 0;
        rect.top = 0;
        rect.right = 0;
        rect.bottom = 0;
        android.graphics.Rect rect2 = this.mTmpRect;
        while (true) {
            android.graphics.drawable.Drawable[] drawableArr = this.mLayers;
            if (i >= drawableArr.length) {
                return true;
            }
            android.graphics.drawable.Drawable drawable = drawableArr[i];
            if (drawable != null) {
                drawable.getPadding(rect2);
                rect.left = java.lang.Math.max(rect.left, rect2.left);
                rect.top = java.lang.Math.max(rect.top, rect2.top);
                rect.right = java.lang.Math.max(rect.right, rect2.right);
                rect.bottom = java.lang.Math.max(rect.bottom, rect2.bottom);
            }
            i++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public android.graphics.drawable.Drawable mutate() {
        int i = 0;
        while (true) {
            android.graphics.drawable.Drawable[] drawableArr = this.mLayers;
            if (i < drawableArr.length) {
                android.graphics.drawable.Drawable drawable = drawableArr[i];
                if (drawable != null) {
                    drawable.mutate();
                }
                i++;
            } else {
                this.mIsMutated = true;
                return this;
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.mLayers.length == 0) {
            return -2;
        }
        int i = 1;
        int iResolveOpacity = -1;
        while (true) {
            android.graphics.drawable.Drawable[] drawableArr = this.mLayers;
            if (i >= drawableArr.length) {
                return iResolveOpacity;
            }
            android.graphics.drawable.Drawable drawable = drawableArr[i];
            if (drawable != null) {
                iResolveOpacity = android.graphics.drawable.Drawable.resolveOpacity(iResolveOpacity, drawable.getOpacity());
            }
            i++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mDrawableProperties.setAlpha(i);
        int i2 = 0;
        while (true) {
            android.graphics.drawable.Drawable[] drawableArr = this.mLayers;
            if (i2 >= drawableArr.length) {
                return;
            }
            android.graphics.drawable.Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.setAlpha(i);
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
        this.mDrawableProperties.setColorFilter(colorFilter);
        int i = 0;
        while (true) {
            android.graphics.drawable.Drawable[] drawableArr = this.mLayers;
            if (i >= drawableArr.length) {
                return;
            }
            android.graphics.drawable.Drawable drawable = drawableArr[i];
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
            i++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.mDrawableProperties.setDither(z);
        int i = 0;
        while (true) {
            android.graphics.drawable.Drawable[] drawableArr = this.mLayers;
            if (i >= drawableArr.length) {
                return;
            }
            android.graphics.drawable.Drawable drawable = drawableArr[i];
            if (drawable != null) {
                drawable.setDither(z);
            }
            i++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.mDrawableProperties.setFilterBitmap(z);
        int i = 0;
        while (true) {
            android.graphics.drawable.Drawable[] drawableArr = this.mLayers;
            if (i >= drawableArr.length) {
                return;
            }
            android.graphics.drawable.Drawable drawable = drawableArr[i];
            if (drawable != null) {
                drawable.setFilterBitmap(z);
            }
            i++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        int i = 0;
        while (true) {
            android.graphics.drawable.Drawable[] drawableArr = this.mLayers;
            if (i >= drawableArr.length) {
                return visible;
            }
            android.graphics.drawable.Drawable drawable = drawableArr[i];
            if (drawable != null) {
                drawable.setVisible(z, z2);
            }
            i++;
        }
    }

    public com.facebook.drawee.drawable.DrawableParent getDrawableParentForIndex(int i) {
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(i >= 0));
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(i < this.mDrawableParents.length));
        com.facebook.drawee.drawable.DrawableParent[] drawableParentArr = this.mDrawableParents;
        if (drawableParentArr[i] == null) {
            drawableParentArr[i] = createDrawableParentForIndex(i);
        }
        return this.mDrawableParents[i];
    }

    private com.facebook.drawee.drawable.DrawableParent createDrawableParentForIndex(final int i) {
        return new com.facebook.drawee.drawable.DrawableParent() { // from class: com.facebook.drawee.drawable.ArrayDrawable.1
            @Override // com.facebook.drawee.drawable.DrawableParent
            @javax.annotation.Nullable
            public android.graphics.drawable.Drawable setDrawable(@javax.annotation.Nullable android.graphics.drawable.Drawable drawable) {
                return com.facebook.drawee.drawable.ArrayDrawable.this.setDrawable(i, drawable);
            }

            @Override // com.facebook.drawee.drawable.DrawableParent
            @javax.annotation.Nullable
            public android.graphics.drawable.Drawable getDrawable() {
                return com.facebook.drawee.drawable.ArrayDrawable.this.getDrawable(i);
            }
        };
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

    @Override // com.facebook.drawee.drawable.TransformCallback
    public void getTransform(android.graphics.Matrix matrix) {
        com.facebook.drawee.drawable.TransformCallback transformCallback = this.mTransformCallback;
        if (transformCallback != null) {
            transformCallback.getTransform(matrix);
        } else {
            matrix.reset();
        }
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

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        int i = 0;
        while (true) {
            android.graphics.drawable.Drawable[] drawableArr = this.mLayers;
            if (i >= drawableArr.length) {
                return;
            }
            android.graphics.drawable.Drawable drawable = drawableArr[i];
            if (drawable != null) {
                drawable.setHotspot(f, f2);
            }
            i++;
        }
    }
}
