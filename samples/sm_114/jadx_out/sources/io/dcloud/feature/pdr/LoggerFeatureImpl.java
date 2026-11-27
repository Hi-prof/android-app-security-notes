package io.dcloud.feature.pdr;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class LoggerFeatureImpl implements io.dcloud.common.DHInterface.IFeature {
    @Override // io.dcloud.common.DHInterface.IFeature
    public void dispose(java.lang.String str) {
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public java.lang.String execute(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr) throws java.lang.Throwable {
        if (!str.equals(com.taobao.weex.common.WXConfig.logLevel)) {
            if (!str.equals("clear")) {
                return null;
            }
            try {
                io.dcloud.common.adapter.io.DHFile.deleteFile(iWebview.obtainFrameView().obtainApp().obtainAppLog());
                return null;
            } catch (java.io.IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        io.dcloud.p.z2.a(iWebview.obtainFrameView().obtainApp().obtainAppLog());
        if (strArr[0].equals("LOG")) {
            io.dcloud.p.z2.d("LOG", strArr[1]);
            return null;
        }
        if (strArr[0].equals("ERROR")) {
            io.dcloud.p.z2.e("ERROR", strArr[1]);
            return null;
        }
        if (strArr[0].equals("WARN")) {
            io.dcloud.p.z2.a("WARN", strArr[1]);
            return null;
        }
        if (strArr[0].equals("INFO")) {
            io.dcloud.p.z2.i("INFO", strArr[1]);
            return null;
        }
        strArr[0].equals("ASSERT");
        return null;
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void init(io.dcloud.common.DHInterface.AbsMgr absMgr, java.lang.String str) {
    }
}
