package io.dcloud.feature.weex;

/* JADX INFO: loaded from: classes2.dex */
class WXViewWrapper extends io.dcloud.feature.weex.WXBaseWrapper implements com.taobao.weex.IWXRenderListener, io.dcloud.common.DHInterface.IEventCallback, io.dcloud.feature.weex.WeexInstanceMgr.IWXStatisticsCallBack {
    static final int LOAD_JS = 1000;
    java.lang.String TAG;
    private boolean hasScrollListener;
    private boolean isChlid;
    private boolean isCompilerWithUniapp;
    boolean isDelayRender;
    private boolean isFrameShow;
    private boolean isPre;
    boolean isReady;
    boolean isService;
    org.json.JSONObject jsonObject;
    long lastTime;
    java.util.List<io.dcloud.feature.weex.WXViewWrapper.FireEvent> mFireCaches;
    int mFontSize;
    android.os.Handler mHandler;
    com.taobao.weex.IWXInstanceContainerOnSizeListener mInstanceOnSizeListener;
    private float mLastScreenWidth;
    org.json.JSONObject mNvueCfgData;
    private java.util.List<android.os.Message> mRenderCaches;
    com.taobao.weex.utils.tools.LogDetail mServiceLogDetail;
    private java.lang.String mUniPagePath;
    float mViewPort;
    android.view.View mWXSDKView;
    private java.util.List<android.os.Message> mWaitServiceRenderList;
    private java.lang.String readyJs;
    long time;

    @Override // com.taobao.weex.IWXRenderListener
    public void onRefreshSuccess(com.taobao.weex.WXSDKInstance wXSDKInstance, int i, int i2) {
    }

    public java.util.List<android.os.Message> getWaitServiceRenderList() {
        return this.mWaitServiceRenderList;
    }

    @Override // io.dcloud.feature.weex.WXBaseWrapper
    public void onReady() {
        this.isReady = true;
        runFireCache();
        if (this.isService) {
            if (!io.dcloud.feature.internal.sdk.SDK.isUniMPSDK()) {
                io.dcloud.feature.weex.WeexInstanceMgr.self().doForFeature(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 10, new java.lang.Object[]{this.mWebview.obtainApp(), io.dcloud.feature.weex.WeexInstanceMgr.self().getUniMPFeature(), "onUniMPInit", new java.lang.Object[0]});
            }
            com.taobao.weex.utils.tools.LogDetail logDetail = this.mServiceLogDetail;
            if (logDetail != null) {
                logDetail.taskEnd();
                io.dcloud.weex.WXDotDataUtil.setValue(this.mServiceLogDetail.info.taskName, java.lang.Long.valueOf(this.mServiceLogDetail.time.execTime));
            }
        }
    }

    private synchronized void runFireCache() {
        if (!this.mFireCaches.isEmpty()) {
            for (int i = 0; i < this.mFireCaches.size(); i++) {
                io.dcloud.feature.weex.WXViewWrapper.FireEvent fireEvent = this.mFireCaches.get(i);
                fireGlobalEvent(fireEvent.key, fireEvent.params);
            }
            this.mFireCaches.clear();
        }
    }

