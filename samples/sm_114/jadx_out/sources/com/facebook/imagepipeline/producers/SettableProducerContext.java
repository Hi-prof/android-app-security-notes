package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public class SettableProducerContext extends com.facebook.imagepipeline.producers.BaseProducerContext {
    public SettableProducerContext(com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        this(producerContext.getImageRequest(), producerContext.getId(), producerContext.getUiComponentId(), producerContext.getProducerListener(), producerContext.getCallerContext(), producerContext.getLowestPermittedRequestLevel(), producerContext.isPrefetch(), producerContext.isIntermediateResultExpected(), producerContext.getPriority(), producerContext.getImagePipelineConfig());
    }

    public SettableProducerContext(com.facebook.imagepipeline.request.ImageRequest imageRequest, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        this(imageRequest, producerContext.getId(), producerContext.getUiComponentId(), producerContext.getProducerListener(), producerContext.getCallerContext(), producerContext.getLowestPermittedRequestLevel(), producerContext.isPrefetch(), producerContext.isIntermediateResultExpected(), producerContext.getPriority(), producerContext.getImagePipelineConfig());
    }

    public SettableProducerContext(com.facebook.imagepipeline.request.ImageRequest imageRequest, java.lang.String str, com.facebook.imagepipeline.producers.ProducerListener2 producerListener2, @javax.annotation.Nullable java.lang.Object obj, com.facebook.imagepipeline.request.ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, com.facebook.imagepipeline.common.Priority priority, com.facebook.imagepipeline.core.ImagePipelineConfigInterface imagePipelineConfigInterface) {
        super(imageRequest, str, producerListener2, obj, requestLevel, z, z2, priority, imagePipelineConfigInterface);
    }

    public SettableProducerContext(com.facebook.imagepipeline.request.ImageRequest imageRequest, java.lang.String str, @javax.annotation.Nullable java.lang.String str2, com.facebook.imagepipeline.producers.ProducerListener2 producerListener2, @javax.annotation.Nullable java.lang.Object obj, com.facebook.imagepipeline.request.ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, com.facebook.imagepipeline.common.Priority priority, com.facebook.imagepipeline.core.ImagePipelineConfigInterface imagePipelineConfigInterface) {
        super(imageRequest, str, str2, null, producerListener2, obj, requestLevel, z, z2, priority, imagePipelineConfigInterface);
    }

    public void setIsPrefetch(boolean z) {
        com.facebook.imagepipeline.producers.BaseProducerContext.callOnIsPrefetchChanged(setIsPrefetchNoCallbacks(z));
    }

    public void setIsIntermediateResultExpected(boolean z) {
        com.facebook.imagepipeline.producers.BaseProducerContext.callOnIsIntermediateResultExpectedChanged(setIsIntermediateResultExpectedNoCallbacks(z));
    }

    public void setPriority(com.facebook.imagepipeline.common.Priority priority) {
        com.facebook.imagepipeline.producers.BaseProducerContext.callOnPriorityChanged(setPriorityNoCallbacks(priority));
    }
}
