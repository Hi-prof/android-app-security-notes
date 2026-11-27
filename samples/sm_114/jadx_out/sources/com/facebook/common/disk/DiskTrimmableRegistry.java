package com.facebook.common.disk;

/* JADX INFO: loaded from: classes.dex */
public interface DiskTrimmableRegistry {
    void registerDiskTrimmable(com.facebook.common.disk.DiskTrimmable diskTrimmable);

    void unregisterDiskTrimmable(com.facebook.common.disk.DiskTrimmable diskTrimmable);
}
