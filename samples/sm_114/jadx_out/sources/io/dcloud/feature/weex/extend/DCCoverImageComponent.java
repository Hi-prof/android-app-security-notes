package io.dcloud.feature.weex.extend;

/* JADX INFO: loaded from: classes2.dex */
public class DCCoverImageComponent extends com.taobao.weex.ui.component.WXImage {
    private int mBitmapHeight;
    private int mBitmapWidth;

    public DCCoverImageComponent(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        this.mBitmapWidth = 0;
        this.mBitmapHeight = 0;
        setContentBoxMeasurement(new io.dcloud.feature.uniapp.layout.UniContentBoxMeasurement() { // from class: io.dcloud.feature.weex.extend.DCCoverImageComponent.1
            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void layoutAfter(float f, float f2) {
            }

            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void layoutBefore() {
            }

            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void measureInternal(float f, float f2, int i, int i2) {
                if (i == 0 || !io.dcloud.feature.weex.extend.DCCoverImageComponent.this.getStyles().containsKey("width")) {
                    this.mMeasureWidth = io.dcloud.feature.weex.extend.DCCoverImageComponent.this.mBitmapWidth;
                }
                if (i2 == 0) {
                    this.mMeasureHeight = io.dcloud.feature.weex.extend.DCCoverImageComponent.this.mBitmapHeight;
                }
            }
        });
    }

    @Override // com.taobao.weex.ui.component.WXImage
    protected void setImage(java.lang.String str, com.taobao.weex.common.WXImageStrategy wXImageStrategy) {
        io.dcloud.feature.weex.adapter.GlideImageAdapter.setImage(str, getHostView(), getImageQuality(), wXImageStrategy);
    }

    @Override // com.taobao.weex.ui.component.WXImage
    public void onImageFinish(boolean z, java.util.Map map) {
        super.onImageFinish(z, map);
        this.mBitmapWidth = com.taobao.weex.utils.WXUtils.getInt(map.get("width"));
        this.mBitmapHeight = com.taobao.weex.utils.WXUtils.getInt(map.get("height"));
        if (getStyles().containsKey("height")) {
            return;
        }
        com.taobao.weex.bridge.WXBridgeManager.getInstance().post(new java.lang.Runnable() { // from class: io.dcloud.feature.weex.extend.DCCoverImageComponent$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m432x2d94e741();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onImageFinish$0$io-dcloud-feature-weex-extend-DCCoverImageComponent, reason: not valid java name */
    /* synthetic */ void m432x2d94e741() {
        com.taobao.weex.bridge.WXBridgeManager.getInstance().setStyleWidth(getInstanceId(), getRef(), this.mBitmapWidth);
        com.taobao.weex.bridge.WXBridgeManager.getInstance().setStyleHeight(getInstanceId(), getRef(), this.mBitmapHeight);
    }
}
