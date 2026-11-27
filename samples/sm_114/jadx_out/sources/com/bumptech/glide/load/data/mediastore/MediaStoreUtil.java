package com.bumptech.glide.load.data.mediastore;

/* JADX INFO: loaded from: classes.dex */
public final class MediaStoreUtil {
    private static final int MINI_THUMB_HEIGHT = 384;
    private static final int MINI_THUMB_WIDTH = 512;

    public static boolean isThumbnailSize(int i, int i2) {
        return i != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE && i <= 512 && i2 <= 384;
    }

    private MediaStoreUtil() {
    }

    public static boolean isMediaStoreUri(android.net.Uri uri) {
        return uri != null && com.facebook.common.util.UriUtil.LOCAL_CONTENT_SCHEME.equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    public static boolean isAndroidPickerUri(android.net.Uri uri) {
        return isMediaStoreUri(uri) && uri.getPathSegments().contains("picker");
    }

    private static boolean isVideoUri(android.net.Uri uri) {
        return uri.getPathSegments().contains("video");
    }

    public static boolean isMediaStoreVideoUri(android.net.Uri uri) {
        return isMediaStoreUri(uri) && isVideoUri(uri);
    }

    public static boolean isMediaStoreImageUri(android.net.Uri uri) {
        return isMediaStoreUri(uri) && !isVideoUri(uri);
    }
}
