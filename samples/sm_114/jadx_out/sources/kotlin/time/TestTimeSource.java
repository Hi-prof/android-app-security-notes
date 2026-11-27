package kotlin.time;

/* JADX INFO: compiled from: TimeSources.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlin/time/TestTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "<init>", "()V", "reading", "", "read", "plusAssign", "", "duration", "Lkotlin/time/Duration;", "plusAssign-LRDsOJo", "(J)V", com.taobao.weex.common.Constants.Name.OVERFLOW, "overflow-LRDsOJo", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TestTimeSource extends kotlin.time.AbstractLongTimeSource {
    private long reading;

    public TestTimeSource() {
        super(kotlin.time.DurationUnit.NANOSECONDS);
        markNow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.time.AbstractLongTimeSource
    /* JADX INFO: renamed from: read, reason: from getter */
    public long getReading() {
        return this.reading;
    }

    /* JADX INFO: renamed from: plusAssign-LRDsOJo, reason: not valid java name */
    public final void m2047plusAssignLRDsOJo(long duration) {
        long jM1976toLongimpl = kotlin.time.Duration.m1976toLongimpl(duration, getUnit());
        if (((jM1976toLongimpl - 1) | 1) != Long.MAX_VALUE) {
            long j = this.reading;
            long j2 = j + jM1976toLongimpl;
            if ((jM1976toLongimpl ^ j) >= 0 && (j ^ j2) < 0) {
                m2046overflowLRDsOJo(duration);
            }
            this.reading = j2;
            return;
        }
        long jM1940divUwyO8pc = kotlin.time.Duration.m1940divUwyO8pc(duration, 2);
        if ((1 | (kotlin.time.Duration.m1976toLongimpl(jM1940divUwyO8pc, getUnit()) - 1)) != Long.MAX_VALUE) {
            long j3 = this.reading;
            try {
                m2047plusAssignLRDsOJo(jM1940divUwyO8pc);
                m2047plusAssignLRDsOJo(kotlin.time.Duration.m1965minusLRDsOJo(duration, jM1940divUwyO8pc));
                return;
            } catch (java.lang.IllegalStateException e) {
                this.reading = j3;
                throw e;
            }
        }
        m2046overflowLRDsOJo(duration);
    }

    /* JADX INFO: renamed from: overflow-LRDsOJo, reason: not valid java name */
    private final void m2046overflowLRDsOJo(long duration) {
        throw new java.lang.IllegalStateException("TestTimeSource will overflow if its reading " + this.reading + kotlin.time.DurationUnitKt.shortName(getUnit()) + " is advanced by " + ((java.lang.Object) kotlin.time.Duration.m1977toStringimpl(duration)) + com.taobao.weex.el.parse.Operators.DOT);
    }
}
