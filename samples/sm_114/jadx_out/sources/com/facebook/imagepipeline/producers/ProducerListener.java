package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public interface ProducerListener {
    void onProducerEvent(java.lang.String str, java.lang.String str2, java.lang.String str3);

    void onProducerFinishWithCancellation(java.lang.String str, java.lang.String str2, @javax.annotation.Nullable java.util.Map<java.lang.String, java.lang.String> map);

    void onProducerFinishWithFailure(java.lang.String str, java.lang.String str2, java.lang.Throwable th, @javax.annotation.Nullable java.util.Map<java.lang.String, java.lang.String> map);

    void onProducerFinishWithSuccess(java.lang.String str, java.lang.String str2, @javax.annotation.Nullable java.util.Map<java.lang.String, java.lang.String> map);

    void onProducerStart(java.lang.String str, java.lang.String str2);

    void onUltimateProducerReached(java.lang.String str, java.lang.String str2, boolean z);

    boolean requiresExtraMap(java.lang.String str);
}
