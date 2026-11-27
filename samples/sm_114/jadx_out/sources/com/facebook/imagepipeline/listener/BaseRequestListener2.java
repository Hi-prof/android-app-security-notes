package com.facebook.imagepipeline.listener;

/* JADX INFO: compiled from: BaseRequestListener2.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J.\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0014H\u0016J8\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0014H\u0016J.\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0014H\u0016J \u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u001c"}, d2 = {"Lcom/facebook/imagepipeline/listener/BaseRequestListener2;", "Lcom/facebook/imagepipeline/listener/RequestListener2;", "<init>", "()V", "onRequestStart", "", "producerContext", "Lcom/facebook/imagepipeline/producers/ProducerContext;", "onRequestSuccess", "onRequestFailure", "throwable", "", "onRequestCancellation", "onProducerStart", "producerName", "", "onProducerEvent", com.taobao.weex.WXGlobalEventReceiver.EVENT_NAME, "onProducerFinishWithSuccess", "extraMap", "", "onProducerFinishWithFailure", "t", "onProducerFinishWithCancellation", "onUltimateProducerReached", "successful", "", "requiresExtraMap", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class BaseRequestListener2 implements com.facebook.imagepipeline.listener.RequestListener2 {
    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerEvent(com.facebook.imagepipeline.producers.ProducerContext producerContext, java.lang.String producerName, java.lang.String eventName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerName, "producerName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(eventName, "eventName");
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerFinishWithCancellation(com.facebook.imagepipeline.producers.ProducerContext producerContext, java.lang.String producerName, java.util.Map<java.lang.String, java.lang.String> extraMap) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerName, "producerName");
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerFinishWithFailure(com.facebook.imagepipeline.producers.ProducerContext producerContext, java.lang.String producerName, java.lang.Throwable t, java.util.Map<java.lang.String, java.lang.String> extraMap) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerName, "producerName");
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerFinishWithSuccess(com.facebook.imagepipeline.producers.ProducerContext producerContext, java.lang.String producerName, java.util.Map<java.lang.String, java.lang.String> extraMap) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerName, "producerName");
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerStart(com.facebook.imagepipeline.producers.ProducerContext producerContext, java.lang.String producerName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerName, "producerName");
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public void onRequestCancellation(com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerContext, "producerContext");
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public void onRequestFailure(com.facebook.imagepipeline.producers.ProducerContext producerContext, java.lang.Throwable throwable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerContext, "producerContext");
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public void onRequestStart(com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerContext, "producerContext");
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public void onRequestSuccess(com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerContext, "producerContext");
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onUltimateProducerReached(com.facebook.imagepipeline.producers.ProducerContext producerContext, java.lang.String producerName, boolean successful) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerName, "producerName");
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public boolean requiresExtraMap(com.facebook.imagepipeline.producers.ProducerContext producerContext, java.lang.String producerName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerName, "producerName");
        return false;
    }
}
