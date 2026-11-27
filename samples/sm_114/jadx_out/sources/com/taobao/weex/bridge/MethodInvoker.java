package com.taobao.weex.bridge;

/* JADX INFO: loaded from: classes.dex */
public class MethodInvoker implements com.taobao.weex.bridge.Invoker {
    final java.lang.reflect.Method mMethod;
    java.lang.reflect.Type[] mParam;
    final boolean mRunOnUIThread;

    public MethodInvoker(java.lang.reflect.Method method) {
        this(method, false);
    }

    public MethodInvoker(java.lang.reflect.Method method, boolean z) {
        this.mMethod = method;
        this.mParam = method.getGenericParameterTypes();
        this.mRunOnUIThread = z;
    }

    @Override // com.taobao.weex.bridge.Invoker
    public java.lang.Object invoke(java.lang.Object obj, java.lang.Object... objArr) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        return this.mMethod.invoke(obj, objArr);
    }

    @Override // com.taobao.weex.bridge.Invoker
    public java.lang.reflect.Type[] getParameterTypes() {
        if (this.mParam == null) {
            this.mParam = this.mMethod.getGenericParameterTypes();
        }
        return this.mParam;
    }

    @Override // com.taobao.weex.bridge.Invoker
    public boolean isRunOnUIThread() {
        return this.mRunOnUIThread;
    }

    public java.lang.String toString() {
        return this.mMethod.getName();
    }
}
