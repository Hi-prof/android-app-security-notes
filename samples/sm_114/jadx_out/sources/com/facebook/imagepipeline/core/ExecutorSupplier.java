package com.facebook.imagepipeline.core;

/* JADX INFO: loaded from: classes.dex */
public interface ExecutorSupplier {
    java.util.concurrent.Executor forBackgroundTasks();

    java.util.concurrent.Executor forDecode();

    java.util.concurrent.Executor forLightweightBackgroundTasks();

    java.util.concurrent.Executor forLocalStorageRead();

    java.util.concurrent.Executor forLocalStorageWrite();

    java.util.concurrent.Executor forThumbnailProducer();

    @javax.annotation.Nullable
    java.util.concurrent.ScheduledExecutorService scheduledExecutorServiceForBackgroundTasks();
}
