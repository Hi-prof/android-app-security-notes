package com.nostra13.dcloudimageloader.core.assist;

/* JADX INFO: loaded from: classes.dex */
public final class MemoryCacheUtil {
    private static final java.lang.String URI_AND_SIZE_SEPARATOR = "_";
    private static final java.lang.String WIDTH_AND_HEIGHT_SEPARATOR = "x";

    private MemoryCacheUtil() {
    }

    public static java.lang.String generateKey(java.lang.String str, com.nostra13.dcloudimageloader.core.assist.ImageSize imageSize) {
        return str + "_" + imageSize.getWidth() + "x" + imageSize.getHeight();
    }

    public static java.util.Comparator<java.lang.String> createFuzzyKeyComparator() {
        return new java.util.Comparator<java.lang.String>() { // from class: com.nostra13.dcloudimageloader.core.assist.MemoryCacheUtil.1
            @Override // java.util.Comparator
            public int compare(java.lang.String str, java.lang.String str2) {
                return str.substring(0, str.lastIndexOf("_")).compareTo(str2.substring(0, str2.lastIndexOf("_")));
            }
        };
    }

    public static java.util.List<android.graphics.Bitmap> findCachedBitmapsForImageUri(java.lang.String str, com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware memoryCacheAware) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.String str2 : memoryCacheAware.keys()) {
            if (str2.startsWith(str)) {
                arrayList.add(memoryCacheAware.get(str2));
            }
        }
        return arrayList;
    }

    public static java.util.List<java.lang.String> findCacheKeysForImageUri(java.lang.String str, com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware memoryCacheAware) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.String str2 : memoryCacheAware.keys()) {
            if (str2.startsWith(str)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    public static void removeFromCache(java.lang.String str, com.nostra13.dcloudimageloader.cache.memory.MemoryCacheAware memoryCacheAware) {
        for (java.lang.String str2 : memoryCacheAware.keys()) {
            if (str2.startsWith(str)) {
                memoryCacheAware.remove(str2);
                return;
            }
        }
    }
}
