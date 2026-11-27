package io.dcloud.media.weex.weex_video.ijkplayer.utils;

/* JADX INFO: loaded from: classes2.dex */
public class VideoCacheUtil {
    private static final int CACHE_FOLDER_MAX_LIMIT = 104857600;
    private static final java.lang.String VIDEO_CACHE_FOLDER_NAME = "videoPlayer_CacheFiles";

    public static android.net.Uri cacheHttpUriWrap(android.net.Uri uri) {
        return android.net.Uri.parse("ijkio:cache:ffio:" + uri.toString());
    }

    public static java.lang.String getCacheFilePath(android.content.Context context, android.net.Uri uri) {
        if (context == null || uri == null) {
            return null;
        }
        java.io.File cacheRootFile = getCacheRootFile(context);
        return cacheRootFile.getPath() + java.io.File.separator + (java.lang.String.valueOf(uri.hashCode()) + ".videoCache");
    }

    public static java.lang.String getCacheMapFilePath(android.content.Context context, android.net.Uri uri) {
        if (context == null || uri == null) {
            return null;
        }
        java.io.File cacheRootFile = getCacheRootFile(context);
        return cacheRootFile.getPath() + java.io.File.separator + (java.lang.String.valueOf(uri.hashCode()) + ".videoCacheMap");
    }

    public static void cleanCacheIfNesscessary(android.content.Context context) {
        java.io.File cacheRootFile = getCacheRootFile(context);
        if (cacheRootFile.canRead()) {
            java.io.File[] fileArrListFiles = cacheRootFile.listFiles();
            long length = 0;
            for (java.io.File file : fileArrListFiles) {
                if (file.isFile()) {
                    length += file.length();
                }
                if (length >= com.facebook.common.statfs.StatFsHelper.DEFAULT_DISK_RED_LEVEL_IN_BYTES) {
                    for (java.io.File file2 : fileArrListFiles) {
                        file2.delete();
                    }
                    return;
                }
            }
        }
    }

    private static java.io.File getCacheRootFile(android.content.Context context) {
        java.io.File file = new java.io.File(context.getCacheDir().toString() + java.io.File.separator + VIDEO_CACHE_FOLDER_NAME);
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }
}
