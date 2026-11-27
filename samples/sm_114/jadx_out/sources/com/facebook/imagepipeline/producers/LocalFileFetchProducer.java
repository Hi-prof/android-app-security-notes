package com.facebook.imagepipeline.producers;

/* JADX INFO: compiled from: LocalFileFetchProducer.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014J\b\u0010\f\u001a\u00020\rH\u0014¨\u0006\u000f"}, d2 = {"Lcom/facebook/imagepipeline/producers/LocalFileFetchProducer;", "Lcom/facebook/imagepipeline/producers/LocalFetchProducer;", "executor", "Ljava/util/concurrent/Executor;", "pooledByteBufferFactory", "Lcom/facebook/common/memory/PooledByteBufferFactory;", "<init>", "(Ljava/util/concurrent/Executor;Lcom/facebook/common/memory/PooledByteBufferFactory;)V", "getEncodedImage", "Lcom/facebook/imagepipeline/image/EncodedImage;", "imageRequest", "Lcom/facebook/imagepipeline/request/ImageRequest;", "getProducerName", "", "Companion", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LocalFileFetchProducer extends com.facebook.imagepipeline.producers.LocalFetchProducer {
    public static final java.lang.String PRODUCER_NAME = "LocalFileFetchProducer";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalFileFetchProducer(java.util.concurrent.Executor executor, com.facebook.common.memory.PooledByteBufferFactory pooledByteBufferFactory) {
        super(executor, pooledByteBufferFactory);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(executor, "executor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pooledByteBufferFactory, "pooledByteBufferFactory");
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    protected com.facebook.imagepipeline.image.EncodedImage getEncodedImage(com.facebook.imagepipeline.request.ImageRequest imageRequest) throws java.io.IOException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        return getEncodedImage(new java.io.FileInputStream(imageRequest.getSourceFile().toString()), (int) imageRequest.getSourceFile().length());
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    protected java.lang.String getProducerName() {
        return PRODUCER_NAME;
    }
}
