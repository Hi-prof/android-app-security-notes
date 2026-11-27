package io.dcloud.common.adapter.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class InvokeExecutorHelper {
    public static io.dcloud.common.adapter.util.InvokeExecutorHelper.InvokeExecutor create(java.lang.String str) {
        io.dcloud.common.adapter.util.InvokeExecutorHelper.InvokeExecutor invokeExecutor = new io.dcloud.common.adapter.util.InvokeExecutorHelper.InvokeExecutor();
        try {
            invokeExecutor.mCls = java.lang.Class.forName(str);
        } catch (java.lang.Exception unused) {
        }
        return invokeExecutor;
    }

    public static io.dcloud.common.adapter.util.InvokeExecutorHelper.InvokeExecutor createInvokeExecutor(java.lang.String str, java.lang.Class[] clsArr, java.lang.Object... objArr) {
        io.dcloud.common.adapter.util.InvokeExecutorHelper.InvokeExecutor invokeExecutor = new io.dcloud.common.adapter.util.InvokeExecutorHelper.InvokeExecutor();
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(str);
            invokeExecutor.mCls = cls;
            invokeExecutor.mObj = cls.getConstructor(clsArr).newInstance(objArr);
            return invokeExecutor;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            io.dcloud.common.adapter.util.Logger.d("createInvokeExecutor clsName=" + str);
            return invokeExecutor;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class InvokeExecutor {
        java.lang.Class mCls = null;
        java.lang.Object mObj = null;

        public final int getInt(java.lang.String str) {
            try {
                java.lang.Class cls = this.mCls;
                if (cls != null) {
                    return ((java.lang.Integer) cls.getField(str).get(this.mObj)).intValue();
                }
                return -10000;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                return -10000;
            }
        }

        public final java.lang.String getString(java.lang.String str) {
            try {
                java.lang.Class cls = this.mCls;
                if (cls != null) {
                    return (java.lang.String) cls.getField(str).get(this.mObj);
                }
                return null;
            } catch (java.lang.Exception unused) {
                return null;
            }
        }

        public final boolean hasObject() {
            return this.mObj != null;
        }

        public final java.lang.String invoke(java.lang.String str) {
            java.lang.reflect.Method method;
            try {
                java.lang.Class cls = this.mCls;
                return (cls == null || (method = cls.getMethod(str, null)) == null) ? "" : (java.lang.String) method.invoke(this.mObj, null);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                return "";
            }
        }

        public final io.dcloud.common.adapter.util.InvokeExecutorHelper.InvokeExecutor setInstance(java.lang.Object obj) {
            this.mObj = obj;
            return this;
        }

        public final java.lang.String invoke(java.lang.String str, java.lang.String str2) {
            java.lang.reflect.Method method;
            try {
                java.lang.Class cls = this.mCls;
                return (cls == null || (method = cls.getMethod(str, java.lang.String.class)) == null) ? str2 : (java.lang.String) method.invoke(this.mObj, str2);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                return str2;
            }
        }

        public final boolean invoke(java.lang.String str, java.lang.String str2, boolean z) {
            java.lang.reflect.Method method;
            try {
                java.lang.Class cls = this.mCls;
                if (cls != null && (method = cls.getMethod(str, java.lang.String.class)) != null) {
                    return ((java.lang.Boolean) method.invoke(this.mObj, str2)).booleanValue();
                }
            } catch (java.lang.Exception unused) {
            }
            return z;
        }

        public final java.lang.Object invoke(java.lang.String str, java.lang.Class[] clsArr, java.lang.Object... objArr) {
            java.lang.reflect.Method method;
            try {
                java.lang.Class cls = this.mCls;
                if (cls == null || (method = cls.getMethod(str, clsArr)) == null) {
                    return null;
                }
                return method.invoke(this.mObj, objArr);
            } catch (java.lang.Exception unused) {
                return null;
            }
        }
    }
}
