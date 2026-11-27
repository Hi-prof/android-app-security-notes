package com.facebook.drawee.drawable;

/* JADX INFO: loaded from: classes.dex */
public class RoundedCornersDrawable extends com.facebook.drawee.drawable.ForwardingDrawable implements com.facebook.drawee.drawable.Rounded {
    private int mBorderColor;
    private final android.graphics.Path mBorderPath;
    final float[] mBorderRadii;
    private float mBorderWidth;
    private final android.graphics.RectF mBounds;

    @javax.annotation.Nullable
    private android.graphics.RectF mInsideBorderBounds;

    @javax.annotation.Nullable
    private android.graphics.Matrix mInsideBorderTransform;
    private boolean mIsCircle;
    private int mOverlayColor;
    private float mPadding;
    final android.graphics.Paint mPaint;
    private boolean mPaintFilterBitmap;
    private final android.graphics.Path mPath;
    private final float[] mRadii;
    private boolean mScaleDownInsideBorders;
    private final android.graphics.RectF mTempRectangle;
    com.facebook.drawee.drawable.RoundedCornersDrawable.Type mType;

    public enum Type {
        OVERLAY_COLOR,
        CLIPPING
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setRepeatEdgePixels(boolean z) {
    }

    public RoundedCornersDrawable(android.graphics.drawable.Drawable drawable) {
        super((android.graphics.drawable.Drawable) com.facebook.common.internal.Preconditions.checkNotNull(drawable));
        this.mType = com.facebook.drawee.drawable.RoundedCornersDrawable.Type.OVERLAY_COLOR;
        this.mBounds = new android.graphics.RectF();
        this.mRadii = new float[8];
        this.mBorderRadii = new float[8];
        this.mPaint = new android.graphics.Paint(1);
        this.mIsCircle = false;
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.mOverlayColor = 0;
        this.mPadding = 0.0f;
        this.mScaleDownInsideBorders = false;
        this.mPaintFilterBitmap = false;
        this.mPath = new android.graphics.Path();
        this.mBorderPath = new android.graphics.Path();
        this.mTempRectangle = new android.graphics.RectF();
    }

