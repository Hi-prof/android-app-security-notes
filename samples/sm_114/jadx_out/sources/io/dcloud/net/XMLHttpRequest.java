package io.dcloud.net;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class XMLHttpRequest implements io.dcloud.common.DHInterface.IReqListener, io.dcloud.common.DHInterface.IResponseListener {
    private static final int ERROR_OTHER_CODE = 1;
    private static final int ERROR_TIME_OUT_CODE = 0;
    private static final int LOADED = 4;
    private static final int RECEIVING = 3;
    private java.lang.String mCallbackId;
    private int mErrorCode = -1;
    private io.dcloud.common.util.net.NetWork mNetWork;
    private int mReadyState;
    private io.dcloud.common.util.net.RequestData mRequestData;
    private int mState;
    private java.lang.String mStatusText;
    public java.lang.String mUUID;
    io.dcloud.common.DHInterface.IWebview mWebview;

    /* JADX INFO: renamed from: io.dcloud.net.XMLHttpRequest$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$dcloud$common$DHInterface$IReqListener$NetState;

        static {
            int[] iArr = new int[io.dcloud.common.DHInterface.IReqListener.NetState.values().length];
            $SwitchMap$io$dcloud$common$DHInterface$IReqListener$NetState = iArr;
            try {
                iArr[io.dcloud.common.DHInterface.IReqListener.NetState.NET_HANDLE_END.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$dcloud$common$DHInterface$IReqListener$NetState[io.dcloud.common.DHInterface.IReqListener.NetState.NET_HANDLE_ING.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$dcloud$common$DHInterface$IReqListener$NetState[io.dcloud.common.DHInterface.IReqListener.NetState.NET_ERROR.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$dcloud$common$DHInterface$IReqListener$NetState[io.dcloud.common.DHInterface.IReqListener.NetState.NET_TIMEOUT.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    public XMLHttpRequest(java.lang.String str, java.lang.String str2, java.lang.String str3, io.dcloud.common.DHInterface.IWebview iWebview) {
        this.mUUID = str;
        io.dcloud.common.util.net.RequestData requestData = new io.dcloud.common.util.net.RequestData(str2, str3);
        this.mRequestData = requestData;
        requestData.unTrustedCAType = iWebview.obtainApp().obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_UNTRUSTEDCA);
        this.mRequestData.addHeader(io.dcloud.common.DHInterface.IWebview.USER_AGENT, iWebview.getWebviewProperty(io.dcloud.common.DHInterface.IWebview.USER_AGENT));
        this.mNetWork = new io.dcloud.common.util.net.NetWork(3, this.mRequestData, this, this);
        this.mWebview = iWebview;
    }

    private org.json.JSONObject headersToJSON(java.util.Map<java.lang.String, java.lang.String> map) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        for (java.lang.String str : map.keySet()) {
            try {
                jSONObject.put(str, map.get(str));
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    private java.lang.String toJsResponseText(java.lang.String str) {
        return io.dcloud.common.util.JSONUtil.toJSONableString(str);
    }

    public io.dcloud.common.util.net.NetWork getNetWork() {
        return this.mNetWork;
    }

    public io.dcloud.common.util.net.RequestData getRequestData() {
        return this.mRequestData;
    }

    @Override // io.dcloud.common.DHInterface.IReqListener
    public void onNetStateChanged(io.dcloud.common.DHInterface.IReqListener.NetState netState, boolean z) {
        if (z) {
            this.mReadyState = 4;
            return;
        }
        int i = io.dcloud.net.XMLHttpRequest.AnonymousClass1.$SwitchMap$io$dcloud$common$DHInterface$IReqListener$NetState[netState.ordinal()];
        if (i == 1) {
            this.mReadyState = 4;
            io.dcloud.common.util.JSUtil.execCallback(this.mWebview, this.mCallbackId, toJSON(), io.dcloud.common.util.JSUtil.OK, true);
            return;
        }
        if (i == 2) {
            this.mReadyState = 3;
            io.dcloud.common.util.JSUtil.execCallback(this.mWebview, this.mCallbackId, toJSON(), io.dcloud.common.util.JSUtil.OK, true);
        } else if (i == 3) {
            this.mReadyState = 4;
            this.mErrorCode = 1;
            io.dcloud.common.util.JSUtil.execCallback(this.mWebview, this.mCallbackId, toJSON(), io.dcloud.common.util.JSUtil.OK, true);
        } else {
            if (i != 4) {
                return;
            }
            this.mReadyState = 4;
            this.mErrorCode = 0;
            io.dcloud.common.util.JSUtil.execCallback(this.mWebview, this.mCallbackId, toJSON(), io.dcloud.common.util.JSUtil.OK, true);
        }
    }

    @Override // io.dcloud.common.DHInterface.IReqListener
    public int onReceiving(java.io.InputStream inputStream) {
        return 0;
    }

    @Override // io.dcloud.common.DHInterface.IResponseListener
    public void onResponseState(int i, java.lang.String str) {
        this.mState = i;
        this.mStatusText = str;
        io.dcloud.common.adapter.util.Logger.d("xhr", "onResponseState pState=" + i + ";mCallbackId=" + this.mCallbackId);
    }

    @Override // io.dcloud.common.DHInterface.IReqListener
    public void onResponsing(java.io.InputStream inputStream) {
    }

    public void setCallbackId(java.lang.String str) {
        this.mCallbackId = str;
    }

    public org.json.JSONObject toJSON() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        java.lang.String responseText = this.mNetWork.getResponseText();
        try {
            jSONObject.put("readyState", this.mReadyState);
            jSONObject.put("status", this.mState);
            jSONObject.put(com.taobao.weex.http.WXStreamModule.STATUS_TEXT, this.mStatusText);
            jSONObject.put("responseText", responseText);
            jSONObject.put(com.taobao.weex.ui.component.WXBasicComponentType.HEADER, headersToJSON(this.mNetWork.getHeadersAndValues()));
            int i = this.mErrorCode;
            if (i > -1) {
                jSONObject.put("error", i);
            }
            return jSONObject;
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }
}
