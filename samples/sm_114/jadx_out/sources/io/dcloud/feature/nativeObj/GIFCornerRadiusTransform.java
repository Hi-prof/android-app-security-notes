package io.dcloud.feature.nativeObj;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class GIFCornerRadiusTransform implements pl.droidsonroids.gif.transforms.Transform {
    private int gifViewWidth;
    private float mCornerRadius;
    private final android.graphics.RectF mDstRectF = new android.graphics.RectF();
    private android.graphics.Shader mShader;

    public GIFCornerRadiusTransform(float f, int i) {
        this.gifViewWidth = -1;
        setCornerRadiusSafely(f);
        this.gifViewWidth = i;
    }

    private void setCornerRadiusSafely(float f) {
        float fMax = java.lang.Math.max(0.0f, f);
        if (fMax != this.mCornerRadius) {
            this.mCornerRadius = fMax;
            this.mShader = null;
        }
    }

    public android.graphics.RectF getBounds() {
        return this.mDstRectF;
    }

    public float getCornerRadius() {
        return this.mCornerRadius;
    }

    @Override // pl.droidsonroids.gif.transforms.Transform
    public void onBoundsChange(android.graphics.Rect rect) {
        this.mDstRectF.set(rect);
        this.mShader = null;
    }

    @Override // pl.droidsonroids.gif.transforms.Transform
    public void onDraw(android.graphics.Canvas canvas, android.graphics.Paint paint, android.graphics.Bitmap bitmap) {
        if (this.mCornerRadius == 0.0f) {
            canvas.drawBitmap(bitmap, (android.graphics.Rect) null, this.mDstRectF, paint);
            return;
        }
        if (this.mShader == null) {
            android.graphics.Shader.TileMode tileMode = android.graphics.Shader.TileMode.CLAMP;
            this.mShader = new android.graphics.BitmapShader(bitmap, tileMode, tileMode);
            android.graphics.Matrix matrix = new android.graphics.Matrix();
            android.graphics.RectF rectF = this.mDstRectF;
            matrix.setTranslate(rectF.left, rectF.top);
            matrix.preScale(this.mDstRectF.width() / bitmap.getWidth(), this.mDstRectF.height() / bitmap.getHeight());
            this.mShader.setLocalMatrix(matrix);
        }
        paint.setShader(this.mShader);
        float fWidth = this.gifViewWidth > 0 ? this.mDstRectF.width() / this.gifViewWidth : 1.0f;
        paint.setAntiAlias(true);
        android.graphics.RectF rectF2 = this.mDstRectF;
        float f = this.mCornerRadius * fWidth;
        canvas.drawRoundRect(rectF2, f, f, paint);
    }

    public void setCornerRadius(float f) {
        setCornerRadiusSafely(f);
    }
}
