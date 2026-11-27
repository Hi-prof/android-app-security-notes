package com.facebook.imagepipeline.multiuri;

/* JADX INFO: loaded from: classes.dex */
public class MultiUri {

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.request.ImageRequest mHighResImageRequest;

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.request.ImageRequest mLowResImageRequest;

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.request.ImageRequest[] mMultiImageRequests;

    private MultiUri(com.facebook.imagepipeline.multiuri.MultiUri.Builder builder) {
        this.mLowResImageRequest = builder.mLowResImageRequest;
        this.mHighResImageRequest = builder.mHighResImageRequest;
        this.mMultiImageRequests = builder.mMultiImageRequests;
    }

    @javax.annotation.Nullable
    public com.facebook.imagepipeline.request.ImageRequest getLowResImageRequest() {
        return this.mLowResImageRequest;
    }

    @javax.annotation.Nullable
    public com.facebook.imagepipeline.request.ImageRequest getHighResImageRequest() {
        return this.mHighResImageRequest;
    }

    @javax.annotation.Nullable
    public com.facebook.imagepipeline.request.ImageRequest[] getMultiImageRequests() {
        return this.mMultiImageRequests;
    }

    public static com.facebook.imagepipeline.multiuri.MultiUri.Builder create() {
        return new com.facebook.imagepipeline.multiuri.MultiUri.Builder();
    }

    public static final class Builder {

        @javax.annotation.Nullable
        private com.facebook.imagepipeline.request.ImageRequest mHighResImageRequest;

        @javax.annotation.Nullable
        private com.facebook.imagepipeline.request.ImageRequest mLowResImageRequest;

        @javax.annotation.Nullable
        private com.facebook.imagepipeline.request.ImageRequest[] mMultiImageRequests;

        private Builder() {
        }

        public com.facebook.imagepipeline.multiuri.MultiUri build() {
            return new com.facebook.imagepipeline.multiuri.MultiUri(this);
        }

        public com.facebook.imagepipeline.multiuri.MultiUri.Builder setLowResImageRequest(@javax.annotation.Nullable com.facebook.imagepipeline.request.ImageRequest imageRequest) {
            this.mLowResImageRequest = imageRequest;
            return this;
        }

        public com.facebook.imagepipeline.multiuri.MultiUri.Builder setHighResImageRequest(@javax.annotation.Nullable com.facebook.imagepipeline.request.ImageRequest imageRequest) {
            this.mHighResImageRequest = imageRequest;
            return this;
        }

        public com.facebook.imagepipeline.multiuri.MultiUri.Builder setImageRequests(@javax.annotation.Nullable com.facebook.imagepipeline.request.ImageRequest... imageRequestArr) {
            this.mMultiImageRequests = imageRequestArr;
            return this;
        }
    }
}
