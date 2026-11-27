package io.dcloud.feature.gg.dcloud;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ADBaseHandler {
    private org.json.JSONObject errorJson;
    protected io.dcloud.feature.gg.dcloud.ADBaseHandler.OnAdsRequestListener listeners;
    protected android.content.Context mContext;
    private int source;
    private long startLoadTime;
    private long totalLoadTime;
    public final int AD_REQUESTING = 0;
    public final int AD_REQUEST_SUCCESS = 1;
    public final int AD_REQUEST_FAIL = -1;
    protected int currentStatus = 0;
    public java.lang.String AD_TAD = "";
    private boolean isShow = false;
    private boolean isBest = false;
    protected java.lang.String errorMsg = "";

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface OnAdsRequestListener {
        void fail(io.dcloud.feature.gg.dcloud.ADBaseHandler aDBaseHandler);

        void success(io.dcloud.feature.gg.dcloud.ADBaseHandler aDBaseHandler);
    }

    public void addRequestListener(io.dcloud.feature.gg.dcloud.ADBaseHandler.OnAdsRequestListener onAdsRequestListener) {
        if (this.listeners == null) {
            this.listeners = onAdsRequestListener;
        }
    }

    public void clearListener() {
        this.listeners = null;
    }

    public void endLoadAds() {
        this.totalLoadTime = java.lang.System.currentTimeMillis() - this.startLoadTime;
    }

    public void execFail(int i, java.lang.String str) {
        this.currentStatus = -1;
        if (this.AD_TAD.equals(io.dcloud.sdk.core.util.Const.TYPE_GDT) && i == 6000) {
            this.errorMsg = i + com.taobao.weex.el.parse.Operators.BRACKET_START_STR + str + com.taobao.weex.el.parse.Operators.BRACKET_END_STR;
        } else {
            this.errorMsg = java.lang.String.valueOf(i);
        }
        if (i != -9999) {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            this.errorJson = jSONObject;
            try {
                jSONObject.put("code", i);
                this.errorJson.put(androidx.core.app.NotificationCompat.CATEGORY_MESSAGE, str);
            } catch (org.json.JSONException unused) {
            }
        }
        io.dcloud.feature.gg.dcloud.ADBaseHandler.OnAdsRequestListener onAdsRequestListener = this.listeners;
        if (onAdsRequestListener != null) {
            onAdsRequestListener.fail(this);
        }
    }

    public void execSuccess() {
        this.currentStatus = 1;
        io.dcloud.feature.gg.dcloud.ADBaseHandler.OnAdsRequestListener onAdsRequestListener = this.listeners;
        if (onAdsRequestListener != null) {
            onAdsRequestListener.success(this);
        }
    }

    public int getAdRequestStatus() {
        return this.currentStatus;
    }

    public java.lang.String getErrorMsg() {
        return this.errorMsg;
    }

    public org.json.JSONObject getResult() {
        org.json.JSONObject jSONObject;
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        try {
            jSONObject2.put("provider", this.AD_TAD);
            int i = this.currentStatus;
            if (i == -1) {
                i = 0;
            }
            jSONObject2.put("ret", i);
            if (this.currentStatus == -1 && (jSONObject = this.errorJson) != null) {
                jSONObject2.put(com.taobao.weex.adapter.IWXUserTrackAdapter.MONITOR_ERROR_MSG, jSONObject);
            }
            jSONObject2.put(com.taobao.weex.common.Constants.Value.TIME, this.totalLoadTime);
        } catch (org.json.JSONException unused) {
        }
        return jSONObject2;
    }

    public int getSource() {
        return this.source;
    }

    public boolean isBest() {
        return this.isBest;
    }

    public boolean isHasContext() {
        return this.mContext != null;
    }

    public boolean isShow() {
        return this.isShow;
    }

    public abstract void onBack();

    public abstract void onCreate(android.content.Context context);

    public abstract android.view.View onCreateSplash(android.content.Context context, java.lang.String str, io.dcloud.common.DHInterface.ICallBack iCallBack);

    public abstract boolean onSplashClose(android.view.View view);

    public void pullAds(android.content.Context context, java.lang.String str, io.dcloud.feature.gg.dcloud.ADBaseHandler.OnAdsRequestListener onAdsRequestListener) {
    }

    public abstract void setAdData(java.lang.String str, java.lang.String str2);

    public void setBest() {
        this.isBest = true;
    }

    public void setShowed() {
        this.isShow = true;
    }

    public void setSource(int i) {
        this.source = i;
    }

    public void startLoadAds() {
        this.startLoadTime = java.lang.System.currentTimeMillis();
    }

    public void pullAds(android.content.Context context) {
        this.currentStatus = 0;
        this.errorMsg = "";
    }
}
