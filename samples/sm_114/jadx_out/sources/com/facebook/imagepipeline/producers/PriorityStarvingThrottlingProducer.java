package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public class PriorityStarvingThrottlingProducer<T> implements com.facebook.imagepipeline.producers.Producer<T> {
    public static final java.lang.String PRODUCER_NAME = "PriorityStarvingThrottlingProducer";
    private final java.util.concurrent.Executor mExecutor;
    private final com.facebook.imagepipeline.producers.Producer<T> mInputProducer;
    private final int mMaxSimultaneousRequests;
    private final java.util.Queue<com.facebook.imagepipeline.producers.PriorityStarvingThrottlingProducer.Item<T>> mPendingRequests = new java.util.PriorityQueue(11, new com.facebook.imagepipeline.producers.PriorityStarvingThrottlingProducer.PriorityComparator());
    private int mNumCurrentRequests = 0;

    public PriorityStarvingThrottlingProducer(int i, java.util.concurrent.Executor executor, com.facebook.imagepipeline.producers.Producer<T> producer) {
        this.mMaxSimultaneousRequests = i;
        this.mExecutor = (java.util.concurrent.Executor) com.facebook.common.internal.Preconditions.checkNotNull(executor);
        this.mInputProducer = (com.facebook.imagepipeline.producers.Producer) com.facebook.common.internal.Preconditions.checkNotNull(producer);
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(com.facebook.imagepipeline.producers.Consumer<T> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        boolean z;
        long jNanoTime = java.lang.System.nanoTime();
        producerContext.getProducerListener().onProducerStart(producerContext, PRODUCER_NAME);
        synchronized (this) {
            int i = this.mNumCurrentRequests;
            z = true;
            if (i >= this.mMaxSimultaneousRequests) {
                this.mPendingRequests.add(new com.facebook.imagepipeline.producers.PriorityStarvingThrottlingProducer.Item<>(consumer, producerContext, jNanoTime));
            } else {
                this.mNumCurrentRequests = i + 1;
                z = false;
            }
        }
        if (z) {
            return;
        }
        produceResultsInternal(new com.facebook.imagepipeline.producers.PriorityStarvingThrottlingProducer.Item<>(consumer, producerContext, jNanoTime));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void produceResultsInternal(com.facebook.imagepipeline.producers.PriorityStarvingThrottlingProducer.Item<T> item) {
        item.producerContext.getProducerListener().onProducerFinishWithSuccess(item.producerContext, PRODUCER_NAME, null);
        this.mInputProducer.produceResults(new com.facebook.imagepipeline.producers.PriorityStarvingThrottlingProducer.ThrottlerConsumer(item.consumer), item.producerContext);
    }

    static class Item<T> {
        final com.facebook.imagepipeline.producers.Consumer<T> consumer;
        final com.facebook.imagepipeline.producers.ProducerContext producerContext;
        final long time;

        Item(com.facebook.imagepipeline.producers.Consumer<T> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext, long j) {
            this.consumer = consumer;
            this.producerContext = producerContext;
            this.time = j;
        }
    }

    static class PriorityComparator<T> implements java.util.Comparator<com.facebook.imagepipeline.producers.PriorityStarvingThrottlingProducer.Item<T>> {
        PriorityComparator() {
        }

        @Override // java.util.Comparator
        public int compare(com.facebook.imagepipeline.producers.PriorityStarvingThrottlingProducer.Item<T> item, com.facebook.imagepipeline.producers.PriorityStarvingThrottlingProducer.Item<T> item2) {
            com.facebook.imagepipeline.common.Priority priority = item.producerContext.getPriority();
            com.facebook.imagepipeline.common.Priority priority2 = item2.producerContext.getPriority();
            if (priority == priority2) {
                return java.lang.Double.compare(item.time, item2.time);
            }
            return priority.ordinal() > priority2.ordinal() ? -1 : 1;
        }
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
            final com.facebook.imagepipeline.producers.PriorityStarvingThrottlingProducer.Item item;
            synchronized (com.facebook.imagepipeline.producers.PriorityStarvingThrottlingProducer.this) {
                item = (com.facebook.imagepipeline.producers.PriorityStarvingThrottlingProducer.Item) com.facebook.imagepipeline.producers.PriorityStarvingThrottlingProducer.this.mPendingRequests.poll();
                if (item == null) {
                    com.facebook.imagepipeline.producers.PriorityStarvingThrottlingProducer.this.mNumCurrentRequests--;
                }
            }
            if (item != null) {
                com.facebook.imagepipeline.producers.PriorityStarvingThrottlingProducer.this.mExecutor.execute(new java.lang.Runnable() { // from class: com.facebook.imagepipeline.producers.PriorityStarvingThrottlingProducer.ThrottlerConsumer.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.facebook.imagepipeline.producers.PriorityStarvingThrottlingProducer.this.produceResultsInternal(item);
                    }
                });
            }
        }
    }
}
