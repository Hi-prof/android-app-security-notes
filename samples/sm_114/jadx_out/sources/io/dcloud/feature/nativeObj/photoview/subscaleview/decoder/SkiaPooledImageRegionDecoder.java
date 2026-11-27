package io.dcloud.feature.nativeObj.photoview.subscaleview.decoder;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class SkiaPooledImageRegionDecoder implements io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.ImageRegionDecoder {
    private static final java.lang.String ASSET_PREFIX = "file:///android_asset/";
    private static final java.lang.String FILE_PREFIX = "file://";
    private static final java.lang.String RESOURCE_PREFIX = "android.resource://";
    private static final java.lang.String TAG = "SkiaPooledImageRegionDecoder";
    private static boolean debug = false;
    private final android.graphics.Bitmap.Config bitmapConfig;
    private android.content.Context context;
    private final java.util.concurrent.locks.ReadWriteLock decoderLock;
    private io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.SkiaPooledImageRegionDecoder.DecoderPool decoderPool;
    private long fileLength;
    private final android.graphics.Point imageDimensions;
    private final java.util.concurrent.atomic.AtomicBoolean lazyInited;
    private android.net.Uri uri;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private static class DecoderPool {
        private final java.util.concurrent.Semaphore available;
        private final java.util.Map<android.graphics.BitmapRegionDecoder, java.lang.Boolean> decoders;

        private DecoderPool() {
            this.available = new java.util.concurrent.Semaphore(0, true);
            this.decoders = new java.util.concurrent.ConcurrentHashMap();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public android.graphics.BitmapRegionDecoder acquire() {
            this.available.acquireUninterruptibly();
            return getNextAvailable();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void add(android.graphics.BitmapRegionDecoder bitmapRegionDecoder) {
            this.decoders.put(bitmapRegionDecoder, java.lang.Boolean.FALSE);
            this.available.release();
        }

        private synchronized android.graphics.BitmapRegionDecoder getNextAvailable() {
            for (java.util.Map.Entry<android.graphics.BitmapRegionDecoder, java.lang.Boolean> entry : this.decoders.entrySet()) {
                if (!entry.getValue().booleanValue()) {
                    entry.setValue(java.lang.Boolean.TRUE);
                    return entry.getKey();
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean isEmpty() {
            return this.decoders.isEmpty();
        }

        private synchronized boolean markAsUnused(android.graphics.BitmapRegionDecoder bitmapRegionDecoder) {
            for (java.util.Map.Entry<android.graphics.BitmapRegionDecoder, java.lang.Boolean> entry : this.decoders.entrySet()) {
                if (bitmapRegionDecoder == entry.getKey()) {
                    if (!entry.getValue().booleanValue()) {
                        return false;
                    }
                    entry.setValue(java.lang.Boolean.FALSE);
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void recycle() {
            while (!this.decoders.isEmpty()) {
                android.graphics.BitmapRegionDecoder bitmapRegionDecoderAcquire = acquire();
                bitmapRegionDecoderAcquire.recycle();
                this.decoders.remove(bitmapRegionDecoderAcquire);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void release(android.graphics.BitmapRegionDecoder bitmapRegionDecoder) {
            if (markAsUnused(bitmapRegionDecoder)) {
                this.available.release();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized int size() {
            return this.decoders.size();
        }
    }

    public SkiaPooledImageRegionDecoder() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void debug(java.lang.String str) {
        if (debug) {
            android.util.Log.d(TAG, str);
        }
    }

    private int getNumCoresOldPhones() {
        try {
            return new java.io.File("/sys/devices/system/cpu/").listFiles(new java.io.FileFilter() { // from class: io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.SkiaPooledImageRegionDecoder.1CpuFilter
                @Override // java.io.FileFilter
                public boolean accept(java.io.File file) {
                    return java.util.regex.Pattern.matches("cpu[0-9]+", file.getName());
                }
            }).length;
        } catch (java.lang.Exception unused) {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initialiseDecoder() throws java.lang.Exception {
        android.graphics.BitmapRegionDecoder bitmapRegionDecoderNewInstance;
        android.graphics.BitmapRegionDecoder bitmapRegionDecoderNewInstance2;
        int identifier;
        java.lang.String string = this.uri.toString();
        long length = Long.MAX_VALUE;
        if (string.startsWith(RESOURCE_PREFIX)) {
            java.lang.String authority = this.uri.getAuthority();
            android.content.res.Resources resources = this.context.getPackageName().equals(authority) ? this.context.getResources() : this.context.getPackageManager().getResourcesForApplication(authority);
            java.util.List<java.lang.String> pathSegments = this.uri.getPathSegments();
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
            try {
                length = this.context.getResources().openRawResourceFd(identifier).getLength();
            } catch (java.lang.Exception unused2) {
            }
            bitmapRegionDecoderNewInstance2 = android.graphics.BitmapRegionDecoder.newInstance(this.context.getResources().openRawResource(identifier), false);
        } else if (string.startsWith("file:///android_asset/")) {
            java.lang.String strSubstring = string.substring(22);
            try {
                length = this.context.getAssets().openFd(strSubstring).getLength();
            } catch (java.lang.Exception unused3) {
            }
            bitmapRegionDecoderNewInstance2 = android.graphics.BitmapRegionDecoder.newInstance(this.context.getAssets().open(strSubstring, 1), false);
        } else {
            if (string.startsWith("file://")) {
                bitmapRegionDecoderNewInstance = android.graphics.BitmapRegionDecoder.newInstance(string.substring(7), false);
                try {
                    java.io.File file = new java.io.File(string);
                    if (file.exists()) {
                        length = file.length();
                    }
                } catch (java.lang.Exception unused4) {
                }
            } else {
                java.io.InputStream inputStreamOpenInputStream = null;
                try {
                    android.content.ContentResolver contentResolver = this.context.getContentResolver();
                    inputStreamOpenInputStream = contentResolver.openInputStream(this.uri);
                    android.graphics.BitmapRegionDecoder bitmapRegionDecoderNewInstance3 = android.graphics.BitmapRegionDecoder.newInstance(inputStreamOpenInputStream, false);
                    try {
                        android.content.res.AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(this.uri, "r");
                        if (assetFileDescriptorOpenAssetFileDescriptor != null) {
                            length = assetFileDescriptorOpenAssetFileDescriptor.getLength();
                        }
                    } catch (java.lang.Exception unused5) {
                    }
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (java.lang.Exception unused6) {
                            bitmapRegionDecoderNewInstance = bitmapRegionDecoderNewInstance3;
                            bitmapRegionDecoderNewInstance2 = bitmapRegionDecoderNewInstance;
                        }
                    }
                    bitmapRegionDecoderNewInstance2 = bitmapRegionDecoderNewInstance3;
                } catch (java.lang.Throwable th) {
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (java.lang.Exception unused7) {
                        }
                    }
                    throw th;
                }
            }
            bitmapRegionDecoderNewInstance2 = bitmapRegionDecoderNewInstance;
        }
        this.fileLength = length;
        this.imageDimensions.set(bitmapRegionDecoderNewInstance2.getWidth(), bitmapRegionDecoderNewInstance2.getHeight());
        this.decoderLock.writeLock().lock();
        try {
            io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.SkiaPooledImageRegionDecoder.DecoderPool decoderPool = this.decoderPool;
            if (decoderPool != null) {
                decoderPool.add(bitmapRegionDecoderNewInstance2);
            }
        } finally {
            this.decoderLock.writeLock().unlock();
        }
    }

    private boolean isLowMemory() {
        android.app.ActivityManager activityManager = (android.app.ActivityManager) this.context.getSystemService("activity");
        if (activityManager == null) {
            return true;
        }
        android.app.ActivityManager.MemoryInfo memoryInfo = new android.app.ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.lowMemory;
    }

    private void lazyInit() {
        if (!this.lazyInited.compareAndSet(false, true) || this.fileLength >= Long.MAX_VALUE) {
            return;
        }
        debug("Starting lazy init of additional decoders");
        new java.lang.Thread() { // from class: io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.SkiaPooledImageRegionDecoder.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                while (io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.SkiaPooledImageRegionDecoder.this.decoderPool != null) {
                    io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.SkiaPooledImageRegionDecoder skiaPooledImageRegionDecoder = io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.SkiaPooledImageRegionDecoder.this;
                    if (!skiaPooledImageRegionDecoder.allowAdditionalDecoder(skiaPooledImageRegionDecoder.decoderPool.size(), io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.SkiaPooledImageRegionDecoder.this.fileLength)) {
                        return;
                    }
                    try {
                        if (io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.SkiaPooledImageRegionDecoder.this.decoderPool != null) {
                            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                            io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.SkiaPooledImageRegionDecoder.this.debug("Starting decoder");
                            io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.SkiaPooledImageRegionDecoder.this.initialiseDecoder();
                            long jCurrentTimeMillis2 = java.lang.System.currentTimeMillis();
                            io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.SkiaPooledImageRegionDecoder.this.debug("Started decoder, took " + (jCurrentTimeMillis2 - jCurrentTimeMillis) + "ms");
                        }
                    } catch (java.lang.Exception e) {
                        io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.SkiaPooledImageRegionDecoder.this.debug("Failed to start decoder: " + e.getMessage());
                    }
                }
            }
        }.start();
    }

    public static void setDebug(boolean z) {
        debug = z;
    }

    protected boolean allowAdditionalDecoder(int i, long j) {
        if (i >= 4) {
            debug("No additional decoders allowed, reached hard limit (4)");
            return false;
        }
        long j2 = ((long) i) * j;
        if (j2 > 20971520) {
            debug("No additional encoders allowed, reached hard memory limit (20Mb)");
            return false;
        }
        if (i >= getNumberOfCores()) {
            debug("No additional encoders allowed, limited by CPU cores (" + getNumberOfCores() + com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
            return false;
        }
        if (isLowMemory()) {
            debug("No additional encoders allowed, memory is low");
            return false;
        }
        debug("Additional decoder allowed, current count is " + i + ", estimated native memory " + (j2 / 1048576) + "Mb");
        return true;
    }

    @Override // io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.ImageRegionDecoder
    public android.graphics.Bitmap decodeRegion(android.graphics.Rect rect, int i) {
        debug("Decode region " + rect + " on thread " + java.lang.Thread.currentThread().getName());
        if (rect.width() < this.imageDimensions.x || rect.height() < this.imageDimensions.y) {
            lazyInit();
        }
        this.decoderLock.readLock().lock();
        try {
            io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.SkiaPooledImageRegionDecoder.DecoderPool decoderPool = this.decoderPool;
            if (decoderPool != null) {
                android.graphics.BitmapRegionDecoder bitmapRegionDecoderAcquire = decoderPool.acquire();
                if (bitmapRegionDecoderAcquire != null) {
                    try {
                        if (!bitmapRegionDecoderAcquire.isRecycled()) {
                            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
                            options.inSampleSize = i;
                            options.inPreferredConfig = this.bitmapConfig;
                            android.graphics.Bitmap bitmapDecodeRegion = bitmapRegionDecoderAcquire.decodeRegion(rect, options);
                            if (bitmapDecodeRegion == null) {
                                throw new java.lang.RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
                            }
                            this.decoderPool.release(bitmapRegionDecoderAcquire);
                            this.decoderLock.readLock().unlock();
                            return bitmapDecodeRegion;
                        }
                    } catch (java.lang.Throwable th) {
                        this.decoderPool.release(bitmapRegionDecoderAcquire);
                        throw th;
                    }
                }
                if (bitmapRegionDecoderAcquire != null) {
                    this.decoderPool.release(bitmapRegionDecoderAcquire);
                }
            }
            throw new java.lang.IllegalStateException("Cannot decode region after decoder has been recycled");
        } catch (java.lang.Throwable th2) {
            this.decoderLock.readLock().unlock();
            throw th2;
        }
    }

    @Override // io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.ImageRegionDecoder
    public android.graphics.Point init(android.content.Context context, android.net.Uri uri) throws java.lang.Exception {
        this.context = context;
        this.uri = uri;
        initialiseDecoder();
        return this.imageDimensions;
    }

    @Override // io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.ImageRegionDecoder
    public synchronized boolean isReady() {
        io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.SkiaPooledImageRegionDecoder.DecoderPool decoderPool = this.decoderPool;
        return (decoderPool == null || decoderPool.isEmpty()) ? false : true;
    }

    @Override // io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.ImageRegionDecoder
    public synchronized void recycle() {
        this.decoderLock.writeLock().lock();
        try {
            io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.SkiaPooledImageRegionDecoder.DecoderPool decoderPool = this.decoderPool;
            if (decoderPool != null) {
                decoderPool.recycle();
                this.decoderPool = null;
                this.context = null;
                this.uri = null;
            }
            this.decoderLock.writeLock().unlock();
        } catch (java.lang.Throwable th) {
            this.decoderLock.writeLock().unlock();
            throw th;
        }
    }

    public SkiaPooledImageRegionDecoder(android.graphics.Bitmap.Config config) {
        this.decoderPool = new io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.SkiaPooledImageRegionDecoder.DecoderPool();
        this.decoderLock = new java.util.concurrent.locks.ReentrantReadWriteLock(true);
        this.fileLength = Long.MAX_VALUE;
        this.imageDimensions = new android.graphics.Point(0, 0);
        this.lazyInited = new java.util.concurrent.atomic.AtomicBoolean(false);
        android.graphics.Bitmap.Config preferredBitmapConfig = io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.getPreferredBitmapConfig();
        if (config != null) {
            this.bitmapConfig = config;
        } else if (preferredBitmapConfig != null) {
            this.bitmapConfig = preferredBitmapConfig;
        } else {
            this.bitmapConfig = android.graphics.Bitmap.Config.RGB_565;
        }
    }

    private int getNumberOfCores() {
        return java.lang.Runtime.getRuntime().availableProcessors();
    }
}
