package kotlin.time;

/* JADX INFO: compiled from: measureTime.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0005\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0007\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\t\u001a3\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\u0004\b\u0000\u0010\f2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\f0\u0003H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a7\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\u0004\b\u0000\u0010\f*\u00020\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\f0\u0003H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a7\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\u0004\b\u0000\u0010\f*\u00020\b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\f0\u0003H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"measureTime", "Lkotlin/time/Duration;", io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_BLOCK, "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)J", "Lkotlin/time/TimeSource;", "(Lkotlin/time/TimeSource;Lkotlin/jvm/functions/Function0;)J", "Lkotlin/time/TimeSource$Monotonic;", "(Lkotlin/time/TimeSource$Monotonic;Lkotlin/jvm/functions/Function0;)J", "measureTimedValue", "Lkotlin/time/TimedValue;", "T", "kotlin-stdlib"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class MeasureTimeKt {
    public static final long measureTime(kotlin.jvm.functions.Function0<kotlin.Unit> block) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(block, "block");
        long jM2050markNowz9LOYto = kotlin.time.TimeSource.Monotonic.INSTANCE.m2050markNowz9LOYto();
        block.invoke();
        return kotlin.time.TimeSource.Monotonic.ValueTimeMark.m2055elapsedNowUwyO8pc(jM2050markNowz9LOYto);
    }

    public static final long measureTime(kotlin.time.TimeSource timeSource, kotlin.jvm.functions.Function0<kotlin.Unit> block) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(timeSource, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(block, "block");
        kotlin.time.TimeMark timeMarkMarkNow = timeSource.markNow();
        block.invoke();
        return timeMarkMarkNow.mo1927elapsedNowUwyO8pc();
    }

    public static final long measureTime(kotlin.time.TimeSource.Monotonic monotonic, kotlin.jvm.functions.Function0<kotlin.Unit> block) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(monotonic, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(block, "block");
        long jM2050markNowz9LOYto = monotonic.m2050markNowz9LOYto();
        block.invoke();
        return kotlin.time.TimeSource.Monotonic.ValueTimeMark.m2055elapsedNowUwyO8pc(jM2050markNowz9LOYto);
    }

    public static final <T> kotlin.time.TimedValue<T> measureTimedValue(kotlin.jvm.functions.Function0<? extends T> block) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(block, "block");
        return new kotlin.time.TimedValue<>(block.invoke(), kotlin.time.TimeSource.Monotonic.ValueTimeMark.m2055elapsedNowUwyO8pc(kotlin.time.TimeSource.Monotonic.INSTANCE.m2050markNowz9LOYto()), null);
    }

    public static final <T> kotlin.time.TimedValue<T> measureTimedValue(kotlin.time.TimeSource timeSource, kotlin.jvm.functions.Function0<? extends T> block) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(timeSource, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(block, "block");
        return new kotlin.time.TimedValue<>(block.invoke(), timeSource.markNow().mo1927elapsedNowUwyO8pc(), null);
    }

    public static final <T> kotlin.time.TimedValue<T> measureTimedValue(kotlin.time.TimeSource.Monotonic monotonic, kotlin.jvm.functions.Function0<? extends T> block) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(monotonic, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(block, "block");
        return new kotlin.time.TimedValue<>(block.invoke(), kotlin.time.TimeSource.Monotonic.ValueTimeMark.m2055elapsedNowUwyO8pc(monotonic.m2050markNowz9LOYto()), null);
    }
}
