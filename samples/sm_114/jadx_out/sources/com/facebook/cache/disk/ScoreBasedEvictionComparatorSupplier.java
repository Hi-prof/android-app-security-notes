package com.facebook.cache.disk;

/* JADX INFO: loaded from: classes.dex */
public class ScoreBasedEvictionComparatorSupplier implements com.facebook.cache.disk.EntryEvictionComparatorSupplier {
    private final float mAgeWeight;
    private final float mSizeWeight;

    public ScoreBasedEvictionComparatorSupplier(float f, float f2) {
        this.mAgeWeight = f;
        this.mSizeWeight = f2;
    }

    @Override // com.facebook.cache.disk.EntryEvictionComparatorSupplier
    public com.facebook.cache.disk.EntryEvictionComparator get() {
        return new com.facebook.cache.disk.EntryEvictionComparator() { // from class: com.facebook.cache.disk.ScoreBasedEvictionComparatorSupplier.1
            long now = java.lang.System.currentTimeMillis();

            @Override // java.util.Comparator
            public int compare(com.facebook.cache.disk.DiskStorage.Entry entry, com.facebook.cache.disk.DiskStorage.Entry entry2) {
                float fCalculateScore = com.facebook.cache.disk.ScoreBasedEvictionComparatorSupplier.this.calculateScore(entry, this.now);
                float fCalculateScore2 = com.facebook.cache.disk.ScoreBasedEvictionComparatorSupplier.this.calculateScore(entry2, this.now);
                if (fCalculateScore < fCalculateScore2) {
                    return 1;
                }
                return fCalculateScore2 == fCalculateScore ? 0 : -1;
            }
        };
    }

    float calculateScore(com.facebook.cache.disk.DiskStorage.Entry entry, long j) {
        return (this.mAgeWeight * (j - entry.getTimestamp())) + (this.mSizeWeight * entry.getSize());
    }
}
