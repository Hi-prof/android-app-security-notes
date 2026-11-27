package com.facebook.imagepipeline.request;

/* JADX INFO: loaded from: classes.dex */
public class ImageRequest {
    public static final com.facebook.common.internal.Fn<com.facebook.imagepipeline.request.ImageRequest, android.net.Uri> REQUEST_TO_URI_FN = new com.facebook.common.internal.Fn<com.facebook.imagepipeline.request.ImageRequest, android.net.Uri>() { // from class: com.facebook.imagepipeline.request.ImageRequest.1
        @Override // com.facebook.common.internal.Fn
        @javax.annotation.Nullable
        public android.net.Uri apply(@javax.annotation.Nullable com.facebook.imagepipeline.request.ImageRequest imageRequest) {
            if (imageRequest != null) {
                return imageRequest.getSourceUri();
            }
            return null;
        }
    };
    private static boolean sCacheHashcode;
    private static boolean sUseCachedHashcodeInEquals;

    @javax.annotation.Nullable
    private final com.facebook.imagepipeline.common.BytesRange mBytesRange;
    private final com.facebook.imagepipeline.request.ImageRequest.CacheChoice mCacheChoice;
    protected int mCachesDisabled;

    @javax.annotation.Nullable
    private final java.lang.Boolean mDecodePrefetches;
    private final int mDelayMs;

    @javax.annotation.Nullable
    private final java.lang.String mDiskCacheId;

    @javax.annotation.Nullable
    private final com.facebook.imagepipeline.core.DownsampleMode mDownsampleOverride;
    private int mHashcode;
    private final com.facebook.imagepipeline.common.ImageDecodeOptions mImageDecodeOptions;
    private final boolean mIsDiskCacheEnabled;
    private final boolean mIsMemoryCacheEnabled;
    private final boolean mLoadThumbnailOnly;
    private final boolean mLocalThumbnailPreviewsEnabled;
    private final com.facebook.imagepipeline.request.ImageRequest.RequestLevel mLowestPermittedRequestLevel;

    @javax.annotation.Nullable
    private final com.facebook.imagepipeline.request.Postprocessor mPostprocessor;
    private final boolean mProgressiveRenderingEnabled;

    @javax.annotation.Nullable
    private final com.facebook.imagepipeline.listener.RequestListener mRequestListener;
    private final com.facebook.imagepipeline.common.Priority mRequestPriority;

    @javax.annotation.Nullable
    private final com.facebook.imagepipeline.common.ResizeOptions mResizeOptions;

    @javax.annotation.Nullable
    private final java.lang.Boolean mResizingAllowedOverride;
    private final com.facebook.imagepipeline.common.RotationOptions mRotationOptions;

    @javax.annotation.Nullable
    private java.io.File mSourceFile;
    private final android.net.Uri mSourceUri;
    private final int mSourceUriType;

    public enum CacheChoice {
        SMALL,
        DEFAULT,
        DYNAMIC
    }

    public @interface CachesLocationsMasks {
        public static final int BITMAP_READ = 1;
        public static final int BITMAP_WRITE = 2;
        public static final int DISK_READ = 16;
        public static final int DISK_WRITE = 32;
        public static final int ENCODED_READ = 4;
        public static final int ENCODED_WRITE = 8;
    }

    @javax.annotation.Nullable
    public static com.facebook.imagepipeline.request.ImageRequest fromFile(@javax.annotation.Nullable java.io.File file) {
        if (file == null) {
            return null;
        }
        return fromUri(com.facebook.common.util.UriUtil.getUriForFile(file));
    }

    @javax.annotation.Nullable
    public static com.facebook.imagepipeline.request.ImageRequest fromUri(@javax.annotation.Nullable android.net.Uri uri) {
        if (uri == null) {
            return null;
        }
        return com.facebook.imagepipeline.request.ImageRequestBuilder.newBuilderWithSource(uri).build();
    }

    @javax.annotation.Nullable
    public static com.facebook.imagepipeline.request.ImageRequest fromUri(@javax.annotation.Nullable java.lang.String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return fromUri(android.net.Uri.parse(str));
    }

