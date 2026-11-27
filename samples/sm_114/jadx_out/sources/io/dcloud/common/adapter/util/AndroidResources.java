package io.dcloud.common.adapter.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public abstract class AndroidResources {
    public static java.lang.String appName = null;
    public static android.content.pm.PackageInfo mApplicationInfo = null;
    public static android.content.res.Resources mResources = null;
    public static java.lang.String packageName = null;
    public static int sAppTargetSdkVersion = 0;
    static android.content.res.AssetManager sAssetMgr = null;
    public static boolean sIMEAlive = false;
    static android.os.Bundle sMetaDatas = null;
    public static boolean splashBacking = false;
    public static int versionCode;
    public static java.lang.String versionName;

    public static void clearData() {
        io.dcloud.common.adapter.util.CanvasHelper.clearData();
        io.dcloud.common.adapter.ui.AdaWebview.clearData();
        mResources = null;
        sAssetMgr = null;
        mApplicationInfo = null;
    }

    public static int getIdentifier(java.lang.String str, java.lang.String str2) {
        android.content.res.Resources resources = mResources;
        if (resources != null) {
            return resources.getIdentifier(str, str2, packageName);
        }
        return 0;
    }

    public static int getIdentifierFromApk(android.content.Context context, java.lang.String str, java.lang.String str2) {
        try {
            return context.createPackageContext(context.getPackageName(), 2).getResources().getIdentifier(str, str2, context.getPackageName());
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static java.lang.String getMetaValue(java.lang.String str) {
        if (sMetaDatas == null) {
            try {
                sMetaDatas = io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext.getPackageManager().getApplicationInfo(packageName, 128).metaData;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        android.os.Bundle bundle = sMetaDatas;
        if (bundle == null || io.dcloud.common.util.PdrUtil.isEmpty(bundle.get(str))) {
            return null;
        }
        return java.lang.String.valueOf(sMetaDatas.get(str));
    }

    public static java.lang.String getString(int i) {
        android.content.res.Resources resources = mResources;
        return resources != null ? resources.getString(i) : "";
    }

    public static void initAndroidResources(android.content.Context context) {
        if (mResources != null) {
            return;
        }
        mResources = context.getResources();
        io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext = context;
        sAssetMgr = context.getAssets();
        android.content.pm.ApplicationInfo applicationInfo = context.getApplicationInfo();
        try {
            sAppTargetSdkVersion = applicationInfo.targetSdkVersion;
            packageName = applicationInfo.packageName;
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            android.content.pm.PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 1);
            mApplicationInfo = packageInfo;
            versionName = packageInfo.versionName;
            versionCode = packageInfo.versionCode;
            appName = java.lang.String.valueOf(packageManager.getApplicationLabel(applicationInfo));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void setMetaValue(java.lang.String str, java.lang.String str2) {
        if (sMetaDatas == null) {
            try {
                sMetaDatas = io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext.getPackageManager().getApplicationInfo(packageName, 128).metaData;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        android.os.Bundle bundle = sMetaDatas;
        if (bundle != null) {
            bundle.putString(str, str2);
            java.lang.System.out.println("meta data = " + sMetaDatas.get(str));
        }
    }
}
