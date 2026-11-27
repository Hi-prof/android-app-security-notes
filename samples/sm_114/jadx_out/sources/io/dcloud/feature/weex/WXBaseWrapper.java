package io.dcloud.feature.weex;

/* JADX INFO: loaded from: classes2.dex */
public class WXBaseWrapper extends io.dcloud.feature.weex.adapter.widget.refresh.WeexDcRefreshLayout implements io.dcloud.common.DHInterface.IUniNView {
    protected static int DE_INDEX = -1;
    protected java.lang.String mPath;
    protected java.lang.String mSrcPath;
    protected io.dcloud.feature.weex.WXAnalyzerDelegate mWXAnaly;
    protected com.taobao.weex.WXSDKInstance mWXSDKInstance;
    protected io.dcloud.common.DHInterface.IWebview mWebview;
    protected java.lang.String mWxId;

    @Override // io.dcloud.common.DHInterface.IUniNView
    public java.lang.String evalJs(java.lang.String str, int i) {
        return null;
    }

    @Override // io.dcloud.common.DHInterface.IUniNView
    public java.lang.String getType() {
        return null;
    }

    @Override // io.dcloud.common.DHInterface.IUniNView
    public void loadTemplate(org.json.JSONObject jSONObject) {
    }

    @Override // io.dcloud.common.DHInterface.IUniNView
    public android.view.ViewGroup obtainMainView() {
        return this;
    }

    public void onReady() {
    }

    protected void onRefresh() {
    }

    @Override // io.dcloud.common.DHInterface.IUniNView
    public void reload() {
    }

    @Override // io.dcloud.common.DHInterface.IUniNView
    public void titleNViewRefresh() {
    }

    public WXBaseWrapper(android.content.Context context) {
        super(context);
        this.mPath = null;
        this.mSrcPath = null;
        setEnabled(false);
    }

    @Override // io.dcloud.common.DHInterface.IUniNView
    public void initRefresh(org.json.JSONObject jSONObject) {
        if (jSONObject != null) {
            boolean z = java.lang.Boolean.parseBoolean(io.dcloud.common.util.JSONUtil.getString(jSONObject, io.dcloud.common.constant.AbsoluteConst.PULL_REFRESH_SUPPORT));
            java.lang.String strOptString = jSONObject != null ? jSONObject.optString("style", "default") : "default";
            if (z && strOptString.equals("circle")) {
                setEnabled(true);
                setOnRefreshListener(new io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.OnRefreshListener() { // from class: io.dcloud.feature.weex.WXBaseWrapper.1
                    @Override // io.dcloud.feature.weex.adapter.widget.refresh.DCWeexBaseRefreshLayout.OnRefreshListener
                    public void onRefresh() {
                        io.dcloud.feature.weex.WXBaseWrapper.this.onRefresh();
                    }
                });
                parseData(jSONObject);
            } else {
                setOnRefreshListener(null);
                setEnabled(false);
            }
        }
    }

