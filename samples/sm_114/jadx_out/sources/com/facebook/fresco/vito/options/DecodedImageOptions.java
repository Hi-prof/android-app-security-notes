package com.facebook.fresco.vito.options;

/* JADX INFO: compiled from: DecodedImageOptions.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001BB\u0013\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u00107\u001a\u00020+J\u0013\u00108\u001a\u00020+2\b\u00109\u001a\u0004\u0018\u00010:H\u0096\u0002J\u0010\u0010;\u001a\u00020+2\u0006\u00109\u001a\u00020\u0000H\u0004J\b\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u00020AH\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010&\u001a\u0004\u0018\u00010'¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010*\u001a\u00020+¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010.\u001a\u00020+¢\u0006\b\n\u0000\u001a\u0004\b/\u0010-R\u0013\u00100\u001a\u0004\u0018\u000101¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0015\u00104\u001a\u0004\u0018\u00010+¢\u0006\n\n\u0002\u00106\u001a\u0004\b4\u00105¨\u0006C"}, d2 = {"Lcom/facebook/fresco/vito/options/DecodedImageOptions;", "Lcom/facebook/fresco/vito/options/EncodedImageOptions;", "builder", "Lcom/facebook/fresco/vito/options/DecodedImageOptions$Builder;", "<init>", "(Lcom/facebook/fresco/vito/options/DecodedImageOptions$Builder;)V", "resizeOptions", "Lcom/facebook/imagepipeline/common/ResizeOptions;", "getResizeOptions", "()Lcom/facebook/imagepipeline/common/ResizeOptions;", "downsampleOverride", "Lcom/facebook/imagepipeline/core/DownsampleMode;", "getDownsampleOverride", "()Lcom/facebook/imagepipeline/core/DownsampleMode;", "rotationOptions", "Lcom/facebook/imagepipeline/common/RotationOptions;", "getRotationOptions", "()Lcom/facebook/imagepipeline/common/RotationOptions;", "postprocessor", "Lcom/facebook/imagepipeline/request/Postprocessor;", "getPostprocessor", "()Lcom/facebook/imagepipeline/request/Postprocessor;", "imageDecodeOptions", "Lcom/facebook/imagepipeline/common/ImageDecodeOptions;", "getImageDecodeOptions", "()Lcom/facebook/imagepipeline/common/ImageDecodeOptions;", "roundingOptions", "Lcom/facebook/fresco/vito/options/RoundingOptions;", "getRoundingOptions", "()Lcom/facebook/fresco/vito/options/RoundingOptions;", "borderOptions", "Lcom/facebook/fresco/vito/options/BorderOptions;", "getBorderOptions", "()Lcom/facebook/fresco/vito/options/BorderOptions;", "actualImageScaleType", "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "getActualImageScaleType", "()Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "actualImageFocusPoint", "Landroid/graphics/PointF;", "getActualImageFocusPoint", "()Landroid/graphics/PointF;", "mLocalThumbnailPreviewsEnabled", "", "getMLocalThumbnailPreviewsEnabled", "()Z", "loadThumbnailOnly", "getLoadThumbnailOnly", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "getBitmapConfig", "()Landroid/graphics/Bitmap$Config;", "isProgressiveDecodingEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "areLocalThumbnailPreviewsEnabled", "equals", "other", "", "equalDecodedOptions", "hashCode", "", "toString", "", "toStringHelper", "Lcom/facebook/common/internal/Objects$ToStringHelper;", "Builder", "options_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class DecodedImageOptions extends com.facebook.fresco.vito.options.EncodedImageOptions {
    private final android.graphics.PointF actualImageFocusPoint;
    private final com.facebook.drawee.drawable.ScalingUtils.ScaleType actualImageScaleType;
    private final android.graphics.Bitmap.Config bitmapConfig;
    private final com.facebook.fresco.vito.options.BorderOptions borderOptions;
    private final com.facebook.imagepipeline.core.DownsampleMode downsampleOverride;
    private final com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions;
    private final java.lang.Boolean isProgressiveDecodingEnabled;
    private final boolean loadThumbnailOnly;
    private final boolean mLocalThumbnailPreviewsEnabled;
    private final com.facebook.imagepipeline.request.Postprocessor postprocessor;
    private final com.facebook.imagepipeline.common.ResizeOptions resizeOptions;
    private final com.facebook.imagepipeline.common.RotationOptions rotationOptions;
    private final com.facebook.fresco.vito.options.RoundingOptions roundingOptions;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DecodedImageOptions(com.facebook.fresco.vito.options.DecodedImageOptions.Builder<?> builder) {
        super(builder);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builder, "builder");
        this.resizeOptions = builder.getResizeOptions();
        this.downsampleOverride = builder.getDownsampleOverride();
        this.rotationOptions = builder.getRotationOptions();
        this.postprocessor = builder.getPostprocessor();
        this.imageDecodeOptions = builder.getImageDecodeOptions();
        this.roundingOptions = builder.getRoundingOptions();
        this.borderOptions = builder.getBorderOptions();
        this.actualImageScaleType = builder.getActualImageScaleType();
        this.actualImageFocusPoint = builder.getActualFocusPoint();
        this.mLocalThumbnailPreviewsEnabled = builder.getLocalThumbnailPreviewsEnabled();
        this.loadThumbnailOnly = builder.getLoadThumbnailOnly();
        this.bitmapConfig = builder.getBitmapConfig();
        this.isProgressiveDecodingEnabled = builder.getProgressiveDecodingEnabled();
    }

    public final com.facebook.imagepipeline.common.ResizeOptions getResizeOptions() {
        return this.resizeOptions;
    }

    public final com.facebook.imagepipeline.core.DownsampleMode getDownsampleOverride() {
        return this.downsampleOverride;
    }

    public final com.facebook.imagepipeline.common.RotationOptions getRotationOptions() {
        return this.rotationOptions;
    }

    public final com.facebook.imagepipeline.request.Postprocessor getPostprocessor() {
        return this.postprocessor;
    }

    public final com.facebook.imagepipeline.common.ImageDecodeOptions getImageDecodeOptions() {
        return this.imageDecodeOptions;
    }

    public final com.facebook.fresco.vito.options.RoundingOptions getRoundingOptions() {
        return this.roundingOptions;
    }

    public final com.facebook.fresco.vito.options.BorderOptions getBorderOptions() {
        return this.borderOptions;
    }

    public final com.facebook.drawee.drawable.ScalingUtils.ScaleType getActualImageScaleType() {
        return this.actualImageScaleType;
    }

    public final android.graphics.PointF getActualImageFocusPoint() {
        return this.actualImageFocusPoint;
    }

    public final boolean getMLocalThumbnailPreviewsEnabled() {
        return this.mLocalThumbnailPreviewsEnabled;
    }

    public final boolean getLoadThumbnailOnly() {
        return this.loadThumbnailOnly;
    }

    public final android.graphics.Bitmap.Config getBitmapConfig() {
        return this.bitmapConfig;
    }

    /* JADX INFO: renamed from: isProgressiveDecodingEnabled, reason: from getter */
    public final java.lang.Boolean getIsProgressiveDecodingEnabled() {
        return this.isProgressiveDecodingEnabled;
    }

    /* JADX INFO: renamed from: areLocalThumbnailPreviewsEnabled, reason: from getter */
    public final boolean getMLocalThumbnailPreviewsEnabled() {
        return this.mLocalThumbnailPreviewsEnabled;
    }

    @Override // com.facebook.fresco.vito.options.EncodedImageOptions
    public boolean equals(java.lang.Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !kotlin.jvm.internal.Intrinsics.areEqual(getClass(), other.getClass())) {
            return false;
        }
        return equalDecodedOptions((com.facebook.fresco.vito.options.DecodedImageOptions) other);
    }

    protected final boolean equalDecodedOptions(com.facebook.fresco.vito.options.DecodedImageOptions other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        if (com.facebook.common.internal.Objects.equal(this.resizeOptions, other.resizeOptions) && com.facebook.common.internal.Objects.equal(this.downsampleOverride, other.downsampleOverride) && com.facebook.common.internal.Objects.equal(this.rotationOptions, other.rotationOptions) && com.facebook.common.internal.Objects.equal(this.postprocessor, other.postprocessor) && com.facebook.common.internal.Objects.equal(this.imageDecodeOptions, other.imageDecodeOptions) && com.facebook.common.internal.Objects.equal(this.roundingOptions, other.roundingOptions) && com.facebook.common.internal.Objects.equal(this.borderOptions, other.borderOptions) && com.facebook.common.internal.Objects.equal(this.actualImageScaleType, other.actualImageScaleType) && com.facebook.common.internal.Objects.equal(this.actualImageFocusPoint, other.actualImageFocusPoint) && this.mLocalThumbnailPreviewsEnabled == other.mLocalThumbnailPreviewsEnabled && this.loadThumbnailOnly == other.loadThumbnailOnly && this.isProgressiveDecodingEnabled == other.isProgressiveDecodingEnabled && com.facebook.common.internal.Objects.equal(this.bitmapConfig, other.bitmapConfig)) {
            return equalEncodedOptions(other);
        }
        return false;
    }

    @Override // com.facebook.fresco.vito.options.EncodedImageOptions
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        com.facebook.imagepipeline.common.ResizeOptions resizeOptions = this.resizeOptions;
        int iHashCode2 = (iHashCode + (resizeOptions != null ? resizeOptions.hashCode() : 0)) * 31;
        com.facebook.imagepipeline.core.DownsampleMode downsampleMode = this.downsampleOverride;
        int iHashCode3 = (iHashCode2 + (downsampleMode != null ? downsampleMode.hashCode() : 0)) * 31;
        com.facebook.imagepipeline.common.RotationOptions rotationOptions = this.rotationOptions;
        int iHashCode4 = (iHashCode3 + (rotationOptions != null ? rotationOptions.hashCode() : 0)) * 31;
        com.facebook.imagepipeline.request.Postprocessor postprocessor = this.postprocessor;
        int iHashCode5 = (iHashCode4 + (postprocessor != null ? postprocessor.hashCode() : 0)) * 31;
        com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions = this.imageDecodeOptions;
        int iHashCode6 = (iHashCode5 + (imageDecodeOptions != null ? imageDecodeOptions.hashCode() : 0)) * 31;
        com.facebook.fresco.vito.options.RoundingOptions roundingOptions = this.roundingOptions;
        int iHashCode7 = (iHashCode6 + (roundingOptions != null ? roundingOptions.hashCode() : 0)) * 31;
        com.facebook.fresco.vito.options.BorderOptions borderOptions = this.borderOptions;
        int iHashCode8 = (((iHashCode7 + (borderOptions != null ? borderOptions.hashCode() : 0)) * 31) + this.actualImageScaleType.hashCode()) * 31;
        android.graphics.PointF pointF = this.actualImageFocusPoint;
        int iHashCode9 = (((((iHashCode8 + (pointF != null ? pointF.hashCode() : 0)) * 31) + (this.mLocalThumbnailPreviewsEnabled ? 1 : 0)) * 31) + (this.loadThumbnailOnly ? 1 : 0)) * 31;
        android.graphics.Bitmap.Config config = this.bitmapConfig;
        int iHashCode10 = (iHashCode9 + (config != null ? config.hashCode() : 0)) * 31;
        java.lang.Boolean bool = this.isProgressiveDecodingEnabled;
        return iHashCode10 + (bool != null ? bool.hashCode() : 0);
    }

    @Override // com.facebook.fresco.vito.options.EncodedImageOptions
    public java.lang.String toString() {
        return "DecodedImageOptions{" + toStringHelper() + com.taobao.weex.el.parse.Operators.BLOCK_END_STR;
    }

    @Override // com.facebook.fresco.vito.options.EncodedImageOptions
    protected com.facebook.common.internal.Objects.ToStringHelper toStringHelper() {
        com.facebook.common.internal.Objects.ToStringHelper toStringHelperAdd = super.toStringHelper().add("resizeOptions", this.resizeOptions).add("downsampleOverride", this.downsampleOverride).add("rotationOptions", this.rotationOptions).add("postprocessor", this.postprocessor).add("imageDecodeOptions", this.imageDecodeOptions).add("roundingOptions", this.roundingOptions).add("borderOptions", this.borderOptions).add("actualImageScaleType", this.actualImageScaleType).add("actualImageFocusPoint", this.actualImageFocusPoint).add("localThumbnailPreviewsEnabled", this.mLocalThumbnailPreviewsEnabled).add("loadThumbnailOnly", this.loadThumbnailOnly).add("bitmapConfig", this.bitmapConfig).add("progressiveRenderingEnabled", this.isProgressiveDecodingEnabled);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(toStringHelperAdd, "add(...)");
        return toStringHelperAdd;
    }

    /* JADX INFO: compiled from: DecodedImageOptions.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0003\u0010\nJ\u0015\u0010V\u001a\u00028\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010WJ\u0015\u0010\u0011\u001a\u00028\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010XJ\u0015\u0010Y\u001a\u00028\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010ZJ\u0015\u0010[\u001a\u00028\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\u0002\u0010\\J\u0015\u0010#\u001a\u00028\u00002\b\u0010#\u001a\u0004\u0018\u00010$¢\u0006\u0002\u0010]J\u0015\u0010^\u001a\u00028\u00002\b\u0010)\u001a\u0004\u0018\u00010*¢\u0006\u0002\u0010_J\u0015\u0010`\u001a\u00028\u00002\b\u0010/\u001a\u0004\u0018\u000100¢\u0006\u0002\u0010aJ\u0015\u0010b\u001a\u00028\u00002\b\u00105\u001a\u0004\u0018\u000106¢\u0006\u0002\u0010cJ\u0015\u0010d\u001a\u00028\u00002\b\u0010d\u001a\u0004\u0018\u00010<¢\u0006\u0002\u0010eJ\u0013\u0010A\u001a\u00028\u00002\u0006\u0010A\u001a\u00020B¢\u0006\u0002\u0010fJ\u0013\u0010G\u001a\u00028\u00002\u0006\u0010G\u001a\u00020B¢\u0006\u0002\u0010fJ\u0015\u0010J\u001a\u00028\u00002\b\u0010J\u001a\u0004\u0018\u00010K¢\u0006\u0002\u0010gJ\u0015\u0010h\u001a\u00028\u00002\b\u0010P\u001a\u0004\u0018\u00010B¢\u0006\u0002\u0010iJ\b\u0010j\u001a\u00020\u0006H\u0016J-\u0010k\u001a\u00028\u00002\u001d\u0010l\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\u0004\u0012\u00020n0m¢\u0006\u0002\boH\u0082\b¢\u0006\u0002\u0010pR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010/\u001a\u0004\u0018\u000100X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u000206X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010A\u001a\u00020BX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010G\u001a\u00020BX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010D\"\u0004\bI\u0010FR\u001c\u0010J\u001a\u0004\u0018\u00010KX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001e\u0010P\u001a\u0004\u0018\u00010BX\u0080\u000e¢\u0006\u0010\n\u0002\u0010U\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010T¨\u0006q"}, d2 = {"Lcom/facebook/fresco/vito/options/DecodedImageOptions$Builder;", "T", "Lcom/facebook/fresco/vito/options/EncodedImageOptions$Builder;", "<init>", "()V", "decodedImageOptions", "Lcom/facebook/fresco/vito/options/DecodedImageOptions;", "(Lcom/facebook/fresco/vito/options/DecodedImageOptions;)V", "defaultOptions", "Lcom/facebook/fresco/vito/options/ImageOptions;", "(Lcom/facebook/fresco/vito/options/ImageOptions;)V", "resizeOptions", "Lcom/facebook/imagepipeline/common/ResizeOptions;", "getResizeOptions$options_release", "()Lcom/facebook/imagepipeline/common/ResizeOptions;", "setResizeOptions$options_release", "(Lcom/facebook/imagepipeline/common/ResizeOptions;)V", "downsampleOverride", "Lcom/facebook/imagepipeline/core/DownsampleMode;", "getDownsampleOverride$options_release", "()Lcom/facebook/imagepipeline/core/DownsampleMode;", "setDownsampleOverride$options_release", "(Lcom/facebook/imagepipeline/core/DownsampleMode;)V", "rotationOptions", "Lcom/facebook/imagepipeline/common/RotationOptions;", "getRotationOptions$options_release", "()Lcom/facebook/imagepipeline/common/RotationOptions;", "setRotationOptions$options_release", "(Lcom/facebook/imagepipeline/common/RotationOptions;)V", "postprocessor", "Lcom/facebook/imagepipeline/request/Postprocessor;", "getPostprocessor$options_release", "()Lcom/facebook/imagepipeline/request/Postprocessor;", "setPostprocessor$options_release", "(Lcom/facebook/imagepipeline/request/Postprocessor;)V", "imageDecodeOptions", "Lcom/facebook/imagepipeline/common/ImageDecodeOptions;", "getImageDecodeOptions$options_release", "()Lcom/facebook/imagepipeline/common/ImageDecodeOptions;", "setImageDecodeOptions$options_release", "(Lcom/facebook/imagepipeline/common/ImageDecodeOptions;)V", "roundingOptions", "Lcom/facebook/fresco/vito/options/RoundingOptions;", "getRoundingOptions$options_release", "()Lcom/facebook/fresco/vito/options/RoundingOptions;", "setRoundingOptions$options_release", "(Lcom/facebook/fresco/vito/options/RoundingOptions;)V", "borderOptions", "Lcom/facebook/fresco/vito/options/BorderOptions;", "getBorderOptions$options_release", "()Lcom/facebook/fresco/vito/options/BorderOptions;", "setBorderOptions$options_release", "(Lcom/facebook/fresco/vito/options/BorderOptions;)V", "actualImageScaleType", "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "getActualImageScaleType$options_release", "()Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "setActualImageScaleType$options_release", "(Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)V", "actualFocusPoint", "Landroid/graphics/PointF;", "getActualFocusPoint$options_release", "()Landroid/graphics/PointF;", "setActualFocusPoint$options_release", "(Landroid/graphics/PointF;)V", "localThumbnailPreviewsEnabled", "", "getLocalThumbnailPreviewsEnabled$options_release", "()Z", "setLocalThumbnailPreviewsEnabled$options_release", "(Z)V", "loadThumbnailOnly", "getLoadThumbnailOnly$options_release", "setLoadThumbnailOnly$options_release", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "getBitmapConfig$options_release", "()Landroid/graphics/Bitmap$Config;", "setBitmapConfig$options_release", "(Landroid/graphics/Bitmap$Config;)V", "progressiveDecodingEnabled", "getProgressiveDecodingEnabled$options_release", "()Ljava/lang/Boolean;", "setProgressiveDecodingEnabled$options_release", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "resize", "(Lcom/facebook/imagepipeline/common/ResizeOptions;)Lcom/facebook/fresco/vito/options/DecodedImageOptions$Builder;", "(Lcom/facebook/imagepipeline/core/DownsampleMode;)Lcom/facebook/fresco/vito/options/DecodedImageOptions$Builder;", "rotate", "(Lcom/facebook/imagepipeline/common/RotationOptions;)Lcom/facebook/fresco/vito/options/DecodedImageOptions$Builder;", "postprocess", "(Lcom/facebook/imagepipeline/request/Postprocessor;)Lcom/facebook/fresco/vito/options/DecodedImageOptions$Builder;", "(Lcom/facebook/imagepipeline/common/ImageDecodeOptions;)Lcom/facebook/fresco/vito/options/DecodedImageOptions$Builder;", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ROUND, "(Lcom/facebook/fresco/vito/options/RoundingOptions;)Lcom/facebook/fresco/vito/options/DecodedImageOptions$Builder;", "borders", "(Lcom/facebook/fresco/vito/options/BorderOptions;)Lcom/facebook/fresco/vito/options/DecodedImageOptions$Builder;", "scale", "(Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)Lcom/facebook/fresco/vito/options/DecodedImageOptions$Builder;", "focusPoint", "(Landroid/graphics/PointF;)Lcom/facebook/fresco/vito/options/DecodedImageOptions$Builder;", "(Z)Lcom/facebook/fresco/vito/options/DecodedImageOptions$Builder;", "(Landroid/graphics/Bitmap$Config;)Lcom/facebook/fresco/vito/options/DecodedImageOptions$Builder;", "progressiveRendering", "(Ljava/lang/Boolean;)Lcom/facebook/fresco/vito/options/DecodedImageOptions$Builder;", "build", "modify", io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_BLOCK, "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)Lcom/facebook/fresco/vito/options/DecodedImageOptions$Builder;", "options_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static class Builder<T extends com.facebook.fresco.vito.options.DecodedImageOptions.Builder<T>> extends com.facebook.fresco.vito.options.EncodedImageOptions.Builder<T> {
        private android.graphics.PointF actualFocusPoint;
        private com.facebook.drawee.drawable.ScalingUtils.ScaleType actualImageScaleType;
        private android.graphics.Bitmap.Config bitmapConfig;
        private com.facebook.fresco.vito.options.BorderOptions borderOptions;
        private com.facebook.imagepipeline.core.DownsampleMode downsampleOverride;
        private com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions;
        private boolean loadThumbnailOnly;
        private boolean localThumbnailPreviewsEnabled;
        private com.facebook.imagepipeline.request.Postprocessor postprocessor;
        private java.lang.Boolean progressiveDecodingEnabled;
        private com.facebook.imagepipeline.common.ResizeOptions resizeOptions;
        private com.facebook.imagepipeline.common.RotationOptions rotationOptions;
        private com.facebook.fresco.vito.options.RoundingOptions roundingOptions;

        /* JADX INFO: renamed from: getResizeOptions$options_release, reason: from getter */
        public final com.facebook.imagepipeline.common.ResizeOptions getResizeOptions() {
            return this.resizeOptions;
        }

        public final void setResizeOptions$options_release(com.facebook.imagepipeline.common.ResizeOptions resizeOptions) {
            this.resizeOptions = resizeOptions;
        }

        /* JADX INFO: renamed from: getDownsampleOverride$options_release, reason: from getter */
        public final com.facebook.imagepipeline.core.DownsampleMode getDownsampleOverride() {
            return this.downsampleOverride;
        }

        public final void setDownsampleOverride$options_release(com.facebook.imagepipeline.core.DownsampleMode downsampleMode) {
            this.downsampleOverride = downsampleMode;
        }

        /* JADX INFO: renamed from: getRotationOptions$options_release, reason: from getter */
        public final com.facebook.imagepipeline.common.RotationOptions getRotationOptions() {
            return this.rotationOptions;
        }

        public final void setRotationOptions$options_release(com.facebook.imagepipeline.common.RotationOptions rotationOptions) {
            this.rotationOptions = rotationOptions;
        }

        /* JADX INFO: renamed from: getPostprocessor$options_release, reason: from getter */
        public final com.facebook.imagepipeline.request.Postprocessor getPostprocessor() {
            return this.postprocessor;
        }

        public final void setPostprocessor$options_release(com.facebook.imagepipeline.request.Postprocessor postprocessor) {
            this.postprocessor = postprocessor;
        }

        /* JADX INFO: renamed from: getImageDecodeOptions$options_release, reason: from getter */
        public final com.facebook.imagepipeline.common.ImageDecodeOptions getImageDecodeOptions() {
            return this.imageDecodeOptions;
        }

        public final void setImageDecodeOptions$options_release(com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions) {
            this.imageDecodeOptions = imageDecodeOptions;
        }

        /* JADX INFO: renamed from: getRoundingOptions$options_release, reason: from getter */
        public final com.facebook.fresco.vito.options.RoundingOptions getRoundingOptions() {
            return this.roundingOptions;
        }

        public final void setRoundingOptions$options_release(com.facebook.fresco.vito.options.RoundingOptions roundingOptions) {
            this.roundingOptions = roundingOptions;
        }

        /* JADX INFO: renamed from: getBorderOptions$options_release, reason: from getter */
        public final com.facebook.fresco.vito.options.BorderOptions getBorderOptions() {
            return this.borderOptions;
        }

        public final void setBorderOptions$options_release(com.facebook.fresco.vito.options.BorderOptions borderOptions) {
            this.borderOptions = borderOptions;
        }

        /* JADX INFO: renamed from: getActualImageScaleType$options_release, reason: from getter */
        public final com.facebook.drawee.drawable.ScalingUtils.ScaleType getActualImageScaleType() {
            return this.actualImageScaleType;
        }

        public final void setActualImageScaleType$options_release(com.facebook.drawee.drawable.ScalingUtils.ScaleType scaleType) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(scaleType, "<set-?>");
            this.actualImageScaleType = scaleType;
        }

        /* JADX INFO: renamed from: getActualFocusPoint$options_release, reason: from getter */
        public final android.graphics.PointF getActualFocusPoint() {
            return this.actualFocusPoint;
        }

        public final void setActualFocusPoint$options_release(android.graphics.PointF pointF) {
            this.actualFocusPoint = pointF;
        }

        /* JADX INFO: renamed from: getLocalThumbnailPreviewsEnabled$options_release, reason: from getter */
        public final boolean getLocalThumbnailPreviewsEnabled() {
            return this.localThumbnailPreviewsEnabled;
        }

        public final void setLocalThumbnailPreviewsEnabled$options_release(boolean z) {
            this.localThumbnailPreviewsEnabled = z;
        }

        /* JADX INFO: renamed from: getLoadThumbnailOnly$options_release, reason: from getter */
        public final boolean getLoadThumbnailOnly() {
            return this.loadThumbnailOnly;
        }

        public final void setLoadThumbnailOnly$options_release(boolean z) {
            this.loadThumbnailOnly = z;
        }

        /* JADX INFO: renamed from: getBitmapConfig$options_release, reason: from getter */
        public final android.graphics.Bitmap.Config getBitmapConfig() {
            return this.bitmapConfig;
        }

        public final void setBitmapConfig$options_release(android.graphics.Bitmap.Config config) {
            this.bitmapConfig = config;
        }

        /* JADX INFO: renamed from: getProgressiveDecodingEnabled$options_release, reason: from getter */
        public final java.lang.Boolean getProgressiveDecodingEnabled() {
            return this.progressiveDecodingEnabled;
        }

        public final void setProgressiveDecodingEnabled$options_release(java.lang.Boolean bool) {
            this.progressiveDecodingEnabled = bool;
        }

        public Builder() {
            com.facebook.drawee.drawable.ScalingUtils.ScaleType CENTER_CROP = com.facebook.drawee.drawable.ScalingUtils.ScaleType.CENTER_CROP;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(CENTER_CROP, "CENTER_CROP");
            this.actualImageScaleType = CENTER_CROP;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(com.facebook.fresco.vito.options.DecodedImageOptions decodedImageOptions) {
            super(decodedImageOptions);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(decodedImageOptions, "decodedImageOptions");
            com.facebook.drawee.drawable.ScalingUtils.ScaleType CENTER_CROP = com.facebook.drawee.drawable.ScalingUtils.ScaleType.CENTER_CROP;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(CENTER_CROP, "CENTER_CROP");
            this.actualImageScaleType = CENTER_CROP;
            this.resizeOptions = decodedImageOptions.getResizeOptions();
            this.downsampleOverride = decodedImageOptions.getDownsampleOverride();
            this.rotationOptions = decodedImageOptions.getRotationOptions();
            this.postprocessor = decodedImageOptions.getPostprocessor();
            this.imageDecodeOptions = decodedImageOptions.getImageDecodeOptions();
            this.roundingOptions = decodedImageOptions.getRoundingOptions();
            this.borderOptions = decodedImageOptions.getBorderOptions();
            this.actualImageScaleType = decodedImageOptions.getActualImageScaleType();
            this.actualFocusPoint = decodedImageOptions.getActualImageFocusPoint();
            this.localThumbnailPreviewsEnabled = decodedImageOptions.getMLocalThumbnailPreviewsEnabled();
            this.loadThumbnailOnly = decodedImageOptions.getLoadThumbnailOnly();
            this.bitmapConfig = decodedImageOptions.getBitmapConfig();
            this.progressiveDecodingEnabled = decodedImageOptions.getIsProgressiveDecodingEnabled();
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(com.facebook.fresco.vito.options.ImageOptions defaultOptions) {
            this((com.facebook.fresco.vito.options.DecodedImageOptions) defaultOptions);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(defaultOptions, "defaultOptions");
        }

        @Override // com.facebook.fresco.vito.options.EncodedImageOptions.Builder
        public com.facebook.fresco.vito.options.DecodedImageOptions build() {
            return new com.facebook.fresco.vito.options.DecodedImageOptions(this);
        }

        private final T modify(kotlin.jvm.functions.Function1<? super com.facebook.fresco.vito.options.DecodedImageOptions.Builder<T>, kotlin.Unit> block) {
            block.invoke2(this);
            return getThis();
        }

        public final T resize(com.facebook.imagepipeline.common.ResizeOptions resizeOptions) {
            this.resizeOptions = resizeOptions;
            return getThis();
        }

        public final T downsampleOverride(com.facebook.imagepipeline.core.DownsampleMode downsampleOverride) {
            this.downsampleOverride = downsampleOverride;
            return getThis();
        }

        public final T rotate(com.facebook.imagepipeline.common.RotationOptions rotationOptions) {
            this.rotationOptions = rotationOptions;
            return getThis();
        }

        public final T postprocess(com.facebook.imagepipeline.request.Postprocessor postprocessor) {
            this.postprocessor = postprocessor;
            return getThis();
        }

        public final T imageDecodeOptions(com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions) {
            this.imageDecodeOptions = imageDecodeOptions;
            return getThis();
        }

        public final T round(com.facebook.fresco.vito.options.RoundingOptions roundingOptions) {
            this.roundingOptions = roundingOptions;
            return getThis();
        }

        public final T borders(com.facebook.fresco.vito.options.BorderOptions borderOptions) {
            this.borderOptions = borderOptions;
            return getThis();
        }

        public final T scale(com.facebook.drawee.drawable.ScalingUtils.ScaleType actualImageScaleType) {
            if (actualImageScaleType == null) {
                actualImageScaleType = com.facebook.fresco.vito.options.ImageOptions.INSTANCE.defaults().getActualImageScaleType();
            }
            this.actualImageScaleType = actualImageScaleType;
            return getThis();
        }

        public final T focusPoint(android.graphics.PointF focusPoint) {
            this.actualFocusPoint = focusPoint;
            return getThis();
        }

        public final T localThumbnailPreviewsEnabled(boolean localThumbnailPreviewsEnabled) {
            this.localThumbnailPreviewsEnabled = localThumbnailPreviewsEnabled;
            return getThis();
        }

        public final T loadThumbnailOnly(boolean loadThumbnailOnly) {
            this.loadThumbnailOnly = loadThumbnailOnly;
            return getThis();
        }

        public final T bitmapConfig(android.graphics.Bitmap.Config bitmapConfig) {
            this.bitmapConfig = bitmapConfig;
            return getThis();
        }

        public final T progressiveRendering(java.lang.Boolean progressiveDecodingEnabled) {
            this.progressiveDecodingEnabled = progressiveDecodingEnabled;
            return getThis();
        }
    }
}
