package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b3 {
    private static org.json.JSONObject a = new org.json.JSONObject();
    private static boolean b = false;
    private static java.util.Map c = new java.util.HashMap();
    private static boolean d = false;

    public static org.json.JSONObject a(android.content.Context context) {
        if (context == null) {
            return a;
        }
        if (androidx.core.content.ContextCompat.checkSelfPermission(context, com.hjq.permissions.Permission.ACCESS_FINE_LOCATION) != 0 && androidx.core.content.ContextCompat.checkSelfPermission(context, com.hjq.permissions.Permission.ACCESS_COARSE_LOCATION) != 0) {
            return a;
        }
        if (!io.dcloud.sdk.poly.base.utils.PrivacyManager.getInstance().d()) {
            return a;
        }
        if (!io.dcloud.p.c0.a().a(context)) {
            return a;
        }
        if (b) {
            return a;
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        android.location.LocationManager locationManager = (android.location.LocationManager) context.getSystemService("location");
        if (locationManager != null) {
            try {
                java.lang.reflect.Method declaredMethod = locationManager.getClass().getDeclaredMethod("getLastKnownLocation", java.lang.String.class);
                declaredMethod.setAccessible(true);
                android.location.Location location = (android.location.Location) declaredMethod.invoke(locationManager, "gps");
                if (location == null && (location = (android.location.Location) declaredMethod.invoke(locationManager, "network")) == null) {
                    location = (android.location.Location) declaredMethod.invoke(locationManager, "passive");
                }
                if (location != null) {
                    java.lang.Class<?> cls = java.lang.Class.forName("android.location.Location");
                    java.lang.reflect.Method method = cls.getMethod("getLongitude", null);
                    java.lang.reflect.Method method2 = cls.getMethod("getLatitude", null);
                    java.lang.reflect.Method method3 = cls.getMethod("getAccuracy", null);
                    java.lang.reflect.Method method4 = cls.getMethod("getTime", null);
                    method.setAccessible(true);
                    jSONObject.put("lon", java.lang.String.valueOf(method.invoke(location, null)));
                    method2.setAccessible(true);
                    jSONObject.put("lat", java.lang.String.valueOf(method2.invoke(location, null)));
                    method3.setAccessible(true);
                    jSONObject.put("accuracy", java.lang.String.valueOf(method3.invoke(location, null)));
                    method4.setAccessible(true);
                    jSONObject.put("ts", java.lang.String.valueOf(method4.invoke(location, null)));
                }
            } catch (java.lang.Exception unused) {
            }
        }
        a = jSONObject;
        b = true;
        return jSONObject;
    }

    public static java.util.Map a(android.content.Context context, java.lang.String str) {
        int i;
        int baseStationId;
        int networkId;
        if (context == null) {
            return c;
        }
        if (androidx.core.content.ContextCompat.checkSelfPermission(context, com.hjq.permissions.Permission.ACCESS_FINE_LOCATION) != 0) {
            return c;
        }
        if (!io.dcloud.sdk.poly.base.utils.PrivacyManager.getInstance().d()) {
            return c;
        }
        if (!io.dcloud.p.c0.a().a(context)) {
            return c;
        }
        if (d) {
            return c;
        }
        if (android.text.TextUtils.isEmpty(str) || str.equals("10")) {
            i = 0;
            baseStationId = 0;
            networkId = 0;
        } else {
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone");
            if (!"03".equals(str) && !"05".equals(str)) {
                if ("01".equals(str) || "06".equals(str)) {
                    i = 3;
                } else {
                    i = ("00".equals(str) || "02".equals(str) || "07".equals(str)) ? 1 : 4;
                }
                android.telephony.gsm.GsmCellLocation gsmCellLocation = (android.telephony.gsm.GsmCellLocation) telephonyManager.getCellLocation();
                networkId = gsmCellLocation.getLac();
                baseStationId = gsmCellLocation.getCid();
            } else {
                android.telephony.cdma.CdmaCellLocation cdmaCellLocation = (android.telephony.cdma.CdmaCellLocation) telephonyManager.getCellLocation();
                networkId = cdmaCellLocation.getNetworkId();
                baseStationId = cdmaCellLocation.getBaseStationId() / 16;
                i = 2;
            }
        }
        java.util.HashMap map = new java.util.HashMap();
        map.put("carrier", java.lang.Integer.valueOf(i));
        map.put("cid", java.lang.Integer.valueOf(baseStationId));
        map.put("lac", java.lang.Integer.valueOf(networkId));
        c = map;
        d = true;
        return map;
    }
}
