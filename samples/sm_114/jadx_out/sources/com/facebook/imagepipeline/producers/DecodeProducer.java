package com.facebook.imagepipeline.producers;

/* JADX INFO: compiled from: DecodeProducer.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 =2\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0004:;<=Bw\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0001\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ$\u00104\u001a\u0002052\u0012\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002072\u0006\u00108\u001a\u000209H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010(R\u0019\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0001¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001a¢\u0006\b\n\u0000\u001a\u0004\b2\u00103¨\u0006>"}, d2 = {"Lcom/facebook/imagepipeline/producers/DecodeProducer;", "Lcom/facebook/imagepipeline/producers/Producer;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "byteArrayPool", "Lcom/facebook/common/memory/ByteArrayPool;", "executor", "Ljava/util/concurrent/Executor;", "imageDecoder", "Lcom/facebook/imagepipeline/decoder/ImageDecoder;", "progressiveJpegConfig", "Lcom/facebook/imagepipeline/decoder/ProgressiveJpegConfig;", "downsampleMode", "Lcom/facebook/imagepipeline/core/DownsampleMode;", "downsampleEnabledForNetwork", "", "decodeCancellationEnabled", "inputProducer", "Lcom/facebook/imagepipeline/image/EncodedImage;", "maxBitmapDimension", "", "closeableReferenceFactory", "Lcom/facebook/imagepipeline/core/CloseableReferenceFactory;", "reclaimMemoryRunnable", "Ljava/lang/Runnable;", "recoverFromDecoderOOM", "Lcom/facebook/common/internal/Supplier;", "<init>", "(Lcom/facebook/common/memory/ByteArrayPool;Ljava/util/concurrent/Executor;Lcom/facebook/imagepipeline/decoder/ImageDecoder;Lcom/facebook/imagepipeline/decoder/ProgressiveJpegConfig;Lcom/facebook/imagepipeline/core/DownsampleMode;ZZLcom/facebook/imagepipeline/producers/Producer;ILcom/facebook/imagepipeline/core/CloseableReferenceFactory;Ljava/lang/Runnable;Lcom/facebook/common/internal/Supplier;)V", "getByteArrayPool", "()Lcom/facebook/common/memory/ByteArrayPool;", "getExecutor", "()Ljava/util/concurrent/Executor;", "getImageDecoder", "()Lcom/facebook/imagepipeline/decoder/ImageDecoder;", "getProgressiveJpegConfig", "()Lcom/facebook/imagepipeline/decoder/ProgressiveJpegConfig;", "getDownsampleMode", "()Lcom/facebook/imagepipeline/core/DownsampleMode;", "getDownsampleEnabledForNetwork", "()Z", "getDecodeCancellationEnabled", "getInputProducer", "()Lcom/facebook/imagepipeline/producers/Producer;", "getMaxBitmapDimension", "()I", "getCloseableReferenceFactory", "()Lcom/facebook/imagepipeline/core/CloseableReferenceFactory;", "getReclaimMemoryRunnable", "()Ljava/lang/Runnable;", "getRecoverFromDecoderOOM", "()Lcom/facebook/common/internal/Supplier;", "produceResults", "", "consumer", "Lcom/facebook/imagepipeline/producers/Consumer;", "context", "Lcom/facebook/imagepipeline/producers/ProducerContext;", "ProgressiveDecoder", "LocalImagesProgressiveDecoder", "NetworkImagesProgressiveDecoder", "Companion", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DecodeProducer implements com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final com.facebook.imagepipeline.producers.DecodeProducer.Companion INSTANCE = new com.facebook.imagepipeline.producers.DecodeProducer.Companion(null);
    private static final int DECODE_EXCEPTION_MESSAGE_NUM_HEADER_BYTES = 10;
    public static final java.lang.String ENCODED_IMAGE_SIZE = "encodedImageSize";
    public static final java.lang.String EXTRA_BITMAP_BYTES = "byteCount";
    public static final java.lang.String EXTRA_BITMAP_SIZE = "bitmapSize";
    public static final java.lang.String EXTRA_HAS_GOOD_QUALITY = "hasGoodQuality";
    public static final java.lang.String EXTRA_IMAGE_FORMAT_NAME = "imageFormat";
    public static final java.lang.String EXTRA_IS_FINAL = "isFinal";
    private static final int MAX_BITMAP_SIZE = 104857600;
    public static final java.lang.String NON_FATAL_DECODE_ERROR = "non_fatal_decode_error";
    public static final java.lang.String PRODUCER_NAME = "DecodeProducer";
    public static final java.lang.String REQUESTED_IMAGE_SIZE = "requestedImageSize";
    public static final java.lang.String SAMPLE_SIZE = "sampleSize";
    private final com.facebook.common.memory.ByteArrayPool byteArrayPool;
    private final com.facebook.imagepipeline.core.CloseableReferenceFactory closeableReferenceFactory;
    private final boolean decodeCancellationEnabled;
    private final boolean downsampleEnabledForNetwork;
    private final com.facebook.imagepipeline.core.DownsampleMode downsampleMode;
    private final java.util.concurrent.Executor executor;
    private final com.facebook.imagepipeline.decoder.ImageDecoder imageDecoder;
    private final com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> inputProducer;
    private final int maxBitmapDimension;
    private final com.facebook.imagepipeline.decoder.ProgressiveJpegConfig progressiveJpegConfig;
    private final java.lang.Runnable reclaimMemoryRunnable;
    private final com.facebook.common.internal.Supplier<java.lang.Boolean> recoverFromDecoderOOM;

    public DecodeProducer(com.facebook.common.memory.ByteArrayPool byteArrayPool, java.util.concurrent.Executor executor, com.facebook.imagepipeline.decoder.ImageDecoder imageDecoder, com.facebook.imagepipeline.decoder.ProgressiveJpegConfig progressiveJpegConfig, com.facebook.imagepipeline.core.DownsampleMode downsampleMode, boolean z, boolean z2, com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> inputProducer, int i, com.facebook.imagepipeline.core.CloseableReferenceFactory closeableReferenceFactory, java.lang.Runnable runnable, com.facebook.common.internal.Supplier<java.lang.Boolean> recoverFromDecoderOOM) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(byteArrayPool, "byteArrayPool");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(executor, "executor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imageDecoder, "imageDecoder");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(progressiveJpegConfig, "progressiveJpegConfig");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(downsampleMode, "downsampleMode");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(inputProducer, "inputProducer");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(closeableReferenceFactory, "closeableReferenceFactory");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(recoverFromDecoderOOM, "recoverFromDecoderOOM");
        this.byteArrayPool = byteArrayPool;
        this.executor = executor;
        this.imageDecoder = imageDecoder;
        this.progressiveJpegConfig = progressiveJpegConfig;
        this.downsampleMode = downsampleMode;
        this.downsampleEnabledForNetwork = z;
        this.decodeCancellationEnabled = z2;
        this.inputProducer = inputProducer;
        this.maxBitmapDimension = i;
        this.closeableReferenceFactory = closeableReferenceFactory;
        this.reclaimMemoryRunnable = runnable;
        this.recoverFromDecoderOOM = recoverFromDecoderOOM;
    }

    public final com.facebook.common.memory.ByteArrayPool getByteArrayPool() {
        return this.byteArrayPool;
    }

    public final java.util.concurrent.Executor getExecutor() {
        return this.executor;
    }

    public final com.facebook.imagepipeline.decoder.ImageDecoder getImageDecoder() {
        return this.imageDecoder;
    }

    public final com.facebook.imagepipeline.decoder.ProgressiveJpegConfig getProgressiveJpegConfig() {
        return this.progressiveJpegConfig;
    }

    public final com.facebook.imagepipeline.core.DownsampleMode getDownsampleMode() {
        return this.downsampleMode;
    }

    public final boolean getDownsampleEnabledForNetwork() {
        return this.downsampleEnabledForNetwork;
    }

    public final boolean getDecodeCancellationEnabled() {
        return this.decodeCancellationEnabled;
    }

    public final com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> getInputProducer() {
        return this.inputProducer;
    }

    public final int getMaxBitmapDimension() {
        return this.maxBitmapDimension;
    }

    public final com.facebook.imagepipeline.core.CloseableReferenceFactory getCloseableReferenceFactory() {
        return this.closeableReferenceFactory;
    }

    public final java.lang.Runnable getReclaimMemoryRunnable() {
        return this.reclaimMemoryRunnable;
    }

    public final com.facebook.common.internal.Supplier<java.lang.Boolean> getRecoverFromDecoderOOM() {
        return this.recoverFromDecoderOOM;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(com.facebook.imagepipeline.producers.Consumer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> consumer, com.facebook.imagepipeline.producers.ProducerContext context) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(consumer, "consumer");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        com.facebook.imagepipeline.systrace.FrescoSystrace frescoSystrace = com.facebook.imagepipeline.systrace.FrescoSystrace.INSTANCE;
        if (!com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.request.ImageRequest imageRequest = context.getImageRequest();
            this.inputProducer.produceResults((com.facebook.common.util.UriUtil.isNetworkUri(imageRequest.getSourceUri()) || com.facebook.imagepipeline.request.ImageRequestBuilder.isCustomNetworkUri(imageRequest.getSourceUri())) ? new com.facebook.imagepipeline.producers.DecodeProducer.NetworkImagesProgressiveDecoder(this, consumer, context, new com.facebook.imagepipeline.decoder.ProgressiveJpegParser(this.byteArrayPool), this.progressiveJpegConfig, this.decodeCancellationEnabled, this.maxBitmapDimension) : new com.facebook.imagepipeline.producers.DecodeProducer.LocalImagesProgressiveDecoder(this, consumer, context, this.decodeCancellationEnabled, this.maxBitmapDimension), context);
            return;
        }
        com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("DecodeProducer#produceResults");
        try {
            com.facebook.imagepipeline.request.ImageRequest imageRequest2 = context.getImageRequest();
            this.inputProducer.produceResults((com.facebook.common.util.UriUtil.isNetworkUri(imageRequest2.getSourceUri()) || com.facebook.imagepipeline.request.ImageRequestBuilder.isCustomNetworkUri(imageRequest2.getSourceUri())) ? new com.facebook.imagepipeline.producers.DecodeProducer.NetworkImagesProgressiveDecoder(this, consumer, context, new com.facebook.imagepipeline.decoder.ProgressiveJpegParser(this.byteArrayPool), this.progressiveJpegConfig, this.decodeCancellationEnabled, this.maxBitmapDimension) : new com.facebook.imagepipeline.producers.DecodeProducer.LocalImagesProgressiveDecoder(this, consumer, context, this.decodeCancellationEnabled, this.maxBitmapDimension), context);
            kotlin.Unit unit = kotlin.Unit.INSTANCE;
        } finally {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: DecodeProducer.kt */
    @kotlin.Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\b¢\u0004\u0018\u00002\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B3\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0002H\u0002J\u001a\u0010 \u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010\u00022\u0006\u0010\"\u001a\u00020\fH\u0016J\u0010\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%H\u0014J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u001eH\u0016J\u001a\u0010*\u001a\u00020\n2\b\u0010+\u001a\u0004\u0018\u00010\u00022\u0006\u0010\"\u001a\u00020\fH\u0014J \u0010,\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0002J\"\u0010-\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\f2\u0006\u0010/\u001a\u000200H\u0002J\"\u00101\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00022\b\u00102\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0018\u001a\u00020\fH\u0002JX\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u0001042\b\u00102\u001a\u0004\u0018\u00010\u00042\u0006\u00105\u001a\u0002062\u0006\u0010/\u001a\u0002002\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\u00102\u0006\u00109\u001a\u00020\u00102\u0006\u0010:\u001a\u00020\u00102\u0006\u0010;\u001a\u00020\u0010H\u0002J\u0010\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020\nH\u0002J\u001a\u0010>\u001a\u00020\u001e2\b\u0010?\u001a\u0004\u0018\u00010\u00042\u0006\u0010\"\u001a\u00020\fH\u0002J\u0010\u0010@\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(H\u0002J\b\u0010A\u001a\u00020\u001eH\u0002J\u0010\u0010B\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u0002H$R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0012\u0010C\u001a\u000200X¤\u0004¢\u0006\u0006\u001a\u0004\bD\u0010E¨\u0006F"}, d2 = {"Lcom/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder;", "Lcom/facebook/imagepipeline/producers/DelegatingConsumer;", "Lcom/facebook/imagepipeline/image/EncodedImage;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "consumer", "Lcom/facebook/imagepipeline/producers/Consumer;", "producerContext", "Lcom/facebook/imagepipeline/producers/ProducerContext;", "decodeCancellationEnabled", "", "maxBitmapDimension", "", "<init>", "(Lcom/facebook/imagepipeline/producers/DecodeProducer;Lcom/facebook/imagepipeline/producers/Consumer;Lcom/facebook/imagepipeline/producers/ProducerContext;ZI)V", "TAG", "", "producerListener", "Lcom/facebook/imagepipeline/producers/ProducerListener2;", "imageDecodeOptions", "Lcom/facebook/imagepipeline/common/ImageDecodeOptions;", "isFinished", "jobScheduler", "Lcom/facebook/imagepipeline/producers/JobScheduler;", "lastScheduledScanNumber", "getLastScheduledScanNumber", "()I", "setLastScheduledScanNumber", "(I)V", "maybeIncreaseSampleSize", "", "encodedImage", "onNewResultImpl", "newResult", "status", "onProgressUpdateImpl", "progress", "", "onFailureImpl", "t", "", "onCancellationImpl", "updateDecodeJob", "ref", "doDecode", "internalDecode", "length", com.taobao.weex.common.Constants.Name.QUALITY, "Lcom/facebook/imagepipeline/image/QualityInfo;", "setImageExtras", "image", "getExtraMap", "", "queueTime", "", "isFinal", "imageFormatName", "encodedImageSize", "requestImageSize", "sampleSize", "maybeFinish", "shouldFinish", "handleResult", "decodedImage", "handleError", "handleCancellation", "getIntermediateImageEndOffset", "qualityInfo", "getQualityInfo", "()Lcom/facebook/imagepipeline/image/QualityInfo;", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    abstract class ProgressiveDecoder extends com.facebook.imagepipeline.producers.DelegatingConsumer<com.facebook.imagepipeline.image.EncodedImage, com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> {
        private final java.lang.String TAG;
        private final com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions;
        private boolean isFinished;
        private final com.facebook.imagepipeline.producers.JobScheduler jobScheduler;
        private int lastScheduledScanNumber;
        private final com.facebook.imagepipeline.producers.ProducerContext producerContext;
        private final com.facebook.imagepipeline.producers.ProducerListener2 producerListener;
        final /* synthetic */ com.facebook.imagepipeline.producers.DecodeProducer this$0;

        protected abstract int getIntermediateImageEndOffset(com.facebook.imagepipeline.image.EncodedImage encodedImage);

        protected abstract com.facebook.imagepipeline.image.QualityInfo getQualityInfo();

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ProgressiveDecoder(final com.facebook.imagepipeline.producers.DecodeProducer decodeProducer, com.facebook.imagepipeline.producers.Consumer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext, final boolean z, final int i) {
            super(consumer);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(consumer, "consumer");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerContext, "producerContext");
            this.this$0 = decodeProducer;
            this.producerContext = producerContext;
            this.TAG = "ProgressiveDecoder";
            this.producerListener = producerContext.getProducerListener();
            com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions = producerContext.getImageRequest().getImageDecodeOptions();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(imageDecodeOptions, "getImageDecodeOptions(...)");
            this.imageDecodeOptions = imageDecodeOptions;
            this.jobScheduler = new com.facebook.imagepipeline.producers.JobScheduler(decodeProducer.getExecutor(), new com.facebook.imagepipeline.producers.JobScheduler.JobRunnable() { // from class: com.facebook.imagepipeline.producers.DecodeProducer$ProgressiveDecoder$$ExternalSyntheticLambda0
                @Override // com.facebook.imagepipeline.producers.JobScheduler.JobRunnable
                public final void run(com.facebook.imagepipeline.image.EncodedImage encodedImage, int i2) throws java.lang.Throwable {
                    com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder._init_$lambda$2(this.f$0, decodeProducer, i, encodedImage, i2);
                }
            }, imageDecodeOptions.minDecodeIntervalMs);
            producerContext.addCallbacks(new com.facebook.imagepipeline.producers.BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder.1
                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onIsIntermediateResultExpectedChanged() {
                    if (com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder.this.producerContext.isIntermediateResultExpected()) {
                        com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder.this.jobScheduler.scheduleJob();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    if (z) {
                        com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder.this.handleCancellation();
                    }
                }
            });
        }

        protected final int getLastScheduledScanNumber() {
            return this.lastScheduledScanNumber;
        }

        protected final void setLastScheduledScanNumber(int i) {
            this.lastScheduledScanNumber = i;
        }

        private final void maybeIncreaseSampleSize(com.facebook.imagepipeline.image.EncodedImage encodedImage) {
            if (encodedImage.getImageFormat() != com.facebook.imageformat.DefaultImageFormats.JPEG) {
                return;
            }
            encodedImage.setSampleSize(com.facebook.imagepipeline.transcoder.DownsampleUtil.determineSampleSizeJPEG(encodedImage, com.facebook.imageutils.BitmapUtil.getPixelSizeForBitmapConfig(this.imageDecodeOptions.bitmapConfig), com.facebook.imagepipeline.producers.DecodeProducer.MAX_BITMAP_SIZE));
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(com.facebook.imagepipeline.image.EncodedImage newResult, int status) {
            com.facebook.imagepipeline.systrace.FrescoSystrace frescoSystrace = com.facebook.imagepipeline.systrace.FrescoSystrace.INSTANCE;
            if (!com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                boolean zIsLast = com.facebook.imagepipeline.producers.BaseConsumer.isLast(status);
                if (zIsLast) {
                    if (newResult == null) {
                        boolean zAreEqual = kotlin.jvm.internal.Intrinsics.areEqual(this.producerContext.getExtra("cached_value_found"), (java.lang.Object) true);
                        if (!this.producerContext.getImagePipelineConfig().getExperiments().getCancelDecodeOnCacheMiss() || this.producerContext.getLowestPermittedRequestLevel() == com.facebook.imagepipeline.request.ImageRequest.RequestLevel.FULL_FETCH || zAreEqual) {
                            handleError(new com.facebook.common.util.ExceptionWithNoStacktrace("Encoded image is null."));
                            return;
                        }
                    } else if (!newResult.isValid()) {
                        handleError(new com.facebook.common.util.ExceptionWithNoStacktrace("Encoded image is not valid."));
                        return;
                    }
                }
                if (updateDecodeJob(newResult, status)) {
                    boolean zStatusHasFlag = com.facebook.imagepipeline.producers.BaseConsumer.statusHasFlag(status, 4);
                    if (zIsLast || zStatusHasFlag || this.producerContext.isIntermediateResultExpected()) {
                        this.jobScheduler.scheduleJob();
                        return;
                    }
                    return;
                }
                return;
            }
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("DecodeProducer#onNewResultImpl");
            try {
                boolean zIsLast2 = com.facebook.imagepipeline.producers.BaseConsumer.isLast(status);
                if (zIsLast2) {
                    if (newResult == null) {
                        boolean zAreEqual2 = kotlin.jvm.internal.Intrinsics.areEqual(this.producerContext.getExtra("cached_value_found"), (java.lang.Object) true);
                        if (!this.producerContext.getImagePipelineConfig().getExperiments().getCancelDecodeOnCacheMiss() || this.producerContext.getLowestPermittedRequestLevel() == com.facebook.imagepipeline.request.ImageRequest.RequestLevel.FULL_FETCH || zAreEqual2) {
                            handleError(new com.facebook.common.util.ExceptionWithNoStacktrace("Encoded image is null."));
                            return;
                        }
                    } else if (!newResult.isValid()) {
                        handleError(new com.facebook.common.util.ExceptionWithNoStacktrace("Encoded image is not valid."));
                        return;
                    }
                }
                if (updateDecodeJob(newResult, status)) {
                    boolean zStatusHasFlag2 = com.facebook.imagepipeline.producers.BaseConsumer.statusHasFlag(status, 4);
                    if (zIsLast2 || zStatusHasFlag2 || this.producerContext.isIntermediateResultExpected()) {
                        this.jobScheduler.scheduleJob();
                    }
                    kotlin.Unit unit = kotlin.Unit.INSTANCE;
                }
            } finally {
                com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
            }
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        protected void onProgressUpdateImpl(float progress) {
            super.onProgressUpdateImpl(progress * 0.99f);
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onFailureImpl(java.lang.Throwable t) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(t, "t");
            handleError(t);
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onCancellationImpl() {
            handleCancellation();
        }

        protected boolean updateDecodeJob(com.facebook.imagepipeline.image.EncodedImage ref, int status) {
            return this.jobScheduler.updateJob(ref, status);
        }

        private final void doDecode(com.facebook.imagepipeline.image.EncodedImage encodedImage, int status, int lastScheduledScanNumber) throws java.lang.Throwable {
            char c;
            int size;
            com.facebook.imagepipeline.image.QualityInfo qualityInfo;
            com.facebook.imagepipeline.image.CloseableImage closeableImage;
            int i = status;
            if ((encodedImage.getImageFormat() != com.facebook.imageformat.DefaultImageFormats.JPEG && com.facebook.imagepipeline.producers.BaseConsumer.isNotLast(i)) || this.isFinished || !com.facebook.imagepipeline.image.EncodedImage.isValid(encodedImage)) {
                return;
            }
            if (kotlin.jvm.internal.Intrinsics.areEqual(encodedImage.getImageFormat(), com.facebook.imageformat.DefaultImageFormats.GIF) && com.facebook.imagepipeline.producers.DecodeProducer.INSTANCE.isTooBig(encodedImage, this.imageDecodeOptions)) {
                java.lang.IllegalStateException illegalStateException = new java.lang.IllegalStateException("Image is too big to attempt decoding: w = " + encodedImage.getWidth() + ", h = " + encodedImage.getHeight() + ", pixel config = " + this.imageDecodeOptions.bitmapConfig + ", max bitmap size = 104857600");
                this.producerListener.onProducerFinishWithFailure(this.producerContext, com.facebook.imagepipeline.producers.DecodeProducer.PRODUCER_NAME, illegalStateException, null);
                handleError(illegalStateException);
                return;
            }
            com.facebook.imageformat.ImageFormat imageFormat = encodedImage.getImageFormat();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(imageFormat, "getImageFormat(...)");
            java.lang.String name = imageFormat.getName();
            java.lang.String str = "unknown";
            java.lang.String str2 = name == null ? "unknown" : name;
            java.lang.String str3 = encodedImage.getWidth() + com.taobao.weex.common.Constants.Name.X + encodedImage.getHeight();
            java.lang.String strValueOf = java.lang.String.valueOf(encodedImage.getSampleSize());
            boolean zIsLast = com.facebook.imagepipeline.producers.BaseConsumer.isLast(i);
            boolean z = zIsLast && !com.facebook.imagepipeline.producers.BaseConsumer.statusHasFlag(i, 8);
            boolean zStatusHasFlag = com.facebook.imagepipeline.producers.BaseConsumer.statusHasFlag(i, 4);
            com.facebook.imagepipeline.common.ResizeOptions resizeOptions = this.producerContext.getImageRequest().getResizeOptions();
            if (resizeOptions != null) {
                c = 0;
                str = resizeOptions.width + com.taobao.weex.common.Constants.Name.X + resizeOptions.height;
            } else {
                c = 0;
            }
            try {
                long queuedTime = this.jobScheduler.getQueuedTime();
                java.lang.String string = this.producerContext.getImageRequest().getSourceUri().toString();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                if (z || zStatusHasFlag) {
                    size = encodedImage.getSize();
                } else {
                    size = getIntermediateImageEndOffset(encodedImage);
                }
                if (z || zStatusHasFlag) {
                    qualityInfo = com.facebook.imagepipeline.image.ImmutableQualityInfo.FULL_QUALITY;
                } else {
                    qualityInfo = getQualityInfo();
                }
                try {
                    this.producerListener.onProducerStart(this.producerContext, com.facebook.imagepipeline.producers.DecodeProducer.PRODUCER_NAME);
                    try {
                        kotlin.jvm.internal.Intrinsics.checkNotNull(qualityInfo);
                        com.facebook.imagepipeline.image.CloseableImage closeableImageInternalDecode = internalDecode(encodedImage, size, qualityInfo);
                        try {
                            if (encodedImage.getSampleSize() != 1) {
                                i |= 16;
                            }
                            this.producerListener.onProducerFinishWithSuccess(this.producerContext, com.facebook.imagepipeline.producers.DecodeProducer.PRODUCER_NAME, getExtraMap(closeableImageInternalDecode, queuedTime, qualityInfo, zIsLast, str2, str3, str, strValueOf));
                            setImageExtras(encodedImage, closeableImageInternalDecode, lastScheduledScanNumber);
                            handleResult(closeableImageInternalDecode, i);
                            com.facebook.imagepipeline.image.EncodedImage.closeSafely(encodedImage);
                        } catch (java.lang.Exception e) {
                            e = e;
                            str = str;
                            queuedTime = queuedTime;
                            closeableImage = closeableImageInternalDecode;
                            kotlin.jvm.internal.Intrinsics.checkNotNull(qualityInfo);
                            this.producerListener.onProducerFinishWithFailure(this.producerContext, com.facebook.imagepipeline.producers.DecodeProducer.PRODUCER_NAME, e, getExtraMap(closeableImage, queuedTime, qualityInfo, zIsLast, str2, str3, str, strValueOf));
                            handleError(e);
                            com.facebook.imagepipeline.image.EncodedImage.closeSafely(encodedImage);
                        }
                    } catch (com.facebook.imagepipeline.decoder.DecodeException e2) {
                        try {
                            com.facebook.imagepipeline.image.EncodedImage encodedImage2 = e2.getEncodedImage();
                            java.lang.String str4 = this.TAG;
                            java.lang.String message = e2.getMessage();
                            java.lang.String firstBytesAsHexString = encodedImage2.getFirstBytesAsHexString(10);
                            java.lang.Integer numValueOf = java.lang.Integer.valueOf(encodedImage2.getSize());
                            java.lang.Object[] objArr = new java.lang.Object[4];
                            objArr[c] = message;
                            objArr[1] = string;
                            objArr[2] = firstBytesAsHexString;
                            objArr[3] = numValueOf;
                            com.facebook.common.logging.FLog.w(str4, "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", objArr);
                            throw e2;
                        } catch (java.lang.Exception e3) {
                            e = e3;
                            closeableImage = null;
                            kotlin.jvm.internal.Intrinsics.checkNotNull(qualityInfo);
                            this.producerListener.onProducerFinishWithFailure(this.producerContext, com.facebook.imagepipeline.producers.DecodeProducer.PRODUCER_NAME, e, getExtraMap(closeableImage, queuedTime, qualityInfo, zIsLast, str2, str3, str, strValueOf));
                            handleError(e);
                            com.facebook.imagepipeline.image.EncodedImage.closeSafely(encodedImage);
                        }
                    } catch (java.lang.Exception e4) {
                        e = e4;
                        closeableImage = null;
                        kotlin.jvm.internal.Intrinsics.checkNotNull(qualityInfo);
                        this.producerListener.onProducerFinishWithFailure(this.producerContext, com.facebook.imagepipeline.producers.DecodeProducer.PRODUCER_NAME, e, getExtraMap(closeableImage, queuedTime, qualityInfo, zIsLast, str2, str3, str, strValueOf));
                        handleError(e);
                        com.facebook.imagepipeline.image.EncodedImage.closeSafely(encodedImage);
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    com.facebook.imagepipeline.image.EncodedImage.closeSafely(encodedImage);
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }

        private final com.facebook.imagepipeline.image.CloseableImage internalDecode(com.facebook.imagepipeline.image.EncodedImage encodedImage, int length, com.facebook.imagepipeline.image.QualityInfo quality) {
            boolean z = this.this$0.getReclaimMemoryRunnable() != null && this.this$0.getRecoverFromDecoderOOM().get().booleanValue();
            try {
                return this.this$0.getImageDecoder().decode(encodedImage, length, quality, this.imageDecodeOptions);
            } catch (java.lang.OutOfMemoryError e) {
                if (!z) {
                    throw e;
                }
                java.lang.Runnable reclaimMemoryRunnable = this.this$0.getReclaimMemoryRunnable();
                if (reclaimMemoryRunnable != null) {
                    reclaimMemoryRunnable.run();
                }
                java.lang.System.gc();
                return this.this$0.getImageDecoder().decode(encodedImage, length, quality, this.imageDecodeOptions);
            }
        }

        private final void setImageExtras(com.facebook.imagepipeline.image.EncodedImage encodedImage, com.facebook.imagepipeline.image.CloseableImage image, int lastScheduledScanNumber) {
            this.producerContext.putExtra("encoded_width", java.lang.Integer.valueOf(encodedImage.getWidth()));
            this.producerContext.putExtra("encoded_height", java.lang.Integer.valueOf(encodedImage.getHeight()));
            this.producerContext.putExtra("encoded_size", java.lang.Integer.valueOf(encodedImage.getSize()));
            this.producerContext.putExtra("image_color_space", encodedImage.getColorSpace());
            if (image instanceof com.facebook.imagepipeline.image.CloseableBitmap) {
                this.producerContext.putExtra("bitmap_config", java.lang.String.valueOf(((com.facebook.imagepipeline.image.CloseableBitmap) image).getUnderlyingBitmap().getConfig()));
            }
            if (image != null) {
                image.putExtras(this.producerContext.getExtras());
            }
            this.producerContext.putExtra("last_scan_num", java.lang.Integer.valueOf(lastScheduledScanNumber));
        }

        private final java.util.Map<java.lang.String, java.lang.String> getExtraMap(com.facebook.imagepipeline.image.CloseableImage image, long queueTime, com.facebook.imagepipeline.image.QualityInfo quality, boolean isFinal, java.lang.String imageFormatName, java.lang.String encodedImageSize, java.lang.String requestImageSize, java.lang.String sampleSize) {
            java.util.Map<java.lang.String, java.lang.Object> extras;
            java.lang.Object obj;
            java.lang.String string = null;
            if (!this.producerListener.requiresExtraMap(this.producerContext, com.facebook.imagepipeline.producers.DecodeProducer.PRODUCER_NAME)) {
                return null;
            }
            java.lang.String strValueOf = java.lang.String.valueOf(queueTime);
            java.lang.String strValueOf2 = java.lang.String.valueOf(quality.isOfGoodEnoughQuality());
            java.lang.String strValueOf3 = java.lang.String.valueOf(isFinal);
            if (image != null && (extras = image.getExtras()) != null && (obj = extras.get("non_fatal_decode_error")) != null) {
                string = obj.toString();
            }
            if (image instanceof com.facebook.imagepipeline.image.CloseableStaticBitmap) {
                java.lang.String str = string;
                android.graphics.Bitmap underlyingBitmap = ((com.facebook.imagepipeline.image.CloseableStaticBitmap) image).getUnderlyingBitmap();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(underlyingBitmap, "getUnderlyingBitmap(...)");
                java.lang.String str2 = underlyingBitmap.getWidth() + com.taobao.weex.common.Constants.Name.X + underlyingBitmap.getHeight();
                java.util.HashMap map = new java.util.HashMap(8);
                map.put("bitmapSize", str2);
                map.put("queueTime", strValueOf);
                map.put("hasGoodQuality", strValueOf2);
                map.put("isFinal", strValueOf3);
                map.put("encodedImageSize", encodedImageSize);
                map.put("imageFormat", imageFormatName);
                map.put("requestedImageSize", requestImageSize);
                map.put("sampleSize", sampleSize);
                int byteCount = underlyingBitmap.getByteCount();
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(byteCount);
                map.put("byteCount", sb.toString());
                if (str != null) {
                    map.put("non_fatal_decode_error", str);
                }
                return com.facebook.common.internal.ImmutableMap.copyOf((java.util.Map) map);
            }
            java.lang.String str3 = string;
            java.util.HashMap map2 = new java.util.HashMap(7);
            map2.put("queueTime", strValueOf);
            map2.put("hasGoodQuality", strValueOf2);
            map2.put("isFinal", strValueOf3);
            map2.put("encodedImageSize", encodedImageSize);
            map2.put("imageFormat", imageFormatName);
            map2.put("requestedImageSize", requestImageSize);
            map2.put("sampleSize", sampleSize);
            if (str3 != null) {
                map2.put("non_fatal_decode_error", str3);
            }
            return com.facebook.common.internal.ImmutableMap.copyOf((java.util.Map) map2);
        }

        private final void maybeFinish(boolean shouldFinish) {
            synchronized (this) {
                if (shouldFinish) {
                    if (!this.isFinished) {
                        getConsumer().onProgressUpdate(1.0f);
                        this.isFinished = true;
                        kotlin.Unit unit = kotlin.Unit.INSTANCE;
                        this.jobScheduler.clearJob();
                    }
                }
            }
        }

        private final void handleResult(com.facebook.imagepipeline.image.CloseableImage decodedImage, int status) {
            com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage> closeableReferenceCreate = this.this$0.getCloseableReferenceFactory().create(decodedImage);
            try {
                maybeFinish(com.facebook.imagepipeline.producers.BaseConsumer.isLast(status));
                getConsumer().onNewResult(closeableReferenceCreate, status);
            } finally {
                com.facebook.common.references.CloseableReference.closeSafely(closeableReferenceCreate);
            }
        }

        private final void handleError(java.lang.Throwable t) {
            maybeFinish(true);
            getConsumer().onFailure(t);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void handleCancellation() {
            maybeFinish(true);
            getConsumer().onCancellation();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void _init_$lambda$2(com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder this$0, com.facebook.imagepipeline.producers.DecodeProducer this$1, int i, com.facebook.imagepipeline.image.EncodedImage encodedImage, int i2) throws java.lang.Throwable {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (encodedImage != null) {
                com.facebook.imagepipeline.request.ImageRequest imageRequest = this$0.producerContext.getImageRequest();
                this$0.producerContext.putExtra("image_format", encodedImage.getImageFormat().getName());
                android.net.Uri sourceUri = imageRequest.getSourceUri();
                encodedImage.setSource(sourceUri != null ? sourceUri.toString() : null);
                com.facebook.imagepipeline.core.DownsampleMode downsampleOverride = imageRequest.getDownsampleOverride();
                if (downsampleOverride == null) {
                    downsampleOverride = this$1.getDownsampleMode();
                }
                boolean zStatusHasFlag = com.facebook.imagepipeline.producers.BaseConsumer.statusHasFlag(i2, 16);
                if ((downsampleOverride == com.facebook.imagepipeline.core.DownsampleMode.ALWAYS || (downsampleOverride == com.facebook.imagepipeline.core.DownsampleMode.AUTO && !zStatusHasFlag)) && (this$1.getDownsampleEnabledForNetwork() || !com.facebook.common.util.UriUtil.isNetworkUri(imageRequest.getSourceUri()))) {
                    com.facebook.imagepipeline.common.RotationOptions rotationOptions = imageRequest.getRotationOptions();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(rotationOptions, "getRotationOptions(...)");
                    encodedImage.setSampleSize(com.facebook.imagepipeline.transcoder.DownsampleUtil.determineSampleSize(rotationOptions, imageRequest.getResizeOptions(), encodedImage, i));
                }
                if (this$0.producerContext.getImagePipelineConfig().getExperiments().getDownsampleIfLargeBitmap()) {
                    this$0.maybeIncreaseSampleSize(encodedImage);
                }
                this$0.doDecode(encodedImage, i2, this$0.lastScheduledScanNumber);
            }
        }
    }

    /* JADX INFO: compiled from: DecodeProducer.kt */
    @kotlin.Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B3\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\fH\u0014J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014R\u0014\u0010\u0014\u001a\u00020\u00158TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/facebook/imagepipeline/producers/DecodeProducer$LocalImagesProgressiveDecoder;", "Lcom/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder;", "Lcom/facebook/imagepipeline/producers/DecodeProducer;", "consumer", "Lcom/facebook/imagepipeline/producers/Consumer;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "producerContext", "Lcom/facebook/imagepipeline/producers/ProducerContext;", "decodeCancellationEnabled", "", "maxBitmapDimension", "", "<init>", "(Lcom/facebook/imagepipeline/producers/DecodeProducer;Lcom/facebook/imagepipeline/producers/Consumer;Lcom/facebook/imagepipeline/producers/ProducerContext;ZI)V", "updateDecodeJob", "encodedImage", "Lcom/facebook/imagepipeline/image/EncodedImage;", "status", "getIntermediateImageEndOffset", "qualityInfo", "Lcom/facebook/imagepipeline/image/QualityInfo;", "getQualityInfo", "()Lcom/facebook/imagepipeline/image/QualityInfo;", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private final class LocalImagesProgressiveDecoder extends com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder {
        final /* synthetic */ com.facebook.imagepipeline.producers.DecodeProducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LocalImagesProgressiveDecoder(com.facebook.imagepipeline.producers.DecodeProducer decodeProducer, com.facebook.imagepipeline.producers.Consumer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext, boolean z, int i) {
            super(decodeProducer, consumer, producerContext, z, i);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(consumer, "consumer");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerContext, "producerContext");
            this.this$0 = decodeProducer;
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        protected synchronized boolean updateDecodeJob(com.facebook.imagepipeline.image.EncodedImage encodedImage, int status) {
            return com.facebook.imagepipeline.producers.BaseConsumer.isNotLast(status) ? false : super.updateDecodeJob(encodedImage, status);
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        protected int getIntermediateImageEndOffset(com.facebook.imagepipeline.image.EncodedImage encodedImage) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(encodedImage, "encodedImage");
            return encodedImage.getSize();
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        protected com.facebook.imagepipeline.image.QualityInfo getQualityInfo() {
            com.facebook.imagepipeline.image.QualityInfo qualityInfoOf = com.facebook.imagepipeline.image.ImmutableQualityInfo.of(0, false, false);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(qualityInfoOf, "of(...)");
            return qualityInfoOf;
        }
    }

    /* JADX INFO: compiled from: DecodeProducer.kt */
    @kotlin.Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002BC\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0010H\u0014J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001c\u001a\u00020\u001d8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/facebook/imagepipeline/producers/DecodeProducer$NetworkImagesProgressiveDecoder;", "Lcom/facebook/imagepipeline/producers/DecodeProducer$ProgressiveDecoder;", "Lcom/facebook/imagepipeline/producers/DecodeProducer;", "consumer", "Lcom/facebook/imagepipeline/producers/Consumer;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "producerContext", "Lcom/facebook/imagepipeline/producers/ProducerContext;", "progressiveJpegParser", "Lcom/facebook/imagepipeline/decoder/ProgressiveJpegParser;", "progressiveJpegConfig", "Lcom/facebook/imagepipeline/decoder/ProgressiveJpegConfig;", "decodeCancellationEnabled", "", "maxBitmapDimension", "", "<init>", "(Lcom/facebook/imagepipeline/producers/DecodeProducer;Lcom/facebook/imagepipeline/producers/Consumer;Lcom/facebook/imagepipeline/producers/ProducerContext;Lcom/facebook/imagepipeline/decoder/ProgressiveJpegParser;Lcom/facebook/imagepipeline/decoder/ProgressiveJpegConfig;ZI)V", "getProgressiveJpegParser", "()Lcom/facebook/imagepipeline/decoder/ProgressiveJpegParser;", "getProgressiveJpegConfig", "()Lcom/facebook/imagepipeline/decoder/ProgressiveJpegConfig;", "updateDecodeJob", "encodedImage", "Lcom/facebook/imagepipeline/image/EncodedImage;", "status", "getIntermediateImageEndOffset", "qualityInfo", "Lcom/facebook/imagepipeline/image/QualityInfo;", "getQualityInfo", "()Lcom/facebook/imagepipeline/image/QualityInfo;", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private final class NetworkImagesProgressiveDecoder extends com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder {
        private final com.facebook.imagepipeline.decoder.ProgressiveJpegConfig progressiveJpegConfig;
        private final com.facebook.imagepipeline.decoder.ProgressiveJpegParser progressiveJpegParser;
        final /* synthetic */ com.facebook.imagepipeline.producers.DecodeProducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NetworkImagesProgressiveDecoder(com.facebook.imagepipeline.producers.DecodeProducer decodeProducer, com.facebook.imagepipeline.producers.Consumer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext, com.facebook.imagepipeline.decoder.ProgressiveJpegParser progressiveJpegParser, com.facebook.imagepipeline.decoder.ProgressiveJpegConfig progressiveJpegConfig, boolean z, int i) {
            super(decodeProducer, consumer, producerContext, z, i);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(consumer, "consumer");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerContext, "producerContext");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(progressiveJpegParser, "progressiveJpegParser");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(progressiveJpegConfig, "progressiveJpegConfig");
            this.this$0 = decodeProducer;
            this.progressiveJpegParser = progressiveJpegParser;
            this.progressiveJpegConfig = progressiveJpegConfig;
            setLastScheduledScanNumber(0);
        }

        public final com.facebook.imagepipeline.decoder.ProgressiveJpegParser getProgressiveJpegParser() {
            return this.progressiveJpegParser;
        }

        public final com.facebook.imagepipeline.decoder.ProgressiveJpegConfig getProgressiveJpegConfig() {
            return this.progressiveJpegConfig;
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        protected synchronized boolean updateDecodeJob(com.facebook.imagepipeline.image.EncodedImage encodedImage, int status) {
            if (encodedImage == null) {
                return false;
            }
            boolean zUpdateDecodeJob = super.updateDecodeJob(encodedImage, status);
            if ((com.facebook.imagepipeline.producers.BaseConsumer.isNotLast(status) || com.facebook.imagepipeline.producers.BaseConsumer.statusHasFlag(status, 8)) && !com.facebook.imagepipeline.producers.BaseConsumer.statusHasFlag(status, 4) && com.facebook.imagepipeline.image.EncodedImage.isValid(encodedImage) && encodedImage.getImageFormat() == com.facebook.imageformat.DefaultImageFormats.JPEG) {
                if (!this.progressiveJpegParser.parseMoreData(encodedImage)) {
                    return false;
                }
                int bestScanNumber = this.progressiveJpegParser.getBestScanNumber();
                if (bestScanNumber <= getLastScheduledScanNumber()) {
                    return false;
                }
                if (bestScanNumber < this.progressiveJpegConfig.getNextScanNumberToDecode(getLastScheduledScanNumber()) && !this.progressiveJpegParser.isEndMarkerRead()) {
                    return false;
                }
                setLastScheduledScanNumber(bestScanNumber);
            }
            return zUpdateDecodeJob;
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        protected int getIntermediateImageEndOffset(com.facebook.imagepipeline.image.EncodedImage encodedImage) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(encodedImage, "encodedImage");
            return this.progressiveJpegParser.getBestScanEndOffset();
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        protected com.facebook.imagepipeline.image.QualityInfo getQualityInfo() {
            com.facebook.imagepipeline.image.QualityInfo qualityInfo = this.progressiveJpegConfig.getQualityInfo(this.progressiveJpegParser.getBestScanNumber());
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(qualityInfo, "getQualityInfo(...)");
            return qualityInfo;
        }
    }

    /* JADX INFO: compiled from: DecodeProducer.kt */
    @kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/facebook/imagepipeline/producers/DecodeProducer$Companion;", "", "<init>", "()V", "PRODUCER_NAME", "", "DECODE_EXCEPTION_MESSAGE_NUM_HEADER_BYTES", "", "MAX_BITMAP_SIZE", "EXTRA_BITMAP_SIZE", "EXTRA_HAS_GOOD_QUALITY", "EXTRA_IS_FINAL", "EXTRA_IMAGE_FORMAT_NAME", "EXTRA_BITMAP_BYTES", "ENCODED_IMAGE_SIZE", "REQUESTED_IMAGE_SIZE", "SAMPLE_SIZE", "NON_FATAL_DECODE_ERROR", "isTooBig", "", "encodedImage", "Lcom/facebook/imagepipeline/image/EncodedImage;", "imageDecodeOptions", "Lcom/facebook/imagepipeline/common/ImageDecodeOptions;", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isTooBig(com.facebook.imagepipeline.image.EncodedImage encodedImage, com.facebook.imagepipeline.common.ImageDecodeOptions imageDecodeOptions) {
            return (((long) encodedImage.getWidth()) * ((long) encodedImage.getHeight())) * ((long) com.facebook.imageutils.BitmapUtil.getPixelSizeForBitmapConfig(imageDecodeOptions.bitmapConfig)) > com.facebook.common.statfs.StatFsHelper.DEFAULT_DISK_RED_LEVEL_IN_BYTES;
        }
    }
}
