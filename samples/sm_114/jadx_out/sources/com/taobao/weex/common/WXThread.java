package com.taobao.weex.common;

/* JADX INFO: loaded from: classes.dex */
public class WXThread extends android.os.HandlerThread {
    private android.os.Handler mHandler;

    static class SafeRunnable implements java.lang.Runnable {
        static final java.lang.String TAG = "SafeRunnable";
        private java.lang.ref.WeakReference<com.taobao.weex.WXSDKInstance> mInstance;
        final java.lang.Runnable mTask;
        private com.taobao.weex.utils.tools.LogDetail mTimelineLog;

        SafeRunnable(java.lang.Runnable runnable) {
            this(runnable, null);
        }

        SafeRunnable(java.lang.Runnable runnable, java.lang.String str) {
            this(runnable, null, str);
        }

        SafeRunnable(java.lang.Runnable runnable, com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str) {
            this.mTimelineLog = null;
            this.mTask = runnable;
            if (str != null) {
                com.taobao.weex.utils.tools.LogDetail logDetail = new com.taobao.weex.utils.tools.LogDetail();
                this.mTimelineLog = logDetail;
                logDetail.info.platform = com.taobao.weex.utils.tools.TimeCalculator.PLATFORM_ANDROID;
                this.mTimelineLog.name(str);
                this.mInstance = new java.lang.ref.WeakReference<>(wXSDKInstance);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.ref.WeakReference<com.taobao.weex.WXSDKInstance> weakReference;
            com.taobao.weex.WXSDKInstance wXSDKInstance;
            try {
                if (this.mTask != null) {
                    com.taobao.weex.utils.tools.LogDetail logDetail = this.mTimelineLog;
                    if (logDetail != null) {
                        logDetail.taskStart();
                    }
                    this.mTask.run();
                    com.taobao.weex.utils.tools.LogDetail logDetail2 = this.mTimelineLog;
                    if (logDetail2 != null) {
                        logDetail2.taskEnd();
                    }
                }
            } catch (java.lang.Throwable th) {
                if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
                    com.taobao.weex.utils.WXLogUtils.e(TAG, "SafeRunnable run throw expection:" + th.getMessage());
                    throw th;
                }
                com.taobao.weex.utils.WXLogUtils.w(TAG, th);
            }
            if (this.mTimelineLog == null || (weakReference = this.mInstance) == null || (wXSDKInstance = weakReference.get()) == null || wXSDKInstance.mTimeCalculator == null) {
                return;
            }
            wXSDKInstance.mTimeCalculator.addLog(this.mTimelineLog);
        }
    }

    static class SafeCallback implements android.os.Handler.Callback {
        static final java.lang.String TAG = "SafeCallback";
        final android.os.Handler.Callback mCallback;

        SafeCallback(android.os.Handler.Callback callback) {
            this.mCallback = callback;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            try {
                android.os.Handler.Callback callback = this.mCallback;
                if (callback != null) {
                    return callback.handleMessage(message);
                }
                return false;
            } catch (java.lang.Throwable th) {
                if (!com.taobao.weex.WXEnvironment.isApkDebugable()) {
                    return false;
                }
                com.taobao.weex.utils.WXLogUtils.e(TAG, "SafeCallback handleMessage throw expection:" + th.getMessage());
                throw th;
            }
        }
    }

    public static java.lang.Runnable secure(java.lang.Runnable runnable) {
        return secure(runnable, null, null);
    }

    public static java.lang.Runnable secure(java.lang.Runnable runnable, com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str) {
        return (runnable == null || (runnable instanceof com.taobao.weex.common.WXThread.SafeRunnable)) ? runnable : new com.taobao.weex.common.WXThread.SafeRunnable(runnable, wXSDKInstance, str);
    }

    public static android.os.Handler.Callback secure(android.os.Handler.Callback callback) {
        return (callback == null || (callback instanceof com.taobao.weex.common.WXThread.SafeCallback)) ? callback : new com.taobao.weex.common.WXThread.SafeCallback(callback);
    }

    public WXThread(java.lang.String str) {
        super(str);
        start();
        this.mHandler = new android.os.Handler(getLooper());
    }

    public WXThread(java.lang.String str, android.os.Handler.Callback callback) {
        super(str);
        start();
        this.mHandler = new android.os.Handler(getLooper(), secure(callback));
    }

    public WXThread(java.lang.String str, int i, android.os.Handler.Callback callback) {
        super(str, i);
        start();
        this.mHandler = new android.os.Handler(getLooper(), secure(callback));
    }

    public WXThread(java.lang.String str, int i) {
        super(str, i);
        start();
        this.mHandler = new android.os.Handler(getLooper());
    }

    public android.os.Handler getHandler() {
        return this.mHandler;
    }

    public boolean isWXThreadAlive() {
        return (this.mHandler == null || getLooper() == null || !isAlive()) ? false : true;
    }

    @Override // android.os.HandlerThread
    public boolean quit() {
        android.os.Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        return super.quit();
    }
}
