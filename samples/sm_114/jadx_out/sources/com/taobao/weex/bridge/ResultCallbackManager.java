package com.taobao.weex.bridge;

/* JADX INFO: loaded from: classes.dex */
class ResultCallbackManager {
    private static android.util.SparseArray<com.taobao.weex.bridge.ResultCallback> mResultCallbacks = new android.util.SparseArray<>();
    private static long sCallbackId;

    ResultCallbackManager() {
    }

    static long generateCallbackId(com.taobao.weex.bridge.ResultCallback resultCallback) {
        if (sCallbackId >= 2147483647L) {
            sCallbackId = 0L;
        }
        long j = sCallbackId;
        sCallbackId = 1 + j;
        int i = (int) j;
        mResultCallbacks.put(i, resultCallback);
        return i;
    }

    static com.taobao.weex.bridge.ResultCallback removeCallbackById(long j) {
        int i = (int) j;
        com.taobao.weex.bridge.ResultCallback resultCallback = mResultCallbacks.get(i);
        mResultCallbacks.remove(i);
        return resultCallback;
    }
}
