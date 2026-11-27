package io.dcloud.feature.ui.navigator;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class NavigatorUIFeatureImpl implements io.dcloud.common.DHInterface.IFeature {
    io.dcloud.common.DHInterface.AbsMgr a;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a extends io.dcloud.common.adapter.util.PermissionUtil.StreamPermissionRequest {
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview a;
        final /* synthetic */ java.lang.String[] b;
        final /* synthetic */ io.dcloud.common.DHInterface.IApp c;
        final /* synthetic */ java.lang.String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(io.dcloud.common.DHInterface.IApp iApp, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String[] strArr, io.dcloud.common.DHInterface.IApp iApp2, java.lang.String str) {
            super(iApp);
            this.a = iWebview;
            this.b = strArr;
            this.c = iApp2;
            this.d = str;
        }

        @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
        public void onDenied(java.lang.String str) {
        }

        @Override // io.dcloud.common.adapter.util.PermissionUtil.Request
        public void onGranted(java.lang.String str) {
            io.dcloud.feature.ui.navigator.NavigatorUIFeatureImpl.this.a(this.a, this.b, this.c, this.d);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b implements io.dcloud.common.DHInterface.ISysEventListener {
        final /* synthetic */ int a;
        final /* synthetic */ io.dcloud.common.DHInterface.IApp b;
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview c;
        final /* synthetic */ java.lang.String d;
        final /* synthetic */ java.lang.String e;

        b(int i, io.dcloud.common.DHInterface.IApp iApp, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2) {
            this.a = i;
            this.b = iApp;
            this.c = iWebview;
            this.d = str;
            this.e = str2;
        }

        @Override // io.dcloud.common.DHInterface.ISysEventListener
        public boolean onExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj) {
            java.lang.Object[] objArr = (java.lang.Object[]) obj;
            int iIntValue = ((java.lang.Integer) objArr[0]).intValue();
            int[] iArr = (int[]) objArr[2];
            io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType2 = io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onRequestPermissionsResult;
            if (sysEventType2 == sysEventType && iIntValue == this.a) {
                this.b.unregisterSysEventListener(this, sysEventType2);
                io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.c, this.e, io.dcloud.common.util.StringUtil.format("{result:'%s'}", io.dcloud.common.adapter.util.PermissionUtil.convert5PlusValue(iArr.length > 0 ? iArr[0] : this.c.obtainApp().checkSelfPermission(this.d, this.c.obtainApp().obtainAppName()))), io.dcloud.common.util.JSUtil.OK, true, false);
            }
            return true;
        }
    }

    private void b(android.content.Context context, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2) {
        java.lang.String str3;
        java.lang.String strRequestShortCut = io.dcloud.common.util.ShortCutUtil.requestShortCut(context, str2);
        if (io.dcloud.common.util.ShortCutUtil.SHORT_CUT_EXISTING.equals(strRequestShortCut)) {
            str3 = io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_SHORTCUT_RESULT_INFO, "existing");
        } else if (io.dcloud.common.util.ShortCutUtil.SHORT_CUT_NONE.equals(strRequestShortCut)) {
            str3 = io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_SHORTCUT_RESULT_INFO, "none");
        } else {
            str3 = io.dcloud.common.util.ShortCutUtil.NOPERMISSIONS.equals(strRequestShortCut) ? io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_SHORTCUT_RESULT_INFO, io.dcloud.common.util.ShortCutUtil.NOPERMISSIONS) : io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_SHORTCUT_RESULT_INFO, "unknown");
        }
        try {
            io.dcloud.common.util.JSUtil.execCallback(iWebview, str, new org.json.JSONObject(str3), io.dcloud.common.util.JSUtil.OK, false);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void dispose(java.lang.String str) {
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public java.lang.String execute(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String[] strArr) {
        int i;
        int iStringToColor;
        io.dcloud.common.DHInterface.IApp iAppObtainApp = iWebview.obtainApp();
        java.lang.String strObtainAppId = iAppObtainApp.obtainAppId();
        str.getClass();
        str.hashCode();
        switch (str) {
            case "getOrientation":
                try {
                    int rotation = iWebview.getActivity().getWindowManager().getDefaultDisplay().getRotation();
                    if (rotation == 1) {
                        i = 90;
                    } else if (rotation != 2) {
                        i = rotation != 3 ? 0 : -90;
                    } else {
                        i = 180;
                    }
                    return io.dcloud.common.util.JSUtil.wrapJsVar(i);
                } catch (java.lang.Exception unused) {
                    return io.dcloud.common.util.JSUtil.wrapJsVar(0.0f);
                }
            case "hideSystemNavigation":
                android.view.Window window = iAppObtainApp.getActivity().getWindow();
                window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 4866);
                iWebview.obtainApp().setHideNavBarState(true);
                return null;
            case "updateSplashscreen":
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject(strArr[0]);
                    android.content.SharedPreferences.Editor editorEdit = io.dcloud.common.adapter.util.SP.getOrCreateBundle(iWebview.getContext(), "pdr").edit();
                    java.lang.String strObtainAppId2 = iAppObtainApp.obtainAppId();
                    java.lang.String strOptString = jSONObject.optString("image", null);
                    if (!android.text.TextUtils.isEmpty(strOptString)) {
                        java.lang.String strConvert2AbsFullPath = iAppObtainApp.convert2AbsFullPath(iWebview.obtainFullUrl(), strOptString);
                        if (io.dcloud.common.util.PdrUtil.isDeviceRootDir(strConvert2AbsFullPath)) {
                            io.dcloud.common.adapter.io.DHFile.copyFile(strConvert2AbsFullPath, io.dcloud.common.constant.StringConst.STREAMAPP_KEY_ROOTPATH + "splash/" + iAppObtainApp.obtainAppId() + ".png", true, false);
                        }
                        editorEdit.putString(io.dcloud.common.adapter.util.SP.UPDATE_SPLASH_IMG_PATH, strConvert2AbsFullPath);
                    }
                    if (!jSONObject.isNull(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_AUTOCLOSE)) {
                        editorEdit.putBoolean(strObtainAppId2 + io.dcloud.common.adapter.util.SP.UPDATE_SPLASH_AUTOCLOSE, jSONObject.optBoolean(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_AUTOCLOSE));
                    }
                    if (!jSONObject.isNull(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_DELAY)) {
                        editorEdit.putInt(strObtainAppId2 + io.dcloud.common.adapter.util.SP.UPDATE_SPLASH_DELAY, jSONObject.optInt(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_DELAY));
                    }
                    if (io.dcloud.common.util.BaseInfo.isWap2AppAppid(strObtainAppId2)) {
                        if (!jSONObject.isNull(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_AUTOCLOSE_W2A)) {
                            editorEdit.putBoolean(strObtainAppId2 + io.dcloud.common.adapter.util.SP.UPDATE_SPLASH_AUTOCLOSE_W2A, jSONObject.optBoolean(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_AUTOCLOSE_W2A));
                        }
                        if (!jSONObject.isNull(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_DELAY_W2A)) {
                            editorEdit.putInt(strObtainAppId2 + io.dcloud.common.adapter.util.SP.UPDATE_SPLASH_DELAY_W2A, jSONObject.optInt(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_DELAY_W2A));
                        }
                    }
                    editorEdit.commit();
                    return null;
                } catch (org.json.JSONException e) {
                    e.printStackTrace();
                    return null;
                }
            case "hasShortcut":
                io.dcloud.common.util.AppRuntime.checkPrivacyComplianceAndPrompt(iWebview.getContext(), "Navigator-" + str);
                java.lang.String str2 = strArr[0];
                java.lang.String str3 = strArr[1];
                java.lang.String strObtainAppName = iWebview.obtainApp().obtainAppName();
                try {
                    strObtainAppName = new org.json.JSONObject(str2).optString("name", strObtainAppName);
                    break;
                } catch (org.json.JSONException e2) {
                    e2.printStackTrace();
                }
                b(iWebview.getContext(), iWebview, str3, strObtainAppName);
                return null;
            case "closeSplashscreen":
                io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.MAIN_TAG, "appid=" + strObtainAppId + " closeSplashscreen");
                io.dcloud.common.util.TestUtil.print(io.dcloud.common.util.TestUtil.START_STREAM_APP, "closeSplashscreen appid=" + strObtainAppId);
                io.dcloud.common.adapter.util.Logger.i("download_manager", "javascript webapp task begin success appid=" + strObtainAppId + " closeSplashscreen");
                this.a.processEvent(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 11, iWebview.obtainFrameView());
                return null;
            case "getStatusBarStyle":
                return io.dcloud.common.util.JSUtil.wrapJsVar(iAppObtainApp.obtainConfigProperty(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR_MODE));
            case "isLogs":
                return io.dcloud.common.util.JSUtil.wrapJsVar(io.dcloud.common.adapter.util.Logger.isOpen());
            case "showSystemNavigation":
                android.view.Window window2 = iAppObtainApp.getActivity().getWindow();
                window2.getDecorView().setSystemUiVisibility(window2.getDecorView().getSystemUiVisibility() & (-515));
                iWebview.obtainApp().setHideNavBarState(false);
                return null;
            case "isSimulator":
                io.dcloud.common.util.AppRuntime.checkPrivacyComplianceAndPrompt(iWebview.getContext(), "Navigator-" + str);
                return io.dcloud.common.util.JSUtil.wrapJsVar(io.dcloud.common.util.emulator.EmulatorCheckUtil.getSingleInstance().emulatorCheck(iWebview.getContext()));
            case "removeSessionCookie":
                try {
                    iWebview.removeSessionCookie();
                    return null;
                } catch (java.lang.Exception e3) {
                    e3.printStackTrace();
                    return null;
                }
            case "isImmersedStatusbar":
                return io.dcloud.common.util.JSUtil.wrapJsVar(iAppObtainApp.obtainStatusBarMgr().checkImmersedStatusBar(iWebview.getActivity(), java.lang.Boolean.valueOf(iAppObtainApp.obtainConfigProperty(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR_IMMERSED)).booleanValue()));
            case "getStatusBarBackground":
                return io.dcloud.common.util.JSUtil.wrapJsVar(io.dcloud.common.util.PdrUtil.toHexFromColor(iAppObtainApp.getActivity().getWindow().getStatusBarColor()));
            case "setCookie":
                iWebview.setCookie(strArr[0], strArr[1]);
                return null;
            case "hasSplashscreen":
                return io.dcloud.common.util.JSUtil.wrapJsVar(!iAppObtainApp.obtainWebAppRootView().didCloseSplash());
            case "getUserAgent":
                boolean z = java.lang.Boolean.parseBoolean(iAppObtainApp.obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_funSetUA));
                java.lang.String strObtainConfigProperty = iWebview.obtainApp().obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_USER_AGENT);
                if (android.text.TextUtils.isEmpty(strObtainConfigProperty)) {
                    strObtainConfigProperty = "";
                }
                if (!z) {
                    boolean z2 = java.lang.Boolean.parseBoolean(iAppObtainApp.obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_CONCATENATE));
                    boolean z3 = java.lang.Boolean.parseBoolean(iAppObtainApp.obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_H5PLUS));
                    if (z2) {
                        java.lang.String str4 = io.dcloud.common.util.BaseInfo.sDefWebViewUserAgent + com.taobao.weex.el.parse.Operators.SPACE_STR + strObtainConfigProperty;
                        if (iWebview.obtainApp().isUniApp() && !str4.contains("uni-app")) {
                            str4 = str4 + " uni-app";
                        }
                        if (!z3) {
                            return str4;
                        }
                        return str4 + io.dcloud.common.adapter.ui.webview.DCWebView.UserAgentExtInfo;
                    }
                }
                return strObtainConfigProperty;
            case "getCookie":
                return iWebview.getCookie(strArr[0]);
            case "createShortcut":
                io.dcloud.common.util.AppRuntime.checkPrivacyComplianceAndPrompt(iWebview.getContext(), "Navigator-" + str);
                io.dcloud.common.adapter.util.PermissionUtil.usePermission(iWebview.getActivity(), io.dcloud.common.DHInterface.IFeature.F_NAVIGATOR, "SHORTCUT", 2, new io.dcloud.feature.ui.navigator.NavigatorUIFeatureImpl.a(iAppObtainApp, iWebview, strArr, iAppObtainApp, strObtainAppId));
                return null;
            case "setFullscreen":
                iAppObtainApp.setFullScreen(io.dcloud.common.util.PdrUtil.parseBoolean(java.lang.String.valueOf(strArr[0]), false, false));
                break;
            case "getUiStyle":
                return io.dcloud.common.util.JSUtil.wrapJsVar(io.dcloud.common.util.AppRuntime.getAppDarkMode(iWebview.getContext()) ? io.dcloud.common.ui.blur.DCBlurDraweeView.DARK : io.dcloud.common.ui.blur.DCBlurDraweeView.LIGHT);
            case "checkPermission":
                return io.dcloud.common.util.JSUtil.wrapJsVar(io.dcloud.common.adapter.util.PermissionUtil.checkPermission(iWebview, strArr));
            case "requestPermission":
                java.lang.String str5 = strArr[0];
                java.lang.String str6 = strArr[1];
                int requestCode = io.dcloud.common.adapter.util.PermissionUtil.getRequestCode();
                java.lang.String strConvertNativePermission = io.dcloud.common.adapter.util.PermissionUtil.convertNativePermission(str5);
                iAppObtainApp.registerSysEventListener(new io.dcloud.feature.ui.navigator.NavigatorUIFeatureImpl.b(requestCode, iAppObtainApp, iWebview, strConvertNativePermission, str6), io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onRequestPermissionsResult);
                iAppObtainApp.requestPermissions(new java.lang.String[]{strConvertNativePermission}, requestCode);
                break;
            case "isBackground":
                return io.dcloud.common.util.JSUtil.wrapJsVar(iAppObtainApp.obtainAppStatus() == 2);
            case "getSignature":
                return io.dcloud.common.util.JSUtil.wrapJsVar(io.dcloud.common.util.LoadAppUtils.getAppSignatureSHA1(iWebview.getContext()));
            case "hasNotchInScreen":
                return io.dcloud.common.util.JSUtil.wrapJsVar(io.dcloud.feature.ui.navigator.QueryNotchTool.hasNotchInScreen(iWebview.getActivity()));
            case "setStatusBarBackground":
                java.lang.String str7 = strArr[0];
                if (!android.text.TextUtils.isEmpty(str7)) {
                    try {
                        iStringToColor = android.graphics.Color.parseColor(str7);
                        break;
                    } catch (java.lang.Exception unused2) {
                        iStringToColor = io.dcloud.common.util.PdrUtil.stringToColor(str7);
                    }
                    iAppObtainApp.setConfigProperty(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR_BC, strArr[0]);
                    iAppObtainApp.obtainStatusBarMgr().setStatusBarColor(iAppObtainApp.getActivity(), iStringToColor);
                    break;
                }
                break;
            case "removeAllCookie":
                try {
                    iWebview.removeAllCookie();
                    break;
                } catch (java.lang.Exception e4) {
                    e4.printStackTrace();
                    break;
                }
                break;
            case "isFullScreen":
                return io.dcloud.common.util.JSUtil.wrapJsVar(iAppObtainApp.isFullScreen());
            case "getStatusbarHeight":
                io.dcloud.common.adapter.util.DeviceInfo.updateStatusBarHeight(iWebview.getActivity());
                return io.dcloud.common.util.JSUtil.wrapJsVar(io.dcloud.common.adapter.util.DeviceInfo.sStatusBarHeight / iWebview.getScale());
            case "setUserAgent":
                java.lang.String str8 = strArr[0];
                java.lang.String str9 = strArr[1];
                iAppObtainApp.setConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_USER_AGENT, str8);
                iAppObtainApp.setConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_funSetUA, io.dcloud.common.constant.AbsoluteConst.TRUE);
                iAppObtainApp.setConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_H5PLUS, str9);
                iWebview.setWebviewProperty(io.dcloud.common.DHInterface.IWebview.USER_AGENT, str8);
                break;
            case "setLogs":
                io.dcloud.common.adapter.util.Logger.setOpen(io.dcloud.common.util.PdrUtil.parseBoolean(java.lang.String.valueOf(strArr[0]), false, false));
                break;
            case "setStatusBarStyle":
                java.lang.String str10 = strArr[0];
                iAppObtainApp.setConfigProperty(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR_MODE, str10);
                iAppObtainApp.obtainStatusBarMgr().setStatusBarMode(iAppObtainApp.getActivity(), str10);
                break;
        }
        return null;
    }

    @Override // io.dcloud.common.DHInterface.IFeature
    public void init(io.dcloud.common.DHInterface.AbsMgr absMgr, java.lang.String str) {
        this.a = absMgr;
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class c implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ io.dcloud.common.DHInterface.IWebview c;
        final /* synthetic */ java.lang.String d;

        c(android.content.Context context, java.lang.String str, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str2) {
            this.a = context;
            this.b = str;
            this.c = iWebview;
            this.d = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.String str;
            if (!io.dcloud.common.util.ShortCutUtil.SHORT_CUT_EXISTING.equals(io.dcloud.common.util.ShortCutUtil.requestShortCutForCommit(this.a, this.b))) {
                str = io.dcloud.common.constant.AbsoluteConst.FALSE;
            } else {
                str = io.dcloud.common.constant.AbsoluteConst.TRUE;
            }
            try {
                io.dcloud.common.util.JSUtil.execCallback(this.c, this.d, new org.json.JSONObject(io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.DOMException.JSON_SHORTCUT_SUCCESS_INFO, str)), io.dcloud.common.util.JSUtil.OK, false);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:30:0x00a4 A[Catch: Exception -> 0x00d0, TRY_LEAVE, TryCatch #0 {Exception -> 0x00d0, blocks: (B:28:0x009e, B:30:0x00a4, B:39:0x00c1, B:36:0x00ba, B:33:0x00b3), top: B:45:0x009e, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00bd A[DONT_INVERT, PHI: r3
  0x00bd: PHI (r3v10 android.graphics.Bitmap) = (r3v8 android.graphics.Bitmap), (r3v8 android.graphics.Bitmap), (r3v9 android.graphics.Bitmap) binds: [B:32:0x00b1, B:36:0x00ba, B:34:0x00b7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:38:0x00bf A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:49:0x00b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public boolean a(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String[] strArr, io.dcloud.common.DHInterface.IApp iApp, java.lang.String str) {
        java.lang.String str2;
        boolean zOptBoolean;
        java.lang.String str3;
        boolean z;
        java.lang.String str4;
        java.lang.String str5;
        boolean zOptBoolean2;
        java.lang.String str6;
        java.lang.String str7;
        android.graphics.Bitmap bitmapDecodeFile;
        java.lang.String str8 = strArr[0];
        java.lang.String str9 = strArr[1];
        java.lang.String strOptString = "";
        java.lang.String strOptString2 = io.dcloud.common.util.StringUtil.format(iWebview.getContext().getString(io.dcloud.base.R.string.dcloud_short_cut_created), iApp.obtainAppName());
        org.json.JSONObject jSONObjectOptJSONObject = null;
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str8);
            zOptBoolean = jSONObject.optBoolean(io.dcloud.common.constant.AbsoluteConst.INSTALL_OPTIONS_FORCE, true);
            if (zOptBoolean) {
                try {
                    strOptString2 = strOptString2 + iWebview.getActivity().getString(io.dcloud.base.R.string.dcloud_short_cut_created_removed_manually);
                } catch (org.json.JSONException e) {
                    e = e;
                    str2 = strOptString2;
                    str3 = strOptString;
                    e.printStackTrace();
                    z = zOptBoolean;
                    str4 = str3;
                    str5 = strOptString;
                    zOptBoolean2 = true;
                    str6 = strOptString;
                    str7 = str2;
                    bitmapDecodeFile = android.text.TextUtils.isEmpty(str5) ? null : android.graphics.BitmapFactory.decodeFile(iApp.convert2AbsFullPath(iWebview.obtainFullUrl(), str5));
                    if (bitmapDecodeFile == null) {
                        try {
                            bitmapDecodeFile = a(iApp);
                        } catch (java.lang.Exception e2) {
                            e2.printStackTrace();
                        }
                        if (bitmapDecodeFile == null) {
                            bitmapDecodeFile = android.graphics.BitmapFactory.decodeResource(iWebview.getContext().getResources(), io.dcloud.PdrR.DRAWABLE_ICON);
                        }
                    } else if (bitmapDecodeFile == null) {
                        bitmapDecodeFile = android.graphics.BitmapFactory.decodeResource(iWebview.getContext().getResources(), io.dcloud.PdrR.DRAWABLE_ICON);
                    }
                    a(iWebview, str6, bitmapDecodeFile, str4, str7, jSONObjectOptJSONObject, z, zOptBoolean2, str9);
                    return false;
                }
            }
            java.lang.String strOptString3 = jSONObject.optString("name");
            try {
                strOptString = jSONObject.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ICON);
                try {
                    strOptString = jSONObject.optString("classname");
                    if (jSONObject.has("toast")) {
                        strOptString2 = jSONObject.optString("toast");
                    }
                    jSONObjectOptJSONObject = jSONObject.optJSONObject("extra");
                    try {
                        z = zOptBoolean;
                        zOptBoolean2 = jSONObject.optBoolean("check", true);
                        str6 = strOptString3;
                        str5 = strOptString;
                        str4 = strOptString;
                        str7 = strOptString2;
                    } catch (org.json.JSONException e3) {
                        e = e3;
                        str2 = strOptString2;
                        str3 = strOptString;
                        strOptString = strOptString3;
                        e.printStackTrace();
                        z = zOptBoolean;
                        str4 = str3;
                        str5 = strOptString;
                        zOptBoolean2 = true;
                        str6 = strOptString;
                        str7 = str2;
                    }
                } catch (org.json.JSONException e4) {
                    e = e4;
                    str2 = strOptString2;
                    jSONObjectOptJSONObject = null;
                }
            } catch (org.json.JSONException e5) {
                e = e5;
                strOptString = "";
                str2 = strOptString2;
                jSONObjectOptJSONObject = null;
                str3 = strOptString;
            }
        } catch (org.json.JSONException e6) {
            e = e6;
            str2 = strOptString2;
            zOptBoolean = true;
        }
        try {
            if (android.text.TextUtils.isEmpty(str5)) {
            }
            if (bitmapDecodeFile == null) {
                bitmapDecodeFile = a(iApp);
                if (bitmapDecodeFile == null && bitmapDecodeFile == null) {
                    bitmapDecodeFile = android.graphics.BitmapFactory.decodeResource(iWebview.getContext().getResources(), io.dcloud.PdrR.DRAWABLE_ICON);
                }
            } else if (bitmapDecodeFile == null) {
                bitmapDecodeFile = android.graphics.BitmapFactory.decodeResource(iWebview.getContext().getResources(), io.dcloud.PdrR.DRAWABLE_ICON);
            }
        } catch (java.lang.Exception e7) {
            e7.printStackTrace();
        }
        a(iWebview, str6, bitmapDecodeFile, str4, str7, jSONObjectOptJSONObject, z, zOptBoolean2, str9);
        return false;
    }

    private java.lang.String b(io.dcloud.common.DHInterface.IApp iApp) {
        android.content.Intent intentObtainWebAppIntent = iApp.obtainWebAppIntent();
        return intentObtainWebAppIntent != null ? intentObtainWebAppIntent.getStringExtra(io.dcloud.common.constant.IntentConst.WEBAPP_ACTIVITY_APPICON) : "";
    }

    private void a(android.content.Context context, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, java.lang.String str2) {
        io.dcloud.common.adapter.util.MessageHandler.postDelayed(new io.dcloud.feature.ui.navigator.NavigatorUIFeatureImpl.c(context, str2, iWebview, str), android.os.Build.VERSION.SDK_INT >= 25 ? 1500 : 500);
    }

    private android.graphics.Bitmap a(io.dcloud.common.DHInterface.IApp iApp) {
        java.lang.String strB = b(iApp);
        if (strB != null) {
            return android.graphics.BitmapFactory.decodeFile(strB);
        }
        return null;
    }

    private void a(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, android.graphics.Bitmap bitmap, java.lang.String str2, java.lang.String str3, org.json.JSONObject jSONObject, boolean z, boolean z2, java.lang.String str4) {
        java.lang.String str5;
        android.content.Intent intentObtainWebAppIntent;
        io.dcloud.common.DHInterface.IApp iAppObtainApp = iWebview.obtainApp();
        java.lang.String strObtainAppId = iAppObtainApp.obtainAppId();
        android.app.Activity activity = iWebview.getActivity();
        android.content.SharedPreferences orCreateBundle = io.dcloud.common.adapter.util.SP.getOrCreateBundle(iWebview.getContext(), "pdr");
        if (io.dcloud.common.util.PdrUtil.isEmpty(str)) {
            str = iAppObtainApp.obtainAppName();
        }
        boolean z3 = orCreateBundle.getBoolean(strObtainAppId + io.dcloud.common.adapter.util.SP.K_CREATED_SHORTCUT, false);
        if (android.text.TextUtils.isEmpty(str2) && (intentObtainWebAppIntent = iWebview.obtainApp().obtainWebAppIntent()) != null) {
            str2 = intentObtainWebAppIntent.getStringExtra(io.dcloud.common.constant.IntentConst.WEBAPP_SHORT_CUT_CLASS_NAME);
        }
        java.lang.String str6 = str2;
        if (android.os.Build.VERSION.SDK_INT >= 25) {
            if (!io.dcloud.common.util.ShortCutUtil.hasShortcut(activity, str) || z) {
                str5 = str;
                if (io.dcloud.common.util.ShortCutUtil.createShortcutToDeskTop(activity, strObtainAppId, str5, bitmap, str6, jSONObject, true) && !android.text.TextUtils.isEmpty(str3)) {
                    com.dcloud.android.widget.toast.ToastCompat.makeText(activity.getApplicationContext(), (java.lang.CharSequence) str3, 1).show();
                }
            } else {
                str5 = str;
            }
        } else {
            str5 = str;
            if (io.dcloud.common.util.ShortcutCreateUtil.isDuplicateLauncher(activity)) {
                if (io.dcloud.common.util.ShortCutUtil.createShortcutToDeskTop(activity, strObtainAppId, str5, bitmap, str6, jSONObject, true) && !android.text.TextUtils.isEmpty(str3) && io.dcloud.common.util.ShortcutCreateUtil.needToast(activity)) {
                    com.dcloud.android.widget.toast.ToastCompat.makeText(activity.getApplicationContext(), (java.lang.CharSequence) str3, 1).show();
                }
            } else if (!io.dcloud.common.util.ShortCutUtil.hasShortcut(activity, str5)) {
                if (z) {
                    if (!android.text.TextUtils.isEmpty(str3) && io.dcloud.common.util.ShortcutCreateUtil.needToast(activity)) {
                        com.dcloud.android.widget.toast.ToastCompat.makeText(activity.getApplicationContext(), (java.lang.CharSequence) str3, 1).show();
                    }
                    io.dcloud.common.util.ShortCutUtil.createShortcutToDeskTop(activity, strObtainAppId, str5, bitmap, str6, jSONObject, true);
                } else {
                    if (z3) {
                        return;
                    }
                    if (io.dcloud.common.util.ShortCutUtil.createShortcutToDeskTop(activity, strObtainAppId, str5, bitmap, str6, jSONObject, true) && !android.text.TextUtils.isEmpty(str3) && io.dcloud.common.util.ShortcutCreateUtil.needToast(activity)) {
                        com.dcloud.android.widget.toast.ToastCompat.makeText(activity.getApplicationContext(), (java.lang.CharSequence) str3, 1).show();
                    }
                }
            }
        }
        a(iWebview.getContext(), iWebview, str4, str5);
    }
}
