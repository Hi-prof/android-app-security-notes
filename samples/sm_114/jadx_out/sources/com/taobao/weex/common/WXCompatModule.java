package com.taobao.weex.common;

/* JADX INFO: loaded from: classes.dex */
public abstract class WXCompatModule extends com.taobao.weex.common.WXModule implements com.taobao.weex.common.Destroyable {
    private com.taobao.weex.common.WXCompatModule.ModuleReceive mModuleReceive = new com.taobao.weex.common.WXCompatModule.ModuleReceive(this);

    @Override // com.taobao.weex.common.WXModule
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
    }

    @Override // com.taobao.weex.common.WXModule
    public void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
    }

    public WXCompatModule() {
        androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(com.taobao.weex.WXEnvironment.getApplication()).registerReceiver(this.mModuleReceive, new android.content.IntentFilter(com.taobao.weex.common.WXModule.ACTION_ACTIVITY_RESULT));
        androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(com.taobao.weex.WXEnvironment.getApplication()).registerReceiver(this.mModuleReceive, new android.content.IntentFilter(com.taobao.weex.common.WXModule.ACTION_REQUEST_PERMISSIONS_RESULT));
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(com.taobao.weex.WXEnvironment.getApplication()).unregisterReceiver(this.mModuleReceive);
    }

    static class ModuleReceive extends android.content.BroadcastReceiver {
        private com.taobao.weex.common.WXCompatModule mWXCompatModule;

        ModuleReceive(com.taobao.weex.common.WXCompatModule wXCompatModule) {
            this.mWXCompatModule = wXCompatModule;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            java.lang.String action = intent.getAction();
            action.hashCode();
            if (action.equals(com.taobao.weex.common.WXModule.ACTION_ACTIVITY_RESULT)) {
                this.mWXCompatModule.onActivityResult(intent.getIntExtra(com.taobao.weex.common.WXModule.REQUEST_CODE, -1), intent.getIntExtra(com.taobao.weex.common.WXModule.RESULT_CODE, -1), intent);
            } else if (action.equals(com.taobao.weex.common.WXModule.ACTION_REQUEST_PERMISSIONS_RESULT)) {
                this.mWXCompatModule.onRequestPermissionsResult(intent.getIntExtra(com.taobao.weex.common.WXModule.REQUEST_CODE, -1), intent.getStringArrayExtra("permissions"), intent.getIntArrayExtra(com.taobao.weex.common.WXModule.GRANT_RESULTS));
            }
        }
    }
}
