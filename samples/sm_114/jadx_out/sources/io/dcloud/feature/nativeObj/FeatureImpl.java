package io.dcloud.feature.nativeObj;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class FeatureImpl implements io.dcloud.common.DHInterface.IFeature, io.dcloud.common.DHInterface.IWaiter {
    private static java.util.HashMap<java.lang.String, io.dcloud.feature.nativeObj.NativeBitmapMgr> mNativeBitMapMs = new java.util.HashMap<>();
    private java.lang.String mCurrentAppId;
    io.dcloud.common.DHInterface.AbsMgr mFeatureMgr;

    public static void destroyNativeView(java.lang.String str, io.dcloud.feature.nativeObj.NativeView nativeView) {
        if (mNativeBitMapMs.containsKey(str)) {
            mNativeBitMapMs.get(str).destroyNativeView(nativeView);
        }
    }

    public static io.dcloud.common.DHInterface.INativeBitmap getNativeBitmap(java.lang.String str, java.lang.String str2) {
        if (mNativeBitMapMs.containsKey(str)) {
            return mNativeBitMapMs.get(str).getBitmapByUuid(str2);
        }
        return null;
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void dispose(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str)) {
            if (mNativeBitMapMs.containsKey(str)) {
                mNativeBitMapMs.get(str).destroy();
                mNativeBitMapMs.remove(str);
                return;
            }
            return;
        }
        if (str == null) {
            for (java.util.Map.Entry<java.lang.String, io.dcloud.feature.nativeObj.NativeBitmapMgr> entry : mNativeBitMapMs.entrySet()) {
                entry.getValue().destroy();
                mNativeBitMapMs.remove(entry.getValue());
            }
            mNativeBitMapMs.clear();
        }
    }

    @Override // io.dcloud.common.DHInterface.IWaiter
    public java.lang.Object doForFeature(java.lang.String str, java.lang.Object obj) {
        if (str.equals("getNativeBitmap")) {
            java.lang.String[] strArr = (java.lang.String[]) obj;
            return getNativeBitmap(strArr[0], strArr[1]);
        }
        java.lang.String strObtainAppId = ((io.dcloud.common.DHInterface.IFrameView) ((java.lang.Object[]) obj)[0]).obtainApp().obtainAppId();
        if (!mNativeBitMapMs.containsKey(strObtainAppId)) {
            mNativeBitMapMs.put(strObtainAppId, new io.dcloud.feature.nativeObj.NativeBitmapMgr());
        }
        return mNativeBitMapMs.containsKey(strObtainAppId) ? mNativeBitMapMs.get(strObtainAppId).doForFeature(str, obj) : mNativeBitMapMs.get(this.mCurrentAppId).doForFeature(str, obj);
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public java.lang.String execute(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr) {
        java.lang.String strObtainAppId = iWebview.obtainApp().obtainAppId();
        this.mCurrentAppId = strObtainAppId;
        if (!mNativeBitMapMs.containsKey(strObtainAppId)) {
            mNativeBitMapMs.put(this.mCurrentAppId, new io.dcloud.feature.nativeObj.NativeBitmapMgr());
        }
        return mNativeBitMapMs.get(this.mCurrentAppId).execute(iWebview, str, strArr);
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void init(io.dcloud.common.DHInterface.AbsMgr absMgr, java.lang.String str) {
        this.mFeatureMgr = absMgr;
        if (mNativeBitMapMs == null) {
            mNativeBitMapMs = new java.util.HashMap<>();
        }
    }
}
