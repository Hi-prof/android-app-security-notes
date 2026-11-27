package com.taobao.weex;

/* JADX INFO: loaded from: classes.dex */
public interface ComponentObserver {
    void onCreate(com.taobao.weex.ui.component.WXComponent wXComponent);

    void onPreDestory(com.taobao.weex.ui.component.WXComponent wXComponent);

    void onViewCreated(com.taobao.weex.ui.component.WXComponent wXComponent, android.view.View view);
}
