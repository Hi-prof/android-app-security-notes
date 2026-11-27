package com.facebook.imagepipeline.core;

/* JADX INFO: compiled from: DefaultExecutorSupplier.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/facebook/imagepipeline/core/DefaultExecutorSupplier;", "Lcom/facebook/imagepipeline/core/ExecutorSupplier;", "numCpuBoundThreads", "", "<init>", "(I)V", "ioBoundExecutor", "Ljava/util/concurrent/Executor;", "decodeExecutor", "backgroundExecutor", "lightWeightBackgroundExecutor", "backgroundScheduledExecutorService", "Ljava/util/concurrent/ScheduledExecutorService;", "forLocalStorageRead", "forLocalStorageWrite", "forDecode", "forBackgroundTasks", "scheduledExecutorServiceForBackgroundTasks", "forLightweightBackgroundTasks", "forThumbnailProducer", "Companion", "imagepipeline-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultExecutorSupplier implements com.facebook.imagepipeline.core.ExecutorSupplier {
    private static final int NUM_IO_BOUND_THREADS = 2;
    private static final int NUM_LIGHTWEIGHT_BACKGROUND_THREADS = 1;
    private final java.util.concurrent.Executor backgroundExecutor;
    private final java.util.concurrent.ScheduledExecutorService backgroundScheduledExecutorService;
    private final java.util.concurrent.Executor decodeExecutor;
    private final java.util.concurrent.Executor ioBoundExecutor;
    private final java.util.concurrent.Executor lightWeightBackgroundExecutor;

    public DefaultExecutorSupplier(int i) {
        java.util.concurrent.ExecutorService executorServiceNewFixedThreadPool = java.util.concurrent.Executors.newFixedThreadPool(2, new com.facebook.imagepipeline.core.PriorityThreadFactory(10, "FrescoIoBoundExecutor", true));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(executorServiceNewFixedThreadPool, "newFixedThreadPool(...)");
        this.ioBoundExecutor = executorServiceNewFixedThreadPool;
        java.util.concurrent.ExecutorService executorServiceNewFixedThreadPool2 = java.util.concurrent.Executors.newFixedThreadPool(i, new com.facebook.imagepipeline.core.PriorityThreadFactory(10, "FrescoDecodeExecutor", true));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(executorServiceNewFixedThreadPool2, "newFixedThreadPool(...)");
        this.decodeExecutor = executorServiceNewFixedThreadPool2;
        java.util.concurrent.ExecutorService executorServiceNewFixedThreadPool3 = java.util.concurrent.Executors.newFixedThreadPool(i, new com.facebook.imagepipeline.core.PriorityThreadFactory(10, "FrescoBackgroundExecutor", true));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(executorServiceNewFixedThreadPool3, "newFixedThreadPool(...)");
        this.backgroundExecutor = executorServiceNewFixedThreadPool3;
        java.util.concurrent.ExecutorService executorServiceNewFixedThreadPool4 = java.util.concurrent.Executors.newFixedThreadPool(1, new com.facebook.imagepipeline.core.PriorityThreadFactory(10, "FrescoLightWeightBackgroundExecutor", true));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(executorServiceNewFixedThreadPool4, "newFixedThreadPool(...)");
        this.lightWeightBackgroundExecutor = executorServiceNewFixedThreadPool4;
        java.util.concurrent.ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = java.util.concurrent.Executors.newScheduledThreadPool(i, new com.facebook.imagepipeline.core.PriorityThreadFactory(10, "FrescoBackgroundExecutor", true));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(scheduledExecutorServiceNewScheduledThreadPool, "newScheduledThreadPool(...)");
        this.backgroundScheduledExecutorService = scheduledExecutorServiceNewScheduledThreadPool;
    }

    @Override // com.facebook.imagepipeline.core.ExecutorSupplier
    /* JADX INFO: renamed from: forLocalStorageRead, reason: from getter */
    public java.util.concurrent.Executor getIoBoundExecutor() {
        return this.ioBoundExecutor;
    }

    @Override // com.facebook.imagepipeline.core.ExecutorSupplier
    public java.util.concurrent.Executor forLocalStorageWrite() {
        return this.ioBoundExecutor;
    }

    @Override // com.facebook.imagepipeline.core.ExecutorSupplier
    /* JADX INFO: renamed from: forDecode, reason: from getter */
    public java.util.concurrent.Executor getDecodeExecutor() {
        return this.decodeExecutor;
    }

    @Override // com.facebook.imagepipeline.core.ExecutorSupplier
    /* JADX INFO: renamed from: forBackgroundTasks, reason: from getter */
    public java.util.concurrent.Executor getBackgroundExecutor() {
        return this.backgroundExecutor;
    }

    @Override // com.facebook.imagepipeline.core.ExecutorSupplier
    /* JADX INFO: renamed from: scheduledExecutorServiceForBackgroundTasks, reason: from getter */
    public java.util.concurrent.ScheduledExecutorService getBackgroundScheduledExecutorService() {
        return this.backgroundScheduledExecutorService;
    }

    @Override // com.facebook.imagepipeline.core.ExecutorSupplier
    /* JADX INFO: renamed from: forLightweightBackgroundTasks, reason: from getter */
    public java.util.concurrent.Executor getLightWeightBackgroundExecutor() {
        return this.lightWeightBackgroundExecutor;
    }

    @Override // com.facebook.imagepipeline.core.ExecutorSupplier
    public java.util.concurrent.Executor forThumbnailProducer() {
        return this.ioBoundExecutor;
    }
}
