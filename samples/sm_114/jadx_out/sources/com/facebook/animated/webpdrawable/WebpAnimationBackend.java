package com.facebook.animated.webpdrawable;

/* JADX INFO: loaded from: classes.dex */
public class WebpAnimationBackend implements com.facebook.fresco.animation.backend.AnimationBackend {
    private android.graphics.Rect mBounds;
    private final android.graphics.Rect mRenderDstRect = new android.graphics.Rect();
    private final android.graphics.Rect mRenderSrcRect = new android.graphics.Rect();

    @javax.annotation.Nullable
    private android.graphics.Bitmap mTempBitmap;
    private final com.facebook.animated.webp.WebPImage mWebPImage;

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getSizeInBytes() {
        return 0;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void preloadAnimation() {
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setAlpha(int i) {
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setAnimationListener(@javax.annotation.Nullable com.facebook.fresco.animation.backend.AnimationBackend.Listener listener) {
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void setColorFilter(@javax.annotation.Nullable android.graphics.ColorFilter colorFilter) {
    }

    public static com.facebook.animated.webpdrawable.WebpAnimationBackend create(java.lang.String str) throws java.lang.Throwable {
        java.io.BufferedInputStream bufferedInputStream = null;
        try {
            java.io.BufferedInputStream bufferedInputStream2 = new java.io.BufferedInputStream(new java.io.FileInputStream(str));
            try {
                bufferedInputStream2.mark(Integer.MAX_VALUE);
                byte[] bArr = new byte[bufferedInputStream2.available()];
                bufferedInputStream2.read(bArr);
                com.facebook.animated.webp.WebPImage webPImageCreateFromByteArray = com.facebook.animated.webp.WebPImage.createFromByteArray(bArr, null);
                bufferedInputStream2.reset();
                com.facebook.animated.webpdrawable.WebpAnimationBackend webpAnimationBackend = new com.facebook.animated.webpdrawable.WebpAnimationBackend(webPImageCreateFromByteArray);
                closeSilently(bufferedInputStream2);
                return webpAnimationBackend;
            } catch (java.lang.Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                closeSilently(bufferedInputStream);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private WebpAnimationBackend(com.facebook.animated.webp.WebPImage webPImage) {
        this.mWebPImage = webPImage;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public boolean drawFrame(android.graphics.drawable.Drawable drawable, android.graphics.Canvas canvas, int i) {
        com.facebook.animated.webp.WebPFrame frame = this.mWebPImage.getFrame(i);
        double dWidth = ((double) this.mBounds.width()) / ((double) drawable.getIntrinsicWidth());
        double dHeight = ((double) this.mBounds.height()) / ((double) drawable.getIntrinsicHeight());
        int iRound = (int) java.lang.Math.round(((double) frame.getWidth()) * dWidth);
        int iRound2 = (int) java.lang.Math.round(((double) frame.getHeight()) * dHeight);
        int xOffset = (int) (((double) frame.getXOffset()) * dWidth);
        int yOffset = (int) (((double) frame.getYOffset()) * dHeight);
        synchronized (this) {
            int iWidth = this.mBounds.width();
            int iHeight = this.mBounds.height();
            prepareTempBitmapForThisSize(iWidth, iHeight);
            android.graphics.Bitmap bitmap = this.mTempBitmap;
            if (bitmap == null) {
                return false;
            }
            frame.renderFrame(iRound, iRound2, bitmap);
            this.mRenderSrcRect.set(0, 0, iWidth, iHeight);
            this.mRenderDstRect.set(xOffset, yOffset, iWidth + xOffset, iHeight + yOffset);
            canvas.drawBitmap(this.mTempBitmap, this.mRenderSrcRect, this.mRenderDstRect, (android.graphics.Paint) null);
            return true;
        }
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public synchronized void setBounds(android.graphics.Rect rect) {
        this.mBounds = rect;
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicWidth() {
        return this.mWebPImage.getWidth();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public int getIntrinsicHeight() {
        return this.mWebPImage.getHeight();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationBackend
    public void clear() {
        this.mWebPImage.dispose();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameCount() {
        return this.mWebPImage.getFrameCount();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getFrameDurationMs(int i) {
        return this.mWebPImage.getFrameDurations()[i];
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getLoopDurationMs() {
        return this.mWebPImage.getDuration();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int width() {
        return this.mWebPImage.getWidth();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int height() {
        return this.mWebPImage.getHeight();
    }

    @Override // com.facebook.fresco.animation.backend.AnimationInformation
    public int getLoopCount() {
        return this.mWebPImage.getLoopCount();
    }

    private synchronized void prepareTempBitmapForThisSize(int i, int i2) {
        android.graphics.Bitmap bitmap = this.mTempBitmap;
        if (bitmap != null && (bitmap.getWidth() < i || this.mTempBitmap.getHeight() < i2)) {
            clearTempBitmap();
        }
        if (this.mTempBitmap == null) {
            this.mTempBitmap = android.graphics.Bitmap.createBitmap(i, i2, android.graphics.Bitmap.Config.ARGB_8888);
        }
        this.mTempBitmap.eraseColor(0);
    }

    private synchronized void clearTempBitmap() {
        android.graphics.Bitmap bitmap = this.mTempBitmap;
        if (bitmap != null) {
            bitmap.recycle();
            this.mTempBitmap = null;
        }
    }

    private static void closeSilently(@javax.annotation.Nullable java.io.Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (java.io.IOException unused) {
        }
    }
}
