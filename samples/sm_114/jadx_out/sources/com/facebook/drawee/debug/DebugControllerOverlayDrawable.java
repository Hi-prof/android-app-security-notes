package com.facebook.drawee.debug;

/* JADX INFO: loaded from: classes.dex */
public class DebugControllerOverlayDrawable extends android.graphics.drawable.Drawable implements com.facebook.drawee.debug.listener.ImageLoadingTimeListener {
    private static final float IMAGE_SIZE_THRESHOLD_NOT_OK = 0.5f;
    private static final float IMAGE_SIZE_THRESHOLD_OK = 0.1f;
    private static final int MAX_LINE_WIDTH_EM = 8;
    private static final int MAX_NUMBER_OF_LINES = 9;
    private static final int MAX_TEXT_SIZE_PX = 40;
    private static final int MIN_TEXT_SIZE_PX = 10;
    private static final java.lang.String NO_CONTROLLER_ID = "none";
    private static final int OUTLINE_COLOR = -26624;
    private static final int OUTLINE_STROKE_WIDTH_PX = 2;
    private static final int TEXT_BACKGROUND_COLOR = 1711276032;
    private static final int TEXT_COLOR = -1;
    static final int TEXT_COLOR_IMAGE_ALMOST_OK = -256;
    static final int TEXT_COLOR_IMAGE_NOT_OK = -65536;
    static final int TEXT_COLOR_IMAGE_OK = -16711936;
    private static final int TEXT_LINE_SPACING_PX = 8;
    private static final int TEXT_PADDING_PX = 10;
    private java.lang.String mControllerId;
    private int mCurrentTextXPx;
    private int mCurrentTextYPx;
    private long mFinalImageTimeMs;
    private int mFrameCount;
    private int mHeightPx;

    @javax.annotation.Nullable
    private java.lang.String mImageFormat;

    @javax.annotation.Nullable
    private java.lang.String mImageId;
    private int mImageSizeBytes;
    private int mLineIncrementPx;
    private int mLoopCount;

    @javax.annotation.Nullable
    private java.lang.String mOriginText;

