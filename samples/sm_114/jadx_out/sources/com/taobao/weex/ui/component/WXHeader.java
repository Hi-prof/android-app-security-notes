package com.taobao.weex.ui.component;

/* JADX INFO: loaded from: classes.dex */
@com.taobao.weex.annotation.Component(lazyload = false)
public class WXHeader extends com.taobao.weex.ui.component.list.WXCell {
    @Override // com.taobao.weex.ui.component.list.WXCell, com.taobao.weex.ui.component.WXComponent
    public boolean isLazy() {
        return false;
    }

    @java.lang.Deprecated
    public WXHeader(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, java.lang.String str, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    public WXHeader(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
        java.lang.String componentType = wXVContainer.getComponentType();
        if (com.taobao.weex.ui.component.WXBasicComponentType.LIST.equals(componentType) || com.taobao.weex.ui.component.WXBasicComponentType.RECYCLE_LIST.equals(componentType)) {
            getStyles().put("position", "sticky");
            setSticky("sticky");
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public boolean canRecycled() {
        return !isSticky();
    }
}
