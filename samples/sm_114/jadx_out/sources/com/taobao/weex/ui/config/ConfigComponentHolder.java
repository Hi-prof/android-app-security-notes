package com.taobao.weex.ui.config;

/* JADX INFO: loaded from: classes.dex */
public class ConfigComponentHolder implements com.taobao.weex.ui.IFComponentHolder {
    public static final java.lang.String TAG = "WeexScanConfigRegister";
    private boolean mAppendTree;
    private java.lang.Class mClass;
    private java.lang.ClassLoader mClassLoader;
    private java.lang.String mClassName;
    private java.util.Map<java.lang.String, com.taobao.weex.bridge.Invoker> mMethodInvokers;
    private java.util.Map<java.lang.String, com.taobao.weex.bridge.Invoker> mPropertyInvokers;
    private java.lang.String mType;
    private java.lang.String[] methods;

    @Override // io.dcloud.feature.uniapp.ui.AbsIComponentHolder
    public void loadIfNonLazy() {
    }

    public ConfigComponentHolder(java.lang.String str, boolean z, java.lang.String str2, java.lang.String[] strArr) {
        this.mType = str;
        this.mAppendTree = z;
        this.mClassName = str2;
        this.methods = strArr;
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
        if (this.mClass == null || this.mClassLoader != wXSDKInstance.getContext().getClassLoader()) {
            this.mClass = com.taobao.weex.WXSDKManager.getInstance().getClassLoaderAdapter().getComponentClass(this.mType, this.mClassName, wXSDKInstance);
            this.mClassLoader = wXSDKInstance.getContext().getClassLoader();
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
    public java.lang.String[] getMethods() {
        java.lang.String[] strArr = this.methods;
        return strArr == null ? new java.lang.String[0] : strArr;
    }

    public static final com.taobao.weex.ui.config.ConfigComponentHolder fromConfig(com.alibaba.fastjson.JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            java.lang.String string = jSONObject.getString("name");
            boolean booleanValue = jSONObject.getBooleanValue("appendTree");
            java.lang.String string2 = jSONObject.getString("className");
            com.alibaba.fastjson.JSONArray jSONArray = jSONObject.containsKey("methods") ? jSONObject.getJSONArray("methods") : null;
            if (!android.text.TextUtils.isEmpty(string) && !android.text.TextUtils.isEmpty(string2)) {
                java.lang.String[] strArr = new java.lang.String[0];
                if (jSONArray != null) {
                    strArr = new java.lang.String[jSONArray.size()];
                    jSONArray.toArray(strArr);
                }
                if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                    com.taobao.weex.utils.WXLogUtils.d("WeexScanConfigRegister", "resolve component " + string + " className " + string2 + " methods " + jSONArray);
                }
                return new com.taobao.weex.ui.config.ConfigComponentHolder(string, booleanValue, string2, strArr);
            }
            return null;
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("WeexScanConfigRegister", e);
            return null;
        }
    }

    public boolean isAppendTree() {
        return this.mAppendTree;
    }

    public java.lang.String getType() {
        return this.mType;
    }
}
