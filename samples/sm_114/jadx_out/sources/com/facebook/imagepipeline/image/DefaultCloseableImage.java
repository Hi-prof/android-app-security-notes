package com.facebook.imagepipeline.image;

/* JADX INFO: loaded from: classes.dex */
public abstract class DefaultCloseableImage extends com.facebook.imagepipeline.image.BaseCloseableImage {
    private static final java.lang.String TAG = "CloseableImage";

    protected void finalize() throws java.lang.Throwable {
        if (isClosed()) {
            return;
        }
        com.facebook.common.logging.FLog.w(TAG, "finalize: %s %x still open.", getClass().getSimpleName(), java.lang.Integer.valueOf(java.lang.System.identityHashCode(this)));
        try {
            close();
        } finally {
            super.finalize();
        }
    }
}
