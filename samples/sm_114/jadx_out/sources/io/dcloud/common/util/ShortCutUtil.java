package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class ShortCutUtil {
    public static final java.lang.String NOPERMISSIONS = "nopermissions";
    private static final java.lang.String SHORTCUT_SRC_STREAM_APPS = "short_cut_src_stream_apps";
    public static final java.lang.String SHORT_CUT_EXISTING = "short_cut_existing";
    public static final java.lang.String SHORT_CUT_NONE = "short_cut_none";
    public static final java.lang.String TAG = "ShortCutUtil";
    public static final java.lang.String UNKNOWN = "unknown";
    public static java.lang.String activityNameSDK = null;
    public static java.util.HashMap<java.lang.String, java.lang.String> extraProSDK = null;
    public static boolean mAutoCreateShortcut = true;
    static io.dcloud.common.util.ShortCutUtil.TypeRunnable mRunnable;
    private boolean isChekShortCut;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    interface TypeRunnable extends java.lang.Runnable {
        java.lang.String getType();

        void setType(java.lang.String str);
    }

    private static void addShortCutSrc(android.content.Context context, android.content.Intent intent, java.lang.String str) {
        intent.putExtra(io.dcloud.common.constant.IntentConst.SHORT_CUT_SRC, str.hashCode() + "_" + context.getPackageName());
    }

    private static void checkShortcutPermission(io.dcloud.common.DHInterface.IApp iApp, java.lang.String str, android.content.SharedPreferences sharedPreferences, java.lang.String str2) {
        if (!io.dcloud.common.util.PdrUtil.isEquals(iApp.forceShortCut(), "tipOnce")) {
            io.dcloud.common.util.AppPermissionUtil.showShortCutOpsDialog(iApp, iApp.getActivity(), str, sharedPreferences);
            return;
        }
        if (sharedPreferences.getBoolean(str + str2, true)) {
            sharedPreferences.edit().putBoolean(str + str2, false).commit();
            io.dcloud.common.util.AppPermissionUtil.showShortCutOpsDialog(iApp, iApp.getActivity(), str, sharedPreferences);
        }
    }

    public static void createShortcut(io.dcloud.common.DHInterface.IApp iApp, java.lang.String str, android.graphics.Bitmap bitmap, boolean z) {
        android.graphics.Bitmap bitmapDecodeResource;
        java.lang.String strSubstring = str;
        io.dcloud.common.adapter.util.Logger.e("StreamSDK", "come in createShortcut");
        io.dcloud.common.adapter.util.Logger.e("IAN", "createShortcut: BaseInfo.mAutoCreateShortcut" + mAutoCreateShortcut);
        io.dcloud.common.adapter.util.Logger.e("IAN", "createShortcut: ShortCutUtil.activityNameSDK" + activityNameSDK);
        if (iApp == null || android.text.TextUtils.isEmpty(strSubstring) || iApp.startFromShortCut() || iApp.forceShortCut().equals("none")) {
            if (iApp != null) {
                io.dcloud.common.adapter.util.Logger.e("IAN", "createShortcut: filePath==" + strSubstring + "app.startFromShortCut()==" + iApp.startFromShortCut() + "app.forceShortCut().equals(none)==" + iApp.forceShortCut().equals("none"));
                return;
            }
            return;
        }
        if (io.dcloud.common.util.PdrUtil.isEquals(iApp.forceShortCut(), "none")) {
            return;
        }
        io.dcloud.common.adapter.util.Logger.e("StreamSDK", "come out return 1");
        android.content.Intent intentObtainWebAppIntent = iApp.obtainWebAppIntent();
        boolean z2 = intentObtainWebAppIntent != null && intentObtainWebAppIntent.getIntExtra(io.dcloud.common.constant.IntentConst.START_FROM, -1) == 5;
        io.dcloud.common.adapter.util.Logger.e("StreamSDK", "isMyRuning" + z2);
        if (z2) {
            return;
        }
        android.app.Activity activity = iApp.getActivity();
        java.lang.String strObtainAppName = iApp.obtainAppName();
        java.lang.String strObtainAppId = iApp.obtainAppId();
        if (bitmap == null) {
            if (!android.text.TextUtils.isEmpty(strSubstring) && strSubstring.startsWith(io.dcloud.common.adapter.util.DeviceInfo.FILE_PROTOCOL)) {
                strSubstring = strSubstring.substring(7);
            }
            bitmapDecodeResource = android.graphics.BitmapFactory.decodeFile(strSubstring);
        } else {
            bitmapDecodeResource = bitmap;
        }
        if (bitmapDecodeResource == null) {
            bitmapDecodeResource = android.graphics.BitmapFactory.decodeResource(activity.getResources(), io.dcloud.PdrR.DRAWABLE_ICON);
        }
        android.graphics.Bitmap bitmap2 = bitmapDecodeResource;
        android.content.Intent intentObtainWebAppIntent2 = iApp.obtainWebAppIntent();
        java.lang.String stringExtra = intentObtainWebAppIntent2 != null ? intentObtainWebAppIntent2.getStringExtra(io.dcloud.common.constant.IntentConst.WEBAPP_SHORT_CUT_CLASS_NAME) : "";
        if (hasShortcut(activity, strObtainAppName)) {
            io.dcloud.common.adapter.util.Logger.e("StreamSDK", "ShortCutUtil.hasShortcut(context, name)");
            return;
        }
        android.content.SharedPreferences orCreateBundle = io.dcloud.common.adapter.util.SP.getOrCreateBundle(activity, "pdr");
        boolean z3 = orCreateBundle.getBoolean(strObtainAppId + io.dcloud.common.adapter.util.SP.STAREMAPP_FIRST_SHORT_CUT, true);
        if (io.dcloud.common.util.ShortcutCreateUtil.isDisableShort(iApp.getActivity())) {
            handleDisableShort(iApp.getActivity(), strObtainAppId, z3, orCreateBundle);
            orCreateBundle.edit().putBoolean(strObtainAppId + io.dcloud.common.adapter.util.SP.STAREMAPP_FIRST_SHORT_CUT, false).commit();
            return;
        }
        if (io.dcloud.common.adapter.util.MobilePhoneModel.isSpecialPhone(activity) && showSettingsDialog(iApp, strSubstring, bitmap)) {
            return;
        }
        java.lang.String string = orCreateBundle.getString(io.dcloud.common.constant.AbsoluteConst.TEST_RUN + strObtainAppId, null);
        if (!android.text.TextUtils.isEmpty(string)) {
            string.equals("__am=t");
        }
        boolean z4 = orCreateBundle.getBoolean(strObtainAppId + io.dcloud.common.adapter.util.SP.K_CREATED_SHORTCUT, false);
        if (android.os.Build.BRAND.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.MEIZU) && !io.dcloud.common.util.AppPermissionUtil.isFlymeShortcutallowAllow(activity, getHeadShortCutIntent(strObtainAppName))) {
            checkShortcutPermission(iApp, strObtainAppId, orCreateBundle, io.dcloud.common.adapter.util.SP.STAREMAPP_SHORTCUT_GUIDE_IS_FIRST_FLYME);
            return;
        }
        if (android.os.Build.MANUFACTURER.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.HUAWEI) && !io.dcloud.common.util.AppPermissionUtil.isEmuiShortcutallowAllow()) {
            checkShortcutPermission(iApp, strObtainAppId, orCreateBundle, io.dcloud.common.adapter.util.SP.STAREMAPP_SHORTCUT_GUIDE_IS_FIRST_EMUI);
            return;
        }
        if (!io.dcloud.common.util.ShortcutCreateUtil.isDuplicateLauncher(activity) && iApp.forceShortCut().equals("auto") && z4) {
            return;
        }
        if (!z4) {
            io.dcloud.common.adapter.util.SP.getOrCreateBundle(activity, "streamapp_create_shortcut").getBoolean("is_create_shortcut" + strObtainAppId, false);
        }
        if (orCreateBundle.getBoolean(io.dcloud.common.adapter.util.SP.K_SHORT_CUT_ONE_TIPS, true)) {
            orCreateBundle.edit().putBoolean(io.dcloud.common.adapter.util.SP.K_SHORT_CUT_ONE_TIPS, false).commit();
        }
        orCreateBundle.edit().putBoolean(strObtainAppId + io.dcloud.common.adapter.util.SP.STAREMAPP_FIRST_SHORT_CUT, false).commit();
        if (createShortcutToDeskTop(activity, strObtainAppId, strObtainAppName, bitmap2, stringExtra, null, false)) {
            io.dcloud.common.adapter.util.Logger.e("StreamSDK", "come into createShortcutToDeskTop and return ture already");
            if (z) {
                if (io.dcloud.common.util.PdrUtil.isEquals(iApp.forceShortCut(), "tipOnce")) {
                    if (orCreateBundle.getBoolean(strObtainAppId + io.dcloud.common.adapter.util.SP.STAREMAPP_SHORTCUT_TIP_IS_FIRST, true)) {
                        orCreateBundle.edit().putBoolean(strObtainAppId + io.dcloud.common.adapter.util.SP.STAREMAPP_SHORTCUT_TIP_IS_FIRST, false).commit();
                        if (showToast(iApp, activity, strObtainAppId, orCreateBundle)) {
                            return;
                        }
                    }
                } else if (showToast(iApp, activity, strObtainAppId, orCreateBundle)) {
                    return;
                }
            } else if (isHasShortCut(iApp, 1000L, "auto")) {
                return;
            } else {
                showCreateShortCutToast(iApp);
            }
        }
        orCreateBundle.edit().putString(strObtainAppId + io.dcloud.common.adapter.util.SP.K_CREATE_SHORTCUT_NAME, strObtainAppName).commit();
        orCreateBundle.edit().putBoolean(strObtainAppId + io.dcloud.common.adapter.util.SP.K_CREATED_SHORTCUT, true).commit();
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x01aa, code lost:
    
        if (showToast(r15, r4, r5, r0) != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01b1, code lost:
    
        if (showToast(r15, r4, r5, r0) != false) goto L65;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int createShortcutGuide(io.dcloud.common.DHInterface.IApp r15, java.lang.String r16, android.graphics.Bitmap r17, boolean r18, boolean r19, boolean r20) {
        /*
            Method dump skipped, instruction units count: 495
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.dcloud.common.util.ShortCutUtil.createShortcutGuide(io.dcloud.common.DHInterface.IApp, java.lang.String, android.graphics.Bitmap, boolean, boolean, boolean):int");
    }

    public static boolean createShortcutToDeskTop(android.content.Context context, java.lang.String str, java.lang.String str2, android.graphics.Bitmap bitmap, java.lang.String str3, org.json.JSONObject jSONObject, boolean z) {
        return createShortcutToDeskTop(context, str, str2, bitmap, str3, jSONObject, z, false);
    }

    public static android.content.Intent getHeadShortCutIntent(java.lang.String str) {
        android.content.Intent intent = new android.content.Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent.putExtra("android.intent.extra.shortcut.NAME", str);
        intent.putExtra("duplicate", false);
        return intent;
    }

    public static android.net.Uri getUriFromLauncher(android.content.Context context) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("content://");
        java.lang.String launcherPackageName = io.dcloud.common.util.LauncherUtil.getLauncherPackageName(context);
        io.dcloud.common.adapter.util.Logger.e("tag", "getUriFromLauncher: packageName" + launcherPackageName);
        if ("com.nd.android.pandahome2".equals(launcherPackageName)) {
            return android.net.Uri.parse("content://com.nd.android.launcher2.settings/com.nd.hilauncherdev/favorites?notify=true");
        }
        java.lang.String authorityFromPermission = io.dcloud.common.util.LauncherUtil.getAuthorityFromPermission(context, launcherPackageName + ".permission.READ_SETTINGS");
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder("getUriFromLauncher: LauncherUtil.getAuthorityFromPermissionwithpackagename(");
        sb2.append(authorityFromPermission);
        io.dcloud.common.adapter.util.Logger.e("TAG", sb2.toString());
        if (android.text.TextUtils.isEmpty(authorityFromPermission)) {
            authorityFromPermission = io.dcloud.common.util.LauncherUtil.getAuthorityFromPermissionDefault(context);
            io.dcloud.common.adapter.util.Logger.e("TAG", "getUriFromLauncher: LauncherUtil.getAuthorityFromPermissionDefault(" + authorityFromPermission);
        }
        if (android.text.TextUtils.isEmpty(authorityFromPermission)) {
            if (android.os.Build.MANUFACTURER.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.QiKU)) {
                return android.net.Uri.parse("content://com.yulong.android.launcher3.compound/compoundworkspace?notify=false");
            }
            return null;
        }
        sb.append(authorityFromPermission);
        if (android.os.Build.MANUFACTURER.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.OPPO)) {
            sb.append("/singledesktopitems?notify=true");
        } else {
            sb.append("/favorites?notify=true");
        }
        return android.net.Uri.parse(sb.toString());
    }

    public static void handleDisableShort(android.app.Activity activity, java.lang.String str, boolean z, android.content.SharedPreferences sharedPreferences) {
    }

    public static boolean hasShortcut(android.content.Context context, java.lang.String str) {
        return SHORT_CUT_EXISTING.equals(requestShortCut(context, str));
    }

    public static boolean isHasShortCut(final io.dcloud.common.DHInterface.IApp iApp, long j, java.lang.String str) {
        if (!android.os.Build.BRAND.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.XIAOMI)) {
            return false;
        }
        io.dcloud.common.util.ShortCutUtil.TypeRunnable typeRunnable = mRunnable;
        if (typeRunnable != null) {
            if (typeRunnable.getType().equals("back") && str.equals(mRunnable.getType())) {
                return true;
            }
            removeRunHandler();
        }
        io.dcloud.common.util.BaseInfo.isPostChcekShortCut = true;
        io.dcloud.common.util.ShortCutUtil.TypeRunnable typeRunnable2 = new io.dcloud.common.util.ShortCutUtil.TypeRunnable() { // from class: io.dcloud.common.util.ShortCutUtil.3
            java.lang.String type;

            @Override // io.dcloud.common.util.ShortCutUtil.TypeRunnable
            public java.lang.String getType() {
                return this.type;
            }

            @Override // java.lang.Runnable
            public void run() {
                io.dcloud.common.util.BaseInfo.isPostChcekShortCut = false;
                if (!iApp.getActivity().isFinishing()) {
                    android.content.SharedPreferences orCreateBundle = io.dcloud.common.adapter.util.SP.getOrCreateBundle(iApp.getActivity(), "pdr");
                    if (io.dcloud.common.util.ShortCutUtil.hasShortcut(iApp.getActivity(), iApp.obtainAppName())) {
                        orCreateBundle.edit().putString(iApp.obtainAppId() + io.dcloud.common.adapter.util.SP.K_CREATE_SHORTCUT_NAME, iApp.obtainAppName()).commit();
                        orCreateBundle.edit().putBoolean(iApp.obtainAppId() + io.dcloud.common.adapter.util.SP.K_CREATED_SHORTCUT, true).commit();
                        io.dcloud.common.util.ShortCutUtil.showCreateShortCutToast(iApp);
                    } else if (io.dcloud.common.util.AppPermissionUtil.getCheckShortcutOps(iApp.getActivity()) == 0) {
                        io.dcloud.common.util.ShortCutUtil.createShortcutToDeskTop(iApp, true);
                        io.dcloud.common.util.ShortCutUtil.showCreateShortCutToast(iApp);
                    } else {
                        io.dcloud.common.DHInterface.IApp iApp2 = iApp;
                        io.dcloud.common.util.AppPermissionUtil.showShortCutOpsDialog(iApp2, iApp2.getActivity(), iApp.obtainAppId(), orCreateBundle);
                    }
                }
                io.dcloud.common.util.ShortCutUtil.mRunnable = null;
            }

            @Override // io.dcloud.common.util.ShortCutUtil.TypeRunnable
            public void setType(java.lang.String str2) {
                this.type = str2;
            }
        };
        mRunnable = typeRunnable2;
        typeRunnable2.setType(str);
        io.dcloud.common.adapter.util.MessageHandler.postDelayed(mRunnable, j);
        return true;
    }

    public static boolean isOpsCreateShortcut(android.content.Context context, java.lang.String str) {
        android.content.SharedPreferences orCreateBundle = io.dcloud.common.adapter.util.SP.getOrCreateBundle(context, "pdr");
        boolean z = orCreateBundle.getBoolean(str + io.dcloud.common.adapter.util.SP.IS_CREATE_SHORTCUT, false);
        if (z) {
            orCreateBundle.edit().remove(str + io.dcloud.common.adapter.util.SP.IS_CREATE_SHORTCUT).commit();
        }
        return z;
    }

    public static boolean isRunShortCut(android.content.Context context, java.lang.String str) {
        android.content.SharedPreferences orCreateBundle = io.dcloud.common.adapter.util.SP.getOrCreateBundle(context, "pdr");
        if (!orCreateBundle.getString(io.dcloud.common.adapter.util.SP.RECORD_RUN_SHORT_CUT, "").equals(str)) {
            return false;
        }
        orCreateBundle.edit().remove(io.dcloud.common.adapter.util.SP.RECORD_RUN_SHORT_CUT).commit();
        return true;
    }

    public static void onResumeCreateShortcut(io.dcloud.common.DHInterface.IApp iApp) {
        if (io.dcloud.common.util.AppPermissionUtil.getCheckShortcutOps(iApp.getActivity()) != 1) {
            createShortcut(iApp, null, null, false);
            return;
        }
        io.dcloud.common.util.AppPermissionUtil.checkShortcutOps(iApp, iApp.getActivity(), iApp.obtainAppId(), iApp.obtainAppName());
        android.content.Intent intentObtainWebAppIntent = iApp.obtainWebAppIntent();
        createShortcutToDeskTop(iApp.getActivity(), iApp.obtainAppId(), iApp.obtainAppName(), null, intentObtainWebAppIntent != null ? intentObtainWebAppIntent.getStringExtra(io.dcloud.common.constant.IntentConst.WEBAPP_SHORT_CUT_CLASS_NAME) : "", null, false);
    }

    public static void onResumeCreateShortcutGuide(io.dcloud.common.DHInterface.IApp iApp) {
        io.dcloud.common.ui.PermissionGuideWindow.getInstance(iApp.getActivity()).dismissWindow();
        java.lang.String str = android.os.Build.BRAND;
        if (str.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.GOOGLE)) {
            str = android.os.Build.MANUFACTURER;
        }
        if (io.dcloud.common.adapter.util.MobilePhoneModel.SMARTISAN.equals(str)) {
            createShortcutGuide(iApp, null, null, false, false, false);
            return;
        }
        io.dcloud.common.adapter.util.MobilePhoneModel.XIAOMI.equals(str);
        io.dcloud.common.adapter.util.MobilePhoneModel.MEIZU.equals(str);
        android.os.Build.MANUFACTURER.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.HUAWEI);
        createShortcutGuide(iApp, null, null, false, true, true);
    }

    public static void removeRunHandler() {
        if (mRunnable != null) {
            io.dcloud.common.util.BaseInfo.isPostChcekShortCut = false;
            io.dcloud.common.adapter.util.MessageHandler.removeCallbacks(mRunnable);
        }
    }

    public static boolean removeShortcutFromDeskTop(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, org.json.JSONObject jSONObject) {
        android.content.Intent intent = new android.content.Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
        intent.putExtra("android.intent.extra.shortcut.NAME", str2);
        intent.putExtra("duplicate", false);
        android.content.Intent intent2 = new android.content.Intent();
        if (android.text.TextUtils.isEmpty(str3)) {
            intent2 = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        } else {
            if (io.dcloud.common.util.PdrUtil.isEmpty(activityNameSDK)) {
                intent2.setClassName(context.getPackageName(), str3);
            } else {
                intent2.putExtra(io.dcloud.common.constant.IntentConst.WEBAPP_ACTIVITY_SHORTCUTACTIVITY, activityNameSDK);
                intent2.setClassName(context.getPackageName(), activityNameSDK);
            }
            intent2.setAction("android.intent.action.MAIN");
            intent2.addCategory("android.intent.category.LAUNCHER");
        }
        if (jSONObject != null) {
            java.util.Iterator<java.lang.String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                try {
                    java.lang.String next = itKeys.next();
                    intent2.putExtra(next, jSONObject.getString(next));
                } catch (org.json.JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        addShortCutSrc(context, intent2, str2);
        intent2.putExtra(io.dcloud.common.constant.IntentConst.SHORT_CUT_APPID, str);
        intent2.putExtra(io.dcloud.common.constant.IntentConst.FROM_SHORT_CUT_STRAT, true);
        intent2.setFlags(268435456);
        intent2.setData(android.net.Uri.parse("https://m3w.cn/s/" + str));
        intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
        context.sendBroadcast(intent);
        return true;
    }

    public static java.lang.String requestShortCut(android.content.Context context, java.lang.String str) {
        java.lang.String str2 = "unknown";
        if (android.os.Build.VERSION.SDK_INT >= 25) {
            java.util.List pinnedShortcuts = androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0.m13m(context.getSystemService(androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0.m$3())).getPinnedShortcuts();
            java.lang.String str3 = "id_" + str.hashCode();
            for (int i = 0; i < pinnedShortcuts.size(); i++) {
                if (androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0.m12m(pinnedShortcuts.get(i)).getId().equals(str3)) {
                    return SHORT_CUT_EXISTING;
                }
            }
        } else {
            android.content.ContentResolver contentResolver = context.getContentResolver();
            android.net.Uri uriFromLauncher = getUriFromLauncher(context);
            if (uriFromLauncher == null) {
                java.lang.String shortCutUri = getShortCutUri(context);
                if (!android.text.TextUtils.isEmpty(shortCutUri)) {
                    uriFromLauncher = android.net.Uri.parse(shortCutUri);
                    io.dcloud.common.adapter.util.Logger.es("shortcututil", context.getString(io.dcloud.base.R.string.dcloud_short_cut_err1) + uriFromLauncher);
                }
            }
            android.net.Uri uri = uriFromLauncher;
            io.dcloud.common.adapter.util.Logger.e("shortcututil", "requestShortCut: uri===" + uri);
            if (uri != null) {
                try {
                    android.database.Cursor cursorQuery = contentResolver.query(uri, new java.lang.String[]{io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE, "intent"}, "title=? ", new java.lang.String[]{str}, null);
                    if (cursorQuery == null || cursorQuery.getCount() <= 0) {
                        str2 = SHORT_CUT_NONE;
                    } else {
                        io.dcloud.common.adapter.util.Logger.e("shortcututil", "c != null && c.getCount() > 0");
                        while (cursorQuery.moveToNext()) {
                            java.lang.String string = cursorQuery.getString(cursorQuery.getColumnIndex("intent"));
                            if (android.text.TextUtils.isEmpty(string)) {
                                str2 = SHORT_CUT_NONE;
                            } else {
                                io.dcloud.common.adapter.util.Logger.e("shortcututil", "intent=====" + string);
                                if (string.contains(io.dcloud.common.constant.IntentConst.SHORT_CUT_APPID)) {
                                    if (!io.dcloud.common.util.BaseInfo.isBase(context)) {
                                        if (string.contains("io.dcloud.appstream.StreamAppMainActivity")) {
                                            if (string.contains(str.hashCode() + "_" + context.getPackageName())) {
                                            }
                                        }
                                    }
                                    str2 = SHORT_CUT_EXISTING;
                                }
                            }
                        }
                    }
                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                        cursorQuery.close();
                    }
                    return str2;
                } catch (java.lang.Exception e) {
                    if (e.getMessage() != null && e.getMessage().contains("READ_SETTINGS")) {
                        str2 = NOPERMISSIONS;
                    }
                    io.dcloud.common.adapter.util.Logger.es("shortcututil", e.getMessage() + "URI==" + uri);
                    e.printStackTrace();
                }
            }
        }
        return str2;
    }

    public static java.lang.String requestShortCutForCommit(android.content.Context context, java.lang.String str) {
        return requestShortCut(context, str);
    }

    public static void showCreateShortCutToast(io.dcloud.common.DHInterface.IApp iApp) {
        java.lang.String str = io.dcloud.common.util.StringUtil.format(iApp.getActivity().getString(io.dcloud.base.R.string.dcloud_short_cut_created), iApp.obtainAppName());
        if (!iApp.forceShortCut().equals(io.dcloud.common.constant.AbsoluteConst.INSTALL_OPTIONS_FORCE) || io.dcloud.common.util.ShortcutCreateUtil.isDuplicateLauncher(iApp.getActivity())) {
            if (io.dcloud.common.util.ShortcutCreateUtil.needToast(iApp.getActivity())) {
                com.dcloud.android.widget.toast.ToastCompat.makeText(iApp.getActivity().getApplicationContext(), (java.lang.CharSequence) str, 1).show();
                return;
            }
            return;
        }
        java.lang.String str2 = "“" + iApp.obtainAppName() + iApp.getActivity().getString(io.dcloud.base.R.string.dcloud_short_cut_created_tip);
        if (io.dcloud.common.util.ShortcutCreateUtil.needToast(iApp.getActivity())) {
            com.dcloud.android.widget.toast.ToastCompat.makeText(iApp.getActivity().getApplicationContext(), (java.lang.CharSequence) str2, 1).show();
        }
    }

    public static boolean showSettingsDialog(final io.dcloud.common.DHInterface.IApp iApp, final java.lang.String str, final android.graphics.Bitmap bitmap) {
        java.lang.String str2;
        java.lang.String string;
        java.lang.String string2;
        final android.content.SharedPreferences orCreateBundle = io.dcloud.common.adapter.util.SP.getOrCreateBundle(iApp.getActivity(), "pdr");
        if (!orCreateBundle.getBoolean(io.dcloud.common.adapter.util.SP.K_SHORT_CUT_ONE_TIPS, true) && !android.os.Build.BRAND.equals(io.dcloud.common.adapter.util.MobilePhoneModel.SMARTISAN)) {
            return false;
        }
        if (orCreateBundle.getBoolean(io.dcloud.common.adapter.util.SP.K_SHORT_CUT_ONE_TIPS, true)) {
            orCreateBundle.edit().putBoolean(io.dcloud.common.adapter.util.SP.K_SHORT_CUT_ONE_TIPS, false).commit();
        }
        java.lang.String string3 = iApp.getActivity().getString(io.dcloud.base.R.string.dcloud_short_cut_goto_pms);
        java.lang.String string4 = iApp.getActivity().getString(io.dcloud.base.R.string.dcloud_short_cut_it_set);
        java.lang.String str3 = android.os.Build.BRAND;
        if (str3.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.QiKU)) {
            string2 = iApp.getActivity().getString(io.dcloud.base.R.string.dcloud_short_cut_qiku1);
            string = iApp.getActivity().getString(io.dcloud.base.R.string.dcloud_short_cut_goto_run);
        } else {
            if (str3.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.VIVO)) {
                if (!io.dcloud.common.util.LoadAppUtils.isAppLoad(iApp.getActivity(), "com.iqoo.secure")) {
                    return false;
                }
                str2 = iApp.getActivity().getString(io.dcloud.base.R.string.dcloud_short_cut_vivo1) + "App" + iApp.getActivity().getString(io.dcloud.base.R.string.dcloud_short_cut_vivo2);
            } else if (str3.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.SMARTISAN)) {
                string = string3;
                string2 = iApp.getActivity().getString(io.dcloud.base.R.string.dcloud_short_cut_chuizi1);
                string4 = iApp.getActivity().getString(io.dcloud.base.R.string.dcloud_short_cut_not_install);
            } else {
                str2 = "";
            }
            java.lang.String str4 = str2;
            string = string3;
            string2 = str4;
        }
        com.dcloud.android.widget.dialog.DCloudAlertDialog dCloudAlertDialogInitDialogTheme = io.dcloud.common.util.DialogUtil.initDialogTheme(iApp.getActivity(), true);
        dCloudAlertDialogInitDialogTheme.setMessage(string2);
        dCloudAlertDialogInitDialogTheme.setTitle(iApp.getActivity().getString(io.dcloud.base.R.string.dcloud_short_cut_tips));
        dCloudAlertDialogInitDialogTheme.setButton(-1, string, new android.content.DialogInterface.OnClickListener() { // from class: io.dcloud.common.util.ShortCutUtil.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i) {
                android.content.Intent intent;
                orCreateBundle.edit().putString(io.dcloud.common.adapter.util.SP.RECORD_RUN_SHORT_CUT, iApp.obtainAppId()).commit();
                java.lang.String str5 = android.os.Build.BRAND;
                if (str5.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.QiKU) || str5.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.SMARTISAN)) {
                    if (str5.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.QiKU)) {
                        intent = new android.content.Intent();
                        intent.setClassName("com.yulong.android.launcher3", "com.yulong.android.launcher3.LauncherSettingsActivity");
                    } else {
                        intent = new android.content.Intent("android.settings.SETTINGS");
                    }
                    iApp.getActivity().startActivity(intent);
                    return;
                }
                if (str5.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.VIVO)) {
                    android.content.pm.PackageManager packageManager = iApp.getActivity().getPackageManager();
                    new android.content.Intent();
                    android.content.Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage("com.iqoo.secure");
                    launchIntentForPackage.setFlags(337641472);
                    iApp.getActivity().startActivity(launchIntentForPackage);
                }
            }
        });
        dCloudAlertDialogInitDialogTheme.setButton(-2, string4, new android.content.DialogInterface.OnClickListener() { // from class: io.dcloud.common.util.ShortCutUtil.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i) {
                if (android.os.Build.BRAND.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.SMARTISAN)) {
                    return;
                }
                io.dcloud.common.util.ShortCutUtil.createShortcut(iApp, str, bitmap, false);
            }
        });
        dCloudAlertDialogInitDialogTheme.setCanceledOnTouchOutside(false);
        dCloudAlertDialogInitDialogTheme.show();
        return true;
    }

    private static boolean showToast(io.dcloud.common.DHInterface.IApp iApp, android.app.Activity activity, java.lang.String str, android.content.SharedPreferences sharedPreferences) {
        if ("12214060304".equals(io.dcloud.common.util.BaseInfo.sChannel) && "com.aliyun.homeshell".equals(io.dcloud.common.util.LauncherUtil.getLauncherPackageName(activity))) {
            if (sharedPreferences.getBoolean(str + io.dcloud.common.adapter.util.SP.STAREMAPP_ALIYUN_SHORT_CUT_IS_FIRST_CREATED, true)) {
                showCreateShortCutToast(iApp);
                sharedPreferences.edit().putBoolean(str + io.dcloud.common.adapter.util.SP.STAREMAPP_ALIYUN_SHORT_CUT_IS_FIRST_CREATED, false).commit();
            }
        } else {
            showCreateShortCutToast(iApp);
        }
        return false;
    }

    public static void updateShortcutFromDeskTop(android.app.Activity activity, java.lang.String str, java.lang.String str2, android.graphics.Bitmap bitmap, java.lang.String str3) {
        removeShortcutFromDeskTop(activity, str, str2, str3, null);
        createShortcutToDeskTop(activity, str, str2, bitmap, str3, null, false);
    }

    public static java.lang.String requestShortCutPermissionVivo(android.content.Context context, java.lang.String str) {
        android.content.ContentResolver contentResolver = context.getContentResolver();
        android.net.Uri uriFromLauncher = getUriFromLauncher(context);
        if (uriFromLauncher == null) {
            java.lang.String shortCutUri = getShortCutUri(context);
            if (!android.text.TextUtils.isEmpty(shortCutUri)) {
                uriFromLauncher = android.net.Uri.parse(shortCutUri);
            }
        }
        io.dcloud.common.adapter.util.Logger.e("shortcututil", "requestShortCut: uri===" + uriFromLauncher);
        if (uriFromLauncher != null) {
            try {
                android.database.Cursor cursorQuery = contentResolver.query(uriFromLauncher, new java.lang.String[]{io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE, "intent", "shortcutPermission"}, "title=? ", new java.lang.String[]{str}, null);
                if (cursorQuery != null && cursorQuery.getCount() > 0) {
                    io.dcloud.common.adapter.util.Logger.e("shortcututil", "c != null && c.getCount() > 0");
                    if (cursorQuery.moveToNext()) {
                        return cursorQuery.getString(cursorQuery.getColumnIndex("shortcutPermission"));
                    }
                }
                if (cursorQuery != null && !cursorQuery.isClosed()) {
                    cursorQuery.close();
                    return "-1";
                }
            } catch (java.lang.Exception e) {
                io.dcloud.common.adapter.util.Logger.es("shortcututil", e.getMessage() + "URI==" + uriFromLauncher);
                e.printStackTrace();
            }
        }
        return "-1";
    }

    public static boolean createShortcutToDeskTop(io.dcloud.common.DHInterface.IApp iApp, boolean z) {
        java.lang.String stringExtra;
        android.content.Intent intentObtainWebAppIntent = iApp.obtainWebAppIntent();
        if (intentObtainWebAppIntent == null) {
            stringExtra = "";
        } else {
            stringExtra = intentObtainWebAppIntent.getStringExtra(io.dcloud.common.constant.IntentConst.WEBAPP_SHORT_CUT_CLASS_NAME);
        }
        return createShortcutToDeskTop(iApp.getActivity(), iApp.obtainAppId(), iApp.obtainAppName(), null, stringExtra, null, false, z);
    }

    public static java.lang.String getShortCutUri(android.content.Context context) {
        android.content.pm.ActivityInfo activityInfo;
        if (context == null) {
            return "";
        }
        android.content.Intent intent = new android.content.Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        android.content.pm.ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        if (resolveInfoResolveActivity == null || (activityInfo = resolveInfoResolveActivity.activityInfo) == null || activityInfo.packageName.equals(com.taobao.weex.WXEnvironment.OS)) {
            return "";
        }
        java.lang.String str = resolveInfoResolveActivity.activityInfo.packageName;
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        return "content://" + str + ".settings/favorites?notify=true";
    }

    public static boolean createShortcutToDeskTop(android.content.Context context, java.lang.String str, java.lang.String str2, android.graphics.Bitmap bitmap, java.lang.String str3, org.json.JSONObject jSONObject, boolean z, boolean z2) {
        android.content.Intent intent = new android.content.Intent();
        if (android.text.TextUtils.isEmpty(str3)) {
            intent = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        } else {
            intent.setClassName(context.getPackageName(), str3);
            intent.setAction("android.intent.action.MAIN");
        }
        if (jSONObject != null) {
            java.util.Iterator<java.lang.String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                try {
                    java.lang.String next = itKeys.next();
                    intent.putExtra(next, jSONObject.getString(next));
                } catch (org.json.JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        addShortCutSrc(context, intent, str2);
        intent.putExtra(io.dcloud.common.constant.IntentConst.SHORT_CUT_APPID, str);
        intent.putExtra(io.dcloud.common.constant.IntentConst.FROM_SHORT_CUT_STRAT, true);
        intent.setFlags(268435456);
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            android.content.pm.ShortcutManager shortcutManagerM13m = androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0.m13m(context.getSystemService(io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_SHORTCUT));
            if (shortcutManagerM13m != null && shortcutManagerM13m.isRequestPinShortcutSupported()) {
                androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0.m25m();
                android.content.pm.ShortcutInfo shortcutInfoBuild = androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0.m11m(context, "id_" + str2.hashCode()).setIcon(android.graphics.drawable.Icon.createWithBitmap(bitmap)).setIntent(intent).setShortLabel(str2).build();
                shortcutManagerM13m.requestPinShortcut(shortcutInfoBuild, android.app.PendingIntent.getBroadcast(context, 0, shortcutManagerM13m.createShortcutResultIntent(shortcutInfoBuild), 0).getIntentSender());
            }
        } else {
            android.content.Intent headShortCutIntent = getHeadShortCutIntent(str2);
            headShortCutIntent.putExtra("android.intent.extra.shortcut.INTENT", intent);
            headShortCutIntent.putExtra("android.intent.extra.shortcut.ICON", bitmap);
            context.sendBroadcast(headShortCutIntent);
        }
        return true;
    }
}
