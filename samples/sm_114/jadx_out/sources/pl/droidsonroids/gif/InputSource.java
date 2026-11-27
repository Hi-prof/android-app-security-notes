package pl.droidsonroids.gif;

/* JADX INFO: loaded from: classes2.dex */
public abstract class InputSource {
    abstract pl.droidsonroids.gif.GifInfoHandle open() throws java.io.IOException;

    private InputSource() {
    }

    final pl.droidsonroids.gif.GifDrawable createGifDrawable(pl.droidsonroids.gif.GifDrawable gifDrawable, java.util.concurrent.ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, boolean z, pl.droidsonroids.gif.GifOptions gifOptions) throws java.io.IOException {
        return new pl.droidsonroids.gif.GifDrawable(createHandleWith(gifOptions), gifDrawable, scheduledThreadPoolExecutor, z);
    }

    final pl.droidsonroids.gif.GifInfoHandle createHandleWith(pl.droidsonroids.gif.GifOptions gifOptions) throws java.io.IOException {
        pl.droidsonroids.gif.GifInfoHandle gifInfoHandleOpen = open();
        gifInfoHandleOpen.setOptions(gifOptions.inSampleSize, gifOptions.inIsOpaque);
        return gifInfoHandleOpen;
    }

    public static final class DirectByteBufferSource extends pl.droidsonroids.gif.InputSource {
        private final java.nio.ByteBuffer byteBuffer;

        public DirectByteBufferSource(java.nio.ByteBuffer byteBuffer) {
            super();
            this.byteBuffer = byteBuffer;
        }

        @Override // pl.droidsonroids.gif.InputSource
        pl.droidsonroids.gif.GifInfoHandle open() throws pl.droidsonroids.gif.GifIOException {
            return new pl.droidsonroids.gif.GifInfoHandle(this.byteBuffer);
        }
    }

    public static final class ByteArraySource extends pl.droidsonroids.gif.InputSource {
        private final byte[] bytes;

        public ByteArraySource(byte[] bArr) {
            super();
            this.bytes = bArr;
        }

        @Override // pl.droidsonroids.gif.InputSource
        pl.droidsonroids.gif.GifInfoHandle open() throws pl.droidsonroids.gif.GifIOException {
            return new pl.droidsonroids.gif.GifInfoHandle(this.bytes);
        }
    }

    public static final class FileSource extends pl.droidsonroids.gif.InputSource {
        private final java.lang.String mPath;

        public FileSource(java.io.File file) {
            super();
            this.mPath = file.getPath();
        }

        public FileSource(java.lang.String str) {
            super();
            this.mPath = str;
        }

        @Override // pl.droidsonroids.gif.InputSource
        pl.droidsonroids.gif.GifInfoHandle open() throws pl.droidsonroids.gif.GifIOException {
            return new pl.droidsonroids.gif.GifInfoHandle(this.mPath);
        }
    }

    public static final class UriSource extends pl.droidsonroids.gif.InputSource {
        private final android.content.ContentResolver mContentResolver;
        private final android.net.Uri mUri;

        public UriSource(android.content.ContentResolver contentResolver, android.net.Uri uri) {
            super();
            this.mContentResolver = contentResolver;
            this.mUri = uri;
        }

        @Override // pl.droidsonroids.gif.InputSource
        pl.droidsonroids.gif.GifInfoHandle open() throws java.io.IOException {
            return pl.droidsonroids.gif.GifInfoHandle.openUri(this.mContentResolver, this.mUri);
        }
    }

    public static final class AssetSource extends pl.droidsonroids.gif.InputSource {
        private final android.content.res.AssetManager mAssetManager;
        private final java.lang.String mAssetName;

        public AssetSource(android.content.res.AssetManager assetManager, java.lang.String str) {
            super();
            this.mAssetManager = assetManager;
            this.mAssetName = str;
        }

        @Override // pl.droidsonroids.gif.InputSource
        pl.droidsonroids.gif.GifInfoHandle open() throws java.io.IOException {
            return new pl.droidsonroids.gif.GifInfoHandle(this.mAssetManager.openFd(this.mAssetName));
        }
    }

    public static final class FileDescriptorSource extends pl.droidsonroids.gif.InputSource {
        private final java.io.FileDescriptor mFd;

        public FileDescriptorSource(java.io.FileDescriptor fileDescriptor) {
            super();
            this.mFd = fileDescriptor;
        }

        @Override // pl.droidsonroids.gif.InputSource
        pl.droidsonroids.gif.GifInfoHandle open() throws java.io.IOException {
            return new pl.droidsonroids.gif.GifInfoHandle(this.mFd);
        }
    }

    public static final class InputStreamSource extends pl.droidsonroids.gif.InputSource {
        private final java.io.InputStream inputStream;

        public InputStreamSource(java.io.InputStream inputStream) {
            super();
            this.inputStream = inputStream;
        }

        @Override // pl.droidsonroids.gif.InputSource
        pl.droidsonroids.gif.GifInfoHandle open() throws java.io.IOException {
            return new pl.droidsonroids.gif.GifInfoHandle(this.inputStream);
        }
    }

    public static class ResourcesSource extends pl.droidsonroids.gif.InputSource {
        private final int mResourceId;
        private final android.content.res.Resources mResources;

        public ResourcesSource(android.content.res.Resources resources, int i) {
            super();
            this.mResources = resources;
            this.mResourceId = i;
        }

        @Override // pl.droidsonroids.gif.InputSource
        pl.droidsonroids.gif.GifInfoHandle open() throws java.io.IOException {
            return new pl.droidsonroids.gif.GifInfoHandle(this.mResources.openRawResourceFd(this.mResourceId));
        }
    }

    public static class AssetFileDescriptorSource extends pl.droidsonroids.gif.InputSource {
        private final android.content.res.AssetFileDescriptor mAssetFileDescriptor;

        public AssetFileDescriptorSource(android.content.res.AssetFileDescriptor assetFileDescriptor) {
            super();
            this.mAssetFileDescriptor = assetFileDescriptor;
        }

        @Override // pl.droidsonroids.gif.InputSource
        pl.droidsonroids.gif.GifInfoHandle open() throws java.io.IOException {
            return new pl.droidsonroids.gif.GifInfoHandle(this.mAssetFileDescriptor);
        }
    }
}
