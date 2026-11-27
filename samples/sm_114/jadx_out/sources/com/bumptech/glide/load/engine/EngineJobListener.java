package com.bumptech.glide.load.engine;

/* JADX INFO: loaded from: classes.dex */
interface EngineJobListener {
    void onEngineJobCancelled(com.bumptech.glide.load.engine.EngineJob<?> engineJob, com.bumptech.glide.load.Key key);

    void onEngineJobComplete(com.bumptech.glide.load.engine.EngineJob<?> engineJob, com.bumptech.glide.load.Key key, com.bumptech.glide.load.engine.EngineResource<?> engineResource);
}
