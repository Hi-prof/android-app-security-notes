package com.facebook.imagepipeline.nativecode;

/* JADX INFO: loaded from: classes.dex */
public class NativeRoundingFilter {
    private static native void nativeAddRoundedCornersFilter(android.graphics.Bitmap bitmap, int i, int i2, int i3, int i4);

    private static native void nativeToCircleFastFilter(android.graphics.Bitmap bitmap, boolean z);

    private static native void nativeToCircleFilter(android.graphics.Bitmap bitmap, boolean z);

    private static native void nativeToCircleWithBorderFilter(android.graphics.Bitmap bitmap, int i, int i2, boolean z);

    static {
        com.facebook.imagepipeline.nativecode.NativeFiltersLoader.load();
    }

    public static void toCircle(android.graphics.Bitmap bitmap) {
        toCircle(bitmap, false);
    }

    public static void toCircleFast(android.graphics.Bitmap bitmap) {
        toCircleFast(bitmap, false);
    }

    public static void addRoundedCorners(android.graphics.Bitmap bitmap, int i, int i2, int i3, int i4) {
        nativeAddRoundedCornersFilter(bitmap, i, i2, i3, i4);
    }

    public static void toCircle(android.graphics.Bitmap bitmap, boolean z) {
        com.facebook.common.internal.Preconditions.checkNotNull(bitmap);
        if (bitmap.getWidth() < 3 || bitmap.getHeight() < 3) {
            return;
        }
        nativeToCircleFilter(bitmap, z);
    }

    public static void toCircleFast(android.graphics.Bitmap bitmap, boolean z) {
        com.facebook.common.internal.Preconditions.checkNotNull(bitmap);
        if (bitmap.getWidth() < 3 || bitmap.getHeight() < 3) {
            return;
        }
        nativeToCircleFastFilter(bitmap, z);
    }

    public static void toCircleWithBorder(android.graphics.Bitmap bitmap, int i, int i2, boolean z) {
        com.facebook.common.internal.Preconditions.checkNotNull(bitmap);
        if (bitmap.getWidth() < 3 || bitmap.getHeight() < 3) {
            return;
        }
        nativeToCircleWithBorderFilter(bitmap, i, i2, z);
    }
}
