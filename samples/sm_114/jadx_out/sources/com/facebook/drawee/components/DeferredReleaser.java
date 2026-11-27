package com.facebook.drawee.components;

/* JADX INFO: loaded from: classes.dex */
public abstract class DeferredReleaser {

    @javax.annotation.Nullable
    private static com.facebook.drawee.components.DeferredReleaser sInstance;

    public interface Releasable {
        void release();
    }

    public abstract void cancelDeferredRelease(com.facebook.drawee.components.DeferredReleaser.Releasable releasable);

    public abstract void scheduleDeferredRelease(com.facebook.drawee.components.DeferredReleaser.Releasable releasable);

    public static synchronized com.facebook.drawee.components.DeferredReleaser getInstance() {
        if (sInstance == null) {
            sInstance = new com.facebook.drawee.components.DeferredReleaserConcurrentImpl();
        }
        return sInstance;
    }

    static boolean isOnUiThread() {
        return android.os.Looper.getMainLooper().getThread() == java.lang.Thread.currentThread();
    }
}
