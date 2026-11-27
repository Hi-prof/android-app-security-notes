package com.facebook.imagepipeline.datasource;

/* JADX INFO: compiled from: AbstractProducerToDataSourceAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B'\b\u0004\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0002J'\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0014¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0004J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u0013H\u0002J\b\u0010&\u001a\u00020'H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\"\u001a\u0004\u0018\u00010#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/facebook/imagepipeline/datasource/AbstractProducerToDataSourceAdapter;", "T", "Lcom/facebook/datasource/AbstractDataSource;", "Lcom/facebook/imagepipeline/request/HasImageRequest;", "producer", "Lcom/facebook/imagepipeline/producers/Producer;", "settableProducerContext", "Lcom/facebook/imagepipeline/producers/SettableProducerContext;", "requestListener", "Lcom/facebook/imagepipeline/listener/RequestListener2;", "<init>", "(Lcom/facebook/imagepipeline/producers/Producer;Lcom/facebook/imagepipeline/producers/SettableProducerContext;Lcom/facebook/imagepipeline/listener/RequestListener2;)V", "getSettableProducerContext", "()Lcom/facebook/imagepipeline/producers/SettableProducerContext;", "getRequestListener", "()Lcom/facebook/imagepipeline/listener/RequestListener2;", "createConsumer", "Lcom/facebook/imagepipeline/producers/Consumer;", "onNewResultImpl", "", "result", "status", "", "producerContext", "Lcom/facebook/imagepipeline/producers/ProducerContext;", "(Ljava/lang/Object;ILcom/facebook/imagepipeline/producers/ProducerContext;)V", "getExtras", "", "", "", "onFailureImpl", "throwable", "", "onCancellationImpl", "imageRequest", "Lcom/facebook/imagepipeline/request/ImageRequest;", "getImageRequest", "()Lcom/facebook/imagepipeline/request/ImageRequest;", io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE, "", "imagepipeline_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbstractProducerToDataSourceAdapter<T> extends com.facebook.datasource.AbstractDataSource<T> implements com.facebook.imagepipeline.request.HasImageRequest {
    private final com.facebook.imagepipeline.listener.RequestListener2 requestListener;
    private final com.facebook.imagepipeline.producers.SettableProducerContext settableProducerContext;

    public final com.facebook.imagepipeline.producers.SettableProducerContext getSettableProducerContext() {
        return this.settableProducerContext;
    }

    public final com.facebook.imagepipeline.listener.RequestListener2 getRequestListener() {
        return this.requestListener;
    }

    protected AbstractProducerToDataSourceAdapter(com.facebook.imagepipeline.producers.Producer<T> producer, com.facebook.imagepipeline.producers.SettableProducerContext settableProducerContext, com.facebook.imagepipeline.listener.RequestListener2 requestListener) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producer, "producer");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(settableProducerContext, "settableProducerContext");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(requestListener, "requestListener");
        this.settableProducerContext = settableProducerContext;
        this.requestListener = requestListener;
        com.facebook.imagepipeline.systrace.FrescoSystrace frescoSystrace = com.facebook.imagepipeline.systrace.FrescoSystrace.INSTANCE;
        if (!com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
            setExtras(settableProducerContext.getExtras());
            com.facebook.imagepipeline.systrace.FrescoSystrace frescoSystrace2 = com.facebook.imagepipeline.systrace.FrescoSystrace.INSTANCE;
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("AbstractProducerToDataSourceAdapter()->onRequestStart");
                try {
                    requestListener.onRequestStart(settableProducerContext);
                    kotlin.Unit unit = kotlin.Unit.INSTANCE;
                    com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                } catch (java.lang.Throwable th) {
                    com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                    throw th;
                }
            } else {
                requestListener.onRequestStart(settableProducerContext);
            }
            com.facebook.imagepipeline.systrace.FrescoSystrace frescoSystrace3 = com.facebook.imagepipeline.systrace.FrescoSystrace.INSTANCE;
            if (!com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                producer.produceResults(createConsumer(), settableProducerContext);
                return;
            }
            com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("AbstractProducerToDataSourceAdapter()->produceResult");
            try {
                producer.produceResults(createConsumer(), settableProducerContext);
                kotlin.Unit unit2 = kotlin.Unit.INSTANCE;
                return;
            } finally {
                com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
            }
        }
        com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("AbstractProducerToDataSourceAdapter()");
        try {
            setExtras(settableProducerContext.getExtras());
            com.facebook.imagepipeline.systrace.FrescoSystrace frescoSystrace4 = com.facebook.imagepipeline.systrace.FrescoSystrace.INSTANCE;
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("AbstractProducerToDataSourceAdapter()->onRequestStart");
                try {
                    requestListener.onRequestStart(settableProducerContext);
                    kotlin.Unit unit3 = kotlin.Unit.INSTANCE;
                    com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                } catch (java.lang.Throwable th2) {
                    com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                    throw th2;
                }
            } else {
                requestListener.onRequestStart(settableProducerContext);
            }
            com.facebook.imagepipeline.systrace.FrescoSystrace frescoSystrace5 = com.facebook.imagepipeline.systrace.FrescoSystrace.INSTANCE;
            if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("AbstractProducerToDataSourceAdapter()->produceResult");
                try {
                    producer.produceResults(createConsumer(), settableProducerContext);
                    kotlin.Unit unit4 = kotlin.Unit.INSTANCE;
                    com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                } finally {
                    com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                }
            } else {
                producer.produceResults(createConsumer(), settableProducerContext);
            }
            kotlin.Unit unit5 = kotlin.Unit.INSTANCE;
        } catch (java.lang.Throwable th3) {
            com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
            throw th3;
        }
    }

    private final com.facebook.imagepipeline.producers.Consumer<T> createConsumer() {
        return new com.facebook.imagepipeline.producers.BaseConsumer<T>(this) { // from class: com.facebook.imagepipeline.datasource.AbstractProducerToDataSourceAdapter.createConsumer.1
            final /* synthetic */ com.facebook.imagepipeline.datasource.AbstractProducerToDataSourceAdapter<T> this$0;

            {
                this.this$0 = this;
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            protected void onNewResultImpl(T newResult, int status) {
                com.facebook.imagepipeline.datasource.AbstractProducerToDataSourceAdapter<T> abstractProducerToDataSourceAdapter = this.this$0;
                abstractProducerToDataSourceAdapter.onNewResultImpl(newResult, status, abstractProducerToDataSourceAdapter.getSettableProducerContext());
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            protected void onFailureImpl(java.lang.Throwable throwable) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(throwable, "throwable");
                this.this$0.onFailureImpl(throwable);
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            protected void onCancellationImpl() {
                this.this$0.onCancellationImpl();
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            protected void onProgressUpdateImpl(float progress) {
                this.this$0.setProgress(progress);
            }
        };
    }

    protected void onNewResultImpl(T result, int status, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        boolean zIsLast = com.facebook.imagepipeline.producers.BaseConsumer.isLast(status);
        if (super.setResult(result, zIsLast, getExtras(producerContext)) && zIsLast) {
            this.requestListener.onRequestSuccess(this.settableProducerContext);
        }
    }

    protected final java.util.Map<java.lang.String, java.lang.Object> getExtras(com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        return producerContext.getExtras();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onFailureImpl(java.lang.Throwable throwable) {
        if (super.setFailure(throwable, getExtras(this.settableProducerContext))) {
            this.requestListener.onRequestFailure(this.settableProducerContext, throwable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void onCancellationImpl() {
        com.facebook.common.internal.Preconditions.checkState(isClosed());
    }

    @Override // com.facebook.imagepipeline.request.HasImageRequest
    public com.facebook.imagepipeline.request.ImageRequest getImageRequest() {
        return this.settableProducerContext.getImageRequest();
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    public boolean close() {
        if (!super.close()) {
            return false;
        }
        if (super.isFinished()) {
            return true;
        }
        this.requestListener.onRequestCancellation(this.settableProducerContext);
        this.settableProducerContext.cancel();
        return true;
    }
}
