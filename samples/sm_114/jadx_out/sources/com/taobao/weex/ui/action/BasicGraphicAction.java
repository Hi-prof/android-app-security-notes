package com.taobao.weex.ui.action;

/* JADX INFO: loaded from: classes.dex */
public abstract class BasicGraphicAction implements com.taobao.weex.ui.action.IExecutable, java.lang.Runnable {
    public static final int ActionTypeBatchBegin = 1;
    public static final int ActionTypeBatchEnd = 2;
    public static final int ActionTypeNormal = 0;
    private com.taobao.weex.WXSDKInstance mInstance;
    private final java.lang.String mRef;
    public int mActionType = 0;
    public boolean mIsRunByBatch = false;

    public BasicGraphicAction(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str) {
        this.mInstance = wXSDKInstance;
        this.mRef = str;
    }

    public final com.taobao.weex.WXSDKInstance getWXSDKIntance() {
        return this.mInstance;
    }

    public final java.lang.String getPageId() {
        com.taobao.weex.WXSDKInstance wXSDKInstance = this.mInstance;
        if (wXSDKInstance != null) {
            return wXSDKInstance.getInstanceId();
        }
        return null;
    }

    public final java.lang.String getRef() {
        return this.mRef;
    }

    public void executeActionOnRender() {
        com.taobao.weex.WXSDKInstance wXSDKInstance = this.mInstance;
        if (wXSDKInstance != null) {
            if (android.text.TextUtils.isEmpty(wXSDKInstance.getInstanceId())) {
                com.taobao.weex.utils.WXLogUtils.e("[BasicGraphicAction] pageId can not be null");
                if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                    throw new java.lang.RuntimeException(com.taobao.weex.el.parse.Operators.ARRAY_START_STR + getClass().getName() + "] pageId can not be null");
                }
                return;
            }
            com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().postGraphicAction(this.mInstance.getInstanceId(), this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            executeAction();
        } catch (java.lang.Throwable th) {
            if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                com.taobao.weex.utils.WXLogUtils.e("BasicGraphicAction", "SafeRunnable run throw expection:" + th.getMessage());
                throw th;
            }
            com.taobao.weex.utils.WXLogUtils.w("BasicGraphicAction", th);
        }
    }
}
