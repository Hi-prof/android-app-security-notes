package com.taobao.weex.ui.component.list;

/* JADX INFO: loaded from: classes.dex */
@com.taobao.weex.annotation.Component(lazyload = false)
public class HorizontalListComponent extends com.taobao.weex.ui.component.list.WXListComponent {
    @Override // com.taobao.weex.ui.component.list.BasicListComponent, com.taobao.weex.ui.component.Scrollable
    public int getOrientation() {
        return 0;
    }

    public HorizontalListComponent(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
    }
}
