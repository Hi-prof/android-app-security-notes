package com.taobao.weex.ui.component;

/* JADX INFO: loaded from: classes.dex */
@com.taobao.weex.annotation.Component(lazyload = false)
public class WXEmbed extends com.taobao.weex.ui.component.WXDiv implements com.taobao.weex.WXSDKInstance.OnInstanceVisibleListener, com.taobao.weex.ui.component.NestedContainer {
    public static final java.lang.String ITEM_ID = "itemId";
    public static final java.lang.String PRIORITY_HIGH = "high";
    public static final java.lang.String PRIORITY_LOW = "low";
    public static final java.lang.String PRIORITY_NORMAL = "normal";
    public static final java.lang.String STRATEGY_HIGH = "high";
    public static final java.lang.String STRATEGY_NONE = "none";
    public static final java.lang.String STRATEGY_NORMAL = "normal";
    private long hiddenTime;
    private com.taobao.weex.ui.component.WXEmbed.EmbedInstanceOnScrollFireEventInterceptor mInstanceOnScrollFireEventInterceptor;
    private boolean mIsVisible;
    private com.taobao.weex.ui.component.WXEmbed.EmbedRenderListener mListener;
    protected com.taobao.weex.WXSDKInstance mNestedInstance;
    private java.lang.String originUrl;
    private java.lang.String priority;
    private java.lang.String src;
    private java.lang.String strategy;
    private static int ERROR_IMG_WIDTH = (int) com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(270.0f, 750);
    private static int ERROR_IMG_HEIGHT = (int) com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(260.0f, 750);

    public interface EmbedManager {
        com.taobao.weex.ui.component.WXEmbed getEmbed(java.lang.String str);

        void putEmbed(java.lang.String str, com.taobao.weex.ui.component.WXEmbed wXEmbed);
    }

    public static class FailToH5Listener extends com.taobao.weex.ui.component.WXEmbed.ClickToReloadListener {
        @Override // com.taobao.weex.ui.component.WXEmbed.ClickToReloadListener, com.taobao.weex.ui.component.NestedContainer.OnNestedInstanceEventListener
        public void onException(com.taobao.weex.ui.component.NestedContainer nestedContainer, java.lang.String str, java.lang.String str2) {
            if (str != null && (nestedContainer instanceof com.taobao.weex.ui.component.WXEmbed) && str.startsWith("1|")) {
                android.view.ViewGroup viewContainer = nestedContainer.getViewContainer();
                android.webkit.WebView webView = new android.webkit.WebView(viewContainer.getContext());
                webView.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
                webView.getSettings().setAllowFileAccess(false);
                io.dcloud.common.adapter.ui.webview.WebViewFactory.setFileAccess(webView.getSettings(), true);
                io.dcloud.common.adapter.ui.webview.WebViewFactory.openJSEnabled(webView.getSettings(), null);
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                webView.removeJavascriptInterface("accessibility");
                webView.removeJavascriptInterface("accessibilityTraversal");
                webView.getSettings().setSavePassword(false);
                viewContainer.removeAllViews();
                viewContainer.addView(webView);
                webView.loadUrl(((com.taobao.weex.ui.component.WXEmbed) nestedContainer).src);
                return;
            }
            super.onException(nestedContainer, str, str2);
        }
    }

    public static class ClickToReloadListener implements com.taobao.weex.ui.component.NestedContainer.OnNestedInstanceEventListener {
        @Override // com.taobao.weex.ui.component.NestedContainer.OnNestedInstanceEventListener
        public void onCreated(com.taobao.weex.ui.component.NestedContainer nestedContainer, com.taobao.weex.WXSDKInstance wXSDKInstance) {
        }

        @Override // com.taobao.weex.ui.component.NestedContainer.OnNestedInstanceEventListener
        public boolean onPreCreate(com.taobao.weex.ui.component.NestedContainer nestedContainer, java.lang.String str) {
            return true;
        }

