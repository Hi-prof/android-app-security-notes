package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public class AddImageTransformMetaDataProducer implements com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> {
    private final com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> mInputProducer;

    public AddImageTransformMetaDataProducer(com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> producer) {
        this.mInputProducer = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(com.facebook.imagepipeline.producers.Consumer<com.facebook.imagepipeline.image.EncodedImage> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        this.mInputProducer.produceResults(new com.facebook.imagepipeline.producers.AddImageTransformMetaDataProducer.AddImageTransformMetaDataConsumer(consumer), producerContext);
    }

    private static class AddImageTransformMetaDataConsumer extends com.facebook.imagepipeline.producers.DelegatingConsumer<com.facebook.imagepipeline.image.EncodedImage, com.facebook.imagepipeline.image.EncodedImage> {
        private AddImageTransformMetaDataConsumer(com.facebook.imagepipeline.producers.Consumer<com.facebook.imagepipeline.image.EncodedImage> consumer) {
            super(consumer);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(@javax.annotation.Nullable com.facebook.imagepipeline.image.EncodedImage encodedImage, int i) {
            if (encodedImage == null) {
                getConsumer().onNewResult(null, i);
                return;
            }
            if (!com.facebook.imagepipeline.image.EncodedImage.isMetaDataAvailable(encodedImage)) {
                encodedImage.parseMetaData();
            }
            getConsumer().onNewResult(encodedImage, i);
        }
    }
}
