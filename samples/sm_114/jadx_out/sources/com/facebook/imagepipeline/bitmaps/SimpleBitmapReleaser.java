package com.facebook.imagepipeline.bitmaps;

/* JADX INFO: loaded from: classes.dex */
public class SimpleBitmapReleaser implements com.facebook.common.references.ResourceReleaser<android.graphics.Bitmap> {
    private static com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser sInstance;

    public static com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser getInstance() {
        if (sInstance == null) {
            sInstance = new com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser();
        }
        return sInstance;
    }

    private SimpleBitmapReleaser() {
    }

    @Override // com.facebook.common.references.ResourceReleaser
    public void release(android.graphics.Bitmap bitmap) {
        bitmap.recycle();
    }
}
