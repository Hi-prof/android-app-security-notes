package com.bumptech.glide.load.resource;

/* JADX INFO: loaded from: classes.dex */
public class SimpleResource<T> implements com.bumptech.glide.load.engine.Resource<T> {
    protected final T data;

    @Override // com.bumptech.glide.load.engine.Resource
    public final int getSize() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
    }

    public SimpleResource(T t) {
        this.data = (T) com.bumptech.glide.util.Preconditions.checkNotNull(t);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public java.lang.Class<T> getResourceClass() {
        return (java.lang.Class<T>) this.data.getClass();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final T get() {
        return this.data;
    }
}
