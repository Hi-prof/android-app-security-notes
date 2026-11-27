package com.taobao.weex.ui.component;

/* JADX INFO: loaded from: classes.dex */
@com.taobao.weex.annotation.Component(lazyload = false)
public class WXBaseScroller extends com.taobao.weex.ui.component.WXVContainer<android.view.ViewGroup> implements com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener, com.taobao.weex.ui.component.Scrollable {
    public void bindAppearEvent(com.taobao.weex.ui.component.WXComponent wXComponent) {
    }

    public void bindDisappearEvent(com.taobao.weex.ui.component.WXComponent wXComponent) {
    }

    public void bindStickStyle(com.taobao.weex.ui.component.WXComponent wXComponent) {
    }

    public android.view.ViewGroup getInnerView() {
        return null;
    }

    public int getOrientation() {
        return 0;
    }

    public java.util.Map<java.lang.String, java.lang.Object> getScrollEvent(int i, int i2) {
        return null;
    }

    public int getScrollX() {
        return 0;
    }

    public int getScrollY() {
        return 0;
    }

    public java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.taobao.weex.ui.component.WXComponent>> getStickMap() {
        return null;
    }

    public boolean isScrollable() {
        return false;
    }

    @Override // com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener
    public void onScroll(com.taobao.weex.ui.view.WXScrollView wXScrollView, int i, int i2) {
    }

    @Override // com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener
    public void onScrollChanged(com.taobao.weex.ui.view.WXScrollView wXScrollView, int i, int i2, int i3, int i4) {
    }

    @Override // com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener
    public void onScrollStopped(com.taobao.weex.ui.view.WXScrollView wXScrollView, int i, int i2) {
    }

    @Override // com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener
    public void onScrollToBottom(com.taobao.weex.ui.view.WXScrollView wXScrollView, int i, int i2) {
    }

    public void scrollTo(com.taobao.weex.ui.component.WXComponent wXComponent, java.util.Map<java.lang.String, java.lang.Object> map) {
    }

    public void unbindAppearEvent(com.taobao.weex.ui.component.WXComponent wXComponent) {
    }

    public void unbindDisappearEvent(com.taobao.weex.ui.component.WXComponent wXComponent) {
    }

    public void unbindStickStyle(com.taobao.weex.ui.component.WXComponent wXComponent) {
    }

    public WXBaseScroller(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, java.lang.String str, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, str, z, basicComponentData);
    }

    public WXBaseScroller(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    public WXBaseScroller(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
    }
}
