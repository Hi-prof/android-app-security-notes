package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class ReflectUtils {
    public static final java.lang.String CLASSNAME_APPLICATIONINFO = "android.content.pm.ApplicationInfo";
    public static final java.lang.String CLASSNAME_AUDIOSYSTEM = "android.media.AudioSystem";
    public static final java.lang.String CLASSNAME_ICONTENTPROVIDER = "android.content.IContentProvider";
    public static final java.lang.String CLASSNAME_IMOUNTSERVICE_STUB = "android.os.storage.IMountService$Stub";
    public static final java.lang.String CLASSNAME_IPACKAGEDATAOBSERVER = "android.content.pm.IPackageDataObserver";
    public static final java.lang.String CLASSNAME_IPACKAGEDELETEOBSERVER = "android.content.pm.IPackageDeleteObserver";
    public static final java.lang.String CLASSNAME_IPACKAGEINSTALLOBERVER = "android.content.pm.IPackageInstallObserver";
    public static final java.lang.String CLASSNAME_IPACKAGEMANAGER = "android.content.pm.IPackageManager";
    public static final java.lang.String CLASSNAME_IPACKAGEMANAGER_STUB = "android.content.pm.IPackageManager$Stub";
    public static final java.lang.String CLASSNAME_IPACKAGESTATSOBSERVER = "android.content.pm.IPackageStatsObserver";
    public static final java.lang.String CLASSNAME_PACKAGEINFO = "android.content.pm.PackageInfo";
    public static final java.lang.String CLASSNAME_PACKAGEMANAGER = "android.content.pm.PackageManager";
    public static final java.lang.String CLASSNAME_PAGEAGEPARSE = "android.content.pm.PackageParser";
    public static final java.lang.String CLASSNAME_PAGEAGEPARSE_PACKAGE = "android.content.pm.PackageParser$Package";
    public static final java.lang.String CLASSNAME_PROCESS = "android.os.Process";
    public static final java.lang.String CLASSNAME_THREADS = "android.provider.Telephony$Threads";
    public static final java.lang.String CLASSNAME_THUMBNAILUTILS = "android.media.ThumbnailUtils";

    public static java.lang.Class classForName(java.lang.String str) {
        try {
            return java.lang.Class.forName(str);
        } catch (java.lang.ClassNotFoundException unused) {
            throw new java.lang.RuntimeException(str);
        }
    }

    public static android.content.Context getApplicationContext() {
        try {
            return (android.content.Context) java.lang.Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", null).invoke(null, null);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.reflect.Field getDeclaredField(java.lang.Object obj, java.lang.String str) {
        for (java.lang.Class<?> superclass = obj.getClass(); superclass != java.lang.Object.class; superclass = superclass.getSuperclass()) {
            try {
                return superclass.getDeclaredField(str);
            } catch (java.lang.Exception unused) {
            }
        }
        return null;
    }

    public static java.lang.reflect.Method getDeclaredMethod(java.lang.Object obj, java.lang.String str, java.lang.Class<?>... clsArr) {
        for (java.lang.Class<?> superclass = obj.getClass(); superclass != java.lang.Object.class; superclass = superclass.getSuperclass()) {
            try {
                return superclass.getDeclaredMethod(str, clsArr);
            } catch (java.lang.Exception unused) {
            }
        }
        return null;
    }

    public static java.lang.Object getField(java.lang.Object obj, java.lang.String str) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException {
        return prepareField(obj.getClass(), str).get(obj);
    }

    public static java.lang.Object getFieldValue(java.lang.Object obj, java.lang.String str) {
        java.lang.reflect.Field declaredField = getDeclaredField(obj, str);
        declaredField.setAccessible(true);
        try {
            return declaredField.get(obj);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int getIntField(java.lang.Object obj, java.lang.String str) {
        try {
            return obj.getClass().getDeclaredField(str).getInt(obj);
        } catch (java.lang.IllegalAccessException e) {
            throw new java.lang.RuntimeException(e);
        } catch (java.lang.NoSuchFieldException e2) {
            throw new java.lang.RuntimeException(e2);
        }
    }

    public static java.lang.reflect.Method getMethod(java.lang.String str, java.lang.String str2, java.lang.Class<?>... clsArr) {
        try {
            return java.lang.Class.forName(str).getDeclaredMethod(str2, clsArr);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.reflect.Constructor getObjectConstructor(java.lang.String str, java.lang.Class... clsArr) {
        try {
            return java.lang.Class.forName(str).getConstructor(clsArr);
        } catch (java.lang.ClassNotFoundException e) {
            throw new java.lang.RuntimeException(e);
        } catch (java.lang.NoSuchMethodException e2) {
            throw new java.lang.RuntimeException(e2);
        }
    }

    public static java.lang.Object getObjectField(java.lang.Object obj, java.lang.String str) {
        try {
            return obj.getClass().getDeclaredField(str).get(obj);
        } catch (java.lang.IllegalAccessException e) {
            throw new java.lang.RuntimeException(e);
        } catch (java.lang.NoSuchFieldException e2) {
            throw new java.lang.RuntimeException(e2);
        }
    }

    public static java.lang.Object getObjectFieldNoDeclared(java.lang.Object obj, java.lang.String str) {
        try {
            return obj.getClass().getField(str).get(obj);
        } catch (java.lang.IllegalAccessException e) {
            throw new java.lang.RuntimeException(e);
        } catch (java.lang.NoSuchFieldException e2) {
            throw new java.lang.RuntimeException(e2);
        }
    }

    public static int getStaticIntField(java.lang.String str, java.lang.String str2) {
        try {
            return java.lang.Class.forName(str).getDeclaredField(str2).getInt(null);
        } catch (java.lang.ClassNotFoundException e) {
            throw new java.lang.RuntimeException(e);
        } catch (java.lang.IllegalAccessException e2) {
            throw new java.lang.RuntimeException(e2);
        } catch (java.lang.NoSuchFieldException e3) {
            throw new java.lang.RuntimeException(e3);
        }
    }

    public static java.lang.Object getStaticObjectField(java.lang.String str, java.lang.String str2) {
        try {
            return java.lang.Class.forName(str).getDeclaredField(str2).get(null);
        } catch (java.lang.ClassNotFoundException e) {
            throw new java.lang.RuntimeException(e);
        } catch (java.lang.IllegalAccessException e2) {
            throw new java.lang.RuntimeException(e2);
        } catch (java.lang.NoSuchFieldException e3) {
            throw new java.lang.RuntimeException(e3);
        }
    }

    public static java.lang.String getStaticStringField(java.lang.String str, java.lang.String str2) {
        return (java.lang.String) getStaticObjectField(str, str2);
    }

    public static java.lang.String getSystemProperties(java.lang.String str, java.lang.String str2) {
        try {
            return (java.lang.String) java.lang.Class.forName("android.os.SystemProperties").getDeclaredMethod("get", java.lang.String.class, java.lang.String.class).invoke(null, str, str2);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    public static java.lang.Object invoke(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.Object invokeMethod(java.lang.Object obj, java.lang.String str, java.lang.Class<?>[] clsArr, java.lang.Object[] objArr) {
        java.lang.reflect.Method declaredMethod = getDeclaredMethod(obj, str, clsArr);
        declaredMethod.setAccessible(true);
        try {
            return declaredMethod.invoke(obj, objArr);
        } catch (java.lang.IllegalAccessException | java.lang.IllegalArgumentException | java.lang.reflect.InvocationTargetException unused) {
            return null;
        }
    }

    public static void modifyPushBigContentView(java.lang.Object obj, java.lang.String str, java.lang.Object obj2) {
        try {
            java.lang.reflect.Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
        } catch (java.lang.IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }

    public static void modifyPushPriority(java.lang.Object obj, java.lang.String str, java.lang.Object obj2) {
        try {
            java.lang.reflect.Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
        } catch (java.lang.IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }

    private static java.lang.reflect.Field prepareField(java.lang.Class<?> cls, java.lang.String str) throws java.lang.NoSuchFieldException {
        if (cls == null) {
            throw new java.lang.NoSuchFieldException();
        }
        try {
            java.lang.reflect.Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } finally {
            cls.getSuperclass();
        }
    }

    public static void setField(java.lang.Object obj, java.lang.String str, java.lang.Object obj2) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException {
        prepareField(obj.getClass(), str).set(obj, obj2);
    }

    public static void setFieldValue(java.lang.Object obj, java.lang.String str, java.lang.Object obj2) {
        java.lang.reflect.Field declaredField = getDeclaredField(obj, str);
        declaredField.setAccessible(true);
        try {
            declaredField.set(obj, obj2);
        } catch (java.lang.IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.IllegalArgumentException e2) {
            e2.printStackTrace();
        }
    }

    public static java.lang.Object stubAsInterface(java.lang.String str, android.os.IBinder iBinder) {
        return stubAsInterface(classForName(str), iBinder);
    }

    public static void windowDismissed(android.view.inputmethod.InputMethodManager inputMethodManager, android.os.IBinder iBinder) {
        try {
            inputMethodManager.getClass().getMethod("windowDismissed", android.os.IBinder.class).invoke(inputMethodManager, iBinder);
        } catch (java.lang.IllegalAccessException e) {
            throw new java.lang.RuntimeException(e);
        } catch (java.lang.NoSuchMethodException e2) {
            throw new java.lang.RuntimeException(e2);
        } catch (java.lang.reflect.InvocationTargetException e3) {
            throw new java.lang.RuntimeException(e3);
        }
    }

    public static java.lang.Object stubAsInterface(java.lang.Class cls, android.os.IBinder iBinder) {
        try {
            return cls.getDeclaredMethod("asInterface", android.os.IBinder.class).invoke(null, iBinder);
        } catch (java.lang.IllegalAccessException e) {
            throw new java.lang.RuntimeException(e);
        } catch (java.lang.NoSuchMethodException e2) {
            throw new java.lang.RuntimeException(e2);
        } catch (java.lang.reflect.InvocationTargetException e3) {
            throw new java.lang.RuntimeException(e3);
        }
    }

    public static java.lang.reflect.Method getMethod(java.lang.Class<?> cls, java.lang.String str, java.lang.Class<?>[] clsArr) {
        if (str != null && str.length() > 0) {
            try {
                return cls.getMethod(str, clsArr);
            } catch (java.lang.NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return null;
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
}
