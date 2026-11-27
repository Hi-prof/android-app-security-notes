package com.facebook.imagepipeline.listener;

/* JADX INFO: compiled from: ForwardingRequestListener2.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(B\u001b\b\u0016\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B!\b\u0016\u0012\u0016\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0006\"\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0001J%\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b0\u0011H\u0082\bJ\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J2\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0019H\u0016J<\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0019H\u0016J2\u0010\u001d\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0019H\u0016J \u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000fH\u0016J \u0010 \u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010$\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u001cH\u0016J\u0010\u0010&\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010'\u001a\u00020\"2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000fH\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/facebook/imagepipeline/listener/ForwardingRequestListener2;", "Lcom/facebook/imagepipeline/listener/RequestListener2;", "listenersToAdd", "", "<init>", "(Ljava/util/Set;)V", "", "([Lcom/facebook/imagepipeline/listener/RequestListener2;)V", "requestListeners", "", "addRequestListener", "", "requestListener", "forEachListener", "methodName", "", io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_BLOCK, "Lkotlin/Function1;", "onRequestStart", "producerContext", "Lcom/facebook/imagepipeline/producers/ProducerContext;", "onProducerStart", "producerName", "onProducerFinishWithSuccess", "extraMap", "", "onProducerFinishWithFailure", "t", "", "onProducerFinishWithCancellation", "onProducerEvent", "producerEventName", "onUltimateProducerReached", "successful", "", "onRequestSuccess", "onRequestFailure", "throwable", "onRequestCancellation", "requiresExtraMap", "Companion", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ForwardingRequestListener2 implements com.facebook.imagepipeline.listener.RequestListener2 {
    private static final java.lang.String TAG = "ForwardingRequestListener2";
    private final java.util.List<com.facebook.imagepipeline.listener.RequestListener2> requestListeners;

    public ForwardingRequestListener2(java.util.Set<? extends com.facebook.imagepipeline.listener.RequestListener2> set) {
        if (set == null) {
            this.requestListeners = new java.util.ArrayList();
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(set.size());
        this.requestListeners = arrayList;
        kotlin.collections.CollectionsKt.filterNotNullTo(set, arrayList);
    }

    public ForwardingRequestListener2(com.facebook.imagepipeline.listener.RequestListener2... listenersToAdd) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listenersToAdd, "listenersToAdd");
        java.util.ArrayList arrayList = new java.util.ArrayList(listenersToAdd.length);
        this.requestListeners = arrayList;
        kotlin.collections.ArraysKt.filterNotNullTo(listenersToAdd, arrayList);
    }

    public final void addRequestListener(com.facebook.imagepipeline.listener.RequestListener2 requestListener) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(requestListener, "requestListener");
        this.requestListeners.add(requestListener);
    }

    private final void forEachListener(java.lang.String methodName, kotlin.jvm.functions.Function1<? super com.facebook.imagepipeline.listener.RequestListener2, kotlin.Unit> block) {
        java.util.Iterator<T> it = this.requestListeners.iterator();
        while (it.hasNext()) {
            try {
                block.invoke2((com.facebook.imagepipeline.listener.RequestListener2) it.next());
            } catch (java.lang.Exception e) {
                com.facebook.common.logging.FLog.e(TAG, "InternalListener exception in " + methodName, e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public boolean requiresExtraMap(com.facebook.imagepipeline.producers.ProducerContext producerContext, java.lang.String producerName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerName, "producerName");
        java.util.List<com.facebook.imagepipeline.listener.RequestListener2> list = this.requestListeners;
        if ((list instanceof java.util.Collection) && list.isEmpty()) {
            return false;
        }
        java.util.Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((com.facebook.imagepipeline.listener.RequestListener2) it.next()).requiresExtraMap(producerContext, producerName)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public void onRequestStart(com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        java.util.Iterator<T> it = this.requestListeners.iterator();
        while (it.hasNext()) {
            try {
                ((com.facebook.imagepipeline.listener.RequestListener2) it.next()).onRequestStart(producerContext);
            } catch (java.lang.Exception e) {
                com.facebook.common.logging.FLog.e(TAG, "InternalListener exception in onRequestStart", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerStart(com.facebook.imagepipeline.producers.ProducerContext producerContext, java.lang.String producerName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerName, "producerName");
        java.util.Iterator<T> it = this.requestListeners.iterator();
        while (it.hasNext()) {
            try {
                ((com.facebook.imagepipeline.listener.RequestListener2) it.next()).onProducerStart(producerContext, producerName);
            } catch (java.lang.Exception e) {
                com.facebook.common.logging.FLog.e(TAG, "InternalListener exception in onProducerStart", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerFinishWithSuccess(com.facebook.imagepipeline.producers.ProducerContext producerContext, java.lang.String producerName, java.util.Map<java.lang.String, java.lang.String> extraMap) {
        java.util.Iterator<T> it = this.requestListeners.iterator();
        while (it.hasNext()) {
            try {
                ((com.facebook.imagepipeline.listener.RequestListener2) it.next()).onProducerFinishWithSuccess(producerContext, producerName, extraMap);
            } catch (java.lang.Exception e) {
                com.facebook.common.logging.FLog.e(TAG, "InternalListener exception in onProducerFinishWithSuccess", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerFinishWithFailure(com.facebook.imagepipeline.producers.ProducerContext producerContext, java.lang.String producerName, java.lang.Throwable t, java.util.Map<java.lang.String, java.lang.String> extraMap) {
        java.util.Iterator<T> it = this.requestListeners.iterator();
        while (it.hasNext()) {
            try {
                ((com.facebook.imagepipeline.listener.RequestListener2) it.next()).onProducerFinishWithFailure(producerContext, producerName, t, extraMap);
            } catch (java.lang.Exception e) {
                com.facebook.common.logging.FLog.e(TAG, "InternalListener exception in onProducerFinishWithFailure", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerFinishWithCancellation(com.facebook.imagepipeline.producers.ProducerContext producerContext, java.lang.String producerName, java.util.Map<java.lang.String, java.lang.String> extraMap) {
        java.util.Iterator<T> it = this.requestListeners.iterator();
        while (it.hasNext()) {
            try {
                ((com.facebook.imagepipeline.listener.RequestListener2) it.next()).onProducerFinishWithCancellation(producerContext, producerName, extraMap);
            } catch (java.lang.Exception e) {
                com.facebook.common.logging.FLog.e(TAG, "InternalListener exception in onProducerFinishWithCancellation", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onProducerEvent(com.facebook.imagepipeline.producers.ProducerContext producerContext, java.lang.String producerName, java.lang.String producerEventName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerName, "producerName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerEventName, "producerEventName");
        java.util.Iterator<T> it = this.requestListeners.iterator();
        while (it.hasNext()) {
            try {
                ((com.facebook.imagepipeline.listener.RequestListener2) it.next()).onProducerEvent(producerContext, producerName, producerEventName);
            } catch (java.lang.Exception e) {
                com.facebook.common.logging.FLog.e(TAG, "InternalListener exception in onIntermediateChunkStart", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public void onUltimateProducerReached(com.facebook.imagepipeline.producers.ProducerContext producerContext, java.lang.String producerName, boolean successful) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerName, "producerName");
        java.util.Iterator<T> it = this.requestListeners.iterator();
        while (it.hasNext()) {
            try {
                ((com.facebook.imagepipeline.listener.RequestListener2) it.next()).onUltimateProducerReached(producerContext, producerName, successful);
            } catch (java.lang.Exception e) {
                com.facebook.common.logging.FLog.e(TAG, "InternalListener exception in onProducerFinishWithSuccess", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public void onRequestSuccess(com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        java.util.Iterator<T> it = this.requestListeners.iterator();
        while (it.hasNext()) {
            try {
                ((com.facebook.imagepipeline.listener.RequestListener2) it.next()).onRequestSuccess(producerContext);
            } catch (java.lang.Exception e) {
                com.facebook.common.logging.FLog.e(TAG, "InternalListener exception in onRequestSuccess", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public void onRequestFailure(com.facebook.imagepipeline.producers.ProducerContext producerContext, java.lang.Throwable throwable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(throwable, "throwable");
        java.util.Iterator<T> it = this.requestListeners.iterator();
        while (it.hasNext()) {
            try {
                ((com.facebook.imagepipeline.listener.RequestListener2) it.next()).onRequestFailure(producerContext, throwable);
            } catch (java.lang.Exception e) {
                com.facebook.common.logging.FLog.e(TAG, "InternalListener exception in onRequestFailure", e);
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public void onRequestCancellation(com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        java.util.Iterator<T> it = this.requestListeners.iterator();
        while (it.hasNext()) {
            try {
                ((com.facebook.imagepipeline.listener.RequestListener2) it.next()).onRequestCancellation(producerContext);
            } catch (java.lang.Exception e) {
                com.facebook.common.logging.FLog.e(TAG, "InternalListener exception in onRequestCancellation", e);
            }
        }
    }
}
