package io.dcloud.js.geolocation;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class GeolocationFeatureImpl implements io.dcloud.common.DHInterface.IFeature {
    private io.dcloud.p.p1 a;
    private boolean b = false;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a extends io.dcloud.common.adapter.util.PermissionUtil.StreamPermissionRequest {
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.String[] c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(io.dcloud.common.DHInterface.IApp iApp, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr) {
            super(iApp);
            this.a = iWebview;
            this.b = str;
            this.c = strArr;
        }

        @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
        public void onDenied(java.lang.String str) {
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.a, this.c[0], io.dcloud.common.constant.DOMException.toJSON(22, io.dcloud.common.constant.DOMException.MSG_GEOLOCATION_PERMISSION_ERROR), io.dcloud.common.util.JSUtil.ERROR, true, false);
        }

        @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
        public void onGranted(java.lang.String str) {
            if (io.dcloud.js.geolocation.GeolocationFeatureImpl.this.b) {
                return;
            }
            io.dcloud.js.geolocation.GeolocationFeatureImpl.this.b = true;
            io.dcloud.js.geolocation.GeolocationFeatureImpl.this.a.a(this.a, this.b, this.c);
        }
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void dispose(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            this.a.a();
        }
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public java.lang.String execute(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr) {
        if (io.dcloud.common.DHInterface.FeatureMessageDispatcher.contains("record_address")) {
            this.a.a(iWebview, str, strArr);
            return null;
        }
        io.dcloud.common.util.AppRuntime.checkPrivacyComplianceAndPrompt(iWebview.getContext(), "Geolocation-" + str);
        this.b = false;
        io.dcloud.common.adapter.util.PermissionUtil.usePermission(iWebview.getActivity(), io.dcloud.common.DHInterface.IFeature.F_GEOLOCATION, io.dcloud.common.adapter.util.PermissionUtil.PMS_LOCATION, 2, new io.dcloud.js.geolocation.GeolocationFeatureImpl.a(iWebview.obtainApp(), iWebview, str, strArr));
        return null;
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void init(io.dcloud.common.DHInterface.AbsMgr absMgr, java.lang.String str) {
        this.a = new io.dcloud.p.p1(absMgr);
    }
}
