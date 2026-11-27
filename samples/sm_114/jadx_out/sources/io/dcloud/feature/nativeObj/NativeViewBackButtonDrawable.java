package io.dcloud.feature.nativeObj;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class NativeViewBackButtonDrawable extends android.graphics.drawable.Drawable {
    private android.graphics.Paint mPaint;
    private java.lang.String widthStr;

    public NativeViewBackButtonDrawable(int i) {
        android.graphics.Paint paint = new android.graphics.Paint(1);
        this.mPaint = paint;
        paint.setColor(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        android.graphics.Rect bounds = getBounds();
        float fExactCenterX = bounds.exactCenterX();
        float fExactCenterY = bounds.exactCenterY();
        if (!io.dcloud.common.util.PdrUtil.isEmpty(this.widthStr) && this.widthStr.equals("backButton")) {
            if (bounds.width() <= bounds.height()) {
                canvas.drawCircle(fExactCenterX, fExactCenterY, java.lang.Math.min(fExactCenterX, fExactCenterY), this.mPaint);
                return;
            } else {
                canvas.drawRoundRect(new android.graphics.RectF(bounds), java.lang.Math.min(fExactCenterX, fExactCenterY), java.lang.Math.min(fExactCenterX, fExactCenterY), this.mPaint);
                return;
            }
        }
        if (io.dcloud.common.util.PdrUtil.isEmpty(this.widthStr) || !(this.widthStr.equals("auto") || this.widthStr.endsWith("px"))) {
            canvas.drawCircle(fExactCenterX, fExactCenterY, java.lang.Math.min(fExactCenterX, fExactCenterY), this.mPaint);
            return;
        }
        if (this.widthStr.endsWith("px")) {
            java.lang.String str = this.widthStr;
            try {
                if (java.lang.Integer.parseInt(str.substring(0, str.indexOf("px"))) <= 44) {
                    canvas.drawCircle(fExactCenterX, fExactCenterY, java.lang.Math.min(fExactCenterX, fExactCenterY), this.mPaint);
                    return;
                }
            } catch (java.lang.Exception unused) {
            }
        }
        canvas.drawRoundRect(new android.graphics.RectF(bounds), java.lang.Math.min(fExactCenterX, fExactCenterY), java.lang.Math.min(fExactCenterX, fExactCenterY), this.mPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mPaint.getAlpha();
    }

    public int getDrawableAlpha() {
        return this.mPaint.getAlpha();
    }

    public int getDrawableColor() {
        android.graphics.Paint paint = this.mPaint;
        if (paint != null) {
            return paint.getColor();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setDrawableColor(int i) {
        android.graphics.Paint paint = this.mPaint;
        if (paint != null) {
            paint.setColor(i);
        }
        invalidateSelf();
    }

    public void setWidth(java.lang.String str) {
        this.widthStr = str;
    }
}
