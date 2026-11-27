package com.taobao.weex.ui.view;

/* JADX INFO: loaded from: classes.dex */
public interface IWebView {

    public interface OnErrorListener {
        void onError(java.lang.String str, java.lang.Object obj);
    }

    public interface OnMessageListener {
        void onMessage(java.util.Map<java.lang.String, java.lang.Object> map);
    }

    public interface OnPageListener {
        void onPageFinish(java.lang.String str, boolean z, boolean z2);

        void onPageStart(java.lang.String str);

        void onReceivedTitle(java.lang.String str);
    }

    void destroy();

    android.view.View getView();

    void goBack();

    void goForward();

    void loadDataWithBaseURL(java.lang.String str);

    void loadUrl(java.lang.String str);

    void onActivityResult(int i, int i2, android.content.Intent intent);

    void postMessage(java.lang.Object obj);

    void reload();

    void setOnErrorListener(com.taobao.weex.ui.view.IWebView.OnErrorListener onErrorListener);

    void setOnMessageListener(com.taobao.weex.ui.view.IWebView.OnMessageListener onMessageListener);

    void setOnPageListener(com.taobao.weex.ui.view.IWebView.OnPageListener onPageListener);

    void setShowLoading(boolean z);
}
