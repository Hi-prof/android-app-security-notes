package kotlin.time.jdk8;

/* JADX INFO: compiled from: DurationConversions.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b¢\u0006\u0002\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0002*\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"toKotlinDuration", "Lkotlin/time/Duration;", "Ljava/time/Duration;", "(Ljava/time/Duration;)J", "toJavaDuration", "toJavaDuration-LRDsOJo", "(J)Ljava/time/Duration;", "kotlin-stdlib-jdk8"}, k = 2, mv = {2, 2, 0}, pn = "kotlin.time", xi = 48)
public final class DurationConversionsJDK8Kt {
    private static final long toKotlinDuration(java.time.Duration duration) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(duration, "<this>");
        return kotlin.time.Duration.m1966plusLRDsOJo(kotlin.time.DurationKt.toDuration(duration.getSeconds(), kotlin.time.DurationUnit.SECONDS), kotlin.time.DurationKt.toDuration(duration.getNano(), kotlin.time.DurationUnit.NANOSECONDS));
    }

    /* JADX INFO: renamed from: toJavaDuration-LRDsOJo, reason: not valid java name */
    private static final java.time.Duration m2073toJavaDurationLRDsOJo(long j) {
        java.time.Duration durationOfSeconds = java.time.Duration.ofSeconds(kotlin.time.Duration.m1951getInWholeSecondsimpl(j), kotlin.time.Duration.m1953getNanosecondsComponentimpl(j));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(durationOfSeconds, "toComponents-impl(...)");
        return durationOfSeconds;
    }
}
