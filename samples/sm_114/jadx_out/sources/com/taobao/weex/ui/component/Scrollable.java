package com.taobao.weex.ui.component;

/* JADX INFO: loaded from: classes.dex */
public interface Scrollable {
    void bindAppearEvent(com.taobao.weex.ui.component.WXComponent wXComponent);

    void bindDisappearEvent(com.taobao.weex.ui.component.WXComponent wXComponent);

    void bindStickStyle(com.taobao.weex.ui.component.WXComponent wXComponent);

    int getOrientation();

    java.lang.String getRef();

    int getScrollX();

    int getScrollY();

    android.view.ViewGroup getView();

    boolean isScrollable();

    void scrollTo(com.taobao.weex.ui.component.WXComponent wXComponent, java.util.Map<java.lang.String, java.lang.Object> map);

    void unbindAppearEvent(com.taobao.weex.ui.component.WXComponent wXComponent);

    void unbindDisappearEvent(com.taobao.weex.ui.component.WXComponent wXComponent);

    void unbindStickStyle(com.taobao.weex.ui.component.WXComponent wXComponent);
}
