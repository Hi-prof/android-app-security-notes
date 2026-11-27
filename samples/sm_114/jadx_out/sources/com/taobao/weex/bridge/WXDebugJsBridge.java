package com.taobao.weex.bridge;

/* JADX INFO: loaded from: classes.dex */
public class WXDebugJsBridge {
    public native void jsHandleCallAddElement(java.lang.String str, java.lang.String str2, byte[] bArr, java.lang.String str3, boolean z);

    public native void jsHandleCallAddEvent(java.lang.String str, java.lang.String str2, java.lang.String str3);

    public native void jsHandleCallCreateBody(java.lang.String str, byte[] bArr, boolean z);

    public native void jsHandleCallCreateFinish(java.lang.String str);

    public native void jsHandleCallGCanvasLinkNative(java.lang.String str, int i, java.lang.String str2);

    public native void jsHandleCallMoveElement(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4);

    public native void jsHandleCallNative(java.lang.String str, byte[] bArr, java.lang.String str2);

    public native void jsHandleCallNativeComponent(java.lang.String str, java.lang.String str2, java.lang.String str3, byte[] bArr, byte[] bArr2, boolean z);

    public native void jsHandleCallNativeLog(byte[] bArr);

    public native void jsHandleCallNativeModule(java.lang.String str, java.lang.String str2, java.lang.String str3, byte[] bArr, byte[] bArr2, boolean z);

    public native void jsHandleCallRefreshFinish(java.lang.String str, byte[] bArr, java.lang.String str2);

    public native void jsHandleCallRemoveElement(java.lang.String str, java.lang.String str2);

    public native void jsHandleCallRemoveEvent(java.lang.String str, java.lang.String str2, java.lang.String str3);

    public native void jsHandleCallUpdateAttrs(java.lang.String str, java.lang.String str2, byte[] bArr, boolean z);

    public native void jsHandleCallUpdateFinish(java.lang.String str, byte[] bArr, java.lang.String str2);

    public native void jsHandleCallUpdateStyleNative(java.lang.String str, java.lang.String str2, byte[] bArr, boolean z);

    public native void jsHandleClearInterval(java.lang.String str, java.lang.String str2);

    public native void jsHandleReportException(java.lang.String str, java.lang.String str2, java.lang.String str3);

    public native void jsHandleSetInterval(java.lang.String str, java.lang.String str2, java.lang.String str3);

    public native void jsHandleSetJSVersion(java.lang.String str);

    public native void jsHandleSetTimeout(java.lang.String str, java.lang.String str2);

    public native void resetWXBridge(java.lang.Object obj, java.lang.String str);

    public void jsHandleCallNativeModule(java.lang.String str, java.lang.String str2, java.lang.String str3, byte[] bArr, byte[] bArr2) {
        jsHandleCallNativeModule(str, str2, str3, com.taobao.weex.utils.WXWsonJSONSwitch.convertJSONToWsonIfUseWson(bArr), com.taobao.weex.utils.WXWsonJSONSwitch.convertJSONToWsonIfUseWson(bArr2), true);
    }

    public void jsHandleCallNativeComponent(java.lang.String str, java.lang.String str2, java.lang.String str3, byte[] bArr, byte[] bArr2) {
        jsHandleCallNativeComponent(str, str2, str3, com.taobao.weex.utils.WXWsonJSONSwitch.convertJSONToWsonIfUseWson(bArr), com.taobao.weex.utils.WXWsonJSONSwitch.convertJSONToWsonIfUseWson(bArr2), true);
    }

    public void jsHandleCallAddElement(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        jsHandleCallAddElement(str, str2, com.taobao.weex.wson.WsonUtils.toWson(com.alibaba.fastjson.JSON.parse(str3)), str4, true);
    }

    public void jsHandleCallCreateBody(java.lang.String str, java.lang.String str2) {
        jsHandleCallCreateBody(str, com.taobao.weex.wson.WsonUtils.toWson(com.alibaba.fastjson.JSON.parse(str2)), true);
    }

    public void jsHandleCallUpdateAttrs(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        jsHandleCallUpdateAttrs(str, str2, com.taobao.weex.wson.WsonUtils.toWson(com.alibaba.fastjson.JSON.parseObject(str3)), true);
    }

    public void jsHandleCallUpdateStyle(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        jsHandleCallUpdateStyleNative(str, str2, com.taobao.weex.wson.WsonUtils.toWson(com.alibaba.fastjson.JSON.parseObject(str3)), true);
    }
}
