package io.dcloud.sdk.core.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class ReflectUtil {
    public static java.lang.Object invokeField(java.lang.String str, java.lang.String str2) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(str);
            java.lang.reflect.Field declaredField = cls.getDeclaredField(str2);
            declaredField.setAccessible(true);
            return declaredField.get(cls);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static java.lang.Object invokeMethod(java.lang.Object obj, java.lang.String str, java.lang.Class<?>[] clsArr, java.lang.Object... objArr) {
        if (obj == null) {
            return null;
        }
        try {
            java.lang.reflect.Method method = obj.getClass().getMethod(str, clsArr);
            method.setAccessible(true);
            if (objArr == null || objArr.length == 0) {
                objArr = null;
            }
            return method.invoke(obj, objArr);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static java.lang.Object newInstance(java.lang.String str, java.lang.Class[] clsArr, java.lang.Object[] objArr) {
        try {
            return java.lang.Class.forName(str).getConstructor(clsArr).newInstance(objArr);
        } catch (java.lang.Throwable th) {
            io.dcloud.p.c3.a(com.taobao.weex.common.RenderTypes.RENDER_TYPE_NATIVE, th.toString());
            return null;
        }
    }

    public static java.lang.Object invokeMethod(java.lang.String str, java.lang.String str2, java.lang.Object obj, java.lang.Class[] clsArr, java.lang.Object[] objArr) {
        java.lang.String message;
        java.lang.Object objInvoke;
        java.lang.String str3 = null;
        try {
            java.lang.reflect.Method method = java.lang.Class.forName(str).getMethod(str2, clsArr);
            if (method != null) {
                method.setAccessible(true);
                objInvoke = method.invoke(obj, objArr);
            } else {
                objInvoke = null;
            }
        } catch (java.lang.ClassNotFoundException unused) {
            message = "ClassNotFoundException";
            str3 = message;
            objInvoke = null;
        } catch (java.lang.NoSuchMethodException unused2) {
            message = "NoSuchMethodException";
            str3 = message;
            objInvoke = null;
        } catch (java.lang.Exception e) {
            message = e.getMessage();
            str3 = message;
            objInvoke = null;
        }
        if (str3 != null) {
            "getJsContent".equals(str2);
        }
        return objInvoke;
    }

    public static java.lang.Object invokeMethod(java.lang.String str, java.lang.String str2, java.lang.Object obj) {
        return invokeMethod(str, str2, obj, new java.lang.Class[0], new java.lang.Object[0]);
    }
}
