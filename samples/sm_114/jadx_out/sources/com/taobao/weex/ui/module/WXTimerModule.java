package com.taobao.weex.ui.module;

/* JADX INFO: loaded from: classes.dex */
public class WXTimerModule extends com.taobao.weex.common.WXModule implements com.taobao.weex.common.Destroyable, android.os.Handler.Callback {
    private static final java.lang.String TAG = "timer";
    private android.os.Handler handler = new android.os.Handler(com.taobao.weex.bridge.WXBridgeManager.getInstance().getJSLooper(), this);
    private android.util.SparseArray<java.lang.Integer> antiIntAutoBoxing = new android.util.SparseArray<>();

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void setTimeout(int i, float f) {
        if (this.mWXSDKInstance != null) {
            postOrHoldMessage(11, i, (int) f, com.taobao.weex.utils.WXUtils.parseInt(this.mWXSDKInstance.getInstanceId()));
            if (this.mWXSDKInstance.getWXPerformance() != null) {
                this.mWXSDKInstance.getWXPerformance().timerInvokeCount++;
            }
            this.mWXSDKInstance.getApmForInstance().updateFSDiffStats(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STATS_FS_TIMER_NUM, 1.0d);
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void setInterval(int i, float f) {
        if (this.mWXSDKInstance != null) {
            postOrHoldMessage(12, i, (int) f, com.taobao.weex.utils.WXUtils.parseInt(this.mWXSDKInstance.getInstanceId()));
            if (this.mWXSDKInstance.getWXPerformance() != null) {
                this.mWXSDKInstance.getWXPerformance().timerInvokeCount++;
            }
            this.mWXSDKInstance.getApmForInstance().updateFSDiffStats(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STATS_FS_TIMER_NUM, 1.0d);
        }
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void clearTimeout(int i) {
        if (i <= 0) {
            return;
        }
        removeOrHoldMessage(11, i);
    }

    @com.taobao.weex.annotation.JSMethod(uiThread = false)
    public void clearInterval(int i) {
        if (i <= 0) {
            return;
        }
        removeOrHoldMessage(12, i);
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        if (this.handler != null) {
            if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                com.taobao.weex.utils.WXLogUtils.d(TAG, "Timer Module removeAllMessages: ");
            }
            this.handler.removeCallbacksAndMessages(null);
            this.antiIntAutoBoxing.clear();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(android.os.Message message) {
        if (message != null) {
            int i = message.what;
            if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                com.taobao.weex.utils.WXLogUtils.d(TAG, "Timer Module handleMessage : " + message.what);
            }
            if (i == 11) {
                if (message.obj != null) {
                    checkIfTimerInBack(message.arg1);
                    com.taobao.weex.bridge.WXBridgeManager.getInstance().invokeExecJS(java.lang.String.valueOf(message.arg1), null, com.taobao.weex.bridge.WXBridgeManager.METHOD_CALL_JS, createTimerArgs(message.arg1, ((java.lang.Integer) message.obj).intValue(), false), true);
                    return true;
                }
            } else if (i == 12 && message.obj != null) {
                checkIfTimerInBack(message.arg1);
                postMessage(12, ((java.lang.Integer) message.obj).intValue(), message.arg2, message.arg1);
                com.taobao.weex.bridge.WXBridgeManager.getInstance().invokeExecJS(java.lang.String.valueOf(message.arg1), null, com.taobao.weex.bridge.WXBridgeManager.METHOD_CALL_JS, createTimerArgs(message.arg1, ((java.lang.Integer) message.obj).intValue(), true), true);
                return true;
            }
        }
        return false;
    }

    private void checkIfTimerInBack(int i) {
        com.taobao.weex.WXSDKInstance sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(java.lang.String.valueOf(i));
        if (sDKInstance != null && sDKInstance.isViewDisAppear()) {
            sDKInstance.getApmForInstance().updateDiffStats(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_TIMER_BACK_NUM, 1.0d);
        }
    }

    void setHandler(android.os.Handler handler) {
        this.handler = handler;
    }

    private com.taobao.weex.bridge.WXJSObject[] createTimerArgs(int i, int i2, boolean z) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(java.lang.Integer.valueOf(i2));
        arrayList.add(new java.util.HashMap());
        arrayList.add(java.lang.Boolean.valueOf(z));
        com.taobao.weex.bridge.WXHashMap wXHashMap = new com.taobao.weex.bridge.WXHashMap();
        wXHashMap.put("method", com.taobao.weex.bridge.WXBridgeManager.METHOD_CALLBACK);
        wXHashMap.put("args", arrayList);
        return new com.taobao.weex.bridge.WXJSObject[]{new com.taobao.weex.bridge.WXJSObject(2, java.lang.String.valueOf(i)), new com.taobao.weex.bridge.WXJSObject(3, com.taobao.weex.utils.WXJsonUtils.fromObjectToJSONString(new java.lang.Object[]{wXHashMap}))};
    }

    private void postOrHoldMessage(int i, int i2, int i3, int i4) {
        if (this.mWXSDKInstance.isPreRenderMode()) {
            postMessage(i, i2, i3, i4);
        } else {
            postMessage(i, i2, i3, i4);
        }
    }

    private void removeOrHoldMessage(int i, int i2) {
        if (this.mWXSDKInstance.isPreRenderMode()) {
            this.handler.removeMessages(i, this.antiIntAutoBoxing.get(i2, java.lang.Integer.valueOf(i2)));
        } else {
            this.handler.removeMessages(i, this.antiIntAutoBoxing.get(i2, java.lang.Integer.valueOf(i2)));
        }
    }

    private void postMessage(int i, int i2, int i3, int i4) {
        if (i3 < 0 || i2 <= 0) {
            com.taobao.weex.utils.WXLogUtils.e(TAG, "interval < 0 or funcId <=0");
            return;
        }
        if (this.antiIntAutoBoxing.get(i2) == null) {
            this.antiIntAutoBoxing.put(i2, java.lang.Integer.valueOf(i2));
        }
        this.handler.sendMessageDelayed(this.handler.obtainMessage(i, i4, i3, this.antiIntAutoBoxing.get(i2)), i3);
    }
}
