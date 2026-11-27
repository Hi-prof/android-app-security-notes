package io.dcloud.common.adapter.ui.webview;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class SysWebView extends android.webkit.WebView implements io.dcloud.common.adapter.ui.webview.DCWebView, android.webkit.DownloadListener, com.dcloud.android.v4.widget.IRefreshAble.OnRefreshListener {
    static final java.lang.String PLUSSCROLLBOTTOM_JS_TEMPLATE = "(function(){var e = document.createEvent('HTMLEvents');var evt = 'plusscrollbottom';e.initEvent(evt, false, true);document.dispatchEvent(e);})();";
    static final java.lang.String TAG = "webview";
    android.webkit.CookieManager cm;
    private boolean didTouch;
    boolean isToInvalidate;
    io.dcloud.common.adapter.ui.AdaWebview mAdaWebview;
    java.lang.String mBaseUrl;
    private int mCacheMode;
    private int mContentHeight;
    android.content.Context mContext;
    private io.dcloud.common.DHInterface.IDCloudWebviewClientListener mDcloudwebviewclientListener;
    int mDeafaltOverScrollMode;
    private int mEventX;
    private int mEventY;
    private boolean mIsBeingDragged;
    float mLastMotionX;
    float mLastMotionY;
    private long mLastScrollTimestamp;
    private int mLastScrollY;
    private io.dcloud.common.adapter.ui.webview.OnPageFinishedCallack mPageFinishedCallack;
    private java.lang.String mPageTitle;
    float mScale;
    private int mThreshold;
    private int mThresholdTime;
    private int mTouchSlop;
    java.lang.String mUrl;
    java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.lang.String>> mUrlHeads;
    java.lang.String mUserAgent;
    io.dcloud.common.adapter.ui.webview.WebJsEvent mWebJsEvent;
    io.dcloud.common.adapter.ui.webview.WebLoadEvent mWebLoadEvent;
    android.webkit.WebSettings webSettings;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class BorderDrawable extends android.graphics.drawable.Drawable {
        int mBackgroundColor;
        android.graphics.Paint mPaint;

        BorderDrawable(int i, int i2) {
            android.graphics.Paint paint = new android.graphics.Paint();
            this.mPaint = paint;
            this.mBackgroundColor = i;
            paint.setColor(i2);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(android.graphics.Canvas canvas) {
            canvas.drawColor(this.mBackgroundColor);
            this.mPaint.setStyle(android.graphics.Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(3.0f);
            canvas.drawRect(getBounds(), this.mPaint);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return this.mPaint.getAlpha();
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            this.mPaint.setAlpha(i);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(android.graphics.ColorFilter colorFilter) {
            this.mPaint.setColorFilter(colorFilter);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public class CustomizedSelectActionModeCallback implements android.view.ActionMode.Callback {
        android.view.ActionMode.Callback callback;

        public CustomizedSelectActionModeCallback(android.view.ActionMode.Callback callback) {
            this.callback = callback;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(android.view.ActionMode actionMode, android.view.MenuItem menuItem) {
            return this.callback.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(android.view.ActionMode actionMode, android.view.Menu menu) {
            this.callback.onCreateActionMode(actionMode, menu);
            int size = menu.size();
            for (int i = 0; i < size; i++) {
                android.view.MenuItem item = menu.getItem(i);
                java.lang.String string = item.getTitle().toString();
                if (string.contains("搜索") || string.toLowerCase(java.util.Locale.ENGLISH).contains("search")) {
                    menu.removeItem(item.getItemId());
                    return true;
                }
            }
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(android.view.ActionMode actionMode) {
            this.callback.onDestroyActionMode(actionMode);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(android.view.ActionMode actionMode, android.view.Menu menu) {
            return this.callback.onPrepareActionMode(actionMode, menu);
        }
    }

    public SysWebView(android.content.Context context, io.dcloud.common.adapter.ui.AdaWebview adaWebview) {
        super(context);
        this.mUserAgent = null;
        this.mAdaWebview = null;
        this.mWebLoadEvent = null;
        this.mWebJsEvent = null;
        this.mUrl = null;
        this.mScale = 0.0f;
        this.mContext = null;
        this.mBaseUrl = null;
        this.webSettings = getSettings();
        this.cm = null;
        this.mLastScrollY = 0;
        this.mContentHeight = 0;
        this.mThreshold = 2;
        this.mThresholdTime = 15;
        this.mLastScrollTimestamp = 0L;
        this.mPageTitle = null;
        this.mDeafaltOverScrollMode = 0;
        this.mCacheMode = -1;
        this.didTouch = false;
        this.isToInvalidate = false;
        this.mUrlHeads = new java.util.HashMap<>();
        this.mEventY = 0;
        this.mEventX = 0;
        this.mTouchSlop = -1;
        this.mIsBeingDragged = true;
        this.mScale = getContext().getResources().getDisplayMetrics().density;
        io.dcloud.common.adapter.util.Logger.d("WebViewImpl");
        this.mContext = context.getApplicationContext();
        io.dcloud.common.util.BaseInfo.s_Webview_Count++;
        this.mAdaWebview = adaWebview;
    }

    private android.graphics.Bitmap captureWebView(android.webkit.WebView webView, android.graphics.Rect rect) {
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(rect.width(), rect.height(), android.graphics.Bitmap.Config.RGB_565);
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
        canvas.translate(-rect.left, -rect.top);
        io.dcloud.common.adapter.ui.AdaWebview adaWebview = this.mAdaWebview;
        if (adaWebview == null || adaWebview.obtainFrameView() == null || !(this.mAdaWebview.obtainFrameView() instanceof io.dcloud.common.adapter.ui.AdaContainerFrameItem) || ((io.dcloud.common.adapter.ui.AdaContainerFrameItem) this.mAdaWebview.obtainFrameView()).getChilds().size() <= 1) {
            webView.draw(canvas);
            return bitmapCreateBitmap;
        }
        if (this.mAdaWebview.obtainFrameView().obtainMainView() != null) {
            this.mAdaWebview.obtainFrameView().obtainMainView().draw(canvas);
        }
        return bitmapCreateBitmap;
    }

    private static java.lang.String getStreamAppFlag() {
        java.lang.String str;
        if (android.text.TextUtils.isEmpty(io.dcloud.common.util.BaseInfo.sChannel)) {
            str = "";
        } else {
            str = " (" + io.dcloud.common.util.BaseInfo.sChannel + ") ";
        }
        return io.dcloud.common.util.StringUtil.format(io.dcloud.common.adapter.ui.webview.DCWebView.UserAgentStreamApp, str);
    }

    private void removeUnSafeJavascriptInterface() {
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibilityTraversal");
        removeJavascriptInterface("accessibility");
    }

    private void setWebViewData() throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException {
        java.lang.Class<?>[] clsArr = {java.lang.Boolean.TYPE};
        try {
            java.lang.reflect.Method declaredMethod = android.webkit.WebView.class.getDeclaredMethod("getFactory", null);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                java.lang.Object[] objArr = {java.lang.Boolean.FALSE};
                java.lang.Object objInvoke = declaredMethod.invoke(null, null);
                java.lang.reflect.Method declaredMethod2 = objInvoke.getClass().getDeclaredMethod("setWebContentsDebuggingEnabled", clsArr);
                if (declaredMethod2 != null) {
                    declaredMethod2.setAccessible(true);
                    declaredMethod2.invoke(objInvoke, objArr);
                }
            }
        } catch (java.lang.IllegalAccessException | java.lang.IllegalArgumentException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException | java.lang.Exception unused) {
        }
    }

    @Override // io.dcloud.common.adapter.ui.webview.DCWebView
    public void applyWebViewDarkMode() {
        io.dcloud.common.util.AppRuntime.applyWebViewDarkMode(this.mContext, this);
    }

    public boolean checkApkUrl(java.lang.String str, java.lang.String str2) {
        return (!android.text.TextUtils.isEmpty(str2) && str2.toLowerCase(java.util.Locale.ENGLISH).contains(io.dcloud.common.constant.StringConst.POINT_APP_EN)) || str.toLowerCase(java.util.Locale.ENGLISH).contains(io.dcloud.common.constant.StringConst.POINT_APP_EN);
    }

    @Override // io.dcloud.common.adapter.ui.webview.DCWebView
    public boolean checkOverrideUrl(org.json.JSONObject jSONObject, java.lang.String str) {
        if (jSONObject != null) {
            try {
                if (io.dcloud.common.constant.AbsoluteConst.EVENTS_WEBVIEW_ONTOUCH_START.equals(jSONObject.optString("effect", "instant")) && !isDidTouch()) {
                    return false;
                }
                int type = getHitTestResult().getType();
                if ("redirect".equalsIgnoreCase(jSONObject.optString("exclude")) && type == 0) {
                    return false;
                }
                java.lang.String strOptString = jSONObject.optString("mode");
                boolean zMatches = jSONObject.has("match") ? java.util.regex.Pattern.compile(jSONObject.optString("match")).matcher(str).matches() : true;
                if ("allow".equals(strOptString)) {
                    return !zMatches;
                }
                return zMatches;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // io.dcloud.common.adapter.ui.webview.DCWebView
    public boolean checkWhite(java.lang.String str) {
        android.graphics.Rect rect;
        if (getWidth() <= 0) {
            return true;
        }
        if (str.equals("center")) {
            int height = getHeight() / 2;
            rect = new android.graphics.Rect(0, height, getWidth(), height + 1);
        } else if (str.equals("top")) {
            int deivceSuitablePixel = io.dcloud.common.adapter.util.DeviceInfo.getDeivceSuitablePixel(this.mAdaWebview.getActivity(), 20);
            rect = new android.graphics.Rect(0, deivceSuitablePixel, getWidth(), deivceSuitablePixel + 1);
        } else if (str.equals("bottom")) {
            int deivceSuitablePixel2 = io.dcloud.common.adapter.util.DeviceInfo.getDeivceSuitablePixel(this.mAdaWebview.getActivity(), 25);
            rect = new android.graphics.Rect(0, (getHeight() - deivceSuitablePixel2) + 1, getWidth(), getHeight() - deivceSuitablePixel2);
        } else {
            int width = getWidth() / 2;
            rect = new android.graphics.Rect(width, 0, width + 5, getHeight());
        }
        android.graphics.Bitmap bitmapCaptureWebView = captureWebView(this, rect);
        if (bitmapCaptureWebView == null) {
            return false;
        }
        boolean zIsWhiteBitmap = str.equals("auto") ? io.dcloud.common.adapter.util.PlatformUtil.isWhiteBitmap(bitmapCaptureWebView, !this.mAdaWebview.isLoaded(), true) : io.dcloud.common.adapter.util.PlatformUtil.isLineWhiteBitmap(bitmapCaptureWebView, !this.mAdaWebview.isLoaded());
        bitmapCaptureWebView.recycle();
        return zIsWhiteBitmap;
    }

    @Override // io.dcloud.common.adapter.ui.webview.DCWebView
    public void closeWap2AppBlockDialog(boolean z) {
        this.mWebLoadEvent.closeWap2AppBlockDialog(z);
    }

    @Override // io.dcloud.common.adapter.ui.webview.DCWebView
    public java.lang.String convertRelPath(java.lang.String str) {
        if (str.indexOf(this.mBaseUrl) >= 0) {
            return str.substring(this.mBaseUrl.length());
        }
        java.lang.String strSubstring = this.mBaseUrl.substring(7);
        return str.indexOf(strSubstring) >= 0 ? str.substring(strSubstring.length()) : str;
    }

    @Override // io.dcloud.common.adapter.ui.webview.DCWebView
    public void destroyWeb() {
        setWebChromeClient(null);
        setWebViewClient(null);
        setDownloadListener(null);
        destroy();
        destroyDrawingCache();
        clearDisappearingChildren();
        if (this.mAdaWebview != null) {
            this.cm = null;
            setOnLongClickListener(null);
            this.mAdaWebview = null;
            this.mWebLoadEvent.destroy();
            this.mWebLoadEvent = null;
            this.mWebJsEvent.destroy();
            this.mWebJsEvent = null;
            this.webSettings = null;
            this.mContext = null;
        }
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
        for (int i = 0; i < getChildCount(); i++) {
            boolean zDispatchKeyEvent = getChildAt(i).dispatchKeyEvent(keyEvent);
            if (zDispatchKeyEvent) {
                return zDispatchKeyEvent;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean doKeyDownAction(int i, android.view.KeyEvent keyEvent) {
        io.dcloud.common.DHInterface.IKeyHandler iKeyHandler = (io.dcloud.common.DHInterface.IKeyHandler) this.mAdaWebview.getActivity();
        boolean zOnKeyEventExecute = keyEvent.getRepeatCount() == 0 ? iKeyHandler.onKeyEventExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyDown, i, keyEvent) : iKeyHandler.onKeyEventExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyDown, i, keyEvent);
        return zOnKeyEventExecute ? zOnKeyEventExecute : super.onKeyDown(i, keyEvent);
    }

    public boolean doKeyUpAction(int i, android.view.KeyEvent keyEvent) {
        boolean zOnKeyEventExecute = ((io.dcloud.common.DHInterface.IKeyHandler) this.mAdaWebview.getActivity()).onKeyEventExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyUp, i, keyEvent);
        return zOnKeyEventExecute ? zOnKeyEventExecute : super.onKeyUp(i, keyEvent);
    }

    long downloadFile(final android.content.Context context, final java.lang.String str, final java.lang.String str2, java.lang.String str3, java.lang.String str4, final io.dcloud.common.DHInterface.ILoadCallBack iLoadCallBack) {
        return io.dcloud.common.adapter.util.DownloadUtil.getInstance(context).startRequest(context, str3, str4, io.dcloud.common.adapter.util.DeviceInfo.sDeviceRootDir + "/Download/", str, new io.dcloud.common.DHInterface.ILoadCallBack() { // from class: io.dcloud.common.adapter.ui.webview.SysWebView.3
            @Override // io.dcloud.common.DHInterface.ILoadCallBack
            public java.lang.Object onCallBack(int i, android.content.Context context2, java.lang.Object obj) {
                io.dcloud.feature.internal.sdk.SDK.IntegratedMode integratedMode = io.dcloud.common.util.BaseInfo.sRuntimeMode;
                if (obj == null && i == -1 && context2 == null) {
                    android.content.Intent intent = new android.content.Intent();
                    io.dcloud.common.util.NotificationUtil.showNotification(context, str2, context.getString(io.dcloud.base.R.string.dcloud_common_download_failed) + com.taobao.weex.el.parse.Operators.SPACE_STR + str, intent, -1, -1, intent.hashCode(), true);
                    return null;
                }
                if (iLoadCallBack != null) {
                    java.lang.String strValueOf = java.lang.String.valueOf(obj);
                    java.lang.String mimeType = io.dcloud.common.util.PdrUtil.getMimeType(strValueOf);
                    if (strValueOf.startsWith(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL)) {
                        strValueOf = strValueOf.substring(7);
                    }
                    if (strValueOf.startsWith("content://")) {
                        strValueOf = io.dcloud.common.adapter.util.PlatformUtil.getFilePathFromContentUri(android.net.Uri.parse(strValueOf), context.getContentResolver());
                        mimeType = io.dcloud.common.util.PdrUtil.getMimeType(strValueOf);
                    }
                    if (io.dcloud.common.constant.AbsoluteConst.TRUE.equals(java.lang.String.valueOf(iLoadCallBack.onCallBack(0, context2, io.dcloud.common.util.LoadAppUtils.getDataAndTypeIntent(context, strValueOf, mimeType))))) {
                        return null;
                    }
                }
                if (integratedMode == null) {
                    java.lang.String strValueOf2 = java.lang.String.valueOf(obj);
                    java.lang.String mimeType2 = io.dcloud.common.util.PdrUtil.getMimeType(strValueOf2);
                    if (strValueOf2.startsWith(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL)) {
                        strValueOf2 = strValueOf2.substring(7);
                    }
                    if (strValueOf2.startsWith("content://")) {
                        strValueOf2 = io.dcloud.common.adapter.util.PlatformUtil.getFilePathFromContentUri(android.net.Uri.parse(strValueOf2), context.getContentResolver());
                        mimeType2 = io.dcloud.common.util.PdrUtil.getMimeType(strValueOf2);
                    }
                    java.io.File file = new java.io.File(strValueOf2);
                    android.content.Intent dataAndTypeIntent = io.dcloud.common.util.LoadAppUtils.getDataAndTypeIntent(context, strValueOf2, mimeType2);
                    if (file.exists() && file.getName().toLowerCase(java.util.Locale.ENGLISH).endsWith(io.dcloud.common.constant.StringConst.POINT_APP_EN)) {
                        try {
                            io.dcloud.common.adapter.util.PlatformUtil.APKInfo apkFileInfo = io.dcloud.common.adapter.util.PlatformUtil.getApkFileInfo(context, strValueOf2);
                            android.graphics.drawable.Drawable drawable = apkFileInfo.mIcon;
                            java.lang.String str5 = apkFileInfo.mAppName;
                            if (drawable instanceof android.graphics.drawable.BitmapDrawable) {
                                android.graphics.Bitmap bitmap = ((android.graphics.drawable.BitmapDrawable) drawable).getBitmap();
                                java.lang.String name = file.getName();
                                android.app.PendingIntent activity = android.os.Build.VERSION.SDK_INT >= 23 ? android.app.PendingIntent.getActivity(context, dataAndTypeIntent.hashCode(), dataAndTypeIntent, 1140850688) : android.app.PendingIntent.getActivity(context, dataAndTypeIntent.hashCode(), dataAndTypeIntent, 1073741824);
                                io.dcloud.common.util.NotificationUtil.createCustomNotification(context, str5 + com.taobao.weex.el.parse.Operators.SPACE_STR + context.getString(io.dcloud.base.R.string.dcloud_common_download_complete), bitmap, str5, name, dataAndTypeIntent.hashCode(), activity);
                                return null;
                            }
                        } catch (java.lang.Exception e) {
                            e.printStackTrace();
                        }
                    }
                    io.dcloud.common.util.NotificationUtil.showNotification(context, str2, str + com.taobao.weex.el.parse.Operators.SPACE_STR + context.getString(io.dcloud.base.R.string.dcloud_common_download_complete), dataAndTypeIntent, -1, -1, dataAndTypeIntent.hashCode(), true);
                }
                return null;
            }
        });
    }

    @Override // io.dcloud.common.adapter.ui.webview.DCWebView
    public void evalJSSync(java.lang.String str, final io.dcloud.common.DHInterface.ICallBack iCallBack) {
        if (str.startsWith(io.dcloud.common.constant.AbsoluteConst.PROTOCOL_JAVASCRIPT)) {
            try {
                evaluateJavascript(str, new android.webkit.ValueCallback<java.lang.String>() { // from class: io.dcloud.common.adapter.ui.webview.SysWebView.1
                    @Override // android.webkit.ValueCallback
                    public void onReceiveValue(java.lang.String str2) {
                        io.dcloud.common.DHInterface.ICallBack iCallBack2 = iCallBack;
                        if (iCallBack2 != null) {
                            iCallBack2.onCallBack(1, str2);
                        }
                    }
                });
            } catch (java.lang.Throwable th) {
                io.dcloud.common.adapter.util.Logger.e(TAG, "e.getMessage()==" + th.getMessage());
                super.loadUrl(str);
                if (iCallBack != null) {
                    iCallBack.onCallBack(1, null);
                }
            }
        }
    }

    @Override // io.dcloud.common.adapter.ui.webview.DCWebView
    public java.lang.String getBaseUrl() {
        return this.mBaseUrl;
    }

    @Override // io.dcloud.common.adapter.ui.webview.DCWebView
    public int getCacheMode() {
        return this.mCacheMode;
    }

    @Override // io.dcloud.common.adapter.ui.webview.DCWebView
    public java.lang.String getCookie(java.lang.String str) {
        android.webkit.CookieManager cookieManager = this.cm;
        if (cookieManager != null) {
            return cookieManager.getCookie(str);
        }
        return null;
    }

    @Override // io.dcloud.common.adapter.ui.webview.DCWebView
    public java.lang.String getPageTitle() {
        return this.mPageTitle;
    }

    @Override // io.dcloud.common.adapter.ui.webview.DCWebView
    public com.dcloud.android.v4.widget.IRefreshAble.OnRefreshListener getRefreshListener() {
        return this;
    }

    @Override // android.webkit.WebView, io.dcloud.common.adapter.ui.webview.DCWebView
    public float getScale() {
        return this.mScale;
    }

    @Override // io.dcloud.common.adapter.ui.webview.DCWebView
    public java.lang.String getUrlStr() {
        return this.mUrl;
    }

    @Override // io.dcloud.common.adapter.ui.webview.DCWebView
    public java.lang.String getUserAgentString() {
        return this.webSettings.getUserAgentString();
    }

    @Override // io.dcloud.common.adapter.ui.webview.DCWebView
    public android.view.ViewGroup getWebView() {
        return this;
    }

    @Override // io.dcloud.common.adapter.ui.webview.DCWebView
    public int getWebViewScrollY() {
        return getScrollY();
    }

    @Override // io.dcloud.common.adapter.ui.webview.DCWebView
    public void init() throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException {
        setOnLongClickListener(new android.view.View.OnLongClickListener() { // from class: io.dcloud.common.adapter.ui.webview.SysWebView.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(android.view.View view) {
                try {
                    io.dcloud.common.adapter.ui.AdaWebview adaWebview = io.dcloud.common.adapter.ui.webview.SysWebView.this.mAdaWebview;
                    if (adaWebview == null) {
                        return true;
                    }
                    if (adaWebview.mFrameView.getCircleRefreshView() == null || !io.dcloud.common.adapter.ui.webview.SysWebView.this.mAdaWebview.mFrameView.getCircleRefreshView().hasRefreshOperator()) {
                        return true ^ io.dcloud.common.adapter.ui.webview.SysWebView.this.mAdaWebview.mFrameView.obtainFrameOptions().isUserSelect;
                    }
                    return true;
                } catch (java.lang.Exception unused) {
                    return true;
                }
            }
        });
        if (!io.dcloud.common.adapter.ui.AdaWebview.setedWebViewData) {
            boolean zHasFile = io.dcloud.common.adapter.io.DHFile.hasFile();
            boolean z = java.lang.Boolean.parseBoolean(this.mAdaWebview.obtainApp().obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_USE_ENCRYPTION));
            boolean zIsUniAppAppid = io.dcloud.common.util.BaseInfo.isUniAppAppid(this.mAdaWebview.obtainApp());
            java.lang.String strObtainConfigProperty = this.mAdaWebview.obtainApp().obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_UNIAPP_CONTROL);
            boolean z2 = !zIsUniAppAppid;
            if (!android.text.TextUtils.isEmpty(strObtainConfigProperty) && zIsUniAppAppid && strObtainConfigProperty.equals(io.dcloud.common.constant.AbsoluteConst.UNI_V3)) {
                z2 = true;
            }
            if (zHasFile || (io.dcloud.common.util.BaseInfo.ISDEBUG && !z && z2)) {
                io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("android.webkit.WebView", "setWebContentsDebuggingEnabled", null, new java.lang.Class[]{java.lang.Boolean.TYPE}, new java.lang.Object[]{java.lang.Boolean.TRUE});
            } else {
                setWebViewData();
            }
            io.dcloud.common.adapter.ui.AdaWebview.setedWebViewData = true;
        }
        setDownloadListener(this);
        if (io.dcloud.common.adapter.util.DeviceInfo.sDeviceSdkVer >= 9) {
            this.mDeafaltOverScrollMode = getOverScrollMode();
        }
        try {
            android.webkit.CookieSyncManager.createInstance(this.mContext);
            android.webkit.CookieManager cookieManager = android.webkit.CookieManager.getInstance();
            this.cm = cookieManager;
            if (cookieManager != null) {
                io.dcloud.common.adapter.util.PlatformUtil.invokeMethod(android.webkit.CookieManager.class.getName(), "setAcceptThirdPartyCookies", this.cm, new java.lang.Class[]{android.webkit.WebView.class, java.lang.Boolean.TYPE}, new java.lang.Object[]{this, java.lang.Boolean.TRUE});
                this.cm.setAcceptCookie(true);
                this.cm.removeExpiredCookie();
                android.webkit.CookieSyncManager.getInstance().sync();
            }
        } catch (java.lang.Throwable th) {
            io.dcloud.common.adapter.util.Logger.e("WebViewImpl CookieManager.getInstance Exception =" + th);
        }
        this.mAdaWebview.obtainFrameView().onInit();
        io.dcloud.common.DHInterface.IApp iAppObtainApp = this.mAdaWebview.obtainFrameView().obtainApp();
        this.mBaseUrl = iAppObtainApp.obtainWebviewBaseUrl();
        setScrollBarStyle(33554432);
        java.lang.String str = io.dcloud.common.adapter.ui.AdaWebview.sCustomUserAgent;
        if (str != null) {
            this.webSettings.setUserAgentString(str);
        } else {
            initUserAgent(iAppObtainApp);
        }
        this.webSettings.setAllowFileAccess(false);
        io.dcloud.common.adapter.ui.webview.WebViewFactory.setFileAccess(this.webSettings, iAppObtainApp, true);
        this.webSettings.setDefaultTextEncodingName(com.dcloud.zxing2.common.StringUtils.GB2312);
        this.webSettings.setDisplayZoomControls(false);
        this.webSettings.setCacheMode(getCacheMode());
        this.webSettings.setLayoutAlgorithm(android.webkit.WebSettings.LayoutAlgorithm.NORMAL);
        this.webSettings.setSavePassword(false);
        this.webSettings.setSaveFormData(false);
        io.dcloud.common.adapter.ui.webview.WebViewFactory.openJSEnabled(this.webSettings, iAppObtainApp);
        boolean z3 = this.mAdaWebview.mFrameView.obtainFrameOptions().scalable;
        this.webSettings.supportZoom();
        this.webSettings.setBuiltInZoomControls(z3);
        this.webSettings.setSupportZoom(z3);
        this.webSettings.setUseWideViewPort(true);
        if (!android.os.Build.BRAND.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.MEIZU)) {
            this.webSettings.setLoadWithOverviewMode(true);
        }
        this.webSettings.setDatabasePath(this.mAdaWebview.obtainFrameView().obtainApp().obtainAppWebCachePath());
        this.webSettings.setDatabaseEnabled(true);
        if (io.dcloud.common.adapter.util.DeviceInfo.sDeviceSdkVer >= 7) {
            this.mContext.getSharedPreferences(this.mAdaWebview.obtainFrameView().obtainApp().obtainAppId(), 0).getLong("maxSize", 0L);
            this.webSettings.setDomStorageEnabled(true);
        }
        this.webSettings.setMediaPlaybackRequiresUserGesture(false);
        this.webSettings.setGeolocationEnabled(true);
        this.webSettings.setGeolocationDatabasePath(this.mAdaWebview.obtainFrameView().obtainApp().obtainAppWebCachePath());
        io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("android.webkit.WebSettings", "setMixedContentMode", this.webSettings, new java.lang.Class[]{java.lang.Integer.TYPE}, new java.lang.Object[]{0});
        io.dcloud.common.adapter.ui.webview.WebJsEvent webJsEvent = new io.dcloud.common.adapter.ui.webview.WebJsEvent(this.mAdaWebview);
        this.mWebJsEvent = webJsEvent;
        setWebChromeClient(webJsEvent);
        io.dcloud.common.adapter.ui.webview.WebLoadEvent webLoadEvent = new io.dcloud.common.adapter.ui.webview.WebLoadEvent(this.mAdaWebview);
        this.mWebLoadEvent = webLoadEvent;
        webLoadEvent.setPageFinishedCallack(this.mPageFinishedCallack);
        if (!io.dcloud.common.util.PdrUtil.isEmpty(this.mDcloudwebviewclientListener)) {
            webLoadEvent.setDcloudwebviewclientListener(this.mDcloudwebviewclientListener);
        }
        setWebViewClient(webLoadEvent);
        io.dcloud.common.adapter.ui.ReceiveJSValue.addJavascriptInterface(this.mAdaWebview);
        requestFocus();
        setClickable(true);
        removeUnSafeJavascriptInterface();
        applyWebViewDarkMode();
    }

    @Override // io.dcloud.common.adapter.ui.webview.DCWebView
    public void initScalable(boolean z) {
        this.webSettings.supportZoom();
        this.webSettings.setBuiltInZoomControls(z);
        this.webSettings.setSupportZoom(z);
        this.webSettings.setUseWideViewPort(true);
        if (android.os.Build.BRAND.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.MEIZU)) {
            return;
        }
        this.webSettings.setLoadWithOverviewMode(true);
    }

    void initUserAgent(io.dcloud.common.DHInterface.IApp iApp) {
        java.lang.String strObtainConfigProperty = iApp.obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_USER_AGENT);
        boolean z = java.lang.Boolean.parseBoolean(iApp.obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_CONCATENATE));
        boolean z2 = false;
        if (java.lang.Boolean.parseBoolean(iApp.obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_funSetUA))) {
            z = false;
        }
        if (z && java.lang.Boolean.parseBoolean(iApp.obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_H5PLUS))) {
            z2 = true;
        }
        if (io.dcloud.common.util.PdrUtil.isEmpty(io.dcloud.common.adapter.ui.AdaWebview.sDefalutUserAgent)) {
            io.dcloud.common.adapter.ui.AdaWebview.sDefalutUserAgent = this.webSettings.getUserAgentString();
            java.util.HashMap map = new java.util.HashMap(1);
            map.put("ua", io.dcloud.common.adapter.ui.AdaWebview.sDefalutUserAgent);
            io.dcloud.p.l.a(getContext(), iApp.obtainAppId(), "save", map);
        }
        this.mUserAgent = io.dcloud.common.adapter.ui.AdaWebview.sDefalutUserAgent;
        if (!z) {
            this.mUserAgent = strObtainConfigProperty;
        } else if (!android.text.TextUtils.isEmpty(strObtainConfigProperty)) {
            this.mUserAgent += com.taobao.weex.el.parse.Operators.SPACE_STR + strObtainConfigProperty.trim();
        }
        boolean z3 = java.lang.Boolean.parseBoolean(iApp.obtainConfigProperty(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR_IMMERSED));
        if (iApp.obtainStatusBarMgr() != null && iApp.obtainStatusBarMgr().checkImmersedStatusBar(this.mAdaWebview.getActivity(), z3)) {
            this.mUserAgent += (" (Immersed/" + (io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight / this.mScale) + com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
        }
        if (iApp.isUniApp() && z && !this.mUserAgent.contains("uni-app")) {
            this.mUserAgent += " uni-app";
        }
        if (z2 && !this.mUserAgent.contains(io.dcloud.common.adapter.ui.webview.DCWebView.UserAgentExtInfo)) {
            if (io.dcloud.common.util.BaseInfo.ISAMU && io.dcloud.common.util.BaseInfo.isBase(getContext())) {
                this.mUserAgent += " Html5Plus/1.0 StreamApp/1.0";
            } else {
                this.mUserAgent += io.dcloud.common.adapter.ui.webview.DCWebView.UserAgentExtInfo;
            }
        }
        io.dcloud.common.adapter.util.Logger.d(TAG, "userAgent=" + this.mUserAgent);
        if (this.mAdaWebview.obtainFrameView().getFrameType() != 6) {
            this.webSettings.setUserAgentString(this.mUserAgent);
        }
        dc.squareup.HttpConstants.setUA(this.mUserAgent);
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        try {
            if (getParent() != null) {
                float contentHeight = getContentHeight() * this.mScale;
                if (contentHeight > 0.0f) {
                    if ((contentHeight > getHeight() || (this.mAdaWebview.mProgress > 60 && contentHeight >= getHeight())) && !this.isToInvalidate) {
                        this.mAdaWebview.dispatchWebviewStateEvent(6, java.lang.Integer.valueOf(getContentHeight()));
                        this.mAdaWebview.mFrameView.dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENTS_RENDERING, java.lang.Integer.valueOf(getContentHeight()));
                        this.isToInvalidate = true;
                    }
                }
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public boolean isChildSpeciaView(float f, float f2) {
        if (this.mAdaWebview.mFrameView.checkITypeofAble()) {
            return false;
        }
        for (int i = 0; i < getChildCount(); i++) {
            android.view.KeyEvent.Callback childAt = getChildAt(i);
            if (childAt instanceof com.dcloud.android.widget.SlideLayout) {
                return false;
            }
            if (childAt instanceof io.dcloud.common.DHInterface.INativeView) {
                return true;
            }
            if (childAt instanceof io.dcloud.common.DHInterface.IVideoPlayer) {
                io.dcloud.common.DHInterface.IVideoPlayer iVideoPlayer = (io.dcloud.common.DHInterface.IVideoPlayer) childAt;
                if (!iVideoPlayer.isVideoHandleTouch() || iVideoPlayer.isPointInRect(f, f2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // io.dcloud.common.adapter.ui.webview.DCWebView
    public boolean isDidTouch() {
        return this.didTouch;
    }

    protected boolean isReadyForPullUp(int i) {
        int iFloor = ((int) java.lang.Math.floor(getContentHeight() * this.mScale)) - getHeight();
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        boolean z = (i >= iFloor || (i >= iFloor - this.mThreshold && jCurrentTimeMillis - this.mLastScrollTimestamp > ((long) this.mThresholdTime))) && this.mLastScrollY < this.mContentHeight;
        this.mLastScrollY = i;
        this.mContentHeight = iFloor;
        long j = jCurrentTimeMillis - this.mLastScrollTimestamp;
        if (j <= 500) {
            this.mLastScrollTimestamp = j;
        }
        return z;
    }

    @Override // io.dcloud.common.adapter.ui.webview.DCWebView
    public void listenPageFinishTimeout(java.lang.String str) {
        this.mWebLoadEvent.listenPageFinishTimeout(this, getUrlStr(), str);
    }

    @Override // android.webkit.WebView, io.dcloud.common.adapter.ui.webview.DCWebView
    public void loadUrl(java.lang.String str) {
        io.dcloud.common.adapter.ui.AdaWebview adaWebview = this.mAdaWebview;
        if (adaWebview == null || adaWebview.isDisposed()) {
            return;
        }
        if (!str.startsWith(io.dcloud.common.constant.AbsoluteConst.PROTOCOL_JAVASCRIPT)) {
            this.didTouch = false;
            java.util.HashMap<java.lang.String, java.lang.String> map = this.mUrlHeads.get(str);
            if (map != null) {
                super.loadUrl(str, map);
                return;
            } else {
                super.loadUrl(str);
                return;
            }
        }
        try {
            evaluateJavascript(str, null);
        } catch (java.lang.Throwable th) {
            io.dcloud.common.adapter.util.Logger.e(TAG, "e.getMessage()==" + th.getMessage());
            super.loadUrl(str);
        }
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (((io.dcloud.common.adapter.ui.AdaFrameView) this.mAdaWebview.obtainFrameView()).getCircleRefreshView() != null) {
            invalidate();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.webkit.WebView, android.view.View
    public android.view.inputmethod.InputConnection onCreateInputConnection(android.view.inputmethod.EditorInfo editorInfo) {
        android.view.inputmethod.InputConnection inputConnectionOnCreateInputConnection;
        io.dcloud.common.adapter.ui.CustomeizedInputConnection customeizedInputConnection;
        io.dcloud.common.adapter.util.Logger.e("AssistantInput", "onCreateInputConnection 00");
        try {
            inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            try {
                if (!io.dcloud.common.util.BaseInfo.AuxiliaryInput || inputConnectionOnCreateInputConnection == null) {
                    return inputConnectionOnCreateInputConnection;
                }
                customeizedInputConnection = new io.dcloud.common.adapter.ui.CustomeizedInputConnection(this.mAdaWebview, inputConnectionOnCreateInputConnection, editorInfo, io.dcloud.common.adapter.ui.AdaWebview.sCustomeizedInputConnection);
                try {
                    io.dcloud.common.adapter.ui.AdaWebview.sCustomeizedInputConnection = customeizedInputConnection;
                    return customeizedInputConnection;
                } catch (java.lang.Throwable th) {
                    th = th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                customeizedInputConnection = inputConnectionOnCreateInputConnection;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            inputConnectionOnCreateInputConnection = null;
        }
        th.printStackTrace();
        return customeizedInputConnection;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        io.dcloud.common.adapter.ui.webview.WebJsEvent webJsEvent = this.mWebJsEvent;
        if (webJsEvent != null) {
            webJsEvent.releaseDefaultVideoPoster();
        }
        if (((io.dcloud.common.adapter.ui.AdaFrameView) this.mAdaWebview.obtainFrameView()).getCircleRefreshView() == null || !((io.dcloud.common.adapter.ui.AdaFrameView) this.mAdaWebview.obtainFrameView()).getCircleRefreshView().isRefreshEnable()) {
            return;
        }
        ((io.dcloud.common.adapter.ui.AdaFrameView) this.mAdaWebview.obtainFrameView()).getCircleRefreshView().endRefresh();
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(final java.lang.String str, java.lang.String str2, java.lang.String str3, final java.lang.String str4, long j) {
        try {
            android.content.Context context = getContext();
            if (io.dcloud.common.adapter.util.DeviceInfo.sDeviceSdkVer <= 8) {
                android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
                intent.setData(android.net.Uri.parse(str));
                context.startActivity(intent);
                return;
            }
            if (context == null || !(context instanceof android.app.Activity)) {
                return;
            }
            final java.lang.String downloadFilename = io.dcloud.common.util.PdrUtil.getDownloadFilename(str3, str4, str);
            java.lang.String str5 = context.getString(io.dcloud.base.R.string.dcloud_common_download_do_file) + downloadFilename;
            if (0 < j) {
                str5 = str5 + "【" + new java.math.BigDecimal(j).divide(new java.math.BigDecimal(1048576L), 2, 4).floatValue() + "MB】";
            }
            io.dcloud.common.util.DialogUtil.showAlertDialog((android.app.Activity) context, str5, context.getString(io.dcloud.base.R.string.dcloud_common_download), context.getString(io.dcloud.base.R.string.dcloud_common_cancel), new android.view.View.OnClickListener() { // from class: io.dcloud.common.adapter.ui.webview.SysWebView.4
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view) {
                    io.dcloud.common.adapter.ui.webview.SysWebView sysWebView = io.dcloud.common.adapter.ui.webview.SysWebView.this;
                    sysWebView.downloadFile(sysWebView.getContext(), downloadFilename, io.dcloud.common.adapter.ui.webview.SysWebView.this.mAdaWebview.getAppName(), str, str4, null);
                }
            }, null, null, null, false, 0, 80, (int) (((double) context.getResources().getDisplayMetrics().widthPixels) * 0.9d));
        } catch (java.lang.Exception e) {
            io.dcloud.common.adapter.util.Logger.w("webview onDownloadStart", e);
            io.dcloud.common.adapter.util.Logger.e(TAG, "browser will download url=" + str);
            try {
                android.content.Intent intent2 = new android.content.Intent("android.intent.action.VIEW");
                intent2.setData(android.net.Uri.parse(str));
                this.mAdaWebview.getActivity().startActivity(intent2);
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        if (!isChildSpeciaView(motionEvent.getX(), motionEvent.getY())) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (actionMasked == 0) {
            this.mLastMotionY = rawY;
            this.mLastMotionX = rawX;
            this.mIsBeingDragged = false;
        } else if (actionMasked == 2) {
            float f = rawX - this.mLastMotionX;
            float f2 = rawY - this.mLastMotionY;
            if (java.lang.Math.abs(f2) > java.lang.Math.abs(f) && java.lang.Math.abs(f2) > 20.0f) {
                motionEvent.setAction(0);
                onTouchEvent(motionEvent);
                this.mIsBeingDragged = true;
            }
        }
        boolean z = this.mIsBeingDragged;
        return z ? z : super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        return io.dcloud.common.util.BaseInfo.USE_ACTIVITY_HANDLE_KEYEVENT ? super.onKeyDown(i, keyEvent) : doKeyDownAction(i, keyEvent);
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, android.view.KeyEvent keyEvent) {
        return io.dcloud.common.util.BaseInfo.USE_ACTIVITY_HANDLE_KEYEVENT ? super.onKeyUp(i, keyEvent) : doKeyUpAction(i, keyEvent);
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        io.dcloud.common.ui.blur.AppEventForBlurManager.onScrollChanged(i, i2);
    }

    @Override // io.dcloud.common.adapter.ui.webview.DCWebView
    public void onPageStarted() {
        this.isToInvalidate = false;
    }

    @Override // io.dcloud.common.adapter.ui.webview.DCWebView
    public void onPreloadJSContent(java.lang.String str) {
        this.mWebLoadEvent.onPreloadJSContent(this, this.mUrl, str);
    }

    @Override // io.dcloud.common.adapter.ui.webview.DCWebView, com.dcloud.android.v4.widget.IRefreshAble.OnRefreshListener
    public void onRefresh(int i) {
        this.mAdaWebview.mFrameView.dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENTS_PULL_DOWN_EVENT, java.lang.Integer.valueOf(i));
        this.mAdaWebview.mFrameView.dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENTS_PULL_TO_REFRESH, java.lang.Integer.valueOf(i));
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if ((i == i3 && i2 == i4) || this.mAdaWebview == null) {
            return;
        }
        if (!io.dcloud.common.adapter.util.AndroidResources.sIMEAlive && isReadyForPullUp(i2)) {
            io.dcloud.common.adapter.util.Logger.d("onPlusScrollBottom", "上拉事件  url=" + this.mAdaWebview.obtainUrl());
            this.mAdaWebview.executeScript(PLUSSCROLLBOTTOM_JS_TEMPLATE);
        }
        org.json.JSONObject jSONObject = this.mAdaWebview.mFrameView.obtainFrameOptions().titleNView;
        if (jSONObject != null && jSONObject.has("type") && "transparent".equals(jSONObject.optString("type"))) {
            int i5 = this.mAdaWebview.mFrameView.obtainFrameOptions().coverage;
            if (i5 >= i4 || i5 >= i2) {
                java.lang.Object titleNView = io.dcloud.common.util.TitleNViewUtil.getTitleNView(this.mAdaWebview.obtainFrameView().obtainWindowMgr(), this.mAdaWebview.obtainFrameView().obtainWebView(), this.mAdaWebview.obtainFrameView(), io.dcloud.common.util.TitleNViewUtil.getTitleNViewId(this.mAdaWebview.obtainFrameView()));
                if (titleNView instanceof io.dcloud.common.DHInterface.ITitleNView) {
                    io.dcloud.common.util.TitleNViewUtil.updateTitleNViewStatus((io.dcloud.common.DHInterface.ITitleNView) titleNView, this.mAdaWebview.obtainFrameView().obtainWebView(), i2, jSONObject, i5);
                }
            }
        }
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        this.didTouch = true;
        if (motionEvent.getAction() == 0) {
            this.mAdaWebview.mFrameView.dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENTS_WEBVIEW_ONTOUCH_START, java.lang.Integer.valueOf(getContentHeight()));
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // io.dcloud.common.adapter.ui.webview.DCWebView
    public void onUpdatePlusData(java.lang.String str) {
        this.mWebLoadEvent.onUpdatePlusData(this, getUrlStr(), str);
    }

    @Override // io.dcloud.common.adapter.ui.webview.DCWebView
    public void putHeads(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.String> map) {
        this.mUrlHeads.put(str, map);
    }

    @Override // io.dcloud.common.adapter.ui.webview.DCWebView
    public void removeAllCookie() {
        android.webkit.CookieManager cookieManager = this.cm;
        if (cookieManager != null) {
            cookieManager.removeAllCookie();
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        try {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                android.view.View childAt = getChildAt(childCount);
                if (childAt != ((io.dcloud.common.adapter.ui.AdaFrameView) this.mAdaWebview.obtainFrameView()).getCircleRefreshView()) {
                    removeView(childAt);
                }
            }
        } catch (java.lang.Exception unused) {
            super.removeAllViews();
            if (((io.dcloud.common.adapter.ui.AdaFrameView) this.mAdaWebview.obtainFrameView()).getCircleRefreshView() != null) {
                addView((android.view.View) ((io.dcloud.common.adapter.ui.AdaFrameView) this.mAdaWebview.obtainFrameView()).getCircleRefreshView(), -1, -1);
            }
        }
    }

    @Override // io.dcloud.common.adapter.ui.webview.DCWebView
    public void removeSessionCookie() {
        android.webkit.CookieManager cookieManager = this.cm;
        if (cookieManager != null) {
            cookieManager.removeSessionCookie();
        }
    }

    @Override // io.dcloud.common.adapter.ui.webview.DCWebView
    public void setBlockNetworkImage(boolean z) {
        this.webSettings.setBlockNetworkImage(z);
    }

    @Override // io.dcloud.common.adapter.ui.webview.DCWebView
    public void setCookie(java.lang.String str, java.lang.String str2) {
        android.webkit.CookieManager cookieManager = this.cm;
        if (cookieManager != null) {
            cookieManager.setAcceptCookie(true);
            this.cm.setCookie(str, str2);
            android.webkit.CookieSyncManager.getInstance().sync();
        }
    }

    @Override // io.dcloud.common.adapter.ui.webview.DCWebView
    public void setDcloudwebviewclientListener(io.dcloud.common.DHInterface.IDCloudWebviewClientListener iDCloudWebviewClientListener) {
        setDcloudwebviewclientListener(iDCloudWebviewClientListener);
    }

    @Override // io.dcloud.common.adapter.ui.webview.DCWebView
    public void setDidTouch(boolean z) {
        this.didTouch = z;
    }

    @Override // io.dcloud.common.adapter.ui.webview.DCWebView
    public void setPageTitle(java.lang.String str) {
        this.mPageTitle = str;
    }

    @Override // io.dcloud.common.adapter.ui.webview.DCWebView
    public void setUrlStr(java.lang.String str) {
        this.mUrl = str;
    }

    @Override // io.dcloud.common.adapter.ui.webview.DCWebView
    public void setUserAgentString(java.lang.String str) {
        this.webSettings.setUserAgentString(str);
    }

    @Override // io.dcloud.common.adapter.ui.webview.DCWebView
    public void setWebViewCacheMode(java.lang.String str) {
        if (str.equals("default")) {
            this.mCacheMode = -1;
        } else if (str.equals("cacheElseNetwork")) {
            this.mCacheMode = 1;
        } else if (str.equals("noCache")) {
            this.mCacheMode = 2;
        } else if (str.equals("cacheOnly")) {
            this.mCacheMode = 3;
        }
        this.webSettings.setCacheMode(this.mCacheMode);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(android.webkit.WebViewClient webViewClient) {
        if ((webViewClient instanceof io.dcloud.common.adapter.ui.webview.WebLoadEvent) || webViewClient == null) {
            super.setWebViewClient(webViewClient);
        }
    }

    @Override // android.view.View
    public java.lang.String toString() {
        java.lang.String str;
        java.lang.String str2 = this.mUrl;
        if (str2 == null || (str = this.mBaseUrl) == null) {
            return super.toString();
        }
        int iIndexOf = str2.indexOf(str);
        java.lang.String strSubstring = this.mUrl;
        if (iIndexOf >= 0) {
            strSubstring = strSubstring.substring(this.mBaseUrl.length());
        }
        return "<url=" + strSubstring + ">;<hashcode=" + hashCode() + com.taobao.weex.el.parse.Operators.G;
    }

    @Override // io.dcloud.common.adapter.ui.webview.DCWebView
    public void webReload(boolean z) {
        if (!z) {
            this.webSettings.setCacheMode(this.mCacheMode);
            return;
        }
        io.dcloud.common.adapter.ui.webview.WebLoadEvent webLoadEvent = this.mWebLoadEvent;
        if (webLoadEvent != null) {
            webLoadEvent.reset();
        }
        this.webSettings.setCacheMode(2);
    }

    @Override // android.view.View
    public android.view.ActionMode startActionMode(android.view.ActionMode.Callback callback) {
        return super.startActionMode(new io.dcloud.common.adapter.ui.webview.SysWebView.CustomizedSelectActionModeCallback(callback));
    }

    public SysWebView(android.content.Context context, io.dcloud.common.adapter.ui.AdaWebview adaWebview, io.dcloud.common.DHInterface.IDCloudWebviewClientListener iDCloudWebviewClientListener) {
        super(context);
        this.mUserAgent = null;
        this.mAdaWebview = null;
        this.mWebLoadEvent = null;
        this.mWebJsEvent = null;
        this.mUrl = null;
        this.mScale = 0.0f;
        this.mContext = null;
        this.mBaseUrl = null;
        this.webSettings = getSettings();
        this.cm = null;
        this.mLastScrollY = 0;
        this.mContentHeight = 0;
        this.mThreshold = 2;
        this.mThresholdTime = 15;
        this.mLastScrollTimestamp = 0L;
        this.mPageTitle = null;
        this.mDeafaltOverScrollMode = 0;
        this.mCacheMode = -1;
        this.didTouch = false;
        this.isToInvalidate = false;
        this.mUrlHeads = new java.util.HashMap<>();
        this.mEventY = 0;
        this.mEventX = 0;
        this.mTouchSlop = -1;
        this.mIsBeingDragged = true;
        this.mScale = getContext().getResources().getDisplayMetrics().density;
        io.dcloud.common.adapter.util.Logger.d("WebViewImpl");
        this.mContext = context.getApplicationContext();
        io.dcloud.common.util.BaseInfo.s_Webview_Count++;
        this.mAdaWebview = adaWebview;
        this.mDcloudwebviewclientListener = iDCloudWebviewClientListener;
    }

    public SysWebView(android.content.Context context, io.dcloud.common.adapter.ui.AdaWebview adaWebview, io.dcloud.common.adapter.ui.webview.OnPageFinishedCallack onPageFinishedCallack) {
        super(context);
        this.mUserAgent = null;
        this.mAdaWebview = null;
        this.mWebLoadEvent = null;
        this.mWebJsEvent = null;
        this.mUrl = null;
        this.mScale = 0.0f;
        this.mContext = null;
        this.mBaseUrl = null;
        this.webSettings = getSettings();
        this.cm = null;
        this.mLastScrollY = 0;
        this.mContentHeight = 0;
        this.mThreshold = 2;
        this.mThresholdTime = 15;
        this.mLastScrollTimestamp = 0L;
        this.mPageTitle = null;
        this.mDeafaltOverScrollMode = 0;
        this.mCacheMode = -1;
        this.didTouch = false;
        this.isToInvalidate = false;
        this.mUrlHeads = new java.util.HashMap<>();
        this.mEventY = 0;
        this.mEventX = 0;
        this.mTouchSlop = -1;
        this.mIsBeingDragged = true;
        io.dcloud.common.adapter.util.Logger.d("WebViewImpl");
        this.mContext = context.getApplicationContext();
        this.mAdaWebview = adaWebview;
        this.mPageFinishedCallack = onPageFinishedCallack;
        this.mScale = getContext().getResources().getDisplayMetrics().density;
    }
}