    protected ImageRequest(com.facebook.imagepipeline.request.ImageRequestBuilder imageRequestBuilder) {
        com.facebook.imagepipeline.common.RotationOptions rotationOptions;
        this.mCacheChoice = imageRequestBuilder.getCacheChoice();
        android.net.Uri sourceUri = imageRequestBuilder.getSourceUri();
        this.mSourceUri = sourceUri;
        this.mSourceUriType = getSourceUriType(sourceUri);
        this.mProgressiveRenderingEnabled = imageRequestBuilder.isProgressiveRenderingEnabled();
        this.mLocalThumbnailPreviewsEnabled = imageRequestBuilder.isLocalThumbnailPreviewsEnabled();
        this.mLoadThumbnailOnly = imageRequestBuilder.getLoadThumbnailOnly();
        this.mImageDecodeOptions = imageRequestBuilder.getImageDecodeOptions();
        this.mResizeOptions = imageRequestBuilder.getResizeOptions();
        if (imageRequestBuilder.getRotationOptions() == null) {
            rotationOptions = com.facebook.imagepipeline.common.RotationOptions.autoRotate();
        } else {
            rotationOptions = imageRequestBuilder.getRotationOptions();
        }
        this.mRotationOptions = rotationOptions;
        this.mBytesRange = imageRequestBuilder.getBytesRange();
        this.mRequestPriority = imageRequestBuilder.getRequestPriority();
        this.mLowestPermittedRequestLevel = imageRequestBuilder.getLowestPermittedRequestLevel();
        boolean zIsDiskCacheEnabled = imageRequestBuilder.isDiskCacheEnabled();
        this.mIsDiskCacheEnabled = zIsDiskCacheEnabled;
        int cachesDisabled = imageRequestBuilder.getCachesDisabled();
        this.mCachesDisabled = zIsDiskCacheEnabled ? cachesDisabled : cachesDisabled | 48;
        this.mIsMemoryCacheEnabled = imageRequestBuilder.isMemoryCacheEnabled();
        this.mDecodePrefetches = imageRequestBuilder.shouldDecodePrefetches();
        this.mPostprocessor = imageRequestBuilder.getPostprocessor();
        this.mRequestListener = imageRequestBuilder.getRequestListener();
        this.mResizingAllowedOverride = imageRequestBuilder.getResizingAllowedOverride();
        this.mDownsampleOverride = imageRequestBuilder.getDownsampleOverride();
        this.mDelayMs = imageRequestBuilder.getDelayMs();
        this.mDiskCacheId = imageRequestBuilder.getDiskCacheId();
    }

    public com.facebook.imagepipeline.request.ImageRequest.CacheChoice getCacheChoice() {
        return this.mCacheChoice;
    }

    public android.net.Uri getSourceUri() {
        return this.mSourceUri;
    }

    public int getSourceUriType() {
        return this.mSourceUriType;
    }

    public int getPreferredWidth() {
        com.facebook.imagepipeline.common.ResizeOptions resizeOptions = this.mResizeOptions;
        if (resizeOptions != null) {
            return resizeOptions.width;
        }
        return 2048;
    }

    public int getPreferredHeight() {
        com.facebook.imagepipeline.common.ResizeOptions resizeOptions = this.mResizeOptions;
        if (resizeOptions != null) {
            return resizeOptions.height;
        }
        return 2048;
    }

    @javax.annotation.Nullable
    public com.facebook.imagepipeline.common.ResizeOptions getResizeOptions() {
        return this.mResizeOptions;
    }

    public com.facebook.imagepipeline.common.RotationOptions getRotationOptions() {
        return this.mRotationOptions;
    }

    @java.lang.Deprecated
    public boolean getAutoRotateEnabled() {
        return this.mRotationOptions.useImageMetadata();
    }

    @javax.annotation.Nullable
    public com.facebook.imagepipeline.common.BytesRange getBytesRange() {
        return this.mBytesRange;
    }

    public com.facebook.imagepipeline.common.ImageDecodeOptions getImageDecodeOptions() {
        return this.mImageDecodeOptions;
    }

    public boolean getProgressiveRenderingEnabled() {
        return this.mProgressiveRenderingEnabled;
    }

    public boolean getLocalThumbnailPreviewsEnabled() {
        return this.mLocalThumbnailPreviewsEnabled;
    }

    public boolean getLoadThumbnailOnlyForAndroidSdkAboveQ() {
        return android.os.Build.VERSION.SDK_INT >= 29 && this.mLoadThumbnailOnly;
    }

    public com.facebook.imagepipeline.common.Priority getPriority() {
        return this.mRequestPriority;
    }

    public com.facebook.imagepipeline.request.ImageRequest.RequestLevel getLowestPermittedRequestLevel() {
        return this.mLowestPermittedRequestLevel;
    }

    public int getCachesDisabled() {
        return this.mCachesDisabled;
    }

