package io.dcloud.feature.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class d extends io.dcloud.feature.ui.b implements io.dcloud.common.DHInterface.IEventCallback {
    java.util.ArrayList u;
    io.dcloud.common.DHInterface.IFrameView v;

    public d(java.lang.String str, java.util.ArrayList arrayList, org.json.JSONObject jSONObject) {
        super(str);
        this.u = arrayList;
    }

    @Override // io.dcloud.feature.ui.b
    public void a(int i, int i2, int i3, int i4, int i5, int i6) {
    }

    @Override // io.dcloud.feature.ui.b
    public io.dcloud.common.adapter.ui.AdaFrameItem d() {
        return (io.dcloud.common.adapter.ui.AdaFrameItem) this.v;
    }

    @Override // io.dcloud.feature.ui.b
    protected void e() {
    }

    public void i() {
        this.c.c(this.v);
        java.util.ArrayList arrayList = this.u;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            java.lang.Object obj = arrayList.get(i);
            i++;
            io.dcloud.common.DHInterface.IFrameView iFrameView = (io.dcloud.common.DHInterface.IFrameView) obj;
            this.c.c(iFrameView);
            ((io.dcloud.common.adapter.ui.AdaFrameView) iFrameView).isChildOfFrameView = true;
        }
    }

    @Override // io.dcloud.common.DHInterface.IEventCallback
    public java.lang.Object onCallBack(java.lang.String str, java.lang.Object obj) {
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.EVENTS_PAGER_SELECTED)) {
            a(str, io.dcloud.common.util.PdrUtil.isEmpty(obj) ? null : java.lang.String.valueOf(obj), false);
        }
        return null;
    }

    public void a(boolean z) {
        this.v.setVisible(z, true);
    }

    public void a(io.dcloud.common.DHInterface.IFrameView iFrameView) {
        this.v = iFrameView;
    }

    @Override // io.dcloud.feature.ui.b
    public java.lang.String a(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, org.json.JSONArray jSONArray) {
        try {
            if ("addEventListener".equals(str) && iWebview != null) {
                a(jSONArray.getString(1), jSONArray.getString(0), (java.lang.String) this.b.get(iWebview.getWebviewANID()));
                return null;
            }
            "setSelectIndex".equals(str);
            return null;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
