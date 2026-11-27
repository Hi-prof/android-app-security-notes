package com.taobao.weex.common;

/* JADX INFO: loaded from: classes.dex */
public abstract class WXModule implements com.taobao.weex.common.IWXObject {
    public static final java.lang.String ACTION_ACTIVITY_RESULT = "actionActivityResult";
    public static final java.lang.String ACTION_REQUEST_PERMISSIONS_RESULT = "actionRequestPermissionsResult";
    public static final java.lang.String GRANT_RESULTS = "grantResults";
    public static final java.lang.String PERMISSIONS = "permissions";
    public static final java.lang.String REQUEST_CODE = "requestCode";
    public static final java.lang.String RESULT_CODE = "resultCode";
    private java.util.Map<java.lang.String, java.util.List<java.lang.String>> mEvents = new java.util.HashMap();
    private java.util.Map<java.lang.String, java.lang.Boolean> mKeepAlives = new java.util.HashMap();
    private java.lang.String mModuleName;
    public io.dcloud.feature.uniapp.AbsSDKInstance mUniSDKInstance;
    public com.taobao.weex.WXSDKInstance mWXSDKInstance;

    public boolean onActivityBack() {
        return false;
    }

    public void onActivityCreate() {
    }

    public void onActivityDestroy() {
    }

    public void onActivityPause() {
    }

    public void onActivityResult(int i, int i2, android.content.Intent intent) {
    }

    public void onActivityResume() {
    }

    public void onActivityStart() {
    }

    public void onActivityStop() {
    }

    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        return false;
    }

    public void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
    }

    protected final com.taobao.weex.ui.component.WXComponent findComponent(java.lang.String str) {
        if (this.mWXSDKInstance == null || str == null) {
            return null;
        }
        return com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().getWXComponent(this.mWXSDKInstance.getInstanceId(), str);
    }

    @com.taobao.weex.annotation.JSMethod
    public void addEventListener(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.Object> map) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        boolean z = false;
        if (map != null && map.size() > 0 && map.containsKey("once") && com.taobao.weex.utils.WXUtils.getBoolean(map.get("once"), false).booleanValue()) {
            z = true;
        }
        this.mKeepAlives.put(str2, java.lang.Boolean.valueOf(z));
        if (this.mEvents.get(str) == null) {
            this.mEvents.put(str, new java.util.ArrayList());
        }
        this.mEvents.get(str).add(str2);
    }

    @com.taobao.weex.annotation.JSMethod
    public void removeAllEventListeners(java.lang.String str) {
        if (this.mEvents.containsKey(str)) {
            java.util.Iterator<java.lang.String> it = this.mEvents.remove(str).iterator();
            while (it.hasNext()) {
                this.mKeepAlives.remove(it.next());
            }
        }
    }

    public java.util.List<java.lang.String> getEventCallbacks(java.lang.String str) {
        return this.mEvents.get(str);
    }

    public boolean isOnce(java.lang.String str) {
        return this.mKeepAlives.get(str).booleanValue();
    }

    public java.lang.String getModuleName() {
        return this.mModuleName;
    }

    public void setModuleName(java.lang.String str) {
        this.mModuleName = str;
    }
}
