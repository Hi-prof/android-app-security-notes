package io.dcloud.glide;

/* JADX INFO: loaded from: classes2.dex */
public final class GlideOptions extends com.bumptech.glide.request.RequestOptions implements java.lang.Cloneable {
    private static io.dcloud.glide.GlideOptions centerCropTransform2;
    private static io.dcloud.glide.GlideOptions centerInsideTransform1;
    private static io.dcloud.glide.GlideOptions circleCropTransform3;
    private static io.dcloud.glide.GlideOptions fitCenterTransform0;
    private static io.dcloud.glide.GlideOptions noAnimation5;
    private static io.dcloud.glide.GlideOptions noTransformation4;

    @Override // com.bumptech.glide.request.BaseRequestOptions
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
    @java.lang.SafeVarargs
    public /* bridge */ /* synthetic */ com.bumptech.glide.request.BaseRequestOptions transform(com.bumptech.glide.load.Transformation[] transformationArr) {
        return transform((com.bumptech.glide.load.Transformation<android.graphics.Bitmap>[]) transformationArr);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @java.lang.SafeVarargs
    @java.lang.Deprecated
    public /* bridge */ /* synthetic */ com.bumptech.glide.request.BaseRequestOptions transforms(com.bumptech.glide.load.Transformation[] transformationArr) {
        return transforms((com.bumptech.glide.load.Transformation<android.graphics.Bitmap>[]) transformationArr);
    }

    public static io.dcloud.glide.GlideOptions sizeMultiplierOf(float f) {
        return new io.dcloud.glide.GlideOptions().sizeMultiplier(f);
    }

    public static io.dcloud.glide.GlideOptions diskCacheStrategyOf(com.bumptech.glide.load.engine.DiskCacheStrategy diskCacheStrategy) {
        return new io.dcloud.glide.GlideOptions().diskCacheStrategy(diskCacheStrategy);
    }

    public static io.dcloud.glide.GlideOptions priorityOf(com.bumptech.glide.Priority priority) {
        return new io.dcloud.glide.GlideOptions().priority(priority);
    }

    public static io.dcloud.glide.GlideOptions placeholderOf(android.graphics.drawable.Drawable drawable) {
        return new io.dcloud.glide.GlideOptions().placeholder(drawable);
    }

    public static io.dcloud.glide.GlideOptions placeholderOf(int i) {
        return new io.dcloud.glide.GlideOptions().placeholder(i);
    }

    public static io.dcloud.glide.GlideOptions errorOf(android.graphics.drawable.Drawable drawable) {
        return new io.dcloud.glide.GlideOptions().error(drawable);
    }

    public static io.dcloud.glide.GlideOptions errorOf(int i) {
        return new io.dcloud.glide.GlideOptions().error(i);
    }

    public static io.dcloud.glide.GlideOptions skipMemoryCacheOf(boolean z) {
        return new io.dcloud.glide.GlideOptions().skipMemoryCache(z);
    }

    public static io.dcloud.glide.GlideOptions overrideOf(int i, int i2) {
        return new io.dcloud.glide.GlideOptions().override(i, i2);
    }

    public static io.dcloud.glide.GlideOptions overrideOf(int i) {
        return new io.dcloud.glide.GlideOptions().override(i);
    }

    public static io.dcloud.glide.GlideOptions signatureOf(com.bumptech.glide.load.Key key) {
        return new io.dcloud.glide.GlideOptions().signature(key);
    }

    public static io.dcloud.glide.GlideOptions fitCenterTransform() {
        if (fitCenterTransform0 == null) {
            fitCenterTransform0 = new io.dcloud.glide.GlideOptions().fitCenter().autoClone();
        }
        return fitCenterTransform0;
    }

    public static io.dcloud.glide.GlideOptions centerInsideTransform() {
        if (centerInsideTransform1 == null) {
            centerInsideTransform1 = new io.dcloud.glide.GlideOptions().centerInside().autoClone();
        }
        return centerInsideTransform1;
    }

    public static io.dcloud.glide.GlideOptions centerCropTransform() {
        if (centerCropTransform2 == null) {
            centerCropTransform2 = new io.dcloud.glide.GlideOptions().centerCrop().autoClone();
        }
        return centerCropTransform2;
    }

    public static io.dcloud.glide.GlideOptions circleCropTransform() {
        if (circleCropTransform3 == null) {
            circleCropTransform3 = new io.dcloud.glide.GlideOptions().circleCrop().autoClone();
        }
        return circleCropTransform3;
    }

    public static io.dcloud.glide.GlideOptions bitmapTransform(com.bumptech.glide.load.Transformation<android.graphics.Bitmap> transformation) {
        return new io.dcloud.glide.GlideOptions().transform(transformation);
    }

    public static io.dcloud.glide.GlideOptions noTransformation() {
        if (noTransformation4 == null) {
            noTransformation4 = new io.dcloud.glide.GlideOptions().dontTransform().autoClone();
        }
        return noTransformation4;
    }

    public static <T> io.dcloud.glide.GlideOptions option(com.bumptech.glide.load.Option<T> option, T t) {
        return new io.dcloud.glide.GlideOptions().set(option, t);
    }

    public static io.dcloud.glide.GlideOptions decodeTypeOf(java.lang.Class<?> cls) {
        return new io.dcloud.glide.GlideOptions().decode(cls);
    }

    public static io.dcloud.glide.GlideOptions formatOf(com.bumptech.glide.load.DecodeFormat decodeFormat) {
        return new io.dcloud.glide.GlideOptions().format(decodeFormat);
    }

    public static io.dcloud.glide.GlideOptions frameOf(long j) {
        return new io.dcloud.glide.GlideOptions().frame(j);
    }

    public static io.dcloud.glide.GlideOptions downsampleOf(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy downsampleStrategy) {
        return new io.dcloud.glide.GlideOptions().downsample(downsampleStrategy);
    }

    public static io.dcloud.glide.GlideOptions timeoutOf(int i) {
        return new io.dcloud.glide.GlideOptions().timeout(i);
    }

    public static io.dcloud.glide.GlideOptions encodeQualityOf(int i) {
        return new io.dcloud.glide.GlideOptions().encodeQuality(i);
    }

    public static io.dcloud.glide.GlideOptions encodeFormatOf(android.graphics.Bitmap.CompressFormat compressFormat) {
        return new io.dcloud.glide.GlideOptions().encodeFormat(compressFormat);
    }

    public static io.dcloud.glide.GlideOptions noAnimation() {
        if (noAnimation5 == null) {
            noAnimation5 = new io.dcloud.glide.GlideOptions().dontAnimate().autoClone();
        }
        return noAnimation5;
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions sizeMultiplier(float f) {
        return (io.dcloud.glide.GlideOptions) super.sizeMultiplier(f);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions useUnlimitedSourceGeneratorsPool(boolean z) {
        return (io.dcloud.glide.GlideOptions) super.useUnlimitedSourceGeneratorsPool(z);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions useAnimationPool(boolean z) {
        return (io.dcloud.glide.GlideOptions) super.useAnimationPool(z);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions onlyRetrieveFromCache(boolean z) {
        return (io.dcloud.glide.GlideOptions) super.onlyRetrieveFromCache(z);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions diskCacheStrategy(com.bumptech.glide.load.engine.DiskCacheStrategy diskCacheStrategy) {
        return (io.dcloud.glide.GlideOptions) super.diskCacheStrategy(diskCacheStrategy);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions priority(com.bumptech.glide.Priority priority) {
        return (io.dcloud.glide.GlideOptions) super.priority(priority);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions placeholder(android.graphics.drawable.Drawable drawable) {
        return (io.dcloud.glide.GlideOptions) super.placeholder(drawable);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions placeholder(int i) {
        return (io.dcloud.glide.GlideOptions) super.placeholder(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions fallback(android.graphics.drawable.Drawable drawable) {
        return (io.dcloud.glide.GlideOptions) super.fallback(drawable);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions fallback(int i) {
        return (io.dcloud.glide.GlideOptions) super.fallback(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions error(android.graphics.drawable.Drawable drawable) {
        return (io.dcloud.glide.GlideOptions) super.error(drawable);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions error(int i) {
        return (io.dcloud.glide.GlideOptions) super.error(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions theme(android.content.res.Resources.Theme theme) {
        return (io.dcloud.glide.GlideOptions) super.theme(theme);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions skipMemoryCache(boolean z) {
        return (io.dcloud.glide.GlideOptions) super.skipMemoryCache(z);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions override(int i, int i2) {
        return (io.dcloud.glide.GlideOptions) super.override(i, i2);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions override(int i) {
        return (io.dcloud.glide.GlideOptions) super.override(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions signature(com.bumptech.glide.load.Key key) {
        return (io.dcloud.glide.GlideOptions) super.signature(key);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    /* JADX INFO: renamed from: clone */
    public io.dcloud.glide.GlideOptions mo206clone() {
        return (io.dcloud.glide.GlideOptions) super.mo206clone();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public <Y> io.dcloud.glide.GlideOptions set(com.bumptech.glide.load.Option<Y> option, Y y) {
        return (io.dcloud.glide.GlideOptions) super.set((com.bumptech.glide.load.Option) option, (java.lang.Object) y);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions decode(java.lang.Class<?> cls) {
        return (io.dcloud.glide.GlideOptions) super.decode(cls);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions encodeFormat(android.graphics.Bitmap.CompressFormat compressFormat) {
        return (io.dcloud.glide.GlideOptions) super.encodeFormat(compressFormat);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions encodeQuality(int i) {
        return (io.dcloud.glide.GlideOptions) super.encodeQuality(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions frame(long j) {
        return (io.dcloud.glide.GlideOptions) super.frame(j);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions format(com.bumptech.glide.load.DecodeFormat decodeFormat) {
        return (io.dcloud.glide.GlideOptions) super.format(decodeFormat);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions disallowHardwareConfig() {
        return (io.dcloud.glide.GlideOptions) super.disallowHardwareConfig();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions downsample(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy downsampleStrategy) {
        return (io.dcloud.glide.GlideOptions) super.downsample(downsampleStrategy);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions timeout(int i) {
        return (io.dcloud.glide.GlideOptions) super.timeout(i);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions optionalCenterCrop() {
        return (io.dcloud.glide.GlideOptions) super.optionalCenterCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions centerCrop() {
        return (io.dcloud.glide.GlideOptions) super.centerCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions optionalFitCenter() {
        return (io.dcloud.glide.GlideOptions) super.optionalFitCenter();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions fitCenter() {
        return (io.dcloud.glide.GlideOptions) super.fitCenter();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions optionalCenterInside() {
        return (io.dcloud.glide.GlideOptions) super.optionalCenterInside();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions centerInside() {
        return (io.dcloud.glide.GlideOptions) super.centerInside();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions optionalCircleCrop() {
        return (io.dcloud.glide.GlideOptions) super.optionalCircleCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions circleCrop() {
        return (io.dcloud.glide.GlideOptions) super.circleCrop();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions transform(com.bumptech.glide.load.Transformation<android.graphics.Bitmap> transformation) {
        return (io.dcloud.glide.GlideOptions) super.transform(transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @java.lang.SafeVarargs
    public final io.dcloud.glide.GlideOptions transform(com.bumptech.glide.load.Transformation<android.graphics.Bitmap>... transformationArr) {
        return (io.dcloud.glide.GlideOptions) super.transform(transformationArr);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @java.lang.SafeVarargs
    @java.lang.Deprecated
    public final io.dcloud.glide.GlideOptions transforms(com.bumptech.glide.load.Transformation<android.graphics.Bitmap>... transformationArr) {
        return (io.dcloud.glide.GlideOptions) super.transforms(transformationArr);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions optionalTransform(com.bumptech.glide.load.Transformation<android.graphics.Bitmap> transformation) {
        return (io.dcloud.glide.GlideOptions) super.optionalTransform(transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public <Y> io.dcloud.glide.GlideOptions optionalTransform(java.lang.Class<Y> cls, com.bumptech.glide.load.Transformation<Y> transformation) {
        return (io.dcloud.glide.GlideOptions) super.optionalTransform((java.lang.Class) cls, (com.bumptech.glide.load.Transformation) transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public <Y> io.dcloud.glide.GlideOptions transform(java.lang.Class<Y> cls, com.bumptech.glide.load.Transformation<Y> transformation) {
        return (io.dcloud.glide.GlideOptions) super.transform((java.lang.Class) cls, (com.bumptech.glide.load.Transformation) transformation);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions dontTransform() {
        return (io.dcloud.glide.GlideOptions) super.dontTransform();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions dontAnimate() {
        return (io.dcloud.glide.GlideOptions) super.dontAnimate();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions apply(com.bumptech.glide.request.BaseRequestOptions<?> baseRequestOptions) {
        return (io.dcloud.glide.GlideOptions) super.apply(baseRequestOptions);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions lock() {
        return (io.dcloud.glide.GlideOptions) super.lock();
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public io.dcloud.glide.GlideOptions autoClone() {
        return (io.dcloud.glide.GlideOptions) super.autoClone();
    }
}
