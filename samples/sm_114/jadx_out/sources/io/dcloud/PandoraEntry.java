package io.dcloud;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class PandoraEntry extends android.app.Activity {

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a implements java.lang.Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            io.dcloud.PandoraEntry.this.finish();
        }
    }

    private void a(android.content.Intent intent) {
        java.io.InputStream inputStream;
        try {
            boolean zIsUniMPSDK = io.dcloud.feature.internal.sdk.SDK.isUniMPSDK();
            java.lang.String str = io.dcloud.common.util.BaseInfo.sDefaultBootApp + "/www/manifest.json";
            if (zIsUniMPSDK) {
                java.io.File file = new java.io.File(io.dcloud.common.util.BaseInfo.sCacheFsAppsPath + str);
                inputStream = file.exists() ? io.dcloud.common.adapter.io.DHFile.getInputStream(file) : getResources().getAssets().open(str);
            } else {
                java.io.File file2 = new java.io.File(getExternalFilesDir(android.os.Environment.DIRECTORY_PICTURES).getAbsolutePath().replace("files/Pictures", "apps/") + str);
                inputStream = file2.exists() ? io.dcloud.common.adapter.io.DHFile.getInputStream(file2) : null;
            }
            if (inputStream == null) {
                return;
            }
            java.lang.String string = io.dcloud.common.util.IOUtil.toString(inputStream);
            if (android.text.TextUtils.isEmpty(string)) {
                return;
            }
            intent.putExtra(io.dcloud.common.constant.IntentConst.INTENT_ORIENTATION, io.dcloud.common.util.PdrUtil.getConfigOrientation(new org.json.JSONObject(string)));
        } catch (java.lang.Exception unused) {
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT < 26) {
            super.attachBaseContext(context);
        } else {
            super.attachBaseContext(io.dcloud.common.util.language.LanguageUtil.updateContextLanguageAfterO(context, false));
        }
    }

    @Override // android.app.Activity
    protected void onCreate(android.os.Bundle bundle) {
        if (android.os.Build.VERSION.SDK_INT == 26 && a()) {
            a(this);
        }
        super.onCreate(bundle);
        android.content.Intent intent = getIntent();
        io.dcloud.common.util.ReflectUtils.invokeMethod("io.dcloud.feature.aps.NotificationReceiver", "sOnReceiver", null, new java.lang.Class[]{android.content.Context.class, android.content.Intent.class}, new java.lang.Object[]{this, intent});
        io.dcloud.common.adapter.util.AndroidResources.initAndroidResources(getApplication());
        io.dcloud.common.util.BaseInfo.parseControl();
        if (io.dcloud.feature.internal.sdk.SDK.isUniMPSDK() && intent.hasExtra("appid")) {
            io.dcloud.common.util.BaseInfo.sDefaultBootApp = intent.getStringExtra("appid");
        }
        if (io.dcloud.feature.internal.sdk.SDK.isUniMPSDK() || io.dcloud.common.util.BaseInfo.SyncDebug) {
            a(intent);
        }
        if (intent.hasExtra(io.dcloud.common.constant.IntentConst.START_FROM_TO_CLASS) && io.dcloud.feature.internal.sdk.SDK.isUniMPSDK()) {
            java.lang.String stringExtra = intent.getStringExtra(io.dcloud.common.constant.IntentConst.START_FROM_TO_CLASS);
            if (!android.text.TextUtils.isEmpty(stringExtra) && stringExtra.startsWith("io.dcloud.feature.sdk.multi")) {
                intent.setClassName(getPackageName(), stringExtra);
                intent.removeExtra(io.dcloud.common.constant.IntentConst.START_FROM_TO_CLASS);
            }
        } else {
            intent.putExtra(io.dcloud.common.constant.IntentConst.WEBAPP_SHORT_CUT_CLASS_NAME, io.dcloud.PandoraEntry.class.getName());
            intent.setClass(this, io.dcloud.PandoraEntryActivity.class);
        }
        startActivity(intent);
        overridePendingTransition(0, 0);
        if (io.dcloud.feature.internal.sdk.SDK.isUniMPSDK()) {
            finish();
        } else {
            new android.os.Handler().postDelayed(new io.dcloud.PandoraEntry.a(), 20L);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        overridePendingTransition(0, 0);
        super.onPause();
    }

    private static void a(android.app.Activity activity) {
        try {
            java.lang.reflect.Field declaredField = android.app.Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ((android.content.pm.ActivityInfo) declaredField.get(activity)).screenOrientation = -1;
        } catch (java.lang.Exception unused) {
        }
    }

    private boolean a() {
        try {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = obtainStyledAttributes((int[]) java.lang.Class.forName("com.android.internal.R$styleable").getField(io.dcloud.common.constant.AbsoluteConst.FEATURE_WINDOW).get(null));
            java.lang.reflect.Method method = android.content.pm.ActivityInfo.class.getMethod("isTranslucentOrFloating", android.content.res.TypedArray.class);
            method.setAccessible(true);
            boolean zBooleanValue = ((java.lang.Boolean) method.invoke(null, typedArrayObtainStyledAttributes)).booleanValue();
            try {
                method.setAccessible(false);
                return zBooleanValue;
            } catch (java.lang.Exception unused) {
                return zBooleanValue;
            }
        } catch (java.lang.Exception unused2) {
            return false;
        }
    }
}
