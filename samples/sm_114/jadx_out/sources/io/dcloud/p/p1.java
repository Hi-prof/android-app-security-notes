package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class p1 {
    io.dcloud.common.DHInterface.AbsMgr a;
    io.dcloud.js.geolocation.GeoManagerBase b = null;
    io.dcloud.js.geolocation.GeoManagerBase c = null;
    io.dcloud.js.geolocation.GeoManagerBase d = null;
    boolean e = false;

    public p1(io.dcloud.common.DHInterface.AbsMgr absMgr) {
        this.a = absMgr;
    }

    private io.dcloud.js.geolocation.GeoManagerBase a(java.lang.String str) {
        io.dcloud.js.geolocation.GeoManagerBase geoManagerBase;
        try {
            return (!str.equals("io.dcloud.js.geolocation.amap.AMapGeoManager") || (geoManagerBase = (io.dcloud.js.geolocation.GeoManagerBase) io.dcloud.common.adapter.util.PlatformUtil.invokeMethod(str, "getInstance", null, new java.lang.Class[]{android.content.Context.class}, new java.lang.Object[]{this.a.getContext()})) == null) ? (io.dcloud.js.geolocation.GeoManagerBase) java.lang.Class.forName(str).getConstructor(android.content.Context.class).newInstance(this.a.getContext()) : geoManagerBase;
        } catch (java.lang.Exception unused) {
            android.util.Log.w("geoLoaction", str + " exception");
            return null;
        }
    }

    public java.lang.String a(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr) {
        io.dcloud.js.geolocation.GeoManagerBase geoManagerBaseA;
        if ("clearWatch".equals(str)) {
            io.dcloud.js.geolocation.GeoManagerBase geoManagerBase = this.d;
            if (geoManagerBase != null && geoManagerBase.hasKey(strArr[0])) {
                geoManagerBaseA = this.d;
            } else {
                io.dcloud.js.geolocation.GeoManagerBase geoManagerBase2 = this.c;
                if (geoManagerBase2 != null && geoManagerBase2.hasKey(strArr[0])) {
                    geoManagerBaseA = this.c;
                } else {
                    io.dcloud.js.geolocation.GeoManagerBase geoManagerBase3 = this.b;
                    geoManagerBaseA = (geoManagerBase3 == null || !geoManagerBase3.hasKey(strArr[0])) ? null : this.b;
                }
            }
        } else {
            geoManagerBaseA = a(iWebview, strArr[4], strArr[3], strArr[0]);
        }
        if (geoManagerBaseA != null) {
            geoManagerBaseA.execute(iWebview, str, strArr);
        }
        return null;
    }

    private io.dcloud.js.geolocation.GeoManagerBase a(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        io.dcloud.js.geolocation.GeoManagerBase geoManagerBaseA;
        io.dcloud.js.geolocation.GeoManagerBase geoManagerBaseA2;
        java.lang.String str4 = io.dcloud.common.util.PdrUtil.isEmpty(str2) ? "wgs84" : str2;
        if (io.dcloud.common.util.PdrUtil.isEmpty(str)) {
            if (io.dcloud.common.util.PdrUtil.isEquals(str4, "wgs84")) {
                geoManagerBaseA2 = this.d;
                if (geoManagerBaseA2 == null) {
                    geoManagerBaseA2 = a("io.dcloud.js.geolocation.system.LocalGeoManager");
                }
                this.d = geoManagerBaseA2;
            } else if (io.dcloud.common.util.PdrUtil.isEquals(str4, "gcj02")) {
                geoManagerBaseA2 = this.c;
                if (geoManagerBaseA2 == null) {
                    geoManagerBaseA2 = a("io.dcloud.js.geolocation.amap.AMapGeoManager");
                }
                this.c = geoManagerBaseA2;
                if (geoManagerBaseA2 == null) {
                    if (geoManagerBaseA2 == null) {
                        geoManagerBaseA2 = a("io.dcloud.js.geolocation.baidu.BaiduGeoManager");
                    }
                    this.c = geoManagerBaseA2;
                }
            } else if (io.dcloud.common.util.PdrUtil.isEquals(str4, "bd09") || io.dcloud.common.util.PdrUtil.isEquals(str4, "bd09ll") || io.dcloud.common.util.PdrUtil.isEquals(str4, "gcj02")) {
                geoManagerBaseA2 = this.c;
                if (geoManagerBaseA2 == null) {
                    geoManagerBaseA2 = a("io.dcloud.js.geolocation.baidu.BaiduGeoManager");
                }
                this.c = geoManagerBaseA2;
            } else {
                geoManagerBaseA2 = null;
            }
            if (geoManagerBaseA2 == null) {
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str3, io.dcloud.common.constant.DOMException.toJSON(18, "not support " + str4), io.dcloud.common.util.JSUtil.ERROR, true, false);
            }
            return geoManagerBaseA2;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals("baidu", str)) {
            geoManagerBaseA = this.b;
            if (geoManagerBaseA == null) {
                geoManagerBaseA = a("io.dcloud.js.geolocation.baidu.BaiduGeoManager");
            }
            this.b = geoManagerBaseA;
        } else if (io.dcloud.common.util.PdrUtil.isEquals("amap", str)) {
            geoManagerBaseA = this.c;
            if (geoManagerBaseA == null) {
                geoManagerBaseA = a("io.dcloud.js.geolocation.amap.AMapGeoManager");
            }
            this.c = geoManagerBaseA;
        } else {
            geoManagerBaseA = this.d;
            if (geoManagerBaseA == null) {
                geoManagerBaseA = a("io.dcloud.js.geolocation.system.LocalGeoManager");
            }
            this.d = geoManagerBaseA;
        }
        if (geoManagerBaseA == null) {
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str3, io.dcloud.common.constant.DOMException.toJSON(17, io.dcloud.common.constant.DOMException.MSG_GEOLOCATION_PROVIDER_ERROR), io.dcloud.common.util.JSUtil.ERROR, true, false);
        }
        return geoManagerBaseA;
    }

    public void a() {
        io.dcloud.js.geolocation.GeoManagerBase geoManagerBase = this.b;
        if (geoManagerBase != null) {
            geoManagerBase.onDestroy();
        }
        io.dcloud.js.geolocation.GeoManagerBase geoManagerBase2 = this.d;
        if (geoManagerBase2 != null) {
            geoManagerBase2.onDestroy();
        }
        io.dcloud.js.geolocation.GeoManagerBase geoManagerBase3 = this.c;
        if (geoManagerBase3 != null) {
            geoManagerBase3.onDestroy();
        }
    }
}
