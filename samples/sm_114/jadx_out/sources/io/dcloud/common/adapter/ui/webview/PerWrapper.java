package io.dcloud.common.adapter.ui.webview;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class PerWrapper {
    public java.lang.String action;
    public org.json.JSONArray args;
    public boolean async;
    private java.lang.Object result;
    public java.lang.String service;
    public io.dcloud.common.adapter.ui.AdaWebview webview;

    public PerWrapper(java.lang.Object obj, io.dcloud.common.adapter.ui.AdaWebview adaWebview, java.lang.String str, java.lang.String str2, org.json.JSONArray jSONArray, boolean z) {
        this.result = obj;
        this.webview = adaWebview;
        this.service = str;
        this.action = str2;
        this.args = jSONArray;
        this.async = z;
    }

    public void confirm(java.lang.String str) {
        java.lang.Object obj = this.result;
        if (obj != null) {
            io.dcloud.common.adapter.util.PlatformUtil.invokeMethod(obj, "confirm", new java.lang.Class[]{java.lang.String.class}, str);
        }
    }
}
