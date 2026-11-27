package com.dcloud.zxing2.oned.rss.expanded;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
final class ExpandedPair {
    private final com.dcloud.zxing2.oned.rss.FinderPattern finderPattern;
    private final com.dcloud.zxing2.oned.rss.DataCharacter leftChar;
    private final boolean mayBeLast;
    private final com.dcloud.zxing2.oned.rss.DataCharacter rightChar;

    ExpandedPair(com.dcloud.zxing2.oned.rss.DataCharacter dataCharacter, com.dcloud.zxing2.oned.rss.DataCharacter dataCharacter2, com.dcloud.zxing2.oned.rss.FinderPattern finderPattern, boolean z) {
        this.leftChar = dataCharacter;
        this.rightChar = dataCharacter2;
        this.finderPattern = finderPattern;
        this.mayBeLast = z;
    }

    private static boolean equalsOrNull(java.lang.Object obj, java.lang.Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    private static int hashNotNull(java.lang.Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof com.dcloud.zxing2.oned.rss.expanded.ExpandedPair)) {
            return false;
        }
        com.dcloud.zxing2.oned.rss.expanded.ExpandedPair expandedPair = (com.dcloud.zxing2.oned.rss.expanded.ExpandedPair) obj;
        return equalsOrNull(this.leftChar, expandedPair.leftChar) && equalsOrNull(this.rightChar, expandedPair.rightChar) && equalsOrNull(this.finderPattern, expandedPair.finderPattern);
    }

    com.dcloud.zxing2.oned.rss.FinderPattern getFinderPattern() {
        return this.finderPattern;
    }

    com.dcloud.zxing2.oned.rss.DataCharacter getLeftChar() {
        return this.leftChar;
    }

    com.dcloud.zxing2.oned.rss.DataCharacter getRightChar() {
        return this.rightChar;
    }

    public int hashCode() {
        return (hashNotNull(this.leftChar) ^ hashNotNull(this.rightChar)) ^ hashNotNull(this.finderPattern);
    }

    boolean mayBeLast() {
        return this.mayBeLast;
    }

    public boolean mustBeLast() {
        return this.rightChar == null;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("[ ");
        sb.append(this.leftChar);
        sb.append(" , ");
        sb.append(this.rightChar);
        sb.append(" : ");
        com.dcloud.zxing2.oned.rss.FinderPattern finderPattern = this.finderPattern;
        sb.append(finderPattern == null ? "null" : java.lang.Integer.valueOf(finderPattern.getValue()));
        sb.append(" ]");
        return sb.toString();
    }
}
