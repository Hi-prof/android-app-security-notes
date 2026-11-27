package com.taobao.weex.utils;

/* JADX INFO: loaded from: classes.dex */
public class WXInterception {

    private interface Intercepted {
    }

    private WXInterception() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T proxy(java.lang.Object obj, java.lang.Class<T> cls, com.taobao.weex.utils.WXInterception.InterceptionHandler<T> interceptionHandler) throws java.lang.IllegalArgumentException {
        if (obj instanceof com.taobao.weex.utils.WXInterception.Intercepted) {
            return obj;
        }
        interceptionHandler.setDelegate(obj);
        return (T) java.lang.reflect.Proxy.newProxyInstance(com.taobao.weex.utils.WXInterception.class.getClassLoader(), new java.lang.Class[]{cls, com.taobao.weex.utils.WXInterception.Intercepted.class}, interceptionHandler);
    }

    public static <T> T proxy(java.lang.Object obj, com.taobao.weex.utils.WXInterception.InterceptionHandler<T> interceptionHandler, java.lang.Class<?>... clsArr) throws java.lang.IllegalArgumentException {
        interceptionHandler.setDelegate(obj);
        return (T) java.lang.reflect.Proxy.newProxyInstance(com.taobao.weex.utils.WXInterception.class.getClassLoader(), clsArr, interceptionHandler);
    }

    public static abstract class InterceptionHandler<T> implements java.lang.reflect.InvocationHandler {
        private T mDelegate;

        @Override // java.lang.reflect.InvocationHandler
        public java.lang.Object invoke(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) throws java.lang.Throwable {
            try {
                return method.invoke(delegate(), objArr);
            } catch (java.lang.IllegalAccessException e) {
                com.taobao.weex.utils.WXLogUtils.e("", e);
                return null;
            } catch (java.lang.IllegalArgumentException e2) {
                com.taobao.weex.utils.WXLogUtils.e("", e2);
                return null;
            } catch (java.lang.reflect.InvocationTargetException e3) {
                throw e3.getTargetException();
            }
        }

        protected T delegate() {
            return this.mDelegate;
        }

        void setDelegate(T t) {
            this.mDelegate = t;
        }
    }
}
