package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class m3 {
    private static io.dcloud.p.m3 b;
    private java.lang.String a = "";

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private class a implements java.lang.reflect.InvocationHandler {
        android.content.Context a;

        public a(android.content.Context context) {
            this.a = context;
        }

        @Override // java.lang.reflect.InvocationHandler
        public java.lang.Object invoke(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) {
            if (method.getName().equalsIgnoreCase("OnSupport") && objArr != null && objArr.length > 0) {
                ((java.lang.Boolean) objArr[0]).getClass();
                java.lang.Object obj2 = objArr.length > 1 ? objArr[1] : null;
                if (obj2 != null) {
                    java.lang.Object objA = io.dcloud.p.m3.a(obj2, "getOAID", null, new java.lang.Object[0]);
                    java.lang.Object objA2 = io.dcloud.p.m3.a(obj2, "getVAID", null, new java.lang.Object[0]);
                    java.lang.Object objA3 = io.dcloud.p.m3.a(obj2, "getAAID", null, new java.lang.Object[0]);
                    (objA == null ? "" : objA).toString();
                    if (objA2 == null) {
                        objA2 = "";
                    }
                    objA2.toString();
                    if (objA3 == null) {
                        objA3 = "";
                    }
                    objA3.toString();
                    io.dcloud.p.m3.this.a = java.lang.String.valueOf(objA);
                    android.content.Context context = this.a;
                    if (context != null) {
                        io.dcloud.p.e4.a(context, "dcloud-ads", "oaid", java.lang.String.valueOf(objA));
                    }
                }
            }
            return null;
        }
    }

    private m3() {
    }

    private boolean b(android.content.Context context) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException {
        int iA = a(context);
        return (iA == 1008612 || iA == 1008613 || iA == 1008611 || iA != 1008614) ? false : true;
    }

    public java.lang.String c(android.content.Context context) {
        if (android.text.TextUtils.isEmpty(this.a)) {
            if (!b(context)) {
                return "";
            }
            if (context != null) {
                this.a = io.dcloud.p.e4.a(context, "dcloud-ads", "oaid");
            }
        }
        return this.a;
    }

    public static io.dcloud.p.m3 a() {
        if (b == null) {
            synchronized (io.dcloud.p.m3.class) {
                if (b == null) {
                    b = new io.dcloud.p.m3();
                }
            }
        }
        return b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 2 */
    private int a(android.content.Context context) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.bun.miitmdid.core.MdidSdkHelper");
            java.lang.Object objNewProxyInstance = java.lang.reflect.Proxy.newProxyInstance(getClass().getClassLoader(), new java.lang.Class[]{com.bun.supplier.IIdentifierListener.class}, new io.dcloud.p.m3.a(context));
            java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod("InitSdk", android.content.Context.class, java.lang.Boolean.TYPE, com.bun.supplier.IIdentifierListener.class);
            java.lang.Object objInvoke = null;
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                objInvoke = declaredMethod.invoke(null, context, java.lang.Boolean.TRUE, objNewProxyInstance);
            }
            if (objInvoke instanceof java.lang.Integer) {
                return ((java.lang.Integer) objInvoke).intValue();
            }
        } catch (java.lang.Exception unused) {
        }
        return com.bun.miitmdid.core.ErrorCode.INIT_HELPER_CALL_ERROR;
    }

    public static java.lang.Object a(java.lang.Object obj, java.lang.String str, java.lang.Class[] clsArr, java.lang.Object... objArr) {
        if (obj == null) {
            return null;
        }
        try {
            java.lang.reflect.Method method = obj.getClass().getMethod(str, clsArr);
            method.setAccessible(true);
            if (objArr.length == 0) {
                objArr = null;
            }
            return method.invoke(obj, objArr);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }
}
