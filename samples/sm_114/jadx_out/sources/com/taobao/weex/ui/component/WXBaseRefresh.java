package com.taobao.weex.ui.component;

/* JADX INFO: loaded from: classes.dex */
@com.taobao.weex.annotation.Component(lazyload = false)
public class WXBaseRefresh extends com.taobao.weex.ui.component.WXVContainer<com.taobao.weex.ui.view.WXFrameLayout> {
    private com.taobao.weex.ui.component.WXLoadingIndicator mLoadingIndicator;

    public WXBaseRefresh(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer
    public void addChild(com.taobao.weex.ui.component.WXComponent wXComponent) {
        super.addChild(wXComponent);
        checkLoadingIndicator(wXComponent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public com.taobao.weex.ui.view.WXFrameLayout initComponentHostView(android.content.Context context) {
        return new com.taobao.weex.ui.view.WXFrameLayout(context);
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer
    public void addChild(com.taobao.weex.ui.component.WXComponent wXComponent, int i) {
        super.addChild(wXComponent, i);
        checkLoadingIndicator(wXComponent);
    }

    private void checkLoadingIndicator(com.taobao.weex.ui.component.WXComponent wXComponent) {
        if (wXComponent instanceof com.taobao.weex.ui.component.WXLoadingIndicator) {
            this.mLoadingIndicator = (com.taobao.weex.ui.component.WXLoadingIndicator) wXComponent;
        }
    }
}
