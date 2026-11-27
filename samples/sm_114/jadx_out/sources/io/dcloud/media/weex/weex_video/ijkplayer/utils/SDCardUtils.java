package io.dcloud.media.weex.weex_video.ijkplayer.utils;

/* JADX INFO: loaded from: classes2.dex */
public class SDCardUtils {
    public static java.lang.String getState() {
        return android.os.Environment.getExternalStorageState();
    }

    public static boolean isAvailable() {
        return getState().equals("mounted");
    }

    public static java.io.File getRootDirectory() {
        if (isAvailable()) {
            return android.os.Environment.getExternalStorageDirectory();
        }
        return null;
    }

    public static java.lang.String getRootPath() {
        java.io.File rootDirectory = getRootDirectory();
        if (rootDirectory != null) {
            return rootDirectory.getPath();
        }
        return null;
    }

    public static java.lang.String getSDPath() {
        return (android.os.Environment.getExternalStorageState().equals("mounted") ? android.os.Environment.getExternalStorageDirectory() : null).toString();
    }

    public static long getFreeSpaceBytes(java.lang.String str) {
        return new android.os.StatFs(str).getAvailableBytes();
    }
}
