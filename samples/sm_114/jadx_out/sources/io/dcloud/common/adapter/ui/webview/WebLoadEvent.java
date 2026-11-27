package io.dcloud.common.adapter.ui.webview;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public final class WebLoadEvent extends android.webkit.WebViewClient {
    private static final java.lang.String DIFFERENT_VERSION_JS = "window.plus && (plus.android.import=plus.android.importClass);";
    public static final java.lang.String ENABLE = "enable";
    private static final java.lang.String ERROR_TEMPLATE = "javascript:(function(){var b=document.createEvent('HTMLEvents');var a='%s';b.url='%s';b.href='%s';b.initEvent(a,false,true);console.error(a);document.dispatchEvent(b);})();";
    private static final java.lang.String IF_LOAD_TEMPLATE = "(function(){/*console.log('eval js loading href=' + location.href);*/if(location.__page__load__over__){return 2}if(location.__plusready__||window.__html5plus__){return 1}return 0})();";
    private static final java.lang.String IF_PLUSREADY_EVENT_TEMPLATE = "(function(){/*console.log('plusready event loading href=' + location.href);*/if(location.__page__load__over__){return 2}if(location.__plusready__||window.__html5plus__){if(!location.__plusready__event__){location.__plusready__event__=true;return 1}else{return 2}}return 0})();";
    private static final java.lang.String IF_PLUSREADY_TEMPLATE = "(function(){/*console.log('all.js loading href=' + location.href);*/if(location.__page__load__over__){return 2}if(!location.__plusready__){location.__plusready__=true;return 1}else{return 2}return 0})();";
    private static final java.lang.String IF_PRELOAD_TEMPLATE = "(function(){/*console.log( 'preload js loading href=' + location.href);*/if(location.__page__load__over__){return 2}var jsfile='%s';if(location.__plusready__||window.__html5plus__){location.__preload__=location.__preload__||[];if(location.__preload__.indexOf(jsfile)<0){location.__preload__.push(jsfile);return 1}else{return 2}}return 0})();";
    private static final int LOADABLE = 1;
    private static final int LOADED = 2;
    private static final int NOLOAD = 0;
    public static java.lang.String PAGE_FINISHED_FLAG = "javascript:setTimeout(function(){location.__page__load__over__ = true;},2000);";
    public static final java.lang.String PLUSREADY = "html5plus://ready";
    static final java.lang.String TAG = "WebLoadEvent";
    static final int Timeout_Page_Finish = 6000;
    static final int Timeout_Plus_Inject = 3000;
    public static final java.lang.String UNIAPP_READY = "uniapp://ready";
    boolean isInitAmapGEO;
    io.dcloud.common.adapter.ui.AdaWebview mAdaWebview;
    java.lang.String mAppid;
    private boolean mClearCache;
    long mShowLoadingTime;
    boolean printLog = true;
    private io.dcloud.common.adapter.ui.webview.OnPageFinishedCallack mPageFinishedCallack = null;
    private io.dcloud.common.DHInterface.IDCloudWebviewClientListener mdcloudwebviewclientlister = null;
    private java.lang.String mLastPageUrl = "";
    io.dcloud.common.adapter.ui.WaitingView mWap2AppBlockDialog = null;
    io.dcloud.common.DHInterface.ISysEventListener mWap2AppBlockDialogSysEventListener = null;
    java.lang.String mPlusJS = null;
    java.lang.String TYPE_JS = "type_js";
    java.lang.String TYPE_CSS = "type_css";
    private java.lang.Runnable mTitleNViewProgressStop = null;
    boolean needResponseRedirect = true;
    android.widget.ProgressBar mWaitingForWapPage = null;
    java.lang.Runnable Timeout_Plus_Inject_Runnable = null;
    java.lang.Runnable Timeout_Page_Finish_Runnable = null;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class CatchFile {
        java.io.File mFile = null;
        java.lang.String mEncoding = null;
        java.lang.String mContentType = null;
        boolean mExist = false;

        CatchFile() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class TitleNViewProgressStop implements java.lang.Runnable {
        private java.lang.ref.WeakReference<io.dcloud.common.adapter.ui.AdaWebview> mAdaWebview;

        public TitleNViewProgressStop(io.dcloud.common.adapter.ui.AdaWebview adaWebview) {
            this.mAdaWebview = new java.lang.ref.WeakReference<>(adaWebview);
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.ref.WeakReference<io.dcloud.common.adapter.ui.AdaWebview> weakReference = this.mAdaWebview;
            if (weakReference == null || weakReference.get() == null || this.mAdaWebview.get().obtainFrameView() == null) {
                return;
            }
            java.lang.Object titleNView = io.dcloud.common.util.TitleNViewUtil.getTitleNView(this.mAdaWebview.get().obtainFrameView().obtainWindowMgr(), this.mAdaWebview.get().obtainFrameView().obtainWebView(), this.mAdaWebview.get().obtainFrameView(), io.dcloud.common.util.TitleNViewUtil.getTitleNViewId(this.mAdaWebview.get().obtainFrameView()));
            if (titleNView instanceof io.dcloud.common.DHInterface.ITitleNView) {
                io.dcloud.common.util.TitleNViewUtil.stopProcess((io.dcloud.common.DHInterface.ITitleNView) titleNView);
            }
        }
    }

    public WebLoadEvent(io.dcloud.common.adapter.ui.AdaWebview adaWebview) {
        this.mClearCache = false;
        this.mAppid = null;
        this.isInitAmapGEO = false;
        this.mAdaWebview = adaWebview;
        this.mAppid = adaWebview.obtainApp().obtainAppId();
        java.lang.String strObtainConfigProperty = adaWebview.obtainApp().obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_RAM_CACHE_MODE);
        if (io.dcloud.common.util.BaseInfo.isBase(adaWebview.getContext()) && !ENABLE.equalsIgnoreCase(strObtainConfigProperty)) {
            this.mClearCache = true;
        }
        reset();
        this.isInitAmapGEO = io.dcloud.common.util.DLGeolocation.checkGeo(adaWebview.getContext());
    }

    private boolean checkCssFile(java.lang.String str) {
        return !android.text.TextUtils.isEmpty(str) && str.contains(".css");
    }

    private boolean checkJsFile(java.lang.String str) {
        return (android.text.TextUtils.isEmpty(str) || !str.contains(".js") || str.contains(".jsp")) ? false : true;
    }

    private android.webkit.WebResourceResponse checkWebResourceResponseRedirect(android.webkit.WebView webView, java.lang.String str) {
        io.dcloud.common.adapter.ui.AdaWebview adaWebview;
        org.json.JSONObject jSONObjectObtainThridInfo;
        java.lang.String strOptString;
        if (!this.needResponseRedirect) {
            return null;
        }
        try {
            if (android.webkit.URLUtil.isNetworkUrl(str) && io.dcloud.common.util.BaseInfo.existsStreamEnv() && (adaWebview = this.mAdaWebview) != null && adaWebview.obtainFrameView().obtainApp() != null && (jSONObjectObtainThridInfo = this.mAdaWebview.obtainFrameView().obtainApp().obtainThridInfo(io.dcloud.common.DHInterface.IApp.ConfigProperty.ThridInfo.URDJsonData)) != null) {
                org.json.JSONArray jSONArrayOptJSONArray = jSONObjectObtainThridInfo.optJSONObject("data").optJSONArray(io.dcloud.common.adapter.util.InvokeExecutorHelper.create("io.dcloud.appstream.rules.util.Tools").invoke("getTopDomainInHost", new java.net.URL(str).getHost()));
                if (jSONArrayOptJSONArray != null) {
                    boolean z = false;
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        org.json.JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                        org.json.JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("match");
                        strOptString = jSONObjectOptJSONObject.optString("redirect");
                        for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                            if (java.util.regex.Pattern.compile(jSONArrayOptJSONArray2.optString(i)).matcher(str).matches()) {
                                z = true;
                                break;
                            }
                        }
                        if (z) {
                            return downloadResponse(webView, strOptString);
                        }
                    }
                    strOptString = null;
                    return downloadResponse(webView, strOptString);
                }
            }
            return null;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void completeLoadJs(final android.webkit.WebView webView, final java.lang.String str, final java.lang.String str2, final java.lang.String[] strArr, final java.lang.String str3, final java.lang.Object... objArr) {
        final java.lang.ref.SoftReference softReference = new java.lang.ref.SoftReference(this.mAdaWebview);
        this.mAdaWebview.executeScript(io.dcloud.common.adapter.ui.ReceiveJSValue.registerCallback((io.dcloud.common.adapter.ui.AdaWebview) softReference.get(), io.dcloud.common.util.StringUtil.format(str3, objArr), new io.dcloud.common.adapter.ui.ReceiveJSValue.ReceiveJSValueCallback() { // from class: io.dcloud.common.adapter.ui.webview.WebLoadEvent.9
            @Override // io.dcloud.common.adapter.ui.ReceiveJSValue.ReceiveJSValueCallback
            public java.lang.String callback(org.json.JSONArray jSONArray) {
                try {
                    int i = jSONArray.getInt(1);
                    if (i == 0 && !io.dcloud.common.util.PdrUtil.isEquals(str2, "onPageFinished")) {
                        io.dcloud.common.adapter.ui.webview.WebLoadEvent.this.completeLoadJs(webView, str, str2, strArr, str3, objArr);
                        return null;
                    }
                    if (1 != i) {
                        return null;
                    }
                    for (java.lang.String str4 : strArr) {
                        if (softReference.get() != null) {
                            ((io.dcloud.common.adapter.ui.AdaWebview) softReference.get()).executeScript(str4);
                        }
                    }
                    return null;
                } catch (org.json.JSONException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }));
    }

    private boolean directPageIsLaunchPage(io.dcloud.common.DHInterface.IApp iApp) {
        return (iApp == null || android.text.TextUtils.isEmpty(iApp.getOriginalDirectPage()) || iApp.obtainWebAppIntent().hasExtra(io.dcloud.common.constant.IntentConst.DIRECT_PAGE)) ? false : true;
    }

    private android.webkit.WebResourceResponse downloadResponse(final android.webkit.WebView webView, final java.lang.String str) {
        if (!android.webkit.URLUtil.isNetworkUrl(str)) {
            return null;
        }
        try {
            io.dcloud.common.adapter.util.MessageHandler.sendMessage(new io.dcloud.common.adapter.util.MessageHandler.IMessages() { // from class: io.dcloud.common.adapter.ui.webview.WebLoadEvent.1
                @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
                public void execute(java.lang.Object obj) {
                    webView.stopLoading();
                    io.dcloud.common.adapter.ui.webview.WebLoadEvent.this.needResponseRedirect = false;
                    webView.loadUrl(str);
                }
            }, null);
            return new android.webkit.WebResourceResponse(null, null, new java.io.ByteArrayInputStream("".getBytes()));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x004e  */
    /* JADX WARN: Code duplicated, block: B:83:0x01ad A[Catch: Exception -> 0x01e4, TryCatch #4 {Exception -> 0x01e4, blocks: (B:21:0x0060, B:23:0x0066, B:25:0x006c, B:28:0x0072, B:30:0x0078, B:32:0x007f, B:33:0x0086, B:36:0x0090, B:38:0x009a, B:39:0x00a9, B:41:0x00af, B:43:0x00b9, B:44:0x00d3, B:46:0x00d7, B:48:0x00e1, B:50:0x00eb, B:51:0x00fa, B:53:0x00fe, B:54:0x0107, B:56:0x010d, B:57:0x0111, B:61:0x0119, B:63:0x0121, B:65:0x0126, B:67:0x012e, B:69:0x0133, B:71:0x0146, B:83:0x01ad, B:85:0x01b5, B:60:0x0116, B:73:0x015f, B:75:0x0167, B:77:0x016f, B:78:0x019c, B:80:0x01a2), top: B:124:0x0060, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x01b5 A[Catch: Exception -> 0x01e4, TRY_LEAVE, TryCatch #4 {Exception -> 0x01e4, blocks: (B:21:0x0060, B:23:0x0066, B:25:0x006c, B:28:0x0072, B:30:0x0078, B:32:0x007f, B:33:0x0086, B:36:0x0090, B:38:0x009a, B:39:0x00a9, B:41:0x00af, B:43:0x00b9, B:44:0x00d3, B:46:0x00d7, B:48:0x00e1, B:50:0x00eb, B:51:0x00fa, B:53:0x00fe, B:54:0x0107, B:56:0x010d, B:57:0x0111, B:61:0x0119, B:63:0x0121, B:65:0x0126, B:67:0x012e, B:69:0x0133, B:71:0x0146, B:83:0x01ad, B:85:0x01b5, B:60:0x0116, B:73:0x015f, B:75:0x0167, B:77:0x016f, B:78:0x019c, B:80:0x01a2), top: B:124:0x0060, inners: #2 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:85:0x01b5, please report this as an issue */
    private android.webkit.WebResourceResponse downloadResponseInjection(android.webkit.WebResourceResponse webResourceResponse, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        byte[] bytes;
        java.lang.String str5;
        java.lang.String str6;
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        if (str4.equals(this.TYPE_JS)) {
            java.lang.String preLoadJsString = this.mAdaWebview.getPreLoadJsString();
            io.dcloud.common.adapter.ui.AdaWebview adaWebview = this.mAdaWebview;
            java.io.InputStream fileInputStream = null;
            if (adaWebview.mForceAHeadJsFileLoaded || android.text.TextUtils.isEmpty(adaWebview.mForceAHeadJsFile)) {
                bytes = null;
            } else {
                try {
                    io.dcloud.common.adapter.ui.AdaWebview adaWebview2 = this.mAdaWebview;
                    java.io.InputStream encryptionInputStream = io.dcloud.common.adapter.ui.webview.WebResUtil.getEncryptionInputStream(adaWebview2.mForceAHeadJsFile, adaWebview2.mFrameView.obtainApp());
                    if (encryptionInputStream != null) {
                        bytes = io.dcloud.common.util.IOUtil.getBytes(encryptionInputStream);
                    } else {
                        bytes = null;
                    }
                } catch (java.io.IOException e) {
                    io.dcloud.common.adapter.util.Logger.e("Exception", e.getMessage());
                }
            }
            if (android.text.TextUtils.isEmpty(preLoadJsString) && bytes == null && android.text.TextUtils.isEmpty(this.mPlusJS)) {
                return null;
            }
            try {
                if (android.webkit.URLUtil.isNetworkUrl(str) && (this.mAdaWebview.mNeedInjection || this.isInitAmapGEO || bytes != null)) {
                    io.dcloud.common.adapter.ui.webview.WebLoadEvent.CatchFile urlFile = getUrlFile(str, str4);
                    if (urlFile != null) {
                        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                        if (bytes != null) {
                            byteArrayOutputStream.write(bytes);
                            this.mAdaWebview.mForceAHeadJsFileLoaded = true;
                        }
                        if (!android.text.TextUtils.isEmpty(this.mPlusJS) && this.mAdaWebview.mPlusrequire.equals("ahead")) {
                            io.dcloud.common.adapter.ui.AdaWebview adaWebview3 = this.mAdaWebview;
                            adaWebview3.mPlusInjectTag = str;
                            adaWebview3.mPlusLoading = true;
                            byteArrayOutputStream.write(this.mPlusJS.getBytes());
                        }
                        if (!android.text.TextUtils.isEmpty(preLoadJsString) && this.mAdaWebview.mPlusrequire.equals("ahead")) {
                            io.dcloud.common.adapter.util.Logger.i(TAG, "mPlusrequire=ahead;this=" + this);
                            this.mAdaWebview.mPreloadJsLoading = true;
                            byteArrayOutputStream.write(preLoadJsString.getBytes());
                        }
                        if (this.isInitAmapGEO && io.dcloud.common.util.DLGeolocation.checkInjectGeo(this.mAdaWebview.mInjectGEO) && !this.mAdaWebview.mPlusrequire.equals("ahead")) {
                            this.mAdaWebview.mInjectGeoLoaded = true;
                            byteArrayOutputStream.write(io.dcloud.common.util.DLGeolocation.getGEOJS().getBytes());
                        }
                        if (urlFile.mExist) {
                            try {
                                java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(urlFile.mFile);
                                byte[] bArr = new byte[4096];
                                while (true) {
                                    int i = fileInputStream2.read(bArr);
                                    if (i <= 0) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(bArr, 0, i);
                                }
                                fileInputStream2.close();
                            } catch (java.io.IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        str6 = !android.text.TextUtils.isEmpty(urlFile.mEncoding) ? urlFile.mEncoding : str3;
                        str5 = !android.text.TextUtils.isEmpty(urlFile.mContentType) ? urlFile.mContentType : str2;
                        java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                        if (this.mAdaWebview.mPlusrequire.equals("ahead")) {
                            listenPlusInjectTimeout((android.webkit.WebView) this.mAdaWebview.getDCWebView().getWebView(), this.mAdaWebview.obtainFullUrl(), "inject_with_js");
                        }
                        fileInputStream = byteArrayInputStream;
                    }
                    if (fileInputStream != null) {
                        webResourceResponse = new android.webkit.WebResourceResponse(str5, str6, fileInputStream);
                    }
                    if (webResourceResponse != null) {
                        this.mAdaWebview.mEncoding = str6;
                        io.dcloud.common.adapter.util.Logger.i(TAG, "提前注入JS成功耗时：" + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis) + this.mAdaWebview.getOriginalUrl() + ";url=" + str);
                    }
                } else if (PLUSREADY.equals(str)) {
                    if (!android.text.TextUtils.isEmpty(this.mPlusJS)) {
                        io.dcloud.common.adapter.util.Logger.i("PLUSREADY", this.mAdaWebview.getOriginalUrl() + ";url=" + str);
                        this.mAdaWebview.mPlusLoading = true;
                        fileInputStream = new java.io.ByteArrayInputStream(this.mPlusJS.getBytes());
                    }
                } else if (io.dcloud.common.util.PdrUtil.isDeviceRootDir(str)) {
                    fileInputStream = new java.io.FileInputStream(str);
                }
                str5 = str2;
                str6 = str3;
                if (fileInputStream != null) {
                    webResourceResponse = new android.webkit.WebResourceResponse(str5, str6, fileInputStream);
                }
                if (webResourceResponse != null) {
                    this.mAdaWebview.mEncoding = str6;
                    io.dcloud.common.adapter.util.Logger.i(TAG, "提前注入JS成功耗时：" + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis) + this.mAdaWebview.getOriginalUrl() + ";url=" + str);
                }
            } catch (java.lang.Exception e3) {
                e3.printStackTrace();
            }
        } else if (this.TYPE_CSS.equals(str4)) {
            java.lang.String cssString = this.mAdaWebview.getCssString();
            if (!this.mAdaWebview.mIsAdvanceCss && !android.text.TextUtils.isEmpty(cssString)) {
                try {
                    java.io.ByteArrayOutputStream byteArrayOutputStream2 = new java.io.ByteArrayOutputStream();
                    io.dcloud.common.adapter.ui.webview.WebLoadEvent.CatchFile urlFile2 = getUrlFile(str, str4);
                    if (urlFile2 != null) {
                        if (urlFile2.mExist) {
                            java.io.FileInputStream fileInputStream3 = new java.io.FileInputStream(urlFile2.mFile);
                            byte[] bArr2 = new byte[4096];
                            while (true) {
                                int i2 = fileInputStream3.read(bArr2);
                                if (i2 <= 0) {
                                    break;
                                }
                                byteArrayOutputStream2.write(bArr2, 0, i2);
                            }
                            fileInputStream3.close();
                        }
                        byteArrayOutputStream2.write(cssString.getBytes());
                    }
                    java.lang.String str7 = !android.text.TextUtils.isEmpty(urlFile2.mEncoding) ? urlFile2.mEncoding : str3;
                    android.webkit.WebResourceResponse webResourceResponse2 = new android.webkit.WebResourceResponse("text/css", str7, new java.io.ByteArrayInputStream(byteArrayOutputStream2.toByteArray()));
                    try {
                        io.dcloud.common.adapter.ui.AdaWebview adaWebview4 = this.mAdaWebview;
                        adaWebview4.mIsAdvanceCss = true;
                        adaWebview4.mEncoding = str7;
                        io.dcloud.common.adapter.util.Logger.i(TAG, "提前注入CSS成功耗时：" + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis) + this.mAdaWebview.getOriginalUrl() + ";url=" + str);
                        return webResourceResponse2;
                    } catch (java.lang.Exception unused) {
                        webResourceResponse = webResourceResponse2;
                        this.mAdaWebview.mIsAdvanceCss = false;
                        return webResourceResponse;
                    }
                } catch (java.lang.Exception unused2) {
                }
            }
        }
        return webResourceResponse;
    }

    private java.lang.String getCacheLocalFilePath(java.lang.String str, java.lang.String str2) {
        io.dcloud.common.DHInterface.IApp iAppObtainApp;
        io.dcloud.common.adapter.ui.AdaWebview adaWebview = this.mAdaWebview;
        if (adaWebview == null || (iAppObtainApp = adaWebview.obtainApp()) == null) {
            return null;
        }
        if (this.TYPE_JS.equals(str2)) {
            return iAppObtainApp.obtainAppTempPath() + "__plus__cache__/" + io.dcloud.common.util.Md5Utils.md5(str) + ".js";
        }
        return iAppObtainApp.obtainAppTempPath() + "__plus__cache__/" + io.dcloud.common.util.Md5Utils.md5(str) + ".css";
    }

    public static java.lang.String getMimeType(java.lang.String str) {
        java.lang.String fileExtensionFromUrl = android.webkit.MimeTypeMap.getFileExtensionFromUrl(str);
        java.lang.String mimeTypeFromExtension = fileExtensionFromUrl != null ? android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl) : null;
        return android.text.TextUtils.isEmpty(mimeTypeFromExtension) ? androidx.webkit.internal.AssetHelper.DEFAULT_MIME_TYPE : mimeTypeFromExtension;
    }

    private io.dcloud.common.adapter.ui.webview.WebLoadEvent.CatchFile getUrlFile(java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        java.lang.String cacheLocalFilePath = getCacheLocalFilePath(str, str2);
        try {
            if (io.dcloud.common.adapter.io.DHFile.isExist(cacheLocalFilePath)) {
                io.dcloud.common.adapter.ui.webview.WebLoadEvent.CatchFile catchFile = new io.dcloud.common.adapter.ui.webview.WebLoadEvent.CatchFile();
                java.io.File file = new java.io.File(cacheLocalFilePath);
                catchFile.mFile = file;
                catchFile.mExist = file.exists();
                return catchFile;
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        try {
            java.net.URL url = new java.net.URL(str);
            java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) url.openConnection();
            if (httpURLConnection instanceof javax.net.ssl.HttpsURLConnection) {
                try {
                    javax.net.ssl.SSLSocketFactory sSLSocketFactory = io.dcloud.common.adapter.util.DCloudTrustManager.getSSLSocketFactory();
                    if (sSLSocketFactory != null) {
                        ((javax.net.ssl.HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
                    }
                    ((javax.net.ssl.HttpsURLConnection) httpURLConnection).setHostnameVerifier(io.dcloud.common.adapter.util.DCloudTrustManager.getHostnameVerifier(true));
                } catch (java.lang.Exception e2) {
                    throw new java.lang.RuntimeException(e2);
                }
            }
            httpURLConnection.setConnectTimeout(com.nostra13.dcloudimageloader.core.download.BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT);
            httpURLConnection.setReadTimeout(com.nostra13.dcloudimageloader.core.download.BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            int responseCode = httpURLConnection.getResponseCode();
            java.lang.String contentType = httpURLConnection.getContentType();
            if (!android.text.TextUtils.isEmpty(contentType) && (((str2.equals(this.TYPE_JS) && contentType.contains("javascript")) || (str2.equals(this.TYPE_CSS) && (contentType.contains("text/css") || url.getPath().endsWith(".css")))) && (responseCode == 200 || responseCode == 206))) {
                java.io.InputStream inputStream = httpURLConnection.getInputStream();
                boolean zWriteFile = io.dcloud.common.adapter.io.DHFile.writeFile(inputStream, cacheLocalFilePath);
                io.dcloud.common.util.IOUtil.close(inputStream);
                if (zWriteFile) {
                    io.dcloud.common.adapter.ui.webview.WebLoadEvent.CatchFile catchFile2 = new io.dcloud.common.adapter.ui.webview.WebLoadEvent.CatchFile();
                    java.io.File file2 = new java.io.File(cacheLocalFilePath);
                    catchFile2.mFile = file2;
                    catchFile2.mExist = file2.exists();
                    catchFile2.mEncoding = httpURLConnection.getContentEncoding();
                    catchFile2.mContentType = contentType;
                    return catchFile2;
                }
                java.io.File file3 = new java.io.File(cacheLocalFilePath);
                if (file3.exists()) {
                    file3.delete();
                }
            }
            return null;
        } catch (java.io.IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    private android.webkit.WebResourceResponse handleDecode(java.lang.String str, android.webkit.WebResourceResponse webResourceResponse) {
        java.io.InputStream encryptionInputStream;
        return (android.text.TextUtils.isEmpty(str) || (encryptionInputStream = io.dcloud.common.adapter.ui.webview.WebResUtil.getEncryptionInputStream(str, this.mAdaWebview.obtainApp())) == null) ? webResourceResponse : new android.webkit.WebResourceResponse(getMimeType(str), "UTF-8", encryptionInputStream);
    }

    private void hideLoading() {
        this.mAdaWebview.obtainMainView().post(new java.lang.Runnable() { // from class: io.dcloud.common.adapter.ui.webview.WebLoadEvent.12
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // java.lang.Runnable
            public void run() {
                if (io.dcloud.common.adapter.ui.webview.WebLoadEvent.this.mAdaWebview == null) {
                    return;
                }
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                io.dcloud.common.adapter.ui.webview.WebLoadEvent webLoadEvent = io.dcloud.common.adapter.ui.webview.WebLoadEvent.this;
                if (jCurrentTimeMillis - webLoadEvent.mShowLoadingTime < 1000) {
                    webLoadEvent.mAdaWebview.getDCWebView().getWebView().postDelayed(this, jCurrentTimeMillis - io.dcloud.common.adapter.ui.webview.WebLoadEvent.this.mShowLoadingTime);
                } else {
                    io.dcloud.common.adapter.ui.AdaFrameView adaFrameView = webLoadEvent.mAdaWebview.mFrameView;
                    adaFrameView.dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENTS_HIDE_LOADING, adaFrameView);
                }
            }
        });
    }

    private void listenPlusInjectTimeout(final android.webkit.WebView webView, final java.lang.String str, final java.lang.String str2) {
        io.dcloud.common.adapter.ui.AdaWebview adaWebview = this.mAdaWebview;
        if (adaWebview == null && adaWebview.mPlusrequire.equals("none")) {
            return;
        }
        java.lang.Runnable runnable = this.Timeout_Plus_Inject_Runnable;
        if (runnable != null) {
            io.dcloud.common.adapter.util.MessageHandler.removeCallbacks(runnable);
        }
        java.lang.Runnable runnable2 = new java.lang.Runnable() { // from class: io.dcloud.common.adapter.ui.webview.WebLoadEvent.7
            @Override // java.lang.Runnable
            public void run() {
                io.dcloud.common.adapter.ui.AdaWebview adaWebview2 = io.dcloud.common.adapter.ui.webview.WebLoadEvent.this.mAdaWebview;
                if (adaWebview2 == null || adaWebview2.isRealInject(str)) {
                    return;
                }
                io.dcloud.common.adapter.util.Logger.i("WebViewData", "listenPlusInjectTimeout url=" + str);
                io.dcloud.common.adapter.ui.webview.WebLoadEvent.this.onLoadPlusJSContent(webView, str, "plus_inject_timeout_" + str2);
                io.dcloud.common.adapter.ui.webview.WebLoadEvent webLoadEvent = io.dcloud.common.adapter.ui.webview.WebLoadEvent.this;
                webLoadEvent.mAdaWebview.mPreloadJsLoading = false;
                webLoadEvent.Timeout_Plus_Inject_Runnable = null;
            }
        };
        this.Timeout_Plus_Inject_Runnable = runnable2;
        io.dcloud.common.adapter.util.MessageHandler.postDelayed(runnable2, 3000L);
    }

    private void loadAllJSContent(android.webkit.WebView webView, java.lang.String str, java.lang.String str2) {
        if (onLoadPlusJSContent(webView, str, str2)) {
            injectScript(webView, str, str2);
        }
    }

    private void onExecuteEvalJSStatck(android.webkit.WebView webView, java.lang.String str, java.lang.String str2) {
        java.lang.String str3 = this.mAdaWebview.get_eval_js_stack();
        if (io.dcloud.common.util.PdrUtil.isEmpty(str3)) {
            return;
        }
        completeLoadJs(webView, str, str2, new java.lang.String[]{str3}, IF_LOAD_TEMPLATE, str);
    }

    private void onLoadCssContent() {
        io.dcloud.common.adapter.ui.AdaWebview adaWebview = this.mAdaWebview;
        if (adaWebview.mIsAdvanceCss) {
            io.dcloud.common.adapter.util.Logger.i(TAG, "已经提前注入CSS完成。不需要再注入了" + this.mAdaWebview.getOriginalUrl());
        } else if (adaWebview.loadCssFile()) {
            io.dcloud.common.adapter.util.Logger.i(TAG, "提前注入CSS完成" + this.mAdaWebview.getOriginalUrl());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onLoadPlusJSContent(final android.webkit.WebView webView, final java.lang.String str, final java.lang.String str2) {
        if (this.mAdaWebview.mPlusrequire.equals("none")) {
            return false;
        }
        if (this.mAdaWebview.isRealInject(str)) {
            io.dcloud.common.adapter.util.Logger.i(TAG, "all.js已经注入完成。不需要再注入了" + this.mAdaWebview.getOriginalUrl());
            return true;
        }
        io.dcloud.common.adapter.util.Logger.i(TAG, "onLoadPlusJSContent all.js注入 " + this.mAdaWebview.getOriginalUrl() + ";tag=" + str2 + ";mAdaWebview.mPlusrequire=" + this.mAdaWebview.mPlusrequire);
        if (this.mAdaWebview.mPlusrequire.equals("later") && str2.equals("onPageFinished")) {
            webView.postDelayed(new java.lang.Runnable() { // from class: io.dcloud.common.adapter.ui.webview.WebLoadEvent.6
                @Override // java.lang.Runnable
                public void run() {
                    io.dcloud.common.adapter.ui.webview.WebLoadEvent webLoadEvent = io.dcloud.common.adapter.ui.webview.WebLoadEvent.this;
                    io.dcloud.common.adapter.ui.AdaWebview adaWebview = webLoadEvent.mAdaWebview;
                    if (adaWebview != null) {
                        java.lang.String str3 = str2;
                        adaWebview.mPlusInjectTag = str3;
                        adaWebview.mPlusLoading = true;
                        android.webkit.WebView webView2 = webView;
                        java.lang.String str4 = str;
                        webLoadEvent.completeLoadJs(webView2, str4, str3, new java.lang.String[]{webLoadEvent.mPlusJS, io.dcloud.common.adapter.ui.webview.WebLoadEvent.DIFFERENT_VERSION_JS}, io.dcloud.common.adapter.ui.webview.WebLoadEvent.IF_PLUSREADY_TEMPLATE, str4);
                    }
                }
            }, 2000L);
        } else {
            io.dcloud.common.adapter.ui.AdaWebview adaWebview = this.mAdaWebview;
            adaWebview.mPlusInjectTag = str2;
            adaWebview.mPlusLoading = true;
            completeLoadJs(webView, str, str2, new java.lang.String[]{this.mPlusJS, DIFFERENT_VERSION_JS}, IF_PLUSREADY_TEMPLATE, str);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPlusreadyEvent(android.webkit.WebView webView, java.lang.String str, java.lang.String str2) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.EVENTS_DOCUMENT_EXECUTE_TEMPLATE, io.dcloud.common.constant.AbsoluteConst.EVENTS_PLUSREADY));
        java.lang.StringBuffer stringBuffer2 = new java.lang.StringBuffer();
        stringBuffer2.append(io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.EVENTS_IFRAME_DOUCMENT_EXECUTE_TEMPLATE, io.dcloud.common.constant.AbsoluteConst.EVENTS_PLUSREADY));
        completeLoadJs(webView, str, str2, new java.lang.String[]{stringBuffer.toString(), stringBuffer2.toString(), "plus.webview.currentWebview().__needTouchEvent__()"}, IF_PLUSREADY_EVENT_TEMPLATE, str);
    }

    private void printOpenLog(android.webkit.WebView webView, java.lang.String str) {
        io.dcloud.common.DHInterface.IApp iAppObtainApp;
        java.lang.String url = webView.getUrl();
        if (!io.dcloud.common.util.BaseInfo.isBase(webView.getContext()) || android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(url) || (iAppObtainApp = this.mAdaWebview.mFrameView.obtainApp()) == null || str.startsWith(io.dcloud.common.adapter.util.DeviceInfo.HTTP_PROTOCOL) || url.startsWith(io.dcloud.common.adapter.util.DeviceInfo.HTTP_PROTOCOL) || str.startsWith(io.dcloud.common.adapter.util.DeviceInfo.HTTPS_PROTOCOL) || url.startsWith(io.dcloud.common.adapter.util.DeviceInfo.HTTPS_PROTOCOL)) {
            return;
        }
        android.util.Log.i(io.dcloud.common.constant.AbsoluteConst.HBUILDER_TAG, io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.OPENLOG, io.dcloud.common.adapter.ui.webview.WebResUtil.getHBuilderPrintUrl(iAppObtainApp.convert2RelPath(io.dcloud.common.adapter.ui.webview.WebResUtil.getOriginalUrl(url))), io.dcloud.common.adapter.ui.webview.WebResUtil.getHBuilderPrintUrl(iAppObtainApp.convert2RelPath(io.dcloud.common.adapter.ui.webview.WebResUtil.getOriginalUrl(str)))));
    }

    private void printResourceLog(android.webkit.WebView webView, io.dcloud.common.DHInterface.IApp iApp, java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str2) || android.text.TextUtils.isEmpty(str) || webView == null || iApp == null || !io.dcloud.common.util.BaseInfo.isBase(webView.getContext()) || str.equalsIgnoreCase(str2) || android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        if (this.mClearCache && !this.mLastPageUrl.equalsIgnoreCase(str)) {
            webView.clearCache(true);
        }
        this.mLastPageUrl = str;
        java.lang.String originalUrl = io.dcloud.common.adapter.ui.webview.WebResUtil.getOriginalUrl(str);
        if (str2.startsWith(io.dcloud.common.adapter.util.DeviceInfo.HTTP_PROTOCOL) || str2.startsWith(io.dcloud.common.adapter.util.DeviceInfo.HTTPS_PROTOCOL)) {
            return;
        }
        android.util.Log.i(io.dcloud.common.constant.AbsoluteConst.HBUILDER_TAG, io.dcloud.common.util.StringUtil.format(io.dcloud.common.constant.AbsoluteConst.RESOURCELOG, io.dcloud.common.adapter.ui.webview.WebResUtil.getHBuilderPrintUrl(iApp.convert2RelPath(originalUrl)), io.dcloud.common.adapter.ui.webview.WebResUtil.getHBuilderPrintUrl(iApp.convert2RelPath(io.dcloud.common.adapter.ui.webview.WebResUtil.getOriginalUrl(str2)))));
    }

    private boolean shouldRuntimeHandle(java.lang.String str) {
        return io.dcloud.common.util.PdrUtil.isDeviceRootDir(str) || io.dcloud.common.util.PdrUtil.isNetPath(str) || str.startsWith(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL);
    }

    private void showLoading() {
        this.mAdaWebview.getDCWebView().getWebView().post(new java.lang.Runnable() { // from class: io.dcloud.common.adapter.ui.webview.WebLoadEvent.11
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // java.lang.Runnable
            public void run() {
                io.dcloud.common.adapter.ui.AdaWebview adaWebview = io.dcloud.common.adapter.ui.webview.WebLoadEvent.this.mAdaWebview;
                if (adaWebview != null) {
                    io.dcloud.common.adapter.ui.AdaFrameView adaFrameView = adaWebview.mFrameView;
                    adaFrameView.dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENTS_SHOW_LOADING, adaFrameView);
                }
            }
        });
        this.mShowLoadingTime = java.lang.System.currentTimeMillis();
    }

    private void startTryLoadAllJSContent(android.webkit.WebView webView, java.lang.String str, java.lang.String str2) {
        loadAllJSContent(webView, str, str2);
    }

    public void closeWap2AppBlockDialog(boolean z) {
        io.dcloud.common.adapter.ui.WaitingView waitingView = this.mWap2AppBlockDialog;
        if (waitingView != null) {
            waitingView.close();
            this.mAdaWebview.obtainApp().unregisterSysEventListener(this.mWap2AppBlockDialogSysEventListener, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onKeyUp);
            this.mWap2AppBlockDialog = null;
            this.mWap2AppBlockDialogSysEventListener = null;
            if (z) {
                io.dcloud.common.adapter.ui.AdaWebview adaWebview = this.mAdaWebview;
                adaWebview.loadUrl(adaWebview.mRecordLastUrl);
            }
        }
    }

    public void destroy() {
        this.mAdaWebview = null;
        this.mPlusJS = null;
        this.mTitleNViewProgressStop = null;
        this.mWap2AppBlockDialog = null;
        this.mWaitingForWapPage = null;
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(android.webkit.WebView webView, java.lang.String str, boolean z) {
        if (io.dcloud.common.util.PdrUtil.isEmpty(this.mdcloudwebviewclientlister)) {
            return;
        }
        this.mdcloudwebviewclientlister.doUpdateVisitedHistory(webView, str, z);
    }

    java.lang.String getErrorPage() {
        java.lang.String strHandleWap2appTemplateFilePath = this.mAdaWebview.mFrameView.obtainFrameOptions().errorPage;
        if (!android.webkit.URLUtil.isNetworkUrl(strHandleWap2appTemplateFilePath)) {
            if (android.text.TextUtils.isEmpty(strHandleWap2appTemplateFilePath)) {
                java.lang.String strObtainConfigProperty = this.mAdaWebview.obtainApp().obtainConfigProperty("error");
                return !"none".equals(strObtainConfigProperty) ? this.mAdaWebview.obtainApp().convert2WebviewFullPath(null, strObtainConfigProperty) : "none";
            }
            io.dcloud.common.DHInterface.IApp iAppObtainApp = this.mAdaWebview.obtainApp();
            if (!"none".equals(strHandleWap2appTemplateFilePath)) {
                java.lang.String strConvert2AbsFullPath = iAppObtainApp.convert2AbsFullPath(this.mAdaWebview.obtainFullUrl(), strHandleWap2appTemplateFilePath);
                java.io.File file = new java.io.File(strConvert2AbsFullPath);
                if (file.exists()) {
                    return iAppObtainApp.convert2WebviewFullPath(this.mAdaWebview.obtainFullUrl(), strHandleWap2appTemplateFilePath);
                }
                if (io.dcloud.common.util.BaseInfo.isWap2AppAppid(iAppObtainApp.obtainAppId())) {
                    java.lang.String relPath = io.dcloud.common.adapter.ui.webview.WebResUtil.getRelPath(io.dcloud.common.util.PdrUtil.stripQuery(io.dcloud.common.util.PdrUtil.stripAnchor(strConvert2AbsFullPath)), iAppObtainApp);
                    if (io.dcloud.common.adapter.ui.webview.WebResUtil.isWap2appTemplateFile(iAppObtainApp, relPath)) {
                        strHandleWap2appTemplateFilePath = io.dcloud.common.adapter.ui.webview.WebResUtil.handleWap2appTemplateFilePath(relPath);
                        file = new java.io.File(strHandleWap2appTemplateFilePath);
                    }
                }
                if (!file.exists()) {
                    java.lang.String strObtainConfigProperty2 = iAppObtainApp.obtainConfigProperty("error");
                    return !"none".equals(strObtainConfigProperty2) ? iAppObtainApp.convert2WebviewFullPath(null, strObtainConfigProperty2) : "none";
                }
                return io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL + strHandleWap2appTemplateFilePath;
            }
        }
        return strHandleWap2appTemplateFilePath;
    }

    void injectScript(final android.webkit.WebView webView, final java.lang.String str, final java.lang.String str2) {
        if (str2.equals("onPageFinished") && this.mAdaWebview.mPlusrequire.equals("later")) {
            webView.postDelayed(new java.lang.Runnable() { // from class: io.dcloud.common.adapter.ui.webview.WebLoadEvent.10
                @Override // java.lang.Runnable
                public void run() {
                    io.dcloud.common.adapter.ui.webview.WebLoadEvent webLoadEvent = io.dcloud.common.adapter.ui.webview.WebLoadEvent.this;
                    if (webLoadEvent.mAdaWebview != null) {
                        webLoadEvent.onPreloadJSContent(webView, str, str2);
                        io.dcloud.common.adapter.ui.webview.WebLoadEvent.this.onPlusreadyEvent(webView, str, str2);
                    }
                }
            }, 2000L);
        } else {
            onPreloadJSContent(webView, str, str2);
            onPlusreadyEvent(webView, str, str2);
        }
        onLoadCssContent();
    }

    public void listenPageFinishTimeout(final android.webkit.WebView webView, final java.lang.String str, final java.lang.String str2) {
        io.dcloud.common.adapter.ui.AdaWebview adaWebview = this.mAdaWebview;
        if (adaWebview.mLoaded && adaWebview.isRealInject(str)) {
            injectScript(webView, str, str2);
            return;
        }
        java.lang.Runnable runnable = this.Timeout_Page_Finish_Runnable;
        if (runnable != null) {
            io.dcloud.common.adapter.util.MessageHandler.removeCallbacks(runnable);
        }
        java.lang.Runnable runnable2 = new java.lang.Runnable() { // from class: io.dcloud.common.adapter.ui.webview.WebLoadEvent.8
            @Override // java.lang.Runnable
            public void run() {
                io.dcloud.common.adapter.ui.AdaWebview adaWebview2 = io.dcloud.common.adapter.ui.webview.WebLoadEvent.this.mAdaWebview;
                if (adaWebview2 == null || adaWebview2.mLoaded || !adaWebview2.isRealInject(str)) {
                    return;
                }
                io.dcloud.common.adapter.ui.webview.WebLoadEvent.this.injectScript(webView, str, "page_finished_timeout_" + str2);
                io.dcloud.common.adapter.ui.webview.WebLoadEvent.this.Timeout_Page_Finish_Runnable = null;
            }
        };
        this.Timeout_Page_Finish_Runnable = runnable2;
        io.dcloud.common.adapter.util.MessageHandler.postDelayed(runnable2, 6000L);
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(android.webkit.WebView webView, java.lang.String str) {
        if (this.mAdaWebview == null) {
            return;
        }
        if (this.printLog) {
            io.dcloud.common.adapter.util.Logger.i(TAG, "onLoadResource url=" + str);
        }
        this.needResponseRedirect = true;
        printResourceLog(webView, this.mAdaWebview.mFrameView.obtainApp(), webView.getUrl(), str);
        io.dcloud.common.DHInterface.IFrameView iFrameViewObtainFrameView = this.mAdaWebview.obtainFrameView();
        if (iFrameViewObtainFrameView.obtainStatus() != 3) {
            iFrameViewObtainFrameView.onLoading();
        }
        if (this.mAdaWebview.checkResourceLoading(str)) {
            this.mAdaWebview.mFrameView.dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENTS_LISTEN_RESOURCE_LOADING, "{url:'" + str + "'}");
        }
        this.mAdaWebview.dispatchWebviewStateEvent(2, str);
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
        boolean z;
        if (this.mAdaWebview == null) {
            return;
        }
        io.dcloud.common.adapter.util.Logger.d(TAG, "onPageFinished=" + str);
        if (io.dcloud.common.util.PdrUtil.isEmpty(this.mAdaWebview.mFrameView.obtainApp())) {
            io.dcloud.common.adapter.util.Logger.e(TAG, "mAdaWebview.mFrameView.obtainApp()===null");
            return;
        }
        if (this.mAdaWebview.hadClearHistory(str)) {
            this.mAdaWebview.hasErrorPage = false;
            return;
        }
        if (this.mAdaWebview.hasErrorPage) {
            java.lang.String errorPage = getErrorPage();
            if (!io.dcloud.common.util.PdrUtil.isEquals(str, errorPage) && (!"data:text/html,chromewebdata".equals(str) || !"none".equals(errorPage))) {
                return;
            } else {
                z = true;
            }
        } else {
            z = false;
        }
        if (this.mAdaWebview.unReceiveTitle) {
            io.dcloud.common.adapter.util.Logger.i(TAG, "onPageFinished will exe titleUpdate =" + str);
            io.dcloud.common.adapter.ui.AdaWebview adaWebview = this.mAdaWebview;
            adaWebview.mFrameView.dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENTS_TITLE_UPDATE, adaWebview.getDCWebView().getTitle());
            this.mAdaWebview.unReceiveTitle = false;
        }
        android.webkit.CookieSyncManager.getInstance().sync();
        io.dcloud.common.adapter.util.Logger.i(TAG, "onPageFinished" + this.mAdaWebview.getOriginalUrl());
        this.mAdaWebview.dispatchWebviewStateEvent(1, str);
        this.mAdaWebview.loadForceAHeadJs();
        onLoadPlusJSContent(webView, str, "onPageFinished");
        if (this.mAdaWebview.isRealInject(str)) {
            injectScript(webView, str, "onPageFinished");
        }
        io.dcloud.common.adapter.ui.AdaWebview adaWebview2 = this.mAdaWebview;
        adaWebview2.mFrameView.dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENTS_LOADED, adaWebview2);
        if (z) {
            this.mAdaWebview.executeScript(io.dcloud.common.util.StringUtil.format(ERROR_TEMPLATE, "error", this.mAdaWebview.getOriginalUrl(), this.mAdaWebview.errorPageUrl));
            io.dcloud.common.adapter.ui.AdaWebview adaWebview3 = this.mAdaWebview;
            adaWebview3.errorPageUrl = null;
            adaWebview3.hasErrorPage = false;
        }
        io.dcloud.common.adapter.ui.AdaFrameView adaFrameView = this.mAdaWebview.mFrameView;
        if (adaFrameView.obtainStatus() != 3) {
            adaFrameView.onPreShow(null);
        }
        io.dcloud.common.adapter.ui.AdaWebview adaWebview4 = this.mAdaWebview;
        if (!adaWebview4.mLoaded) {
            adaWebview4.mLoaded = true;
            adaWebview4.mPlusLoaded = true;
        }
        super.onPageFinished(webView, str);
        if (this.mAdaWebview.justClearOption && !str.startsWith("data:")) {
            io.dcloud.common.adapter.util.Logger.d(TAG, "onPageFinished mWebViewImpl.clearHistory url=" + str);
            this.mAdaWebview.getDCWebView().clearHistory();
            this.mAdaWebview.justClearOption = false;
        }
        this.mAdaWebview.getDCWebView().webReload(false);
        io.dcloud.common.adapter.ui.webview.OnPageFinishedCallack onPageFinishedCallack = this.mPageFinishedCallack;
        if (onPageFinishedCallack != null) {
            onPageFinishedCallack.onLoad();
        }
        if (this.mWaitingForWapPage != null) {
            try {
                ((android.view.ViewGroup) this.mAdaWebview.obtainFrameView().obtainMainView()).removeView(this.mWaitingForWapPage);
                this.mWaitingForWapPage = null;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        this.mAdaWebview.checkInjectSitemap();
        if (io.dcloud.common.util.PdrUtil.isEmpty(this.mdcloudwebviewclientlister)) {
            return;
        }
        this.mdcloudwebviewclientlister.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(android.webkit.WebView webView, java.lang.String str, android.graphics.Bitmap bitmap) {
        io.dcloud.common.adapter.ui.AdaWebview adaWebview = this.mAdaWebview;
        if (adaWebview == null) {
            return;
        }
        if (adaWebview.hasErrorPage) {
            java.lang.String errorPage = getErrorPage();
            if (!io.dcloud.common.util.PdrUtil.isEquals(str, errorPage) && ((!"data:text/html,chromewebdata".equals(str) || !"none".equals(errorPage)) && (io.dcloud.common.util.PdrUtil.isEmpty(this.mAdaWebview.errorPageUrl) || !this.mAdaWebview.errorPageUrl.equals(str)))) {
                io.dcloud.common.adapter.ui.AdaWebview adaWebview2 = this.mAdaWebview;
                adaWebview2.hasErrorPage = false;
                adaWebview2.errorPageUrl = null;
            }
        }
        io.dcloud.common.adapter.util.Logger.i(TAG, "onPageStarted url=" + str);
        this.mAdaWebview.onPageStarted();
        printOpenLog(webView, str);
        if (this.mAdaWebview.hadClearHistory(str)) {
            return;
        }
        if (this.mAdaWebview.mPlusrequire.equals("ahead")) {
            listenPlusInjectTimeout(webView, str, "onPageStarted");
        }
        if (!str.startsWith("data:")) {
            this.mAdaWebview.getDCWebView().setUrlStr(str);
        }
        this.mAdaWebview.resetPlusLoadSaveData();
        if (!io.dcloud.common.util.PdrUtil.isEmpty(this.mAdaWebview.getDCWebView().getUrlStr())) {
            io.dcloud.common.adapter.ui.AdaWebview adaWebview3 = this.mAdaWebview;
            adaWebview3.mFrameView.dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENTS_WINDOW_CLOSE, adaWebview3);
        }
        this.mAdaWebview.dispatchWebviewStateEvent(0, str);
        io.dcloud.common.adapter.ui.AdaWebview adaWebview4 = this.mAdaWebview;
        io.dcloud.common.adapter.ui.AdaFrameView adaFrameView = adaWebview4.mFrameView;
        adaFrameView.dispatchFrameViewEvents("loading", adaWebview4);
        if (adaFrameView.obtainStatus() != 3) {
            adaFrameView.onPreLoading();
        }
        super.onPageStarted(webView, str, bitmap);
        if (this.mAdaWebview.mFrameView.getFrameType() == 3) {
            try {
                if (this.mWaitingForWapPage == null) {
                    this.mWaitingForWapPage = new android.widget.ProgressBar(this.mAdaWebview.getContext());
                    int i = io.dcloud.common.adapter.util.AndroidResources.mResources.getDisplayMetrics().widthPixels;
                    int i2 = io.dcloud.common.adapter.util.AndroidResources.mResources.getDisplayMetrics().heightPixels;
                    int i3 = io.dcloud.common.util.PdrUtil.parseInt("7%", i, -1);
                    ((android.view.ViewGroup) this.mAdaWebview.obtainFrameView().obtainMainView()).addView(this.mWaitingForWapPage, new android.widget.AbsoluteLayout.LayoutParams(i3, i3, (i - i3) / 2, (i2 - i3) / 2));
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        java.lang.Object titleNView = io.dcloud.common.util.TitleNViewUtil.getTitleNView(this.mAdaWebview.obtainFrameView().obtainWindowMgr(), this.mAdaWebview.obtainFrameView().obtainWebView(), this.mAdaWebview.obtainFrameView(), io.dcloud.common.util.TitleNViewUtil.getTitleNViewId(this.mAdaWebview.obtainFrameView()));
        if (titleNView instanceof io.dcloud.common.DHInterface.ITitleNView) {
            if (this.mTitleNViewProgressStop != null) {
                io.dcloud.common.util.TitleNViewUtil.stopProcess((io.dcloud.common.DHInterface.ITitleNView) titleNView);
                this.mAdaWebview.obtainWindowView().removeCallbacks(this.mTitleNViewProgressStop);
                this.mTitleNViewProgressStop = null;
            }
            this.mTitleNViewProgressStop = new io.dcloud.common.adapter.ui.webview.WebLoadEvent.TitleNViewProgressStop(this.mAdaWebview);
            io.dcloud.common.util.TitleNViewUtil.startProcess((io.dcloud.common.DHInterface.ITitleNView) titleNView);
            this.mAdaWebview.obtainWindowView().postDelayed(this.mTitleNViewProgressStop, 6000L);
        }
        if (io.dcloud.common.util.PdrUtil.isEmpty(this.mdcloudwebviewclientlister)) {
            return;
        }
        this.mdcloudwebviewclientlister.onPageStarted(webView, str, bitmap);
    }

    public void onPreloadJSContent(android.webkit.WebView webView, java.lang.String str, java.lang.String str2) {
        if (this.mAdaWebview.obtainFrameView().obtainApp() == null || this.mAdaWebview.obtainFrameView().obtainApp().manifestBeParsed()) {
            io.dcloud.common.adapter.ui.AdaWebview adaWebview = this.mAdaWebview;
            if (adaWebview.mPreloadJsLoaded) {
                io.dcloud.common.adapter.util.Logger.i(TAG, "mPreloadJs 已经提前注入JS完成。不需要再注入了" + this.mAdaWebview.getOriginalUrl());
                return;
            }
            java.lang.String preLoadJsString = adaWebview.getPreLoadJsString();
            if (!io.dcloud.common.util.PdrUtil.isEmpty(preLoadJsString)) {
                this.mAdaWebview.mPreloadJsLoading = true;
                io.dcloud.common.adapter.util.Logger.i(TAG, " tag=" + str2 + ";url=" + str);
                completeLoadJs(webView, str, str2, new java.lang.String[]{preLoadJsString}, IF_PRELOAD_TEMPLATE, this.mAdaWebview.mPreloadJsFile);
                this.mAdaWebview.mPreloadJsLoaded = true;
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(android.webkit.WebView webView, int i, java.lang.String str, final java.lang.String str2) {
        if (this.mAdaWebview == null) {
            return;
        }
        io.dcloud.common.adapter.util.Logger.e(TAG, "onReceivedError description=" + str + ";failingUrl=" + str2 + ";errorCode=" + i);
        this.mAdaWebview.dispatchWebviewStateEvent(5, str);
        io.dcloud.common.adapter.ui.AdaWebview adaWebview = this.mAdaWebview;
        adaWebview.mFrameView.dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENTS_FAILED, adaWebview);
        io.dcloud.common.adapter.ui.AdaWebview adaWebview2 = this.mAdaWebview;
        adaWebview2.hasErrorPage = true;
        adaWebview2.errorPageUrl = str2;
        final io.dcloud.common.DHInterface.IApp iAppObtainApp = adaWebview2.mFrameView.obtainApp();
        if (iAppObtainApp != null) {
            try {
                if (io.dcloud.common.util.BaseInfo.isWap2AppAppid(iAppObtainApp.obtainAppId()) && this.mAdaWebview.mFrameView.getFrameType() == 2 && !android.text.TextUtils.equals("none", iAppObtainApp.obtainConfigProperty("launchError"))) {
                    android.content.Context context = this.mAdaWebview.getContext();
                    final android.app.AlertDialog alertDialogCreate = new android.app.AlertDialog.Builder(context).create();
                    alertDialogCreate.setTitle(io.dcloud.base.R.string.dcloud_common_tips);
                    alertDialogCreate.setCanceledOnTouchOutside(false);
                    alertDialogCreate.setMessage(context.getString(io.dcloud.base.R.string.dcloud_common_no_network_tips));
                    android.content.DialogInterface.OnClickListener onClickListener = new android.content.DialogInterface.OnClickListener() { // from class: io.dcloud.common.adapter.ui.webview.WebLoadEvent.3
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(android.content.DialogInterface dialogInterface, int i2) {
                            if (i2 == -2) {
                                io.dcloud.common.adapter.ui.webview.WebLoadEvent.this.mAdaWebview.getActivity().startActivity(new android.content.Intent("android.settings.SETTINGS"));
                            } else if (i2 == -3) {
                                io.dcloud.common.adapter.util.Logger.e(io.dcloud.common.adapter.ui.webview.WebLoadEvent.TAG, "onReceivedError try again");
                                io.src.dcloud.adapter.DCloudAdapterUtil.getIActivityHandler(io.dcloud.common.adapter.ui.webview.WebLoadEvent.this.mAdaWebview.getActivity());
                                io.dcloud.common.adapter.ui.webview.WebLoadEvent.this.mAdaWebview.loadUrl(str2);
                            } else if (i2 == -1) {
                                android.app.Activity activity = io.dcloud.common.adapter.ui.webview.WebLoadEvent.this.mAdaWebview.getActivity();
                                io.src.dcloud.adapter.DCloudAdapterUtil.getIActivityHandler(activity).updateParam("closewebapp", activity);
                            }
                            alertDialogCreate.dismiss();
                        }
                    };
                    alertDialogCreate.setOnKeyListener(new android.content.DialogInterface.OnKeyListener() { // from class: io.dcloud.common.adapter.ui.webview.WebLoadEvent.4
                        @Override // android.content.DialogInterface.OnKeyListener
                        public boolean onKey(android.content.DialogInterface dialogInterface, int i2, android.view.KeyEvent keyEvent) {
                            if (i2 != 4) {
                                return false;
                            }
                            alertDialogCreate.dismiss();
                            android.app.Activity activity = io.dcloud.common.adapter.ui.webview.WebLoadEvent.this.mAdaWebview.getActivity();
                            io.src.dcloud.adapter.DCloudAdapterUtil.getIActivityHandler(activity).updateParam("closewebapp", activity);
                            return false;
                        }
                    });
                    alertDialogCreate.setButton(-2, context.getString(io.dcloud.base.R.string.dcloud_common_set_network), onClickListener);
                    alertDialogCreate.setButton(-3, context.getString(io.dcloud.base.R.string.dcloud_common_retry), onClickListener);
                    alertDialogCreate.setButton(-1, context.getString(io.dcloud.base.R.string.dcloud_common_exit), onClickListener);
                    alertDialogCreate.show();
                    iAppObtainApp.registerSysEventListener(new io.dcloud.common.DHInterface.ISysEventListener() { // from class: io.dcloud.common.adapter.ui.webview.WebLoadEvent.5
                        @Override // io.dcloud.common.DHInterface.ISysEventListener
                        public boolean onExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, java.lang.Object obj) {
                            io.dcloud.common.adapter.ui.AdaWebview adaWebview3;
                            if (io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onResume != sysEventType || (adaWebview3 = io.dcloud.common.adapter.ui.webview.WebLoadEvent.this.mAdaWebview) == null) {
                                return false;
                            }
                            adaWebview3.obtainMainView().postDelayed(new java.lang.Runnable() { // from class: io.dcloud.common.adapter.ui.webview.WebLoadEvent.5.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    io.dcloud.common.adapter.util.Logger.e(io.dcloud.common.adapter.ui.webview.WebLoadEvent.TAG, "onReceivedError 500ms retry after the onResume");
                                    io.src.dcloud.adapter.DCloudAdapterUtil.getIActivityHandler(io.dcloud.common.adapter.ui.webview.WebLoadEvent.this.mAdaWebview.getActivity());
                                    io.dcloud.common.adapter.ui.webview.WebLoadEvent.AnonymousClass5 anonymousClass5 = io.dcloud.common.adapter.ui.webview.WebLoadEvent.AnonymousClass5.this;
                                    io.dcloud.common.adapter.ui.webview.WebLoadEvent.this.mAdaWebview.loadUrl(str2);
                                }
                            }, 500L);
                            iAppObtainApp.unregisterSysEventListener(this, sysEventType);
                            return false;
                        }
                    }, io.dcloud.common.DHInterface.ISysEventListener.SysEventType.onResume);
                    io.dcloud.common.adapter.util.Logger.e(TAG, "onReceivedError do clearHistory");
                    this.mAdaWebview.clearHistory();
                } else {
                    java.lang.String errorPage = getErrorPage();
                    if ("none".equals(errorPage)) {
                        this.mAdaWebview.hasErrorPage = false;
                    } else {
                        io.dcloud.common.adapter.util.Logger.e(TAG, "onReceivedError  load errorPage " + errorPage);
                        this.mAdaWebview.loadUrl(errorPage);
                    }
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        if (io.dcloud.common.util.PdrUtil.isEmpty(this.mdcloudwebviewclientlister)) {
            return;
        }
        this.mdcloudwebviewclientlister.onReceivedError(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(android.webkit.WebView webView, final android.webkit.SslErrorHandler sslErrorHandler, final android.net.http.SslError sslError) {
        io.dcloud.common.adapter.ui.AdaWebview adaWebview = this.mAdaWebview;
        if (adaWebview == null || adaWebview.obtainApp() == null) {
            return;
        }
        java.lang.String strObtainConfigProperty = this.mAdaWebview.obtainApp().obtainConfigProperty(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_UNTRUSTEDCA);
        io.dcloud.common.adapter.util.Logger.i("onReceivedSslError", "onReceivedSslError++type====" + strObtainConfigProperty);
        if (io.dcloud.common.util.PdrUtil.isEquals(strObtainConfigProperty, "refuse")) {
            sslErrorHandler.cancel();
        } else if (io.dcloud.common.util.PdrUtil.isEquals(strObtainConfigProperty, "warning")) {
            android.content.Context context = webView.getContext();
            final android.app.AlertDialog alertDialogCreate = new android.app.AlertDialog.Builder(context).create();
            alertDialogCreate.setIcon(android.R.drawable.ic_secure);
            alertDialogCreate.setTitle(io.dcloud.base.R.string.dcloud_common_safety_warning);
            alertDialogCreate.setCanceledOnTouchOutside(false);
            java.lang.String url = sslError.getUrl();
            java.lang.String string = context.getString(io.dcloud.base.R.string.dcloud_common_certificate_continue);
            if (!android.text.TextUtils.isEmpty(url)) {
                string = url + "\n" + string;
            }
            alertDialogCreate.setMessage(string);
            android.content.DialogInterface.OnClickListener onClickListener = new android.content.DialogInterface.OnClickListener() { // from class: io.dcloud.common.adapter.ui.webview.WebLoadEvent.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(android.content.DialogInterface dialogInterface, int i) {
                    if (i == -2) {
                        alertDialogCreate.cancel();
                        alertDialogCreate.dismiss();
                    } else if (i == -3) {
                        sslError.getCertificate().getIssuedBy();
                    } else if (i == -1) {
                        io.dcloud.common.adapter.ui.webview.WebViewFactory.setSslHandlerState(sslErrorHandler, 1);
                        alertDialogCreate.dismiss();
                    }
                }
            };
            alertDialogCreate.setButton(-2, context.getResources().getString(android.R.string.cancel), onClickListener);
            alertDialogCreate.setButton(-1, context.getResources().getString(android.R.string.ok), onClickListener);
            alertDialogCreate.show();
        } else {
            io.dcloud.common.adapter.ui.webview.WebViewFactory.setSslHandlerState(sslErrorHandler, 1);
        }
        if (io.dcloud.common.util.PdrUtil.isEmpty(this.mdcloudwebviewclientlister)) {
            return;
        }
        this.mdcloudwebviewclientlister.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    @Override // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(android.webkit.WebView webView, android.view.KeyEvent keyEvent) {
        super.onUnhandledKeyEvent(webView, keyEvent);
        if (webView instanceof io.dcloud.common.adapter.ui.webview.SysWebView) {
            io.dcloud.common.adapter.ui.webview.SysWebView sysWebView = (io.dcloud.common.adapter.ui.webview.SysWebView) webView;
            if (keyEvent.getAction() == 0) {
                sysWebView.doKeyDownAction(keyEvent.getKeyCode(), keyEvent);
            } else if (keyEvent.getAction() == 1) {
                sysWebView.doKeyUpAction(keyEvent.getKeyCode(), keyEvent);
            }
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void onUpdatePlusData(android.webkit.WebView webView, java.lang.String str, java.lang.String str2) {
        io.dcloud.common.adapter.ui.AdaWebview adaWebview = this.mAdaWebview;
        adaWebview.executeScript(adaWebview.getScreenAndDisplayJson(adaWebview));
        onExecuteEvalJSStatck(webView, str, str2);
    }

    public void reset() {
        this.mPlusJS = "(function(){/*console.log('all.js loading href=' + location.href);*/if(location.__page__load__over__){return 2}if(!location.__plusready__){location.__plusready__=true;return 1}else{return 2}return 0})();\n" + this.mAdaWebview.mFrameView.obtainPrePlusreadyJs() + "\nwindow.plus && (plus.android.import=plus.android.importClass);";
    }

    public void setDcloudwebviewclientListener(io.dcloud.common.DHInterface.IDCloudWebviewClientListener iDCloudWebviewClientListener) {
        this.mdcloudwebviewclientlister = iDCloudWebviewClientListener;
    }

    public void setPageFinishedCallack(io.dcloud.common.adapter.ui.webview.OnPageFinishedCallack onPageFinishedCallack) {
        this.mPageFinishedCallack = onPageFinishedCallack;
    }

    /* JADX WARN: Code duplicated, block: B:111:0x01e0 A[Catch: Exception -> 0x023d, TRY_ENTER, TryCatch #0 {Exception -> 0x023d, blocks: (B:100:0x01bb, B:102:0x01c7, B:104:0x01cf, B:111:0x01e0, B:113:0x01e6, B:115:0x01ec), top: B:193:0x01bb }] */
    /* JADX WARN: Code duplicated, block: B:121:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:124:0x0208 A[Catch: Exception -> 0x0264, TryCatch #5 {Exception -> 0x0264, blocks: (B:117:0x01ef, B:145:0x0246, B:147:0x024e, B:149:0x0256, B:151:0x025c, B:122:0x01fc, B:124:0x0208, B:126:0x020e, B:128:0x0214, B:130:0x021a, B:132:0x0224, B:134:0x0228, B:136:0x022e, B:138:0x0236), top: B:203:0x01b9 }] */
    /* JADX WARN: Code duplicated, block: B:132:0x0224 A[Catch: Exception -> 0x0264, TryCatch #5 {Exception -> 0x0264, blocks: (B:117:0x01ef, B:145:0x0246, B:147:0x024e, B:149:0x0256, B:151:0x025c, B:122:0x01fc, B:124:0x0208, B:126:0x020e, B:128:0x0214, B:130:0x021a, B:132:0x0224, B:134:0x0228, B:136:0x022e, B:138:0x0236), top: B:203:0x01b9 }] */
    /* JADX WARN: Code duplicated, block: B:134:0x0228 A[Catch: Exception -> 0x0264, TryCatch #5 {Exception -> 0x0264, blocks: (B:117:0x01ef, B:145:0x0246, B:147:0x024e, B:149:0x0256, B:151:0x025c, B:122:0x01fc, B:124:0x0208, B:126:0x020e, B:128:0x0214, B:130:0x021a, B:132:0x0224, B:134:0x0228, B:136:0x022e, B:138:0x0236), top: B:203:0x01b9 }] */
    /* JADX WARN: Code duplicated, block: B:136:0x022e A[Catch: Exception -> 0x0264, TryCatch #5 {Exception -> 0x0264, blocks: (B:117:0x01ef, B:145:0x0246, B:147:0x024e, B:149:0x0256, B:151:0x025c, B:122:0x01fc, B:124:0x0208, B:126:0x020e, B:128:0x0214, B:130:0x021a, B:132:0x0224, B:134:0x0228, B:136:0x022e, B:138:0x0236), top: B:203:0x01b9 }] */
    /* JADX WARN: Code duplicated, block: B:189:0x0303  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12, types: [io.dcloud.common.adapter.ui.webview.WebLoadEvent] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14, types: [io.dcloud.common.adapter.ui.webview.WebLoadEvent] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v3, types: [io.dcloud.common.adapter.ui.webview.WebLoadEvent] */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r5v36 */
    /* JADX WARN: Type inference failed for: r5v37 */
    /* JADX WARN: Type inference failed for: r5v4, types: [io.dcloud.common.adapter.ui.webview.WebLoadEvent] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // android.webkit.WebViewClient
    public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView webView, java.lang.String str) {
        java.lang.String str2;
        java.lang.Exception exc;
        ?? r5;
        io.dcloud.common.adapter.ui.webview.WebLoadEvent webLoadEvent;
        boolean z;
        io.dcloud.common.adapter.ui.AdaWebview adaWebview;
        android.webkit.WebResourceResponse webResourceResponseDownloadResponseInjection;
        org.json.JSONObject jSONObject;
        java.io.File file;
        java.lang.String str3;
        java.lang.String str4;
        java.io.File file2;
        if (this.mAdaWebview == null) {
            return null;
        }
        android.webkit.WebResourceResponse webResourceResponseShouldInterceptRequest = super.shouldInterceptRequest(webView, str);
        android.webkit.WebResourceResponse webResourceResponseShouldInterceptRequest2 = super.shouldInterceptRequest(webView, str);
        if (!io.dcloud.common.util.PdrUtil.isEmpty(this.mdcloudwebviewclientlister)) {
            webResourceResponseShouldInterceptRequest2 = this.mdcloudwebviewclientlister.shouldInterceptRequest(webView, str);
        }
        android.webkit.WebResourceResponse webResourceResponse = webResourceResponseShouldInterceptRequest2;
        android.webkit.WebResourceResponse webResourceResponseCheckWebResourceResponseRedirect = checkWebResourceResponseRedirect(webView, str);
        if (webResourceResponseCheckWebResourceResponseRedirect != null) {
            return webResourceResponseCheckWebResourceResponseRedirect;
        }
        java.lang.String str5 = "image/gif";
        if (!io.dcloud.common.util.PdrUtil.isEmpty(str)) {
            if (str.startsWith("plusfile://")) {
                java.lang.String strReplace = str.replace("plusfile://", "");
                if (strReplace.startsWith(io.dcloud.common.util.BaseInfo.REL_PUBLIC_DOWNLOADS_DIR) || strReplace.startsWith(io.dcloud.common.util.BaseInfo.REL_PRIVATE_DOC_DIR) || strReplace.startsWith(io.dcloud.common.util.BaseInfo.REL_PUBLIC_DOCUMENTS_DIR)) {
                    java.lang.String strConvert2WebviewFullPath = this.mAdaWebview.obtainApp().convert2WebviewFullPath(null, strReplace);
                    if (strConvert2WebviewFullPath.startsWith("file:///")) {
                        strConvert2WebviewFullPath = strConvert2WebviewFullPath.substring(7);
                    }
                    if (strConvert2WebviewFullPath.startsWith(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL)) {
                        strConvert2WebviewFullPath = strConvert2WebviewFullPath.substring(6);
                    }
                    file2 = new java.io.File(strConvert2WebviewFullPath);
                } else {
                    file2 = new java.io.File(strReplace);
                }
                if (file2.exists()) {
                    try {
                        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file2);
                        java.lang.String mimeType = io.dcloud.common.util.PdrUtil.getMimeType(str);
                        if (str.contains(".jpg")) {
                            mimeType = "image/jpeg";
                        } else if (str.contains(".png")) {
                            mimeType = "image/png";
                        } else if (str.contains(".gif")) {
                            mimeType = "image/gif";
                        }
                        return new android.webkit.WebResourceResponse(mimeType, null, fileInputStream);
                    } catch (java.io.FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            } else if (str.contains("h5pscript://")) {
                java.io.InputStream encryptionInputStream = io.dcloud.common.adapter.ui.webview.WebResUtil.getEncryptionInputStream(str.substring(str.indexOf("h5pscript://") + 12), this.mAdaWebview.obtainApp());
                java.lang.String mimeType2 = io.dcloud.common.util.PdrUtil.getMimeType(str);
                if (encryptionInputStream != null) {
                    if (str.contains(".jpg")) {
                        str4 = "image/jpeg";
                    } else if (str.contains(".png")) {
                        str4 = "image/png";
                    } else if (!str.contains(".gif")) {
                        str4 = str5;
                        str4 = mimeType2;
                    }
                    str4 = str5;
                    return new android.webkit.WebResourceResponse(str4, null, encryptionInputStream);
                }
            } else if (str.startsWith("plus-confusion://")) {
                java.io.InputStream encryptionInputStream2 = io.dcloud.common.adapter.ui.webview.WebResUtil.getEncryptionInputStream(this.mAdaWebview.obtainApp().convert2WebviewFullPath(this.mAdaWebview.obtainFullUrl(), str.substring(17)), this.mAdaWebview.obtainApp());
                java.lang.String mimeType3 = io.dcloud.common.util.PdrUtil.getMimeType(str);
                if (encryptionInputStream2 != null) {
                    return new android.webkit.WebResourceResponse(mimeType3, null, encryptionInputStream2);
                }
            }
        }
        ?? r6 = str5;
        if (io.dcloud.common.util.ImageLoaderUtil.isDownload(str) && (file = com.nostra13.dcloudimageloader.core.ImageLoaderL.getInstance().getDiscCache().get(str)) != null && file.exists()) {
            java.lang.String mimeType4 = io.dcloud.common.util.PdrUtil.getMimeType(str);
            if (str.contains(".jpg")) {
                r6 = str5;
                r6 = str5;
                str3 = "image/jpeg";
            } else if (str.contains(".png")) {
                r6 = str5;
                r6 = str5;
                str3 = "image/png";
            } else if (!str.contains(".gif")) {
                r6 = str5;
                r6 = str5;
                str3 = str5;
                str3 = mimeType4;
            }
            try {
                r6 = str5;
                r6 = str5;
                str3 = str5;
                return new android.webkit.WebResourceResponse(str3, null, new java.io.FileInputStream(file));
            } catch (java.io.FileNotFoundException e2) {
                e2.printStackTrace();
                r6 = str3;
            }
        }
        r6 = str5;
        r6 = str5;
        r6 = str5;
        io.dcloud.common.adapter.ui.AdaWebview adaWebview2 = this.mAdaWebview;
        io.dcloud.common.adapter.ui.AdaWebview.OverrideResourceRequestItem overrideResourceRequestItemCheckResourceRequestUrl = adaWebview2 != null ? adaWebview2.checkResourceRequestUrl(str) : null;
        io.dcloud.common.adapter.ui.AdaWebview adaWebview3 = this.mAdaWebview;
        if (adaWebview3 == null) {
            return webResourceResponseShouldInterceptRequest;
        }
        java.lang.String str6 = adaWebview3.mEncoding;
        if (overrideResourceRequestItemCheckResourceRequestUrl != null) {
            str = overrideResourceRequestItemCheckResourceRequestUrl.redirect;
            str6 = overrideResourceRequestItemCheckResourceRequestUrl.encoding;
            str2 = overrideResourceRequestItemCheckResourceRequestUrl.mime;
        } else {
            str2 = "application/x-javascript";
        }
        java.lang.String str7 = str6;
        java.lang.String str8 = str;
        java.lang.String str9 = str2;
        try {
            io.dcloud.common.adapter.util.Logger.i(TAG, "shouldInterceptRequest url=" + str8 + ";withJs=" + this.mAdaWebview.mInjectPlusWidthJs);
            android.webkit.WebResourceResponse webResourceResponseHandleDecode = handleDecode(str8, webResourceResponseShouldInterceptRequest);
            try {
                if (webResourceResponseHandleDecode == null) {
                    try {
                        if (this.mAdaWebview.mPlusrequire.equals("ahead") && this.mAdaWebview.hasPreLoadJsFile()) {
                            java.lang.String str10 = this.mAdaWebview.mInjectPlusWidthJs;
                            if (str10 != null) {
                                try {
                                    if (!android.text.TextUtils.equals(str10, str8)) {
                                        webLoadEvent = this;
                                        if (android.text.TextUtils.isEmpty(webLoadEvent.mAdaWebview.getCssString())) {
                                            z = webLoadEvent.isInitAmapGEO;
                                            r6 = webLoadEvent;
                                            if (z) {
                                                adaWebview = webLoadEvent.mAdaWebview;
                                                if (adaWebview.mInjectGeoLoaded) {
                                                }
                                            }
                                        } else {
                                            z = webLoadEvent.isInitAmapGEO;
                                            r6 = webLoadEvent;
                                            if (z) {
                                                adaWebview = webLoadEvent.mAdaWebview;
                                                if (adaWebview.mInjectGeoLoaded) {
                                                }
                                            }
                                        }
                                    } else if (io.dcloud.common.util.PdrUtil.isNetPath(str8) || !checkJsFile(str8)) {
                                        webLoadEvent = this;
                                        if (android.text.TextUtils.isEmpty(webLoadEvent.mAdaWebview.getCssString())) {
                                            z = webLoadEvent.isInitAmapGEO;
                                            r6 = webLoadEvent;
                                            if (z) {
                                                adaWebview = webLoadEvent.mAdaWebview;
                                                if (adaWebview.mInjectGeoLoaded) {
                                                }
                                            }
                                        } else {
                                            z = webLoadEvent.isInitAmapGEO;
                                            r6 = webLoadEvent;
                                            if (z) {
                                                adaWebview = webLoadEvent.mAdaWebview;
                                                if (adaWebview.mInjectGeoLoaded) {
                                                }
                                            }
                                        }
                                    } else {
                                        r6 = this;
                                        webResourceResponseShouldInterceptRequest = r6.downloadResponseInjection(webResourceResponseHandleDecode, str8, str9, str7, this.TYPE_JS);
                                        if (webResourceResponseShouldInterceptRequest != null) {
                                            try {
                                                r6.mAdaWebview.mInjectPlusWidthJs = str8;
                                            } catch (java.lang.Exception e3) {
                                                e = e3;
                                                exc = e;
                                                r6 = r6;
                                                exc.printStackTrace();
                                                io.dcloud.common.adapter.util.Logger.e(r6.mAppid + ";url=" + str8);
                                            }
                                        }
                                        webResourceResponseHandleDecode = webResourceResponseShouldInterceptRequest;
                                        r6 = r6;
                                    }
                                } catch (java.lang.Exception e4) {
                                    exc = e4;
                                    r5 = this;
                                    webResourceResponseShouldInterceptRequest = webResourceResponseHandleDecode;
                                    r6 = r5;
                                    exc.printStackTrace();
                                    io.dcloud.common.adapter.util.Logger.e(r6.mAppid + ";url=" + str8);
                                }
                            } else if (io.dcloud.common.util.PdrUtil.isNetPath(str8)) {
                                webLoadEvent = this;
                                if (android.text.TextUtils.isEmpty(webLoadEvent.mAdaWebview.getCssString())) {
                                    z = webLoadEvent.isInitAmapGEO;
                                    r6 = webLoadEvent;
                                    if (z) {
                                        adaWebview = webLoadEvent.mAdaWebview;
                                        if (adaWebview.mInjectGeoLoaded) {
                                        }
                                    }
                                } else {
                                    z = webLoadEvent.isInitAmapGEO;
                                    r6 = webLoadEvent;
                                    if (z) {
                                        adaWebview = webLoadEvent.mAdaWebview;
                                        if (adaWebview.mInjectGeoLoaded) {
                                        }
                                    }
                                }
                            } else {
                                webLoadEvent = this;
                                if (android.text.TextUtils.isEmpty(webLoadEvent.mAdaWebview.getCssString())) {
                                    z = webLoadEvent.isInitAmapGEO;
                                    r6 = webLoadEvent;
                                    if (z) {
                                        adaWebview = webLoadEvent.mAdaWebview;
                                        if (adaWebview.mInjectGeoLoaded) {
                                        }
                                    }
                                } else {
                                    z = webLoadEvent.isInitAmapGEO;
                                    r6 = webLoadEvent;
                                    if (z) {
                                        adaWebview = webLoadEvent.mAdaWebview;
                                        if (adaWebview.mInjectGeoLoaded) {
                                        }
                                    }
                                }
                            }
                        } else {
                            webLoadEvent = this;
                            if (android.text.TextUtils.isEmpty(webLoadEvent.mAdaWebview.getCssString()) || webLoadEvent.mAdaWebview.mIsAdvanceCss || !io.dcloud.common.util.PdrUtil.isNetPath(str8) || !checkCssFile(str8)) {
                                z = webLoadEvent.isInitAmapGEO;
                                r6 = webLoadEvent;
                                if (z) {
                                    adaWebview = webLoadEvent.mAdaWebview;
                                    if (adaWebview.mInjectGeoLoaded && io.dcloud.common.util.DLGeolocation.checkInjectGeo(adaWebview.mInjectGEO)) {
                                        r6 = webLoadEvent;
                                        r6 = webLoadEvent;
                                        webResourceResponseDownloadResponseInjection = webLoadEvent.downloadResponseInjection(webResourceResponseHandleDecode, str8, str9, str7, webLoadEvent.TYPE_JS);
                                    }
                                    e = e3;
                                    exc = e;
                                    r6 = r6;
                                    exc.printStackTrace();
                                    io.dcloud.common.adapter.util.Logger.e(r6.mAppid + ";url=" + str8);
                                }
                            } else {
                                str9 = "text/css";
                                webResourceResponseDownloadResponseInjection = webLoadEvent.downloadResponseInjection(webResourceResponseHandleDecode, str8, "text/css", str7, webLoadEvent.TYPE_CSS);
                            }
                            webResourceResponseHandleDecode = webResourceResponseDownloadResponseInjection;
                            r6 = webLoadEvent;
                        }
                    } catch (java.lang.Exception e5) {
                        e = e5;
                        r6 = this;
                        exc = e;
                        r5 = r6;
                        webResourceResponseShouldInterceptRequest = webResourceResponseHandleDecode;
                        r6 = r5;
                        exc.printStackTrace();
                        io.dcloud.common.adapter.util.Logger.e(r6.mAppid + ";url=" + str8);
                        if (io.dcloud.common.util.PdrUtil.isEmpty(r6.mdcloudwebviewclientlister)) {
                        }
                    }
                    return (!io.dcloud.common.util.PdrUtil.isEmpty(r6.mdcloudwebviewclientlister) || io.dcloud.common.util.PdrUtil.isEmpty(webResourceResponse)) ? webResourceResponseShouldInterceptRequest : webResourceResponse;
                }
                r6 = this;
                webResourceResponseShouldInterceptRequest = (webResourceResponseHandleDecode != null || io.dcloud.common.util.BaseInfo.isWap2AppAppid(r6.mAppid) || !PLUSREADY.equals(str8) || r6.mAdaWebview.mPlusLoaded) ? webResourceResponseHandleDecode : r6.downloadResponseInjection(webResourceResponseHandleDecode, str8, str9, str7, r6.TYPE_JS);
                if (webResourceResponseShouldInterceptRequest == null) {
                    io.dcloud.common.util.BaseInfo.isUniAppAppid(r6.mAdaWebview.obtainApp());
                }
                if (webResourceResponseShouldInterceptRequest == null && overrideResourceRequestItemCheckResourceRequestUrl != null) {
                    try {
                        webResourceResponseShouldInterceptRequest = new android.webkit.WebResourceResponse(str9, str7, new java.io.FileInputStream(str8));
                    } catch (java.io.FileNotFoundException e6) {
                        e6.printStackTrace();
                    }
                }
                if (webResourceResponseShouldInterceptRequest != null) {
                    java.util.Map<java.lang.String, java.lang.String> responseHeaders = webResourceResponseShouldInterceptRequest.getResponseHeaders();
                    if (responseHeaders == null) {
                        responseHeaders = new java.util.HashMap<>();
                    }
                    responseHeaders.put("Access-Control-Allow-Credentials", io.dcloud.common.constant.AbsoluteConst.TRUE);
                    responseHeaders.put("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
                    responseHeaders.put("Access-Control-Allow-Origin", "*");
                    if (overrideResourceRequestItemCheckResourceRequestUrl != null && (jSONObject = overrideResourceRequestItemCheckResourceRequestUrl.headerJson) != null) {
                        java.util.Iterator<java.lang.String> itKeys = jSONObject.keys();
                        if (overrideResourceRequestItemCheckResourceRequestUrl.headerJson.length() > 0) {
                            while (itKeys.hasNext()) {
                                java.lang.String next = itKeys.next();
                                responseHeaders.put(next, overrideResourceRequestItemCheckResourceRequestUrl.headerJson.opt(next).toString());
                            }
                        }
                    }
                    webResourceResponseShouldInterceptRequest.setResponseHeaders(responseHeaders);
                    return webResourceResponseShouldInterceptRequest;
                }
            } catch (java.lang.Exception e7) {
                e = e7;
            }
        } catch (java.lang.Exception e8) {
            e = e8;
            r6 = this;
        }
        if (io.dcloud.common.util.PdrUtil.isEmpty(r6.mdcloudwebviewclientlister)) {
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(android.webkit.WebView webView, android.view.KeyEvent keyEvent) {
        return false;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str) {
        if (this.mAdaWebview == null) {
            return false;
        }
        io.dcloud.common.adapter.util.Logger.e(TAG, "shouldOverrideUrlLoading url=" + str);
        io.dcloud.common.adapter.ui.AdaWebview adaWebview = this.mAdaWebview;
        adaWebview.mProgressIntValue = 0;
        adaWebview.mRecordLastUrl = str;
        if (adaWebview.checkOverrideUrl(str)) {
            io.dcloud.common.adapter.util.Logger.e(TAG, "检测拦截回调shouldOverrideUrlLoading url=" + str);
            this.mAdaWebview.mFrameView.dispatchFrameViewEvents(io.dcloud.common.constant.AbsoluteConst.EVENTS_OVERRIDE_URL_LOADING, "{url:'" + str + "'}");
            return true;
        }
        if (this.mAdaWebview.mFrameView.getFrameType() == 5 || (this.mAdaWebview.mFrameView.getFrameType() == 2 && directPageIsLaunchPage(this.mAdaWebview.obtainApp()))) {
            this.mAdaWebview.obtainApp().updateDirectPage(str);
        }
        if (shouldRuntimeHandle(str) || this.mAdaWebview.mFrameView.getFrameType() == 6) {
            if (io.dcloud.common.util.PdrUtil.isEmpty(this.mdcloudwebviewclientlister)) {
                return false;
            }
            return this.mdcloudwebviewclientlister.shouldOverrideUrlLoading(webView, str);
        }
        try {
            if (str.startsWith("sms:")) {
                int iIndexOf = str.indexOf("sms:");
                int iIndexOf2 = str.indexOf(com.taobao.weex.el.parse.Operators.CONDITION_IF_STRING);
                if (iIndexOf2 == -1) {
                    this.mAdaWebview.getActivity().startActivity(new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(str)));
                    return true;
                }
                java.lang.String strSubstring = str.substring(iIndexOf + 4, iIndexOf2);
                java.lang.String strSubstring2 = str.substring(iIndexOf2 + 1);
                android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse("sms:" + strSubstring));
                intent.putExtra("address", strSubstring);
                intent.putExtra("sms_body", strSubstring2);
                this.mAdaWebview.getActivity().startActivity(intent);
            } else if (str.startsWith("intent://")) {
                android.content.Intent uri = android.content.Intent.parseUri(str, 1);
                uri.addCategory("android.intent.category.BROWSABLE");
                uri.setComponent(null);
                uri.setSelector(null);
                if (this.mAdaWebview.getActivity().getPackageManager().queryIntentActivities(uri, 0).size() > 0) {
                    this.mAdaWebview.getActivity().startActivityIfNeeded(uri, -1);
                }
            } else {
                io.dcloud.common.adapter.ui.AdaWebview adaWebview2 = this.mAdaWebview;
                if (adaWebview2 != null && adaWebview2.getActivity() != null && this.mAdaWebview.obtainApp().checkSchemeWhite(str)) {
                    this.mAdaWebview.getActivity().startActivity(new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(str)));
                }
            }
        } catch (java.lang.Exception unused) {
            io.dcloud.common.adapter.util.Logger.e(TAG, "ActivityNotFoundException url=" + str);
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0040 A[DONT_INVERT, PHI: r1
  0x0040: PHI (r1v13 char) = (r1v12 char), (r1v16 char) binds: [B:15:0x003a, B:17:0x003e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:19:0x0042 A[Catch: all -> 0x007a, Exception -> 0x007d, TryCatch #4 {Exception -> 0x007d, all -> 0x007a, blocks: (B:9:0x001c, B:20:0x004d, B:19:0x0042, B:21:0x0051, B:23:0x005f, B:25:0x0065, B:26:0x0070), top: B:49:0x001c }] */
    /* JADX WARN: Code duplicated, block: B:20:0x004d A[Catch: all -> 0x007a, Exception -> 0x007d, PHI: r1
  0x004d: PHI (r1v15 char) = (r1v13 char), (r1v18 char) binds: [B:18:0x0040, B:17:0x003e] A[DONT_GENERATE, DONT_INLINE], TryCatch #4 {Exception -> 0x007d, all -> 0x007a, blocks: (B:9:0x001c, B:20:0x004d, B:19:0x0042, B:21:0x0051, B:23:0x005f, B:25:0x0065, B:26:0x0070), top: B:49:0x001c }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    private android.webkit.WebResourceResponse downloadResponse(android.webkit.WebView webView, java.lang.String str, java.lang.String str2, android.webkit.WebResourceResponse webResourceResponse, java.io.File file, boolean z) throws java.lang.Throwable {
        ?? r1;
        if (!android.webkit.URLUtil.isNetworkUrl(str2) || file == null) {
            return webResourceResponse;
        }
        showLoading();
        ?? r2 = 0;
        java.net.HttpURLConnection httpURLConnection = null;
        try {
            try {
                java.net.HttpURLConnection httpURLConnection2 = (java.net.HttpURLConnection) new java.net.URL(str2).openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(com.nostra13.dcloudimageloader.core.download.BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT);
                    httpURLConnection2.setReadTimeout(com.nostra13.dcloudimageloader.core.download.BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT);
                    httpURLConnection2.setRequestMethod("GET");
                    httpURLConnection2.setDoInput(true);
                    int responseCode = httpURLConnection2.getResponseCode();
                    if (responseCode == 200 || responseCode == 206) {
                        java.io.InputStream inputStream = httpURLConnection2.getInputStream();
                        java.lang.String absolutePath = file.getAbsolutePath();
                        if (!io.dcloud.common.adapter.io.DHFile.writeFile(inputStream, absolutePath) && z) {
                            io.dcloud.common.adapter.ui.webview.WebLoadEvent webLoadEvent = this;
                            webLoadEvent.downloadResponse(webView, str, str2, webResourceResponse, file, false);
                            r1 = webLoadEvent;
                        } else {
                            hideLoading();
                            r1 = absolutePath;
                        }
                    } else {
                        char c = 400;
                        if (responseCode >= 400) {
                            c = 500;
                            c = 500;
                            if (responseCode < 500) {
                                hideLoading();
                                r1 = c;
                            } else if (z) {
                                io.dcloud.common.adapter.ui.webview.WebLoadEvent webLoadEvent2 = this;
                                webLoadEvent2.downloadResponse(webView, str, str2, webResourceResponse, file, false);
                                r1 = webLoadEvent2;
                            } else {
                                hideLoading();
                                r1 = c;
                            }
                        } else if (z) {
                            io.dcloud.common.adapter.ui.webview.WebLoadEvent webLoadEvent3 = this;
                            webLoadEvent3.downloadResponse(webView, str, str2, webResourceResponse, file, false);
                            r1 = webLoadEvent3;
                        } else {
                            hideLoading();
                            r1 = c;
                        }
                    }
                    httpURLConnection2.disconnect();
                    hideLoading();
                    r2 = r1;
                } catch (java.lang.Exception e) {
                    e = e;
                    httpURLConnection = httpURLConnection2;
                    e.printStackTrace();
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    hideLoading();
                    r2 = httpURLConnection;
                } catch (java.lang.Throwable th) {
                    th = th;
                    r2 = httpURLConnection2;
                    if (r2 != 0) {
                        r2.disconnect();
                    }
                    hideLoading();
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
        }
        return handleDecode(str, webResourceResponse);
    }
}
