package com.taobao.weex.render;

/* JADX INFO: loaded from: classes.dex */
public class WXAbstractRenderContainer extends android.widget.FrameLayout {
    protected boolean mHasConsumeEvent;
    protected java.lang.ref.WeakReference<com.taobao.weex.WXSDKInstance> mSDKInstance;

    public void createInstanceRenderView(java.lang.String str) {
    }

    public WXAbstractRenderContainer(android.content.Context context) {
        super(context);
        this.mHasConsumeEvent = false;
    }

    public WXAbstractRenderContainer(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHasConsumeEvent = false;
    }

    public WXAbstractRenderContainer(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHasConsumeEvent = false;
    }

    public WXAbstractRenderContainer(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mHasConsumeEvent = false;
    }

    public void setSDKInstance(com.taobao.weex.WXSDKInstance wXSDKInstance) {
        this.mSDKInstance = new java.lang.ref.WeakReference<>(wXSDKInstance);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        com.taobao.weex.WXSDKInstance wXSDKInstance;
        super.onSizeChanged(i, i2, i3, i4);
        java.lang.ref.WeakReference<com.taobao.weex.WXSDKInstance> weakReference = this.mSDKInstance;
        if (weakReference == null || (wXSDKInstance = weakReference.get()) == null) {
            return;
        }
        wXSDKInstance.setSize(i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        this.mHasConsumeEvent = true;
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean hasConsumeEvent() {
        return this.mHasConsumeEvent;
    }
}
