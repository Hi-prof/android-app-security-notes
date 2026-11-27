package com.taobao.weex.tracing;

/* JADX INFO: loaded from: classes.dex */
public class WXTracing {
    private static final java.util.concurrent.atomic.AtomicInteger sIdGenerator = new java.util.concurrent.atomic.AtomicInteger(0);

    public static class TraceInfo {
        public long domQueueTime;
        public long domThreadNanos;
        public int rootEventId;
        public long uiQueueTime;
        public long uiThreadNanos;
        public long domThreadStart = -1;
        public long uiThreadStart = -1;
    }

    public static int nextId() {
        return sIdGenerator.getAndIncrement();
    }

    public static boolean isAvailable() {
        return com.taobao.weex.WXEnvironment.isApkDebugable();
    }

    public static synchronized void submit(com.taobao.weex.tracing.WXTracing.TraceEvent traceEvent) {
        com.taobao.weex.adapter.ITracingAdapter tracingAdapter = com.taobao.weex.WXSDKManager.getInstance().getTracingAdapter();
        if (tracingAdapter != null) {
            tracingAdapter.submitTracingEvent(traceEvent);
        }
    }

    public static class TraceEvent {
        public java.lang.String classname;
        public double duration;
        public java.util.Map<java.lang.String, java.lang.Object> extParams;
        public boolean firstScreenFinish;
        public java.lang.String fname;
        public java.lang.String iid;
        public boolean isSegment;
        public java.lang.String name;
        public java.lang.String parentRef;
        public double parseJsonTime;
        public java.lang.String payload;
        public java.lang.String ph;
        public java.lang.String ref;
        public android.util.SparseArray<com.taobao.weex.tracing.WXTracing.TraceEvent> subEvents;
        private boolean submitted;
        public int parentId = -1;
        public long ts = java.lang.System.currentTimeMillis();
        public int traceId = com.taobao.weex.tracing.WXTracing.nextId();
        public java.lang.String tname = com.taobao.weex.tracing.WXTracing.currentThreadName();

        public void submit() {
            if (!this.submitted) {
                this.submitted = true;
                com.taobao.weex.tracing.WXTracing.submit(this);
            } else {
                com.taobao.weex.utils.WXLogUtils.w("WXTracing", "Event " + this.traceId + " has been submitted.");
            }
        }
    }

    public static java.lang.String currentThreadName() {
        java.lang.String name = java.lang.Thread.currentThread().getName();
        if ("WeexJSBridgeThread".equals(name)) {
            return "JSThread";
        }
        if ("WeeXDomThread".equals(name)) {
            return "DOMThread";
        }
        return android.os.Looper.getMainLooper() == android.os.Looper.myLooper() ? "UIThread" : name;
    }

    public static com.taobao.weex.tracing.WXTracing.TraceEvent newEvent(java.lang.String str, java.lang.String str2, int i) {
        com.taobao.weex.tracing.WXTracing.TraceEvent traceEvent = new com.taobao.weex.tracing.WXTracing.TraceEvent();
        traceEvent.fname = str;
        traceEvent.iid = str2;
        traceEvent.traceId = nextId();
        traceEvent.parentId = i;
        return traceEvent;
    }
}
