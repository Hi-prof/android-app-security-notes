package com.taobao.weex.common;

/* JADX INFO: loaded from: classes.dex */
public interface IWXBridge extends com.taobao.weex.common.IWXObject {
    public static final int DESTROY_INSTANCE = -1;
    public static final int INSTANCE_RENDERING = 1;
    public static final int INSTANCE_RENDERING_ERROR = 0;

    void bindMeasurementToRenderObject(long j);

    int callAddChildToRichtext(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.util.HashMap<java.lang.String, java.lang.String> map, java.util.HashMap<java.lang.String, java.lang.String> map2);

    int callAddElement(java.lang.String str, java.lang.String str2, java.lang.String str3, int i, java.lang.String str4, java.util.HashMap<java.lang.String, java.lang.String> map, java.util.HashMap<java.lang.String, java.lang.String> map2, java.util.HashSet<java.lang.String> hashSet, float[] fArr, float[] fArr2, float[] fArr3, boolean z);

    int callAddEvent(java.lang.String str, java.lang.String str2, java.lang.String str3);

    int callAppendTreeCreateFinish(java.lang.String str, java.lang.String str2);

    void callBacthEnd(java.lang.String str);

    void callBacthStart(java.lang.String str);

    int callCreateBody(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.HashMap<java.lang.String, java.lang.String> map, java.util.HashMap<java.lang.String, java.lang.String> map2, java.util.HashSet<java.lang.String> hashSet, float[] fArr, float[] fArr2, float[] fArr3);

    int callCreateFinish(java.lang.String str);

    int callHasTransitionPros(java.lang.String str, java.lang.String str2, java.util.HashMap<java.lang.String, java.lang.String> map);

    int callLayout(java.lang.String str, java.lang.String str2, int i, int i2, int i3, int i4, int i5, int i6, boolean z, int i7);

    int callMoveElement(java.lang.String str, java.lang.String str2, java.lang.String str3, int i);

    int callNative(java.lang.String str, java.lang.String str2, java.lang.String str3);

    int callNative(java.lang.String str, byte[] bArr, java.lang.String str2);

    void callNativeComponent(java.lang.String str, java.lang.String str2, java.lang.String str3, byte[] bArr, byte[] bArr2);

    java.lang.Object callNativeModule(java.lang.String str, java.lang.String str2, java.lang.String str3, byte[] bArr, byte[] bArr2);

    int callRefreshFinish(java.lang.String str, byte[] bArr, java.lang.String str2);

    int callRemoveChildFromRichtext(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4);

    int callRemoveElement(java.lang.String str, java.lang.String str2);

    int callRemoveEvent(java.lang.String str, java.lang.String str2, java.lang.String str3);

    int callRenderSuccess(java.lang.String str);

    int callUpdateAttrs(java.lang.String str, java.lang.String str2, java.util.HashMap<java.lang.String, java.lang.String> map);

    int callUpdateFinish(java.lang.String str, byte[] bArr, java.lang.String str2);

    int callUpdateRichtextChildAttr(java.lang.String str, java.lang.String str2, java.util.HashMap<java.lang.String, java.lang.String> map, java.lang.String str3, java.lang.String str4);

    int callUpdateRichtextStyle(java.lang.String str, java.lang.String str2, java.util.HashMap<java.lang.String, java.lang.String> map, java.lang.String str3, java.lang.String str4);

    int callUpdateStyle(java.lang.String str, java.lang.String str2, java.util.HashMap<java.lang.String, java.lang.Object> map, java.util.HashMap<java.lang.String, java.lang.String> map2, java.util.HashMap<java.lang.String, java.lang.String> map3, java.util.HashMap<java.lang.String, java.lang.String> map4);

    void callVueExec(java.lang.String str, java.lang.String str2, java.lang.String str3);

    java.lang.Object callVueExecSync(java.lang.String str, java.lang.String str2, java.lang.String str3);

