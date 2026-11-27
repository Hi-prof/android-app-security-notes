package com.nostra13.dcloudimageloader.utils;

/* JADX INFO: loaded from: classes.dex */
public final class StorageUtils {
    private static final java.lang.String EXTERNAL_STORAGE_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";
    private static final java.lang.String INDIVIDUAL_DIR_NAME = "uil-images";

    private StorageUtils() {
    }

    public static java.io.File getCacheDirectory(android.content.Context context) {
        return getCacheDirectory(context, true);
    }

    public static java.io.File getCacheDirectory(android.content.Context context, boolean z) {
        java.io.File externalCacheDir = (z && "mounted".equals(android.os.Environment.getExternalStorageState()) && hasExternalStoragePermission(context)) ? getExternalCacheDir(context) : null;
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        if (externalCacheDir != null) {
            return externalCacheDir;
        }
        java.lang.String str = "/data/data/" + context.getPackageName() + "/cache/";
        com.nostra13.dcloudimageloader.utils.L.w("Can't define system cache directory! '%s' will be used.", str);
        return new java.io.File(str);
    }

    public static java.io.File getIndividualCacheDirectory(android.content.Context context) {
        java.io.File cacheDirectory = getCacheDirectory(context);
        java.io.File file = new java.io.File(cacheDirectory, INDIVIDUAL_DIR_NAME);
        return (file.exists() || file.mkdir()) ? file : cacheDirectory;
    }

    public static java.io.File getOwnCacheDirectory(android.content.Context context, java.lang.String str) {
        java.io.File file = ("mounted".equals(android.os.Environment.getExternalStorageState()) && hasExternalStoragePermission(context)) ? new java.io.File(android.os.Environment.getExternalStorageDirectory(), str) : null;
        return (file == null || !(file.exists() || file.mkdirs())) ? context.getCacheDir() : file;
    }

    private static java.io.File getExternalCacheDir(android.content.Context context) {
        java.io.File file = new java.io.File(new java.io.File(new java.io.File(new java.io.File(android.os.Environment.getExternalStorageDirectory(), com.taobao.weex.utils.tools.TimeCalculator.PLATFORM_ANDROID), "data"), context.getPackageName()), io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_CACHE);
        if (!file.exists()) {
            if (!file.mkdirs()) {
                com.nostra13.dcloudimageloader.utils.L.w("Unable to create external cache directory", new java.lang.Object[0]);
                return null;
            }
            try {
                new java.io.File(file, ".nomedia").createNewFile();
                return file;
            } catch (java.io.IOException unused) {
                com.nostra13.dcloudimageloader.utils.L.i("Can't create \".nomedia\" file in application external cache directory", new java.lang.Object[0]);
            }
        }
        return file;
    }

    private static boolean hasExternalStoragePermission(android.content.Context context) {
        return context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }
}
