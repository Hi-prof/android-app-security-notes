package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class AppPermissionUtil {
    public static final int MODE_ALLOWED = 0;
    public static final int MODE_ASK = 4;
    public static final int MODE_DEFAULT = 3;
    public static final int MODE_ERRORED = 2;
    public static final int MODE_IGNORED = 1;
    public static final int MODE_UNKNOWN = -1;
    public static java.util.HashMap<java.lang.String, java.lang.Integer> mXiaoMiCode19OPSIDs = new java.util.HashMap<>();
    public static java.util.HashMap<java.lang.String, java.lang.Integer> mXiaoMiCode21OPSIDs = new java.util.HashMap<>();
    public static java.util.HashMap<java.lang.String, java.lang.Integer> mXiaoMiCode23OPSIDs = new java.util.HashMap<>();
    public static java.lang.String OP_INSTALL_SHORTCUT = "op_install_shortcut";

    static {
        mXiaoMiCode19OPSIDs.put("op_install_shortcut", 60);
        mXiaoMiCode21OPSIDs.put(OP_INSTALL_SHORTCUT, 63);
        mXiaoMiCode23OPSIDs.put(OP_INSTALL_SHORTCUT, 10017);
    }

    public static void againShortcutOpsDialog(final io.dcloud.common.DHInterface.IApp iApp, final android.app.Activity activity, final java.lang.String str, java.lang.String str2) {
        final android.content.SharedPreferences orCreateBundle = io.dcloud.common.adapter.util.SP.getOrCreateBundle(activity, "pdr");
        com.dcloud.android.widget.dialog.DCloudAlertDialog dCloudAlertDialogInitDialogTheme = io.dcloud.common.util.DialogUtil.initDialogTheme(activity, true);
        dCloudAlertDialogInitDialogTheme.setTitle(io.dcloud.base.R.string.dcloud_short_cut_set_pms);
        dCloudAlertDialogInitDialogTheme.setMessage(activity.getString(io.dcloud.base.R.string.dcloud_short_cut_create_error_tips));
        dCloudAlertDialogInitDialogTheme.setButton(-1, activity.getString(io.dcloud.base.R.string.dcloud_short_cut_goto_pms), new android.content.DialogInterface.OnClickListener() { // from class: io.dcloud.common.util.AppPermissionUtil.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i) {
                android.content.Intent intent = new android.content.Intent("android.settings.APPLICATION_DETAILS_SETTINGS", android.net.Uri.parse("package:" + activity.getPackageName()));
                orCreateBundle.edit().putBoolean(str + io.dcloud.common.adapter.util.SP.IS_CREATE_SHORTCUT, true).commit();
                activity.startActivity(intent);
            }
        });
        dCloudAlertDialogInitDialogTheme.setButton(-2, activity.getString(io.dcloud.base.R.string.dcloud_short_cut_not_install), new android.content.DialogInterface.OnClickListener() { // from class: io.dcloud.common.util.AppPermissionUtil.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i) {
                if (android.os.Build.BRAND.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.MEIZU) || android.os.Build.MANUFACTURER.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.HUAWEI)) {
                    io.dcloud.common.util.ShortCutUtil.createShortcutToDeskTop(iApp, false);
                }
            }
        });
        dCloudAlertDialogInitDialogTheme.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() { // from class: io.dcloud.common.util.AppPermissionUtil.6
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(android.content.DialogInterface dialogInterface) {
            }
        });
        dCloudAlertDialogInitDialogTheme.setCanceledOnTouchOutside(false);
        dCloudAlertDialogInitDialogTheme.show();
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00c7  */
    public static int checkNoShortcutPermionGuide(android.content.Context context, java.lang.String str, boolean z, io.dcloud.common.DHInterface.IApp iApp, java.lang.String str2, android.content.SharedPreferences sharedPreferences, boolean z2) {
        java.lang.String str3;
        int i;
        java.lang.String string = context.getString(io.dcloud.base.R.string.dcloud_short_cut_pms_unauthorized_tips1);
        java.lang.String str4 = android.os.Build.BRAND;
        int iCheckOp = -1;
        if (str4.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.MEIZU)) {
            if (isFlymeShortcutallowAllow(context, io.dcloud.common.util.ShortCutUtil.getHeadShortCutIntent(str))) {
                str3 = null;
                i = 0;
            } else {
                i = io.dcloud.PdrR.DCLOUD_GUIDE_GIF_MEIZU;
                string = context.getString(io.dcloud.base.R.string.dcloud_short_cut_pms_unauthorized_tips2);
                str3 = io.dcloud.common.adapter.util.SP.STAREMAPP_SHORTCUT_GUIDE_IS_FIRST_FLYME;
                iCheckOp = 1;
            }
        } else if (str4.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.XIAOMI)) {
            iCheckOp = checkOp(context);
            string = context.getString(io.dcloud.base.R.string.dcloud_short_cut_pms_unauthorized_tips2);
            i = io.dcloud.PdrR.DCLOUD_GUIDE_GIF_XIAOMI;
            str3 = io.dcloud.common.adapter.util.SP.STAREMAPP_SHORTCUT_GUIDE_IS_FIRST_MIUI;
        } else if (!android.os.Build.MANUFACTURER.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.HUAWEI)) {
            if (str4.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.VIVO)) {
                java.lang.String appVersionName = io.dcloud.common.util.LoadAppUtils.getAppVersionName(context, "com.iqoo.secure");
                java.lang.String appName = io.dcloud.common.util.LoadAppUtils.getAppName(context);
                java.lang.String strRequestShortCutPermissionVivo = io.dcloud.common.util.ShortCutUtil.requestShortCutPermissionVivo(context, appName);
                if (!io.dcloud.common.util.PdrUtil.isEmpty(appVersionName)) {
                    if (appVersionName.startsWith("2") || appVersionName.startsWith("1")) {
                        return -1;
                    }
                    if (io.dcloud.common.util.PdrUtil.isEquals("1", strRequestShortCutPermissionVivo) || io.dcloud.common.util.PdrUtil.isEquals("17", strRequestShortCutPermissionVivo)) {
                        if (appVersionName.startsWith("3")) {
                            string = io.dcloud.common.util.StringUtil.format(context.getString(io.dcloud.base.R.string.dcloud_short_cut_pms_unauthorized_tips4), appName);
                            str3 = io.dcloud.common.adapter.util.SP.STAREMAPP_SHORTCUT_GUIDE_IS_FIRST_VIVO;
                            i = 1;
                        } else {
                            if (appVersionName.startsWith("4")) {
                                string = context.getString(io.dcloud.base.R.string.dcloud_short_cut_open_set_pms);
                            }
                            str3 = io.dcloud.common.adapter.util.SP.STAREMAPP_SHORTCUT_GUIDE_IS_FIRST_VIVO;
                            i = 0;
                        }
                        iCheckOp = 1;
                    }
                }
            }
            str3 = null;
            i = 0;
        } else if (isEmuiShortcutallowAllow()) {
            str3 = null;
            i = 0;
        } else {
            string = context.getString(io.dcloud.base.R.string.dcloud_short_cut_pms_unauthorized_tips3);
            i = io.dcloud.PdrR.DCLOUD_GUIDE_GIF_HUAWEI;
            str3 = io.dcloud.common.adapter.util.SP.STAREMAPP_SHORTCUT_GUIDE_IS_FIRST_EMUI;
            iCheckOp = 1;
        }
        if (iCheckOp == 1 && z2) {
            if (io.dcloud.common.util.PdrUtil.isEquals(iApp.forceShortCut(), "tipOnce")) {
                if (sharedPreferences.getBoolean(str2 + str3, true)) {
                    sharedPreferences.edit().putBoolean(str2 + str3, false).commit();
                    if (z) {
                        showShortCutDialog(iApp, iApp.getActivity(), str2, sharedPreferences, i, string);
                        return iCheckOp;
                    }
                    int i2 = i;
                    java.lang.String str5 = string;
                    if (io.dcloud.common.util.LoadAppUtils.startSecuritySettingPage(context)) {
                        com.dcloud.android.widget.toast.ToastCompat.makeText(context, (java.lang.CharSequence) str5, 1).show();
                        io.dcloud.common.ui.PermissionGuideWindow.getInstance(context).showWindow(str5, i2);
                        return iCheckOp;
                    }
                }
            } else {
                int i3 = i;
                java.lang.String str6 = string;
                if (z) {
                    showShortCutDialog(iApp, iApp.getActivity(), str2, sharedPreferences, i3, str6);
                    return iCheckOp;
                }
                if (io.dcloud.common.util.LoadAppUtils.startSecuritySettingPage(context)) {
                    com.dcloud.android.widget.toast.ToastCompat.makeText(context, (java.lang.CharSequence) str6, 1).show();
                    io.dcloud.common.ui.PermissionGuideWindow.getInstance(context).showWindow(str6, i3);
                }
            }
        }
        return iCheckOp;
    }

    public static int checkPermission(android.content.Context context, java.lang.String str) {
        java.lang.String str2 = android.os.Build.BRAND;
        if (str2.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.MEIZU)) {
            return !isFlymeShortcutallowAllow(context, io.dcloud.common.util.ShortCutUtil.getHeadShortCutIntent(str)) ? 1 : 3;
        }
        if (str2.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.XIAOMI)) {
            int iCheckOp = checkOp(context);
            if (iCheckOp == 0 || iCheckOp == 1) {
                return iCheckOp;
            }
            if (iCheckOp == 3 || iCheckOp == 4) {
                return 2;
            }
        } else if (android.os.Build.MANUFACTURER.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.HUAWEI)) {
            return !isEmuiShortcutallowAllow() ? 1 : 3;
        }
        return 4;
    }

    public static boolean checkShortcutOps(io.dcloud.common.DHInterface.IApp iApp, android.app.Activity activity, java.lang.String str, java.lang.String str2) {
        android.content.SharedPreferences orCreateBundle = io.dcloud.common.adapter.util.SP.getOrCreateBundle(activity, "pdr");
        if (getCheckShortcutOps(activity) != 1) {
            return true;
        }
        showShortCutOpsDialog(iApp, activity, str, orCreateBundle);
        return false;
    }

    public static int getCheckShortcutOps(android.app.Activity activity) {
        if (-1 != getShotCutOpId()) {
            return checkOp(activity);
        }
        return 0;
    }

    private static int getFlymePermissionGranted(android.content.Context context, int i, android.content.Intent intent) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("meizu.security.IFlymePermissionService$Stub");
            java.lang.Class<?> cls2 = java.lang.Class.forName("android.os.ServiceManager");
            java.lang.Object objInvoke = cls.getDeclaredMethod("asInterface", android.os.IBinder.class).invoke(cls, (android.os.IBinder) cls2.getDeclaredMethod("getService", java.lang.String.class).invoke(cls2, "flyme_permission"));
            java.lang.Class<?> cls3 = objInvoke.getClass();
            java.lang.Class<?> cls4 = java.lang.Integer.TYPE;
            java.lang.reflect.Method method = cls3.getMethod("noteIntentOperation", cls4, cls4, java.lang.String.class, android.content.Intent.class);
            int callingPid = android.os.Binder.getCallingPid();
            return ((java.lang.Integer) method.invoke(objInvoke, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(callingPid), context.getPackageName(), intent)).intValue();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private static int getFlymeShortcutPid() {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("meizu.security.FlymePermissionManager");
            java.lang.reflect.Field declaredField = cls.getDeclaredField("OP_SEND_SHORTCUT_BROADCAST");
            declaredField.setAccessible(true);
            return ((java.lang.Integer) declaredField.get(cls)).intValue();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int getShotCutOpId() {
        int i;
        if (!android.os.Build.BRAND.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.XIAOMI)) {
            return (android.os.Build.MANUFACTURER.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.HUAWEI) && ((i = android.os.Build.VERSION.SDK_INT) == 23 || i == 24)) ? 16777216 : -1;
        }
        switch (android.os.Build.VERSION.SDK_INT) {
            case 21:
            case 22:
                return mXiaoMiCode21OPSIDs.get(OP_INSTALL_SHORTCUT).intValue();
            case 23:
                return mXiaoMiCode23OPSIDs.get(OP_INSTALL_SHORTCUT).intValue();
            default:
                return -1;
        }
    }

    public static boolean isEmuiShortcutallowAllow() {
        try {
            int shotCutOpId = getShotCutOpId();
            if (-1 == shotCutOpId) {
                return true;
            }
            java.lang.Class<?> cls = java.lang.Class.forName("com.huawei.hsm.permission.StubController");
            java.lang.Class<?> cls2 = java.lang.Integer.TYPE;
            if (((java.lang.Integer) cls.getDeclaredMethod("holdForGetPermissionSelection", cls2, cls2, cls2, java.lang.String.class).invoke(cls, java.lang.Integer.valueOf(shotCutOpId), java.lang.Integer.valueOf(android.os.Binder.getCallingUid()), java.lang.Integer.valueOf(android.os.Binder.getCallingPid()), null)).intValue() == 2) {
                return false;
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean isFlymeShortcutallowAllow(android.content.Context context, android.content.Intent intent) {
        int flymeShortcutPid = getFlymeShortcutPid();
        return flymeShortcutPid == -1 || getFlymePermissionGranted(context, flymeShortcutPid, intent) != 1;
    }

    public static void showShortCutDialog(io.dcloud.common.DHInterface.IApp iApp, final android.app.Activity activity, final java.lang.String str, final android.content.SharedPreferences sharedPreferences, final int i, final java.lang.String str2) {
        com.dcloud.android.widget.dialog.DCloudAlertDialog dCloudAlertDialogInitDialogTheme = io.dcloud.common.util.DialogUtil.initDialogTheme(activity, true);
        java.lang.String string = activity.getString(io.dcloud.base.R.string.dcloud_short_cut_create_error);
        dCloudAlertDialogInitDialogTheme.setTitle(activity.getString(io.dcloud.base.R.string.dcloud_short_cut_set_pms));
        dCloudAlertDialogInitDialogTheme.setMessage(string);
        dCloudAlertDialogInitDialogTheme.setButton(-1, activity.getString(io.dcloud.base.R.string.dcloud_short_cut_set_up), new android.content.DialogInterface.OnClickListener() { // from class: io.dcloud.common.util.AppPermissionUtil.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i2) {
                if (io.dcloud.common.util.LoadAppUtils.startSecuritySettingPage(activity)) {
                    sharedPreferences.edit().putBoolean(str + io.dcloud.common.adapter.util.SP.IS_CREATE_SHORTCUT, true).commit();
                    com.dcloud.android.widget.toast.ToastCompat.makeText((android.content.Context) activity, (java.lang.CharSequence) str2, 1).show();
                    io.dcloud.common.ui.PermissionGuideWindow.getInstance(activity).showWindow(str2, i);
                }
            }
        });
        dCloudAlertDialogInitDialogTheme.setButton(-2, activity.getString(io.dcloud.base.R.string.dcloud_short_cut_abandon_install), new android.content.DialogInterface.OnClickListener() { // from class: io.dcloud.common.util.AppPermissionUtil.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        });
        dCloudAlertDialogInitDialogTheme.setCanceledOnTouchOutside(false);
        dCloudAlertDialogInitDialogTheme.show();
        android.view.Window window = dCloudAlertDialogInitDialogTheme.getWindow();
        if (window != null) {
            android.view.WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.x = 0;
            attributes.y = 0;
            window.setGravity(80);
            window.setLayout((int) (((double) activity.getResources().getDisplayMetrics().widthPixels) * 0.9d), attributes.height);
        }
    }

    public static void showShortCutOpsDialog(final io.dcloud.common.DHInterface.IApp iApp, final android.app.Activity activity, final java.lang.String str, final android.content.SharedPreferences sharedPreferences) {
        com.dcloud.android.widget.dialog.DCloudAlertDialog dCloudAlertDialogInitDialogTheme = io.dcloud.common.util.DialogUtil.initDialogTheme(activity, true);
        java.lang.String string = activity.getString(io.dcloud.base.R.string.dcloud_short_cut_create_error_tips2);
        if (android.os.Build.BRAND.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.MEIZU)) {
            string = activity.getString(io.dcloud.base.R.string.dcloud_short_cut_create_error_tips3);
        } else if (android.os.Build.MANUFACTURER.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.HUAWEI)) {
            string = activity.getString(io.dcloud.base.R.string.dcloud_short_cut_create_error_tips4);
        }
        dCloudAlertDialogInitDialogTheme.setTitle(io.dcloud.base.R.string.dcloud_short_cut_set_pms);
        dCloudAlertDialogInitDialogTheme.setMessage(string);
        dCloudAlertDialogInitDialogTheme.setButton(-1, activity.getString(io.dcloud.base.R.string.dcloud_short_cut_goto_pms), new android.content.DialogInterface.OnClickListener() { // from class: io.dcloud.common.util.AppPermissionUtil.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i) {
                android.content.Intent intent = new android.content.Intent("android.settings.APPLICATION_DETAILS_SETTINGS", android.net.Uri.parse("package:" + activity.getPackageName()));
                sharedPreferences.edit().putBoolean(str + io.dcloud.common.adapter.util.SP.IS_CREATE_SHORTCUT, true).commit();
                activity.startActivity(intent);
            }
        });
        dCloudAlertDialogInitDialogTheme.setButton(-2, activity.getString(io.dcloud.base.R.string.dcloud_short_cut_not_install), new android.content.DialogInterface.OnClickListener() { // from class: io.dcloud.common.util.AppPermissionUtil.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i) {
                io.dcloud.common.DHInterface.IApp iApp2 = iApp;
                io.dcloud.common.util.AppPermissionUtil.againShortcutOpsDialog(iApp2, activity, str, iApp2.obtainAppName());
            }
        });
        dCloudAlertDialogInitDialogTheme.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() { // from class: io.dcloud.common.util.AppPermissionUtil.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(android.content.DialogInterface dialogInterface) {
                io.dcloud.common.DHInterface.IApp iApp2 = iApp;
                io.dcloud.common.util.AppPermissionUtil.againShortcutOpsDialog(iApp2, activity, str, iApp2.obtainAppName());
            }
        });
        dCloudAlertDialogInitDialogTheme.setCanceledOnTouchOutside(false);
        dCloudAlertDialogInitDialogTheme.show();
    }

    public static int checkOp(android.content.Context context) {
        java.lang.Object systemService = context.getSystemService("appops");
        java.lang.Class<?> cls = systemService.getClass();
        try {
            java.lang.Integer num = (java.lang.Integer) cls.getDeclaredField("OP_INSTALL_SHORTCUT").get(cls);
            num.intValue();
            java.lang.Class<?> cls2 = java.lang.Integer.TYPE;
            return ((java.lang.Integer) cls.getDeclaredMethod("checkOp", cls2, cls2, java.lang.String.class).invoke(systemService, num, java.lang.Integer.valueOf(android.os.Binder.getCallingUid()), context.getPackageName())).intValue();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
