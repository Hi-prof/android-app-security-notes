package com.taobao.weex.ui;

/* JADX INFO: loaded from: classes.dex */
public class ExternalLoaderComponentHolder implements com.taobao.weex.ui.IFComponentHolder {
    public static final java.lang.String TAG = "SimpleComponentHolder";
    private java.lang.Class mClass;
    private final com.taobao.weex.ui.IExternalComponentGetter mClzGetter;
    private java.util.Map<java.lang.String, com.taobao.weex.bridge.Invoker> mMethodInvokers;
    private java.util.Map<java.lang.String, com.taobao.weex.bridge.Invoker> mPropertyInvokers;
    private final java.lang.String mType;

    @Override // io.dcloud.feature.uniapp.ui.AbsIComponentHolder
    public void loadIfNonLazy() {
    }

    public ExternalLoaderComponentHolder(java.lang.String str, com.taobao.weex.ui.IExternalComponentGetter iExternalComponentGetter) {
        this.mClzGetter = iExternalComponentGetter;
        this.mType = str;
    }

    private synchronized boolean generate() {
        java.lang.Class cls = this.mClass;
        if (cls == null) {
            return false;
        }
        android.util.Pair<java.util.Map<java.lang.String, com.taobao.weex.bridge.Invoker>, java.util.Map<java.lang.String, com.taobao.weex.bridge.Invoker>> methods = com.taobao.weex.ui.SimpleComponentHolder.getMethods(cls);
        this.mPropertyInvokers = (java.util.Map) methods.first;
        this.mMethodInvokers = (java.util.Map) methods.second;
        return true;
    }

    @Override // com.taobao.weex.ui.ComponentCreator
    public synchronized com.taobao.weex.ui.component.WXComponent createInstance(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.reflect.InvocationTargetException {
        com.taobao.weex.ui.component.WXComponent wXComponentCreateInstance;
        if (this.mClass == null) {
            this.mClass = this.mClzGetter.getExternalComponentClass(this.mType, wXSDKInstance);
        }
        wXComponentCreateInstance = new com.taobao.weex.ui.SimpleComponentHolder.ClazzComponentCreator(this.mClass).createInstance(wXSDKInstance, wXVContainer, basicComponentData);
        wXComponentCreateInstance.bindHolder(this);
        return wXComponentCreateInstance;
    }

    @Override // io.dcloud.feature.uniapp.ui.AbsIComponentHolder
    public synchronized com.taobao.weex.bridge.Invoker getPropertyInvoker(java.lang.String str) {
        if (this.mPropertyInvokers == null && !generate()) {
            return null;
        }
        return this.mPropertyInvokers.get(str);
    }

    @Override // com.taobao.weex.bridge.JavascriptInvokable
    public com.taobao.weex.bridge.Invoker getMethodInvoker(java.lang.String str) {
        if (this.mMethodInvokers != null || generate()) {
            return this.mMethodInvokers.get(str);
        }
        return null;
    }

    @Override // com.taobao.weex.bridge.JavascriptInvokable
    public synchronized java.lang.String[] getMethods() {
        if (this.mMethodInvokers == null && !generate()) {
            return new java.lang.String[0];
        }
        java.util.Set<java.lang.String> setKeySet = this.mMethodInvokers.keySet();
        return (java.lang.String[]) setKeySet.toArray(new java.lang.String[setKeySet.size()]);
    }
}
