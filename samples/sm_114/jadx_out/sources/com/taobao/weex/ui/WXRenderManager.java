package com.taobao.weex.ui;

/* JADX INFO: loaded from: classes.dex */
public class WXRenderManager {
    private static int mOpenGLRenderLimitValue = 0;
    private static int nativeBatchTimes = 0;
    private static final java.lang.String sKeyAction = "Action";
    private java.lang.String mCurrentBatchInstanceId = null;
    private java.util.ArrayList<java.util.Map<java.lang.String, java.lang.Object>> mBatchActions = new java.util.ArrayList<>();
    private final int MAX_DROP_FRAME_NATIVE_BATCH = 2000;
    private volatile java.util.concurrent.ConcurrentHashMap<java.lang.String, com.taobao.weex.ui.RenderContextImpl> mRenderContext = new java.util.concurrent.ConcurrentHashMap<>();
    private com.taobao.weex.ui.WXRenderHandler mWXRenderHandler = new com.taobao.weex.ui.WXRenderHandler();

    public com.taobao.weex.dom.RenderContext getRenderContext(java.lang.String str) {
        return this.mRenderContext.get(str);
    }

    public com.taobao.weex.ui.component.WXComponent getWXComponent(java.lang.String str, java.lang.String str2) {
        com.taobao.weex.dom.RenderContext renderContext;
        if (str == null || android.text.TextUtils.isEmpty(str2) || (renderContext = getRenderContext(str)) == null) {
            return null;
        }
        return renderContext.getComponent(str2);
    }

    public com.taobao.weex.ui.component.WXComponent getWXComponentById(java.lang.String str, java.lang.String str2) {
        com.taobao.weex.ui.RenderContextImpl renderContextImpl;
        if (str == null || android.text.TextUtils.isEmpty(str2) || (renderContextImpl = this.mRenderContext.get(str)) == null) {
            return null;
        }
        return renderContextImpl.getComponentById(str2);
    }

    public void setScrollable(java.lang.String str, boolean z, java.lang.String str2) {
        if (str == null) {
            return;
        }
        this.mRenderContext.get(str).setAllScrollerScrollable(z, str2);
    }

    public com.taobao.weex.WXSDKInstance getWXSDKInstance(java.lang.String str) {
        com.taobao.weex.ui.RenderContextImpl renderContextImpl = this.mRenderContext.get(str);
        if (renderContextImpl == null) {
            return null;
        }
        return renderContextImpl.getWXSDKInstance();
    }

    public static int getOpenGLRenderLimitValue() {
        if (mOpenGLRenderLimitValue == 0) {
            int i = 0;
            try {
                javax.microedition.khronos.egl.EGL10 egl10 = (javax.microedition.khronos.egl.EGL10) javax.microedition.khronos.egl.EGLContext.getEGL();
                javax.microedition.khronos.egl.EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(javax.microedition.khronos.egl.EGL10.EGL_DEFAULT_DISPLAY);
                egl10.eglInitialize(eGLDisplayEglGetDisplay, new int[2]);
                javax.microedition.khronos.egl.EGLConfig[] eGLConfigArr = new javax.microedition.khronos.egl.EGLConfig[1];
                int[] iArr = new int[1];
                egl10.eglChooseConfig(eGLDisplayEglGetDisplay, new int[]{12351, 12430, 12329, 0, 12339, 1, 12344}, eGLConfigArr, 1, iArr);
                if (iArr[0] == 0) {
                    i = -1;
                    egl10.eglTerminate(eGLDisplayEglGetDisplay);
                } else {
                    javax.microedition.khronos.egl.EGLConfig eGLConfig = eGLConfigArr[0];
                    javax.microedition.khronos.egl.EGLSurface eGLSurfaceEglCreatePbufferSurface = egl10.eglCreatePbufferSurface(eGLDisplayEglGetDisplay, eGLConfig, new int[]{12375, 64, 12374, 64, 12344});
                    javax.microedition.khronos.egl.EGLContext eGLContextEglCreateContext = egl10.eglCreateContext(eGLDisplayEglGetDisplay, eGLConfig, javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT, new int[]{12440, 1, 12344});
                    egl10.eglMakeCurrent(eGLDisplayEglGetDisplay, eGLSurfaceEglCreatePbufferSurface, eGLSurfaceEglCreatePbufferSurface, eGLContextEglCreateContext);
                    int[] iArr2 = new int[1];
                    android.opengl.GLES10.glGetIntegerv(3379, iArr2, 0);
                    egl10.eglMakeCurrent(eGLDisplayEglGetDisplay, javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE, javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE, javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT);
                    egl10.eglDestroySurface(eGLDisplayEglGetDisplay, eGLSurfaceEglCreatePbufferSurface);
                    egl10.eglDestroyContext(eGLDisplayEglGetDisplay, eGLContextEglCreateContext);
                    egl10.eglTerminate(eGLDisplayEglGetDisplay);
                    i = iArr2[0];
                }
            } catch (java.lang.Exception e) {
                com.taobao.weex.utils.WXLogUtils.e(com.taobao.weex.utils.WXLogUtils.getStackTrace(e));
            }
            mOpenGLRenderLimitValue = i;
        }
        return mOpenGLRenderLimitValue;
    }

