package com.facebook.imagepipeline.datasource;

/* JADX INFO: loaded from: classes.dex */
public class CloseableProducerToDataSourceAdapter<T> extends com.facebook.imagepipeline.datasource.AbstractProducerToDataSourceAdapter<com.facebook.common.references.CloseableReference<T>> {
    public static <T> com.facebook.datasource.DataSource<com.facebook.common.references.CloseableReference<T>> create(com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<T>> producer, com.facebook.imagepipeline.producers.SettableProducerContext settableProducerContext, com.facebook.imagepipeline.listener.RequestListener2 requestListener2) {
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("CloseableProducerToDataSourceAdapter#create");
        }
        com.facebook.imagepipeline.datasource.CloseableProducerToDataSourceAdapter closeableProducerToDataSourceAdapter = new com.facebook.imagepipeline.datasource.CloseableProducerToDataSourceAdapter(producer, settableProducerContext, requestListener2);
        if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
        }
        return closeableProducerToDataSourceAdapter;
    }

    private CloseableProducerToDataSourceAdapter(com.facebook.imagepipeline.producers.Producer<com.facebook.common.references.CloseableReference<T>> producer, com.facebook.imagepipeline.producers.SettableProducerContext settableProducerContext, com.facebook.imagepipeline.listener.RequestListener2 requestListener2) {
        super(producer, settableProducerContext, requestListener2);
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    @javax.annotation.Nullable
    public com.facebook.common.references.CloseableReference<T> getResult() {
        return com.facebook.common.references.CloseableReference.cloneOrNull((com.facebook.common.references.CloseableReference) super.getResult());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.datasource.AbstractDataSource
    public void closeResult(com.facebook.common.references.CloseableReference<T> closeableReference) {
        com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) closeableReference);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.datasource.AbstractProducerToDataSourceAdapter
    public void onNewResultImpl(com.facebook.common.references.CloseableReference<T> closeableReference, int i, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        super.onNewResultImpl(com.facebook.common.references.CloseableReference.cloneOrNull(closeableReference), i, producerContext);
    }
}
