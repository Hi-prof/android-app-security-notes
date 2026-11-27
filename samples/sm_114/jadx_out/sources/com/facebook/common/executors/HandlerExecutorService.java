package com.facebook.common.executors;

/* JADX INFO: loaded from: classes.dex */
public interface HandlerExecutorService extends java.util.concurrent.ScheduledExecutorService {
    boolean isHandlerThread();

    void quit();
}
