package com.taobao.weex.tracing;

/* JADX INFO: loaded from: classes.dex */
public class Stopwatch {
    private static final java.lang.ThreadLocal<com.taobao.weex.tracing.Stopwatch> sThreadLocal = new java.lang.ThreadLocal<>();
    private java.util.List<com.taobao.weex.tracing.Stopwatch.ProcessEvent> splits = new java.util.ArrayList();
    private long startMillis;
    private long startNanos;

    public static class ProcessEvent {
        public double duration;
        public java.lang.String fname;
        public long startMillis;
    }

    public static double nanosToMillis(long j) {
        return j / 1000000.0d;
    }

    private static void prepare() {
        java.lang.ThreadLocal<com.taobao.weex.tracing.Stopwatch> threadLocal = sThreadLocal;
        if (threadLocal.get() == null) {
            threadLocal.set(new com.taobao.weex.tracing.Stopwatch());
        }
    }

    public static void tick() {
        if (com.taobao.weex.tracing.WXTracing.isAvailable()) {
            try {
                prepare();
                java.lang.ThreadLocal<com.taobao.weex.tracing.Stopwatch> threadLocal = sThreadLocal;
                if (threadLocal.get().startNanos != 0) {
                    com.taobao.weex.utils.WXLogUtils.w("Stopwatch", "Stopwatch is not reset");
                }
                threadLocal.get().startNanos = java.lang.System.nanoTime();
                threadLocal.get().startMillis = java.lang.System.currentTimeMillis();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void split(java.lang.String str) {
        if (com.taobao.weex.tracing.WXTracing.isAvailable()) {
            try {
                com.taobao.weex.tracing.Stopwatch.ProcessEvent processEvent = new com.taobao.weex.tracing.Stopwatch.ProcessEvent();
                java.lang.ThreadLocal<com.taobao.weex.tracing.Stopwatch> threadLocal = sThreadLocal;
                long j = threadLocal.get().startMillis;
                double dTackAndTick = tackAndTick();
                processEvent.fname = str;
                processEvent.duration = dTackAndTick;
                processEvent.startMillis = j;
                threadLocal.get().splits.add(processEvent);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static java.util.List<com.taobao.weex.tracing.Stopwatch.ProcessEvent> getProcessEvents() {
        if (com.taobao.weex.tracing.WXTracing.isAvailable()) {
            tack();
            java.lang.ThreadLocal<com.taobao.weex.tracing.Stopwatch> threadLocal = sThreadLocal;
            java.util.List<com.taobao.weex.tracing.Stopwatch.ProcessEvent> list = threadLocal.get().splits;
            threadLocal.get().splits = new java.util.ArrayList();
            return list;
        }
        return java.util.Collections.EMPTY_LIST;
    }

    public static double tack() {
        if (!com.taobao.weex.tracing.WXTracing.isAvailable()) {
            return -1.0d;
        }
        try {
            java.lang.ThreadLocal<com.taobao.weex.tracing.Stopwatch> threadLocal = sThreadLocal;
            long j = threadLocal.get().startNanos;
            if (j == 0) {
                com.taobao.weex.utils.WXLogUtils.w("Stopwatch", "Should call Stopwatch.tick() before Stopwatch.tack() called");
            }
            long jNanoTime = java.lang.System.nanoTime() - j;
            threadLocal.get().startNanos = 0L;
            return nanosToMillis(jNanoTime);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return -1.0d;
        }
    }

    public static long lastTickStamp() {
        if (!com.taobao.weex.tracing.WXTracing.isAvailable()) {
            return -1L;
        }
        try {
            return sThreadLocal.get().startMillis;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return -1L;
        }
    }

    public static double tackAndTick() {
        double dTack = tack();
        tick();
        return dTack;
    }

    public static double millisUntilNow(long j) {
        return nanosToMillis(java.lang.System.nanoTime() - j);
    }
}
