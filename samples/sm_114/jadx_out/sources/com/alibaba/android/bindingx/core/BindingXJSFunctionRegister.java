package com.alibaba.android.bindingx.core;

/* JADX INFO: loaded from: classes.dex */
public class BindingXJSFunctionRegister {
    private static final com.alibaba.android.bindingx.core.BindingXJSFunctionRegister sInstance = new com.alibaba.android.bindingx.core.BindingXJSFunctionRegister();
    private final java.util.LinkedHashMap<java.lang.String, com.alibaba.android.bindingx.core.internal.JSFunctionInterface> mJSFunctionMap = new java.util.LinkedHashMap<>(8);

    public static com.alibaba.android.bindingx.core.BindingXJSFunctionRegister getInstance() {
        return sInstance;
    }

    public void registerJSFunction(java.lang.String str, com.alibaba.android.bindingx.core.internal.JSFunctionInterface jSFunctionInterface) {
        if (android.text.TextUtils.isEmpty(str) || jSFunctionInterface == null) {
            return;
        }
        this.mJSFunctionMap.put(str, jSFunctionInterface);
    }

    public boolean unregisterJSFunction(java.lang.String str) {
        return (android.text.TextUtils.isEmpty(str) || this.mJSFunctionMap.remove(str) == null) ? false : true;
    }

    public void clear() {
        this.mJSFunctionMap.clear();
    }

    public java.util.Map<java.lang.String, com.alibaba.android.bindingx.core.internal.JSFunctionInterface> getJSFunctions() {
        return java.util.Collections.unmodifiableMap(this.mJSFunctionMap);
    }
}
