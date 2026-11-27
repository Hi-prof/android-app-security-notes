package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class y1 {
    private static boolean a = false;
    private static java.lang.String[] b = null;
    private static boolean c = false;
    private static java.lang.String d = null;
    private static boolean e = false;
    private static java.lang.String f = null;
    private static boolean g = false;
    private static java.lang.String h;

    public static java.lang.String a(android.content.Context context) {
        if (!io.dcloud.sdk.poly.base.utils.PrivacyManager.getInstance().d()) {
            return f;
        }
        if (!io.dcloud.p.c0.a().a(context)) {
            return f;
        }
        if (io.dcloud.sdk.poly.base.utils.PrivacyManager.getInstance().e()) {
            java.lang.String strC = io.dcloud.sdk.poly.base.utils.PrivacyManager.getInstance().c();
            f = strC;
            return strC;
        }
        if (!e) {
            f = android.provider.Settings.System.getString(context.getContentResolver(), "android_id");
            e = true;
        }
        return f;
    }

    private static java.lang.String b(android.content.Context context) {
        try {
            return ((android.telephony.TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static java.lang.String c(android.content.Context context) {
        java.lang.String str;
        java.lang.String strB;
        if (context == null) {
            return "";
        }
        try {
            if (androidx.core.content.ContextCompat.checkSelfPermission(context, com.hjq.permissions.Permission.READ_PHONE_STATE) != 0) {
                return d;
            }
            if (!io.dcloud.sdk.poly.base.utils.PrivacyManager.getInstance().d()) {
                return d;
            }
            if (!io.dcloud.p.c0.a().a(context)) {
                return d;
            }
            if (io.dcloud.sdk.poly.base.utils.PrivacyManager.getInstance().e()) {
                java.lang.String strB2 = io.dcloud.sdk.poly.base.utils.PrivacyManager.getInstance().b();
                d = strB2;
                return strB2;
            }
            if (c) {
                return d;
            }
            int iB = b(0, context);
            int iB2 = b(1, context);
            if (iB != -1 || iB2 != -1) {
                str = (java.lang.String) a(iB, context);
                java.lang.String str2 = (java.lang.String) a(iB2, context);
                if (!android.text.TextUtils.isEmpty(str)) {
                    try {
                        if (!android.text.TextUtils.isEmpty(str2) && !str.equals(str2)) {
                            strB = str + "," + str2;
                        }
                    } catch (java.lang.Exception unused) {
                    }
                } else if (android.text.TextUtils.isEmpty(str2)) {
                    strB = b(context);
                } else {
                    str = str2;
                }
                c = true;
                d = str;
                return str;
            }
            strB = b(context);
            str = strB;
            c = true;
            d = str;
            return str;
        } catch (java.lang.Exception unused2) {
            str = null;
        }
    }

    public static java.lang.String d(android.content.Context context) {
        if (androidx.core.content.ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_WIFI_STATE") != 0) {
            return h;
        }
        if (!io.dcloud.sdk.poly.base.utils.PrivacyManager.getInstance().d()) {
            return h;
        }
        if (!io.dcloud.p.c0.a().a(context)) {
            return h;
        }
        if (g) {
            return h;
        }
        android.net.wifi.WifiInfo connectionInfo = ((android.net.wifi.WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        java.lang.String macAddress = connectionInfo == null ? null : connectionInfo.getMacAddress();
        h = macAddress;
        g = true;
        return macAddress;
    }

    public static java.lang.String[] e(android.content.Context context) {
        java.lang.String deviceId;
        java.lang.String deviceId2;
        if (context == null) {
            return null;
        }
        if (androidx.core.content.ContextCompat.checkSelfPermission(context, com.hjq.permissions.Permission.READ_PHONE_STATE) != 0) {
            return b;
        }
        if (!io.dcloud.sdk.poly.base.utils.PrivacyManager.getInstance().d()) {
            return b;
        }
        if (!io.dcloud.p.c0.a().a(context)) {
            return b;
        }
        if (io.dcloud.sdk.poly.base.utils.PrivacyManager.getInstance().e()) {
            java.lang.String[] strArrA = io.dcloud.sdk.poly.base.utils.PrivacyManager.getInstance().a();
            b = strArrA;
            return strArrA;
        }
        if (a) {
            return b;
        }
        android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone");
        try {
            deviceId = telephonyManager.getDeviceId();
            deviceId2 = telephonyManager.getDeviceId(1);
            if (a(deviceId)) {
                deviceId = null;
            }
            try {
                if (a(deviceId2)) {
                    deviceId2 = null;
                }
            } catch (java.lang.Exception unused) {
            }
        } catch (java.lang.Exception unused2) {
            deviceId = null;
        }
        if (!a(deviceId) && !a(deviceId2)) {
            b = new java.lang.String[]{deviceId, deviceId2};
        } else if (!a(deviceId)) {
            b = new java.lang.String[]{deviceId};
        } else if (a(deviceId2)) {
            b = null;
        } else {
            b = new java.lang.String[]{deviceId2};
        }
        a = true;
        return b;
    }

    private static int b(int i, android.content.Context context) {
        android.net.Uri uri = android.net.Uri.parse("content://telephony/siminfo");
        android.content.ContentResolver contentResolver = context.getContentResolver();
        android.database.Cursor cursorQuery = null;
        try {
            cursorQuery = contentResolver.query(uri, new java.lang.String[]{"_id", "sim_id"}, "sim_id = ?", new java.lang.String[]{java.lang.String.valueOf(i)}, null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                cursorQuery.close();
                return i2;
            }
            if (cursorQuery == null) {
                return -1;
            }
        } catch (java.lang.Exception unused) {
            if (cursorQuery == null) {
                return -1;
            }
        } catch (java.lang.Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
                throw th;
            }
            throw th;
        }
        cursorQuery.close();
        return -1;
    }

    private static java.lang.Object a(int i, android.content.Context context) {
        try {
            java.lang.Object systemService = context.getSystemService("phone");
            int i2 = android.os.Build.VERSION.SDK_INT;
            if (i2 > 21) {
                return a(systemService.getClass().getName(), "getSubscriberId", systemService, new java.lang.Class[]{java.lang.Integer.TYPE}, new java.lang.Object[]{java.lang.Integer.valueOf(i)});
            }
            if (i2 == 21) {
                return a(systemService.getClass().getName(), "getSubscriberId", systemService, new java.lang.Class[]{java.lang.Long.TYPE}, new java.lang.Object[]{java.lang.Integer.valueOf(i)});
            }
            return null;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    private static java.lang.Object a(java.lang.String str, java.lang.String str2, java.lang.Object obj, java.lang.Class[] clsArr, java.lang.Object[] objArr) {
        try {
            java.lang.reflect.Method method = java.lang.Class.forName(str).getMethod(str2, clsArr);
            if (method == null) {
                return null;
            }
            method.setAccessible(true);
            return method.invoke(obj, objArr);
        } catch (java.lang.ClassNotFoundException | java.lang.NoSuchMethodException | java.lang.Exception unused) {
            return null;
        }
    }

    private static boolean a(java.lang.String str) {
        return android.text.TextUtils.isEmpty(str) || str.contains("Unknown") || str.contains("00000000");
    }
}
