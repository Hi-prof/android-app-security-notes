package io.dcloud.uts;

/* JADX INFO: compiled from: UTSTimer.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0018\u0010\u001a\u001a\u00020\u001b2\u0010\u0010\u001c\u001a\f\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u001d\u001a \u0010\u001a\u001a\u00020\u001b2\u0010\u0010\u001c\u001a\f\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u001d2\u0006\u0010\u001e\u001a\u00020\u001b\u001a \u0010\u001f\u001a\u00020\u001b2\u0010\u0010\u001c\u001a\f\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u001d2\u0006\u0010\u001e\u001a\u00020\u001b\u001a(\u0010\u001f\u001a\u00020\u001b2\u0010\u0010\u001c\u001a\f\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u001d2\u0006\u0010 \u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001b\u001a\u000e\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u001b\u001a\u000e\u0010#\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u001b\"\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\"Z\u0010\t\u001aB\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\r0\r \f* \u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\r0\r\u0018\u00010\u000e0\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\"Z\u0010\u0013\u001aB\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\r0\r \f* \u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\r0\r\u0018\u00010\u000e0\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012\"\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019*\u0016\u0010\u0000\"\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006$"}, d2 = {"TimerCallback", "Lkotlin/Function0;", "", "taskDynamicId", "Ljava/util/concurrent/atomic/AtomicInteger;", "getTaskDynamicId", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setTaskDynamicId", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "intervalTaskMap", "", "", "kotlin.jvm.PlatformType", "Lio/dcloud/uts/TaskFuture;", "", "getIntervalTaskMap", "()Ljava/util/Map;", "setIntervalTaskMap", "(Ljava/util/Map;)V", "timeoutTaskMap", "getTimeoutTaskMap", "setTimeoutTaskMap", "executorService", "Ljava/util/concurrent/ScheduledExecutorService;", "getExecutorService", "()Ljava/util/concurrent/ScheduledExecutorService;", "setTimeout", "", com.taobao.weex.bridge.WXBridgeManager.METHOD_CALLBACK, "Lio/dcloud/uts/TimerCallback;", "timeout", "setInterval", io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_DELAY, "clearTimeout", "taskId", "clearInterval", "utsplugin_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class UTSTimerKt {
    private static final java.util.concurrent.ScheduledExecutorService executorService;
    private static java.util.concurrent.atomic.AtomicInteger taskDynamicId = new java.util.concurrent.atomic.AtomicInteger(0);
    private static java.util.Map<java.lang.Integer, io.dcloud.uts.TaskFuture> intervalTaskMap = java.util.Collections.synchronizedMap(new java.util.LinkedHashMap());
    private static java.util.Map<java.lang.Integer, io.dcloud.uts.TaskFuture> timeoutTaskMap = java.util.Collections.synchronizedMap(new java.util.LinkedHashMap());

    static {
        java.util.concurrent.ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = java.util.concurrent.Executors.newScheduledThreadPool(10);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(scheduledExecutorServiceNewScheduledThreadPool, "newScheduledThreadPool(...)");
        executorService = scheduledExecutorServiceNewScheduledThreadPool;
    }

    public static final java.util.concurrent.atomic.AtomicInteger getTaskDynamicId() {
        return taskDynamicId;
    }

    public static final void setTaskDynamicId(java.util.concurrent.atomic.AtomicInteger atomicInteger) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(atomicInteger, "<set-?>");
        taskDynamicId = atomicInteger;
    }

    public static final java.util.Map<java.lang.Integer, io.dcloud.uts.TaskFuture> getIntervalTaskMap() {
        return intervalTaskMap;
    }

    public static final void setIntervalTaskMap(java.util.Map<java.lang.Integer, io.dcloud.uts.TaskFuture> map) {
        intervalTaskMap = map;
    }

    public static final java.util.Map<java.lang.Integer, io.dcloud.uts.TaskFuture> getTimeoutTaskMap() {
        return timeoutTaskMap;
    }

    public static final void setTimeoutTaskMap(java.util.Map<java.lang.Integer, io.dcloud.uts.TaskFuture> map) {
        timeoutTaskMap = map;
    }

    public static final java.util.concurrent.ScheduledExecutorService getExecutorService() {
        return executorService;
    }

    public static final synchronized java.lang.Number setTimeout(kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        return setTimeout(callback, (java.lang.Number) 0);
    }

    public static final synchronized java.lang.Number setTimeout(final kotlin.jvm.functions.Function0<kotlin.Unit> callback, java.lang.Number timeout) {
        final int iIncrementAndGet;
        io.dcloud.uts.TaskFuture taskFuture;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(timeout, "timeout");
        iIncrementAndGet = taskDynamicId.incrementAndGet();
        if (android.os.Looper.myLooper() == null) {
            java.util.concurrent.ScheduledFuture<?> scheduledFutureSchedule = executorService.schedule(new java.lang.Runnable() { // from class: io.dcloud.uts.UTSTimerKt$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    io.dcloud.uts.UTSTimerKt.setTimeout$lambda$0(callback, iIncrementAndGet);
                }
            }, timeout.longValue(), java.util.concurrent.TimeUnit.MILLISECONDS);
            kotlin.jvm.internal.Intrinsics.checkNotNull(scheduledFutureSchedule);
            taskFuture = new io.dcloud.uts.TaskFuture(scheduledFutureSchedule);
        } else {
            android.os.Looper looperMyLooper = android.os.Looper.myLooper();
            kotlin.jvm.internal.Intrinsics.checkNotNull(looperMyLooper);
            android.os.Handler handler = new android.os.Handler(looperMyLooper);
            io.dcloud.uts.UTSRunnable uTSRunnable = new io.dcloud.uts.UTSRunnable() { // from class: io.dcloud.uts.UTSTimerKt$setTimeout$runnable$1
                @Override // io.dcloud.uts.UTSRunnable
                public void doSth() {
                    callback.invoke();
                    io.dcloud.uts.UTSTimerKt.clearTimeout(java.lang.Integer.valueOf(iIncrementAndGet));
                }
            };
            handler.postDelayed(uTSRunnable, timeout.longValue());
            taskFuture = new io.dcloud.uts.TaskFuture(handler, uTSRunnable);
        }
        java.util.Map<java.lang.Integer, io.dcloud.uts.TaskFuture> timeoutTaskMap2 = timeoutTaskMap;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(timeoutTaskMap2, "timeoutTaskMap");
        timeoutTaskMap2.put(java.lang.Integer.valueOf(iIncrementAndGet), taskFuture);
        return java.lang.Integer.valueOf(iIncrementAndGet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTimeout$lambda$0(kotlin.jvm.functions.Function0 function0, int i) {
        function0.invoke();
        clearTimeout(java.lang.Integer.valueOf(i));
    }

    public static final synchronized java.lang.Number setInterval(kotlin.jvm.functions.Function0<kotlin.Unit> callback, java.lang.Number timeout) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(timeout, "timeout");
        return setInterval(callback, timeout, timeout);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [T, io.dcloud.uts.UTSTimerKt$$ExternalSyntheticLambda3] */
    public static final synchronized java.lang.Number setInterval(final kotlin.jvm.functions.Function0<kotlin.Unit> callback, java.lang.Number delay, java.lang.Number timeout) {
        io.dcloud.uts.TaskFuture taskFuture;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callback, "callback");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(delay, "delay");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(timeout, "timeout");
        if (io.dcloud.uts.NumberKt.compareTo(delay, (java.lang.Number) 0) <= 0) {
            delay = (java.lang.Number) 1;
        }
        if (io.dcloud.uts.NumberKt.compareTo(timeout, (java.lang.Number) 0) <= 0) {
            timeout = (java.lang.Number) 1;
        }
        if (android.os.Looper.myLooper() == null) {
            java.util.concurrent.ScheduledFuture<?> scheduledFutureScheduleAtFixedRate = executorService.scheduleAtFixedRate(new java.lang.Runnable() { // from class: io.dcloud.uts.UTSTimerKt$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    callback.invoke();
                }
            }, delay.longValue(), timeout.longValue(), java.util.concurrent.TimeUnit.MILLISECONDS);
            kotlin.jvm.internal.Intrinsics.checkNotNull(scheduledFutureScheduleAtFixedRate);
            taskFuture = new io.dcloud.uts.TaskFuture(scheduledFutureScheduleAtFixedRate);
        } else {
            final kotlin.jvm.internal.Ref.ObjectRef objectRef = new kotlin.jvm.internal.Ref.ObjectRef();
            objectRef.element = new kotlin.jvm.functions.Function0() { // from class: io.dcloud.uts.UTSTimerKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return io.dcloud.uts.UTSTimerKt.setInterval$lambda$2(callback);
                }
            };
            android.os.Looper looperMyLooper = android.os.Looper.myLooper();
            kotlin.jvm.internal.Intrinsics.checkNotNull(looperMyLooper);
            final android.os.Handler handler = new android.os.Handler(looperMyLooper);
            java.util.concurrent.ScheduledFuture<?> scheduledFutureScheduleAtFixedRate2 = executorService.scheduleAtFixedRate(new java.lang.Runnable() { // from class: io.dcloud.uts.UTSTimerKt$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    io.dcloud.uts.UTSTimerKt.setInterval$lambda$4(handler, objectRef);
                }
            }, delay.longValue(), timeout.longValue(), java.util.concurrent.TimeUnit.MILLISECONDS);
            kotlin.jvm.internal.Intrinsics.checkNotNull(scheduledFutureScheduleAtFixedRate2);
            taskFuture = new io.dcloud.uts.TaskFuture(scheduledFutureScheduleAtFixedRate2);
        }
        taskDynamicId.getAndIncrement();
        java.util.Map<java.lang.Integer, io.dcloud.uts.TaskFuture> intervalTaskMap2 = intervalTaskMap;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(intervalTaskMap2, "intervalTaskMap");
        intervalTaskMap2.put(java.lang.Integer.valueOf(taskDynamicId.get()), taskFuture);
        return java.lang.Integer.valueOf(taskDynamicId.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit setInterval$lambda$2(kotlin.jvm.functions.Function0 function0) {
        function0.invoke();
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setInterval$lambda$4(android.os.Handler handler, kotlin.jvm.internal.Ref.ObjectRef objectRef) {
        final kotlin.jvm.functions.Function0 function0 = (kotlin.jvm.functions.Function0) objectRef.element;
        handler.post(new java.lang.Runnable() { // from class: io.dcloud.uts.UTSTimerKt$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                function0.invoke();
            }
        });
    }

    public static final synchronized void clearTimeout(java.lang.Number taskId) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(taskId, "taskId");
        if (timeoutTaskMap.get(java.lang.Integer.valueOf(taskId.intValue())) == null) {
            return;
        }
        io.dcloud.uts.TaskFuture taskFuture = timeoutTaskMap.get(java.lang.Integer.valueOf(taskId.intValue()));
        kotlin.jvm.internal.Intrinsics.checkNotNull(taskFuture);
        taskFuture.cancel();
        timeoutTaskMap.remove(java.lang.Integer.valueOf(taskId.intValue()));
    }

    public static final synchronized void clearInterval(java.lang.Number taskId) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(taskId, "taskId");
        if (intervalTaskMap.get(java.lang.Integer.valueOf(taskId.intValue())) == null) {
            return;
        }
        io.dcloud.uts.TaskFuture taskFuture = intervalTaskMap.get(java.lang.Integer.valueOf(taskId.intValue()));
        kotlin.jvm.internal.Intrinsics.checkNotNull(taskFuture);
        taskFuture.cancel();
        intervalTaskMap.remove(java.lang.Integer.valueOf(taskId.intValue()));
    }
}
