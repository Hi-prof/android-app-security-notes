package pl.droidsonroids.gif;

/* JADX INFO: loaded from: classes2.dex */
public abstract class GifDrawableInit<T extends pl.droidsonroids.gif.GifDrawableInit<T>> {
    private java.util.concurrent.ScheduledThreadPoolExecutor mExecutor;
    private pl.droidsonroids.gif.InputSource mInputSource;
    private pl.droidsonroids.gif.GifDrawable mOldDrawable;
    private boolean mIsRenderingTriggeredOnDraw = true;
    private final pl.droidsonroids.gif.GifOptions mOptions = new pl.droidsonroids.gif.GifOptions();

    protected abstract T self();

    public T sampleSize(int i) {
        this.mOptions.setInSampleSize(i);
        return (T) self();
    }

    public pl.droidsonroids.gif.GifDrawable build() throws java.io.IOException {
        pl.droidsonroids.gif.InputSource inputSource = this.mInputSource;
        if (inputSource == null) {
            throw new java.lang.NullPointerException("Source is not set");
        }
        return inputSource.createGifDrawable(this.mOldDrawable, this.mExecutor, this.mIsRenderingTriggeredOnDraw, this.mOptions);
    }

    public T with(pl.droidsonroids.gif.GifDrawable gifDrawable) {
        this.mOldDrawable = gifDrawable;
        return (T) self();
    }

    public T threadPoolSize(int i) {
        this.mExecutor = new java.util.concurrent.ScheduledThreadPoolExecutor(i);
        return (T) self();
    }

    public T taskExecutor(java.util.concurrent.ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        this.mExecutor = scheduledThreadPoolExecutor;
        return (T) self();
    }

    public T renderingTriggeredOnDraw(boolean z) {
        this.mIsRenderingTriggeredOnDraw = z;
        return (T) self();
    }

    public T setRenderingTriggeredOnDraw(boolean z) {
        return (T) renderingTriggeredOnDraw(z);
    }

    public T options(pl.droidsonroids.gif.GifOptions gifOptions) {
        this.mOptions.setFrom(gifOptions);
        return (T) self();
    }

    public T from(java.io.InputStream inputStream) {
        this.mInputSource = new pl.droidsonroids.gif.InputSource.InputStreamSource(inputStream);
        return (T) self();
    }

    public T from(android.content.res.AssetFileDescriptor assetFileDescriptor) {
        this.mInputSource = new pl.droidsonroids.gif.InputSource.AssetFileDescriptorSource(assetFileDescriptor);
        return (T) self();
    }

    public T from(java.io.FileDescriptor fileDescriptor) {
        this.mInputSource = new pl.droidsonroids.gif.InputSource.FileDescriptorSource(fileDescriptor);
        return (T) self();
    }

    public T from(android.content.res.AssetManager assetManager, java.lang.String str) {
        this.mInputSource = new pl.droidsonroids.gif.InputSource.AssetSource(assetManager, str);
        return (T) self();
    }

    public T from(android.content.ContentResolver contentResolver, android.net.Uri uri) {
        this.mInputSource = new pl.droidsonroids.gif.InputSource.UriSource(contentResolver, uri);
        return (T) self();
    }

    public T from(java.io.File file) {
        this.mInputSource = new pl.droidsonroids.gif.InputSource.FileSource(file);
        return (T) self();
    }

    public T from(java.lang.String str) {
        this.mInputSource = new pl.droidsonroids.gif.InputSource.FileSource(str);
        return (T) self();
    }

    public T from(byte[] bArr) {
        this.mInputSource = new pl.droidsonroids.gif.InputSource.ByteArraySource(bArr);
        return (T) self();
    }

    public T from(java.nio.ByteBuffer byteBuffer) {
        this.mInputSource = new pl.droidsonroids.gif.InputSource.DirectByteBufferSource(byteBuffer);
        return (T) self();
    }

    public T from(android.content.res.Resources resources, int i) {
        this.mInputSource = new pl.droidsonroids.gif.InputSource.ResourcesSource(resources, i);
        return (T) self();
    }

    public pl.droidsonroids.gif.InputSource getInputSource() {
        return this.mInputSource;
    }

    public pl.droidsonroids.gif.GifDrawable getOldDrawable() {
        return this.mOldDrawable;
    }

    public java.util.concurrent.ScheduledThreadPoolExecutor getExecutor() {
        return this.mExecutor;
    }

    public boolean isRenderingTriggeredOnDraw() {
        return this.mIsRenderingTriggeredOnDraw;
    }

    public pl.droidsonroids.gif.GifOptions getOptions() {
        return this.mOptions;
    }
}