    public boolean isDiskCacheEnabled() {
        return this.mIsDiskCacheEnabled;
    }

    public boolean isCacheEnabled(int i) {
        return (i & getCachesDisabled()) == 0;
    }

    public boolean isMemoryCacheEnabled() {
        return this.mIsMemoryCacheEnabled;
    }

    @javax.annotation.Nullable
    public java.lang.Boolean shouldDecodePrefetches() {
        return this.mDecodePrefetches;
    }

    @javax.annotation.Nullable
    public java.lang.Boolean getResizingAllowedOverride() {
        return this.mResizingAllowedOverride;
    }

    @javax.annotation.Nullable
    public com.facebook.imagepipeline.core.DownsampleMode getDownsampleOverride() {
        return this.mDownsampleOverride;
    }

    public int getDelayMs() {
        return this.mDelayMs;
    }

    public synchronized java.io.File getSourceFile() {
        if (this.mSourceFile == null) {
            com.facebook.common.internal.Preconditions.checkNotNull(this.mSourceUri.getPath());
            this.mSourceFile = new java.io.File(this.mSourceUri.getPath());
        }
        return this.mSourceFile;
    }

    @javax.annotation.Nullable
    public com.facebook.imagepipeline.request.Postprocessor getPostprocessor() {
        return this.mPostprocessor;
    }

    @javax.annotation.Nullable
    public com.facebook.imagepipeline.listener.RequestListener getRequestListener() {
        return this.mRequestListener;
    }

    @javax.annotation.Nullable
    public java.lang.String getDiskCacheId() {
        return this.mDiskCacheId;
    }

