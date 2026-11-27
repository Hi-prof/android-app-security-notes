package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public interface ProducerListener2 {
    void onProducerEvent(com.facebook.imagepipeline.producers.ProducerContext producerContext, java.lang.String str, java.lang.String str2);

    void onProducerFinishWithCancellation(com.facebook.imagepipeline.producers.ProducerContext producerContext, java.lang.String str, @javax.annotation.Nullable java.util.Map<java.lang.String, java.lang.String> map);

    void onProducerFinishWithFailure(com.facebook.imagepipeline.producers.ProducerContext producerContext, java.lang.String str, java.lang.Throwable th, @javax.annotation.Nullable java.util.Map<java.lang.String, java.lang.String> map);

    void onProducerFinishWithSuccess(com.facebook.imagepipeline.producers.ProducerContext producerContext, java.lang.String str, @javax.annotation.Nullable java.util.Map<java.lang.String, java.lang.String> map);

    void onProducerStart(com.facebook.imagepipeline.producers.ProducerContext producerContext, java.lang.String str);

    void onUltimateProducerReached(com.facebook.imagepipeline.producers.ProducerContext producerContext, java.lang.String str, boolean z);

    boolean requiresExtraMap(com.facebook.imagepipeline.producers.ProducerContext producerContext, java.lang.String str);
}
