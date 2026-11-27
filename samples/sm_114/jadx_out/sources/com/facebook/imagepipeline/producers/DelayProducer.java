package com.facebook.imagepipeline.producers;

/* JADX INFO: compiled from: DelayProducer.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B%\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ$\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/facebook/imagepipeline/producers/DelayProducer;", "Lcom/facebook/imagepipeline/producers/Producer;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "inputProducer", "backgroundTasksExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "<init>", "(Lcom/facebook/imagepipeline/producers/Producer;Ljava/util/concurrent/ScheduledExecutorService;)V", "produceResults", "", "consumer", "Lcom/facebook/imagepipeline/producers/Consumer;", "context", "Lcom/facebook/imagepipeline/producers/ProducerContext;", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DelayProducer implements com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> {
    private final java.util.concurrent.ScheduledExecutorService backgroundTasksExecutor;
    private final com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> inputProducer;

    public DelayProducer(com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> inputProducer, java.util.concurrent.ScheduledExecutorService scheduledExecutorService) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(inputProducer, "inputProducer");
        this.inputProducer = inputProducer;
        this.backgroundTasksExecutor = scheduledExecutorService;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(final com.facebook.imagepipeline.producers.Consumer<com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>> consumer, final com.facebook.imagepipeline.producers.ProducerContext context) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(consumer, "consumer");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        com.facebook.imagepipeline.request.ImageRequest imageRequest = context.getImageRequest();
        java.util.concurrent.ScheduledExecutorService scheduledExecutorService = this.backgroundTasksExecutor;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.schedule(new java.lang.Runnable() { // from class: com.facebook.imagepipeline.producers.DelayProducer$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    com.facebook.imagepipeline.producers.DelayProducer.produceResults$lambda$0(this.f$0, consumer, context);
                }
            }, imageRequest.getDelayMs(), java.util.concurrent.TimeUnit.MILLISECONDS);
        } else {
            this.inputProducer.produceResults(consumer, context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void produceResults$lambda$0(com.facebook.imagepipeline.producers.DelayProducer this$0, com.facebook.imagepipeline.producers.Consumer consumer, com.facebook.imagepipeline.producers.ProducerContext context) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this$0, "this$0");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(consumer, "$consumer");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "$context");
        this$0.inputProducer.produceResults(consumer, context);
    }
}