    WXViewWrapper(io.dcloud.common.DHInterface.IWebview iWebview, android.view.ViewGroup viewGroup, org.json.JSONObject jSONObject, java.lang.String str, int i, boolean z) {
        super(viewGroup.getContext());
        this.TAG = "WXViewWrapper";
        this.lastTime = 0L;
        this.isService = false;
        this.readyJs = ";var plusModule = weex.requireModule('plus'); plusModule.uniReady();";
        this.isReady = false;
        this.mFontSize = -1;
        this.mNvueCfgData = null;
        this.isDelayRender = false;
        this.mRenderCaches = new java.util.ArrayList();
        this.mWaitServiceRenderList = new java.util.ArrayList();
        this.isFrameShow = false;
        this.isChlid = false;
        this.isPre = false;
        this.isCompilerWithUniapp = true;
        this.mHandler = new android.os.Handler() { // from class: io.dcloud.feature.weex.WXViewWrapper.1
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                super.handleMessage(message);
                if (message.what != 1000) {
                    return;
                }
                if (!io.dcloud.feature.weex.WXViewWrapper.this.isService) {
                    io.dcloud.feature.weex.WXViewWrapper.this.delayedRender(message.obj, 10);
                    return;
                }
                if (io.dcloud.feature.weex.WXViewWrapper.this.mWebview == null) {
                    return;
                }
                java.lang.String strObtainConfigProperty = io.dcloud.feature.weex.WXViewWrapper.this.mWebview.obtainApp().obtainConfigProperty(io.dcloud.common.constant.AbsoluteConst.NVUE_LAUNCH_MODE);
                if (android.text.TextUtils.isEmpty(strObtainConfigProperty) || !strObtainConfigProperty.equals("fast") || !io.dcloud.feature.weex.WeexInstanceMgr.self().getControl().equals(io.dcloud.common.constant.AbsoluteConst.UNI_V3) || com.taobao.weex.WXEnvironment.sRemoteDebugMode) {
                    io.dcloud.feature.weex.WXViewWrapper.this.delayedRender(message.obj, 10L);
                    return;
                }
                org.json.JSONObject jSONObjectObtainThridInfo = io.dcloud.feature.weex.WXViewWrapper.this.mWebview.obtainApp().obtainThridInfo(io.dcloud.common.DHInterface.IApp.ConfigProperty.ThridInfo.LaunchWebviewJsonData);
                if (jSONObjectObtainThridInfo == null || !jSONObjectObtainThridInfo.has(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_UNINVIEW)) {
                    io.dcloud.feature.weex.WXViewWrapper.this.delayedRender(message.obj, 10L);
                } else {
                    io.dcloud.feature.weex.WXViewWrapper.this.delayedRender(message.obj, 100L);
                }
            }
        };
        this.mInstanceOnSizeListener = new com.taobao.weex.IWXInstanceContainerOnSizeListener() { // from class: io.dcloud.feature.weex.WXViewWrapper.2
            @Override // com.taobao.weex.IWXInstanceContainerOnSizeListener
            public void onSizeChanged(java.lang.String str2, float f, float f2, boolean z2, boolean z3) {
                io.dcloud.feature.weex.WXViewWrapper.this.updateDeviceDisplay(f, f2, z2, z3);
            }
        };
        this.hasScrollListener = false;
        this.time = 0L;
        this.mLastScreenWidth = 0.0f;
        this.lastTime = java.lang.System.currentTimeMillis();
        io.dcloud.common.adapter.util.Logger.e(this.TAG, "WXViewWrapper----------isPre=" + z + "  wxid=" + str);
        if (!io.dcloud.feature.weex.WeexInstanceMgr.self().isJsFrameworkReady()) {
            io.dcloud.feature.weex.WeexInstanceMgr.self().setWXStatisticsCallBack(this);
        }
        this.isCompilerWithUniapp = !io.dcloud.feature.weex.WeexInstanceMgr.self().getComplier().equalsIgnoreCase("weex");
        this.mWebview = iWebview;
        this.isPre = z;
        this.mFireCaches = new java.util.ArrayList();
        if (this.mWebview instanceof io.dcloud.common.adapter.ui.AdaUniWebView) {
            this.isService = ((io.dcloud.common.adapter.ui.AdaUniWebView) this.mWebview).isUniService();
        }
        if (io.dcloud.feature.weex.WeexInstanceMgr.self().isJSFKFileNotFound()) {
            io.dcloud.common.util.ErrorDialogUtil.showErrorTipsAlert(iWebview.getActivity(), io.dcloud.common.util.StringUtil.format(iWebview.getContext().getString(com.taobao.weex.R.string.dcloud_feature_weex_jsfk_not_found_tips), io.dcloud.feature.weex.WeexInstanceMgr.self().getVueVersion() == 3 ? "VUE3" : "VUE2"), new android.content.DialogInterface.OnClickListener() { // from class: io.dcloud.feature.weex.WXViewWrapper.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(android.content.DialogInterface dialogInterface, int i2) {
                    android.os.Process.killProcess(android.os.Process.myPid());
                }
            });
            return;
        }
        viewGroup.addView(this, i, new android.view.ViewGroup.LayoutParams(-1, -1));
        ((io.dcloud.common.adapter.ui.AdaFrameView) this.mWebview.obtainFrameView()).addFrameViewListener(this);
        this.jsonObject = jSONObject;
        this.lastTime = java.lang.System.currentTimeMillis();
        this.mWxId = str;
        this.mNvueCfgData = io.dcloud.common.util.JSONUtil.createJSONObject(this.mWebview.obtainApp().obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.UNI_NVUE_DATA));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.util.Map<java.lang.String, java.lang.Object> getInitOptions() {
        int iIndexOf;
        java.util.HashMap map = new java.util.HashMap();
        if (this.mWebview != null) {
            map.put("plus_appid", this.mWebview.obtainApp().obtainAppId());
        }
        if (this.mWebview != null) {
            map.put("plus_web_id", this.mWebview.obtainFrameId());
        }
        java.lang.String str = this.mSrcPath;
        if (!android.text.TextUtils.isEmpty(this.mPath) && str.indexOf(com.taobao.weex.el.parse.Operators.CONDITION_IF_STRING) == -1 && (iIndexOf = this.mPath.indexOf(com.taobao.weex.el.parse.Operators.CONDITION_IF_STRING)) > 0) {
            str = str + this.mPath.substring(iIndexOf);
        }
        map.put("deviceLanguage", io.dcloud.common.util.language.LanguageUtil.getDeviceDefLocalLanguage());
        map.put("deviceCountry", io.dcloud.common.util.language.LanguageUtil.getDeviceDefCountry());
        map.put("isInternational", java.lang.Boolean.valueOf(io.dcloud.common.util.PdrUtil.checkIntl()));
        map.put("bundleUrl", str);
        if (getWxId().equals("__uniapp__service")) {
            map.put("plus_weex_id", "__uniapp__service");
        }
        return map;
    }

    public java.lang.String getSrcPath() {
        return this.mSrcPath;
    }

    public java.lang.String getWxId() {
        return this.mWxId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String getInitStringJsonData() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            java.lang.String originalUrl = this.mWebview.getOriginalUrl();
            if (originalUrl.startsWith(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL)) {
                originalUrl = originalUrl.substring(7);
            }
            jSONObject.put("Plus_InitURL", this.mWebview.obtainApp().convert2RelPath(originalUrl));
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override // io.dcloud.feature.weex.WXBaseWrapper, io.dcloud.common.DHInterface.IUniNView
    public java.lang.String evalJs(java.lang.String str, int i) {
        if (this.mWXSDKInstance != null) {
            return com.taobao.weex.bridge.WXBridgeManager.getInstance().syncExecJsOnInstanceWithResult(this.mWXSDKInstance.getInstanceId(), str, i);
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(java.lang.Object obj, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str) {
        if (this.mWXSDKInstance != null) {
            recoveryInstance();
        }
        if (this.mWebview == null || this.mWebview.obtainFrameView() == null) {
            return;
        }
        if (this.isService && io.dcloud.common.util.BaseInfo.SyncDebug) {
            if (this.mServiceLogDetail == null) {
                com.taobao.weex.utils.tools.LogDetail logDetail = new com.taobao.weex.utils.tools.LogDetail();
                this.mServiceLogDetail = logDetail;
                logDetail.name("initV3Service");
            }
            this.mServiceLogDetail.taskStart();
        }
        this.isChlid = ((io.dcloud.common.adapter.ui.AdaFrameView) this.mWebview.obtainFrameView()).isChildOfFrameView;
        this.isReady = false;
        if (this.isPre) {
            if (io.dcloud.feature.weex.WeexInstanceMgr.self().getPreInstanceId() != null) {
                this.mWXSDKInstance = com.taobao.weex.WXSDKManager.getInstance().getSDKInstance(io.dcloud.feature.weex.WeexInstanceMgr.self().getPreInstanceId());
                if (this.mWXSDKInstance != null) {
                    this.mWXSDKInstance.init(this.mWebview.getContext());
                    onReady();
                    fireGlobalEvent("launchApp", new java.util.HashMap());
                }
            }
        } else {
            java.lang.String strReplaceFirst = (java.lang.String) obj;
            if (!com.taobao.weex.WXEnvironment.sRemoteDebugMode) {
                strReplaceFirst = strReplaceFirst.replaceFirst(java.util.regex.Pattern.quote("\"use weex:vue\""), java.util.regex.Matcher.quoteReplacement(""));
            }
            obj = strReplaceFirst + this.readyJs;
        }
        if (!this.isPre) {
            if (this.mWebview.getActivity() instanceof io.dcloud.common.DHInterface.IActivityHandler) {
                this.mWXSDKInstance = new io.dcloud.feature.uniapp.UniSDKInstance(this.mWebview.getContext(), ((io.dcloud.common.DHInterface.IActivityHandler) this.mWebview.getActivity()).getOriginalContext());
            } else {
                this.mWXSDKInstance = new io.dcloud.feature.uniapp.UniSDKInstance(this.mWebview.getContext());
            }
        }
        if (this.mFontSize > 0) {
            this.mWXSDKInstance.setDefaultFontSize(this.mFontSize);
        }
        this.mWXSDKInstance.setPageKeepRawCssStyles();
        this.mWXSDKInstance.setImmersive(this.mWebview.obtainApp().obtainStatusBarMgr().isImmersive);
        this.mWXAnaly = new io.dcloud.feature.weex.WXAnalyzerDelegate(this.mWebview.getContext());
        this.mWXSDKInstance.registerRenderListener(this);
        this.mWXSDKInstance.setBundleUrl(this.mSrcPath);
        this.mWXSDKInstance.setUniPagePath(this.isService ? "app-service.js" : this.mUniPagePath);
        this.mWXSDKInstance.setWXInstanceContainerOnSizeListener(this.mInstanceOnSizeListener);
        ((io.dcloud.feature.uniapp.UniSDKInstance) this.mWXSDKInstance).setCompilerWithUniapp(this.isCompilerWithUniapp);
        int frameType = this.mWebview.obtainFrameView().getFrameType();
        if ((this.isFrameShow || frameType == 2 || frameType == 4) && this.mWXSDKInstance != null) {
            this.mWXSDKInstance.onShowAnimationEnd();
        }
        if (!this.isPre) {
            this.mWXSDKInstance.render(this.mWxId, java.lang.String.valueOf(obj), map, str, com.taobao.weex.common.WXRenderStrategy.APPEND_ASYNC);
        }
        if (!this.isService && (this.mWebview instanceof io.dcloud.common.adapter.ui.AdaWebview)) {
            ((io.dcloud.common.adapter.ui.AdaWebview) this.mWebview).dispatchWebviewStateEvent(0, this.mPath);
        }
        initViewPortWidth(false);
        initFlexDirection();
        initTitleNView();
        if (this.isService) {
            io.dcloud.feature.weex.WeexInstanceMgr.self().setUniServiceCreated(true, this.mWebview.obtainApp());
        }
    }

    private void initTitleNView() {
        io.dcloud.common.adapter.ui.AdaFrameView adaFrameView = (io.dcloud.common.adapter.ui.AdaFrameView) this.mWebview.obtainFrameView();
        org.json.JSONObject jSONObject = adaFrameView.obtainFrameOptions().titleNView;
        if (jSONObject == null || adaFrameView.isChildOfFrameView || !jSONObject.has("type") || !"transparent".equals(jSONObject.optString("type"))) {
            return;
        }
        this.mWXSDKInstance.addOnInstanceVisibleListener(new com.taobao.weex.WXSDKInstance.OnInstanceVisibleListener() { // from class: io.dcloud.feature.weex.WXViewWrapper.4
            @Override // com.taobao.weex.WXSDKInstance.OnInstanceVisibleListener
            public void onDisappear() {
            }

            @Override // com.taobao.weex.WXSDKInstance.OnInstanceVisibleListener
            public void onAppear() {
                io.dcloud.feature.weex.WXViewWrapper.this.addScrollListener(this);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0062  */
    public void addScrollListener(com.taobao.weex.WXSDKInstance.OnInstanceVisibleListener onInstanceVisibleListener) {
        boolean z;
        if (this.mWXSDKInstance == null || this.mWXSDKInstance.getRootView() == null || this.hasScrollListener) {
            return;
        }
        this.hasScrollListener = true;
        final io.dcloud.common.adapter.ui.AdaFrameView adaFrameView = (io.dcloud.common.adapter.ui.AdaFrameView) this.mWebview.obtainFrameView();
        io.dcloud.common.adapter.util.ViewOptions viewOptionsObtainFrameOptions = adaFrameView.obtainFrameOptions();
        io.dcloud.common.adapter.util.ViewOptions viewOptionsObtainFrameOptions2 = adaFrameView.obtainWebviewParent().obtainFrameOptions();
        final org.json.JSONObject jSONObject = viewOptionsObtainFrameOptions.titleNView;
        if (jSONObject == null && viewOptionsObtainFrameOptions2.titleNView != null) {
            jSONObject = viewOptionsObtainFrameOptions2.titleNView;
        }
        if (jSONObject == null || !jSONObject.has("type")) {
            return;
        }
        io.dcloud.common.adapter.ui.AdaContainerFrameItem parentFrameItem = adaFrameView.getParentFrameItem();
        if (parentFrameItem instanceof io.dcloud.common.adapter.ui.AdaFrameView) {
            io.dcloud.common.adapter.ui.AdaFrameView adaFrameView2 = (io.dcloud.common.adapter.ui.AdaFrameView) parentFrameItem;
            z = adaFrameView2.obtainWebView() != null && "tab".equals(adaFrameView2.obtainWebView().obtainFrameId());
        }
        if (jSONObject != null) {
            if ((!adaFrameView.isChildOfFrameView || z) && jSONObject.has("type") && "transparent".equals(jSONObject.optString("type")) && this.mWXSDKInstance != null) {
                android.view.View rootView = this.mWXSDKInstance.getRootView();
                if (rootView != null && onInstanceVisibleListener != null) {
                    this.mWXSDKInstance.removeOnInstanceVisibleListener(onInstanceVisibleListener);
                }
                if (rootView instanceof io.dcloud.feature.weex_scroller.view.DCWXScrollView) {
                    ((io.dcloud.feature.weex_scroller.view.DCWXScrollView) rootView).addScrollViewListener(new io.dcloud.feature.weex_scroller.view.DCWXScrollView.WXScrollViewListener() { // from class: io.dcloud.feature.weex.WXViewWrapper.5
                        @Override // io.dcloud.feature.weex_scroller.view.DCWXScrollView.WXScrollViewListener
                        public void onScroll(io.dcloud.feature.weex_scroller.view.DCWXScrollView dCWXScrollView, int i, int i2) {
                        }

                        @Override // io.dcloud.feature.weex_scroller.view.DCWXScrollView.WXScrollViewListener
                        public void onScrollStopped(io.dcloud.feature.weex_scroller.view.DCWXScrollView dCWXScrollView, int i, int i2) {
                        }

                        @Override // io.dcloud.feature.weex_scroller.view.DCWXScrollView.WXScrollViewListener
                        public void onScrollToBottom(io.dcloud.feature.weex_scroller.view.DCWXScrollView dCWXScrollView, int i, int i2) {
                        }

                        @Override // io.dcloud.feature.weex_scroller.view.DCWXScrollView.WXScrollViewListener
                        public void onScrollToTop(io.dcloud.feature.weex_scroller.view.DCWXScrollView dCWXScrollView, int i, int i2) {
                        }

                        @Override // io.dcloud.feature.weex_scroller.view.DCWXScrollView.WXScrollViewListener
                        public void onScrollChanged(io.dcloud.feature.weex_scroller.view.DCWXScrollView dCWXScrollView, int i, int i2, int i3, int i4) {
                            io.dcloud.common.adapter.ui.AdaFrameView adaFrameView3 = adaFrameView;
                            if (adaFrameView3 == null || jSONObject == null) {
                                return;
                            }
                            int i5 = adaFrameView3.obtainFrameOptions().coverage;
                            if (i5 >= i4 || i5 >= i2) {
                                io.dcloud.common.DHInterface.AbsMgr absMgrObtainWindowMgr = adaFrameView.obtainWindowMgr();
                                io.dcloud.common.DHInterface.IWebview iWebviewObtainWebView = adaFrameView.obtainWebView();
                                io.dcloud.common.adapter.ui.AdaFrameView adaFrameView4 = adaFrameView;
                                java.lang.Object titleNView = io.dcloud.common.util.TitleNViewUtil.getTitleNView(absMgrObtainWindowMgr, iWebviewObtainWebView, adaFrameView4, io.dcloud.common.util.TitleNViewUtil.getTitleNViewId(adaFrameView4));
                                if (titleNView instanceof io.dcloud.common.DHInterface.ITitleNView) {
                                    io.dcloud.common.util.TitleNViewUtil.updateTitleNViewStatus((io.dcloud.common.DHInterface.ITitleNView) titleNView, adaFrameView.obtainWebView(), i2, jSONObject, i5);
                                }
                            }
                        }
                    });
                } else if (rootView instanceof com.taobao.weex.ui.view.WXScrollView) {
                    ((com.taobao.weex.ui.view.WXScrollView) rootView).addScrollViewListener(new com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener() { // from class: io.dcloud.feature.weex.WXViewWrapper.6
                        @Override // com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener
                        public void onScroll(com.taobao.weex.ui.view.WXScrollView wXScrollView, int i, int i2) {
                        }

                        @Override // com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener
                        public void onScrollStopped(com.taobao.weex.ui.view.WXScrollView wXScrollView, int i, int i2) {
                        }

                        @Override // com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener
                        public void onScrollToBottom(com.taobao.weex.ui.view.WXScrollView wXScrollView, int i, int i2) {
                        }

                        @Override // com.taobao.weex.ui.view.WXScrollView.WXScrollViewListener
                        public void onScrollChanged(com.taobao.weex.ui.view.WXScrollView wXScrollView, int i, int i2, int i3, int i4) {
                            io.dcloud.common.adapter.ui.AdaFrameView adaFrameView3 = adaFrameView;
                            if (adaFrameView3 == null || jSONObject == null) {
                                return;
                            }
                            int i5 = adaFrameView3.obtainFrameOptions().coverage;
                            if (i5 >= i4 || i5 >= i2) {
                                io.dcloud.common.DHInterface.AbsMgr absMgrObtainWindowMgr = adaFrameView.obtainWindowMgr();
                                io.dcloud.common.DHInterface.IWebview iWebviewObtainWebView = adaFrameView.obtainWebView();
                                io.dcloud.common.adapter.ui.AdaFrameView adaFrameView4 = adaFrameView;
                                java.lang.Object titleNView = io.dcloud.common.util.TitleNViewUtil.getTitleNView(absMgrObtainWindowMgr, iWebviewObtainWebView, adaFrameView4, io.dcloud.common.util.TitleNViewUtil.getTitleNViewId(adaFrameView4));
                                if (titleNView instanceof io.dcloud.common.DHInterface.ITitleNView) {
                                    io.dcloud.common.util.TitleNViewUtil.updateTitleNViewStatus((io.dcloud.common.DHInterface.ITitleNView) titleNView, adaFrameView.obtainWebView(), i2, jSONObject, i5);
                                }
                            }
                        }
                    });
                } else if (rootView instanceof com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) {
                    ((com.taobao.weex.ui.view.listview.WXRecyclerView) ((com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView) rootView).getInnerView()).addOnScrollListener(new androidx.recyclerview.widget.RecyclerView.OnScrollListener() { // from class: io.dcloud.feature.weex.WXViewWrapper.7
                        int oldx;
                        int oldy;

                        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                        public void onScrolled(androidx.recyclerview.widget.RecyclerView recyclerView, int i, int i2) {
                            int i3 = this.oldx;
                            int i4 = this.oldy;
                            this.oldx = i3 + i;
                            this.oldy = i2 + i4;
                            io.dcloud.common.adapter.ui.AdaFrameView adaFrameView3 = adaFrameView;
                            if (adaFrameView3 == null || jSONObject == null) {
                                return;
                            }
                            int i5 = adaFrameView3.obtainFrameOptions().coverage;
                            if (i5 >= i4 || i5 >= this.oldy) {
                                io.dcloud.common.DHInterface.AbsMgr absMgrObtainWindowMgr = adaFrameView.obtainWindowMgr();
                                io.dcloud.common.DHInterface.IWebview iWebviewObtainWebView = adaFrameView.obtainWebView();
                                io.dcloud.common.adapter.ui.AdaFrameView adaFrameView4 = adaFrameView;
                                java.lang.Object titleNView = io.dcloud.common.util.TitleNViewUtil.getTitleNView(absMgrObtainWindowMgr, iWebviewObtainWebView, adaFrameView4, io.dcloud.common.util.TitleNViewUtil.getTitleNViewId(adaFrameView4));
                                if (titleNView instanceof io.dcloud.common.DHInterface.ITitleNView) {
                                    io.dcloud.common.util.TitleNViewUtil.updateTitleNViewStatus((io.dcloud.common.DHInterface.ITitleNView) titleNView, adaFrameView.obtainWebView(), this.oldy, jSONObject, i5);
                                }
                            }
                        }
                    });
                }
            }
        }
    }

    @Override // io.dcloud.feature.weex.WXBaseWrapper
    protected void onRefresh() {
        if (this.mWebview != null) {
            ((io.dcloud.common.adapter.ui.AdaFrameView) this.mWebview.obtainFrameView()).dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENTS_PULL_DOWN_EVENT, 3);
            ((io.dcloud.common.adapter.ui.AdaFrameView) this.mWebview.obtainFrameView()).dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENTS_PULL_TO_REFRESH, 3);
        }
    }

    @Override // io.dcloud.feature.weex.WXBaseWrapper, io.dcloud.common.DHInterface.IUniNView
    public void loadTemplate(org.json.JSONObject jSONObject) {
        org.json.JSONObject jSONObjectOptJSONObject;
        try {
            this.jsonObject = jSONObject;
            this.mPath = jSONObject.optString("js");
            org.json.JSONObject jSONObject2 = this.jsonObject;
            if (jSONObject2 != null && jSONObject2.has("data") && (jSONObjectOptJSONObject = this.jsonObject.optJSONObject("data")) != null) {
                this.mFontSize = jSONObjectOptJSONObject.optInt("defaultFontSize");
                if (jSONObjectOptJSONObject.has("delayRender")) {
                    this.isDelayRender = jSONObjectOptJSONObject.optBoolean("delayRender", this.isDelayRender);
                }
                if (jSONObjectOptJSONObject.has(io.dcloud.common.constant.AbsoluteConst.XML_PATH)) {
                    this.mUniPagePath = jSONObjectOptJSONObject.optString(io.dcloud.common.constant.AbsoluteConst.XML_PATH, "") + ".nvue";
                }
            }
            if (io.dcloud.common.util.PdrUtil.isNetPath(this.mPath)) {
                return;
            }
            this.mSrcPath = initSrcPath(this.mPath);
            if (this.isPre) {
                render(null, getInitOptions(), getInitStringJsonData());
            } else {
                io.dcloud.common.util.ThreadPool.self().addThreadTask(new java.lang.Runnable() { // from class: io.dcloud.feature.weex.WXViewWrapper.8
                    @Override // java.lang.Runnable
                    public void run() {
                        java.io.InputStream encryptionInputStream;
                        if (io.dcloud.feature.weex.WXViewWrapper.this.mWebview == null || (encryptionInputStream = io.dcloud.common.adapter.ui.webview.WebResUtil.getEncryptionInputStream(io.dcloud.feature.weex.WXViewWrapper.this.mSrcPath, io.dcloud.feature.weex.WXViewWrapper.this.mWebview.obtainApp())) == null) {
                            return;
                        }
                        try {
                            java.lang.String str = new java.lang.String(io.dcloud.common.util.IOUtil.toString(encryptionInputStream));
                            if (io.dcloud.feature.weex.WXViewWrapper.this.isService) {
                                str = io.dcloud.feature.weex.WXViewWrapper.this.getAllUniService(str);
                            }
                            android.os.Message message = new android.os.Message();
                            message.obj = str;
                            message.what = 1000;
                            if (!io.dcloud.feature.weex.WXViewWrapper.this.isService && !io.dcloud.feature.weex.WeexInstanceMgr.self().isUniServiceCreated(io.dcloud.feature.weex.WXViewWrapper.this.mWebview.obtainApp())) {
                                if (!io.dcloud.feature.weex.WXViewWrapper.this.mWaitServiceRenderList.contains(message)) {
                                    io.dcloud.feature.weex.WXViewWrapper.this.mWaitServiceRenderList.add(message);
                                }
                            } else if (!io.dcloud.feature.weex.WeexInstanceMgr.self().isJsFrameworkReady()) {
                                if (!io.dcloud.feature.weex.WXViewWrapper.this.mRenderCaches.contains(message)) {
                                    io.dcloud.feature.weex.WXViewWrapper.this.mRenderCaches.add(message);
                                }
                            } else if (io.dcloud.feature.weex.WXViewWrapper.this.isDelayRender && !io.dcloud.feature.weex.WXViewWrapper.this.isService && !io.dcloud.feature.weex.WXViewWrapper.this.isFrameShow) {
                                if (!io.dcloud.feature.weex.WXViewWrapper.this.mRenderCaches.contains(message)) {
                                    io.dcloud.feature.weex.WXViewWrapper.this.mRenderCaches.add(message);
                                }
                            } else {
                                io.dcloud.feature.weex.WXViewWrapper.this.mHandler.sendMessage(message);
                            }
                        } catch (java.lang.Exception e) {
                            e.printStackTrace();
                        }
                        io.dcloud.common.util.IOUtil.close(encryptionInputStream);
                    }
                }, true);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // io.dcloud.feature.weex.WXBaseWrapper, io.dcloud.common.DHInterface.IUniNView
    public void titleNViewRefresh() {
        addScrollListener(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String getAllUniService(java.lang.String str) {
        if (this.mWebview == null || this.mWebview.obtainApp() == null) {
            return "";
        }
        io.dcloud.common.DHInterface.IApp iAppObtainApp = this.mWebview.obtainApp();
        java.lang.String strInitSrcPath = initSrcPath("_www/app-config.js");
        java.lang.String strInitSrcPath2 = initSrcPath("_www/app-confusion.js");
        java.lang.String dCloudUts = getDCloudUts();
        java.io.InputStream encryptionInputStream = io.dcloud.common.adapter.ui.webview.WebResUtil.getEncryptionInputStream(strInitSrcPath, iAppObtainApp);
        java.io.InputStream encryptionInputStream2 = io.dcloud.common.adapter.ui.webview.WebResUtil.getEncryptionInputStream(strInitSrcPath2, iAppObtainApp);
        try {
            return io.dcloud.common.util.IOUtil.toString(encryptionInputStream) + io.dcloud.common.util.IOUtil.toString(encryptionInputStream2) + dCloudUts + str;
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return str;
        }
    }

    private java.lang.String getDCloudUts() {
        java.io.InputStream resInputStream = io.dcloud.common.adapter.util.PlatformUtil.getResInputStream("data/dcloud_uts.dat");
        if (resInputStream != null) {
            try {
                return new java.lang.String(android.util.Base64.decode(io.dcloud.common.util.IOUtil.getBytes(resInputStream), 0));
            } catch (java.io.IOException e) {
                throw new java.lang.RuntimeException(e);
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delayedRender(final java.lang.Object obj, long j) {
        postDelayed(new java.lang.Runnable() { // from class: io.dcloud.feature.weex.WXViewWrapper.9
            @Override // java.lang.Runnable
            public void run() {
                if (io.dcloud.feature.weex.WXViewWrapper.this.mWebview == null) {
                    return;
                }
                io.dcloud.feature.weex.WXViewWrapper wXViewWrapper = io.dcloud.feature.weex.WXViewWrapper.this;
                wXViewWrapper.render(obj, wXViewWrapper.getInitOptions(), io.dcloud.feature.weex.WXViewWrapper.this.getInitStringJsonData());
            }
        }, j);
    }

    public java.lang.String initSrcPath(java.lang.String str) {
        if (this.mWebview == null) {
            return str;
        }
        int iIndexOf = str.indexOf(com.taobao.weex.el.parse.Operators.CONDITION_IF_STRING);
        java.lang.String strSubstring = iIndexOf > 1 ? str.substring(0, iIndexOf) : str;
        if (strSubstring.startsWith("/")) {
            strSubstring = strSubstring.substring(1);
        }
        java.lang.String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length == 1) {
            strSubstring = strSubstring + ".js";
        } else if (strArrSplit.length == 2) {
            strSubstring = strArrSplit[0] + ".js";
        }
        java.io.File file = new java.io.File(strSubstring);
        if (file.exists()) {
            return android.net.Uri.fromFile(file).toString();
        }
        byte bObtainRunningAppMode = this.mWebview.obtainApp().obtainRunningAppMode();
        java.lang.String strObtainFullUrl = !(this.mWebview instanceof io.dcloud.common.adapter.ui.AdaUniWebView) ? this.mWebview.obtainFullUrl() : null;
        if (!strSubstring.startsWith("/storage") && bObtainRunningAppMode == 1) {
            java.lang.String strConvert2AbsFullPath = this.mWebview.obtainApp().convert2AbsFullPath(strObtainFullUrl, strSubstring);
            return strConvert2AbsFullPath.startsWith("/") ? strConvert2AbsFullPath.substring(1, strConvert2AbsFullPath.length()) : strConvert2AbsFullPath;
        }
        return this.mWebview.obtainApp().convert2WebviewFullPath(strObtainFullUrl, strSubstring);
    }

    @Override // com.taobao.weex.IWXRenderListener
    public void onViewCreated(com.taobao.weex.WXSDKInstance wXSDKInstance, android.view.View view) {
        if (this.mWXAnaly != null) {
            this.mWXAnaly.onWeexViewCreated(wXSDKInstance, view);
        }
        this.mWXSDKView = view;
        addView(this.mWXSDKView, new android.widget.LinearLayout.LayoutParams(-1, -1));
        this.mWXSDKView.layout(0, 0, getWidth(), getHeight());
        if (isFocusableInTouchMode()) {
            this.mWXSDKView.setFocusable(true);
            this.mWXSDKView.setFocusableInTouchMode(true);
        }
        addScrollListener(null);
    }

    @Override // android.view.View
    public void setFocusable(int i) {
        super.setFocusable(i);
        android.view.View view = this.mWXSDKView;
        if (view != null) {
            view.setFocusable(i);
        }
    }

    @Override // android.view.View
    public void setFocusableInTouchMode(boolean z) {
        super.setFocusableInTouchMode(z);
        android.view.View view = this.mWXSDKView;
        if (view != null) {
            view.setFocusableInTouchMode(z);
        }
    }

    @Override // com.taobao.weex.IWXRenderListener
    public void onRenderSuccess(com.taobao.weex.WXSDKInstance wXSDKInstance, int i, int i2) {
        if (this.mWXAnaly != null) {
            this.mWXAnaly.onWeexRenderSuccess(wXSDKInstance);
        }
        if (this.isService || this.mWebview == null) {
            return;
        }
        if (this.mWebview instanceof io.dcloud.common.adapter.ui.AdaWebview) {
            ((io.dcloud.common.adapter.ui.AdaWebview) this.mWebview).dispatchWebviewStateEvent(1, this.mPath);
        }
        java.lang.String strObtainConfigProperty = this.mWebview.obtainApp().obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_AUTOCLOSE);
        if (io.dcloud.common.util.PdrUtil.isEmpty(strObtainConfigProperty)) {
            strObtainConfigProperty = io.dcloud.common.constant.AbsoluteConst.TRUE;
        }
        if (java.lang.Boolean.parseBoolean(strObtainConfigProperty)) {
            this.mWebview.obtainFrameView().obtainWindowMgr().processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 11, this.mWebview.obtainFrameView());
        }
    }

    @Override // com.taobao.weex.IWXRenderListener
    public void onException(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str, java.lang.String str2) {
        io.dcloud.common.adapter.util.Logger.e(this.TAG, "onException--errCode=" + str + "    msg=" + str2);
        if (this.mWXAnaly != null) {
            this.mWXAnaly.onException(wXSDKInstance, str, str2);
        }
    }

    @Override // io.dcloud.feature.weex.WXBaseWrapper, io.dcloud.common.DHInterface.IUniNView
    public void onDestroy() {
        super.onDestroy();
        io.dcloud.feature.weex.WeexInstanceMgr.self().unWXStatisticsCallBack(this);
        this.mWebview = null;
    }

    @Override // io.dcloud.feature.weex.WXBaseWrapper, io.dcloud.common.DHInterface.IUniNView
    public void reload() {
        if (this.time == 0 || java.lang.System.currentTimeMillis() - this.time >= 600) {
            this.time = java.lang.System.currentTimeMillis();
            recoveryInstance();
            this.isFrameShow = true;
            if (android.text.TextUtils.isEmpty(this.mPath)) {
                return;
            }
            loadTemplate(this.jsonObject);
        }
    }

    @Override // io.dcloud.feature.weex.WXBaseWrapper, io.dcloud.common.DHInterface.IUniNView
    public java.lang.String getType() {
        return com.taobao.weex.ui.component.WXBasicComponentType.VIEW;
    }

    @Override // io.dcloud.common.DHInterface.IEventCallback
    public java.lang.Object onCallBack(java.lang.String str, java.lang.Object obj) {
        if (io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.EVENTS_CLOSE) && (obj instanceof io.dcloud.common.DHInterface.IWebview)) {
            ((io.dcloud.common.adapter.ui.AdaFrameView) ((io.dcloud.common.DHInterface.IWebview) obj).obtainFrameView()).removeFrameViewListener(this);
            io.dcloud.feature.weex.WeexInstanceMgr.self().removeWeexView(this.mWxId);
            onDestroy();
            return null;
        }
        if ((!io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.EVENTS_SHOW_ANIMATION_END) && !io.dcloud.common.util.PdrUtil.isEquals(str, io.dcloud.common.constant.AbsoluteConst.EVENTS_CHILD_INITIALIZE_SHOW)) || this.isFrameShow) {
            return null;
        }
        this.isFrameShow = true;
        if (this.mWXSDKInstance != null) {
            this.mWXSDKInstance.onShowAnimationEnd();
        }
        if (!this.isDelayRender) {
            return null;
        }
        runDelayedRenderCaches(this.mRenderCaches);
        return null;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(android.content.res.Configuration configuration) {
        java.lang.String str;
        int i;
        super.onConfigurationChanged(configuration);
        if (this.mWXSDKInstance == null || this.mWebview.getActivity() == null) {
            return;
        }
        int rotation = this.mWebview.getActivity().getWindowManager().getDefaultDisplay().getRotation();
        if (rotation == 1) {
            str = "landscape";
            i = 90;
        } else if (rotation == 2) {
            str = "portraitReverse";
            i = 180;
        } else if (rotation != 3) {
            str = "portrait";
            i = 0;
        } else {
            str = "landscapeReverse";
            i = -90;
        }
        com.taobao.weex.utils.WXUtils.getCache().evictAll();
        java.util.HashMap map = new java.util.HashMap();
        map.put("value", str);
        map.put("orientation", java.lang.Integer.valueOf(i));
        this.mWXSDKInstance.fireGlobalEventCallback("orientationchange", map);
        if (this.isCompilerWithUniapp) {
            this.mWXSDKInstance.setInstanceViewPortWidth(this.mWebview.obtainApp().getInt(0) / this.mWebview.getScale(), true);
        }
    }

    private void updateInitDeviceParams(android.content.Context context) {
        com.taobao.weex.bridge.WXParams initParams = com.taobao.weex.bridge.WXBridgeManager.getInstance().getInitParams();
        if (initParams == null || android.text.TextUtils.equals(initParams.getDeviceWidth(), java.lang.String.valueOf(com.taobao.weex.utils.WXViewUtils.getScreenWidth(context)))) {
            return;
        }
        initParams.setDeviceWidth(java.lang.String.valueOf(com.taobao.weex.utils.WXViewUtils.getScreenWidth(context)));
        initParams.setDeviceHeight(java.lang.String.valueOf(com.taobao.weex.utils.WXViewUtils.getScreenHeight(context)));
        float f = com.taobao.weex.WXEnvironment.sApplication.getResources().getDisplayMetrics().density;
        com.taobao.weex.WXEnvironment.addCustomOptions("scale", java.lang.Float.toString(f));
        com.taobao.weex.bridge.WXBridgeManager.getInstance().updateInitDeviceParams(initParams.getDeviceWidth(), initParams.getDeviceHeight(), java.lang.Float.toString(f), com.taobao.weex.utils.WXViewUtils.getStatusBarHeight(context) > 0 ? java.lang.String.valueOf(com.taobao.weex.utils.WXViewUtils.getStatusBarHeight(context)) : null);
        com.taobao.weex.bridge.WXBridgeManager.getInstance().setDeviceDisplay(this.mWXSDKInstance.getInstanceId(), com.taobao.weex.utils.WXViewUtils.getScreenWidth(context), com.taobao.weex.utils.WXViewUtils.getScreenHeight(context), com.taobao.weex.utils.WXViewUtils.getScreenDensity(context));
    }

    @Override // io.dcloud.feature.weex.WXBaseWrapper, io.dcloud.common.DHInterface.IUniNView
    public synchronized boolean fireGlobalEvent(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
        if (this.isReady) {
            return super.fireGlobalEvent(str, map);
        }
        this.mFireCaches.add(new io.dcloud.feature.weex.WXViewWrapper.FireEvent(str, map));
        return true;
    }

    @Override // io.dcloud.feature.weex.WeexInstanceMgr.IWXStatisticsCallBack
    public void onJsFrameworkReady() {
        runDelayedRenderCaches(this.mRenderCaches);
        if (this.mWXSDKInstance != null) {
            initViewPortWidth(true);
            initFlexDirection();
        }
    }

    public void runDelayedRenderCaches(java.util.List<android.os.Message> list) {
        if (list.size() > 0) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mHandler.sendMessage(list.get(size));
            }
            list.clear();
        }
    }

    private void initViewPortWidth(boolean z) {
        if (!this.isCompilerWithUniapp || this.mWXSDKInstance == null) {
            return;
        }
        int screenWidth = this.mWebview.obtainApp().getInt(0);
        if (z) {
            screenWidth = com.taobao.weex.utils.WXViewUtils.getScreenWidth(getContext());
        }
        this.mViewPort = screenWidth / this.mWebview.getScale();
        this.mWXSDKInstance.setInstanceViewPortWidth(this.mViewPort, z);
    }

    private void initFlexDirection() {
        org.json.JSONObject jSONObject = this.mNvueCfgData;
        if (jSONObject == null || !jSONObject.has(io.dcloud.common.constant.AbsoluteConst.UNI_NVUE_FLEX_DIRECTION)) {
            return;
        }
        com.taobao.weex.bridge.WXBridgeManager.getInstance().setFlexDirectionDef(this.mNvueCfgData.optString(io.dcloud.common.constant.AbsoluteConst.UNI_NVUE_FLEX_DIRECTION));
    }

    class FireEvent {
        java.lang.String key;
        java.util.Map<java.lang.String, java.lang.Object> params;

        public FireEvent(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
            this.key = str;
            this.params = map;
        }
    }

    @Override // io.dcloud.feature.weex.WXBaseWrapper
    public void recoveryInstance() {
        android.view.View currentFocus;
        if (this.mWXSDKView != null) {
            if (!this.isChlid && (currentFocus = this.mWebview.getActivity().getCurrentFocus()) != null) {
                io.dcloud.common.adapter.util.DeviceInfo.hideIME(currentFocus);
            }
            this.mWXSDKView.clearFocus();
            clearFocus();
            removeView(this.mWXSDKView);
            this.mWXSDKView = null;
            this.isPre = false;
        }
        super.recoveryInstance();
        this.isFrameShow = false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.mWebview == null || !(this.mWebview instanceof io.dcloud.common.adapter.ui.AdaUniWebView)) {
            return;
        }
        try {
            ((io.dcloud.common.adapter.ui.AdaUniWebView) this.mWebview).updateScreenAndDisplay();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDeviceDisplay(float f, float f2, boolean z, boolean z2) {
        if (this.mWXSDKInstance == null || this.mWebview == null || this.mWebview.getActivity() == null) {
            return;
        }
        int i = this.mWebview.obtainApp().getInt(2);
        int i2 = this.mWebview.obtainApp().getInt(0);
        int i3 = this.mWebview.obtainApp().getInt(1);
        if (this.mWXSDKInstance.isOnSizeChangedRender()) {
            java.util.HashMap map = new java.util.HashMap();
            float scale = this.mWebview.getScale();
            map.put("resolutionHeight", java.lang.Integer.valueOf((int) (i / scale)));
            float f3 = i2;
            int i4 = (int) (f3 / scale);
            map.put("resolutionWidth", java.lang.Integer.valueOf(i4));
            map.put("dpiX", java.lang.Float.valueOf(io.dcloud.common.adapter.util.DeviceInfo.dpiX));
            map.put("dpiY", java.lang.Float.valueOf(io.dcloud.common.adapter.util.DeviceInfo.dpiY));
            java.util.HashMap map2 = new java.util.HashMap();
            map2.put("resolutionHeight", java.lang.Integer.valueOf((int) (i3 / scale)));
            map2.put("resolutionWidth", java.lang.Integer.valueOf(i4));
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (java.lang.String str : map.keySet()) {
                sb.append("plus.screen.");
                sb.append(str);
                sb.append("=");
                sb.append(map.get(str));
                sb.append(";");
            }
            for (java.lang.String str2 : map2.keySet()) {
                sb.append("plus.display.");
                sb.append(str2);
                sb.append("=");
                sb.append(map2.get(str2));
                sb.append(";");
            }
            this.mWebview.evalJS(sb.toString());
            if (this.isCompilerWithUniapp) {
                this.mWXSDKInstance.setInstanceViewPortWidth(f3 / this.mWebview.getScale(), true);
            }
            if (this.isService) {
                return;
            }
            this.mWXSDKInstance.setDeviceDisplayOfPage(i2, i3);
            this.mWXSDKInstance.reloadPageLayout();
            com.taobao.weex.bridge.WXBridgeManager.getInstance().setDefaultRootSize(this.mWXSDKInstance.getInstanceId(), f, f2, z, z2);
        }
    }
}
