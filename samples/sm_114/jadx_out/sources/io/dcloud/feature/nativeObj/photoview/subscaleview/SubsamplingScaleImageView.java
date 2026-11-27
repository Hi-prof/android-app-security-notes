package io.dcloud.feature.nativeObj.photoview.subscaleview;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class SubsamplingScaleImageView extends pl.droidsonroids.gif.GifImageView {
    public static final int EASE_IN_OUT_QUAD = 2;
    public static final int EASE_OUT_QUAD = 1;
    private static final int MESSAGE_LONG_CLICK = 1;
    public static final int ORIENTATION_0 = 0;
    public static final int ORIENTATION_180 = 180;
    public static final int ORIENTATION_270 = 270;
    public static final int ORIENTATION_90 = 90;
    public static final int ORIENTATION_USE_EXIF = -1;
    public static final int ORIGIN_ANIM = 1;
    public static final int ORIGIN_DOUBLE_TAP_ZOOM = 4;
    public static final int ORIGIN_FLING = 3;
    public static final int ORIGIN_TOUCH = 2;
    public static final int PAN_LIMIT_CENTER = 3;
    public static final int PAN_LIMIT_INSIDE = 1;
    public static final int PAN_LIMIT_OUTSIDE = 2;
    public static final int SCALE_TYPE_CENTER_CROP = 2;
    public static final int SCALE_TYPE_CENTER_INSIDE = 1;
    public static final int SCALE_TYPE_CUSTOM = 3;
    public static final int SCALE_TYPE_START = 4;
    private static final java.lang.String TAG = "SubsamplingScaleImageView";
    public static final int TILE_SIZE_AUTO = Integer.MAX_VALUE;
    public static final int ZOOM_FOCUS_CENTER = 2;
    public static final int ZOOM_FOCUS_CENTER_IMMEDIATE = 3;
    public static final int ZOOM_FOCUS_FIXED = 1;
    private static android.graphics.Bitmap.Config preferredBitmapConfig;
    private io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.Anim anim;
    private android.graphics.Bitmap bitmap;
    private io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.DecoderFactory<? extends io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.ImageDecoder> bitmapDecoderFactory;
    private boolean bitmapIsCached;
    private boolean bitmapIsPreview;
    private android.graphics.Paint bitmapPaint;
    private boolean debug;
    private android.graphics.Paint debugLinePaint;
    private android.graphics.Paint debugTextPaint;
    private io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.ImageRegionDecoder decoder;
    private final java.util.concurrent.locks.ReadWriteLock decoderLock;
    private final float density;
    private android.view.GestureDetector detector;
    private int doubleTapZoomDuration;
    private float doubleTapZoomScale;
    private int doubleTapZoomStyle;
    private final float[] dstArray;
    private boolean eagerLoadingEnabled;
    private java.util.concurrent.Executor executor;
    private int fullImageSampleSize;
    private final android.os.Handler handler;
    private boolean imageLoadedSent;
    private io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.TilesInited inited;
    private boolean isPanning;
    private boolean isQuickScaling;
    private boolean isZooming;
    private android.graphics.Matrix matrix;
    private float maxScale;
    private int maxTileHeight;
    private int maxTileWidth;
    private int maxTouchCount;
    private float minScale;
    private int minimumScaleType;
    private int minimumTileDpi;
    private io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.OnImageEventListener onImageEventListener;
    private android.view.View.OnLongClickListener onLongClickListener;
    private io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.OnStateChangedListener onStateChangedListener;
    private int orientation;
    private android.graphics.Rect pRegion;
    private boolean panEnabled;
    private int panLimit;
    private java.lang.Float pendingScale;
    private boolean quickScaleEnabled;
    private float quickScaleLastDistance;
    private boolean quickScaleMoved;
    private android.graphics.PointF quickScaleSCenter;
    private final float quickScaleThreshold;
    private android.graphics.PointF quickScaleVLastPoint;
    private android.graphics.PointF quickScaleVStart;
    private boolean readySent;
    private io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.DecoderFactory<? extends io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.ImageRegionDecoder> regionDecoderFactory;
    private int sHeight;
    private int sOrientation;
    private android.graphics.PointF sPendingCenter;
    private android.graphics.RectF sRect;
    private android.graphics.Rect sRegion;
    private android.graphics.PointF sRequestedCenter;
    private int sWidth;
    private io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.ScaleAndTranslate satTemp;
    private float scale;
    private float scaleStart;
    private android.view.GestureDetector singleDetector;
    private final float[] srcArray;
    private android.graphics.Paint tileBgPaint;
    private java.util.Map<java.lang.Integer, java.util.List<io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.Tile>> tileMap;
    private android.net.Uri uri;
    private android.graphics.PointF vCenterStart;
    private float vDistStart;
    private android.graphics.PointF vTranslate;
    private android.graphics.PointF vTranslateBefore;
    private android.graphics.PointF vTranslateStart;
    private boolean zoomEnabled;
    private static final java.util.List<java.lang.Integer> VALID_ORIENTATIONS = java.util.Arrays.asList(0, 90, 180, 270, -1);
    private static final java.util.List<java.lang.Integer> VALID_ZOOM_STYLES = java.util.Arrays.asList(1, 2, 3);
    private static final java.util.List<java.lang.Integer> VALID_EASING_STYLES = java.util.Arrays.asList(2, 1);
    private static final java.util.List<java.lang.Integer> VALID_PAN_LIMITS = java.util.Arrays.asList(1, 2, 3);
    private static final java.util.List<java.lang.Integer> VALID_SCALE_TYPES = java.util.Arrays.asList(2, 1, 3, 4);

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private static class Anim {
        private long duration;
        private int easing;
        private boolean interruptible;
        private io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.OnAnimationEventListener listener;
        private int origin;
        private android.graphics.PointF sCenterEnd;
        private android.graphics.PointF sCenterEndRequested;
        private android.graphics.PointF sCenterStart;
        private float scaleEnd;
        private float scaleStart;
        private long time;
        private android.graphics.PointF vFocusEnd;
        private android.graphics.PointF vFocusStart;

        private Anim() {
            this.duration = 500L;
            this.interruptible = true;
            this.easing = 2;
            this.origin = 1;
            this.time = java.lang.System.currentTimeMillis();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private static class BitmapLoadTask extends android.os.AsyncTask<java.lang.Void, java.lang.Void, java.lang.Integer> {
        private android.graphics.Bitmap bitmap;
        private final java.lang.ref.WeakReference<android.content.Context> contextRef;
        private final java.lang.ref.WeakReference<io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.DecoderFactory<? extends io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.ImageDecoder>> decoderFactoryRef;
        private java.lang.Exception exception;
        private final boolean preview;
        private final android.net.Uri source;
        private final java.lang.ref.WeakReference<io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView> viewRef;

        BitmapLoadTask(io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView subsamplingScaleImageView, android.content.Context context, io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.DecoderFactory<? extends io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.ImageDecoder> decoderFactory, android.net.Uri uri, boolean z) {
            this.viewRef = new java.lang.ref.WeakReference<>(subsamplingScaleImageView);
            this.contextRef = new java.lang.ref.WeakReference<>(context);
            this.decoderFactoryRef = new java.lang.ref.WeakReference<>(decoderFactory);
            this.source = uri;
            this.preview = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public java.lang.Integer doInBackground(java.lang.Void... voidArr) {
            try {
                java.lang.String string = this.source.toString();
                android.content.Context context = this.contextRef.get();
                io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.DecoderFactory<? extends io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.ImageDecoder> decoderFactory = this.decoderFactoryRef.get();
                io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
                if (context == null || decoderFactory == null || subsamplingScaleImageView == null) {
                    return null;
                }
                subsamplingScaleImageView.debug("BitmapLoadTask.doInBackground", new java.lang.Object[0]);
                this.bitmap = decoderFactory.make().decode(context, this.source);
                return java.lang.Integer.valueOf(subsamplingScaleImageView.getExifOrientation(context, string));
            } catch (java.lang.Exception e) {
                android.util.Log.e(io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.TAG, "Failed to load bitmap", e);
                this.exception = e;
                return null;
            } catch (java.lang.OutOfMemoryError e2) {
                android.util.Log.e(io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.TAG, "Failed to load bitmap - OutOfMemoryError", e2);
                this.exception = new java.lang.RuntimeException(e2);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(java.lang.Integer num) {
            io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
            if (subsamplingScaleImageView != null) {
                android.graphics.Bitmap bitmap = this.bitmap;
                if (bitmap != null && num != null) {
                    if (this.preview) {
                        subsamplingScaleImageView.onPreviewLoaded(bitmap);
                        return;
                    } else {
                        subsamplingScaleImageView.onImageLoaded(bitmap, num.intValue(), false);
                        return;
                    }
                }
                if (this.exception == null || subsamplingScaleImageView.onImageEventListener == null) {
                    return;
                }
                if (this.preview) {
                    subsamplingScaleImageView.onImageEventListener.onPreviewLoadError(this.exception);
                } else {
                    subsamplingScaleImageView.onImageEventListener.onImageLoadError(this.exception);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class DefaultOnAnimationEventListener implements io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.OnAnimationEventListener {
        @Override // io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.OnAnimationEventListener
        public void onComplete() {
        }

        @Override // io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.OnAnimationEventListener
        public void onInterruptedByNewAnim() {
        }

        @Override // io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.OnAnimationEventListener
        public void onInterruptedByUser() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class DefaultOnImageEventListener implements io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.OnImageEventListener {
        @Override // io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onImageLoadError(java.lang.Exception exc) {
        }

        @Override // io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onImageLoaded() {
        }

        @Override // io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onPreviewLoadError(java.lang.Exception exc) {
        }

        @Override // io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onPreviewReleased() {
        }

        @Override // io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onReady() {
        }

        @Override // io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onTileLoadError(java.lang.Exception exc) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class DefaultOnStateChangedListener implements io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.OnStateChangedListener {
        @Override // io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.OnStateChangedListener
        public void onCenterChanged(android.graphics.PointF pointF, int i) {
        }

        @Override // io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.OnStateChangedListener
        public void onScaleChanged(float f, int i) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface OnAnimationEventListener {
        void onComplete();

        void onInterruptedByNewAnim();

        void onInterruptedByUser();
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface OnImageEventListener {
        void onImageLoadError(java.lang.Exception exc);

        void onImageLoaded();

        void onPreviewLoadError(java.lang.Exception exc);

        void onPreviewReleased();

        void onReady();

        void onTileLoadError(java.lang.Exception exc);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface OnStateChangedListener {
        void onCenterChanged(android.graphics.PointF pointF, int i);

        void onScaleChanged(float f, int i);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private static class ScaleAndTranslate {
        private float scale;
        private final android.graphics.PointF vTranslate;

        private ScaleAndTranslate(float f, android.graphics.PointF pointF) {
            this.scale = f;
            this.vTranslate = pointF;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private static class Tile {
        private android.graphics.Bitmap bitmap;
        private android.graphics.Rect fileSRect;
        private boolean loading;
        private android.graphics.Rect sRect;
        private int sampleSize;
        private android.graphics.Rect vRect;
        private boolean visible;

        private Tile() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private static class TileLoadTask extends android.os.AsyncTask<java.lang.Void, java.lang.Void, android.graphics.Bitmap> {
        private final java.lang.ref.WeakReference<io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.ImageRegionDecoder> decoderRef;
        private java.lang.Exception exception;
        private final java.lang.ref.WeakReference<io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.Tile> tileRef;
        private final java.lang.ref.WeakReference<io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView> viewRef;

        TileLoadTask(io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView subsamplingScaleImageView, io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.ImageRegionDecoder imageRegionDecoder, io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.Tile tile) {
            this.viewRef = new java.lang.ref.WeakReference<>(subsamplingScaleImageView);
            this.decoderRef = new java.lang.ref.WeakReference<>(imageRegionDecoder);
            this.tileRef = new java.lang.ref.WeakReference<>(tile);
            tile.loading = true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public android.graphics.Bitmap doInBackground(java.lang.Void... voidArr) {
            try {
                io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
                io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.ImageRegionDecoder imageRegionDecoder = this.decoderRef.get();
                io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.Tile tile = this.tileRef.get();
                if (imageRegionDecoder == null || tile == null || subsamplingScaleImageView == null || !imageRegionDecoder.isReady() || !tile.visible) {
                    if (tile == null) {
                        return null;
                    }
                    tile.loading = false;
                    return null;
                }
                subsamplingScaleImageView.debug("TileLoadTask.doInBackground, tile.sRect=%s, tile.sampleSize=%d", tile.sRect, java.lang.Integer.valueOf(tile.sampleSize));
                subsamplingScaleImageView.decoderLock.readLock().lock();
                try {
                    if (!imageRegionDecoder.isReady()) {
                        tile.loading = false;
                        return null;
                    }
                    subsamplingScaleImageView.fileSRect(tile.sRect, tile.fileSRect);
                    if (subsamplingScaleImageView.sRegion != null) {
                        tile.fileSRect.offset(subsamplingScaleImageView.sRegion.left, subsamplingScaleImageView.sRegion.top);
                    }
                    return imageRegionDecoder.decodeRegion(tile.fileSRect, tile.sampleSize);
                } finally {
                    subsamplingScaleImageView.decoderLock.readLock().unlock();
                }
            } catch (java.lang.Exception e) {
                android.util.Log.e(io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.TAG, "Failed to decode tile", e);
                this.exception = e;
                return null;
            } catch (java.lang.OutOfMemoryError e2) {
                android.util.Log.e(io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.TAG, "Failed to decode tile - OutOfMemoryError", e2);
                this.exception = new java.lang.RuntimeException(e2);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(android.graphics.Bitmap bitmap) {
            io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
            io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.Tile tile = this.tileRef.get();
            if (subsamplingScaleImageView == null || tile == null) {
                return;
            }
            if (bitmap != null) {
                tile.bitmap = bitmap;
                tile.loading = false;
                subsamplingScaleImageView.onTileLoaded();
            } else {
                if (this.exception == null || subsamplingScaleImageView.onImageEventListener == null) {
                    return;
                }
                subsamplingScaleImageView.onImageEventListener.onTileLoadError(this.exception);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private static class TilesInitTask extends android.os.AsyncTask<java.lang.Void, java.lang.Void, int[]> {
        private final java.lang.ref.WeakReference<android.content.Context> contextRef;
        private io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.ImageRegionDecoder decoder;
        private final java.lang.ref.WeakReference<io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.DecoderFactory<? extends io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.ImageRegionDecoder>> decoderFactoryRef;
        private java.lang.Exception exception;
        private final android.net.Uri source;
        private final java.lang.ref.WeakReference<io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView> viewRef;

        TilesInitTask(io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView subsamplingScaleImageView, android.content.Context context, io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.DecoderFactory<? extends io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.ImageRegionDecoder> decoderFactory, android.net.Uri uri) {
            this.viewRef = new java.lang.ref.WeakReference<>(subsamplingScaleImageView);
            this.contextRef = new java.lang.ref.WeakReference<>(context);
            this.decoderFactoryRef = new java.lang.ref.WeakReference<>(decoderFactory);
            this.source = uri;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public int[] doInBackground(java.lang.Void... voidArr) {
            try {
                java.lang.String string = this.source.toString();
                android.content.Context context = this.contextRef.get();
                io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.DecoderFactory<? extends io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.ImageRegionDecoder> decoderFactory = this.decoderFactoryRef.get();
                io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
                if (context == null || decoderFactory == null || subsamplingScaleImageView == null) {
                    return null;
                }
                subsamplingScaleImageView.debug("TilesInitTask.doInBackground", new java.lang.Object[0]);
                io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.ImageRegionDecoder imageRegionDecoderMake = decoderFactory.make();
                this.decoder = imageRegionDecoderMake;
                android.graphics.Point pointInit = imageRegionDecoderMake.init(context, this.source);
                int iWidth = pointInit.x;
                int iHeight = pointInit.y;
                int exifOrientation = subsamplingScaleImageView.getExifOrientation(context, string);
                if (subsamplingScaleImageView.sRegion != null) {
                    subsamplingScaleImageView.sRegion.left = java.lang.Math.max(0, subsamplingScaleImageView.sRegion.left);
                    subsamplingScaleImageView.sRegion.top = java.lang.Math.max(0, subsamplingScaleImageView.sRegion.top);
                    subsamplingScaleImageView.sRegion.right = java.lang.Math.min(iWidth, subsamplingScaleImageView.sRegion.right);
                    subsamplingScaleImageView.sRegion.bottom = java.lang.Math.min(iHeight, subsamplingScaleImageView.sRegion.bottom);
                    iWidth = subsamplingScaleImageView.sRegion.width();
                    iHeight = subsamplingScaleImageView.sRegion.height();
                }
                return new int[]{iWidth, iHeight, exifOrientation};
            } catch (java.lang.Exception e) {
                android.util.Log.e(io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.TAG, "Failed to initialise bitmap decoder", e);
                this.exception = e;
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(int[] iArr) {
            io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
            if (subsamplingScaleImageView != null) {
                io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.ImageRegionDecoder imageRegionDecoder = this.decoder;
                if (imageRegionDecoder != null && iArr != null && iArr.length == 3) {
                    subsamplingScaleImageView.onTilesInited(imageRegionDecoder, iArr[0], iArr[1], iArr[2]);
                } else {
                    if (this.exception == null || subsamplingScaleImageView.onImageEventListener == null) {
                        return;
                    }
                    subsamplingScaleImageView.onImageEventListener.onImageLoadError(this.exception);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface TilesInited {
        void onTileInited();
    }

    public SubsamplingScaleImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.orientation = 0;
        this.maxScale = 2.0f;
        this.minScale = minScale();
        this.minimumTileDpi = -1;
        this.panLimit = 1;
        this.minimumScaleType = 3;
        this.maxTileWidth = Integer.MAX_VALUE;
        this.maxTileHeight = Integer.MAX_VALUE;
        this.executor = android.os.AsyncTask.THREAD_POOL_EXECUTOR;
        this.eagerLoadingEnabled = true;
        this.panEnabled = true;
        this.zoomEnabled = true;
        this.quickScaleEnabled = true;
        this.doubleTapZoomScale = 1.0f;
        this.doubleTapZoomStyle = 1;
        this.doubleTapZoomDuration = 200;
        this.decoderLock = new java.util.concurrent.locks.ReentrantReadWriteLock(true);
        this.bitmapDecoderFactory = new io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.CompatDecoderFactory(io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.SkiaImageDecoder.class);
        this.regionDecoderFactory = new io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.CompatDecoderFactory(io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.SkiaImageRegionDecoder.class);
        this.srcArray = new float[8];
        this.dstArray = new float[8];
        this.density = getResources().getDisplayMetrics().density;
        setMinimumDpi(com.alibaba.fastjson.asm.Opcodes.IF_ICMPNE);
        setDoubleTapZoomDpi(com.alibaba.fastjson.asm.Opcodes.IF_ICMPNE);
        setMinimumTileDpi(320);
        setGestureDetector(context);
        this.handler = new android.os.Handler(new android.os.Handler.Callback() { // from class: io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(android.os.Message message) {
                if (message.what == 1 && io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.onLongClickListener != null) {
                    io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.maxTouchCount = 0;
                    io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView subsamplingScaleImageView = io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this;
                    io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.super.setOnLongClickListener(subsamplingScaleImageView.onLongClickListener);
                    io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.performLongClick();
                    io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.super.setOnLongClickListener(null);
                }
                return true;
            }
        });
        this.quickScaleThreshold = android.util.TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
    }

    private int calculateInSampleSize(float f) {
        int iRound;
        if (this.minimumTileDpi > 0) {
            android.util.DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            f *= this.minimumTileDpi / ((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f);
        }
        int iSWidth = (int) (sWidth() * f);
        int iSHeight = (int) (sHeight() * f);
        if (iSWidth == 0 || iSHeight == 0) {
            return 32;
        }
        int i = 1;
        if (sHeight() > iSHeight || sWidth() > iSWidth) {
            iRound = java.lang.Math.round(sHeight() / iSHeight);
            int iRound2 = java.lang.Math.round(sWidth() / iSWidth);
            if (iRound >= iRound2) {
                iRound = iRound2;
            }
        } else {
            iRound = 1;
        }
        while (true) {
            int i2 = i * 2;
            if (i2 >= iRound) {
                return i;
            }
            i = i2;
        }
    }

    private boolean checkImageLoaded() {
        boolean zIsBaseLayerReady = isBaseLayerReady();
        if (!this.imageLoadedSent && zIsBaseLayerReady) {
            preDraw();
            this.imageLoadedSent = true;
            onImageLoaded();
            io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.OnImageEventListener onImageEventListener = this.onImageEventListener;
            if (onImageEventListener != null) {
                onImageEventListener.onImageLoaded();
            }
        }
        return zIsBaseLayerReady;
    }

    private boolean checkReady() {
        boolean z = getWidth() > 0 && getHeight() > 0 && this.sWidth > 0 && this.sHeight > 0 && (this.bitmap != null || isBaseLayerReady());
        if (!this.readySent && z) {
            preDraw();
            this.readySent = true;
            onReady();
            io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.OnImageEventListener onImageEventListener = this.onImageEventListener;
            if (onImageEventListener != null) {
                onImageEventListener.onReady();
            }
        }
        return z;
    }

    private void createPaints() {
        if (this.bitmapPaint == null) {
            android.graphics.Paint paint = new android.graphics.Paint();
            this.bitmapPaint = paint;
            paint.setAntiAlias(true);
            this.bitmapPaint.setFilterBitmap(true);
            this.bitmapPaint.setDither(true);
        }
        if ((this.debugTextPaint == null || this.debugLinePaint == null) && this.debug) {
            android.graphics.Paint paint2 = new android.graphics.Paint();
            this.debugTextPaint = paint2;
            paint2.setTextSize(px(12));
            this.debugTextPaint.setColor(-65281);
            this.debugTextPaint.setStyle(android.graphics.Paint.Style.FILL);
            android.graphics.Paint paint3 = new android.graphics.Paint();
            this.debugLinePaint = paint3;
            paint3.setColor(-65281);
            this.debugLinePaint.setStyle(android.graphics.Paint.Style.STROKE);
            this.debugLinePaint.setStrokeWidth(px(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void debug(java.lang.String str, java.lang.Object... objArr) {
        if (this.debug) {
            android.util.Log.d(TAG, io.dcloud.common.util.StringUtil.format(str, objArr));
        }
    }

    private float distance(float f, float f2, float f3, float f4) {
        float f5 = f - f2;
        float f6 = f3 - f4;
        return (float) java.lang.Math.sqrt((f5 * f5) + (f6 * f6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doubleTapZoom(android.graphics.PointF pointF, android.graphics.PointF pointF2) {
        if (!this.panEnabled) {
            android.graphics.PointF pointF3 = this.sRequestedCenter;
            if (pointF3 != null) {
                pointF.x = pointF3.x;
                pointF.y = pointF3.y;
            } else {
                pointF.x = sWidth() / 2;
                pointF.y = sHeight() / 2;
            }
        }
        float fMin = java.lang.Math.min(this.maxScale, this.doubleTapZoomScale);
        float f = this.scale;
        boolean z = ((double) f) <= ((double) fMin) * 0.9d || f == this.minScale;
        if (!z) {
            fMin = minScale();
        }
        int i = this.doubleTapZoomStyle;
        if (i == 3) {
            setScaleAndCenter(fMin, pointF);
        } else if (i == 2 || !z || !this.panEnabled) {
            new io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.AnimationBuilder(fMin, pointF).withInterruptible(false).withDuration(this.doubleTapZoomDuration).withOrigin(4).start();
        } else if (i == 1) {
            new io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.AnimationBuilder(fMin, pointF, pointF2).withInterruptible(false).withDuration(this.doubleTapZoomDuration).withOrigin(4).start();
        }
        invalidate();
    }

    private float ease(int i, long j, float f, float f2, long j2) {
        if (i == 1) {
            return easeOutQuad(j, f, f2, j2);
        }
        if (i == 2) {
            return easeInOutQuad(j, f, f2, j2);
        }
        throw new java.lang.IllegalStateException("Unexpected easing type: " + i);
    }

    private float easeInOutQuad(long j, float f, float f2, long j2) {
        float f3;
        float f4 = j / (j2 / 2.0f);
        if (f4 < 1.0f) {
            f3 = (f2 / 2.0f) * f4;
        } else {
            float f5 = f4 - 1.0f;
            f3 = (-f2) / 2.0f;
            f4 = (f5 * (f5 - 2.0f)) - 1.0f;
        }
        return (f3 * f4) + f;
    }

    private float easeOutQuad(long j, float f, float f2, long j2) {
        float f3 = j / j2;
        return ((-f2) * f3 * (f3 - 2.0f)) + f;
    }

    private void execute(android.os.AsyncTask<java.lang.Void, java.lang.Void, ?> asyncTask) {
        asyncTask.executeOnExecutor(this.executor, new java.lang.Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fileSRect(android.graphics.Rect rect, android.graphics.Rect rect2) {
        if (getRequiredRotation() == 0) {
            rect2.set(rect);
            return;
        }
        if (getRequiredRotation() == 90) {
            int i = rect.top;
            int i2 = this.sHeight;
            rect2.set(i, i2 - rect.right, rect.bottom, i2 - rect.left);
        } else if (getRequiredRotation() != 180) {
            int i3 = this.sWidth;
            rect2.set(i3 - rect.bottom, rect.left, i3 - rect.top, rect.right);
        } else {
            int i4 = this.sWidth;
            int i5 = i4 - rect.right;
            int i6 = this.sHeight;
            rect2.set(i5, i6 - rect.bottom, i4 - rect.left, i6 - rect.top);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fitToBounds(boolean z, io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.ScaleAndTranslate scaleAndTranslate) {
        float fMax;
        int iMax;
        float fMax2;
        if (this.panLimit == 2 && isReady()) {
            z = false;
        }
        android.graphics.PointF pointF = scaleAndTranslate.vTranslate;
        float fLimitedScale = limitedScale(scaleAndTranslate.scale);
        float fSWidth = sWidth() * fLimitedScale;
        float fSHeight = sHeight() * fLimitedScale;
        if (this.panLimit == 3 && isReady()) {
            pointF.x = java.lang.Math.max(pointF.x, (getWidth() / 2) - fSWidth);
            pointF.y = java.lang.Math.max(pointF.y, (getHeight() / 2) - fSHeight);
        } else if (z) {
            pointF.x = java.lang.Math.max(pointF.x, getWidth() - fSWidth);
            pointF.y = java.lang.Math.max(pointF.y, getHeight() - fSHeight);
        } else {
            pointF.x = java.lang.Math.max(pointF.x, -fSWidth);
            pointF.y = java.lang.Math.max(pointF.y, -fSHeight);
        }
        float paddingLeft = (getPaddingLeft() > 0 || getPaddingRight() > 0) ? getPaddingLeft() / (getPaddingLeft() + getPaddingRight()) : 0.5f;
        float paddingTop = (getPaddingTop() > 0 || getPaddingBottom() > 0) ? getPaddingTop() / (getPaddingTop() + getPaddingBottom()) : 0.5f;
        if (this.panLimit != 3 || !isReady()) {
            if (z) {
                fMax = java.lang.Math.max(0.0f, (getWidth() - fSWidth) * paddingLeft);
                fMax2 = java.lang.Math.max(0.0f, (getHeight() - fSHeight) * paddingTop);
            } else {
                fMax = java.lang.Math.max(0, getWidth());
                iMax = java.lang.Math.max(0, getHeight());
            }
            pointF.x = java.lang.Math.min(pointF.x, fMax);
            pointF.y = java.lang.Math.min(pointF.y, fMax2);
            scaleAndTranslate.scale = fLimitedScale;
        }
        fMax = java.lang.Math.max(0, getWidth() / 2);
        iMax = java.lang.Math.max(0, getHeight() / 2);
        fMax2 = iMax;
        pointF.x = java.lang.Math.min(pointF.x, fMax);
        pointF.y = java.lang.Math.min(pointF.y, fMax2);
        scaleAndTranslate.scale = fLimitedScale;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getExifOrientation(android.content.Context context, java.lang.String str) {
        int i = 0;
        if (str.startsWith(com.facebook.common.util.UriUtil.LOCAL_CONTENT_SCHEME)) {
            android.database.Cursor cursorQuery = null;
            try {
                try {
                    cursorQuery = context.getContentResolver().query(android.net.Uri.parse(str), new java.lang.String[]{"orientation"}, null, null, null);
                    if (cursorQuery != null && cursorQuery.moveToFirst()) {
                        int i2 = cursorQuery.getInt(0);
                        if (!VALID_ORIENTATIONS.contains(java.lang.Integer.valueOf(i2)) || i2 == -1) {
                            android.util.Log.w(TAG, "Unsupported orientation: " + i2);
                        } else {
                            i = i2;
                        }
                    }
                    if (cursorQuery == null) {
                        return i;
                    }
                } catch (java.lang.Exception unused) {
                    android.util.Log.w(TAG, "Could not get orientation of image from media store");
                    return i;
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        } else if (str.startsWith("file:///") && !str.startsWith(io.dcloud.feature.internal.sdk.SDK.ANDROID_ASSET)) {
            try {
                int attributeInt = new android.media.ExifInterface(str.substring(7)).getAttributeInt("Orientation", 1);
                if (attributeInt != 1 && attributeInt != 0) {
                    if (attributeInt == 6) {
                        return 90;
                    }
                    if (attributeInt == 3) {
                        return 180;
                    }
                    if (attributeInt == 8) {
                        return 270;
                    }
                    android.util.Log.w(TAG, "Unsupported EXIF orientation: " + attributeInt);
                }
                return 0;
            } catch (java.lang.Exception unused2) {
                android.util.Log.w(TAG, "Could not get EXIF orientation of image");
            }
        }
        return i;
    }

    private android.graphics.Point getMaxBitmapDimensions(android.graphics.Canvas canvas) {
        return new android.graphics.Point(java.lang.Math.min(canvas.getMaximumBitmapWidth(), this.maxTileWidth), java.lang.Math.min(canvas.getMaximumBitmapHeight(), this.maxTileHeight));
    }

    public static android.graphics.Bitmap.Config getPreferredBitmapConfig() {
        return preferredBitmapConfig;
    }

    private int getRequiredRotation() {
        int i = this.orientation;
        return i == -1 ? this.sOrientation : i;
    }

    private synchronized void initialiseBaseLayer(android.graphics.Point point) throws java.lang.Throwable {
        java.lang.Throwable th;
        try {
            try {
                debug("initialiseBaseLayer maxTileDimensions=%dx%d", java.lang.Integer.valueOf(point.x), java.lang.Integer.valueOf(point.y));
                io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.ScaleAndTranslate scaleAndTranslate = new io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.ScaleAndTranslate(0.0f, new android.graphics.PointF(0.0f, 0.0f));
                this.satTemp = scaleAndTranslate;
                fitToBounds(true, scaleAndTranslate);
                int iCalculateInSampleSize = calculateInSampleSize(this.satTemp.scale);
                this.fullImageSampleSize = iCalculateInSampleSize;
                if (iCalculateInSampleSize > 1) {
                    try {
                        this.fullImageSampleSize = iCalculateInSampleSize / 2;
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                    }
                }
                if (this.fullImageSampleSize == 1 && this.sRegion == null && sWidth() < point.x && sHeight() < point.y) {
                    this.decoder.recycle();
                    this.decoder = null;
                    execute(new io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, this.uri, false));
                    return;
                } else {
                    initialiseTileMap(point);
                    java.util.Iterator<io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.Tile> it = this.tileMap.get(java.lang.Integer.valueOf(this.fullImageSampleSize)).iterator();
                    while (it.hasNext()) {
                        execute(new io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.TileLoadTask(this, this.decoder, it.next()));
                    }
                    refreshRequiredTiles(true);
                    return;
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                th = th;
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
        }
        throw th;
    }

    private void initialiseTileMap(android.graphics.Point point) {
        int i = 1;
        debug("initialiseTileMap maxTileDimensions=%dx%d", java.lang.Integer.valueOf(point.x), java.lang.Integer.valueOf(point.y));
        this.tileMap = new java.util.LinkedHashMap();
        int i2 = this.fullImageSampleSize;
        int i3 = 1;
        int i4 = 1;
        while (true) {
            int iSWidth = sWidth() / i3;
            int iSHeight = sHeight() / i4;
            int i5 = iSWidth / i2;
            int i6 = iSHeight / i2;
            while (true) {
                if (i5 + i3 + i <= point.x && (i5 <= ((double) getWidth()) * 1.25d || i2 >= this.fullImageSampleSize)) {
                    break;
                }
                i3++;
                iSWidth = sWidth() / i3;
                i5 = iSWidth / i2;
            }
            while (true) {
                if (i6 + i4 + i <= point.y && (i6 <= ((double) getHeight()) * 1.25d || i2 >= this.fullImageSampleSize)) {
                    break;
                }
                i4++;
                iSHeight = sHeight() / i4;
                i6 = iSHeight / i2;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList(i3 * i4);
            int i7 = 0;
            while (i7 < i3) {
                int i8 = 0;
                while (i8 < i4) {
                    io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.Tile tile = new io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.Tile();
                    tile.sampleSize = i2;
                    tile.visible = i2 == this.fullImageSampleSize;
                    tile.sRect = new android.graphics.Rect(i7 * iSWidth, i8 * iSHeight, i7 == i3 + (-1) ? sWidth() : (i7 + 1) * iSWidth, i8 == i4 + (-1) ? sHeight() : (i8 + 1) * iSHeight);
                    tile.vRect = new android.graphics.Rect(0, 0, 0, 0);
                    tile.fileSRect = new android.graphics.Rect(tile.sRect);
                    arrayList.add(tile);
                    i8++;
                }
                i7++;
            }
            this.tileMap.put(java.lang.Integer.valueOf(i2), arrayList);
            i = 1;
            if (i2 == 1) {
                return;
            } else {
                i2 /= 2;
            }
        }
    }

    private boolean isBaseLayerReady() {
        boolean z = true;
        if (this.bitmap != null && !this.bitmapIsPreview) {
            return true;
        }
        java.util.Map<java.lang.Integer, java.util.List<io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.Tile>> map = this.tileMap;
        if (map == null) {
            return false;
        }
        for (java.util.Map.Entry<java.lang.Integer, java.util.List<io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.Tile>> entry : map.entrySet()) {
            if (entry.getKey().intValue() == this.fullImageSampleSize) {
                for (io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.Tile tile : entry.getValue()) {
                    if (tile.loading || tile.bitmap == null) {
                        z = false;
                    }
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.graphics.PointF limitedSCenter(float f, float f2, float f3, android.graphics.PointF pointF) {
        android.graphics.PointF pointFVTranslateForSCenter = vTranslateForSCenter(f, f2, f3);
        pointF.set(((getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2)) - pointFVTranslateForSCenter.x) / f3, ((getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2)) - pointFVTranslateForSCenter.y) / f3);
        return pointF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float limitedScale(float f) {
        return java.lang.Math.min(this.maxScale, java.lang.Math.max(minScale(), f));
    }

    private float minScale() {
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int i = this.minimumScaleType;
        if (i == 2 || i == 4) {
            return java.lang.Math.max((getWidth() - paddingLeft) / sWidth(), (getHeight() - paddingBottom) / sHeight());
        }
        if (i == 3) {
            float f = this.minScale;
            if (f > 0.0f) {
                return f;
            }
        }
        return java.lang.Math.min((getWidth() - paddingLeft) / sWidth(), (getHeight() - paddingBottom) / sHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onPreviewLoaded(android.graphics.Bitmap bitmap) {
        debug("onPreviewLoaded", new java.lang.Object[0]);
        if (this.bitmap == null && !this.imageLoadedSent) {
            android.graphics.Rect rect = this.pRegion;
            if (rect != null) {
                this.bitmap = android.graphics.Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), this.pRegion.height());
            } else {
                this.bitmap = bitmap;
            }
            this.bitmapIsPreview = true;
            if (checkReady()) {
                invalidate();
                requestLayout();
                return;
            }
            return;
        }
        bitmap.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onTileLoaded() {
        android.graphics.Bitmap bitmap;
        debug("onTileLoaded", new java.lang.Object[0]);
        checkReady();
        checkImageLoaded();
        if (isBaseLayerReady() && (bitmap = this.bitmap) != null) {
            if (!this.bitmapIsCached) {
                bitmap.recycle();
            }
            this.bitmap = null;
            io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.OnImageEventListener onImageEventListener = this.onImageEventListener;
            if (onImageEventListener != null && this.bitmapIsCached) {
                onImageEventListener.onPreviewReleased();
            }
            this.bitmapIsPreview = false;
            this.bitmapIsCached = false;
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onTilesInited(io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.ImageRegionDecoder imageRegionDecoder, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        debug("onTilesInited sWidth=%d, sHeight=%d, sOrientation=%d", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(this.orientation));
        int i7 = this.sWidth;
        if (i7 > 0 && (i6 = this.sHeight) > 0 && (i7 != i || i6 != i2)) {
            reset(false);
            android.graphics.Bitmap bitmap = this.bitmap;
            if (bitmap != null) {
                if (!this.bitmapIsCached) {
                    bitmap.recycle();
                }
                this.bitmap = null;
                io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.OnImageEventListener onImageEventListener = this.onImageEventListener;
                if (onImageEventListener != null && this.bitmapIsCached) {
                    onImageEventListener.onPreviewReleased();
                }
                this.bitmapIsPreview = false;
                this.bitmapIsCached = false;
            }
        }
        this.decoder = imageRegionDecoder;
        this.sWidth = i;
        this.sHeight = i2;
        this.sOrientation = i3;
        checkReady();
        if (!checkImageLoaded() && (i4 = this.maxTileWidth) > 0 && i4 != Integer.MAX_VALUE && (i5 = this.maxTileHeight) > 0 && i5 != Integer.MAX_VALUE && getWidth() > 0 && getHeight() > 0) {
            initialiseBaseLayer(new android.graphics.Point(this.maxTileWidth, this.maxTileHeight));
        }
        invalidate();
        requestLayout();
        resetAllScale(i, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001f, code lost:
    
        if (r1 != 262) goto L132;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean onTouchEventInternal(android.view.MotionEvent r11) {
        /*
            Method dump skipped, instruction units count: 1187
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.onTouchEventInternal(android.view.MotionEvent):boolean");
    }

    private void preDraw() {
        java.lang.Float f;
        if (getWidth() == 0 || getHeight() == 0 || this.sWidth <= 0 || this.sHeight <= 0) {
            return;
        }
        if (this.sPendingCenter != null && (f = this.pendingScale) != null) {
            this.scale = f.floatValue();
            if (this.vTranslate == null) {
                this.vTranslate = new android.graphics.PointF();
            }
            this.vTranslate.x = (getWidth() / 2) - (this.scale * this.sPendingCenter.x);
            this.vTranslate.y = (getHeight() / 2) - (this.scale * this.sPendingCenter.y);
            this.sPendingCenter = null;
            this.pendingScale = null;
            fitToBounds(true);
            refreshRequiredTiles(true);
        }
        fitToBounds(false);
    }

    private int px(int i) {
        return (int) (this.density * i);
    }

    private void refreshRequiredTiles(boolean z) {
        if (this.decoder == null || this.tileMap == null) {
            return;
        }
        int iMin = java.lang.Math.min(this.fullImageSampleSize, calculateInSampleSize(this.scale));
        java.util.Iterator<java.util.Map.Entry<java.lang.Integer, java.util.List<io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.Tile>>> it = this.tileMap.entrySet().iterator();
        while (it.hasNext()) {
            for (io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.Tile tile : it.next().getValue()) {
                if (tile.sampleSize < iMin || (tile.sampleSize > iMin && tile.sampleSize != this.fullImageSampleSize)) {
                    tile.visible = false;
                    if (tile.bitmap != null) {
                        tile.bitmap.recycle();
                        tile.bitmap = null;
                    }
                }
                if (tile.sampleSize == iMin) {
                    if (tileVisible(tile)) {
                        tile.visible = true;
                        if (!tile.loading && tile.bitmap == null && z) {
                            execute(new io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.TileLoadTask(this, this.decoder, tile));
                        }
                    } else if (tile.sampleSize != this.fullImageSampleSize) {
                        tile.visible = false;
                        if (tile.bitmap != null) {
                            tile.bitmap.recycle();
                            tile.bitmap = null;
                        }
                    }
                } else if (tile.sampleSize == this.fullImageSampleSize) {
                    tile.visible = true;
                }
            }
        }
    }

    private void requestDisallowInterceptTouchEvent(boolean z) {
        android.view.ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private void reset(boolean z) {
        io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.OnImageEventListener onImageEventListener;
        debug("reset newImage=" + z, new java.lang.Object[0]);
        this.scale = 0.0f;
        this.scaleStart = 0.0f;
        this.vTranslate = null;
        this.vTranslateStart = null;
        this.vTranslateBefore = null;
        this.pendingScale = java.lang.Float.valueOf(0.0f);
        this.sPendingCenter = null;
        this.sRequestedCenter = null;
        this.isZooming = false;
        this.isPanning = false;
        this.isQuickScaling = false;
        this.maxTouchCount = 0;
        this.fullImageSampleSize = 0;
        this.vCenterStart = null;
        this.vDistStart = 0.0f;
        this.quickScaleLastDistance = 0.0f;
        this.quickScaleMoved = false;
        this.quickScaleSCenter = null;
        this.quickScaleVLastPoint = null;
        this.quickScaleVStart = null;
        this.anim = null;
        this.satTemp = null;
        this.matrix = null;
        this.sRect = null;
        if (z) {
            this.uri = null;
            this.decoderLock.writeLock().lock();
            try {
                io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.ImageRegionDecoder imageRegionDecoder = this.decoder;
                if (imageRegionDecoder != null) {
                    imageRegionDecoder.recycle();
                    this.decoder = null;
                }
                this.decoderLock.writeLock().unlock();
                android.graphics.Bitmap bitmap = this.bitmap;
                if (bitmap != null && !this.bitmapIsCached) {
                    bitmap.recycle();
                }
                if (this.bitmap != null && this.bitmapIsCached && (onImageEventListener = this.onImageEventListener) != null) {
                    onImageEventListener.onPreviewReleased();
                }
                this.sWidth = 0;
                this.sHeight = 0;
                this.sOrientation = 0;
                this.sRegion = null;
                this.pRegion = null;
                this.readySent = false;
                this.imageLoadedSent = false;
                this.bitmap = null;
                this.bitmapIsPreview = false;
                this.bitmapIsCached = false;
            } catch (java.lang.Throwable th) {
                this.decoderLock.writeLock().unlock();
                throw th;
            }
        }
        java.util.Map<java.lang.Integer, java.util.List<io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.Tile>> map = this.tileMap;
        if (map != null) {
            java.util.Iterator<java.util.Map.Entry<java.lang.Integer, java.util.List<io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.Tile>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                for (io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.Tile tile : it.next().getValue()) {
                    tile.visible = false;
                    if (tile.bitmap != null) {
                        tile.bitmap.recycle();
                        tile.bitmap = null;
                    }
                }
            }
            this.tileMap = null;
        }
        setGestureDetector(getContext());
    }

    private void resetAllScale(int i, int i2) {
        float width = getWidth() / i;
        setMinScale(width);
        float f = width + 4.0f;
        setMaxScale(f);
        setDoubleTapZoomScale(f * 0.9f);
        if (i > getWidth() || i2 > i) {
            return;
        }
        float f2 = i2;
        setDoubleTapZoomScale(getHeight() / f2);
        setMaxScale((getHeight() / f2) / 0.7f);
    }

    private void restoreState(io.dcloud.feature.nativeObj.photoview.subscaleview.ImageViewState imageViewState) {
        if (imageViewState == null || !VALID_ORIENTATIONS.contains(java.lang.Integer.valueOf(imageViewState.getOrientation()))) {
            return;
        }
        this.sPendingCenter = imageViewState.getCenter();
        invalidate();
    }

    private int sHeight() {
        int requiredRotation = getRequiredRotation();
        return (requiredRotation == 90 || requiredRotation == 270) ? this.sWidth : this.sHeight;
    }

    private int sWidth() {
        int requiredRotation = getRequiredRotation();
        return (requiredRotation == 90 || requiredRotation == 270) ? this.sHeight : this.sWidth;
    }

    private void sendStateChanged(float f, android.graphics.PointF pointF, int i) {
        io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.OnStateChangedListener onStateChangedListener = this.onStateChangedListener;
        if (onStateChangedListener != null) {
            float f2 = this.scale;
            if (f2 != f) {
                onStateChangedListener.onScaleChanged(f2, i);
            }
        }
        if (this.onStateChangedListener == null || this.vTranslate.equals(pointF)) {
            return;
        }
        this.onStateChangedListener.onCenterChanged(getCenter(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGestureDetector(final android.content.Context context) {
        this.detector = new android.view.GestureDetector(context, new android.view.GestureDetector.SimpleOnGestureListener() { // from class: io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(android.view.MotionEvent motionEvent) {
                if (!io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.zoomEnabled || !io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.readySent || io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.vTranslate == null) {
                    return super.onDoubleTapEvent(motionEvent);
                }
                io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.setGestureDetector(context);
                if (!io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.quickScaleEnabled) {
                    io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView subsamplingScaleImageView = io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this;
                    subsamplingScaleImageView.doubleTapZoom(subsamplingScaleImageView.viewToSourceCoord(new android.graphics.PointF(motionEvent.getX(), motionEvent.getY())), new android.graphics.PointF(motionEvent.getX(), motionEvent.getY()));
                    return true;
                }
                io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.vCenterStart = new android.graphics.PointF(motionEvent.getX(), motionEvent.getY());
                io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.vTranslateStart = new android.graphics.PointF(io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.vTranslate.x, io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.vTranslate.y);
                io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView subsamplingScaleImageView2 = io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this;
                subsamplingScaleImageView2.scaleStart = subsamplingScaleImageView2.scale;
                io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.isQuickScaling = true;
                io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.isZooming = true;
                io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.quickScaleLastDistance = -1.0f;
                io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView subsamplingScaleImageView3 = io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this;
                subsamplingScaleImageView3.quickScaleSCenter = subsamplingScaleImageView3.viewToSourceCoord(subsamplingScaleImageView3.vCenterStart);
                io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.quickScaleVStart = new android.graphics.PointF(motionEvent.getX(), motionEvent.getY());
                io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.quickScaleVLastPoint = new android.graphics.PointF(io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.quickScaleSCenter.x, io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.quickScaleSCenter.y);
                io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.quickScaleMoved = false;
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f, float f2) {
                if (!io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.panEnabled || !io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.readySent || io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.vTranslate == null || motionEvent == null || motionEvent2 == null || ((java.lang.Math.abs(motionEvent.getX() - motionEvent2.getX()) <= 50.0f && java.lang.Math.abs(motionEvent.getY() - motionEvent2.getY()) <= 50.0f) || ((java.lang.Math.abs(f) <= 500.0f && java.lang.Math.abs(f2) <= 500.0f) || io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.isZooming))) {
                    return super.onFling(motionEvent, motionEvent2, f, f2);
                }
                android.graphics.PointF pointF = new android.graphics.PointF(io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.vTranslate.x + (f * 0.25f), io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.vTranslate.y + (f2 * 0.25f));
                new io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.AnimationBuilder(new android.graphics.PointF(((io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.getWidth() / 2) - pointF.x) / io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.scale, ((io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.getHeight() / 2) - pointF.y) / io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.scale)).withEasing(1).withPanLimited(false).withOrigin(3).start();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(android.view.MotionEvent motionEvent) {
                io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.performClick();
                return true;
            }
        });
        this.singleDetector = new android.view.GestureDetector(context, new android.view.GestureDetector.SimpleOnGestureListener() { // from class: io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(android.view.MotionEvent motionEvent) {
                io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.performLongClick();
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(android.view.MotionEvent motionEvent) {
                io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.performClick();
                return true;
            }
        });
    }

    private void setMatrixArray(float[] fArr, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f3;
        fArr[3] = f4;
        fArr[4] = f5;
        fArr[5] = f6;
        fArr[6] = f7;
        fArr[7] = f8;
    }

    public static void setPreferredBitmapConfig(android.graphics.Bitmap.Config config) {
        preferredBitmapConfig = config;
    }

    private void sourceToViewRect(android.graphics.Rect rect, android.graphics.Rect rect2) {
        rect2.set((int) sourceToViewX(rect.left), (int) sourceToViewY(rect.top), (int) sourceToViewX(rect.right), (int) sourceToViewY(rect.bottom));
    }

    private float sourceToViewX(float f) {
        android.graphics.PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f * this.scale) + pointF.x;
    }

    private float sourceToViewY(float f) {
        android.graphics.PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f * this.scale) + pointF.y;
    }

    private boolean tileVisible(io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.Tile tile) {
        return viewToSourceX(0.0f) <= ((float) tile.sRect.right) && ((float) tile.sRect.left) <= viewToSourceX((float) getWidth()) && viewToSourceY(0.0f) <= ((float) tile.sRect.bottom) && ((float) tile.sRect.top) <= viewToSourceY((float) getHeight());
    }

    private android.graphics.PointF vTranslateForSCenter(float f, float f2, float f3) {
        int paddingLeft = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
        int paddingTop = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
        if (this.satTemp == null) {
            this.satTemp = new io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.ScaleAndTranslate(0.0f, new android.graphics.PointF(0.0f, 0.0f));
        }
        this.satTemp.scale = f3;
        this.satTemp.vTranslate.set(paddingLeft - (f * f3), paddingTop - (f2 * f3));
        fitToBounds(true, this.satTemp);
        return this.satTemp.vTranslate;
    }

    private float viewToSourceX(float f) {
        android.graphics.PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f - pointF.x) / this.scale;
    }

    private float viewToSourceY(float f) {
        android.graphics.PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f - pointF.y) / this.scale;
    }

    public io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.AnimationBuilder animateCenter(android.graphics.PointF pointF) {
        if (isReady()) {
            return new io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.AnimationBuilder(pointF);
        }
        return null;
    }

    public io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.AnimationBuilder animateScale(float f) {
        if (isReady()) {
            return new io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.AnimationBuilder(f);
        }
        return null;
    }

    public io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.AnimationBuilder animateScaleAndCenter(float f, android.graphics.PointF pointF) {
        if (isReady()) {
            return new io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.AnimationBuilder(f, pointF);
        }
        return null;
    }

    public final int getAppliedOrientation() {
        return getRequiredRotation();
    }

    public final android.graphics.PointF getCenter() {
        return viewToSourceCoord(getWidth() / 2, getHeight() / 2);
    }

    public float getMaxScale() {
        return this.maxScale;
    }

    public final float getMinScale() {
        return minScale();
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final void getPanRemaining(android.graphics.RectF rectF) {
        if (isReady()) {
            float fSWidth = this.scale * sWidth();
            float fSHeight = this.scale * sHeight();
            int i = this.panLimit;
            if (i == 3) {
                rectF.top = java.lang.Math.max(0.0f, -(this.vTranslate.y - (getHeight() / 2)));
                rectF.left = java.lang.Math.max(0.0f, -(this.vTranslate.x - (getWidth() / 2)));
                rectF.bottom = java.lang.Math.max(0.0f, this.vTranslate.y - ((getHeight() / 2) - fSHeight));
                rectF.right = java.lang.Math.max(0.0f, this.vTranslate.x - ((getWidth() / 2) - fSWidth));
                return;
            }
            if (i == 2) {
                rectF.top = java.lang.Math.max(0.0f, -(this.vTranslate.y - getHeight()));
                rectF.left = java.lang.Math.max(0.0f, -(this.vTranslate.x - getWidth()));
                rectF.bottom = java.lang.Math.max(0.0f, this.vTranslate.y + fSHeight);
                rectF.right = java.lang.Math.max(0.0f, this.vTranslate.x + fSWidth);
                return;
            }
            rectF.top = java.lang.Math.max(0.0f, -this.vTranslate.y);
            rectF.left = java.lang.Math.max(0.0f, -this.vTranslate.x);
            rectF.bottom = java.lang.Math.max(0.0f, (fSHeight + this.vTranslate.y) - getHeight());
            rectF.right = java.lang.Math.max(0.0f, (fSWidth + this.vTranslate.x) - getWidth());
        }
    }

    public final int getSHeight() {
        return this.sHeight;
    }

    public final int getSWidth() {
        return this.sWidth;
    }

    public final float getScale() {
        return this.scale;
    }

    public final io.dcloud.feature.nativeObj.photoview.subscaleview.ImageViewState getState() {
        if (this.vTranslate == null || this.sWidth <= 0 || this.sHeight <= 0) {
            return null;
        }
        return new io.dcloud.feature.nativeObj.photoview.subscaleview.ImageViewState(getScale(), getCenter(), getOrientation());
    }

    public boolean hasImage() {
        return (this.uri == null && this.bitmap == null) ? false : true;
    }

    public final boolean isImageLoaded() {
        return this.imageLoadedSent;
    }

    public final boolean isPanEnabled() {
        return this.panEnabled;
    }

    public final boolean isQuickScaleEnabled() {
        return this.quickScaleEnabled;
    }

    public final boolean isReady() {
        return this.readySent;
    }

    public final boolean isZoomEnabled() {
        return this.zoomEnabled;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(android.graphics.Canvas canvas) throws java.lang.Throwable {
        int i;
        int i2;
        char c;
        float f;
        int i3;
        super.onDraw(canvas);
        createPaints();
        if (this.sWidth == 0 || this.sHeight == 0 || getWidth() == 0 || getHeight() == 0) {
            return;
        }
        if (this.tileMap == null && this.decoder != null) {
            initialiseBaseLayer(getMaxBitmapDimensions(canvas));
        }
        if (checkReady()) {
            preDraw();
            io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.Anim anim = this.anim;
            if (anim != null && anim.vFocusStart != null) {
                float f2 = this.scale;
                if (this.vTranslateBefore == null) {
                    this.vTranslateBefore = new android.graphics.PointF(0.0f, 0.0f);
                }
                this.vTranslateBefore.set(this.vTranslate);
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - this.anim.time;
                boolean z = jCurrentTimeMillis > this.anim.duration;
                long jMin = java.lang.Math.min(jCurrentTimeMillis, this.anim.duration);
                this.scale = ease(this.anim.easing, jMin, this.anim.scaleStart, this.anim.scaleEnd - this.anim.scaleStart, this.anim.duration);
                float fEase = ease(this.anim.easing, jMin, this.anim.vFocusStart.x, this.anim.vFocusEnd.x - this.anim.vFocusStart.x, this.anim.duration);
                float fEase2 = ease(this.anim.easing, jMin, this.anim.vFocusStart.y, this.anim.vFocusEnd.y - this.anim.vFocusStart.y, this.anim.duration);
                this.vTranslate.x -= sourceToViewX(this.anim.sCenterEnd.x) - fEase;
                this.vTranslate.y -= sourceToViewY(this.anim.sCenterEnd.y) - fEase2;
                fitToBounds(z || this.anim.scaleStart == this.anim.scaleEnd);
                sendStateChanged(f2, this.vTranslateBefore, this.anim.origin);
                refreshRequiredTiles(z);
                if (z) {
                    if (this.anim.listener != null) {
                        try {
                            this.anim.listener.onComplete();
                        } catch (java.lang.Exception e) {
                            android.util.Log.w(TAG, "Error thrown by animation listener", e);
                        }
                    }
                    this.anim = null;
                }
                invalidate();
            }
            if (this.tileMap == null || !isBaseLayerReady()) {
                i = 15;
                i2 = 5;
                c = 0;
                android.graphics.Bitmap bitmap = this.bitmap;
                if (bitmap != null) {
                    float height = this.scale;
                    if (this.bitmapIsPreview) {
                        float width = height * (this.sWidth / bitmap.getWidth());
                        height = this.scale * (this.sHeight / this.bitmap.getHeight());
                        f = width;
                    } else {
                        f = height;
                    }
                    if (this.matrix == null) {
                        this.matrix = new android.graphics.Matrix();
                    }
                    this.matrix.reset();
                    this.matrix.postScale(f, height);
                    this.matrix.postRotate(getRequiredRotation());
                    android.graphics.Matrix matrix = this.matrix;
                    android.graphics.PointF pointF = this.vTranslate;
                    matrix.postTranslate(pointF.x, pointF.y);
                    if (getRequiredRotation() == 180) {
                        android.graphics.Matrix matrix2 = this.matrix;
                        float f3 = this.scale;
                        matrix2.postTranslate(this.sWidth * f3, f3 * this.sHeight);
                    } else if (getRequiredRotation() == 90) {
                        this.matrix.postTranslate(this.scale * this.sHeight, 0.0f);
                    } else if (getRequiredRotation() == 270) {
                        this.matrix.postTranslate(0.0f, this.scale * this.sWidth);
                    }
                    if (this.tileBgPaint != null) {
                        if (this.sRect == null) {
                            this.sRect = new android.graphics.RectF();
                        }
                        this.sRect.set(0.0f, 0.0f, this.bitmapIsPreview ? this.bitmap.getWidth() : this.sWidth, this.bitmapIsPreview ? this.bitmap.getHeight() : this.sHeight);
                        this.matrix.mapRect(this.sRect);
                        canvas.drawRect(this.sRect, this.tileBgPaint);
                    }
                    canvas.drawBitmap(this.bitmap, this.matrix, this.bitmapPaint);
                }
            } else {
                int iMin = java.lang.Math.min(this.fullImageSampleSize, calculateInSampleSize(this.scale));
                boolean z2 = false;
                for (java.util.Map.Entry<java.lang.Integer, java.util.List<io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.Tile>> entry : this.tileMap.entrySet()) {
                    if (entry.getKey().intValue() == iMin) {
                        for (io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.Tile tile : entry.getValue()) {
                            if (tile.visible && (tile.loading || tile.bitmap == null)) {
                                z2 = true;
                            }
                        }
                    }
                }
                for (java.util.Map.Entry<java.lang.Integer, java.util.List<io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.Tile>> entry2 : this.tileMap.entrySet()) {
                    if (entry2.getKey().intValue() == iMin || z2) {
                        for (io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.Tile tile2 : entry2.getValue()) {
                            sourceToViewRect(tile2.sRect, tile2.vRect);
                            if (tile2.loading || tile2.bitmap == null) {
                                i3 = 5;
                                if (tile2.loading && this.debug) {
                                    canvas.drawText("LOADING", tile2.vRect.left + px(5), tile2.vRect.top + px(35), this.debugTextPaint);
                                }
                            } else {
                                if (this.tileBgPaint != null) {
                                    canvas.drawRect(tile2.vRect, this.tileBgPaint);
                                }
                                if (this.matrix == null) {
                                    this.matrix = new android.graphics.Matrix();
                                }
                                this.matrix.reset();
                                i3 = 5;
                                setMatrixArray(this.srcArray, 0.0f, 0.0f, tile2.bitmap.getWidth(), 0.0f, tile2.bitmap.getWidth(), tile2.bitmap.getHeight(), 0.0f, tile2.bitmap.getHeight());
                                if (getRequiredRotation() == 0) {
                                    setMatrixArray(this.dstArray, tile2.vRect.left, tile2.vRect.top, tile2.vRect.right, tile2.vRect.top, tile2.vRect.right, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.bottom);
                                } else if (getRequiredRotation() == 90) {
                                    setMatrixArray(this.dstArray, tile2.vRect.right, tile2.vRect.top, tile2.vRect.right, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.top);
                                } else if (getRequiredRotation() == 180) {
                                    setMatrixArray(this.dstArray, tile2.vRect.right, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.top, tile2.vRect.right, tile2.vRect.top);
                                } else if (getRequiredRotation() == 270) {
                                    setMatrixArray(this.dstArray, tile2.vRect.left, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.top, tile2.vRect.right, tile2.vRect.top, tile2.vRect.right, tile2.vRect.bottom);
                                }
                                this.matrix.setPolyToPoly(this.srcArray, 0, this.dstArray, 0, 4);
                                canvas.drawBitmap(tile2.bitmap, this.matrix, this.bitmapPaint);
                                if (this.debug) {
                                    canvas.drawRect(tile2.vRect, this.debugLinePaint);
                                }
                            }
                            if (tile2.visible && this.debug) {
                                canvas.drawText("ISS " + tile2.sampleSize + " RECT " + tile2.sRect.top + "," + tile2.sRect.left + "," + tile2.sRect.bottom + "," + tile2.sRect.right, tile2.vRect.left + px(i3), tile2.vRect.top + px(15), this.debugTextPaint);
                            }
                        }
                    }
                }
                i = 15;
                i2 = 5;
                c = 0;
            }
            if (this.debug) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder("Scale: ");
                java.util.Locale locale = java.util.Locale.ENGLISH;
                java.lang.Object[] objArr = new java.lang.Object[1];
                objArr[c] = java.lang.Float.valueOf(this.scale);
                sb.append(java.lang.String.format(locale, "%.2f", objArr));
                sb.append(" (");
                java.lang.Object[] objArr2 = new java.lang.Object[1];
                objArr2[c] = java.lang.Float.valueOf(minScale());
                sb.append(java.lang.String.format(locale, "%.2f", objArr2));
                sb.append(" - ");
                java.lang.Object[] objArr3 = new java.lang.Object[1];
                objArr3[c] = java.lang.Float.valueOf(this.maxScale);
                sb.append(java.lang.String.format(locale, "%.2f", objArr3));
                sb.append(com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
                canvas.drawText(sb.toString(), px(i2), px(i), this.debugTextPaint);
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder("Translate: ");
                java.lang.Object[] objArr4 = new java.lang.Object[1];
                objArr4[c] = java.lang.Float.valueOf(this.vTranslate.x);
                sb2.append(java.lang.String.format(locale, "%.2f", objArr4));
                sb2.append(":");
                java.lang.Object[] objArr5 = new java.lang.Object[1];
                objArr5[c] = java.lang.Float.valueOf(this.vTranslate.y);
                sb2.append(java.lang.String.format(locale, "%.2f", objArr5));
                canvas.drawText(sb2.toString(), px(i2), px(30), this.debugTextPaint);
                android.graphics.PointF center = getCenter();
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder("Source center: ");
                java.lang.Object[] objArr6 = new java.lang.Object[1];
                objArr6[c] = java.lang.Float.valueOf(center.x);
                sb3.append(java.lang.String.format(locale, "%.2f", objArr6));
                sb3.append(":");
                java.lang.Object[] objArr7 = new java.lang.Object[1];
                objArr7[c] = java.lang.Float.valueOf(center.y);
                sb3.append(java.lang.String.format(locale, "%.2f", objArr7));
                canvas.drawText(sb3.toString(), px(i2), px(45), this.debugTextPaint);
                io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.Anim anim2 = this.anim;
                if (anim2 != null) {
                    android.graphics.PointF pointFSourceToViewCoord = sourceToViewCoord(anim2.sCenterStart);
                    android.graphics.PointF pointFSourceToViewCoord2 = sourceToViewCoord(this.anim.sCenterEndRequested);
                    android.graphics.PointF pointFSourceToViewCoord3 = sourceToViewCoord(this.anim.sCenterEnd);
                    canvas.drawCircle(pointFSourceToViewCoord.x, pointFSourceToViewCoord.y, px(10), this.debugLinePaint);
                    this.debugLinePaint.setColor(-65536);
                    canvas.drawCircle(pointFSourceToViewCoord2.x, pointFSourceToViewCoord2.y, px(20), this.debugLinePaint);
                    this.debugLinePaint.setColor(-16776961);
                    canvas.drawCircle(pointFSourceToViewCoord3.x, pointFSourceToViewCoord3.y, px(25), this.debugLinePaint);
                    this.debugLinePaint.setColor(-16711681);
                    canvas.drawCircle(getWidth() / 2, getHeight() / 2, px(30), this.debugLinePaint);
                }
                if (this.vCenterStart != null) {
                    this.debugLinePaint.setColor(-65536);
                    android.graphics.PointF pointF2 = this.vCenterStart;
                    canvas.drawCircle(pointF2.x, pointF2.y, px(20), this.debugLinePaint);
                }
                if (this.quickScaleSCenter != null) {
                    this.debugLinePaint.setColor(-16776961);
                    canvas.drawCircle(sourceToViewX(this.quickScaleSCenter.x), sourceToViewY(this.quickScaleSCenter.y), px(35), this.debugLinePaint);
                }
                if (this.quickScaleVStart != null && this.isQuickScaling) {
                    this.debugLinePaint.setColor(-16711681);
                    android.graphics.PointF pointF3 = this.quickScaleVStart;
                    canvas.drawCircle(pointF3.x, pointF3.y, px(30), this.debugLinePaint);
                }
                this.debugLinePaint.setColor(-65281);
            }
        }
    }

    protected void onImageLoaded() {
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = android.view.View.MeasureSpec.getMode(i);
        int mode2 = android.view.View.MeasureSpec.getMode(i2);
        int size = android.view.View.MeasureSpec.getSize(i);
        int size2 = android.view.View.MeasureSpec.getSize(i2);
        boolean z = mode != 1073741824;
        boolean z2 = mode2 != 1073741824;
        if (this.sWidth > 0 && this.sHeight > 0) {
            if (z && z2) {
                size = sWidth();
                size2 = sHeight();
            } else if (z2) {
                size2 = (int) ((((double) sHeight()) / ((double) sWidth())) * ((double) size));
            } else if (z) {
                size = (int) ((((double) sWidth()) / ((double) sHeight())) * ((double) size2));
            }
        }
        setMeasuredDimension(java.lang.Math.max(size, getSuggestedMinimumWidth()), java.lang.Math.max(size2, getSuggestedMinimumHeight()));
    }

    protected void onReady() {
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        debug("onSizeChanged %dx%d -> %dx%d", java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i4), java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2));
        android.graphics.PointF center = getCenter();
        if (!this.readySent || center == null) {
            return;
        }
        this.anim = null;
        this.pendingScale = java.lang.Float.valueOf(this.scale);
        this.sPendingCenter = center;
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        android.view.GestureDetector gestureDetector;
        io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.Anim anim = this.anim;
        if (anim != null && !anim.interruptible) {
            requestDisallowInterceptTouchEvent(true);
            return true;
        }
        io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.Anim anim2 = this.anim;
        if (anim2 != null && anim2.listener != null) {
            try {
                this.anim.listener.onInterruptedByUser();
            } catch (java.lang.Exception e) {
                android.util.Log.w(TAG, "Error thrown by animation listener", e);
            }
        }
        this.anim = null;
        if (this.vTranslate == null) {
            android.view.GestureDetector gestureDetector2 = this.singleDetector;
            if (gestureDetector2 != null) {
                gestureDetector2.onTouchEvent(motionEvent);
            }
            return true;
        }
        if (!this.isQuickScaling && ((gestureDetector = this.detector) == null || gestureDetector.onTouchEvent(motionEvent))) {
            this.isZooming = false;
            this.isPanning = false;
            this.maxTouchCount = 0;
            return true;
        }
        if (this.vTranslateStart == null) {
            this.vTranslateStart = new android.graphics.PointF(0.0f, 0.0f);
        }
        if (this.vTranslateBefore == null) {
            this.vTranslateBefore = new android.graphics.PointF(0.0f, 0.0f);
        }
        if (this.vCenterStart == null) {
            this.vCenterStart = new android.graphics.PointF(0.0f, 0.0f);
        }
        float f = this.scale;
        this.vTranslateBefore.set(this.vTranslate);
        boolean zOnTouchEventInternal = onTouchEventInternal(motionEvent);
        sendStateChanged(f, this.vTranslateBefore, 2);
        return zOnTouchEventInternal || super.onTouchEvent(motionEvent);
    }

    public void recycle() {
        reset(true);
        this.bitmapPaint = null;
        this.debugTextPaint = null;
        this.debugLinePaint = null;
        this.tileBgPaint = null;
    }

    public final void resetScaleAndCenter() {
        this.anim = null;
        this.pendingScale = java.lang.Float.valueOf(limitedScale(0.0f));
        if (isReady()) {
            this.sPendingCenter = new android.graphics.PointF(sWidth() / 2, sHeight() / 2);
        } else {
            this.sPendingCenter = new android.graphics.PointF(0.0f, 0.0f);
        }
        invalidate();
    }

    public final void setBitmapDecoderClass(java.lang.Class<? extends io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.ImageDecoder> cls) {
        if (cls == null) {
            throw new java.lang.IllegalArgumentException("Decoder class cannot be set to null");
        }
        this.bitmapDecoderFactory = new io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.CompatDecoderFactory(cls);
    }

    public final void setBitmapDecoderFactory(io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.DecoderFactory<? extends io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.ImageDecoder> decoderFactory) {
        if (decoderFactory == null) {
            throw new java.lang.IllegalArgumentException("Decoder factory cannot be set to null");
        }
        this.bitmapDecoderFactory = decoderFactory;
    }

    public final void setDebug(boolean z) {
        this.debug = z;
    }

    public final void setDoubleTapZoomDpi(int i) {
        android.util.DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setDoubleTapZoomScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i);
    }

    public final void setDoubleTapZoomDuration(int i) {
        this.doubleTapZoomDuration = java.lang.Math.max(0, i);
    }

    public final void setDoubleTapZoomScale(float f) {
        this.doubleTapZoomScale = f;
    }

    public final void setDoubleTapZoomStyle(int i) {
        if (VALID_ZOOM_STYLES.contains(java.lang.Integer.valueOf(i))) {
            this.doubleTapZoomStyle = i;
        } else {
            throw new java.lang.IllegalArgumentException("Invalid zoom style: " + i);
        }
    }

    public void setEagerLoadingEnabled(boolean z) {
        this.eagerLoadingEnabled = z;
    }

    public void setExecutor(java.util.concurrent.Executor executor) {
        if (executor == null) {
            throw new java.lang.NullPointerException("Executor must not be null");
        }
        this.executor = executor;
    }

    public final void setImage(io.dcloud.feature.nativeObj.photoview.subscaleview.ImageSource imageSource) {
        setImage(imageSource, null, new io.dcloud.feature.nativeObj.photoview.subscaleview.ImageViewState(0.0f, new android.graphics.PointF(getWidth() / 2.0f, 0.0f), 0));
    }

    public final void setMaxScale(float f) {
        this.maxScale = f;
    }

    public void setMaxTileSize(int i) {
        this.maxTileWidth = i;
        this.maxTileHeight = i;
    }

    public final void setMaximumDpi(int i) {
        android.util.DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMinScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i);
    }

    public final void setMinScale(float f) {
        this.minScale = f;
    }

    public final void setMinimumDpi(int i) {
        android.util.DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMaxScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i);
    }

    public final void setMinimumScaleType(int i) {
        if (!VALID_SCALE_TYPES.contains(java.lang.Integer.valueOf(i))) {
            throw new java.lang.IllegalArgumentException("Invalid scale type: " + i);
        }
        this.minimumScaleType = i;
        if (isReady()) {
            fitToBounds(true);
            invalidate();
        }
    }

    public void setMinimumTileDpi(int i) {
        android.util.DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.minimumTileDpi = (int) java.lang.Math.min((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f, i);
        if (isReady()) {
            reset(false);
            invalidate();
        }
    }

    public void setOnImageEventListener(io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.OnImageEventListener onImageEventListener) {
        this.onImageEventListener = onImageEventListener;
    }

    @Override // android.view.View
    public void setOnLongClickListener(android.view.View.OnLongClickListener onLongClickListener) {
        super.setOnLongClickListener(onLongClickListener);
        this.onLongClickListener = onLongClickListener;
    }

    public void setOnStateChangedListener(io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.OnStateChangedListener onStateChangedListener) {
        this.onStateChangedListener = onStateChangedListener;
    }

    public void setOnTileInited(io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.TilesInited tilesInited) {
        this.inited = tilesInited;
    }

    public final void setOrientation(int i) {
        if (!VALID_ORIENTATIONS.contains(java.lang.Integer.valueOf(i))) {
            throw new java.lang.IllegalArgumentException("Invalid orientation: " + i);
        }
        this.orientation = i;
        reset(false);
        invalidate();
        requestLayout();
    }

    public final void setPanEnabled(boolean z) {
        android.graphics.PointF pointF;
        this.panEnabled = z;
        if (z || (pointF = this.vTranslate) == null) {
            return;
        }
        pointF.x = (getWidth() / 2) - (this.scale * (sWidth() / 2));
        this.vTranslate.y = (getHeight() / 2) - (this.scale * (sHeight() / 2));
        if (isReady()) {
            refreshRequiredTiles(true);
            invalidate();
        }
    }

    public final void setPanLimit(int i) {
        if (!VALID_PAN_LIMITS.contains(java.lang.Integer.valueOf(i))) {
            throw new java.lang.IllegalArgumentException("Invalid pan limit: " + i);
        }
        this.panLimit = i;
        if (isReady()) {
            fitToBounds(true);
            invalidate();
        }
    }

    public final void setQuickScaleEnabled(boolean z) {
        this.quickScaleEnabled = z;
    }

    public final void setRegionDecoderClass(java.lang.Class<? extends io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.ImageRegionDecoder> cls) {
        if (cls == null) {
            throw new java.lang.IllegalArgumentException("Decoder class cannot be set to null");
        }
        this.regionDecoderFactory = new io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.CompatDecoderFactory(cls);
    }

    public final void setRegionDecoderFactory(io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.DecoderFactory<? extends io.dcloud.feature.nativeObj.photoview.subscaleview.decoder.ImageRegionDecoder> decoderFactory) {
        if (decoderFactory == null) {
            throw new java.lang.IllegalArgumentException("Decoder factory cannot be set to null");
        }
        this.regionDecoderFactory = decoderFactory;
    }

    public final void setScaleAndCenter(float f, android.graphics.PointF pointF) {
        this.anim = null;
        this.pendingScale = java.lang.Float.valueOf(f);
        this.sPendingCenter = pointF;
        this.sRequestedCenter = pointF;
        invalidate();
    }

    public final void setTileBackgroundColor(int i) {
        if (android.graphics.Color.alpha(i) == 0) {
            this.tileBgPaint = null;
        } else {
            android.graphics.Paint paint = new android.graphics.Paint();
            this.tileBgPaint = paint;
            paint.setStyle(android.graphics.Paint.Style.FILL);
            this.tileBgPaint.setColor(i);
        }
        invalidate();
    }

    public final void setZoomEnabled(boolean z) {
        this.zoomEnabled = z;
    }

    public final android.graphics.PointF sourceToViewCoord(android.graphics.PointF pointF) {
        return sourceToViewCoord(pointF.x, pointF.y, new android.graphics.PointF());
    }

    public void viewToFileRect(android.graphics.Rect rect, android.graphics.Rect rect2) {
        if (this.vTranslate == null || !this.readySent) {
            return;
        }
        rect2.set((int) viewToSourceX(rect.left), (int) viewToSourceY(rect.top), (int) viewToSourceX(rect.right), (int) viewToSourceY(rect.bottom));
        fileSRect(rect2, rect2);
        rect2.set(java.lang.Math.max(0, rect2.left), java.lang.Math.max(0, rect2.top), java.lang.Math.min(this.sWidth, rect2.right), java.lang.Math.min(this.sHeight, rect2.bottom));
        android.graphics.Rect rect3 = this.sRegion;
        if (rect3 != null) {
            rect2.offset(rect3.left, rect3.top);
        }
    }

    public final android.graphics.PointF viewToSourceCoord(android.graphics.PointF pointF) {
        return viewToSourceCoord(pointF.x, pointF.y, new android.graphics.PointF());
    }

    public void visibleFileRect(android.graphics.Rect rect) {
        if (this.vTranslate == null || !this.readySent) {
            return;
        }
        rect.set(0, 0, getWidth(), getHeight());
        viewToFileRect(rect, rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onImageLoaded(android.graphics.Bitmap bitmap, int i, boolean z) {
        io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.OnImageEventListener onImageEventListener;
        debug("onImageLoaded", new java.lang.Object[0]);
        int i2 = this.sWidth;
        if (i2 > 0 && this.sHeight > 0 && (i2 != bitmap.getWidth() || this.sHeight != bitmap.getHeight())) {
            reset(false);
        }
        android.graphics.Bitmap bitmap2 = this.bitmap;
        if (bitmap2 != null && !this.bitmapIsCached) {
            bitmap2.recycle();
        }
        if (this.bitmap != null && this.bitmapIsCached && (onImageEventListener = this.onImageEventListener) != null) {
            onImageEventListener.onPreviewReleased();
        }
        this.bitmapIsPreview = false;
        this.bitmapIsCached = z;
        this.bitmap = bitmap;
        this.sWidth = bitmap.getWidth();
        int height = bitmap.getHeight();
        this.sHeight = height;
        this.sOrientation = i;
        resetAllScale(this.sWidth, height);
        boolean zCheckReady = checkReady();
        boolean zCheckImageLoaded = checkImageLoaded();
        if (zCheckReady || zCheckImageLoaded) {
            invalidate();
            requestLayout();
        }
    }

    public final android.graphics.PointF sourceToViewCoord(float f, float f2) {
        return sourceToViewCoord(f, f2, new android.graphics.PointF());
    }

    public final android.graphics.PointF viewToSourceCoord(float f, float f2) {
        return viewToSourceCoord(f, f2, new android.graphics.PointF());
    }

    public final void setImage(io.dcloud.feature.nativeObj.photoview.subscaleview.ImageSource imageSource, io.dcloud.feature.nativeObj.photoview.subscaleview.ImageViewState imageViewState) {
        setImage(imageSource, null, imageViewState);
    }

    public void setMaxTileSize(int i, int i2) {
        this.maxTileWidth = i;
        this.maxTileHeight = i2;
    }

    public final android.graphics.PointF sourceToViewCoord(android.graphics.PointF pointF, android.graphics.PointF pointF2) {
        return sourceToViewCoord(pointF.x, pointF.y, pointF2);
    }

    public final android.graphics.PointF viewToSourceCoord(android.graphics.PointF pointF, android.graphics.PointF pointF2) {
        return viewToSourceCoord(pointF.x, pointF.y, pointF2);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public final class AnimationBuilder {
        private long duration;
        private int easing;
        private boolean interruptible;
        private io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.OnAnimationEventListener listener;
        private int origin;
        private boolean panLimited;
        private final android.graphics.PointF targetSCenter;
        private final float targetScale;
        private final android.graphics.PointF vFocus;

        /* JADX INFO: Access modifiers changed from: private */
        public io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.AnimationBuilder withOrigin(int i) {
            this.origin = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.AnimationBuilder withPanLimited(boolean z) {
            this.panLimited = z;
            return this;
        }

        public void start() {
            android.graphics.PointF pointFLimitedSCenter;
            if (io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.anim != null && io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.anim.listener != null) {
                try {
                    io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.anim.listener.onInterruptedByNewAnim();
                } catch (java.lang.Exception e) {
                    android.util.Log.w(io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.TAG, "Error thrown by animation listener", e);
                }
            }
            int paddingLeft = io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.getPaddingLeft() + (((io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.getWidth() - io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.getPaddingRight()) - io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.getPaddingLeft()) / 2);
            int paddingTop = io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.getPaddingTop() + (((io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.getHeight() - io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.getPaddingBottom()) - io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.getPaddingTop()) / 2);
            float fLimitedScale = io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.limitedScale(this.targetScale);
            if (this.panLimited) {
                io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView subsamplingScaleImageView = io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this;
                android.graphics.PointF pointF = this.targetSCenter;
                pointFLimitedSCenter = subsamplingScaleImageView.limitedSCenter(pointF.x, pointF.y, fLimitedScale, new android.graphics.PointF());
            } else {
                pointFLimitedSCenter = this.targetSCenter;
            }
            io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.anim = new io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.Anim();
            io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.anim.scaleStart = io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.scale;
            io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.anim.scaleEnd = fLimitedScale;
            io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.anim.time = java.lang.System.currentTimeMillis();
            io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.anim.sCenterEndRequested = pointFLimitedSCenter;
            io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.anim.sCenterStart = io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.getCenter();
            io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.anim.sCenterEnd = pointFLimitedSCenter;
            io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.anim.vFocusStart = io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.sourceToViewCoord(pointFLimitedSCenter);
            io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.anim.vFocusEnd = new android.graphics.PointF(paddingLeft, paddingTop);
            io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.anim.duration = this.duration;
            io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.anim.interruptible = this.interruptible;
            io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.anim.easing = this.easing;
            io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.anim.origin = this.origin;
            io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.anim.time = java.lang.System.currentTimeMillis();
            io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.anim.listener = this.listener;
            android.graphics.PointF pointF2 = this.vFocus;
            if (pointF2 != null) {
                float f = pointF2.x - (io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.anim.sCenterStart.x * fLimitedScale);
                float f2 = this.vFocus.y - (io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.anim.sCenterStart.y * fLimitedScale);
                io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.ScaleAndTranslate scaleAndTranslate = new io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.ScaleAndTranslate(fLimitedScale, new android.graphics.PointF(f, f2));
                io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.fitToBounds(true, scaleAndTranslate);
                io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.anim.vFocusEnd = new android.graphics.PointF(this.vFocus.x + (scaleAndTranslate.vTranslate.x - f), this.vFocus.y + (scaleAndTranslate.vTranslate.y - f2));
            }
            io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.invalidate();
        }

        public io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.AnimationBuilder withDuration(long j) {
            this.duration = j;
            return this;
        }

        public io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.AnimationBuilder withEasing(int i) {
            if (io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.VALID_EASING_STYLES.contains(java.lang.Integer.valueOf(i))) {
                this.easing = i;
                return this;
            }
            throw new java.lang.IllegalArgumentException("Unknown easing type: " + i);
        }

        public io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.AnimationBuilder withInterruptible(boolean z) {
            this.interruptible = z;
            return this;
        }

        public io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.AnimationBuilder withOnAnimationEventListener(io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.OnAnimationEventListener onAnimationEventListener) {
            this.listener = onAnimationEventListener;
            return this;
        }

        private AnimationBuilder(android.graphics.PointF pointF) {
            this.duration = 500L;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.scale;
            this.targetSCenter = pointF;
            this.vFocus = null;
        }

        private AnimationBuilder(float f) {
            this.duration = 500L;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f;
            this.targetSCenter = io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.this.getCenter();
            this.vFocus = null;
        }

        private AnimationBuilder(float f, android.graphics.PointF pointF) {
            this.duration = 500L;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f;
            this.targetSCenter = pointF;
            this.vFocus = null;
        }

        private AnimationBuilder(float f, android.graphics.PointF pointF, android.graphics.PointF pointF2) {
            this.duration = 500L;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f;
            this.targetSCenter = pointF;
            this.vFocus = pointF2;
        }
    }

    public final void setImage(io.dcloud.feature.nativeObj.photoview.subscaleview.ImageSource imageSource, io.dcloud.feature.nativeObj.photoview.subscaleview.ImageSource imageSource2) {
        setImage(imageSource, imageSource2, null);
    }

    public final android.graphics.PointF sourceToViewCoord(float f, float f2, android.graphics.PointF pointF) {
        if (this.vTranslate == null) {
            return null;
        }
        pointF.set(sourceToViewX(f), sourceToViewY(f2));
        return pointF;
    }

    public final android.graphics.PointF viewToSourceCoord(float f, float f2, android.graphics.PointF pointF) {
        if (this.vTranslate == null) {
            return null;
        }
        pointF.set(viewToSourceX(f), viewToSourceY(f2));
        return pointF;
    }

    public final void setImage(io.dcloud.feature.nativeObj.photoview.subscaleview.ImageSource imageSource, io.dcloud.feature.nativeObj.photoview.subscaleview.ImageSource imageSource2, io.dcloud.feature.nativeObj.photoview.subscaleview.ImageViewState imageViewState) {
        if (imageSource != null) {
            reset(true);
            if (imageViewState != null) {
                restoreState(imageViewState);
            }
            if (imageSource2 != null) {
                if (imageSource.getBitmap() == null) {
                    if (imageSource.getSWidth() > 0 && imageSource.getSHeight() > 0) {
                        this.sWidth = imageSource.getSWidth();
                        this.sHeight = imageSource.getSHeight();
                        this.pRegion = imageSource2.getSRegion();
                        if (imageSource2.getBitmap() != null) {
                            this.bitmapIsCached = imageSource2.isCached();
                            onPreviewLoaded(imageSource2.getBitmap());
                        } else {
                            android.net.Uri uri = imageSource2.getUri();
                            if (uri == null && imageSource2.getResource() != null) {
                                uri = android.net.Uri.parse("android.resource://" + getContext().getPackageName() + "/" + imageSource2.getResource());
                            }
                            execute(new io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, uri, true));
                        }
                    } else {
                        throw new java.lang.IllegalArgumentException("Preview image cannot be used unless dimensions are provided for the main image");
                    }
                } else {
                    throw new java.lang.IllegalArgumentException("Preview image cannot be used when a bitmap is provided for the main image");
                }
            }
            if (imageSource.getBitmap() != null && imageSource.getSRegion() != null) {
                onImageLoaded(android.graphics.Bitmap.createBitmap(imageSource.getBitmap(), imageSource.getSRegion().left, imageSource.getSRegion().top, imageSource.getSRegion().width(), imageSource.getSRegion().height()), 0, false);
                return;
            }
            if (imageSource.getBitmap() != null) {
                onImageLoaded(imageSource.getBitmap(), 0, imageSource.isCached());
                return;
            }
            this.sRegion = imageSource.getSRegion();
            android.net.Uri uri2 = imageSource.getUri();
            this.uri = uri2;
            if (uri2 == null && imageSource.getResource() != null) {
                this.uri = android.net.Uri.parse("android.resource://" + getContext().getPackageName() + "/" + imageSource.getResource());
            }
            if (!imageSource.getTile() && this.sRegion == null) {
                execute(new io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, this.uri, false));
                return;
            } else {
                execute(new io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.TilesInitTask(this, getContext(), this.regionDecoderFactory, this.uri));
                return;
            }
        }
        throw new java.lang.NullPointerException("imageSource must not be null");
    }

    private void fitToBounds(boolean z) {
        boolean z2;
        float f = 0.0f;
        if (this.vTranslate == null) {
            this.vTranslate = new android.graphics.PointF(0.0f, 0.0f);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.satTemp == null) {
            this.satTemp = new io.dcloud.feature.nativeObj.photoview.subscaleview.SubsamplingScaleImageView.ScaleAndTranslate(f, new android.graphics.PointF(0.0f, 0.0f));
        }
        this.satTemp.scale = this.scale;
        this.satTemp.vTranslate.set(this.vTranslate);
        fitToBounds(z, this.satTemp);
        this.scale = this.satTemp.scale;
        this.vTranslate.set(this.satTemp.vTranslate);
        if (!z2 || this.minimumScaleType == 4) {
            return;
        }
        this.vTranslate.set(vTranslateForSCenter(sWidth() / 2, sHeight() / 2, this.scale));
    }

    public SubsamplingScaleImageView(android.content.Context context) {
        this(context, null);
    }
}
