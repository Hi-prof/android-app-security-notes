package io.dcloud.common.core.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class TabBarWebview extends io.dcloud.common.adapter.ui.AdaWebview {
    private boolean isVisible;
    private io.dcloud.common.DHInterface.IApp mApp;
    private com.alibaba.fastjson.JSONArray mChildJson;
    private java.util.ArrayList<java.lang.String> mPagePaths;
    android.view.ViewGroup mRoot;
    float mScale;
    private int mSelectIndex;
    private com.dcloud.android.widget.TabView mTabBar;
    private com.alibaba.fastjson.JSONObject mTabBarJson;
    private java.util.ArrayList<io.dcloud.common.core.ui.b> mTabItems;
    private android.widget.FrameLayout mTabLayout;
    private io.dcloud.common.core.ui.l mWindowMgr;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements java.lang.Runnable {
        final /* synthetic */ io.dcloud.common.core.ui.b a;

        a(io.dcloud.common.core.ui.b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.resize();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b implements android.view.animation.Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(android.view.animation.Animation animation) {
            io.dcloud.common.core.ui.TabBarWebview.this.mTabBar.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(android.view.animation.Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(android.view.animation.Animation animation) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class c implements java.lang.Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            io.dcloud.common.core.ui.TabBarWebview.this.mTabBar.setVisibility(8);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class d implements android.view.animation.Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(android.view.animation.Animation animation) {
            io.dcloud.common.core.ui.TabBarWebview tabBarWebview = io.dcloud.common.core.ui.TabBarWebview.this;
            tabBarWebview.setTabItemsBottomMargin(tabBarWebview.mTabBar.getTabHeight());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(android.view.animation.Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(android.view.animation.Animation animation) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class e implements java.lang.Runnable {
        final /* synthetic */ io.dcloud.common.core.ui.b a;

        e(io.dcloud.common.core.ui.b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) this.a.obtainWebviewParent().obtainMainView();
            if (viewGroup != null && viewGroup.getHeight() != this.a.obtainMainView().getHeight()) {
                io.dcloud.common.adapter.ui.AdaFrameItem.LayoutParamsUtil.setViewLayoutParams(viewGroup, 0, 0, -1, -1);
            }
            this.a.resize();
        }
    }

    public TabBarWebview(android.content.Context context, io.dcloud.common.DHInterface.IApp iApp, io.dcloud.common.core.ui.l lVar, io.dcloud.common.core.ui.c cVar, org.json.JSONObject jSONObject) {
        super(context);
        this.mScale = 3.0f;
        this.mSelectIndex = 0;
        this.mFrameView = cVar;
        this.mWindowMgr = lVar;
        this.mTabItems = new java.util.ArrayList<>();
        this.mPagePaths = new java.util.ArrayList<>();
        initWebviewUUID("TabBar");
        initPagePaths(com.alibaba.fastjson.JSON.parseObject(jSONObject.toString()));
        this.mScale = context.getResources().getDisplayMetrics().density;
        this.mApp = iApp;
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(jSONObject.toString());
        this.mTabBarJson = object;
        this.mChildJson = object.getJSONArray("child");
        this.mTabLayout = new android.widget.FrameLayout(context);
        if (this.mTabBarJson.containsKey("selected")) {
            java.lang.String string = this.mTabBarJson.getString("selected");
            if (!android.text.TextUtils.isEmpty(string)) {
                this.mSelectIndex = java.lang.Integer.valueOf(string).intValue();
            }
        }
        this.mRoot = (android.widget.FrameLayout) cVar.obtainMainView();
        com.dcloud.android.widget.TabView tabView = new com.dcloud.android.widget.TabView(context, this.mRoot, this.mTabBarJson, this.mScale, iApp);
        this.mTabBar = tabView;
        setMainView(tabView);
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        layoutParams.bottomMargin = this.mTabBar.getTabHeight();
        this.mRoot.addView(this.mTabLayout, layoutParams);
        io.dcloud.common.core.ui.TabBarWebviewMgr.getInstance().setLancheTabBar(this);
        this.isVisible = true;
        cVar.addFrameItem(this, new android.view.ViewGroup.LayoutParams(-1, -1));
    }

    private void initPagePaths(com.alibaba.fastjson.JSONObject jSONObject) {
        if (jSONObject.containsKey(com.taobao.weex.ui.component.WXBasicComponentType.LIST)) {
            com.alibaba.fastjson.JSONArray jSONArray = jSONObject.getJSONArray(com.taobao.weex.ui.component.WXBasicComponentType.LIST);
            for (int i = 0; i < jSONArray.size(); i++) {
                java.lang.String string = jSONArray.getJSONObject(i).getString("pagePath");
                if (!android.text.TextUtils.isEmpty(string)) {
                    if (string.startsWith("/")) {
                        string = string.substring(1);
                    }
                    this.mPagePaths.add(string);
                }
            }
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void append(java.lang.String str, io.dcloud.common.DHInterface.ICallBack iCallBack) {
        io.dcloud.common.core.ui.l lVar;
        if (android.text.TextUtils.isEmpty(str) || (lVar = this.mWindowMgr) == null) {
            iCallBack.onCallBack(-1, null);
            return;
        }
        io.dcloud.common.DHInterface.IMgr.MgrType mgrType = io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr;
        io.dcloud.common.DHInterface.IApp iApp = this.mApp;
        java.lang.Object objProcessEvent = lVar.processEvent(mgrType, 10, new java.lang.Object[]{iApp, io.dcloud.common.constant.AbsoluteConst.F_UI, "findWebview", new java.lang.String[]{iApp.obtainAppId(), str}});
        if (objProcessEvent == null || !(objProcessEvent instanceof io.dcloud.common.DHInterface.IWebview)) {
            iCallBack.onCallBack(-1, null);
            return;
        }
        io.dcloud.common.DHInterface.IFrameView iFrameViewObtainFrameView = ((io.dcloud.common.DHInterface.IWebview) objProcessEvent).obtainFrameView();
        if (iFrameViewObtainFrameView instanceof io.dcloud.common.core.ui.b) {
            append((io.dcloud.common.core.ui.b) iFrameViewObtainFrameView);
            iCallBack.onCallBack(0, null);
        }
    }

    public boolean checkPagePathIsTab(java.lang.String str) {
        java.util.ArrayList<java.lang.String> arrayList = this.mPagePaths;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            java.lang.String str2 = arrayList.get(i);
            i++;
            if (str2.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public boolean checkUrlToReload(java.lang.String str) {
        try {
            java.util.ArrayList<io.dcloud.common.core.ui.b> arrayList = this.mTabItems;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                io.dcloud.common.core.ui.b bVar = arrayList.get(i);
                i++;
                io.dcloud.common.core.ui.b bVar2 = bVar;
                if (str.endsWith(".js")) {
                    bVar2.mWindowMgr.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 10, new java.lang.Object[]{bVar2.obtainApp(), "weex,io.dcloud.feature.weex.WeexFeature", "updateReload", new java.lang.Object[]{str}});
                    return true;
                }
                if (bVar2.obtainWebView().obtainUrl().startsWith(str)) {
                    bVar2.obtainWebView().reload();
                    return true;
                }
            }
        } catch (java.lang.Exception unused) {
        }
        return false;
    }

    @Override // io.dcloud.common.adapter.ui.AdaWebview, io.dcloud.common.adapter.ui.AdaContainerFrameItem, io.dcloud.common.adapter.ui.AdaFrameItem
    public void dispose() {
        super.dispose();
        com.dcloud.android.widget.TabView tabView = this.mTabBar;
        if (tabView != null) {
            tabView.dispose();
        }
        this.mTabItems.clear();
        java.util.ArrayList<java.lang.String> arrayList = this.mPagePaths;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    @Override // io.dcloud.common.adapter.ui.AdaWebview, io.dcloud.common.DHInterface.IWebview
    public void evalJS(java.lang.String str) {
    }

    @Override // io.dcloud.common.adapter.ui.AdaWebview, io.dcloud.common.DHInterface.IWebview
    public void evalJS(java.lang.String str, io.dcloud.common.adapter.ui.ReceiveJSValue.ReceiveJSValueCallback receiveJSValueCallback) {
    }

    @Override // io.dcloud.common.adapter.ui.AdaWebview, io.dcloud.common.DHInterface.IWebview
    public void executeScript(java.lang.String str) {
    }

    @Override // io.dcloud.common.adapter.ui.AdaWebview, io.dcloud.common.DHInterface.IWebview
    public float getScale() {
        return this.mScale;
    }

    public int getSelectIndex() {
        return this.mSelectIndex;
    }

    public java.lang.String getTabBarHeight() {
        return this.mTabBar.getTabHeightStr().substring(0, this.mTabBar.getTabHeightStr().length() - 2);
    }

    public void hideTabBar(com.alibaba.fastjson.JSONObject jSONObject) {
        if (this.isVisible) {
            boolean zBooleanValue = jSONObject.containsKey("animation") ? jSONObject.getBoolean("animation").booleanValue() : false;
            setTabItemsBottomMargin(0);
            this.mTabBar.bringToFront();
            this.mTabBar.bringMaskToFront();
            if (zBooleanValue) {
                android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(0.0f, 0.0f, 0.0f, this.mTabBar.getTabHeight() + this.mTabBar.getMidHeight());
                translateAnimation.setDuration(100L);
                translateAnimation.setAnimationListener(new io.dcloud.common.core.ui.TabBarWebview.b());
                this.mTabBar.startAnimation(translateAnimation);
            } else {
                this.mTabBar.postDelayed(new io.dcloud.common.core.ui.TabBarWebview.c(), 150L);
            }
            this.isVisible = false;
        }
    }

    public void hideTabBarRedDot(com.alibaba.fastjson.JSONObject jSONObject) {
        this.mTabBar.hideTabBarRedDot(jSONObject);
    }

    public boolean isInsertLauch() {
        if (this.mChildJson != null) {
            for (int i = 0; i < this.mChildJson.size(); i++) {
                if (this.mChildJson.getString(i).equals("lauchwebview")) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public io.dcloud.common.DHInterface.IApp obtainApp() {
        return this.mApp;
    }

    @Override // io.dcloud.common.adapter.ui.AdaWebview, io.dcloud.common.DHInterface.IWebview
    public android.view.ViewGroup obtainWindowView() {
        return this.mRoot;
    }

    @Override // io.dcloud.common.adapter.ui.AdaContainerFrameItem, io.dcloud.common.adapter.ui.AdaFrameItem
    protected void onResize() {
        super.onResize();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void popFrame(java.lang.String str) {
        if (this.mTabLayout != null) {
            io.dcloud.common.core.ui.l lVar = this.mWindowMgr;
            io.dcloud.common.DHInterface.IMgr.MgrType mgrType = io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr;
            io.dcloud.common.DHInterface.IApp iApp = this.mApp;
            java.lang.Object objProcessEvent = lVar.processEvent(mgrType, 10, new java.lang.Object[]{iApp, io.dcloud.common.constant.AbsoluteConst.F_UI, "findWebview", new java.lang.String[]{iApp.obtainAppId(), str}});
            if (objProcessEvent == null || !(objProcessEvent instanceof io.dcloud.common.DHInterface.IWebview)) {
                return;
            }
            ((io.dcloud.common.DHInterface.IWebview) objProcessEvent).obtainFrameView().obtainMainView().setVisibility(8);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void pushFrame(java.lang.String str) {
        if (this.mTabLayout != null) {
            io.dcloud.common.core.ui.l lVar = this.mWindowMgr;
            io.dcloud.common.DHInterface.IMgr.MgrType mgrType = io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr;
            io.dcloud.common.DHInterface.IApp iApp = this.mApp;
            java.lang.Object objProcessEvent = lVar.processEvent(mgrType, 10, new java.lang.Object[]{iApp, io.dcloud.common.constant.AbsoluteConst.F_UI, "findWebview", new java.lang.String[]{iApp.obtainAppId(), str}});
            if (objProcessEvent == null || !(objProcessEvent instanceof io.dcloud.common.DHInterface.IWebview)) {
                return;
            }
            ((io.dcloud.common.DHInterface.IWebview) objProcessEvent).obtainFrameView().obtainMainView().setVisibility(0);
        }
    }

    public void removeFrameView(io.dcloud.common.core.ui.b bVar) {
        android.widget.FrameLayout frameLayout;
        if (bVar == null || (frameLayout = this.mTabLayout) == null) {
            return;
        }
        frameLayout.removeView(bVar.obtainMainView());
        if (this.mTabItems.contains(bVar)) {
            this.mTabItems.remove(bVar);
        }
        if (this.mTabItems.size() == 0 && this.mTabBar.getVisibility() == 0) {
            this.mTabBar.setVisibility(4);
        }
    }

    public void removeTabBarBadge(com.alibaba.fastjson.JSONObject jSONObject) {
        this.mTabBar.removeTabBarBadge(jSONObject);
    }

    public void setClickCallBack(io.dcloud.common.DHInterface.ICallBack iCallBack) {
        this.mTabBar.setSingleCallbackListener(iCallBack);
    }

    public void setDoubleClickCallBack(io.dcloud.common.DHInterface.ICallBack iCallBack) {
        this.mTabBar.setDoubleCallbackListener(iCallBack);
    }

    @Override // io.dcloud.common.adapter.ui.AdaWebview, io.dcloud.common.DHInterface.IWebview
    public void setIWebViewFocusable(boolean z) {
        super.setIWebViewFocusable(z);
        java.util.ArrayList<io.dcloud.common.core.ui.b> arrayList = this.mTabItems;
        if (arrayList != null) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                io.dcloud.common.core.ui.b bVar = arrayList.get(i);
                i++;
                io.dcloud.common.core.ui.b bVar2 = bVar;
                if (bVar2 != null && bVar2.obtainWebView() != null) {
                    bVar2.obtainWebView().setIWebViewFocusable(z);
                }
            }
        }
        com.dcloud.android.widget.TabView tabView = this.mTabBar;
        if (tabView != null) {
            tabView.setIWebViewFocusable(z);
        }
    }

    public void setItem(com.alibaba.fastjson.JSONObject jSONObject) {
        this.mTabBar.setTabBarItem(jSONObject);
    }

    public void setMask(com.alibaba.fastjson.JSONObject jSONObject) {
        this.mTabBar.setMask(jSONObject);
    }

    public void setMaskButtonClickCallBack(io.dcloud.common.DHInterface.ICallBack iCallBack) {
        this.mTabBar.setMaskCallbackListener(iCallBack);
    }

    public void setMidButtonClickCallBack(io.dcloud.common.DHInterface.ICallBack iCallBack) {
        this.mTabBar.setMidCallbackListener(iCallBack);
    }

    public void setStyle(com.alibaba.fastjson.JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mTabBar.setTabBarStyle(jSONObject);
            if (jSONObject.containsKey("height")) {
                setTabItemsBottomMargin(this.isVisible ? this.mTabBar.getTabHeight() : 0);
            }
        }
    }

    public void setTabBarBadge(com.alibaba.fastjson.JSONObject jSONObject) {
        this.mTabBar.setTabBarBadge(jSONObject);
    }

    public void setTabItemsBottomMargin(int i) {
        if (this.mTabItems != null) {
            android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) this.mTabLayout.getLayoutParams();
            layoutParams.bottomMargin = i;
            this.mTabLayout.setLayoutParams(layoutParams);
            java.util.ArrayList<io.dcloud.common.core.ui.b> arrayList = this.mTabItems;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                io.dcloud.common.core.ui.b bVar = arrayList.get(i2);
                i2++;
                io.dcloud.common.core.ui.b bVar2 = bVar;
                if (bVar2 != null && bVar2.obtainMainView() != null) {
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    try {
                        jSONObject.put("top", "0px");
                        jSONObject.put("bottom", i > 0 ? this.mTabBar.getTabHeightStr() : "0px");
                        jSONObject.put("isTab", true);
                    } catch (org.json.JSONException e2) {
                        e2.printStackTrace();
                    }
                    bVar2.obtainFrameOptions().updateViewData(jSONObject);
                    bVar2.obtainMainView().post(new io.dcloud.common.core.ui.TabBarWebview.e(bVar2));
                }
            }
            this.mFrameView.resize();
        }
    }

    @Override // io.dcloud.common.DHInterface.IWebview
    public void show(android.view.animation.Animation animation) {
    }

    public void showTabBar(com.alibaba.fastjson.JSONObject jSONObject) {
        if (this.isVisible) {
            return;
        }
        if (jSONObject.containsKey("animation") ? jSONObject.getBoolean("animation").booleanValue() : false) {
            android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(0.0f, 0.0f, this.mTabBar.getTabHeight() + this.mTabBar.getMidHeight(), 0.0f);
            translateAnimation.setDuration(100L);
            translateAnimation.setAnimationListener(new io.dcloud.common.core.ui.TabBarWebview.d());
            this.mTabBar.startAnimation(translateAnimation);
        } else {
            setTabItemsBottomMargin(this.mTabBar.getTabHeight());
        }
        this.mTabBar.setVisibility(0);
        this.isVisible = true;
    }

    public void showTabBarRedDot(com.alibaba.fastjson.JSONObject jSONObject) {
        this.mTabBar.showTabBarRedDot(jSONObject);
    }

    public void switchSelect(int i) {
        this.mSelectIndex = i;
        this.mTabBar.switchTab(i);
    }

    public void tabItemActive(io.dcloud.common.core.ui.b bVar) {
        for (int i = 0; i < this.mTabItems.size(); i++) {
            io.dcloud.common.core.ui.b bVar2 = this.mTabItems.get(i);
            if (bVar == null || bVar2 != bVar) {
                this.mTabItems.get(i).obtainMainView().setImportantForAccessibility(4);
                bVar2.obtainMainView().setImportantForAccessibility(4);
            } else {
                bVar2.obtainMainView().setImportantForAccessibility(0);
            }
        }
    }

    public void updateMidButton(com.alibaba.fastjson.JSONObject jSONObject) {
        this.mTabBar.updateMidButton(jSONObject);
    }

    public void append(io.dcloud.common.core.ui.b bVar) {
        int iIndexOfChild;
        if (bVar != null) {
            android.view.View viewObtainMainView = bVar.obtainMainView();
            if (viewObtainMainView.getParent() != null) {
                bVar.p();
                bVar.getAnimOptions().mOption = (byte) 1;
                bVar.k.b(bVar);
                if (bVar.e()) {
                    this.mWindowMgr.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 28, bVar.b);
                    bVar.b = null;
                }
                bVar.r();
                bVar.b(false);
                bVar.getAnimOptions().mOption = (byte) 0;
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) viewObtainMainView.getParent();
                iIndexOfChild = viewGroup == this.mTabLayout ? viewGroup.indexOfChild(viewObtainMainView) : -1;
                viewGroup.removeView(viewObtainMainView);
            } else {
                iIndexOfChild = -1;
            }
            bVar.setTabItem(true);
            this.mWindowMgr.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 22, bVar);
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put("top", "0px");
                jSONObject.put("bottom", this.isVisible ? this.mTabBar.getTabHeightStr() : "0px");
                jSONObject.put("isTab", true);
            } catch (org.json.JSONException e2) {
                e2.printStackTrace();
            }
            bVar.obtainFrameOptions().setParentViewRect(this.mFrameView.obtainFrameOptions());
            bVar.obtainFrameOptions().updateViewData(jSONObject);
            bVar.setParentFrameItem(this.mFrameView);
            this.mFrameView.mChildArrayList.add(bVar);
            bVar.inStack = true;
            bVar.isChildOfFrameView = true;
            this.mTabLayout.addView(viewObtainMainView, iIndexOfChild, new android.widget.FrameLayout.LayoutParams(-1, -1));
            bVar.obtainWebView().setIWebViewFocusable(true);
            if (!this.mTabItems.contains(bVar)) {
                this.mTabItems.add(bVar);
            }
            if (this.mTabItems.size() > 0 && this.mTabBar.getVisibility() != 0 && this.isVisible) {
                this.mTabBar.setVisibility(0);
            }
            if (viewObtainMainView.getImportantForAccessibility() == 4) {
                viewObtainMainView.setImportantForAccessibility(0);
            }
            bVar.obtainMainView().post(new io.dcloud.common.core.ui.TabBarWebview.a(bVar));
        }
    }
}
