package com.facebook.drawee.components;

/* JADX INFO: loaded from: classes.dex */
class DeferredReleaserConcurrentImpl extends com.facebook.drawee.components.DeferredReleaser {
    private final java.lang.Object mLock = new java.lang.Object();
    private final java.lang.Runnable releaseRunnable = new java.lang.Runnable() { // from class: com.facebook.drawee.components.DeferredReleaserConcurrentImpl.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (com.facebook.drawee.components.DeferredReleaserConcurrentImpl.this.mLock) {
                java.util.ArrayList arrayList = com.facebook.drawee.components.DeferredReleaserConcurrentImpl.this.mTempList;
                com.facebook.drawee.components.DeferredReleaserConcurrentImpl deferredReleaserConcurrentImpl = com.facebook.drawee.components.DeferredReleaserConcurrentImpl.this;
                deferredReleaserConcurrentImpl.mTempList = deferredReleaserConcurrentImpl.mPendingReleasables;
                com.facebook.drawee.components.DeferredReleaserConcurrentImpl.this.mPendingReleasables = arrayList;
            }
            int size = com.facebook.drawee.components.DeferredReleaserConcurrentImpl.this.mTempList.size();
            for (int i = 0; i < size; i++) {
                ((com.facebook.drawee.components.DeferredReleaser.Releasable) com.facebook.drawee.components.DeferredReleaserConcurrentImpl.this.mTempList.get(i)).release();
            }
            com.facebook.drawee.components.DeferredReleaserConcurrentImpl.this.mTempList.clear();
        }
    };
    private java.util.ArrayList<com.facebook.drawee.components.DeferredReleaser.Releasable> mPendingReleasables = new java.util.ArrayList<>();
    private java.util.ArrayList<com.facebook.drawee.components.DeferredReleaser.Releasable> mTempList = new java.util.ArrayList<>();
    private final android.os.Handler mUiHandler = new android.os.Handler(android.os.Looper.getMainLooper());

    @Override // com.facebook.drawee.components.DeferredReleaser
    public void scheduleDeferredRelease(com.facebook.drawee.components.DeferredReleaser.Releasable releasable) {
        if (!isOnUiThread()) {
            releasable.release();
            return;
        }
        synchronized (this.mLock) {
            if (this.mPendingReleasables.contains(releasable)) {
                return;
            }
            this.mPendingReleasables.add(releasable);
            boolean z = true;
            if (this.mPendingReleasables.size() != 1) {
                z = false;
            }
            if (z) {
                this.mUiHandler.post(this.releaseRunnable);
            }
        }
    }

    @Override // com.facebook.drawee.components.DeferredReleaser
    public void cancelDeferredRelease(com.facebook.drawee.components.DeferredReleaser.Releasable releasable) {
        synchronized (this.mLock) {
            this.mPendingReleasables.remove(releasable);
        }
    }
}