    public void setType(com.facebook.drawee.drawable.RoundedCornersDrawable.Type type) {
        this.mType = type;
        updatePath();
        invalidateSelf();
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
    public void setRadius(float f) {
        java.util.Arrays.fill(this.mRadii, f);
        updatePath();
        invalidateSelf();
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

    public void setOverlayColor(int i) {
        this.mOverlayColor = i;
        invalidateSelf();
    }

    public int getOverlayColor() {
        return this.mOverlayColor;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setBorder(int i, float f) {
        this.mBorderColor = i;
        this.mBorderWidth = f;
        updatePath();
        invalidateSelf();
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
        this.mPadding = f;
        updatePath();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public float getPadding() {
        return this.mPadding;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public void setScaleDownInsideBorders(boolean z) {
        this.mScaleDownInsideBorders = z;
        updatePath();
        invalidateSelf();
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

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(android.graphics.Rect rect) {
        super.onBoundsChange(rect);
        updatePath();
    }

    private void updatePath() {
        float[] fArr;
        this.mPath.reset();
        this.mBorderPath.reset();
        this.mTempRectangle.set(getBounds());
        android.graphics.RectF rectF = this.mTempRectangle;
        float f = this.mPadding;
        rectF.inset(f, f);
        if (this.mType == com.facebook.drawee.drawable.RoundedCornersDrawable.Type.OVERLAY_COLOR) {
            this.mPath.addRect(this.mTempRectangle, android.graphics.Path.Direction.CW);
        }
        if (this.mIsCircle) {
            this.mPath.addCircle(this.mTempRectangle.centerX(), this.mTempRectangle.centerY(), java.lang.Math.min(this.mTempRectangle.width(), this.mTempRectangle.height()) / 2.0f, android.graphics.Path.Direction.CW);
        } else {
            this.mPath.addRoundRect(this.mTempRectangle, this.mRadii, android.graphics.Path.Direction.CW);
        }
        android.graphics.RectF rectF2 = this.mTempRectangle;
        float f2 = this.mPadding;
        rectF2.inset(-f2, -f2);
        android.graphics.RectF rectF3 = this.mTempRectangle;
        float f3 = this.mBorderWidth;
        rectF3.inset(f3 / 2.0f, f3 / 2.0f);
        if (this.mIsCircle) {
            this.mBorderPath.addCircle(this.mTempRectangle.centerX(), this.mTempRectangle.centerY(), java.lang.Math.min(this.mTempRectangle.width(), this.mTempRectangle.height()) / 2.0f, android.graphics.Path.Direction.CW);
        } else {
            int i = 0;
            while (true) {
                fArr = this.mBorderRadii;
                if (i >= fArr.length) {
                    break;
                }
                fArr[i] = (this.mRadii[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
                i++;
            }
            this.mBorderPath.addRoundRect(this.mTempRectangle, fArr, android.graphics.Path.Direction.CW);
        }
        android.graphics.RectF rectF4 = this.mTempRectangle;
        float f4 = this.mBorderWidth;
        rectF4.inset((-f4) / 2.0f, (-f4) / 2.0f);
    }

    /* JADX INFO: renamed from: com.facebook.drawee.drawable.RoundedCornersDrawable$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$drawee$drawable$RoundedCornersDrawable$Type;

        static {
            int[] iArr = new int[com.facebook.drawee.drawable.RoundedCornersDrawable.Type.values().length];
            $SwitchMap$com$facebook$drawee$drawable$RoundedCornersDrawable$Type = iArr;
            try {
                iArr[com.facebook.drawee.drawable.RoundedCornersDrawable.Type.CLIPPING.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$drawee$drawable$RoundedCornersDrawable$Type[com.facebook.drawee.drawable.RoundedCornersDrawable.Type.OVERLAY_COLOR.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        this.mBounds.set(getBounds());
        int i = com.facebook.drawee.drawable.RoundedCornersDrawable.AnonymousClass1.$SwitchMap$com$facebook$drawee$drawable$RoundedCornersDrawable$Type[this.mType.ordinal()];
        if (i == 1) {
            int iSave = canvas.save();
            canvas.clipPath(this.mPath);
            super.draw(canvas);
            canvas.restoreToCount(iSave);
        } else if (i == 2) {
            if (this.mScaleDownInsideBorders) {
                android.graphics.RectF rectF = this.mInsideBorderBounds;
                if (rectF == null) {
                    this.mInsideBorderBounds = new android.graphics.RectF(this.mBounds);
                    this.mInsideBorderTransform = new android.graphics.Matrix();
                } else {
                    rectF.set(this.mBounds);
                }
                android.graphics.RectF rectF2 = this.mInsideBorderBounds;
                float f = this.mBorderWidth;
                rectF2.inset(f, f);
                android.graphics.Matrix matrix = this.mInsideBorderTransform;
                if (matrix != null) {
                    matrix.setRectToRect(this.mBounds, this.mInsideBorderBounds, android.graphics.Matrix.ScaleToFit.FILL);
                }
                int iSave2 = canvas.save();
                canvas.clipRect(this.mBounds);
                canvas.concat(this.mInsideBorderTransform);
                super.draw(canvas);
                canvas.restoreToCount(iSave2);
            } else {
                super.draw(canvas);
            }
            this.mPaint.setStyle(android.graphics.Paint.Style.FILL);
            this.mPaint.setColor(this.mOverlayColor);
            this.mPaint.setStrokeWidth(0.0f);
            this.mPaint.setFilterBitmap(getPaintFilterBitmap());
            this.mPath.setFillType(android.graphics.Path.FillType.EVEN_ODD);
            canvas.drawPath(this.mPath, this.mPaint);
            if (this.mIsCircle) {
                float fWidth = ((this.mBounds.width() - this.mBounds.height()) + this.mBorderWidth) / 2.0f;
                float fHeight = ((this.mBounds.height() - this.mBounds.width()) + this.mBorderWidth) / 2.0f;
                if (fWidth > 0.0f) {
                    canvas.drawRect(this.mBounds.left, this.mBounds.top, this.mBounds.left + fWidth, this.mBounds.bottom, this.mPaint);
                    canvas.drawRect(this.mBounds.right - fWidth, this.mBounds.top, this.mBounds.right, this.mBounds.bottom, this.mPaint);
                }
                if (fHeight > 0.0f) {
                    canvas.drawRect(this.mBounds.left, this.mBounds.top, this.mBounds.right, this.mBounds.top + fHeight, this.mPaint);
                    canvas.drawRect(this.mBounds.left, this.mBounds.bottom - fHeight, this.mBounds.right, this.mBounds.bottom, this.mPaint);
                }
            }
        }
        if (this.mBorderColor != 0) {
            this.mPaint.setStyle(android.graphics.Paint.Style.STROKE);
            this.mPaint.setColor(this.mBorderColor);
            this.mPaint.setStrokeWidth(this.mBorderWidth);
            this.mPath.setFillType(android.graphics.Path.FillType.EVEN_ODD);
            canvas.drawPath(this.mBorderPath, this.mPaint);
        }
    }
}
