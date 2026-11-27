package io.dcloud.feature.payment;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public final class PaymentResult implements io.dcloud.common.DHInterface.IReflectAble {
    io.dcloud.feature.payment.AbsPaymentChannel a;
    public java.lang.String description;
    public java.lang.String rawDataJson;
    public java.lang.String signature;
    public java.lang.String tradeno;
    public java.lang.String url;

    public PaymentResult(io.dcloud.feature.payment.AbsPaymentChannel absPaymentChannel) {
        this.a = absPaymentChannel;
    }

    public org.json.JSONObject toJSONObject() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put(io.dcloud.common.constant.AbsoluteConst.XML_CHANNEL, this.a.toJSONObject());
            jSONObject.put("description", this.description);
            jSONObject.put("url", this.url);
            jSONObject.put("signature", this.signature);
            jSONObject.put("tradeno", this.tradeno);
            if (!io.dcloud.common.util.PdrUtil.isEmpty(this.rawDataJson)) {
                jSONObject.put("rawdata", new org.json.JSONObject(this.rawDataJson).toString());
            }
            return jSONObject;
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }
}
