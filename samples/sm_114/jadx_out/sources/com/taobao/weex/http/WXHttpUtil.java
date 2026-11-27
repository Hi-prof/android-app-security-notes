package com.taobao.weex.http;

/* JADX INFO: loaded from: classes.dex */
public class WXHttpUtil {
    public static final java.lang.String KEY_USER_AGENT = "user-agent";

    public static java.lang.String assembleUserAgent() {
        java.lang.String defaultUA = dc.squareup.HttpConstants.getDefaultUA();
        if (!android.text.TextUtils.isEmpty(defaultUA)) {
            return defaultUA;
        }
        dc.squareup.HttpConstants.setUA(io.dcloud.common.util.BaseInfo.sDefWebViewUserAgent);
        return dc.squareup.HttpConstants.getDefaultUA();
    }

    public static java.lang.String assembleUserAgent(android.content.Context context, java.util.Map<java.lang.String, java.lang.String> map) {
        return assembleUserAgent();
    }
}
