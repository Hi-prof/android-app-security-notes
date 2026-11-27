package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public class FetchState {
    private final com.facebook.imagepipeline.producers.Consumer<com.facebook.imagepipeline.image.EncodedImage> mConsumer;
    private final com.facebook.imagepipeline.producers.ProducerContext mContext;
    private long mLastIntermediateResultTimeMs = 0;
    private int mOnNewResultStatusFlags;

    @javax.annotation.Nullable
    private com.facebook.imagepipeline.common.BytesRange mResponseBytesRange;

    public FetchState(com.facebook.imagepipeline.producers.Consumer<com.facebook.imagepipeline.image.EncodedImage> consumer, com.facebook.imagepipeline.producers.ProducerContext producerContext) {
        this.mConsumer = consumer;
        this.mContext = producerContext;
    }

    public com.facebook.imagepipeline.producers.Consumer<com.facebook.imagepipeline.image.EncodedImage> getConsumer() {
        return this.mConsumer;
    }

    public com.facebook.imagepipeline.producers.ProducerContext getContext() {
        return this.mContext;
    }

    public java.lang.String getId() {
        return this.mContext.getId();
    }

    public com.facebook.imagepipeline.producers.ProducerListener2 getListener() {
        return this.mContext.getProducerListener();
    }

    public android.net.Uri getUri() {
        return this.mContext.getImageRequest().getSourceUri();
    }

    public long getLastIntermediateResultTimeMs() {
        return this.mLastIntermediateResultTimeMs;
    }

    public void setLastIntermediateResultTimeMs(long j) {
        this.mLastIntermediateResultTimeMs = j;
    }

    public int getOnNewResultStatusFlags() {
        return this.mOnNewResultStatusFlags;
    }

    public void setOnNewResultStatusFlags(int i) {
        this.mOnNewResultStatusFlags = i;
    }

    @javax.annotation.Nullable
    public com.facebook.imagepipeline.common.BytesRange getResponseBytesRange() {
        return this.mResponseBytesRange;
    }

    public void setResponseBytesRange(@javax.annotation.Nullable com.facebook.imagepipeline.common.BytesRange bytesRange) {
        this.mResponseBytesRange = bytesRange;
    }
}
