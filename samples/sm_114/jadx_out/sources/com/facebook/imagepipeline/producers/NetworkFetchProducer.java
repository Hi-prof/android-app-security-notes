package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public class NetworkFetchProducer implements com.facebook.imagepipeline.producers.Producer<com.facebook.imagepipeline.image.EncodedImage> {
    public static final java.lang.String INTERMEDIATE_RESULT_PRODUCER_EVENT = "intermediate_result";
    public static final java.lang.String PRODUCER_NAME = "NetworkFetchProducer";
    private static final int READ_SIZE = 16384;
    static final long TIME_BETWEEN_PARTIAL_RESULTS_MS = 100;
    private final com.facebook.common.memory.ByteArrayPool mByteArrayPool;
    private final com.facebook.imagepipeline.producers.NetworkFetcher mNetworkFetcher;
    protected final com.facebook.common.memory.PooledByteBufferFactory mPooledByteBufferFactory;

    public NetworkFetchProducer(com.facebook.common.memory.PooledByteBufferFactory pooledByteBufferFactory, com.facebook.common.memory.ByteArrayPool byteArrayPool, com.facebook.imagepipeline.producers.NetworkFetcher networkFetcher) {
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
        this.mByteArrayPool = byteArrayPool;
        this.mNetworkFetcher = networkFetcher;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(com.facebook.imagepipeline.producers.Consumer<com.facebook.imagepipeline.image.EncodedImage> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        producerContext.getProducerListener().onProducerStart(producerContext, PRODUCER_NAME);
        final com.facebook.imagepipeline.producers.FetchState fetchStateCreateFetchState = this.mNetworkFetcher.createFetchState(consumer, producerContext);
        this.mNetworkFetcher.fetch(fetchStateCreateFetchState, new com.facebook.imagepipeline.producers.NetworkFetcher.Callback() { // from class: com.facebook.imagepipeline.producers.NetworkFetchProducer.1
            @Override // com.facebook.imagepipeline.producers.NetworkFetcher.Callback
            public void onResponse(java.io.InputStream inputStream, int i) throws java.lang.Throwable {
                if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                    com.facebook.imagepipeline.systrace.FrescoSystrace.beginSection("NetworkFetcher->onResponse");
                }
                com.facebook.imagepipeline.producers.NetworkFetchProducer.this.onResponse(fetchStateCreateFetchState, inputStream, i);
                if (com.facebook.imagepipeline.systrace.FrescoSystrace.isTracing()) {
                    com.facebook.imagepipeline.systrace.FrescoSystrace.endSection();
                }
            }

            @Override // com.facebook.imagepipeline.producers.NetworkFetcher.Callback
            public void onFailure(java.lang.Throwable th) {
                com.facebook.imagepipeline.producers.NetworkFetchProducer.this.onFailure(fetchStateCreateFetchState, th);
            }

            @Override // com.facebook.imagepipeline.producers.NetworkFetcher.Callback
            public void onCancellation() {
                com.facebook.imagepipeline.producers.NetworkFetchProducer.this.onCancellation(fetchStateCreateFetchState);
            }
        });
    }

    protected void onResponse(com.facebook.imagepipeline.producers.FetchState fetchState, java.io.InputStream inputStream, int i) throws java.lang.Throwable {
        com.facebook.common.memory.PooledByteBufferOutputStream pooledByteBufferOutputStreamNewOutputStream;
        if (i > 0) {
            pooledByteBufferOutputStreamNewOutputStream = this.mPooledByteBufferFactory.newOutputStream(i);
        } else {
            pooledByteBufferOutputStreamNewOutputStream = this.mPooledByteBufferFactory.newOutputStream();
        }
        byte[] bArr = this.mByteArrayPool.get(16384);
        while (true) {
            try {
                int i2 = inputStream.read(bArr);
                if (i2 < 0) {
                    this.mNetworkFetcher.onFetchCompletion(fetchState, pooledByteBufferOutputStreamNewOutputStream.getCount());
                    handleFinalResult(pooledByteBufferOutputStreamNewOutputStream, fetchState);
                    this.mByteArrayPool.release(bArr);
                    pooledByteBufferOutputStreamNewOutputStream.close();
                    return;
                }
                if (i2 > 0) {
                    pooledByteBufferOutputStreamNewOutputStream.write(bArr, 0, i2);
                    maybeHandleIntermediateResult(pooledByteBufferOutputStreamNewOutputStream, fetchState);
                    fetchState.getConsumer().onProgressUpdate(calculateProgress(pooledByteBufferOutputStreamNewOutputStream.getCount(), i));
                }
            } catch (java.lang.Throwable th) {
                this.mByteArrayPool.release(bArr);
                pooledByteBufferOutputStreamNewOutputStream.close();
                throw th;
            }
        }
    }

    protected static float calculateProgress(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) java.lang.Math.exp(((double) (-i)) / 50000.0d));
    }

    protected void maybeHandleIntermediateResult(com.facebook.common.memory.PooledByteBufferOutputStream pooledByteBufferOutputStream, com.facebook.imagepipeline.producers.FetchState fetchState) throws java.lang.Throwable {
        if (shouldPropagateIntermediateResults(fetchState, fetchState.getContext())) {
            long systemUptime = getSystemUptime();
            if (systemUptime - fetchState.getLastIntermediateResultTimeMs() >= TIME_BETWEEN_PARTIAL_RESULTS_MS) {
                fetchState.setLastIntermediateResultTimeMs(systemUptime);
                fetchState.getListener().onProducerEvent(fetchState.getContext(), PRODUCER_NAME, INTERMEDIATE_RESULT_PRODUCER_EVENT);
                notifyConsumer(pooledByteBufferOutputStream, fetchState.getOnNewResultStatusFlags(), fetchState.getResponseBytesRange(), fetchState.getConsumer(), fetchState.getContext());
            }
        }
    }

    protected void handleFinalResult(com.facebook.common.memory.PooledByteBufferOutputStream pooledByteBufferOutputStream, com.facebook.imagepipeline.producers.FetchState fetchState) throws java.lang.Throwable {
        java.util.Map<java.lang.String, java.lang.String> extraMap = getExtraMap(fetchState, pooledByteBufferOutputStream.getCount());
        com.facebook.imagepipeline.producers.ProducerListener2 listener = fetchState.getListener();
        listener.onProducerFinishWithSuccess(fetchState.getContext(), PRODUCER_NAME, extraMap);
        listener.onUltimateProducerReached(fetchState.getContext(), PRODUCER_NAME, true);
        fetchState.getContext().putOriginExtra("network");
        notifyConsumer(pooledByteBufferOutputStream, fetchState.getOnNewResultStatusFlags() | 1, fetchState.getResponseBytesRange(), fetchState.getConsumer(), fetchState.getContext());
    }

    protected static void notifyConsumer(com.facebook.common.memory.PooledByteBufferOutputStream pooledByteBufferOutputStream, int i, @javax.annotation.Nullable com.facebook.imagepipeline.common.BytesRange bytesRange, com.facebook.imagepipeline.producers.Consumer<com.facebook.imagepipeline.image.EncodedImage> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext) throws java.lang.Throwable {
        com.facebook.common.references.CloseableReference closeableReferenceOf = com.facebook.common.references.CloseableReference.of(pooledByteBufferOutputStream.toByteBuffer());
        com.facebook.imagepipeline.image.EncodedImage encodedImage = null;
        try {
            com.facebook.imagepipeline.image.EncodedImage encodedImage2 = new com.facebook.imagepipeline.image.EncodedImage((com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer>) closeableReferenceOf);
            try {
                encodedImage2.setBytesRange(bytesRange);
                encodedImage2.parseMetaData();
                consumer.onNewResult(encodedImage2, i);
                com.facebook.imagepipeline.image.EncodedImage.closeSafely(encodedImage2);
                com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) closeableReferenceOf);
            } catch (java.lang.Throwable th) {
                th = th;
                encodedImage = encodedImage2;
                com.facebook.imagepipeline.image.EncodedImage.closeSafely(encodedImage);
                com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) closeableReferenceOf);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFailure(com.facebook.imagepipeline.producers.FetchState fetchState, java.lang.Throwable th) {
        fetchState.getListener().onProducerFinishWithFailure(fetchState.getContext(), PRODUCER_NAME, th, null);
        fetchState.getListener().onUltimateProducerReached(fetchState.getContext(), PRODUCER_NAME, false);
        fetchState.getContext().putOriginExtra("network");
        fetchState.getConsumer().onFailure(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCancellation(com.facebook.imagepipeline.producers.FetchState fetchState) {
        fetchState.getListener().onProducerFinishWithCancellation(fetchState.getContext(), PRODUCER_NAME, null);
        fetchState.getConsumer().onCancellation();
    }

    private boolean shouldPropagateIntermediateResults(com.facebook.imagepipeline.producers.FetchState fetchState, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        com.facebook.imagepipeline.decoder.ProgressiveJpegConfig progressiveJpegConfig = producerContext.getImagePipelineConfig().getProgressiveJpegConfig();
        if (progressiveJpegConfig != null && progressiveJpegConfig.decodeProgressively() && fetchState.getContext().isIntermediateResultExpected()) {
            return this.mNetworkFetcher.shouldPropagate(fetchState);
        }
        return false;
    }

    @javax.annotation.Nullable
    private java.util.Map<java.lang.String, java.lang.String> getExtraMap(com.facebook.imagepipeline.producers.FetchState fetchState, int i) {
        if (fetchState.getListener().requiresExtraMap(fetchState.getContext(), PRODUCER_NAME)) {
            return this.mNetworkFetcher.getExtraMap(fetchState, i);
        }
        return null;
    }

    protected long getSystemUptime() {
        return android.os.SystemClock.uptimeMillis();
    }
}
