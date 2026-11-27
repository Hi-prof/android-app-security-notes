package com.facebook.drawee.drawable;

/* JADX INFO: loaded from: classes.dex */
public class RoundedColorDrawable extends android.graphics.drawable.Drawable implements com.facebook.drawee.drawable.Rounded {
    private int mAlpha;
    private int mBorderColor;
    final android.graphics.Path mBorderPath;
    final float[] mBorderRadii;
    private float mBorderWidth;
    private int mColor;

    @javax.annotation.Nullable
    float[] mInsideBorderRadii;
    private boolean mIsCircle;
    private float mPadding;
    final android.graphics.Paint mPaint;
    private boolean mPaintFilterBitmap;
    final android.graphics.Path mPath;
    private final float[] mRadii;
    private boolean mScaleDownInsideBorders;
    private final android.graphics.RectF mTempRect;

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setRepeatEdgePixels(boolean z) {
    }

    public RoundedColorDrawable(int i) {
        this.mRadii = new float[8];
        this.mBorderRadii = new float[8];
        this.mPaint = new android.graphics.Paint(1);
        this.mIsCircle = false;
        this.mBorderWidth = 0.0f;
        this.mPadding = 0.0f;
        this.mBorderColor = 0;
        this.mScaleDownInsideBorders = false;
        this.mPaintFilterBitmap = false;
        this.mPath = new android.graphics.Path();
        this.mBorderPath = new android.graphics.Path();
        this.mColor = 0;
        this.mTempRect = new android.graphics.RectF();
        this.mAlpha = 255;
        setColor(i);
    }

    public static com.facebook.drawee.drawable.RoundedColorDrawable fromColorDrawable(android.graphics.drawable.ColorDrawable colorDrawable) {
        return new com.facebook.drawee.drawable.RoundedColorDrawable(colorDrawable.getColor());
    }

    public RoundedColorDrawable(float[] fArr, int i) {
        this(i);
        setRadii(fArr);
    }

    public RoundedColorDrawable(float f, int i) {
        this(i);
        setRadius(f);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(android.graphics.Rect rect) {
        super.onBoundsChange(rect);
        updatePath();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        this.mPaint.setColor(com.facebook.drawee.drawable.DrawableUtils.multiplyColorAlpha(this.mColor, this.mAlpha));
        this.mPaint.setStyle(android.graphics.Paint.Style.FILL);
        this.mPaint.setFilterBitmap(getPaintFilterBitmap());
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mBorderWidth != 0.0f) {
            this.mPaint.setColor(com.facebook.drawee.drawable.DrawableUtils.multiplyColorAlpha(this.mBorderColor, this.mAlpha));
            this.mPaint.setStyle(android.graphics.Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            canvas.drawPath(this.mBorderPath, this.mPaint);
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setCircle(boolean z) {
        this.mIsCircle = z;
        updatePath();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public boolean isCircle() {
        return this.mIsCircle;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setRadii(float[] fArr) {
        if (fArr == null) {
            java.util.Arrays.fill(this.mRadii, 0.0f);
        } else {
            com.facebook.common.internal.Preconditions.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            java.lang.System.arraycopy(fArr, 0, this.mRadii, 0, 8);
        }
        updatePath();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float[] getRadii() {
        return this.mRadii;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setRadius(float f) {
        com.facebook.common.internal.Preconditions.checkArgument(f >= 0.0f, "radius should be non negative");
        java.util.Arrays.fill(this.mRadii, f);
        updatePath();
        invalidateSelf();
    }

    public void setColor(int i) {
        if (this.mColor != i) {
            this.mColor = i;
            invalidateSelf();
        }
    }

    public int getColor() {
        return this.mColor;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setBorder(int i, float f) {
        if (this.mBorderColor != i) {
            this.mBorderColor = i;
            invalidateSelf();
        }
        if (this.mBorderWidth != f) {
            this.mBorderWidth = f;
            updatePath();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public int getBorderColor() {
        return this.mBorderColor;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setPadding(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            updatePath();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float getPadding() {
        return this.mPadding;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setScaleDownInsideBorders(boolean z) {
        if (this.mScaleDownInsideBorders != z) {
            this.mScaleDownInsideBorders = z;
            updatePath();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public boolean getScaleDownInsideBorders() {
        return this.mScaleDownInsideBorders;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setPaintFilterBitmap(boolean z) {
        if (this.mPaintFilterBitmap != z) {
            this.mPaintFilterBitmap = z;
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public boolean getPaintFilterBitmap() {
        return this.mPaintFilterBitmap;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.mAlpha) {
            this.mAlpha = i;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mAlpha;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return com.facebook.drawee.drawable.DrawableUtils.getOpacityFromColor(com.facebook.drawee.drawable.DrawableUtils.multiplyColorAlpha(this.mColor, this.mAlpha));
    }

    private void updatePath() {
        float[] fArr;
        float[] fArr2;
        this.mPath.reset();
        this.mBorderPath.reset();
        this.mTempRect.set(getBounds());
        android.graphics.RectF rectF = this.mTempRect;
        float f = this.mBorderWidth;
        rectF.inset(f / 2.0f, f / 2.0f);
        int i = 0;
        if (this.mIsCircle) {
            this.mBorderPath.addCircle(this.mTempRect.centerX(), this.mTempRect.centerY(), java.lang.Math.min(this.mTempRect.width(), this.mTempRect.height()) / 2.0f, android.graphics.Path.Direction.CW);
        } else {
            int i2 = 0;
            while (true) {
                fArr = this.mBorderRadii;
                if (i2 >= fArr.length) {
                    break;
                }
                fArr[i2] = (this.mRadii[i2] + this.mPadding) - (this.mBorderWidth / 2.0f);
                i2++;
            }
            this.mBorderPath.addRoundRect(this.mTempRect, fArr, android.graphics.Path.Direction.CW);
        }
        android.graphics.RectF rectF2 = this.mTempRect;
        float f2 = this.mBorderWidth;
        rectF2.inset((-f2) / 2.0f, (-f2) / 2.0f);
        float f3 = this.mPadding + (this.mScaleDownInsideBorders ? this.mBorderWidth : 0.0f);
        this.mTempRect.inset(f3, f3);
        if (this.mIsCircle) {
            this.mPath.addCircle(this.mTempRect.centerX(), this.mTempRect.centerY(), java.lang.Math.min(this.mTempRect.width(), this.mTempRect.height()) / 2.0f, android.graphics.Path.Direction.CW);
        } else if (this.mScaleDownInsideBorders) {
            if (this.mInsideBorderRadii == null) {
                this.mInsideBorderRadii = new float[8];
            }
            while (true) {
                fArr2 = this.mInsideBorderRadii;
                if (i >= fArr2.length) {
                    break;
                }
                fArr2[i] = this.mRadii[i] - this.mBorderWidth;
                i++;
            }
            this.mPath.addRoundRect(this.mTempRect, fArr2, android.graphics.Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.mTempRect, this.mRadii, android.graphics.Path.Direction.CW);
        }
        float f4 = -f3;
        this.mTempRect.inset(f4, f4);
    }
}
