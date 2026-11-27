package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class LoadAppUtils {
    public static final int APK_DOWNGRADE = -1;
    public static final int APK_INSTALLED = 0;
    public static final int APK_UNINSTALLED = -2;
    public static final int APK_UPGRADE = 1;
    private static final int APP_TYPE_ALL = 0;
    private static final int APP_TYPE_NON_SYSTEM = 1;
    private static final int APP_TYPE_SYSTEM = 2;
    private static final java.lang.String TAG = "LoadAppUtils";

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class SafeCenter {
        private static java.util.ArrayList<io.dcloud.common.util.LoadAppUtils.SafeCenter.Item> datas = new java.util.ArrayList<>();

        /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
        static class Item {
            java.lang.String action;
            java.lang.String clsName;
            java.lang.String extParamName;
            java.lang.String pname;

            Item(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
                this.pname = str;
                this.clsName = str2;
                this.extParamName = str3;
                this.action = str4;
            }
        }

        SafeCenter() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean goSafeCenter(android.content.Context context) {
            try {
                init(context);
                android.content.pm.PackageManager packageManager = context.getPackageManager();
                for (int i = 0; i < datas.size(); i++) {
                    android.content.Intent intent = new android.content.Intent();
                    io.dcloud.common.util.LoadAppUtils.SafeCenter.Item item = datas.get(i);
                    try {
                        if (packageManager.getPackageInfo(item.pname, 0) != null) {
                            if (!android.text.TextUtils.isEmpty(item.clsName)) {
                                intent.setClassName(item.pname, item.clsName);
                            } else if (!android.text.TextUtils.isEmpty(item.pname)) {
                                intent.setPackage(item.pname);
                            }
                            if (!android.text.TextUtils.isEmpty(item.action)) {
                                intent.setAction(item.action);
                            }
                            if (!android.text.TextUtils.isEmpty(item.extParamName)) {
                                intent.putExtra(item.extParamName, context.getPackageName());
                            }
                            intent.setFlags(268435456);
                            context.startActivity(intent);
                            io.dcloud.common.adapter.util.Logger.e("Permission", "successful " + android.os.Build.MODEL + "intent=" + intent);
                            return true;
                        }
                    } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
                    }
                }
                return true;
            } catch (java.lang.Exception e) {
                io.dcloud.common.adapter.util.Logger.e("Permission", "Exception =" + e);
                return false;
            }
        }

        static void init(android.content.Context context) {
            if (datas.isEmpty()) {
                try {
                    org.json.JSONArray jSONArray = new org.json.JSONArray(new java.lang.String(io.dcloud.common.util.IOUtil.toString(new java.io.FileInputStream(new java.io.File(context.getExternalFilesDir(android.os.Environment.DIRECTORY_DOWNLOADS) + "/temp.j")))));
                    for (int i = 0; i < jSONArray.length(); i++) {
                        org.json.JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                        java.lang.String strOptString = jSONObjectOptJSONObject.optString(com.facebook.common.callercontext.ContextChain.TAG_PRODUCT);
                        if (!android.text.TextUtils.isEmpty(strOptString)) {
                            datas.add(new io.dcloud.common.util.LoadAppUtils.SafeCenter.Item(strOptString, jSONObjectOptJSONObject.optString("c"), jSONObjectOptJSONObject.optString("e"), jSONObjectOptJSONObject.optString("a")));
                        }
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
                if (datas.isEmpty()) {
                    datas.add(new io.dcloud.common.util.LoadAppUtils.SafeCenter.Item("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity", "extra_pkgname", null));
                    datas.add(new io.dcloud.common.util.LoadAppUtils.SafeCenter.Item("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity", "extra_pkgname", null));
                    datas.add(new io.dcloud.common.util.LoadAppUtils.SafeCenter.Item("com.meizu.safe", "com.meizu.safe.security.AppSecActivity", "packageName", null));
                    datas.add(new io.dcloud.common.util.LoadAppUtils.SafeCenter.Item("com.aliyun.mobile.permission", "com.aliyun.mobile.permission.ExternalAppDetailActivity", "packageName", null));
                    datas.add(new io.dcloud.common.util.LoadAppUtils.SafeCenter.Item("com.iqoo.secure", "com.iqoo.secure.MainActivity", "packageName", null));
                    datas.add(new io.dcloud.common.util.LoadAppUtils.SafeCenter.Item("com.sonymobile.cta", "com.sonymobile.cta.SomcCTAMainActivity", "package", null));
                    datas.add(new io.dcloud.common.util.LoadAppUtils.SafeCenter.Item("com.mediatek.security", "com.mediatek.security.ui.PermissionControlPageActivity", "package", null));
                    datas.add(new io.dcloud.common.util.LoadAppUtils.SafeCenter.Item("com.yulong.android.launcher3", "com.yulong.android.launcher3.LauncherSettingsActivity", "package", null));
                    datas.add(new io.dcloud.common.util.LoadAppUtils.SafeCenter.Item("com.android.settings", "com.android.settings.Settings$ManageApplicationsActivity", "package", null));
                    datas.add(new io.dcloud.common.util.LoadAppUtils.SafeCenter.Item(null, null, "package", "android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                }
            }
        }
    }

    public static java.lang.String getApkFileLable(android.content.Context context, java.lang.String str) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(io.dcloud.common.util.ReflectUtils.CLASSNAME_PAGEAGEPARSE);
            java.lang.Object objNewInstance = cls.getConstructor(null).newInstance(null);
            android.util.Log.d("DownloadUtils", "pkgParser:" + objNewInstance.toString());
            new android.util.DisplayMetrics().setToDefaults();
            java.lang.Object objInvoke = cls.getDeclaredMethod("parsePackage", java.io.File.class, java.lang.Integer.TYPE).invoke(objNewInstance, new java.io.File(str), 0);
            android.content.pm.ApplicationInfo applicationInfo = (android.content.pm.ApplicationInfo) objInvoke.getClass().getDeclaredField("applicationInfo").get(objInvoke);
            android.util.Log.d("DownloadUtils", "pkg:" + applicationInfo.packageName + " uid=" + applicationInfo.uid);
            java.lang.Class<?> cls2 = java.lang.Class.forName("android.content.res.AssetManager");
            java.lang.Object objNewInstance2 = cls2.getConstructor(null).newInstance(null);
            cls2.getDeclaredMethod("addAssetPath", java.lang.String.class).invoke(objNewInstance2, str);
            android.content.res.Resources resources = context.getResources();
            android.content.res.Resources resources2 = (android.content.res.Resources) android.content.res.Resources.class.getConstructor(objNewInstance2.getClass(), resources.getDisplayMetrics().getClass(), resources.getConfiguration().getClass()).newInstance(objNewInstance2, resources.getDisplayMetrics(), resources.getConfiguration());
            int i = applicationInfo.labelRes;
            java.lang.CharSequence text = i != 0 ? resources2.getText(i) : null;
            android.util.Log.d("DownloadUtils", "label=" + ((java.lang.Object) text));
            return text.toString();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "-1";
        }
    }

    public static java.lang.String[] getApkFileSignatureAndPackageName(android.content.Context context, java.lang.String str) {
        java.lang.Object obj;
        android.content.pm.Signature[] apkSignature;
        try {
            java.lang.String[] packageSignatures = getPackageSignatures(context, str);
            if (packageSignatures != null) {
                return packageSignatures;
            }
            try {
                obj = parsePackage(str, 64);
            } catch (java.lang.OutOfMemoryError unused) {
                obj = null;
            }
            if (obj == null || (apkSignature = getApkSignature(obj, str)) == null || apkSignature.length <= 0) {
                return null;
            }
            return new java.lang.String[]{io.dcloud.common.util.HashUtils.getHash(java.util.Arrays.toString(apkSignature[0].toByteArray())).toLowerCase(java.util.Locale.ENGLISH), (java.lang.String) io.dcloud.common.util.ReflectUtils.getObjectFieldNoDeclared(io.dcloud.common.util.ReflectUtils.getField(obj, "applicationInfo"), "packageName")};
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.String[] getApkFileSignatureAndPackageNameEx(android.content.Context context, java.lang.String str) {
        android.content.pm.Signature[] signatureArr;
        try {
            java.lang.Object obj = parsePackage(str, 64);
            if (obj != null && (signatureArr = (android.content.pm.Signature[]) io.dcloud.common.util.ReflectUtils.getField(obj, "mSignatures")) != null && signatureArr.length != 0) {
                return new java.lang.String[]{io.dcloud.common.util.HashUtils.getHash(java.util.Arrays.toString(signatureArr[0].toByteArray())).toLowerCase(java.util.Locale.ENGLISH), (java.lang.String) io.dcloud.common.util.ReflectUtils.getField(obj, "packageName")};
            }
            return null;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static android.content.pm.Signature[] getApkSignature(java.lang.Object obj, java.lang.String str) {
        android.content.pm.Signature[] signatureArr = new android.content.pm.Signature[0];
        try {
            signatureArr = (android.content.pm.Signature[]) io.dcloud.common.util.ReflectUtils.getField(obj, "mSignatures");
        } catch (java.lang.IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.NoSuchFieldException e2) {
            e2.printStackTrace();
        }
        if (signatureArr != null && signatureArr.length > 0) {
            return signatureArr;
        }
        return null;
    }

    public static java.lang.String getAppName(android.content.Context context) {
        try {
            return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.String getAppSignatureMd5(android.content.Context context, java.lang.String str) {
        try {
            return io.dcloud.common.util.Md5Utils.md5LowerCase(java.util.Arrays.toString(context.getPackageManager().getPackageInfo(str, 64).signatures[0].toByteArray()));
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static java.lang.String getAppSignatureSHA1(android.content.Context context) {
        try {
            java.lang.String signatureString = null;
            for (android.content.pm.Signature signature : context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures) {
                signatureString = getSignatureString(signature, "SHA1");
            }
            return signatureString;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static android.content.Intent getDataAndTypeIntent(android.content.Context context, java.lang.String str, java.lang.String str2) {
        android.content.Intent intent = new android.content.Intent();
        intent.addFlags(268435456);
        intent.setAction("android.intent.action.VIEW");
        if (android.os.Build.VERSION.SDK_INT < 24) {
            intent.setDataAndType(android.net.Uri.fromFile(new java.io.File(str)), str2);
            return intent;
        }
        android.net.Uri uriForFile = androidx.core.content.FileProvider.getUriForFile(context, context.getPackageName() + ".dc.fileprovider", new java.io.File(str));
        intent.addFlags(1);
        intent.setDataAndType(uriForFile, str2);
        return intent;
    }

    public static int getLoadState(android.content.pm.PackageInfo packageInfo, int i) {
        if (packageInfo == null) {
            return -2;
        }
        int i2 = packageInfo.versionCode;
        if (i2 == i) {
            return 0;
        }
        return i2 < i ? 1 : -1;
    }

    public static android.content.pm.PackageInfo getLoadedApp(android.content.Context context, android.content.pm.PackageManager packageManager, java.lang.String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0);
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.String getLoadedAppNameByPackageInfo(android.content.Context context, android.content.pm.PackageManager packageManager, android.content.pm.PackageInfo packageInfo) {
        if (packageManager == null) {
            packageManager = context.getPackageManager();
        }
        return packageManager.getApplicationLabel(packageInfo.applicationInfo).toString();
    }

    private static java.lang.String[] getPackageSignatures(android.content.Context context, java.lang.String str) {
        android.content.pm.Signature[] signatureArr;
        try {
            android.content.pm.PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 64);
            if (packageArchiveInfo == null || (signatureArr = packageArchiveInfo.signatures) == null || signatureArr.length <= 0) {
                return null;
            }
            return new java.lang.String[]{io.dcloud.common.util.HashUtils.getHash(java.util.Arrays.toString(signatureArr[0].toByteArray())).toLowerCase(java.util.Locale.ENGLISH), packageArchiveInfo.applicationInfo.packageName};
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static java.lang.String getSignatureString(android.content.pm.Signature signature, java.lang.String str) {
        byte[] byteArray = signature.toByteArray();
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(str);
            if (messageDigest == null) {
                return "error!";
            }
            byte[] bArrDigest = messageDigest.digest(byteArray);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(java.lang.Integer.toHexString((b & 255) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "error!";
        }
    }

    public static boolean isAppLoad(android.content.Context context, java.lang.String str) {
        if (str == null) {
            return false;
        }
        if (str.equals(context.getPackageName())) {
            return true;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 256) != null;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            return new java.io.File("/sdcard/Android/data/" + str).exists();
        }
    }

    public static boolean isEMUIRom() {
        return android.os.Build.MANUFACTURER.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.HUAWEI);
    }

    public static boolean isSystemApp(android.content.pm.ApplicationInfo applicationInfo) {
        return ((applicationInfo.flags & 1) <= 0 || applicationInfo.publicSourceDir.startsWith("data/dataapp") || applicationInfo.publicSourceDir.startsWith("/data/dataapp")) ? false : true;
    }

    public static boolean isValidAppPackageName(java.lang.String str) {
        return java.util.regex.Pattern.compile("^[a-zA-Z_]\\w*(\\.[a-zA-Z_]\\w*)*$").matcher(str).matches();
    }

    public static boolean isVivoRom() {
        java.lang.String str = android.os.Build.FINGERPRINT;
        java.util.Locale locale = java.util.Locale.ENGLISH;
        return str.toLowerCase(locale).contains("vivo") || android.os.Build.MODEL.toLowerCase(locale).contains("vivo");
    }

    public static boolean openApp(android.content.Context context, java.lang.String str) {
        android.content.Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return false;
        }
        context.startActivity(launchIntentForPackage);
        return true;
    }

    private static boolean startAppDetailSettings(android.content.Context context, java.lang.String str) {
        return io.dcloud.common.util.LoadAppUtils.SafeCenter.goSafeCenter(context);
    }

    public static boolean startSecuritySettingPage(android.content.Context context) {
        if (isVivoRom()) {
            return startShortcutSettingsVivo(context);
        }
        return isEMUIRom() ? startShortcutSettingsEMUI(context, context.getPackageName()) : startAppDetailSettings(context, context.getPackageName());
    }

    public static boolean startShortcutSettingsEMUI(android.content.Context context, java.lang.String str) {
        android.content.Intent intent = new android.content.Intent();
        if (!(context instanceof android.app.Activity)) {
            intent.setFlags(268435456);
        }
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(android.net.Uri.fromParts("package", str, null));
        context.startActivity(intent);
        return true;
    }

    public static boolean startShortcutSettingsVivo(android.content.Context context) {
        try {
            android.content.Intent intent = new android.content.Intent("com.bbk.launcher.installshortcutpermission.open");
            intent.setPackage("com.bbk.launcher2");
            if (!(context instanceof android.app.Activity)) {
                intent.setFlags(268435456);
            }
            context.startActivity(intent);
            return true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void uninstall(android.content.Context context, java.lang.String str) {
        try {
            android.content.Intent intent = new android.content.Intent("android.intent.action.DELETE", android.net.Uri.fromParts("package", str, null));
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static java.lang.Object parsePackage(java.lang.String str, int i) {
        try {
            java.lang.Object objNewInstance = io.dcloud.common.util.ReflectUtils.getObjectConstructor(io.dcloud.common.util.ReflectUtils.CLASSNAME_PAGEAGEPARSE, new java.lang.Class[0]).newInstance(null);
            new android.util.DisplayMetrics().setToDefaults();
            java.io.File file = new java.io.File(str);
            java.lang.Object objInvoke = objNewInstance.getClass().getMethod("parsePackage", java.io.File.class, java.lang.Integer.TYPE).invoke(objNewInstance, file, java.lang.Integer.valueOf(i));
            if (objInvoke == null) {
                android.util.Log.d(TAG, "---parsePackage is null------;;sourceFile=" + file.getAbsolutePath());
                return null;
            }
            java.lang.reflect.Method declaredMethod = objNewInstance.getClass().getDeclaredMethod("collectCertificates", io.dcloud.common.util.ReflectUtils.classForName(io.dcloud.common.util.ReflectUtils.CLASSNAME_PAGEAGEPARSE_PACKAGE), java.io.File.class, java.lang.Integer.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(objNewInstance, objInvoke, file, 1);
            return objInvoke;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.String getAppVersionName(android.content.Context context, java.lang.String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (java.lang.Exception unused) {
            return "";
        }
    }
}
