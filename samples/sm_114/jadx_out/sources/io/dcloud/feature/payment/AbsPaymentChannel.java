package io.dcloud.feature.payment;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsPaymentChannel implements io.dcloud.common.DHInterface.IReflectAble {
    private java.lang.String a;
    protected java.lang.String description;
    protected java.lang.String featureName;
    protected java.lang.String id;
    protected android.content.Context mContext;
    protected final io.dcloud.feature.payment.IPaymentListener mListener = new io.dcloud.feature.payment.AbsPaymentChannel.a();
    protected io.dcloud.common.DHInterface.IWebview mWebview;
    protected java.lang.String name;
    protected boolean serviceReady;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements io.dcloud.feature.payment.IPaymentListener {
        a() {
        }

        @Override // io.dcloud.feature.payment.IPaymentListener
        public void onError(int i, java.lang.String str) {
            java.lang.String json = io.dcloud.common.constant.DOMException.toJSON(i, str);
            io.dcloud.feature.payment.AbsPaymentChannel absPaymentChannel = io.dcloud.feature.payment.AbsPaymentChannel.this;
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(absPaymentChannel.mWebview, absPaymentChannel.a, json, io.dcloud.common.util.JSUtil.ERROR, true, false);
        }

        @Override // io.dcloud.feature.payment.IPaymentListener
        public void onSuccess(io.dcloud.feature.payment.PaymentResult paymentResult) {
            io.dcloud.feature.payment.AbsPaymentChannel absPaymentChannel = io.dcloud.feature.payment.AbsPaymentChannel.this;
            io.dcloud.common.util.JSUtil.execCallback(absPaymentChannel.mWebview, absPaymentChannel.a, paymentResult.toJSONObject(), io.dcloud.common.util.JSUtil.OK, false);
        }
    }

    public java.lang.String getFullDescription() {
        return this.featureName + this.description;
    }

    public void init(android.content.Context context) {
        this.mContext = context;
    }

    protected abstract void installService();

    protected void isReadyToPay(java.lang.String str, java.lang.String str2) {
    }

    protected abstract void request(java.lang.String str);

    public org.json.JSONObject toJSONObject() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("id", this.id);
            jSONObject.put("description", this.description);
            jSONObject.put("serviceReady", this.serviceReady);
            return jSONObject;
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public void updateWebview(io.dcloud.common.DHInterface.IWebview iWebview) {
        this.mWebview = iWebview;
    }

    final void a(java.lang.String str, java.lang.String str2) {
        this.a = str2;
        request(str);
    }
}
