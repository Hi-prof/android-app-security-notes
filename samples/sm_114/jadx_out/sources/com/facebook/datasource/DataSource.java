package com.facebook.datasource;

/* JADX INFO: loaded from: classes.dex */
public interface DataSource<T> {
    boolean close();

    @javax.annotation.Nullable
    java.util.Map<java.lang.String, java.lang.Object> getExtras();

    @javax.annotation.Nullable
    java.lang.Throwable getFailureCause();

    float getProgress();

    @javax.annotation.Nullable
    T getResult();

    boolean hasFailed();

    boolean hasMultipleResults();

    boolean hasResult();

    boolean isClosed();

    boolean isFinished();

    void subscribe(com.facebook.datasource.DataSubscriber<T> dataSubscriber, java.util.concurrent.Executor executor);
}
