package com.taobao.weex.common;

/* JADX INFO: loaded from: classes.dex */
public class WXRequest {
    public static final int DEFAULT_TIMEOUT_MS = 60000;
    public java.lang.String body;
    public java.lang.String inputType;
    public java.lang.String instanceId;
    public java.lang.String method;
    public java.util.Map<java.lang.String, java.lang.String> paramMap;
    public java.lang.String url;
    public int timeoutMs = DEFAULT_TIMEOUT_MS;
    public boolean sslVerify = false;
    public boolean isFirstIpv4 = false;
    public com.alibaba.fastjson.JSONObject tls = null;
}
