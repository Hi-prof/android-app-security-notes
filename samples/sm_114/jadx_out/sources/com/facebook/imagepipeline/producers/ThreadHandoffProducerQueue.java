package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public interface ThreadHandoffProducerQueue {
    void addToQueueOrExecute(java.lang.Runnable runnable);

    boolean isQueueing();

    void remove(java.lang.Runnable runnable);

    void startQueueing();

    void stopQueuing();
}
