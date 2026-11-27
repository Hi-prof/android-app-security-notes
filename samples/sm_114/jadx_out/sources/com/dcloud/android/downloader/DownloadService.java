package com.dcloud.android.downloader;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class DownloadService extends android.app.Service {
    private static final java.lang.String TAG = "DownloadService";
    public static com.dcloud.android.downloader.callback.DCDownloadManager downloadManager;

    public static com.dcloud.android.downloader.callback.DCDownloadManager getDownloadManager(android.content.Context context) {
        return getDownloadManager(context, null);
    }

    private static boolean isServiceRunning(android.content.Context context) {
        java.util.List<android.app.ActivityManager.RunningServiceInfo> runningServices = ((android.app.ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
        if (runningServices != null && runningServices.size() != 0) {
            for (int i = 0; i < runningServices.size(); i++) {
                if (runningServices.get(i).service.getClassName().equals(com.dcloud.android.downloader.DownloadService.class.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        com.dcloud.android.downloader.callback.DCDownloadManager dCDownloadManager = downloadManager;
        if (dCDownloadManager != null) {
            dCDownloadManager.onDestroy();
            downloadManager = null;
        }
        super.onDestroy();
    }

    public static com.dcloud.android.downloader.callback.DCDownloadManager getDownloadManager(android.content.Context context, com.dcloud.android.downloader.config.Config config) {
        if (!isServiceRunning(context)) {
            context.startService(new android.content.Intent(context, (java.lang.Class<?>) com.dcloud.android.downloader.DownloadService.class));
        }
        if (downloadManager == null) {
            downloadManager = com.dcloud.android.downloader.DownloadManagerImpl.getInstance(context, config);
        }
        return downloadManager;
    }
}
