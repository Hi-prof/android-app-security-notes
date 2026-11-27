package com.taobao.weex.utils.batch;

/* JADX INFO: loaded from: classes.dex */
public class BatchOperationHelper implements com.taobao.weex.utils.batch.Interceptor {
    private boolean isCollecting;
    private com.taobao.weex.utils.batch.BactchExecutor mExecutor;
    private java.util.concurrent.CopyOnWriteArrayList<java.lang.Runnable> sRegisterTasks = new java.util.concurrent.CopyOnWriteArrayList<>();

    public BatchOperationHelper(com.taobao.weex.utils.batch.BactchExecutor bactchExecutor) {
        this.isCollecting = false;
        this.mExecutor = bactchExecutor;
        bactchExecutor.setInterceptor(this);
        this.isCollecting = true;
    }

    @Override // com.taobao.weex.utils.batch.Interceptor
    public boolean take(java.lang.Runnable runnable) {
        if (!this.isCollecting) {
            return false;
        }
        this.sRegisterTasks.add(runnable);
        return true;
    }

    public void flush() {
        this.isCollecting = false;
        this.mExecutor.post(new java.lang.Runnable() { // from class: com.taobao.weex.utils.batch.BatchOperationHelper.1
            @Override // java.lang.Runnable
            public void run() {
                for (java.lang.Runnable runnable : com.taobao.weex.utils.batch.BatchOperationHelper.this.sRegisterTasks) {
                    runnable.run();
                    com.taobao.weex.utils.batch.BatchOperationHelper.this.sRegisterTasks.remove(runnable);
                }
            }
        });
        this.mExecutor.setInterceptor(null);
    }
}
