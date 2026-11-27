package kotlin.time;

/* JADX INFO: compiled from: TimeSource.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00062\u00020\u0001:\u0003\u0004\u0005\u0006J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lkotlin/time/TimeSource;", "", "markNow", "Lkotlin/time/TimeMark;", "WithComparableMarks", "Monotonic", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface TimeSource {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final kotlin.time.TimeSource.Companion INSTANCE = kotlin.time.TimeSource.Companion.$$INSTANCE;

    /* JADX INFO: compiled from: TimeSource.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lkotlin/time/TimeSource$WithComparableMarks;", "Lkotlin/time/TimeSource;", "markNow", "Lkotlin/time/ComparableTimeMark;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface WithComparableMarks extends kotlin.time.TimeSource {
        @Override // kotlin.time.TimeSource
        kotlin.time.ComparableTimeMark markNow();
    }

    kotlin.time.TimeMark markNow();

    /* JADX INFO: compiled from: TimeSource.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0004\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lkotlin/time/TimeSource$Monotonic;", "Lkotlin/time/TimeSource$WithComparableMarks;", "<init>", "()V", "markNow", "Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "markNow-z9LOYto", "()J", "toString", "", "ValueTimeMark", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Monotonic implements kotlin.time.TimeSource.WithComparableMarks {
        public static final kotlin.time.TimeSource.Monotonic INSTANCE = new kotlin.time.TimeSource.Monotonic();

        private Monotonic() {
        }

        @Override // kotlin.time.TimeSource.WithComparableMarks, kotlin.time.TimeSource
        public /* bridge */ /* synthetic */ kotlin.time.ComparableTimeMark markNow() {
            return kotlin.time.TimeSource.Monotonic.ValueTimeMark.m2051boximpl(m2050markNowz9LOYto());
        }

        @Override // kotlin.time.TimeSource
        public /* bridge */ /* synthetic */ kotlin.time.TimeMark markNow() {
            return kotlin.time.TimeSource.Monotonic.ValueTimeMark.m2051boximpl(m2050markNowz9LOYto());
        }

        /* JADX INFO: renamed from: markNow-z9LOYto, reason: not valid java name */
        public long m2050markNowz9LOYto() {
            return kotlin.time.MonotonicTimeSource.INSTANCE.m2045markNowz9LOYto();
        }

        public java.lang.String toString() {
            return kotlin.time.MonotonicTimeSource.INSTANCE.toString();
        }

        /* JADX INFO: compiled from: TimeSource.kt */
        @kotlin.Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087@\u0018\u00002\u00020\u0001B\u0015\b\u0000\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\tH\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\tH\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0014J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0001H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u001a\u0010\u000eJ\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001cHÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0014\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0080\u0004¢\u0006\u0004\n\u0002\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00060\u0003j\u0002`\u0004¨\u0006$"}, d2 = {"Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "Lkotlin/time/ComparableTimeMark;", "reading", "", "Lkotlin/time/ValueTimeMarkReading;", "constructor-impl", "(J)J", "J", "elapsedNow", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_PLUS, "duration", "plus-LRDsOJo", "(JJ)J", "minus", "minus-LRDsOJo", "hasPassedNow", "", "hasPassedNow-impl", "(J)Z", "hasNotPassedNow", "hasNotPassedNow-impl", "other", "minus-UwyO8pc", "(JLkotlin/time/ComparableTimeMark;)J", "minus-6eNON_k", "compareTo", "", "compareTo-6eNON_k", "(JJ)I", "equals", "", "hashCode", "toString", "", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
        @kotlin.jvm.JvmInline
        public static final class ValueTimeMark implements kotlin.time.ComparableTimeMark {
            private final long reading;

            /* JADX INFO: renamed from: box-impl, reason: not valid java name */
            public static final /* synthetic */ kotlin.time.TimeSource.Monotonic.ValueTimeMark m2051boximpl(long j) {
                return new kotlin.time.TimeSource.Monotonic.ValueTimeMark(j);
            }

            /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
            public static long m2054constructorimpl(long j) {
                return j;
            }

            /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
            public static boolean m2056equalsimpl(long j, java.lang.Object obj) {
                return (obj instanceof kotlin.time.TimeSource.Monotonic.ValueTimeMark) && j == ((kotlin.time.TimeSource.Monotonic.ValueTimeMark) obj).getReading();
            }

            /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
            public static final boolean m2057equalsimpl0(long j, long j2) {
                return j == j2;
            }

            /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
            public static int m2060hashCodeimpl(long j) {
                return kotlin.UByte$$ExternalSyntheticBackport0.m(j);
            }

            /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
            public static java.lang.String m2065toStringimpl(long j) {
                return "ValueTimeMark(reading=" + j + com.taobao.weex.el.parse.Operators.BRACKET_END;
            }

            @Override // kotlin.time.ComparableTimeMark
            public boolean equals(java.lang.Object other) {
                return m2056equalsimpl(this.reading, other);
            }

            @Override // kotlin.time.ComparableTimeMark
            public int hashCode() {
                return m2060hashCodeimpl(this.reading);
            }

            public java.lang.String toString() {
                return m2065toStringimpl(this.reading);
            }

            /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
            public final /* synthetic */ long getReading() {
                return this.reading;
            }

            /* JADX INFO: renamed from: compareTo-impl, reason: not valid java name */
            public static int m2053compareToimpl(long j, kotlin.time.ComparableTimeMark other) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
                return m2051boximpl(j).compareTo(other);
            }

            @Override // java.lang.Comparable
            public int compareTo(kotlin.time.ComparableTimeMark comparableTimeMark) {
                return kotlin.time.ComparableTimeMark.DefaultImpls.compareTo(this, comparableTimeMark);
            }

            @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
            /* JADX INFO: renamed from: minus-LRDsOJo */
            public /* bridge */ /* synthetic */ kotlin.time.ComparableTimeMark mo1928minusLRDsOJo(long j) {
                return m2051boximpl(m2066minusLRDsOJo(j));
            }

            @Override // kotlin.time.TimeMark
            /* JADX INFO: renamed from: minus-LRDsOJo */
            public /* bridge */ /* synthetic */ kotlin.time.TimeMark mo1928minusLRDsOJo(long j) {
                return m2051boximpl(m2066minusLRDsOJo(j));
            }

            @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
            /* JADX INFO: renamed from: plus-LRDsOJo */
            public /* bridge */ /* synthetic */ kotlin.time.ComparableTimeMark mo1930plusLRDsOJo(long j) {
                return m2051boximpl(m2067plusLRDsOJo(j));
            }

            @Override // kotlin.time.TimeMark
            /* JADX INFO: renamed from: plus-LRDsOJo */
            public /* bridge */ /* synthetic */ kotlin.time.TimeMark mo1930plusLRDsOJo(long j) {
                return m2051boximpl(m2067plusLRDsOJo(j));
            }

            private /* synthetic */ ValueTimeMark(long j) {
                this.reading = j;
            }

            /* JADX INFO: renamed from: elapsedNow-UwyO8pc, reason: not valid java name */
            public static long m2055elapsedNowUwyO8pc(long j) {
                return kotlin.time.MonotonicTimeSource.INSTANCE.m2044elapsedFrom6eNON_k(j);
            }

            @Override // kotlin.time.TimeMark
            /* JADX INFO: renamed from: elapsedNow-UwyO8pc */
            public long mo1927elapsedNowUwyO8pc() {
                return m2055elapsedNowUwyO8pc(this.reading);
            }

            /* JADX INFO: renamed from: plus-LRDsOJo, reason: not valid java name */
            public static long m2064plusLRDsOJo(long j, long j2) {
                return kotlin.time.MonotonicTimeSource.INSTANCE.m2042adjustReading6QKq23U(j, j2);
            }

            /* JADX INFO: renamed from: plus-LRDsOJo, reason: not valid java name */
            public long m2067plusLRDsOJo(long j) {
                return m2064plusLRDsOJo(this.reading, j);
            }

            /* JADX INFO: renamed from: minus-LRDsOJo, reason: not valid java name */
            public static long m2062minusLRDsOJo(long j, long j2) {
                return kotlin.time.MonotonicTimeSource.INSTANCE.m2042adjustReading6QKq23U(j, kotlin.time.Duration.m1981unaryMinusUwyO8pc(j2));
            }

            /* JADX INFO: renamed from: minus-LRDsOJo, reason: not valid java name */
            public long m2066minusLRDsOJo(long j) {
                return m2062minusLRDsOJo(this.reading, j);
            }

            /* JADX INFO: renamed from: hasPassedNow-impl, reason: not valid java name */
            public static boolean m2059hasPassedNowimpl(long j) {
                return !kotlin.time.Duration.m1963isNegativeimpl(m2055elapsedNowUwyO8pc(j));
            }

            @Override // kotlin.time.TimeMark
            public boolean hasPassedNow() {
                return m2059hasPassedNowimpl(this.reading);
            }

            /* JADX INFO: renamed from: hasNotPassedNow-impl, reason: not valid java name */
            public static boolean m2058hasNotPassedNowimpl(long j) {
                return kotlin.time.Duration.m1963isNegativeimpl(m2055elapsedNowUwyO8pc(j));
            }

            @Override // kotlin.time.TimeMark
            public boolean hasNotPassedNow() {
                return m2058hasNotPassedNowimpl(this.reading);
            }

            @Override // kotlin.time.ComparableTimeMark
            /* JADX INFO: renamed from: minus-UwyO8pc */
            public long mo1929minusUwyO8pc(kotlin.time.ComparableTimeMark other) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
                return m2063minusUwyO8pc(this.reading, other);
            }

            /* JADX INFO: renamed from: minus-UwyO8pc, reason: not valid java name */
            public static long m2063minusUwyO8pc(long j, kotlin.time.ComparableTimeMark other) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
                if (!(other instanceof kotlin.time.TimeSource.Monotonic.ValueTimeMark)) {
                    throw new java.lang.IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + ((java.lang.Object) m2065toStringimpl(j)) + " and " + other);
                }
                return m2061minus6eNON_k(j, ((kotlin.time.TimeSource.Monotonic.ValueTimeMark) other).getReading());
            }

            /* JADX INFO: renamed from: minus-6eNON_k, reason: not valid java name */
            public static final long m2061minus6eNON_k(long j, long j2) {
                return kotlin.time.MonotonicTimeSource.INSTANCE.m2043differenceBetweenfRLX17w(j, j2);
            }

            /* JADX INFO: renamed from: compareTo-6eNON_k, reason: not valid java name */
            public static final int m2052compareTo6eNON_k(long j, long j2) {
                return kotlin.time.Duration.m1936compareToLRDsOJo(m2061minus6eNON_k(j, j2), kotlin.time.Duration.INSTANCE.m2028getZEROUwyO8pc());
            }
        }
    }

    /* JADX INFO: compiled from: TimeSource.kt */
    @kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/time/TimeSource$Companion;", "", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ kotlin.time.TimeSource.Companion $$INSTANCE = new kotlin.time.TimeSource.Companion();

        private Companion() {
        }
    }
}
