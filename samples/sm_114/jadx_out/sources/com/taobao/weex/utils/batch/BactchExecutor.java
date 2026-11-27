package com.taobao.weex.utils.batch;

/* JADX INFO: loaded from: classes.dex */
public interface BactchExecutor {
    void post(java.lang.Runnable runnable);

    void setInterceptor(com.taobao.weex.utils.batch.Interceptor interceptor);
}
