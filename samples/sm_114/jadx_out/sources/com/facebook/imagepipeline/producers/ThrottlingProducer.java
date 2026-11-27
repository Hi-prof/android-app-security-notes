package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public class ThrottlingProducer<T> implements com.facebook.imagepipeline.producers.Producer<T> {
    public static final java.lang.String PRODUCER_NAME = "ThrottlingProducer";
    private final java.util.concurrent.Executor mExecutor;
    private final com.facebook.imagepipeline.producers.Producer<T> mInputProducer;
    private final int mMaxSimultaneousRequests;
    private final java.util.concurrent.ConcurrentLinkedQueue<android.util.Pair<com.facebook.imagepipeline.producers.Consumer<T>, com.facebook.imagepipeline.producers.ProducerContext>> mPendingRequests = new java.util.concurrent.ConcurrentLinkedQueue<>();
    private int mNumCurrentRequests = 0;

    public ThrottlingProducer(int i, java.util.concurrent.Executor executor, com.facebook.imagepipeline.producers.Producer<T> producer) {
        this.mMaxSimultaneousRequests = i;
        this.mExecutor = (java.util.concurrent.Executor) com.facebook.common.internal.Preconditions.checkNotNull(executor);
        this.mInputProducer = (com.facebook.imagepipeline.producers.Producer) com.facebook.common.internal.Preconditions.checkNotNull(producer);
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(com.facebook.imagepipeline.producers.Consumer<T> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        boolean z;
        producerContext.getProducerListener().onProducerStart(producerContext, PRODUCER_NAME);
        synchronized (this) {
            int i = this.mNumCurrentRequests;
            z = true;
            if (i >= this.mMaxSimultaneousRequests) {
                this.mPendingRequests.add(android.util.Pair.create(consumer, producerContext));
            } else {
                this.mNumCurrentRequests = i + 1;
                z = false;
            }
        }
        if (z) {
            return;
        }
        produceResultsInternal(consumer, producerContext);
    }

    void produceResultsInternal(com.facebook.imagepipeline.producers.Consumer<T> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        producerContext.getProducerListener().onProducerFinishWithSuccess(producerContext, PRODUCER_NAME, null);
        this.mInputProducer.produceResults(new com.facebook.imagepipeline.producers.ThrottlingProducer.ThrottlerConsumer(consumer), producerContext);
    }

    private class ThrottlerConsumer extends com.facebook.imagepipeline.producers.DelegatingConsumer<T, T> {
        private ThrottlerConsumer(com.facebook.imagepipeline.producers.Consumer<T> consumer) {
            super(consumer);
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        protected void onNewResultImpl(@javax.annotation.Nullable T t, int i) {
            getConsumer().onNewResult(t, i);
            if (isLast(i)) {
                onRequestFinished();
            }
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        protected void onFailureImpl(java.lang.Throwable th) {
            getConsumer().onFailure(th);
            onRequestFinished();
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        protected void onCancellationImpl() {
            getConsumer().onCancellation();
            onRequestFinished();
        }

        private void onRequestFinished() {
            final android.util.Pair pair;
            synchronized (com.facebook.imagepipeline.producers.ThrottlingProducer.this) {
                pair = (android.util.Pair) com.facebook.imagepipeline.producers.ThrottlingProducer.this.mPendingRequests.poll();
                if (pair == null) {
                    com.facebook.imagepipeline.producers.ThrottlingProducer.this.mNumCurrentRequests--;
                }
            }
            if (pair != null) {
                com.facebook.imagepipeline.producers.ThrottlingProducer.this.mExecutor.execute(new java.lang.Runnable() { // from class: com.facebook.imagepipeline.producers.ThrottlingProducer.ThrottlerConsumer.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.facebook.imagepipeline.producers.ThrottlingProducer.this.produceResultsInternal((com.facebook.imagepipeline.producers.Consumer) pair.first, (com.facebook.imagepipeline.producers.ProducerContext) pair.second);
                    }
                });
            }
        }
    }
}
