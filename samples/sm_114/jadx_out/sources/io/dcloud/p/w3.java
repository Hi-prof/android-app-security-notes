package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class w3 implements io.dcloud.common.DHInterface.IEventCallback {
    java.util.HashMap a = new java.util.HashMap();

    public java.lang.String a(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr) {
        io.dcloud.p.v3 v3Var;
        if (str.equals("getCurrentProximity")) {
            java.lang.String str2 = strArr[0];
            io.dcloud.p.v3 v3Var2 = (io.dcloud.p.v3) this.a.get(iWebview);
            if (v3Var2 == null) {
                v3Var2 = new io.dcloud.p.v3(iWebview);
                this.a.put(iWebview, v3Var2);
            }
            v3Var2.d = str2;
            v3Var2.a();
            return null;
        }
        if (!str.equals("start")) {
            if (!str.equals(com.taobao.weex.common.Constants.Value.STOP) || (v3Var = (io.dcloud.p.v3) this.a.get(iWebview)) == null) {
                return null;
            }
            v3Var.b();
            return null;
        }
        java.lang.String str3 = strArr[0];
        ((io.dcloud.common.adapter.ui.AdaFrameView) iWebview.obtainFrameView()).addFrameViewListener(this);
        io.dcloud.p.v3 v3Var3 = (io.dcloud.p.v3) this.a.get(iWebview);
        if (v3Var3 == null) {
            v3Var3 = new io.dcloud.p.v3(iWebview);
            this.a.put(iWebview, v3Var3);
        }
        v3Var3.e = str3;
        v3Var3.a();
        return null;
    }

    @Override // io.dcloud.common.DHInterface.IEventCallback
    public java.lang.Object onCallBack(java.lang.String str, java.lang.Object obj) {
        if ((!io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.EVENTS_WINDOW_CLOSE) && !io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE)) || !(obj instanceof io.dcloud.common.DHInterface.IWebview)) {
            return null;
        }
        io.dcloud.common.DHInterface.IWebview iWebview = (io.dcloud.common.DHInterface.IWebview) obj;
        io.dcloud.p.v3 v3Var = (io.dcloud.p.v3) this.a.remove(iWebview);
        if (v3Var != null) {
            v3Var.b();
        }
        ((io.dcloud.common.adapter.ui.AdaFrameView) iWebview.obtainFrameView()).removeFrameViewListener(this);
        return null;
    }
}
