package io.dcloud.feature.pdr;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class CoreCacheFeatureImpl implements io.dcloud.common.DHInterface.IFeature {
    @Override // io.dcloud.common.DHInterface.IFeature
    public void dispose(java.lang.String str) {
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public java.lang.String execute(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr) {
        if (str.equals("clear")) {
            try {
                io.dcloud.common.adapter.io.DHFile.deleteFile(iWebview.obtainFrameView().obtainApp().obtainAppWebCachePath());
                io.dcloud.common.adapter.io.DHFile.delete(iWebview.getContext().getCacheDir());
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
            io.dcloud.common.util.Deprecated_JSUtil.excCallbackSuccess(iWebview, strArr[0], "");
            return null;
        }
        if (str.equals("calculate")) {
            java.io.File file = new java.io.File(iWebview.obtainFrameView().obtainApp().obtainAppWebCachePath());
            io.dcloud.common.util.JSUtil.execCallback(iWebview, strArr[0], (file.exists() ? io.dcloud.common.adapter.io.DHFile.getFileSize(file) : 0L) + io.dcloud.common.adapter.io.DHFile.getFileSize(iWebview.getContext().getCacheDir()), io.dcloud.common.util.JSUtil.OK, false);
            return null;
        }
        if (!str.equals("setMaxSize")) {
            return null;
        }
        long j = java.lang.Long.parseLong(strArr[0]);
        android.content.SharedPreferences.Editor editorEdit = iWebview.getContext().getSharedPreferences(iWebview.obtainFrameView().obtainApp().obtainAppId(), 0).edit();
        editorEdit.putLong("maxSize", j);
        editorEdit.commit();
        return null;
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void init(io.dcloud.common.DHInterface.AbsMgr absMgr, java.lang.String str) {
    }
}
