package com.bumptech.glide.manager;

/* JADX INFO: loaded from: classes.dex */
final class FirstFrameWaiter implements com.bumptech.glide.manager.FrameWaiter {
    volatile boolean isFirstFrameSet;
    final java.util.Set<android.app.Activity> pendingActivities = java.util.Collections.newSetFromMap(new java.util.WeakHashMap());

    FirstFrameWaiter() {
    }

    @Override // com.bumptech.glide.manager.FrameWaiter
    public void registerSelf(android.app.Activity activity) {
        if (!this.isFirstFrameSet && this.pendingActivities.add(activity)) {
            final android.view.View decorView = activity.getWindow().getDecorView();
            decorView.getViewTreeObserver().addOnDrawListener(new android.view.ViewTreeObserver.OnDrawListener() { // from class: com.bumptech.glide.manager.FirstFrameWaiter.1
                @Override // android.view.ViewTreeObserver.OnDrawListener
                public void onDraw() {
                    com.bumptech.glide.util.Util.postOnUiThread(new java.lang.Runnable() { // from class: com.bumptech.glide.manager.FirstFrameWaiter.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.bumptech.glide.load.resource.bitmap.HardwareConfigState.getInstance().unblockHardwareBitmaps();
                            com.bumptech.glide.manager.FirstFrameWaiter.this.isFirstFrameSet = true;
                            com.bumptech.glide.manager.FirstFrameWaiter.removeListener(decorView, this);
                            com.bumptech.glide.manager.FirstFrameWaiter.this.pendingActivities.clear();
                        }
                    });
                }
            });
        }
    }

    static void removeListener(android.view.View view, android.view.ViewTreeObserver.OnDrawListener onDrawListener) {
        view.getViewTreeObserver().removeOnDrawListener(onDrawListener);
    }
}
