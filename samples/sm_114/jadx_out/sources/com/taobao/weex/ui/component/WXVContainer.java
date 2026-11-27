package com.taobao.weex.ui.component;

/* JADX INFO: loaded from: classes.dex */
public abstract class WXVContainer<T extends android.view.ViewGroup> extends io.dcloud.feature.uniapp.ui.component.AbsVContainer<T> {
    private static final java.lang.String TAG = "WXVContainer";
    private com.taobao.weex.ui.component.WXVContainer<T>.BoxShadowHost mBoxShadowHost;

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer
    protected int getChildrenLayoutTopOffset() {
        return 0;
    }

    public WXVContainer(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, java.lang.String str, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, str, z, basicComponentData);
    }

    public WXVContainer(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    public WXVContainer(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer
    public android.view.View getBoxShadowHost(boolean z) {
        if (z) {
            return this.mBoxShadowHost;
        }
        T hostView = getHostView();
        if (hostView == null) {
            return null;
        }
        try {
            java.lang.String componentType = getComponentType();
            if (!com.taobao.weex.ui.component.WXBasicComponentType.DIV.equals(componentType) && !com.taobao.weex.ui.component.WXBasicComponentType.VIEW.equals(componentType)) {
                return hostView;
            }
            com.taobao.weex.utils.WXLogUtils.d("BoxShadow", "Draw box-shadow with BoxShadowHost on div: " + toString());
            if (this.mBoxShadowHost == null) {
                com.taobao.weex.ui.component.WXVContainer<T>.BoxShadowHost boxShadowHost = new com.taobao.weex.ui.component.WXVContainer.BoxShadowHost(getContext());
                this.mBoxShadowHost = boxShadowHost;
                com.taobao.weex.utils.WXViewUtils.setBackGround(boxShadowHost, null, this);
                hostView.addView(this.mBoxShadowHost);
            }
            com.taobao.weex.dom.CSSShorthand padding = getPadding();
            com.taobao.weex.dom.CSSShorthand border = getBorder();
            int i = (int) (padding.get(com.taobao.weex.dom.CSSShorthand.EDGE.LEFT) + border.get(com.taobao.weex.dom.CSSShorthand.EDGE.LEFT));
            int i2 = (int) (padding.get(com.taobao.weex.dom.CSSShorthand.EDGE.TOP) + border.get(com.taobao.weex.dom.CSSShorthand.EDGE.TOP));
            int i3 = (int) (padding.get(com.taobao.weex.dom.CSSShorthand.EDGE.RIGHT) + border.get(com.taobao.weex.dom.CSSShorthand.EDGE.RIGHT));
            int i4 = (int) (padding.get(com.taobao.weex.dom.CSSShorthand.EDGE.BOTTOM) + border.get(com.taobao.weex.dom.CSSShorthand.EDGE.BOTTOM));
            android.view.ViewGroup.MarginLayoutParams marginLayoutParams = new android.view.ViewGroup.MarginLayoutParams(hostView.getLayoutParams());
            try {
                setMarginsSupportRTL(marginLayoutParams, -i, -i2, -i3, -i4);
                this.mBoxShadowHost.setLayoutParams(marginLayoutParams);
                hostView.removeView(this.mBoxShadowHost);
                hostView.addView(this.mBoxShadowHost);
                return this.mBoxShadowHost;
            } catch (java.lang.Throwable th) {
                th = th;
                com.taobao.weex.utils.WXLogUtils.w("BoxShadow", th);
                return hostView;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer
    public void removeBoxShadowHost() {
        T hostView = getHostView();
        if (hostView == null) {
            return;
        }
        try {
            java.lang.String componentType = getComponentType();
            if (this.mBoxShadowHost != null) {
                if (com.taobao.weex.ui.component.WXBasicComponentType.DIV.equals(componentType) || com.taobao.weex.ui.component.WXBasicComponentType.VIEW.equals(componentType)) {
                    hostView.removeView(this.mBoxShadowHost);
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private class BoxShadowHost extends android.view.View {
        public BoxShadowHost(android.content.Context context) {
            super(context);
        }
    }
}
