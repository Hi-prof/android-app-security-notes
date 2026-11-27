package com.bumptech.glide.request;

/* JADX INFO: loaded from: classes.dex */
public interface RequestListener<R> {
    boolean onLoadFailed(com.bumptech.glide.load.engine.GlideException glideException, java.lang.Object obj, com.bumptech.glide.request.target.Target<R> target, boolean z);

    boolean onResourceReady(R r, java.lang.Object obj, com.bumptech.glide.request.target.Target<R> target, com.bumptech.glide.load.DataSource dataSource, boolean z);
}
