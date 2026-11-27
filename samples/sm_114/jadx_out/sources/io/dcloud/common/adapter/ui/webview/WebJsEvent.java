package io.dcloud.common.adapter.ui.webview;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class WebJsEvent extends android.webkit.WebChromeClient {
    static final android.widget.FrameLayout.LayoutParams COVER_SCREEN_GRAVITY_CENTER = new android.widget.FrameLayout.LayoutParams(-1, -1, 17);
    public static final int FILECHOOSER_RESULTCODE = 1;
    static final java.lang.String TAG = "webview";
    io.dcloud.common.adapter.ui.FileChooseDialog dialog;
    io.dcloud.common.adapter.ui.AdaWebview mAdaWebview;
    android.view.View mCustomView;
    android.webkit.WebChromeClient.CustomViewCallback mCustomViewCallback;
    android.webkit.ValueCallback<android.net.Uri> mUploadMessage;
    android.webkit.ValueCallback<android.net.Uri[]> mUploadMessage21Level;
    private boolean rptJsErr;
    private boolean mScreemOrientationChanged = false;
    private boolean mDefaultTitleBarVisibility = false;
    private int mDefaultScreemOrientation = -2;
    io.dcloud.common.adapter.ui.webview.WebJsEvent.DialogListener mListener = null;
    private android.graphics.Bitmap mDefaultVideoPoster = null;
    private boolean isNeedCloseScreenWakelock = false;
    private int defaultSystemUI = 0;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class DialogListener implements android.content.DialogInterface.OnClickListener {
        android.webkit.JsResult mResult = null;

        DialogListener() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            this.mResult.cancel();
        }
    }

    public WebJsEvent(io.dcloud.common.adapter.ui.AdaWebview adaWebview) {
        this.rptJsErr = true;
        this.mAdaWebview = adaWebview;
        adaWebview.mProgressIntValue = 0;
        this.rptJsErr = io.dcloud.common.util.BaseInfo.getCmitInfo(io.dcloud.common.util.BaseInfo.sLastRunApp).rptJse;
    }

    private void handleConsoleMessage(android.webkit.ConsoleMessage consoleMessage) {
        if (this.mAdaWebview == null) {
            return;
        }
        java.lang.String strMessage = consoleMessage.message();
        if (isFilterConsoleMessage(strMessage)) {
            return;
        }
        int iLineNumber = consoleMessage.lineNumber();
        java.lang.String strSourceId = consoleMessage.sourceId();
        java.lang.String strName = consoleMessage.messageLevel().name();
        if (io.dcloud.common.util.PdrUtil.isEmpty(strSourceId)) {
            io.dcloud.common.util.AppConsoleLogUtil.DCLog(strMessage, strName);
            return;
        }
        try {
            strSourceId = this.mAdaWebview.getDCWebView().convertRelPath(strSourceId);
        } catch (java.lang.Exception unused) {
        }
        io.dcloud.common.util.AppConsoleLogUtil.DCLog(strMessage + " at " + strSourceId + ":" + iLineNumber, strName);
    }

    private void handleMessage(android.webkit.JsPromptResult jsPromptResult, io.dcloud.common.adapter.ui.AdaWebview adaWebview, java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z) {
        jsPromptResult.confirm(this.mAdaWebview.execScript(str, str2, io.dcloud.common.util.JSONUtil.createJSONArray(str3), z));
    }

    private void initUniLoadUrl() {
        if (this.mAdaWebview.isDisposed() || this.mAdaWebview.obtainApp() == null || !io.dcloud.common.util.BaseInfo.isUniAppAppid(this.mAdaWebview.obtainApp())) {
            return;
        }
        io.dcloud.common.util.BaseInfo.isWeexUniJs(this.mAdaWebview.obtainApp());
    }

    private boolean isCallbackId(java.lang.String str) {
        return str != null && str.startsWith(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_PLUS);
    }

    private boolean isFilterConsoleMessage(java.lang.String str) {
        if (io.dcloud.common.util.PdrUtil.isEmpty(str)) {
            return false;
        }
        return str.contains("viewport-fit") || str.contains("Ignored attempt to cancel a touchend event with cancelable=false");
    }

    private boolean isUrlWhiteListed(java.lang.String str) {
        return true;
    }

    private void openFileChooserLogic(android.webkit.ValueCallback<android.net.Uri> valueCallback, java.lang.String str, java.lang.String str2) {
        openFileChooserLogic(valueCallback, null, str, str2, null);
    }

    private void setStatusBarVisibility(android.app.Activity activity, boolean z) {
        if (z) {
            activity.getWindow().getDecorView().setSystemUiVisibility(this.defaultSystemUI);
        } else {
            this.defaultSystemUI = activity.getWindow().getDecorView().getSystemUiVisibility();
            activity.getWindow().getDecorView().setSystemUiVisibility(5894);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showOpenFileChooser(android.webkit.ValueCallback<android.net.Uri> valueCallback, android.webkit.ValueCallback<android.net.Uri[]> valueCallback2, java.lang.String str, java.lang.String str2, android.webkit.WebChromeClient.FileChooserParams fileChooserParams) {
        this.mUploadMessage = valueCallback;
        this.mUploadMessage21Level = valueCallback2;
        android.content.Intent intent = new android.content.Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        if (io.dcloud.common.util.PdrUtil.isEmpty(str)) {
            intent.setType("*/*");
        } else {
            intent.setType(str);
        }
        if (fileChooserParams != null && fileChooserParams.getMode() == 1) {
            intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        }
        this.dialog = new io.dcloud.common.adapter.ui.FileChooseDialog(this.mAdaWebview.getActivity(), this.mAdaWebview.getActivity(), intent);
        this.mAdaWebview.obtainFrameView().obtainApp().registerSysEventListener(new io.dcloud.common.DHInterface.ISysEventListener() { // from class: io.dcloud.common.adapter.ui.webview.WebJsEvent.10
            /* JADX WARN: Code duplicated, block: B:19:0x0063  */
            private android.net.Uri getUri(android.net.Uri uri) {
                android.net.Uri uri2;
                android.database.Cursor cursorQuery = io.dcloud.common.adapter.ui.webview.WebJsEvent.this.mAdaWebview.getContext().getContentResolver().query(uri, new java.lang.String[]{"_data"}, null, null, null);
                if (cursorQuery == null) {
                    return uri;
                }
                if (android.os.Build.VERSION.SDK_INT >= 29 || !cursorQuery.moveToFirst()) {
                    uri2 = uri;
                } else {
                    try {
                        int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("_data");
                        if (columnIndexOrThrow > -1) {
                            java.lang.String string = cursorQuery.getString(columnIndexOrThrow);
                            uri2 = android.net.Uri.parse(string);
                            try {
                                if (io.dcloud.common.util.PdrUtil.isEmpty(uri2.getScheme())) {
                                    uri2 = android.net.Uri.parse((string.startsWith("/") ? io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL : "file:///") + string);
                                }
                            } catch (java.lang.Exception unused) {
                            }
                        } else {
                            uri2 = uri;
                        }
                    } catch (java.lang.Exception unused2) {
                    }
                }
                cursorQuery.close();
                return uri2;
            }

            @Override // io.dcloud.common.DHInterface.ISysEventListener
            public boolean onExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj) {
                java.util.List<java.io.File> list;
                java.lang.Object[] objArr = (java.lang.Object[]) obj;
                int iIntValue = ((java.lang.Integer) objArr[0]).intValue();
                int iIntValue2 = ((java.lang.Integer) objArr[1]).intValue();
                io.dcloud.common.adapter.ui.FileChooseDialog fileChooseDialog = io.dcloud.common.adapter.ui.webview.WebJsEvent.this.dialog;
                if (fileChooseDialog != null) {
                    fileChooseDialog.dismiss();
                }
                io.dcloud.common.DHInterface.IApp iAppObtainApp = io.dcloud.common.adapter.ui.webview.WebJsEvent.this.mAdaWebview.obtainFrameView().obtainApp();
                io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType2 = io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onActivityResult;
                iAppObtainApp.unregisterSysEventListener(this, sysEventType2);
                if (iIntValue2 == 0 || sysEventType != sysEventType2) {
                    io.dcloud.common.adapter.ui.webview.WebJsEvent webJsEvent = io.dcloud.common.adapter.ui.webview.WebJsEvent.this;
                    android.webkit.ValueCallback<android.net.Uri[]> valueCallback3 = webJsEvent.mUploadMessage21Level;
                    if (valueCallback3 != null) {
                        valueCallback3.onReceiveValue(null);
                    } else {
                        android.webkit.ValueCallback<android.net.Uri> valueCallback4 = webJsEvent.mUploadMessage;
                        if (valueCallback4 != null) {
                            valueCallback4.onReceiveValue(null);
                        }
                    }
                    return false;
                }
                android.content.Intent intent2 = (android.content.Intent) objArr[2];
                java.util.ArrayList arrayList = new java.util.ArrayList();
                if (iIntValue != 1) {
                    if (iIntValue == 2 && (list = io.dcloud.common.adapter.ui.webview.WebJsEvent.this.dialog.uris) != null) {
                        for (java.io.File file : list) {
                            if (file.exists()) {
                                arrayList.add(androidx.core.content.FileProvider.getUriForFile(io.dcloud.common.adapter.ui.webview.WebJsEvent.this.mAdaWebview.getActivity(), io.dcloud.common.adapter.ui.webview.WebJsEvent.this.mAdaWebview.getActivity().getPackageName() + ".dc.fileprovider", file));
                                break;
                            }
                        }
                    }
                } else if (intent2.getClipData() != null) {
                    android.content.ClipData clipData = intent2.getClipData();
                    for (int i = 0; i < clipData.getItemCount(); i++) {
                        android.net.Uri uri = clipData.getItemAt(i).getUri();
                        if (uri != null && com.facebook.common.util.UriUtil.LOCAL_CONTENT_SCHEME.equals(uri.getScheme())) {
                            arrayList.add(getUri(uri));
                        }
                    }
                } else {
                    android.net.Uri data = intent2.getData();
                    if (data != null && com.facebook.common.util.UriUtil.LOCAL_CONTENT_SCHEME.equals(data.getScheme())) {
                        data = getUri(data);
                    }
                    arrayList.add(data);
                    io.dcloud.common.adapter.util.Logger.i(io.dcloud.common.adapter.ui.webview.WebJsEvent.TAG, "openFileChooserLogic  OnActivityResult url=" + data);
                }
                android.net.Uri[] uriArr = arrayList.size() > 0 ? (android.net.Uri[]) arrayList.toArray(new android.net.Uri[arrayList.size()]) : null;
                io.dcloud.common.adapter.ui.webview.WebJsEvent webJsEvent2 = io.dcloud.common.adapter.ui.webview.WebJsEvent.this;
                android.webkit.ValueCallback<android.net.Uri[]> valueCallback5 = webJsEvent2.mUploadMessage21Level;
                if (valueCallback5 != null) {
                    valueCallback5.onReceiveValue(uriArr);
                } else {
                    android.webkit.ValueCallback<android.net.Uri> valueCallback6 = webJsEvent2.mUploadMessage;
                    if (valueCallback6 != null) {
                        valueCallback6.onReceiveValue(arrayList.isEmpty() ? null : (android.net.Uri) arrayList.get(0));
                    }
                }
                return true;
            }
        }, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onActivityResult);
        try {
            this.dialog.show();
            this.dialog.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() { // from class: io.dcloud.common.adapter.ui.webview.WebJsEvent.11
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(android.content.DialogInterface dialogInterface) {
                    try {
                        io.dcloud.common.adapter.ui.webview.WebJsEvent webJsEvent = io.dcloud.common.adapter.ui.webview.WebJsEvent.this;
                        android.webkit.ValueCallback<android.net.Uri[]> valueCallback3 = webJsEvent.mUploadMessage21Level;
                        if (valueCallback3 != null) {
                            valueCallback3.onReceiveValue(null);
                            return;
                        }
                        android.webkit.ValueCallback<android.net.Uri> valueCallback4 = webJsEvent.mUploadMessage;
                        if (valueCallback4 != null) {
                            valueCallback4.onReceiveValue(null);
                        }
                    } catch (java.lang.Exception unused) {
                    }
                }
            });
        } catch (java.lang.Exception unused) {
            io.dcloud.common.adapter.util.Logger.e("openFileChooserLogic Exception");
        }
    }

    private void updateTitleNViewTitle(java.lang.String str) {
        java.lang.Object obj;
        org.json.JSONObject jSONObject = this.mAdaWebview.mFrameView.obtainFrameOptions().titleNView;
        if (jSONObject != null) {
            try {
                if (jSONObject.has("titleText")) {
                    obj = jSONObject.get("titleText");
                } else {
                    obj = jSONObject.has("titletext") ? jSONObject.get("titletext") : null;
                }
                if (obj == null || !(obj instanceof java.lang.String)) {
                    java.lang.String strOptString = jSONObject.optString("titleColor");
                    if (android.text.TextUtils.isEmpty(strOptString)) {
                        strOptString = jSONObject.optString("titlecolor");
                    }
                    java.lang.String strOptString2 = jSONObject.optString("titleSize");
                    if (android.text.TextUtils.isEmpty(strOptString2)) {
                        strOptString2 = jSONObject.optString("titlesize");
                    }
                    java.lang.String str2 = strOptString2;
                    java.lang.String strOptString3 = jSONObject.optString("titleOverflow");
                    java.lang.String strOptString4 = jSONObject.optString("titleAlign");
                    java.lang.String strOptString5 = jSONObject.optString("titleIcon");
                    java.lang.String strOptString6 = jSONObject.optString("titleIconRadius");
                    java.lang.String strOptString7 = jSONObject.optString("subtitleText");
                    java.lang.String strOptString8 = jSONObject.optString("subtitleColor");
                    java.lang.String strOptString9 = jSONObject.optString("subtitleSize");
                    java.lang.String strOptString10 = jSONObject.optString("subtitleOverflow");
                    java.lang.String strOptString11 = jSONObject.optString("titleIconWidth");
                    if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(strOptString) || android.text.TextUtils.isEmpty(str2)) {
                        return;
                    }
                    io.dcloud.common.DHInterface.AbsMgr absMgrObtainWindowMgr = this.mAdaWebview.mFrameView.obtainWindowMgr();
                    io.dcloud.common.DHInterface.IWebview iWebviewObtainWebView = this.mAdaWebview.mFrameView.obtainWebView();
                    io.dcloud.common.adapter.ui.AdaWebview adaWebview = this.mAdaWebview;
                    java.lang.Object titleNView = io.dcloud.common.util.TitleNViewUtil.getTitleNView(absMgrObtainWindowMgr, iWebviewObtainWebView, adaWebview.mFrameView, io.dcloud.common.util.TitleNViewUtil.getTitleNViewId(adaWebview.obtainFrameView()));
                    if (titleNView instanceof io.dcloud.common.DHInterface.ITitleNView) {
                        io.dcloud.common.DHInterface.ITitleNView iTitleNView = (io.dcloud.common.DHInterface.ITitleNView) titleNView;
                        if ("transparent".equals(jSONObject.optString("type")) && !android.text.TextUtils.isEmpty(strOptString) && android.graphics.Color.alpha(iTitleNView.getTitleColor()) == 0) {
                            strOptString = io.dcloud.common.util.TitleNViewUtil.changeColorAlpha(strOptString, 0.0f);
                        }
                        io.dcloud.common.util.TitleNViewUtil.drawTitle(this.mAdaWebview.mFrameView, iTitleNView, str, strOptString, str2, strOptString3, strOptString4, strOptString5, strOptString6, strOptString7, strOptString8, strOptString9, strOptString10, strOptString11);
                    }
                }
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void destroy() {
        this.mAdaWebview = null;
    }

    @Override // android.webkit.WebChromeClient
    public android.graphics.Bitmap getDefaultVideoPoster() {
        return super.getDefaultVideoPoster();
    }

    public void hideCustomView() {
        android.util.Log.d(TAG, "Hidding Custom View");
        if (this.mCustomView == null) {
            return;
        }
        if (this.mAdaWebview.obtainMainView() != null) {
            this.mAdaWebview.obtainMainView().setVisibility(0);
        }
        this.mCustomView.setVisibility(8);
        ((android.view.ViewGroup) this.mCustomView.getParent()).removeView(this.mCustomView);
        this.mCustomView = null;
        this.mCustomViewCallback.onCustomViewHidden();
        android.app.Activity activity = this.mAdaWebview.obtainApp() != null ? this.mAdaWebview.obtainApp().getActivity() : null;
        if (activity != null) {
            if (this.isNeedCloseScreenWakelock && this.mAdaWebview.obtainFrameView() != null && this.mAdaWebview.obtainFrameView().obtainWindowMgr() != null) {
                this.mAdaWebview.obtainFrameView().obtainWindowMgr().processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr, 1, new java.lang.Object[]{this.mAdaWebview, "device", "setWakelock", new org.json.JSONArray().put(false)});
            }
            io.dcloud.common.DHInterface.IApp iAppObtainApp = this.mAdaWebview.obtainApp();
            if (iAppObtainApp != null && iAppObtainApp.obtainStatusBarMgr() != null) {
                if (!iAppObtainApp.obtainStatusBarMgr().isFullScreenOrImmersive() || !iAppObtainApp.obtainStatusBarMgr().isFullScreen) {
                    setStatusBarVisibility(activity, true);
                }
                if (iAppObtainApp.obtainStatusBarMgr().isImmersive) {
                    iAppObtainApp.obtainStatusBarMgr().setImmersive(activity, true);
                }
            }
            if (this.mScreemOrientationChanged) {
                this.mScreemOrientationChanged = false;
                io.dcloud.common.adapter.ui.AdaWebview.ScreemOrientationChangedNeedLayout = true;
                activity.setRequestedOrientation(this.mDefaultScreemOrientation);
            }
            io.dcloud.common.DHInterface.IActivityHandler iActivityHandler = io.src.dcloud.adapter.DCloudAdapterUtil.getIActivityHandler(activity);
            if (iActivityHandler != null) {
                iActivityHandler.setSideBarVisibility(0);
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(android.webkit.ConsoleMessage consoleMessage) {
        handleConsoleMessage(consoleMessage);
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public void onExceededDatabaseQuota(java.lang.String str, java.lang.String str2, long j, long j2, long j3, android.webkit.WebStorage.QuotaUpdater quotaUpdater) {
        io.dcloud.common.adapter.util.Logger.i(TAG, "onExceededDatabaseQuota url=" + str);
        quotaUpdater.updateQuota(j2 * 2);
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        io.dcloud.common.adapter.util.Logger.i(TAG, "onGeolocationPermissionsHidePrompt");
        super.onGeolocationPermissionsHidePrompt();
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(final java.lang.String str, final android.webkit.GeolocationPermissions.Callback callback) {
        if (this.mAdaWebview == null) {
            return;
        }
        io.dcloud.common.adapter.util.Logger.i(TAG, "onGeolocationPermissionsShowPrompt origin=" + str);
        io.dcloud.common.DHInterface.IApp iAppObtainApp = this.mAdaWebview.obtainFrameView().obtainApp();
        if (iAppObtainApp != null) {
            io.dcloud.common.adapter.util.PermissionUtil.usePermission(this.mAdaWebview.getActivity(), "base", io.dcloud.common.adapter.util.PermissionUtil.PMS_LOCATION, 2, new io.dcloud.common.adapter.util.PermissionUtil.StreamPermissionRequest(iAppObtainApp) { // from class: io.dcloud.common.adapter.ui.webview.WebJsEvent.12
                @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
                public void onDenied(java.lang.String str2) {
                    callback.invoke(str, false, false);
                }

                @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
                public void onGranted(java.lang.String str2) {
                    callback.invoke(str, true, false);
                }
            });
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        hideCustomView();
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(android.webkit.WebView webView, java.lang.String str, java.lang.String str2, final android.webkit.JsResult jsResult) {
        io.dcloud.common.adapter.ui.AdaWebview adaWebview = this.mAdaWebview;
        if (adaWebview == null || io.dcloud.common.util.PdrUtil.isEmpty(adaWebview.getAppName())) {
            return super.onJsAlert(webView, str, str2, jsResult);
        }
        final android.app.AlertDialog alertDialogCreate = new android.app.AlertDialog.Builder(this.mAdaWebview.getActivity()).create();
        alertDialogCreate.setTitle(this.mAdaWebview.getAppName());
        alertDialogCreate.setMessage(str2);
        if (this.mListener == null) {
            this.mListener = new io.dcloud.common.adapter.ui.webview.WebJsEvent.DialogListener();
        }
        this.mListener.mResult = jsResult;
        alertDialogCreate.setButton(io.dcloud.common.adapter.util.AndroidResources.getString(android.R.string.ok), this.mListener);
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.setOnKeyListener(new android.content.DialogInterface.OnKeyListener() { // from class: io.dcloud.common.adapter.ui.webview.WebJsEvent.4
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(android.content.DialogInterface dialogInterface, int i, android.view.KeyEvent keyEvent) {
                if (keyEvent.getAction() != 1 || i != 4) {
                    return false;
                }
                jsResult.cancel();
                alertDialogCreate.dismiss();
                return true;
            }
        });
        alertDialogCreate.show();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(android.webkit.WebView webView, java.lang.String str, java.lang.String str2, android.webkit.JsResult jsResult) {
        return super.onJsBeforeUnload(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(android.webkit.WebView webView, java.lang.String str, java.lang.String str2, final android.webkit.JsResult jsResult) {
        io.dcloud.common.adapter.ui.AdaWebview adaWebview = this.mAdaWebview;
        if (adaWebview == null || io.dcloud.common.util.PdrUtil.isEmpty(adaWebview.getAppName())) {
            return super.onJsConfirm(webView, str, str2, jsResult);
        }
        try {
            final android.app.AlertDialog alertDialogCreate = new android.app.AlertDialog.Builder(this.mAdaWebview.getActivity()).create();
            alertDialogCreate.setMessage(str2);
            alertDialogCreate.setTitle(this.mAdaWebview.getAppName());
            alertDialogCreate.setButton(io.dcloud.common.adapter.util.AndroidResources.getString(android.R.string.ok), new android.content.DialogInterface.OnClickListener() { // from class: io.dcloud.common.adapter.ui.webview.WebJsEvent.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(android.content.DialogInterface dialogInterface, int i) {
                    jsResult.confirm();
                }
            });
            alertDialogCreate.setButton2(io.dcloud.common.adapter.util.AndroidResources.getString(android.R.string.cancel), new android.content.DialogInterface.OnClickListener() { // from class: io.dcloud.common.adapter.ui.webview.WebJsEvent.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(android.content.DialogInterface dialogInterface, int i) {
                    jsResult.cancel();
                }
            });
            alertDialogCreate.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() { // from class: io.dcloud.common.adapter.ui.webview.WebJsEvent.7
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(android.content.DialogInterface dialogInterface) {
                    jsResult.cancel();
                }
            });
            alertDialogCreate.setOnKeyListener(new android.content.DialogInterface.OnKeyListener() { // from class: io.dcloud.common.adapter.ui.webview.WebJsEvent.8
                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(android.content.DialogInterface dialogInterface, int i, android.view.KeyEvent keyEvent) {
                    if (keyEvent.getAction() != 0 || i != 4) {
                        return false;
                    }
                    jsResult.cancel();
                    alertDialogCreate.dismiss();
                    return true;
                }
            });
            alertDialogCreate.show();
            return true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return super.onJsConfirm(webView, str, str2, jsResult);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(android.webkit.WebView webView, java.lang.String str, java.lang.String str2, java.lang.String str3, final android.webkit.JsPromptResult jsPromptResult) {
        java.lang.String str4;
        java.lang.CharSequence charSequence;
        boolean z;
        if (this.mAdaWebview == null) {
            return false;
        }
        boolean zIsUrlWhiteListed = isUrlWhiteListed(str);
        if (zIsUrlWhiteListed && str3 != null && str3.length() > 3 && str3.substring(0, 4).equals("pdr:")) {
            try {
                org.json.JSONArray jSONArray = new org.json.JSONArray(str3.substring(4));
                try {
                    charSequence = "\\\"";
                    z = true;
                    z = true;
                    str4 = str2;
                    try {
                        handleMessage(jsPromptResult, this.mAdaWebview, jSONArray.getString(0), jSONArray.getString(1), str4, jSONArray.getBoolean(2));
                    } catch (org.json.JSONException e) {
                        e = e;
                        if (io.dcloud.common.util.PdrUtil.isEquals(str3, str3.replace(charSequence, io.dcloud.common.util.JSUtil.QUOTE))) {
                            e.printStackTrace();
                            io.dcloud.common.adapter.util.Logger.e(TAG, "onJsPrompt js->native message=" + str4 + ";defaultValue=" + str3);
                        } else {
                            java.lang.String strReplace = str4.replace(charSequence, io.dcloud.common.util.JSUtil.QUOTE);
                            java.lang.String strSubstring = strReplace.substring(z ? 1 : 0, strReplace.length() - (z ? 1 : 0));
                            java.lang.String strSubstring2 = str3.replace(charSequence, io.dcloud.common.util.JSUtil.QUOTE).substring(4);
                            onJsPrompt(webView, str, strSubstring, "pdr:" + strSubstring2.substring(z ? 1 : 0, strSubstring2.length() - (z ? 1 : 0)), jsPromptResult);
                        }
                    }
                } catch (org.json.JSONException e2) {
                    e = e2;
                    charSequence = "\\\"";
                    z = true;
                    str4 = str2;
                }
            } catch (org.json.JSONException e3) {
                e = e3;
                str4 = str2;
                charSequence = "\\\"";
                z = true;
            }
            return z;
        }
        if (this.mAdaWebview.mReceiveJSValue_android42 == null || !zIsUrlWhiteListed || str3 == null || str3.length() <= 5 || !str3.substring(0, 5).equals("sync:")) {
            final android.app.AlertDialog alertDialogCreate = new android.app.AlertDialog.Builder(this.mAdaWebview.getActivity()).create();
            alertDialogCreate.setMessage(str2);
            alertDialogCreate.setTitle(this.mAdaWebview.getAppName());
            final android.widget.EditText editText = new android.widget.EditText(this.mAdaWebview.getActivity());
            if (str3 != null) {
                editText.setText(str3);
                editText.setSelection(0, str3.length());
                io.dcloud.common.adapter.util.DeviceInfo.showIME(editText);
            }
            alertDialogCreate.setView(editText);
            alertDialogCreate.setButton(io.dcloud.common.adapter.util.AndroidResources.getString(android.R.string.ok), new android.content.DialogInterface.OnClickListener() { // from class: io.dcloud.common.adapter.ui.webview.WebJsEvent.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(android.content.DialogInterface dialogInterface, int i) {
                    jsPromptResult.confirm(editText.getText().toString());
                }
            });
            alertDialogCreate.setButton2(io.dcloud.common.adapter.util.AndroidResources.getString(android.R.string.cancel), new android.content.DialogInterface.OnClickListener() { // from class: io.dcloud.common.adapter.ui.webview.WebJsEvent.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(android.content.DialogInterface dialogInterface, int i) {
                    jsPromptResult.cancel();
                }
            });
            alertDialogCreate.setOnKeyListener(new android.content.DialogInterface.OnKeyListener() { // from class: io.dcloud.common.adapter.ui.webview.WebJsEvent.3
                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(android.content.DialogInterface dialogInterface, int i, android.view.KeyEvent keyEvent) {
                    if (io.dcloud.common.adapter.util.AndroidResources.sIMEAlive || keyEvent.getAction() != 0 || i != 4) {
                        return false;
                    }
                    alertDialogCreate.dismiss();
                    jsPromptResult.cancel();
                    return true;
                }
            });
            alertDialogCreate.show();
            return true;
        }
        try {
            org.json.JSONArray jSONArray2 = new org.json.JSONArray(str3.substring(5));
            jsPromptResult.confirm(this.mAdaWebview.mReceiveJSValue_android42.__js__call__native__(jSONArray2.getString(0), jSONArray2.getString(1)));
        } catch (org.json.JSONException e4) {
            if (io.dcloud.common.util.PdrUtil.isEquals(str3, str3.replace("\\\"", io.dcloud.common.util.JSUtil.QUOTE))) {
                e4.printStackTrace();
                io.dcloud.common.adapter.util.Logger.e(TAG, "onJsPrompt js->native message=" + str2 + ";defaultValue=" + str3);
            } else {
                java.lang.String strReplace2 = str2.replace("\\\"", io.dcloud.common.util.JSUtil.QUOTE);
                java.lang.String strSubstring3 = strReplace2.substring(1, strReplace2.length() - 1);
                java.lang.String strSubstring4 = str3.replace("\\\"", io.dcloud.common.util.JSUtil.QUOTE).substring(4);
                onJsPrompt(webView, str, strSubstring3, "pdr:" + strSubstring4.substring(1, strSubstring4.length() - 1), jsPromptResult);
            }
        }
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequest(android.webkit.PermissionRequest permissionRequest) {
        permissionRequest.grant(permissionRequest.getResources());
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(android.webkit.WebView webView, int i) {
        io.dcloud.common.adapter.ui.AdaWebview adaWebview = this.mAdaWebview;
        if (adaWebview == null) {
            return;
        }
        if (i < 20 && !adaWebview.unReceiveTitle) {
            adaWebview.unReceiveTitle = true;
        }
        adaWebview.mProgressIntValue = i;
        adaWebview.dispatchWebviewStateEvent(3, java.lang.Integer.valueOf(i));
        this.mAdaWebview.mFrameView.dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENTS_PROGRESS_CHANGED, java.lang.Integer.valueOf(i));
        super.onProgressChanged(webView, i);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(android.webkit.WebView webView, java.lang.String str) {
        io.dcloud.common.adapter.ui.AdaWebview adaWebview = this.mAdaWebview;
        if (adaWebview == null) {
            return;
        }
        adaWebview.unReceiveTitle = false;
        adaWebview.dispatchWebviewStateEvent(4, str);
        this.mAdaWebview.mFrameView.dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENTS_TITLE_UPDATE, str);
        this.mAdaWebview.getDCWebView().setPageTitle(str);
        io.dcloud.common.adapter.util.Logger.i(TAG, "onReceivedTitle title=" + str);
        this.mAdaWebview.mLoadCompleted = true;
        updateTitleNViewTitle(str);
        initUniLoadUrl();
        super.onReceivedTitle(webView, str);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTouchIconUrl(android.webkit.WebView webView, java.lang.String str, boolean z) {
        io.dcloud.common.adapter.util.Logger.d("super.onReceivedTouchIconUrl(view, url, precomposed");
        super.onReceivedTouchIconUrl(webView, str, z);
    }

    @Override // android.webkit.WebChromeClient
    public void onRequestFocus(android.webkit.WebView webView) {
        io.dcloud.common.adapter.util.Logger.i(TAG, "onRequestFocus");
        super.onRequestFocus(webView);
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(android.view.View view, android.webkit.WebChromeClient.CustomViewCallback customViewCallback) {
        showCustomView(view, customViewCallback);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(android.webkit.WebView webView, android.webkit.ValueCallback<android.net.Uri[]> valueCallback, android.webkit.WebChromeClient.FileChooserParams fileChooserParams) {
        openFileChooserLogic(null, valueCallback, fileChooserParams.getAcceptTypes() != null ? fileChooserParams.getAcceptTypes()[0] : null, "", fileChooserParams);
        return true;
    }

    public void openFileChooser(android.webkit.ValueCallback<android.net.Uri> valueCallback) {
        openFileChooserLogic(valueCallback, null, null);
    }

    public void releaseDefaultVideoPoster() {
        android.graphics.Bitmap bitmap = this.mDefaultVideoPoster;
        if (bitmap != null) {
            bitmap.recycle();
            this.mDefaultVideoPoster = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void showCustomView(android.view.View view, android.webkit.WebChromeClient.CustomViewCallback customViewCallback) {
        android.view.View childAt;
        android.util.Log.d(TAG, "showing Custom View");
        if (this.mCustomView != null) {
            customViewCallback.onCustomViewHidden();
            return;
        }
        view.setBackgroundDrawable(io.dcloud.common.adapter.util.CanvasHelper.getDrawable());
        if (io.dcloud.common.adapter.util.DeviceInfo.sModel.equals("HUAWEI MT1-U06") || io.dcloud.common.adapter.util.DeviceInfo.sModel.equals("SM-T310") || io.dcloud.common.adapter.util.DeviceInfo.sModel.equals("vivo Y51A")) {
            this.mAdaWebview.obtainFrameView().obtainApp().registerSysEventListener(new io.dcloud.common.DHInterface.ISysEventListener() { // from class: io.dcloud.common.adapter.ui.webview.WebJsEvent.13
                @Override // io.dcloud.common.DHInterface.ISysEventListener
                public boolean onExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj) {
                    io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType2 = io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyUp;
                    if (sysEventType != sysEventType2 || ((java.lang.Integer) ((java.lang.Object[]) obj)[0]).intValue() != 4) {
                        return false;
                    }
                    io.dcloud.common.adapter.ui.webview.WebJsEvent.this.onHideCustomView();
                    io.dcloud.common.adapter.ui.webview.WebJsEvent.this.mAdaWebview.obtainFrameView().obtainApp().unregisterSysEventListener(this, sysEventType2);
                    return true;
                }
            }, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyUp);
        }
        this.mCustomView = view;
        android.widget.FrameLayout frameLayoutObtainActivityContentView = null;
        int requestedOrientation = 0;
        if (!(view instanceof android.view.ViewGroup) || ((android.view.ViewGroup) view).getChildCount() <= 0) {
            childAt = null;
        } else {
            childAt = ((android.view.ViewGroup) this.mCustomView).getChildAt(0);
            if (childAt instanceof android.view.ViewGroup) {
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) childAt;
                if (viewGroup.getChildCount() > 0) {
                    childAt = viewGroup.getChildAt(0);
                }
            }
        }
        if (childAt != null) {
            android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
            layoutParams.setMargins(0, 0, 0, 0);
            layoutParams.gravity = 17;
            childAt.setPadding(0, 0, 0, 0);
            childAt.setLayoutParams(layoutParams);
            childAt.invalidate();
        }
        this.mCustomViewCallback = customViewCallback;
        android.app.Activity activity = this.mAdaWebview.obtainApp().getActivity();
        if (this.mAdaWebview.obtainFrameView() != null && this.mAdaWebview.obtainFrameView().obtainWindowMgr() != null) {
            io.dcloud.common.DHInterface.AbsMgr absMgrObtainWindowMgr = this.mAdaWebview.obtainFrameView().obtainWindowMgr();
            io.dcloud.common.DHInterface.IMgr.MgrType mgrType = io.dcloud.common.DHInterface.IMgr.MgrType.FeatureMgr;
            java.lang.Object objProcessEvent = absMgrObtainWindowMgr.processEvent(mgrType, 1, new java.lang.Object[]{this.mAdaWebview, "device", "__isWakelockNative__", new org.json.JSONArray()});
            if (!(objProcessEvent instanceof java.lang.String ? java.lang.Boolean.valueOf(java.lang.String.valueOf(objProcessEvent)).booleanValue() : false)) {
                this.isNeedCloseScreenWakelock = true;
                this.mAdaWebview.obtainFrameView().obtainWindowMgr().processEvent(mgrType, 1, new java.lang.Object[]{this.mAdaWebview, "device", "setWakelock", new org.json.JSONArray().put(true)});
            }
        }
        if (activity != 0) {
            io.dcloud.common.DHInterface.IActivityHandler iActivityHandler = io.src.dcloud.adapter.DCloudAdapterUtil.getIActivityHandler(activity);
            if (iActivityHandler != null) {
                frameLayoutObtainActivityContentView = iActivityHandler.obtainActivityContentView();
                iActivityHandler.closeSideBar();
                iActivityHandler.setSideBarVisibility(8);
            } else if (activity instanceof io.dcloud.common.DHInterface.IActivityDelegate) {
                frameLayoutObtainActivityContentView = ((io.dcloud.common.DHInterface.IActivityDelegate) activity).obtainActivityContentView();
            }
        }
        if (frameLayoutObtainActivityContentView != null) {
            frameLayoutObtainActivityContentView.addView(view, COVER_SCREEN_GRAVITY_CENTER);
            this.mAdaWebview.obtainMainView().setVisibility(8);
            setStatusBarVisibility(activity, false);
            java.lang.String webviewProperty = this.mAdaWebview.getWebviewProperty(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_VIDEO_FULL_SCREEN);
            if ("landscape".equals(webviewProperty)) {
                requestedOrientation = 6;
            } else if (!"landscape-primary".equals(webviewProperty)) {
                if ("landscape-secondary".equals(webviewProperty)) {
                    requestedOrientation = 8;
                } else if ("portrait-primary".equals(webviewProperty)) {
                    requestedOrientation = 1;
                } else {
                    requestedOrientation = "portrait-secondary".equals(webviewProperty) ? 9 : activity.getRequestedOrientation();
                }
            }
            if (activity.getRequestedOrientation() != requestedOrientation) {
                if (-2 == this.mDefaultScreemOrientation) {
                    this.mDefaultScreemOrientation = activity.getRequestedOrientation();
                }
                this.mScreemOrientationChanged = true;
                io.dcloud.common.adapter.ui.AdaWebview.ScreemOrientationChangedNeedLayout = true;
                activity.setRequestedOrientation(requestedOrientation);
            }
        }
    }

    private void openFileChooserLogic(final android.webkit.ValueCallback<android.net.Uri> valueCallback, final android.webkit.ValueCallback<android.net.Uri[]> valueCallback2, final java.lang.String str, final java.lang.String str2, final android.webkit.WebChromeClient.FileChooserParams fileChooserParams) {
        io.dcloud.common.adapter.ui.AdaWebview adaWebview = this.mAdaWebview;
        if (adaWebview == null) {
            return;
        }
        io.dcloud.common.adapter.util.PermissionUtil.usePermission(adaWebview.getActivity(), "base", io.dcloud.common.adapter.util.PermissionUtil.PMS_STORAGE, 2, new io.dcloud.common.adapter.util.PermissionUtil.Request() { // from class: io.dcloud.common.adapter.ui.webview.WebJsEvent.9
            @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
            public void onDenied(java.lang.String str3) {
            }

            @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
            public void onGranted(java.lang.String str3) {
                io.dcloud.common.adapter.ui.webview.WebJsEvent.this.showOpenFileChooser(valueCallback, valueCallback2, str, str2, fileChooserParams);
            }
        });
    }

    public void openFileChooser(android.webkit.ValueCallback<android.net.Uri> valueCallback, java.lang.String str) {
        openFileChooserLogic(valueCallback, str, null);
    }

    public void openFileChooser(android.webkit.ValueCallback<android.net.Uri> valueCallback, java.lang.String str, java.lang.String str2) {
        openFileChooserLogic(valueCallback, str, str2);
    }
}
