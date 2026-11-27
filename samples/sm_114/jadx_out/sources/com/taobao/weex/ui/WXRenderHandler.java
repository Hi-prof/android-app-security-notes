package com.taobao.weex.ui;

/* JADX INFO: loaded from: classes.dex */
class WXRenderHandler extends android.os.Handler {
    public WXRenderHandler() {
        super(android.os.Looper.getMainLooper());
    }

    public final boolean post(java.lang.String str, java.lang.Runnable runnable) {
        android.os.Message messageObtain = android.os.Message.obtain(this, runnable);
        messageObtain.what = str.hashCode();
        return sendMessageDelayed(messageObtain, 0L);
    }

    @Override // android.os.Handler
    public void handleMessage(android.os.Message message) {
        super.handleMessage(message);
    }
}