    public void postOnUiThread(java.lang.Runnable runnable, long j) {
        this.mWXRenderHandler.postDelayed(com.taobao.weex.common.WXThread.secure(runnable), j);
    }

    public void postOnUiThread(java.lang.Runnable runnable, java.lang.String str) {
        this.mWXRenderHandler.post(str, com.taobao.weex.common.WXThread.secure(runnable));
    }

    public void postOnUiThread(java.lang.Runnable runnable) {
        this.mWXRenderHandler.post(com.taobao.weex.common.WXThread.secure(runnable));
    }

    public void removeTask(java.lang.Runnable runnable) {
        this.mWXRenderHandler.removeCallbacks(runnable);
    }

    public void removeRenderStatement(java.lang.String str) {
        if (!com.taobao.weex.utils.WXUtils.isUiThread()) {
            throw new com.taobao.weex.common.WXRuntimeException("[WXRenderManager] removeRenderStatement can only be called in main thread");
        }
        com.taobao.weex.ui.RenderContextImpl renderContextImplRemove = this.mRenderContext.remove(str);
        if (renderContextImplRemove != null) {
            renderContextImplRemove.destroy();
        }
        if (str == null) {
            this.mWXRenderHandler.removeCallbacksAndMessages(null);
        } else {
            this.mWXRenderHandler.removeMessages(str.hashCode());
        }
    }

    private void postAllStashedGraphicAction(java.lang.String str, com.taobao.weex.ui.action.BasicGraphicAction basicGraphicAction) {
        com.taobao.weex.ui.RenderContextImpl renderContextImpl = this.mRenderContext.get(str);
        java.util.ArrayList arrayList = renderContextImpl != null ? new java.util.ArrayList(this.mBatchActions) : null;
        this.mBatchActions.clear();
        this.mCurrentBatchInstanceId = null;
        nativeBatchTimes = 0;
        if (renderContextImpl == null) {
            return;
        }
        java.util.ArrayList arrayList2 = new java.util.ArrayList(arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            java.lang.Object obj = ((java.util.Map) arrayList.get(i)).get(sKeyAction);
            if (obj instanceof com.taobao.weex.ui.action.BasicGraphicAction) {
                com.taobao.weex.ui.action.BasicGraphicAction basicGraphicAction2 = (com.taobao.weex.ui.action.BasicGraphicAction) obj;
                if (basicGraphicAction2.mActionType != 1 && basicGraphicAction2.mActionType != 2) {
                    arrayList2.add(basicGraphicAction2);
                }
            }
        }
        postGraphicAction(str, new com.taobao.weex.ui.action.GraphicActionBatchAction(basicGraphicAction.getWXSDKIntance(), basicGraphicAction.getRef(), arrayList2));
    }

