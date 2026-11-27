package io.dcloud.common.core.ui;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class DCKeyboardManager {
    public static java.lang.String SOFT_INPUT_MODE_ADJUST_NOTHING = "nothing";
    public static java.lang.String SOFT_INPUT_MODE_ADJUST_PAN = "adjustPan";
    public static java.lang.String SOFT_INPUT_MODE_ADJUST_RESIZE = "adjustResize";
    public static io.dcloud.common.core.ui.DCKeyboardManager instance;
    private java.lang.Runnable keyBoardHideRunnable;
    private java.lang.Runnable keyBoardShowRunnable;
    private android.view.View mContentView;
    private io.dcloud.common.core.ui.a mDHAppRoot;
    private android.os.Handler mHandler;
    java.lang.String mInputMode;
    private android.view.ViewTreeObserver.OnGlobalLayoutListener mLayoutChangeListener;
    private android.view.View mRootContentView;
    int rootViewVisibleHeight;
    private final java.lang.String TAG = "DCKeyboardManager";
    private float mFocusTop = 0.0f;
    private boolean isNativeFocus = false;
    private android.view.View mNativeView = null;
    private java.lang.String mFrontInputType = "text";
    private java.lang.String mActivitySoftInputMode = "";
    int mOrientation = -100;
    private boolean isAdjust = true;
    private io.dcloud.common.DHInterface.IFrameView mInputRootFrame = null;
    boolean isAdministration = false;
    private boolean isAllScreen = false;
    private java.lang.ref.SoftReference<android.app.Activity> mSoftAc = null;
    private float mHtmlInputFT = -1.0f;
    boolean isNativeUpDate = false;
    float mNaiveCursorSpacing = 0.0f;
    java.lang.String EVENTS_DOCUMENT_KEYBOARD = "javascript:(function(){if(!((window.__html5plus__&&__html5plus__.isReady)?__html5plus__:(navigator.plus&&navigator.plus.isReady)?navigator.plus:window.plus)){window.__load__plus__&&window.__load__plus__();}var e = document.createEvent('HTMLEvents');var evt = '%s';e.initEvent(evt, false, true); e.height = %d;/*console.log('dispatch ' + evt + ' event');*/document.dispatchEvent(e);})();";

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements android.view.ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ android.app.Activity a;

        /* JADX INFO: renamed from: io.dcloud.common.core.ui.DCKeyboardManager$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class RunnableC0033a implements java.lang.Runnable {
            final /* synthetic */ int a;

            RunnableC0033a(int i) {
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                io.dcloud.common.core.ui.DCKeyboardManager.this.onKeyboardChanged(this.a, true);
                io.dcloud.common.adapter.util.AndroidResources.sIMEAlive = true;
                io.dcloud.common.adapter.util.DeviceInfo.isIMEShow = true;
                io.dcloud.common.adapter.util.DeviceInfo.sInputMethodHeight = java.lang.Math.abs(this.a);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class b implements java.lang.Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                io.dcloud.common.core.ui.DCKeyboardManager.this.onKeyboardChanged(-1, io.dcloud.common.adapter.util.AndroidResources.sIMEAlive);
                if (io.dcloud.common.core.ui.DCKeyboardManager.this.mDHAppRoot != null) {
                    io.dcloud.common.core.ui.DCKeyboardManager.this.mDHAppRoot.g();
                }
                io.dcloud.common.adapter.util.AndroidResources.sIMEAlive = false;
                io.dcloud.common.adapter.util.DeviceInfo.isIMEShow = false;
            }
        }

        a(android.app.Activity activity) {
            this.a = activity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(android.app.Activity activity) {
            int i;
            int height = io.dcloud.common.core.ui.DCKeyboardManager.this.mRootContentView.getHeight();
            int height2 = ((android.widget.FrameLayout) io.dcloud.common.core.ui.DCKeyboardManager.this.mRootContentView).getChildAt(0).getHeight();
            io.dcloud.common.core.ui.DCKeyboardManager dCKeyboardManager = io.dcloud.common.core.ui.DCKeyboardManager.this;
            if (dCKeyboardManager.rootViewVisibleHeight == 0) {
                dCKeyboardManager.rootViewVisibleHeight = height;
                return;
            }
            boolean zIsFullScreen = io.dcloud.common.util.PdrUtil.isFullScreen(activity);
            android.graphics.Rect rect = new android.graphics.Rect();
            io.dcloud.common.core.ui.DCKeyboardManager.this.mContentView.getWindowVisibleDisplayFrame(rect);
            int iHeight = rect.height();
            if (!zIsFullScreen && (i = io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight + iHeight) <= height2) {
                iHeight = i;
            }
            int i2 = io.dcloud.common.core.ui.DCKeyboardManager.this.isAllScreen ? height / 6 : height / 5;
            io.dcloud.common.core.ui.DCKeyboardManager dCKeyboardManager2 = io.dcloud.common.core.ui.DCKeyboardManager.this;
            if (dCKeyboardManager2.rootViewVisibleHeight == iHeight) {
                return;
            }
            try {
                int i3 = android.os.Build.VERSION.SDK_INT >= 36 ? dCKeyboardManager2.mRootContentView.getRootWindowInsets().getInsets(android.view.WindowInsets.Type.ime()).bottom - io.dcloud.common.core.ui.DCKeyboardManager.this.mRootContentView.getRootWindowInsets().getInsets(android.view.WindowInsets.Type.navigationBars()).bottom : height2 - iHeight;
                if (i3 > i2) {
                    if (io.dcloud.common.core.ui.DCKeyboardManager.this.keyBoardShowRunnable != null) {
                        io.dcloud.common.core.ui.DCKeyboardManager.this.mHandler.removeCallbacks(io.dcloud.common.core.ui.DCKeyboardManager.this.keyBoardShowRunnable);
                    }
                    io.dcloud.common.core.ui.DCKeyboardManager.this.keyBoardShowRunnable = new io.dcloud.common.core.ui.DCKeyboardManager.a.RunnableC0033a(i3);
                    io.dcloud.common.core.ui.DCKeyboardManager.this.mHandler.post(io.dcloud.common.core.ui.DCKeyboardManager.this.keyBoardShowRunnable);
                } else {
                    if (io.dcloud.common.core.ui.DCKeyboardManager.this.keyBoardHideRunnable != null) {
                        io.dcloud.common.core.ui.DCKeyboardManager.this.mHandler.removeCallbacks(io.dcloud.common.core.ui.DCKeyboardManager.this.keyBoardHideRunnable);
                    }
                    io.dcloud.common.core.ui.DCKeyboardManager.this.keyBoardHideRunnable = new io.dcloud.common.core.ui.DCKeyboardManager.a.b();
                    io.dcloud.common.core.ui.DCKeyboardManager.this.mHandler.post(io.dcloud.common.core.ui.DCKeyboardManager.this.keyBoardHideRunnable);
                }
                io.dcloud.common.core.ui.DCKeyboardManager.this.rootViewVisibleHeight = iHeight;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (io.dcloud.common.core.ui.DCKeyboardManager.this.mContentView == null) {
                return;
            }
            android.view.View view = io.dcloud.common.core.ui.DCKeyboardManager.this.mContentView;
            final android.app.Activity activity = this.a;
            view.post(new java.lang.Runnable() { // from class: io.dcloud.common.core.ui.DCKeyboardManager$a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(activity);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b implements java.lang.Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            io.dcloud.common.core.ui.DCKeyboardManager.this.onKeyboardChanged(io.dcloud.common.core.ui.DCKeyboardManager.this.getKeyBoardHeight(), true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class c implements java.lang.Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            io.dcloud.common.core.ui.DCKeyboardManager.this.onKeyboardChanged(io.dcloud.common.core.ui.DCKeyboardManager.this.getKeyBoardHeight(), true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class d implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ io.dcloud.common.adapter.ui.AdaFrameView b;
        final /* synthetic */ android.view.View c;

        d(java.lang.String str, io.dcloud.common.adapter.ui.AdaFrameView adaFrameView, android.view.View view) {
            this.a = str;
            this.b = adaFrameView;
            this.c = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.equals(io.dcloud.common.core.ui.DCKeyboardManager.SOFT_INPUT_MODE_ADJUST_PAN)) {
                io.dcloud.common.adapter.ui.AdaFrameView adaFrameView = this.b;
                int i = adaFrameView != null ? adaFrameView.obtainFrameOptions().top : 0;
                android.view.View view = this.c;
                if (view != null) {
                    view.setTranslationY(i);
                }
            }
            android.view.ViewGroup.LayoutParams layoutParams = io.dcloud.common.core.ui.DCKeyboardManager.this.mContentView.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -1;
            io.dcloud.common.core.ui.DCKeyboardManager.this.mContentView.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class e implements java.lang.Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ android.view.View b;

        e(int i, android.view.View view) {
            this.a = i;
            this.b = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.setTranslationY(this.a - io.dcloud.common.core.ui.DCKeyboardManager.this.mFocusTop);
        }
    }

    private void fireKeyboardEvent(io.dcloud.common.DHInterface.IFrameView iFrameView, int i) {
        if (!iFrameView.obtainWebView().isUniWebView()) {
            iFrameView.obtainWebView().loadUrl(io.dcloud.common.util.StringUtil.format(this.EVENTS_DOCUMENT_KEYBOARD, "keyboardchange", java.lang.Integer.valueOf((int) (i / iFrameView.obtainWebView().getScale()))));
        }
        if (io.dcloud.common.util.BaseInfo.isUniAppAppid(iFrameView.obtainApp())) {
            iFrameView.obtainWindowMgr().processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 10, new java.lang.Object[]{iFrameView.obtainApp(), "weex,io.dcloud.feature.weex.WeexFeature", "onKeyboardHeightChange", new java.lang.Object[]{"__uniapp__service", java.lang.Integer.valueOf(i)}});
        }
    }

    private java.lang.String getActivityInput(android.app.Activity activity) {
        int i = activity.getWindow().getAttributes().softInputMode;
        if (i == 16) {
            return SOFT_INPUT_MODE_ADJUST_RESIZE;
        }
        if (i == 32) {
            return SOFT_INPUT_MODE_ADJUST_PAN;
        }
        if (i == 48) {
            return SOFT_INPUT_MODE_ADJUST_NOTHING;
        }
        java.lang.String metaValue = io.dcloud.common.adapter.util.AndroidResources.getMetaValue("DCLOUD_INPUT_MODE");
        return !android.text.TextUtils.isEmpty(metaValue) ? metaValue : SOFT_INPUT_MODE_ADJUST_RESIZE;
    }

    public static io.dcloud.common.core.ui.DCKeyboardManager getInstance() {
        if (instance == null) {
            instance = new io.dcloud.common.core.ui.DCKeyboardManager();
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getKeyBoardHeight() {
        java.lang.ref.SoftReference<android.app.Activity> softReference;
        int i;
        if (this.mContentView == null || (softReference = this.mSoftAc) == null || softReference.get() == null) {
            return 0;
        }
        boolean zIsFullScreen = io.dcloud.common.util.PdrUtil.isFullScreen(this.mSoftAc.get());
        android.graphics.Rect rect = new android.graphics.Rect();
        this.mContentView.getWindowVisibleDisplayFrame(rect);
        int iHeight = rect.height();
        int height = ((android.widget.FrameLayout) this.mRootContentView).getChildAt(0).getHeight();
        if (!zIsFullScreen && (i = io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight + iHeight) <= height) {
            iHeight = i;
        }
        return height - iHeight;
    }

    private static android.view.View getScrollView(android.view.View view) {
        if (view instanceof android.view.ViewGroup) {
            try {
                if (view.canScrollVertically(1)) {
                    return view;
                }
                for (int i = 0; i < ((android.view.ViewGroup) view).getChildCount(); i++) {
                    android.view.View scrollView = getScrollView(((android.view.ViewGroup) view).getChildAt(i));
                    if (scrollView != null) {
                        return scrollView;
                    }
                }
            } catch (java.lang.Exception unused) {
            }
        }
        return null;
    }

    private void keyboardHide(io.dcloud.common.adapter.ui.AdaFrameView adaFrameView, android.view.View view, java.lang.String str) {
        if (this.isAdjust) {
            this.mFocusTop = 0.0f;
            this.mContentView.post(new io.dcloud.common.core.ui.DCKeyboardManager.d(str, adaFrameView, view));
        }
    }

    private void keyboardShow(android.view.View view, int i, java.lang.String str, boolean z) {
        if (str.equals(SOFT_INPUT_MODE_ADJUST_NOTHING) || !this.isAdjust || io.dcloud.common.adapter.util.DeviceInfo.isIMEShow) {
            return;
        }
        int height = this.mContentView.getHeight();
        if (str.equals(SOFT_INPUT_MODE_ADJUST_RESIZE)) {
            android.view.ViewGroup.LayoutParams layoutParams = this.mContentView.getLayoutParams();
            layoutParams.height = height - i;
            this.mContentView.setLayoutParams(layoutParams);
        } else {
            int i2 = height - i;
            if (!z) {
                this.mFocusTop = this.mHtmlInputFT;
            }
            if (i2 < this.mFocusTop - (io.dcloud.common.adapter.util.DeviceInfo.isIMEShow ? 0.0f - view.getTranslationY() : 0.0f)) {
                this.mContentView.post(new io.dcloud.common.core.ui.DCKeyboardManager.e(i2, view));
            }
        }
    }

    public void dhAppRootIsReady(io.dcloud.common.core.ui.a aVar) {
        if (this.isAdministration) {
            this.mDHAppRoot = aVar;
            this.mContentView.getViewTreeObserver().addOnGlobalLayoutListener(this.mLayoutChangeListener);
        }
    }

    public java.lang.String getFrameSoftInputMode() {
        io.dcloud.common.core.ui.a aVar = this.mDHAppRoot;
        if (aVar != null) {
            return aVar.h().obtainFrameOptions().softinputMode;
        }
        return null;
    }

    public java.lang.String getFrontInputType() {
        return this.mFrontInputType;
    }

    public android.view.View getNativeInput() {
        return this.mNativeView;
    }

    public boolean isTakeOver() {
        java.lang.String frameSoftInputMode = getInstance().getFrameSoftInputMode();
        if (frameSoftInputMode != null) {
            return SOFT_INPUT_MODE_ADJUST_PAN.equals(frameSoftInputMode) || SOFT_INPUT_MODE_ADJUST_NOTHING.equals(frameSoftInputMode);
        }
        return false;
    }

    public void nativeEditTextFocus(java.lang.String str, android.view.View view, boolean z, java.lang.String str2, float f) {
        this.isNativeFocus = z;
        this.isNativeUpDate = true;
        this.mInputRootFrame = null;
        this.mInputMode = str2;
        if (z) {
            this.mNativeView = view;
            this.mNaiveCursorSpacing = f;
            if (this.mDHAppRoot != null && !android.text.TextUtils.isEmpty(str)) {
                io.dcloud.common.core.ui.b bVarH = this.mDHAppRoot.h();
                if (bVarH == null) {
                    return;
                }
                java.lang.Object objProcessEvent = bVarH.obtainWindowMgr().processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 10, new java.lang.Object[]{bVarH.obtainApp(), "weex,io.dcloud.feature.weex.WeexFeature", "findWebviewByInstanceId", new java.lang.Object[]{str}});
                if (objProcessEvent != null && (objProcessEvent instanceof io.dcloud.common.DHInterface.IWebview)) {
                    this.mInputRootFrame = ((io.dcloud.common.DHInterface.IWebview) objProcessEvent).obtainFrameView();
                }
            }
            if (!str2.equals(SOFT_INPUT_MODE_ADJUST_NOTHING) && io.dcloud.common.adapter.util.DeviceInfo.isIMEShow) {
                java.lang.Runnable runnable = this.keyBoardShowRunnable;
                if (runnable != null) {
                    this.mHandler.removeCallbacks(runnable);
                }
                io.dcloud.common.core.ui.DCKeyboardManager.c cVar = new io.dcloud.common.core.ui.DCKeyboardManager.c();
                this.keyBoardShowRunnable = cVar;
                this.mHandler.post(cVar);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(android.app.Activity activity) {
        this.mActivitySoftInputMode = getActivityInput(activity);
        this.isAdministration = true;
        this.mSoftAc = new java.lang.ref.SoftReference<>(activity);
        this.mHandler = new android.os.Handler(android.os.Looper.getMainLooper());
        this.mOrientation = activity.getResources().getConfiguration().orientation;
        this.mRootContentView = activity.getWindow().getDecorView();
        io.dcloud.common.DHInterface.IActivityHandler iActivityHandler = io.src.dcloud.adapter.DCloudAdapterUtil.getIActivityHandler(activity);
        if (iActivityHandler != null) {
            this.mContentView = iActivityHandler.obtainActivityContentView();
        } else if (activity instanceof io.dcloud.common.DHInterface.IActivityDelegate) {
            this.mContentView = ((io.dcloud.common.DHInterface.IActivityDelegate) activity).obtainActivityContentView();
        }
        this.isAllScreen = io.dcloud.common.util.PdrUtil.isAllScreenDevice(activity);
        io.dcloud.common.adapter.util.DeviceInfo.updateStatusBarHeight(activity);
        this.mLayoutChangeListener = new io.dcloud.common.core.ui.DCKeyboardManager.a(activity);
    }

    public void onKeyboardChanged(int i, boolean z) {
        io.dcloud.common.core.ui.b bVarH;
        android.view.View viewObtainMainView;
        android.view.View view;
        if (this.isAdjust && this.mDHAppRoot != null && this.mActivitySoftInputMode.equals(SOFT_INPUT_MODE_ADJUST_RESIZE) && (bVarH = this.mDHAppRoot.h()) != null) {
            if (android.text.TextUtils.isEmpty(this.mInputMode)) {
                this.mInputMode = getFrameSoftInputMode();
            }
            if (z) {
                io.dcloud.common.DHInterface.IFrameView iFrameView = this.mInputRootFrame;
                if (iFrameView != null && iFrameView.obtainWebView() != null) {
                    fireKeyboardEvent(this.mInputRootFrame, i);
                } else if (bVarH.obtainWebView() != null) {
                    fireKeyboardEvent(bVarH, i);
                }
            }
            if (i > 1 && this.mInputMode.equals(SOFT_INPUT_MODE_ADJUST_NOTHING)) {
                android.view.View view2 = this.mNativeView;
                if (view2 == null || !(view2 instanceof io.dcloud.common.core.ui.keyboard.DCEditText) || ((io.dcloud.common.core.ui.keyboard.DCEditText) view2).getKeyboardHeightChangeListener() == null) {
                    return;
                }
                ((io.dcloud.common.core.ui.keyboard.DCEditText) this.mNativeView).getKeyboardHeightChangeListener().onChange(true, i);
                return;
            }
            int height = this.mContentView.getHeight();
            io.dcloud.common.DHInterface.IFrameView iFrameView2 = this.mInputRootFrame;
            if (iFrameView2 == null) {
                viewObtainMainView = bVarH.getChilds().size() > 1 ? bVarH.obtainMainView() : bVarH.obtainWebView().obtainWindowView();
            } else {
                if (iFrameView2.obtainWebView() == null) {
                    this.mInputRootFrame = null;
                    return;
                }
                viewObtainMainView = this.mInputRootFrame.obtainWebView().obtainWindowView();
            }
            try {
                if (i <= 0) {
                    android.view.View view3 = this.mNativeView;
                    if ((view3 instanceof io.dcloud.common.core.ui.keyboard.DCEditText) && ((io.dcloud.common.core.ui.keyboard.DCEditText) view3).getKeyboardHeightChangeListener() != null) {
                        ((io.dcloud.common.core.ui.keyboard.DCEditText) this.mNativeView).getKeyboardHeightChangeListener().onChange(false, i);
                    }
                    if (this.mInputRootFrame != null || bVarH.getChilds().size() <= 1) {
                        bVarH = null;
                    }
                    keyboardHide(bVarH, viewObtainMainView, this.mInputMode);
                    this.isNativeUpDate = true;
                    return;
                }
                if (!this.isNativeFocus || (view = this.mNativeView) == null) {
                    this.mNativeView = null;
                    this.isNativeUpDate = true;
                    if (this.mInputMode.equals(SOFT_INPUT_MODE_ADJUST_PAN)) {
                        float f = this.mHtmlInputFT;
                        float f2 = height;
                        if (f > f2) {
                            int i2 = (int) (f - f2);
                            if (viewObtainMainView instanceof android.webkit.WebView) {
                                viewObtainMainView.scrollBy(0, i2);
                            }
                            this.mHtmlInputFT = f2;
                        }
                    }
                    keyboardShow(viewObtainMainView, i, this.mInputMode, false);
                    return;
                }
                if (this.isNativeUpDate) {
                    int[] iArr = new int[2];
                    view.getLocationOnScreen(iArr);
                    float height2 = iArr[1] + this.mNativeView.getHeight() + this.mNaiveCursorSpacing;
                    this.mFocusTop = height2;
                    float f3 = height;
                    if (height2 > f3) {
                        int i3 = (int) (height2 - f3);
                        android.view.View scrollView = getScrollView(viewObtainMainView);
                        if (scrollView != null) {
                            scrollView.scrollBy(0, i3);
                        }
                        this.mFocusTop = f3;
                    }
                    this.isNativeUpDate = false;
                }
                android.view.View view4 = this.mNativeView;
                if ((view4 instanceof io.dcloud.common.core.ui.keyboard.DCEditText) && ((io.dcloud.common.core.ui.keyboard.DCEditText) view4).getKeyboardHeightChangeListener() != null) {
                    ((io.dcloud.common.core.ui.keyboard.DCEditText) this.mNativeView).getKeyboardHeightChangeListener().onChange(true, i);
                }
                keyboardShow(viewObtainMainView, i, this.mInputMode, true);
            } catch (java.lang.Exception unused) {
                this.mInputMode = null;
                this.mNativeView = null;
            }
        }
    }

    public void onStop() {
        if (this.isAdministration) {
            this.mRootContentView.getViewTreeObserver().removeOnGlobalLayoutListener(this.mLayoutChangeListener);
        }
    }

    public void setAdjust(boolean z) {
        this.isAdjust = z;
    }

    public void setContentView(io.dcloud.common.DHInterface.IActivityHandler iActivityHandler) {
        if (iActivityHandler != null) {
            this.mContentView = iActivityHandler.obtainActivityContentView();
        }
    }

    public void setFrontInputType(java.lang.String str) {
        this.mFrontInputType = str;
    }

    public void setHTMLInputRect(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str) {
        try {
            if (this.isAdjust) {
                io.dcloud.common.DHInterface.IFrameView iFrameViewObtainFrameView = iWebview.obtainFrameView();
                this.mInputRootFrame = iFrameViewObtainFrameView;
                if (iFrameViewObtainFrameView == null) {
                    return;
                }
                int[] iArr = new int[2];
                iFrameViewObtainFrameView.obtainWebView().obtainWindowView().getLocationOnScreen(iArr);
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                org.json.JSONObject jSONObject2 = jSONObject.getJSONObject("position");
                java.lang.String strOptString = jSONObject.optString("mode");
                this.mInputMode = strOptString;
                if (strOptString.equals(SOFT_INPUT_MODE_ADJUST_NOTHING)) {
                    return;
                }
                float f = io.dcloud.common.util.PdrUtil.parseFloat(jSONObject2.optString("top"), 0.0f, 0.0f, iWebview.getScale()) + io.dcloud.common.util.PdrUtil.parseFloat(jSONObject2.optString("height"), 0.0f, 0.0f, iWebview.getScale()) + iArr[1];
                this.mHtmlInputFT = f;
                this.mFocusTop = f;
                if (io.dcloud.common.adapter.util.DeviceInfo.isIMEShow) {
                    java.lang.Runnable runnable = this.keyBoardShowRunnable;
                    if (runnable != null) {
                        this.mHandler.removeCallbacks(runnable);
                    }
                    io.dcloud.common.core.ui.DCKeyboardManager.b bVar = new io.dcloud.common.core.ui.DCKeyboardManager.b();
                    this.keyBoardShowRunnable = bVar;
                    this.mHandler.post(bVar);
                }
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            this.mInputMode = null;
            this.mFocusTop = 0.0f;
            this.mHtmlInputFT = 0.0f;
        }
    }

    public void setNativeInput(android.view.View view, float f) {
        this.mNativeView = view;
        this.mNaiveCursorSpacing = f;
        this.isNativeUpDate = true;
    }
}
