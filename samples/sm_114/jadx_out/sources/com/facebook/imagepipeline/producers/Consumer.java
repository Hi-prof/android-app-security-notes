package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: classes.dex */
public interface Consumer<T> {
    public static final int DO_NOT_CACHE_ENCODED = 2;
    public static final int IS_LAST = 1;
    public static final int IS_PARTIAL_RESULT = 8;
    public static final int IS_PLACEHOLDER = 4;
    public static final int IS_RESIZING_DONE = 16;
    public static final int NO_FLAGS = 0;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Status {
    }

    void onCancellation();

    void onFailure(java.lang.Throwable th);

    void onNewResult(@javax.annotation.Nullable T t, int i);

    void onProgressUpdate(float f);
}
