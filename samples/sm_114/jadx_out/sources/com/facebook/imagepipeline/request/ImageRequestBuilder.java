package com.facebook.imagepipeline.request;

/* JADX INFO: loaded from: classes.dex */
public class ImageRequestBuilder {
    private static final java.util.Set<java.lang.String> CUSTOM_NETWORK_SCHEMES = new java.util.HashSet();
    private int mDelayMs;

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.listener.RequestListener mRequestListener;

    @javax.annotation.Nullable
    private android.net.Uri mSourceUri = null;
    private com.facebook.imagepipeline.request.ImageRequest.RequestLevel mLowestPermittedRequestLevel = com.facebook.imagepipeline.request.ImageRequest.RequestLevel.FULL_FETCH;
    private int mCachesDisabled = 0;

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.common.ResizeOptions mResizeOptions = null;

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.common.RotationOptions mRotationOptions = null;
    private com.facebook.imagepipeline.common.ImageDecodeOptions mImageDecodeOptions = com.facebook.imagepipeline.common.ImageDecodeOptions.defaults();
    private com.facebook.imagepipeline.request.ImageRequest.CacheChoice mCacheChoice = com.facebook.imagepipeline.request.ImageRequest.CacheChoice.DEFAULT;
    private boolean mProgressiveRenderingEnabled = com.facebook.imagepipeline.core.ImagePipelineConfig.getDefaultImageRequestConfig().getIsProgressiveRenderingEnabled();
    private boolean mLocalThumbnailPreviewsEnabled = false;
    private boolean mLoadThumbnailOnly = false;
    private com.facebook.imagepipeline.common.Priority mRequestPriority = com.facebook.imagepipeline.common.Priority.HIGH;

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.request.Postprocessor mPostprocessor = null;

    @javax.annotation.Nullable
    private java.lang.Boolean mDecodePrefetches = null;

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.common.BytesRange mBytesRange = null;

    @javax.annotation.Nullable
    private java.lang.Boolean mResizingAllowedOverride = null;

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.core.DownsampleMode mDownsampleOverride = null;

    @javax.annotation.Nullable
    private java.lang.String mDiskCacheId = null;

    public static com.facebook.imagepipeline.request.ImageRequestBuilder newBuilderWithSource(android.net.Uri uri) {
        return new com.facebook.imagepipeline.request.ImageRequestBuilder().setSource(uri);
    }

    public static com.facebook.imagepipeline.request.ImageRequestBuilder newBuilderWithResourceId(int i) {
        return newBuilderWithSource(com.facebook.common.util.UriUtil.getUriForResourceId(i));
    }

    public static com.facebook.imagepipeline.request.ImageRequestBuilder fromRequest(com.facebook.imagepipeline.request.ImageRequest imageRequest) {
        return newBuilderWithSource(imageRequest.getSourceUri()).setImageDecodeOptions(imageRequest.getImageDecodeOptions()).setBytesRange(imageRequest.getBytesRange()).setCacheChoice(imageRequest.getCacheChoice()).setLocalThumbnailPreviewsEnabled(imageRequest.getLocalThumbnailPreviewsEnabled()).setLoadThumbnailOnly(imageRequest.getLoadThumbnailOnlyForAndroidSdkAboveQ()).setLowestPermittedRequestLevel(imageRequest.getLowestPermittedRequestLevel()).setCachesDisabled(imageRequest.getCachesDisabled()).setPostprocessor(imageRequest.getPostprocessor()).setProgressiveRenderingEnabled(imageRequest.getProgressiveRenderingEnabled()).setRequestPriority(imageRequest.getPriority()).setResizeOptions(imageRequest.getResizeOptions()).setRequestListener(imageRequest.getRequestListener()).setRotationOptions(imageRequest.getRotationOptions()).setShouldDecodePrefetches(imageRequest.shouldDecodePrefetches()).setDelayMs(imageRequest.getDelayMs()).setDiskCacheId(imageRequest.getDiskCacheId()).setDownsampleOverride(imageRequest.getDownsampleOverride()).setResizingAllowedOverride(imageRequest.getResizingAllowedOverride());
    }

    public static void addCustomUriNetworkScheme(java.lang.String str) {
        CUSTOM_NETWORK_SCHEMES.add(str);
    }

    private ImageRequestBuilder() {
    }

    public com.facebook.imagepipeline.request.ImageRequestBuilder setSource(android.net.Uri uri) {
        com.facebook.common.internal.Preconditions.checkNotNull(uri);
        this.mSourceUri = uri;
        return this;
    }

    public android.net.Uri getSourceUri() {
        return this.mSourceUri;
    }

