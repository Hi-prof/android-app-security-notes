package com.facebook.imagepipeline.producers;

/* JADX INFO: compiled from: InternalProducerListener.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J$\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0016J4\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0018\u0010\u0014\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u0015H\u0016J>\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0018\u0010\u0014\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u0015H\u0016J4\u0010\u0019\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0018\u0010\u0014\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u0015H\u0016J\"\u0010\u001a\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/facebook/imagepipeline/producers/InternalProducerListener;", "Lcom/facebook/imagepipeline/producers/ProducerListener2;", "producerListener", "Lcom/facebook/imagepipeline/producers/ProducerListener;", "producerListener2", "<init>", "(Lcom/facebook/imagepipeline/producers/ProducerListener;Lcom/facebook/imagepipeline/producers/ProducerListener2;)V", "getProducerListener", "()Lcom/facebook/imagepipeline/producers/ProducerListener;", "getProducerListener2", "()Lcom/facebook/imagepipeline/producers/ProducerListener2;", "onProducerStart", "", "context", "Lcom/facebook/imagepipeline/producers/ProducerContext;", "producerName", "", "onProducerEvent", com.taobao.weex.WXGlobalEventReceiver.EVENT_NAME, "onProducerFinishWithSuccess", "extraMap", "", "onProducerFinishWithFailure", "t", "", "onProducerFinishWithCancellation", "onUltimateProducerReached", "successful", "", "requiresExtraMap", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class InternalProducerListener implements com.facebook.imagepipeline.producers.ProducerListener2 {
    private final com.facebook.imagepipeline.producers.ProducerListener producerListener;
    private final com.facebook.imagepipeline.producers.ProducerListener2 producerListener2;

    public InternalProducerListener(com.facebook.imagepipeline.producers.ProducerListener producerListener, com.facebook.imagepipeline.producers.ProducerListener2 producerListener2) {
        this.producerListener = producerListener;
        this.producerListener2 = producerListener2;
    }

    public final com.facebook.imagepipeline.producers.ProducerListener getProducerListener() {
        return this.producerListener;
    }

    public final com.facebook.imagepipeline.producers.ProducerListener2 getProducerListener2() {
        return this.producerListener2;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerStart(com.facebook.imagepipeline.producers.ProducerContext context, java.lang.String producerName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        com.facebook.imagepipeline.producers.ProducerListener producerListener = this.producerListener;
        if (producerListener != null) {
            producerListener.onProducerStart(context.getId(), producerName);
        }
        com.facebook.imagepipeline.producers.ProducerListener2 producerListener2 = this.producerListener2;
        if (producerListener2 != null) {
            producerListener2.onProducerStart(context, producerName);
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerEvent(com.facebook.imagepipeline.producers.ProducerContext context, java.lang.String producerName, java.lang.String eventName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        com.facebook.imagepipeline.producers.ProducerListener producerListener = this.producerListener;
        if (producerListener != null) {
            producerListener.onProducerEvent(context.getId(), producerName, eventName);
        }
        com.facebook.imagepipeline.producers.ProducerListener2 producerListener2 = this.producerListener2;
        if (producerListener2 != null) {
            producerListener2.onProducerEvent(context, producerName, eventName);
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerFinishWithSuccess(com.facebook.imagepipeline.producers.ProducerContext context, java.lang.String producerName, java.util.Map<java.lang.String, java.lang.String> extraMap) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        com.facebook.imagepipeline.producers.ProducerListener producerListener = this.producerListener;
        if (producerListener != null) {
            producerListener.onProducerFinishWithSuccess(context.getId(), producerName, extraMap);
        }
        com.facebook.imagepipeline.producers.ProducerListener2 producerListener2 = this.producerListener2;
        if (producerListener2 != null) {
            producerListener2.onProducerFinishWithSuccess(context, producerName, extraMap);
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerFinishWithFailure(com.facebook.imagepipeline.producers.ProducerContext context, java.lang.String producerName, java.lang.Throwable t, java.util.Map<java.lang.String, java.lang.String> extraMap) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        com.facebook.imagepipeline.producers.ProducerListener producerListener = this.producerListener;
        if (producerListener != null) {
            producerListener.onProducerFinishWithFailure(context.getId(), producerName, t, extraMap);
        }
        com.facebook.imagepipeline.producers.ProducerListener2 producerListener2 = this.producerListener2;
        if (producerListener2 != null) {
            producerListener2.onProducerFinishWithFailure(context, producerName, t, extraMap);
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerFinishWithCancellation(com.facebook.imagepipeline.producers.ProducerContext context, java.lang.String producerName, java.util.Map<java.lang.String, java.lang.String> extraMap) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        com.facebook.imagepipeline.producers.ProducerListener producerListener = this.producerListener;
        if (producerListener != null) {
            producerListener.onProducerFinishWithCancellation(context.getId(), producerName, extraMap);
        }
        com.facebook.imagepipeline.producers.ProducerListener2 producerListener2 = this.producerListener2;
        if (producerListener2 != null) {
            producerListener2.onProducerFinishWithCancellation(context, producerName, extraMap);
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onUltimateProducerReached(com.facebook.imagepipeline.producers.ProducerContext context, java.lang.String producerName, boolean successful) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        com.facebook.imagepipeline.producers.ProducerListener producerListener = this.producerListener;
        if (producerListener != null) {
            producerListener.onUltimateProducerReached(context.getId(), producerName, successful);
        }
        com.facebook.imagepipeline.producers.ProducerListener2 producerListener2 = this.producerListener2;
        if (producerListener2 != null) {
            producerListener2.onUltimateProducerReached(context, producerName, successful);
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public boolean requiresExtraMap(com.facebook.imagepipeline.producers.ProducerContext context, java.lang.String producerName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        com.facebook.imagepipeline.producers.ProducerListener producerListener = this.producerListener;
        java.lang.Boolean boolValueOf = producerListener != null ? java.lang.Boolean.valueOf(producerListener.requiresExtraMap(context.getId())) : null;
        if (!kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) boolValueOf, (java.lang.Object) true)) {
            com.facebook.imagepipeline.producers.ProducerListener2 producerListener2 = this.producerListener2;
            boolValueOf = producerListener2 != null ? java.lang.Boolean.valueOf(producerListener2.requiresExtraMap(context, producerName)) : null;
        }
        if (boolValueOf != null) {
            return boolValueOf.booleanValue();
        }
        return false;
    }
}
