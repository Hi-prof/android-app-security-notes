package io.dcloud.feature.weex.adapter;

/* JADX INFO: loaded from: classes2.dex */
public class ScalableViewComponent extends com.taobao.weex.ui.component.WXDiv {
    private boolean isScalable;

    public ScalableViewComponent(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        this.isScalable = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXDiv, com.taobao.weex.ui.component.WXComponent
    public com.taobao.weex.ui.view.WXFrameLayout initComponentHostView(android.content.Context context) {
        io.dcloud.feature.weex.adapter.ScalableView scalableView = new io.dcloud.feature.weex.adapter.ScalableView(context);
        scalableView.holdComponent((com.taobao.weex.ui.component.WXDiv) this);
        return scalableView;
    }

    public boolean isScalable() {
        return this.isScalable;
    }

    public void setScalable(boolean z) {
        this.isScalable = z;
    }

    public static class Ceator implements com.taobao.weex.ui.ComponentCreator {
        @Override // com.taobao.weex.ui.ComponentCreator
        public com.taobao.weex.ui.component.WXComponent createInstance(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
            return new io.dcloud.feature.weex.adapter.ScalableViewComponent(wXSDKInstance, wXVContainer, basicComponentData);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public void setHostLayoutParams(com.taobao.weex.ui.view.WXFrameLayout wXFrameLayout, int i, int i2, int i3, int i4, int i5, int i6) {
        if (isScalable()) {
            super.setHostLayoutParams(wXFrameLayout, -1, -1, i3, i4, i5, i6);
        } else {
            super.setHostLayoutParams(wXFrameLayout, i, i2, i3, i4, i5, i6);
        }
    }
}
