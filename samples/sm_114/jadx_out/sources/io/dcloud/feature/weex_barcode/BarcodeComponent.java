package io.dcloud.feature.weex_barcode;

/* JADX INFO: loaded from: classes2.dex */
public class BarcodeComponent extends com.taobao.weex.ui.component.WXComponent<io.dcloud.feature.weex_barcode.BarcodeView> {
    private boolean isAnimationEnd;
    private java.util.concurrent.atomic.AtomicBoolean isLoad;

    @com.taobao.weex.annotation.JSMethod
    public void close() {
    }

    public BarcodeComponent(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        this.isLoad = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.isAnimationEnd = false;
    }

    public BarcodeComponent(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, int i, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, i, basicComponentData);
        this.isLoad = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.isAnimationEnd = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public io.dcloud.feature.weex_barcode.BarcodeView initComponentHostView(android.content.Context context) {
        io.dcloud.common.util.AppRuntime.checkPrivacyComplianceAndPrompt(context, "nvue-Barcode");
        return new io.dcloud.feature.weex_barcode.BarcodeView(context, this, getInstance());
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void updateProperties(java.util.Map<java.lang.String, java.lang.Object> map) {
        super.updateProperties(map);
        if (getHostView() == null || getAttrs().containsKey("background")) {
            return;
        }
        getHostView().setBackgroundColor(-16777216);
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = "frameColor")
    public void setFrameColor(java.lang.String str) {
        getHostView().setFrameColor(com.taobao.weex.utils.WXResourceUtils.getColor(str));
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = "autoDecodeCharset")
    public void setAutoDecodeCharset(boolean z) {
        getHostView().setAutoDecodeCharset(z);
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = "autoZoom")
    public void setAutoZoom(boolean z) {
        getHostView().setAutoZoom(z);
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = "background")
    public void setBackground(java.lang.String str) {
        getHostView().setBackground(com.taobao.weex.utils.WXResourceUtils.getColor(str));
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = "scanbarColor")
    public void setScanbarColor(java.lang.String str) {
        getHostView().setScanBarColor(com.taobao.weex.utils.WXResourceUtils.getColor(str));
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = "filters")
    public void setFilters(com.alibaba.fastjson.JSONArray jSONArray) {
        getHostView().initDecodeFormats(jSONArray);
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = "autostart")
    public void setSutoStart(final boolean z) {
        if (!this.isAnimationEnd) {
            getInstance().addFrameViewEventListener(new com.taobao.weex.WXSDKInstance.FrameViewEventListener() { // from class: io.dcloud.feature.weex_barcode.BarcodeComponent.1
                @Override // com.taobao.weex.WXSDKInstance.FrameViewEventListener
                public void onShowAnimationEnd() {
                    io.dcloud.feature.weex_barcode.BarcodeComponent.this.isAnimationEnd = true;
                    if (z) {
                        io.dcloud.feature.weex_barcode.BarcodeComponent.this.start(null);
                    }
                    io.dcloud.feature.weex_barcode.BarcodeComponent.this.getInstance().removeFrameViewEventListener(this);
                }
            });
        } else if (z) {
            start(null);
        }
    }

    @com.taobao.weex.annotation.JSMethod
    public void start(com.alibaba.fastjson.JSONObject jSONObject) {
        if (jSONObject != null) {
            getHostView().setConserve(jSONObject.containsKey("conserve") ? jSONObject.getBoolean("conserve").booleanValue() : false);
            getHostView().setFilename(io.dcloud.common.util.PdrUtil.getDefaultPrivateDocPath(jSONObject.getString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_FILENAME), "png"));
            getHostView().setVibrate(jSONObject.containsKey("vibrate") ? jSONObject.getBoolean("vibrate").booleanValue() : true);
            getHostView().setPlayBeep(!jSONObject.containsKey("sound") || jSONObject.getString("sound").equals("default"));
        }
        getHostView().start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public void setHostLayoutParams(io.dcloud.feature.weex_barcode.BarcodeView barcodeView, int i, int i2, int i3, int i4, int i5, int i6) {
        super.setHostLayoutParams(barcodeView, i, i2, i3, i4, i5, i6);
        if (!this.isLoad.get()) {
            this.isLoad.set(true);
            getHostView().initBarcodeView(i, i2);
        } else {
            getHostView().updateStyles(i, i2);
        }
    }

    @com.taobao.weex.annotation.JSMethod
    public void cancel() {
        getHostView().cancelScan();
    }

    @com.taobao.weex.annotation.JSMethod
    public void setFlash(boolean z) {
        if (io.dcloud.common.util.PdrUtil.isEmpty(java.lang.Boolean.valueOf(z))) {
            return;
        }
        getHostView().setFlash(z);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        super.destroy();
        getHostView().closeScan();
        getHostView().onDestory();
    }

    @Override // com.taobao.weex.ui.component.WXComponent, com.taobao.weex.IWXActivityStateListener
    public void onActivityResume() {
        super.onActivityResume();
        getHostView().onResume(true);
    }

    @Override // com.taobao.weex.ui.component.WXComponent, com.taobao.weex.IWXActivityStateListener
    public void onActivityPause() {
        super.onActivityPause();
        getHostView().onPause();
    }
}
