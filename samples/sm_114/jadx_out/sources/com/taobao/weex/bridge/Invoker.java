package com.taobao.weex.bridge;

/* JADX INFO: loaded from: classes.dex */
public interface Invoker {
    java.lang.reflect.Type[] getParameterTypes();

    java.lang.Object invoke(java.lang.Object obj, java.lang.Object... objArr) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException;

    boolean isRunOnUIThread();
}
