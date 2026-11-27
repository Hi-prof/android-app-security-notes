package io.src.dcloud.adapter;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class DCloudAdapterUtil implements io.dcloud.common.DHInterface.IReflectAble {
    public static void Plugin2Host_closeAppStreamSplash(java.lang.String str) {
    }

    public static void Plugin2Host_finishActivity(java.lang.String str) {
    }

    public static java.lang.String getDcloudDownloadService() {
        return "io.dcloud.streamdownload.DownloadService";
    }

    public static java.lang.Class<?> getDownloadServiceClass() {
        try {
            return java.lang.Class.forName(getDcloudDownloadService());
        } catch (java.lang.ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static io.dcloud.common.DHInterface.IActivityHandler getIActivityHandler(android.app.Activity activity) {
        if (activity instanceof io.dcloud.common.DHInterface.IActivityHandler) {
            return (io.dcloud.common.DHInterface.IActivityHandler) activity;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static io.dcloud.common.DHInterface.IOnCreateSplashView getIOnCreateSplashView(android.app.Activity activity) {
        if (activity instanceof io.dcloud.common.DHInterface.IOnCreateSplashView) {
            return (io.dcloud.common.DHInterface.IOnCreateSplashView) activity;
        }
        return null;
    }

    public static int getImageOnLoadingId(android.content.Context context) {
        return io.dcloud.PdrR.STREAMAPP_DRAWABLE_APPDEFULTICON;
    }

    public static java.lang.String getPageName() {
        return "";
    }

    public static java.lang.String getRuntimeJsPath() {
        return io.dcloud.common.util.BaseInfo.sRuntimeJsPath;
    }

    public static android.content.SharedPreferences getSharedPreferences(android.content.Context context, java.lang.String str, int i) {
        return null;
    }

    public static boolean isAutoCreateShortCut(android.content.Context context) {
        return true;
    }

    public static boolean isPlugin() {
        return false;
    }
}