    public void postGraphicAction(java.lang.String str, com.taobao.weex.ui.action.BasicGraphicAction basicGraphicAction) {
        if (this.mRenderContext.get(str) == null) {
            return;
        }
        java.lang.String str2 = this.mCurrentBatchInstanceId;
        if (str2 != null && str != null && !str2.equals(str) && this.mBatchActions.size() > 0) {
            java.util.ArrayList<java.util.Map<java.lang.String, java.lang.Object>> arrayList = this.mBatchActions;
            java.lang.Object obj = arrayList.get(arrayList.size() - 1).get(sKeyAction);
            if (obj instanceof com.taobao.weex.ui.action.BasicGraphicAction) {
                postAllStashedGraphicAction(this.mCurrentBatchInstanceId, (com.taobao.weex.ui.action.BasicGraphicAction) obj);
            }
        }
        if (basicGraphicAction.mActionType == 2) {
            postAllStashedGraphicAction(str, basicGraphicAction);
            return;
        }
        if (basicGraphicAction.mActionType == 1 || this.mBatchActions.size() > 0) {
            int i = nativeBatchTimes + 1;
            nativeBatchTimes = i;
            if (i > 2000) {
                postAllStashedGraphicAction(str, basicGraphicAction);
            } else {
                java.util.HashMap map = new java.util.HashMap(1);
                basicGraphicAction.mIsRunByBatch = true;
                map.put(sKeyAction, basicGraphicAction);
                this.mBatchActions.add(map);
                this.mCurrentBatchInstanceId = str;
                return;
            }
        }
        this.mWXRenderHandler.post(str, basicGraphicAction);
    }

    public void registerInstance(com.taobao.weex.WXSDKInstance wXSDKInstance) {
        if (wXSDKInstance.getInstanceId() == null) {
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(null, com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_INSTANCE_ID_NULL, "registerInstance", com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_INSTANCE_ID_NULL.getErrorMsg() + "instanceId is null", null);
            return;
        }
        this.mRenderContext.put(wXSDKInstance.getInstanceId(), new com.taobao.weex.ui.RenderContextImpl(wXSDKInstance));
    }

    public java.util.List<com.taobao.weex.WXSDKInstance> getAllInstances() {
        if (this.mRenderContext == null || this.mRenderContext.isEmpty()) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.taobao.weex.ui.RenderContextImpl>> it = this.mRenderContext.entrySet().iterator();
        while (it.hasNext()) {
            com.taobao.weex.ui.RenderContextImpl value = it.next().getValue();
            if (value != null) {
                arrayList.add(value.getWXSDKInstance());
            }
        }
        return arrayList;
    }

    public void registerComponent(java.lang.String str, java.lang.String str2, com.taobao.weex.ui.component.WXComponent wXComponent) {
        com.taobao.weex.ui.RenderContextImpl renderContextImpl = this.mRenderContext.get(str);
        if (renderContextImpl != null) {
            renderContextImpl.registerComponent(str2, wXComponent);
            if (renderContextImpl.getInstance() != null) {
                renderContextImpl.getInstance().getApmForInstance().updateMaxStats(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STATS_MAX_COMPONENT_NUM, renderContextImpl.getComponentCount());
            }
        }
    }

    public com.taobao.weex.ui.component.WXComponent unregisterComponent(java.lang.String str, java.lang.String str2) {
        com.taobao.weex.ui.RenderContextImpl renderContextImpl = this.mRenderContext.get(str);
        if (renderContextImpl == null) {
            return null;
        }
        if (renderContextImpl.getInstance() != null) {
            renderContextImpl.getInstance().getApmForInstance().updateMaxStats(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STATS_MAX_COMPONENT_NUM, renderContextImpl.getComponentCount());
        }
        return renderContextImpl.unregisterComponent(str2);
    }
}
