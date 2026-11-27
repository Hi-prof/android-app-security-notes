package com.alibaba.android.bindingx.core;

/* JADX INFO: loaded from: classes.dex */
public interface IEventInterceptor {
    void performInterceptIfNeeded(java.lang.String str, com.alibaba.android.bindingx.core.internal.ExpressionPair expressionPair, java.util.Map<java.lang.String, java.lang.Object> map);

    void setInterceptors(java.util.Map<java.lang.String, com.alibaba.android.bindingx.core.internal.ExpressionPair> map);
}
