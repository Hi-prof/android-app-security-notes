package io.dcloud.feature.uniapp.ui.component;

/* JADX INFO: loaded from: classes2.dex */
public class UniVContainer<T extends android.view.ViewGroup> extends com.taobao.weex.ui.component.WXVContainer<T> {
    public UniVContainer(io.dcloud.feature.uniapp.UniSDKInstance uniSDKInstance, io.dcloud.feature.uniapp.ui.component.AbsVContainer absVContainer, java.lang.String str, boolean z, io.dcloud.feature.uniapp.ui.action.AbsComponentData absComponentData) {
        super(uniSDKInstance, (com.taobao.weex.ui.component.WXVContainer) absVContainer, str, z, (com.taobao.weex.ui.action.BasicComponentData) absComponentData);
    }

    public UniVContainer(io.dcloud.feature.uniapp.UniSDKInstance uniSDKInstance, io.dcloud.feature.uniapp.ui.component.AbsVContainer absVContainer, boolean z, io.dcloud.feature.uniapp.ui.action.AbsComponentData absComponentData) {
        super(uniSDKInstance, (com.taobao.weex.ui.component.WXVContainer) absVContainer, z, (com.taobao.weex.ui.action.BasicComponentData) absComponentData);
    }

    public UniVContainer(io.dcloud.feature.uniapp.UniSDKInstance uniSDKInstance, io.dcloud.feature.uniapp.ui.component.AbsVContainer absVContainer, io.dcloud.feature.uniapp.ui.action.AbsComponentData absComponentData) {
        super(uniSDKInstance, (com.taobao.weex.ui.component.WXVContainer) absVContainer, (com.taobao.weex.ui.action.BasicComponentData) absComponentData);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public io.dcloud.feature.uniapp.UniSDKInstance getInstance() {
        return (io.dcloud.feature.uniapp.UniSDKInstance) super.getInstance();
    }
}
