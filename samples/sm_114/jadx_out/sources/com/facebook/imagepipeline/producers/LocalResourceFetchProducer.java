package com.facebook.imagepipeline.producers;

/* JADX INFO: compiled from: LocalResourceFetchProducer.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/facebook/imagepipeline/producers/LocalResourceFetchProducer;", "Lcom/facebook/imagepipeline/producers/LocalFetchProducer;", "executor", "Ljava/util/concurrent/Executor;", "pooledByteBufferFactory", "Lcom/facebook/common/memory/PooledByteBufferFactory;", io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_RESOURCES, "Landroid/content/res/Resources;", "<init>", "(Ljava/util/concurrent/Executor;Lcom/facebook/common/memory/PooledByteBufferFactory;Landroid/content/res/Resources;)V", "getEncodedImage", "Lcom/facebook/imagepipeline/image/EncodedImage;", "imageRequest", "Lcom/facebook/imagepipeline/request/ImageRequest;", "getLength", "", "getProducerName", "", "Companion", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LocalResourceFetchProducer extends com.facebook.imagepipeline.producers.LocalFetchProducer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final com.facebook.imagepipeline.producers.LocalResourceFetchProducer.Companion INSTANCE = new com.facebook.imagepipeline.producers.LocalResourceFetchProducer.Companion(null);
    public static final java.lang.String PRODUCER_NAME = "LocalResourceFetchProducer";
    private final android.content.res.Resources resources;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalResourceFetchProducer(java.util.concurrent.Executor executor, com.facebook.common.memory.PooledByteBufferFactory pooledByteBufferFactory, android.content.res.Resources resources) {
        super(executor, pooledByteBufferFactory);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(executor, "executor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pooledByteBufferFactory, "pooledByteBufferFactory");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(resources, "resources");
        this.resources = resources;
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    protected com.facebook.imagepipeline.image.EncodedImage getEncodedImage(com.facebook.imagepipeline.request.ImageRequest imageRequest) throws java.io.IOException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        return getEncodedImage(this.resources.openRawResource(INSTANCE.getResourceId(imageRequest)), getLength(imageRequest));
    }

    private final int getLength(com.facebook.imagepipeline.request.ImageRequest imageRequest) {
        android.content.res.AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = null;
        try {
            assetFileDescriptorOpenRawResourceFd = this.resources.openRawResourceFd(INSTANCE.getResourceId(imageRequest));
            int length = (int) assetFileDescriptorOpenRawResourceFd.getLength();
            if (assetFileDescriptorOpenRawResourceFd == null) {
                return length;
            }
            try {
                return length;
            } catch (java.io.IOException unused) {
                return length;
            }
        } catch (android.content.res.Resources.NotFoundException unused2) {
            return -1;
        } finally {
            if (assetFileDescriptorOpenRawResourceFd != null) {
                try {
                    assetFileDescriptorOpenRawResourceFd.close();
                } catch (java.io.IOException unused3) {
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    protected java.lang.String getProducerName() {
        return PRODUCER_NAME;
    }

    /* JADX INFO: compiled from: LocalResourceFetchProducer.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/facebook/imagepipeline/producers/LocalResourceFetchProducer$Companion;", "", "<init>", "()V", "PRODUCER_NAME", "", "getResourceId", "", "imageRequest", "Lcom/facebook/imagepipeline/request/ImageRequest;", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int getResourceId(com.facebook.imagepipeline.request.ImageRequest imageRequest) {
            java.lang.String path = imageRequest.getSourceUri().getPath();
            if (path == null) {
                throw new java.lang.IllegalStateException("Required value was null.".toString());
            }
            java.lang.String strSubstring = path.substring(1);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return java.lang.Integer.parseInt(strSubstring);
        }
    }
}
