package com.bumptech.glide.request;

/* JADX INFO: loaded from: classes.dex */
@java.lang.Deprecated
public abstract class ExperimentalRequestListener<ResourceT> implements com.bumptech.glide.request.RequestListener<ResourceT> {
    public void onRequestStarted(java.lang.Object obj) {
    }

    public abstract boolean onResourceReady(ResourceT resourcet, java.lang.Object obj, com.bumptech.glide.request.target.Target<ResourceT> target, com.bumptech.glide.load.DataSource dataSource, boolean z, boolean z2);
}
