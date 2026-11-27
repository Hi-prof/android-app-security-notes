package com.taobao.weex.adapter;

/* JADX INFO: loaded from: classes.dex */
public interface IWXUserTrackAdapter {
    public static final java.lang.String COUNTER = "counter";
    public static final java.lang.String DOM_MODULE = "domModule";
    public static final java.lang.String INIT_FRAMEWORK = "initFramework";
    public static final java.lang.String INVOKE_MODULE = "invokeModule";
    public static final java.lang.String JS_BRIDGE = "jsBridge";
    public static final java.lang.String JS_DOWNLOAD = "jsDownload";
    public static final java.lang.String JS_FRAMEWORK = "jsFramework";
    public static final java.lang.String LOAD = "load";
    public static final java.lang.String MODULE_NAME = "weex";
    public static final java.lang.String MONITOR_ARG = "arg";
    public static final java.lang.String MONITOR_ERROR_CODE = "errCode";
    public static final java.lang.String MONITOR_ERROR_MSG = "errMsg";
    public static final java.lang.String STREAM_MODULE = "streamModule";

    void commit(android.content.Context context, java.lang.String str, java.lang.String str2, com.taobao.weex.common.WXPerformance wXPerformance, java.util.Map<java.lang.String, java.io.Serializable> map);
}
