package io.dcloud.js.geolocation.system;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class LocalGeoManager extends io.dcloud.js.geolocation.GeoManagerBase {
    public static final java.lang.String TAG = "LocalGeoManager";
    private io.dcloud.js.geolocation.system.a a;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements io.dcloud.common.DHInterface.IEventCallback {
        a() {
        }

        @Override // io.dcloud.common.DHInterface.IEventCallback
        public java.lang.Object onCallBack(java.lang.String str, java.lang.Object obj) {
            if ((!io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.EVENTS_WINDOW_CLOSE) && !io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE)) || !(obj instanceof io.dcloud.common.DHInterface.IWebview)) {
                return null;
            }
            if (io.dcloud.js.geolocation.system.LocalGeoManager.this.a != null) {
                io.dcloud.js.geolocation.system.LocalGeoManager.this.a.c(io.dcloud.js.geolocation.system.a.u);
            }
            ((io.dcloud.common.adapter.ui.AdaFrameView) ((io.dcloud.common.DHInterface.IWebview) obj).obtainFrameView()).removeFrameViewListener(this);
            return null;
        }
    }

    public LocalGeoManager(android.content.Context context) {
        super(context);
    }

    @Override // io.dcloud.js.geolocation.GeoManagerBase
    public java.lang.String execute(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr) {
        try {
            try {
                if (str.equals("getCurrentPosition")) {
                    boolean z = java.lang.Boolean.parseBoolean(strArr[1]);
                    int i = java.lang.Integer.parseInt(strArr[2]);
                    java.lang.String str2 = strArr.length > 7 ? strArr[6] : "null";
                    int i2 = !"null".equals(str2) ? java.lang.Integer.parseInt(str2) : com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT;
                    if (!io.dcloud.common.util.PdrUtil.isEquals(strArr[3], "wgs84") && !io.dcloud.common.util.PdrUtil.isEmpty(strArr[3])) {
                        io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, strArr[0], io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, 17, "only support wgs84"), io.dcloud.common.util.JSUtil.ERROR, true, false);
                        return "";
                    }
                    getCurrentLocation(iWebview, strArr[0], z, i, i2);
                    return "";
                }
                try {
                    try {
                        if (str.equals("watchPosition")) {
                            boolean z2 = java.lang.Boolean.parseBoolean(strArr[2]);
                            iWebview.obtainFrameView().addFrameViewListener(new io.dcloud.js.geolocation.system.LocalGeoManager.a());
                            boolean z3 = io.dcloud.common.util.PdrUtil.isEquals(strArr[3], "wgs84") || io.dcloud.common.util.PdrUtil.isEmpty(strArr[3]);
                            java.lang.String str3 = strArr.length > 7 ? strArr[6] : "null";
                            int i3 = !"null".equals(str3) ? java.lang.Integer.parseInt(str3) : Integer.MAX_VALUE;
                            java.lang.String str4 = strArr.length > 8 ? strArr[7] : "5000";
                            int i4 = !str4.equals("null") ? java.lang.Integer.parseInt(str4) : com.nostra13.dcloudimageloader.core.download.BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT;
                            if (i4 < 1000) {
                                i4 = 1000;
                            }
                            if (z3) {
                                start(iWebview, strArr[0], strArr[1], z2, i3, i4);
                                return "";
                            }
                            io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, strArr[0], io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, 17, "only support wgs84"), io.dcloud.common.util.JSUtil.ERROR, true, false);
                            return "";
                        }
                        if (str.equals("clearWatch")) {
                            stop(strArr[0]);
                            return "";
                        }
                    } catch (java.lang.Exception unused) {
                    }
                } catch (java.lang.Exception unused2) {
                }
                return "";
            } catch (java.lang.Exception unused3) {
            }
        } catch (java.lang.Exception unused4) {
        }
    }

    public void getCurrentLocation(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, boolean z, int i, int i2) {
        a().a(iWebview, i, str, i2);
    }

    @Override // io.dcloud.js.geolocation.GeoManagerBase
    public void onDestroy() {
        io.dcloud.js.geolocation.system.a aVar = this.a;
        if (aVar != null) {
            aVar.a();
        }
        this.a = null;
    }

    public void start(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2, boolean z, int i, int i2) {
        if (a().b(iWebview, i2, str, i)) {
            this.keySet.add(str2);
        }
    }

    public void stop(java.lang.String str) {
        if (this.a == null || !this.keySet.contains(str)) {
            return;
        }
        this.keySet.remove(str);
        this.a.c(io.dcloud.js.geolocation.system.a.u);
    }

    io.dcloud.js.geolocation.system.a a() {
        if (this.a == null) {
            this.a = new io.dcloud.js.geolocation.system.a(this.mContext, "");
        }
        return this.a;
    }
}
