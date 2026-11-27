package com.taobao.weex.bridge;

/* JADX INFO: loaded from: classes.dex */
public interface WXValidateProcessor {

    public static class WXComponentValidateResult {
        public boolean isSuccess;
        public java.lang.String replacedComponent;
        public com.alibaba.fastjson.JSONObject validateInfo;
    }

    public static class WXModuleValidateResult {
        public boolean isSuccess;
        public com.alibaba.fastjson.JSONObject validateInfo;
    }

    boolean needValidate(java.lang.String str);

    com.taobao.weex.bridge.WXValidateProcessor.WXComponentValidateResult onComponentValidate(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str, com.taobao.weex.ui.component.WXComponent wXComponent);

    com.taobao.weex.bridge.WXValidateProcessor.WXModuleValidateResult onModuleValidate(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str, java.lang.String str2, com.alibaba.fastjson.JSONArray jSONArray, com.alibaba.fastjson.JSONObject jSONObject);
}
