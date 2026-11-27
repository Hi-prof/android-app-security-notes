package pl.droidsonroids.gif;

/* JADX INFO: loaded from: classes2.dex */
public class GifTexImage2D {
    private final pl.droidsonroids.gif.GifInfoHandle mGifInfoHandle;

    public GifTexImage2D(pl.droidsonroids.gif.InputSource inputSource, pl.droidsonroids.gif.GifOptions gifOptions) throws java.io.IOException {
        gifOptions = gifOptions == null ? new pl.droidsonroids.gif.GifOptions() : gifOptions;
        pl.droidsonroids.gif.GifInfoHandle gifInfoHandleOpen = inputSource.open();
        this.mGifInfoHandle = gifInfoHandleOpen;
        gifInfoHandleOpen.setOptions(gifOptions.inSampleSize, gifOptions.inIsOpaque);
        gifInfoHandleOpen.initTexImageDescriptor();
    }

    public int getFrameDuration(int i) {
        return this.mGifInfoHandle.getFrameDuration(i);
    }

    public void seekToFrame(int i) {
        this.mGifInfoHandle.seekToFrameGL(i);
    }

    public int getNumberOfFrames() {
        return this.mGifInfoHandle.getNumberOfFrames();
    }

    public int getCurrentFrameIndex() {
        return this.mGifInfoHandle.getCurrentFrameIndex();
    }

    public void setSpeed(float f) {
        this.mGifInfoHandle.setSpeedFactor(f);
    }

    public void glTexImage2D(int i, int i2) {
        this.mGifInfoHandle.glTexImage2D(i, i2);
    }

    public void glTexSubImage2D(int i, int i2) {
        this.mGifInfoHandle.glTexSubImage2D(i, i2);
    }

    public void startDecoderThread() {
        this.mGifInfoHandle.startDecoderThread();
    }

    public void stopDecoderThread() {
        this.mGifInfoHandle.stopDecoderThread();
    }

    public void recycle() {
        pl.droidsonroids.gif.GifInfoHandle gifInfoHandle = this.mGifInfoHandle;
        if (gifInfoHandle != null) {
            gifInfoHandle.recycle();
        }
    }

    public int getWidth() {
        return this.mGifInfoHandle.getWidth();
    }

    public int getHeight() {
        return this.mGifInfoHandle.getHeight();
    }

    public int getDuration() {
        return this.mGifInfoHandle.getDuration();
    }

    protected final void finalize() throws java.lang.Throwable {
        try {
            recycle();
        } finally {
            super.finalize();
        }
    }
}