    public com.facebook.imagepipeline.request.ImageRequestBuilder setLowestPermittedRequestLevel(com.facebook.imagepipeline.request.ImageRequest.RequestLevel requestLevel) {
        this.mLowestPermittedRequestLevel = requestLevel;
        return this;
    }

    public com.facebook.imagepipeline.request.ImageRequest.RequestLevel getLowestPermittedRequestLevel() {
        return this.mLowestPermittedRequestLevel;
    }

    private com.facebook.imagepipeline.request.ImageRequestBuilder setCachesDisabled(int i) {
        this.mCachesDisabled = i;
        if (this.mCacheChoice != com.facebook.imagepipeline.request.ImageRequest.CacheChoice.DYNAMIC) {
            this.mDiskCacheId = null;
        }
        return this;
    }

    public int getCachesDisabled() {
        return this.mCachesDisabled;
    }

    @java.lang.Deprecated
    public com.facebook.imagepipeline.request.ImageRequestBuilder setAutoRotateEnabled(boolean z) {
        if (z) {
            return setRotationOptions(com.facebook.imagepipeline.common.RotationOptions.autoRotate());
        }
        return setRotationOptions(com.facebook.imagepipeline.common.RotationOptions.disableRotation());
    }

    public com.facebook.imagepipeline.request.ImageRequestBuilder setResizeOptions(@javax.annotation.Nullable com.facebook.imagepipeline.common.ResizeOptions resizeOptions) {
        this.mResizeOptions = resizeOptions;
        return this;
    }

    @javax.annotation.Nullable
    public com.facebook.imagepipeline.common.ResizeOptions getResizeOptions() {
        return this.mResizeOptions;
    }

    public com.facebook.imagepipeline.request.ImageRequestBuilder setRotationOptions(@javax.annotation.Nullable com.facebook.imagepipeline.common.RotationOptions rotationOptions) {
        this.mRotationOptions = rotationOptions;
        return this;
    }

    @javax.annotation.Nullable
    public com.facebook.imagepipeline.common.RotationOptions getRotationOptions() {
        return this.mRotationOptions;
    }

    public com.facebook.imagepipeline.request.ImageRequestBuilder setBytesRange(@javax.annotation.Nullable com.facebook.imagepipeline.common.BytesRange bytesRange) {
        this.mBytesRange = bytesRange;
        return this;
    }

    @javax.annotation.Nullable
    public com.facebook.imagepipeline.common.BytesRange getBytesRange() {
        return this.mBytesRange;
    }

    public com.facebook.imagepipeline.request.ImageRequestBuilder setImageDecodeOptions(com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions) {
        this.mImageDecodeOptions = imageDecodeOptions;
        return this;
    }

    public com.facebook.imagepipeline.common.ImageDecodeOptions getImageDecodeOptions() {
        return this.mImageDecodeOptions;
    }

    public com.facebook.imagepipeline.request.ImageRequestBuilder setCacheChoice(com.facebook.imagepipeline.request.ImageRequest.CacheChoice cacheChoice) {
        this.mCacheChoice = cacheChoice;
        return this;
    }

    public com.facebook.imagepipeline.request.ImageRequest.CacheChoice getCacheChoice() {
        return this.mCacheChoice;
    }

    public com.facebook.imagepipeline.request.ImageRequestBuilder setProgressiveRenderingEnabled(boolean z) {
        this.mProgressiveRenderingEnabled = z;
        return this;
    }

    public boolean isProgressiveRenderingEnabled() {
        return this.mProgressiveRenderingEnabled;
    }

    public com.facebook.imagepipeline.request.ImageRequestBuilder setLocalThumbnailPreviewsEnabled(boolean z) {
        this.mLocalThumbnailPreviewsEnabled = z;
        return this;
    }

    public boolean isLocalThumbnailPreviewsEnabled() {
        return this.mLocalThumbnailPreviewsEnabled;
    }

    public com.facebook.imagepipeline.request.ImageRequestBuilder setLoadThumbnailOnly(boolean z) {
        this.mLoadThumbnailOnly = z;
        return this;
    }

    public boolean getLoadThumbnailOnly() {
        return this.mLoadThumbnailOnly;
    }

    public com.facebook.imagepipeline.request.ImageRequestBuilder disableDiskCache() {
        this.mCachesDisabled |= 48;
        return this;
    }