    @javax.annotation.Nullable
    private com.facebook.drawee.drawable.ScalingUtils.ScaleType mScaleType;
    private int mStartTextXPx;
    private int mStartTextYPx;
    private int mWidthPx;
    private java.util.HashMap<java.lang.String, java.lang.String> mAdditionalData = new java.util.HashMap<>();
    private int mTextGravity = 80;
    private final android.graphics.Paint mPaint = new android.graphics.Paint(1);
    private final android.graphics.Matrix mMatrix = new android.graphics.Matrix();
    private final android.graphics.Rect mRect = new android.graphics.Rect();
    private final android.graphics.RectF mRectF = new android.graphics.RectF();
    private int mOriginColor = -1;
    private int mOverlayColor = 0;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
    }

    public DebugControllerOverlayDrawable() {
        reset();
    }

    public void reset() {
        this.mWidthPx = -1;
        this.mHeightPx = -1;
        this.mImageSizeBytes = -1;
        this.mAdditionalData = new java.util.HashMap<>();
        this.mFrameCount = -1;
        this.mLoopCount = -1;
        this.mImageFormat = null;
        setControllerId(null);
        this.mFinalImageTimeMs = -1L;
        this.mOriginText = null;
        this.mOriginColor = -1;
        invalidateSelf();
    }

    public void setTextGravity(int i) {
        this.mTextGravity = i;
        invalidateSelf();
    }

    public void setControllerId(@javax.annotation.Nullable java.lang.String str) {
        if (str == null) {
            str = "none";
        }
        this.mControllerId = str;
        invalidateSelf();
    }

    public void setImageId(@javax.annotation.Nullable java.lang.String str) {
        this.mImageId = str;
        invalidateSelf();
    }

    public void setDimensions(int i, int i2) {
        this.mWidthPx = i;
        this.mHeightPx = i2;
        invalidateSelf();
    }

    public void setAnimationInfo(int i, int i2) {
        this.mFrameCount = i;
        this.mLoopCount = i2;
        invalidateSelf();
    }

    public void setOrigin(java.lang.String str, int i) {
        this.mOriginText = str;
        this.mOriginColor = i;
        invalidateSelf();
    }

    public void setImageSize(int i) {
        this.mImageSizeBytes = i;
    }

    public void addAdditionalData(java.lang.String str, java.lang.String str2) {
        this.mAdditionalData.put(str, str2);
    }

    public void setImageFormat(@javax.annotation.Nullable java.lang.String str) {
        this.mImageFormat = str;
    }

    public void setScaleType(com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        this.mScaleType = scaleType;
    }

    public void setOverlayColor(int i) {
        this.mOverlayColor = i;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(android.graphics.Rect rect) {
        super.onBoundsChange(rect);
        prepareDebugTextParameters(rect, 9, 8);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        android.graphics.Rect bounds = getBounds();
        this.mPaint.setStyle(android.graphics.Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(2.0f);
        this.mPaint.setColor(OUTLINE_COLOR);
        canvas.drawRect(bounds.left, bounds.top, bounds.right, bounds.bottom, this.mPaint);
        this.mPaint.setStyle(android.graphics.Paint.Style.FILL);
        this.mPaint.setColor(this.mOverlayColor);
        canvas.drawRect(bounds.left, bounds.top, bounds.right, bounds.bottom, this.mPaint);
        this.mPaint.setStyle(android.graphics.Paint.Style.FILL);
        this.mPaint.setStrokeWidth(0.0f);
        this.mPaint.setColor(-1);
        this.mCurrentTextXPx = this.mStartTextXPx;
        this.mCurrentTextYPx = this.mStartTextYPx;
        java.lang.String str = this.mImageId;
        if (str != null) {
            addDebugText(canvas, "IDs", format("%s, %s", this.mControllerId, str));
        } else {
            addDebugText(canvas, "ID", this.mControllerId);
        }
        addDebugText(canvas, "D", format("%dx%d", java.lang.Integer.valueOf(bounds.width()), java.lang.Integer.valueOf(bounds.height())));
        if (bounds.height() > 0) {
            addDebugText(canvas, "DAR", java.lang.Float.valueOf(bounds.width() / bounds.height()));
        }
        addDebugText(canvas, "I", format("%dx%d", java.lang.Integer.valueOf(this.mWidthPx), java.lang.Integer.valueOf(this.mHeightPx)), determineSizeHintColor(this.mWidthPx, this.mHeightPx, this.mScaleType));
        int i = this.mHeightPx;
        if (i > 0) {
            addDebugText(canvas, "IAR", java.lang.Float.valueOf(this.mWidthPx / i));
        }
        addDebugText(canvas, "I", format("%d KiB", java.lang.Integer.valueOf(this.mImageSizeBytes / 1024)));
        java.lang.String str2 = this.mImageFormat;
        if (str2 != null) {
            addDebugText(canvas, "i format", str2);
        }
        int i2 = this.mFrameCount;
        if (i2 > 0) {
            addDebugText(canvas, "anim", format("f %d, l %d", java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(this.mLoopCount)));
        }
        com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType = this.mScaleType;
        if (scaleType != null) {
            addDebugText(canvas, "scale", scaleType);
        }
        long j = this.mFinalImageTimeMs;
        if (j >= 0) {
            addDebugText(canvas, "t", format("%d ms", java.lang.Long.valueOf(j)));
        }
        java.lang.String str3 = this.mOriginText;
        if (str3 != null) {
            addDebugText(canvas, "origin", str3, this.mOriginColor);
        }
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : this.mAdditionalData.entrySet()) {
            addDebugText(canvas, entry.getKey(), entry.getValue());
        }
    }

    private void prepareDebugTextParameters(android.graphics.Rect rect, int i, int i2) {
        int i3;
        int iMin = java.lang.Math.min(40, java.lang.Math.max(10, java.lang.Math.min(rect.width() / i2, rect.height() / i)));
        this.mPaint.setTextSize(iMin);
        int i4 = iMin + 8;
        this.mLineIncrementPx = i4;
        if (this.mTextGravity == 80) {
            this.mLineIncrementPx = i4 * (-1);
        }
        this.mStartTextXPx = rect.left + 10;
        if (this.mTextGravity == 80) {
            i3 = rect.bottom - 10;
        } else {
            i3 = rect.top + 20;
        }
        this.mStartTextYPx = i3;
    }

    private static java.lang.String format(java.lang.String str, @javax.annotation.Nullable java.lang.Object... objArr) {
        return objArr == null ? str : java.lang.String.format(java.util.Locale.US, str, objArr);
    }

    private void addDebugText(android.graphics.Canvas canvas, java.lang.String str, java.lang.Object obj) {
        addDebugText(canvas, str, java.lang.String.valueOf(obj), -1);
    }

    private void addDebugText(android.graphics.Canvas canvas, java.lang.String str, java.lang.String str2) {
        addDebugText(canvas, str, str2, -1);
    }

    private void addDebugText(android.graphics.Canvas canvas, java.lang.String str, java.lang.String str2, int i) {
        java.lang.String str3 = str + ": ";
        float fMeasureText = this.mPaint.measureText(str3);
        float fMeasureText2 = this.mPaint.measureText(str2);
        this.mPaint.setColor(TEXT_BACKGROUND_COLOR);
        int i2 = this.mCurrentTextXPx;
        int i3 = this.mCurrentTextYPx;
        canvas.drawRect(i2 - 4, i3 + 8, i2 + fMeasureText + fMeasureText2 + 4.0f, i3 + this.mLineIncrementPx + 8, this.mPaint);
        this.mPaint.setColor(-1);
        canvas.drawText(str3, this.mCurrentTextXPx, this.mCurrentTextYPx, this.mPaint);
        this.mPaint.setColor(i);
        canvas.drawText(str2, this.mCurrentTextXPx + fMeasureText, this.mCurrentTextYPx, this.mPaint);
        this.mCurrentTextYPx += this.mLineIncrementPx;
    }

    int determineSizeHintColor(int i, int i2, @javax.annotation.Nullable com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
        int i3;
        int i4;
        int iWidth = getBounds().width();
        int iHeight = getBounds().height();
        if (iWidth > 0 && iHeight > 0 && i > 0 && i2 > 0) {
            if (scaleType != null) {
                android.graphics.Rect rect = this.mRect;
                rect.top = 0;
                rect.left = 0;
                this.mRect.right = iWidth;
                this.mRect.bottom = iHeight;
                this.mMatrix.reset();
                i3 = i;
                i4 = i2;
                scaleType.getTransform(this.mMatrix, this.mRect, i3, i4, 0.0f, 0.0f);
                android.graphics.RectF rectF = this.mRectF;
                rectF.top = 0.0f;
                rectF.left = 0.0f;
                this.mRectF.right = i3;
                this.mRectF.bottom = i4;
                this.mMatrix.mapRect(this.mRectF);
                int iWidth2 = (int) this.mRectF.width();
                int iHeight2 = (int) this.mRectF.height();
                iWidth = java.lang.Math.min(iWidth, iWidth2);
                iHeight = java.lang.Math.min(iHeight, iHeight2);
            } else {
                i3 = i;
                i4 = i2;
            }
            float f = iWidth;
            float f2 = f * IMAGE_SIZE_THRESHOLD_OK;
            float f3 = f * 0.5f;
            float f4 = iHeight;
            float f5 = IMAGE_SIZE_THRESHOLD_OK * f4;
            float f6 = f4 * 0.5f;
            int iAbs = java.lang.Math.abs(i3 - iWidth);
            int iAbs2 = java.lang.Math.abs(i4 - iHeight);
            float f7 = iAbs;
            if (f7 < f2 && iAbs2 < f5) {
                return TEXT_COLOR_IMAGE_OK;
            }
            if (f7 < f3 && iAbs2 < f6) {
                return -256;
            }
        }
        return -65536;
    }

    public void setFinalImageTimeMs(long j) {
        this.mFinalImageTimeMs = j;
    }

    @Override // com.facebook.drawee.debug.listener.ImageLoadingTimeListener
    public void onFinalImageSet(long j) {
        this.mFinalImageTimeMs = j;
        invalidateSelf();
    }
}
