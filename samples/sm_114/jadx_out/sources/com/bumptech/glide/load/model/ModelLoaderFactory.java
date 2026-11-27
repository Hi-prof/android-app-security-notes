package com.bumptech.glide.load.model;

/* JADX INFO: loaded from: classes.dex */
public interface ModelLoaderFactory<T, Y> {
    com.bumptech.glide.load.model.ModelLoader<T, Y> build(com.bumptech.glide.load.model.MultiModelLoaderFactory multiModelLoaderFactory);

    void teardown();
}
