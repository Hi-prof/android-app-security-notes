package com.facebook.imagepipeline.core;

/* JADX INFO: compiled from: ProducerSequenceFactory.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u0084\u00012\u00020\u0001:\u0002\u0084\u0001B\u008b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\u001f0\u001e2\u0006\u00102\u001a\u000203J\u0016\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0\u001e2\u0006\u00102\u001a\u000203J\u001a\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001e2\u0006\u00102\u001a\u000203J\u0016\u0010B\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0\u001e2\u0006\u00102\u001a\u000203J\u001c\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001e2\u0006\u00102\u001a\u000203H\u0002J\u0018\u0010Q\u001a\b\u0012\u0004\u0012\u00020H0\u001e2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007J\"\u0010s\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001e2\f\u0010t\u001a\b\u0012\u0004\u0012\u00020H0\u001eH\u0002J;\u0010s\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001e2\f\u0010t\u001a\b\u0012\u0004\u0012\u00020H0\u001e2\u0012\u0010u\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020H0w0vH\u0002¢\u0006\u0002\u0010xJ \u0010y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001e2\f\u0010t\u001a\b\u0012\u0004\u0012\u00020H0\u001eJ\u001c\u0010z\u001a\b\u0012\u0004\u0012\u00020H0\u001e2\f\u0010t\u001a\b\u0012\u0004\u0012\u00020H0\u001eH\u0002J\u001c\u0010{\u001a\b\u0012\u0004\u0012\u00020H0\u001e2\f\u0010t\u001a\b\u0012\u0004\u0012\u00020H0\u001eH\u0002J(\u0010|\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001e2\u0012\u0010t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001eH\u0002J5\u0010}\u001a\b\u0012\u0004\u0012\u00020H0\u001e2\f\u0010t\u001a\b\u0012\u0004\u0012\u00020H0\u001e2\u0012\u0010u\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020H0w0vH\u0002¢\u0006\u0002\u0010xJ'\u0010~\u001a\b\u0012\u0004\u0012\u00020H0\u001e2\u0012\u0010u\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020H0w0vH\u0002¢\u0006\u0002\u0010\u007fJ)\u0010\u0080\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001e2\u0012\u0010t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001eH\u0002J%\u0010\u0081\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0\u001e2\u0012\u0010t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001eH\u0002J)\u0010\u0082\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001e2\u0012\u0010t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001eH\u0002J)\u0010\u0083\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001e2\u0012\u0010t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0082\u0004¢\u0006\u0002\n\u0000RH\u0010\u001c\u001a&\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001e\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001e0\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&RD\u0010'\u001a\"\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010(0\u001e0\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b)\u0010\"\u001a\u0004\b*\u0010$\"\u0004\b+\u0010&RH\u0010,\u001a&\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001e\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001e0\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b-\u0010\"\u001a\u0004\b.\u0010$\"\u0004\b/\u0010&R'\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\u001f0\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b5\u00106R-\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\u001f0\u001e8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b<\u00108\u0012\u0004\b:\u0010\"\u001a\u0004\b;\u00106R'\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\u001f0\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b?\u00108\u001a\u0004\b>\u00106R'\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bF\u00108\u001a\u0004\bE\u00106R#\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010H0\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bJ\u00108\u001a\u0004\bI\u00106R#\u0010K\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bM\u00108\u001a\u0004\bL\u00106R!\u0010N\u001a\b\u0012\u0004\u0012\u00020H0\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bP\u00108\u001a\u0004\bO\u00106R#\u0010R\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bT\u00108\u001a\u0004\bS\u00106R#\u0010U\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010H0\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bW\u00108\u001a\u0004\bV\u00106R#\u0010X\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010H0\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bZ\u00108\u001a\u0004\bY\u00106R'\u0010[\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b]\u00108\u001a\u0004\b\\\u00106R'\u0010^\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b`\u00108\u001a\u0004\b_\u00106R'\u0010a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bc\u00108\u001a\u0004\bb\u00106R'\u0010d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001e8GX\u0086\u0084\u0002¢\u0006\f\n\u0004\bf\u00108\u001a\u0004\be\u00106R'\u0010g\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bi\u00108\u001a\u0004\bh\u00106R'\u0010j\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bl\u00108\u001a\u0004\bk\u00106R'\u0010m\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bo\u00108\u001a\u0004\bn\u00106R'\u0010p\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\br\u00108\u001a\u0004\bq\u00106¨\u0006\u0085\u0001"}, d2 = {"Lcom/facebook/imagepipeline/core/ProducerSequenceFactory;", "", "contentResolver", "Landroid/content/ContentResolver;", "producerFactory", "Lcom/facebook/imagepipeline/core/ProducerFactory;", "networkFetcher", "Lcom/facebook/imagepipeline/producers/NetworkFetcher;", "resizeAndRotateEnabledForNetwork", "", "webpSupportEnabled", "threadHandoffProducerQueue", "Lcom/facebook/imagepipeline/producers/ThreadHandoffProducerQueue;", "downsampleMode", "Lcom/facebook/imagepipeline/core/DownsampleMode;", "useBitmapPrepareToDraw", "partialImageCachingEnabled", "diskCacheEnabled", "imageTranscoderFactory", "Lcom/facebook/imagepipeline/transcoder/ImageTranscoderFactory;", "isEncodedMemoryCacheProbingEnabled", "isDiskCacheProbingEnabled", "allowDelay", "customProducerSequenceFactories", "", "Lcom/facebook/imagepipeline/producers/CustomProducerSequenceFactory;", "<init>", "(Landroid/content/ContentResolver;Lcom/facebook/imagepipeline/core/ProducerFactory;Lcom/facebook/imagepipeline/producers/NetworkFetcher;ZZLcom/facebook/imagepipeline/producers/ThreadHandoffProducerQueue;Lcom/facebook/imagepipeline/core/DownsampleMode;ZZZLcom/facebook/imagepipeline/transcoder/ImageTranscoderFactory;ZZZLjava/util/Set;)V", "postprocessorSequences", "", "Lcom/facebook/imagepipeline/producers/Producer;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "getPostprocessorSequences$annotations", "()V", "getPostprocessorSequences", "()Ljava/util/Map;", "setPostprocessorSequences", "(Ljava/util/Map;)V", "closeableImagePrefetchSequences", "Ljava/lang/Void;", "getCloseableImagePrefetchSequences$annotations", "getCloseableImagePrefetchSequences", "setCloseableImagePrefetchSequences", "bitmapPrepareSequences", "getBitmapPrepareSequences$annotations", "getBitmapPrepareSequences", "setBitmapPrepareSequences", "getEncodedImageProducerSequence", "Lcom/facebook/common/memory/PooledByteBuffer;", "imageRequest", "Lcom/facebook/imagepipeline/request/ImageRequest;", "networkFetchEncodedImageProducerSequence", "getNetworkFetchEncodedImageProducerSequence", "()Lcom/facebook/imagepipeline/producers/Producer;", "networkFetchEncodedImageProducerSequence$delegate", "Lkotlin/Lazy;", "localFileFetchEncodedImageProducerSequence", "getLocalFileFetchEncodedImageProducerSequence$annotations", "getLocalFileFetchEncodedImageProducerSequence", "localFileFetchEncodedImageProducerSequence$delegate", "localContentUriFetchEncodedImageProducerSequence", "getLocalContentUriFetchEncodedImageProducerSequence", "localContentUriFetchEncodedImageProducerSequence$delegate", "getEncodedImagePrefetchProducerSequence", "getDecodedImageProducerSequence", "getDecodedImagePrefetchProducerSequence", "getBasicDecodedImageSequence", "networkFetchSequence", "getNetworkFetchSequence", "networkFetchSequence$delegate", "backgroundNetworkFetchToEncodedMemorySequence", "Lcom/facebook/imagepipeline/image/EncodedImage;", "getBackgroundNetworkFetchToEncodedMemorySequence", "backgroundNetworkFetchToEncodedMemorySequence$delegate", "networkFetchToEncodedMemoryPrefetchSequence", "getNetworkFetchToEncodedMemoryPrefetchSequence", "networkFetchToEncodedMemoryPrefetchSequence$delegate", "commonNetworkFetchToEncodedMemorySequence", "getCommonNetworkFetchToEncodedMemorySequence", "commonNetworkFetchToEncodedMemorySequence$delegate", "newCommonNetworkFetchToEncodedMemorySequence", "localFileFetchToEncodedMemoryPrefetchSequence", "getLocalFileFetchToEncodedMemoryPrefetchSequence", "localFileFetchToEncodedMemoryPrefetchSequence$delegate", "backgroundLocalFileFetchToEncodeMemorySequence", "getBackgroundLocalFileFetchToEncodeMemorySequence", "backgroundLocalFileFetchToEncodeMemorySequence$delegate", "backgroundLocalContentUriFetchToEncodeMemorySequence", "getBackgroundLocalContentUriFetchToEncodeMemorySequence", "backgroundLocalContentUriFetchToEncodeMemorySequence$delegate", "localImageFileFetchSequence", "getLocalImageFileFetchSequence", "localImageFileFetchSequence$delegate", "localVideoFileFetchSequence", "getLocalVideoFileFetchSequence", "localVideoFileFetchSequence$delegate", "localContentUriFetchSequence", "getLocalContentUriFetchSequence", "localContentUriFetchSequence$delegate", "localThumbnailBitmapSdk29FetchSequence", "getLocalThumbnailBitmapSdk29FetchSequence", "localThumbnailBitmapSdk29FetchSequence$delegate", "qualifiedResourceFetchSequence", "getQualifiedResourceFetchSequence", "qualifiedResourceFetchSequence$delegate", "localResourceFetchSequence", "getLocalResourceFetchSequence", "localResourceFetchSequence$delegate", "localAssetFetchSequence", "getLocalAssetFetchSequence", "localAssetFetchSequence$delegate", "dataFetchSequence", "getDataFetchSequence", "dataFetchSequence$delegate", "newBitmapCacheGetToLocalTransformSequence", "inputProducer", "thumbnailProducers", "", "Lcom/facebook/imagepipeline/producers/ThumbnailProducer;", "(Lcom/facebook/imagepipeline/producers/Producer;[Lcom/facebook/imagepipeline/producers/ThumbnailProducer;)Lcom/facebook/imagepipeline/producers/Producer;", "newBitmapCacheGetToDecodeSequence", "newEncodedCacheMultiplexToTranscodeSequence", "newDiskCacheSequence", "newBitmapCacheGetToBitmapCacheSequence", "newLocalTransformationsSequence", "newLocalThumbnailProducer", "([Lcom/facebook/imagepipeline/producers/ThumbnailProducer;)Lcom/facebook/imagepipeline/producers/Producer;", "getPostprocessorSequence", "getDecodedImagePrefetchSequence", "getBitmapPrepareSequence", "getDelaySequence", "Companion", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProducerSequenceFactory {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final com.facebook.imagepipeline.core.ProducerSequenceFactory.Companion INSTANCE = new com.facebook.imagepipeline.core.ProducerSequenceFactory.Companion(null);
    private final boolean allowDelay;

    /* JADX INFO: renamed from: backgroundLocalContentUriFetchToEncodeMemorySequence$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy backgroundLocalContentUriFetchToEncodeMemorySequence;

    /* JADX INFO: renamed from: backgroundLocalFileFetchToEncodeMemorySequence$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy backgroundLocalFileFetchToEncodeMemorySequence;

    /* JADX INFO: renamed from: backgroundNetworkFetchToEncodedMemorySequence$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy backgroundNetworkFetchToEncodedMemorySequence;
    private java.util.Map<com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>, com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>> bitmapPrepareSequences;
    private java.util.Map<com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>, com.facebook.imagepipeline.producers.Producer<java.lang.Void>> closeableImagePrefetchSequences;

    /* JADX INFO: renamed from: commonNetworkFetchToEncodedMemorySequence$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy commonNetworkFetchToEncodedMemorySequence;
    private final android.content.ContentResolver contentResolver;
    private final java.util.Set<com.facebook.imagepipeline.producers.CustomProducerSequenceFactory> customProducerSequenceFactories;

    /* JADX INFO: renamed from: dataFetchSequence$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy dataFetchSequence;
    private final boolean diskCacheEnabled;
    private final com.facebook.imagepipeline.core.DownsampleMode downsampleMode;
    private final com.facebook.imagepipeline.transcoder.ImageTranscoderFactory imageTranscoderFactory;
    private final boolean isDiskCacheProbingEnabled;
    private final boolean isEncodedMemoryCacheProbingEnabled;

    /* JADX INFO: renamed from: localAssetFetchSequence$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy localAssetFetchSequence;

    /* JADX INFO: renamed from: localContentUriFetchEncodedImageProducerSequence$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy localContentUriFetchEncodedImageProducerSequence;

    /* JADX INFO: renamed from: localContentUriFetchSequence$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy localContentUriFetchSequence;

    /* JADX INFO: renamed from: localFileFetchEncodedImageProducerSequence$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy localFileFetchEncodedImageProducerSequence;

    /* JADX INFO: renamed from: localFileFetchToEncodedMemoryPrefetchSequence$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy localFileFetchToEncodedMemoryPrefetchSequence;

    /* JADX INFO: renamed from: localImageFileFetchSequence$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy localImageFileFetchSequence;

    /* JADX INFO: renamed from: localResourceFetchSequence$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy localResourceFetchSequence;

    /* JADX INFO: renamed from: localThumbnailBitmapSdk29FetchSequence$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy localThumbnailBitmapSdk29FetchSequence;

    /* JADX INFO: renamed from: localVideoFileFetchSequence$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy localVideoFileFetchSequence;

    /* JADX INFO: renamed from: networkFetchEncodedImageProducerSequence$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy networkFetchEncodedImageProducerSequence;

    /* JADX INFO: renamed from: networkFetchSequence$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy networkFetchSequence;

    /* JADX INFO: renamed from: networkFetchToEncodedMemoryPrefetchSequence$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy networkFetchToEncodedMemoryPrefetchSequence;
    private final com.facebook.imagepipeline.producers.NetworkFetcher<?> networkFetcher;
    private final boolean partialImageCachingEnabled;
    private java.util.Map<com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>, com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>> postprocessorSequences;
    private final com.facebook.imagepipeline.core.ProducerFactory producerFactory;

    /* JADX INFO: renamed from: qualifiedResourceFetchSequence$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy qualifiedResourceFetchSequence;
    private final boolean resizeAndRotateEnabledForNetwork;
    private final com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue threadHandoffProducerQueue;
    private final boolean useBitmapPrepareToDraw;
    private final boolean webpSupportEnabled;

    public static /* synthetic */ void getBitmapPrepareSequences$annotations() {
    }

    public static /* synthetic */ void getCloseableImagePrefetchSequences$annotations() {
    }

    public static /* synthetic */ void getLocalFileFetchEncodedImageProducerSequence$annotations() {
    }

    public static /* synthetic */ void getPostprocessorSequences$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProducerSequenceFactory(android.content.ContentResolver contentResolver, com.facebook.imagepipeline.core.ProducerFactory producerFactory, com.facebook.imagepipeline.producers.NetworkFetcher<?> networkFetcher, boolean z, boolean z2, com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue threadHandoffProducerQueue, com.facebook.imagepipeline.core.DownsampleMode downsampleMode, boolean z3, boolean z4, boolean z5, com.facebook.imagepipeline.transcoder.ImageTranscoderFactory imageTranscoderFactory, boolean z6, boolean z7, boolean z8, java.util.Set<? extends com.facebook.imagepipeline.producers.CustomProducerSequenceFactory> set) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerFactory, "producerFactory");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(networkFetcher, "networkFetcher");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(threadHandoffProducerQueue, "threadHandoffProducerQueue");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(downsampleMode, "downsampleMode");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imageTranscoderFactory, "imageTranscoderFactory");
        this.contentResolver = contentResolver;
        this.producerFactory = producerFactory;
        this.networkFetcher = networkFetcher;
        this.resizeAndRotateEnabledForNetwork = z;
        this.webpSupportEnabled = z2;
        this.threadHandoffProducerQueue = threadHandoffProducerQueue;
        this.downsampleMode = downsampleMode;
        this.useBitmapPrepareToDraw = z3;
        this.partialImageCachingEnabled = z4;
        this.diskCacheEnabled = z5;
        this.imageTranscoderFactory = imageTranscoderFactory;
        this.isEncodedMemoryCacheProbingEnabled = z6;
        this.isDiskCacheProbingEnabled = z7;
        this.allowDelay = z8;
        this.customProducerSequenceFactories = set;
        this.postprocessorSequences = new java.util.LinkedHashMap();
        this.closeableImagePrefetchSequences = new java.util.LinkedHashMap();
        this.bitmapPrepareSequences = new java.util.LinkedHashMap();
        this.networkFetchEncodedImageProducerSequence = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return com.facebook.imagepipeline.core.ProducerSequenceFactory.networkFetchEncodedImageProducerSequence_delegate$lambda$2(this.f$0);
            }
        });
        this.localFileFetchEncodedImageProducerSequence = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return com.facebook.imagepipeline.core.ProducerSequenceFactory.localFileFetchEncodedImageProducerSequence_delegate$lambda$4(this.f$0);
            }
        });
        this.localContentUriFetchEncodedImageProducerSequence = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return com.facebook.imagepipeline.core.ProducerSequenceFactory.localContentUriFetchEncodedImageProducerSequence_delegate$lambda$6(this.f$0);
            }
        });
        this.networkFetchSequence = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return com.facebook.imagepipeline.core.ProducerSequenceFactory.networkFetchSequence_delegate$lambda$11(this.f$0);
            }
        });
        this.backgroundNetworkFetchToEncodedMemorySequence = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return com.facebook.imagepipeline.core.ProducerSequenceFactory.backgroundNetworkFetchToEncodedMemorySequence_delegate$lambda$13(this.f$0);
            }
        });
        this.networkFetchToEncodedMemoryPrefetchSequence = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return com.facebook.imagepipeline.core.ProducerSequenceFactory.networkFetchToEncodedMemoryPrefetchSequence_delegate$lambda$15(this.f$0);
            }
        });
        this.commonNetworkFetchToEncodedMemorySequence = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return com.facebook.imagepipeline.core.ProducerSequenceFactory.commonNetworkFetchToEncodedMemorySequence_delegate$lambda$17(this.f$0);
            }
        });
        this.localFileFetchToEncodedMemoryPrefetchSequence = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return com.facebook.imagepipeline.core.ProducerSequenceFactory.localFileFetchToEncodedMemoryPrefetchSequence_delegate$lambda$20(this.f$0);
            }
        });
        this.backgroundLocalFileFetchToEncodeMemorySequence = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return com.facebook.imagepipeline.core.ProducerSequenceFactory.backgroundLocalFileFetchToEncodeMemorySequence_delegate$lambda$22(this.f$0);
            }
        });
        this.backgroundLocalContentUriFetchToEncodeMemorySequence = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return com.facebook.imagepipeline.core.ProducerSequenceFactory.backgroundLocalContentUriFetchToEncodeMemorySequence_delegate$lambda$24(this.f$0);
            }
        });
        this.localImageFileFetchSequence = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return com.facebook.imagepipeline.core.ProducerSequenceFactory.localImageFileFetchSequence_delegate$lambda$25(this.f$0);
            }
        });
        this.localVideoFileFetchSequence = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return com.facebook.imagepipeline.core.ProducerSequenceFactory.localVideoFileFetchSequence_delegate$lambda$26(this.f$0);
            }
        });
        this.localContentUriFetchSequence = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return com.facebook.imagepipeline.core.ProducerSequenceFactory.localContentUriFetchSequence_delegate$lambda$27(this.f$0);
            }
        });
        this.localThumbnailBitmapSdk29FetchSequence = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return com.facebook.imagepipeline.core.ProducerSequenceFactory.localThumbnailBitmapSdk29FetchSequence_delegate$lambda$28(this.f$0);
            }
        });
        this.qualifiedResourceFetchSequence = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return com.facebook.imagepipeline.core.ProducerSequenceFactory.qualifiedResourceFetchSequence_delegate$lambda$29(this.f$0);
            }
        });
        this.localResourceFetchSequence = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return com.facebook.imagepipeline.core.ProducerSequenceFactory.localResourceFetchSequence_delegate$lambda$30(this.f$0);
            }
        });
        this.localAssetFetchSequence = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return com.facebook.imagepipeline.core.ProducerSequenceFactory.localAssetFetchSequence_delegate$lambda$31(this.f$0);
            }
        });
        this.dataFetchSequence = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0() { // from class: com.facebook.imagepipeline.core.ProducerSequenceFactory$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return com.facebook.imagepipeline.core.ProducerSequenceFactory.dataFetchSequence_delegate$lambda$32(this.f$0);
            }
        });
    }

    public final java.util.Map<com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>, com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>> getPostprocessorSequences() {
        return this.postprocessorSequences;
    }

    public final void setPostprocessorSequences(java.util.Map<com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>, com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>> map) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.postprocessorSequences = map;
    }

    public final java.util.Map<com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>, com.facebook.imagepipeline.producers.Producer<java.lang.Void>> getCloseableImagePrefetchSequences() {
        return this.closeableImagePrefetchSequences;
    }

    public final void setCloseableImagePrefetchSequences(java.util.Map<com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>, com.facebook.imagepipeline.producers.Producer<java.lang.Void>> map) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.closeableImagePrefetchSequences = map;
    }

    public final java.util.Map<com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>, com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>> getBitmapPrepareSequences() {
        return this.bitmapPrepareSequences;
    }

    public final void setBitmapPrepareSequences(java.util.Map<com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>, com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>>> map) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.bitmapPrepareSequences = map;
    }

    public final com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer>> getEncodedImageProducerSequence(com.facebook.imagepipeline.request.ImageRequest imageRequest) {
        com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer>> networkFetchEncodedImageProducerSequence;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        com.facebook.imagepipeline.systrace.FrescoSystrace frescoSystrace = com.facebook.imagepipeline.systrace.FrescoSystrace.INSTANCE;
        if (!com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            INSTANCE.validateEncodedImageRequest(imageRequest);
            android.net.Uri sourceUri = imageRequest.getSourceUri();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sourceUri, "getSourceUri(...)");
            int sourceUriType = imageRequest.getSourceUriType();
            if (sourceUriType == 0) {
                return getNetworkFetchEncodedImageProducerSequence();
            }
            if (sourceUriType == 2 || sourceUriType == 3) {
                return getLocalFileFetchEncodedImageProducerSequence();
            }
            if (sourceUriType == 4) {
                return getLocalContentUriFetchEncodedImageProducerSequence();
            }
            java.util.Set<com.facebook.imagepipeline.producers.CustomProducerSequenceFactory> set = this.customProducerSequenceFactories;
            if (set != null) {
                java.util.Iterator<com.facebook.imagepipeline.producers.CustomProducerSequenceFactory> it = set.iterator();
                while (it.hasNext()) {
                    com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer>> customEncodedImageSequence = it.next().getCustomEncodedImageSequence(imageRequest, this, this.producerFactory, this.threadHandoffProducerQueue);
                    if (customEncodedImageSequence != null) {
                        return customEncodedImageSequence;
                    }
                }
            }
            throw new java.lang.IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + INSTANCE.getShortenedUriString(sourceUri));
        }
        com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("ProducerSequenceFactory#getEncodedImageProducerSequence");
        try {
            INSTANCE.validateEncodedImageRequest(imageRequest);
            android.net.Uri sourceUri2 = imageRequest.getSourceUri();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sourceUri2, "getSourceUri(...)");
            int sourceUriType2 = imageRequest.getSourceUriType();
            if (sourceUriType2 == 0) {
                networkFetchEncodedImageProducerSequence = getNetworkFetchEncodedImageProducerSequence();
            } else if (sourceUriType2 == 2 || sourceUriType2 == 3) {
                networkFetchEncodedImageProducerSequence = getLocalFileFetchEncodedImageProducerSequence();
            } else {
                if (sourceUriType2 != 4) {
                    java.util.Set<com.facebook.imagepipeline.producers.CustomProducerSequenceFactory> set2 = this.customProducerSequenceFactories;
                    if (set2 != null) {
                        java.util.Iterator<com.facebook.imagepipeline.producers.CustomProducerSequenceFactory> it2 = set2.iterator();
                        while (it2.hasNext()) {
                            com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer>> customEncodedImageSequence2 = it2.next().getCustomEncodedImageSequence(imageRequest, this, this.producerFactory, this.threadHandoffProducerQueue);
                            if (customEncodedImageSequence2 != null) {
                                com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                                return customEncodedImageSequence2;
                            }
                        }
                    }
                    throw new java.lang.IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + INSTANCE.getShortenedUriString(sourceUri2));
                }
                networkFetchEncodedImageProducerSequence = getLocalContentUriFetchEncodedImageProducerSequence();
            }
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
            return networkFetchEncodedImageProducerSequence;
        } catch (java.lang.Throwable th) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
            throw th;
        }
    }

    public final com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer>> getNetworkFetchEncodedImageProducerSequence() {
        return (com.facebook.imagepipeline.producers.Producer) this.networkFetchEncodedImageProducerSequence.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.facebook.imagepipeline.producers.RemoveImageTransformMetaDataProducer networkFetchEncodedImageProducerSequence_delegate$lambda$2(com.facebook.imagepipeline.core.ProducerSequenceFactory this$0) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.facebook.imagepipeline.systrace.FrescoSystrace frescoSystrace = com.facebook.imagepipeline.systrace.FrescoSystrace.INSTANCE;
        if (!com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            return new com.facebook.imagepipeline.producers.RemoveImageTransformMetaDataProducer(this$0.getBackgroundNetworkFetchToEncodedMemorySequence());
        }
        com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchEncodedImageProducerSequence:init");
        try {
            return new com.facebook.imagepipeline.producers.RemoveImageTransformMetaDataProducer(this$0.getBackgroundNetworkFetchToEncodedMemorySequence());
        } finally {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
    }

    public final com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer>> getLocalFileFetchEncodedImageProducerSequence() {
        return (com.facebook.imagepipeline.producers.Producer) this.localFileFetchEncodedImageProducerSequence.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.facebook.imagepipeline.producers.RemoveImageTransformMetaDataProducer localFileFetchEncodedImageProducerSequence_delegate$lambda$4(com.facebook.imagepipeline.core.ProducerSequenceFactory this$0) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.facebook.imagepipeline.systrace.FrescoSystrace frescoSystrace = com.facebook.imagepipeline.systrace.FrescoSystrace.INSTANCE;
        if (!com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            return new com.facebook.imagepipeline.producers.RemoveImageTransformMetaDataProducer(this$0.getBackgroundLocalFileFetchToEncodeMemorySequence());
        }
        com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalFileFetchEncodedImageProducerSequence:init");
        try {
            return new com.facebook.imagepipeline.producers.RemoveImageTransformMetaDataProducer(this$0.getBackgroundLocalFileFetchToEncodeMemorySequence());
        } finally {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
    }

    public final com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer>> getLocalContentUriFetchEncodedImageProducerSequence() {
        return (com.facebook.imagepipeline.producers.Producer) this.localContentUriFetchEncodedImageProducerSequence.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.facebook.imagepipeline.producers.RemoveImageTransformMetaDataProducer localContentUriFetchEncodedImageProducerSequence_delegate$lambda$6(com.facebook.imagepipeline.core.ProducerSequenceFactory this$0) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.facebook.imagepipeline.systrace.FrescoSystrace frescoSystrace = com.facebook.imagepipeline.systrace.FrescoSystrace.INSTANCE;
        if (!com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            return new com.facebook.imagepipeline.producers.RemoveImageTransformMetaDataProducer(this$0.getBackgroundLocalContentUriFetchToEncodeMemorySequence());
        }
        com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalContentUriFetchEncodedImageProducerSequence:init");
        try {
            return new com.facebook.imagepipeline.producers.RemoveImageTransformMetaDataProducer(this$0.getBackgroundLocalContentUriFetchToEncodeMemorySequence());
        } finally {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
    }

    public final com.facebook.imagepipeline.producers.Producer<java.lang.Void> getEncodedImagePrefetchProducerSequence(com.facebook.imagepipeline.request.ImageRequest imageRequest) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        com.facebook.imagepipeline.core.ProducerSequenceFactory.Companion companion = INSTANCE;
        companion.validateEncodedImageRequest(imageRequest);
        int sourceUriType = imageRequest.getSourceUriType();
        if (sourceUriType == 0) {
            return getNetworkFetchToEncodedMemoryPrefetchSequence();
        }
        if (sourceUriType == 2 || sourceUriType == 3) {
            return getLocalFileFetchToEncodedMemoryPrefetchSequence();
        }
        android.net.Uri sourceUri = imageRequest.getSourceUri();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sourceUri, "getSourceUri(...)");
        throw new java.lang.IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + companion.getShortenedUriString(sourceUri));
    }

    public final com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> getDecodedImageProducerSequence(com.facebook.imagepipeline.request.ImageRequest imageRequest) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        com.facebook.imagepipeline.systrace.FrescoSystrace frescoSystrace = com.facebook.imagepipeline.systrace.FrescoSystrace.INSTANCE;
        if (!com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> basicDecodedImageSequence = getBasicDecodedImageSequence(imageRequest);
            if (imageRequest.getPostprocessor() != null) {
                basicDecodedImageSequence = getPostprocessorSequence(basicDecodedImageSequence);
            }
            if (this.useBitmapPrepareToDraw) {
                basicDecodedImageSequence = getBitmapPrepareSequence(basicDecodedImageSequence);
            }
            return (!this.allowDelay || imageRequest.getDelayMs() <= 0) ? basicDecodedImageSequence : getDelaySequence(basicDecodedImageSequence);
        }
        com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("ProducerSequenceFactory#getDecodedImageProducerSequence");
        try {
            com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> basicDecodedImageSequence2 = getBasicDecodedImageSequence(imageRequest);
            if (imageRequest.getPostprocessor() != null) {
                basicDecodedImageSequence2 = getPostprocessorSequence(basicDecodedImageSequence2);
            }
            if (this.useBitmapPrepareToDraw) {
                basicDecodedImageSequence2 = getBitmapPrepareSequence(basicDecodedImageSequence2);
            }
            if (this.allowDelay && imageRequest.getDelayMs() > 0) {
                basicDecodedImageSequence2 = getDelaySequence(basicDecodedImageSequence2);
            }
            return basicDecodedImageSequence2;
        } finally {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
    }

    public final com.facebook.imagepipeline.producers.Producer<java.lang.Void> getDecodedImagePrefetchProducerSequence(com.facebook.imagepipeline.request.ImageRequest imageRequest) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> basicDecodedImageSequence = getBasicDecodedImageSequence(imageRequest);
        if (this.useBitmapPrepareToDraw) {
            basicDecodedImageSequence = getBitmapPrepareSequence(basicDecodedImageSequence);
        }
        return getDecodedImagePrefetchSequence(basicDecodedImageSequence);
    }

    private final com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> getBasicDecodedImageSequence(com.facebook.imagepipeline.request.ImageRequest imageRequest) {
        com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> networkFetchSequence;
        com.facebook.imagepipeline.systrace.FrescoSystrace frescoSystrace = com.facebook.imagepipeline.systrace.FrescoSystrace.INSTANCE;
        if (!com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            android.net.Uri sourceUri = imageRequest.getSourceUri();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sourceUri, "getSourceUri(...)");
            if (sourceUri == null) {
                throw new java.lang.IllegalStateException("Uri is null.".toString());
            }
            int sourceUriType = imageRequest.getSourceUriType();
            if (sourceUriType == 0) {
                return getNetworkFetchSequence();
            }
            switch (sourceUriType) {
                case 2:
                    return imageRequest.getLoadThumbnailOnlyForAndroidSdkAboveQ() ? getLocalThumbnailBitmapSdk29FetchSequence() : getLocalVideoFileFetchSequence();
                case 3:
                    return imageRequest.getLoadThumbnailOnlyForAndroidSdkAboveQ() ? getLocalThumbnailBitmapSdk29FetchSequence() : getLocalImageFileFetchSequence();
                case 4:
                    if (imageRequest.getLoadThumbnailOnlyForAndroidSdkAboveQ()) {
                        return getLocalThumbnailBitmapSdk29FetchSequence();
                    }
                    return com.facebook.common.media.MediaUtils.isVideo(this.contentResolver.getType(sourceUri)) ? getLocalVideoFileFetchSequence() : getLocalContentUriFetchSequence();
                case 5:
                    return getLocalAssetFetchSequence();
                case 6:
                    return getLocalResourceFetchSequence();
                case 7:
                    return getDataFetchSequence();
                case 8:
                    return getQualifiedResourceFetchSequence();
                default:
                    java.util.Set<com.facebook.imagepipeline.producers.CustomProducerSequenceFactory> set = this.customProducerSequenceFactories;
                    if (set != null) {
                        java.util.Iterator<com.facebook.imagepipeline.producers.CustomProducerSequenceFactory> it = set.iterator();
                        while (it.hasNext()) {
                            com.facebook.imagepipeline.request.ImageRequest imageRequest2 = imageRequest;
                            com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> customDecodedImageSequence = it.next().getCustomDecodedImageSequence(imageRequest2, this, this.producerFactory, this.threadHandoffProducerQueue, this.isEncodedMemoryCacheProbingEnabled, this.isDiskCacheProbingEnabled);
                            if (customDecodedImageSequence != null) {
                                return customDecodedImageSequence;
                            }
                            imageRequest = imageRequest2;
                        }
                    }
                    throw new java.lang.IllegalArgumentException("Unsupported uri scheme! Uri is: " + INSTANCE.getShortenedUriString(sourceUri));
            }
        }
        com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("ProducerSequenceFactory#getBasicDecodedImageSequence");
        try {
            android.net.Uri sourceUri2 = imageRequest.getSourceUri();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sourceUri2, "getSourceUri(...)");
            if (sourceUri2 == null) {
                throw new java.lang.IllegalStateException("Uri is null.".toString());
            }
            int sourceUriType2 = imageRequest.getSourceUriType();
            if (sourceUriType2 != 0) {
                switch (sourceUriType2) {
                    case 2:
                        if (imageRequest.getLoadThumbnailOnlyForAndroidSdkAboveQ()) {
                            com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> localThumbnailBitmapSdk29FetchSequence = getLocalThumbnailBitmapSdk29FetchSequence();
                            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                            return localThumbnailBitmapSdk29FetchSequence;
                        }
                        networkFetchSequence = getLocalVideoFileFetchSequence();
                        break;
                    case 3:
                        if (imageRequest.getLoadThumbnailOnlyForAndroidSdkAboveQ()) {
                            com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> localThumbnailBitmapSdk29FetchSequence2 = getLocalThumbnailBitmapSdk29FetchSequence();
                            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                            return localThumbnailBitmapSdk29FetchSequence2;
                        }
                        networkFetchSequence = getLocalImageFileFetchSequence();
                        break;
                    case 4:
                        if (imageRequest.getLoadThumbnailOnlyForAndroidSdkAboveQ()) {
                            com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> localThumbnailBitmapSdk29FetchSequence3 = getLocalThumbnailBitmapSdk29FetchSequence();
                            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                            return localThumbnailBitmapSdk29FetchSequence3;
                        }
                        if (com.facebook.common.media.MediaUtils.isVideo(this.contentResolver.getType(sourceUri2))) {
                            com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> localVideoFileFetchSequence = getLocalVideoFileFetchSequence();
                            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                            return localVideoFileFetchSequence;
                        }
                        networkFetchSequence = getLocalContentUriFetchSequence();
                        break;
                    case 5:
                        networkFetchSequence = getLocalAssetFetchSequence();
                        break;
                    case 6:
                        networkFetchSequence = getLocalResourceFetchSequence();
                        break;
                    case 7:
                        networkFetchSequence = getDataFetchSequence();
                        break;
                    case 8:
                        networkFetchSequence = getQualifiedResourceFetchSequence();
                        break;
                    default:
                        java.util.Set<com.facebook.imagepipeline.producers.CustomProducerSequenceFactory> set2 = this.customProducerSequenceFactories;
                        if (set2 != null) {
                            java.util.Iterator<com.facebook.imagepipeline.producers.CustomProducerSequenceFactory> it2 = set2.iterator();
                            while (it2.hasNext()) {
                                com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> customDecodedImageSequence2 = it2.next().getCustomDecodedImageSequence(imageRequest, this, this.producerFactory, this.threadHandoffProducerQueue, this.isEncodedMemoryCacheProbingEnabled, this.isDiskCacheProbingEnabled);
                                if (customDecodedImageSequence2 != null) {
                                    com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                                    return customDecodedImageSequence2;
                                }
                            }
                        }
                        throw new java.lang.IllegalArgumentException("Unsupported uri scheme! Uri is: " + INSTANCE.getShortenedUriString(sourceUri2));
                }
            } else {
                networkFetchSequence = getNetworkFetchSequence();
            }
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
            return networkFetchSequence;
        } catch (java.lang.Throwable th) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
            throw th;
        }
    }

    public final com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> getNetworkFetchSequence() {
        return (com.facebook.imagepipeline.producers.Producer) this.networkFetchSequence.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.facebook.imagepipeline.producers.Producer networkFetchSequence_delegate$lambda$11(com.facebook.imagepipeline.core.ProducerSequenceFactory this$0) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.facebook.imagepipeline.systrace.FrescoSystrace frescoSystrace = com.facebook.imagepipeline.systrace.FrescoSystrace.INSTANCE;
        if (!com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            return this$0.newBitmapCacheGetToDecodeSequence(this$0.getCommonNetworkFetchToEncodedMemorySequence());
        }
        com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchSequence:init");
        try {
            return this$0.newBitmapCacheGetToDecodeSequence(this$0.getCommonNetworkFetchToEncodedMemorySequence());
        } finally {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
    }

    public final com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> getBackgroundNetworkFetchToEncodedMemorySequence() {
        java.lang.Object value = this.backgroundNetworkFetchToEncodedMemorySequence.getValue();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (com.facebook.imagepipeline.producers.Producer) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.facebook.imagepipeline.producers.Producer backgroundNetworkFetchToEncodedMemorySequence_delegate$lambda$13(com.facebook.imagepipeline.core.ProducerSequenceFactory this$0) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.facebook.imagepipeline.systrace.FrescoSystrace frescoSystrace = com.facebook.imagepipeline.systrace.FrescoSystrace.INSTANCE;
        if (!com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            return this$0.producerFactory.newBackgroundThreadHandoffProducer(this$0.getCommonNetworkFetchToEncodedMemorySequence(), this$0.threadHandoffProducerQueue);
        }
        com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundNetworkFetchToEncodedMemorySequence:init");
        try {
            return this$0.producerFactory.newBackgroundThreadHandoffProducer(this$0.getCommonNetworkFetchToEncodedMemorySequence(), this$0.threadHandoffProducerQueue);
        } finally {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
    }

    public final com.facebook.imagepipeline.producers.Producer<java.lang.Void> getNetworkFetchToEncodedMemoryPrefetchSequence() {
        java.lang.Object value = this.networkFetchToEncodedMemoryPrefetchSequence.getValue();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (com.facebook.imagepipeline.producers.Producer) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.facebook.imagepipeline.producers.SwallowResultProducer networkFetchToEncodedMemoryPrefetchSequence_delegate$lambda$15(com.facebook.imagepipeline.core.ProducerSequenceFactory this$0) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.facebook.imagepipeline.systrace.FrescoSystrace frescoSystrace = com.facebook.imagepipeline.systrace.FrescoSystrace.INSTANCE;
        if (!com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            return this$0.producerFactory.newSwallowResultProducer(this$0.getBackgroundNetworkFetchToEncodedMemorySequence());
        }
        com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchToEncodedMemoryPrefetchSequence");
        try {
            return this$0.producerFactory.newSwallowResultProducer(this$0.getBackgroundNetworkFetchToEncodedMemorySequence());
        } finally {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
    }

    public final com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> getCommonNetworkFetchToEncodedMemorySequence() {
        return (com.facebook.imagepipeline.producers.Producer) this.commonNetworkFetchToEncodedMemorySequence.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.facebook.imagepipeline.producers.Producer commonNetworkFetchToEncodedMemorySequence_delegate$lambda$17(com.facebook.imagepipeline.core.ProducerSequenceFactory this$0) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.facebook.imagepipeline.systrace.FrescoSystrace frescoSystrace = com.facebook.imagepipeline.systrace.FrescoSystrace.INSTANCE;
        if (!com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            return this$0.newCommonNetworkFetchToEncodedMemorySequence(this$0.networkFetcher);
        }
        com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("ProducerSequenceFactory#getCommonNetworkFetchToEncodedMemorySequence");
        try {
            return this$0.newCommonNetworkFetchToEncodedMemorySequence(this$0.networkFetcher);
        } finally {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
    }

    public final synchronized com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> newCommonNetworkFetchToEncodedMemorySequence(com.facebook.imagepipeline.producers.NetworkFetcher<?> networkFetcher) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(networkFetcher, "networkFetcher");
        com.facebook.imagepipeline.systrace.FrescoSystrace frescoSystrace = com.facebook.imagepipeline.systrace.FrescoSystrace.INSTANCE;
        boolean z = true;
        if (!com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> producerNewNetworkFetchProducer = this.producerFactory.newNetworkFetchProducer(networkFetcher);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(producerNewNetworkFetchProducer, "newNetworkFetchProducer(...)");
            com.facebook.imagepipeline.producers.AddImageTransformMetaDataProducer addImageTransformMetaDataProducerNewAddImageTransformMetaDataProducer = com.facebook.imagepipeline.core.ProducerFactory.newAddImageTransformMetaDataProducer(newEncodedCacheMultiplexToTranscodeSequence(producerNewNetworkFetchProducer));
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(addImageTransformMetaDataProducerNewAddImageTransformMetaDataProducer, "newAddImageTransformMetaDataProducer(...)");
            com.facebook.imagepipeline.producers.AddImageTransformMetaDataProducer addImageTransformMetaDataProducer = addImageTransformMetaDataProducerNewAddImageTransformMetaDataProducer;
            com.facebook.imagepipeline.core.ProducerFactory producerFactory = this.producerFactory;
            if (!this.resizeAndRotateEnabledForNetwork || this.downsampleMode == com.facebook.imagepipeline.core.DownsampleMode.NEVER) {
                z = false;
            }
            return producerFactory.newResizeAndRotateProducer(addImageTransformMetaDataProducer, z, this.imageTranscoderFactory);
        }
        com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("ProducerSequenceFactory#createCommonNetworkFetchToEncodedMemorySequence");
        try {
            com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> producerNewNetworkFetchProducer2 = this.producerFactory.newNetworkFetchProducer(networkFetcher);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(producerNewNetworkFetchProducer2, "newNetworkFetchProducer(...)");
            com.facebook.imagepipeline.producers.AddImageTransformMetaDataProducer addImageTransformMetaDataProducerNewAddImageTransformMetaDataProducer2 = com.facebook.imagepipeline.core.ProducerFactory.newAddImageTransformMetaDataProducer(newEncodedCacheMultiplexToTranscodeSequence(producerNewNetworkFetchProducer2));
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(addImageTransformMetaDataProducerNewAddImageTransformMetaDataProducer2, "newAddImageTransformMetaDataProducer(...)");
            com.facebook.imagepipeline.producers.AddImageTransformMetaDataProducer addImageTransformMetaDataProducer2 = addImageTransformMetaDataProducerNewAddImageTransformMetaDataProducer2;
            com.facebook.imagepipeline.core.ProducerFactory producerFactory2 = this.producerFactory;
            if (!this.resizeAndRotateEnabledForNetwork || this.downsampleMode == com.facebook.imagepipeline.core.DownsampleMode.NEVER) {
                z = false;
            }
            com.facebook.imagepipeline.producers.ResizeAndRotateProducer resizeAndRotateProducerNewResizeAndRotateProducer = producerFactory2.newResizeAndRotateProducer(addImageTransformMetaDataProducer2, z, this.imageTranscoderFactory);
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
            return resizeAndRotateProducerNewResizeAndRotateProducer;
        } catch (java.lang.Throwable th) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
            throw th;
        }
    }

    public final com.facebook.imagepipeline.producers.Producer<java.lang.Void> getLocalFileFetchToEncodedMemoryPrefetchSequence() {
        java.lang.Object value = this.localFileFetchToEncodedMemoryPrefetchSequence.getValue();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (com.facebook.imagepipeline.producers.Producer) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.facebook.imagepipeline.producers.SwallowResultProducer localFileFetchToEncodedMemoryPrefetchSequence_delegate$lambda$20(com.facebook.imagepipeline.core.ProducerSequenceFactory this$0) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.facebook.imagepipeline.systrace.FrescoSystrace frescoSystrace = com.facebook.imagepipeline.systrace.FrescoSystrace.INSTANCE;
        if (!com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            return this$0.producerFactory.newSwallowResultProducer(this$0.getBackgroundLocalFileFetchToEncodeMemorySequence());
        }
        com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalFileFetchToEncodedMemoryPrefetchSequence:init");
        try {
            return this$0.producerFactory.newSwallowResultProducer(this$0.getBackgroundLocalFileFetchToEncodeMemorySequence());
        } finally {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
    }

    public final com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> getBackgroundLocalFileFetchToEncodeMemorySequence() {
        java.lang.Object value = this.backgroundLocalFileFetchToEncodeMemorySequence.getValue();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (com.facebook.imagepipeline.producers.Producer) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.facebook.imagepipeline.producers.Producer backgroundLocalFileFetchToEncodeMemorySequence_delegate$lambda$22(com.facebook.imagepipeline.core.ProducerSequenceFactory this$0) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.facebook.imagepipeline.systrace.FrescoSystrace frescoSystrace = com.facebook.imagepipeline.systrace.FrescoSystrace.INSTANCE;
        if (!com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.producers.LocalFileFetchProducer localFileFetchProducerNewLocalFileFetchProducer = this$0.producerFactory.newLocalFileFetchProducer();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(localFileFetchProducerNewLocalFileFetchProducer, "newLocalFileFetchProducer(...)");
            return this$0.producerFactory.newBackgroundThreadHandoffProducer(this$0.newEncodedCacheMultiplexToTranscodeSequence(localFileFetchProducerNewLocalFileFetchProducer), this$0.threadHandoffProducerQueue);
        }
        com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundLocalFileFetchToEncodeMemorySequence");
        try {
            com.facebook.imagepipeline.producers.LocalFileFetchProducer localFileFetchProducerNewLocalFileFetchProducer2 = this$0.producerFactory.newLocalFileFetchProducer();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(localFileFetchProducerNewLocalFileFetchProducer2, "newLocalFileFetchProducer(...)");
            return this$0.producerFactory.newBackgroundThreadHandoffProducer(this$0.newEncodedCacheMultiplexToTranscodeSequence(localFileFetchProducerNewLocalFileFetchProducer2), this$0.threadHandoffProducerQueue);
        } finally {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
    }

    public final com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> getBackgroundLocalContentUriFetchToEncodeMemorySequence() {
        java.lang.Object value = this.backgroundLocalContentUriFetchToEncodeMemorySequence.getValue();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (com.facebook.imagepipeline.producers.Producer) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.facebook.imagepipeline.producers.Producer backgroundLocalContentUriFetchToEncodeMemorySequence_delegate$lambda$24(com.facebook.imagepipeline.core.ProducerSequenceFactory this$0) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.facebook.imagepipeline.systrace.FrescoSystrace frescoSystrace = com.facebook.imagepipeline.systrace.FrescoSystrace.INSTANCE;
        if (!com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.producers.LocalContentUriFetchProducer localContentUriFetchProducerNewLocalContentUriFetchProducer = this$0.producerFactory.newLocalContentUriFetchProducer();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducerNewLocalContentUriFetchProducer, "newLocalContentUriFetchProducer(...)");
            return this$0.producerFactory.newBackgroundThreadHandoffProducer(this$0.newEncodedCacheMultiplexToTranscodeSequence(localContentUriFetchProducerNewLocalContentUriFetchProducer), this$0.threadHandoffProducerQueue);
        }
        com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundLocalContentUriFetchToEncodeMemorySequence:init");
        try {
            com.facebook.imagepipeline.producers.LocalContentUriFetchProducer localContentUriFetchProducerNewLocalContentUriFetchProducer2 = this$0.producerFactory.newLocalContentUriFetchProducer();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducerNewLocalContentUriFetchProducer2, "newLocalContentUriFetchProducer(...)");
            return this$0.producerFactory.newBackgroundThreadHandoffProducer(this$0.newEncodedCacheMultiplexToTranscodeSequence(localContentUriFetchProducerNewLocalContentUriFetchProducer2), this$0.threadHandoffProducerQueue);
        } finally {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
    }

    public final com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> getLocalImageFileFetchSequence() {
        return (com.facebook.imagepipeline.producers.Producer) this.localImageFileFetchSequence.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.facebook.imagepipeline.producers.Producer localImageFileFetchSequence_delegate$lambda$25(com.facebook.imagepipeline.core.ProducerSequenceFactory this$0) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.facebook.imagepipeline.producers.LocalFileFetchProducer localFileFetchProducerNewLocalFileFetchProducer = this$0.producerFactory.newLocalFileFetchProducer();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(localFileFetchProducerNewLocalFileFetchProducer, "newLocalFileFetchProducer(...)");
        return this$0.newBitmapCacheGetToLocalTransformSequence(localFileFetchProducerNewLocalFileFetchProducer);
    }

    public final com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> getLocalVideoFileFetchSequence() {
        return (com.facebook.imagepipeline.producers.Producer) this.localVideoFileFetchSequence.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.facebook.imagepipeline.producers.Producer localVideoFileFetchSequence_delegate$lambda$26(com.facebook.imagepipeline.core.ProducerSequenceFactory this$0) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer localVideoThumbnailProducerNewLocalVideoThumbnailProducer = this$0.producerFactory.newLocalVideoThumbnailProducer();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(localVideoThumbnailProducerNewLocalVideoThumbnailProducer, "newLocalVideoThumbnailProducer(...)");
        return this$0.newBitmapCacheGetToBitmapCacheSequence(localVideoThumbnailProducerNewLocalVideoThumbnailProducer);
    }

    public final com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> getLocalContentUriFetchSequence() {
        return (com.facebook.imagepipeline.producers.Producer) this.localContentUriFetchSequence.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.facebook.imagepipeline.producers.Producer localContentUriFetchSequence_delegate$lambda$27(com.facebook.imagepipeline.core.ProducerSequenceFactory this$0) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.facebook.imagepipeline.producers.LocalContentUriFetchProducer localContentUriFetchProducerNewLocalContentUriFetchProducer = this$0.producerFactory.newLocalContentUriFetchProducer();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(localContentUriFetchProducerNewLocalContentUriFetchProducer, "newLocalContentUriFetchProducer(...)");
        return this$0.newBitmapCacheGetToLocalTransformSequence(localContentUriFetchProducerNewLocalContentUriFetchProducer, new com.facebook.imagepipeline.producers.ThumbnailProducer[]{this$0.producerFactory.newLocalContentUriThumbnailFetchProducer(), this$0.producerFactory.newLocalExifThumbnailProducer()});
    }

    public final com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> getLocalThumbnailBitmapSdk29FetchSequence() {
        return (com.facebook.imagepipeline.producers.Producer) this.localThumbnailBitmapSdk29FetchSequence.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.facebook.imagepipeline.producers.Producer localThumbnailBitmapSdk29FetchSequence_delegate$lambda$28(com.facebook.imagepipeline.core.ProducerSequenceFactory this$0) throws java.lang.Throwable {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            com.facebook.imagepipeline.producers.LocalThumbnailBitmapSdk29Producer localThumbnailBitmapSdk29ProducerNewLocalThumbnailBitmapSdk29Producer = this$0.producerFactory.newLocalThumbnailBitmapSdk29Producer();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(localThumbnailBitmapSdk29ProducerNewLocalThumbnailBitmapSdk29Producer, "newLocalThumbnailBitmapSdk29Producer(...)");
            return this$0.newBitmapCacheGetToBitmapCacheSequence(localThumbnailBitmapSdk29ProducerNewLocalThumbnailBitmapSdk29Producer);
        }
        throw new java.lang.Throwable("Unreachable exception. Just to make linter happy for the lazy block.");
    }

    public final com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> getQualifiedResourceFetchSequence() {
        return (com.facebook.imagepipeline.producers.Producer) this.qualifiedResourceFetchSequence.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.facebook.imagepipeline.producers.Producer qualifiedResourceFetchSequence_delegate$lambda$29(com.facebook.imagepipeline.core.ProducerSequenceFactory this$0) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.facebook.imagepipeline.producers.QualifiedResourceFetchProducer qualifiedResourceFetchProducerNewQualifiedResourceFetchProducer = this$0.producerFactory.newQualifiedResourceFetchProducer();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(qualifiedResourceFetchProducerNewQualifiedResourceFetchProducer, "newQualifiedResourceFetchProducer(...)");
        return this$0.newBitmapCacheGetToLocalTransformSequence(qualifiedResourceFetchProducerNewQualifiedResourceFetchProducer);
    }

    public final com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> getLocalResourceFetchSequence() {
        return (com.facebook.imagepipeline.producers.Producer) this.localResourceFetchSequence.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.facebook.imagepipeline.producers.Producer localResourceFetchSequence_delegate$lambda$30(com.facebook.imagepipeline.core.ProducerSequenceFactory this$0) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.facebook.imagepipeline.producers.LocalResourceFetchProducer localResourceFetchProducerNewLocalResourceFetchProducer = this$0.producerFactory.newLocalResourceFetchProducer();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(localResourceFetchProducerNewLocalResourceFetchProducer, "newLocalResourceFetchProducer(...)");
        return this$0.newBitmapCacheGetToLocalTransformSequence(localResourceFetchProducerNewLocalResourceFetchProducer);
    }

    public final com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> getLocalAssetFetchSequence() {
        return (com.facebook.imagepipeline.producers.Producer) this.localAssetFetchSequence.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.facebook.imagepipeline.producers.Producer localAssetFetchSequence_delegate$lambda$31(com.facebook.imagepipeline.core.ProducerSequenceFactory this$0) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.facebook.imagepipeline.producers.LocalAssetFetchProducer localAssetFetchProducerNewLocalAssetFetchProducer = this$0.producerFactory.newLocalAssetFetchProducer();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(localAssetFetchProducerNewLocalAssetFetchProducer, "newLocalAssetFetchProducer(...)");
        return this$0.newBitmapCacheGetToLocalTransformSequence(localAssetFetchProducerNewLocalAssetFetchProducer);
    }

    public final com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> getDataFetchSequence() {
        return (com.facebook.imagepipeline.producers.Producer) this.dataFetchSequence.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.facebook.imagepipeline.producers.Producer dataFetchSequence_delegate$lambda$32(com.facebook.imagepipeline.core.ProducerSequenceFactory this$0) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.facebook.imagepipeline.producers.DataFetchProducer dataFetchProducerNewDataFetchProducer = this$0.producerFactory.newDataFetchProducer();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(dataFetchProducerNewDataFetchProducer, "newDataFetchProducer(...)");
        return this$0.newBitmapCacheGetToDecodeSequence(this$0.producerFactory.newResizeAndRotateProducer(com.facebook.imagepipeline.core.ProducerFactory.newAddImageTransformMetaDataProducer(dataFetchProducerNewDataFetchProducer), true, this$0.imageTranscoderFactory));
    }

    private final com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> newBitmapCacheGetToLocalTransformSequence(com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> inputProducer) {
        return newBitmapCacheGetToLocalTransformSequence(inputProducer, new com.facebook.imagepipeline.producers.ThumbnailProducer[]{this.producerFactory.newLocalExifThumbnailProducer()});
    }

    private final com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> newBitmapCacheGetToLocalTransformSequence(com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> inputProducer, com.facebook.imagepipeline.producers.ThumbnailProducer<com.facebook.imagepipeline.image.EncodedImage>[] thumbnailProducers) {
        return newBitmapCacheGetToDecodeSequence(newLocalTransformationsSequence(newEncodedCacheMultiplexToTranscodeSequence(inputProducer), thumbnailProducers));
    }

    public final com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> newBitmapCacheGetToDecodeSequence(com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> inputProducer) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(inputProducer, "inputProducer");
        com.facebook.imagepipeline.systrace.FrescoSystrace frescoSystrace = com.facebook.imagepipeline.systrace.FrescoSystrace.INSTANCE;
        if (!com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.producers.DecodeProducer decodeProducerNewDecodeProducer = this.producerFactory.newDecodeProducer(inputProducer);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(decodeProducerNewDecodeProducer, "newDecodeProducer(...)");
            return newBitmapCacheGetToBitmapCacheSequence(decodeProducerNewDecodeProducer);
        }
        com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("ProducerSequenceFactory#newBitmapCacheGetToDecodeSequence");
        try {
            com.facebook.imagepipeline.producers.DecodeProducer decodeProducerNewDecodeProducer2 = this.producerFactory.newDecodeProducer(inputProducer);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(decodeProducerNewDecodeProducer2, "newDecodeProducer(...)");
            return newBitmapCacheGetToBitmapCacheSequence(decodeProducerNewDecodeProducer2);
        } finally {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
    }

    private final com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> newEncodedCacheMultiplexToTranscodeSequence(com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> inputProducer) {
        if (this.diskCacheEnabled) {
            inputProducer = newDiskCacheSequence(inputProducer);
        }
        com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> producerNewEncodedMemoryCacheProducer = this.producerFactory.newEncodedMemoryCacheProducer(inputProducer);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(producerNewEncodedMemoryCacheProducer, "newEncodedMemoryCacheProducer(...)");
        if (this.isDiskCacheProbingEnabled) {
            com.facebook.imagepipeline.producers.EncodedProbeProducer encodedProbeProducerNewEncodedProbeProducer = this.producerFactory.newEncodedProbeProducer(producerNewEncodedMemoryCacheProducer);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(encodedProbeProducerNewEncodedProbeProducer, "newEncodedProbeProducer(...)");
            com.facebook.imagepipeline.producers.EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerNewEncodedCacheKeyMultiplexProducer = this.producerFactory.newEncodedCacheKeyMultiplexProducer(encodedProbeProducerNewEncodedProbeProducer);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(encodedCacheKeyMultiplexProducerNewEncodedCacheKeyMultiplexProducer, "newEncodedCacheKeyMultiplexProducer(...)");
            return encodedCacheKeyMultiplexProducerNewEncodedCacheKeyMultiplexProducer;
        }
        com.facebook.imagepipeline.producers.EncodedCacheKeyMultiplexProducer encodedCacheKeyMultiplexProducerNewEncodedCacheKeyMultiplexProducer2 = this.producerFactory.newEncodedCacheKeyMultiplexProducer(producerNewEncodedMemoryCacheProducer);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(encodedCacheKeyMultiplexProducerNewEncodedCacheKeyMultiplexProducer2, "newEncodedCacheKeyMultiplexProducer(...)");
        return encodedCacheKeyMultiplexProducerNewEncodedCacheKeyMultiplexProducer2;
    }

    private final com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> newDiskCacheSequence(com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> inputProducer) {
        com.facebook.imagepipeline.producers.DiskCacheWriteProducer diskCacheWriteProducerNewDiskCacheWriteProducer;
        com.facebook.imagepipeline.producers.DiskCacheWriteProducer diskCacheWriteProducerNewDiskCacheWriteProducer2;
        com.facebook.imagepipeline.systrace.FrescoSystrace frescoSystrace = com.facebook.imagepipeline.systrace.FrescoSystrace.INSTANCE;
        if (!com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            if (this.partialImageCachingEnabled) {
                com.facebook.imagepipeline.producers.PartialDiskCacheProducer partialDiskCacheProducerNewPartialDiskCacheProducer = this.producerFactory.newPartialDiskCacheProducer(inputProducer);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(partialDiskCacheProducerNewPartialDiskCacheProducer, "newPartialDiskCacheProducer(...)");
                diskCacheWriteProducerNewDiskCacheWriteProducer2 = this.producerFactory.newDiskCacheWriteProducer(partialDiskCacheProducerNewPartialDiskCacheProducer);
            } else {
                diskCacheWriteProducerNewDiskCacheWriteProducer2 = this.producerFactory.newDiskCacheWriteProducer(inputProducer);
            }
            kotlin.jvm.internal.Intrinsics.checkNotNull(diskCacheWriteProducerNewDiskCacheWriteProducer2);
            com.facebook.imagepipeline.producers.DiskCacheReadProducer diskCacheReadProducerNewDiskCacheReadProducer = this.producerFactory.newDiskCacheReadProducer(diskCacheWriteProducerNewDiskCacheWriteProducer2);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(diskCacheReadProducerNewDiskCacheReadProducer, "newDiskCacheReadProducer(...)");
            return diskCacheReadProducerNewDiskCacheReadProducer;
        }
        com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("ProducerSequenceFactory#newDiskCacheSequence");
        try {
            if (this.partialImageCachingEnabled) {
                com.facebook.imagepipeline.producers.PartialDiskCacheProducer partialDiskCacheProducerNewPartialDiskCacheProducer2 = this.producerFactory.newPartialDiskCacheProducer(inputProducer);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(partialDiskCacheProducerNewPartialDiskCacheProducer2, "newPartialDiskCacheProducer(...)");
                diskCacheWriteProducerNewDiskCacheWriteProducer = this.producerFactory.newDiskCacheWriteProducer(partialDiskCacheProducerNewPartialDiskCacheProducer2);
            } else {
                diskCacheWriteProducerNewDiskCacheWriteProducer = this.producerFactory.newDiskCacheWriteProducer(inputProducer);
            }
            kotlin.jvm.internal.Intrinsics.checkNotNull(diskCacheWriteProducerNewDiskCacheWriteProducer);
            com.facebook.imagepipeline.producers.DiskCacheReadProducer diskCacheReadProducerNewDiskCacheReadProducer2 = this.producerFactory.newDiskCacheReadProducer(diskCacheWriteProducerNewDiskCacheWriteProducer);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(diskCacheReadProducerNewDiskCacheReadProducer2, "newDiskCacheReadProducer(...)");
            return diskCacheReadProducerNewDiskCacheReadProducer2;
        } finally {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
    }

    private final com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> newBitmapCacheGetToBitmapCacheSequence(com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> inputProducer) {
        com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer bitmapMemoryCacheProducerNewBitmapMemoryCacheProducer = this.producerFactory.newBitmapMemoryCacheProducer(inputProducer);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bitmapMemoryCacheProducerNewBitmapMemoryCacheProducer, "newBitmapMemoryCacheProducer(...)");
        com.facebook.imagepipeline.producers.BitmapMemoryCacheKeyMultiplexProducer bitmapMemoryCacheKeyMultiplexProducerNewBitmapMemoryCacheKeyMultiplexProducer = this.producerFactory.newBitmapMemoryCacheKeyMultiplexProducer(bitmapMemoryCacheProducerNewBitmapMemoryCacheProducer);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bitmapMemoryCacheKeyMultiplexProducerNewBitmapMemoryCacheKeyMultiplexProducer, "newBitmapMemoryCacheKeyMultiplexProducer(...)");
        com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> producerNewBackgroundThreadHandoffProducer = this.producerFactory.newBackgroundThreadHandoffProducer(bitmapMemoryCacheKeyMultiplexProducerNewBitmapMemoryCacheKeyMultiplexProducer, this.threadHandoffProducerQueue);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(producerNewBackgroundThreadHandoffProducer, "newBackgroundThreadHandoffProducer(...)");
        if (this.isEncodedMemoryCacheProbingEnabled || this.isDiskCacheProbingEnabled) {
            com.facebook.imagepipeline.producers.BitmapMemoryCacheGetProducer bitmapMemoryCacheGetProducerNewBitmapMemoryCacheGetProducer = this.producerFactory.newBitmapMemoryCacheGetProducer(producerNewBackgroundThreadHandoffProducer);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bitmapMemoryCacheGetProducerNewBitmapMemoryCacheGetProducer, "newBitmapMemoryCacheGetProducer(...)");
            com.facebook.imagepipeline.producers.BitmapProbeProducer bitmapProbeProducerNewBitmapProbeProducer = this.producerFactory.newBitmapProbeProducer(bitmapMemoryCacheGetProducerNewBitmapMemoryCacheGetProducer);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bitmapProbeProducerNewBitmapProbeProducer, "newBitmapProbeProducer(...)");
            return bitmapProbeProducerNewBitmapProbeProducer;
        }
        com.facebook.imagepipeline.producers.BitmapMemoryCacheGetProducer bitmapMemoryCacheGetProducerNewBitmapMemoryCacheGetProducer2 = this.producerFactory.newBitmapMemoryCacheGetProducer(producerNewBackgroundThreadHandoffProducer);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bitmapMemoryCacheGetProducerNewBitmapMemoryCacheGetProducer2, "newBitmapMemoryCacheGetProducer(...)");
        return bitmapMemoryCacheGetProducerNewBitmapMemoryCacheGetProducer2;
    }

    private final com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> newLocalTransformationsSequence(com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> inputProducer, com.facebook.imagepipeline.producers.ThumbnailProducer<com.facebook.imagepipeline.image.EncodedImage>[] thumbnailProducers) {
        com.facebook.imagepipeline.producers.AddImageTransformMetaDataProducer addImageTransformMetaDataProducerNewAddImageTransformMetaDataProducer = com.facebook.imagepipeline.core.ProducerFactory.newAddImageTransformMetaDataProducer(inputProducer);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(addImageTransformMetaDataProducerNewAddImageTransformMetaDataProducer, "newAddImageTransformMetaDataProducer(...)");
        com.facebook.imagepipeline.producers.ThrottlingProducer throttlingProducerNewThrottlingProducer = this.producerFactory.newThrottlingProducer(this.producerFactory.newResizeAndRotateProducer(addImageTransformMetaDataProducerNewAddImageTransformMetaDataProducer, true, this.imageTranscoderFactory));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(throttlingProducerNewThrottlingProducer, "newThrottlingProducer(...)");
        com.facebook.imagepipeline.producers.BranchOnSeparateImagesProducer branchOnSeparateImagesProducerNewBranchOnSeparateImagesProducer = com.facebook.imagepipeline.core.ProducerFactory.newBranchOnSeparateImagesProducer(newLocalThumbnailProducer(thumbnailProducers), throttlingProducerNewThrottlingProducer);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(branchOnSeparateImagesProducerNewBranchOnSeparateImagesProducer, "newBranchOnSeparateImagesProducer(...)");
        return branchOnSeparateImagesProducerNewBranchOnSeparateImagesProducer;
    }

    private final com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> newLocalThumbnailProducer(com.facebook.imagepipeline.producers.ThumbnailProducer<com.facebook.imagepipeline.image.EncodedImage>[] thumbnailProducers) {
        com.facebook.imagepipeline.producers.ThumbnailBranchProducer thumbnailBranchProducerNewThumbnailBranchProducer = this.producerFactory.newThumbnailBranchProducer(thumbnailProducers);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(thumbnailBranchProducerNewThumbnailBranchProducer, "newThumbnailBranchProducer(...)");
        com.facebook.imagepipeline.producers.ResizeAndRotateProducer resizeAndRotateProducerNewResizeAndRotateProducer = this.producerFactory.newResizeAndRotateProducer(thumbnailBranchProducerNewThumbnailBranchProducer, true, this.imageTranscoderFactory);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(resizeAndRotateProducerNewResizeAndRotateProducer, "newResizeAndRotateProducer(...)");
        return resizeAndRotateProducerNewResizeAndRotateProducer;
    }

    private final synchronized com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> getPostprocessorSequence(com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> inputProducer) {
        com.facebook.imagepipeline.producers.PostprocessedBitmapMemoryCacheProducer postprocessedBitmapMemoryCacheProducerNewPostprocessorBitmapMemoryCacheProducer;
        postprocessedBitmapMemoryCacheProducerNewPostprocessorBitmapMemoryCacheProducer = this.postprocessorSequences.get(inputProducer);
        if (postprocessedBitmapMemoryCacheProducerNewPostprocessorBitmapMemoryCacheProducer == null) {
            com.facebook.imagepipeline.producers.PostprocessorProducer postprocessorProducerNewPostprocessorProducer = this.producerFactory.newPostprocessorProducer(inputProducer);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(postprocessorProducerNewPostprocessorProducer, "newPostprocessorProducer(...)");
            postprocessedBitmapMemoryCacheProducerNewPostprocessorBitmapMemoryCacheProducer = this.producerFactory.newPostprocessorBitmapMemoryCacheProducer(postprocessorProducerNewPostprocessorProducer);
            this.postprocessorSequences.put(inputProducer, postprocessedBitmapMemoryCacheProducerNewPostprocessorBitmapMemoryCacheProducer);
        }
        return postprocessedBitmapMemoryCacheProducerNewPostprocessorBitmapMemoryCacheProducer;
    }

    private final synchronized com.facebook.imagepipeline.producers.Producer<java.lang.Void> getDecodedImagePrefetchSequence(com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> inputProducer) {
        com.facebook.imagepipeline.producers.SwallowResultProducer swallowResultProducerNewSwallowResultProducer;
        swallowResultProducerNewSwallowResultProducer = this.closeableImagePrefetchSequences.get(inputProducer);
        if (swallowResultProducerNewSwallowResultProducer == null) {
            swallowResultProducerNewSwallowResultProducer = this.producerFactory.newSwallowResultProducer(inputProducer);
            this.closeableImagePrefetchSequences.put(inputProducer, swallowResultProducerNewSwallowResultProducer);
        }
        return swallowResultProducerNewSwallowResultProducer;
    }

    private final synchronized com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> getBitmapPrepareSequence(com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> inputProducer) {
        com.facebook.imagepipeline.producers.BitmapPrepareProducer bitmapPrepareProducerNewBitmapPrepareProducer;
        bitmapPrepareProducerNewBitmapPrepareProducer = this.bitmapPrepareSequences.get(inputProducer);
        if (bitmapPrepareProducerNewBitmapPrepareProducer == null) {
            bitmapPrepareProducerNewBitmapPrepareProducer = this.producerFactory.newBitmapPrepareProducer(inputProducer);
            this.bitmapPrepareSequences.put(inputProducer, bitmapPrepareProducerNewBitmapPrepareProducer);
        }
        return bitmapPrepareProducerNewBitmapPrepareProducer;
    }

    private final synchronized com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> getDelaySequence(com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> inputProducer) {
        com.facebook.imagepipeline.producers.DelayProducer delayProducerNewDelayProducer;
        delayProducerNewDelayProducer = this.producerFactory.newDelayProducer(inputProducer);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(delayProducerNewDelayProducer, "newDelayProducer(...)");
        return delayProducerNewDelayProducer;
    }

    /* JADX INFO: compiled from: ProducerSequenceFactory.kt */
    @kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\f"}, d2 = {"Lcom/facebook/imagepipeline/core/ProducerSequenceFactory$Companion;", "", "<init>", "()V", "validateEncodedImageRequest", "", "imageRequest", "Lcom/facebook/imagepipeline/request/ImageRequest;", "getShortenedUriString", "", "uri", "Landroid/net/Uri;", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void validateEncodedImageRequest(com.facebook.imagepipeline.request.ImageRequest imageRequest) {
            com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(imageRequest.getLowestPermittedRequestLevel().getValue() <= com.facebook.imagepipeline.request.ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final java.lang.String getShortenedUriString(android.net.Uri uri) {
            java.lang.String string = uri.toString();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            if (string.length() <= 30) {
                return string;
            }
            java.lang.String strSubstring = string.substring(0, 30);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return strSubstring + "...";
        }
    }
}
