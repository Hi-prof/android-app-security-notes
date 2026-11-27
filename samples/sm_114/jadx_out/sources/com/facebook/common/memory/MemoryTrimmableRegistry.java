package com.facebook.common.memory;

/* JADX INFO: loaded from: classes.dex */
public interface MemoryTrimmableRegistry {
    void registerMemoryTrimmable(com.facebook.common.memory.MemoryTrimmable memoryTrimmable);

    void unregisterMemoryTrimmable(com.facebook.common.memory.MemoryTrimmable memoryTrimmable);
}
