package com.taobao.weex.common;

/* JADX INFO: loaded from: classes.dex */
public class WXJSExceptionInfo {
    private java.lang.String mBundleUrl;
    private com.taobao.weex.common.WXErrorCode mErrCode;
    private java.lang.String mException;
    private java.util.Map<java.lang.String, java.lang.String> mExtParams;
    private java.lang.String mFunction;
    private java.lang.String mInstanceId;
    private java.lang.String mWeexVersion = com.taobao.weex.WXEnvironment.WXSDK_VERSION;
    private java.lang.String mJsFrameworkVersion = com.taobao.weex.WXEnvironment.JS_LIB_SDK_VERSION;
    public long time = java.lang.System.currentTimeMillis();

    public WXJSExceptionInfo(java.lang.String str, java.lang.String str2, com.taobao.weex.common.WXErrorCode wXErrorCode, java.lang.String str3, java.lang.String str4, java.util.Map<java.lang.String, java.lang.String> map) {
        this.mInstanceId = str;
        this.mBundleUrl = str2;
        this.mErrCode = wXErrorCode;
        this.mFunction = str3;
        this.mException = str4;
        this.mExtParams = map;
    }

    public java.lang.String getInstanceId() {
        return this.mInstanceId;
    }

    public void setInstanceId(java.lang.String str) {
        this.mInstanceId = str;
    }

    public java.lang.String getBundleUrl() {
        return this.mBundleUrl;
    }

    public void setBundleUrl(java.lang.String str) {
        this.mBundleUrl = str;
    }

    public com.taobao.weex.common.WXErrorCode getErrCode() {
        return this.mErrCode;
    }

    public void setErrCode(com.taobao.weex.common.WXErrorCode wXErrorCode) {
        this.mErrCode = wXErrorCode;
    }

    public java.lang.String getFunction() {
        return this.mFunction;
    }

    public void setFunction(java.lang.String str) {
        this.mFunction = str;
    }

    public java.lang.String getException() {
        return this.mException;
    }

    public void setException(java.lang.String str) {
        this.mException = str;
    }

    public java.util.Map<java.lang.String, java.lang.String> getExtParams() {
        return this.mExtParams;
    }

    public void setExtParams(java.util.Map<java.lang.String, java.lang.String> map) {
        this.mExtParams = map;
    }

    public java.lang.String getWeexVersion() {
        return this.mWeexVersion;
    }

    public java.lang.String getJsFrameworkVersion() {
        return this.mJsFrameworkVersion;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(" errCode:");
        com.taobao.weex.common.WXErrorCode wXErrorCode = this.mErrCode;
        sb.append(wXErrorCode == null ? "unSetErrorCode" : wXErrorCode.getErrorCode());
        sb.append(",function:");
        java.lang.String str = this.mFunction;
        if (str == null) {
            str = "unSetFuncName";
        }
        sb.append(str);
        sb.append(",exception:");
        java.lang.String str2 = this.mException;
        if (str2 == null) {
            str2 = "unSetException";
        }
        sb.append(str2);
        return sb.toString();
    }
}
