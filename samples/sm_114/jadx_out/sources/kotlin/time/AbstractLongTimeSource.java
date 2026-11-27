package kotlin.time;

/* JADX INFO: compiled from: TimeSources.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH$J\b\u0010\u000f\u001a\u00020\tH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lkotlin/time/AbstractLongTimeSource;", "Lkotlin/time/TimeSource$WithComparableMarks;", "unit", "Lkotlin/time/DurationUnit;", "<init>", "(Lkotlin/time/DurationUnit;)V", "getUnit", "()Lkotlin/time/DurationUnit;", "read", "", "zero", "getZero", "()J", "zero$delegate", "Lkotlin/Lazy;", "adjustedRead", "markNow", "Lkotlin/time/ComparableTimeMark;", "LongTimeMark", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class AbstractLongTimeSource implements kotlin.time.TimeSource.WithComparableMarks {
    private final kotlin.time.DurationUnit unit;

    /* JADX INFO: renamed from: zero$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy zero;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract long read();

    public AbstractLongTimeSource(kotlin.time.DurationUnit unit) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(unit, "unit");
        this.unit = unit;
        this.zero = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0() { // from class: kotlin.time.AbstractLongTimeSource$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final java.lang.Object invoke() {
                return java.lang.Long.valueOf(this.f$0.read());
            }
        });
    }

    protected final kotlin.time.DurationUnit getUnit() {
        return this.unit;
    }

    private final long getZero() {
        return ((java.lang.Number) this.zero.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long adjustedRead() {
        return read() - getZero();
    }

    /* JADX INFO: compiled from: TimeSources.kt */
    @kotlin.Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0001H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0013\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u001d"}, d2 = {"Lkotlin/time/AbstractLongTimeSource$LongTimeMark;", "Lkotlin/time/ComparableTimeMark;", "startedAt", "", "timeSource", "Lkotlin/time/AbstractLongTimeSource;", "offset", "Lkotlin/time/Duration;", "<init>", "(JLkotlin/time/AbstractLongTimeSource;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "elapsedNow", "elapsedNow-UwyO8pc", "()J", io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_PLUS, "duration", "plus-LRDsOJo", "(J)Lkotlin/time/ComparableTimeMark;", "minus", "other", "minus-UwyO8pc", "(Lkotlin/time/ComparableTimeMark;)J", "equals", "", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class LongTimeMark implements kotlin.time.ComparableTimeMark {
        private final long offset;
        private final long startedAt;
        private final kotlin.time.AbstractLongTimeSource timeSource;

        public /* synthetic */ LongTimeMark(long j, kotlin.time.AbstractLongTimeSource abstractLongTimeSource, long j2, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this(j, abstractLongTimeSource, j2);
        }

        private LongTimeMark(long j, kotlin.time.AbstractLongTimeSource timeSource, long j2) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(timeSource, "timeSource");
            this.startedAt = j;
            this.timeSource = timeSource;
            this.offset = j2;
        }

        @Override // java.lang.Comparable
        public int compareTo(kotlin.time.ComparableTimeMark comparableTimeMark) {
            return kotlin.time.ComparableTimeMark.DefaultImpls.compareTo(this, comparableTimeMark);
        }

        @Override // kotlin.time.TimeMark
        public boolean hasNotPassedNow() {
            return kotlin.time.ComparableTimeMark.DefaultImpls.hasNotPassedNow(this);
        }

        @Override // kotlin.time.TimeMark
        public boolean hasPassedNow() {
            return kotlin.time.ComparableTimeMark.DefaultImpls.hasPassedNow(this);
        }

        @Override // kotlin.time.TimeMark
        /* JADX INFO: renamed from: minus-LRDsOJo */
        public kotlin.time.ComparableTimeMark mo1928minusLRDsOJo(long j) {
            return kotlin.time.ComparableTimeMark.DefaultImpls.m1932minusLRDsOJo(this, j);
        }

        @Override // kotlin.time.TimeMark
        /* JADX INFO: renamed from: elapsedNow-UwyO8pc */
        public long mo1927elapsedNowUwyO8pc() {
            return kotlin.time.Duration.m1965minusLRDsOJo(kotlin.time.LongSaturatedMathKt.saturatingOriginsDiff(this.timeSource.adjustedRead(), this.startedAt, this.timeSource.getUnit()), this.offset);
        }

        @Override // kotlin.time.TimeMark
        /* JADX INFO: renamed from: plus-LRDsOJo */
        public kotlin.time.ComparableTimeMark mo1930plusLRDsOJo(long duration) {
            kotlin.time.DurationUnit unit = this.timeSource.getUnit();
            if (kotlin.time.Duration.m1962isInfiniteimpl(duration)) {
                return new kotlin.time.AbstractLongTimeSource.LongTimeMark(kotlin.time.LongSaturatedMathKt.m2040saturatingAddNuflL3o(this.startedAt, unit, duration), this.timeSource, kotlin.time.Duration.INSTANCE.m2028getZEROUwyO8pc(), null);
            }
            long jM1980truncateToUwyO8pc$kotlin_stdlib = kotlin.time.Duration.m1980truncateToUwyO8pc$kotlin_stdlib(duration, unit);
            long jM1966plusLRDsOJo = kotlin.time.Duration.m1966plusLRDsOJo(kotlin.time.Duration.m1965minusLRDsOJo(duration, jM1980truncateToUwyO8pc$kotlin_stdlib), this.offset);
            long jM2040saturatingAddNuflL3o = kotlin.time.LongSaturatedMathKt.m2040saturatingAddNuflL3o(this.startedAt, unit, jM1980truncateToUwyO8pc$kotlin_stdlib);
            long jM1980truncateToUwyO8pc$kotlin_stdlib2 = kotlin.time.Duration.m1980truncateToUwyO8pc$kotlin_stdlib(jM1966plusLRDsOJo, unit);
            long jM2040saturatingAddNuflL3o2 = kotlin.time.LongSaturatedMathKt.m2040saturatingAddNuflL3o(jM2040saturatingAddNuflL3o, unit, jM1980truncateToUwyO8pc$kotlin_stdlib2);
            long jM1965minusLRDsOJo = kotlin.time.Duration.m1965minusLRDsOJo(jM1966plusLRDsOJo, jM1980truncateToUwyO8pc$kotlin_stdlib2);
            long jM1950getInWholeNanosecondsimpl = kotlin.time.Duration.m1950getInWholeNanosecondsimpl(jM1965minusLRDsOJo);
            if (jM2040saturatingAddNuflL3o2 != 0 && jM1950getInWholeNanosecondsimpl != 0 && (jM2040saturatingAddNuflL3o2 ^ jM1950getInWholeNanosecondsimpl) < 0) {
                long duration2 = kotlin.time.DurationKt.toDuration(kotlin.math.MathKt.getSign(jM1950getInWholeNanosecondsimpl), unit);
                jM2040saturatingAddNuflL3o2 = kotlin.time.LongSaturatedMathKt.m2040saturatingAddNuflL3o(jM2040saturatingAddNuflL3o2, unit, duration2);
                jM1965minusLRDsOJo = kotlin.time.Duration.m1965minusLRDsOJo(jM1965minusLRDsOJo, duration2);
            }
            if ((1 | (jM2040saturatingAddNuflL3o2 - 1)) == Long.MAX_VALUE) {
                jM1965minusLRDsOJo = kotlin.time.Duration.INSTANCE.m2028getZEROUwyO8pc();
            }
            return new kotlin.time.AbstractLongTimeSource.LongTimeMark(jM2040saturatingAddNuflL3o2, this.timeSource, jM1965minusLRDsOJo, null);
        }

        @Override // kotlin.time.ComparableTimeMark
        /* JADX INFO: renamed from: minus-UwyO8pc */
        public long mo1929minusUwyO8pc(kotlin.time.ComparableTimeMark other) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
            if (other instanceof kotlin.time.AbstractLongTimeSource.LongTimeMark) {
                kotlin.time.AbstractLongTimeSource.LongTimeMark longTimeMark = (kotlin.time.AbstractLongTimeSource.LongTimeMark) other;
                if (kotlin.jvm.internal.Intrinsics.areEqual(this.timeSource, longTimeMark.timeSource)) {
                    return kotlin.time.Duration.m1966plusLRDsOJo(kotlin.time.LongSaturatedMathKt.saturatingOriginsDiff(this.startedAt, longTimeMark.startedAt, this.timeSource.getUnit()), kotlin.time.Duration.m1965minusLRDsOJo(this.offset, longTimeMark.offset));
                }
            }
            throw new java.lang.IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + other);
        }

        @Override // kotlin.time.ComparableTimeMark
        public boolean equals(java.lang.Object other) {
            return (other instanceof kotlin.time.AbstractLongTimeSource.LongTimeMark) && kotlin.jvm.internal.Intrinsics.areEqual(this.timeSource, ((kotlin.time.AbstractLongTimeSource.LongTimeMark) other).timeSource) && kotlin.time.Duration.m1942equalsimpl0(mo1929minusUwyO8pc((kotlin.time.ComparableTimeMark) other), kotlin.time.Duration.INSTANCE.m2028getZEROUwyO8pc());
        }

        @Override // kotlin.time.ComparableTimeMark
        public int hashCode() {
            return (kotlin.time.Duration.m1958hashCodeimpl(this.offset) * 37) + kotlin.UByte$$ExternalSyntheticBackport0.m(this.startedAt);
        }

        public java.lang.String toString() {
            return "LongTimeMark(" + this.startedAt + kotlin.time.DurationUnitKt.shortName(this.timeSource.getUnit()) + " + " + ((java.lang.Object) kotlin.time.Duration.m1977toStringimpl(this.offset)) + ", " + this.timeSource + com.taobao.weex.el.parse.Operators.BRACKET_END;
        }
    }

    @Override // kotlin.time.TimeSource
    public kotlin.time.ComparableTimeMark markNow() {
        return new kotlin.time.AbstractLongTimeSource.LongTimeMark(adjustedRead(), this, kotlin.time.Duration.INSTANCE.m2028getZEROUwyO8pc(), null);
    }
}
