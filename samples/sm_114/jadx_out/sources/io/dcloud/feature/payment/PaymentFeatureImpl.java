package io.dcloud.feature.payment;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class PaymentFeatureImpl implements io.dcloud.common.DHInterface.IFeature {
    java.lang.String a;
    io.dcloud.common.DHInterface.AbsMgr b;
    android.content.Context c;
    java.util.ArrayList d = null;

    private void a(io.dcloud.common.DHInterface.IWebview iWebview) {
        java.util.HashMap map = (java.util.HashMap) this.b.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 4, this.a);
        if (map == null || map.isEmpty()) {
            return;
        }
        for (java.lang.String str : map.keySet()) {
            try {
                java.lang.Object objNewInstance = java.lang.Class.forName((java.lang.String) map.get(str)).newInstance();
                if (objNewInstance instanceof io.dcloud.feature.payment.AbsPaymentChannel) {
                    io.dcloud.feature.payment.AbsPaymentChannel absPaymentChannel = (io.dcloud.feature.payment.AbsPaymentChannel) objNewInstance;
                    absPaymentChannel.init(this.c);
                    absPaymentChannel.name = str;
                    absPaymentChannel.featureName = this.a;
                    if (absPaymentChannel.id == null) {
                        absPaymentChannel.id = str;
                    }
                    this.d.add(absPaymentChannel);
                }
            } catch (java.lang.ClassNotFoundException e) {
                e.printStackTrace();
            } catch (java.lang.IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (java.lang.InstantiationException e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void dispose(java.lang.String str) {
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public java.lang.String execute(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr) {
        io.dcloud.feature.payment.AbsPaymentChannel absPaymentChannelA;
        io.dcloud.common.util.AppRuntime.checkPrivacyComplianceAndPrompt(iWebview.getContext(), "Payment-getUserInfo");
        if ("getChannels".equals(str)) {
            if (this.d.isEmpty()) {
                a(iWebview);
            }
            io.dcloud.common.util.JSUtil.execCallback(iWebview, strArr[0], a(), io.dcloud.common.util.JSUtil.OK, false);
            return null;
        }
        if (io.dcloud.feature.uniapp.adapter.AbsURIAdapter.REQUEST.equals(str)) {
            io.dcloud.feature.payment.AbsPaymentChannel absPaymentChannelA2 = a(strArr[0]);
            java.lang.String str2 = strArr[1];
            java.lang.String str3 = strArr[2];
            if (absPaymentChannelA2 == null) {
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(iWebview, str3, io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_ERROR_INFO, java.lang.Integer.valueOf(io.dcloud.feature.payment.IPaymentListener.CODE_UNKNOWN), "not found channel"), io.dcloud.common.util.JSUtil.ERROR, true, false);
                return null;
            }
            if (absPaymentChannelA2.id.equalsIgnoreCase("wxpay")) {
                android.app.Application application = iWebview.getActivity().getApplication();
                if (application instanceof io.dcloud.application.DCloudApplication) {
                    ((io.dcloud.application.DCloudApplication) application).stopB2FOnce();
                }
            }
            absPaymentChannelA2.updateWebview(iWebview);
            absPaymentChannelA2.a(str2, str3);
            return null;
        }
        if ("installService".equals(str)) {
            io.dcloud.feature.payment.AbsPaymentChannel absPaymentChannelA3 = a(strArr[0]);
            if (absPaymentChannelA3 == null) {
                return null;
            }
            absPaymentChannelA3.updateWebview(iWebview);
            absPaymentChannelA3.installService();
            return null;
        }
        if (!"isReadyToPay".equals(str) || (absPaymentChannelA = a(strArr[0])) == null) {
            return null;
        }
        absPaymentChannelA.updateWebview(iWebview);
        absPaymentChannelA.isReadyToPay(strArr[1], strArr[2]);
        return null;
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void init(io.dcloud.common.DHInterface.AbsMgr absMgr, java.lang.String str) {
        this.a = str;
        this.b = absMgr;
        this.c = absMgr.getContext();
        this.d = new java.util.ArrayList(2);
    }

    private org.json.JSONArray a() {
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        int size = this.d.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(((io.dcloud.feature.payment.AbsPaymentChannel) this.d.get(i)).toJSONObject());
        }
        return jSONArray;
    }

    private io.dcloud.feature.payment.AbsPaymentChannel a(java.lang.String str) {
        java.util.ArrayList arrayList = this.d;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            java.lang.Object obj = arrayList.get(i);
            i++;
            io.dcloud.feature.payment.AbsPaymentChannel absPaymentChannel = (io.dcloud.feature.payment.AbsPaymentChannel) obj;
            if (absPaymentChannel.id.equals(str)) {
                return absPaymentChannel;
            }
        }
        return null;
    }
}
