package com.taobao.weex.common;

/* JADX INFO: loaded from: classes.dex */
public final class WXWorkThreadManager {
    private java.util.concurrent.ExecutorService singleThreadExecutor = java.util.concurrent.Executors.newSingleThreadExecutor();

    public void post(java.lang.Runnable runnable) {
        java.util.concurrent.ExecutorService executorService = this.singleThreadExecutor;
        if (executorService != null) {
            executorService.execute(runnable);
        }
    }

    public void destroy() {
        java.util.concurrent.ExecutorService executorService = this.singleThreadExecutor;
        if (executorService != null) {
            executorService.shutdown();
        }
        this.singleThreadExecutor = null;
    }
}