        @Override // com.taobao.weex.ui.component.NestedContainer.OnNestedInstanceEventListener
        public java.lang.String transformUrl(java.lang.String str) {
            return str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.taobao.weex.ui.component.NestedContainer.OnNestedInstanceEventListener
        public void onException(com.taobao.weex.ui.component.NestedContainer nestedContainer, java.lang.String str, java.lang.String str2) {
            if (android.text.TextUtils.equals(str, com.taobao.weex.common.WXErrorCode.WX_DEGRAD_ERR_NETWORK_BUNDLE_DOWNLOAD_FAILED.getErrorCode()) && (nestedContainer instanceof com.taobao.weex.ui.component.WXEmbed)) {
                final com.taobao.weex.ui.component.WXEmbed wXEmbed = (com.taobao.weex.ui.component.WXEmbed) nestedContainer;
                final android.widget.ImageView imageView = new android.widget.ImageView(wXEmbed.getContext());
                imageView.setImageResource(com.taobao.weex.R.drawable.weex_error);
                android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(com.taobao.weex.ui.component.WXEmbed.ERROR_IMG_WIDTH, com.taobao.weex.ui.component.WXEmbed.ERROR_IMG_HEIGHT);
                layoutParams.gravity = 17;
                imageView.setLayoutParams(layoutParams);
                imageView.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
                imageView.setAdjustViewBounds(true);
                imageView.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.taobao.weex.ui.component.WXEmbed.ClickToReloadListener.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(android.view.View view) {
                        imageView.setOnClickListener(null);
                        imageView.setEnabled(false);
                        wXEmbed.loadContent();
                    }
                });
                android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) wXEmbed.getHostView();
                frameLayout.removeAllViews();
                frameLayout.addView(imageView);
                com.taobao.weex.utils.WXLogUtils.e("WXEmbed", "NetWork failure :" + str + ",\n error message :" + str2);
            }
        }
    }

    static class EmbedRenderListener implements com.taobao.weex.IWXRenderListener {
        com.taobao.weex.ui.component.WXEmbed mComponent;
        com.taobao.weex.ui.component.NestedContainer.OnNestedInstanceEventListener mEventListener = new com.taobao.weex.ui.component.WXEmbed.ClickToReloadListener();

        @Override // com.taobao.weex.IWXRenderListener
        public void onRefreshSuccess(com.taobao.weex.WXSDKInstance wXSDKInstance, int i, int i2) {
        }

        @Override // com.taobao.weex.IWXRenderListener
        public void onRenderSuccess(com.taobao.weex.WXSDKInstance wXSDKInstance, int i, int i2) {
        }

        EmbedRenderListener(com.taobao.weex.ui.component.WXEmbed wXEmbed) {
            this.mComponent = wXEmbed;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.taobao.weex.IWXRenderListener
        public void onViewCreated(com.taobao.weex.WXSDKInstance wXSDKInstance, android.view.View view) {
            android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) this.mComponent.getHostView();
            frameLayout.removeAllViews();
            frameLayout.addView(view);
        }

        @Override // com.taobao.weex.IWXRenderListener
        public void onException(com.taobao.weex.WXSDKInstance wXSDKInstance, java.lang.String str, java.lang.String str2) {
            com.taobao.weex.ui.component.NestedContainer.OnNestedInstanceEventListener onNestedInstanceEventListener = this.mEventListener;
            if (onNestedInstanceEventListener != null) {
                onNestedInstanceEventListener.onException(this.mComponent, str, str2);
            }
        }
    }

    @java.lang.Deprecated
    public WXEmbed(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, java.lang.String str, boolean z, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, basicComponentData);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WXEmbed(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) {
        java.lang.Object obj;
        super(wXSDKInstance, wXVContainer, basicComponentData);
        this.mIsVisible = true;
        this.priority = "normal";
        this.strategy = "normal";
        this.mListener = new com.taobao.weex.ui.component.WXEmbed.EmbedRenderListener(this);
        this.mInstanceOnScrollFireEventInterceptor = new com.taobao.weex.ui.component.WXEmbed.EmbedInstanceOnScrollFireEventInterceptor(this);
        ERROR_IMG_WIDTH = (int) com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(270.0f, wXSDKInstance.getInstanceViewPortWidthWithFloat());
        ERROR_IMG_HEIGHT = (int) com.taobao.weex.utils.WXViewUtils.getRealPxByWidth(260.0f, wXSDKInstance.getInstanceViewPortWidthWithFloat());
        if ((wXSDKInstance instanceof com.taobao.weex.ui.component.WXEmbed.EmbedManager) && (obj = getAttrs().get(ITEM_ID)) != null) {
            ((com.taobao.weex.ui.component.WXEmbed.EmbedManager) wXSDKInstance).putEmbed(obj.toString(), this);
        }
        this.priority = com.taobao.weex.utils.WXUtils.getString(getAttrs().get("priority"), "normal");
        this.strategy = com.taobao.weex.utils.WXUtils.getString(getAttrs().get(com.taobao.weex.common.Constants.Name.STRATEGY), "none");
        wXSDKInstance.getApmForInstance().updateDiffStats(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_STATS_EMBED_COUNT, 1.0d);
    }

    @Override // com.taobao.weex.ui.component.NestedContainer
    public void setOnNestEventListener(com.taobao.weex.ui.component.NestedContainer.OnNestedInstanceEventListener onNestedInstanceEventListener) {
        this.mListener.mEventListener = onNestedInstanceEventListener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.taobao.weex.ui.component.NestedContainer
    public android.view.ViewGroup getViewContainer() {
        return (android.view.ViewGroup) getHostView();
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected boolean setProperty(java.lang.String str, java.lang.Object obj) {
        str.hashCode();
        if (str.equals("priority")) {
            java.lang.String string = com.taobao.weex.utils.WXUtils.getString(obj, null);
            if (string != null) {
                setPriority(string);
            }
            return true;
        }
        if (str.equals("src")) {
            java.lang.String string2 = com.taobao.weex.utils.WXUtils.getString(obj, null);
            if (string2 != null) {
                setSrc(string2);
            }
            return true;
        }
        return super.setProperty(str, obj);
    }

    @Override // com.taobao.weex.ui.component.NestedContainer
    public void renderNewURL(java.lang.String str) {
        this.src = str;
        loadContent();
    }

    @Override // com.taobao.weex.ui.component.NestedContainer
    public void reload() {
        if (android.text.TextUtils.isEmpty(this.src)) {
            return;
        }
        loadContent();
    }

    public java.lang.String getOriginUrl() {
        return this.originUrl;
    }

    public void setOriginUrl(java.lang.String str) {
        this.originUrl = str;
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void addEvent(java.lang.String str) {
        super.addEvent(str);
        if (com.taobao.weex.common.Constants.Event.SCROLL_START.equals(str)) {
            this.mInstanceOnScrollFireEventInterceptor.addInterceptEvent(str);
        } else if (com.taobao.weex.common.Constants.Event.SCROLL_END.equals(str)) {
            this.mInstanceOnScrollFireEventInterceptor.addInterceptEvent(str);
        } else if ("scroll".equals(str)) {
            this.mInstanceOnScrollFireEventInterceptor.addInterceptEvent(str);
        }
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = "src")
    public void setSrc(java.lang.String str) {
        this.originUrl = str;
        this.src = str;
        com.taobao.weex.WXSDKInstance wXSDKInstance = this.mNestedInstance;
        if (wXSDKInstance != null) {
            wXSDKInstance.destroy();
            this.mNestedInstance = null;
        }
        if (!this.mIsVisible || android.text.TextUtils.isEmpty(this.src)) {
            return;
        }
        loadContent();
    }

    public java.lang.String getSrc() {
        return this.src;
    }

    @com.taobao.weex.ui.component.WXComponentProp(name = "priority")
    public void setPriority(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.priority = str;
    }

    protected void loadContent() {
        com.taobao.weex.WXSDKInstance wXSDKInstance = this.mNestedInstance;
        if (wXSDKInstance != null) {
            wXSDKInstance.destroy();
        }
        this.mNestedInstance = createInstance();
        com.taobao.weex.ui.component.WXEmbed.EmbedRenderListener embedRenderListener = this.mListener;
        if (embedRenderListener == null || embedRenderListener.mEventListener == null || this.mListener.mEventListener.onPreCreate(this, this.src)) {
            return;
        }
        this.mListener.mEventListener.onCreated(this, this.mNestedInstance);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getLevel(com.taobao.weex.ui.component.WXEmbed wXEmbed) {
        java.lang.String str = wXEmbed.priority;
        if ("high".equals(wXEmbed.strategy)) {
            return 5;
        }
        if (android.text.TextUtils.equals(str, "low")) {
            return 0;
        }
        return android.text.TextUtils.equals(str, "high") ? 10 : 5;
    }

    private com.taobao.weex.WXSDKInstance createInstance() {
        com.taobao.weex.WXSDKInstance wXSDKInstanceCreateNestedInstance = getInstance().createNestedInstance(this);
        wXSDKInstanceCreateNestedInstance.setParentInstance(getInstance());
        if (!getAttrs().containsKey("disableInstanceVisibleListener")) {
            getInstance().addOnInstanceVisibleListener(this);
        }
        wXSDKInstanceCreateNestedInstance.registerRenderListener(this.mListener);
        this.mInstanceOnScrollFireEventInterceptor.resetFirstLaterScroller();
        wXSDKInstanceCreateNestedInstance.addInstanceOnFireEventInterceptor(this.mInstanceOnScrollFireEventInterceptor);
        wXSDKInstanceCreateNestedInstance.registerOnWXScrollListener(this.mInstanceOnScrollFireEventInterceptor);
        java.lang.String strTransformUrl = this.src;
        com.taobao.weex.ui.component.WXEmbed.EmbedRenderListener embedRenderListener = this.mListener;
        if (embedRenderListener != null && embedRenderListener.mEventListener != null) {
            strTransformUrl = this.mListener.mEventListener.transformUrl(this.src);
            if (!this.mListener.mEventListener.onPreCreate(this, this.src)) {
                return null;
            }
        }
        java.lang.String str = strTransformUrl;
        if (android.text.TextUtils.isEmpty(str)) {
            this.mListener.mEventListener.onException(this, com.taobao.weex.common.WXErrorCode.WX_DEGRAD_ERR_BUNDLE_CONTENTTYPE_ERROR.getErrorCode(), com.taobao.weex.common.WXErrorCode.WX_DEGRAD_ERR_BUNDLE_CONTENTTYPE_ERROR.getErrorMsg() + "!!wx embed src url is null");
            return wXSDKInstanceCreateNestedInstance;
        }
        wXSDKInstanceCreateNestedInstance.setContainerInfo(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_PROPERTIES_INSTANCE_TYPE, com.taobao.weex.ui.component.WXBasicComponentType.EMBED);
        wXSDKInstanceCreateNestedInstance.setContainerInfo(com.taobao.weex.performance.WXInstanceApm.KEY_PAGE_PROPERTIES_PARENT_PAGE, getInstance().getWXPerformance().pageName);
        wXSDKInstanceCreateNestedInstance.renderByUrl(str, str, null, null, com.taobao.weex.common.WXRenderStrategy.APPEND_ASYNC);
        return wXSDKInstanceCreateNestedInstance;
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void setVisibility(java.lang.String str) {
        com.taobao.weex.WXSDKInstance wXSDKInstance;
        super.setVisibility(str);
        boolean zEquals = android.text.TextUtils.equals(str, "visible");
        if (this.mIsVisible != zEquals) {
            if (!android.text.TextUtils.isEmpty(this.src) && zEquals) {
                com.taobao.weex.WXSDKInstance wXSDKInstance2 = this.mNestedInstance;
                if (wXSDKInstance2 == null) {
                    loadContent();
                } else {
                    wXSDKInstance2.onViewAppear();
                }
            }
            if (!zEquals && (wXSDKInstance = this.mNestedInstance) != null) {
                wXSDKInstance.onViewDisappear();
            }
            this.mIsVisible = zEquals;
            doAutoEmbedMemoryStrategy();
        }
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer, com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        super.destroy();
        destoryNestInstance();
        this.src = null;
        if (getInstance() != null) {
            getInstance().removeOnInstanceVisibleListener(this);
        }
    }

    private void doAutoEmbedMemoryStrategy() {
        if ("none".equals(this.strategy)) {
            return;
        }
        if (!this.mIsVisible && this.mNestedInstance != null) {
            if ("low".equals(this.priority)) {
                destoryNestInstance();
            } else {
                if (getInstance().hiddenEmbeds == null) {
                    getInstance().hiddenEmbeds = new java.util.PriorityQueue<>(8, new java.util.Comparator<com.taobao.weex.ui.component.WXEmbed>() { // from class: com.taobao.weex.ui.component.WXEmbed.1
                        @Override // java.util.Comparator
                        public int compare(com.taobao.weex.ui.component.WXEmbed wXEmbed, com.taobao.weex.ui.component.WXEmbed wXEmbed2) {
                            int level = com.taobao.weex.ui.component.WXEmbed.getLevel(wXEmbed) - com.taobao.weex.ui.component.WXEmbed.getLevel(wXEmbed2);
                            return level != 0 ? level : (int) (wXEmbed.hiddenTime - wXEmbed2.hiddenTime);
                        }
                    });
                }
                if (!getInstance().hiddenEmbeds.contains(this)) {
                    this.hiddenTime = java.lang.System.currentTimeMillis();
                    getInstance().hiddenEmbeds.add(this);
                }
                if (getInstance().hiddenEmbeds != null && getInstance().getMaxHiddenEmbedsNum() >= 0) {
                    while (getInstance().hiddenEmbeds.size() > getInstance().getMaxHiddenEmbedsNum()) {
                        com.taobao.weex.ui.component.WXEmbed wXEmbedPoll = getInstance().hiddenEmbeds.poll();
                        if (!wXEmbedPoll.mIsVisible && wXEmbedPoll != null) {
                            wXEmbedPoll.destoryNestInstance();
                        }
                    }
                }
            }
        }
        if (!this.mIsVisible || this.mNestedInstance == null || getInstance().hiddenEmbeds == null || !getInstance().hiddenEmbeds.contains(this)) {
            return;
        }
        getInstance().hiddenEmbeds.remove(this);
    }

    @Override // com.taobao.weex.WXSDKInstance.OnInstanceVisibleListener
    public void onAppear() {
        com.taobao.weex.WXSDKInstance wXSDKInstance;
        com.taobao.weex.ui.component.WXComponent rootComponent;
        if (!this.mIsVisible || (wXSDKInstance = this.mNestedInstance) == null || (rootComponent = wXSDKInstance.getRootComponent()) == null) {
            return;
        }
        rootComponent.fireEvent(com.taobao.weex.common.Constants.Event.VIEWAPPEAR);
    }

    @Override // com.taobao.weex.WXSDKInstance.OnInstanceVisibleListener
    public void onDisappear() {
        com.taobao.weex.WXSDKInstance wXSDKInstance;
        com.taobao.weex.ui.component.WXComponent rootComponent;
        if (!this.mIsVisible || (wXSDKInstance = this.mNestedInstance) == null || (rootComponent = wXSDKInstance.getRootComponent()) == null) {
            return;
        }
        rootComponent.fireEvent(com.taobao.weex.common.Constants.Event.VIEWDISAPPEAR);
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer, com.taobao.weex.ui.component.WXComponent, com.taobao.weex.IWXActivityStateListener
    public void onActivityStart() {
        super.onActivityStart();
        com.taobao.weex.WXSDKInstance wXSDKInstance = this.mNestedInstance;
        if (wXSDKInstance != null) {
            wXSDKInstance.onActivityStart();
        }
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer, com.taobao.weex.ui.component.WXComponent, com.taobao.weex.IWXActivityStateListener
    public void onActivityResume() {
        super.onActivityResume();
        com.taobao.weex.WXSDKInstance wXSDKInstance = this.mNestedInstance;
        if (wXSDKInstance != null) {
            wXSDKInstance.onActivityResume();
        }
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer, com.taobao.weex.ui.component.WXComponent, com.taobao.weex.IWXActivityStateListener
    public void onActivityPause() {
        super.onActivityPause();
        com.taobao.weex.WXSDKInstance wXSDKInstance = this.mNestedInstance;
        if (wXSDKInstance != null) {
            wXSDKInstance.onActivityPause();
        }
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer, com.taobao.weex.ui.component.WXComponent, com.taobao.weex.IWXActivityStateListener
    public void onActivityStop() {
        super.onActivityStop();
        com.taobao.weex.WXSDKInstance wXSDKInstance = this.mNestedInstance;
        if (wXSDKInstance != null) {
            wXSDKInstance.onActivityStop();
        }
    }

    @Override // io.dcloud.feature.uniapp.ui.component.AbsVContainer, com.taobao.weex.ui.component.WXComponent, com.taobao.weex.IWXActivityStateListener
    public void onActivityDestroy() {
        super.onActivityDestroy();
        com.taobao.weex.WXSDKInstance wXSDKInstance = this.mNestedInstance;
        if (wXSDKInstance != null) {
            wXSDKInstance.onActivityDestroy();
        }
    }

    public void setStrategy(java.lang.String str) {
        this.strategy = str;
    }

    private void destoryNestInstance() {
        if (getInstance().hiddenEmbeds != null && getInstance().hiddenEmbeds.contains(this)) {
            getInstance().hiddenEmbeds.remove(this);
        }
        com.taobao.weex.WXSDKInstance wXSDKInstance = this.mNestedInstance;
        if (wXSDKInstance != null) {
            wXSDKInstance.destroy();
            this.mNestedInstance = null;
        }
        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("WXEmbed destoryNestInstance priority ");
            sb.append(this.priority);
            sb.append(" index ");
            sb.append(getAttrs().get("index"));
            sb.append("  ");
            sb.append(this.hiddenTime);
            sb.append(" embeds size ");
            sb.append(getInstance().hiddenEmbeds == null ? 0 : getInstance().hiddenEmbeds.size());
            sb.append(" strategy ");
            sb.append(this.strategy);
            com.taobao.weex.utils.WXLogUtils.w(sb.toString());
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void addLayerOverFlowListener(java.lang.String str) {
        com.taobao.weex.WXSDKInstance wXSDKInstance = this.mNestedInstance;
        if (wXSDKInstance != null) {
            wXSDKInstance.addLayerOverFlowListener(getRef());
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void removeLayerOverFlowListener(java.lang.String str) {
        com.taobao.weex.WXSDKInstance wXSDKInstance = this.mNestedInstance;
        if (wXSDKInstance != null) {
            wXSDKInstance.removeLayerOverFlowListener(str);
        }
    }

    static class EmbedInstanceOnScrollFireEventInterceptor extends com.taobao.weex.instance.InstanceOnFireEventInterceptor implements com.taobao.weex.common.OnWXScrollListener {
        private com.taobao.weex.ui.component.WXComponent firstLayerScroller;
        private com.taobao.weex.ui.component.WXEmbed mEmbed;

        @Override // com.taobao.weex.common.OnWXScrollListener
        public void onScrollStateChanged(android.view.View view, int i, int i2, int i3) {
        }

        public EmbedInstanceOnScrollFireEventInterceptor(com.taobao.weex.ui.component.WXEmbed wXEmbed) {
            this.mEmbed = wXEmbed;
        }

        public void resetFirstLaterScroller() {
            this.firstLayerScroller = null;
        }

        @Override // com.taobao.weex.instance.InstanceOnFireEventInterceptor
        public void onFireEvent(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.Object> map, java.util.Map<java.lang.String, java.lang.Object> map2) {
            com.taobao.weex.ui.component.WXEmbed wXEmbed = this.mEmbed;
            if (wXEmbed == null || wXEmbed.mNestedInstance == null || !this.mEmbed.mNestedInstance.getInstanceId().equals(str)) {
                return;
            }
            if (this.firstLayerScroller == null) {
                initFirstLayerScroller();
            }
            com.taobao.weex.ui.component.WXComponent wXComponent = this.firstLayerScroller;
            if (wXComponent != null && wXComponent.getRef().equals(str2)) {
                this.mEmbed.getInstance().fireEvent(this.mEmbed.getRef(), str3, map, map2);
            }
        }

        private void initFirstLayerScroller() {
            if (this.firstLayerScroller == null) {
                com.taobao.weex.ui.component.WXComponent wXComponentFindFirstLayerScroller = findFirstLayerScroller();
                this.firstLayerScroller = wXComponentFindFirstLayerScroller;
                if (wXComponentFindFirstLayerScroller != null) {
                    for (java.lang.String str : getListenEvents()) {
                        if (!this.firstLayerScroller.containsEvent(str)) {
                            this.firstLayerScroller.getEvents().add(str);
                            this.firstLayerScroller.addEvent(str);
                        }
                    }
                }
            }
        }

        private com.taobao.weex.ui.component.WXComponent findFirstLayerScroller() {
            com.taobao.weex.ui.component.WXComponent wXComponent;
            if (this.mEmbed.mNestedInstance == null) {
                return null;
            }
            com.taobao.weex.ui.component.WXComponent rootComponent = this.mEmbed.mNestedInstance.getRootComponent();
            if (rootComponent instanceof com.taobao.weex.ui.component.Scrollable) {
                return rootComponent;
            }
            java.util.ArrayDeque arrayDeque = new java.util.ArrayDeque();
            arrayDeque.offer(rootComponent);
            while (!arrayDeque.isEmpty() && (wXComponent = (com.taobao.weex.ui.component.WXComponent) arrayDeque.poll()) != null) {
                if (wXComponent instanceof com.taobao.weex.ui.component.Scrollable) {
                    return wXComponent;
                }
                if (wXComponent instanceof com.taobao.weex.ui.component.WXVContainer) {
                    com.taobao.weex.ui.component.WXVContainer wXVContainer = (com.taobao.weex.ui.component.WXVContainer) wXComponent;
                    for (int i = 0; i < wXVContainer.getChildCount(); i++) {
                        arrayDeque.offer(wXVContainer.getChild(i));
                    }
                }
            }
            return null;
        }

        @Override // com.taobao.weex.common.OnWXScrollListener
        public void onScrolled(android.view.View view, int i, int i2) {
            if (this.firstLayerScroller == null && getListenEvents().size() > 0) {
                initFirstLayerScroller();
            }
        }
    }
}
