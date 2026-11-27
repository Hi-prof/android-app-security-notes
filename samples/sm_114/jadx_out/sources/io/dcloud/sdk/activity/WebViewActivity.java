package io.dcloud.sdk.activity;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class WebViewActivity extends android.app.Activity implements android.view.View.OnClickListener {
    public static final /* synthetic */ int o = 0;
    private android.widget.TextView a;
    private android.widget.TextView b;
    private android.widget.TextView c;
    private android.widget.TextView d;
    private android.widget.TextView e;
    private io.dcloud.sdk.activity.WebViewActivity.e f;
    private android.widget.FrameLayout g;
    private android.webkit.WebView h;
    private boolean i;
    private java.lang.String j = null;
    public java.util.ArrayList k = new java.util.ArrayList();
    private boolean l = false;
    private boolean m = false;
    public java.util.Map n = new io.dcloud.sdk.activity.WebViewActivity.a();

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a extends java.util.HashMap {
        a() {
            put("X-Requested-With", "");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b extends android.webkit.WebChromeClient {
        b() {
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(java.lang.String str, android.webkit.GeolocationPermissions.Callback callback) {
            super.onGeolocationPermissionsShowPrompt(str, callback);
            if (io.dcloud.sdk.activity.WebViewActivity.this.m) {
                callback.invoke(str, false, false);
            } else {
                callback.invoke(str, true, false);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(android.webkit.WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (io.dcloud.sdk.activity.WebViewActivity.this.l) {
                return;
            }
            if (io.dcloud.sdk.activity.WebViewActivity.this.f.getParent() == null) {
                io.dcloud.sdk.activity.WebViewActivity.this.g.addView(io.dcloud.sdk.activity.WebViewActivity.this.f);
                io.dcloud.sdk.activity.WebViewActivity.this.f.c();
            } else if (io.dcloud.sdk.activity.WebViewActivity.this.i) {
                io.dcloud.sdk.activity.WebViewActivity.this.i = false;
                io.dcloud.sdk.activity.WebViewActivity.this.f.c();
            }
            io.dcloud.sdk.activity.WebViewActivity.this.f.setVisibility(0);
            if (io.dcloud.sdk.activity.WebViewActivity.this.f.b() <= i) {
                io.dcloud.sdk.activity.WebViewActivity.this.f.a(i);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(android.webkit.WebView webView, java.lang.String str) {
            super.onReceivedTitle(webView, str);
            if (io.dcloud.sdk.activity.WebViewActivity.this.c == null || android.text.TextUtils.isEmpty(str) || str.startsWith("http") || str.startsWith("https")) {
                return;
            }
            io.dcloud.sdk.activity.WebViewActivity.this.c.setText(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class c extends android.webkit.WebViewClient {

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class a implements android.content.DialogInterface.OnClickListener {
            final /* synthetic */ android.content.Intent a;

            a(android.content.Intent intent) {
                this.a = intent;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i) {
                io.dcloud.sdk.activity.WebViewActivity.this.startActivity(this.a);
            }
        }

        c() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
            super.onPageFinished(webView, str);
            io.dcloud.sdk.activity.WebViewActivity.this.b.setVisibility(webView.canGoBack() ? 0 : 4);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(android.webkit.WebView webView, android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError) {
            if (sslErrorHandler != null) {
                io.dcloud.sdk.activity.WebViewActivity.this.a(sslErrorHandler, "proceed", new java.lang.Class[0], new java.lang.Object[0]);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str) {
            android.content.Intent intent;
            java.lang.String lowerCase = !android.text.TextUtils.isEmpty(str) ? str.toLowerCase(java.util.Locale.ENGLISH) : "";
            if (android.text.TextUtils.isEmpty(lowerCase) || str.startsWith("streamapp://") || lowerCase.startsWith(io.dcloud.common.adapter.util.DeviceInfo.HTTP_PROTOCOL) || lowerCase.startsWith(io.dcloud.common.adapter.util.DeviceInfo.HTTPS_PROTOCOL) || lowerCase.contains("streamapp://")) {
                webView.loadUrl(str, io.dcloud.sdk.activity.WebViewActivity.this.n);
                io.dcloud.sdk.activity.WebViewActivity.this.i = true;
                return true;
            }
            if (!android.text.TextUtils.isEmpty(lowerCase)) {
                java.util.ArrayList arrayList = io.dcloud.sdk.activity.WebViewActivity.this.k;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    java.lang.Object obj = arrayList.get(i);
                    i++;
                    if (lowerCase.startsWith(((java.lang.String) obj) + ":")) {
                        try {
                            android.content.Intent intent2 = new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(str));
                            intent2.setSelector(null);
                            intent2.setComponent(null);
                            intent2.addCategory("android.intent.category.BROWSABLE");
                            io.dcloud.sdk.activity.WebViewActivity.this.startActivity(intent2);
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
                android.content.pm.PackageManager packageManager = io.dcloud.sdk.activity.WebViewActivity.this.getPackageManager();
                java.util.List<android.content.pm.ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
                if (listQueryIntentActivities != null && listQueryIntentActivities.size() > 0) {
                    java.lang.String str2 = "即将打开\"Android system\"应用, \n立即打开?";
                    java.lang.CharSequence charSequenceLoadLabel = 1 == listQueryIntentActivities.size() ? listQueryIntentActivities.get(0).loadLabel(packageManager) : "";
                    if (!android.text.TextUtils.isEmpty(charSequenceLoadLabel)) {
                        str2 = "即将打开\"" + ((java.lang.Object) charSequenceLoadLabel) + "\"应用, \n立即打开?";
                    }
                    new android.app.AlertDialog.Builder(io.dcloud.sdk.activity.WebViewActivity.this).setMessage(str2).setPositiveButton("打开", new io.dcloud.sdk.activity.WebViewActivity.c.a(intent)).setNegativeButton("取消", (android.content.DialogInterface.OnClickListener) null).create().show();
                }
            } catch (java.lang.Exception unused2) {
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class d implements io.dcloud.p.g.b {
        d() {
        }

        @Override // io.dcloud.p.g.b
        public void initCancelText(android.widget.TextView textView) {
        }

        @Override // io.dcloud.p.g.b
        public void initTextItem(int i, android.widget.TextView textView, java.lang.String str) {
        }

        @Override // io.dcloud.p.g.b
        public boolean onDismiss(int i) {
            return false;
        }

        @Override // io.dcloud.p.g.b
        public void onItemClick(int i) {
            if (i == 1) {
                if (io.dcloud.sdk.activity.WebViewActivity.this.h != null) {
                    io.dcloud.sdk.activity.WebViewActivity.this.i = true;
                    io.dcloud.sdk.activity.WebViewActivity.this.h.reload();
                    return;
                }
                return;
            }
            if (i == 2) {
                io.dcloud.sdk.activity.WebViewActivity.this.b();
            } else if (i == 3) {
                io.dcloud.sdk.activity.WebViewActivity.this.d();
            } else {
                if (i != 4) {
                    return;
                }
                io.dcloud.sdk.activity.WebViewActivity.this.e();
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
                io.dcloud.sdk.activity.WebViewActivity.e eVar = io.dcloud.sdk.activity.WebViewActivity.e.this;
                int i = eVar.g - 5;
                eVar.g = i;
                if (i > 0) {
                    eVar.postDelayed(this, 5L);
                } else {
                    android.view.ViewGroup viewGroup = (android.view.ViewGroup) eVar.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(io.dcloud.sdk.activity.WebViewActivity.e.this);
                    }
                }
                io.dcloud.sdk.activity.WebViewActivity.e.this.invalidate();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class b implements java.lang.Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                io.dcloud.sdk.activity.WebViewActivity.e eVar = io.dcloud.sdk.activity.WebViewActivity.e.this;
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
                io.dcloud.sdk.activity.WebViewActivity.e.this.invalidate();
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
            this.b = io.dcloud.sdk.activity.WebViewActivity.pxFromDp(2.0f, getResources().getDisplayMetrics());
        }

        void a() {
            postDelayed(new io.dcloud.sdk.activity.WebViewActivity.e.a(), 50L);
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
                postDelayed(new io.dcloud.sdk.activity.WebViewActivity.e.b(), 5L);
            }
            this.f = i2;
        }
    }

    private void h() {
    }

    public static int pxFromDp(float f, android.util.DisplayMetrics displayMetrics) {
        return java.lang.Math.round(android.util.TypedValue.applyDimension(1, f, displayMetrics));
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        getIntent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        if (view == this.a) {
            if (a()) {
                return;
            }
            finish();
        } else if (view == this.b) {
            finish();
        } else if (view == this.d) {
            c();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(android.os.Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setContentView(io.dcloud.base.R.layout.dcloud_ad_activity_webview);
        f();
        g();
        if (android.text.TextUtils.isEmpty(this.j)) {
            return;
        }
        this.h.loadUrl(this.j, this.n);
    }

    @Override // android.app.Activity
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

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        if (4 != i) {
            return super.onKeyDown(i, keyEvent);
        }
        boolean zA = a();
        return !zA ? super.onKeyDown(i, keyEvent) : zA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ((android.text.ClipboardManager) getSystemService("clipboard")).setText(this.h.getUrl());
        android.widget.Toast.makeText(this, "拷贝到剪切板" + this.h.getUrl(), 1).show();
    }

    private void c() {
        io.dcloud.p.g gVar = new io.dcloud.p.g(this);
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE, "刷新");
            jSONArray.put(jSONObject);
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE, "复制链接");
            jSONArray.put(jSONObject2);
            org.json.JSONObject jSONObject3 = new org.json.JSONObject();
            jSONObject3.put(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE, "使用浏览器打开");
            jSONArray.put(jSONObject3);
            org.json.JSONObject jSONObject4 = new org.json.JSONObject();
            jSONObject4.put(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE, "分享页面");
            jSONArray.put(jSONObject4);
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
        }
        gVar.a("取消");
        gVar.a(jSONArray);
        gVar.a(new io.dcloud.sdk.activity.WebViewActivity.d());
        gVar.a(true);
        gVar.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            android.content.Intent intent = new android.content.Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(android.net.Uri.parse(this.h.getUrl()));
            startActivity(android.content.Intent.createChooser(intent, "打开网页"));
        } catch (java.lang.Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            android.content.Intent intent = new android.content.Intent("android.intent.action.SEND");
            intent.setType(androidx.webkit.internal.AssetHelper.DEFAULT_MIME_TYPE);
            intent.putExtra("android.intent.extra.SUBJECT", this.h.getTitle());
            intent.putExtra("android.intent.extra.TEXT", this.h.getUrl());
            intent.setFlags(268435456);
            startActivity(android.content.Intent.createChooser(intent, "分享"));
        } catch (java.lang.Exception unused) {
        }
    }

    private void f() {
        if (getIntent() != null) {
            if (getIntent().hasExtra("url")) {
                this.j = getIntent().getStringExtra("url");
            }
            if (getIntent().hasExtra(io.dcloud.WebviewActivity.isLocalHtmlParam)) {
                this.l = getIntent().getBooleanExtra(io.dcloud.WebviewActivity.isLocalHtmlParam, false);
            }
            if (getIntent().hasExtra(io.dcloud.WebviewActivity.noPermissionAllowParam)) {
                this.m = getIntent().getBooleanExtra(io.dcloud.WebviewActivity.noPermissionAllowParam, false);
            }
        }
        this.k.add("weixin");
        this.k.add("alipay");
        this.k.add("alipays");
        this.k.add("alipayqr");
    }

    private void g() {
        android.graphics.Typeface typefaceCreateFromAsset;
        this.a = (android.widget.TextView) findViewById(io.dcloud.base.R.id.back);
        this.b = (android.widget.TextView) findViewById(io.dcloud.base.R.id.close);
        this.c = (android.widget.TextView) findViewById(io.dcloud.base.R.id.title);
        this.e = (android.widget.TextView) findViewById(io.dcloud.base.R.id.refresh);
        this.d = (android.widget.TextView) findViewById(io.dcloud.base.R.id.menu);
        this.g = (android.widget.FrameLayout) findViewById(io.dcloud.base.R.id.content);
        io.dcloud.sdk.activity.WebViewActivity.e eVar = new io.dcloud.sdk.activity.WebViewActivity.e(this);
        this.f = eVar;
        if (this.l) {
            eVar.setVisibility(8);
            this.d.setVisibility(4);
        }
        android.webkit.WebView webView = (android.webkit.WebView) findViewById(io.dcloud.base.R.id.webview);
        this.h = webView;
        a(webView);
        int iPxFromDp = pxFromDp(23.0f, getResources().getDisplayMetrics());
        try {
            typefaceCreateFromAsset = android.graphics.Typeface.createFromAsset(getAssets(), "dcloud_uni_ad/dcloud_iconfont.ttf");
        } catch (java.lang.Exception unused) {
            typefaceCreateFromAsset = android.graphics.Typeface.createFromAsset(getAssets(), "fonts/dcloud_iconfont.ttf");
        }
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

    private void a(android.webkit.WebView webView) {
        if (webView != null) {
            android.webkit.WebSettings settings = webView.getSettings();
            settings.setDomStorageEnabled(true);
            java.lang.Class[] clsArr = {java.lang.Boolean.TYPE};
            java.lang.Object[] objArr = {java.lang.Boolean.TRUE};
            settings.setAllowFileAccess(false);
            io.dcloud.sdk.core.util.ReflectUtil.invokeMethod(settings, io.dcloud.p.s4.c("e218SWRkZ39OYWRtSWtrbXt7"), clsArr, objArr);
            settings.setSavePassword(false);
            settings.setJavaScriptEnabled(true);
            webView.setFocusable(true);
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibilityTraversal");
            webView.removeJavascriptInterface("accessibility");
            webView.setWebChromeClient(new io.dcloud.sdk.activity.WebViewActivity.b());
            webView.setWebViewClient(new io.dcloud.sdk.activity.WebViewActivity.c());
        }
        h();
    }

    private boolean a() {
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

    public java.lang.Object a(java.lang.Object obj, java.lang.String str, java.lang.Class[] clsArr, java.lang.Object... objArr) {
        if (obj == null) {
            return null;
        }
        try {
            java.lang.reflect.Method method = obj.getClass().getMethod(str, clsArr);
            method.setAccessible(true);
            if (objArr.length == 0) {
                objArr = null;
            }
            return method.invoke(obj, objArr);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }
}
