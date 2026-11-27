package pl.droidsonroids.gif;

/* JADX INFO: loaded from: classes2.dex */
public class GifDrawable extends android.graphics.drawable.Drawable implements android.graphics.drawable.Animatable, android.widget.MediaController.MediaPlayerControl {
    final android.graphics.Bitmap mBuffer;
    private final android.graphics.Rect mDstRect;
    final java.util.concurrent.ScheduledThreadPoolExecutor mExecutor;
    final pl.droidsonroids.gif.InvalidationHandler mInvalidationHandler;
    final boolean mIsRenderingTriggeredOnDraw;
    volatile boolean mIsRunning;
    final java.util.concurrent.ConcurrentLinkedQueue<pl.droidsonroids.gif.AnimationListener> mListeners;
    final pl.droidsonroids.gif.GifInfoHandle mNativeInfoHandle;
    long mNextFrameRenderTime;
    protected final android.graphics.Paint mPaint;
    private final pl.droidsonroids.gif.RenderTask mRenderTask;
    java.util.concurrent.ScheduledFuture<?> mRenderTaskSchedule;
    private int mScaledHeight;
    private int mScaledWidth;
    private final android.graphics.Rect mSrcRect;
    private android.content.res.ColorStateList mTint;
    private android.graphics.PorterDuffColorFilter mTintFilter;
    private android.graphics.PorterDuff.Mode mTintMode;
    private pl.droidsonroids.gif.transforms.Transform mTransform;

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        return 100;
    }

    public GifDrawable(android.content.res.Resources resources, int i) throws android.content.res.Resources.NotFoundException, java.io.IOException {
        this(resources.openRawResourceFd(i));
        float densityScale = pl.droidsonroids.gif.GifViewUtils.getDensityScale(resources, i);
        this.mScaledHeight = (int) (this.mNativeInfoHandle.getHeight() * densityScale);
        this.mScaledWidth = (int) (this.mNativeInfoHandle.getWidth() * densityScale);
    }

    public GifDrawable(android.content.res.AssetManager assetManager, java.lang.String str) throws java.io.IOException {
        this(assetManager.openFd(str));
    }

    public GifDrawable(java.lang.String str) throws java.io.IOException {
        this(new pl.droidsonroids.gif.GifInfoHandle(str), null, null, true);
    }

    public GifDrawable(java.io.File file) throws java.io.IOException {
        this(file.getPath());
    }

    public GifDrawable(java.io.InputStream inputStream) throws java.io.IOException {
        this(new pl.droidsonroids.gif.GifInfoHandle(inputStream), null, null, true);
    }

    public GifDrawable(android.content.res.AssetFileDescriptor assetFileDescriptor) throws java.io.IOException {
        this(new pl.droidsonroids.gif.GifInfoHandle(assetFileDescriptor), null, null, true);
    }

    public GifDrawable(java.io.FileDescriptor fileDescriptor) throws java.io.IOException {
        this(new pl.droidsonroids.gif.GifInfoHandle(fileDescriptor), null, null, true);
    }

    public GifDrawable(byte[] bArr) throws java.io.IOException {
        this(new pl.droidsonroids.gif.GifInfoHandle(bArr), null, null, true);
    }

    public GifDrawable(java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
        this(new pl.droidsonroids.gif.GifInfoHandle(byteBuffer), null, null, true);
    }

    public GifDrawable(android.content.ContentResolver contentResolver, android.net.Uri uri) throws java.io.IOException {
        this(pl.droidsonroids.gif.GifInfoHandle.openUri(contentResolver, uri), null, null, true);
    }

    protected GifDrawable(pl.droidsonroids.gif.InputSource inputSource, pl.droidsonroids.gif.GifDrawable gifDrawable, java.util.concurrent.ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, boolean z, pl.droidsonroids.gif.GifOptions gifOptions) throws java.io.IOException {
        this(inputSource.createHandleWith(gifOptions), gifDrawable, scheduledThreadPoolExecutor, z);
    }

    GifDrawable(pl.droidsonroids.gif.GifInfoHandle gifInfoHandle, pl.droidsonroids.gif.GifDrawable gifDrawable, java.util.concurrent.ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, boolean z) {
        this.mIsRunning = true;
        this.mNextFrameRenderTime = Long.MIN_VALUE;
        this.mDstRect = new android.graphics.Rect();
        this.mPaint = new android.graphics.Paint(6);
        this.mListeners = new java.util.concurrent.ConcurrentLinkedQueue<>();
        pl.droidsonroids.gif.RenderTask renderTask = new pl.droidsonroids.gif.RenderTask(this);
        this.mRenderTask = renderTask;
        this.mIsRenderingTriggeredOnDraw = z;
        this.mExecutor = scheduledThreadPoolExecutor == null ? pl.droidsonroids.gif.GifRenderingExecutor.getInstance() : scheduledThreadPoolExecutor;
        this.mNativeInfoHandle = gifInfoHandle;
        android.graphics.Bitmap bitmap = null;
        if (gifDrawable != null) {
            synchronized (gifDrawable.mNativeInfoHandle) {
                if (!gifDrawable.mNativeInfoHandle.isRecycled() && gifDrawable.mNativeInfoHandle.getHeight() >= gifInfoHandle.getHeight() && gifDrawable.mNativeInfoHandle.getWidth() >= gifInfoHandle.getWidth()) {
                    gifDrawable.shutdown();
                    android.graphics.Bitmap bitmap2 = gifDrawable.mBuffer;
                    bitmap2.eraseColor(0);
                    bitmap = bitmap2;
                }
            }
        }
        if (bitmap == null) {
            this.mBuffer = android.graphics.Bitmap.createBitmap(gifInfoHandle.getWidth(), gifInfoHandle.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        } else {
            this.mBuffer = bitmap;
        }
        this.mBuffer.setHasAlpha(!gifInfoHandle.isOpaque());
        this.mSrcRect = new android.graphics.Rect(0, 0, gifInfoHandle.getWidth(), gifInfoHandle.getHeight());
        this.mInvalidationHandler = new pl.droidsonroids.gif.InvalidationHandler(this);
        renderTask.doWork();
        this.mScaledWidth = gifInfoHandle.getWidth();
        this.mScaledHeight = gifInfoHandle.getHeight();
    }

    public void recycle() {
        shutdown();
        this.mBuffer.recycle();
    }

    private void shutdown() {
        this.mIsRunning = false;
        this.mInvalidationHandler.removeMessages(-1);
        this.mNativeInfoHandle.recycle();
    }

    public boolean isRecycled() {
        return this.mNativeInfoHandle.isRecycled();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        scheduleNextRender();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mScaledHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mScaledWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(android.graphics.ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return (!this.mNativeInfoHandle.isOpaque() || this.mPaint.getAlpha() < 255) ? -2 : -1;
    }

    @Override // android.graphics.drawable.Animatable, android.widget.MediaController.MediaPlayerControl
    public void start() {
        synchronized (this) {
            if (this.mIsRunning) {
                return;
            }
            this.mIsRunning = true;
            startAnimation(this.mNativeInfoHandle.restoreRemainder());
        }
    }

    void startAnimation(long j) {
        if (this.mIsRenderingTriggeredOnDraw) {
            this.mNextFrameRenderTime = 0L;
            this.mInvalidationHandler.sendEmptyMessageAtTime(-1, 0L);
        } else {
            cancelPendingRenderTask();
            this.mRenderTaskSchedule = this.mExecutor.schedule(this.mRenderTask, java.lang.Math.max(j, 0L), java.util.concurrent.TimeUnit.MILLISECONDS);
        }
    }

    public void reset() {
        this.mExecutor.execute(new pl.droidsonroids.gif.SafeRunnable(this) { // from class: pl.droidsonroids.gif.GifDrawable.1
            @Override // pl.droidsonroids.gif.SafeRunnable
            public void doWork() {
                if (pl.droidsonroids.gif.GifDrawable.this.mNativeInfoHandle.reset()) {
                    pl.droidsonroids.gif.GifDrawable.this.start();
                }
            }
        });
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        synchronized (this) {
            if (this.mIsRunning) {
                this.mIsRunning = false;
                cancelPendingRenderTask();
                this.mNativeInfoHandle.saveRemainder();
            }
        }
    }

    private void cancelPendingRenderTask() {
        java.util.concurrent.ScheduledFuture<?> scheduledFuture = this.mRenderTaskSchedule;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.mInvalidationHandler.removeMessages(-1);
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mIsRunning;
    }

    public java.lang.String getComment() {
        return this.mNativeInfoHandle.getComment();
    }

    public int getLoopCount() {
        return this.mNativeInfoHandle.getLoopCount();
    }

    public void setLoopCount(int i) {
        this.mNativeInfoHandle.setLoopCount(i);
    }

    public java.lang.String toString() {
        return java.lang.String.format(java.util.Locale.ENGLISH, "GIF: size: %dx%d, frames: %d, error: %d", java.lang.Integer.valueOf(this.mNativeInfoHandle.getWidth()), java.lang.Integer.valueOf(this.mNativeInfoHandle.getHeight()), java.lang.Integer.valueOf(this.mNativeInfoHandle.getNumberOfFrames()), java.lang.Integer.valueOf(this.mNativeInfoHandle.getNativeErrorCode()));
    }

    public int getNumberOfFrames() {
        return this.mNativeInfoHandle.getNumberOfFrames();
    }

    public pl.droidsonroids.gif.GifError getError() {
        return pl.droidsonroids.gif.GifError.fromCode(this.mNativeInfoHandle.getNativeErrorCode());
    }

    public static pl.droidsonroids.gif.GifDrawable createFromResource(android.content.res.Resources resources, int i) {
        try {
            return new pl.droidsonroids.gif.GifDrawable(resources, i);
        } catch (java.io.IOException unused) {
            return null;
        }
    }

    public void setSpeed(float f) {
        this.mNativeInfoHandle.setSpeedFactor(f);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        stop();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        return this.mNativeInfoHandle.getDuration();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        return this.mNativeInfoHandle.getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(final int i) {
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("Position is not positive");
        }
        this.mExecutor.execute(new pl.droidsonroids.gif.SafeRunnable(this) { // from class: pl.droidsonroids.gif.GifDrawable.2
            @Override // pl.droidsonroids.gif.SafeRunnable
            public void doWork() {
                pl.droidsonroids.gif.GifDrawable.this.mNativeInfoHandle.seekToTime(i, pl.droidsonroids.gif.GifDrawable.this.mBuffer);
                this.mGifDrawable.mInvalidationHandler.sendEmptyMessageAtTime(-1, 0L);
            }
        });
    }

    public void seekToBlocking(int i) {
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("Position is not positive");
        }
        synchronized (this.mNativeInfoHandle) {
            this.mNativeInfoHandle.seekToTime(i, this.mBuffer);
        }
        this.mInvalidationHandler.sendEmptyMessageAtTime(-1, 0L);
    }

    public void seekToFrame(final int i) {
        if (i < 0) {
            throw new java.lang.IndexOutOfBoundsException("Frame index is not positive");
        }
        this.mExecutor.execute(new pl.droidsonroids.gif.SafeRunnable(this) { // from class: pl.droidsonroids.gif.GifDrawable.3
            @Override // pl.droidsonroids.gif.SafeRunnable
            public void doWork() {
                pl.droidsonroids.gif.GifDrawable.this.mNativeInfoHandle.seekToFrame(i, pl.droidsonroids.gif.GifDrawable.this.mBuffer);
                pl.droidsonroids.gif.GifDrawable.this.mInvalidationHandler.sendEmptyMessageAtTime(-1, 0L);
            }
        });
    }

    public android.graphics.Bitmap seekToFrameAndGet(int i) {
        android.graphics.Bitmap currentFrame;
        if (i < 0) {
            throw new java.lang.IndexOutOfBoundsException("Frame index is not positive");
        }
        synchronized (this.mNativeInfoHandle) {
            this.mNativeInfoHandle.seekToFrame(i, this.mBuffer);
            currentFrame = getCurrentFrame();
        }
        this.mInvalidationHandler.sendEmptyMessageAtTime(-1, 0L);
        return currentFrame;
    }

    public android.graphics.Bitmap seekToPositionAndGet(int i) {
        android.graphics.Bitmap currentFrame;
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("Position is not positive");
        }
        synchronized (this.mNativeInfoHandle) {
            this.mNativeInfoHandle.seekToTime(i, this.mBuffer);
            currentFrame = getCurrentFrame();
        }
        this.mInvalidationHandler.sendEmptyMessageAtTime(-1, 0L);
        return currentFrame;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return this.mIsRunning;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return getNumberOfFrames() > 1;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return getNumberOfFrames() > 1;
    }

    public int getFrameByteCount() {
        return this.mBuffer.getRowBytes() * this.mBuffer.getHeight();
    }

    public long getAllocationByteCount() {
        return this.mNativeInfoHandle.getAllocationByteCount() + ((long) this.mBuffer.getAllocationByteCount());
    }

    public long getMetadataAllocationByteCount() {
        return this.mNativeInfoHandle.getMetadataByteCount();
    }

    public long getInputSourceByteCount() {
        return this.mNativeInfoHandle.getSourceLength();
    }

    public void getPixels(int[] iArr) {
        this.mBuffer.getPixels(iArr, 0, this.mNativeInfoHandle.getWidth(), 0, 0, this.mNativeInfoHandle.getWidth(), this.mNativeInfoHandle.getHeight());
    }

    public int getPixel(int i, int i2) {
        if (i >= this.mNativeInfoHandle.getWidth()) {
            throw new java.lang.IllegalArgumentException("x must be < width");
        }
        if (i2 >= this.mNativeInfoHandle.getHeight()) {
            throw new java.lang.IllegalArgumentException("y must be < height");
        }
        return this.mBuffer.getPixel(i, i2);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(android.graphics.Rect rect) {
        this.mDstRect.set(rect);
        pl.droidsonroids.gif.transforms.Transform transform = this.mTransform;
        if (transform != null) {
            transform.onBoundsChange(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        boolean z;
        if (this.mTintFilter == null || this.mPaint.getColorFilter() != null) {
            z = false;
        } else {
            this.mPaint.setColorFilter(this.mTintFilter);
            z = true;
        }
        pl.droidsonroids.gif.transforms.Transform transform = this.mTransform;
        if (transform == null) {
            canvas.drawBitmap(this.mBuffer, this.mSrcRect, this.mDstRect, this.mPaint);
        } else {
            transform.onDraw(canvas, this.mPaint, this.mBuffer);
        }
        if (z) {
            this.mPaint.setColorFilter(null);
        }
    }

    private void scheduleNextRender() {
        if (this.mIsRenderingTriggeredOnDraw && this.mIsRunning) {
            long j = this.mNextFrameRenderTime;
            if (j != Long.MIN_VALUE) {
                long jMax = java.lang.Math.max(0L, j - android.os.SystemClock.uptimeMillis());
                this.mNextFrameRenderTime = Long.MIN_VALUE;
                this.mExecutor.remove(this.mRenderTask);
                this.mRenderTaskSchedule = this.mExecutor.schedule(this.mRenderTask, jMax, java.util.concurrent.TimeUnit.MILLISECONDS);
            }
        }
    }

    public final android.graphics.Paint getPaint() {
        return this.mPaint;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mPaint.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.mPaint.setFilterBitmap(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.mPaint.setDither(z);
        invalidateSelf();
    }

    public void addAnimationListener(pl.droidsonroids.gif.AnimationListener animationListener) {
        this.mListeners.add(animationListener);
    }

    public boolean removeAnimationListener(pl.droidsonroids.gif.AnimationListener animationListener) {
        return this.mListeners.remove(animationListener);
    }

    @Override // android.graphics.drawable.Drawable
    public android.graphics.ColorFilter getColorFilter() {
        return this.mPaint.getColorFilter();
    }

    public android.graphics.Bitmap getCurrentFrame() {
        android.graphics.Bitmap bitmap = this.mBuffer;
        android.graphics.Bitmap bitmapCopy = bitmap.copy(bitmap.getConfig(), this.mBuffer.isMutable());
        bitmapCopy.setHasAlpha(this.mBuffer.hasAlpha());
        return bitmapCopy;
    }

    private android.graphics.PorterDuffColorFilter updateTintFilter(android.content.res.ColorStateList colorStateList, android.graphics.PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new android.graphics.PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(android.content.res.ColorStateList colorStateList) {
        this.mTint = colorStateList;
        this.mTintFilter = updateTintFilter(colorStateList, this.mTintMode);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(android.graphics.PorterDuff.Mode mode) {
        this.mTintMode = mode;
        this.mTintFilter = updateTintFilter(this.mTint, mode);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        android.graphics.PorterDuff.Mode mode;
        android.content.res.ColorStateList colorStateList = this.mTint;
        if (colorStateList == null || (mode = this.mTintMode) == null) {
            return false;
        }
        this.mTintFilter = updateTintFilter(colorStateList, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (super.isStateful()) {
            return true;
        }
        android.content.res.ColorStateList colorStateList = this.mTint;
        return colorStateList != null && colorStateList.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (!this.mIsRenderingTriggeredOnDraw) {
            if (z) {
                if (z2) {
                    reset();
                }
                if (visible) {
                    start();
                    return visible;
                }
            } else if (visible) {
                stop();
            }
        }
        return visible;
    }

    public int getCurrentFrameIndex() {
        return this.mNativeInfoHandle.getCurrentFrameIndex();
    }

    public int getCurrentLoop() {
        int currentLoop = this.mNativeInfoHandle.getCurrentLoop();
        return (currentLoop == 0 || currentLoop < this.mNativeInfoHandle.getLoopCount()) ? currentLoop : currentLoop - 1;
    }

    public boolean isAnimationCompleted() {
        return this.mNativeInfoHandle.isAnimationCompleted();
    }

    public int getFrameDuration(int i) {
        return this.mNativeInfoHandle.getFrameDuration(i);
    }

    public void setCornerRadius(float f) {
        pl.droidsonroids.gif.transforms.CornerRadiusTransform cornerRadiusTransform = new pl.droidsonroids.gif.transforms.CornerRadiusTransform(f);
        this.mTransform = cornerRadiusTransform;
        cornerRadiusTransform.onBoundsChange(this.mDstRect);
    }

    public float getCornerRadius() {
        pl.droidsonroids.gif.transforms.Transform transform = this.mTransform;
        if (transform instanceof pl.droidsonroids.gif.transforms.CornerRadiusTransform) {
            return ((pl.droidsonroids.gif.transforms.CornerRadiusTransform) transform).getCornerRadius();
        }
        return 0.0f;
    }

    public void setTransform(pl.droidsonroids.gif.transforms.Transform transform) {
        this.mTransform = transform;
        if (transform != null) {
            transform.onBoundsChange(this.mDstRect);
        }
    }

    public pl.droidsonroids.gif.transforms.Transform getTransform() {
        return this.mTransform;
    }
}
