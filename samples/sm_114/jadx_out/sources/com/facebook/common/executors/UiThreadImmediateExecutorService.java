package com.facebook.common.executors;

/* JADX INFO: loaded from: classes.dex */
public class UiThreadImmediateExecutorService extends com.facebook.common.executors.HandlerExecutorServiceImpl {

    @javax.annotation.Nullable
    private static com.facebook.common.executors.UiThreadImmediateExecutorService sInstance;

    private UiThreadImmediateExecutorService() {
        super(new android.os.Handler(android.os.Looper.getMainLooper()));
    }

    public static com.facebook.common.executors.UiThreadImmediateExecutorService getInstance() {
        if (sInstance == null) {
            sInstance = new com.facebook.common.executors.UiThreadImmediateExecutorService();
        }
        return sInstance;
    }

    @Override // com.facebook.common.executors.HandlerExecutorServiceImpl, java.util.concurrent.Executor
    public void execute(java.lang.Runnable runnable) {
        if (isHandlerThread()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
