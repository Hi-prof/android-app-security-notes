package com.bumptech.glide.request.target;

/* JADX INFO: loaded from: classes.dex */
@java.lang.Deprecated
public abstract class BaseTarget<Z> implements com.bumptech.glide.request.target.Target<Z> {
    private com.bumptech.glide.request.Request request;

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(android.graphics.drawable.Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadFailed(android.graphics.drawable.Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadStarted(android.graphics.drawable.Drawable drawable) {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void setRequest(com.bumptech.glide.request.Request request) {
        this.request = request;
    }

    @Override // com.bumptech.glide.request.target.Target
    public com.bumptech.glide.request.Request getRequest() {
        return this.request;
    }
}
