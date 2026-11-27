package com.facebook.imageutils;

/* JADX INFO: compiled from: HeifExifUtil.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/facebook/imageutils/HeifExifUtil;", "", "<init>", "()V", "TAG", "", "getOrientation", "", "inputStream", "Ljava/io/InputStream;", "imagepipeline-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HeifExifUtil {
    public static final com.facebook.imageutils.HeifExifUtil INSTANCE = new com.facebook.imageutils.HeifExifUtil();
    private static final java.lang.String TAG = "HeifExifUtil";

    private HeifExifUtil() {
    }

    @kotlin.jvm.JvmStatic
    public static final int getOrientation(java.io.InputStream inputStream) {
        if (inputStream == null) {
            com.facebook.common.logging.FLog.d(TAG, "Trying to read Heif Exif from null inputStream -> ignoring");
            return 0;
        }
        try {
            return new androidx.exifinterface.media.ExifInterface(inputStream).getAttributeInt("Orientation", 1);
        } catch (java.io.IOException e) {
            com.facebook.common.logging.FLog.d(TAG, "Failed reading Heif Exif orientation -> ignoring", (java.lang.Throwable) e);
            return 0;
        }
    }
}
