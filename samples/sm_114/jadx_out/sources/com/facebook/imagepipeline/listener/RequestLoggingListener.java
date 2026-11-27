package com.facebook.imagepipeline.listener;

/* JADX INFO: compiled from: RequestLoggingListener.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\f\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J.\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0017H\u0016J6\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0017H\u0016J.\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0017H\u0016J \u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0016J \u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0012H\u0016J \u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J(\u0010!\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u0007H\u0016R(\u0010\u0004\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\b0\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/facebook/imagepipeline/listener/RequestLoggingListener;", "Lcom/facebook/imagepipeline/listener/RequestListener;", "<init>", "()V", "producerStartTimeMap", "", "Landroid/util/Pair;", "", "", "requestStartTimeMap", "onRequestStart", "", io.dcloud.feature.uniapp.adapter.AbsURIAdapter.REQUEST, "Lcom/facebook/imagepipeline/request/ImageRequest;", "callerContextObject", "", "requestId", "isPrefetch", "", "onProducerStart", "producerName", "onProducerFinishWithSuccess", "extraMap", "", "onProducerFinishWithFailure", "throwable", "", "onProducerFinishWithCancellation", "onProducerEvent", "producerEventName", "onUltimateProducerReached", "successful", "onRequestSuccess", "onRequestFailure", "onRequestCancellation", "requiresExtraMap", "id", "Companion", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RequestLoggingListener implements com.facebook.imagepipeline.listener.RequestListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final com.facebook.imagepipeline.listener.RequestLoggingListener.Companion INSTANCE = new com.facebook.imagepipeline.listener.RequestLoggingListener.Companion(null);
    private static final java.lang.String TAG = "RequestLoggingListener";
    private final java.util.Map<android.util.Pair<java.lang.String, java.lang.String>, java.lang.Long> producerStartTimeMap = new java.util.HashMap();
    private final java.util.Map<java.lang.String, java.lang.Long> requestStartTimeMap = new java.util.HashMap();

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public synchronized void onRequestStart(com.facebook.imagepipeline.request.ImageRequest request, java.lang.Object callerContextObject, java.lang.String requestId, boolean isPrefetch) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(request, "request");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callerContextObject, "callerContextObject");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(requestId, "requestId");
        if (com.facebook.common.logging.FLog.isLoggable(2)) {
            com.facebook.imagepipeline.listener.RequestLoggingListener.Companion companion = INSTANCE;
            com.facebook.common.logging.FLog.v(TAG, "time %d: onRequestSubmit: {requestId: %s, callerContext: %s, isPrefetch: %b}", java.lang.Long.valueOf(companion.getTime()), requestId, callerContextObject, java.lang.Boolean.valueOf(isPrefetch));
            this.requestStartTimeMap.put(requestId, java.lang.Long.valueOf(companion.getTime()));
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public synchronized void onProducerStart(java.lang.String requestId, java.lang.String producerName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(requestId, "requestId");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerName, "producerName");
        if (com.facebook.common.logging.FLog.isLoggable(2)) {
            android.util.Pair<java.lang.String, java.lang.String> pairCreate = android.util.Pair.create(requestId, producerName);
            long time = INSTANCE.getTime();
            this.producerStartTimeMap.put(pairCreate, java.lang.Long.valueOf(time));
            com.facebook.common.logging.FLog.v(TAG, "time %d: onProducerStart: {requestId: %s, producer: %s}", java.lang.Long.valueOf(time), requestId, producerName);
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public synchronized void onProducerFinishWithSuccess(java.lang.String requestId, java.lang.String producerName, java.util.Map<java.lang.String, java.lang.String> extraMap) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(requestId, "requestId");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerName, "producerName");
        if (com.facebook.common.logging.FLog.isLoggable(2)) {
            java.lang.Long lRemove = this.producerStartTimeMap.remove(android.util.Pair.create(requestId, producerName));
            com.facebook.imagepipeline.listener.RequestLoggingListener.Companion companion = INSTANCE;
            long time = companion.getTime();
            com.facebook.common.logging.FLog.v(TAG, "time %d: onProducerFinishWithSuccess: {requestId: %s, producer: %s, elapsedTime: %d ms, extraMap: %s}", java.lang.Long.valueOf(time), requestId, producerName, java.lang.Long.valueOf(companion.getElapsedTime(lRemove, time)), extraMap);
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public synchronized void onProducerFinishWithFailure(java.lang.String requestId, java.lang.String producerName, java.lang.Throwable throwable, java.util.Map<java.lang.String, java.lang.String> extraMap) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(requestId, "requestId");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerName, "producerName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(throwable, "throwable");
        if (com.facebook.common.logging.FLog.isLoggable(5)) {
            java.lang.Long lRemove = this.producerStartTimeMap.remove(android.util.Pair.create(requestId, producerName));
            com.facebook.imagepipeline.listener.RequestLoggingListener.Companion companion = INSTANCE;
            long time = companion.getTime();
            com.facebook.common.logging.FLog.w(TAG, throwable, "time %d: onProducerFinishWithFailure: {requestId: %s, stage: %s, elapsedTime: %d ms, extraMap: %s, throwable: %s}", java.lang.Long.valueOf(time), requestId, producerName, java.lang.Long.valueOf(companion.getElapsedTime(lRemove, time)), extraMap, throwable.toString());
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public synchronized void onProducerFinishWithCancellation(java.lang.String requestId, java.lang.String producerName, java.util.Map<java.lang.String, java.lang.String> extraMap) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(requestId, "requestId");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerName, "producerName");
        if (com.facebook.common.logging.FLog.isLoggable(2)) {
            java.lang.Long lRemove = this.producerStartTimeMap.remove(android.util.Pair.create(requestId, producerName));
            com.facebook.imagepipeline.listener.RequestLoggingListener.Companion companion = INSTANCE;
            long time = companion.getTime();
            com.facebook.common.logging.FLog.v(TAG, "time %d: onProducerFinishWithCancellation: {requestId: %s, stage: %s, elapsedTime: %d ms, extraMap: %s}", java.lang.Long.valueOf(time), requestId, producerName, java.lang.Long.valueOf(companion.getElapsedTime(lRemove, time)), extraMap);
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public synchronized void onProducerEvent(java.lang.String requestId, java.lang.String producerName, java.lang.String producerEventName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(requestId, "requestId");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerName, "producerName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerEventName, "producerEventName");
        if (com.facebook.common.logging.FLog.isLoggable(2)) {
            java.lang.Long l = this.producerStartTimeMap.get(android.util.Pair.create(requestId, producerName));
            com.facebook.imagepipeline.listener.RequestLoggingListener.Companion companion = INSTANCE;
            com.facebook.common.logging.FLog.v(TAG, "time %d: onProducerEvent: {requestId: %s, stage: %s, eventName: %s; elapsedTime: %d ms}", java.lang.Long.valueOf(companion.getTime()), requestId, producerName, producerEventName, java.lang.Long.valueOf(companion.getElapsedTime(l, companion.getTime())));
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public synchronized void onUltimateProducerReached(java.lang.String requestId, java.lang.String producerName, boolean successful) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(requestId, "requestId");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerName, "producerName");
        if (com.facebook.common.logging.FLog.isLoggable(2)) {
            java.lang.Long lRemove = this.producerStartTimeMap.remove(android.util.Pair.create(requestId, producerName));
            com.facebook.imagepipeline.listener.RequestLoggingListener.Companion companion = INSTANCE;
            long time = companion.getTime();
            com.facebook.common.logging.FLog.v(TAG, "time %d: onUltimateProducerReached: {requestId: %s, producer: %s, elapsedTime: %d ms, success: %b}", java.lang.Long.valueOf(time), requestId, producerName, java.lang.Long.valueOf(companion.getElapsedTime(lRemove, time)), java.lang.Boolean.valueOf(successful));
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public synchronized void onRequestSuccess(com.facebook.imagepipeline.request.ImageRequest request, java.lang.String requestId, boolean isPrefetch) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(request, "request");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(requestId, "requestId");
        if (com.facebook.common.logging.FLog.isLoggable(2)) {
            java.lang.Long lRemove = this.requestStartTimeMap.remove(requestId);
            com.facebook.imagepipeline.listener.RequestLoggingListener.Companion companion = INSTANCE;
            long time = companion.getTime();
            com.facebook.common.logging.FLog.v(TAG, "time %d: onRequestSuccess: {requestId: %s, elapsedTime: %d ms}", java.lang.Long.valueOf(time), requestId, java.lang.Long.valueOf(companion.getElapsedTime(lRemove, time)));
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public synchronized void onRequestFailure(com.facebook.imagepipeline.request.ImageRequest request, java.lang.String requestId, java.lang.Throwable throwable, boolean isPrefetch) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(request, "request");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(requestId, "requestId");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(throwable, "throwable");
        if (com.facebook.common.logging.FLog.isLoggable(5)) {
            java.lang.Long lRemove = this.requestStartTimeMap.remove(requestId);
            com.facebook.imagepipeline.listener.RequestLoggingListener.Companion companion = INSTANCE;
            long time = companion.getTime();
            com.facebook.common.logging.FLog.w(TAG, "time %d: onRequestFailure: {requestId: %s, elapsedTime: %d ms, throwable: %s}", java.lang.Long.valueOf(time), requestId, java.lang.Long.valueOf(companion.getElapsedTime(lRemove, time)), throwable.toString());
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public synchronized void onRequestCancellation(java.lang.String requestId) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(requestId, "requestId");
        if (com.facebook.common.logging.FLog.isLoggable(2)) {
            java.lang.Long lRemove = this.requestStartTimeMap.remove(requestId);
            com.facebook.imagepipeline.listener.RequestLoggingListener.Companion companion = INSTANCE;
            long time = companion.getTime();
            com.facebook.common.logging.FLog.v(TAG, "time %d: onRequestCancellation: {requestId: %s, elapsedTime: %d ms}", java.lang.Long.valueOf(time), requestId, java.lang.Long.valueOf(companion.getElapsedTime(lRemove, time)));
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public boolean requiresExtraMap(java.lang.String id) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(id, "id");
        return com.facebook.common.logging.FLog.isLoggable(2);
    }

    /* JADX INFO: compiled from: RequestLoggingListener.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/facebook/imagepipeline/listener/RequestLoggingListener$Companion;", "", "<init>", "()V", "TAG", "", "getElapsedTime", "", "startTime", "endTime", "(Ljava/lang/Long;J)J", com.taobao.weex.common.Constants.Value.TIME, "getTime", "()J", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final long getElapsedTime(java.lang.Long startTime, long endTime) {
            if (startTime != null) {
                return endTime - startTime.longValue();
            }
            return -1L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final long getTime() {
            return android.os.SystemClock.uptimeMillis();
        }
    }
}
