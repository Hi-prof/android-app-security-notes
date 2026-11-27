package com.facebook.imagepipeline.nativecode;

/* JADX INFO: loaded from: classes.dex */
public class Bitmaps {
    private static native void nativeCopyBitmap(android.graphics.Bitmap bitmap, int i, android.graphics.Bitmap bitmap2, int i2, int i3);

    static {
        com.facebook.imagepipeline.nativecode.ImagePipelineNativeLoader.load();
    }

    public static void copyBitmap(android.graphics.Bitmap bitmap, android.graphics.Bitmap bitmap2) {
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(bitmap2.getConfig() == bitmap.getConfig()));
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(bitmap.isMutable()));
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(bitmap.getWidth() == bitmap2.getWidth()));
        com.facebook.common.internal.Preconditions.checkArgument(java.lang.Boolean.valueOf(bitmap.getHeight() == bitmap2.getHeight()));
        nativeCopyBitmap(bitmap, bitmap.getRowBytes(), bitmap2, bitmap2.getRowBytes(), bitmap.getHeight());
    }
}