    int createInstanceContext(java.lang.String str, java.lang.String str2, java.lang.String str3, com.taobao.weex.bridge.WXJSObject[] wXJSObjectArr);

    int destoryInstance(java.lang.String str, java.lang.String str2, java.lang.String str3, com.taobao.weex.bridge.WXJSObject[] wXJSObjectArr);

    int execJS(java.lang.String str, java.lang.String str2, java.lang.String str3, com.taobao.weex.bridge.WXJSObject[] wXJSObjectArr);

    java.lang.String execJSOnInstance(java.lang.String str, java.lang.String str2, int i);

    int execJSService(java.lang.String str);

    void execJSWithCallback(java.lang.String str, java.lang.String str2, java.lang.String str3, com.taobao.weex.bridge.WXJSObject[] wXJSObjectArr, com.taobao.weex.bridge.ResultCallback resultCallback);

    void forceLayout(java.lang.String str);

    long[] getFirstScreenRenderTime(java.lang.String str);

    com.taobao.weex.layout.ContentBoxMeasurement getMeasurementFunc(java.lang.String str, long j);

    long[] getRenderFinishTime(java.lang.String str);

    int initFramework(java.lang.String str, com.taobao.weex.bridge.WXParams wXParams);

    int initFrameworkEnv(java.lang.String str, com.taobao.weex.bridge.WXParams wXParams, java.lang.String str2, boolean z);

    void markDirty(java.lang.String str, java.lang.String str2, boolean z);

    boolean notifyLayout(java.lang.String str);

    void onInstanceClose(java.lang.String str);

    void refreshInstance(java.lang.String str, java.lang.String str2, java.lang.String str3, com.taobao.weex.bridge.WXJSObject[] wXJSObjectArr);

    void registerCoreEnv(java.lang.String str, java.lang.String str2);

    void reloadPageLayout(java.lang.String str);

    void removeInstanceRenderType(java.lang.String str);

    void reportJSException(java.lang.String str, java.lang.String str2, java.lang.String str3);

    void reportNativeInitStatus(java.lang.String str, java.lang.String str2);

    void reportServerCrash(java.lang.String str, java.lang.String str2);

    void resetWXBridge(boolean z);

    void setDefaultHeightAndWidthIntoRootDom(java.lang.String str, float f, float f2, boolean z, boolean z2);

    void setDeviceDisplay(java.lang.String str, float f, float f2, float f3);

    void setDeviceDisplayOfPage(java.lang.String str, float f, float f2);

    void setFlexDirectionDef(java.lang.String str);

    void setInstanceRenderType(java.lang.String str, java.lang.String str2);

    void setJSFrmVersion(java.lang.String str);

    void setLogType(float f, boolean z);

    void setMargin(java.lang.String str, java.lang.String str2, com.taobao.weex.dom.CSSShorthand.EDGE edge, float f);

    void setPadding(java.lang.String str, java.lang.String str2, com.taobao.weex.dom.CSSShorthand.EDGE edge, float f);

    void setPageArgument(java.lang.String str, java.lang.String str2, java.lang.String str3);

    void setPosition(java.lang.String str, java.lang.String str2, com.taobao.weex.dom.CSSShorthand.EDGE edge, float f);

    void setRenderContainerWrapContent(boolean z, java.lang.String str);

    void setStyleHeight(java.lang.String str, java.lang.String str2, float f);

    void setStyleHeight(java.lang.String str, java.lang.String str2, float f, boolean z);

    void setStyleWidth(java.lang.String str, java.lang.String str2, float f);

    void setStyleWidth(java.lang.String str, java.lang.String str2, float f, boolean z);

    void setTimeoutNative(java.lang.String str, java.lang.String str2);

    void setViewPortWidth(java.lang.String str, float f);

    void takeHeapSnapshot(java.lang.String str);

    void updateInitFrameworkParams(java.lang.String str, java.lang.String str2, java.lang.String str3);
}
