package io.dcloud.feature.uniapp.ui.component;

/* JADX INFO: loaded from: classes2.dex */
public class UniAnimationHolder implements io.dcloud.feature.uniapp.ui.AbsAnimationHolder {
    private java.lang.String callback;
    private com.taobao.weex.ui.animation.WXAnimationBean wxAnimationBean;

    public UniAnimationHolder(io.dcloud.feature.uniapp.ui.animation.UniAnimationBean uniAnimationBean, java.lang.String str) {
        this.wxAnimationBean = uniAnimationBean;
        this.callback = str;
    }

    @Override // io.dcloud.feature.uniapp.ui.AbsAnimationHolder
    public void execute(io.dcloud.feature.uniapp.AbsSDKInstance absSDKInstance, io.dcloud.feature.uniapp.ui.component.AbsBasicComponent absBasicComponent) {
        if (absSDKInstance == null || absBasicComponent == null) {
            return;
        }
        com.taobao.weex.ui.action.GraphicActionAnimation graphicActionAnimation = new com.taobao.weex.ui.action.GraphicActionAnimation((com.taobao.weex.WXSDKInstance) absSDKInstance, absBasicComponent.getRef(), this.wxAnimationBean, this.callback);
        com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().postGraphicAction(graphicActionAnimation.getPageId(), graphicActionAnimation);
    }
}
