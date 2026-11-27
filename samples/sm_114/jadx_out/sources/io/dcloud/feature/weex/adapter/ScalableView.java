package io.dcloud.feature.weex.adapter;

/* JADX INFO: loaded from: classes2.dex */
public class ScalableView extends com.taobao.weex.ui.view.WXFrameLayout {
    int mHeight;
    int mWidth;

    public ScalableView(android.content.Context context) {
        super(context);
        this.mWidth = 0;
        this.mHeight = 0;
    }

    @Override // android.view.View
    protected void onSizeChanged(final int i, final int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        try {
            if ((getComponent() instanceof io.dcloud.feature.weex.adapter.ScalableViewComponent) && ((io.dcloud.feature.weex.adapter.ScalableViewComponent) getComponent()).isScalable()) {
                if (this.mHeight == i2 && this.mWidth == i) {
                    return;
                }
                com.taobao.weex.bridge.WXBridgeManager.getInstance().post(new java.lang.Runnable() { // from class: io.dcloud.feature.weex.adapter.ScalableView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (io.dcloud.feature.weex.adapter.ScalableView.this.getComponent() == null || io.dcloud.feature.weex.adapter.ScalableView.this.getComponent().getInstance() == null) {
                            return;
                        }
                        com.taobao.weex.bridge.WXBridgeManager.getInstance().setStyleHeight(io.dcloud.feature.weex.adapter.ScalableView.this.getComponent().getInstanceId(), io.dcloud.feature.weex.adapter.ScalableView.this.getComponent().getRef(), i2, true);
                        com.taobao.weex.bridge.WXBridgeManager.getInstance().setStyleWidth(io.dcloud.feature.weex.adapter.ScalableView.this.getComponent().getInstanceId(), io.dcloud.feature.weex.adapter.ScalableView.this.getComponent().getRef(), i, true);
                        io.dcloud.feature.weex.adapter.ScalableView.this.mWidth = i;
                        io.dcloud.feature.weex.adapter.ScalableView.this.mHeight = i2;
                    }
                });
            }
        } catch (java.lang.Exception unused) {
        }
    }
}
