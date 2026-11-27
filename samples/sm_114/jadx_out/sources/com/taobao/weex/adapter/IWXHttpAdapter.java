package com.taobao.weex.adapter;

/* JADX INFO: loaded from: classes.dex */
public interface IWXHttpAdapter {

    public interface OnHttpListener {
        void onHeadersReceived(int i, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map);

        void onHttpFinish(com.taobao.weex.common.WXResponse wXResponse);

        void onHttpResponseProgress(int i);

        void onHttpStart();

        void onHttpUploadProgress(int i);
    }

    void sendRequest(com.taobao.weex.common.WXRequest wXRequest, com.taobao.weex.adapter.IWXHttpAdapter.OnHttpListener onHttpListener);
}
