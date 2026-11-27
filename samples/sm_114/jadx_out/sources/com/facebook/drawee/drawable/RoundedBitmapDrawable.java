package com.facebook.drawee.drawable;

/* JADX INFO: loaded from: classes.dex */
public class RoundedBitmapDrawable extends com.facebook.drawee.drawable.RoundedDrawable {
    private static boolean sDefaultRepeatEdgePixels = false;

    @javax.annotation.Nullable
    private final android.graphics.Bitmap mBitmap;

    @javax.annotation.Nullable
    private android.graphics.RectF mBitmapClipRect;
    private final android.graphics.Paint mBorderPaint;

    @javax.annotation.Nullable
    private java.lang.ref.WeakReference<android.graphics.Bitmap> mLastBitmap;
    private final android.graphics.Paint mPaint;
    private boolean mRepeatEdgePixels;

    public static void setDefaultRepeatEdgePixels(boolean z) {
        sDefaultRepeatEdgePixels = z;
    }

    public static boolean getDefaultRepeatEdgePixels() {
        return sDefaultRepeatEdgePixels;
    }

    public RoundedBitmapDrawable(android.content.res.Resources resources, @javax.annotation.Nullable android.graphics.Bitmap bitmap, @javax.annotation.Nullable android.graphics.Paint paint, boolean z) {
        super(new android.graphics.drawable.BitmapDrawable(resources, bitmap));
        android.graphics.Paint paint2 = new android.graphics.Paint();
        this.mPaint = paint2;
        android.graphics.Paint paint3 = new android.graphics.Paint(1);
        this.mBorderPaint = paint3;
        this.mBitmapClipRect = null;
        this.mBitmap = bitmap;
        if (paint != null) {
            paint2.set(paint);
        }
        paint2.setFlags(1);
        paint3.setStyle(android.graphics.Paint.Style.STROKE);
        this.mRepeatEdgePixels = z;
    }

    public RoundedBitmapDrawable(android.content.res.Resources resources, @javax.annotation.Nullable android.graphics.Bitmap bitmap, @javax.annotation.Nullable android.graphics.Paint paint) {
        this(resources, bitmap, paint, sDefaultRepeatEdgePixels);
    }

    public RoundedBitmapDrawable(android.content.res.Resources resources, @javax.annotation.Nullable android.graphics.Bitmap bitmap) {
        this(resources, bitmap, null);
    }

    @Override // com.facebook.drawee.drawable.RoundedDrawable
    protected void updateTransform() {
        super.updateTransform();
        if (this.mRepeatEdgePixels) {
            return;
        }
        if (this.mBitmapClipRect == null) {
            this.mBitmapClipRect = new android.graphics.RectF();
        }
        this.mTransform.mapRect(this.mBitmapClipRect, this.mBitmapBounds);
    }

    @Override // com.facebook.drawee.drawable.RoundedDrawable, android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("RoundedBitmapDrawable#draw");
        }
        if (!shouldRound()) {
            super.draw(canvas);
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                return;
            }
            return;
        }
        updateTransform();
        updatePath();
        updatePaint();
        int iSave = canvas.save();
        canvas.concat(this.mInverseParentTransform);
        if (!this.mRepeatEdgePixels && this.mBitmapClipRect != null) {
            int iSave2 = canvas.save();
            canvas.clipRect(this.mBitmapClipRect);
            canvas.drawPath(this.mPath, this.mPaint);
            canvas.restoreToCount(iSave2);
        } else {
            canvas.drawPath(this.mPath, this.mPaint);
        }
        if (this.mBorderWidth > 0.0f) {
            this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
            this.mBorderPaint.setColor(com.facebook.drawee.drawable.DrawableUtils.multiplyColorAlpha(this.mBorderColor, this.mPaint.getAlpha()));
            canvas.drawPath(this.mBorderPath, this.mBorderPaint);
        }
        canvas.restoreToCount(iSave);
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
    }

    private void updatePaint() {
        android.graphics.Shader shader;
        java.lang.ref.WeakReference<android.graphics.Bitmap> weakReference = this.mLastBitmap;
        if (weakReference == null || weakReference.get() != this.mBitmap) {
            this.mLastBitmap = new java.lang.ref.WeakReference<>(this.mBitmap);
            if (this.mBitmap != null) {
                this.mPaint.setShader(new android.graphics.BitmapShader(this.mBitmap, android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP));
                this.mIsShaderTransformDirty = true;
            }
        }
        if (this.mIsShaderTransformDirty && (shader = this.mPaint.getShader()) != null) {
            shader.setLocalMatrix(this.mTransform);
            this.mIsShaderTransformDirty = false;
        }
        this.mPaint.setFilterBitmap(getPaintFilterBitmap());
    }

    public static com.facebook.drawee.drawable.RoundedBitmapDrawable fromBitmapDrawable(android.content.res.Resources resources, android.graphics.drawable.BitmapDrawable bitmapDrawable) {
        return new com.facebook.drawee.drawable.RoundedBitmapDrawable(resources, bitmapDrawable.getBitmap(), bitmapDrawable.getPaint());
    }

    @Override // com.facebook.drawee.drawable.RoundedDrawable
    boolean shouldRound() {
        return super.shouldRound() && this.mBitmap != null;
    }

    @Override // com.facebook.drawee.drawable.RoundedDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        super.setAlpha(i);
        if (i != this.mPaint.getAlpha()) {
            this.mPaint.setAlpha(i);
            super.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.RoundedDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(@javax.annotation.Nullable android.graphics.ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
        this.mPaint.setColorFilter(colorFilter);
    }

    public android.graphics.Paint getPaint() {
        return this.mPaint;
    }

    @Override // com.facebook.drawee.drawable.RoundedDrawable, com.facebook.drawee.drawable.Rounded
    public void setRepeatEdgePixels(boolean z) {
        this.mRepeatEdgePixels = z;
    }

    @javax.annotation.Nullable
    public android.graphics.Bitmap getBitmap() {
        return this.mBitmap;
    }

    public boolean getRepeatEdgePixels() {
        return this.mRepeatEdgePixels;
    }
}
