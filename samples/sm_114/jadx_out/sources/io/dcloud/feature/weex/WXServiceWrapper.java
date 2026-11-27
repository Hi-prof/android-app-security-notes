package io.dcloud.feature.weex;

/* JADX INFO: loaded from: classes2.dex */
public class WXServiceWrapper extends io.dcloud.feature.weex.WXBaseWrapper implements com.taobao.weex.IWXRenderListener {
    io.dcloud.common.DHInterface.IApp mApp;
    org.json.JSONObject mData;
    android.view.ViewGroup mRootView;
    io.dcloud.common.DHInterface.ISysEventListener mSysEventListener;
    java.lang.String mTemplate;
    long time;

    @Override // io.dcloud.feature.weex.WXBaseWrapper, io.dcloud.common.DHInterface.IUniNView
    public java.lang.String evalJs(java.lang.String str, int i) {
        return null;
    }

    @Override // com.taobao.weex.IWXRenderListener
    public void onException(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str, java.lang.String str2) {
    }

    @Override // com.taobao.weex.IWXRenderListener
    public void onRefreshSuccess(com.taobao.weex.WXSDKInstance wXSDKInstance, int i, int i2) {
    }

    @Override // com.taobao.weex.IWXRenderListener
    public void onRenderSuccess(com.taobao.weex.WXSDKInstance wXSDKInstance, int i, int i2) {
    }

    public WXServiceWrapper(io.dcloud.common.DHInterface.IApp iApp, android.view.ViewGroup viewGroup, java.lang.String str, org.json.JSONObject jSONObject) {
        super(viewGroup.getContext());
        this.time = 0L;
        this.mApp = iApp;
        this.mRootView = viewGroup;
        this.mWxId = str;
        this.mData = jSONObject;
        this.mSrcPath = jSONObject.optString(io.dcloud.common.constant.AbsoluteConst.XML_PATH);
        java.lang.String strOptString = this.mData.optString("template");
        this.mTemplate = strOptString;
        render(strOptString, getOptions(), null);
    }

    public io.dcloud.common.DHInterface.IApp obtanApp() {
        return this.mApp;
    }

    void render(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str2) {
        if (this.mWXSDKInstance == null) {
            this.mWXSDKInstance = new io.dcloud.feature.uniapp.UniSDKInstance(this.mRootView.getContext());
            this.mWXSDKInstance.registerRenderListener(this);
            this.mWXSDKInstance.setBundleUrl(this.mSrcPath);
        }
        this.mWXSDKInstance.render(this.mWxId, str, map, str2, com.taobao.weex.common.WXRenderStrategy.APPEND_ASYNC);
        com.alibaba.fastjson.JSONObject registerJsModules = com.taobao.weex.bridge.WXModuleManager.getRegisterJsModules();
        if (registerJsModules != null) {
            io.dcloud.feature.weex.WeexInstanceMgr.self().setUniNViewModules(registerJsModules.toJSONString());
        }
    }

    @Override // com.taobao.weex.IWXRenderListener
    public void onViewCreated(com.taobao.weex.WXSDKInstance wXSDKInstance, android.view.View view) {
        android.view.ViewGroup viewGroup = this.mRootView;
        if (viewGroup != null) {
            viewGroup.addView(this, new android.view.ViewGroup.LayoutParams(-1, -1));
            addView(view, new android.widget.LinearLayout.LayoutParams(-1, -1));
            setVisibility(8);
        }
    }

    @Override // io.dcloud.feature.weex.WXBaseWrapper, io.dcloud.common.DHInterface.IUniNView
    public void reload() {
        if (this.time == 0 || java.lang.System.currentTimeMillis() - this.time >= 600) {
            this.time = java.lang.System.currentTimeMillis();
            if (this.mWXSDKInstance != null) {
                this.mWXSDKInstance.registerRenderListener(null);
                this.mWXSDKInstance.destroy();
                this.mWXSDKInstance = null;
                removeAllViews();
            }
            if (android.text.TextUtils.isEmpty(this.mTemplate)) {
                return;
            }
            render(this.mTemplate, getOptions(), null);
        }
    }

    public java.util.Map<java.lang.String, java.lang.Object> getOptions() {
        java.util.HashMap map = new java.util.HashMap();
        map.put("plus_appid", this.mApp.obtainAppId());
        map.put("bundleUrl", this.mSrcPath);
        return map;
    }

    @Override // io.dcloud.feature.weex.WXBaseWrapper, io.dcloud.common.DHInterface.IUniNView
    public java.lang.String getType() {
        return "service";
    }

    @Override // io.dcloud.feature.weex.WXBaseWrapper, io.dcloud.common.DHInterface.IUniNView
    public void onDestroy() {
        if (this.mApp != null) {
            this.mApp = null;
        }
        android.view.ViewGroup viewGroup = this.mRootView;
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        if (this.mWXSDKInstance != null) {
            this.mWXSDKInstance.onActivityDestroy();
            this.mWXSDKInstance = null;
        }
        this.mData = null;
    }

    public void findWebViewToLoadUrL(java.lang.String str, java.lang.String str2) {
        if (this.mApp == null) {
            return;
        }
        io.dcloud.feature.weex.WeexInstanceMgr weexInstanceMgrSelf = io.dcloud.feature.weex.WeexInstanceMgr.self();
        io.dcloud.common.DHInterface.IApp iApp = this.mApp;
        io.dcloud.common.DHInterface.IWebview iWebviewFindWebview = weexInstanceMgrSelf.findWebview(null, iApp, iApp.obtainAppId(), str2);
        if (iWebviewFindWebview != null) {
            iWebviewFindWebview.loadUrl(str);
        }
    }
}
