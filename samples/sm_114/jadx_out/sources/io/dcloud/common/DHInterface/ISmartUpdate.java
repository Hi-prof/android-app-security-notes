package io.dcloud.common.DHInterface;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public interface ISmartUpdate {

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface OnSmartUpdateCallback {
        void onCallback(io.dcloud.common.DHInterface.ISmartUpdate.SmartUpdateCallbackParams smartUpdateCallbackParams);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class SmartUpdateCallbackParams {
        public java.lang.String icon_url;
        public int mode;
        public boolean needUpdate;
        public java.lang.String oldVersion;
        public org.json.JSONObject sitemap;
        public java.lang.String splash_url;
        public int type;
        public java.lang.String updateVersion;
        public java.lang.String url;
        public java.lang.String wap2app_url;

        public SmartUpdateCallbackParams(java.lang.String str) {
            this.needUpdate = false;
            this.type = 1;
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                int iOptInt = jSONObject.optInt("ret", jSONObject.optInt("status", 0) == 1 ? 0 : 1);
                this.url = jSONObject.optString("url");
                this.icon_url = jSONObject.optString("icon_url");
                this.splash_url = jSONObject.optString("splash_url");
                this.wap2app_url = jSONObject.optString("wap2app_url");
                this.sitemap = jSONObject.optJSONObject("sitemap");
                if (iOptInt == 0) {
                    java.lang.String strOptString = jSONObject.optString("type");
                    this.updateVersion = jSONObject.optString("updateVersion");
                    this.needUpdate = true;
                    if (strOptString.equals("wgt")) {
                        this.type = 0;
                    }
                }
                this.mode = jSONObject.optInt("up_mode");
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
    }

    void checkUpdate();

    void reload();

    void update(io.dcloud.common.DHInterface.ISmartUpdate.SmartUpdateCallbackParams smartUpdateCallbackParams);
}
