package com.taobao.weex.ui.component;

/* JADX INFO: loaded from: classes.dex */
@com.taobao.weex.annotation.Component(lazyload = false)
public class WXInput extends com.taobao.weex.ui.component.AbstractEditComponent {
    @java.lang.Deprecated
    public WXInput(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, java.lang.String str, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    public WXInput(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    @Override // com.taobao.weex.ui.component.AbstractEditComponent
    protected void appleStyleAfterCreated(com.taobao.weex.ui.view.WXEditText wXEditText) {
        super.appleStyleAfterCreated(wXEditText);
        wXEditText.setSingleLine();
    }
}
