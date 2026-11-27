package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class o3 implements io.dcloud.common.DHInterface.IEventCallback {
    private java.util.HashMap a = new java.util.HashMap();
    android.content.Context b;

    public o3(android.content.Context context) {
        this.b = context;
    }

    @Override // io.dcloud.common.DHInterface.IEventCallback
    public java.lang.Object onCallBack(java.lang.String str, java.lang.Object obj) {
        if ((!io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.EVENTS_WINDOW_CLOSE) && !io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE)) || !(obj instanceof io.dcloud.common.DHInterface.IWebview)) {
            return null;
        }
        io.dcloud.common.DHInterface.IWebview iWebview = (io.dcloud.common.DHInterface.IWebview) obj;
        a(iWebview);
        ((io.dcloud.common.adapter.ui.AdaFrameView) iWebview.obtainFrameView()).removeFrameViewListener(this);
        return null;
    }

    public java.lang.String a(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr) {
        if (str.equals("start")) {
            a(iWebview, strArr[0]);
            ((io.dcloud.common.adapter.ui.AdaFrameView) iWebview.obtainFrameView()).addFrameViewListener(this);
            return "";
        }
        if (str.equals(com.taobao.weex.common.Constants.Value.STOP)) {
            a(iWebview);
        }
        return "";
    }

    private void a(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
        io.dcloud.p.n3 n3Var = (io.dcloud.p.n3) this.a.get(iWebview);
        if (n3Var == null) {
            n3Var = new io.dcloud.p.n3(iWebview, str);
            this.a.put(iWebview, n3Var);
        }
        n3Var.a();
    }

    private void a(io.dcloud.common.DHInterface.IWebview iWebview) {
        io.dcloud.p.n3 n3Var = (io.dcloud.p.n3) this.a.remove(iWebview);
        if (n3Var != null) {
            n3Var.b();
        }
    }
}
