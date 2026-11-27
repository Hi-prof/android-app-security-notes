package com.bumptech.glide.manager;

/* JADX INFO: loaded from: classes.dex */
final class DefaultConnectivityMonitor implements com.bumptech.glide.manager.ConnectivityMonitor {
    private final android.content.Context context;
    final com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener listener;

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    DefaultConnectivityMonitor(android.content.Context context, com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener connectivityListener) {
        this.context = context.getApplicationContext();
        this.listener = connectivityListener;
    }

    private void register() {
        com.bumptech.glide.manager.SingletonConnectivityReceiver.get(this.context).register(this.listener);
    }

    private void unregister() {
        com.bumptech.glide.manager.SingletonConnectivityReceiver.get(this.context).unregister(this.listener);
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        register();
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        unregister();
    }
}
