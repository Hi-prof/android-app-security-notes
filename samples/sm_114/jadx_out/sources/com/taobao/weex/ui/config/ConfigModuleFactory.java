package com.taobao.weex.ui.config;

/* JADX INFO: loaded from: classes.dex */
public class ConfigModuleFactory<T extends com.taobao.weex.common.WXModule> implements com.taobao.weex.bridge.ModuleFactory<T> {
    public static final java.lang.String TAG = "WeexScanConfigRegister";
    private java.lang.ClassLoader mClassLoader;
    private java.lang.String mClassName;
    private java.lang.Class<T> mClazz;
    private java.util.Map<java.lang.String, com.taobao.weex.bridge.Invoker> mMethodMap;
    private java.lang.String mName;
    private java.lang.String[] methods;

    public ConfigModuleFactory(java.lang.String str, java.lang.String str2, java.lang.String[] strArr) {
        this.mName = str;
        this.mClassName = str2;
        this.methods = strArr;
    }

    @Override // com.taobao.weex.bridge.JavascriptInvokable
    public java.lang.String[] getMethods() {
        java.lang.String[] strArr = this.methods;
        return strArr == null ? new java.lang.String[0] : strArr;
    }

    @Override // com.taobao.weex.bridge.JavascriptInvokable
    public com.taobao.weex.bridge.Invoker getMethodInvoker(java.lang.String str) {
        if (this.mMethodMap == null) {
            generateMethodMap();
        }
        return this.mMethodMap.get(str);
    }

    @Override // com.taobao.weex.bridge.ModuleFactory
    public T buildInstance() throws java.lang.IllegalAccessException, java.lang.InstantiationException {
        if (this.mClazz == null) {
            this.mClazz = (java.lang.Class<T>) com.taobao.weex.WXSDKManager.getInstance().getClassLoaderAdapter().getModuleClass(this.mName, this.mClassName, com.taobao.weex.WXEnvironment.getApplication().getApplicationContext());
        }
        return this.mClazz.newInstance();
    }

    public T buildInstance(com.taobao.weex.WXSDKInstance wXSDKInstance) throws java.lang.IllegalAccessException, java.lang.InstantiationException {
        if (wXSDKInstance == null) {
            return (T) buildInstance();
        }
        if (this.mClazz == null || this.mClassLoader != wXSDKInstance.getContext().getClassLoader()) {
            this.mClazz = (java.lang.Class<T>) com.taobao.weex.WXSDKManager.getInstance().getClassLoaderAdapter().getModuleClass(this.mName, this.mClassName, wXSDKInstance.getContext());
            this.mClassLoader = wXSDKInstance.getContext().getClassLoader();
        }
        return this.mClazz.newInstance();
    }

    private void generateMethodMap() {
        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            com.taobao.weex.utils.WXLogUtils.d("WeexScanConfigRegister", "extractMethodNames:" + this.mClazz.getSimpleName());
        }
        java.util.HashMap map = new java.util.HashMap();
        try {
            for (java.lang.reflect.Method method : this.mClazz.getMethods()) {
                for (java.lang.annotation.Annotation annotation : method.getDeclaredAnnotations()) {
                    if (annotation != null) {
                        if (annotation instanceof com.taobao.weex.annotation.JSMethod) {
                            com.taobao.weex.annotation.JSMethod jSMethod = (com.taobao.weex.annotation.JSMethod) annotation;
                            map.put("_".equals(jSMethod.alias()) ? method.getName() : jSMethod.alias(), new com.taobao.weex.bridge.MethodInvoker(method, jSMethod.uiThread()));
                            break;
                        } else if (annotation instanceof com.taobao.weex.common.WXModuleAnno) {
                            map.put(method.getName(), new com.taobao.weex.bridge.MethodInvoker(method, ((com.taobao.weex.common.WXModuleAnno) annotation).runOnUIThread()));
                            break;
                        } else if (annotation instanceof io.dcloud.feature.uniapp.annotation.UniJSMethod) {
                            io.dcloud.feature.uniapp.annotation.UniJSMethod uniJSMethod = (io.dcloud.feature.uniapp.annotation.UniJSMethod) annotation;
                            map.put("_".equals(uniJSMethod.alias()) ? method.getName() : uniJSMethod.alias(), new com.taobao.weex.bridge.MethodInvoker(method, uniJSMethod.uiThread()));
                            break;
                        } else if (annotation instanceof io.dcloud.feature.uniapp.common.UniModuleAnno) {
                            map.put(method.getName(), new com.taobao.weex.bridge.MethodInvoker(method, ((io.dcloud.feature.uniapp.common.UniModuleAnno) annotation).runOnUIThread()));
                            break;
                        }
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            com.taobao.weex.utils.WXLogUtils.e("[WXModuleManager] extractMethodNames:", th);
        }
        this.mMethodMap = map;
    }

    public static com.taobao.weex.ui.config.ConfigModuleFactory fromConfig(com.alibaba.fastjson.JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            java.lang.String string = jSONObject.getString("name");
            java.lang.String string2 = jSONObject.getString("className");
            com.alibaba.fastjson.JSONArray jSONArray = jSONObject.getJSONArray("methods");
            if (!android.text.TextUtils.isEmpty(string) && !android.text.TextUtils.isEmpty(string2)) {
                java.lang.String[] strArr = new java.lang.String[jSONArray.size()];
                if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                    com.taobao.weex.utils.WXLogUtils.d("WeexScanConfigRegister", " resolve module " + string + " className " + string2 + " methods " + jSONArray);
                }
                return new com.taobao.weex.ui.config.ConfigModuleFactory(string, string2, (java.lang.String[]) jSONArray.toArray(strArr));
            }
            return null;
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("WeexScanConfigRegister", e);
            return null;
        }
    }

    public java.lang.String getName() {
        return this.mName;
    }
}
