package com.facebook.common.media;

/* JADX INFO: loaded from: classes.dex */
public class MimeTypeMapWrapper {
    private static final android.webkit.MimeTypeMap sMimeTypeMap = android.webkit.MimeTypeMap.getSingleton();
    private static final java.util.Map<java.lang.String, java.lang.String> sMimeTypeToExtensionMap = com.facebook.common.internal.ImmutableMap.of("image/heif", "heif", "image/heic", "heic");
    private static final java.util.Map<java.lang.String, java.lang.String> sExtensionToMimeTypeMap = com.facebook.common.internal.ImmutableMap.of("heif", "image/heif", "heic", "image/heic");

    public static java.lang.String getExtensionFromMimeType(java.lang.String str) {
        java.lang.String str2 = sMimeTypeToExtensionMap.get(str);
        return str2 != null ? str2 : sMimeTypeMap.getExtensionFromMimeType(str);
    }

    public static java.lang.String getMimeTypeFromExtension(java.lang.String str) {
        java.lang.String str2 = sExtensionToMimeTypeMap.get(str);
        return str2 != null ? str2 : sMimeTypeMap.getMimeTypeFromExtension(str);
    }

    public static boolean hasExtension(java.lang.String str) {
        return sExtensionToMimeTypeMap.containsKey(str) || sMimeTypeMap.hasExtension(str);
    }

    public static boolean hasMimeType(java.lang.String str) {
        return sMimeTypeToExtensionMap.containsKey(str) || sMimeTypeMap.hasMimeType(str);
    }
}
