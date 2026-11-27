package com.taobao.weex;

/* JADX INFO: loaded from: classes.dex */
public class WeexFrameRateControl {
    private static final long VSYNC_FRAME = 16;
    private java.lang.ref.WeakReference<com.taobao.weex.WeexFrameRateControl.VSyncListener> mListener;
    private final android.view.Choreographer mChoreographer = android.view.Choreographer.getInstance();
    private final android.view.Choreographer.FrameCallback mVSyncFrameCallback = new android.view.Choreographer.FrameCallback() { // from class: com.taobao.weex.WeexFrameRateControl.1
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            com.taobao.weex.WeexFrameRateControl.VSyncListener vSyncListener;
            if (com.taobao.weex.WeexFrameRateControl.this.mListener == null || (vSyncListener = (com.taobao.weex.WeexFrameRateControl.VSyncListener) com.taobao.weex.WeexFrameRateControl.this.mListener.get()) == 0) {
                return;
            }
            try {
                vSyncListener.OnVSync();
                com.taobao.weex.WeexFrameRateControl.this.mChoreographer.postFrameCallback(com.taobao.weex.WeexFrameRateControl.this.mVSyncFrameCallback);
            } catch (java.lang.UnsatisfiedLinkError e) {
                if (vSyncListener instanceof com.taobao.weex.WXSDKInstance) {
                    ((com.taobao.weex.WXSDKInstance) vSyncListener).onRenderError(com.taobao.weex.common.WXErrorCode.WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED.getErrorCode(), android.util.Log.getStackTraceString(e));
                }
            }
        }
    };
    private final java.lang.Runnable runnable = null;

    public interface VSyncListener {
        void OnVSync();
    }

    public WeexFrameRateControl(com.taobao.weex.WeexFrameRateControl.VSyncListener vSyncListener) {
        this.mListener = new java.lang.ref.WeakReference<>(vSyncListener);
    }

    /* JADX INFO: renamed from: com.taobao.weex.WeexFrameRateControl$2, reason: invalid class name */
    class AnonymousClass2 implements java.lang.Runnable {
        AnonymousClass2() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            com.taobao.weex.WeexFrameRateControl.VSyncListener vSyncListener;
            if (com.taobao.weex.WeexFrameRateControl.this.mListener == null || (vSyncListener = (com.taobao.weex.WeexFrameRateControl.VSyncListener) com.taobao.weex.WeexFrameRateControl.this.mListener.get()) == 0) {
                return;
            }
            try {
                vSyncListener.OnVSync();
                com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().postOnUiThread(com.taobao.weex.WeexFrameRateControl.this.runnable, 16L);
            } catch (java.lang.UnsatisfiedLinkError e) {
                if (vSyncListener instanceof com.taobao.weex.WXSDKInstance) {
                    ((com.taobao.weex.WXSDKInstance) vSyncListener).onRenderError(com.taobao.weex.common.WXErrorCode.WX_DEGRAD_ERR_INSTANCE_CREATE_FAILED.getErrorCode(), android.util.Log.getStackTraceString(e));
                }
            }
        }
    }

    public void start() {
        android.view.Choreographer choreographer = this.mChoreographer;
        if (choreographer != null) {
            choreographer.postFrameCallback(this.mVSyncFrameCallback);
        } else if (this.runnable != null) {
            com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().postOnUiThread(this.runnable, 16L);
        }
    }

    public void stop() {
        android.view.Choreographer choreographer = this.mChoreographer;
        if (choreographer != null) {
            choreographer.removeFrameCallback(this.mVSyncFrameCallback);
        } else if (this.runnable != null) {
            com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().removeTask(this.runnable);
        }
    }
}
