package com.taobao.weex.utils;

/* JADX INFO: loaded from: classes.dex */
public class WXLogUtils {
    private static final java.lang.String CLAZZ_NAME_LOG_UTIL = "com.taobao.weex.devtools.common.LogUtil";
    public static final java.lang.String WEEX_PERF_TAG = "weex_perf";
    public static final java.lang.String WEEX_TAG = "weex";
    private static java.lang.StringBuilder builder = new java.lang.StringBuilder(50);
    private static java.util.HashMap<java.lang.String, java.lang.Class> clazzMaps;
    private static boolean isDebug;
    private static java.util.List<com.taobao.weex.utils.WXLogUtils.JsLogWatcher> jsLogWatcherList;
    private static com.taobao.weex.utils.WXLogUtils.LogWatcher sLogWatcher;

    public interface JsLogWatcher {
        void onJsLog(int i, java.lang.String str);
    }

    public interface LogWatcher {
        void onLog(java.lang.String str, java.lang.String str2, java.lang.String str3);
    }

    public static void performance(java.lang.String str, byte[] bArr) {
    }

    static {
        java.util.HashMap<java.lang.String, java.lang.Class> map = new java.util.HashMap<>(2);
        clazzMaps = map;
        isDebug = true;
        map.put(CLAZZ_NAME_LOG_UTIL, loadClass(CLAZZ_NAME_LOG_UTIL));
        jsLogWatcherList = new java.util.ArrayList();
    }

    public static void setIsDebug(boolean z) {
        isDebug = z;
    }

