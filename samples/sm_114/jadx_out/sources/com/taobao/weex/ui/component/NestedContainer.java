package com.taobao.weex.ui.component;

/* JADX INFO: loaded from: classes.dex */
public interface NestedContainer {

    public interface OnNestedInstanceEventListener {
        void onCreated(com.taobao.weex.ui.component.NestedContainer nestedContainer, com.taobao.weex.WXSDKInstance wXSDKInstance);

        void onException(com.taobao.weex.ui.component.NestedContainer nestedContainer, java.lang.String str, java.lang.String str2);

        boolean onPreCreate(com.taobao.weex.ui.component.NestedContainer nestedContainer, java.lang.String str);

        java.lang.String transformUrl(java.lang.String str);
    }

    android.view.ViewGroup getViewContainer();

    void reload();

    void renderNewURL(java.lang.String str);

    void setOnNestEventListener(com.taobao.weex.ui.component.NestedContainer.OnNestedInstanceEventListener onNestedInstanceEventListener);
}
