package pl.droidsonroids.gif;

/* JADX INFO: loaded from: classes2.dex */
final class GifInfoHandle {
    private volatile long gifInfoPtr;

    private static native void bindSurface(long j, android.view.Surface surface, long[] jArr);

    static native int createTempNativeFileDescriptor() throws pl.droidsonroids.gif.GifIOException;

    static native int extractNativeFileDescriptor(java.io.FileDescriptor fileDescriptor, boolean z) throws pl.droidsonroids.gif.GifIOException;

    private static native void free(long j);

    private static native long getAllocationByteCount(long j);

    private static native java.lang.String getComment(long j);

    private static native int getCurrentFrameIndex(long j);

    private static native int getCurrentLoop(long j);

    private static native int getCurrentPosition(long j);

    private static native int getDuration(long j);

    private static native int getFrameDuration(long j, int i);

    private static native int getHeight(long j);

    private static native int getLoopCount(long j);

    private static native long getMetadataByteCount(long j);

    private static native int getNativeErrorCode(long j);

    private static native int getNumberOfFrames(long j);

    private static native long[] getSavedState(long j);

    private static native long getSourceLength(long j);

    private static native int getWidth(long j);

    private static native void glTexImage2D(long j, int i, int i2);

    private static native void glTexSubImage2D(long j, int i, int i2);

    private static native void initTexImageDescriptor(long j);

    private static native boolean isAnimationCompleted(long j);

    private static native boolean isOpaque(long j);

    static native long openByteArray(byte[] bArr) throws pl.droidsonroids.gif.GifIOException;

    static native long openDirectByteBuffer(java.nio.ByteBuffer byteBuffer) throws pl.droidsonroids.gif.GifIOException;

    static native long openFile(java.lang.String str) throws pl.droidsonroids.gif.GifIOException;

    static native long openNativeFileDescriptor(int i, long j) throws pl.droidsonroids.gif.GifIOException;

    static native long openStream(java.io.InputStream inputStream) throws pl.droidsonroids.gif.GifIOException;

    private static native void postUnbindSurface(long j);

    private static native long renderFrame(long j, android.graphics.Bitmap bitmap);

    private static native boolean reset(long j);

    private static native long restoreRemainder(long j);

    private static native int restoreSavedState(long j, long[] jArr, android.graphics.Bitmap bitmap);

    private static native void saveRemainder(long j);

    private static native void seekToFrame(long j, int i, android.graphics.Bitmap bitmap);

    private static native void seekToFrameGL(long j, int i);

    private static native void seekToTime(long j, int i, android.graphics.Bitmap bitmap);

    private static native void setLoopCount(long j, char c);

    private static native void setOptions(long j, char c, boolean z);

    private static native void setSpeedFactor(long j, float f);

    private static native void startDecoderThread(long j);

    private static native void stopDecoderThread(long j);

    static {
        pl.droidsonroids.gif.LibraryLoader.loadLibrary();
    }

    GifInfoHandle() {
    }

    GifInfoHandle(java.io.FileDescriptor fileDescriptor) throws pl.droidsonroids.gif.GifIOException {
        this.gifInfoPtr = openFileDescriptor(fileDescriptor, 0L, true);
    }

    GifInfoHandle(byte[] bArr) throws pl.droidsonroids.gif.GifIOException {
        this.gifInfoPtr = openByteArray(bArr);
    }

    GifInfoHandle(java.nio.ByteBuffer byteBuffer) throws pl.droidsonroids.gif.GifIOException {
        this.gifInfoPtr = openDirectByteBuffer(byteBuffer);
    }

    GifInfoHandle(java.lang.String str) throws pl.droidsonroids.gif.GifIOException {
        this.gifInfoPtr = openFile(str);
    }

    GifInfoHandle(java.io.InputStream inputStream) throws pl.droidsonroids.gif.GifIOException {
        if (!inputStream.markSupported()) {
            throw new java.lang.IllegalArgumentException("InputStream does not support marking");
        }
        this.gifInfoPtr = openStream(inputStream);
    }