    public boolean equals(@javax.annotation.Nullable java.lang.Object obj) {
        if (!(obj instanceof com.facebook.imagepipeline.request.ImageRequest)) {
            return false;
        }
        com.facebook.imagepipeline.request.ImageRequest imageRequest = (com.facebook.imagepipeline.request.ImageRequest) obj;
        if (sUseCachedHashcodeInEquals) {
            int i = this.mHashcode;
            int i2 = imageRequest.mHashcode;
            if (i != 0 && i2 != 0 && i != i2) {
                return false;
            }
        }
        if (this.mLocalThumbnailPreviewsEnabled == imageRequest.mLocalThumbnailPreviewsEnabled && this.mIsDiskCacheEnabled == imageRequest.mIsDiskCacheEnabled && this.mIsMemoryCacheEnabled == imageRequest.mIsMemoryCacheEnabled && com.facebook.common.internal.Objects.equal(this.mSourceUri, imageRequest.mSourceUri) && com.facebook.common.internal.Objects.equal(this.mCacheChoice, imageRequest.mCacheChoice) && com.facebook.common.internal.Objects.equal(this.mDiskCacheId, imageRequest.mDiskCacheId) && com.facebook.common.internal.Objects.equal(this.mSourceFile, imageRequest.mSourceFile) && com.facebook.common.internal.Objects.equal(this.mBytesRange, imageRequest.mBytesRange) && com.facebook.common.internal.Objects.equal(this.mImageDecodeOptions, imageRequest.mImageDecodeOptions) && com.facebook.common.internal.Objects.equal(this.mResizeOptions, imageRequest.mResizeOptions) && com.facebook.common.internal.Objects.equal(this.mRequestPriority, imageRequest.mRequestPriority) && com.facebook.common.internal.Objects.equal(this.mLowestPermittedRequestLevel, imageRequest.mLowestPermittedRequestLevel) && com.facebook.common.internal.Objects.equal(java.lang.Integer.valueOf(this.mCachesDisabled), java.lang.Integer.valueOf(imageRequest.mCachesDisabled)) && com.facebook.common.internal.Objects.equal(this.mDecodePrefetches, imageRequest.mDecodePrefetches) && com.facebook.common.internal.Objects.equal(this.mResizingAllowedOverride, imageRequest.mResizingAllowedOverride) && com.facebook.common.internal.Objects.equal(this.mDownsampleOverride, imageRequest.mDownsampleOverride) && com.facebook.common.internal.Objects.equal(this.mRotationOptions, imageRequest.mRotationOptions) && this.mLoadThumbnailOnly == imageRequest.mLoadThumbnailOnly) {
            com.facebook.imagepipeline.request.Postprocessor postprocessor = this.mPostprocessor;
            com.facebook.cache.common.CacheKey postprocessorCacheKey = postprocessor != null ? postprocessor.getPostprocessorCacheKey() : null;
            com.facebook.imagepipeline.request.Postprocessor postprocessor2 = imageRequest.mPostprocessor;
            if (com.facebook.common.internal.Objects.equal(postprocessorCacheKey, postprocessor2 != null ? postprocessor2.getPostprocessorCacheKey() : null) && this.mDelayMs == imageRequest.mDelayMs) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        boolean z = sCacheHashcode;
        int i = z ? this.mHashcode : 0;
        if (i != 0) {
            return i;
        }
        com.facebook.imagepipeline.request.Postprocessor postprocessor = this.mPostprocessor;
        int iExtend = com.facebook.memory.helper.HashCode.extend(com.facebook.memory.helper.HashCode.extend(com.facebook.memory.helper.HashCode.extend(com.facebook.memory.helper.HashCode.extend(com.facebook.memory.helper.HashCode.extend(com.facebook.memory.helper.HashCode.extend(com.facebook.memory.helper.HashCode.extend(com.facebook.memory.helper.HashCode.extend(com.facebook.memory.helper.HashCode.extend(com.facebook.memory.helper.HashCode.extend(com.facebook.memory.helper.HashCode.extend(com.facebook.memory.helper.HashCode.extend(com.facebook.memory.helper.HashCode.extend(com.facebook.memory.helper.HashCode.extend(com.facebook.memory.helper.HashCode.extend(com.facebook.memory.helper.HashCode.extend(com.facebook.memory.helper.HashCode.extend(com.facebook.memory.helper.HashCode.extend(0, this.mCacheChoice), this.mSourceUri), java.lang.Boolean.valueOf(this.mLocalThumbnailPreviewsEnabled)), this.mBytesRange), this.mRequestPriority), this.mLowestPermittedRequestLevel), java.lang.Integer.valueOf(this.mCachesDisabled)), java.lang.Boolean.valueOf(this.mIsDiskCacheEnabled)), java.lang.Boolean.valueOf(this.mIsMemoryCacheEnabled)), this.mImageDecodeOptions), this.mDecodePrefetches), this.mResizeOptions), this.mRotationOptions), postprocessor != null ? postprocessor.getPostprocessorCacheKey() : null), this.mResizingAllowedOverride), this.mDownsampleOverride), java.lang.Integer.valueOf(this.mDelayMs)), java.lang.Boolean.valueOf(this.mLoadThumbnailOnly));
        if (z) {
            this.mHashcode = iExtend;
        }
        return iExtend;
    }

    public void recordHashCode(java.util.HashMap<java.lang.String, java.lang.Integer> map) {
        com.facebook.imagepipeline.request.Postprocessor postprocessor = this.mPostprocessor;
        com.facebook.cache.common.CacheKey postprocessorCacheKey = postprocessor != null ? postprocessor.getPostprocessorCacheKey() : null;
        map.put("ImageRequest", java.lang.Integer.valueOf(hashCode()));
        map.put("ImageRequest.mSourceUri", java.lang.Integer.valueOf(getHashCodeHelper(this.mSourceUri)));
        map.put("ImageRequest.mLocalThumbnailPreviewsEnabled", java.lang.Integer.valueOf(getHashCodeHelper(java.lang.Boolean.valueOf(this.mLocalThumbnailPreviewsEnabled))));
        map.put("ImageRequest.mBytesRange", java.lang.Integer.valueOf(getHashCodeHelper(this.mBytesRange)));
        map.put("ImageRequest.mRequestPriority", java.lang.Integer.valueOf(getHashCodeHelper(this.mRequestPriority)));
        map.put("ImageRequest.mLowestPermittedRequestLevel", java.lang.Integer.valueOf(getHashCodeHelper(this.mLowestPermittedRequestLevel)));
        map.put("ImageRequest.mCachesDisabled", java.lang.Integer.valueOf(getHashCodeHelper(java.lang.Integer.valueOf(this.mCachesDisabled))));
        map.put("ImageRequest.mIsDiskCacheEnabled", java.lang.Integer.valueOf(getHashCodeHelper(java.lang.Boolean.valueOf(this.mIsDiskCacheEnabled))));
        map.put("ImageRequest.mIsMemoryCacheEnabled", java.lang.Integer.valueOf(getHashCodeHelper(java.lang.Boolean.valueOf(this.mIsMemoryCacheEnabled))));
        map.put("ImageRequest.mImageDecodeOptions", java.lang.Integer.valueOf(getHashCodeHelper(this.mImageDecodeOptions)));
        map.put("ImageRequest.mDecodePrefetches", java.lang.Integer.valueOf(getHashCodeHelper(this.mDecodePrefetches)));
        map.put("ImageRequest.mSoumResizeOptionsrceUri", java.lang.Integer.valueOf(getHashCodeHelper(this.mResizeOptions)));
        map.put("ImageRequest.mRotationOptions", java.lang.Integer.valueOf(getHashCodeHelper(this.mRotationOptions)));
        map.put("ImageRequest.postprocessorCacheKey", java.lang.Integer.valueOf(getHashCodeHelper(postprocessorCacheKey)));
        map.put("ImageRequest.mResizingAllowedOverride", java.lang.Integer.valueOf(getHashCodeHelper(this.mResizingAllowedOverride)));
        map.put("ImageRequest.mDownsampleOverride", java.lang.Integer.valueOf(getHashCodeHelper(this.mDownsampleOverride)));
        map.put("ImageRequest.mDelayMs", java.lang.Integer.valueOf(getHashCodeHelper(java.lang.Integer.valueOf(this.mDelayMs))));
        map.put("ImageRequest.mLoadThumbnailOnly", java.lang.Integer.valueOf(getHashCodeHelper(java.lang.Boolean.valueOf(this.mLoadThumbnailOnly))));
    }

    private static int getHashCodeHelper(@javax.annotation.Nullable java.lang.Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public java.lang.String toString() {
        return com.facebook.common.internal.Objects.toStringHelper(this).add("uri", this.mSourceUri).add("cacheChoice", this.mCacheChoice).add("decodeOptions", this.mImageDecodeOptions).add("postprocessor", this.mPostprocessor).add("priority", this.mRequestPriority).add("resizeOptions", this.mResizeOptions).add("rotationOptions", this.mRotationOptions).add("bytesRange", this.mBytesRange).add("resizingAllowedOverride", this.mResizingAllowedOverride).add("downsampleOverride", this.mDownsampleOverride).add("progressiveRenderingEnabled", this.mProgressiveRenderingEnabled).add("localThumbnailPreviewsEnabled", this.mLocalThumbnailPreviewsEnabled).add("loadThumbnailOnly", this.mLoadThumbnailOnly).add("lowestPermittedRequestLevel", this.mLowestPermittedRequestLevel).add("cachesDisabled", this.mCachesDisabled).add("isDiskCacheEnabled", this.mIsDiskCacheEnabled).add("isMemoryCacheEnabled", this.mIsMemoryCacheEnabled).add("decodePrefetches", this.mDecodePrefetches).add("delayMs", this.mDelayMs).toString();
    }

    public enum RequestLevel {
        FULL_FETCH(1),
        DISK_CACHE(2),
        ENCODED_MEMORY_CACHE(3),
        BITMAP_MEMORY_CACHE(4);

        private int mValue;

        RequestLevel(int i) {
            this.mValue = i;
        }

        public int getValue() {
            return this.mValue;
        }

        public static com.facebook.imagepipeline.request.ImageRequest.RequestLevel getMax(com.facebook.imagepipeline.request.ImageRequest.RequestLevel requestLevel, com.facebook.imagepipeline.request.ImageRequest.RequestLevel requestLevel2) {
            return requestLevel.getValue() > requestLevel2.getValue() ? requestLevel : requestLevel2;
        }
    }

    private static int getSourceUriType(@javax.annotation.Nullable android.net.Uri uri) {
        if (uri == null) {
            return -1;
        }
        if (com.facebook.common.util.UriUtil.isNetworkUri(uri)) {
            return 0;
        }
        if (uri.getPath() != null && com.facebook.common.util.UriUtil.isLocalFileUri(uri)) {
            return com.facebook.common.media.MediaUtils.isVideo(com.facebook.common.media.MediaUtils.extractMime(uri.getPath())) ? 2 : 3;
        }
        if (com.facebook.common.util.UriUtil.isLocalContentUri(uri)) {
            return 4;
        }
        if (com.facebook.common.util.UriUtil.isLocalAssetUri(uri)) {
            return 5;
        }
        if (com.facebook.common.util.UriUtil.isLocalResourceUri(uri)) {
            return 6;
        }
        if (com.facebook.common.util.UriUtil.isDataUri(uri)) {
            return 7;
        }
        return com.facebook.common.util.UriUtil.isQualifiedResourceUri(uri) ? 8 : -1;
    }

    public static void setUseCachedHashcodeInEquals(boolean z) {
        sUseCachedHashcodeInEquals = z;
    }

    public static void setCacheHashcode(boolean z) {
        sCacheHashcode = z;
    }
}
