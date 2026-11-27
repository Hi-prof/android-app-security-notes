package kotlin.random;

/* JADX INFO: compiled from: URandom.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007¢\u0006\u0002\u0010\u0003\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\f\u001a\u0011\u0010\r\u001a\u00020\u000e*\u00020\u0002H\u0007¢\u0006\u0002\u0010\u000f\u001a\u001b\u0010\r\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a#\u0010\r\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0019\u0010\r\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0014H\u0007¢\u0006\u0002\u0010\u0015\u001a\u001b\u0010\u0016\u001a\u00020\u0017*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0019\u0010\u0016\u001a\u00020\u0017*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0002\u0010\u001d\u001a/\u0010\u0016\u001a\u00020\u0017*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u001e\u001a\u00020\u001c2\b\b\u0002\u0010\u001f\u001a\u00020\u001cH\u0007¢\u0006\u0004\b \u0010!\u001a\u001f\u0010\"\u001a\u00020#2\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0000¢\u0006\u0004\b$\u0010%\u001a\u001f\u0010&\u001a\u00020#2\u0006\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0000¢\u0006\u0004\b'\u0010(¨\u0006)"}, d2 = {"nextUInt", "Lkotlin/UInt;", "Lkotlin/random/Random;", "(Lkotlin/random/Random;)I", "until", "nextUInt-qCasIEU", "(Lkotlin/random/Random;I)I", "from", "nextUInt-a8DCA5k", "(Lkotlin/random/Random;II)I", io.dcloud.common.constant.AbsoluteConst.PULL_REFRESH_RANGE, "Lkotlin/ranges/UIntRange;", "(Lkotlin/random/Random;Lkotlin/ranges/UIntRange;)I", "nextULong", "Lkotlin/ULong;", "(Lkotlin/random/Random;)J", "nextULong-V1Xi4fY", "(Lkotlin/random/Random;J)J", "nextULong-jmpaW-c", "(Lkotlin/random/Random;JJ)J", "Lkotlin/ranges/ULongRange;", "(Lkotlin/random/Random;Lkotlin/ranges/ULongRange;)J", "nextUBytes", "Lkotlin/UByteArray;", "array", "nextUBytes-EVgfTAA", "(Lkotlin/random/Random;[B)[B", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE, "", "(Lkotlin/random/Random;I)[B", "fromIndex", "toIndex", "nextUBytes-Wvrt4B4", "(Lkotlin/random/Random;[BII)[B", "checkUIntRangeBounds", "", "checkUIntRangeBounds-J1ME1BU", "(II)V", "checkULongRangeBounds", "checkULongRangeBounds-eb3DHEI", "(JJ)V", "kotlin-stdlib"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class URandomKt {
    public static final int nextUInt(kotlin.random.Random random) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(random, "<this>");
        return kotlin.UInt.m638constructorimpl(random.nextInt());
    }

    /* JADX INFO: renamed from: nextUInt-qCasIEU, reason: not valid java name */
    public static final int m1771nextUIntqCasIEU(kotlin.random.Random nextUInt, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nextUInt, "$this$nextUInt");
        return m1770nextUInta8DCA5k(nextUInt, 0, i);
    }

    /* JADX INFO: renamed from: nextUInt-a8DCA5k, reason: not valid java name */
    public static final int m1770nextUInta8DCA5k(kotlin.random.Random nextUInt, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nextUInt, "$this$nextUInt");
        m1765checkUIntRangeBoundsJ1ME1BU(i, i2);
        return kotlin.UInt.m638constructorimpl(nextUInt.nextInt(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE) ^ Integer.MIN_VALUE);
    }

    public static final int nextUInt(kotlin.random.Random random, kotlin.ranges.UIntRange range) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(random, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(range, "range");
        if (range.isEmpty()) {
            throw new java.lang.IllegalArgumentException("Cannot get random in empty range: " + range);
        }
        if (java.lang.Integer.compare(range.getLast() ^ Integer.MIN_VALUE, (-1) ^ Integer.MIN_VALUE) < 0) {
            return m1770nextUInta8DCA5k(random, range.getFirst(), kotlin.UInt.m638constructorimpl(range.getLast() + 1));
        }
        return java.lang.Integer.compare(range.getFirst() ^ Integer.MIN_VALUE, 0 ^ Integer.MIN_VALUE) > 0 ? kotlin.UInt.m638constructorimpl(m1770nextUInta8DCA5k(random, kotlin.UInt.m638constructorimpl(range.getFirst() - 1), range.getLast()) + 1) : nextUInt(random);
    }

    public static final long nextULong(kotlin.random.Random random) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(random, "<this>");
        return kotlin.ULong.m717constructorimpl(random.nextLong());
    }

    /* JADX INFO: renamed from: nextULong-V1Xi4fY, reason: not valid java name */
    public static final long m1772nextULongV1Xi4fY(kotlin.random.Random nextULong, long j) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nextULong, "$this$nextULong");
        return m1773nextULongjmpaWc(nextULong, 0L, j);
    }

    /* JADX INFO: renamed from: nextULong-jmpaW-c, reason: not valid java name */
    public static final long m1773nextULongjmpaWc(kotlin.random.Random nextULong, long j, long j2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nextULong, "$this$nextULong");
        m1766checkULongRangeBoundseb3DHEI(j, j2);
        return kotlin.ULong.m717constructorimpl(nextULong.nextLong(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE) ^ Long.MIN_VALUE);
    }

    public static final long nextULong(kotlin.random.Random random, kotlin.ranges.ULongRange range) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(random, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(range, "range");
        if (range.isEmpty()) {
            throw new java.lang.IllegalArgumentException("Cannot get random in empty range: " + range);
        }
        if (java.lang.Long.compare(range.getLast() ^ Long.MIN_VALUE, (-1) ^ Long.MIN_VALUE) < 0) {
            return m1773nextULongjmpaWc(random, range.getFirst(), kotlin.ULong.m717constructorimpl(range.getLast() + kotlin.ULong.m717constructorimpl(net.lingala.zip4j.util.InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) 1))));
        }
        if (java.lang.Long.compare(range.getFirst() ^ Long.MIN_VALUE, 0 ^ Long.MIN_VALUE) <= 0) {
            return nextULong(random);
        }
        long j = range.getFirst();
        long j2 = net.lingala.zip4j.util.InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) 1);
        return kotlin.ULong.m717constructorimpl(m1773nextULongjmpaWc(random, kotlin.ULong.m717constructorimpl(j - kotlin.ULong.m717constructorimpl(j2)), range.getLast()) + kotlin.ULong.m717constructorimpl(j2));
    }

    /* JADX INFO: renamed from: nextUBytes-EVgfTAA, reason: not valid java name */
    public static final byte[] m1767nextUBytesEVgfTAA(kotlin.random.Random nextUBytes, byte[] array) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nextUBytes, "$this$nextUBytes");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(array, "array");
        nextUBytes.nextBytes(array);
        return array;
    }

    public static final byte[] nextUBytes(kotlin.random.Random random, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(random, "<this>");
        return kotlin.UByteArray.m614constructorimpl(random.nextBytes(i));
    }

    /* JADX INFO: renamed from: nextUBytes-Wvrt4B4$default, reason: not valid java name */
    public static /* synthetic */ byte[] m1769nextUBytesWvrt4B4$default(kotlin.random.Random random, byte[] bArr, int i, int i2, int i3, java.lang.Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = kotlin.UByteArray.m620getSizeimpl(bArr);
        }
        return m1768nextUBytesWvrt4B4(random, bArr, i, i2);
    }

    /* JADX INFO: renamed from: nextUBytes-Wvrt4B4, reason: not valid java name */
    public static final byte[] m1768nextUBytesWvrt4B4(kotlin.random.Random nextUBytes, byte[] array, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nextUBytes, "$this$nextUBytes");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(array, "array");
        nextUBytes.nextBytes(array, i, i2);
        return array;
    }

    /* JADX INFO: renamed from: checkUIntRangeBounds-J1ME1BU, reason: not valid java name */
    public static final void m1765checkUIntRangeBoundsJ1ME1BU(int i, int i2) {
        if (java.lang.Integer.compare(i2 ^ Integer.MIN_VALUE, i ^ Integer.MIN_VALUE) <= 0) {
            throw new java.lang.IllegalArgumentException(kotlin.random.RandomKt.boundsErrorMessage(kotlin.UInt.m632boximpl(i), kotlin.UInt.m632boximpl(i2)).toString());
        }
    }

    /* JADX INFO: renamed from: checkULongRangeBounds-eb3DHEI, reason: not valid java name */
    public static final void m1766checkULongRangeBoundseb3DHEI(long j, long j2) {
        if (java.lang.Long.compare(j2 ^ Long.MIN_VALUE, j ^ Long.MIN_VALUE) <= 0) {
            throw new java.lang.IllegalArgumentException(kotlin.random.RandomKt.boundsErrorMessage(kotlin.ULong.m711boximpl(j), kotlin.ULong.m711boximpl(j2)).toString());
        }
    }
}
