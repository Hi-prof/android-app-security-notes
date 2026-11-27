package com.taobao.weex.ui.component;

/* JADX INFO: loaded from: classes.dex */
@com.taobao.weex.annotation.Component(lazyload = false)
public class WXIndicator extends com.taobao.weex.ui.component.WXComponent<com.taobao.weex.ui.view.WXCircleIndicator> {
    @java.lang.Deprecated
    public WXIndicator(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, java.lang.String str, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    public WXIndicator(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public void setHostLayoutParams(com.taobao.weex.ui.view.WXCircleIndicator wXCircleIndicator, int i, int i2, int i3, int i4, int i5, int i6) {
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(i, i2);
        setMarginsSupportRTL(layoutParams, i3, i5, i4, i6);
        wXCircleIndicator.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public com.taobao.weex.ui.view.WXCircleIndicator initComponentHostView(android.content.Context context) {
        com.taobao.weex.ui.view.WXCircleIndicator wXCircleIndicator = new com.taobao.weex.ui.view.WXCircleIndicator(context);
        if ((getParent() instanceof com.taobao.weex.ui.component.WXSlider) || (getParent() instanceof io.dcloud.feature.weex.extend.DCWXSlider)) {
            return wXCircleIndicator;
        }
        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            throw new com.taobao.weex.common.WXRuntimeException("WXIndicator initView error.");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public void onHostViewInitialized(com.taobao.weex.ui.view.WXCircleIndicator wXCircleIndicator) {
        super.onHostViewInitialized(wXCircleIndicator);
        if (getParent() instanceof com.taobao.weex.ui.component.WXSlider) {
            ((com.taobao.weex.ui.component.WXSlider) getParent()).addIndicator(this);
        } else if (getParent() instanceof io.dcloud.feature.weex.extend.DCWXSlider) {
            ((io.dcloud.feature.weex.extend.DCWXSlider) getParent()).addIndicator(this);
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected boolean setProperty(java.lang.String str, java.lang.Object obj) {
        str.hashCode();
        switch (str) {
            case "itemSize":
                java.lang.Integer integer = com.taobao.weex.utils.WXUtils.getInteger(obj, null);
                if (integer != null) {
                    setItemSize(integer.intValue());
                }
                return true;
            case "itemSelectedColor":
                java.lang.String string = com.taobao.weex.utils.WXUtils.getString(obj, null);
                if (string != null) {
                    setItemSelectedColor(string);
                }
                return true;
            case "itemColor":
                java.lang.String string2 = com.taobao.weex.utils.WXUtils.getString(obj, null);
                if (string2 != null) {
                    setItemColor(string2);
                }
                return true;
            default:
                return super.setProperty(str, obj);
        }
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.ITEM_COLOR)
    public void setItemColor(java.lang.String str) {
        int color;
        if (android.text.TextUtils.isEmpty(str) || (color = com.taobao.weex.utils.WXResourceUtils.getColor(str)) == Integer.MIN_VALUE) {
            return;
        }
        getHostView().setPageColor(color);
        getHostView().forceLayout();
        getHostView().requestLayout();
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.ITEM_SELECTED_COLOR)
    public void setItemSelectedColor(java.lang.String str) {
        int color;
        if (android.text.TextUtils.isEmpty(str) || (color = com.taobao.weex.utils.WXResourceUtils.getColor(str)) == Integer.MIN_VALUE) {
            return;
        }
        getHostView().setFillColor(color);
        getHostView().forceLayout();
        getHostView().requestLayout();
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.common.Constants.Name.ITEM_SIZE)
    public void setItemSize(int i) {
        if (i < 0) {
            return;
        }
        getHostView().setRadius(com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(i, getInstance().getInstanceViewPortWidthWithFloat()) / 2.0f);
        getHostView().forceLayout();
        getHostView().requestLayout();
    }

    public void setShowIndicators(boolean z) {
        if (getHostView() == null) {
            return;
        }
        if (z) {
            getHostView().setVisibility(0);
        } else {
            getHostView().setVisibility(8);
        }
    }
}
