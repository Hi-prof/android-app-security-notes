package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class ADUtils {
    private static final com.dcloud.android.downloader.callback.DownloadListener DOWNLOAD_DC_LISTENER = new com.dcloud.android.downloader.callback.DownloadListener() { // from class: io.dcloud.common.util.ADUtils.1
        @Override // com.dcloud.android.downloader.callback.DownloadListener
        public void onDownloadFailed(com.dcloud.android.downloader.domain.DownloadInfo downloadInfo, com.dcloud.android.downloader.exception.DownloadException downloadException) {
            downloadException.printStackTrace();
            org.json.JSONObject loadData = io.dcloud.common.util.ADUtils.getLoadData(downloadInfo.getId());
            if (loadData != null) {
                io.dcloud.common.util.ADUtils.downloadCommit(downloadInfo.getContext(), loadData.optString("appid"), loadData.optString("tid"), loadData.optString("adid"), 32, java.lang.String.valueOf(downloadException.getCode()), downloadException.getMessage(), loadData.optString("ua"));
            }
        }

        @Override // com.dcloud.android.downloader.callback.DownloadListener
        public void onDownloadSuccess(com.dcloud.android.downloader.domain.DownloadInfo downloadInfo) {
            org.json.JSONObject jSONObjectRemoveDownlaodData = io.dcloud.common.util.ADUtils.removeDownlaodData(downloadInfo.getContext(), downloadInfo.getId());
            if (jSONObjectRemoveDownlaodData != null) {
                io.dcloud.common.util.ADUtils.downloadCommit(downloadInfo.getContext(), jSONObjectRemoveDownlaodData.optString("appid"), jSONObjectRemoveDownlaodData.optString("tid"), jSONObjectRemoveDownlaodData.optString("adid"), 30, null, null, jSONObjectRemoveDownlaodData.optString("ua"));
                io.dcloud.common.util.ADUtils.saveLoadAppData(downloadInfo.getContext(), jSONObjectRemoveDownlaodData.optString("pname"), jSONObjectRemoveDownlaodData.optString("appid"), jSONObjectRemoveDownlaodData.optString("tid"), jSONObjectRemoveDownlaodData.optString("adid"), downloadInfo.getPath(), jSONObjectRemoveDownlaodData.optString("ua"));
            }
            android.content.Intent aPKInstallIntent = io.dcloud.common.adapter.util.DownloadUtil.getAPKInstallIntent(downloadInfo.getContext(), downloadInfo.getPath());
            if (downloadInfo.getTag() == null || !(downloadInfo.getTag() instanceof io.dcloud.common.DHInterface.ILoadCallBack)) {
                downloadInfo.getContext().startActivity(aPKInstallIntent);
            } else {
                ((io.dcloud.common.DHInterface.ILoadCallBack) downloadInfo.getTag()).onCallBack(0, downloadInfo.getContext(), aPKInstallIntent);
            }
            com.dcloud.android.downloader.DownloadService.getDownloadManager(downloadInfo.getContext().getApplicationContext()).remove(downloadInfo);
        }

        @Override // com.dcloud.android.downloader.callback.DownloadListener
        public void onDownloading(long j, long j2) {
        }

        @Override // com.dcloud.android.downloader.callback.DownloadListener
        public void onPaused() {
        }

        @Override // com.dcloud.android.downloader.callback.DownloadListener
        public void onRemoved() {
        }

        @Override // com.dcloud.android.downloader.callback.DownloadListener
        public void onStart() {
        }

        @Override // com.dcloud.android.downloader.callback.DownloadListener
        public void onWaited() {
        }
    };
    private static final java.lang.String TAG = "ADUtils";

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class ADLoadData {
        public java.lang.String adid;
        public java.lang.String appid;
        public long expiresTime;
        public long id;
        public java.lang.String name;
        public java.lang.String pname;
        public java.lang.String tid;
        public java.lang.String type = "default";
        public java.lang.String ua;
        public java.lang.String url;
    }

    private ADUtils() {
    }

    public static java.lang.Object ADHandlerMethod(java.lang.String str, java.lang.Object... objArr) {
        try {
            java.lang.Class[] clsArr = new java.lang.Class[0];
            if (objArr != null && objArr.length > 0) {
                clsArr = new java.lang.Class[objArr.length];
                for (int i = 0; i < objArr.length; i++) {
                    clsArr[i] = objArr[i].getClass();
                }
            }
            return io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.feature.gg.dcloud.ADHandler", str, null, clsArr, objArr);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static void downloadCommit(final android.content.Context context, final java.lang.String str, final java.lang.String str2, final java.lang.String str3, final int i, final java.lang.String str4, final java.lang.String str5, final java.lang.String str6) {
        io.dcloud.common.util.ThreadPool.self().addThreadTask(new java.lang.Runnable() { // from class: io.dcloud.common.util.ADUtils.4
            @Override // java.lang.Runnable
            public void run() {
                io.dcloud.p.e0.a(context, str, str2, str3, i, str4, str5, null, null, null, io.dcloud.common.util.ADUtils.getSplashAdpId(), str6, null);
            }
        });
    }

    public static org.json.JSONObject getDdDataForUrl(java.lang.String str) {
        java.util.Map<java.lang.String, ?> all = io.dcloud.common.adapter.util.SP.getOrCreateBundle(io.dcloud.common.constant.AbsoluteConst.AD_DOWNLOAD_DATA).getAll();
        if (all == null || all.size() <= 0) {
            return null;
        }
        java.util.Iterator<?> it = all.values().iterator();
        while (it.hasNext()) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject((java.lang.String) it.next());
                if (str.equals(jSONObject.optString("url"))) {
                    return jSONObject;
                }
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static java.lang.String getDownloadDataKey(long j) {
        return io.dcloud.common.constant.AbsoluteConst.AD_DL_DATA_KEY + java.lang.String.valueOf(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String getLoadAppDataKey(java.lang.String str) {
        return io.dcloud.common.constant.AbsoluteConst.AD_IA_DATA_KEY + str;
    }

    public static org.json.JSONObject getLoadData(long j) {
        try {
            return new org.json.JSONObject(io.dcloud.common.adapter.util.SP.getOrCreateBundle(io.dcloud.common.constant.AbsoluteConst.AD_DOWNLOAD_DATA).getString(getDownloadDataKey(j), ""));
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.String getSplashAdpId() {
        return java.lang.String.valueOf(io.dcloud.common.adapter.util.PlatformUtil.invokeMethod("io.dcloud.feature.gg.AolSplashUtil", "getSplashAdpId", null, new java.lang.Class[]{io.dcloud.common.DHInterface.IApp.class, java.lang.String.class, java.lang.String.class}, new java.lang.Object[]{null, "_adpid_", "UNIAD_SPLASH_ADPID"}));
    }

    public static long loadADFile(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, io.dcloud.common.DHInterface.ILoadCallBack iLoadCallBack, boolean z, java.lang.String str8) {
        if (z) {
            downloadCommit(context, str, str2, str3, 29, null, null, str8);
        }
        com.dcloud.android.downloader.callback.DCDownloadManager downloadManager = com.dcloud.android.downloader.DownloadService.getDownloadManager(context.getApplicationContext());
        com.dcloud.android.downloader.domain.DownloadInfo downloadInfoBuild = new com.dcloud.android.downloader.domain.DownloadInfo.Builder().setUrl(str6).setPath(io.dcloud.common.adapter.util.DeviceInfo.sDeviceRootDir + "/Download/" + str4).build(context);
        downloadInfoBuild.setTag(iLoadCallBack);
        downloadInfoBuild.setDownloadListener(DOWNLOAD_DC_LISTENER);
        downloadManager.download(downloadInfoBuild);
        return downloadInfoBuild.getId();
    }

    public static void loadAppTip(android.content.Context context) {
        io.dcloud.common.adapter.util.MessageHandler.sendMessage(new io.dcloud.common.adapter.util.MessageHandler.IMessages() { // from class: io.dcloud.common.util.ADUtils.3
            @Override // io.dcloud.common.adapter.util.MessageHandler.IMessages
            public void execute(java.lang.Object obj) {
                com.dcloud.android.widget.toast.ToastCompat.makeText((android.content.Context) obj, io.dcloud.base.R.string.dcloud_common_download_tips1, 0).show();
            }
        }, context);
    }

    public static void openBrowser(android.content.Context context, java.lang.String str) {
        try {
            android.content.Intent intent = new android.content.Intent();
            if (!android.os.Build.BRAND.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.VIVO) && io.dcloud.common.util.LoadAppUtils.isAppLoad(context, "com.android.browser")) {
                intent.setPackage("com.android.browser");
            }
            intent.setData(android.net.Uri.parse(str));
            intent.setAction("android.intent.action.VIEW");
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (java.lang.Exception e) {
            android.util.Log.e(TAG, "openBrowser exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static boolean openDeepLink(android.content.Context context, java.lang.String str) {
        try {
            android.content.Intent uri = android.content.Intent.parseUri(str, 1);
            if (io.dcloud.common.util.BaseInfo.isDefense) {
                uri.setSelector(null);
                uri.setComponent(null);
                uri.addCategory("android.intent.category.BROWSABLE");
            }
            java.util.List<android.content.pm.ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(uri, 65536);
            if (listQueryIntentActivities == null || listQueryIntentActivities.isEmpty()) {
                return false;
            }
            uri.setFlags(268435456);
            context.startActivity(uri);
            return true;
        } catch (java.lang.Exception e) {
            android.util.Log.e(TAG, "openDeepLink exception: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public static void openStreamApp(android.content.Context context, java.lang.String str, org.json.JSONObject jSONObject, int i, java.lang.String str2) {
        boolean z;
        try {
            android.content.Intent intent = new android.content.Intent();
            intent.putExtra(io.dcloud.common.constant.IntentConst.START_FROM, i);
            intent.setAction("android.intent.action.MAIN");
            if (android.text.TextUtils.isEmpty(str2)) {
                if (io.dcloud.common.util.BaseInfo.existsStreamEnv()) {
                    intent.setClassName(context.getPackageName(), "io.dcloud.appstream.StreamAppMainActivity");
                }
            } else if ("com.qihoo.appstore".equals(str2)) {
                intent.setClassName(str2, "io.dcloud.appstream.StreamAppListFakeActivity");
            } else if ("com.aspire.mm".equals(str2)) {
                intent.setClassName(str2, "io.dcloud.StreamAppLauncherActivity");
            } else {
                intent.setClassName(str2, "io.dcloud.appstream.StreamAppMainActivity");
            }
            intent.putExtra("appid", str);
            boolean z2 = true;
            intent.putExtra(io.dcloud.common.constant.IntentConst.IS_STREAM_APP, true);
            if (jSONObject != null) {
                if (jSONObject.has("arguments")) {
                    intent.putExtra(io.dcloud.common.constant.IntentConst.EXTRAS, jSONObject.opt("arguments").toString());
                    z = true;
                } else {
                    z = false;
                }
                if (jSONObject.has("richurl")) {
                    intent.putExtra(io.dcloud.common.constant.IntentConst.DIRECT_PAGE, jSONObject.optString("richurl"));
                    intent.putExtra(io.dcloud.common.constant.IntentConst.IS_START_FIRST_WEB, true);
                } else {
                    z2 = z;
                }
                if (z2) {
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                    jSONObject2.put("action", io.dcloud.common.constant.AbsoluteConst.XML_APP);
                    jSONObject2.put("parameters", jSONObject);
                    intent.putExtra("rules_msg", jSONObject2.toString());
                }
            }
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (java.lang.Exception e) {
            android.util.Log.e(TAG, "openStreamApp exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void openUrl(android.content.Context context, java.lang.String str) {
        try {
            android.content.Intent intent = new android.content.Intent();
            intent.setClass(context, io.dcloud.WebviewActivity.class);
            intent.putExtra("url", str);
            intent.setData(android.net.Uri.parse(str));
            intent.setAction("android.intent.action.VIEW");
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (java.lang.Exception e) {
            android.util.Log.e(TAG, "openUrl exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static org.json.JSONObject removeDownlaodData(android.content.Context context, long j) {
        android.content.SharedPreferences orCreateBundle = io.dcloud.common.adapter.util.SP.getOrCreateBundle(context, io.dcloud.common.constant.AbsoluteConst.AD_DOWNLOAD_DATA);
        java.lang.String downloadDataKey = getDownloadDataKey(j);
        java.lang.String string = orCreateBundle.getString(downloadDataKey, "");
        orCreateBundle.edit().remove(downloadDataKey).commit();
        try {
            return new org.json.JSONObject(string);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static org.json.JSONObject removeLoadAppData(android.content.Context context, java.lang.String str) {
        org.json.JSONObject jSONObject;
        android.content.SharedPreferences orCreateBundle = io.dcloud.common.adapter.util.SP.getOrCreateBundle(context, io.dcloud.common.constant.AbsoluteConst.AD_INSTALL_DATA);
        java.lang.String loadAppDataKey = getLoadAppDataKey(str);
        java.lang.String string = orCreateBundle.getString(loadAppDataKey, "");
        if (android.text.TextUtils.isEmpty(string)) {
            jSONObject = null;
        } else {
            try {
                jSONObject = new org.json.JSONObject(string);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
                jSONObject = null;
            }
        }
        orCreateBundle.edit().remove(loadAppDataKey).commit();
        return jSONObject;
    }

    public static void saveLoadAppData(final android.content.Context context, final java.lang.String str, final java.lang.String str2, final java.lang.String str3, final java.lang.String str4, final java.lang.String str5, final java.lang.String str6) {
        io.dcloud.common.util.ThreadPool.self().addThreadTask(new java.lang.Runnable() { // from class: io.dcloud.common.util.ADUtils.2
            @Override // java.lang.Runnable
            public void run() {
                android.content.SharedPreferences orCreateBundle = io.dcloud.common.adapter.util.SP.getOrCreateBundle(context, io.dcloud.common.constant.AbsoluteConst.AD_INSTALL_DATA);
                java.lang.String loadAppDataKey = io.dcloud.common.util.ADUtils.getLoadAppDataKey(str);
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                try {
                    if (io.dcloud.common.util.PdrUtil.isEmpty(str)) {
                        android.content.pm.PackageInfo apkInfo = io.dcloud.common.adapter.util.PlatformUtil.parseApkInfo(context, str5);
                        if (apkInfo == null) {
                            return;
                        }
                        jSONObject.put("packName", apkInfo.packageName);
                        loadAppDataKey = io.dcloud.common.util.ADUtils.getLoadAppDataKey(apkInfo.packageName);
                    } else {
                        jSONObject.put("packName", str);
                    }
                    jSONObject.put("appid", str2);
                    jSONObject.put("tid", str3);
                    jSONObject.put("adid", str4);
                    jSONObject.put("ua", str6);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
                orCreateBundle.edit().putString(loadAppDataKey, jSONObject.toString()).commit();
            }
        });
    }

    public static void saveLoadData(io.dcloud.common.util.ADUtils.ADLoadData aDLoadData) throws java.lang.Exception {
        android.content.SharedPreferences orCreateBundle = io.dcloud.common.adapter.util.SP.getOrCreateBundle(io.dcloud.common.constant.AbsoluteConst.AD_DOWNLOAD_DATA);
        java.lang.String downloadDataKey = getDownloadDataKey(aDLoadData.id);
        if (android.text.TextUtils.isEmpty(orCreateBundle.getString(downloadDataKey, ""))) {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("name", aDLoadData.name);
            jSONObject.put("url", aDLoadData.url);
            jSONObject.put("pname", aDLoadData.pname);
            jSONObject.put("id", aDLoadData.id);
            jSONObject.put("expiresTime", aDLoadData.expiresTime);
            jSONObject.put("tid", aDLoadData.tid);
            jSONObject.put("appid", aDLoadData.appid);
            jSONObject.put("adid", aDLoadData.adid);
            jSONObject.put("type", aDLoadData.type);
            jSONObject.put("ua", aDLoadData.ua);
            orCreateBundle.edit().putString(downloadDataKey, jSONObject.toString()).commit();
        }
    }
}
