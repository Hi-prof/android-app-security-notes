package com.facebook.imagepipeline.listener;

/* JADX INFO: loaded from: classes.dex */
public interface RequestListener extends com.facebook.imagepipeline.producers.ProducerListener {
    void onRequestCancellation(java.lang.String str);

    void onRequestFailure(com.facebook.imagepipeline.request.ImageRequest imageRequest, java.lang.String str, java.lang.Throwable th, boolean z);

    void onRequestStart(com.facebook.imagepipeline.request.ImageRequest imageRequest, java.lang.Object obj, java.lang.String str, boolean z);

    void onRequestSuccess(com.facebook.imagepipeline.request.ImageRequest imageRequest, java.lang.String str, boolean z);
}
