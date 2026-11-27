package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class DLGeolocation implements io.dcloud.common.DHInterface.IJsInterface {
    io.dcloud.common.DHInterface.IWebview mWebview;

    public DLGeolocation(io.dcloud.common.DHInterface.IWebview iWebview) {
        this.mWebview = iWebview;
    }

    public static boolean checkAmapGeo() {
        try {
            java.lang.Class.forName("io.dcloud.js.geolocation.amap.AMapGeoManager");
            return !io.dcloud.common.util.PdrUtil.isEmpty(io.dcloud.common.adapter.util.AndroidResources.getMetaValue("com.amap.api.v2.apikey"));
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public static boolean checkBDmapGeo() {
        try {
            java.lang.Class.forName("io.dcloud.js.geolocation.baidu.BaiduGeoManager");
            return !io.dcloud.common.util.PdrUtil.isEmpty(io.dcloud.common.adapter.util.AndroidResources.getMetaValue("com.baidu.lbsapi.API_KEY"));
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public static boolean checkGeo(android.content.Context context) {
        return checkAmapGeo() || checkBDmapGeo();
    }

    public static boolean checkInjectGeo(java.lang.String str) {
        if (str.equals("replace") || str.equals("alldevice")) {
            return true;
        }
        return str.equals("auto") && io.dcloud.common.util.BaseInfo.injectionGeolocationJS;
    }

    public static java.lang.String getGEOJS() {
        return "!function(){function t(t,e){t?(this.coordsType=t.coordsType,this.address=t.address,this.addresses=t.addresses,this.coords=new a(t.latitude,t.longitude,t.altitude,t.accuracy,t.heading,t.velocity,t.altitudeAccuracy)):this.coords=new a,this.timestamp=void 0!==e?e:(new Date).getTime()}function a(t,a,e,i,n,o,s){this.latitude=t,this.longitude=a,this.accuracy=void 0!==i?i:null,this.altitude=void 0!==e?e:null,this.heading=void 0!==n?n:null,this.speed=void 0!==o?o:null,(0===this.speed||null===this.speed)&&(this.heading=0/0),this.altitudeAccuracy=void 0!==s?s:null}function e(t,a){if(o(t,a))return[t,a];var e=i(t-105,a-35),s=n(t-105,a-35),d=a/180*c,u=Math.sin(d);u=1-r*u*u;var h=Math.sqrt(u);return e=180*e/(l*(1-r)/(u*h)*c),s=180*s/(l/h*Math.cos(d)*c),mglat=a+e,mglng=t+s,[2*t-mglng,2*a-mglat]}function i(t,a){var e=-100+2*t+3*a+.2*a*a+.1*t*a+.2*Math.sqrt(Math.abs(t));return e+=2*(20*Math.sin(6*t*c)+20*Math.sin(2*t*c))/3,e+=2*(20*Math.sin(a*c)+40*Math.sin(a/3*c))/3,e+=2*(160*Math.sin(a/12*c)+320*Math.sin(a*c/30))/3}function n(t,a){var e=300+t+2*a+.1*t*t+.1*t*a+.1*Math.sqrt(Math.abs(t));return e+=2*(20*Math.sin(6*t*c)+20*Math.sin(2*t*c))/3,e+=2*(20*Math.sin(t*c)+40*Math.sin(t/3*c))/3,e+=2*(150*Math.sin(t/12*c)+300*Math.sin(t/30*c))/3}function o(t,a){return 72.004>t||t>137.8347||.8293>a||a>55.8271||!1}window.__geo__={};var s=__geo__;s.callbacks={},s.callbackId=function(t,a){var e=\"dlgeolocation\"+(new Date).valueOf();return s.callbacks[e]={s:t,e:a},e},s.callbackFromNative=function(a,i){var n=s.callbacks[a];if(n){if(1==i.status){if(n.s){var o=i.message,c=o.longitude,l=o.latitude;if(\"gcj02\"===o.coordsType){var r=e(o.longitude,o.latitude);c=r[0],l=r[1]}var d=new t({latitude:l,longitude:c,altitude:o.altitude,accuracy:o.accuracy,heading:o.heading,velocity:o.velocity,coordsType:\"WGS84\",address:o.address,addresses:o.addresses,altitudeAccuracy:o.altitudeAccuracy},void 0===o.timestamp?(new Date).getTime():o.timestamp instanceof Date?o.timestamp.getTime():o.timestamp);n.s(d)}}else n.e&&n.e(i.message);i.keepCallback||delete s.callbacks[a]}},navigator.geolocation.getCurrentPosition=function(t,a,e){console.log(\"DLGeolocation-------navigator.geolocation.getCurrentPosition\",e);var i=t,n=a||function(){},o=e||{},c=JSON.stringify(o);_dlGeolocation.exec(\"getCurrentPosition\",s.callbackId(function(t){console.log(\"success:\",t),i(t)},function(t){console.log(\"error:\",t),n(t)}),c)},navigator.geolocation.watchPosition=function(t,a,e){var i=t,n=a||function(){},o=e||{},c=JSON.stringify(o);c.id=\"dlwatchPosition\"+(new Date).valueOf(),_dlGeolocation.exec(\"watchPosition\",s.callbackId(i,n),c)},navigator.geolocation.clearwatch=function(t){_dlGeolocation.exec(\"clearwatch\",null,{id:t})};var c=3.141592653589793,l=6378245,r=.006693421622965943}();";
    }

    private java.lang.Object initGeoManager() {
        try {
            if (checkAmapGeo()) {
                return io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.js.geolocation.amap.AMapGeoManager", "getInstance", null, new java.lang.Class[]{android.content.Context.class}, new java.lang.Object[]{this.mWebview.getContext()});
            }
            if (checkBDmapGeo()) {
                return io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.js.geolocation.baidu.BaiduGeoManager", "getInstance", null, new java.lang.Class[]{android.content.Context.class}, new java.lang.Object[]{this.mWebview.getContext()});
            }
            return null;
        } catch (java.lang.Exception e) {
            io.dcloud.common.adapter.util.Logger.e("DLGeolocation", "initGeoManager " + e.getMessage());
            return null;
        }
    }

    @Override // io.dcloud.common.DHInterface.IJsInterface
    public java.lang.String exec(java.lang.String str, java.lang.String str2, org.json.JSONArray jSONArray) {
        return null;
    }

    @Override // io.dcloud.common.DHInterface.IJsInterface
    public void forceStop(java.lang.String str) {
    }

    public java.lang.String[] getGeoArgs(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str2);
            int iOptInt = jSONObject.has("maximumAge") ? jSONObject.optInt("maximumAge") : 0;
            boolean zOptBoolean = jSONObject.has("enableHighAccuracy") ? jSONObject.optBoolean("enableHighAccuracy") : false;
            int iOptInt2 = jSONObject.has("timeout") ? jSONObject.optInt("timeout") : 0;
            boolean zOptBoolean2 = jSONObject.has("geocode") ? jSONObject.optBoolean("geocode") : true;
            if (str.equals("getCurrentPosition")) {
                return new java.lang.String[]{str3, zOptBoolean + "", iOptInt + "", null, null, zOptBoolean2 + "", iOptInt2 + ""};
            }
            if (!str.equals("watchPosition")) {
                if (str.equals("clearwatch")) {
                    return new java.lang.String[]{jSONObject.optString("id")};
                }
                return null;
            }
            return new java.lang.String[]{str3, jSONObject.optString("id"), zOptBoolean + "", "", "", zOptBoolean2 + "", iOptInt2 + "", iOptInt + ""};
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // io.dcloud.common.DHInterface.IJsInterface
    public java.lang.String prompt(java.lang.String str, java.lang.String str2) {
        return null;
    }

    public void runGeolocation(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.String str4;
        if (this.mWebview == null) {
            return;
        }
        try {
            java.lang.Object objInitGeoManager = initGeoManager();
            str4 = str2;
            try {
                objInitGeoManager.getClass().getMethod("execute", io.dcloud.common.DHInterface.IWebview.class, java.lang.String.class, java.lang.String[].class).invoke(objInitGeoManager, this.mWebview, str + "DLGEO", getGeoArgs(str, str3, str4));
            } catch (java.lang.Exception unused) {
                io.dcloud.common.util.JSUtil.execGEOCallback(this.mWebview, str4, io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, -100, this.mWebview.getContext().getString(io.dcloud.base.R.string.dcloud_geo_fail)), io.dcloud.common.util.JSUtil.ERROR, true, false);
            }
        } catch (java.lang.Exception unused2) {
            str4 = str2;
        }
    }

    @Override // io.dcloud.common.DHInterface.IJsInterface
    @android.webkit.JavascriptInterface
    public java.lang.String exec(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        runGeolocation(str, str2, str3);
        return null;
    }
}
