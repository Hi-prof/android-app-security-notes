package com.taobao.weex.utils;

/* JADX INFO: loaded from: classes.dex */
public class ImageDrawable extends android.graphics.drawable.PaintDrawable {
    private int bitmapHeight;
    private int bitmapWidth;
    private float[] radii;

    public static android.graphics.drawable.Drawable createImageDrawable(android.graphics.drawable.Drawable drawable, android.widget.ImageView.ScaleType scaleType, float[] fArr, int i, int i2, boolean z) {
        android.graphics.Bitmap bitmap;
        if (!z && i > 0 && i2 > 0) {
            if ((drawable instanceof android.graphics.drawable.BitmapDrawable) && (bitmap = ((android.graphics.drawable.BitmapDrawable) drawable).getBitmap()) != null) {
                com.taobao.weex.utils.ImageDrawable imageDrawable = new com.taobao.weex.utils.ImageDrawable();
                imageDrawable.getPaint().setFilterBitmap(true);
                imageDrawable.bitmapWidth = bitmap.getWidth();
                imageDrawable.bitmapHeight = bitmap.getHeight();
                android.graphics.BitmapShader bitmapShader = new android.graphics.BitmapShader(bitmap, android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP);
                updateShaderAndSize(scaleType, i, i2, imageDrawable, bitmapShader);
                imageDrawable.getPaint().setShader(bitmapShader);
                return imageDrawable;
            }
            if (drawable instanceof com.taobao.weex.utils.ImageDrawable) {
                com.taobao.weex.utils.ImageDrawable imageDrawable2 = (com.taobao.weex.utils.ImageDrawable) drawable;
                if (imageDrawable2.getPaint() != null && (imageDrawable2.getPaint().getShader() instanceof android.graphics.BitmapShader)) {
                    updateShaderAndSize(scaleType, i, i2, imageDrawable2, (android.graphics.BitmapShader) imageDrawable2.getPaint().getShader());
                    return imageDrawable2;
                }
            }
        }
        return drawable;
    }

    private static void updateShaderAndSize(android.widget.ImageView.ScaleType scaleType, int i, int i2, com.taobao.weex.utils.ImageDrawable imageDrawable, android.graphics.BitmapShader bitmapShader) {
        android.graphics.Matrix matrixCreateShaderMatrix = createShaderMatrix(scaleType, i, i2, imageDrawable.bitmapWidth, imageDrawable.bitmapHeight);
        if (scaleType == android.widget.ImageView.ScaleType.FIT_CENTER) {
            android.graphics.RectF rectF = new android.graphics.RectF(0.0f, 0.0f, imageDrawable.bitmapWidth, imageDrawable.bitmapHeight);
            android.graphics.RectF rectF2 = new android.graphics.RectF();
            matrixCreateShaderMatrix.mapRect(rectF2, rectF);
            i = (int) rectF2.width();
            i2 = (int) rectF2.height();
            matrixCreateShaderMatrix = createShaderMatrix(scaleType, i, i2, imageDrawable.bitmapWidth, imageDrawable.bitmapHeight);
        }
        imageDrawable.setIntrinsicWidth(i);
        imageDrawable.setIntrinsicHeight(i2);
        bitmapShader.setLocalMatrix(matrixCreateShaderMatrix);
    }

    private static android.graphics.Matrix createShaderMatrix(android.widget.ImageView.ScaleType scaleType, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        if (i3 * i2 > i4 * i) {
            f = i2 / i4;
            f3 = (i - (i3 * f)) * 0.5f;
            f2 = 0.0f;
        } else {
            f = i / i3;
            f2 = (i2 - (i4 * f)) * 0.5f;
            f3 = 0.0f;
        }
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        if (scaleType == android.widget.ImageView.ScaleType.FIT_XY) {
            matrix.setScale(i / i3, i2 / i4);
            return matrix;
        }
        if (scaleType == android.widget.ImageView.ScaleType.FIT_CENTER) {
            matrix.setRectToRect(new android.graphics.RectF(0.0f, 0.0f, i3, i4), new android.graphics.RectF(0.0f, 0.0f, i, i2), android.graphics.Matrix.ScaleToFit.CENTER);
            return matrix;
        }
        if (scaleType == android.widget.ImageView.ScaleType.CENTER_CROP) {
            matrix.setScale(f, f);
            matrix.postTranslate(f3 + 0.5f, f2 + 0.5f);
        }
        return matrix;
    }

    private ImageDrawable() {
    }

    @Override // android.graphics.drawable.PaintDrawable
    public void setCornerRadii(float[] fArr) {
        this.radii = fArr;
        super.setCornerRadii(fArr);
    }

    @Override // android.graphics.drawable.ShapeDrawable
    protected void onDraw(android.graphics.drawable.shapes.Shape shape, android.graphics.Canvas canvas, android.graphics.Paint paint) {
        if (android.os.Build.VERSION.SDK_INT == 21) {
            paint.setAntiAlias(false);
        }
        super.onDraw(shape, canvas, paint);
    }

    public float[] getCornerRadii() {
        return this.radii;
    }

    public int getBitmapHeight() {
        return this.bitmapHeight;
    }

    public int getBitmapWidth() {
        return this.bitmapWidth;
    }
}
