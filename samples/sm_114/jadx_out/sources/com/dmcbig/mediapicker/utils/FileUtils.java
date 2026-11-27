package com.dmcbig.mediapicker.utils;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class FileUtils {
    private static final java.lang.String EXTERNAL_STORAGE_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";
    private static final java.lang.String JPEG_FILE_PREFIX = "IMG_";
    private static final java.lang.String JPEG_FILE_SUFFIX = ".jpg";
    private static final long MB = 1048576;

    public static java.io.File createTmpFile(android.content.Context context) throws java.io.IOException {
        java.io.File cacheDirectory;
        if (android.text.TextUtils.equals(android.os.Environment.getExternalStorageState(), "mounted")) {
            cacheDirectory = android.os.Environment.getExternalStoragePublicDirectory(android.os.Environment.DIRECTORY_DCIM);
            if (!cacheDirectory.exists()) {
                cacheDirectory = android.os.Environment.getExternalStoragePublicDirectory(android.os.Environment.DIRECTORY_DCIM + "/Camera");
                if (!cacheDirectory.exists()) {
                    cacheDirectory = getCacheDirectory(context, true);
                }
            }
        } else {
            cacheDirectory = getCacheDirectory(context, true);
        }
        return java.io.File.createTempFile(JPEG_FILE_PREFIX, JPEG_FILE_SUFFIX, cacheDirectory);
    }

    public static java.lang.String fileSize(long j) {
        if (j <= 0) {
            return com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT;
        }
        double d = j;
        int iLog10 = (int) (java.lang.Math.log10(d) / java.lang.Math.log10(1024.0d));
        return new java.text.DecimalFormat("#,##0.#").format(d / java.lang.Math.pow(1024.0d, iLog10)) + com.taobao.weex.el.parse.Operators.SPACE_STR + new java.lang.String[]{"B", "kB", "MB", "GB", "TB"}[iLog10];
    }

    public static java.io.File getCacheDirectory(android.content.Context context) {
        return getCacheDirectory(context, true);
    }

    private static java.io.File getExternalCacheDir(android.content.Context context) {
        java.io.File file = new java.io.File(new java.io.File(new java.io.File(new java.io.File(android.os.Environment.getExternalStorageDirectory(), com.taobao.weex.utils.tools.TimeCalculator.PLATFORM_ANDROID), "data"), context.getPackageName()), io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_CACHE);
        if (!file.exists()) {
            if (!file.mkdirs()) {
                return null;
            }
            try {
                new java.io.File(file, ".nomedia").createNewFile();
            } catch (java.io.IOException unused) {
            }
        }
        return file;
    }

    public static java.io.File getIndividualCacheDirectory(android.content.Context context, java.lang.String str) {
        java.io.File cacheDirectory = getCacheDirectory(context);
        java.io.File file = new java.io.File(cacheDirectory, str);
        return (file.exists() || file.mkdir()) ? file : cacheDirectory;
    }

    public static java.lang.String getMimeType(android.content.Context context, android.net.Uri uri) {
        if (com.facebook.common.util.UriUtil.LOCAL_CONTENT_SCHEME.equals(uri.getScheme())) {
            java.lang.String extensionFromMimeType = android.webkit.MimeTypeMap.getSingleton().getExtensionFromMimeType(context.getContentResolver().getType(uri));
            return android.text.TextUtils.isEmpty(extensionFromMimeType) ? android.webkit.MimeTypeMap.getFileExtensionFromUrl(android.net.Uri.fromFile(new java.io.File(uri.getPath())).toString()) : extensionFromMimeType;
        }
        java.lang.String fileExtensionFromUrl = android.webkit.MimeTypeMap.getFileExtensionFromUrl(android.net.Uri.fromFile(new java.io.File(uri.getPath())).toString());
        return android.text.TextUtils.isEmpty(fileExtensionFromUrl) ? android.webkit.MimeTypeMap.getSingleton().getExtensionFromMimeType(context.getContentResolver().getType(uri)) : fileExtensionFromUrl;
    }

    public static java.lang.String getMimeTypeByFileName(java.lang.String str) {
        return str.substring(str.lastIndexOf(com.taobao.weex.el.parse.Operators.DOT_STR), str.length());
    }

    public static java.lang.String getRealPathFromURI(android.content.Context context, android.net.Uri uri) {
        android.database.Cursor cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
        if (cursorQuery == null) {
            return uri.getPath();
        }
        cursorQuery.moveToFirst();
        java.lang.String string = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
        cursorQuery.close();
        return string;
    }

    private static boolean hasExternalStoragePermission(android.content.Context context) {
        return context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public java.lang.String getSizeByUnit(double d) {
        if (d == 0.0d) {
            return "0K";
        }
        if (d >= 1048576.0d) {
            return java.lang.String.format(java.util.Locale.US, "%.1f", java.lang.Double.valueOf(d / 1048576.0d)) + "M";
        }
        return java.lang.String.format(java.util.Locale.US, "%.1f", java.lang.Double.valueOf(d / 1024.0d)) + "K";
    }

    public static java.io.File getCacheDirectory(android.content.Context context, boolean z) {
        java.lang.String externalStorageState = "";
        try {
            externalStorageState = android.os.Environment.getExternalStorageState();
        } catch (java.lang.IncompatibleClassChangeError | java.lang.NullPointerException unused) {
        }
        java.io.File externalCacheDir = (z && "mounted".equals(externalStorageState) && hasExternalStoragePermission(context)) ? getExternalCacheDir(context) : null;
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        if (externalCacheDir != null) {
            return externalCacheDir;
        }
        return new java.io.File("/data/data/" + context.getPackageName() + "/cache/");
    }
}
