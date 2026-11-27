package com.taobao.weex.common;

/* JADX INFO: loaded from: classes.dex */
public interface WXRequestListener {
    void onError(int i, java.lang.Object obj, com.taobao.weex.common.WXResponse wXResponse);

    void onSuccess(int i, java.lang.Object obj, com.taobao.weex.common.WXResponse wXResponse);
}
