package io.dcloud.feature.gg.dcloud;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class ADSim {
    public static final int INTISPLSH = 10000;
    io.dcloud.feature.gg.dcloud.ADHandler.AdData mAdData = null;
    private android.content.Context mContext;
    org.json.JSONObject mData;
    android.os.Handler mHandler;

    public ADSim(android.content.Context context, org.json.JSONObject jSONObject) {
        this.mHandler = null;
        this.mData = jSONObject;
        this.mContext = context;
        this.mHandler = new android.os.Handler(context.getMainLooper()) { // from class: io.dcloud.feature.gg.dcloud.ADSim.1
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                super.handleMessage(message);
                if (message.what != 10000) {
                    return;
                }
                io.dcloud.feature.gg.dcloud.ADSim.this.initSimSplsh();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void click() {
        io.dcloud.feature.gg.dcloud.ADHandler.log("adh", "ADSim---click");
        android.content.Context context = this.mContext;
        io.dcloud.feature.gg.dcloud.ADHandler.click(context, this.mAdData, io.dcloud.feature.gg.dcloud.ADHandler.get(context, "adid"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public io.dcloud.feature.gg.dcloud.ADHandler.AdData crateAdData(org.json.JSONObject jSONObject) {
        io.dcloud.feature.gg.dcloud.ADHandler.AdData adData = new io.dcloud.feature.gg.dcloud.ADHandler.AdData();
        org.json.JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
        if (jSONObjectOptJSONObject != null) {
            adData.mProvider = jSONObject.optString("provider");
            adData.mJsonData = jSONObject;
            adData.mEShow = jSONObject.optInt("es", 0);
            adData.mEClick = jSONObject.optInt("ec", 0);
            adData.mImgSrc = jSONObjectOptJSONObject.optString("src");
            adData.mImgData = "000";
            adData.mOriginalAppid = io.dcloud.feature.gg.dcloud.ADHandler.get("appid");
        }
        return adData;
    }

    public static void dwApp(final android.content.Context context, final java.lang.String str, final java.lang.String str2, final java.lang.String str3, java.lang.String str4, java.lang.String str5, io.dcloud.common.DHInterface.ILoadCallBack iLoadCallBack, final java.lang.String str6) {
        io.dcloud.common.util.ADUtils.downloadCommit(context, str, str2, str3, 29, null, null, str6);
        final com.dcloud.android.downloader.callback.DCDownloadManager downloadManager = com.dcloud.android.downloader.DownloadService.getDownloadManager(context.getApplicationContext());
        java.lang.String str7 = io.dcloud.common.adapter.util.DeviceInfo.sDeviceRootDir + "/Download/ADSIM-INFO.io";
        java.io.File file = new java.io.File(str7);
        if (file.exists()) {
            file.delete();
        }
        for (com.dcloud.android.downloader.domain.DownloadInfo downloadInfo : downloadManager.findAllDownloading()) {
            if (downloadInfo.getUri().equals(str4)) {
                downloadManager.remove(downloadInfo);
            }
        }
        com.dcloud.android.downloader.domain.DownloadInfo downloadInfoBuild = new com.dcloud.android.downloader.domain.DownloadInfo.Builder().setUrl(str4).setPath(str7).build(context);
        if (iLoadCallBack != null) {
            downloadInfoBuild.setTag(iLoadCallBack);
        }
        downloadInfoBuild.setDownloadListener(new com.dcloud.android.downloader.callback.DownloadListener() { // from class: io.dcloud.feature.gg.dcloud.ADSim.5
            @Override // com.dcloud.android.downloader.callback.DownloadListener
            public void onDownloadFailed(com.dcloud.android.downloader.domain.DownloadInfo downloadInfo2, com.dcloud.android.downloader.exception.DownloadException downloadException) {
                io.dcloud.common.util.ADUtils.downloadCommit(context, str, str2, str3, 32, null, null, str6);
                java.io.File file2 = new java.io.File(downloadInfo2.getPath());
                if (file2.exists()) {
                    file2.delete();
                }
                downloadManager.remove(downloadInfo2);
            }

            @Override // com.dcloud.android.downloader.callback.DownloadListener
            public void onDownloadSuccess(com.dcloud.android.downloader.domain.DownloadInfo downloadInfo2) {
                if (downloadInfo2.getTag() != null && (downloadInfo2.getTag() instanceof io.dcloud.common.DHInterface.ILoadCallBack)) {
                    ((io.dcloud.common.DHInterface.ILoadCallBack) downloadInfo2.getTag()).onCallBack(0, downloadInfo2.getContext(), null);
                }
                io.dcloud.common.util.ADUtils.downloadCommit(context, str, str2, str3, 30, null, null, str6);
                java.io.File file2 = new java.io.File(downloadInfo2.getPath());
                if (file2.exists()) {
                    file2.delete();
                }
                downloadManager.remove(downloadInfo2);
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
        });
        downloadManager.download(downloadInfoBuild);
    }

    public static int getRandomInt(int i, int i2) {
        return (int) (((double) i) + (java.lang.Math.random() * ((double) ((i2 - i) + 1))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initAdImg(final java.lang.String str, final java.lang.String str2) {
        io.dcloud.common.util.ThreadPool.self().addThreadTask(new java.lang.Runnable() { // from class: io.dcloud.feature.gg.dcloud.ADSim.3
            @Override // java.lang.Runnable
            public void run() {
                java.util.HashMap map = new java.util.HashMap();
                if (!io.dcloud.common.util.PdrUtil.isEmpty(str2) && str2.equalsIgnoreCase("webview")) {
                    map.put(io.dcloud.common.DHInterface.IWebview.USER_AGENT, io.dcloud.feature.gg.dcloud.ADHandler.get("ua-webview"));
                }
                try {
                    if (io.dcloud.common.util.NetTool.httpGet(str, (java.util.HashMap<java.lang.String, java.lang.String>) map, true) != null) {
                        io.dcloud.feature.gg.dcloud.ADSim.this.mHandler.sendEmptyMessage(io.dcloud.feature.gg.dcloud.ADSim.INTISPLSH);
                    }
                } catch (java.lang.Exception unused) {
                }
            }
        });
    }

    private void initClick() {
        if (this.mAdData.isEClick()) {
            this.mHandler.postDelayed(new java.lang.Runnable() { // from class: io.dcloud.feature.gg.dcloud.ADSim.4
                @Override // java.lang.Runnable
                public void run() {
                    io.dcloud.feature.gg.dcloud.ADSim.this.click();
                }
            }, getRandomInt(800, 2000));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSimSplsh() {
        io.dcloud.feature.gg.dcloud.ADHandler.log("adh", "ADSim---view");
        android.content.Context context = this.mContext;
        io.dcloud.feature.gg.dcloud.ADHandler.view(context, this.mAdData, io.dcloud.feature.gg.dcloud.ADHandler.get(context, "adid"));
        initClick();
    }

    public static void openUrl(android.content.Context context, java.lang.String str) {
        io.dcloud.feature.gg.dcloud.ADHandler.log("adh", "ADSim---openUrl");
        new io.dcloud.feature.gg.dcloud.AolWebView(context).loadUrl(str);
    }

    public void start() {
        this.mHandler.postDelayed(new java.lang.Runnable() { // from class: io.dcloud.feature.gg.dcloud.ADSim.2
            @Override // java.lang.Runnable
            public void run() {
                io.dcloud.feature.gg.dcloud.ADSim aDSim = io.dcloud.feature.gg.dcloud.ADSim.this;
                aDSim.mAdData = aDSim.crateAdData(aDSim.mData);
                io.dcloud.feature.gg.dcloud.ADHandler.AdData adData = io.dcloud.feature.gg.dcloud.ADSim.this.mAdData;
                if (adData != null) {
                    java.lang.String strOptString = adData.full() != null ? io.dcloud.feature.gg.dcloud.ADSim.this.mAdData.full().optString("ua") : "";
                    io.dcloud.feature.gg.dcloud.ADSim aDSim2 = io.dcloud.feature.gg.dcloud.ADSim.this;
                    aDSim2.initAdImg(aDSim2.mAdData.mImgSrc, strOptString);
                }
            }
        }, getRandomInt(250, 350));
    }
}
