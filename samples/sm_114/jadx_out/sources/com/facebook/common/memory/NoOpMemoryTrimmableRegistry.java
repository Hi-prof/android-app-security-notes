package com.facebook.common.memory;

/* JADX INFO: loaded from: classes.dex */
public class NoOpMemoryTrimmableRegistry implements com.facebook.common.memory.MemoryTrimmableRegistry {

    @javax.annotation.Nullable
    private static com.facebook.common.memory.NoOpMemoryTrimmableRegistry sInstance;

    @Override // com.facebook.common.memory.MemoryTrimmableRegistry
    public void registerMemoryTrimmable(com.facebook.common.memory.MemoryTrimmable memoryTrimmable) {
    }

    @Override // com.facebook.common.memory.MemoryTrimmableRegistry
    public void unregisterMemoryTrimmable(com.facebook.common.memory.MemoryTrimmable memoryTrimmable) {
    }

    public static synchronized com.facebook.common.memory.NoOpMemoryTrimmableRegistry getInstance() {
        if (sInstance == null) {
            sInstance = new com.facebook.common.memory.NoOpMemoryTrimmableRegistry();
        }
        return sInstance;
    }
}
