package io.dcloud;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class WebAppActivity extends io.dcloud.a {
    public static final long ONE_SECOND = 1000;
    public static final long SPLASH_SECOND = 5000;
    protected boolean mSplashShowing;
    private android.app.AlertDialog o;
    private boolean p;
    android.content.BroadcastReceiver s;
    private io.dcloud.WebAppActivity.f t;
    private io.dcloud.WebAppActivity.HomeKeyEventBroadcastReceiver u;
    private android.content.Context v;
    private java.util.ArrayList y;
    private android.os.Handler q = new android.os.Handler();
    private final java.lang.String r = "remove-app_action";
    android.graphics.Bitmap w = null;
    protected android.view.View mSplashView = null;
    long x = 0;
    boolean z = false;
    android.view.View A = null;
    boolean B = false;
    boolean C = true;
    android.widget.FrameLayout D = null;
    android.widget.LinearLayout E = null;
    android.widget.FrameLayout F = null;
    io.dcloud.common.DHInterface.ICallBack G = null;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class HomeKeyEventBroadcastReceiver extends android.content.BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            java.lang.String stringExtra;
            if (!intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") || (stringExtra = intent.getStringExtra("reason")) == null) {
                return;
            }
            if (stringExtra.equals("homekey") || stringExtra.equals("recentapps")) {
                io.dcloud.application.DCLoudApplicationImpl.self().onApp2Back();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a extends android.content.BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            java.lang.String action = intent.getAction();
            action.getClass();
            action.hashCode();
            int i = 0;
            switch (action) {
                case "android.intent.action.BATTERY_CHANGED":
                    int intExtra = intent.getIntExtra(androidtranscoder.format.MediaFormatExtraConstants.KEY_LEVEL, 0);
                    int intExtra2 = (int) (((double) intent.getIntExtra("temperature", 0)) / 10.0d);
                    io.dcloud.common.util.AppRuntime.setBatteryLevel(intExtra);
                    io.dcloud.common.util.AppRuntime.setTemperature(intExtra2);
                    break;
                case "android.intent.action.LOCALE_CHANGED":
                    io.dcloud.common.util.language.LanguageUtil.updateDeviceDefLocalLanguage(java.util.Locale.getDefault());
                    break;
                case "com.huawei.intent.action.CLICK_STATUSBAR":
                    io.dcloud.WebAppActivity webAppActivity = io.dcloud.WebAppActivity.this;
                    if (webAppActivity.D != null && webAppActivity.y != null) {
                        java.util.ArrayList arrayList = io.dcloud.WebAppActivity.this.y;
                        int size = arrayList.size();
                        while (i < size) {
                            java.lang.Object obj = arrayList.get(i);
                            i++;
                            ((io.dcloud.common.DHInterface.ICallBack) obj).onCallBack(1, action);
                        }
                        break;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b implements io.dcloud.common.DHInterface.ICallBack {
        b() {
        }

        @Override // io.dcloud.common.DHInterface.ICallBack
        public java.lang.Object onCallBack(int i, java.lang.Object obj) {
            if (i != 1) {
                return null;
            }
            io.dcloud.WebAppActivity webAppActivity = io.dcloud.WebAppActivity.this;
            if (webAppActivity.G == null) {
                webAppActivity.B = true;
                return null;
            }
            webAppActivity.closeAppStreamSplash((java.lang.String) obj);
            io.dcloud.WebAppActivity.this.B = false;
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class c implements android.content.DialogInterface.OnClickListener {
        final /* synthetic */ java.lang.String a;

        c(java.lang.String str) {
            this.a = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            io.dcloud.WebAppActivity.this.b(this.a, 1);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class d implements android.content.DialogInterface.OnClickListener {
        final /* synthetic */ java.lang.String a;

        d(java.lang.String str) {
            this.a = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            io.dcloud.WebAppActivity webAppActivity = io.dcloud.WebAppActivity.this;
            webAppActivity.updateParam("closewebapp", webAppActivity.that);
            io.dcloud.WebAppActivity.this.b(this.a, 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class e implements android.content.DialogInterface.OnKeyListener {
        final /* synthetic */ java.lang.String a;

        e(java.lang.String str) {
            this.a = str;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(android.content.DialogInterface dialogInterface, int i, android.view.KeyEvent keyEvent) {
            if (keyEvent.getAction() != 1 || i != 4) {
                return false;
            }
            io.dcloud.WebAppActivity webAppActivity = io.dcloud.WebAppActivity.this;
            webAppActivity.updateParam("closewebapp", webAppActivity.that);
            io.dcloud.WebAppActivity.this.b(this.a, 0);
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private class f implements io.dcloud.application.DCLoudApplicationImpl.ActivityStatusListener {
        private java.lang.ref.SoftReference a;

        public f(android.app.Activity activity) {
            this.a = new java.lang.ref.SoftReference(activity);
        }

        @Override // io.dcloud.application.DCLoudApplicationImpl.ActivityStatusListener
        public void onBack() {
            if (io.dcloud.common.util.AppRuntime.hasPrivacyForNotShown((android.content.Context) this.a.get())) {
                return;
            }
            android.app.Activity activity = (android.app.Activity) this.a.get();
            if (activity.isDestroyed() || activity.isFinishing()) {
                return;
            }
            try {
                io.dcloud.feature.gg.dcloud.dcmgr.SIAolManager.class.getMethod("load", android.app.Activity.class).invoke(io.dcloud.feature.gg.dcloud.dcmgr.SIAolManager.class.getMethod("getInstance", null).invoke(null, null), activity);
            } catch (java.lang.Exception unused) {
            }
        }

        @Override // io.dcloud.application.DCLoudApplicationImpl.ActivityStatusListener
        public void onFront() {
            if (io.dcloud.common.util.AppRuntime.hasPrivacyForNotShown((android.content.Context) this.a.get())) {
                return;
            }
            android.app.Activity activity = (android.app.Activity) this.a.get();
            if (activity.isDestroyed() || activity.isFinishing()) {
                return;
            }
            try {
                io.dcloud.feature.gg.dcloud.dcmgr.SIAolManager.class.getMethod(io.dcloud.common.constant.AbsoluteConst.EVENTS_WEBVIEW_SHOW, android.app.Activity.class).invoke(io.dcloud.feature.gg.dcloud.dcmgr.SIAolManager.class.getMethod("getInstance", null).invoke(null, null), activity);
            } catch (java.lang.Exception unused) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class g extends android.widget.RelativeLayout {
        int a;
        float b;
        int c;
        android.graphics.Paint d;
        int e;
        int f;
        int g;

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class a implements java.lang.Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                io.dcloud.WebAppActivity.g gVar = io.dcloud.WebAppActivity.g.this;
                int i = gVar.g - 5;
                gVar.g = i;
                if (i > 0) {
                    gVar.postDelayed(this, 5L);
                } else {
                    android.view.ViewGroup viewGroup = (android.view.ViewGroup) gVar.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(io.dcloud.WebAppActivity.g.this);
                    }
                }
                io.dcloud.WebAppActivity.g.this.invalidate();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        class b implements java.lang.Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                io.dcloud.WebAppActivity.g gVar = io.dcloud.WebAppActivity.g.this;
                int i = gVar.f;
                int i2 = gVar.e;
                int i3 = 10;
                int i4 = (i - i2) / 10;
                if (i4 <= 10) {
                    i3 = 1;
                    if (i4 >= 1) {
                        i3 = i4;
                    }
                }
                int i5 = i2 + i3;
                gVar.e = i5;
                if (i > i5) {
                    gVar.postDelayed(this, 5L);
                } else if (i >= gVar.a) {
                    gVar.a();
                }
                io.dcloud.WebAppActivity.g.this.invalidate();
            }
        }

        g(android.content.Context context) {
            super(context);
            this.c = 0;
            this.d = new android.graphics.Paint();
            this.e = 0;
            this.f = 0;
            this.g = 255;
            this.a = context.getResources().getDisplayMetrics().widthPixels;
            int i = context.getResources().getDisplayMetrics().heightPixels;
            if (i == 1280) {
                this.b = 6.0f;
            } else if (i != 1920) {
                this.b = context.getResources().getDisplayMetrics().heightPixels * 0.0045f;
            } else {
                this.b = 9.0f;
            }
        }

        void a() {
            postDelayed(new io.dcloud.WebAppActivity.g.a(), 50L);
        }

        void b() {
            a(100);
        }

        @Override // android.view.View
        protected void onDraw(android.graphics.Canvas canvas) {
            super.onDraw(canvas);
            this.d.setColor(android.graphics.Color.argb(this.g, 26, 173, 25));
            float f = this.c;
            canvas.drawRect(0.0f, f, this.e, f + this.b, this.d);
        }

        @Override // android.widget.RelativeLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            setMeasuredDimension(this.a, this.c + ((int) this.b));
        }

        void a(int i) {
            int i2 = (this.a * i) / 100;
            if (this.e >= this.f) {
                postDelayed(new io.dcloud.WebAppActivity.g.b(), 5L);
            }
            this.f = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(java.lang.String str, int i) {
        android.content.Intent intent = new android.content.Intent(io.dcloud.common.constant.AbsoluteConst.ACTION_APP_DOWNLOAD_ERROR_DIALOG_CLICKED);
        intent.putExtra("type", i);
        intent.putExtra("appid", str);
        intent.setPackage(getPackageName());
        sendBroadcast(intent);
    }

    public static void deviceInjectionGeoLocationJs(android.content.Context context) {
        io.dcloud.common.util.BaseInfo.injectionGeolocationJS = !io.dcloud.common.adapter.util.MobilePhoneModel.checkDeviceHtml5Geo();
    }

    private void k() {
        android.content.Intent intent = getIntent();
        boolean booleanExtra = intent != null ? intent.getBooleanExtra(io.dcloud.common.constant.IntentConst.PL_AUTO_HIDE, false) : false;
        android.util.Log.d("WebAppActivity", "checkAutoHide " + booleanExtra);
        if (booleanExtra) {
            android.content.Intent intent2 = new android.content.Intent();
            java.lang.String stringExtra = intent.getStringExtra(io.dcloud.common.constant.IntentConst.PL_AUTO_HIDE_SHOW_PN);
            java.lang.String stringExtra2 = intent.getStringExtra(io.dcloud.common.constant.IntentConst.PL_AUTO_HIDE_SHOW_ACTIVITY);
            intent2.putExtra(io.dcloud.common.constant.IntentConst.PL_AUTO_HIDE_SHOW_PN, true);
            intent2.setClassName(stringExtra, stringExtra2);
            this.that.startActivity(intent2);
            this.that.overridePendingTransition(0, 0);
            android.util.Log.d("WebAppActivity", "checkAutoHide return mini package " + stringExtra2);
        }
    }

    private java.lang.String l() {
        return this.p ? getIntent().getStringExtra("appid") : io.dcloud.common.util.BaseInfo.sDefaultBootApp;
    }

    private void m() {
        android.content.Intent intent = getIntent();
        if (intent != null) {
            boolean booleanExtra = intent.getBooleanExtra(io.dcloud.common.constant.IntentConst.IS_STREAM_APP, false);
            this.p = booleanExtra;
            if (booleanExtra) {
                return;
            }
            intent.removeExtra("appid");
        }
    }

    private void n() {
        android.content.IntentFilter intentFilter = new android.content.IntentFilter("com.huawei.intent.action.CLICK_STATUSBAR");
        intentFilter.addAction("android.intent.action.LOCALE_CHANGED");
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        if (this.s == null) {
            this.s = new io.dcloud.WebAppActivity.a();
        }
        if (android.os.Build.VERSION.SDK_INT >= 33) {
            registerReceiver(this.s, intentFilter, "huawei.permission.CLICK_STATUSBAR_BROADCAST", null, 2);
        } else {
            registerReceiver(this.s, intentFilter, "huawei.permission.CLICK_STATUSBAR_BROADCAST", (android.os.Handler) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o() {
        android.view.View view = this.A;
        if (view == null || this.mSplashView == null) {
            return;
        }
        if (view.getHeight() == 0 || this.A.getWidth() == 0) {
            this.A.measure(android.view.View.MeasureSpec.makeMeasureSpec(this.mSplashView.getWidth(), 1073741824), android.view.View.MeasureSpec.makeMeasureSpec(this.mSplashView.getHeight(), 1073741824));
            this.A.layout(0, 0, this.mSplashView.getWidth(), this.mSplashView.getHeight());
        }
    }

    @Override // io.dcloud.common.DHInterface.IActivityHandler
    public void addClickStatusbarCallBack(io.dcloud.common.DHInterface.ICallBack iCallBack) {
        if (this.y == null) {
            this.y = new java.util.ArrayList();
        }
        if (this.y.contains(iCallBack)) {
            return;
        }
        this.y.add(iCallBack);
    }

    protected void addViewToContentView(android.view.View view) {
        int iIndexOfChild = this.D.indexOfChild(this.mSplashView);
        int childCount = this.D.getChildCount();
        if (childCount <= 0) {
            this.D.addView(view);
            return;
        }
        for (int i = childCount - 1; i >= 0; i--) {
            android.view.View childAt = this.D.getChildAt(i);
            if (childAt != view) {
                if ("AppRootView".equals(childAt.getTag())) {
                    this.D.addView(view, i);
                    this.D.removeView(childAt);
                    return;
                } else if (i == 0) {
                    if (childAt == this.mSplashView) {
                        this.D.addView(view, 0);
                    } else if (iIndexOfChild > 0) {
                        this.D.addView(view, iIndexOfChild - 1);
                    } else {
                        this.D.addView(view);
                    }
                }
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(android.content.Context context) {
        this.v = context;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            super.attachBaseContext(context);
        } else {
            super.attachBaseContext(io.dcloud.common.util.language.LanguageUtil.updateContextLanguageAfterO(context, false));
        }
    }

    public int backPressed() {
        return 0;
    }

    @Override // io.dcloud.b, io.dcloud.common.DHInterface.IActivityHandler
    public /* bridge */ /* synthetic */ void callBack(java.lang.String str, android.os.Bundle bundle) {
        super.callBack(str, bundle);
    }

    @Override // io.dcloud.a
    public /* bridge */ /* synthetic */ void checkAndRequestPhoneState() {
        super.checkAndRequestPhoneState();
    }

    @Override // io.dcloud.a
    public /* bridge */ /* synthetic */ void checkAndRequestStoragePermission() {
        super.checkAndRequestStoragePermission();
    }

    @Override // io.dcloud.common.DHInterface.IActivityHandler
    public void closeAppStreamSplash(java.lang.String str) {
        io.dcloud.common.adapter.util.Logger.d("webappActivity closeAppStreamSplash");
        io.src.dcloud.adapter.DCloudAdapterUtil.Plugin2Host_closeAppStreamSplash(str);
        android.graphics.Bitmap bitmap = this.w;
        if (bitmap != null && !bitmap.isRecycled()) {
            try {
                this.w.recycle();
                this.w = null;
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
        if (this.mSplashView != null) {
            io.dcloud.common.adapter.util.Logger.d("webappActivity removeView mSplashView");
            android.view.View view = this.mSplashView;
            if (view instanceof io.dcloud.WebAppActivity.g) {
                ((io.dcloud.WebAppActivity.g) view).b();
            } else {
                this.D.removeView(view);
            }
            this.mSplashView = null;
            this.A = null;
        }
        this.z = false;
        this.mSplashShowing = false;
        this.x = 0L;
        io.dcloud.common.DHInterface.ICallBack iCallBack = this.G;
        if (iCallBack != null) {
            iCallBack.onCallBack(1, null);
            this.G = null;
        }
        initBackToFrontSplashAd();
        if (android.text.TextUtils.isEmpty(str)) {
            str = l();
        }
        io.dcloud.p.l.a(this, str, "onCloseSplashNoAd", null);
    }

    @Override // io.dcloud.common.DHInterface.IActivityHandler
    public void closeSideBar() {
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
    }

    @Override // io.dcloud.b, io.dcloud.common.DHInterface.IActivityHandler
    public /* bridge */ /* synthetic */ int getActivityState() {
        return super.getActivityState();
    }

    @Override // io.dcloud.b, io.dcloud.common.DHInterface.IActivityHandler
    public /* bridge */ /* synthetic */ android.content.Context getContext() {
        return super.getContext();
    }

    @Override // io.dcloud.common.DHInterface.IActivityHandler
    public android.content.Context getOriginalContext() {
        return this.v;
    }

    public android.view.View getProgressView() {
        android.view.View view = this.mSplashView;
        if (view == null || !(view instanceof io.dcloud.WebAppActivity.g)) {
            return null;
        }
        return view;
    }

    @Override // io.dcloud.a, androidx.appcompat.app.AppCompatActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public /* bridge */ /* synthetic */ android.content.res.Resources getResources() {
        return super.getResources();
    }

    @Override // io.dcloud.b, io.dcloud.common.DHInterface.IActivityHandler
    public /* bridge */ /* synthetic */ java.lang.String getUrlByFilePath(java.lang.String str, java.lang.String str2) {
        return super.getUrlByFilePath(str, str2);
    }

    @Override // io.dcloud.a, io.dcloud.common.DHInterface.IActivityHandler
    public boolean hasAdService() {
        return super.hasAdService() && this.z;
    }

    public void initBackToFrontSplashAd() {
        if (!io.dcloud.feature.internal.sdk.SDK.isUniMPSDK() && (getApplication() instanceof io.dcloud.application.DCloudApplication) && this.t == null) {
            io.dcloud.WebAppActivity.HomeKeyEventBroadcastReceiver homeKeyEventBroadcastReceiver = new io.dcloud.WebAppActivity.HomeKeyEventBroadcastReceiver();
            this.u = homeKeyEventBroadcastReceiver;
            if (android.os.Build.VERSION.SDK_INT >= 33) {
                registerReceiver(homeKeyEventBroadcastReceiver, new android.content.IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"), 2);
            } else {
                registerReceiver(homeKeyEventBroadcastReceiver, new android.content.IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
            }
            this.t = new io.dcloud.WebAppActivity.f(this);
            ((io.dcloud.application.DCloudApplication) getApplication()).addActivityStatusListener(this.t);
        }
    }

    @Override // io.dcloud.b, io.dcloud.common.DHInterface.IActivityHandler
    public /* bridge */ /* synthetic */ boolean isMultiProcessMode() {
        return super.isMultiProcessMode();
    }

    public boolean isSideBarCanRefresh() {
        if (this.D == null) {
            return false;
        }
        for (int i = 0; i < this.D.getChildCount(); i++) {
            android.view.View childAt = this.D.getChildAt(i);
            if (childAt != null && (childAt instanceof io.dcloud.common.DHInterface.SplashView)) {
                return false;
            }
        }
        return true;
    }

    @Override // io.dcloud.common.DHInterface.IActivityDelegate
    public android.widget.FrameLayout obtainActivityContentView() {
        return this.D;
    }

    @Override // io.dcloud.a, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onActivityResult(int i, int i2, android.content.Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    public void onAppActive(io.dcloud.common.DHInterface.IApp iApp) {
    }

    public void onAppActive(java.lang.String str) {
    }

    public void onAppStart(io.dcloud.common.DHInterface.IApp iApp) {
    }

    public void onAppStart(java.lang.String str) {
    }

    public void onAppStop(java.lang.String str) {
    }

    @Override // io.dcloud.b, io.dcloud.common.DHInterface.IActivityHandler
    public /* bridge */ /* synthetic */ void onAsyncStartAppEnd(java.lang.String str, java.lang.Object obj) {
        super.onAsyncStartAppEnd(str, obj);
    }

    @Override // io.dcloud.b, io.dcloud.common.DHInterface.IActivityHandler
    public /* bridge */ /* synthetic */ java.lang.Object onAsyncStartAppStart(java.lang.String str) {
        return super.onAsyncStartAppStart(str);
    }

    @Override // io.dcloud.a, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        int iBackPressed;
        io.dcloud.common.adapter.util.Logger.e("back", "WebAppActivity onBackPressed");
        if (isMultiProcessMode() || !(2 == (iBackPressed = backPressed()) || 1 == iBackPressed)) {
            io.dcloud.p.l.a(this, android.text.TextUtils.isEmpty(this.e) ? l() : this.e, "onBack", this.A);
            super.onBackPressed();
        }
    }

    @Override // io.dcloud.a, io.dcloud.common.DHInterface.IOnCreateSplashView
    public /* bridge */ /* synthetic */ void onCloseSplash() {
        super.onCloseSplash();
    }

    @Override // io.dcloud.a, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public /* bridge */ /* synthetic */ void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // io.dcloud.a, io.dcloud.b, io.src.dcloud.adapter.DCloudBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        io.dcloud.common.util.BaseInfo.startTime = java.lang.System.currentTimeMillis();
        io.dcloud.common.util.AppRuntime.restartWeex(getApplication(), null, getIntent().getStringExtra("appid"));
        io.dcloud.common.util.language.LanguageUtil.updateDeviceDefLocalLanguage(this);
        android.util.Log.e("Html5Plus-onCreate", java.lang.System.currentTimeMillis() + "");
        io.dcloud.common.util.ShortCutUtil.activityNameSDK = getIntent().getStringExtra(io.dcloud.common.constant.IntentConst.WEBAPP_ACTIVITY_SHORTCUTACTIVITY);
        io.dcloud.common.util.ShortCutUtil.mAutoCreateShortcut = getIntent().getBooleanExtra(io.dcloud.common.constant.IntentConst.WEBAPP_ACTIVITY_AUTOCREATESHORTCUT, true);
        java.io.Serializable serializableExtra = getIntent().getSerializableExtra(io.dcloud.common.constant.IntentConst.WEBAPP_ACTIVITY_EXTRAPRO);
        if (io.dcloud.common.util.PdrUtil.isEmpty(serializableExtra)) {
            io.dcloud.common.util.ShortCutUtil.extraProSDK = (java.util.HashMap) serializableExtra;
        }
        if (getIntent().hasExtra(io.dcloud.common.constant.IntentConst.INTENT_ORIENTATION)) {
            setRequestedOrientation(getIntent().getIntExtra(io.dcloud.common.constant.IntentConst.INTENT_ORIENTATION, 2));
        }
        deviceInjectionGeoLocationJs(getApplicationContext());
        android.util.Log.d("WebAppActivity", "onCreate");
        m();
        if (!this.p) {
            io.dcloud.common.util.TestUtil.record(io.dcloud.common.constant.AbsoluteConst.RUN_5AP_TIME_KEY);
        }
        super.onCreate(bundle);
        io.dcloud.common.util.BaseInfo.isFirstRun = false;
        io.dcloud.common.adapter.ui.FrameSwitchView frameSwitchView = io.dcloud.common.adapter.ui.FrameSwitchView.getInstance(this.that);
        if (!frameSwitchView.isInit()) {
            frameSwitchView.initView();
        }
        k();
    }

    public void onCreateAdSplash(android.content.Context context) {
        if (this.p || this.mSplashView == null || this.A != null) {
            return;
        }
        if (super.hasAdService()) {
            this.A = io.dcloud.p.l.a(this.that, new io.dcloud.WebAppActivity.b(), io.dcloud.common.util.BaseInfo.sDefaultBootApp);
        }
        android.view.View view = this.A;
        this.z = view != null;
        if (view != null) {
            if (view.getParent() != null) {
                ((android.view.ViewGroup) this.A.getParent()).removeView(this.A);
            }
            android.view.View view2 = this.mSplashView;
            if (view2 instanceof android.view.ViewGroup) {
                ((android.view.ViewGroup) view2).addView(this.A, new android.view.ViewGroup.LayoutParams(-1, -1));
            }
            this.mSplashView.post(new java.lang.Runnable() { // from class: io.dcloud.WebAppActivity$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.o();
                }
            });
        }
    }

    @Override // io.dcloud.a, android.app.Activity
    public /* bridge */ /* synthetic */ boolean onCreateOptionsMenu(android.view.Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override // io.dcloud.a, io.dcloud.common.DHInterface.IOnCreateSplashView
    public java.lang.Object onCreateSplash(android.content.Context context) {
        android.view.Window window = getWindow();
        int i = android.os.Build.VERSION.SDK_INT;
        if (i <= 25) {
            android.view.WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.flags |= 1024;
            window.setAttributes(attributes);
        } else if (i > 25) {
            window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 1280);
            window.setStatusBarColor(0);
            if (i >= 28 && window.getDecorView().getRootWindowInsets() != null) {
                android.view.WindowManager.LayoutParams attributes2 = window.getAttributes();
                attributes2.flags |= 1024;
                attributes2.layoutInDisplayCutoutMode = 1;
                window.setAttributes(attributes2);
            }
        }
        if (this.mSplashView != null) {
            return null;
        }
        io.dcloud.common.util.BaseInfo.splashCreateTime = java.lang.System.currentTimeMillis();
        a(context);
        return null;
    }

    @Override // io.dcloud.a, io.dcloud.b, io.src.dcloud.adapter.DCloudBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        io.dcloud.common.DHInterface.message.ActionBus.getInstance().sendToBus(io.dcloud.common.DHInterface.message.action.WebActivityOnDestroyAction.obtain());
        super.onDestroy();
        try {
            unregisterReceiver(this.s);
            this.y.clear();
            io.dcloud.common.adapter.util.PermissionUtil.clearUseRejectedCache();
            io.dcloud.common.util.ImageLoaderUtil.clearCache();
        } catch (java.lang.Exception unused) {
        }
        android.os.Handler handler = this.q;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (getApplication() instanceof io.dcloud.application.DCloudApplication) {
            ((io.dcloud.application.DCloudApplication) getApplication()).removeActivityStatusListener(this.t);
        }
        io.dcloud.WebAppActivity.HomeKeyEventBroadcastReceiver homeKeyEventBroadcastReceiver = this.u;
        if (homeKeyEventBroadcastReceiver != null) {
            unregisterReceiver(homeKeyEventBroadcastReceiver);
        }
        io.dcloud.common.adapter.ui.FrameSwitchView.getInstance(this.that).clearData();
        io.dcloud.common.core.ui.TabBarWebviewMgr.getInstance().setLancheTabBar(null);
        android.app.AlertDialog alertDialog = this.o;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.o.dismiss();
        }
        io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.feature.weex.WeexDevtoolImpl", "unregisterReceiver", null, new java.lang.Class[]{android.content.Context.class}, new java.lang.Object[]{getContext()});
        this.o = null;
        this.v = null;
        com.bumptech.glide.Glide.get(this).clearMemory();
    }

    @Override // io.dcloud.a, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public /* bridge */ /* synthetic */ boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    @Override // io.dcloud.a, io.dcloud.common.DHInterface.IKeyHandler
    public /* bridge */ /* synthetic */ boolean onKeyEventExecute(io.dcloud.common.DHInterface.ISysEventListener.SysEventType sysEventType, int i, android.view.KeyEvent keyEvent) {
        return super.onKeyEventExecute(sysEventType, i, keyEvent);
    }

    @Override // io.dcloud.a, android.app.Activity, android.view.KeyEvent.Callback
    public /* bridge */ /* synthetic */ boolean onKeyLongPress(int i, android.view.KeyEvent keyEvent) {
        return super.onKeyLongPress(i, keyEvent);
    }

    @Override // io.dcloud.a, android.app.Activity, android.view.KeyEvent.Callback
    public /* bridge */ /* synthetic */ boolean onKeyUp(int i, android.view.KeyEvent keyEvent) {
        return super.onKeyUp(i, keyEvent);
    }

    @Override // io.dcloud.a, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public /* bridge */ /* synthetic */ void onLowMemory() {
        super.onLowMemory();
    }

    @Override // io.dcloud.a, io.src.dcloud.adapter.DCloudBaseActivity
    public void onNewIntentImpl(android.content.Intent intent) {
        super.onNewIntentImpl(intent);
    }

    @Override // io.dcloud.a, io.dcloud.b, androidx.fragment.app.FragmentActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onPause() {
        super.onPause();
    }

    @Override // io.dcloud.a
    public /* bridge */ /* synthetic */ void onPrivacySureAction() {
        super.onPrivacySureAction();
    }

    @Override // io.dcloud.a, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // io.dcloud.a, io.dcloud.b, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        android.util.Log.e("Html5Plus-onResume", java.lang.System.currentTimeMillis() + "");
        getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(android.graphics.Color.parseColor("#333333")));
    }

    @Override // io.dcloud.a
    protected void onRuntimeCreate(android.os.Bundle bundle) {
        n();
        super.onRuntimeCreate(bundle);
    }

    @Override // io.dcloud.a, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public /* bridge */ /* synthetic */ void onSaveInstanceState(android.os.Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        io.dcloud.common.adapter.util.PlatformUtil.SCREEN_WIDTH(this.that);
        io.dcloud.common.adapter.util.PlatformUtil.SCREEN_HEIGHT(this.that);
        io.dcloud.common.adapter.util.PlatformUtil.MESURE_SCREEN_STATUSBAR_HEIGHT(this.that);
    }

    public void recordDialog(android.app.Dialog dialog) {
    }

    @Override // io.dcloud.b
    public /* bridge */ /* synthetic */ void registerLocalReceiver(io.dcloud.feature.internal.reflect.BroadcastReceiver broadcastReceiver, android.content.IntentFilter intentFilter) {
        super.registerLocalReceiver(broadcastReceiver, intentFilter);
    }

    @Override // io.dcloud.b
    public /* bridge */ /* synthetic */ android.content.Intent registerReceiver(io.dcloud.feature.internal.reflect.BroadcastReceiver broadcastReceiver, android.content.IntentFilter intentFilter, java.lang.String str, android.os.Handler handler) {
        return super.registerReceiver(broadcastReceiver, intentFilter, str, handler);
    }

    @Override // io.dcloud.common.DHInterface.IActivityHandler
    public void removeClickStatusbarCallBack(io.dcloud.common.DHInterface.ICallBack iCallBack) {
        java.util.ArrayList arrayList = this.y;
        if (arrayList == null || !arrayList.contains(iCallBack)) {
            return;
        }
        this.y.remove(iCallBack);
    }

    public void removeFromRecord(android.app.Dialog dialog) {
    }

    @Override // io.dcloud.b, io.dcloud.common.DHInterface.IActivityHandler
    public /* bridge */ /* synthetic */ void sendLocalBroadcast(android.content.Intent intent) {
        super.sendLocalBroadcast(intent);
    }

    public void setProgressView() {
        for (int i = 0; i < this.D.getChildCount(); i++) {
            android.view.View childAt = this.D.getChildAt(i);
            if (childAt != null && childAt == this.mSplashView) {
                this.D.removeViewAt(i);
                break;
            }
        }
        io.dcloud.WebAppActivity.g gVar = new io.dcloud.WebAppActivity.g(this.that);
        this.mSplashView = gVar;
        this.D.addView(gVar);
    }

    @Override // io.dcloud.a
    public /* bridge */ /* synthetic */ void setSecondPrivacyAlert() {
        super.setSecondPrivacyAlert();
    }

    @Override // io.dcloud.common.DHInterface.IActivityHandler
    public void setSideBarVisibility(int i) {
    }

    @Override // io.dcloud.common.DHInterface.IActivityHandler
    public void setSplashCloseListener(java.lang.String str, io.dcloud.common.DHInterface.ICallBack iCallBack) {
        this.G = iCallBack;
        if (this.mSplashView == null) {
            iCallBack.onCallBack(1, null);
            this.G = null;
        }
        if (this.B) {
            closeAppStreamSplash(str);
        }
        if (android.text.TextUtils.isEmpty(str)) {
            str = l();
        }
        io.dcloud.p.l.a(this, str, "onWillCloseSplash", this.A);
        this.B = false;
    }

    @Override // io.dcloud.common.DHInterface.IActivityHandler
    public void setViewAsContentView(android.view.View view, android.widget.FrameLayout.LayoutParams layoutParams) {
        if (this.D == null) {
            android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(this.that);
            this.D = frameLayout;
            if (this.E != null) {
                this.D.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -1));
                this.E.addView(this.D);
                setContentView(this.E);
            } else {
                setContentView(frameLayout);
            }
            io.dcloud.common.core.ui.DCKeyboardManager.getInstance().setContentView(this);
        }
        io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.appstream.actionbar.StreamAppActionBarUtil", "checkNeedTitleView", null, new java.lang.Class[]{android.app.Activity.class, java.lang.String.class}, new java.lang.Object[]{this.that, getIntent().getStringExtra("appid")});
        addViewToContentView(view);
        if (layoutParams != null) {
            view.setLayoutParams(layoutParams);
        }
        io.dcloud.common.util.TestUtil.print(io.dcloud.common.util.TestUtil.START_APP_SET_ROOTVIEW, "start" + view);
    }

    @Override // io.dcloud.common.DHInterface.IActivityHandler
    public void setWebViewIntoPreloadView(android.view.View view) {
        if (this.F == null) {
            android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(this.that);
            this.F = frameLayout;
            this.D.addView(frameLayout, 0);
        }
        this.F.addView(view);
    }

    public void showDownloadDialog(java.lang.String str, java.lang.String str2) {
        if (this.mSplashShowing) {
            android.app.AlertDialog alertDialog = this.o;
            if (alertDialog == null || !alertDialog.isShowing()) {
                if (this.o == null) {
                    this.o = new android.app.AlertDialog.Builder(this.that).create();
                }
                this.o.setTitle(getString(io.dcloud.base.R.string.dcloud_common_tips));
                if (io.dcloud.common.util.TestUtil.PointTime.mEc == 20) {
                    this.o.setMessage(getString(io.dcloud.base.R.string.dcloud_common_no_network_tips));
                } else if (str != null) {
                    this.o.setMessage(getString(io.dcloud.base.R.string.dcloud_common_into) + str + getString(io.dcloud.base.R.string.dcloud_common_fail) + getErrorTipMsg());
                } else {
                    this.o.setMessage(getString(io.dcloud.base.R.string.dcloud_common_run_app_failed) + getErrorTipMsg());
                }
                this.o.setCanceledOnTouchOutside(false);
                this.o.setButton(-1, getString(io.dcloud.base.R.string.dcloud_common_retry), new io.dcloud.WebAppActivity.c(str2));
                this.o.setButton(-2, getString(io.dcloud.base.R.string.dcloud_common_close), new io.dcloud.WebAppActivity.d(str2));
                this.o.setOnKeyListener(new io.dcloud.WebAppActivity.e(str2));
                this.o.show();
            }
        }
    }

    @Override // io.dcloud.common.DHInterface.IActivityHandler
    public void showSplashWaiting() {
        if (this.C) {
            android.view.View view = this.mSplashView;
            if (view instanceof io.dcloud.common.DHInterface.SplashView) {
                ((io.dcloud.common.DHInterface.SplashView) view).showWaiting();
            }
        }
    }

    @Override // io.dcloud.common.DHInterface.IActivityHandler
    public void sideBarHideMenu() {
    }

    @Override // io.dcloud.common.DHInterface.IActivityHandler
    public void sideBarShowMenu(java.lang.String str, java.lang.String str2, io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str3) {
    }

    @Override // io.dcloud.b, io.dcloud.common.DHInterface.IActivityHandler
    public /* bridge */ /* synthetic */ void unregisterReceiver(io.dcloud.feature.internal.reflect.BroadcastReceiver broadcastReceiver) {
        super.unregisterReceiver(broadcastReceiver);
    }

    @Override // io.dcloud.a, io.dcloud.common.DHInterface.IActivityHandler
    public void updateParam(java.lang.String str, java.lang.Object obj) {
        if ("progress".equals(str)) {
            android.view.View view = this.mSplashView;
            if (view instanceof io.dcloud.WebAppActivity.g) {
                ((io.dcloud.WebAppActivity.g) view).a(((java.lang.Integer) obj).intValue());
                return;
            }
            return;
        }
        if ("setProgressView".equals(str)) {
            setProgressView();
        } else {
            super.updateParam(str, obj);
        }
    }

    @Override // io.dcloud.common.DHInterface.IActivityHandler
    public void updateSplash(java.lang.String str) {
        android.view.KeyEvent.Callback callback = this.mSplashView;
        if (callback == null || !(callback instanceof io.dcloud.feature.internal.splash.ISplash)) {
            return;
        }
        ((io.dcloud.feature.internal.splash.ISplash) callback).setNameText(str);
    }

    public java.lang.String getErrorTipMsg() {
        int i = io.dcloud.common.util.TestUtil.PointTime.mEc;
        if (i == 4) {
            return "" + getString(io.dcloud.base.R.string.dcloud_common_not_sd_card);
        }
        if (i == 9) {
            return "" + getString(io.dcloud.base.R.string.dcloud_common_sd_not_space);
        }
        int i2 = io.dcloud.common.util.TestUtil.PointTime.mEt;
        if (i2 == 1) {
            return "" + getString(io.dcloud.base.R.string.dcloud_common_setting_download_failed);
        }
        if (i2 != 3 && i2 != 2) {
            return "";
        }
        return "" + getString(io.dcloud.base.R.string.dcloud_common_app_res_download_failed);
    }

    @Override // io.dcloud.b, io.dcloud.common.DHInterface.IActivityHandler
    public /* bridge */ /* synthetic */ void registerReceiver(io.dcloud.feature.internal.reflect.BroadcastReceiver broadcastReceiver, android.content.IntentFilter intentFilter) {
        super.registerReceiver(broadcastReceiver, intentFilter);
    }

    private android.graphics.Bitmap a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        android.graphics.Bitmap bitmapDecodeFile = null;
        try {
            if (!android.text.TextUtils.isEmpty(str) && new java.io.File(str).exists()) {
                io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.MAIN_TAG, "use splashPath=" + str);
                bitmapDecodeFile = android.graphics.BitmapFactory.decodeFile(str);
                if (bitmapDecodeFile != null) {
                    this.C = false;
                    try {
                        io.dcloud.common.adapter.io.DHFile.deleteFile(str);
                    } catch (java.io.IOException e2) {
                        e2.printStackTrace();
                    }
                    io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.MAIN_TAG, "use splashPath=" + str);
                }
            }
            if (bitmapDecodeFile == null && !android.text.TextUtils.isEmpty(str2) && new java.io.File(str2).exists()) {
                io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.MAIN_TAG, "use splashPath=" + str2);
                bitmapDecodeFile = android.graphics.BitmapFactory.decodeFile(str2);
            }
            if (bitmapDecodeFile != null || android.text.TextUtils.isEmpty(str3) || !new java.io.File(str3).exists()) {
                return bitmapDecodeFile;
            }
            io.dcloud.common.adapter.util.Logger.d(io.dcloud.common.adapter.util.Logger.MAIN_TAG, "use splashPath=" + str3);
            return android.graphics.BitmapFactory.decodeFile(str3);
        } catch (java.lang.Exception e3) {
            e3.printStackTrace();
            return bitmapDecodeFile;
        }
    }

    private java.lang.Object a(android.content.Context context) {
        boolean booleanExtra;
        android.view.KeyEvent.Callback callback;
        android.view.KeyEvent.Callback callback2;
        android.content.Intent intent = getIntent();
        java.lang.String stringExtra = intent.getStringExtra("appid");
        io.dcloud.common.adapter.util.Logger.d("splash", "WebAppActivity.onCreateSplash().appid=" + stringExtra + " this.appid=" + this.e + " this=" + this.that);
        java.lang.StringBuilder sb = new java.lang.StringBuilder("WebAppActivity.onCreateSplash().mSplashView is Null =");
        sb.append(this.mSplashView == null);
        io.dcloud.common.adapter.util.Logger.d("splash", sb.toString());
        android.view.View view = this.mSplashView;
        if (view != null && view.getTag() != null) {
            if (this.mSplashView.getTag().equals(stringExtra)) {
                return null;
            }
            closeAppStreamSplash(this.mSplashView.getTag().toString());
        }
        this.C = true;
        io.dcloud.common.adapter.util.Logger.d("WebAppActivity", "onCreateSplash;intent=" + intent);
        boolean booleanExtra2 = intent.getBooleanExtra(io.dcloud.common.constant.IntentConst.IS_START_FIRST_WEB, false);
        boolean z = intent.hasExtra(io.dcloud.common.constant.IntentConst.DIRECT_PAGE) && io.dcloud.common.util.BaseInfo.isWap2AppAppid(stringExtra);
        if ((booleanExtra2 && !z) || !(booleanExtra = intent.getBooleanExtra(io.dcloud.common.constant.IntentConst.SPLASH_VIEW, true))) {
            return null;
        }
        io.dcloud.common.adapter.util.Logger.d("WebAppActivity", "onCreateSplash hasSplash=" + booleanExtra);
        if (intent.getBooleanExtra(io.dcloud.common.constant.IntentConst.PL_AUTO_HIDE, false)) {
            return null;
        }
        java.lang.String stringExtra2 = intent.getStringExtra(io.dcloud.common.constant.IntentConst.WEBAPP_ACTIVITY_SPLASH_MODE);
        intent.removeExtra(io.dcloud.common.constant.IntentConst.WEBAPP_ACTIVITY_SPLASH_MODE);
        if (stringExtra2 == null || "".equals(stringExtra2.trim()) || (!"auto".equals(stringExtra2) && !"default".equals(stringExtra2))) {
            stringExtra2 = "auto";
        }
        io.dcloud.common.adapter.util.Logger.d("WebAppActivity", "onCreateSplash __splash_mode__=" + stringExtra2);
        if (intent.getBooleanExtra(io.dcloud.common.constant.IntentConst.WEBAPP_ACTIVITY_HIDE_STREAM_SPLASH, false)) {
            setViewAsContentView(new android.view.View(context), null);
            this.x = java.lang.System.currentTimeMillis();
            this.mSplashShowing = true;
            return null;
        }
        boolean z2 = z;
        if (intent.getBooleanExtra(io.dcloud.common.constant.IntentConst.WEBAPP_ACTIVITY_HAS_STREAM_SPLASH, false)) {
            if (this.mSplashView == null) {
                if ("auto".equals(stringExtra2)) {
                    if (!z2) {
                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                        java.lang.String str = io.dcloud.common.constant.StringConst.STREAMAPP_KEY_ROOTPATH;
                        sb2.append(str);
                        sb2.append("splash_temp/");
                        sb2.append(stringExtra);
                        sb2.append(".png");
                        this.w = a(sb2.toString(), intent.getStringExtra(io.dcloud.common.constant.IntentConst.APP_SPLASH_PATH), str + "splash/" + stringExtra + ".png");
                    }
                    if (this.w != null) {
                        io.dcloud.common.DHInterface.SplashView splashView = new io.dcloud.common.DHInterface.SplashView(this.that, this.w);
                        this.mSplashView = splashView;
                        if (!this.C) {
                            splashView.showWaiting(io.dcloud.common.DHInterface.SplashView.STYLE_BLACK);
                        }
                    }
                }
                if (this.mSplashView == null) {
                    java.lang.String stringExtra3 = intent.getStringExtra(io.dcloud.common.constant.IntentConst.WEBAPP_ACTIVITY_APPICON);
                    if (!android.text.TextUtils.isEmpty(stringExtra3) && new java.io.File(stringExtra3).exists()) {
                        this.w = android.graphics.BitmapFactory.decodeFile(stringExtra3);
                    }
                    this.mSplashView = a(context, this.w, intent.getStringExtra(io.dcloud.common.constant.IntentConst.NAME), stringExtra);
                    if (this.w == null && io.dcloud.common.util.PdrUtil.isEmpty(stringExtra) && (callback2 = this.mSplashView) != null && (callback2 instanceof io.dcloud.feature.internal.splash.ISplash)) {
                        ((io.dcloud.feature.internal.splash.ISplash) callback2).setImageBitmap(android.graphics.BitmapFactory.decodeResource(getResources(), io.dcloud.PdrR.getInt(getContext(), "drawable", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ICON)));
                    }
                }
            }
            this.mSplashView.setTag(stringExtra);
            setViewAsContentView(this.mSplashView, null);
            this.x = java.lang.System.currentTimeMillis();
            this.mSplashShowing = true;
            io.dcloud.common.adapter.util.Logger.e("IAN", "onCreateSplash aliyun ended");
            return null;
        }
        if (this.mSplashView != null) {
            return null;
        }
        try {
            if ("auto".equals(stringExtra2)) {
                if (!z2) {
                    java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                    java.lang.String str2 = io.dcloud.common.constant.StringConst.STREAMAPP_KEY_ROOTPATH;
                    sb3.append(str2);
                    sb3.append("splash_temp/");
                    sb3.append(stringExtra);
                    sb3.append(".png");
                    this.w = a(sb3.toString(), intent.getStringExtra(io.dcloud.common.constant.IntentConst.APP_SPLASH_PATH), str2 + "splash/" + stringExtra + ".png");
                }
                if (this.w == null) {
                    java.lang.String string = io.dcloud.common.adapter.util.SP.getOrCreateBundle(getContext(), "pdr").getString(io.dcloud.common.adapter.util.SP.UPDATE_SPLASH_IMG_PATH, "");
                    if (!android.text.TextUtils.isEmpty(string)) {
                        try {
                            if (io.dcloud.common.util.PdrUtil.isDeviceRootDir(string)) {
                                this.w = android.graphics.BitmapFactory.decodeFile(string);
                            } else {
                                java.io.InputStream inputStreamOpen = getResources().getAssets().open(string);
                                this.w = android.graphics.BitmapFactory.decodeStream(inputStreamOpen);
                                inputStreamOpen.close();
                            }
                        } catch (java.lang.Exception unused) {
                            this.w = null;
                        }
                    }
                    if (this.w == null && !this.p) {
                        this.w = android.graphics.BitmapFactory.decodeResource(getResources(), io.dcloud.PdrR.getInt(context, "drawable", "splash"));
                    }
                }
                if (this.w != null) {
                    io.dcloud.common.DHInterface.SplashView splashView2 = new io.dcloud.common.DHInterface.SplashView(this.that, this.w);
                    this.mSplashView = splashView2;
                    if (!this.C) {
                        splashView2.showWaiting(io.dcloud.common.DHInterface.SplashView.STYLE_BLACK);
                    }
                }
            }
            if (this.mSplashView == null) {
                java.lang.String stringExtra4 = intent.getStringExtra(io.dcloud.common.constant.IntentConst.WEBAPP_ACTIVITY_APPICON);
                if (!android.text.TextUtils.isEmpty(stringExtra4) && new java.io.File(stringExtra4).exists()) {
                    this.w = android.graphics.BitmapFactory.decodeFile(stringExtra4);
                }
                android.util.Log.d(io.dcloud.common.adapter.util.Logger.MAIN_TAG, "use defaultSplash");
                this.mSplashView = a(context, this.w, intent.getStringExtra(io.dcloud.common.constant.IntentConst.NAME), stringExtra);
                if (this.w == null && io.dcloud.common.util.PdrUtil.isEmpty(stringExtra) && (callback = this.mSplashView) != null && (callback instanceof io.dcloud.feature.internal.splash.ISplash)) {
                    ((io.dcloud.feature.internal.splash.ISplash) callback).setImageBitmap(android.graphics.BitmapFactory.decodeResource(getResources(), io.dcloud.PdrR.getInt(getContext(), "drawable", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ICON)));
                }
            }
            this.mSplashView.setTag(stringExtra);
            setViewAsContentView(this.mSplashView, null);
            this.x = java.lang.System.currentTimeMillis();
            this.mSplashShowing = true;
            return null;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private java.lang.String a(java.lang.String str) {
        if (io.src.dcloud.adapter.DCloudAdapterUtil.isPlugin()) {
            return null;
        }
        try {
            android.content.pm.ApplicationInfo applicationInfo = this.that.getPackageManager().getApplicationInfo(getPackageName(), 128);
            android.os.Bundle bundle = applicationInfo != null ? applicationInfo.metaData : null;
            if (bundle == null || io.dcloud.common.util.PdrUtil.isEmpty(bundle.get(str))) {
                return null;
            }
            return java.lang.String.valueOf(bundle.get(str));
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private android.view.View a(android.content.Context context, android.graphics.Bitmap bitmap, java.lang.String str, java.lang.String str2) {
        boolean z;
        java.lang.String strA = a("DCLOUD_STREAMAPP_CHANNEL");
        if (io.dcloud.common.util.PdrUtil.isEmpty(str2) && io.dcloud.common.util.PdrUtil.isEmpty(str)) {
            str = getString(io.dcloud.PdrR.getInt(context, "string", io.dcloud.common.constant.IntentConst.WEBAPP_ACTIVITY_APPNAME));
            z = true;
        } else {
            z = false;
        }
        return "_12214060304".equals(strA) ? (android.view.View) io.dcloud.common.adapter.util.PlatformUtil.newInstance("io.dcloud.html5pframework.splash.SplashView4Yunos", new java.lang.Class[]{android.content.Context.class, android.graphics.Bitmap.class, java.lang.String.class}, new java.lang.Object[]{context, bitmap, str}) : new io.dcloud.feature.internal.splash.SplashViewDBackground(context, bitmap, str, z);
    }
}
