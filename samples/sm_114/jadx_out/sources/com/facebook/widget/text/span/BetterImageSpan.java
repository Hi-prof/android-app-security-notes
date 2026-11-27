package com.facebook.widget.text.span;

/* JADX INFO: loaded from: classes.dex */
public class BetterImageSpan extends android.text.style.ReplacementSpan {
    public static final int ALIGN_BASELINE = 1;
    public static final int ALIGN_BOTTOM = 0;
    public static final int ALIGN_CENTER = 2;
    private final int mAlignment;
    private android.graphics.Rect mBounds;
    private final android.graphics.drawable.Drawable mDrawable;
    private final android.graphics.Paint.FontMetricsInt mFontMetricsInt;
    protected int mHeight;
    private final android.graphics.Rect mMargin;
    protected int mWidth;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface BetterImageSpanAlignment {
    }

    public static final int normalizeAlignment(int i) {
        if (i != 0) {
            return i != 2 ? 1 : 2;
        }
        return 0;
    }

    public BetterImageSpan(android.graphics.drawable.Drawable drawable) {
        this(drawable, 1);
    }

    public BetterImageSpan(android.graphics.drawable.Drawable drawable, int i) {
        this(drawable, i, new android.graphics.Rect());
    }

    public BetterImageSpan(android.graphics.drawable.Drawable drawable, int i, android.graphics.Rect rect) {
        this.mFontMetricsInt = new android.graphics.Paint.FontMetricsInt();
        this.mDrawable = drawable;
        this.mAlignment = i;
        this.mMargin = rect;
        updateBounds();
    }

    public android.graphics.drawable.Drawable getDrawable() {
        return this.mDrawable;
    }

    public android.graphics.Rect getMargin() {
        return this.mMargin;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(android.graphics.Paint paint, java.lang.CharSequence charSequence, int i, int i2, android.graphics.Paint.FontMetricsInt fontMetricsInt) {
        updateBounds();
        if (fontMetricsInt == null) {
            return this.mWidth;
        }
        return calculateLineWidthAndFontHeight(fontMetricsInt);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(android.graphics.Canvas canvas, java.lang.CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, android.graphics.Paint paint) {
        paint.getFontMetricsInt(this.mFontMetricsInt);
        int iconTop = getIconTop(i4, this.mFontMetricsInt.ascent, this.mFontMetricsInt.descent, i3, i5);
        float f2 = f + this.mMargin.left;
        canvas.translate(f2, iconTop);
        this.mDrawable.draw(canvas);
        canvas.translate(-f2, -iconTop);
    }

    public void updateBounds() {
        android.graphics.Rect bounds = this.mDrawable.getBounds();
        this.mBounds = bounds;
        this.mWidth = bounds.width() + this.mMargin.left + this.mMargin.right;
        this.mHeight = this.mBounds.height();
    }

    protected int getOffsetAboveBaseline(int i, int i2) {
        int i3;
        int i4;
        int i5 = this.mAlignment;
        if (i5 == 0) {
            return (i2 - this.mHeight) - this.mMargin.bottom;
        }
        if (i5 == 2) {
            i3 = i + (((((i2 - i) + this.mMargin.top) + this.mMargin.bottom) - this.mHeight) / 2);
            i4 = this.mMargin.bottom;
        } else {
            i3 = -this.mHeight;
            i4 = this.mMargin.bottom;
        }
        return i3 - i4;
    }

    protected int getIconTop(int i, int i2, int i3, int i4, int i5) {
        return i + getOffsetAboveBaseline(this.mFontMetricsInt.ascent, this.mFontMetricsInt.descent);
    }

    protected int calculateLineWidthAndFontHeight(android.graphics.Paint.FontMetricsInt fontMetricsInt) {
        int i;
        int offsetAboveBaseline = getOffsetAboveBaseline(fontMetricsInt.ascent, fontMetricsInt.descent);
        int i2 = this.mHeight + offsetAboveBaseline;
        if (this.mAlignment == 2) {
            i = offsetAboveBaseline - this.mMargin.top;
            i2 += this.mMargin.bottom;
        } else {
            i = offsetAboveBaseline - this.mMargin.top;
        }
        updateFontHeight(fontMetricsInt, i, i2);
        return this.mWidth;
    }

    protected void updateFontHeight(android.graphics.Paint.FontMetricsInt fontMetricsInt, int i, int i2) {
        if (i < fontMetricsInt.ascent) {
            fontMetricsInt.ascent = i;
        }
        if (i < fontMetricsInt.top) {
            fontMetricsInt.top = i;
        }
        if (i2 > fontMetricsInt.descent) {
            fontMetricsInt.descent = i2;
        }
        if (i2 > fontMetricsInt.bottom) {
            fontMetricsInt.bottom = i2;
        }
    }
}
