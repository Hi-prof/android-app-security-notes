package com.bumptech.glide.load.resource.transcode;

/* JADX INFO: loaded from: classes.dex */
public interface ResourceTranscoder<Z, R> {
    com.bumptech.glide.load.engine.Resource<R> transcode(com.bumptech.glide.load.engine.Resource<Z> resource, com.bumptech.glide.load.Options options);
}
