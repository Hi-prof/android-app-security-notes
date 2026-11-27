package io.dcloud.feature.nativeObj.photoview.subscaleview.decoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class SkiaImageRegionDecoder implements io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.ImageRegionDecoder {
    private static final java.lang.String ASSET_PREFIX = "file:///android_asset/";
    private static final java.lang.String FILE_PREFIX = "file://";
    private static final java.lang.String RESOURCE_PREFIX = "android.resource://";
    private final android.graphics.Bitmap.Config bitmapConfig;
    private android.graphics.BitmapRegionDecoder decoder;
    private final java.util.concurrent.locks.ReadWriteLock decoderLock;

    public SkiaImageRegionDecoder() {
        this(null);
    }

    @Override // io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.ImageRegionDecoder
    public android.graphics.Bitmap decodeRegion(android.graphics.Rect rect, int i) {
        getDecodeLock().lock();
        try {
            android.graphics.BitmapRegionDecoder bitmapRegionDecoder = this.decoder;
            if (bitmapRegionDecoder == null || bitmapRegionDecoder.isRecycled()) {
                throw new java.lang.IllegalStateException("Cannot decode region after decoder has been recycled");
            }
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inSampleSize = i;
            options.inPreferredConfig = this.bitmapConfig;
            android.graphics.Bitmap bitmapDecodeRegion = this.decoder.decodeRegion(rect, options);
            if (bitmapDecodeRegion == null) {
                throw new java.lang.RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
            }
            getDecodeLock().unlock();
            return bitmapDecodeRegion;
        } catch (java.lang.Throwable th) {
            getDecodeLock().unlock();
            throw th;
        }
    }

    @Override // io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.ImageRegionDecoder
    public android.graphics.Point init(android.content.Context context, android.net.Uri uri) throws java.lang.Exception {
        int identifier;
        java.lang.String string = uri.toString();
        if (string.startsWith(RESOURCE_PREFIX)) {
            java.lang.String authority = uri.getAuthority();
            android.content.res.Resources resources = context.getPackageName().equals(authority) ? context.getResources() : context.getPackageManager().getResourcesForApplication(authority);
            java.util.List<java.lang.String> pathSegments = uri.getPathSegments();
            int size = pathSegments.size();
            if (size == 2 && pathSegments.get(0).equals("drawable")) {
                identifier = resources.getIdentifier(pathSegments.get(1), "drawable", authority);
            } else if (size == 1 && android.text.TextUtils.isDigitsOnly(pathSegments.get(0))) {
                try {
                    identifier = java.lang.Integer.parseInt(pathSegments.get(0));
                } catch (java.lang.NumberFormatException unused) {
                    identifier = 0;
                }
            } else {
                identifier = 0;
            }
            this.decoder = android.graphics.BitmapRegionDecoder.newInstance(context.getResources().openRawResource(identifier), false);
        } else if (string.startsWith("file:///android_asset/")) {
            this.decoder = android.graphics.BitmapRegionDecoder.newInstance(context.getAssets().open(string.substring(22), 1), false);
        } else if (string.startsWith("file://")) {
            this.decoder = android.graphics.BitmapRegionDecoder.newInstance(string.substring(7), false);
        } else {
            java.io.InputStream inputStreamOpenInputStream = null;
            try {
                inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                this.decoder = android.graphics.BitmapRegionDecoder.newInstance(inputStreamOpenInputStream, false);
            } finally {
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (java.lang.Exception unused2) {
                    }
                }
            }
        }
        return new android.graphics.Point(this.decoder.getWidth(), this.decoder.getHeight());
    }

    @Override // io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.ImageRegionDecoder
    public synchronized boolean isReady() {
        android.graphics.BitmapRegionDecoder bitmapRegionDecoder = this.decoder;
        return (bitmapRegionDecoder == null || bitmapRegionDecoder.isRecycled()) ? false : true;
    }

    @Override // io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.ImageRegionDecoder
    public synchronized void recycle() {
        this.decoderLock.writeLock().lock();
        try {
            this.decoder.recycle();
            this.decoder = null;
            this.decoderLock.writeLock().unlock();
        } catch (java.lang.Throwable th) {
            this.decoderLock.writeLock().unlock();
            throw th;
        }
    }

    public SkiaImageRegionDecoder(android.graphics.Bitmap.Config config) {
        this.decoderLock = new java.util.concurrent.locks.ReentrantReadWriteLock(true);
        android.graphics.Bitmap.Config preferredBitmapConfig = io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.getPreferredBitmapConfig();
        if (config != null) {
            this.bitmapConfig = config;
        } else if (preferredBitmapConfig != null) {
            this.bitmapConfig = preferredBitmapConfig;
        } else {
            this.bitmapConfig = android.graphics.Bitmap.Config.RGB_565;
        }
    }

    private java.util.concurrent.locks.Lock getDecodeLock() {
        return this.decoderLock.readLock();
    }
}
