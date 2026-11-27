package com.taobao.weex.ui.component;

/* JADX INFO: loaded from: classes.dex */
@com.taobao.weex.annotation.Component(lazyload = false)
public class WXA extends com.taobao.weex.ui.component.WXDiv {
    @java.lang.Deprecated
    public WXA(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, java.lang.String str, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, basicComponentData);
    }

    public WXA(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public void onHostViewInitialized(com.taobao.weex.ui.view.WXFrameLayout wXFrameLayout) {
        addClickListener(new com.taobao.weex.ui.component.WXComponent.OnClickListener() { // from class: com.taobao.weex.ui.component.WXA.1
            @Override // com.taobao.weex.ui.component.WXComponent.OnClickListener
            public void onHostViewClick() {
                java.lang.String str;
                com.taobao.weex.dom.WXAttr attrs = com.taobao.weex.ui.component.WXA.this.getAttrs();
                if (attrs == null || (str = (java.lang.String) attrs.get("href")) == null) {
                    return;
                }
                com.taobao.weex.utils.ATagUtil.onClick(null, com.taobao.weex.ui.component.WXA.this.getInstanceId(), str);
            }
        });
        super.onHostViewInitialized(wXFrameLayout);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected boolean setProperty(java.lang.String str, java.lang.Object obj) {
        str.hashCode();
        if (str.equals("href")) {
            return true;
        }
        return super.setProperty(str, obj);
    }
}
