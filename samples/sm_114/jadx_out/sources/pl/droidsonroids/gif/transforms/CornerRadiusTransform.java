package pl.droidsonroids.gif.transforms;

/* JADX INFO: loaded from: classes2.dex */
public class CornerRadiusTransform implements pl.droidsonroids.gif.transforms.Transform {
    private float mCornerRadius;
    private final android.graphics.RectF mDstRectF = new android.graphics.RectF();
    private android.graphics.Shader mShader;

    public CornerRadiusTransform(float f) {
        setCornerRadiusSafely(f);
    }

    public void setCornerRadius(float f) {
        setCornerRadiusSafely(f);
    }

    private void setCornerRadiusSafely(float f) {
        float fMax = java.lang.Math.max(0.0f, f);
        if (fMax != this.mCornerRadius) {
            this.mCornerRadius = fMax;
            this.mShader = null;
        }
    }

    public float getCornerRadius() {
        return this.mCornerRadius;
    }

    public android.graphics.RectF getBounds() {
        return this.mDstRectF;
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
            this.mShader = new android.graphics.BitmapShader(bitmap, android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP);
            android.graphics.Matrix matrix = new android.graphics.Matrix();
            matrix.setTranslate(this.mDstRectF.left, this.mDstRectF.top);
            matrix.preScale(this.mDstRectF.width() / bitmap.getWidth(), this.mDstRectF.height() / bitmap.getHeight());
            this.mShader.setLocalMatrix(matrix);
        }
        paint.setShader(this.mShader);
        android.graphics.RectF rectF = this.mDstRectF;
        float f = this.mCornerRadius;
        canvas.drawRoundRect(rectF, f, f, paint);
    }
}
