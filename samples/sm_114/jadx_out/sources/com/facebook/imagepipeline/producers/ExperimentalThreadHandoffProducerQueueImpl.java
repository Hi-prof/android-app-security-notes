package com.facebook.imagepipeline.producers;

/* JADX INFO: compiled from: ExperimentalThreadHandoffProducerQueueImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/facebook/imagepipeline/producers/ExperimentalThreadHandoffProducerQueueImpl;", "Lcom/facebook/imagepipeline/producers/ThreadHandoffProducerQueue;", "executor", "Ljava/util/concurrent/Executor;", "<init>", "(Ljava/util/concurrent/Executor;)V", "addToQueueOrExecute", "", "runnable", "Ljava/lang/Runnable;", "startQueueing", "stopQueuing", io.dcloud.common.constant.AbsoluteConst.XML_REMOVE, "isQueueing", "", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExperimentalThreadHandoffProducerQueueImpl implements com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue {
    private final java.util.concurrent.Executor executor;

    @Override // com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue
    public boolean isQueueing() {
        return false;
    }

    @Override // com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue
    public void remove(java.lang.Runnable runnable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(runnable, "runnable");
    }

    public ExperimentalThreadHandoffProducerQueueImpl(java.util.concurrent.Executor executor) {
        if (executor == null) {
            throw new java.lang.IllegalStateException("Required value was null.".toString());
        }
        this.executor = executor;
    }

    @Override // com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue
    public void addToQueueOrExecute(java.lang.Runnable runnable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.executor.execute(runnable);
    }

    @Override // com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue
    public void startQueueing() {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue
    public void stopQueuing() {
        throw new java.lang.UnsupportedOperationException();
    }
}
