package io.dcloud.feature.uniapp;

/* JADX INFO: loaded from: classes2.dex */
public interface AbsSDKInstance extends com.taobao.weex.IWXActivityStateListener, android.view.View.OnLayoutChangeListener {
    void addEventListener(java.lang.String str, java.lang.String str2);

    void fireEvent(java.lang.String str, java.lang.String str2);

    void fireEvent(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.Object> map);

    void fireEvent(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2);

    void fireEvent(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2, java.util.List<java.lang.Object> list);

    void fireEvent(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2, java.util.List<java.lang.Object> list, com.taobao.weex.bridge.EventResult eventResult);

    void fireGlobalEventCallback(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map);

    void fireModuleEvent(java.lang.String str, com.taobao.weex.common.WXModule wXModule, java.util.Map<java.lang.String, java.lang.Object> map);

    java.lang.String getBundleUrl();

    android.content.Context getContext();

    int getDefaultFontSize();

    com.taobao.weex.adapter.IDrawableLoader getDrawableLoader();

    com.taobao.weex.adapter.IWXImgLoaderAdapter getImgLoaderAdapter();

    java.lang.String getInstanceId();

    int getInstanceViewPortWidth();

    float getInstanceViewPortWidthWithFloat();

    android.content.Context getOriginalContext();

    com.taobao.weex.WXSDKInstance getParentInstance();

    java.lang.String getRenderType();

    android.view.View getRootView();

    com.taobao.weex.adapter.URIAdapter getURIAdapter();

    int getWeexHeight();

    int getWeexWidth();

    boolean isCompilerWithUniapp();

    boolean isDestroy();

    boolean isFrameViewShow();

    boolean isImmersive();

    boolean onBackPressed();

    void onCreateFinish();

    boolean onCreateOptionsMenu(android.view.Menu menu);

    void onShowAnimationEnd();

    boolean onSupportNavigateUp();

    void registerRenderListener(com.taobao.weex.IWXRenderListener iWXRenderListener);

    void reloadImages();

    void reloadPage(boolean z);

    void removeEventListener(java.lang.String str);

    void removeEventListener(java.lang.String str, java.lang.String str2);

    android.net.Uri rewriteUri(android.net.Uri uri, java.lang.String str);

    void runOnUiThread(java.lang.Runnable runnable);

    void setBundleUrl(java.lang.String str);

    void setDefaultFontSize(int i);

    void setImmersive(boolean z);

    void setRenderType(java.lang.String str);

    void setSize(int i, int i2);

    void setUniPagePath(java.lang.String str);
}