    public static boolean isCustomNetworkUri(@javax.annotation.Nullable android.net.Uri uri) {
        java.util.Set<java.lang.String> set = CUSTOM_NETWORK_SCHEMES;
        if (set != null && uri != null) {
            java.util.Iterator<java.lang.String> it = set.iterator();
            while (it.hasNext()) {
                if (it.next().equals(uri.getScheme())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isDiskCacheEnabled() {
        if ((this.mCachesDisabled & 48) == 0) {
            return com.facebook.common.util.UriUtil.isNetworkUri(this.mSourceUri) || isCustomNetworkUri(this.mSourceUri);
        }
        return false;
    }

    public com.facebook.imagepipeline.request.ImageRequestBuilder disableMemoryCache() {
        this.mCachesDisabled |= 15;
        return this;
    }

    public boolean isMemoryCacheEnabled() {
        return (this.mCachesDisabled & 15) == 0;
    }

    public com.facebook.imagepipeline.request.ImageRequestBuilder setRequestPriority(com.facebook.imagepipeline.common.Priority priority) {
        this.mRequestPriority = priority;
        return this;
    }

    public com.facebook.imagepipeline.common.Priority getRequestPriority() {
        return this.mRequestPriority;
    }

    public com.facebook.imagepipeline.request.ImageRequestBuilder setPostprocessor(@javax.annotation.Nullable com.facebook.imagepipeline.request.Postprocessor postprocessor) {
        this.mPostprocessor = postprocessor;
        return this;
    }

    @javax.annotation.Nullable
    public com.facebook.imagepipeline.request.Postprocessor getPostprocessor() {
        return this.mPostprocessor;
    }

    public com.facebook.imagepipeline.request.ImageRequestBuilder setRequestListener(@javax.annotation.Nullable com.facebook.imagepipeline.listener.RequestListener requestListener) {
        this.mRequestListener = requestListener;
        return this;
    }

    @javax.annotation.Nullable
    public com.facebook.imagepipeline.listener.RequestListener getRequestListener() {
        return this.mRequestListener;
    }

    public com.facebook.imagepipeline.request.ImageRequestBuilder setDiskCacheId(@javax.annotation.Nullable java.lang.String str) {
        this.mDiskCacheId = str;
        return this;
    }

    @javax.annotation.Nullable
    public java.lang.String getDiskCacheId() {
        return this.mDiskCacheId;
    }

    public com.facebook.imagepipeline.request.ImageRequest build() {
        validate();
        return new com.facebook.imagepipeline.request.ImageRequest(this);
    }

    @javax.annotation.Nullable
    public java.lang.Boolean shouldDecodePrefetches() {
        return this.mDecodePrefetches;
    }

    public com.facebook.imagepipeline.request.ImageRequestBuilder setShouldDecodePrefetches(@javax.annotation.Nullable java.lang.Boolean bool) {
        this.mDecodePrefetches = bool;
        return this;
    }

    public com.facebook.imagepipeline.request.ImageRequestBuilder setResizingAllowedOverride(@javax.annotation.Nullable java.lang.Boolean bool) {
        this.mResizingAllowedOverride = bool;
        return this;
    }

    @javax.annotation.Nullable
    public java.lang.Boolean getResizingAllowedOverride() {
        return this.mResizingAllowedOverride;
    }

    public com.facebook.imagepipeline.request.ImageRequestBuilder setDownsampleOverride(@javax.annotation.Nullable com.facebook.imagepipeline.core.DownsampleMode downsampleMode) {
        this.mDownsampleOverride = downsampleMode;
        return this;
    }

    @javax.annotation.Nullable
    public com.facebook.imagepipeline.core.DownsampleMode getDownsampleOverride() {
        return this.mDownsampleOverride;
    }

    public int getDelayMs() {
        return this.mDelayMs;
    }

    public com.facebook.imagepipeline.request.ImageRequestBuilder setDelayMs(int i) {
        this.mDelayMs = i;
        return this;
    }

    public static class BuilderException extends java.lang.RuntimeException {
        public BuilderException(java.lang.String str) {
            super("Invalid request builder: " + str);
        }
    }

    protected void validate() {
        android.net.Uri uri = this.mSourceUri;
        if (uri == null) {
            throw new com.facebook.imagepipeline.request.ImageRequestBuilder.BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.UriUtil.isLocalResourceUri(uri)) {
            if (!this.mSourceUri.isAbsolute()) {
                throw new com.facebook.imagepipeline.request.ImageRequestBuilder.BuilderException("Resource URI path must be absolute.");
            }
            if (this.mSourceUri.getPath().isEmpty()) {
                throw new com.facebook.imagepipeline.request.ImageRequestBuilder.BuilderException("Resource URI must not be empty");
            }
            try {
                java.lang.Integer.parseInt(this.mSourceUri.getPath().substring(1));
            } catch (java.lang.NumberFormatException unused) {
                throw new com.facebook.imagepipeline.request.ImageRequestBuilder.BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.UriUtil.isLocalAssetUri(this.mSourceUri) && !this.mSourceUri.isAbsolute()) {
            throw new com.facebook.imagepipeline.request.ImageRequestBuilder.BuilderException("Asset URI path must be absolute.");
        }
    }
}
