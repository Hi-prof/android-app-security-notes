package com.facebook.imagepipeline.producers;

/* JADX INFO: compiled from: ThreadHandoffProducer.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u0012*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0012B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/facebook/imagepipeline/producers/ThreadHandoffProducer;", "T", "Lcom/facebook/imagepipeline/producers/Producer;", "inputProducer", "threadHandoffProducerQueue", "Lcom/facebook/imagepipeline/producers/ThreadHandoffProducerQueue;", "<init>", "(Lcom/facebook/imagepipeline/producers/Producer;Lcom/facebook/imagepipeline/producers/ThreadHandoffProducerQueue;)V", "getInputProducer", "()Lcom/facebook/imagepipeline/producers/Producer;", "getThreadHandoffProducerQueue", "()Lcom/facebook/imagepipeline/producers/ThreadHandoffProducerQueue;", "produceResults", "", "consumer", "Lcom/facebook/imagepipeline/producers/Consumer;", "context", "Lcom/facebook/imagepipeline/producers/ProducerContext;", "Companion", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ThreadHandoffProducer<T> implements com.facebook.imagepipeline.producers.Producer<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final com.facebook.imagepipeline.producers.ThreadHandoffProducer.Companion INSTANCE = new com.facebook.imagepipeline.producers.ThreadHandoffProducer.Companion(null);
    public static final java.lang.String PRODUCER_NAME = "BackgroundThreadHandoffProducer";
    private final com.facebook.imagepipeline.producers.Producer<T> inputProducer;
    private final com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue threadHandoffProducerQueue;

    public ThreadHandoffProducer(com.facebook.imagepipeline.producers.Producer<T> inputProducer, com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue threadHandoffProducerQueue) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(inputProducer, "inputProducer");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(threadHandoffProducerQueue, "threadHandoffProducerQueue");
        this.inputProducer = inputProducer;
        this.threadHandoffProducerQueue = threadHandoffProducerQueue;
    }

    public final com.facebook.imagepipeline.producers.Producer<T> getInputProducer() {
        return this.inputProducer;
    }

    public final com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue getThreadHandoffProducerQueue() {
        return this.threadHandoffProducerQueue;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(final com.facebook.imagepipeline.producers.Consumer<T> consumer, final com.facebook.imagepipeline.producers.ProducerContext context) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(consumer, "consumer");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        com.facebook.imagepipeline.systrace.FrescoSystrace frescoSystrace = com.facebook.imagepipeline.systrace.FrescoSystrace.INSTANCE;
        if (!com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            final com.facebook.imagepipeline.producers.ProducerListener2 producerListener = context.getProducerListener();
            com.facebook.imagepipeline.producers.ThreadHandoffProducer.Companion companion = INSTANCE;
            if (companion.shouldRunImmediately(context)) {
                producerListener.onProducerStart(context, PRODUCER_NAME);
                producerListener.onProducerFinishWithSuccess(context, PRODUCER_NAME, null);
                this.inputProducer.produceResults(consumer, context);
                return;
            } else {
                final com.facebook.imagepipeline.producers.StatefulProducerRunnable<T> statefulProducerRunnable = new com.facebook.imagepipeline.producers.StatefulProducerRunnable<T>(consumer, producerListener, context, this) { // from class: com.facebook.imagepipeline.producers.ThreadHandoffProducer$produceResults$1$statefulRunnable$1
                    final /* synthetic */ com.facebook.imagepipeline.producers.Consumer<T> $consumer;
                    final /* synthetic */ com.facebook.imagepipeline.producers.ProducerContext $context;
                    final /* synthetic */ com.facebook.imagepipeline.producers.ProducerListener2 $producerListener;
                    final /* synthetic */ com.facebook.imagepipeline.producers.ThreadHandoffProducer<T> this$0;

                    @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
                    protected void disposeResult(T ignored) {
                    }

                    @Override // com.facebook.common.executors.StatefulRunnable
                    protected T getResult() throws java.lang.Exception {
                        return null;
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(consumer, producerListener, context, com.facebook.imagepipeline.producers.ThreadHandoffProducer.PRODUCER_NAME);
                        this.$consumer = consumer;
                        this.$producerListener = producerListener;
                        this.$context = context;
                        this.this$0 = this;
                    }

                    @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
                    protected void onSuccess(T ignored) {
                        this.$producerListener.onProducerFinishWithSuccess(this.$context, com.facebook.imagepipeline.producers.ThreadHandoffProducer.PRODUCER_NAME, null);
                        this.this$0.getInputProducer().produceResults(this.$consumer, this.$context);
                    }
                };
                context.addCallbacks(new com.facebook.imagepipeline.producers.BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.ThreadHandoffProducer$produceResults$1$1
                    @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                    public void onCancellationRequested() {
                        statefulProducerRunnable.cancel();
                        this.getThreadHandoffProducerQueue().remove(statefulProducerRunnable);
                    }
                });
                this.threadHandoffProducerQueue.addToQueueOrExecute(com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.decorateRunnable(statefulProducerRunnable, companion.getInstrumentationTag(context)));
                return;
            }
        }
        com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("ThreadHandoffProducer#produceResults");
        try {
            final com.facebook.imagepipeline.producers.ProducerListener2 producerListener2 = context.getProducerListener();
            com.facebook.imagepipeline.producers.ThreadHandoffProducer.Companion companion2 = INSTANCE;
            if (companion2.shouldRunImmediately(context)) {
                producerListener2.onProducerStart(context, PRODUCER_NAME);
                producerListener2.onProducerFinishWithSuccess(context, PRODUCER_NAME, null);
                this.inputProducer.produceResults(consumer, context);
            } else {
                final com.facebook.imagepipeline.producers.StatefulProducerRunnable<T> statefulProducerRunnable2 = new com.facebook.imagepipeline.producers.StatefulProducerRunnable<T>(consumer, producerListener2, context, this) { // from class: com.facebook.imagepipeline.producers.ThreadHandoffProducer$produceResults$1$statefulRunnable$1
                    final /* synthetic */ com.facebook.imagepipeline.producers.Consumer<T> $consumer;
                    final /* synthetic */ com.facebook.imagepipeline.producers.ProducerContext $context;
                    final /* synthetic */ com.facebook.imagepipeline.producers.ProducerListener2 $producerListener;
                    final /* synthetic */ com.facebook.imagepipeline.producers.ThreadHandoffProducer<T> this$0;

                    @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
                    protected void disposeResult(T ignored) {
                    }

                    @Override // com.facebook.common.executors.StatefulRunnable
                    protected T getResult() throws java.lang.Exception {
                        return null;
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(consumer, producerListener2, context, com.facebook.imagepipeline.producers.ThreadHandoffProducer.PRODUCER_NAME);
                        this.$consumer = consumer;
                        this.$producerListener = producerListener2;
                        this.$context = context;
                        this.this$0 = this;
                    }

                    @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
                    protected void onSuccess(T ignored) {
                        this.$producerListener.onProducerFinishWithSuccess(this.$context, com.facebook.imagepipeline.producers.ThreadHandoffProducer.PRODUCER_NAME, null);
                        this.this$0.getInputProducer().produceResults(this.$consumer, this.$context);
                    }
                };
                context.addCallbacks(new com.facebook.imagepipeline.producers.BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.ThreadHandoffProducer$produceResults$1$1
                    @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                    public void onCancellationRequested() {
                        statefulProducerRunnable2.cancel();
                        this.getThreadHandoffProducerQueue().remove(statefulProducerRunnable2);
                    }
                });
                this.threadHandoffProducerQueue.addToQueueOrExecute(com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.decorateRunnable(statefulProducerRunnable2, companion2.getInstrumentationTag(context)));
                kotlin.Unit unit = kotlin.Unit.INSTANCE;
            }
        } finally {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
    }

    /* JADX INFO: compiled from: ThreadHandoffProducer.kt */
    @kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/facebook/imagepipeline/producers/ThreadHandoffProducer$Companion;", "", "<init>", "()V", "PRODUCER_NAME", "", "getInstrumentationTag", "context", "Lcom/facebook/imagepipeline/producers/ProducerContext;", "shouldRunImmediately", "", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final java.lang.String getInstrumentationTag(com.facebook.imagepipeline.producers.ProducerContext context) {
            if (!com.facebook.imagepipeline.instrumentation.FrescoInstrumenter.isTracing()) {
                return null;
            }
            return "ThreadHandoffProducer_produceResults_" + context.getId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean shouldRunImmediately(com.facebook.imagepipeline.producers.ProducerContext context) {
            return context.getImagePipelineConfig().getExperiments().getHandOffOnUiThreadOnly() && android.os.Looper.getMainLooper().getThread() != java.lang.Thread.currentThread();
        }
    }
}
