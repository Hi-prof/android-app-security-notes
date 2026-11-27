package com.facebook.imagepipeline.nativecode;

/* JADX INFO: loaded from: classes.dex */
public class NativeBlurFilter {
    private static native void nativeIterativeBoxBlur(android.graphics.Bitmap bitmap, int i, int i2);

    static {
        com.facebook.imagepipeline.nativecode.NativeFiltersLoader.load();
    }

    public static void iterativeBoxBlur(android.graphics.Bitmap bitmap, int i, int i2) {
        com.facebook.common.internal.Preconditions.checkNotNull(bitmap);
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(i > 0));
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(i2 > 0));
        nativeIterativeBoxBlur(bitmap, i, i2);
    }
}
