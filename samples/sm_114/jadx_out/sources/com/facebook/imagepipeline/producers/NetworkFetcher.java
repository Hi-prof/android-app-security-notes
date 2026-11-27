package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public interface NetworkFetcher<FETCH_STATE extends com.facebook.imagepipeline.producers.FetchState> {

    public interface Callback {
        void onCancellation();

        void onFailure(java.lang.Throwable th);

        void onResponse(java.io.InputStream inputStream, int i) throws java.io.IOException;
    }

    FETCH_STATE createFetchState(com.facebook.imagepipeline.producers.Consumer<com.facebook.imagepipeline.image.EncodedImage> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext);

    void fetch(FETCH_STATE fetch_state, com.facebook.imagepipeline.producers.NetworkFetcher.Callback callback);

    @javax.annotation.Nullable
    java.util.Map<java.lang.String, java.lang.String> getExtraMap(FETCH_STATE fetch_state, int i);

    void onFetchCompletion(FETCH_STATE fetch_state, int i);

    boolean shouldPropagate(FETCH_STATE fetch_state);
}
