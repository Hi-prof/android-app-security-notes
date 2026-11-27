package com.facebook.common.memory;

/* JADX INFO: loaded from: classes.dex */
public interface Pool<V> extends com.facebook.common.references.ResourceReleaser<V>, com.facebook.common.memory.MemoryTrimmable {
    V get(int i);

    @Override // com.facebook.common.references.ResourceReleaser
    void release(V v);
}
