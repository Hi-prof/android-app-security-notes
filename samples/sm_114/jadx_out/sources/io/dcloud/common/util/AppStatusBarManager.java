package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class AppStatusBarManager {
    private io.dcloud.common.DHInterface.IApp mIApp;
    private io.dcloud.p.e5 mWebAppInfo;
    private int mStatusBarDefaultColor = 0;
    public boolean isImmersive = false;
    public boolean isFullScreen = false;
    public boolean isHandledWhiteScreen = false;
    public boolean isTemporaryFullScreen = true;

    /* JADX WARN: Multi-variable type inference failed */
    public AppStatusBarManager(android.app.Activity activity, io.dcloud.p.e5 e5Var) {
        initStatusBarDefaultColor(activity);
        this.mWebAppInfo = e5Var;
        this.mIApp = (io.dcloud.common.DHInterface.IApp) e5Var;
        initDirectImmersive();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void diyContentFullScreenBug(android.app.Activity activity) {
        if ((activity instanceof io.dcloud.common.DHInterface.IActivityDelegate ? ((io.dcloud.common.DHInterface.IActivityDelegate) activity).obtainActivityContentView() : null) == null) {
            return;
        }
        if (!this.isFullScreen && !this.isImmersive) {
            this.isTemporaryFullScreen = false;
            io.dcloud.common.core.ui.DCKeyboardManager.getInstance().setAdjust(false);
            return;
        }
        java.lang.String metaValue = io.dcloud.common.adapter.util.AndroidResources.getMetaValue("DCLOUD_INPUT_MODE");
        if (android.text.TextUtils.isEmpty(metaValue) || !metaValue.contains("adjustPan")) {
            io.dcloud.common.core.ui.DCKeyboardManager.getInstance().setAdjust(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.view.View getRootView(android.app.Activity activity) {
        return activity.findViewById(android.R.id.content);
    }

    private void initDirectImmersive() {
        if (this.mWebAppInfo.getActivity().getIntent().hasExtra(io.dcloud.common.constant.IntentConst.DIRECT_PAGE) && io.dcloud.common.util.BaseInfo.isWap2AppAppid(this.mWebAppInfo.o)) {
            org.json.JSONObject directStatusJson = getDirectStatusJson(this.mIApp);
            if (directStatusJson == null || !directStatusJson.has(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR_IMMERSED)) {
                this.isImmersive = true;
            } else {
                this.isImmersive = directStatusJson.optBoolean(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR_IMMERSED);
            }
            io.dcloud.common.util.BaseInfo.isImmersive = this.isImmersive;
        }
    }

    private void setMeizuStatusBarDarkIcon(android.app.Activity activity, boolean z) {
        if (activity != null) {
            try {
                android.view.WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                java.lang.reflect.Field declaredField = android.view.WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                java.lang.reflect.Field declaredField2 = android.view.WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i = declaredField.getInt(null);
                int i2 = declaredField2.getInt(attributes);
                declaredField2.setInt(attributes, z ? i2 | i : (~i) & i2);
                activity.getWindow().setAttributes(attributes);
            } catch (java.lang.Exception unused) {
            }
        }
    }

    private void setMiuiStatusBarDarkMode(android.app.Activity activity, boolean z) {
        java.lang.Class<?> cls = activity.getWindow().getClass();
        try {
            java.lang.Class<?> cls2 = java.lang.Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            java.lang.Class<?> cls3 = java.lang.Integer.TYPE;
            cls.getMethod("setExtraFlags", cls3, cls3).invoke(activity.getWindow(), java.lang.Integer.valueOf(z ? i : 0), java.lang.Integer.valueOf(i));
        } catch (java.lang.Exception unused) {
        }
    }

    private void setTranslucentStatus(final android.app.Activity activity, boolean z) {
        android.view.Window window = activity.getWindow();
        android.view.WindowManager.LayoutParams attributes = window.getAttributes();
        if (z) {
            attributes.flags |= androidx.core.view.accessibility.AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        } else {
            attributes.flags &= -67108865;
        }
        window.setAttributes(attributes);
        window.getDecorView().post(new java.lang.Runnable() { // from class: io.dcloud.common.util.AppStatusBarManager.2
            @Override // java.lang.Runnable
            public void run() {
                android.view.View rootView = io.dcloud.common.util.AppStatusBarManager.this.getRootView(activity);
                if (rootView.getParent() instanceof android.widget.LinearLayout) {
                    rootView.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -1));
                } else if (rootView.getParent() instanceof android.widget.FrameLayout) {
                    rootView.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
                }
            }
        });
    }

    public boolean checkImmersedStatusBar(android.content.Context context, boolean z) {
        boolean z2;
        android.os.Bundle bundle;
        int i = android.os.Build.VERSION.SDK_INT;
        boolean z3 = false;
        try {
            android.content.pm.ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            z2 = (applicationInfo == null || (bundle = applicationInfo.metaData) == null) ? false : bundle.getBoolean("immersed.status.bar", false);
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (z2) {
            z = z2;
        }
        if (!this.mWebAppInfo.n.equals("suggestedDevice") || !z) {
            z3 = z;
        } else if (io.dcloud.common.adapter.util.DeviceInfo.sBrand.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.XIAOMI) || io.dcloud.common.adapter.util.DeviceInfo.sBrand.contentEquals(io.dcloud.common.adapter.util.MobilePhoneModel.MEIZU) || i >= 23) {
            z3 = true;
        }
        this.isImmersive = z3;
        if (!z3 && this.mWebAppInfo.getActivity().getIntent().hasExtra(io.dcloud.common.constant.IntentConst.DIRECT_PAGE) && io.dcloud.common.util.BaseInfo.isWap2AppAppid(this.mWebAppInfo.o) && !this.mIApp.manifestBeParsed()) {
            org.json.JSONObject directStatusJson = getDirectStatusJson(this.mIApp);
            if (directStatusJson == null || !directStatusJson.has(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR_IMMERSED)) {
                this.isImmersive = true;
            } else {
                this.isImmersive = directStatusJson.optBoolean(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR_IMMERSED);
            }
            z3 = this.isImmersive;
        }
        io.dcloud.common.util.BaseInfo.isImmersive = this.isImmersive;
        return z3;
    }

    public org.json.JSONObject getDirectStatusJson(io.dcloud.common.DHInterface.IApp iApp) {
        org.json.JSONObject jSONObjectObtainThridInfo = iApp.obtainThridInfo(io.dcloud.common.DHInterface.IApp.ConfigProperty.ThridInfo.DirectPageJsonData);
        if (jSONObjectObtainThridInfo != null && jSONObjectObtainThridInfo.has(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR)) {
            org.json.JSONObject jSONObjectOptJSONObject = jSONObjectObtainThridInfo.optJSONObject(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR);
            if (jSONObjectOptJSONObject != null) {
                return jSONObjectOptJSONObject;
            }
            return null;
        }
        org.json.JSONObject jSONObjectObtainThridInfo2 = iApp.obtainThridInfo(io.dcloud.common.DHInterface.IApp.ConfigProperty.ThridInfo.SitemapJsonData);
        if (jSONObjectObtainThridInfo2 == null || !jSONObjectObtainThridInfo2.has(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR)) {
            return null;
        }
        return jSONObjectObtainThridInfo2.optJSONObject(io.dcloud.common.constant.AbsoluteConst.JSONKEY_STATUSBAR);
    }

    public int getStatusBarDefaultColor() {
        return this.mStatusBarDefaultColor;
    }

    public int getStatusbarColorIndex() {
        try {
            return java.lang.Integer.parseInt(io.dcloud.common.adapter.util.PlatformUtil.invokeFieldValue(null, "Window_statusBarColor", io.dcloud.common.adapter.util.PlatformUtil.newInstance(io.dcloud.common.util.Base64.decode2String("Y29tLmFuZHJvaWQuaW50ZXJuYWwuUiRzdHlsZWFibGU="), null, null)).toString());
        } catch (java.lang.Exception unused) {
            return -1;
        }
    }

    public boolean isFullScreenOrImmersive() {
        return this.isImmersive || this.isFullScreen;
    }

    public void setFullScreen(android.app.Activity activity, boolean z) {
        android.view.Window window = activity.getWindow();
        this.isFullScreen = z;
        if (z) {
            android.view.WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.flags |= 1024;
            if (android.os.Build.VERSION.SDK_INT >= 28) {
                attributes.layoutInDisplayCutoutMode = 1;
            }
            window.setAttributes(attributes);
        } else {
            android.view.WindowManager.LayoutParams attributes2 = window.getAttributes();
            attributes2.flags &= -1025;
            if (android.os.Build.VERSION.SDK_INT >= 28) {
                attributes2.layoutInDisplayCutoutMode = 0;
            }
            window.setAttributes(attributes2);
        }
        diyContentFullScreenBug(activity);
    }

    public void setImmersive(final android.app.Activity activity, boolean z) {
        if (activity != null) {
            if (io.dcloud.common.adapter.util.DeviceInfo.sBrand.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.SONY) || io.dcloud.common.adapter.util.DeviceInfo.sBrand.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.QiKU)) {
                this.isImmersive = z;
                setTranslucentStatus(activity, z);
                diyContentFullScreenBug(activity);
                return;
            }
            this.isImmersive = z;
            android.view.Window window = activity.getWindow();
            int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
            window.clearFlags(1024);
            if (z) {
                window.clearFlags(androidx.core.view.accessibility.AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
                window.addFlags(Integer.MIN_VALUE);
                window.getDecorView().setSystemUiVisibility(systemUiVisibility | 1280);
                window.setStatusBarColor(0);
            } else {
                window.getDecorView().setSystemUiVisibility(systemUiVisibility & (-1281));
                window.setStatusBarColor(this.mStatusBarDefaultColor);
            }
            window.getDecorView().post(new java.lang.Runnable() { // from class: io.dcloud.common.util.AppStatusBarManager.1
                @Override // java.lang.Runnable
                public void run() {
                    android.view.View rootView = io.dcloud.common.util.AppStatusBarManager.this.getRootView(activity);
                    if (rootView.getParent() instanceof android.widget.LinearLayout) {
                        rootView.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -1));
                    } else if (rootView.getParent() instanceof android.widget.FrameLayout) {
                        rootView.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
                    }
                }
            });
            diyContentFullScreenBug(activity);
        }
    }

    public void setStatusBarColor(android.app.Activity activity, int i) {
        if (!io.dcloud.common.util.PdrUtil.checkStatusbarColor(i) || activity == null || this.isImmersive) {
            return;
        }
        android.view.Window window = activity.getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(i);
    }

    public void setStatusBarMode(android.app.Activity activity, java.lang.String str) {
        int i;
        int i2 = android.os.Build.VERSION.SDK_INT;
        if (activity != null) {
            if (io.dcloud.common.util.PdrUtil.isEmpty(str)) {
                str = "nono";
            }
            boolean zEqualsIgnoreCase = str.equalsIgnoreCase(io.dcloud.common.ui.blur.DCBlurDraweeView.DARK);
            android.view.Window window = activity.getWindow();
            java.lang.String str2 = android.os.Build.BRAND;
            if (str2.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.GOOGLE)) {
                str2 = android.os.Build.MANUFACTURER;
            }
            if (str2.equals(io.dcloud.common.adapter.util.MobilePhoneModel.XIAOMI)) {
                setMiuiStatusBarDarkMode(activity, zEqualsIgnoreCase);
            } else if (str2.equals(io.dcloud.common.adapter.util.MobilePhoneModel.MEIZU)) {
                setMeizuStatusBarDarkIcon(activity, zEqualsIgnoreCase);
            }
            if (i2 >= 23) {
                int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
                try {
                    java.lang.Class<?> cls = java.lang.Class.forName("android.view.View");
                    i = cls.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR").getInt(cls);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                    i = 8192;
                }
                window.getDecorView().setSystemUiVisibility(zEqualsIgnoreCase ? systemUiVisibility | i : systemUiVisibility & (~i));
            }
        }
    }

    private void initStatusBarDefaultColor(android.app.Activity activity) {
        if (activity != null) {
            android.view.Window window = activity.getWindow();
            int statusbarColorIndex = getStatusbarColorIndex();
            if (statusbarColorIndex > 0) {
                this.mStatusBarDefaultColor = window.getWindowStyle().getColor(statusbarColorIndex, 0);
            }
            if (this.mStatusBarDefaultColor == 0) {
                this.mStatusBarDefaultColor = android.graphics.Color.parseColor("#D4D4D4");
            }
        }
    }
}
