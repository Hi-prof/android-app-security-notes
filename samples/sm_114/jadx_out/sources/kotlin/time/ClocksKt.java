package kotlin.time;

/* JADX INFO: compiled from: Clocks.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"asClock", "Lkotlin/time/Clock;", "Lkotlin/time/TimeSource;", "origin", "Lkotlin/time/Instant;", "fromTimeSource", "kotlin-stdlib"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ClocksKt {
    public static final kotlin.time.Clock fromTimeSource(final kotlin.time.TimeSource timeSource, final kotlin.time.Instant origin) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(timeSource, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(origin, "origin");
        return new kotlin.time.Clock(timeSource, origin) { // from class: kotlin.time.ClocksKt$asClock$1
            final /* synthetic */ kotlin.time.Instant $origin;
            private final kotlin.time.TimeMark startMark;

            {
                this.$origin = origin;
                this.startMark = timeSource.markNow();
            }

            @Override // kotlin.time.Clock
            public kotlin.time.Instant now() {
                return this.$origin.m2037plusLRDsOJo(this.startMark.mo1927elapsedNowUwyO8pc());
            }
        };
    }
}
