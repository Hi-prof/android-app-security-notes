package com.nostra13.dcloudimageloader.core.display;

/* JADX INFO: loaded from: classes.dex */
public class RoundedBitmapDisplayer implements com.nostra13.dcloudimageloader.core.display.BitmapDisplayer {
    private final int roundPixels;

    public RoundedBitmapDisplayer(int i) {
        this.roundPixels = i;
    }

    @Override // com.nostra13.dcloudimageloader.core.display.BitmapDisplayer
    public android.graphics.Bitmap display(android.graphics.Bitmap bitmap, com.nostra13.dcloudimageloader.core.imageaware.ImageAware imageAware, com.nostra13.dcloudimageloader.core.assist.LoadedFrom loadedFrom) {
        if (!(imageAware instanceof com.nostra13.dcloudimageloader.core.imageaware.ImageViewAware)) {
            throw new java.lang.IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
        }
        android.graphics.Bitmap bitmapRoundCorners = roundCorners(bitmap, (com.nostra13.dcloudimageloader.core.imageaware.ImageViewAware) imageAware, this.roundPixels);
        imageAware.setImageBitmap(bitmapRoundCorners);
        return bitmapRoundCorners;
    }

    public static android.graphics.Bitmap roundCorners(android.graphics.Bitmap bitmap, com.nostra13.dcloudimageloader.core.imageaware.ImageViewAware imageViewAware, int i) {
        int i2;
        int iMin;
        android.graphics.Rect rect;
        int i3;
        int i4;
        android.graphics.Rect rect2;
        int i5;
        int i6;
        android.graphics.Rect rect3;
        android.graphics.Rect rect4;
        android.widget.ImageView wrappedView = imageViewAware.getWrappedView();
        if (wrappedView == null) {
            com.nostra13.dcloudimageloader.utils.L.w("View is collected probably. Can't round bitmap corners without view properties.", new java.lang.Object[0]);
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int width2 = imageViewAware.getWidth();
        int height2 = imageViewAware.getHeight();
        if (width2 <= 0) {
            width2 = width;
        }
        if (height2 <= 0) {
            height2 = height;
        }
        android.widget.ImageView.ScaleType scaleType = wrappedView.getScaleType();
        if (scaleType == null) {
            return bitmap;
        }
        int iOrdinal = scaleType.ordinal();
        if (iOrdinal == 1) {
            float f = width;
            float f2 = height;
            if (width2 / height2 > f / f2) {
                iMin = java.lang.Math.min(height2, height);
                i2 = (int) (f / (f2 / iMin));
            } else {
                int iMin2 = java.lang.Math.min(width2, width);
                int i7 = (int) (f2 / (f / iMin2));
                i2 = iMin2;
                iMin = i7;
            }
            int i8 = (width2 - i2) / 2;
            int i9 = (height2 - iMin) / 2;
            android.graphics.Rect rect5 = new android.graphics.Rect(0, 0, width, height);
            rect = new android.graphics.Rect(i8, i9, i2 + i8, iMin + i9);
            i3 = width2;
            i4 = height2;
            rect2 = rect5;
        } else if (iOrdinal != 5) {
            if (iOrdinal == 6) {
                rect3 = new android.graphics.Rect(0, 0, width, height);
                rect4 = new android.graphics.Rect(0, 0, width2, height2);
            } else if (iOrdinal != 7 && iOrdinal != 8) {
                float f3 = width2;
                float f4 = height2;
                float f5 = width;
                float f6 = height;
                if (f3 / f4 > f5 / f6) {
                    width2 = (int) (f5 / (f6 / f4));
                } else {
                    height2 = (int) (f6 / (f5 / f3));
                }
                rect3 = new android.graphics.Rect(0, 0, width, height);
                rect4 = new android.graphics.Rect(0, 0, width2, height2);
            } else {
                width2 = java.lang.Math.min(width2, width);
                height2 = java.lang.Math.min(height2, height);
                int i10 = (width - width2) / 2;
                int i11 = (height - height2) / 2;
                rect3 = new android.graphics.Rect(i10, i11, i10 + width2, i11 + height2);
                rect4 = new android.graphics.Rect(0, 0, width2, height2);
            }
            rect2 = rect3;
            rect = rect4;
            i3 = width2;
            i4 = height2;
        } else {
            float f7 = width2;
            float f8 = height2;
            float f9 = width;
            float f10 = height;
            if (f7 / f8 > f9 / f10) {
                int i12 = (int) (f8 * (f9 / f7));
                i6 = (height - i12) / 2;
                height = i12;
                i5 = 0;
            } else {
                int i13 = (int) (f7 * (f10 / f8));
                int i14 = (width - i13) / 2;
                width = i13;
                i5 = i14;
                i6 = 0;
            }
            android.graphics.Rect rect6 = new android.graphics.Rect(i5, i6, i5 + width, i6 + height);
            rect = new android.graphics.Rect(0, 0, width, height);
            i3 = width;
            i4 = height;
            rect2 = rect6;
        }
        try {
            return getRoundedCornerBitmap(bitmap, i, rect2, rect, i3, i4);
        } catch (java.lang.OutOfMemoryError e) {
            com.nostra13.dcloudimageloader.utils.L.e(e, "Can't create bitmap with rounded corners. Not enough memory.", new java.lang.Object[0]);
            return bitmap;
        }
    }

    private static android.graphics.Bitmap getRoundedCornerBitmap(android.graphics.Bitmap bitmap, int i, android.graphics.Rect rect, android.graphics.Rect rect2, int i2, int i3) {
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(i2, i3, android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
        android.graphics.Paint paint = new android.graphics.Paint();
        android.graphics.RectF rectF = new android.graphics.RectF(rect2);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-16777216);
        float f = i;
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rectF, paint);
        return bitmapCreateBitmap;
    }
}
