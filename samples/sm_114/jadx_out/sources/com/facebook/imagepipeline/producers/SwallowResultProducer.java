package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public class SwallowResultProducer<T> implements com.facebook.imagepipeline.producers.Producer<java.lang.Void> {
    private final com.facebook.imagepipeline.producers.Producer<T> mInputProducer;

    public SwallowResultProducer(com.facebook.imagepipeline.producers.Producer<T> producer) {
        this.mInputProducer = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(com.facebook.imagepipeline.producers.Consumer<java.lang.Void> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        this.mInputProducer.produceResults(new com.facebook.imagepipeline.producers.DelegatingConsumer<T, java.lang.Void>(consumer) { // from class: com.facebook.imagepipeline.producers.SwallowResultProducer.1
            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            protected void onNewResultImpl(@javax.annotation.Nullable T t, int i) {
                if (isLast(i)) {
                    getConsumer().onNewResult(null, i);
                }
            }
        }, producerContext);
    }
}
