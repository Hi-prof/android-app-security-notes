package io.dcloud;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class WebviewActivity extends io.src.dcloud.adapter.DCloudBaseActivity implements android.view.View.OnClickListener {
    public static final java.lang.String isLocalHtmlParam = "isLocalHtml";
    public static final java.lang.String noPermissionAllowParam = "isNoPermissionAllowParam";
    private android.widget.TextView a;
    private android.widget.TextView b;
    private android.widget.TextView c;
    private android.widget.TextView d;
    private android.widget.TextView e;
    private io.dcloud.WebviewActivity.e f;
    private android.widget.FrameLayout g;
    private android.webkit.WebView h;
    private boolean i;
    private java.lang.String j = null;
    public java.util.ArrayList<java.lang.String> mAppStreamSchemeWhiteDefaultList = new java.util.ArrayList<>();
    private boolean k = false;
    private boolean l = false;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a extends android.webkit.WebChromeClient {
        a() {
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(java.lang.String str, android.webkit.GeolocationPermissions.Callback callback) {
            super.onGeolocationPermissionsShowPrompt(str, callback);
            if (io.dcloud.WebviewActivity.this.l) {
                callback.invoke(str, false, false);
            } else {
                callback.invoke(str, true, false);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(android.webkit.WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (io.dcloud.WebviewActivity.this.k) {
                return;
            }
            if (io.dcloud.WebviewActivity.this.f.getParent() == null) {
                io.dcloud.WebviewActivity.this.g.addView(io.dcloud.WebviewActivity.this.f);
                io.dcloud.WebviewActivity.this.f.c();
            } else if (io.dcloud.WebviewActivity.this.i) {
                io.dcloud.WebviewActivity.this.i = false;
                io.dcloud.WebviewActivity.this.f.c();
            }
            io.dcloud.WebviewActivity.this.f.setVisibility(0);
            if (io.dcloud.WebviewActivity.this.f.b() <= i) {
                io.dcloud.WebviewActivity.this.f.a(i);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(android.webkit.WebView webView, java.lang.String str) {
            super.onReceivedTitle(webView, str);
            if (io.dcloud.WebviewActivity.this.c == null || android.text.TextUtils.isEmpty(str) || str.startsWith("http") || str.startsWith("https")) {
                return;
            }
            io.dcloud.WebviewActivity.this.c.setText(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b extends android.webkit.WebViewClient {

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class a implements android.view.View.OnClickListener {
            final /* synthetic */ android.content.Intent a;

            a(android.content.Intent intent) {
                this.a = intent;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                io.dcloud.WebviewActivity.this.startActivity(this.a);
            }
        }

        /* JADX INFO: renamed from: io.dcloud.WebviewActivity$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class DialogInterfaceOnClickListenerC0022b implements android.content.DialogInterface.OnClickListener {
            final /* synthetic */ android.app.AlertDialog a;
            final /* synthetic */ android.net.http.SslError b;
            final /* synthetic */ android.webkit.SslErrorHandler c;

            DialogInterfaceOnClickListenerC0022b(android.app.AlertDialog alertDialog, android.net.http.SslError sslError, android.webkit.SslErrorHandler sslErrorHandler) {
                this.a = alertDialog;
                this.b = sslError;
                this.c = sslErrorHandler;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i) {
                if (i == -2) {
                    this.a.cancel();
                    this.a.dismiss();
                } else if (i == -3) {
                    this.b.getCertificate().getIssuedBy();
                } else if (i == -1) {
                    io.dcloud.common.adapter.ui.webview.WebViewFactory.setSslHandlerState(this.c, 1);
                    this.a.dismiss();
                }
            }
        }

        b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
            super.onPageFinished(webView, str);
            io.dcloud.WebviewActivity.this.b.setVisibility(webView.canGoBack() ? 0 : 4);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(android.webkit.WebView webView, android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError) {
            if (sslErrorHandler != null) {
                java.lang.String str = io.dcloud.common.util.BaseInfo.untrustedca;
                if (io.dcloud.common.util.PdrUtil.isEquals(str, "refuse")) {
                    sslErrorHandler.cancel();
                    return;
                }
                if (!io.dcloud.common.util.PdrUtil.isEquals(str, "warning")) {
                    io.dcloud.common.adapter.ui.webview.WebViewFactory.setSslHandlerState(sslErrorHandler, 1);
                    return;
                }
                android.app.AlertDialog alertDialogCreate = new android.app.AlertDialog.Builder(webView.getContext()).create();
                alertDialogCreate.setIcon(android.R.drawable.ic_secure);
                alertDialogCreate.setTitle(io.dcloud.WebviewActivity.this.getString(io.dcloud.base.R.string.dcloud_common_safety_warning));
                alertDialogCreate.setCanceledOnTouchOutside(false);
                java.lang.String url = sslError.getUrl();
                java.lang.String string = io.dcloud.WebviewActivity.this.getString(io.dcloud.base.R.string.dcloud_common_certificate_continue);
                if (!android.text.TextUtils.isEmpty(url)) {
                    string = url + "\n" + string;
                }
                alertDialogCreate.setMessage(string);
                io.dcloud.WebviewActivity.b.DialogInterfaceOnClickListenerC0022b dialogInterfaceOnClickListenerC0022b = new io.dcloud.WebviewActivity.b.DialogInterfaceOnClickListenerC0022b(alertDialogCreate, sslError, sslErrorHandler);
                alertDialogCreate.setButton(-2, io.dcloud.WebviewActivity.this.getString(android.R.string.cancel), dialogInterfaceOnClickListenerC0022b);
                alertDialogCreate.setButton(-1, io.dcloud.WebviewActivity.this.getString(android.R.string.ok), dialogInterfaceOnClickListenerC0022b);
                alertDialogCreate.show();
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str) {
            android.content.Intent intent;
            java.lang.String lowerCase = !android.text.TextUtils.isEmpty(str) ? str.toLowerCase(java.util.Locale.ENGLISH) : "";
            if (android.text.TextUtils.isEmpty(lowerCase) || str.startsWith("streamapp://") || lowerCase.startsWith(io.dcloud.common.adapter.util.DeviceInfo.HTTP_PROTOCOL) || lowerCase.startsWith(io.dcloud.common.adapter.util.DeviceInfo.HTTPS_PROTOCOL) || lowerCase.contains("streamapp://")) {
                webView.loadUrl(str);
                io.dcloud.WebviewActivity.this.i = true;
                return true;
            }
            if (!android.text.TextUtils.isEmpty(lowerCase)) {
                java.util.ArrayList<java.lang.String> arrayList = io.dcloud.WebviewActivity.this.mAppStreamSchemeWhiteDefaultList;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    java.lang.String str2 = arrayList.get(i);
                    i++;
                    if (lowerCase.startsWith(str2 + ":")) {
                        try {
                            android.content.Intent intent2 = new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(str));
                            if (io.dcloud.common.util.BaseInfo.isDefense) {
                                intent2.setSelector(null);
                                intent2.setComponent(null);
                                intent2.addCategory("android.intent.category.BROWSABLE");
                            }
                            io.dcloud.WebviewActivity.this.startActivity(intent2);
                        } catch (java.lang.Exception unused) {
                        }
                        return true;
                    }
                }
            }
            try {
                if (lowerCase.startsWith("intent://")) {
                    intent = android.content.Intent.parseUri(str, 1);
                    intent.addCategory("android.intent.category.BROWSABLE");
                    intent.setComponent(null);
                    intent.setSelector(null);
                } else {
                    intent = new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(str));
                }
                android.content.pm.PackageManager packageManager = io.dcloud.WebviewActivity.this.getPackageManager();
                java.util.List<android.content.pm.ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
                if (listQueryIntentActivities != null && listQueryIntentActivities.size() > 0) {
                    java.lang.String str3 = io.dcloud.WebviewActivity.this.getString(io.dcloud.base.R.string.dcloud_common_soon_open) + "\"Android system\"" + io.dcloud.WebviewActivity.this.getString(io.dcloud.base.R.string.dcloud_common_app_open_now);
                    java.lang.CharSequence charSequenceLoadLabel = 1 == listQueryIntentActivities.size() ? listQueryIntentActivities.get(0).loadLabel(packageManager) : "";
                    if (!android.text.TextUtils.isEmpty(charSequenceLoadLabel)) {
                        str3 = io.dcloud.WebviewActivity.this.getString(io.dcloud.base.R.string.dcloud_common_soon_open) + io.dcloud.common.util.JSUtil.QUOTE + ((java.lang.Object) charSequenceLoadLabel) + io.dcloud.common.util.JSUtil.QUOTE + io.dcloud.WebviewActivity.this.getString(io.dcloud.base.R.string.dcloud_common_app_open_now);
                    }
                    io.dcloud.WebviewActivity webviewActivity = io.dcloud.WebviewActivity.this;
                    io.dcloud.common.util.DialogUtil.showAlertDialog(webviewActivity.that, str3, webviewActivity.getString(io.dcloud.base.R.string.dcloud_common_open), io.dcloud.WebviewActivity.this.getString(io.dcloud.base.R.string.dcloud_common_cancel), new io.dcloud.WebviewActivity.b.a(intent), null, null, null, false, 1, 0, (int) (((double) io.dcloud.WebviewActivity.this.getResources().getDisplayMetrics().widthPixels) * 0.9d));
                }
            } catch (java.lang.Exception unused2) {
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class c implements android.webkit.DownloadListener {

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class a implements android.view.View.OnClickListener {
            final /* synthetic */ java.lang.String a;
            final /* synthetic */ java.lang.String b;
            final /* synthetic */ java.lang.String c;
            final /* synthetic */ java.lang.String d;

            /* JADX INFO: renamed from: io.dcloud.WebviewActivity$c$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
            class C0023a implements io.dcloud.common.DHInterface.ILoadCallBack {
                C0023a() {
                }

                @Override // io.dcloud.common.DHInterface.ILoadCallBack
                public java.lang.Object onCallBack(int i, android.content.Context context, java.lang.Object obj) {
                    if (obj == null && i == -1 && context == null) {
                        android.content.Intent intent = new android.content.Intent();
                        io.dcloud.WebviewActivity.c.a aVar = io.dcloud.WebviewActivity.c.a.this;
                        io.dcloud.WebviewActivity webviewActivity = io.dcloud.WebviewActivity.this;
                        io.dcloud.common.util.NotificationUtil.showNotification(webviewActivity.that, aVar.d, webviewActivity.getString(io.dcloud.base.R.string.dcloud_common_download_failed), intent, -1, -1, intent.hashCode(), true);
                        return null;
                    }
                    java.lang.String strValueOf = java.lang.String.valueOf(obj);
                    java.lang.String mimeType = io.dcloud.common.util.PdrUtil.getMimeType(strValueOf);
                    if (strValueOf.startsWith(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL)) {
                        strValueOf = strValueOf.substring(7);
                    }
                    if (strValueOf.startsWith("content://")) {
                        strValueOf = io.dcloud.common.adapter.util.PlatformUtil.getFilePathFromContentUri(android.net.Uri.parse(strValueOf), io.dcloud.WebviewActivity.this.that.getContentResolver());
                        mimeType = io.dcloud.common.util.PdrUtil.getMimeType(strValueOf);
                    }
                    android.content.Intent dataAndTypeIntent = io.dcloud.common.util.LoadAppUtils.getDataAndTypeIntent(context, strValueOf, mimeType);
                    io.dcloud.WebviewActivity.c.a aVar2 = io.dcloud.WebviewActivity.c.a.this;
                    io.dcloud.WebviewActivity webviewActivity2 = io.dcloud.WebviewActivity.this;
                    io.dcloud.common.util.NotificationUtil.showNotification(webviewActivity2.that, aVar2.d, webviewActivity2.getString(io.dcloud.base.R.string.dcloud_common_download_complete), dataAndTypeIntent, io.dcloud.PdrR.DRAWABLE_DCLOUD_WEBVIEW_DOWNLOAD_PIN_AROUND, io.dcloud.PdrR.DRAWABLE_DCLOUD_WEBVIEW_DOWNLOAD_PIN, 1, true);
                    return null;
                }
            }

            a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
                this.a = str;
                this.b = str2;
                this.c = str3;
                this.d = str4;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                io.dcloud.common.adapter.util.DownloadUtil.getInstance(io.dcloud.WebviewActivity.this.that).startRequest(io.dcloud.WebviewActivity.this.that, this.a, this.b, this.c, this.d, new io.dcloud.WebviewActivity.c.a.C0023a());
            }
        }

        c() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, long j) {
            try {
                try {
                    if (io.dcloud.common.adapter.util.DeviceInfo.sDeviceSdkVer <= 8) {
                        android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
                        intent.setData(android.net.Uri.parse(str));
                        io.dcloud.WebviewActivity.this.startActivity(intent);
                        return;
                    }
                    java.lang.String str5 = android.os.Environment.getExternalStorageDirectory().getPath() + java.io.File.separator + android.os.Environment.DIRECTORY_DOWNLOADS;
                    java.lang.String downloadFilename = io.dcloud.common.util.PdrUtil.getDownloadFilename(str3, str4, str);
                    java.lang.String str6 = io.dcloud.WebviewActivity.this.getString(io.dcloud.base.R.string.dcloud_common_download_do_file) + downloadFilename;
                    if (0 < j) {
                        str6 = str6 + "【" + new java.math.BigDecimal(j).divide(new java.math.BigDecimal(1048576L), 2, 4).floatValue() + "MB】";
                    }
                    io.dcloud.WebviewActivity webviewActivity = io.dcloud.WebviewActivity.this;
                    io.dcloud.common.util.DialogUtil.showAlertDialog(webviewActivity.that, str6, webviewActivity.getString(io.dcloud.base.R.string.dcloud_common_download), io.dcloud.WebviewActivity.this.getString(io.dcloud.base.R.string.dcloud_common_cancel), new io.dcloud.WebviewActivity.c.a(str, str4, str5, downloadFilename), null, null, null, false, 0, 80, (int) (((double) io.dcloud.WebviewActivity.this.getResources().getDisplayMetrics().widthPixels) * 0.9d));
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            } catch (java.lang.Exception unused) {
                android.content.Intent intent2 = new android.content.Intent("android.intent.action.VIEW");
                intent2.setData(android.net.Uri.parse(str));
                io.dcloud.WebviewActivity.this.startActivity(intent2);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class d implements io.dcloud.feature.ui.nativeui.a.b {
        d() {
        }

        @Override // io.dcloud.feature.ui.nativeui.a.b
        public void initCancelText(android.widget.TextView textView) {
        }

        @Override // io.dcloud.feature.ui.nativeui.a.b
        public void initTextItem(int i, android.widget.TextView textView, java.lang.String str) {
        }

        @Override // io.dcloud.feature.ui.nativeui.a.b
        public boolean onDismiss(int i) {
            return false;
        }

        @Override // io.dcloud.feature.ui.nativeui.a.b
        public void onItemClick(int i) {
            if (i == 1) {
                if (io.dcloud.WebviewActivity.this.h != null) {
                    io.dcloud.WebviewActivity.this.i = true;
                    io.dcloud.WebviewActivity.this.h.reload();
                    return;
                }
                return;
            }
            if (i == 2) {
                io.dcloud.WebviewActivity.this.h();
            } else if (i == 3) {
                io.dcloud.WebviewActivity.this.j();
            } else {
                if (i != 4) {
                    return;
                }
                io.dcloud.WebviewActivity.this.k();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class e extends android.view.View {
        int a;
        float b;
        int c;
        android.graphics.Paint d;
        int e;
        int f;
        int g;
        int h;

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class a implements java.lang.Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                io.dcloud.WebviewActivity.e eVar = io.dcloud.WebviewActivity.e.this;
                int i = eVar.g - 5;
                eVar.g = i;
                if (i > 0) {
                    eVar.postDelayed(this, 5L);
                } else {
                    android.view.ViewGroup viewGroup = (android.view.ViewGroup) eVar.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(io.dcloud.WebviewActivity.e.this);
                    }
                }
                io.dcloud.WebviewActivity.e.this.invalidate();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class b implements java.lang.Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                io.dcloud.WebviewActivity.e eVar = io.dcloud.WebviewActivity.e.this;
                int i = eVar.f;
                int i2 = eVar.e;
                int i3 = 10;
                int i4 = (i - i2) / 10;
                if (i4 <= 10) {
                    i3 = 1;
                    if (i4 >= 1) {
                        i3 = i4;
                    }
                }
                int i5 = i2 + i3;
                eVar.e = i5;
                if (i > i5) {
                    eVar.postDelayed(this, 5L);
                } else if (i >= eVar.a) {
                    eVar.a();
                }
                io.dcloud.WebviewActivity.e.this.invalidate();
            }
        }

        e(android.content.Context context) {
            super(context);
            this.c = 0;
            this.d = new android.graphics.Paint();
            this.e = 0;
            this.f = 0;
            this.g = 255;
            this.a = context.getResources().getDisplayMetrics().widthPixels;
            this.b = io.dcloud.common.util.PdrUtil.pxFromDp(2.0f, getResources().getDisplayMetrics());
        }

        void a() {
            postDelayed(new io.dcloud.WebviewActivity.e.a(), 50L);
        }

        public int b() {
            return this.h;
        }

        public void c() {
            this.g = 255;
            this.e = 0;
            this.f = 0;
            this.h = 0;
        }

        @Override // android.view.View
        protected void onDraw(android.graphics.Canvas canvas) {
            super.onDraw(canvas);
            this.d.setColor(android.graphics.Color.argb(this.g, 0, com.alibaba.fastjson.asm.Opcodes.IFEQ, 68));
            float f = this.c;
            canvas.drawRect(0.0f, f, this.e, f + this.b, this.d);
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            setMeasuredDimension(this.a, this.c + ((int) this.b));
        }

        void a(int i) {
            this.h = i;
            int i2 = (this.a * i) / 100;
            if (this.e >= this.f) {
                postDelayed(new io.dcloud.WebviewActivity.e.b(), 5L);
            }
            this.f = i2;
        }
    }

    private void l() {
        if (getIntent() != null) {
            if (getIntent().hasExtra("url")) {
                this.j = getIntent().getStringExtra("url");
            }
            if (getIntent().hasExtra(isLocalHtmlParam)) {
                this.k = getIntent().getBooleanExtra(isLocalHtmlParam, false);
            }
            if (getIntent().hasExtra(noPermissionAllowParam)) {
                this.l = getIntent().getBooleanExtra(noPermissionAllowParam, false);
            }
        }
        this.mAppStreamSchemeWhiteDefaultList.add("weixin");
        this.mAppStreamSchemeWhiteDefaultList.add("alipay");
        this.mAppStreamSchemeWhiteDefaultList.add("alipays");
        this.mAppStreamSchemeWhiteDefaultList.add("alipayqr");
    }

    private void m() {
        findViewById(io.dcloud.base.R.id.status_bar_view).setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, io.dcloud.common.adapter.util.DeviceInfo.getStatusHeight(this)));
        this.a = (android.widget.TextView) findViewById(io.dcloud.PdrR.WEBVIEW_ACTIVITY_LAYOUT_BACK);
        this.b = (android.widget.TextView) findViewById(io.dcloud.PdrR.WEBVIEW_ACTIVITY_LAYOUT_CLOSE);
        this.c = (android.widget.TextView) findViewById(io.dcloud.PdrR.WEBVIEW_ACTIVITY_LAYOUT_TITLE);
        this.e = (android.widget.TextView) findViewById(io.dcloud.PdrR.WEBVIEW_ACTIVITY_LAYOUT_REFRESH);
        this.d = (android.widget.TextView) findViewById(io.dcloud.PdrR.WEBVIEW_ACTIVITY_LAYOUT_MENU);
        this.g = (android.widget.FrameLayout) findViewById(io.dcloud.PdrR.WEBVIEW_ACTIVITY_LAYOUT_CONTENT);
        io.dcloud.WebviewActivity.e eVar = new io.dcloud.WebviewActivity.e(this.that);
        this.f = eVar;
        if (this.k) {
            eVar.setVisibility(8);
            this.d.setVisibility(4);
        }
        android.webkit.WebView webView = (android.webkit.WebView) findViewById(io.dcloud.PdrR.WEBVIEW_ACTIVITY_LAYOUT_WEBVIEW);
        this.h = webView;
        a(webView);
        int iPxFromDp = io.dcloud.common.util.PdrUtil.pxFromDp(23.0f, getResources().getDisplayMetrics());
        android.graphics.Typeface typefaceCreateFromAsset = android.graphics.Typeface.createFromAsset(getAssets(), "fonts/dcloud_iconfont.ttf");
        this.a.setText("\ue601");
        this.a.setTypeface(typefaceCreateFromAsset);
        float f = iPxFromDp;
        this.a.getPaint().setTextSize(f);
        this.b.setText("\ue650");
        this.b.setTypeface(typefaceCreateFromAsset);
        this.b.getPaint().setTextSize(f);
        this.b.setVisibility(4);
        this.e.setText("\ue606");
        this.e.setTypeface(typefaceCreateFromAsset);
        this.e.getPaint().setTextSize(f);
        this.d.setText("\ue606");
        this.d.setTypeface(typefaceCreateFromAsset);
        this.d.getPaint().setTextSize(f);
        this.a.setOnClickListener(this);
        this.b.setOnClickListener(this);
        this.d.setOnClickListener(this);
    }

    private void n() {
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        android.content.Intent intent = getIntent();
        if (intent == null || !"POP".equals(intent.getStringExtra("ANIM"))) {
            overridePendingTransition(0, io.dcloud.PdrR.ANIM_DCLOUD_SLIDE_OUT_TO_RIGHT);
        } else {
            overridePendingTransition(0, io.dcloud.base.R.anim.dcloud_pop_out);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        if (view == this.a) {
            if (g()) {
                return;
            }
            finish();
        } else if (view == this.b) {
            finish();
        } else if (view == this.d) {
            i();
        }
    }

    @Override // io.src.dcloud.adapter.DCloudBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(android.os.Bundle bundle) {
        setImmersive(this);
        super.onCreate(bundle);
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 29) {
            getWindow().setNavigationBarContrastEnforced(false);
        }
        setContentView(io.dcloud.PdrR.WEBVIEW_ACTIVITY_LAYOUT);
        l();
        m();
        if (!android.text.TextUtils.isEmpty(this.j)) {
            this.h.loadUrl(this.j);
        }
        if (i < 36 || io.dcloud.common.adapter.util.AndroidResources.sAppTargetSdkVersion < 36) {
            return;
        }
        androidx.core.view.ViewCompat.setOnApplyWindowInsetsListener(findViewById(io.dcloud.base.R.id.webview), new androidx.core.view.OnApplyWindowInsetsListener() { // from class: io.dcloud.WebviewActivity$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final androidx.core.view.WindowInsetsCompat onApplyWindowInsets(android.view.View view, androidx.core.view.WindowInsetsCompat windowInsetsCompat) {
                return io.dcloud.WebviewActivity.a(view, windowInsetsCompat);
            }
        });
    }

    @Override // io.src.dcloud.adapter.DCloudBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        try {
            android.webkit.WebView webView = this.h;
            if (webView != null) {
                if (webView.getParent() != null) {
                    ((android.view.ViewGroup) this.h.getParent()).removeView(this.h);
                }
                this.h.clearHistory();
                this.h.clearCache(true);
                this.h.destroy();
            }
            this.h = null;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        if (4 != i) {
            return super.onKeyDown(i, keyEvent);
        }
        boolean zG = g();
        return !zG ? super.onKeyDown(i, keyEvent) : zG;
    }

    public void setImmersive(android.app.Activity activity) {
        int i;
        if (activity != null) {
            int i2 = android.os.Build.VERSION.SDK_INT;
            android.view.Window window = activity.getWindow();
            int systemUiVisibility = window.getDecorView().getSystemUiVisibility() | 1280;
            window.setStatusBarColor(0);
            if (i2 >= 23) {
                try {
                    java.lang.Class<?> cls = java.lang.Class.forName("android.view.View");
                    i = cls.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR").getInt(cls);
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                    i = 8192;
                }
                systemUiVisibility |= i;
            }
            window.getDecorView().setSystemUiVisibility(systemUiVisibility);
        }
    }

    private boolean g() {
        android.webkit.WebView webView = this.h;
        if (webView == null) {
            return false;
        }
        if (webView.canGoBack()) {
            this.i = true;
            this.h.goBack();
            this.c.setText(this.h.getTitle());
            return true;
        }
        if (this.h.canGoBack()) {
            return false;
        }
        finish();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        ((android.text.ClipboardManager) getSystemService("clipboard")).setText(this.h.getUrl());
        com.dcloud.android.widget.toast.ToastCompat.makeText((android.content.Context) this.that, (java.lang.CharSequence) (getString(io.dcloud.base.R.string.dcloud_common_copy_clipboard) + this.h.getUrl()), 1).show();
    }

    private void i() {
        setTheme(io.dcloud.PdrR.WEBVIEW_ACTIVITY_LAYOUT_ACTS_STYLE_ActionSheetStyleIOS7);
        io.dcloud.feature.ui.nativeui.a aVar = new io.dcloud.feature.ui.nativeui.a(this.that);
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE, getString(io.dcloud.base.R.string.dcloud_common_refresh));
            jSONArray.put(jSONObject);
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE, getString(io.dcloud.base.R.string.dcloud_common_copy_link));
            jSONArray.put(jSONObject2);
            org.json.JSONObject jSONObject3 = new org.json.JSONObject();
            jSONObject3.put(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE, getString(io.dcloud.base.R.string.dcloud_common_open_browser));
            jSONArray.put(jSONObject3);
            org.json.JSONObject jSONObject4 = new org.json.JSONObject();
            jSONObject4.put(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE, getString(io.dcloud.base.R.string.dcloud_common_share_page));
            jSONArray.put(jSONObject4);
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
        }
        aVar.b(getString(io.dcloud.base.R.string.dcloud_common_cancel));
        aVar.a(jSONArray);
        aVar.a(new io.dcloud.WebviewActivity.d());
        aVar.a(true);
        aVar.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        try {
            android.content.Intent intent = new android.content.Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(android.net.Uri.parse(this.h.getUrl()));
            startActivity(android.content.Intent.createChooser(intent, getString(io.dcloud.base.R.string.dcloud_common_open_web)));
        } catch (java.lang.Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        try {
            android.content.Intent intent = new android.content.Intent("android.intent.action.SEND");
            intent.setType(androidx.webkit.internal.AssetHelper.DEFAULT_MIME_TYPE);
            intent.putExtra("android.intent.extra.SUBJECT", this.h.getTitle());
            intent.putExtra("android.intent.extra.TEXT", this.h.getUrl());
            intent.setFlags(268435456);
            startActivity(android.content.Intent.createChooser(intent, getString(io.dcloud.base.R.string.dcloud_common_share)));
        } catch (java.lang.Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ androidx.core.view.WindowInsetsCompat a(android.view.View view, androidx.core.view.WindowInsetsCompat windowInsetsCompat) {
        if (windowInsetsCompat != null) {
            android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof android.view.ViewGroup.MarginLayoutParams) {
                androidx.core.graphics.Insets insets = windowInsetsCompat.getInsets(android.view.WindowInsets.Type.navigationBars());
                android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = insets.bottom;
                marginLayoutParams.topMargin = insets.top;
                marginLayoutParams.leftMargin = insets.left;
                marginLayoutParams.rightMargin = insets.right;
            }
        }
        return androidx.core.view.WindowInsetsCompat.CONSUMED;
    }

    private void a(android.webkit.WebView webView) {
        if (webView != null) {
            android.webkit.WebSettings settings = webView.getSettings();
            settings.setDomStorageEnabled(true);
            java.lang.Class[] clsArr = {java.lang.Boolean.TYPE};
            java.lang.Object[] objArr = {java.lang.Boolean.TRUE};
            settings.setAllowFileAccess(false);
            io.dcloud.common.adapter.util.PlatformUtil.invokeMethod(settings, io.dcloud.p.e1.a("f2l4TWBgY3tKZWBpTW9vaX9/KjZhM2Q4OGZhLTRiYTAtNDc5Zi05NDIyLWU1YWFiZTE1ODk3Yjc2", true, 12), clsArr, objArr);
            settings.setSavePassword(false);
            io.dcloud.common.adapter.ui.webview.WebViewFactory.openJSEnabled(settings, null);
            webView.setFocusable(true);
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibilityTraversal");
            webView.removeJavascriptInterface("accessibility");
            webView.setWebChromeClient(new io.dcloud.WebviewActivity.a());
            webView.setWebViewClient(new io.dcloud.WebviewActivity.b());
        }
        n();
        if (webView == null) {
            return;
        }
        webView.setDownloadListener(new io.dcloud.WebviewActivity.c());
    }
}
