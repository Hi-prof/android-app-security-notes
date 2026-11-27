package com.nostra13.dcloudimageloader.core.assist;

/* JADX INFO: loaded from: classes.dex */
public final class DiscCacheUtil {
    private DiscCacheUtil() {
    }

    public static java.io.File findInCache(java.lang.String str, com.nostra13.dcloudimageloader.cache.disc.DiscCacheAware discCacheAware) {
        java.io.File file = discCacheAware.get(str);
        if (file.exists()) {
            return file;
        }
        return null;
    }

    public static boolean removeFromCache(java.lang.String str, com.nostra13.dcloudimageloader.cache.disc.DiscCacheAware discCacheAware) {
        return discCacheAware.get(str).delete();
    }
}
