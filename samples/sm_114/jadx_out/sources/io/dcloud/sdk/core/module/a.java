package io.dcloud.sdk.core.module;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends io.dcloud.sdk.core.module.DCBaseAOL {
    private int adStatus;
    private org.json.JSONObject errorJson;
    private java.lang.String errorMsg;
    private long loadTotalTime;
    private boolean needReport;
    private long startLoadTime;

    public a(io.dcloud.sdk.core.entry.DCloudAOLSlot dCloudAOLSlot, android.app.Activity activity) {
        super(dCloudAOLSlot, activity);
        this.loadTotalTime = 0L;
        this.adStatus = -1;
        this.errorMsg = "";
        this.needReport = true;
        this.startLoadTime = 0L;
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public int getAdStatus() {
        return this.adStatus;
    }

    public java.lang.String getErrorMsg() {
        return this.errorMsg;
    }

    protected final long getLoadTotalTime() {
        return this.loadTotalTime;
    }

    public org.json.JSONObject getResult() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put(com.taobao.weex.common.Constants.Value.TIME, this.loadTotalTime);
            jSONObject.put("ret", this.adStatus);
            if (this.adStatus == 0) {
                jSONObject.put(com.taobao.weex.adapter.IWXUserTrackAdapter.MONITOR_ERROR_MSG, this.errorJson);
            }
            jSONObject.put("tid", getTid());
            jSONObject.put("mediaId", getAppId());
            jSONObject.put("slotId", getSlotId());
            jSONObject.put("provider", getType());
        } catch (org.json.JSONException unused) {
        }
        return jSONObject;
    }

    public boolean isNeedReport() {
        return this.needReport;
    }

    public void setFail(int i, java.lang.String str) {
        this.needReport = i != -9999;
        io.dcloud.p.c3.b("uniAD", getDCloudId() + ":" + getType() + ":" + i + ":" + str + ";id:" + getSlotId());
        this.adStatus = 0;
        this.loadTotalTime = java.lang.System.currentTimeMillis() - this.startLoadTime;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        this.errorJson = jSONObject;
        try {
            jSONObject.put("code", i);
            this.errorJson.put(androidx.core.app.NotificationCompat.CATEGORY_MESSAGE, str);
        } catch (org.json.JSONException unused) {
        }
        if (getType().equals(io.dcloud.sdk.core.util.Const.TYPE_GDT) && i == 6000) {
            this.errorMsg = getType() + ":" + i + com.taobao.weex.el.parse.Operators.BRACKET_START_STR + str + com.taobao.weex.el.parse.Operators.BRACKET_END_STR;
            return;
        }
        if (getType().equals(io.dcloud.sdk.core.util.Const.TYPE_BD) && i == -1) {
            this.errorMsg = getType() + ":" + str;
            return;
        }
        this.errorMsg = getType() + ":" + i;
    }

    protected void setSlotTimeout() {
        this.loadTotalTime = java.lang.System.currentTimeMillis() - this.startLoadTime;
    }

    protected void setStatus(int i) {
        this.adStatus = i;
    }

    public void setSuccess() {
        io.dcloud.p.c3.b("uniAD", getDCloudId() + ":" + getType() + ":success;id:" + getSlotId());
        this.adStatus = 1;
        this.loadTotalTime = java.lang.System.currentTimeMillis() - this.startLoadTime;
    }

    @Override // io.dcloud.sdk.core.module.DCBaseAOL
    public void startLoadTime() {
        this.startLoadTime = java.lang.System.currentTimeMillis();
    }
}
