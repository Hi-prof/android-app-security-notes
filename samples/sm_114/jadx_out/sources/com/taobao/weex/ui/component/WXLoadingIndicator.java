package com.taobao.weex.ui.component;

/* JADX INFO: loaded from: classes.dex */
@com.taobao.weex.annotation.Component(lazyload = false)
public class WXLoadingIndicator extends com.taobao.weex.ui.component.WXComponent<com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar> {
    private static final java.lang.String ANIMATING = "animating";

    public WXLoadingIndicator(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar initComponentHostView(android.content.Context context) {
        return new com.taobao.weex.ui.view.refresh.circlebar.CircleProgressBar(context);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected boolean setProperty(java.lang.String str, java.lang.Object obj) {
        str.hashCode();
        switch (str) {
            case "arrow":
                getHostView().setShowArrow(com.taobao.weex.utils.WXUtils.getBoolean(obj, true).booleanValue());
                return true;
            case "color":
                java.lang.String string = com.taobao.weex.utils.WXUtils.getString(obj, null);
                if (string != null) {
                    setColor(string);
                }
                return true;
            case "animating":
                java.lang.Boolean bool = com.taobao.weex.utils.WXUtils.getBoolean(obj, null);
                if (bool != null) {
                    setAnimating(bool.booleanValue());
                }
                return true;
            default:
                return super.setProperty(str, obj);
        }
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = "color")
    public void setColor(java.lang.String str) {
        if (str == null || str.equals("")) {
            return;
        }
        getHostView().setColorSchemeColors(com.taobao.weex.utils.WXResourceUtils.getColor(str, -65536));
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = "animating")
    public void setAnimating(boolean z) {
        if (z) {
            getHostView().start();
        } else {
            getHostView().stop();
        }
    }

    private void setAnimatingSp(boolean z) {
        if (z) {
            getHostView().start();
        } else {
            getHostView().stop();
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        super.destroy();
        if (getHostView() != null) {
            getHostView().destory();
        }
    }
}
