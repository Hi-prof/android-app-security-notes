package com.facebook.cache.disk;

/* JADX INFO: loaded from: classes.dex */
public class DefaultEntryEvictionComparatorSupplier implements com.facebook.cache.disk.EntryEvictionComparatorSupplier {
    @Override // com.facebook.cache.disk.EntryEvictionComparatorSupplier
    public com.facebook.cache.disk.EntryEvictionComparator get() {
        return new com.facebook.cache.disk.EntryEvictionComparator() { // from class: com.facebook.cache.disk.DefaultEntryEvictionComparatorSupplier.1
            @Override // java.util.Comparator
            public int compare(com.facebook.cache.disk.DiskStorage.Entry entry, com.facebook.cache.disk.DiskStorage.Entry entry2) {
                long timestamp = entry.getTimestamp();
                long timestamp2 = entry2.getTimestamp();
                if (timestamp < timestamp2) {
                    return -1;
                }
                return timestamp2 == timestamp ? 0 : 1;
            }
        };
    }
}
