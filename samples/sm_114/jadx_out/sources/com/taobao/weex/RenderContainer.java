package com.taobao.weex;

/* JADX INFO: loaded from: classes.dex */
public class RenderContainer extends com.taobao.weex.render.WXAbstractRenderContainer implements com.taobao.weex.WeexFrameRateControl.VSyncListener {
    private com.taobao.weex.WeexFrameRateControl mFrameRateControl;

    public RenderContainer(android.content.Context context) {
        super(context);
        this.mFrameRateControl = new com.taobao.weex.WeexFrameRateControl(this);
    }

    public RenderContainer(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFrameRateControl = new com.taobao.weex.WeexFrameRateControl(this);
    }

    public RenderContainer(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFrameRateControl = new com.taobao.weex.WeexFrameRateControl(this);
    }

    public RenderContainer(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mFrameRateControl = new com.taobao.weex.WeexFrameRateControl(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.taobao.weex.WeexFrameRateControl weexFrameRateControl = this.mFrameRateControl;
        if (weexFrameRateControl != null) {
            weexFrameRateControl.start();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.taobao.weex.WeexFrameRateControl weexFrameRateControl = this.mFrameRateControl;
        if (weexFrameRateControl != null) {
            weexFrameRateControl.stop();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchWindowVisibilityChanged(int i) {
        com.taobao.weex.WeexFrameRateControl weexFrameRateControl;
        super.dispatchWindowVisibilityChanged(i);
        if (i == 8) {
            com.taobao.weex.WeexFrameRateControl weexFrameRateControl2 = this.mFrameRateControl;
            if (weexFrameRateControl2 != null) {
                weexFrameRateControl2.stop();
                return;
            }
            return;
        }
        if (i != 0 || (weexFrameRateControl = this.mFrameRateControl) == null) {
            return;
        }
        weexFrameRateControl.start();
    }

    @Override // com.taobao.weex.WeexFrameRateControl.VSyncListener
    public void OnVSync() {
        if (this.mSDKInstance == null || this.mSDKInstance.get() == null) {
            return;
        }
        this.mSDKInstance.get().OnVSync();
    }
}
