package kotlin.concurrent;

/* JADX INFO: compiled from: Timer.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001a;\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001a;\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001a;\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001a;\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001a\u001a\u0010\r\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0001\u001aO\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001aM\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001aO\u0010\u0014\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001aM\u0010\u0014\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001a'\u0010\u0015\u001a\u00020\u00012\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0016"}, d2 = {"schedule", "Ljava/util/TimerTask;", "Ljava/util/Timer;", io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_DELAY, "", "action", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", com.taobao.weex.common.Constants.Value.TIME, "Ljava/util/Date;", "period", "scheduleAtFixedRate", "timer", "name", "", "daemon", "", "initialDelay", "startAt", "fixedRateTimer", "timerTask", "kotlin-stdlib"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TimersKt {
    private static final java.util.TimerTask schedule(java.util.Timer timer, long j, kotlin.jvm.functions.Function1<? super java.util.TimerTask, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(timer, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        kotlin.concurrent.TimersKt.AnonymousClass1 anonymousClass1 = new kotlin.concurrent.TimersKt.AnonymousClass1(action);
        timer.schedule(anonymousClass1, j);
        return anonymousClass1;
    }

    private static final java.util.TimerTask schedule(java.util.Timer timer, java.util.Date time, kotlin.jvm.functions.Function1<? super java.util.TimerTask, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(timer, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(time, "time");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        kotlin.concurrent.TimersKt.AnonymousClass1 anonymousClass1 = new kotlin.concurrent.TimersKt.AnonymousClass1(action);
        timer.schedule(anonymousClass1, time);
        return anonymousClass1;
    }

    private static final java.util.TimerTask schedule(java.util.Timer timer, long j, long j2, kotlin.jvm.functions.Function1<? super java.util.TimerTask, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(timer, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        kotlin.concurrent.TimersKt.AnonymousClass1 anonymousClass1 = new kotlin.concurrent.TimersKt.AnonymousClass1(action);
        timer.schedule(anonymousClass1, j, j2);
        return anonymousClass1;
    }

    private static final java.util.TimerTask schedule(java.util.Timer timer, java.util.Date time, long j, kotlin.jvm.functions.Function1<? super java.util.TimerTask, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(timer, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(time, "time");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        kotlin.concurrent.TimersKt.AnonymousClass1 anonymousClass1 = new kotlin.concurrent.TimersKt.AnonymousClass1(action);
        timer.schedule(anonymousClass1, time, j);
        return anonymousClass1;
    }

    private static final java.util.TimerTask scheduleAtFixedRate(java.util.Timer timer, long j, long j2, kotlin.jvm.functions.Function1<? super java.util.TimerTask, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(timer, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        kotlin.concurrent.TimersKt.AnonymousClass1 anonymousClass1 = new kotlin.concurrent.TimersKt.AnonymousClass1(action);
        timer.scheduleAtFixedRate(anonymousClass1, j, j2);
        return anonymousClass1;
    }

    private static final java.util.TimerTask scheduleAtFixedRate(java.util.Timer timer, java.util.Date time, long j, kotlin.jvm.functions.Function1<? super java.util.TimerTask, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(timer, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(time, "time");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        kotlin.concurrent.TimersKt.AnonymousClass1 anonymousClass1 = new kotlin.concurrent.TimersKt.AnonymousClass1(action);
        timer.scheduleAtFixedRate(anonymousClass1, time, j);
        return anonymousClass1;
    }

    public static final java.util.Timer timer(java.lang.String str, boolean z) {
        return str == null ? new java.util.Timer(z) : new java.util.Timer(str, z);
    }

    static /* synthetic */ java.util.Timer timer$default(java.lang.String str, boolean z, long j, long j2, kotlin.jvm.functions.Function1 action, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            j = 0;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        java.util.Timer timer = timer(str, z);
        timer.schedule(new kotlin.concurrent.TimersKt.AnonymousClass1(action), j, j2);
        return timer;
    }

    private static final java.util.Timer timer(java.lang.String str, boolean z, long j, long j2, kotlin.jvm.functions.Function1<? super java.util.TimerTask, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        java.util.Timer timer = timer(str, z);
        timer.schedule(new kotlin.concurrent.TimersKt.AnonymousClass1(action), j, j2);
        return timer;
    }

    static /* synthetic */ java.util.Timer timer$default(java.lang.String str, boolean z, java.util.Date startAt, long j, kotlin.jvm.functions.Function1 action, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(startAt, "startAt");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        java.util.Timer timer = timer(str, z);
        timer.schedule(new kotlin.concurrent.TimersKt.AnonymousClass1(action), startAt, j);
        return timer;
    }

    private static final java.util.Timer timer(java.lang.String str, boolean z, java.util.Date startAt, long j, kotlin.jvm.functions.Function1<? super java.util.TimerTask, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(startAt, "startAt");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        java.util.Timer timer = timer(str, z);
        timer.schedule(new kotlin.concurrent.TimersKt.AnonymousClass1(action), startAt, j);
        return timer;
    }

    static /* synthetic */ java.util.Timer fixedRateTimer$default(java.lang.String str, boolean z, long j, long j2, kotlin.jvm.functions.Function1 action, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            j = 0;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        java.util.Timer timer = timer(str, z);
        timer.scheduleAtFixedRate(new kotlin.concurrent.TimersKt.AnonymousClass1(action), j, j2);
        return timer;
    }

    private static final java.util.Timer fixedRateTimer(java.lang.String str, boolean z, long j, long j2, kotlin.jvm.functions.Function1<? super java.util.TimerTask, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        java.util.Timer timer = timer(str, z);
        timer.scheduleAtFixedRate(new kotlin.concurrent.TimersKt.AnonymousClass1(action), j, j2);
        return timer;
    }

    static /* synthetic */ java.util.Timer fixedRateTimer$default(java.lang.String str, boolean z, java.util.Date startAt, long j, kotlin.jvm.functions.Function1 action, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(startAt, "startAt");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        java.util.Timer timer = timer(str, z);
        timer.scheduleAtFixedRate(new kotlin.concurrent.TimersKt.AnonymousClass1(action), startAt, j);
        return timer;
    }

    private static final java.util.Timer fixedRateTimer(java.lang.String str, boolean z, java.util.Date startAt, long j, kotlin.jvm.functions.Function1<? super java.util.TimerTask, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(startAt, "startAt");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        java.util.Timer timer = timer(str, z);
        timer.scheduleAtFixedRate(new kotlin.concurrent.TimersKt.AnonymousClass1(action), startAt, j);
        return timer;
    }

    /* JADX INFO: renamed from: kotlin.concurrent.TimersKt$timerTask$1, reason: invalid class name */
    /* JADX INFO: compiled from: Timer.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", "", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 176)
    public static final class AnonymousClass1 extends java.util.TimerTask {
        final /* synthetic */ kotlin.jvm.functions.Function1<java.util.TimerTask, kotlin.Unit> $action;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(kotlin.jvm.functions.Function1<? super java.util.TimerTask, kotlin.Unit> function1) {
            this.$action = function1;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.$action.invoke(this);
        }
    }

    private static final java.util.TimerTask timerTask(kotlin.jvm.functions.Function1<? super java.util.TimerTask, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        return new kotlin.concurrent.TimersKt.AnonymousClass1(action);
    }
}
