package io.dcloud.glide;

/* JADX INFO: loaded from: classes2.dex */
public class GlideRequest<TranscodeType> extends com.bumptech.glide.RequestBuilder<TranscodeType> implements java.lang.Cloneable {
    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ com.bumptech.glide.RequestBuilder apply(com.bumptech.glide.request.BaseRequestOptions baseRequestOptions) {
        return apply((com.bumptech.glide.request.BaseRequestOptions<?>) baseRequestOptions);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ com.bumptech.glide.request.BaseRequestOptions apply(com.bumptech.glide.request.BaseRequestOptions baseRequestOptions) {
        return apply((com.bumptech.glide.request.BaseRequestOptions<?>) baseRequestOptions);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ com.bumptech.glide.request.BaseRequestOptions decode(java.lang.Class cls) {
        return decode((java.lang.Class<?>) cls);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ com.bumptech.glide.request.BaseRequestOptions optionalTransform(com.bumptech.glide.load.Transformation transformation) {
        return optionalTransform((com.bumptech.glide.load.Transformation<android.graphics.Bitmap>) transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ com.bumptech.glide.request.BaseRequestOptions set(com.bumptech.glide.load.Option option, java.lang.Object obj) {
        return set((com.bumptech.glide.load.Option<java.lang.Object>) option, obj);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ com.bumptech.glide.request.BaseRequestOptions transform(com.bumptech.glide.load.Transformation transformation) {
        return transform((com.bumptech.glide.load.Transformation<android.graphics.Bitmap>) transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public /* bridge */ /* synthetic */ com.bumptech.glide.request.BaseRequestOptions transform(com.bumptech.glide.load.Transformation[] transformationArr) {
        return transform((com.bumptech.glide.load.Transformation<android.graphics.Bitmap>[]) transformationArr);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @java.lang.Deprecated
    public /* bridge */ /* synthetic */ com.bumptech.glide.request.BaseRequestOptions transforms(com.bumptech.glide.load.Transformation[] transformationArr) {
        return transforms((com.bumptech.glide.load.Transformation<android.graphics.Bitmap>[]) transformationArr);
    }

    GlideRequest(java.lang.Class<TranscodeType> cls, com.bumptech.glide.RequestBuilder<?> requestBuilder) {
        super(cls, requestBuilder);
    }

    GlideRequest(com.bumptech.glide.Glide glide, com.bumptech.glide.RequestManager requestManager, java.lang.Class<TranscodeType> cls, android.content.Context context) {
        super(glide, requestManager, cls, context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.RequestBuilder
    public io.dcloud.glide.GlideRequest<java.io.File> getDownloadOnlyRequest() {
        return new io.dcloud.glide.GlideRequest(java.io.File.class, this).apply((com.bumptech.glide.request.BaseRequestOptions<?>) DOWNLOAD_ONLY_OPTIONS);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> sizeMultiplier(float f) {
        return (io.dcloud.glide.GlideRequest) super.sizeMultiplier(f);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> useUnlimitedSourceGeneratorsPool(boolean z) {
        return (io.dcloud.glide.GlideRequest) super.useUnlimitedSourceGeneratorsPool(z);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> useAnimationPool(boolean z) {
        return (io.dcloud.glide.GlideRequest) super.useAnimationPool(z);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> onlyRetrieveFromCache(boolean z) {
        return (io.dcloud.glide.GlideRequest) super.onlyRetrieveFromCache(z);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> diskCacheStrategy(com.bumptech.glide.load.engine.DiskCacheStrategy diskCacheStrategy) {
        return (io.dcloud.glide.GlideRequest) super.diskCacheStrategy(diskCacheStrategy);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> priority(com.bumptech.glide.Priority priority) {
        return (io.dcloud.glide.GlideRequest) super.priority(priority);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> placeholder(android.graphics.drawable.Drawable drawable) {
        return (io.dcloud.glide.GlideRequest) super.placeholder(drawable);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> placeholder(int i) {
        return (io.dcloud.glide.GlideRequest) super.placeholder(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> fallback(android.graphics.drawable.Drawable drawable) {
        return (io.dcloud.glide.GlideRequest) super.fallback(drawable);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> fallback(int i) {
        return (io.dcloud.glide.GlideRequest) super.fallback(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> error(android.graphics.drawable.Drawable drawable) {
        return (io.dcloud.glide.GlideRequest) super.error(drawable);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> error(int i) {
        return (io.dcloud.glide.GlideRequest) super.error(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> theme(android.content.res.Resources.Theme theme) {
        return (io.dcloud.glide.GlideRequest) super.theme(theme);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> skipMemoryCache(boolean z) {
        return (io.dcloud.glide.GlideRequest) super.skipMemoryCache(z);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> override(int i, int i2) {
        return (io.dcloud.glide.GlideRequest) super.override(i, i2);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> override(int i) {
        return (io.dcloud.glide.GlideRequest) super.override(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> signature(com.bumptech.glide.load.Key key) {
        return (io.dcloud.glide.GlideRequest) super.signature(key);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public <Y> io.dcloud.glide.GlideRequest<TranscodeType> set(com.bumptech.glide.load.Option<Y> option, Y y) {
        return (io.dcloud.glide.GlideRequest) super.set((com.bumptech.glide.load.Option) option, (java.lang.Object) y);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> decode(java.lang.Class<?> cls) {
        return (io.dcloud.glide.GlideRequest) super.decode(cls);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> encodeFormat(android.graphics.Bitmap.CompressFormat compressFormat) {
        return (io.dcloud.glide.GlideRequest) super.encodeFormat(compressFormat);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> encodeQuality(int i) {
        return (io.dcloud.glide.GlideRequest) super.encodeQuality(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> frame(long j) {
        return (io.dcloud.glide.GlideRequest) super.frame(j);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> format(com.bumptech.glide.load.DecodeFormat decodeFormat) {
        return (io.dcloud.glide.GlideRequest) super.format(decodeFormat);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> disallowHardwareConfig() {
        return (io.dcloud.glide.GlideRequest) super.disallowHardwareConfig();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> downsample(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy downsampleStrategy) {
        return (io.dcloud.glide.GlideRequest) super.downsample(downsampleStrategy);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> timeout(int i) {
        return (io.dcloud.glide.GlideRequest) super.timeout(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> optionalCenterCrop() {
        return (io.dcloud.glide.GlideRequest) super.optionalCenterCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> centerCrop() {
        return (io.dcloud.glide.GlideRequest) super.centerCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> optionalFitCenter() {
        return (io.dcloud.glide.GlideRequest) super.optionalFitCenter();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> fitCenter() {
        return (io.dcloud.glide.GlideRequest) super.fitCenter();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> optionalCenterInside() {
        return (io.dcloud.glide.GlideRequest) super.optionalCenterInside();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> centerInside() {
        return (io.dcloud.glide.GlideRequest) super.centerInside();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> optionalCircleCrop() {
        return (io.dcloud.glide.GlideRequest) super.optionalCircleCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> circleCrop() {
        return (io.dcloud.glide.GlideRequest) super.circleCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> transform(com.bumptech.glide.load.Transformation<android.graphics.Bitmap> transformation) {
        return (io.dcloud.glide.GlideRequest) super.transform(transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> transform(com.bumptech.glide.load.Transformation<android.graphics.Bitmap>... transformationArr) {
        return (io.dcloud.glide.GlideRequest) super.transform(transformationArr);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @java.lang.Deprecated
    public io.dcloud.glide.GlideRequest<TranscodeType> transforms(com.bumptech.glide.load.Transformation<android.graphics.Bitmap>... transformationArr) {
        return (io.dcloud.glide.GlideRequest) super.transforms(transformationArr);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> optionalTransform(com.bumptech.glide.load.Transformation<android.graphics.Bitmap> transformation) {
        return (io.dcloud.glide.GlideRequest) super.optionalTransform(transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public <Y> io.dcloud.glide.GlideRequest<TranscodeType> optionalTransform(java.lang.Class<Y> cls, com.bumptech.glide.load.Transformation<Y> transformation) {
        return (io.dcloud.glide.GlideRequest) super.optionalTransform((java.lang.Class) cls, (com.bumptech.glide.load.Transformation) transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public <Y> io.dcloud.glide.GlideRequest<TranscodeType> transform(java.lang.Class<Y> cls, com.bumptech.glide.load.Transformation<Y> transformation) {
        return (io.dcloud.glide.GlideRequest) super.transform((java.lang.Class) cls, (com.bumptech.glide.load.Transformation) transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> dontTransform() {
        return (io.dcloud.glide.GlideRequest) super.dontTransform();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> dontAnimate() {
        return (io.dcloud.glide.GlideRequest) super.dontAnimate();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> lock() {
        return (io.dcloud.glide.GlideRequest) super.lock();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> autoClone() {
        return (io.dcloud.glide.GlideRequest) super.autoClone();
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideRequest<TranscodeType> apply(com.bumptech.glide.request.BaseRequestOptions<?> baseRequestOptions) {
        return (io.dcloud.glide.GlideRequest) super.apply(baseRequestOptions);
    }

    @Override // com.bumptech.glide.RequestBuilder
    public io.dcloud.glide.GlideRequest<TranscodeType> transition(com.bumptech.glide.TransitionOptions<?, ? super TranscodeType> transitionOptions) {
        return (io.dcloud.glide.GlideRequest) super.transition((com.bumptech.glide.TransitionOptions) transitionOptions);
    }

    @Override // com.bumptech.glide.RequestBuilder
    public io.dcloud.glide.GlideRequest<TranscodeType> listener(com.bumptech.glide.request.RequestListener<TranscodeType> requestListener) {
        return (io.dcloud.glide.GlideRequest) super.listener((com.bumptech.glide.request.RequestListener) requestListener);
    }

    @Override // com.bumptech.glide.RequestBuilder
    public io.dcloud.glide.GlideRequest<TranscodeType> addListener(com.bumptech.glide.request.RequestListener<TranscodeType> requestListener) {
        return (io.dcloud.glide.GlideRequest) super.addListener((com.bumptech.glide.request.RequestListener) requestListener);
    }

    @Override // com.bumptech.glide.RequestBuilder
    public io.dcloud.glide.GlideRequest<TranscodeType> error(com.bumptech.glide.RequestBuilder<TranscodeType> requestBuilder) {
        return (io.dcloud.glide.GlideRequest) super.error((com.bumptech.glide.RequestBuilder) requestBuilder);
    }

    @Override // com.bumptech.glide.RequestBuilder
    public io.dcloud.glide.GlideRequest<TranscodeType> error(java.lang.Object obj) {
        return (io.dcloud.glide.GlideRequest) super.error(obj);
    }

    @Override // com.bumptech.glide.RequestBuilder
    public io.dcloud.glide.GlideRequest<TranscodeType> thumbnail(com.bumptech.glide.RequestBuilder<TranscodeType> requestBuilder) {
        return (io.dcloud.glide.GlideRequest) super.thumbnail((com.bumptech.glide.RequestBuilder) requestBuilder);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @java.lang.SafeVarargs
    public final io.dcloud.glide.GlideRequest<TranscodeType> thumbnail(com.bumptech.glide.RequestBuilder<TranscodeType>... requestBuilderArr) {
        return (io.dcloud.glide.GlideRequest) super.thumbnail((com.bumptech.glide.RequestBuilder[]) requestBuilderArr);
    }

    @Override // com.bumptech.glide.RequestBuilder
    public io.dcloud.glide.GlideRequest<TranscodeType> thumbnail(java.util.List<com.bumptech.glide.RequestBuilder<TranscodeType>> list) {
        return (io.dcloud.glide.GlideRequest) super.thumbnail((java.util.List) list);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @java.lang.Deprecated
    public io.dcloud.glide.GlideRequest<TranscodeType> thumbnail(float f) {
        return (io.dcloud.glide.GlideRequest) super.thumbnail(f);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    public io.dcloud.glide.GlideRequest<TranscodeType> load(java.lang.Object obj) {
        return (io.dcloud.glide.GlideRequest) super.load(obj);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    public io.dcloud.glide.GlideRequest<TranscodeType> load(android.graphics.Bitmap bitmap) {
        return (io.dcloud.glide.GlideRequest) super.load(bitmap);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    public io.dcloud.glide.GlideRequest<TranscodeType> load(android.graphics.drawable.Drawable drawable) {
        return (io.dcloud.glide.GlideRequest) super.load(drawable);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    public io.dcloud.glide.GlideRequest<TranscodeType> load(java.lang.String str) {
        return (io.dcloud.glide.GlideRequest) super.load(str);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    public io.dcloud.glide.GlideRequest<TranscodeType> load(android.net.Uri uri) {
        return (io.dcloud.glide.GlideRequest) super.load(uri);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    public io.dcloud.glide.GlideRequest<TranscodeType> load(java.io.File file) {
        return (io.dcloud.glide.GlideRequest) super.load(file);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    public io.dcloud.glide.GlideRequest<TranscodeType> load(java.lang.Integer num) {
        return (io.dcloud.glide.GlideRequest) super.load(num);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    @java.lang.Deprecated
    public io.dcloud.glide.GlideRequest<TranscodeType> load(java.net.URL url) {
        return (io.dcloud.glide.GlideRequest) super.load(url);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.ModelTypes
    public io.dcloud.glide.GlideRequest<TranscodeType> load(byte[] bArr) {
        return (io.dcloud.glide.GlideRequest) super.load(bArr);
    }

    @Override // com.bumptech.glide.RequestBuilder, com.bumptech.glide.request.BaseRequestOptions
    /* JADX INFO: renamed from: clone */
    public io.dcloud.glide.GlideRequest<TranscodeType> mo206clone() {
        return (io.dcloud.glide.GlideRequest) super.mo206clone();
    }
}
