package com.bumptech.glide.manager;

/* JADX INFO: loaded from: classes.dex */
final class LifecycleLifecycle implements com.bumptech.glide.manager.Lifecycle, androidx.lifecycle.LifecycleObserver {
    private final androidx.lifecycle.Lifecycle lifecycle;
    private final java.util.Set<com.bumptech.glide.manager.LifecycleListener> lifecycleListeners = new java.util.HashSet();

    LifecycleLifecycle(androidx.lifecycle.Lifecycle lifecycle) {
        this.lifecycle = lifecycle;
        lifecycle.addObserver(this);
    }

    @androidx.lifecycle.OnLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_START)
    public void onStart(androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        java.util.Iterator it = com.bumptech.glide.util.Util.getSnapshot(this.lifecycleListeners).iterator();
        while (it.hasNext()) {
            ((com.bumptech.glide.manager.LifecycleListener) it.next()).onStart();
        }
    }

    @androidx.lifecycle.OnLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_STOP)
    public void onStop(androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        java.util.Iterator it = com.bumptech.glide.util.Util.getSnapshot(this.lifecycleListeners).iterator();
        while (it.hasNext()) {
            ((com.bumptech.glide.manager.LifecycleListener) it.next()).onStop();
        }
    }

    @androidx.lifecycle.OnLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_DESTROY)
    public void onDestroy(androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        java.util.Iterator it = com.bumptech.glide.util.Util.getSnapshot(this.lifecycleListeners).iterator();
        while (it.hasNext()) {
            ((com.bumptech.glide.manager.LifecycleListener) it.next()).onDestroy();
        }
        lifecycleOwner.getLifecycle().removeObserver(this);
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void addListener(com.bumptech.glide.manager.LifecycleListener lifecycleListener) {
        this.lifecycleListeners.add(lifecycleListener);
        if (this.lifecycle.getCurrentState() == androidx.lifecycle.Lifecycle.State.DESTROYED) {
            lifecycleListener.onDestroy();
        } else if (this.lifecycle.getCurrentState().isAtLeast(androidx.lifecycle.Lifecycle.State.STARTED)) {
            lifecycleListener.onStart();
        } else {
            lifecycleListener.onStop();
        }
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void removeListener(com.bumptech.glide.manager.LifecycleListener lifecycleListener) {
        this.lifecycleListeners.remove(lifecycleListener);
    }
}
