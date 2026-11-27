package com.facebook.common.disk;

/* JADX INFO: loaded from: classes.dex */
public class NoOpDiskTrimmableRegistry implements com.facebook.common.disk.DiskTrimmableRegistry {

    @javax.annotation.Nullable
    private static com.facebook.common.disk.NoOpDiskTrimmableRegistry sInstance;

    @Override // com.facebook.common.disk.DiskTrimmableRegistry
    public void registerDiskTrimmable(com.facebook.common.disk.DiskTrimmable diskTrimmable) {
    }

    @Override // com.facebook.common.disk.DiskTrimmableRegistry
    public void unregisterDiskTrimmable(com.facebook.common.disk.DiskTrimmable diskTrimmable) {
    }

    private NoOpDiskTrimmableRegistry() {
    }

    public static synchronized com.facebook.common.disk.NoOpDiskTrimmableRegistry getInstance() {
        if (sInstance == null) {
            sInstance = new com.facebook.common.disk.NoOpDiskTrimmableRegistry();
        }
        return sInstance;
    }
}
