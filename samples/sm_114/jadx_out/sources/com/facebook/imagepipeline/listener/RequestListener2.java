package com.facebook.imagepipeline.listener;

/* JADX INFO: loaded from: classes.dex */
public interface RequestListener2 extends com.facebook.imagepipeline.producers.ProducerListener2 {
    void onRequestCancellation(com.facebook.imagepipeline.producers.ProducerContext producerContext);

    void onRequestFailure(com.facebook.imagepipeline.producers.ProducerContext producerContext, java.lang.Throwable th);

    void onRequestStart(com.facebook.imagepipeline.producers.ProducerContext producerContext);

    void onRequestSuccess(com.facebook.imagepipeline.producers.ProducerContext producerContext);
}
