package io.dcloud.common.core.a;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final java.lang.String TAG = "IDBridge";

    private static io.dcloud.common.DHInterface.IApp getApp() {
        return (io.dcloud.common.DHInterface.IApp) io.dcloud.EntryProxy.getInstnace().getCoreHandler().dispatchEvent(io.dcloud.common.DHInterface.IMgr.MgrType.AppMgr, 28, io.dcloud.common.util.BaseInfo.sDefaultBootApp);
    }

    public static java.lang.String gd() {
        io.dcloud.common.DHInterface.IApp app = getApp();
        if (app == null) {
            return "";
        }
        java.util.HashMap map = new java.util.HashMap(io.dcloud.common.util.TestUtil.PointTime.gsd(app, io.dcloud.common.adapter.util.SP.getOrCreateBundle(app.getActivity(), io.dcloud.common.constant.AbsoluteConst.START_STATISTICS_DATA)));
        try {
            map.put("ps", java.lang.Integer.valueOf(io.dcloud.common.util.BaseInfo.existsStreamEnv() ? 1 : 0));
            map.put("psd", java.lang.Integer.valueOf(io.dcloud.common.util.BaseInfo.ISDEBUG ? 1 : 0));
            map.put("paid", app.obtainConfigProperty("adid"));
            org.json.JSONObject jSONObjectObtainThridInfo = app.obtainThridInfo(io.dcloud.common.DHInterface.IApp.ConfigProperty.ThridInfo.URDJsonData);
            map.put("urv", jSONObjectObtainThridInfo != null ? jSONObjectObtainThridInfo.optString("version") : "0.1");
            if (!android.text.TextUtils.isEmpty(io.dcloud.common.util.AppRuntime.getUniStatistics())) {
                map.put("us", io.dcloud.common.util.AppRuntime.getUniStatistics());
            }
        } catch (java.lang.Exception unused) {
        }
        while (map.values().remove(null)) {
        }
        while (map.values().remove("null")) {
        }
        return new org.json.JSONObject(map).toString();
    }

    public static void bc(java.lang.String str) {
        io.dcloud.common.adapter.util.SP.setBundleData("pdr", io.dcloud.common.adapter.util.SP.REPORT_UNI_VERIFY_GYUID, "");
        android.content.SharedPreferences orCreateBundle = io.dcloud.common.adapter.util.SP.getOrCreateBundle(io.dcloud.common.constant.AbsoluteConst.START_STATISTICS_DATA);
        if ((java.lang.System.currentTimeMillis() - orCreateBundle.getLong(io.dcloud.common.constant.AbsoluteConst.COMMIT_APP_LIST_TIME, 0L)) / 100000 >= 26000 && !io.dcloud.common.util.BaseInfo.isChannelGooglePlay() && ((!android.os.Build.MANUFACTURER.equalsIgnoreCase(io.dcloud.common.adapter.util.MobilePhoneModel.HUAWEI) || android.os.Build.VERSION.SDK_INT < 23 || io.dcloud.common.adapter.util.PlatformUtil.checkGTAndYoumeng()) && (android.text.TextUtils.isEmpty(io.dcloud.common.util.BaseInfo.sChannel) || !io.dcloud.common.util.BaseInfo.sChannel.endsWith("|xiaomi")))) {
            orCreateBundle.edit().putLong(io.dcloud.common.constant.AbsoluteConst.COMMIT_APP_LIST_TIME, java.lang.System.currentTimeMillis()).commit();
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            if (!jSONObject.isNull("ret") && jSONObject.optInt("ret") == 0 && com.taobao.weex.ui.module.WXModalUIModule.OK.equals(jSONObject.opt("desc")) && !jSONObject.isNull("did")) {
                io.dcloud.common.adapter.util.SP.setBundleData(io.dcloud.common.adapter.util.SP.getOrCreateBundle("pdr"), io.dcloud.common.adapter.util.SP.STARTUP_DEVICE_ID, jSONObject.optString("did"));
            }
            if (io.dcloud.common.util.BaseInfo.ISDEBUG || !jSONObject.has("urd")) {
                return;
            }
            java.lang.String strOptString = jSONObject.optString("urd");
            if (android.webkit.URLUtil.isNetworkUrl(strOptString)) {
                io.dcloud.common.adapter.io.DHFile.writeFile(io.dcloud.common.util.NetTool.httpGet(strOptString, false), 0, io.dcloud.common.util.BaseInfo.sURDFilePath);
            }
        } catch (org.json.JSONException e) {
            io.dcloud.common.adapter.util.Logger.p(TAG, e.getMessage());
        }
    }

    private static void notification(final org.json.JSONObject jSONObject) {
        final io.dcloud.common.DHInterface.IApp app = getApp();
        if (app == null) {
            return;
        }
        java.lang.String strOptString = jSONObject.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_ICON);
        if (android.text.TextUtils.isEmpty(strOptString) || !android.webkit.URLUtil.isNetworkUrl(strOptString)) {
            return;
        }
        com.nostra13.dcloudimageloader.core.ImageLoader.getInstance().loadImage(strOptString, new com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener() { // from class: io.dcloud.common.core.a.a.1
            @Override // com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener
            public void onLoadingStarted(java.lang.String str, android.view.View view) {
                java.lang.System.out.print(str);
            }

            @Override // com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener
            public void onLoadingFailed(java.lang.String str, android.view.View view, com.nostra13.dcloudimageloader.core.assist.FailReason failReason) {
                java.lang.System.out.print(str);
            }

            @Override // com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener
            public void onLoadingComplete(java.lang.String str, android.view.View view, android.graphics.Bitmap bitmap) {
                if (bitmap != null) {
                    java.lang.String strOptString2 = jSONObject.optString(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_TITLE);
                    java.lang.String strOptString3 = jSONObject.optString(com.facebook.common.util.UriUtil.LOCAL_CONTENT_SCHEME);
                    android.content.Intent intent = new android.content.Intent();
                    intent.putExtra("dcloud.push.broswer", io.dcloud.common.constant.AbsoluteConst.TRUE);
                    intent.setClassName(app.getActivity(), "io.dcloud.PandoraEntry");
                    intent.putExtra("__json__", jSONObject.toString());
                    intent.putExtra("appid", app.obtainAppId());
                    intent.putExtra("adid", app.obtainConfigProperty("adid"));
                    io.dcloud.common.util.NotificationUtil.createCustomNotification(app.getActivity(), strOptString2, bitmap, strOptString2, strOptString3, jSONObject.hashCode(), android.app.PendingIntent.getActivity(app.getActivity(), intent.hashCode(), intent, 1073741824));
                }
            }

            @Override // com.nostra13.dcloudimageloader.core.assist.ImageLoadingListener
            public void onLoadingCancelled(java.lang.String str, android.view.View view) {
                java.lang.System.out.print(str);
            }
        });
    }

    private static void hdwebview(org.json.JSONObject jSONObject) {
        io.dcloud.common.DHInterface.IApp app = getApp();
        if (app == null) {
            return;
        }
        app.obtainMgrData(io.dcloud.common.DHInterface.IMgr.MgrType.WindowMgr, 52, new java.lang.Object[]{app, jSONObject});
    }

    private static void downloadApk(org.json.JSONObject jSONObject) {
        io.dcloud.common.DHInterface.IApp app = getApp();
        if (app == null) {
            return;
        }
        try {
            java.lang.String strOptString = jSONObject.optString("url");
            java.lang.String strOptString2 = jSONObject.optString("tid");
            java.lang.String strOptString3 = jSONObject.optString("name");
            java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(strOptString).openConnection();
            long contentLength = httpURLConnection.getContentLength();
            if (contentLength < 1) {
                return;
            }
            java.io.File file = new java.io.File(io.dcloud.common.adapter.util.DeviceInfo.sDeviceRootDir + "/.system/apks/" + strOptString3);
            java.io.InputStream inputStream = httpURLConnection.getInputStream();
            if (file.exists() && file.length() < contentLength) {
                file.delete();
            } else if (file.exists() && file.length() == contentLength) {
                return;
            }
            io.dcloud.common.util.TestUtil.PointTime.commitTid(app.getActivity(), app.obtainAppId(), strOptString2, app.obtainConfigProperty("adid"), 29);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
            byte[] bArr = new byte[(int) java.lang.Math.min(contentLength, tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_TOP_FRONT_LEFT)];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    fileOutputStream.flush();
                    io.dcloud.common.util.TestUtil.PointTime.commitTid(app.getActivity(), app.obtainAppId(), strOptString2, app.obtainConfigProperty("adid"), 30);
                    return;
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
