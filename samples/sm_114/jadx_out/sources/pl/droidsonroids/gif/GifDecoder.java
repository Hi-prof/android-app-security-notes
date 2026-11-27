package pl.droidsonroids.gif;

/* JADX INFO: loaded from: classes2.dex */
public class GifDecoder {
    private final pl.droidsonroids.gif.GifInfoHandle mGifInfoHandle;

    public GifDecoder(pl.droidsonroids.gif.InputSource inputSource) throws java.io.IOException {
        this(inputSource, null);
    }

    public GifDecoder(pl.droidsonroids.gif.InputSource inputSource, pl.droidsonroids.gif.GifOptions gifOptions) throws java.io.IOException {
        pl.droidsonroids.gif.GifInfoHandle gifInfoHandleOpen = inputSource.open();
        this.mGifInfoHandle = gifInfoHandleOpen;
        if (gifOptions != null) {
            gifInfoHandleOpen.setOptions(gifOptions.inSampleSize, gifOptions.inIsOpaque);
        }
    }

    public java.lang.String getComment() {
        return this.mGifInfoHandle.getComment();
    }

    public int getLoopCount() {
        return this.mGifInfoHandle.getLoopCount();
    }

    public long getSourceLength() {
        return this.mGifInfoHandle.getSourceLength();
    }

    public void seekToTime(int i, android.graphics.Bitmap bitmap) {
        checkBuffer(bitmap);
        this.mGifInfoHandle.seekToTime(i, bitmap);
    }

    public void seekToFrame(int i, android.graphics.Bitmap bitmap) {
        checkBuffer(bitmap);
        this.mGifInfoHandle.seekToFrame(i, bitmap);
    }

    public long getAllocationByteCount() {
        return this.mGifInfoHandle.getAllocationByteCount();
    }

    public int getFrameDuration(int i) {
        return this.mGifInfoHandle.getFrameDuration(i);
    }

    public int getDuration() {
        return this.mGifInfoHandle.getDuration();
    }

    public int getWidth() {
        return this.mGifInfoHandle.getWidth();
    }

    public int getHeight() {
        return this.mGifInfoHandle.getHeight();
    }

    public int getNumberOfFrames() {
        return this.mGifInfoHandle.getNumberOfFrames();
    }

    public boolean isAnimated() {
        return this.mGifInfoHandle.getNumberOfFrames() > 1 && getDuration() > 0;
    }

    public void recycle() {
        this.mGifInfoHandle.recycle();
    }

    private void checkBuffer(android.graphics.Bitmap bitmap) {
        if (bitmap.isRecycled()) {
            throw new java.lang.IllegalArgumentException("Bitmap is recycled");
        }
        if (bitmap.getWidth() < this.mGifInfoHandle.getWidth() || bitmap.getHeight() < this.mGifInfoHandle.getHeight()) {
            throw new java.lang.IllegalArgumentException("Bitmap ia too small, size must be greater than or equal to GIF size");
        }
        if (bitmap.getConfig() == android.graphics.Bitmap.Config.ARGB_8888) {
            return;
        }
        throw new java.lang.IllegalArgumentException("Only Config.ARGB_8888 is supported. Current bitmap config: " + bitmap.getConfig());
    }
}
