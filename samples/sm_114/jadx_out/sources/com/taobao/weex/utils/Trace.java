package com.taobao.weex.utils;

/* JADX INFO: loaded from: classes.dex */
public class Trace {
    private static final java.lang.String TAG = "Weex_Trace";
    private static final boolean sEnabled = false;
    private static final com.taobao.weex.utils.Trace.AbstractTrace sTrace = new com.taobao.weex.utils.Trace.TraceDummy();

    private static abstract class AbstractTrace {
        abstract void beginSection(java.lang.String str);

        abstract void endSection();

        private AbstractTrace() {
        }
    }

    public static final boolean getTraceEnabled() {
        return sEnabled;
    }

    public static void beginSection(java.lang.String str) {
        android.util.Log.i(TAG, "beginSection() " + str);
        sTrace.beginSection(str);
    }

    public static void endSection() {
        sTrace.endSection();
        android.util.Log.i(TAG, "endSection()");
    }

    private static final class TraceJBMR2 extends com.taobao.weex.utils.Trace.AbstractTrace {
        private TraceJBMR2() {
            super();
        }

        @Override // com.taobao.weex.utils.Trace.AbstractTrace
        void beginSection(java.lang.String str) {
            android.os.Trace.beginSection(str);
        }

        @Override // com.taobao.weex.utils.Trace.AbstractTrace
        void endSection() {
            android.os.Trace.endSection();
        }
    }

    private static final class TraceDummy extends com.taobao.weex.utils.Trace.AbstractTrace {
        @Override // com.taobao.weex.utils.Trace.AbstractTrace
        void beginSection(java.lang.String str) {
        }

        @Override // com.taobao.weex.utils.Trace.AbstractTrace
        void endSection() {
        }

        private TraceDummy() {
            super();
        }
    }
}
