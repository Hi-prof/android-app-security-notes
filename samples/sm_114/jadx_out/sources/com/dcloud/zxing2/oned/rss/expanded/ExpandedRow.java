package com.dcloud.zxing2.oned.rss.expanded;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class ExpandedRow {
    private final java.util.List<com.dcloud.zxing2.oned.rss.expanded.ExpandedPair> pairs;
    private final int rowNumber;
    private final boolean wasReversed;

    ExpandedRow(java.util.List<com.dcloud.zxing2.oned.rss.expanded.ExpandedPair> list, int i, boolean z) {
        this.pairs = new java.util.ArrayList(list);
        this.rowNumber = i;
        this.wasReversed = z;
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof com.dcloud.zxing2.oned.rss.expanded.ExpandedRow)) {
            return false;
        }
        com.dcloud.zxing2.oned.rss.expanded.ExpandedRow expandedRow = (com.dcloud.zxing2.oned.rss.expanded.ExpandedRow) obj;
        return this.pairs.equals(expandedRow.getPairs()) && this.wasReversed == expandedRow.wasReversed;
    }

    java.util.List<com.dcloud.zxing2.oned.rss.expanded.ExpandedPair> getPairs() {
        return this.pairs;
    }

    int getRowNumber() {
        return this.rowNumber;
    }

    public int hashCode() {
        return this.pairs.hashCode() ^ java.lang.Boolean.valueOf(this.wasReversed).hashCode();
    }

    boolean isEquivalent(java.util.List<com.dcloud.zxing2.oned.rss.expanded.ExpandedPair> list) {
        return this.pairs.equals(list);
    }

    boolean isReversed() {
        return this.wasReversed;
    }

    public java.lang.String toString() {
        return "{ " + this.pairs + " }";
    }
}
