package io.dcloud.uts;

/* JADX INFO: compiled from: UTSTimer.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\b\u0016\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\nJ\u0006\u0010\u000e\u001a\u00020\u000fR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lio/dcloud/uts/TaskFuture;", "", "scheduledFuture", "Ljava/util/concurrent/ScheduledFuture;", "<init>", "(Ljava/util/concurrent/ScheduledFuture;)V", "handler", "Landroid/os/Handler;", "taskRun", "Lio/dcloud/uts/UTSRunnable;", "(Landroid/os/Handler;Lio/dcloud/uts/UTSRunnable;)V", "hostHandler", "hostRun", "scheduler", com.alibaba.android.bindingx.core.internal.BindingXConstants.STATE_CANCEL, "", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TaskFuture {
    private android.os.Handler hostHandler;
    private io.dcloud.uts.UTSRunnable hostRun;
    private java.util.concurrent.ScheduledFuture<?> scheduler;

    public TaskFuture(java.util.concurrent.ScheduledFuture<?> scheduledFuture) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(scheduledFuture, "scheduledFuture");
        this.scheduler = scheduledFuture;
    }

    public TaskFuture(android.os.Handler handler, io.dcloud.uts.UTSRunnable taskRun) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(handler, "handler");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(taskRun, "taskRun");
        this.hostHandler = handler;
        this.hostRun = taskRun;
    }

    public final void cancel() {
        android.os.Handler handler = this.hostHandler;
        if (handler != null && this.hostRun != null) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(handler);
            io.dcloud.uts.UTSRunnable uTSRunnable = this.hostRun;
            kotlin.jvm.internal.Intrinsics.checkNotNull(uTSRunnable);
            handler.removeCallbacks(uTSRunnable);
            io.dcloud.uts.UTSRunnable uTSRunnable2 = this.hostRun;
            kotlin.jvm.internal.Intrinsics.checkNotNull(uTSRunnable2);
            uTSRunnable2.setStop(true);
        }
        java.util.concurrent.ScheduledFuture<?> scheduledFuture = this.scheduler;
        if (scheduledFuture != null) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(scheduledFuture);
            scheduledFuture.cancel(true);
        }
    }
}