    private static java.lang.Class loadClass(java.lang.String str) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(str);
            if (cls != null) {
                try {
                    clazzMaps.put(str, cls);
                } catch (java.lang.ClassNotFoundException unused) {
                    return cls;
                }
            }
            return cls;
        } catch (java.lang.ClassNotFoundException unused2) {
            return null;
        }
    }

    public static void renderPerformanceLog(java.lang.String str, long j) {
        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            return;
        }
        com.taobao.weex.WXEnvironment.isPerf();
    }

    private static void log(java.lang.String str, java.lang.String str2, io.dcloud.feature.uniapp.utils.AbsLogLevel absLogLevel) {
        if (android.text.TextUtils.isEmpty(str2) || android.text.TextUtils.isEmpty(str) || absLogLevel == null || android.text.TextUtils.isEmpty(absLogLevel.getName()) || !isDebug) {
            return;
        }
        if (absLogLevel == com.taobao.weex.utils.LogLevel.ERROR && !android.text.TextUtils.isEmpty(str2) && str2.contains("IPCException")) {
            com.taobao.weex.performance.WXStateRecord.getInstance().recordIPCException("ipc", str2);
        }
        io.dcloud.weex.ConsoleLogUtils.consoleLog(str, str2, absLogLevel);
        com.taobao.weex.utils.WXLogUtils.LogWatcher logWatcher = sLogWatcher;
        if (logWatcher != null) {
            logWatcher.onLog(absLogLevel.getName(), str, str2);
        }
        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            if (absLogLevel.getValue() - com.taobao.weex.WXEnvironment.sLogLevel.getValue() >= 0) {
                android.util.Log.println(absLogLevel.getPriority(), str, str2);
                writeConsoleLog(absLogLevel.getName(), str2);
                return;
            }
            return;
        }
        if (absLogLevel.getValue() - com.taobao.weex.utils.LogLevel.WARN.getValue() < 0 || absLogLevel.getValue() - com.taobao.weex.WXEnvironment.sLogLevel.getValue() < 0) {
            return;
        }
        android.util.Log.println(absLogLevel.getPriority(), str, str2);
    }

    public static void v(java.lang.String str) {
        v("weex", str);
    }

    public static void d(java.lang.String str) {
        d("weex", str);
    }

    public static void d(java.lang.String str, byte[] bArr) {
        d(str, new java.lang.String(bArr));
    }

    public static void i(java.lang.String str) {
        i("weex", str);
    }

    public static void i(java.lang.String str, byte[] bArr) {
        i(str, new java.lang.String(bArr));
    }

    public static void info(java.lang.String str) {
        i("weex", str);
    }

    public static void w(java.lang.String str) {
        w("weex", str);
    }

    public static void w(java.lang.String str, byte[] bArr) {
        w(str, new java.lang.String(bArr));
    }

    public static void e(java.lang.String str) {
        e("weex", str);
    }

    public static void e(java.lang.String str, byte[] bArr) {
        e(str, new java.lang.String(bArr));
    }

    public static void wtf(java.lang.String str) {
        wtf("weex", str);
    }

    public static void d(java.lang.String str, java.lang.String str2) {
        java.util.List<com.taobao.weex.utils.WXLogUtils.JsLogWatcher> list;
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        log(str, str2, com.taobao.weex.utils.LogLevel.DEBUG);
        if (!com.taobao.weex.WXEnvironment.isApkDebugable() || !"jsLog".equals(str) || (list = jsLogWatcherList) == null || list.size() <= 0) {
            return;
        }
        for (com.taobao.weex.utils.WXLogUtils.JsLogWatcher jsLogWatcher : jsLogWatcherList) {
            if (str2.endsWith("__DEBUG")) {
                jsLogWatcher.onJsLog(3, str2.replace("__DEBUG", ""));
            } else if (str2.endsWith("__INFO")) {
                jsLogWatcher.onJsLog(3, str2.replace("__INFO", ""));
            } else if (str2.endsWith("__WARN")) {
                jsLogWatcher.onJsLog(3, str2.replace("__WARN", ""));
            } else if (str2.endsWith("__ERROR")) {
                jsLogWatcher.onJsLog(3, str2.replace("__ERROR", ""));
            } else {
                jsLogWatcher.onJsLog(3, str2);
            }
        }
    }

    private static com.taobao.weex.utils.LogLevel getLogLevel(java.lang.String str) {
        java.lang.String strTrim = str.trim();
        strTrim.hashCode();
        switch (strTrim) {
            case "__INFO":
                return com.taobao.weex.utils.LogLevel.INFO;
            case "__WARN":
                return com.taobao.weex.utils.LogLevel.WARN;
            case "__LOG":
                return com.taobao.weex.utils.LogLevel.INFO;
            case "__DEBUG":
                return com.taobao.weex.utils.LogLevel.DEBUG;
            case "__ERROR":
                return com.taobao.weex.utils.LogLevel.ERROR;
            default:
                return com.taobao.weex.utils.LogLevel.DEBUG;
        }
    }

    public static void i(java.lang.String str, java.lang.String str2) {
        log(str, str2, com.taobao.weex.utils.LogLevel.INFO);
    }

    public static void v(java.lang.String str, java.lang.String str2) {
        log(str, str2, com.taobao.weex.utils.LogLevel.VERBOSE);
    }

    public static void w(java.lang.String str, java.lang.String str2) {
        log(str, str2, com.taobao.weex.utils.LogLevel.WARN);
    }

    public static void e(java.lang.String str, java.lang.String str2) {
        log(str, str2, com.taobao.weex.utils.LogLevel.ERROR);
    }

    public static void wtf(java.lang.String str, java.lang.String str2) {
        log(str, str2, com.taobao.weex.utils.LogLevel.WTF);
    }

    public static void p(java.lang.String str) {
        d(WEEX_PERF_TAG, str);
    }

    public static void d(java.lang.String str, java.lang.Throwable th) {
        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            d(str + getStackTrace(th));
        }
    }

    public static void i(java.lang.String str, java.lang.Throwable th) {
        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            info(str + getStackTrace(th));
        }
    }

    public static void v(java.lang.String str, java.lang.Throwable th) {
        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            v(str + getStackTrace(th));
        }
    }

    public static void w(java.lang.String str, java.lang.Throwable th) {
        w(str + getStackTrace(th));
    }

    public static void e(java.lang.String str, java.lang.Throwable th) {
        e(str + getStackTrace(th));
    }

    public static void wtf(java.lang.String str, java.lang.Throwable th) {
        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            wtf(str + getStackTrace(th));
        }
    }

    public static void p(java.lang.String str, java.lang.Throwable th) {
        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            p(str + getStackTrace(th));
        }
    }

    public static void eTag(java.lang.String str, java.lang.Throwable th) {
        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            e(str, getStackTrace(th));
        }
    }

    public static java.lang.String getStackTrace(java.lang.Throwable th) throws java.lang.Throwable {
        java.io.PrintWriter printWriter;
        if (th == null) {
            return "";
        }
        java.io.StringWriter stringWriter = null;
        try {
            java.io.StringWriter stringWriter2 = new java.io.StringWriter();
            try {
                printWriter = new java.io.PrintWriter(stringWriter2);
                try {
                    th.printStackTrace(printWriter);
                    printWriter.flush();
                    stringWriter2.flush();
                    try {
                        stringWriter2.close();
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                    }
                    printWriter.close();
                    return stringWriter2.toString();
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    stringWriter = stringWriter2;
                    if (stringWriter != null) {
                        try {
                            stringWriter.close();
                        } catch (java.io.IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (printWriter != null) {
                        printWriter.close();
                        throw th;
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                printWriter = null;
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            printWriter = null;
        }
    }

    private static void writeConsoleLog(java.lang.String str, java.lang.String str2) {
        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            try {
                java.lang.Class cls = clazzMaps.get(CLAZZ_NAME_LOG_UTIL);
                if (cls != null) {
                    cls.getMethod("log", java.lang.String.class, java.lang.String.class).invoke(cls, str, str2);
                }
            } catch (java.lang.Exception unused) {
                android.util.Log.d("weex", "LogUtil not found!");
            }
        }
    }

    public static void setJsLogWatcher(com.taobao.weex.utils.WXLogUtils.JsLogWatcher jsLogWatcher) {
        if (jsLogWatcherList.contains(jsLogWatcher)) {
            return;
        }
        jsLogWatcherList.add(jsLogWatcher);
    }

    public static void setLogWatcher(com.taobao.weex.utils.WXLogUtils.LogWatcher logWatcher) {
        sLogWatcher = logWatcher;
    }
}
