package com.taobao.weex.base;

/* JADX INFO: loaded from: classes.dex */
public class SystemMessageHandler extends android.os.Handler implements java.io.Serializable {
    private static final int SCHEDULED_WORK = 1;
    private static final java.lang.String TAG = "SystemMessageHandler";
    private java.lang.reflect.Method mMessageMethodSetAsynchronous;
    private long mMessagePumpDelegateNative;

    private native void nativeRunWork(long j);

    private SystemMessageHandler(long j, boolean z) {
        super(z ? android.os.Looper.getMainLooper() : android.os.Looper.myLooper());
        this.mMessagePumpDelegateNative = j;
        try {
            this.mMessageMethodSetAsynchronous = java.lang.Class.forName("android.os.Message").getMethod("setAsynchronous", java.lang.Boolean.TYPE);
        } catch (java.lang.ClassNotFoundException e) {
            android.util.Log.e(TAG, "Failed to find android.os.Message class:" + e);
        } catch (java.lang.NoSuchMethodException e2) {
            android.util.Log.e(TAG, "Failed to load Message.setAsynchronous method:" + e2);
        } catch (java.lang.RuntimeException e3) {
            android.util.Log.e(TAG, "Exception while loading Message.setAsynchronous method: " + e3);
        }
    }

    public static com.taobao.weex.base.SystemMessageHandler create(long j, boolean z) {
        return new com.taobao.weex.base.SystemMessageHandler(j, z);
    }

    private void scheduleWork() {
        sendMessage(obtainAsyncMessage(1));
    }

    private void scheduleDelayedWork(long j) {
        sendMessageDelayed(obtainAsyncMessage(1), j);
    }

    private void stop() {
        removeMessages(1);
    }

    private android.os.Message obtainAsyncMessage(int i) {
        android.os.Message messageObtain = android.os.Message.obtain();
        messageObtain.what = i;
        return messageObtain;
    }

    @Override // android.os.Handler
    public void handleMessage(android.os.Message message) {
        nativeRunWork(this.mMessagePumpDelegateNative);
    }
}
