package io.dcloud.glide;

/* JADX INFO: loaded from: classes2.dex */
public class GlideRequests extends com.bumptech.glide.RequestManager {
    @Override // com.bumptech.glide.RequestManager
    public /* bridge */ /* synthetic */ com.bumptech.glide.RequestManager addDefaultRequestListener(com.bumptech.glide.request.RequestListener requestListener) {
        return addDefaultRequestListener((com.bumptech.glide.request.RequestListener<java.lang.Object>) requestListener);
    }

    public GlideRequests(com.bumptech.glide.Glide glide, com.bumptech.glide.manager.Lifecycle lifecycle, com.bumptech.glide.manager.RequestManagerTreeNode requestManagerTreeNode, android.content.Context context) {
        super(glide, lifecycle, requestManagerTreeNode, context);
    }

    @Override // com.bumptech.glide.RequestManager
    public <ResourceType> io.dcloud.glide.GlideRequest<ResourceType> as(java.lang.Class<ResourceType> cls) {
        return new io.dcloud.glide.GlideRequest<>(this.glide, this, cls, this.context);
    }

    @Override // com.bumptech.glide.RequestManager
    public synchronized io.dcloud.glide.GlideRequests applyDefaultRequestOptions(com.bumptech.glide.request.RequestOptions requestOptions) {
        return (io.dcloud.glide.GlideRequests) super.applyDefaultRequestOptions(requestOptions);
    }

    @Override // com.bumptech.glide.RequestManager
    public synchronized io.dcloud.glide.GlideRequests setDefaultRequestOptions(com.bumptech.glide.request.RequestOptions requestOptions) {
        return (io.dcloud.glide.GlideRequests) super.setDefaultRequestOptions(requestOptions);
    }

    @Override // com.bumptech.glide.RequestManager
    public synchronized io.dcloud.glide.GlideRequests clearOnStop() {
        return (io.dcloud.glide.GlideRequests) super.clearOnStop();
    }

    @Override // com.bumptech.glide.RequestManager
    public io.dcloud.glide.GlideRequests addDefaultRequestListener(com.bumptech.glide.request.RequestListener<java.lang.Object> requestListener) {
        return (io.dcloud.glide.GlideRequests) super.addDefaultRequestListener(requestListener);
    }

    @Override // com.bumptech.glide.RequestManager
    public io.dcloud.glide.GlideRequest<android.graphics.Bitmap> asBitmap() {
        return (io.dcloud.glide.GlideRequest) super.asBitmap();
    }

    @Override // com.bumptech.glide.RequestManager
    public io.dcloud.glide.GlideRequest<com.bumptech.glide.load.resource.gif.GifDrawable> asGif() {
        return (io.dcloud.glide.GlideRequest) super.asGif();
    }

    @Override // com.bumptech.glide.RequestManager
    public io.dcloud.glide.GlideRequest<android.graphics.drawable.Drawable> asDrawable() {
        return (io.dcloud.glide.GlideRequest) super.asDrawable();
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    public com.bumptech.glide.RequestBuilder<android.graphics.drawable.Drawable> load(android.graphics.Bitmap bitmap) {
        return (io.dcloud.glide.GlideRequest) super.load(bitmap);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    public com.bumptech.glide.RequestBuilder<android.graphics.drawable.Drawable> load(android.graphics.drawable.Drawable drawable) {
        return (io.dcloud.glide.GlideRequest) super.load(drawable);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    public com.bumptech.glide.RequestBuilder<android.graphics.drawable.Drawable> load(java.lang.String str) {
        return (io.dcloud.glide.GlideRequest) super.load(str);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    public com.bumptech.glide.RequestBuilder<android.graphics.drawable.Drawable> load(android.net.Uri uri) {
        return (io.dcloud.glide.GlideRequest) super.load(uri);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    public com.bumptech.glide.RequestBuilder<android.graphics.drawable.Drawable> load(java.io.File file) {
        return (io.dcloud.glide.GlideRequest) super.load(file);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    public com.bumptech.glide.RequestBuilder<android.graphics.drawable.Drawable> load(java.lang.Integer num) {
        return (io.dcloud.glide.GlideRequest) super.load(num);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    @java.lang.Deprecated
    public com.bumptech.glide.RequestBuilder<android.graphics.drawable.Drawable> load(java.net.URL url) {
        return (io.dcloud.glide.GlideRequest) super.load(url);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    public com.bumptech.glide.RequestBuilder<android.graphics.drawable.Drawable> load(byte[] bArr) {
        return (io.dcloud.glide.GlideRequest) super.load(bArr);
    }

    @Override // com.bumptech.glide.RequestManager, com.bumptech.glide.ModelTypes
    public com.bumptech.glide.RequestBuilder<android.graphics.drawable.Drawable> load(java.lang.Object obj) {
        return (io.dcloud.glide.GlideRequest) super.load(obj);
    }

    @Override // com.bumptech.glide.RequestManager
    public io.dcloud.glide.GlideRequest<java.io.File> downloadOnly() {
        return (io.dcloud.glide.GlideRequest) super.downloadOnly();
    }

    @Override // com.bumptech.glide.RequestManager
    public io.dcloud.glide.GlideRequest<java.io.File> download(java.lang.Object obj) {
        return (io.dcloud.glide.GlideRequest) super.download(obj);
    }

    @Override // com.bumptech.glide.RequestManager
    public io.dcloud.glide.GlideRequest<java.io.File> asFile() {
        return (io.dcloud.glide.GlideRequest) super.asFile();
    }

    @Override // com.bumptech.glide.RequestManager
    protected void setRequestOptions(com.bumptech.glide.request.RequestOptions requestOptions) {
        if (requestOptions instanceof io.dcloud.glide.GlideOptions) {
            super.setRequestOptions(requestOptions);
        } else {
            super.setRequestOptions(new io.dcloud.glide.GlideOptions().apply((com.bumptech.glide.request.BaseRequestOptions<?>) requestOptions));
        }
    }
}
