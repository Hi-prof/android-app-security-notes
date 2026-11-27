package com.taobao.weex.ui.view;

/* JADX INFO: loaded from: classes.dex */
public class WXFrameLayout extends com.taobao.weex.ui.view.BaseFrameLayout implements com.taobao.weex.ui.view.gesture.WXGestureObservable, com.taobao.weex.ui.view.IRenderStatus<com.taobao.weex.ui.component.WXDiv>, com.taobao.weex.ui.view.IRenderResult<com.taobao.weex.ui.component.WXDiv> {
    private long downTimeMillis;
    private float downX;
    private float downY;
    private java.lang.Object mOnTouchListener;
    private java.lang.ref.WeakReference<com.taobao.weex.ui.component.WXDiv> mWeakReference;
    private float moveX;
    private float moveY;
    private com.taobao.weex.ui.view.gesture.WXGesture wxGesture;

    public WXFrameLayout(android.content.Context context) {
        super(context);
    }

    @Override // com.taobao.weex.ui.view.IRenderResult
    public com.taobao.weex.ui.component.WXDiv getComponent() {
        java.lang.ref.WeakReference<com.taobao.weex.ui.component.WXDiv> weakReference = this.mWeakReference;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.taobao.weex.ui.view.IRenderStatus
    public void holdComponent(com.taobao.weex.ui.component.WXDiv wXDiv) {
        this.mWeakReference = new java.lang.ref.WeakReference<>(wXDiv);
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public void registerGestureListener(com.taobao.weex.ui.view.gesture.WXGesture wXGesture) {
        this.wxGesture = wXGesture;
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public com.taobao.weex.ui.view.gesture.WXGesture getGestureListener() {
        return this.wxGesture;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        com.taobao.weex.ui.view.gesture.WXGesture wXGesture = this.wxGesture;
        return wXGesture != null ? wXGesture.onTouch(this, motionEvent) | zDispatchTouchEvent : zDispatchTouchEvent;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        java.lang.Object obj = this.mOnTouchListener;
        if (obj != null) {
            io.dcloud.common.adapter.util.PlatformUtil.invokeMethod(obj.getClass().getName(), "onTouch", this.mOnTouchListener, new java.lang.Class[]{android.view.View.class, android.view.MotionEvent.class}, new java.lang.Object[]{this, motionEvent});
            int action = motionEvent.getAction();
            if (action == 0) {
                this.downTimeMillis = java.lang.System.currentTimeMillis();
                this.downX = motionEvent.getRawX();
            } else if (action == 1 || action == 2 || action == 3) {
                this.moveX = motionEvent.getRawX();
            }
            if (java.lang.Math.abs(this.moveX - this.downX) > 30.0f && java.lang.System.currentTimeMillis() - this.downTimeMillis > 200) {
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private void addPan(java.lang.Object obj) {
        this.mOnTouchListener = obj;
    }

    private void removePan() {
        this.mOnTouchListener = null;
    }

    @Override // com.taobao.weex.ui.view.BaseFrameLayout, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(android.graphics.Canvas canvas) {
        com.taobao.weex.WXSDKInstance sDKInstance;
        try {
            super.dispatchDrawInterval(canvas);
        } catch (java.lang.Throwable th) {
            if (getComponent() != null) {
                notifyLayerOverFlow();
                if (getComponent() != null && (sDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(getComponent().getInstanceId())) != null && sDKInstance.getApmForInstance() != null && !sDKInstance.getApmForInstance().hasReportLayerOverDraw) {
                    sDKInstance.getApmForInstance().hasReportLayerOverDraw = true;
                    reportLayerOverFlowError();
                }
            }
            com.taobao.weex.utils.WXLogUtils.e("Layer overflow limit error", com.taobao.weex.utils.WXLogUtils.getStackTrace(th));
        }
    }

    private int reportLayerOverFlowError() {
        int iCalLayerDeep = calLayerDeep(this, 0);
        if (getComponent() != null) {
            com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(getComponent().getInstanceId(), com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_LAYER_OVERFLOW, "draw android view", com.taobao.weex.common.WXErrorCode.WX_RENDER_ERR_LAYER_OVERFLOW.getErrorMsg() + "Layer overflow limit error: " + iCalLayerDeep + " layers!", null);
        }
        return iCalLayerDeep;
    }

    private int calLayerDeep(android.view.View view, int i) {
        int i2 = i + 1;
        return (view.getParent() == null || !(view.getParent() instanceof android.view.View)) ? i2 : calLayerDeep((android.view.View) view.getParent(), i2);
    }

    public void notifyLayerOverFlow() {
        com.taobao.weex.WXSDKInstance wXDiv;
        if (getComponent() == null || (wXDiv = getComponent().getInstance()) == null || wXDiv.getLayerOverFlowListeners() == null) {
            return;
        }
        for (java.lang.String str : wXDiv.getLayerOverFlowListeners()) {
            com.taobao.weex.ui.component.WXComponent wXComponent = com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().getWXComponent(wXDiv.getInstanceId(), str);
            java.util.HashMap map = new java.util.HashMap();
            map.put("ref", str);
            map.put(com.taobao.weex.common.Constants.Weex.INSTANCEID, wXComponent.getInstanceId());
            wXComponent.fireEvent(com.taobao.weex.common.Constants.Event.LAYEROVERFLOW, map);
        }
    }
}
