package io.dcloud.feature.nativeObj;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class BannerImageView extends android.widget.ImageView {
    io.dcloud.feature.nativeObj.data.NativeImageDataItem mImageData;
    android.graphics.Paint mPaint;

    public BannerImageView(android.content.Context context, io.dcloud.feature.nativeObj.data.NativeImageDataItem nativeImageDataItem) {
        super(context);
        this.mPaint = new android.graphics.Paint();
        this.mImageData = nativeImageDataItem;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        float height;
        float width;
        float height2;
        float width2;
        float f;
        canvas.setDrawFilter(new android.graphics.PaintFlagsDrawFilter(0, 3));
        android.graphics.drawable.Drawable drawable = getDrawable();
        if (drawable == null || drawable.getIntrinsicWidth() == 0 || drawable.getIntrinsicHeight() == 0) {
            return;
        }
        android.graphics.Bitmap bitmap = drawable instanceof android.graphics.drawable.BitmapDrawable ? ((android.graphics.drawable.BitmapDrawable) drawable).getBitmap() : null;
        if (bitmap == null) {
            return;
        }
        int saveCount = canvas.getSaveCount();
        canvas.save();
        float f2 = getContext().getResources().getDisplayMetrics().density;
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        if (this.mImageData.height.equals("auto") && this.mImageData.width.equals("auto")) {
            float height3 = getHeight() < getWidth() ? getHeight() / intrinsicHeight : getWidth() / intrinsicWidth;
            width = intrinsicWidth * height3;
            height2 = height3 * intrinsicHeight;
        } else {
            if (this.mImageData.height.equals("auto")) {
                float width3 = this.mImageData.getWidth(getWidth(), f2);
                height = intrinsicHeight * (width3 / intrinsicWidth);
                width = width3;
            } else if (this.mImageData.width.equals("auto")) {
                height2 = this.mImageData.getHeight(getHeight(), f2);
                width = intrinsicWidth * (height2 / intrinsicHeight);
            } else {
                height = this.mImageData.getHeight(getHeight(), f2);
                width = this.mImageData.getWidth(getWidth(), f2);
            }
            height2 = height;
        }
        float height4 = 0.0f;
        if (width == getWidth() || this.mImageData.align.equals("left")) {
            width2 = width;
            f = 0.0f;
        } else if (this.mImageData.align.equals("right")) {
            width2 = getWidth();
            f = width2 - width;
        } else {
            float width4 = (getWidth() - width) / 2.0f;
            float f3 = width + width4;
            f = width4;
            width2 = f3;
        }
        if (height2 != getHeight() && !this.mImageData.verticalAlign.equals("top")) {
            if (this.mImageData.verticalAlign.equals("bottom")) {
                float height5 = getHeight();
                height4 = height5 - height2;
                height2 = height5;
            } else {
                height4 = (getHeight() - height2) / 2.0f;
                height2 += height4;
            }
        }
        canvas.drawBitmap(bitmap, (android.graphics.Rect) null, new android.graphics.RectF(f, height4, width2, height2), this.mPaint);
        canvas.restoreToCount(saveCount);
    }
}
