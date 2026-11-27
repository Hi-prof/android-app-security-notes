package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class r {
    public static java.lang.String a = "appid";

    /* JADX WARN: Code duplicated, block: B:8:0x0042  */
    public static void a(android.app.Activity activity, io.dcloud.common.DHInterface.IApp iApp) {
        java.lang.String str;
        java.lang.String string;
        java.lang.String metaValue = io.dcloud.common.adapter.util.AndroidResources.getMetaValue("DCLOUD_STREAMAPP_CHANNEL");
        if (android.text.TextUtils.isEmpty(metaValue) || metaValue == null) {
            str = null;
        } else {
            java.lang.String[] strArrSplit = metaValue.split("\\|");
            if (strArrSplit.length > 2) {
                str = strArrSplit[2] + "|" + iApp.getConfusionMgr().decodeString(iApp.getConfusionMgr().getODS(), true, 50);
            } else {
                str = null;
            }
        }
        try {
            string = io.dcloud.common.util.ReflectUtils.getStaticObjectField(activity.getPackageName() + iApp.getConfusionMgr().decryptStr("&J}adlKgfnao"), iApp.getConfusionMgr().decryptStr("GIC")).toString();
        } catch (java.lang.Exception unused) {
            string = "";
        }
        if (io.dcloud.common.util.BaseInfo.SyncDebug || io.dcloud.feature.internal.sdk.SDK.isUniMP || android.text.TextUtils.isEmpty(string) || a(activity, iApp.obtainAppId(), io.dcloud.common.util.LoadAppUtils.getAppSignatureSHA1(activity), string, str)) {
            return;
        }
        iApp.setStatus((byte) 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(android.content.DialogInterface dialogInterface, int i, android.view.KeyEvent keyEvent) {
        return i == 4;
    }

    private static boolean a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        java.lang.String packageName = context.getPackageName();
        java.util.Locale locale = java.util.Locale.ENGLISH;
        java.lang.String lowerCase = packageName.toLowerCase(locale);
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("|");
            int iCharAt = str3.charAt(0) - '0';
            if ((iCharAt & 1) != 1) {
                str = "";
            }
            sb.append(str);
            sb.append("|");
            if ((iCharAt & 2) != 2) {
                lowerCase = "";
            }
            sb.append(lowerCase);
            sb.append("|");
            if ((iCharAt & 4) != 4) {
                str2 = "";
            }
            sb.append(str2);
            sb.append("|");
            sb.append(str4);
            boolean zEquals = str3.equals((iCharAt + io.dcloud.common.util.Md5Utils.md5(sb.toString())).toLowerCase(locale));
            if (!zEquals) {
                a(iCharAt, context);
            }
            return zEquals;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    private static void a(int i, android.content.Context context) {
        boolean z = (i & 1) == 1;
        boolean z2 = (i & 2) == 2;
        boolean z3 = (i & 4) == 4;
        java.lang.String string = "";
        if (!z && !z2 && !z3) {
            android.os.Process.killProcess(android.os.Process.myPid());
        } else if (z && z2 && z3) {
            string = context.getString(io.dcloud.base.R.string.dcloud_onlone_fail_tips_all);
        } else {
            java.lang.String string2 = context.getString(io.dcloud.base.R.string.dcloud_onlone_fail_tips);
            java.lang.String string3 = context.getString(io.dcloud.base.R.string.dcloud_tips_package_name);
            java.lang.String string4 = context.getString(io.dcloud.base.R.string.dcloud_tips_certificate);
            if (z) {
                string = "" + a + "、";
            }
            if (z2) {
                string = string + string3 + "、";
            }
            if (z3) {
                string = string + string4 + "、";
            }
            string = java.lang.String.format(string2, string.substring(0, string.length() - 1));
        }
        a(context, string);
    }

    public static void a(android.content.Context context, java.lang.String str) {
        try {
            com.dcloud.android.widget.dialog.DCloudAlertDialog dCloudAlertDialog = new com.dcloud.android.widget.dialog.DCloudAlertDialog(context, io.dcloud.common.util.AppRuntime.getAppDarkMode(context) ? com.dcloud.android.widget.dialog.DCloudAlertDialog.DARK_THEME : com.dcloud.android.widget.dialog.DCloudAlertDialog.LIGHT_THEME, true);
            dCloudAlertDialog.setTitle(str);
            dCloudAlertDialog.setButton(-2, context.getString(android.R.string.ok), new android.content.DialogInterface.OnClickListener() { // from class: io.dcloud.p.r$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(android.content.DialogInterface dialogInterface, int i) {
                    io.dcloud.p.r.a(dialogInterface, i);
                }
            });
            dCloudAlertDialog.setOnKeyListener(new android.content.DialogInterface.OnKeyListener() { // from class: io.dcloud.p.r$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(android.content.DialogInterface dialogInterface, int i, android.view.KeyEvent keyEvent) {
                    return io.dcloud.p.r.a(dialogInterface, i, keyEvent);
                }
            });
            dCloudAlertDialog.setCancelable(false);
            dCloudAlertDialog.setCanceledOnTouchOutside(false);
            dCloudAlertDialog.show();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(android.content.DialogInterface dialogInterface, int i) {
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
