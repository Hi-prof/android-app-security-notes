package com.bun.miitmdid.core;

/* JADX INFO: loaded from: classes.dex */
public class MdidSdkHelper {
    public static java.lang.String TAG = "MdidSdkHelper";
    public static boolean _OuterIsOk = true;
    private java.lang.String sdk_date = "2020011018";

    public static int InitSdk(android.content.Context context, boolean z, com.bun.supplier.IIdentifierListener iIdentifierListener) {
        try {
            if (!_OuterIsOk) {
                if (iIdentifierListener != null) {
                    iIdentifierListener.OnSupport(false, new com.bun.supplier.a());
                }
                return com.bun.miitmdid.core.ErrorCode.INIT_HELPER_CALL_ERROR;
            }
            java.lang.Class<?> cls = java.lang.Class.forName("com.bun.miitmdid.core.MdidSdk");
            if (cls == null) {
                logd(z, "not found class:com.bun.miitmdid.core.MdidSdk");
                return com.bun.miitmdid.core.ErrorCode.INIT_HELPER_CALL_ERROR;
            }
            java.lang.reflect.Constructor<?> constructor = cls.getConstructor(java.lang.Boolean.TYPE);
            if (constructor == null) {
                logd(z, "not found MdidSdk Constructor");
                return com.bun.miitmdid.core.ErrorCode.INIT_HELPER_CALL_ERROR;
            }
            java.lang.Object objNewInstance = constructor.newInstance(java.lang.Boolean.valueOf(z));
            if (objNewInstance == null) {
                logd(z, "Create MdidSdk Instance failed");
                return com.bun.miitmdid.core.ErrorCode.INIT_HELPER_CALL_ERROR;
            }
            java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod("InitSdk", android.content.Context.class, com.bun.supplier.IIdentifierListener.class);
            if (declaredMethod == null) {
                logd(z, "not found MdidSdk InitSdk function");
                return com.bun.miitmdid.core.ErrorCode.INIT_HELPER_CALL_ERROR;
            }
            int iIntValue = ((java.lang.Integer) declaredMethod.invoke(objNewInstance, context, iIdentifierListener)).intValue();
            logd(z, "call and retvalue:" + iIntValue);
            return iIntValue;
        } catch (java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.InstantiationException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException e) {
            loge(z, e);
            logd(z, "exception exit");
            return com.bun.miitmdid.core.ErrorCode.INIT_HELPER_CALL_ERROR;
        }
    }

    public static void logd(boolean z, java.lang.String str) {
        if (z) {
            android.util.Log.d(TAG, str);
        }
    }

    public static void loge(boolean z, java.lang.Exception exc) {
        if (z) {
            android.util.Log.e(TAG, exc.getClass().getSimpleName(), exc);
        }
    }
}
