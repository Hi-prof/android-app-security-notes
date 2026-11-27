package kotlin.time;

/* JADX INFO: compiled from: Duration.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0006\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087@\u0018\u0000 \u0089\u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0089\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\f\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ\u0010\u0010\u0016\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0017\u0010\u0005J\u0018\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010!\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\"\u0010\u001bJ\u0018\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b%\u0010&J\u0018\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020'H\u0086\u0002¢\u0006\u0004\b%\u0010(J\u0018\u0010)\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b*\u0010&J\u0018\u0010)\u001a\u00020\u00002\u0006\u0010$\u001a\u00020'H\u0086\u0002¢\u0006\u0004\b*\u0010(J\u0018\u0010)\u001a\u00020'2\u0006\u0010\u0019\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u0013H\u0000¢\u0006\u0004\b/\u00100J\r\u00101\u001a\u00020\r¢\u0006\u0004\b2\u0010\u000fJ\r\u00103\u001a\u00020\r¢\u0006\u0004\b4\u0010\u000fJ\r\u00105\u001a\u00020\r¢\u0006\u0004\b6\u0010\u000fJ\r\u00107\u001a\u00020\r¢\u0006\u0004\b8\u0010\u000fJ\u0018\u0010;\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b<\u0010=J\u009d\u0001\u0010>\u001a\u0002H?\"\u0004\b\u0000\u0010?2u\u0010@\u001aq\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(D\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(E\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(F\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(G\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(H\u0012\u0004\u0012\u0002H?0AH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bI\u0010JJ\u0088\u0001\u0010>\u001a\u0002H?\"\u0004\b\u0000\u0010?2`\u0010@\u001a\\\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(E\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(F\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(G\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(H\u0012\u0004\u0012\u0002H?0KH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bI\u0010LJs\u0010>\u001a\u0002H?\"\u0004\b\u0000\u0010?2K\u0010@\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(F\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(G\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(H\u0012\u0004\u0012\u0002H?0MH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bI\u0010NJ^\u0010>\u001a\u0002H?\"\u0004\b\u0000\u0010?26\u0010@\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(G\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(H\u0012\u0004\u0012\u0002H?0OH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bI\u0010PJ\u0015\u0010^\u001a\u00020'2\u0006\u0010.\u001a\u00020\u0013¢\u0006\u0004\b_\u0010`J\u0015\u0010a\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0013¢\u0006\u0004\bb\u00100J\u0015\u0010c\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u0013¢\u0006\u0004\bd\u0010eJ\u000f\u0010t\u001a\u00020uH\u0016¢\u0006\u0004\bv\u0010wJA\u0010x\u001a\u00020y*\u00060zj\u0002`{2\u0006\u0010|\u001a\u00020\t2\u0006\u0010}\u001a\u00020\t2\u0006\u0010~\u001a\u00020\t2\u0006\u0010.\u001a\u00020u2\u0006\u0010\u007f\u001a\u00020\rH\u0002¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J!\u0010t\u001a\u00020u2\u0006\u0010.\u001a\u00020\u00132\t\b\u0002\u0010\u0082\u0001\u001a\u00020\t¢\u0006\u0005\bv\u0010\u0083\u0001J\u000f\u0010\u0084\u0001\u001a\u00020u¢\u0006\u0005\b\u0085\u0001\u0010wJ\u0015\u0010\u0086\u0001\u001a\u00020\r2\t\u0010\u0019\u001a\u0005\u0018\u00010\u0087\u0001HÖ\u0003J\n\u0010\u0088\u0001\u001a\u00020\tHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0015\u0010\b\u001a\u00020\t8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u00109\u001a\u00020\u00008F¢\u0006\u0006\u001a\u0004\b:\u0010\u0005R\u001a\u0010Q\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\bR\u0010S\u001a\u0004\bT\u0010\u000bR\u001a\u0010U\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\bV\u0010S\u001a\u0004\bW\u0010\u000bR\u001a\u0010X\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\bY\u0010S\u001a\u0004\bZ\u0010\u000bR\u001a\u0010[\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\\\u0010S\u001a\u0004\b]\u0010\u000bR\u0011\u0010f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bg\u0010\u0005R\u0011\u0010h\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bi\u0010\u0005R\u0011\u0010j\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bk\u0010\u0005R\u0011\u0010l\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bm\u0010\u0005R\u0011\u0010n\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bo\u0010\u0005R\u0011\u0010p\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bq\u0010\u0005R\u0011\u0010r\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bs\u0010\u0005\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u008a\u0001"}, d2 = {"Lkotlin/time/Duration;", "", "rawValue", "", "constructor-impl", "(J)J", "value", "getValue-impl", "unitDiscriminator", "", "getUnitDiscriminator-impl", "(J)I", "isInNanos", "", "isInNanos-impl", "(J)Z", "isInMillis", "isInMillis-impl", "storageUnit", "Lkotlin/time/DurationUnit;", "getStorageUnit-impl", "(J)Lkotlin/time/DurationUnit;", "unaryMinus", "unaryMinus-UwyO8pc", io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_PLUS, "other", "plus-LRDsOJo", "(JJ)J", "addValuesMixedRanges", "thisMillis", "otherNanos", "addValuesMixedRanges-UwyO8pc", "(JJJ)J", "minus", "minus-LRDsOJo", "times", "scale", "times-UwyO8pc", "(JI)J", "", "(JD)J", com.taobao.weex.ui.component.WXBasicComponentType.DIV, "div-UwyO8pc", "div-LRDsOJo", "(JJ)D", "truncateTo", "unit", "truncateTo-UwyO8pc$kotlin_stdlib", "(JLkotlin/time/DurationUnit;)J", "isNegative", "isNegative-impl", "isPositive", "isPositive-impl", "isInfinite", "isInfinite-impl", "isFinite", "isFinite-impl", "absoluteValue", "getAbsoluteValue-UwyO8pc", "compareTo", "compareTo-LRDsOJo", "(JJ)I", "toComponents", "T", "action", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "days", "hours", "minutes", "seconds", "nanoseconds", "toComponents-impl", "(JLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "Lkotlin/Function4;", "(JLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(JLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "hoursComponent", "getHoursComponent$annotations", "()V", "getHoursComponent-impl", "minutesComponent", "getMinutesComponent$annotations", "getMinutesComponent-impl", "secondsComponent", "getSecondsComponent$annotations", "getSecondsComponent-impl", "nanosecondsComponent", "getNanosecondsComponent$annotations", "getNanosecondsComponent-impl", "toDouble", "toDouble-impl", "(JLkotlin/time/DurationUnit;)D", "toLong", "toLong-impl", "toInt", "toInt-impl", "(JLkotlin/time/DurationUnit;)I", "inWholeDays", "getInWholeDays-impl", "inWholeHours", "getInWholeHours-impl", "inWholeMinutes", "getInWholeMinutes-impl", "inWholeSeconds", "getInWholeSeconds-impl", "inWholeMilliseconds", "getInWholeMilliseconds-impl", "inWholeMicroseconds", "getInWholeMicroseconds-impl", "inWholeNanoseconds", "getInWholeNanoseconds-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "appendFractional", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", "appendFractional-impl", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "decimals", "(JLkotlin/time/DurationUnit;I)Ljava/lang/String;", "toIsoString", "toIsoString-impl", "equals", "", "hashCode", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
@kotlin.jvm.JvmInline
public final class Duration implements java.lang.Comparable<kotlin.time.Duration> {
    private final long rawValue;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final kotlin.time.Duration.Companion INSTANCE = new kotlin.time.Duration.Companion(null);
    private static final long ZERO = m1937constructorimpl(0);
    private static final long INFINITE = kotlin.time.DurationKt.durationOfMillis(kotlin.time.DurationKt.MAX_MILLIS);
    private static final long NEG_INFINITE = kotlin.time.DurationKt.durationOfMillis(-4611686018427387903L);

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ kotlin.time.Duration m1935boximpl(long j) {
        return new kotlin.time.Duration(j);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1941equalsimpl(long j, java.lang.Object obj) {
        return (obj instanceof kotlin.time.Duration) && j == ((kotlin.time.Duration) obj).getRawValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1942equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getHoursComponent$annotations() {
    }

    public static /* synthetic */ void getMinutesComponent$annotations() {
    }

    public static /* synthetic */ void getNanosecondsComponent$annotations() {
    }

    public static /* synthetic */ void getSecondsComponent$annotations() {
    }

    /* JADX INFO: renamed from: getUnitDiscriminator-impl, reason: not valid java name */
    private static final int m1956getUnitDiscriminatorimpl(long j) {
        return ((int) j) & 1;
    }

    /* JADX INFO: renamed from: getValue-impl, reason: not valid java name */
    private static final long m1957getValueimpl(long j) {
        return j >> 1;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1958hashCodeimpl(long j) {
        return kotlin.UByte$$ExternalSyntheticBackport0.m(j);
    }

    /* JADX INFO: renamed from: isInMillis-impl, reason: not valid java name */
    private static final boolean m1960isInMillisimpl(long j) {
        return (((int) j) & 1) == 1;
    }

    /* JADX INFO: renamed from: isInNanos-impl, reason: not valid java name */
    private static final boolean m1961isInNanosimpl(long j) {
        return (((int) j) & 1) == 0;
    }

    /* JADX INFO: renamed from: isNegative-impl, reason: not valid java name */
    public static final boolean m1963isNegativeimpl(long j) {
        return j < 0;
    }

    /* JADX INFO: renamed from: isPositive-impl, reason: not valid java name */
    public static final boolean m1964isPositiveimpl(long j) {
        return j > 0;
    }

    public boolean equals(java.lang.Object other) {
        return m1941equalsimpl(this.rawValue, other);
    }

    public int hashCode() {
        return m1958hashCodeimpl(this.rawValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getRawValue() {
        return this.rawValue;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(kotlin.time.Duration duration) {
        return m1982compareToLRDsOJo(duration.getRawValue());
    }

    private /* synthetic */ Duration(long j) {
        this.rawValue = j;
    }

    /* JADX INFO: renamed from: getStorageUnit-impl, reason: not valid java name */
    private static final kotlin.time.DurationUnit m1955getStorageUnitimpl(long j) {
        return m1961isInNanosimpl(j) ? kotlin.time.DurationUnit.NANOSECONDS : kotlin.time.DurationUnit.MILLISECONDS;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m1937constructorimpl(long j) {
        if (!kotlin.time.DurationJvmKt.getDurationAssertionsEnabled()) {
            return j;
        }
        if (m1961isInNanosimpl(j)) {
            long jM1957getValueimpl = m1957getValueimpl(j);
            if (-4611686018426999999L <= jM1957getValueimpl && jM1957getValueimpl < 4611686018427000000L) {
                return j;
            }
            throw new java.lang.AssertionError(m1957getValueimpl(j) + " ns is out of nanoseconds range");
        }
        long jM1957getValueimpl2 = m1957getValueimpl(j);
        if (-4611686018427387903L > jM1957getValueimpl2 || jM1957getValueimpl2 >= 4611686018427387904L) {
            throw new java.lang.AssertionError(m1957getValueimpl(j) + " ms is out of milliseconds range");
        }
        long jM1957getValueimpl3 = m1957getValueimpl(j);
        if (-4611686018426L > jM1957getValueimpl3 || jM1957getValueimpl3 >= 4611686018427L) {
            return j;
        }
        throw new java.lang.AssertionError(m1957getValueimpl(j) + " ms is denormalized");
    }

    /* JADX INFO: compiled from: Duration.kt */
    @kotlin.Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0007J\u0015\u00100\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u000201¢\u0006\u0004\b2\u00103J\u0015\u00104\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u000201¢\u0006\u0004\b5\u00103J\u0015\u00106\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u000201¢\u0006\u0002\b7J\u0015\u00108\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u000201¢\u0006\u0002\b9R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u001f\u0010\u0013\u001a\u00020\u0005*\u00020\u00148Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001f\u0010\u0013\u001a\u00020\u0005*\u00020\u00198Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u001a\u001a\u0004\b\u0017\u0010\u001bR\u001f\u0010\u0013\u001a\u00020\u0005*\u00020\u000e8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u001c\u001a\u0004\b\u0017\u0010\u001dR\u001f\u0010\u001e\u001a\u00020\u0005*\u00020\u00148Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0018R\u001f\u0010\u001e\u001a\u00020\u0005*\u00020\u00198Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001bR\u001f\u0010\u001e\u001a\u00020\u0005*\u00020\u000e8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u001dR\u001f\u0010!\u001a\u00020\u0005*\u00020\u00148Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0016\u001a\u0004\b#\u0010\u0018R\u001f\u0010!\u001a\u00020\u0005*\u00020\u00198Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u001a\u001a\u0004\b#\u0010\u001bR\u001f\u0010!\u001a\u00020\u0005*\u00020\u000e8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\u001dR\u001f\u0010$\u001a\u00020\u0005*\u00020\u00148Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010\u0018R\u001f\u0010$\u001a\u00020\u0005*\u00020\u00198Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u001a\u001a\u0004\b&\u0010\u001bR\u001f\u0010$\u001a\u00020\u0005*\u00020\u000e8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u001c\u001a\u0004\b&\u0010\u001dR\u001f\u0010'\u001a\u00020\u0005*\u00020\u00148Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010\u0018R\u001f\u0010'\u001a\u00020\u0005*\u00020\u00198Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010\u001a\u001a\u0004\b)\u0010\u001bR\u001f\u0010'\u001a\u00020\u0005*\u00020\u000e8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010\u001c\u001a\u0004\b)\u0010\u001dR\u001f\u0010*\u001a\u00020\u0005*\u00020\u00148Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010\u0016\u001a\u0004\b,\u0010\u0018R\u001f\u0010*\u001a\u00020\u0005*\u00020\u00198Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010\u001a\u001a\u0004\b,\u0010\u001bR\u001f\u0010*\u001a\u00020\u0005*\u00020\u000e8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010\u001c\u001a\u0004\b,\u0010\u001dR\u001f\u0010-\u001a\u00020\u0005*\u00020\u00148Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b.\u0010\u0016\u001a\u0004\b/\u0010\u0018R\u001f\u0010-\u001a\u00020\u0005*\u00020\u00198Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b.\u0010\u001a\u001a\u0004\b/\u0010\u001bR\u001f\u0010-\u001a\u00020\u0005*\u00020\u000e8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b.\u0010\u001c\u001a\u0004\b/\u0010\u001d¨\u0006:"}, d2 = {"Lkotlin/time/Duration$Companion;", "", "<init>", "()V", "ZERO", "Lkotlin/time/Duration;", "getZERO-UwyO8pc", "()J", "J", "INFINITE", "getINFINITE-UwyO8pc", "NEG_INFINITE", "getNEG_INFINITE-UwyO8pc$kotlin_stdlib", "convert", "", "value", "sourceUnit", "Lkotlin/time/DurationUnit;", "targetUnit", "nanoseconds", "", "getNanoseconds-UwyO8pc$annotations", "(I)V", "getNanoseconds-UwyO8pc", "(I)J", "", "(J)V", "(J)J", "(D)V", "(D)J", "microseconds", "getMicroseconds-UwyO8pc$annotations", "getMicroseconds-UwyO8pc", "milliseconds", "getMilliseconds-UwyO8pc$annotations", "getMilliseconds-UwyO8pc", "seconds", "getSeconds-UwyO8pc$annotations", "getSeconds-UwyO8pc", "minutes", "getMinutes-UwyO8pc$annotations", "getMinutes-UwyO8pc", "hours", "getHours-UwyO8pc$annotations", "getHours-UwyO8pc", "days", "getDays-UwyO8pc$annotations", "getDays-UwyO8pc", "parse", "", "parse-UwyO8pc", "(Ljava/lang/String;)J", "parseIsoString", "parseIsoString-UwyO8pc", "parseOrNull", "parseOrNull-FghU774", "parseIsoStringOrNull", "parseIsoStringOrNull-FghU774", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1987getDaysUwyO8pc$annotations(double d) {
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1988getDaysUwyO8pc$annotations(int i) {
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1989getDaysUwyO8pc$annotations(long j) {
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1993getHoursUwyO8pc$annotations(double d) {
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1994getHoursUwyO8pc$annotations(int i) {
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1995getHoursUwyO8pc$annotations(long j) {
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1999getMicrosecondsUwyO8pc$annotations(double d) {
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2000getMicrosecondsUwyO8pc$annotations(int i) {
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2001getMicrosecondsUwyO8pc$annotations(long j) {
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2005getMillisecondsUwyO8pc$annotations(double d) {
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2006getMillisecondsUwyO8pc$annotations(int i) {
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2007getMillisecondsUwyO8pc$annotations(long j) {
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2011getMinutesUwyO8pc$annotations(double d) {
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2012getMinutesUwyO8pc$annotations(int i) {
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2013getMinutesUwyO8pc$annotations(long j) {
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2017getNanosecondsUwyO8pc$annotations(double d) {
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2018getNanosecondsUwyO8pc$annotations(int i) {
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2019getNanosecondsUwyO8pc$annotations(long j) {
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2023getSecondsUwyO8pc$annotations(double d) {
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2024getSecondsUwyO8pc$annotations(int i) {
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2025getSecondsUwyO8pc$annotations(long j) {
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getZERO-UwyO8pc, reason: not valid java name */
        public final long m2028getZEROUwyO8pc() {
            return kotlin.time.Duration.ZERO;
        }

        /* JADX INFO: renamed from: getINFINITE-UwyO8pc, reason: not valid java name */
        public final long m2026getINFINITEUwyO8pc() {
            return kotlin.time.Duration.INFINITE;
        }

        /* JADX INFO: renamed from: getNEG_INFINITE-UwyO8pc$kotlin_stdlib, reason: not valid java name */
        public final long m2027getNEG_INFINITEUwyO8pc$kotlin_stdlib() {
            return kotlin.time.Duration.NEG_INFINITE;
        }

        public final double convert(double value, kotlin.time.DurationUnit sourceUnit, kotlin.time.DurationUnit targetUnit) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
            return kotlin.time.DurationUnitKt.convertDurationUnit(value, sourceUnit, targetUnit);
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc, reason: not valid java name */
        private final long m2015getNanosecondsUwyO8pc(int i) {
            return kotlin.time.DurationKt.toDuration(i, kotlin.time.DurationUnit.NANOSECONDS);
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc, reason: not valid java name */
        private final long m2016getNanosecondsUwyO8pc(long j) {
            return kotlin.time.DurationKt.toDuration(j, kotlin.time.DurationUnit.NANOSECONDS);
        }

        /* JADX INFO: renamed from: getNanoseconds-UwyO8pc, reason: not valid java name */
        private final long m2014getNanosecondsUwyO8pc(double d) {
            return kotlin.time.DurationKt.toDuration(d, kotlin.time.DurationUnit.NANOSECONDS);
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc, reason: not valid java name */
        private final long m1997getMicrosecondsUwyO8pc(int i) {
            return kotlin.time.DurationKt.toDuration(i, kotlin.time.DurationUnit.MICROSECONDS);
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc, reason: not valid java name */
        private final long m1998getMicrosecondsUwyO8pc(long j) {
            return kotlin.time.DurationKt.toDuration(j, kotlin.time.DurationUnit.MICROSECONDS);
        }

        /* JADX INFO: renamed from: getMicroseconds-UwyO8pc, reason: not valid java name */
        private final long m1996getMicrosecondsUwyO8pc(double d) {
            return kotlin.time.DurationKt.toDuration(d, kotlin.time.DurationUnit.MICROSECONDS);
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc, reason: not valid java name */
        private final long m2003getMillisecondsUwyO8pc(int i) {
            return kotlin.time.DurationKt.toDuration(i, kotlin.time.DurationUnit.MILLISECONDS);
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc, reason: not valid java name */
        private final long m2004getMillisecondsUwyO8pc(long j) {
            return kotlin.time.DurationKt.toDuration(j, kotlin.time.DurationUnit.MILLISECONDS);
        }

        /* JADX INFO: renamed from: getMilliseconds-UwyO8pc, reason: not valid java name */
        private final long m2002getMillisecondsUwyO8pc(double d) {
            return kotlin.time.DurationKt.toDuration(d, kotlin.time.DurationUnit.MILLISECONDS);
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc, reason: not valid java name */
        private final long m2021getSecondsUwyO8pc(int i) {
            return kotlin.time.DurationKt.toDuration(i, kotlin.time.DurationUnit.SECONDS);
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc, reason: not valid java name */
        private final long m2022getSecondsUwyO8pc(long j) {
            return kotlin.time.DurationKt.toDuration(j, kotlin.time.DurationUnit.SECONDS);
        }

        /* JADX INFO: renamed from: getSeconds-UwyO8pc, reason: not valid java name */
        private final long m2020getSecondsUwyO8pc(double d) {
            return kotlin.time.DurationKt.toDuration(d, kotlin.time.DurationUnit.SECONDS);
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc, reason: not valid java name */
        private final long m2009getMinutesUwyO8pc(int i) {
            return kotlin.time.DurationKt.toDuration(i, kotlin.time.DurationUnit.MINUTES);
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc, reason: not valid java name */
        private final long m2010getMinutesUwyO8pc(long j) {
            return kotlin.time.DurationKt.toDuration(j, kotlin.time.DurationUnit.MINUTES);
        }

        /* JADX INFO: renamed from: getMinutes-UwyO8pc, reason: not valid java name */
        private final long m2008getMinutesUwyO8pc(double d) {
            return kotlin.time.DurationKt.toDuration(d, kotlin.time.DurationUnit.MINUTES);
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc, reason: not valid java name */
        private final long m1991getHoursUwyO8pc(int i) {
            return kotlin.time.DurationKt.toDuration(i, kotlin.time.DurationUnit.HOURS);
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc, reason: not valid java name */
        private final long m1992getHoursUwyO8pc(long j) {
            return kotlin.time.DurationKt.toDuration(j, kotlin.time.DurationUnit.HOURS);
        }

        /* JADX INFO: renamed from: getHours-UwyO8pc, reason: not valid java name */
        private final long m1990getHoursUwyO8pc(double d) {
            return kotlin.time.DurationKt.toDuration(d, kotlin.time.DurationUnit.HOURS);
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc, reason: not valid java name */
        private final long m1985getDaysUwyO8pc(int i) {
            return kotlin.time.DurationKt.toDuration(i, kotlin.time.DurationUnit.DAYS);
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc, reason: not valid java name */
        private final long m1986getDaysUwyO8pc(long j) {
            return kotlin.time.DurationKt.toDuration(j, kotlin.time.DurationUnit.DAYS);
        }

        /* JADX INFO: renamed from: getDays-UwyO8pc, reason: not valid java name */
        private final long m1984getDaysUwyO8pc(double d) {
            return kotlin.time.DurationKt.toDuration(d, kotlin.time.DurationUnit.DAYS);
        }

        /* JADX INFO: renamed from: parse-UwyO8pc, reason: not valid java name */
        public final long m2029parseUwyO8pc(java.lang.String value) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
            try {
                return kotlin.time.DurationKt.parseDuration(value, false);
            } catch (java.lang.IllegalArgumentException e) {
                throw new java.lang.IllegalArgumentException("Invalid duration string format: '" + value + "'.", e);
            }
        }

        /* JADX INFO: renamed from: parseIsoString-UwyO8pc, reason: not valid java name */
        public final long m2030parseIsoStringUwyO8pc(java.lang.String value) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
            try {
                return kotlin.time.DurationKt.parseDuration(value, true);
            } catch (java.lang.IllegalArgumentException e) {
                throw new java.lang.IllegalArgumentException("Invalid ISO duration string format: '" + value + "'.", e);
            }
        }

        /* JADX INFO: renamed from: parseOrNull-FghU774, reason: not valid java name */
        public final kotlin.time.Duration m2032parseOrNullFghU774(java.lang.String value) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
            try {
                return kotlin.time.Duration.m1935boximpl(kotlin.time.DurationKt.parseDuration(value, false));
            } catch (java.lang.IllegalArgumentException unused) {
                return null;
            }
        }

        /* JADX INFO: renamed from: parseIsoStringOrNull-FghU774, reason: not valid java name */
        public final kotlin.time.Duration m2031parseIsoStringOrNullFghU774(java.lang.String value) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
            try {
                return kotlin.time.Duration.m1935boximpl(kotlin.time.DurationKt.parseDuration(value, true));
            } catch (java.lang.IllegalArgumentException unused) {
                return null;
            }
        }
    }

    /* JADX INFO: renamed from: unaryMinus-UwyO8pc, reason: not valid java name */
    public static final long m1981unaryMinusUwyO8pc(long j) {
        return kotlin.time.DurationKt.durationOf(-m1957getValueimpl(j), ((int) j) & 1);
    }

    /* JADX INFO: renamed from: plus-LRDsOJo, reason: not valid java name */
    public static final long m1966plusLRDsOJo(long j, long j2) {
        if (m1962isInfiniteimpl(j)) {
            if (m1959isFiniteimpl(j2) || (j2 ^ j) >= 0) {
                return j;
            }
            throw new java.lang.IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        }
        if (m1962isInfiniteimpl(j2)) {
            return j2;
        }
        if ((((int) j) & 1) == (((int) j2) & 1)) {
            long jM1957getValueimpl = m1957getValueimpl(j) + m1957getValueimpl(j2);
            return m1961isInNanosimpl(j) ? kotlin.time.DurationKt.durationOfNanosNormalized(jM1957getValueimpl) : kotlin.time.DurationKt.durationOfMillisNormalized(jM1957getValueimpl);
        }
        if (m1960isInMillisimpl(j)) {
            return m1933addValuesMixedRangesUwyO8pc(j, m1957getValueimpl(j), m1957getValueimpl(j2));
        }
        return m1933addValuesMixedRangesUwyO8pc(j, m1957getValueimpl(j2), m1957getValueimpl(j));
    }

    /* JADX INFO: renamed from: addValuesMixedRanges-UwyO8pc, reason: not valid java name */
    private static final long m1933addValuesMixedRangesUwyO8pc(long j, long j2, long j3) {
        long jNanosToMillis = kotlin.time.DurationKt.nanosToMillis(j3);
        long j4 = j2 + jNanosToMillis;
        if (-4611686018426L > j4 || j4 >= 4611686018427L) {
            return kotlin.time.DurationKt.durationOfMillis(kotlin.ranges.RangesKt.coerceIn(j4, -4611686018427387903L, kotlin.time.DurationKt.MAX_MILLIS));
        }
        return kotlin.time.DurationKt.durationOfNanos(kotlin.time.DurationKt.millisToNanos(j4) + (j3 - kotlin.time.DurationKt.millisToNanos(jNanosToMillis)));
    }

    /* JADX INFO: renamed from: minus-LRDsOJo, reason: not valid java name */
    public static final long m1965minusLRDsOJo(long j, long j2) {
        return m1966plusLRDsOJo(j, m1981unaryMinusUwyO8pc(j2));
    }

    /* JADX INFO: renamed from: times-UwyO8pc, reason: not valid java name */
    public static final long m1968timesUwyO8pc(long j, int i) {
        if (m1962isInfiniteimpl(j)) {
            if (i != 0) {
                return i > 0 ? j : m1981unaryMinusUwyO8pc(j);
            }
            throw new java.lang.IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
        }
        if (i == 0) {
            return ZERO;
        }
        long jM1957getValueimpl = m1957getValueimpl(j);
        long j2 = i;
        long j3 = jM1957getValueimpl * j2;
        if (!m1961isInNanosimpl(j)) {
            if (j3 / j2 == jM1957getValueimpl) {
                return kotlin.time.DurationKt.durationOfMillis(kotlin.ranges.RangesKt.coerceIn(j3, new kotlin.ranges.LongRange(-4611686018427387903L, kotlin.time.DurationKt.MAX_MILLIS)));
            }
            return kotlin.math.MathKt.getSign(jM1957getValueimpl) * kotlin.math.MathKt.getSign(i) > 0 ? INFINITE : NEG_INFINITE;
        }
        if (-2147483647L <= jM1957getValueimpl && jM1957getValueimpl < tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_WIDE_LEFT) {
            return kotlin.time.DurationKt.durationOfNanos(j3);
        }
        if (j3 / j2 == jM1957getValueimpl) {
            return kotlin.time.DurationKt.durationOfNanosNormalized(j3);
        }
        long jNanosToMillis = kotlin.time.DurationKt.nanosToMillis(jM1957getValueimpl);
        long j4 = jNanosToMillis * j2;
        long jNanosToMillis2 = kotlin.time.DurationKt.nanosToMillis((jM1957getValueimpl - kotlin.time.DurationKt.millisToNanos(jNanosToMillis)) * j2) + j4;
        if (j4 / j2 != jNanosToMillis || (jNanosToMillis2 ^ j4) < 0) {
            return kotlin.math.MathKt.getSign(jM1957getValueimpl) * kotlin.math.MathKt.getSign(i) > 0 ? INFINITE : NEG_INFINITE;
        }
        return kotlin.time.DurationKt.durationOfMillis(kotlin.ranges.RangesKt.coerceIn(jNanosToMillis2, new kotlin.ranges.LongRange(-4611686018427387903L, kotlin.time.DurationKt.MAX_MILLIS)));
    }

    /* JADX INFO: renamed from: times-UwyO8pc, reason: not valid java name */
    public static final long m1967timesUwyO8pc(long j, double d) {
        int iRoundToInt = kotlin.math.MathKt.roundToInt(d);
        if (iRoundToInt == d) {
            return m1968timesUwyO8pc(j, iRoundToInt);
        }
        kotlin.time.DurationUnit durationUnitM1955getStorageUnitimpl = m1955getStorageUnitimpl(j);
        return kotlin.time.DurationKt.toDuration(m1973toDoubleimpl(j, durationUnitM1955getStorageUnitimpl) * d, durationUnitM1955getStorageUnitimpl);
    }

    /* JADX INFO: renamed from: div-UwyO8pc, reason: not valid java name */
    public static final long m1940divUwyO8pc(long j, int i) {
        if (i == 0) {
            if (m1964isPositiveimpl(j)) {
                return INFINITE;
            }
            if (m1963isNegativeimpl(j)) {
                return NEG_INFINITE;
            }
            throw new java.lang.IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
        }
        if (m1961isInNanosimpl(j)) {
            return kotlin.time.DurationKt.durationOfNanos(m1957getValueimpl(j) / ((long) i));
        }
        if (m1962isInfiniteimpl(j)) {
            return m1968timesUwyO8pc(j, kotlin.math.MathKt.getSign(i));
        }
        long j2 = i;
        long jM1957getValueimpl = m1957getValueimpl(j) / j2;
        if (-4611686018426L > jM1957getValueimpl || jM1957getValueimpl >= 4611686018427L) {
            return kotlin.time.DurationKt.durationOfMillis(jM1957getValueimpl);
        }
        return kotlin.time.DurationKt.durationOfNanos(kotlin.time.DurationKt.millisToNanos(jM1957getValueimpl) + (kotlin.time.DurationKt.millisToNanos(m1957getValueimpl(j) - (jM1957getValueimpl * j2)) / j2));
    }

    /* JADX INFO: renamed from: div-UwyO8pc, reason: not valid java name */
    public static final long m1939divUwyO8pc(long j, double d) {
        int iRoundToInt = kotlin.math.MathKt.roundToInt(d);
        if (iRoundToInt == d && iRoundToInt != 0) {
            return m1940divUwyO8pc(j, iRoundToInt);
        }
        kotlin.time.DurationUnit durationUnitM1955getStorageUnitimpl = m1955getStorageUnitimpl(j);
        return kotlin.time.DurationKt.toDuration(m1973toDoubleimpl(j, durationUnitM1955getStorageUnitimpl) / d, durationUnitM1955getStorageUnitimpl);
    }

    /* JADX INFO: renamed from: div-LRDsOJo, reason: not valid java name */
    public static final double m1938divLRDsOJo(long j, long j2) {
        kotlin.time.DurationUnit durationUnit = (kotlin.time.DurationUnit) kotlin.comparisons.ComparisonsKt.maxOf(m1955getStorageUnitimpl(j), m1955getStorageUnitimpl(j2));
        return m1973toDoubleimpl(j, durationUnit) / m1973toDoubleimpl(j2, durationUnit);
    }

    /* JADX INFO: renamed from: truncateTo-UwyO8pc$kotlin_stdlib, reason: not valid java name */
    public static final long m1980truncateToUwyO8pc$kotlin_stdlib(long j, kotlin.time.DurationUnit unit) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(unit, "unit");
        kotlin.time.DurationUnit durationUnitM1955getStorageUnitimpl = m1955getStorageUnitimpl(j);
        if (unit.compareTo(durationUnitM1955getStorageUnitimpl) <= 0 || m1962isInfiniteimpl(j)) {
            return j;
        }
        return kotlin.time.DurationKt.toDuration(m1957getValueimpl(j) - (m1957getValueimpl(j) % kotlin.time.DurationUnitKt.convertDurationUnit(1L, unit, durationUnitM1955getStorageUnitimpl)), durationUnitM1955getStorageUnitimpl);
    }

    /* JADX INFO: renamed from: isInfinite-impl, reason: not valid java name */
    public static final boolean m1962isInfiniteimpl(long j) {
        return j == INFINITE || j == NEG_INFINITE;
    }

    /* JADX INFO: renamed from: isFinite-impl, reason: not valid java name */
    public static final boolean m1959isFiniteimpl(long j) {
        return !m1962isInfiniteimpl(j);
    }

    /* JADX INFO: renamed from: getAbsoluteValue-UwyO8pc, reason: not valid java name */
    public static final long m1943getAbsoluteValueUwyO8pc(long j) {
        return m1963isNegativeimpl(j) ? m1981unaryMinusUwyO8pc(j) : j;
    }

    /* JADX INFO: renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public int m1982compareToLRDsOJo(long j) {
        return m1936compareToLRDsOJo(this.rawValue, j);
    }

    /* JADX INFO: renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public static int m1936compareToLRDsOJo(long j, long j2) {
        long j3 = j ^ j2;
        if (j3 < 0 || (((int) j3) & 1) == 0) {
            return kotlin.jvm.internal.Intrinsics.compare(j, j2);
        }
        int i = (((int) j) & 1) - (((int) j2) & 1);
        return m1963isNegativeimpl(j) ? -i : i;
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m1972toComponentsimpl(long j, kotlin.jvm.functions.Function5<? super java.lang.Long, ? super java.lang.Integer, ? super java.lang.Integer, ? super java.lang.Integer, ? super java.lang.Integer, ? extends T> action) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(java.lang.Long.valueOf(m1945getInWholeDaysimpl(j)), java.lang.Integer.valueOf(m1944getHoursComponentimpl(j)), java.lang.Integer.valueOf(m1952getMinutesComponentimpl(j)), java.lang.Integer.valueOf(m1954getSecondsComponentimpl(j)), java.lang.Integer.valueOf(m1953getNanosecondsComponentimpl(j)));
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m1971toComponentsimpl(long j, kotlin.jvm.functions.Function4<? super java.lang.Long, ? super java.lang.Integer, ? super java.lang.Integer, ? super java.lang.Integer, ? extends T> action) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(java.lang.Long.valueOf(m1946getInWholeHoursimpl(j)), java.lang.Integer.valueOf(m1952getMinutesComponentimpl(j)), java.lang.Integer.valueOf(m1954getSecondsComponentimpl(j)), java.lang.Integer.valueOf(m1953getNanosecondsComponentimpl(j)));
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m1970toComponentsimpl(long j, kotlin.jvm.functions.Function3<? super java.lang.Long, ? super java.lang.Integer, ? super java.lang.Integer, ? extends T> action) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(java.lang.Long.valueOf(m1949getInWholeMinutesimpl(j)), java.lang.Integer.valueOf(m1954getSecondsComponentimpl(j)), java.lang.Integer.valueOf(m1953getNanosecondsComponentimpl(j)));
    }

    /* JADX INFO: renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m1969toComponentsimpl(long j, kotlin.jvm.functions.Function2<? super java.lang.Long, ? super java.lang.Integer, ? extends T> action) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(java.lang.Long.valueOf(m1951getInWholeSecondsimpl(j)), java.lang.Integer.valueOf(m1953getNanosecondsComponentimpl(j)));
    }

    /* JADX INFO: renamed from: getHoursComponent-impl, reason: not valid java name */
    public static final int m1944getHoursComponentimpl(long j) {
        if (m1962isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m1946getInWholeHoursimpl(j) % ((long) 24));
    }

    /* JADX INFO: renamed from: getMinutesComponent-impl, reason: not valid java name */
    public static final int m1952getMinutesComponentimpl(long j) {
        if (m1962isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m1949getInWholeMinutesimpl(j) % ((long) 60));
    }

    /* JADX INFO: renamed from: getSecondsComponent-impl, reason: not valid java name */
    public static final int m1954getSecondsComponentimpl(long j) {
        if (m1962isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m1951getInWholeSecondsimpl(j) % ((long) 60));
    }

    /* JADX INFO: renamed from: getNanosecondsComponent-impl, reason: not valid java name */
    public static final int m1953getNanosecondsComponentimpl(long j) {
        long jM1957getValueimpl;
        if (m1962isInfiniteimpl(j)) {
            return 0;
        }
        if (m1960isInMillisimpl(j)) {
            jM1957getValueimpl = kotlin.time.DurationKt.millisToNanos(m1957getValueimpl(j) % ((long) 1000));
        } else {
            jM1957getValueimpl = m1957getValueimpl(j) % ((long) kotlin.time.InstantKt.NANOS_PER_SECOND);
        }
        return (int) jM1957getValueimpl;
    }

    /* JADX INFO: renamed from: toDouble-impl, reason: not valid java name */
    public static final double m1973toDoubleimpl(long j, kotlin.time.DurationUnit unit) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(unit, "unit");
        if (j == INFINITE) {
            return Double.POSITIVE_INFINITY;
        }
        if (j == NEG_INFINITE) {
            return Double.NEGATIVE_INFINITY;
        }
        return kotlin.time.DurationUnitKt.convertDurationUnit(m1957getValueimpl(j), m1955getStorageUnitimpl(j), unit);
    }

    /* JADX INFO: renamed from: toLong-impl, reason: not valid java name */
    public static final long m1976toLongimpl(long j, kotlin.time.DurationUnit unit) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(unit, "unit");
        if (j == INFINITE) {
            return Long.MAX_VALUE;
        }
        if (j == NEG_INFINITE) {
            return Long.MIN_VALUE;
        }
        return kotlin.time.DurationUnitKt.convertDurationUnit(m1957getValueimpl(j), m1955getStorageUnitimpl(j), unit);
    }

    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    public static final int m1974toIntimpl(long j, kotlin.time.DurationUnit unit) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(unit, "unit");
        return (int) kotlin.ranges.RangesKt.coerceIn(m1976toLongimpl(j, unit), -2147483648L, 2147483647L);
    }

    /* JADX INFO: renamed from: getInWholeDays-impl, reason: not valid java name */
    public static final long m1945getInWholeDaysimpl(long j) {
        return m1976toLongimpl(j, kotlin.time.DurationUnit.DAYS);
    }

    /* JADX INFO: renamed from: getInWholeHours-impl, reason: not valid java name */
    public static final long m1946getInWholeHoursimpl(long j) {
        return m1976toLongimpl(j, kotlin.time.DurationUnit.HOURS);
    }

    /* JADX INFO: renamed from: getInWholeMinutes-impl, reason: not valid java name */
    public static final long m1949getInWholeMinutesimpl(long j) {
        return m1976toLongimpl(j, kotlin.time.DurationUnit.MINUTES);
    }

    /* JADX INFO: renamed from: getInWholeSeconds-impl, reason: not valid java name */
    public static final long m1951getInWholeSecondsimpl(long j) {
        return m1976toLongimpl(j, kotlin.time.DurationUnit.SECONDS);
    }

    /* JADX INFO: renamed from: getInWholeMilliseconds-impl, reason: not valid java name */
    public static final long m1948getInWholeMillisecondsimpl(long j) {
        return (m1960isInMillisimpl(j) && m1959isFiniteimpl(j)) ? m1957getValueimpl(j) : m1976toLongimpl(j, kotlin.time.DurationUnit.MILLISECONDS);
    }

    /* JADX INFO: renamed from: getInWholeMicroseconds-impl, reason: not valid java name */
    public static final long m1947getInWholeMicrosecondsimpl(long j) {
        return m1976toLongimpl(j, kotlin.time.DurationUnit.MICROSECONDS);
    }

    /* JADX INFO: renamed from: getInWholeNanoseconds-impl, reason: not valid java name */
    public static final long m1950getInWholeNanosecondsimpl(long j) {
        long jM1957getValueimpl = m1957getValueimpl(j);
        if (m1961isInNanosimpl(j)) {
            return jM1957getValueimpl;
        }
        if (jM1957getValueimpl > 9223372036854L) {
            return Long.MAX_VALUE;
        }
        if (jM1957getValueimpl < -9223372036854L) {
            return Long.MIN_VALUE;
        }
        return kotlin.time.DurationKt.millisToNanos(jM1957getValueimpl);
    }

    public java.lang.String toString() {
        return m1977toStringimpl(this.rawValue);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static java.lang.String m1977toStringimpl(long j) {
        if (j == 0) {
            return "0s";
        }
        if (j == INFINITE) {
            return "Infinity";
        }
        if (j == NEG_INFINITE) {
            return "-Infinity";
        }
        boolean zM1963isNegativeimpl = m1963isNegativeimpl(j);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (zM1963isNegativeimpl) {
            sb.append('-');
        }
        long jM1943getAbsoluteValueUwyO8pc = m1943getAbsoluteValueUwyO8pc(j);
        long jM1945getInWholeDaysimpl = m1945getInWholeDaysimpl(jM1943getAbsoluteValueUwyO8pc);
        int iM1944getHoursComponentimpl = m1944getHoursComponentimpl(jM1943getAbsoluteValueUwyO8pc);
        int iM1952getMinutesComponentimpl = m1952getMinutesComponentimpl(jM1943getAbsoluteValueUwyO8pc);
        int iM1954getSecondsComponentimpl = m1954getSecondsComponentimpl(jM1943getAbsoluteValueUwyO8pc);
        int iM1953getNanosecondsComponentimpl = m1953getNanosecondsComponentimpl(jM1943getAbsoluteValueUwyO8pc);
        int i = 0;
        boolean z = jM1945getInWholeDaysimpl != 0;
        boolean z2 = iM1944getHoursComponentimpl != 0;
        boolean z3 = iM1952getMinutesComponentimpl != 0;
        boolean z4 = (iM1954getSecondsComponentimpl == 0 && iM1953getNanosecondsComponentimpl == 0) ? false : true;
        if (z) {
            sb.append(jM1945getInWholeDaysimpl);
            sb.append('d');
            i = 1;
        }
        if (z2 || (z && (z3 || z4))) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(iM1944getHoursComponentimpl);
            sb.append('h');
            i = i2;
        }
        if (z3 || (z4 && (z2 || z))) {
            int i3 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(iM1952getMinutesComponentimpl);
            sb.append('m');
            i = i3;
        }
        if (z4) {
            int i4 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            if (iM1954getSecondsComponentimpl != 0 || z || z2 || z3) {
                m1934appendFractionalimpl(j, sb, iM1954getSecondsComponentimpl, iM1953getNanosecondsComponentimpl, 9, "s", false);
            } else if (iM1953getNanosecondsComponentimpl >= 1000000) {
                m1934appendFractionalimpl(j, sb, iM1953getNanosecondsComponentimpl / kotlin.time.DurationKt.NANOS_IN_MILLIS, iM1953getNanosecondsComponentimpl % kotlin.time.DurationKt.NANOS_IN_MILLIS, 6, "ms", false);
            } else if (iM1953getNanosecondsComponentimpl >= 1000) {
                m1934appendFractionalimpl(j, sb, iM1953getNanosecondsComponentimpl / 1000, iM1953getNanosecondsComponentimpl % 1000, 3, "us", false);
            } else {
                sb.append(iM1953getNanosecondsComponentimpl);
                sb.append(io.dcloud.common.constant.AbsoluteConst.XML_NS);
            }
            i = i4;
        }
        if (zM1963isNegativeimpl && i > 1) {
            sb.insert(1, com.taobao.weex.el.parse.Operators.BRACKET_START).append(com.taobao.weex.el.parse.Operators.BRACKET_END);
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: appendFractional-impl, reason: not valid java name */
    private static final void m1934appendFractionalimpl(long j, java.lang.StringBuilder sb, int i, int i2, int i3, java.lang.String str, boolean z) {
        sb.append(i);
        if (i2 != 0) {
            sb.append(com.taobao.weex.el.parse.Operators.DOT);
            java.lang.String strPadStart = kotlin.text.StringsKt.padStart(java.lang.String.valueOf(i2), i3, '0');
            int i4 = -1;
            int length = strPadStart.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i5 = length - 1;
                    if (strPadStart.charAt(length) != '0') {
                        i4 = length;
                        break;
                    } else if (i5 < 0) {
                        break;
                    } else {
                        length = i5;
                    }
                }
            }
            int i6 = i4 + 1;
            if (!z && i6 < 3) {
                sb.append((java.lang.CharSequence) strPadStart, 0, i6);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            } else {
                sb.append((java.lang.CharSequence) strPadStart, 0, ((i4 + 3) / 3) * 3);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            }
        }
        sb.append(str);
    }

    /* JADX INFO: renamed from: toString-impl$default, reason: not valid java name */
    public static /* synthetic */ java.lang.String m1979toStringimpl$default(long j, kotlin.time.DurationUnit durationUnit, int i, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return m1978toStringimpl(j, durationUnit, i);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static final java.lang.String m1978toStringimpl(long j, kotlin.time.DurationUnit unit, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(unit, "unit");
        if (i < 0) {
            throw new java.lang.IllegalArgumentException(("decimals must be not negative, but was " + i).toString());
        }
        double dM1973toDoubleimpl = m1973toDoubleimpl(j, unit);
        if (java.lang.Double.isInfinite(dM1973toDoubleimpl)) {
            return java.lang.String.valueOf(dM1973toDoubleimpl);
        }
        return kotlin.time.DurationJvmKt.formatToExactDecimals(dM1973toDoubleimpl, kotlin.ranges.RangesKt.coerceAtMost(i, 12)) + kotlin.time.DurationUnitKt.shortName(unit);
    }

    /* JADX INFO: renamed from: toIsoString-impl, reason: not valid java name */
    public static final java.lang.String m1975toIsoStringimpl(long j) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (m1963isNegativeimpl(j)) {
            sb.append('-');
        }
        sb.append("PT");
        long jM1943getAbsoluteValueUwyO8pc = m1943getAbsoluteValueUwyO8pc(j);
        long jM1946getInWholeHoursimpl = m1946getInWholeHoursimpl(jM1943getAbsoluteValueUwyO8pc);
        int iM1952getMinutesComponentimpl = m1952getMinutesComponentimpl(jM1943getAbsoluteValueUwyO8pc);
        int iM1954getSecondsComponentimpl = m1954getSecondsComponentimpl(jM1943getAbsoluteValueUwyO8pc);
        int iM1953getNanosecondsComponentimpl = m1953getNanosecondsComponentimpl(jM1943getAbsoluteValueUwyO8pc);
        long j2 = m1962isInfiniteimpl(j) ? 9999999999999L : jM1946getInWholeHoursimpl;
        boolean z = true;
        boolean z2 = j2 != 0;
        boolean z3 = (iM1954getSecondsComponentimpl == 0 && iM1953getNanosecondsComponentimpl == 0) ? false : true;
        if (iM1952getMinutesComponentimpl == 0 && (!z3 || !z2)) {
            z = false;
        }
        if (z2) {
            sb.append(j2);
            sb.append('H');
        }
        if (z) {
            sb.append(iM1952getMinutesComponentimpl);
            sb.append('M');
        }
        if (z3 || (!z2 && !z)) {
            m1934appendFractionalimpl(j, sb, iM1954getSecondsComponentimpl, iM1953getNanosecondsComponentimpl, 9, "S", true);
        }
        return sb.toString();
    }
}
