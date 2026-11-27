package com.alibaba.android.bindingx.core;

/* JADX INFO: loaded from: classes.dex */
public interface IEventHandler extends com.alibaba.android.bindingx.core.IEventInterceptor {
    void onActivityPause();

    void onActivityResume();

    void onBindExpression(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map, com.alibaba.android.bindingx.core.internal.ExpressionPair expressionPair, java.util.List<java.util.Map<java.lang.String, java.lang.Object>> list, com.alibaba.android.bindingx.core.BindingXCore.JavaScriptCallback javaScriptCallback);

    boolean onCreate(java.lang.String str, java.lang.String str2);

    void onDestroy();

    boolean onDisable(java.lang.String str, java.lang.String str2);

    void onStart(java.lang.String str, java.lang.String str2);

    void setAnchorInstanceId(java.lang.String str);

    void setExtensionParams(java.lang.Object[] objArr);

    void setGlobalConfig(java.util.Map<java.lang.String, java.lang.Object> map);

    void setToken(java.lang.String str);
}
