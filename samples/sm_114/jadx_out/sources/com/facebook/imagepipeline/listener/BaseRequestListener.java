package com.facebook.imagepipeline.listener;

/* JADX INFO: compiled from: BaseRequestListener.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J(\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J \u0010\u0015\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000bH\u0016J.\u0010\u0017\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0019H\u0016J6\u0010\u001a\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00112\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0019H\u0016J.\u0010\u001c\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0019H\u0016J \u0010\u001d\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\rH\u0016J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006 "}, d2 = {"Lcom/facebook/imagepipeline/listener/BaseRequestListener;", "Lcom/facebook/imagepipeline/listener/RequestListener;", "<init>", "()V", "onRequestStart", "", io.dcloud.feature.uniapp.adapter.AbsURIAdapter.REQUEST, "Lcom/facebook/imagepipeline/request/ImageRequest;", "callerContext", "", "requestId", "", "isPrefetch", "", "onRequestSuccess", "onRequestFailure", "throwable", "", "onRequestCancellation", "onProducerStart", "producerName", "onProducerEvent", com.taobao.weex.WXGlobalEventReceiver.EVENT_NAME, "onProducerFinishWithSuccess", "extraMap", "", "onProducerFinishWithFailure", "t", "onProducerFinishWithCancellation", "onUltimateProducerReached", "successful", "requiresExtraMap", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class BaseRequestListener implements com.facebook.imagepipeline.listener.RequestListener {
    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerEvent(java.lang.String requestId, java.lang.String producerName, java.lang.String eventName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(requestId, "requestId");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerName, "producerName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(eventName, "eventName");
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerFinishWithCancellation(java.lang.String requestId, java.lang.String producerName, java.util.Map<java.lang.String, java.lang.String> extraMap) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(requestId, "requestId");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerName, "producerName");
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerFinishWithFailure(java.lang.String requestId, java.lang.String producerName, java.lang.Throwable t, java.util.Map<java.lang.String, java.lang.String> extraMap) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(requestId, "requestId");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerName, "producerName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(t, "t");
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerFinishWithSuccess(java.lang.String requestId, java.lang.String producerName, java.util.Map<java.lang.String, java.lang.String> extraMap) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(requestId, "requestId");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerName, "producerName");
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onProducerStart(java.lang.String requestId, java.lang.String producerName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(requestId, "requestId");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerName, "producerName");
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void onRequestCancellation(java.lang.String requestId) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(requestId, "requestId");
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void onRequestFailure(com.facebook.imagepipeline.request.ImageRequest request, java.lang.String requestId, java.lang.Throwable throwable, boolean isPrefetch) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(request, "request");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(requestId, "requestId");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(throwable, "throwable");
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void onRequestStart(com.facebook.imagepipeline.request.ImageRequest request, java.lang.Object callerContext, java.lang.String requestId, boolean isPrefetch) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(request, "request");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callerContext, "callerContext");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(requestId, "requestId");
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public void onRequestSuccess(com.facebook.imagepipeline.request.ImageRequest request, java.lang.String requestId, boolean isPrefetch) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(request, "request");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(requestId, "requestId");
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onUltimateProducerReached(java.lang.String requestId, java.lang.String producerName, boolean successful) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(requestId, "requestId");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerName, "producerName");
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public boolean requiresExtraMap(java.lang.String requestId) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(requestId, "requestId");
        return false;
    }
}
