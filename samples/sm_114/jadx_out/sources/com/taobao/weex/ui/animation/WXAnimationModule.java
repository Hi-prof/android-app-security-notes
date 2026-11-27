package com.taobao.weex.ui.animation;

/* JADX INFO: loaded from: classes.dex */
public class WXAnimationModule extends com.taobao.weex.common.WXModule {
    @com.taobao.weex.annotation.JSMethod
    public void transition(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || this.mWXSDKInstance == null) {
            return;
        }
        com.taobao.weex.ui.action.GraphicActionAnimation graphicActionAnimation = new com.taobao.weex.ui.action.GraphicActionAnimation(this.mWXSDKInstance, str, str2, str3);
        com.taobao.weex.WXSDKManager.getInstance().getWXRenderManager().postGraphicAction(graphicActionAnimation.getPageId(), graphicActionAnimation);
    }

    public static class AnimationHolder implements io.dcloud.feature.uniapp.ui.AbsAnimationHolder {
        private java.lang.String callback;
        private com.taobao.weex.ui.animation.WXAnimationBean wxAnimationBean;

        public AnimationHolder(com.taobao.weex.ui.animation.WXAnimationBean wXAnimationBean, java.lang.String str) {
            this.wxAnimationBean = wXAnimationBean;
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
}
