package com.taobao.weex;

/* JADX INFO: loaded from: classes.dex */
public class WXGlobalEventReceiver extends android.content.BroadcastReceiver {
    public static final java.lang.String EVENT_ACTION = "wx_global_action";
    public static final java.lang.String EVENT_NAME = "eventName";
    public static final java.lang.String EVENT_PARAMS = "eventParams";
    public static final java.lang.String EVENT_WX_INSTANCEID = "wx_instanceid";
    private com.taobao.weex.WXSDKInstance mWXSDKInstance;

    public WXGlobalEventReceiver() {
    }

    public WXGlobalEventReceiver(com.taobao.weex.WXSDKInstance wXSDKInstance) {
        this.mWXSDKInstance = wXSDKInstance;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        java.lang.String stringExtra = intent.getStringExtra(EVENT_NAME);
        try {
            this.mWXSDKInstance.fireGlobalEventCallback(stringExtra, (java.util.HashMap) com.alibaba.fastjson.JSON.parseObject(intent.getStringExtra(EVENT_PARAMS), java.util.HashMap.class));
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("global-receive", e);
        }
    }
}
