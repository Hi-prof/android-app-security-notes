package io.dcloud.common.adapter.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public abstract class AdaWebview extends io.dcloud.common.adapter.ui.AdaContainerFrameItem implements io.dcloud.common.DHInterface.IWebview {
    public static boolean ScreemOrientationChangedNeedLayout = false;
    public static io.dcloud.common.adapter.ui.RecordView mRecordView = null;
    public static java.lang.String sCustomUserAgent = null;
    public static io.dcloud.common.adapter.ui.CustomeizedInputConnection sCustomeizedInputConnection = null;
    public static java.lang.String sDefalutUserAgent = null;
    public static boolean setedWebViewData = false;
    public java.lang.String errorPageUrl;
    public io.dcloud.common.adapter.util.MessageHandler.IMessages executeScriptListener;
    private java.lang.String favoriteOptions;
    public boolean hasErrorPage;
    private boolean isDisposed;
    boolean isPause;
    private boolean isStart;
    public boolean justClearOption;
    java.lang.String mAppid;
    java.lang.String mCssString;
    public java.lang.String mEncoding;
    java.lang.String[] mEvalJsOptionStack;
    private int mFixBottomHeight;
    private java.lang.Object mFlag;
    public java.lang.String mForceAHeadJsFile;
    public boolean mForceAHeadJsFileLoaded;
    private java.lang.String mFrameId;
    public io.dcloud.common.adapter.ui.AdaFrameView mFrameView;
    public java.lang.String mInjectGEO;
    public boolean mInjectGeoLoaded;
    java.lang.String mInjectPlusLoadedUrl;
    public java.lang.String mInjectPlusWidthJs;
    public boolean mIsAdvanceCss;
    io.dcloud.common.DHInterface.IJsInterface mJsInterfaces;
    org.json.JSONObject mListenResourceLoadingOptions;
    public boolean mLoadCompleted;
    public boolean mLoaded;
    boolean mLoading;
    public io.dcloud.common.adapter.util.MessageHandler.IMessages mMesssageListener;
    public boolean mNeedInjection;
    boolean mNeedSitemapJson;
    private io.dcloud.common.DHInterface.IWebview mOpener;
    org.json.JSONArray mOverrideResourceRequestOptions;
    org.json.JSONObject mOverrideUrlLoadingDataOptions;
    public java.lang.String mPlusInjectTag;
    public boolean mPlusLoaded;
    public boolean mPlusLoading;
    public java.lang.String mPlusrequire;
    public java.util.ArrayList<java.lang.String> mPreloadJsFile;
    public boolean mPreloadJsLoaded;
    public boolean mPreloadJsLoading;
    public int mProgress;
    public int mProgressIntValue;
    public android.view.View mProgressView;
    public io.dcloud.common.adapter.ui.ReceiveJSValue mReceiveJSValue_android42;
    public java.lang.String mRecordLastUrl;
    private boolean mShareable;
    private java.util.ArrayList<io.dcloud.common.DHInterface.IWebviewStateListener> mStateListeners;
    private java.lang.String mVideoFullscreen;
    private com.dcloud.android.widget.DCWebViewProgressBar mWebProgressView;
    io.dcloud.common.adapter.ui.webview.DCWebView mWebViewImpl;
    io.dcloud.common.adapter.ui.AdaWebViewParent mWebViewParent;
    private java.lang.String mWebviewANID;
    private java.lang.String mWebviewUUID;
    private java.lang.String needTouchEvent;
    java.lang.String originalUrl;
    private java.lang.String shareOptions;
    public boolean unReceiveTitle;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface IFExecutePreloadJSContentCallBack {
        void callback(java.lang.String str, java.lang.String str2);
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public class OverrideResourceRequestItem {
        public java.lang.String redirect = null;
        public java.lang.String mime = null;
        public java.lang.String encoding = null;
        public org.json.JSONObject headerJson = null;

        public OverrideResourceRequestItem() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class WebProgressView extends com.dcloud.android.widget.DCProgressView {
        public WebProgressView(android.content.Context context) {
            super(context);
        }
    }

    protected AdaWebview(android.content.Context context) {
        super(context);
        this.unReceiveTitle = true;
        this.mWebViewParent = null;
        this.mRecordLastUrl = null;
        this.mWebViewImpl = null;
        this.mFrameView = null;
        this.mLoaded = false;
        this.mLoadCompleted = false;
        this.mPreloadJsLoaded = false;
        this.mPreloadJsLoading = false;
        this.mPlusLoaded = false;
        this.mPlusLoading = false;
        this.mPlusInjectTag = "page_finished";
        this.mIsAdvanceCss = false;
        this.mNeedInjection = true;
        this.mEncoding = null;
        this.mWebviewUUID = null;
        this.mWebviewANID = null;
        this.mFrameId = null;
        this.mJsInterfaces = null;
        this.hasErrorPage = false;
        this.errorPageUrl = null;
        this.originalUrl = null;
        this.mVideoFullscreen = "auto";
        this.needTouchEvent = "";
        this.favoriteOptions = "";
        this.shareOptions = "";
        this.mShareable = true;
        this.mPlusrequire = "normal";
        this.mInjectGEO = "none";
        this.mInjectGeoLoaded = false;
        this.mProgressIntValue = 0;
        this.isDisposed = false;
        this.mReceiveJSValue_android42 = null;
        this.isPause = false;
        this.mFlag = null;
        this.mInjectPlusLoadedUrl = null;
        this.mEvalJsOptionStack = null;
        this.mForceAHeadJsFileLoaded = false;
        this.mForceAHeadJsFile = null;
        this.mPreloadJsFile = new java.util.ArrayList<>(2);
        this.mCssString = "";
        this.executeScriptListener = new io.dcloud.common.adapter.util.MessageHandler.IMessages() { // from class: io.dcloud.common.adapter.ui.AdaWebview.4
            @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
            public void execute(java.lang.Object obj) {
                java.lang.String str = (java.lang.String) obj;
                io.dcloud.common.adapter.ui.webview.DCWebView dCWebView = io.dcloud.common.adapter.ui.AdaWebview.this.mWebViewImpl;
                if (dCWebView != null) {
                    if (!str.startsWith(io.dcloud.common.constant.AbsoluteConst.PROTOCOL_JAVASCRIPT)) {
                        str = io.dcloud.common.constant.AbsoluteConst.PROTOCOL_JAVASCRIPT + str;
                    }
                    dCWebView.loadUrl(str);
                }
            }
        };
        this.mMesssageListener = new io.dcloud.common.adapter.util.MessageHandler.IMessages() { // from class: io.dcloud.common.adapter.ui.AdaWebview.5
            @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
            public void execute(java.lang.Object obj) {
                java.lang.Object[] objArr = (java.lang.Object[]) obj;
                io.dcloud.common.adapter.ui.AdaWebview.this.mJsInterfaces.exec(java.lang.String.valueOf(objArr[0]), java.lang.String.valueOf(objArr[1]), (org.json.JSONArray) objArr[2]);
            }
        };
        this.mStateListeners = null;
        this.mProgress = 0;
        this.isStart = false;
        this.justClearOption = false;
        this.mLoading = false;
        this.mNeedSitemapJson = false;
        this.mOverrideResourceRequestOptions = null;
        this.mOverrideUrlLoadingDataOptions = null;
        this.mListenResourceLoadingOptions = null;
        initANID();
    }

    private java.lang.String checkRedCssline(java.lang.String str) {
        java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(str.getBytes());
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(byteArrayInputStream));
        while (true) {
            try {
                java.lang.String line = bufferedReader.readLine();
                if (line == null) {
                    return stringBuffer.substring(0, stringBuffer.length() - 1);
                }
                stringBuffer.append(io.dcloud.common.util.JSUtil.QUOTE + line + "\"\n+");
            } catch (java.io.IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public static void clearData() {
        setedWebViewData = false;
        sCustomUserAgent = null;
        sDefalutUserAgent = null;
    }

    public static io.dcloud.common.DHInterface.IJsInterface[] combineObj2Array(io.dcloud.common.DHInterface.IJsInterface[] iJsInterfaceArr, io.dcloud.common.DHInterface.IJsInterface iJsInterface) {
        io.dcloud.common.DHInterface.IJsInterface[] iJsInterfaceArr2;
        if (iJsInterfaceArr == null) {
            iJsInterfaceArr2 = new io.dcloud.common.DHInterface.IJsInterface[1];
        } else {
            int length = iJsInterfaceArr.length;
            io.dcloud.common.DHInterface.IJsInterface[] iJsInterfaceArr3 = new io.dcloud.common.DHInterface.IJsInterface[length + 1];
            java.lang.System.arraycopy(iJsInterfaceArr, 0, iJsInterfaceArr3, 0, length);
            iJsInterfaceArr2 = iJsInterfaceArr3;
        }
        iJsInterfaceArr2[iJsInterfaceArr2.length] = iJsInterface;
        return iJsInterfaceArr2;
    }

    private void pushEvalJsOption(java.lang.String str) {
        java.lang.String[] strArr = this.mEvalJsOptionStack;
        if (strArr == null) {
            this.mEvalJsOptionStack = new java.lang.String[1];
        } else {
            java.lang.String[] strArr2 = new java.lang.String[strArr.length + 1];
            this.mEvalJsOptionStack = strArr2;
            java.lang.System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        }
        java.lang.String[] strArr3 = this.mEvalJsOptionStack;
        strArr3[strArr3.length - 1] = str;
        io.dcloud.common.adapter.util.Logger.d("adawebview", "webviewimp=(" + this.mWebViewImpl + ");pushEvalJs=" + str);
    }

    private void startWebProgress() {
        if (this.mFrameView.obtainFrameOptions().mProgressJson == null) {
            com.dcloud.android.widget.DCWebViewProgressBar dCWebViewProgressBar = this.mWebProgressView;
            if (dCWebViewProgressBar != null) {
                dCWebViewProgressBar.setVisibility(8);
                if (this.mWebProgressView.getParent() != null) {
                    ((android.view.ViewGroup) this.mWebProgressView.getParent()).removeView(this.mWebProgressView);
                }
                this.mWebProgressView = null;
                return;
            }
            return;
        }
        if (this.mWebProgressView == null) {
            this.mWebProgressView = new com.dcloud.android.widget.DCWebViewProgressBar(getContext());
        }
        org.json.JSONObject jSONObject = this.mFrameView.obtainFrameOptions().mProgressJson;
        java.lang.String strOptString = jSONObject.optString("color", "#00FF00");
        java.lang.String strOptString2 = jSONObject.optString("height", "2px");
        this.mWebProgressView.setColorInt(io.dcloud.common.util.PdrUtil.stringToColor(strOptString));
        int iConvertToScreenInt = io.dcloud.common.util.PdrUtil.convertToScreenInt(strOptString2, obtainWindowView().getMeasuredWidth(), 0, getScale());
        this.mWebProgressView.setVisibility(0);
        this.mWebProgressView.setAlphaInt(255);
        if (this.mWebProgressView.getParent() == null && getWebviewParent() != null) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) getWebviewParent().obtainMainView();
            if (viewGroup == null) {
                return;
            } else {
                viewGroup.addView(this.mWebProgressView, new android.view.ViewGroup.LayoutParams(-1, iConvertToScreenInt));
            }
        }
        this.mWebProgressView.startProgress();
    }

    @Override // io.dcloud.common.adapter.ui.AdaContainerFrameItem, io.dcloud.common.DHInterface.IContainerView
    public void addFrameItem(io.dcloud.common.adapter.ui.AdaFrameItem adaFrameItem) {
        super.addFrameItem(adaFrameItem);
    }

    public void addJsInterface(java.lang.String str, java.lang.String str2) {
        this.mWebViewImpl.addJavascriptInterface(str2, str);
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public void addStateListener(io.dcloud.common.DHInterface.IWebviewStateListener iWebviewStateListener) {
        if (this.mStateListeners == null) {
            this.mStateListeners = new java.util.ArrayList<>();
        }
        if (iWebviewStateListener != null) {
            this.mStateListeners.add(iWebviewStateListener);
        }
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public void appendPreloadJsFile(java.lang.String str) {
        this.mPreloadJsFile.add(str);
        io.dcloud.common.adapter.util.Logger.d("AdaWebview", "appendPreloadJsFile mPreloadJsFile=" + this.mPreloadJsFile + ";this=" + this);
        if (this.mPlusLoaded) {
            android.util.Log.d("AdaWebview", "appendPreloadJsFile---=" + str);
            java.lang.String strLoadFileContent = loadFileContent(str, this.mFrameView.obtainApp().obtainRunningAppMode() == 1 ? 0 : 2);
            if (android.text.TextUtils.isEmpty(strLoadFileContent)) {
                return;
            }
            loadUrl(io.dcloud.common.constant.AbsoluteConst.PROTOCOL_JAVASCRIPT + strLoadFileContent + ";");
        }
    }

    public boolean backOrForward(int i) {
        return this.mWebViewImpl.canGoBackOrForward(i);
    }

    public boolean canGoBack() {
        boolean z = !this.justClearOption && this.mWebViewImpl.canGoBack();
        io.dcloud.common.adapter.util.Logger.d("AdaFrameItem", "canGoBack" + this.mWebViewImpl.getUrlStr() + ";" + this.justClearOption + ";" + z);
        return z;
    }

    public boolean canGoForward() {
        return !this.justClearOption && this.mWebViewImpl.canGoForward();
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public void checkIfNeedLoadOriginalUrl() {
        if (this.mLoading || this.mLoaded) {
            return;
        }
        loadUrl(getOriginalUrl());
    }

    public void checkInjectSitemap() {
        if (this.mNeedSitemapJson && this.mLoaded && this.mPreloadJsLoaded) {
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            java.io.File file = new java.io.File(io.dcloud.common.util.BaseInfo.sBaseFsSitMapPath + java.io.File.separator + obtainApp().obtainAppId() + "_sitemap.json");
            if (file.exists()) {
                try {
                    stringBuffer.append(";window.__wap2app_sitemap=");
                    stringBuffer.append(io.dcloud.common.util.IOUtil.toString(new java.io.FileInputStream(file)));
                    stringBuffer.append(";wap2app&wap2app.initSitemap();\n");
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
                executeScript(stringBuffer.toString());
                this.mNeedSitemapJson = false;
            }
        }
    }

    public boolean checkOverrideUrl(java.lang.String str) {
        io.dcloud.common.adapter.ui.webview.DCWebView dCWebView = this.mWebViewImpl;
        if (dCWebView == null) {
            return false;
        }
        return dCWebView.checkOverrideUrl(this.mOverrideUrlLoadingDataOptions, str);
    }

    public void checkPreLoadJsContent() {
        this.mWebViewImpl.onPreloadJSContent("checkPreLoadJsContent " + this);
    }

    public boolean checkResourceLoading(java.lang.String str) {
        org.json.JSONObject jSONObject = this.mListenResourceLoadingOptions;
        if (jSONObject == null || !jSONObject.has("match")) {
            return true;
        }
        try {
            return java.util.regex.Pattern.compile(this.mListenResourceLoadingOptions.optString("match")).matcher(str).matches();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public io.dcloud.common.adapter.ui.AdaWebview.OverrideResourceRequestItem checkResourceRequestUrl(java.lang.String str) {
        if (this.mOverrideResourceRequestOptions == null) {
            return null;
        }
        for (int i = 0; i < this.mOverrideResourceRequestOptions.length(); i++) {
            try {
                org.json.JSONObject jSONObjectOptJSONObject = this.mOverrideResourceRequestOptions.optJSONObject(i);
                java.lang.String strOptString = jSONObjectOptJSONObject.optString("match", "");
                if (!android.text.TextUtils.isEmpty(strOptString) && java.util.regex.Pattern.compile(strOptString).matcher(str).matches()) {
                    java.lang.String strConvert2AbsFullPath = obtainApp().convert2AbsFullPath(jSONObjectOptJSONObject.optString("redirect"));
                    java.lang.String strOptString2 = jSONObjectOptJSONObject.optString(tv.danmaku.ijk.media.player.misc.IMediaFormat.KEY_MIME, io.dcloud.common.util.PdrUtil.getMimeType(strConvert2AbsFullPath));
                    java.lang.String strOptString3 = jSONObjectOptJSONObject.optString("encoding", "utf-8");
                    org.json.JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(com.taobao.weex.ui.component.WXBasicComponentType.HEADER);
                    io.dcloud.common.adapter.ui.AdaWebview.OverrideResourceRequestItem overrideResourceRequestItem = new io.dcloud.common.adapter.ui.AdaWebview.OverrideResourceRequestItem();
                    overrideResourceRequestItem.redirect = strConvert2AbsFullPath;
                    overrideResourceRequestItem.encoding = strOptString3;
                    overrideResourceRequestItem.mime = strOptString2;
                    overrideResourceRequestItem.headerJson = jSONObjectOptJSONObject2;
                    return overrideResourceRequestItem;
                }
            } catch (java.lang.Exception e) {
                io.dcloud.common.adapter.util.Logger.e("AdaWebview", "checkResourceRequestUrl e==" + e.getMessage());
                return null;
            }
        }
        return null;
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public boolean checkWhite(java.lang.String str) {
        io.dcloud.common.adapter.ui.webview.DCWebView dCWebView = this.mWebViewImpl;
        if (dCWebView != null) {
            return dCWebView.checkWhite(str);
        }
        return false;
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public void clearHistory() {
        if (this.mWebViewImpl == null) {
            return;
        }
        io.dcloud.common.adapter.util.Logger.d("AdaFrameItem", "clearHistory url=" + this.mWebViewImpl.getUrlStr());
        this.justClearOption = true;
        this.mWebViewImpl.loadData("<html><head><meta charset=\"utf-8\"></head><body></body><html>", "text/html", "utf-8");
        this.mWebViewImpl.setUrlStr("");
    }

    public void dispatchWebviewStateEvent(int i, java.lang.Object obj) {
        if (i != 1) {
            if (i == 3) {
                int i2 = java.lang.Integer.parseInt(java.lang.String.valueOf(obj));
                this.mProgress = i2;
                if (!this.isStart && i2 < 100) {
                    startWebProgress();
                    this.isStart = true;
                }
                if (this.mProgress >= 100 && this.isStart) {
                    this.isStart = false;
                    com.dcloud.android.widget.DCWebViewProgressBar dCWebViewProgressBar = this.mWebProgressView;
                    if (dCWebViewProgressBar != null) {
                        dCWebViewProgressBar.finishProgress();
                    }
                }
            }
        } else if (this.isStart) {
            this.isStart = false;
            com.dcloud.android.widget.DCWebViewProgressBar dCWebViewProgressBar2 = this.mWebProgressView;
            if (dCWebViewProgressBar2 != null) {
                dCWebViewProgressBar2.finishProgress();
            }
        }
        java.util.ArrayList<io.dcloud.common.DHInterface.IWebviewStateListener> arrayList = this.mStateListeners;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                this.mStateListeners.get(size).onCallBack(i, obj);
            }
        }
    }

    @Override // io.dcloud.common.adapter.ui.AdaContainerFrameItem, io.dcloud.common.adapter.ui.AdaFrameItem
    public void dispose() {
        super.dispose();
        if (this.isDisposed) {
            return;
        }
        this.isDisposed = true;
        this.mProgressView = null;
        if (this.mFrameView.getFrameType() == 5 && !this.mLoaded && this.mProgressIntValue >= 50) {
            this.mFrameView.obtainApp().checkOrLoadlaunchWebview();
        }
        io.dcloud.common.util.BaseInfo.s_Webview_Count--;
        try {
            io.dcloud.common.adapter.ui.webview.DCWebView dCWebView = this.mWebViewImpl;
            if (dCWebView != null) {
                dCWebView.stopLoading();
            }
        } catch (java.lang.Exception unused) {
        }
        io.dcloud.common.adapter.util.MessageHandler.sendMessage(new io.dcloud.common.adapter.util.MessageHandler.IMessages() { // from class: io.dcloud.common.adapter.ui.AdaWebview.3
            @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
            public void execute(java.lang.Object obj) {
                try {
                    io.dcloud.common.adapter.ui.AdaWebview adaWebview = io.dcloud.common.adapter.ui.AdaWebview.this;
                    if (adaWebview.mFrameView != null) {
                        adaWebview.mFrameView = null;
                    }
                    io.dcloud.common.adapter.ui.webview.DCWebView dCWebView2 = adaWebview.mWebViewImpl;
                    if (dCWebView2 != null) {
                        dCWebView2.clearCache(false);
                        if (io.dcloud.common.adapter.ui.AdaWebview.this.mWebViewImpl.getWebView().getParent() != null) {
                            ((android.view.ViewGroup) io.dcloud.common.adapter.ui.AdaWebview.this.mWebViewImpl.getWebView().getParent()).removeView(io.dcloud.common.adapter.ui.AdaWebview.this.mWebViewImpl.getWebView());
                        }
                        io.dcloud.common.adapter.ui.AdaWebview.this.mWebViewImpl.destroyWeb();
                        io.dcloud.common.adapter.ui.AdaWebview.this.releaseConfigCallback();
                        io.dcloud.common.adapter.ui.AdaWebview.this.mWebViewImpl = null;
                    }
                    io.dcloud.common.adapter.ui.AdaWebview adaWebview2 = io.dcloud.common.adapter.ui.AdaWebview.this;
                    adaWebview2.mJsInterfaces = null;
                    adaWebview2.mMesssageListener = null;
                    adaWebview2.executeScriptListener = null;
                    adaWebview2.mWebViewParent = null;
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
                if (io.dcloud.common.adapter.ui.AdaWebview.this.mStateListeners != null) {
                    io.dcloud.common.adapter.ui.AdaWebview.this.mStateListeners.clear();
                }
                io.dcloud.common.adapter.ui.AdaWebview.this.mStateListeners = null;
                java.lang.System.gc();
            }
        }, null);
    }

    public void endWebViewEvent(java.lang.String str) {
        if (this.mWebViewParent == null) {
            return;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.PULL_DOWN_REFRESH)) {
            this.mWebViewParent.endPullRefresh();
        } else if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.BOUNCE_REGISTER)) {
            this.mWebViewParent.resetBounce();
        }
    }

    public void evalJS(java.lang.String str) {
        if (this.mPlusLoaded) {
            executeScript(str);
        } else {
            pushEvalJsOption(str);
        }
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public void evalJSSync(java.lang.String str, io.dcloud.common.DHInterface.ICallBack iCallBack) {
        if (this.mWebViewImpl != null) {
            if (!str.startsWith(io.dcloud.common.constant.AbsoluteConst.PROTOCOL_JAVASCRIPT)) {
                str = io.dcloud.common.constant.AbsoluteConst.PROTOCOL_JAVASCRIPT + str;
            }
            this.mWebViewImpl.evalJSSync(str, iCallBack);
        }
    }

    public java.lang.String execScript(java.lang.String str, java.lang.String str2, org.json.JSONArray jSONArray, boolean z) {
        if (!z) {
            return this.mJsInterfaces.exec(str, str2, jSONArray);
        }
        io.dcloud.common.adapter.util.MessageHandler.IMessages iMessages = this.mMesssageListener;
        if (iMessages == null) {
            return null;
        }
        io.dcloud.common.adapter.util.MessageHandler.sendMessage(iMessages, new java.lang.Object[]{str, str2, jSONArray});
        return null;
    }

    public void executeScript(java.lang.String str) {
        io.dcloud.common.adapter.util.MessageHandler.IMessages iMessages;
        if (str == null || (iMessages = this.executeScriptListener) == null) {
            return;
        }
        io.dcloud.common.adapter.util.MessageHandler.sendMessage(iMessages, str);
    }

    void execute_eval_js_stack() {
        if (this.mEvalJsOptionStack == null) {
            return;
        }
        io.dcloud.common.adapter.util.Logger.d("adawebview", "webviewimp=" + this.mWebViewImpl + ";execute_eval_js_stack count=" + this.mEvalJsOptionStack.length);
        int i = 0;
        while (true) {
            java.lang.String[] strArr = this.mEvalJsOptionStack;
            if (i >= strArr.length) {
                this.mEvalJsOptionStack = null;
                return;
            } else {
                executeScript(strArr[i]);
                i++;
            }
        }
    }

    public java.lang.String getCookie(java.lang.String str) {
        io.dcloud.common.adapter.ui.webview.DCWebView dCWebView = this.mWebViewImpl;
        if (dCWebView != null) {
            return dCWebView.getCookie(str);
        }
        return null;
    }

    public java.lang.String getCssString() {
        return this.mCssString;
    }

    public io.dcloud.common.adapter.ui.webview.DCWebView getDCWebView() {
        return this.mWebViewImpl;
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public int getFixBottom() {
        return this.mFixBottomHeight;
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public java.lang.Object getFlag() {
        return this.mFlag;
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public io.dcloud.common.DHInterface.IWebview getOpener() {
        return this.mOpener;
    }

    public java.lang.String getOriginalUrl() {
        return this.originalUrl;
    }

    public float getScale() {
        return this.mWebViewImpl.getScale();
    }

    public float getScaleOfOpenerWebview() {
        return getScale();
    }

    public java.lang.String getScreenAndDisplayJson(io.dcloud.common.DHInterface.IWebview iWebview) {
        float scale = iWebview.getScale();
        io.dcloud.common.DHInterface.IApp iAppObtainApp = iWebview.obtainApp();
        int i = iAppObtainApp.getInt(2);
        int i2 = iAppObtainApp.getInt(0);
        int i3 = (int) (i2 / scale);
        return io.dcloud.common.util.StringUtil.format("(function(p){p.screen.scale=%f;p.screen.resolutionHeight=%d;p.screen.resolutionWidth=%d;p.screen.height=%d;p.screen.width=%d;p.screen.dpiX=%f;p.screen.dpiY=%f;p.display.resolutionHeight=%d;p.display.resolutionWidth=%d;})(((window.__html5plus__&&__html5plus__.isReady)?__html5plus__:(navigator.plus&&navigator.plus.isReady)?navigator.plus:window.plus));", java.lang.Float.valueOf(scale), java.lang.Integer.valueOf((int) (i / scale)), java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2), java.lang.Float.valueOf(io.dcloud.common.adapter.util.DeviceInfo.dpiX), java.lang.Float.valueOf(io.dcloud.common.adapter.util.DeviceInfo.dpiY), java.lang.Integer.valueOf((int) (iAppObtainApp.getInt(1) / scale)), java.lang.Integer.valueOf(i3));
    }

    public java.lang.String getTitle() {
        return this.mWebViewImpl.getTitle();
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public java.lang.String getWebviewANID() {
        return this.mWebviewANID;
    }

    protected io.dcloud.common.adapter.ui.AdaWebViewParent getWebviewParent() {
        return this.mWebViewParent;
    }

    public java.lang.String getWebviewProperty(java.lang.String str) {
        if ("getShareOptions".equals(str)) {
            return this.shareOptions;
        }
        if ("getFavoriteOptions".equals(str)) {
            return this.favoriteOptions;
        }
        if ("needTouchEvent".equals(str)) {
            return java.lang.String.valueOf(this.needTouchEvent);
        }
        if (io.dcloud.common.DHInterface.IWebview.USER_AGENT.equals(str)) {
            io.dcloud.common.adapter.ui.webview.DCWebView dCWebView = this.mWebViewImpl;
            return dCWebView != null ? dCWebView.getUserAgentString() : sDefalutUserAgent;
        }
        if (io.dcloud.common.constant.AbsoluteConst.JSON_KEY_VIDEO_FULL_SCREEN.equals(str)) {
            return this.mVideoFullscreen;
        }
        if ("plusrequire".equals(str)) {
            return this.mPlusrequire;
        }
        if (!io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SHAREABLE.equals(str)) {
            return null;
        }
        return this.mShareable + "";
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public final java.lang.String getWebviewUUID() {
        return this.mWebviewUUID;
    }

    public java.lang.String get_eval_js_stack() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        if (this.mEvalJsOptionStack != null) {
            int i = 0;
            while (true) {
                java.lang.String[] strArr = this.mEvalJsOptionStack;
                if (i >= strArr.length) {
                    break;
                }
                java.lang.String str = strArr[i];
                if (str.endsWith(";")) {
                    stringBuffer.append(str);
                } else {
                    stringBuffer.append(str).append(";");
                }
                i++;
            }
            this.mEvalJsOptionStack = null;
        }
        return stringBuffer.toString();
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public void goBackOrForward(int i) {
        io.dcloud.common.adapter.ui.webview.DCWebView dCWebView = this.mWebViewImpl;
        if (dCWebView != null) {
            dCWebView.goBackOrForward(i);
        }
    }

    public boolean hadClearHistory(java.lang.String str) {
        return this.justClearOption && io.dcloud.common.util.PdrUtil.isEquals(str, "data:text/html,<html><head><meta charset=\"utf-8\"></head><body></body><html>");
    }

    public boolean hasPreLoadJsFile() {
        return this.mPreloadJsFile.size() > 0;
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public boolean hasWebViewEvent(java.lang.String str) {
        io.dcloud.common.adapter.ui.AdaWebViewParent adaWebViewParent;
        if (!io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.PULL_DOWN_REFRESH) || (adaWebViewParent = this.mWebViewParent) == null) {
            return false;
        }
        return adaWebViewParent.isSetPull2Refresh;
    }

    public void init() {
        io.dcloud.common.adapter.ui.webview.DCWebView dCWebView = this.mWebViewImpl;
        if (dCWebView != null) {
            dCWebView.init();
        }
    }

    protected void initANID() {
        if (android.text.TextUtils.isEmpty(this.mWebviewANID)) {
            this.mWebviewANID = "AD_Webview" + java.lang.System.currentTimeMillis();
        }
    }

    protected void initSitemapState() {
        this.mNeedSitemapJson = (io.dcloud.common.util.BaseInfo.isWap2AppAppid(this.mAppid) && this.mFrameView.getFrameType() == 2) || this.mFrameView.getFrameType() == 4;
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public final void initWebviewUUID(java.lang.String str) {
        this.mWebviewUUID = str;
    }

    @Override // io.dcloud.common.adapter.ui.AdaFrameItem
    public boolean isDisposed() {
        return this.isDisposed;
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public boolean isIWebViewFocusable() {
        return obtainWindowView().isFocusable();
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public boolean isLoaded() {
        return this.mLoaded;
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public boolean isPause() {
        return this.isPause;
    }

    public boolean isRealInject(java.lang.String str) {
        return this.mPlusLoaded && android.text.TextUtils.equals(io.dcloud.common.util.PdrUtil.getUrlPathName(str), io.dcloud.common.util.PdrUtil.getUrlPathName(this.mInjectPlusLoadedUrl));
    }

    public boolean isUniService() {
        return false;
    }

    public boolean isUniWebView() {
        return false;
    }

    public void loadContentData(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        this.mWebViewImpl.loadDataWithBaseURL(str, str2, str3, str4, str);
    }

    public boolean loadCssFile() {
        if (io.dcloud.common.util.PdrUtil.isEmpty(this.mCssString)) {
            return false;
        }
        java.lang.String strReplaceAll = this.mCssString.replaceAll(io.dcloud.common.util.JSUtil.QUOTE, "'");
        this.mCssString = strReplaceAll;
        loadUrl("javascript:var container = document.getElementsByTagName('head')[0];\nvar addStyle = document.createElement('style');\naddStyle.rel = 'stylesheet';\naddStyle.type = 'text/css';\naddStyle.innerHTML = " + checkRedCssline(strReplaceAll) + ";\ncontainer.appendChild(addStyle);\nfirstNode = container.children[0];\n    container.appendChild(addStyle);\n");
        return true;
    }

    void loadFileContent(io.dcloud.common.adapter.ui.AdaWebview.IFExecutePreloadJSContentCallBack iFExecutePreloadJSContentCallBack) {
        if (io.dcloud.common.util.PdrUtil.isEmpty(this.mPreloadJsFile)) {
            return;
        }
        try {
            io.dcloud.common.DHInterface.IApp iAppObtainApp = this.mFrameView.obtainApp();
            if (iAppObtainApp != null) {
                int i = 0;
                int i2 = iAppObtainApp.obtainRunningAppMode() == 1 ? 0 : 2;
                java.util.ArrayList<java.lang.String> arrayList = this.mPreloadJsFile;
                int size = arrayList.size();
                while (i < size) {
                    java.lang.String str = arrayList.get(i);
                    i++;
                    java.lang.String str2 = str;
                    java.lang.String strWrapAppendJsFile = wrapAppendJsFile(str2, i2);
                    if (!android.text.TextUtils.isEmpty(strWrapAppendJsFile)) {
                        java.lang.String str3 = io.dcloud.common.constant.AbsoluteConst.PROTOCOL_JAVASCRIPT + strWrapAppendJsFile + ";";
                        if (iFExecutePreloadJSContentCallBack == null) {
                            loadUrl(str3);
                        } else {
                            iFExecutePreloadJSContentCallBack.callback(this.mWebViewImpl.convertRelPath(str2), str3);
                        }
                    }
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void loadForceAHeadJs() {
        if (io.dcloud.common.util.PdrUtil.isEmpty(this.mFrameView.obtainApp()) || this.mForceAHeadJsFileLoaded || android.text.TextUtils.isEmpty(this.mForceAHeadJsFile)) {
            return;
        }
        java.lang.String strLoadFileContent = loadFileContent(this.mForceAHeadJsFile, this.mFrameView.obtainApp().obtainRunningAppMode() == 1 ? 0 : 2);
        if (android.text.TextUtils.isEmpty(strLoadFileContent)) {
            return;
        }
        loadUrl(io.dcloud.common.constant.AbsoluteConst.PROTOCOL_JAVASCRIPT + strLoadFileContent + ";");
        this.mForceAHeadJsFileLoaded = true;
    }

    public void loadUrl(java.lang.String str) {
        io.dcloud.common.adapter.ui.webview.DCWebView dCWebView = this.mWebViewImpl;
        if (dCWebView != null && io.dcloud.common.util.PdrUtil.isEmpty(dCWebView.getUrlStr()) && str != null && !str.startsWith(io.dcloud.common.constant.AbsoluteConst.PROTOCOL_JAVASCRIPT)) {
            this.mWebViewImpl.setUrlStr(str);
            this.hasErrorPage = false;
            this.errorPageUrl = null;
        }
        io.dcloud.common.adapter.ui.webview.DCWebView dCWebView2 = this.mWebViewImpl;
        if (dCWebView2 != null) {
            dCWebView2.loadUrl(str);
        }
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public java.lang.String obtainFrameId() {
        return this.mFrameId;
    }

    public io.dcloud.common.DHInterface.IFrameView obtainFrameView() {
        return this.mFrameView;
    }

    public java.lang.String obtainFullUrl() {
        return !android.text.TextUtils.isEmpty(this.mWebViewImpl.getUrlStr()) ? this.mWebViewImpl.getUrlStr() : this.mWebViewImpl.getUrl();
    }

    public java.lang.String obtainPageTitle() {
        try {
            if (android.os.Looper.myLooper() != null && android.os.Looper.getMainLooper() == android.os.Looper.myLooper()) {
                java.lang.String title = this.mWebViewImpl.getTitle();
                return android.text.TextUtils.isEmpty(title) ? this.mWebViewImpl.getPageTitle() : title;
            }
        } catch (java.lang.Exception e) {
            io.dcloud.common.adapter.util.Logger.e("AdaWebview", "e.getMessage()==" + e.getMessage());
        }
        return this.mWebViewImpl.getPageTitle();
    }

    public java.lang.String obtainUrl() {
        io.dcloud.common.adapter.ui.webview.DCWebView dCWebView = this.mWebViewImpl;
        if (dCWebView == null) {
            return "";
        }
        if (dCWebView.getUrlStr() == null) {
            return this.mWebViewImpl.getUrl();
        }
        int iIndexOf = this.mWebViewImpl.getUrlStr().indexOf(this.mWebViewImpl.getBaseUrl());
        java.lang.String urlStr = this.mWebViewImpl.getUrlStr();
        return iIndexOf >= 0 ? urlStr.substring(this.mWebViewImpl.getBaseUrl().length()) : urlStr;
    }

    public android.webkit.WebView obtainWebview() {
        if (this.mWebViewImpl.getWebView() instanceof android.webkit.WebView) {
            return (android.webkit.WebView) this.mWebViewImpl.getWebView();
        }
        return null;
    }

    public android.view.ViewGroup obtainWindowView() {
        return this.mWebViewImpl.getWebView();
    }

    @Override // io.dcloud.common.adapter.ui.AdaContainerFrameItem, io.dcloud.common.adapter.ui.AdaFrameItem
    public boolean onDispose() {
        android.view.View view = this.mProgressView;
        if (view != null && view.getParent() != null) {
            ((android.view.ViewGroup) this.mProgressView.getParent()).removeView(this.mProgressView);
        }
        return super.onDispose();
    }

    public void onPageStarted() {
        this.mLoading = true;
        io.dcloud.common.adapter.ui.webview.DCWebView dCWebView = this.mWebViewImpl;
        if (dCWebView != null) {
            dCWebView.onPageStarted();
        }
        try {
            if (this.mFrameView.getFrameType() == 5 && android.text.TextUtils.equals(this.mFrameView.obtainApp().obtainWebAppIntent().getStringExtra(io.dcloud.common.constant.IntentConst.DIRECT_PAGE), obtainUrl())) {
                obtainWindowView().postDelayed(new java.lang.Runnable() { // from class: io.dcloud.common.adapter.ui.AdaWebview.6
                    @Override // java.lang.Runnable
                    public void run() {
                        io.dcloud.common.adapter.ui.AdaWebview adaWebview = io.dcloud.common.adapter.ui.AdaWebview.this;
                        if (adaWebview.mLoaded || adaWebview.mFrameView.obtainApp() == null) {
                            return;
                        }
                        io.dcloud.common.adapter.ui.AdaWebview.this.mFrameView.obtainApp().checkOrLoadlaunchWebview();
                    }
                }, 6000L);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public void onRootViewGlobalLayout(android.view.View view) {
        try {
            io.dcloud.common.DHInterface.IApp iAppObtainApp = obtainApp();
            if (iAppObtainApp != null) {
                iAppObtainApp.obtainWebAppRootView().onRootViewGlobalLayout(view);
            }
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public void pause() {
        if (this.mWebViewImpl != null) {
            this.isPause = true;
            obtainMainView().post(new java.lang.Runnable() { // from class: io.dcloud.common.adapter.ui.AdaWebview.1
                @Override // java.lang.Runnable
                public void run() {
                    io.dcloud.common.adapter.ui.AdaWebview.this.mWebViewImpl.onPause();
                }
            });
            io.dcloud.common.adapter.ui.AdaFrameView adaFrameView = this.mFrameView;
            if (adaFrameView != null) {
                adaFrameView.dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENTS_WEBVIEW_PAUSE, this);
            }
        }
    }

    public void reload() {
        if (io.dcloud.common.util.PdrUtil.isEmpty(this.mWebViewImpl.getUrlStr())) {
            return;
        }
        removeAllFrameItem();
        try {
            if (io.dcloud.common.util.BaseInfo.ISDEBUG) {
                this.mWebViewImpl.clearCache(false);
            }
        } catch (java.lang.Exception unused) {
        }
        this.mWebViewImpl.setDidTouch(false);
        this.mWebViewImpl.reload();
        java.lang.StringBuilder sb = new java.lang.StringBuilder("reload url=");
        io.dcloud.common.adapter.ui.webview.DCWebView dCWebView = this.mWebViewImpl;
        sb.append(dCWebView.convertRelPath(dCWebView.getUrlStr()));
        io.dcloud.common.adapter.util.Logger.d("webview", sb.toString());
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public void removeAllCookie() {
        io.dcloud.common.adapter.ui.webview.DCWebView dCWebView = this.mWebViewImpl;
        if (dCWebView != null) {
            dCWebView.removeAllCookie();
            return;
        }
        java.net.CookieHandler cookieHandler = java.net.CookieHandler.getDefault();
        if (cookieHandler instanceof io.dcloud.common.util.net.http.WebkitCookieManagerProxy) {
            ((io.dcloud.common.util.net.http.WebkitCookieManagerProxy) cookieHandler).removeAllCookie();
        }
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public void removeSessionCookie() {
        io.dcloud.common.adapter.ui.webview.DCWebView dCWebView = this.mWebViewImpl;
        if (dCWebView != null) {
            dCWebView.removeSessionCookie();
            return;
        }
        java.net.CookieHandler cookieHandler = java.net.CookieHandler.getDefault();
        if (cookieHandler instanceof io.dcloud.common.util.net.http.WebkitCookieManagerProxy) {
            ((io.dcloud.common.util.net.http.WebkitCookieManagerProxy) cookieHandler).removeSessionCookie();
        }
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public void removeStateListener(io.dcloud.common.DHInterface.IWebviewStateListener iWebviewStateListener) {
        java.util.ArrayList<io.dcloud.common.DHInterface.IWebviewStateListener> arrayList = this.mStateListeners;
        if (arrayList != null) {
            arrayList.remove(iWebviewStateListener);
        }
    }

    public void resetPlusLoadSaveData() {
        this.mPlusLoaded = false;
        this.mPlusLoading = false;
        this.mPreloadJsLoaded = false;
        this.mPreloadJsLoading = false;
        this.mInjectPlusWidthJs = null;
        this.mLoaded = false;
        this.mIsAdvanceCss = false;
        this.mInjectGeoLoaded = false;
        this.mForceAHeadJsFileLoaded = false;
        this.mInjectPlusLoadedUrl = null;
        initSitemapState();
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public void resume() {
        if (this.mWebViewImpl != null) {
            this.isPause = false;
            obtainMainView().post(new java.lang.Runnable() { // from class: io.dcloud.common.adapter.ui.AdaWebview.2
                @Override // java.lang.Runnable
                public void run() {
                    io.dcloud.common.adapter.ui.AdaWebview.this.mWebViewImpl.onResume();
                }
            });
            io.dcloud.common.adapter.ui.AdaFrameView adaFrameView = this.mFrameView;
            if (adaFrameView != null) {
                adaFrameView.dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENTS_WEBVIEW_RESUME, this);
            }
        }
    }

    public void saveWebViewData(java.lang.String str) {
        io.dcloud.common.adapter.ui.webview.DCWebView dCWebView;
        if (!this.mPlusLoading || (dCWebView = this.mWebViewImpl) == null) {
            return;
        }
        if (android.text.TextUtils.isEmpty(dCWebView.getUrlStr())) {
            this.mWebViewImpl.setUrlStr(str);
        } else if (!android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.equals(str, "about:blank")) {
            this.mWebViewImpl.setUrlStr(str);
        }
        io.dcloud.common.adapter.util.Logger.i("AdaFrameItem", "saveWebViewData url=" + str);
        this.mPlusLoaded = true;
        this.mInjectPlusLoadedUrl = this.mWebViewImpl.getUrlStr();
        this.mPreloadJsLoaded = this.mPreloadJsLoading;
        this.mWebViewImpl.onUpdatePlusData("saveWebViewData");
        this.mWebViewImpl.listenPageFinishTimeout("saveWebViewData");
        if (this.mFrameView.getCircleRefreshView() == null || !this.mFrameView.getCircleRefreshView().isRefreshing()) {
            return;
        }
        this.mFrameView.getCircleRefreshView().endRefresh();
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0028  */
    @Override // io.dcloud.common.DHInterface.IWebview
    public void setAssistantType(java.lang.String str) {
        boolean z;
        int i;
        io.dcloud.common.adapter.util.Logger.e("AssistantInput", "setAssistantType type=" + str);
        int iConvertInt = io.dcloud.common.adapter.ui.RecordView.Utils.convertInt(str);
        io.dcloud.common.adapter.ui.CustomeizedInputConnection.sDefaultInputType = iConvertInt;
        io.dcloud.common.adapter.ui.CustomeizedInputConnection customeizedInputConnection = sCustomeizedInputConnection;
        if (customeizedInputConnection != null && (i = customeizedInputConnection.mInputType) != iConvertInt) {
            z = (i == 1 || i == 2) ? false : true;
        }
        if (mRecordView != null && z && io.dcloud.common.adapter.util.AndroidResources.sIMEAlive) {
            io.dcloud.common.adapter.ui.RecordView recordView = mRecordView;
            recordView.update(recordView.mAnchorY, iConvertInt);
        }
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public void setCookie(java.lang.String str, java.lang.String str2) {
        io.dcloud.common.adapter.ui.webview.DCWebView dCWebView = this.mWebViewImpl;
        if (dCWebView != null) {
            dCWebView.setCookie(str, str2);
            return;
        }
        try {
            java.net.CookieHandler cookieHandler = java.net.CookieHandler.getDefault();
            if (cookieHandler != null) {
                java.util.HashMap map = new java.util.HashMap();
                java.util.ArrayList arrayList = new java.util.ArrayList();
                arrayList.add(str2);
                map.put(io.dcloud.common.DHInterface.IWebview.SET_COOKIE, arrayList);
                cookieHandler.put(java.net.URI.create(str), map);
            }
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public void setCssFile(java.lang.String str, java.lang.String str2) {
        if (io.dcloud.common.util.PdrUtil.isEmpty(str)) {
            this.mCssString = str2;
        } else {
            this.mCssString = loadFileContent(str, this.mFrameView.obtainApp().obtainRunningAppMode() == 1 ? 0 : 2);
        }
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public void setFixBottom(int i) {
        this.mFixBottomHeight = i;
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public void setFlag(java.lang.Object obj) {
        this.mFlag = obj;
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public void setFrameId(java.lang.String str) {
        this.mFrameId = str;
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public void setIWebViewFocusable(boolean z) {
        android.view.ViewGroup viewGroupObtainWindowView = obtainWindowView();
        io.dcloud.common.adapter.ui.AdaFrameView adaFrameView = this.mFrameView;
        if (adaFrameView != null) {
            io.dcloud.common.DHInterface.AbsMgr absMgrObtainWindowMgr = adaFrameView.obtainWindowMgr();
            io.dcloud.common.DHInterface.IWebview iWebviewObtainWebView = this.mFrameView.obtainWebView();
            io.dcloud.common.adapter.ui.AdaFrameView adaFrameView2 = this.mFrameView;
            java.lang.Object titleNView = io.dcloud.common.util.TitleNViewUtil.getTitleNView(absMgrObtainWindowMgr, iWebviewObtainWebView, adaFrameView2, io.dcloud.common.util.TitleNViewUtil.getTitleNViewId(adaFrameView2));
            if (titleNView instanceof io.dcloud.common.DHInterface.ITitleNView) {
                ((io.dcloud.common.DHInterface.ITitleNView) titleNView).setTitleNViewFocusable(z);
            }
        }
        if (viewGroupObtainWindowView != null) {
            boolean zIsFocusable = viewGroupObtainWindowView.isFocusable();
            if (z && !zIsFocusable) {
                viewGroupObtainWindowView.setFocusable(true);
                viewGroupObtainWindowView.setFocusableInTouchMode(true);
            } else {
                if (z || !zIsFocusable) {
                    return;
                }
                viewGroupObtainWindowView.setFocusable(false);
                viewGroupObtainWindowView.setFocusableInTouchMode(false);
            }
        }
    }

    public void setJsInterface(io.dcloud.common.DHInterface.IJsInterface iJsInterface) {
        if (this.mJsInterfaces == null) {
            this.mJsInterfaces = iJsInterface;
        }
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public void setListenResourceLoading(org.json.JSONObject jSONObject) {
        this.mListenResourceLoadingOptions = jSONObject;
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public void setLoadURLHeads(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.String> map) {
        io.dcloud.common.adapter.ui.webview.DCWebView dCWebView = this.mWebViewImpl;
        if (dCWebView != null) {
            dCWebView.putHeads(str, map);
        }
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public void setOpener(io.dcloud.common.DHInterface.IWebview iWebview) {
        this.mOpener = iWebview;
    }

    public void setOriginalUrl(java.lang.String str) {
        this.originalUrl = str;
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public void setOverrideResourceRequest(org.json.JSONArray jSONArray) {
        this.mOverrideResourceRequestOptions = jSONArray;
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public void setOverrideUrlLoadingData(org.json.JSONObject jSONObject) {
        this.mOverrideUrlLoadingDataOptions = jSONObject;
        io.dcloud.common.adapter.util.Logger.d("AdaFrameItem", "setOverrideUrlLoadingData=" + jSONObject);
        if (this.mFrameView.getFrameType() == 2 || this.mFrameView.getFrameType() == 5) {
            this.mFrameView.obtainApp().setConfigProperty("wap2app_running_mode", io.dcloud.common.constant.AbsoluteConst.FALSE);
            io.dcloud.common.adapter.ui.webview.DCWebView dCWebView = this.mWebViewImpl;
            if (dCWebView != null) {
                dCWebView.closeWap2AppBlockDialog(true);
            }
        }
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public void setPreloadJsFile(java.lang.String str, boolean z) {
        if (z) {
            this.mForceAHeadJsFileLoaded = false;
            this.mForceAHeadJsFile = str;
            if (this.mPlusLoaded) {
                loadForceAHeadJs();
                return;
            }
            return;
        }
        this.mPreloadJsFile.clear();
        this.mPreloadJsFile.add(str);
        io.dcloud.common.adapter.util.Logger.d("AdaWebview", "setPreloadJsFile mPreloadJsFile=" + this.mPreloadJsFile);
        if (this.mPlusLoaded) {
            android.util.Log.d("AdaWebview", "setPreloadJsFile---=" + str);
            loadFileContent(null);
        }
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public void setProgressView(android.view.View view) {
        this.mProgressView = view;
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public void setScrollIndicator(java.lang.String str) {
        if (this.mWebViewImpl != null) {
            if (io.dcloud.common.util.PdrUtil.isEquals(str, "none")) {
                this.mWebViewImpl.setHorizontalScrollBarEnabled(false);
                this.mWebViewImpl.setVerticalScrollBarEnabled(false);
            } else if (io.dcloud.common.util.PdrUtil.isEquals(str, "vertical")) {
                this.mWebViewImpl.setHorizontalScrollBarEnabled(false);
                this.mWebViewImpl.setVerticalScrollBarEnabled(true);
            } else if (io.dcloud.common.util.PdrUtil.isEquals(str, com.taobao.weex.common.Constants.Value.HORIZONTAL)) {
                this.mWebViewImpl.setHorizontalScrollBarEnabled(true);
                this.mWebViewImpl.setVerticalScrollBarEnabled(false);
            } else {
                this.mWebViewImpl.setHorizontalScrollBarEnabled(true);
                this.mWebViewImpl.setVerticalScrollBarEnabled(true);
            }
        }
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public void setWebViewCacheMode(java.lang.String str) {
        io.dcloud.common.adapter.ui.webview.DCWebView dCWebView = this.mWebViewImpl;
        if (dCWebView != null) {
            dCWebView.setWebViewCacheMode(str);
        }
    }

    public void setWebViewEvent(java.lang.String str, java.lang.Object obj) {
        if (this.mWebViewParent == null) {
            return;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.PULL_DOWN_REFRESH)) {
            this.mWebViewParent.parsePullToReFresh((org.json.JSONObject) obj);
        } else if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.PULL_REFRESH_BEGIN)) {
            this.mWebViewParent.beginPullRefresh();
        } else if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.BOUNCE_REGISTER)) {
            this.mWebViewParent.parseBounce((org.json.JSONObject) obj);
        }
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public void setWebviewProperty(java.lang.String str, java.lang.String str2) {
        if ("setShareOptions".equals(str)) {
            if (android.text.TextUtils.isEmpty(str2)) {
                this.shareOptions = "";
                return;
            }
            this.shareOptions = str2;
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(this.shareOptions);
                if (jSONObject.has(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ICON)) {
                    java.lang.String string = jSONObject.getString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ICON);
                    if (android.text.TextUtils.isEmpty(string)) {
                        return;
                    }
                    com.nostra13.dcloudimageloader.core.ImageLoaderL.getInstance().loadImageSync(string);
                    return;
                }
                return;
            } catch (java.lang.Exception unused) {
                return;
            }
        }
        if ("setFavoriteOptions".equals(str)) {
            if (android.text.TextUtils.isEmpty(str2)) {
                this.favoriteOptions = "";
                return;
            } else {
                this.favoriteOptions = str2;
                return;
            }
        }
        if ("needTouchEvent".equals(str)) {
            if (android.text.TextUtils.isEmpty(str2)) {
                this.needTouchEvent = "";
                return;
            } else {
                this.needTouchEvent = str2;
                return;
            }
        }
        if (io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SCALABLE.equals(str)) {
            if (this.mWebViewImpl != null) {
                this.mWebViewImpl.initScalable(io.dcloud.common.util.PdrUtil.parseBoolean(str2, this.mFrameView.obtainFrameOptions().scalable, false));
                return;
            }
            return;
        }
        if (io.dcloud.common.DHInterface.IWebview.USER_AGENT.equals(str)) {
            if (this.mWebViewImpl != null) {
                if (java.lang.Boolean.parseBoolean(this.mFrameView.obtainApp().obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_H5PLUS)) && str2.indexOf(" Html5Plus/") < 0) {
                    str2 = str2 + io.dcloud.common.adapter.ui.webview.DCWebView.UserAgentExtInfo;
                }
                sCustomUserAgent = str2;
                this.mWebViewImpl.getWebView().post(new java.lang.Runnable() { // from class: io.dcloud.common.adapter.ui.AdaWebview.7
                    @Override // java.lang.Runnable
                    public void run() {
                        io.dcloud.common.adapter.ui.AdaWebview.this.mWebViewImpl.setUserAgentString(io.dcloud.common.adapter.ui.AdaWebview.sCustomUserAgent);
                    }
                });
                return;
            }
            return;
        }
        if (io.dcloud.common.constant.AbsoluteConst.JSON_KEY_BLOCK_NETWORK_IMAGE.equals(str)) {
            if (this.mWebViewImpl != null) {
                this.mWebViewImpl.setBlockNetworkImage(io.dcloud.common.util.PdrUtil.parseBoolean(str2, false, false));
                return;
            }
            return;
        }
        if ("injection".equals(str)) {
            this.mNeedInjection = io.dcloud.common.util.PdrUtil.parseBoolean(str2, true, false);
            return;
        }
        if ("bounce".equals(str)) {
            if (this.mWebViewImpl == null || io.dcloud.common.adapter.util.DeviceInfo.sDeviceSdkVer < 9) {
                return;
            }
            org.json.JSONObject jSONObject2 = this.mFrameView.obtainFrameOptions().titleNView;
            if (("vertical".equalsIgnoreCase(str2) || com.taobao.weex.common.Constants.Value.HORIZONTAL.equalsIgnoreCase(str2) || "all".equalsIgnoreCase(str2)) && (jSONObject2 == null || !"transparent".equals(jSONObject2.optString("type")))) {
                this.mWebViewImpl.getWebView().setOverScrollMode(0);
                return;
            } else {
                this.mWebViewImpl.getWebView().setOverScrollMode(2);
                return;
            }
        }
        if (io.dcloud.common.constant.AbsoluteConst.JSON_KEY_VIDEO_FULL_SCREEN.equals(str)) {
            if (android.text.TextUtils.isEmpty(str2)) {
                return;
            }
            this.mVideoFullscreen = str2;
        } else if ("plusrequire".equals(str)) {
            if (android.text.TextUtils.isEmpty(str2)) {
                return;
            }
            this.mPlusrequire = str2;
        } else if ("geolocation".equals(str)) {
            if (android.text.TextUtils.isEmpty(str2)) {
                return;
            }
            this.mInjectGEO = str2;
        } else {
            if (!io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SHAREABLE.equals(str) || android.text.TextUtils.isEmpty(str2)) {
                return;
            }
            this.mShareable = io.dcloud.common.util.PdrUtil.parseBoolean(str2, true, false);
        }
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public void setWebviewclientListener(io.dcloud.common.DHInterface.IDCloudWebviewClientListener iDCloudWebviewClientListener) {
        this.mWebViewImpl.setDcloudwebviewclientListener(iDCloudWebviewClientListener);
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public void stopLoading() {
        io.dcloud.common.adapter.ui.webview.DCWebView dCWebView = this.mWebViewImpl;
        if (dCWebView != null) {
            dCWebView.stopLoading();
        }
    }

    public java.lang.String toString() {
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("<UUID=");
            sb.append(this.mWebviewUUID);
            sb.append(">;");
            sb.append(obtainMainView() != null ? obtainMainView().toString() : "view = null");
            return sb.toString();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return super.toString();
        }
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public boolean unReceiveTitle() {
        return this.unReceiveTitle;
    }

    java.lang.String wrapAppendJsFile(java.lang.String str, int i) {
        if (!io.dcloud.common.util.BaseInfo.isWap2AppAppid(this.mAppid) || str.endsWith("wap2app.js") || (!io.dcloud.common.util.BaseInfo.SyncDebug && !io.dcloud.common.util.BaseInfo.isBase(getContext()))) {
            return loadFileContent(str, i);
        }
        if (str.startsWith(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL)) {
            str = str.substring(7);
        }
        if (io.dcloud.common.util.PdrUtil.isNetPath(this.mWebViewImpl.getUrlStr())) {
            str = "/h5pscript://" + str;
        } else if (!str.startsWith("h5pscript://")) {
            str = "h5pscript://" + str;
        }
        return "javascript:(function(){var container = document.getElementsByTagName('head')[0];\nvar script = document.createElement('script');\nscript.type = 'text/javascript';\nscript.src = '" + str + "';\ncontainer.appendChild(script);\nfirstNode = container.children[0];\nif(firstNode == null || firstNode==undefined)\n{    container.appendChild(script);}\nelse{\n\tcontainer.insertBefore(script,container.children[0]);\n}})();";
    }

    public void addJsInterface(java.lang.String str, java.lang.Object obj) {
        this.mWebViewImpl.addJavascriptInterface(obj, str);
    }

    public java.lang.String getAppName() {
        io.dcloud.common.adapter.ui.AdaFrameView adaFrameView = this.mFrameView;
        return (adaFrameView == null || adaFrameView.obtainApp() == null) ? "" : this.mFrameView.obtainApp().obtainAppName();
    }

    public java.lang.String getPreLoadJsString() {
        io.dcloud.common.DHInterface.IApp iAppObtainApp;
        if (io.dcloud.common.util.PdrUtil.isEmpty(this.mPreloadJsFile) || (iAppObtainApp = this.mFrameView.obtainApp()) == null || this.mPreloadJsFile.size() <= 0) {
            return "";
        }
        int i = 0;
        int i2 = iAppObtainApp.obtainRunningAppMode() == 1 ? 0 : 2;
        java.util.ArrayList<java.lang.String> arrayList = this.mPreloadJsFile;
        int size = arrayList.size();
        java.lang.String str = ";";
        while (i < size) {
            java.lang.String str2 = arrayList.get(i);
            i++;
            java.lang.String str3 = str2;
            if (!this.mPlusrequire.equals("none") || (!str3.contains("__wap2app.js") && !str3.contains("__wap2appconfig.js"))) {
                java.lang.String strWrapAppendJsFile = wrapAppendJsFile(str3, i2);
                if (!android.text.TextUtils.isEmpty(strWrapAppendJsFile)) {
                    str = str + strWrapAppendJsFile + "\n";
                }
            }
        }
        return str + "\n";
    }

    public java.lang.String syncUpdateWebViewData(java.lang.String str) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        java.lang.String webviewUUID = getWebviewUUID();
        if (io.dcloud.common.util.PdrUtil.isEmpty(webviewUUID)) {
            webviewUUID = java.lang.String.valueOf(this.mFrameView.hashCode());
        }
        stringBuffer.append("window.__HtMl_Id__= '" + webviewUUID + "';");
        if (io.dcloud.common.util.PdrUtil.isEmpty(obtainFrameId())) {
            stringBuffer.append("window.__WebVieW_Id__= undefined;");
        } else {
            stringBuffer.append("window.__WebVieW_Id__= '" + obtainFrameId() + "';");
        }
        io.dcloud.common.adapter.util.Logger.e("WebViewData", "syncUpdateWebViewData url=" + this.mRecordLastUrl);
        stringBuffer.append("try{window.plus.__tag__='" + this.mPlusInjectTag + "';location.__plusready__=true;/*console.log(location);window.plus.__url__='" + str + "';*/}catch(e){console.log(e)}");
        return io.dcloud.common.constant.AbsoluteConst.PROTOCOL_JAVASCRIPT + stringBuffer.toString();
    }

    public void addJsInterface(java.lang.String str, io.dcloud.common.DHInterface.IJsInterface iJsInterface) {
        this.mWebViewImpl.addJavascriptInterface(iJsInterface, str);
        setJsInterface(iJsInterface);
    }

    public void evalJS(java.lang.String str, io.dcloud.common.adapter.ui.ReceiveJSValue.ReceiveJSValueCallback receiveJSValueCallback) {
        if (receiveJSValueCallback != null) {
            str = io.dcloud.common.adapter.ui.ReceiveJSValue.registerCallback(str, receiveJSValueCallback);
        }
        evalJS(str);
    }

    public void reload(java.lang.String str) {
        io.dcloud.common.adapter.util.Logger.d("webview", "reload loadUrl url=" + str);
        this.mLoaded = false;
        this.mWebViewImpl.setUrlStr(str);
        this.mWebViewImpl.loadUrl(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseConfigCallback() {
        try {
            java.lang.reflect.Field declaredField = java.lang.Class.forName("android.webkit.BrowserFrame").getDeclaredField("sConfigCallback");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                declaredField.set(null, null);
            }
        } catch (java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.NoSuchFieldException unused) {
        }
    }

    public void reload(boolean z) {
        io.dcloud.common.adapter.ui.webview.DCWebView dCWebView = this.mWebViewImpl;
        if (dCWebView != null) {
            dCWebView.webReload(z);
        }
        reload();
    }

    private java.lang.String loadFileContent(java.lang.String str, int i) {
        byte[] fileContent;
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        java.io.InputStream encryptionInputStream = io.dcloud.common.adapter.ui.webview.WebResUtil.getEncryptionInputStream(str, this.mFrameView.obtainApp());
        try {
            if (encryptionInputStream != null) {
                stringBuffer.append(io.dcloud.common.util.IOUtil.toString(encryptionInputStream));
            } else {
                str = this.mFrameView.obtainApp().convert2AbsFullPath(obtainFullUrl(), str);
                try {
                    if (io.dcloud.common.adapter.io.DHFile.isExist(str) && (fileContent = io.dcloud.common.adapter.util.PlatformUtil.getFileContent(str, i)) != null) {
                        stringBuffer.append(new java.lang.String(fileContent));
                    }
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (java.io.IOException e2) {
            e2.printStackTrace();
        } finally {
            io.dcloud.common.util.IOUtil.close(encryptionInputStream);
        }
        if (this.mNeedSitemapJson && str.endsWith("__wap2app.js")) {
            java.io.File file = new java.io.File(io.dcloud.common.util.BaseInfo.sBaseFsSitMapPath + java.io.File.separator + obtainApp().obtainAppId() + "_sitemap.json");
            if (file.exists()) {
                try {
                    stringBuffer.insert(0, io.dcloud.common.util.IOUtil.toString(new java.io.FileInputStream(file)) + ";\n");
                    stringBuffer.insert(0, ";window.__wap2app_sitemap=");
                } catch (java.io.IOException e3) {
                    e3.printStackTrace();
                }
                this.mNeedSitemapJson = false;
            }
        }
        return stringBuffer.toString();
    }

    protected AdaWebview(android.content.Context context, io.dcloud.common.adapter.ui.AdaFrameView adaFrameView) {
        super(context);
        this.unReceiveTitle = true;
        this.mWebViewParent = null;
        this.mRecordLastUrl = null;
        this.mWebViewImpl = null;
        this.mFrameView = null;
        this.mLoaded = false;
        this.mLoadCompleted = false;
        this.mPreloadJsLoaded = false;
        this.mPreloadJsLoading = false;
        this.mPlusLoaded = false;
        this.mPlusLoading = false;
        this.mPlusInjectTag = "page_finished";
        this.mIsAdvanceCss = false;
        this.mNeedInjection = true;
        this.mEncoding = null;
        this.mWebviewUUID = null;
        this.mWebviewANID = null;
        this.mFrameId = null;
        this.mJsInterfaces = null;
        this.hasErrorPage = false;
        this.errorPageUrl = null;
        this.originalUrl = null;
        this.mVideoFullscreen = "auto";
        this.needTouchEvent = "";
        this.favoriteOptions = "";
        this.shareOptions = "";
        this.mShareable = true;
        this.mPlusrequire = "normal";
        this.mInjectGEO = "none";
        this.mInjectGeoLoaded = false;
        this.mProgressIntValue = 0;
        this.isDisposed = false;
        this.mReceiveJSValue_android42 = null;
        this.isPause = false;
        this.mFlag = null;
        this.mInjectPlusLoadedUrl = null;
        this.mEvalJsOptionStack = null;
        this.mForceAHeadJsFileLoaded = false;
        this.mForceAHeadJsFile = null;
        this.mPreloadJsFile = new java.util.ArrayList<>(2);
        this.mCssString = "";
        this.executeScriptListener = new io.dcloud.common.adapter.util.MessageHandler.IMessages() { // from class: io.dcloud.common.adapter.ui.AdaWebview.4
            @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
            public void execute(java.lang.Object obj) {
                java.lang.String str = (java.lang.String) obj;
                io.dcloud.common.adapter.ui.webview.DCWebView dCWebView = io.dcloud.common.adapter.ui.AdaWebview.this.mWebViewImpl;
                if (dCWebView != null) {
                    if (!str.startsWith(io.dcloud.common.constant.AbsoluteConst.PROTOCOL_JAVASCRIPT)) {
                        str = io.dcloud.common.constant.AbsoluteConst.PROTOCOL_JAVASCRIPT + str;
                    }
                    dCWebView.loadUrl(str);
                }
            }
        };
        this.mMesssageListener = new io.dcloud.common.adapter.util.MessageHandler.IMessages() { // from class: io.dcloud.common.adapter.ui.AdaWebview.5
            @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
            public void execute(java.lang.Object obj) {
                java.lang.Object[] objArr = (java.lang.Object[]) obj;
                io.dcloud.common.adapter.ui.AdaWebview.this.mJsInterfaces.exec(java.lang.String.valueOf(objArr[0]), java.lang.String.valueOf(objArr[1]), (org.json.JSONArray) objArr[2]);
            }
        };
        this.mStateListeners = null;
        this.mProgress = 0;
        this.isStart = false;
        this.justClearOption = false;
        this.mLoading = false;
        this.mNeedSitemapJson = false;
        this.mOverrideResourceRequestOptions = null;
        this.mOverrideUrlLoadingDataOptions = null;
        this.mListenResourceLoadingOptions = null;
        initANID();
        this.mFrameView = adaFrameView;
        this.mAppid = adaFrameView.obtainApp().obtainAppId();
        initSitemapState();
        io.dcloud.common.adapter.util.Logger.d("AdaWebview");
        try {
            this.mWebViewImpl = io.dcloud.common.adapter.ui.webview.WebViewFactory.getWebView(getActivity(), this);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            this.mWebViewImpl = io.dcloud.common.adapter.ui.webview.WebViewFactory.getWebView(getActivity(), this);
        }
        setMainView(this.mWebViewImpl.getWebView());
        io.dcloud.common.adapter.ui.AdaWebViewParent adaWebViewParent = new io.dcloud.common.adapter.ui.AdaWebViewParent(context);
        this.mWebViewParent = adaWebViewParent;
        adaWebViewParent.fillsWithWebview(this);
        if (adaFrameView.getFrameType() == 2) {
            this.mOverrideUrlLoadingDataOptions = this.mFrameView.obtainApp().obtainThridInfo(io.dcloud.common.DHInterface.IApp.ConfigProperty.ThridInfo.OverrideUrlJsonData);
            org.json.JSONObject jSONObjectObtainThridInfo = this.mFrameView.obtainApp().obtainThridInfo(io.dcloud.common.DHInterface.IApp.ConfigProperty.ThridInfo.OverrideResourceJsonData);
            if (jSONObjectObtainThridInfo != null) {
                this.mOverrideResourceRequestOptions = jSONObjectObtainThridInfo.optJSONArray(com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
            }
            this.mNeedInjection = io.dcloud.common.util.PdrUtil.parseBoolean(this.mFrameView.obtainApp().obtainConfigProperty("injection"), this.mNeedInjection, false);
            java.lang.String strObtainConfigProperty = this.mFrameView.obtainApp().obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_LPLUSERQUIRE);
            if (!android.text.TextUtils.isEmpty(strObtainConfigProperty)) {
                this.mPlusrequire = strObtainConfigProperty;
            }
            java.lang.String strObtainConfigProperty2 = this.mFrameView.obtainApp().obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_LGEOLOCATION);
            if (android.text.TextUtils.isEmpty(strObtainConfigProperty2)) {
                return;
            }
            this.mInjectGEO = strObtainConfigProperty2;
            return;
        }
        if (adaFrameView.getFrameType() == 4) {
            java.lang.String strObtainConfigProperty3 = this.mFrameView.obtainApp().obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_SPLUSERQUIRE);
            if (!android.text.TextUtils.isEmpty(strObtainConfigProperty3)) {
                this.mPlusrequire = strObtainConfigProperty3;
            }
            java.lang.String strObtainConfigProperty4 = this.mFrameView.obtainApp().obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_SGEOLOCATION);
            if (android.text.TextUtils.isEmpty(strObtainConfigProperty4)) {
                return;
            }
            this.mInjectGEO = strObtainConfigProperty4;
        }
    }

    protected AdaWebview(android.content.Context context, io.dcloud.common.adapter.ui.AdaFrameView adaFrameView, io.dcloud.common.DHInterface.IDCloudWebviewClientListener iDCloudWebviewClientListener) {
        super(context);
        this.unReceiveTitle = true;
        this.mWebViewParent = null;
        this.mRecordLastUrl = null;
        this.mWebViewImpl = null;
        this.mFrameView = null;
        this.mLoaded = false;
        this.mLoadCompleted = false;
        this.mPreloadJsLoaded = false;
        this.mPreloadJsLoading = false;
        this.mPlusLoaded = false;
        this.mPlusLoading = false;
        this.mPlusInjectTag = "page_finished";
        this.mIsAdvanceCss = false;
        this.mNeedInjection = true;
        this.mEncoding = null;
        this.mWebviewUUID = null;
        this.mWebviewANID = null;
        this.mFrameId = null;
        this.mJsInterfaces = null;
        this.hasErrorPage = false;
        this.errorPageUrl = null;
        this.originalUrl = null;
        this.mVideoFullscreen = "auto";
        this.needTouchEvent = "";
        this.favoriteOptions = "";
        this.shareOptions = "";
        this.mShareable = true;
        this.mPlusrequire = "normal";
        this.mInjectGEO = "none";
        this.mInjectGeoLoaded = false;
        this.mProgressIntValue = 0;
        this.isDisposed = false;
        this.mReceiveJSValue_android42 = null;
        this.isPause = false;
        this.mFlag = null;
        this.mInjectPlusLoadedUrl = null;
        this.mEvalJsOptionStack = null;
        this.mForceAHeadJsFileLoaded = false;
        this.mForceAHeadJsFile = null;
        this.mPreloadJsFile = new java.util.ArrayList<>(2);
        this.mCssString = "";
        this.executeScriptListener = new io.dcloud.common.adapter.util.MessageHandler.IMessages() { // from class: io.dcloud.common.adapter.ui.AdaWebview.4
            @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
            public void execute(java.lang.Object obj) {
                java.lang.String str = (java.lang.String) obj;
                io.dcloud.common.adapter.ui.webview.DCWebView dCWebView = io.dcloud.common.adapter.ui.AdaWebview.this.mWebViewImpl;
                if (dCWebView != null) {
                    if (!str.startsWith(io.dcloud.common.constant.AbsoluteConst.PROTOCOL_JAVASCRIPT)) {
                        str = io.dcloud.common.constant.AbsoluteConst.PROTOCOL_JAVASCRIPT + str;
                    }
                    dCWebView.loadUrl(str);
                }
            }
        };
        this.mMesssageListener = new io.dcloud.common.adapter.util.MessageHandler.IMessages() { // from class: io.dcloud.common.adapter.ui.AdaWebview.5
            @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
            public void execute(java.lang.Object obj) {
                java.lang.Object[] objArr = (java.lang.Object[]) obj;
                io.dcloud.common.adapter.ui.AdaWebview.this.mJsInterfaces.exec(java.lang.String.valueOf(objArr[0]), java.lang.String.valueOf(objArr[1]), (org.json.JSONArray) objArr[2]);
            }
        };
        this.mStateListeners = null;
        this.mProgress = 0;
        this.isStart = false;
        this.justClearOption = false;
        this.mLoading = false;
        this.mNeedSitemapJson = false;
        this.mOverrideResourceRequestOptions = null;
        this.mOverrideUrlLoadingDataOptions = null;
        this.mListenResourceLoadingOptions = null;
        initANID();
        this.mFrameView = adaFrameView;
        this.mAppid = adaFrameView.obtainApp().obtainAppId();
        initSitemapState();
        io.dcloud.common.adapter.util.Logger.d("AdaWebview");
        try {
            this.mWebViewImpl = io.dcloud.common.adapter.ui.webview.WebViewFactory.getWebView(getActivity(), this, iDCloudWebviewClientListener);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            this.mWebViewImpl = io.dcloud.common.adapter.ui.webview.WebViewFactory.getWebView(getActivity(), this, iDCloudWebviewClientListener);
        }
        setMainView(this.mWebViewImpl.getWebView());
        io.dcloud.common.adapter.ui.AdaWebViewParent adaWebViewParent = new io.dcloud.common.adapter.ui.AdaWebViewParent(context);
        this.mWebViewParent = adaWebViewParent;
        adaWebViewParent.fillsWithWebview(this);
        if (adaFrameView.getFrameType() == 2) {
            this.mOverrideUrlLoadingDataOptions = this.mFrameView.obtainApp().obtainThridInfo(io.dcloud.common.DHInterface.IApp.ConfigProperty.ThridInfo.OverrideUrlJsonData);
            org.json.JSONObject jSONObjectObtainThridInfo = this.mFrameView.obtainApp().obtainThridInfo(io.dcloud.common.DHInterface.IApp.ConfigProperty.ThridInfo.OverrideResourceJsonData);
            if (jSONObjectObtainThridInfo != null) {
                this.mOverrideResourceRequestOptions = jSONObjectObtainThridInfo.optJSONArray(com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
            }
            this.mNeedInjection = io.dcloud.common.util.PdrUtil.parseBoolean(this.mFrameView.obtainApp().obtainConfigProperty("injection"), this.mNeedInjection, false);
            java.lang.String strObtainConfigProperty = this.mFrameView.obtainApp().obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_LPLUSERQUIRE);
            if (!android.text.TextUtils.isEmpty(strObtainConfigProperty)) {
                this.mPlusrequire = strObtainConfigProperty;
            }
            java.lang.String strObtainConfigProperty2 = this.mFrameView.obtainApp().obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_LGEOLOCATION);
            if (android.text.TextUtils.isEmpty(strObtainConfigProperty2)) {
                return;
            }
            this.mInjectGEO = strObtainConfigProperty2;
            return;
        }
        if (adaFrameView.getFrameType() == 4) {
            java.lang.String strObtainConfigProperty3 = this.mFrameView.obtainApp().obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_SPLUSERQUIRE);
            if (!android.text.TextUtils.isEmpty(strObtainConfigProperty3)) {
                this.mPlusrequire = strObtainConfigProperty3;
            }
            java.lang.String strObtainConfigProperty4 = this.mFrameView.obtainApp().obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_SGEOLOCATION);
            if (android.text.TextUtils.isEmpty(strObtainConfigProperty4)) {
                return;
            }
            this.mInjectGEO = strObtainConfigProperty4;
        }
    }

    protected AdaWebview(android.content.Context context, io.dcloud.common.adapter.ui.AdaFrameView adaFrameView, io.dcloud.common.adapter.ui.webview.OnPageFinishedCallack onPageFinishedCallack) {
        super(context);
        this.unReceiveTitle = true;
        this.mWebViewParent = null;
        this.mRecordLastUrl = null;
        this.mWebViewImpl = null;
        this.mFrameView = null;
        this.mLoaded = false;
        this.mLoadCompleted = false;
        this.mPreloadJsLoaded = false;
        this.mPreloadJsLoading = false;
        this.mPlusLoaded = false;
        this.mPlusLoading = false;
        this.mPlusInjectTag = "page_finished";
        this.mIsAdvanceCss = false;
        this.mNeedInjection = true;
        this.mEncoding = null;
        this.mWebviewUUID = null;
        this.mWebviewANID = null;
        this.mFrameId = null;
        this.mJsInterfaces = null;
        this.hasErrorPage = false;
        this.errorPageUrl = null;
        this.originalUrl = null;
        this.mVideoFullscreen = "auto";
        this.needTouchEvent = "";
        this.favoriteOptions = "";
        this.shareOptions = "";
        this.mShareable = true;
        this.mPlusrequire = "normal";
        this.mInjectGEO = "none";
        this.mInjectGeoLoaded = false;
        this.mProgressIntValue = 0;
        this.isDisposed = false;
        this.mReceiveJSValue_android42 = null;
        this.isPause = false;
        this.mFlag = null;
        this.mInjectPlusLoadedUrl = null;
        this.mEvalJsOptionStack = null;
        this.mForceAHeadJsFileLoaded = false;
        this.mForceAHeadJsFile = null;
        this.mPreloadJsFile = new java.util.ArrayList<>(2);
        this.mCssString = "";
        this.executeScriptListener = new io.dcloud.common.adapter.util.MessageHandler.IMessages() { // from class: io.dcloud.common.adapter.ui.AdaWebview.4
            @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
            public void execute(java.lang.Object obj) {
                java.lang.String str = (java.lang.String) obj;
                io.dcloud.common.adapter.ui.webview.DCWebView dCWebView = io.dcloud.common.adapter.ui.AdaWebview.this.mWebViewImpl;
                if (dCWebView != null) {
                    if (!str.startsWith(io.dcloud.common.constant.AbsoluteConst.PROTOCOL_JAVASCRIPT)) {
                        str = io.dcloud.common.constant.AbsoluteConst.PROTOCOL_JAVASCRIPT + str;
                    }
                    dCWebView.loadUrl(str);
                }
            }
        };
        this.mMesssageListener = new io.dcloud.common.adapter.util.MessageHandler.IMessages() { // from class: io.dcloud.common.adapter.ui.AdaWebview.5
            @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
            public void execute(java.lang.Object obj) {
                java.lang.Object[] objArr = (java.lang.Object[]) obj;
                io.dcloud.common.adapter.ui.AdaWebview.this.mJsInterfaces.exec(java.lang.String.valueOf(objArr[0]), java.lang.String.valueOf(objArr[1]), (org.json.JSONArray) objArr[2]);
            }
        };
        this.mStateListeners = null;
        this.mProgress = 0;
        this.isStart = false;
        this.justClearOption = false;
        this.mLoading = false;
        this.mNeedSitemapJson = false;
        this.mOverrideResourceRequestOptions = null;
        this.mOverrideUrlLoadingDataOptions = null;
        this.mListenResourceLoadingOptions = null;
        initANID();
        this.mFrameView = adaFrameView;
        io.dcloud.common.adapter.util.Logger.d("AdaWebview");
        try {
            this.mWebViewImpl = io.dcloud.common.adapter.ui.webview.WebViewFactory.getWebView(getActivity(), this, onPageFinishedCallack);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            this.mWebViewImpl = io.dcloud.common.adapter.ui.webview.WebViewFactory.getWebView(getActivity(), this, onPageFinishedCallack);
        }
        setMainView(this.mWebViewImpl.getWebView());
        io.dcloud.common.adapter.ui.AdaWebViewParent adaWebViewParent = new io.dcloud.common.adapter.ui.AdaWebViewParent(context);
        this.mWebViewParent = adaWebViewParent;
        adaWebViewParent.fillsWithWebview(this);
    }
}
