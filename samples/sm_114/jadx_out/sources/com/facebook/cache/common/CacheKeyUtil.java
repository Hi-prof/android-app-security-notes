package com.facebook.cache.common;

/* JADX INFO: compiled from: CacheKeyUtil.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\u000b"}, d2 = {"Lcom/facebook/cache/common/CacheKeyUtil;", "", "<init>", "()V", "getResourceIds", "", "", io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_KEY, "Lcom/facebook/cache/common/CacheKey;", "getFirstResourceId", "secureHashKey", "imagepipeline-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CacheKeyUtil {
    public static final com.facebook.cache.common.CacheKeyUtil INSTANCE = new com.facebook.cache.common.CacheKeyUtil();

    private CacheKeyUtil() {
    }

    @kotlin.jvm.JvmStatic
    public static final java.util.List<java.lang.String> getResourceIds(com.facebook.cache.common.CacheKey key) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        try {
            if (key instanceof com.facebook.cache.common.MultiCacheKey) {
                java.util.List<com.facebook.cache.common.CacheKey> cacheKeys = ((com.facebook.cache.common.MultiCacheKey) key).getCacheKeys();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(cacheKeys, "getCacheKeys(...)");
                java.util.ArrayList arrayList = new java.util.ArrayList(cacheKeys.size());
                int size = cacheKeys.size();
                for (int i = 0; i < size; i++) {
                    com.facebook.cache.common.CacheKeyUtil cacheKeyUtil = INSTANCE;
                    com.facebook.cache.common.CacheKey cacheKey = cacheKeys.get(i);
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(cacheKey, "get(...)");
                    arrayList.add(cacheKeyUtil.secureHashKey(cacheKey));
                }
                return arrayList;
            }
            java.util.ArrayList arrayList2 = new java.util.ArrayList(1);
            arrayList2.add(key.isResourceIdForDebugging() ? key.getUriString() : INSTANCE.secureHashKey(key));
            return arrayList2;
        } catch (java.io.UnsupportedEncodingException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.String getFirstResourceId(com.facebook.cache.common.CacheKey key) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
        try {
            if (key instanceof com.facebook.cache.common.MultiCacheKey) {
                java.util.List<com.facebook.cache.common.CacheKey> cacheKeys = ((com.facebook.cache.common.MultiCacheKey) key).getCacheKeys();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(cacheKeys, "getCacheKeys(...)");
                com.facebook.cache.common.CacheKeyUtil cacheKeyUtil = INSTANCE;
                com.facebook.cache.common.CacheKey cacheKey = cacheKeys.get(0);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(cacheKey, "get(...)");
                return cacheKeyUtil.secureHashKey(cacheKey);
            }
            return INSTANCE.secureHashKey(key);
        } catch (java.io.UnsupportedEncodingException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    private final java.lang.String secureHashKey(com.facebook.cache.common.CacheKey key) throws java.io.UnsupportedEncodingException {
        java.lang.String uriString = key.getUriString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(uriString, "getUriString(...)");
        java.nio.charset.Charset charsetForName = java.nio.charset.Charset.forName("UTF-8");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
        byte[] bytes = uriString.getBytes(charsetForName);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        java.lang.String strMakeSHA1HashBase64 = com.facebook.common.util.SecureHashUtil.makeSHA1HashBase64(bytes);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strMakeSHA1HashBase64, "makeSHA1HashBase64(...)");
        return strMakeSHA1HashBase64;
    }
}
