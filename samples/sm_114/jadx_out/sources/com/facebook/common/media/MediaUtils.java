package com.facebook.common.media;

/* JADX INFO: compiled from: MediaUtils.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\n\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0007J\u0014\u0010\f\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\r\u001a\u00020\u0006H\u0007J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\r\u001a\u00020\u0006H\u0002J\u0012\u0010\u000f\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\u0006H\u0007R\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/common/media/MediaUtils;", "", "<init>", "()V", "ADDITIONAL_ALLOWED_MIME_TYPES", "", "", "isPhoto", "", "mimeType", "isVideo", "isThreeD", "extractMime", io.dcloud.common.constant.AbsoluteConst.XML_PATH, "extractExtension", "isNonNativeSupportedMimeType", "fbcore_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MediaUtils {
    public static final com.facebook.common.media.MediaUtils INSTANCE = new com.facebook.common.media.MediaUtils();
    public static final java.util.Map<java.lang.String, java.lang.String> ADDITIONAL_ALLOWED_MIME_TYPES = kotlin.collections.MapsKt.mapOf(kotlin.TuplesKt.to("mkv", "video/x-matroska"), kotlin.TuplesKt.to("glb", "model/gltf-binary"));

    private MediaUtils() {
    }

    @kotlin.jvm.JvmStatic
    public static final boolean isPhoto(java.lang.String mimeType) {
        if (mimeType != null) {
            return kotlin.text.StringsKt.startsWith$default(mimeType, "image/", false, 2, (java.lang.Object) null);
        }
        return false;
    }

    @kotlin.jvm.JvmStatic
    public static final boolean isVideo(java.lang.String mimeType) {
        if (mimeType != null) {
            return kotlin.text.StringsKt.startsWith$default(mimeType, "video/", false, 2, (java.lang.Object) null);
        }
        return false;
    }

    @kotlin.jvm.JvmStatic
    public static final boolean isThreeD(java.lang.String mimeType) {
        return kotlin.jvm.internal.Intrinsics.areEqual(mimeType, "model/gltf-binary");
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.String extractMime(java.lang.String path) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(path, "path");
        java.lang.String strExtractExtension = INSTANCE.extractExtension(path);
        if (strExtractExtension == null) {
            return null;
        }
        java.util.Locale US = java.util.Locale.US;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(US, "US");
        java.lang.String lowerCase = strExtractExtension.toLowerCase(US);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (lowerCase == null) {
            return null;
        }
        java.lang.String mimeTypeFromExtension = com.facebook.common.media.MimeTypeMapWrapper.getMimeTypeFromExtension(lowerCase);
        return mimeTypeFromExtension == null ? ADDITIONAL_ALLOWED_MIME_TYPES.get(lowerCase) : mimeTypeFromExtension;
    }

    private final java.lang.String extractExtension(java.lang.String path) {
        int iLastIndexOf$default = kotlin.text.StringsKt.lastIndexOf$default((java.lang.CharSequence) path, com.taobao.weex.el.parse.Operators.DOT, 0, false, 6, (java.lang.Object) null);
        if (iLastIndexOf$default < 0 || iLastIndexOf$default == path.length() - 1) {
            return null;
        }
        java.lang.String strSubstring = path.substring(iLastIndexOf$default + 1);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    @kotlin.jvm.JvmStatic
    public static final boolean isNonNativeSupportedMimeType(java.lang.String mimeType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        return ADDITIONAL_ALLOWED_MIME_TYPES.containsValue(mimeType);
    }
}
