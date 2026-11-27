package io.dcloud.feature.uniapp.common;

/* JADX INFO: loaded from: classes2.dex */
public class TypeUniModuleFactory<T extends io.dcloud.feature.uniapp.common.UniModule> implements io.dcloud.feature.uniapp.bridge.UniModuleFactory<T> {
    public static final java.lang.String TAG = "TypeModuleFactory";
    java.lang.Class<T> mClazz;
    java.util.Map<java.lang.String, com.taobao.weex.bridge.Invoker> mMethodMap;

    public TypeUniModuleFactory(java.lang.Class<T> cls) {
        this.mClazz = cls;
    }

    private void generateMethodMap() {
        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            io.dcloud.feature.uniapp.utils.UniLogUtils.d("TypeModuleFactory", "extractMethodNames:" + this.mClazz.getSimpleName());
        }
        java.util.HashMap map = new java.util.HashMap();
        try {
            for (java.lang.reflect.Method method : this.mClazz.getMethods()) {
                for (java.lang.annotation.Annotation annotation : method.getDeclaredAnnotations()) {
                    if (annotation != null) {
                        if (annotation instanceof io.dcloud.feature.uniapp.annotation.UniJSMethod) {
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
            io.dcloud.feature.uniapp.utils.UniLogUtils.e("[WXModuleManager] extractMethodNames:", th);
        }
        this.mMethodMap = map;
    }

    @Override // com.taobao.weex.bridge.ModuleFactory
    public T buildInstance() throws java.lang.IllegalAccessException, java.lang.InstantiationException {
        return this.mClazz.newInstance();
    }

    @Override // com.taobao.weex.bridge.JavascriptInvokable
    public java.lang.String[] getMethods() {
        if (this.mMethodMap == null) {
            generateMethodMap();
        }
        java.util.Set<java.lang.String> setKeySet = this.mMethodMap.keySet();
        return (java.lang.String[]) setKeySet.toArray(new java.lang.String[setKeySet.size()]);
    }

    @Override // com.taobao.weex.bridge.JavascriptInvokable
    public com.taobao.weex.bridge.Invoker getMethodInvoker(java.lang.String str) {
        if (this.mMethodMap == null) {
            generateMethodMap();
        }
        return this.mMethodMap.get(str);
    }
}