    GifInfoHandle(android.content.res.AssetFileDescriptor assetFileDescriptor) throws java.io.IOException {
        try {
            this.gifInfoPtr = openFileDescriptor(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), false);
        } finally {
            try {
                assetFileDescriptor.close();
            } catch (java.io.IOException unused) {
            }
        }
    }

    private static long openFileDescriptor(java.io.FileDescriptor fileDescriptor, long j, boolean z) throws pl.droidsonroids.gif.GifIOException {
        int nativeFileDescriptor;
        if (android.os.Build.VERSION.SDK_INT > 27) {
            try {
                nativeFileDescriptor = getNativeFileDescriptor(fileDescriptor, z);
            } catch (java.lang.Exception e) {
                throw new pl.droidsonroids.gif.GifIOException(pl.droidsonroids.gif.GifError.OPEN_FAILED.errorCode, e.getMessage());
            }
        } else {
            nativeFileDescriptor = extractNativeFileDescriptor(fileDescriptor, z);
        }
        return openNativeFileDescriptor(nativeFileDescriptor, j);
    }

    private static int getNativeFileDescriptor(java.io.FileDescriptor fileDescriptor, boolean z) throws pl.droidsonroids.gif.GifIOException, android.system.ErrnoException {
        try {
            int iCreateTempNativeFileDescriptor = createTempNativeFileDescriptor();
            android.system.Os.dup2(fileDescriptor, iCreateTempNativeFileDescriptor);
            return iCreateTempNativeFileDescriptor;
        } finally {
            if (z) {
                android.system.Os.close(fileDescriptor);
            }
        }
    }

    static pl.droidsonroids.gif.GifInfoHandle openUri(android.content.ContentResolver contentResolver, android.net.Uri uri) throws java.io.IOException {
        if ("file".equals(uri.getScheme())) {
            return new pl.droidsonroids.gif.GifInfoHandle(uri.getPath());
        }
        android.content.res.AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
        if (assetFileDescriptorOpenAssetFileDescriptor == null) {
            throw new java.io.IOException("Could not open AssetFileDescriptor for " + uri);
        }
        return new pl.droidsonroids.gif.GifInfoHandle(assetFileDescriptorOpenAssetFileDescriptor);
    }

    synchronized long renderFrame(android.graphics.Bitmap bitmap) {
        return renderFrame(this.gifInfoPtr, bitmap);
    }

    void bindSurface(android.view.Surface surface, long[] jArr) {
        bindSurface(this.gifInfoPtr, surface, jArr);
    }

    synchronized void recycle() {
        free(this.gifInfoPtr);
        this.gifInfoPtr = 0L;
    }

    synchronized long restoreRemainder() {
        return restoreRemainder(this.gifInfoPtr);
    }

    synchronized boolean reset() {
        return reset(this.gifInfoPtr);
    }

    synchronized void saveRemainder() {
        saveRemainder(this.gifInfoPtr);
    }

    synchronized java.lang.String getComment() {
        return getComment(this.gifInfoPtr);
    }

    synchronized int getLoopCount() {
        return getLoopCount(this.gifInfoPtr);
    }

    void setLoopCount(int i) {
        if (i < 0 || i > 65535) {
            throw new java.lang.IllegalArgumentException("Loop count of range <0, 65535>");
        }
        synchronized (this) {
            setLoopCount(this.gifInfoPtr, (char) i);
        }
    }

    synchronized long getSourceLength() {
        return getSourceLength(this.gifInfoPtr);
    }

    synchronized int getNativeErrorCode() {
        return getNativeErrorCode(this.gifInfoPtr);
    }

    void setSpeedFactor(float f) {
        if (f <= 0.0f || java.lang.Float.isNaN(f)) {
            throw new java.lang.IllegalArgumentException("Speed factor is not positive");
        }
        if (f < 4.656613E-10f) {
            f = 4.656613E-10f;
        }
        synchronized (this) {
            setSpeedFactor(this.gifInfoPtr, f);
        }
    }

    synchronized int getDuration() {
        return getDuration(this.gifInfoPtr);
    }

    synchronized int getCurrentPosition() {
        return getCurrentPosition(this.gifInfoPtr);
    }

    synchronized int getCurrentFrameIndex() {
        return getCurrentFrameIndex(this.gifInfoPtr);
    }

    synchronized int getCurrentLoop() {
        return getCurrentLoop(this.gifInfoPtr);
    }

    synchronized void seekToTime(int i, android.graphics.Bitmap bitmap) {
        seekToTime(this.gifInfoPtr, i, bitmap);
    }

    synchronized void seekToFrame(int i, android.graphics.Bitmap bitmap) {
        seekToFrame(this.gifInfoPtr, i, bitmap);
    }

    synchronized long getAllocationByteCount() {
        return getAllocationByteCount(this.gifInfoPtr);
    }

    synchronized long getMetadataByteCount() {
        return getMetadataByteCount(this.gifInfoPtr);
    }

    synchronized boolean isRecycled() {
        return this.gifInfoPtr == 0;
    }

    protected void finalize() throws java.lang.Throwable {
        try {
            recycle();
        } finally {
            super.finalize();
        }
    }

    synchronized void postUnbindSurface() {
        postUnbindSurface(this.gifInfoPtr);
    }

    synchronized boolean isAnimationCompleted() {
        return isAnimationCompleted(this.gifInfoPtr);
    }

    synchronized long[] getSavedState() {
        return getSavedState(this.gifInfoPtr);
    }

    synchronized int restoreSavedState(long[] jArr, android.graphics.Bitmap bitmap) {
        return restoreSavedState(this.gifInfoPtr, jArr, bitmap);
    }

    synchronized int getFrameDuration(int i) {
        throwIfFrameIndexOutOfBounds(i);
        return getFrameDuration(this.gifInfoPtr, i);
    }

    void setOptions(char c, boolean z) {
        setOptions(this.gifInfoPtr, c, z);
    }

    synchronized int getWidth() {
        return getWidth(this.gifInfoPtr);
    }

    synchronized int getHeight() {
        return getHeight(this.gifInfoPtr);
    }

    synchronized int getNumberOfFrames() {
        return getNumberOfFrames(this.gifInfoPtr);
    }

    synchronized boolean isOpaque() {
        return isOpaque(this.gifInfoPtr);
    }

    void glTexImage2D(int i, int i2) {
        glTexImage2D(this.gifInfoPtr, i, i2);
    }

    void glTexSubImage2D(int i, int i2) {
        glTexSubImage2D(this.gifInfoPtr, i, i2);
    }

    void startDecoderThread() {
        startDecoderThread(this.gifInfoPtr);
    }

    void stopDecoderThread() {
        stopDecoderThread(this.gifInfoPtr);
    }

    void initTexImageDescriptor() {
        initTexImageDescriptor(this.gifInfoPtr);
    }

    void seekToFrameGL(int i) {
        throwIfFrameIndexOutOfBounds(i);
        seekToFrameGL(this.gifInfoPtr, i);
    }

    private void throwIfFrameIndexOutOfBounds(int i) {
        int numberOfFrames = getNumberOfFrames(this.gifInfoPtr);
        if (i < 0 || i >= numberOfFrames) {
            throw new java.lang.IndexOutOfBoundsException("Frame index is not in range <0;" + numberOfFrames + kotlin.text.Typography.greater);
        }
    }
}