    private void parseData(org.json.JSONObject jSONObject) {
        io.dcloud.common.DHInterface.IWebview iWebview = this.mWebview;
        if (iWebview == null) {
            return;
        }
        io.dcloud.common.adapter.util.ViewOptions viewOptionsObtainFrameOptions = ((io.dcloud.common.adapter.ui.AdaFrameView) iWebview.obtainFrameView()).obtainFrameOptions();
        java.lang.String strOptString = jSONObject.optString("offset");
        int iConvertToScreenInt = !android.text.TextUtils.isEmpty(strOptString) ? io.dcloud.common.util.PdrUtil.convertToScreenInt(strOptString, viewOptionsObtainFrameOptions.height, 0, this.mWebview.getScale()) : 0;
        java.lang.String strOptString2 = jSONObject.optString("height");
        int iConvertToScreenInt2 = (int) this.mTotalDragDistance;
        if (!android.text.TextUtils.isEmpty(strOptString2)) {
            iConvertToScreenInt2 = io.dcloud.common.util.PdrUtil.convertToScreenInt(strOptString2, viewOptionsObtainFrameOptions.height, iConvertToScreenInt2, this.mWebview.getScale());
        }
        int i = iConvertToScreenInt2;
        java.lang.String strOptString3 = jSONObject.optString(io.dcloud.common.constant.AbsoluteConst.PULL_REFRESH_RANGE);
        int iConvertToScreenInt3 = (int) this.mSpinnerFinalOffset;
        if (!android.text.TextUtils.isEmpty(strOptString3)) {
            iConvertToScreenInt3 = io.dcloud.common.util.PdrUtil.convertToScreenInt(strOptString3, viewOptionsObtainFrameOptions.height, iConvertToScreenInt3, this.mWebview.getScale());
        }
        int i2 = iConvertToScreenInt3 + this.mOriginalOffsetTop;
        java.lang.String strOptString4 = jSONObject.optString("color");
        int color = android.graphics.Color.parseColor("#2BD009");
        if (!android.text.TextUtils.isEmpty(strOptString4) && strOptString4.startsWith("#")) {
            try {
                color = android.graphics.Color.parseColor(strOptString4);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        setColorSchemeColors(color);
        setProgressViewOffset(false, this.mOriginalOffsetTop, i2, i, iConvertToScreenInt);
    }

    @Override // io.dcloud.common.DHInterface.IUniNView
    public void beginPullRefresh() {
        beginRefresh();
    }

    @Override // io.dcloud.common.DHInterface.IUniNView
    public void endPullToRefresh() {
        setRefreshing(false);
    }

    @Override // io.dcloud.common.DHInterface.IUniNView
    public void onDestroy() {
        destroy();
    }

    public void destroy() {
        setEnabled(false);
        recoveryInstance();
    }

    public void recoveryInstance() {
        com.taobao.weex.WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        if (wXSDKInstance != null) {
            wXSDKInstance.registerRenderListener(null);
            this.mWXSDKInstance.onActivityDestroy();
            io.dcloud.feature.weex.WXAnalyzerDelegate wXAnalyzerDelegate = this.mWXAnaly;
            if (wXAnalyzerDelegate != null) {
                wXAnalyzerDelegate.onDestroy();
                this.mWXAnaly = null;
            }
            this.mWXSDKInstance = null;
            clearTarget();
        }
    }

    @Override // io.dcloud.common.DHInterface.IUniNView
    public boolean fireGlobalEvent(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
        com.taobao.weex.WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        if (wXSDKInstance == null) {
            return false;
        }
        wXSDKInstance.fireGlobalEventCallback(str, map);
        return true;
    }

    public void onActivityResume() {
        com.taobao.weex.WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        if (wXSDKInstance != null) {
            wXSDKInstance.onActivityResume();
            io.dcloud.feature.weex.WXAnalyzerDelegate wXAnalyzerDelegate = this.mWXAnaly;
            if (wXAnalyzerDelegate != null) {
                wXAnalyzerDelegate.onResume();
            }
        }
    }

    public void onActivityPause() {
        com.taobao.weex.WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        if (wXSDKInstance != null) {
            wXSDKInstance.onActivityPause();
            io.dcloud.feature.weex.WXAnalyzerDelegate wXAnalyzerDelegate = this.mWXAnaly;
            if (wXAnalyzerDelegate != null) {
                wXAnalyzerDelegate.onPause();
            }
        }
    }

    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        com.taobao.weex.WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        if (wXSDKInstance != null) {
            wXSDKInstance.onActivityResult(i, i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
        com.taobao.weex.WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        if (wXSDKInstance != null) {
            wXSDKInstance.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        io.dcloud.common.DHInterface.IWebview iWebview;
        boolean zOnKeyDown = super.onKeyDown(i, keyEvent);
        if (zOnKeyDown && (iWebview = this.mWebview) != null && (iWebview.getActivity() instanceof io.dcloud.common.DHInterface.IKeyHandler)) {
            ((io.dcloud.common.DHInterface.IKeyHandler) this.mWebview.getActivity()).onKeyEventExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyDown, i, keyEvent);
        }
        return zOnKeyDown;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, android.view.KeyEvent keyEvent) {
        io.dcloud.common.DHInterface.IWebview iWebview;
        boolean zOnKeyUp = super.onKeyUp(i, keyEvent);
        if (zOnKeyUp && (iWebview = this.mWebview) != null && (iWebview.getActivity() instanceof io.dcloud.common.DHInterface.IKeyHandler)) {
            ((io.dcloud.common.DHInterface.IKeyHandler) this.mWebview.getActivity()).onKeyEventExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyUp, i, keyEvent);
        }
        return zOnKeyUp;
    }
}
