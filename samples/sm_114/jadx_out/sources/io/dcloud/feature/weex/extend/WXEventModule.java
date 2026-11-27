package io.dcloud.feature.weex.extend;

/* JADX INFO: loaded from: classes2.dex */
public class WXEventModule extends com.taobao.weex.common.WXModule {
    private static final int CAMERA_PERMISSION_REQUEST_CODE = 9;

    @Override // com.taobao.weex.common.WXModule
    public void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = true)
    public void openURL(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        java.lang.String scheme = android.net.Uri.parse(str).getScheme();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (android.text.TextUtils.equals("http", scheme) || android.text.TextUtils.equals("https", scheme) || android.text.TextUtils.equals("file", scheme)) {
            sb.append(str);
        } else {
            sb.append("http:");
            sb.append(str);
        }
        android.net.Uri uri = android.net.Uri.parse(sb.toString());
        android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW", uri);
        intent.setData(uri);
        this.mWXSDKInstance.getContext().startActivity(intent);
        if (this.mWXSDKInstance.checkModuleEventRegistered("event", this)) {
            this.mWXSDKInstance.fireModuleEvent("event", this, new java.util.HashMap());
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = true)
    public void fireNativeGlobalEvent(java.lang.String str, com.taobao.weex.bridge.JSCallback jSCallback) {
        java.util.HashMap map = new java.util.HashMap();
        map.put("eventParam", "value");
        this.mWXSDKInstance.fireGlobalEventCallback(str, map);
        if (jSCallback != null) {
            java.util.HashMap map2 = new java.util.HashMap();
            map2.put("ok", true);
            jSCallback.invoke(map2);
        }
    }
}
