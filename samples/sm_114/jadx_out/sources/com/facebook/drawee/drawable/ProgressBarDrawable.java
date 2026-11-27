package com.facebook.drawee.drawable;

/* JADX INFO: loaded from: classes.dex */
public class ProgressBarDrawable extends android.graphics.drawable.Drawable implements com.facebook.drawee.drawable.CloneableDrawable {
    private final android.graphics.Paint mPaint = new android.graphics.Paint(1);
    private final android.graphics.Path mPath = new android.graphics.Path();
    private final android.graphics.RectF mRect = new android.graphics.RectF();
    private int mBackgroundColor = Integer.MIN_VALUE;
    private int mColor = -2147450625;
    private int mPadding = 10;
    private int mBarWidth = 20;
    private int mLevel = 0;
    private int mRadius = 0;
    private boolean mHideWhenZero = false;
    private boolean mIsVertical = false;

    public void setColor(int i) {
        if (this.mColor != i) {
            this.mColor = i;
            invalidateSelf();
        }
    }

    public int getColor() {
        return this.mColor;
    }

    public void setBackgroundColor(int i) {
        if (this.mBackgroundColor != i) {
            this.mBackgroundColor = i;
            invalidateSelf();
        }
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public void setPadding(int i) {
        if (this.mPadding != i) {
            this.mPadding = i;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(android.graphics.Rect rect) {
        int i = this.mPadding;
        rect.set(i, i, i, i);
        return this.mPadding != 0;
    }

    public void setBarWidth(int i) {
        if (this.mBarWidth != i) {
            this.mBarWidth = i;
            invalidateSelf();
        }
    }

    public int getBarWidth() {
        return this.mBarWidth;
    }

    public void setHideWhenZero(boolean z) {
        this.mHideWhenZero = z;
    }

    public boolean getHideWhenZero() {
        return this.mHideWhenZero;
    }

    public void setRadius(int i) {
        if (this.mRadius != i) {
            this.mRadius = i;
            invalidateSelf();
        }
    }

    public int getRadius() {
        return this.mRadius;
    }

    public void setIsVertical(boolean z) {
        if (this.mIsVertical != z) {
            this.mIsVertical = z;
            invalidateSelf();
        }
    }

    public boolean getIsVertical() {
        return this.mIsVertical;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        this.mLevel = i;
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return com.facebook.drawee.drawable.DrawableUtils.getOpacityFromColor(this.mPaint.getColor());
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        if (this.mHideWhenZero && this.mLevel == 0) {
            return;
        }
        if (this.mIsVertical) {
            drawVerticalBar(canvas, io.dcloud.feature.gg.dcloud.ADSim.INTISPLSH, this.mBackgroundColor);
            drawVerticalBar(canvas, this.mLevel, this.mColor);
        } else {
            drawHorizontalBar(canvas, io.dcloud.feature.gg.dcloud.ADSim.INTISPLSH, this.mBackgroundColor);
            drawHorizontalBar(canvas, this.mLevel, this.mColor);
        }
    }

    @Override // com.facebook.drawee.drawable.CloneableDrawable
    public android.graphics.drawable.Drawable cloneDrawable() {
        com.facebook.drawee.drawable.ProgressBarDrawable progressBarDrawable = new com.facebook.drawee.drawable.ProgressBarDrawable();
        progressBarDrawable.mBackgroundColor = this.mBackgroundColor;
        progressBarDrawable.mColor = this.mColor;
        progressBarDrawable.mPadding = this.mPadding;
        progressBarDrawable.mBarWidth = this.mBarWidth;
        progressBarDrawable.mLevel = this.mLevel;
        progressBarDrawable.mRadius = this.mRadius;
        progressBarDrawable.mHideWhenZero = this.mHideWhenZero;
        progressBarDrawable.mIsVertical = this.mIsVertical;
        return progressBarDrawable;
    }

    private void drawHorizontalBar(android.graphics.Canvas canvas, int i, int i2) {
        android.graphics.Rect bounds = getBounds();
        int iWidth = ((bounds.width() - (this.mPadding * 2)) * i) / io.dcloud.feature.gg.dcloud.ADSim.INTISPLSH;
        int i3 = bounds.left + this.mPadding;
        int i4 = bounds.bottom - this.mPadding;
        int i5 = this.mBarWidth;
        int i6 = i4 - i5;
        this.mRect.set(i3, i6, i3 + iWidth, i6 + i5);
        drawBar(canvas, i2);
    }

    private void drawVerticalBar(android.graphics.Canvas canvas, int i, int i2) {
        android.graphics.Rect bounds = getBounds();
        int iHeight = ((bounds.height() - (this.mPadding * 2)) * i) / io.dcloud.feature.gg.dcloud.ADSim.INTISPLSH;
        int i3 = bounds.left + this.mPadding;
        int i4 = bounds.top + this.mPadding;
        this.mRect.set(i3, i4, i3 + this.mBarWidth, i4 + iHeight);
        drawBar(canvas, i2);
    }

    private void drawBar(android.graphics.Canvas canvas, int i) {
        this.mPaint.setColor(i);
        this.mPaint.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        this.mPath.reset();
        this.mPath.setFillType(android.graphics.Path.FillType.EVEN_ODD);
        this.mPath.addRoundRect(this.mRect, java.lang.Math.min(this.mRadius, this.mBarWidth / 2), java.lang.Math.min(this.mRadius, this.mBarWidth / 2), android.graphics.Path.Direction.CW);
        canvas.drawPath(this.mPath, this.mPaint);
    }
}
