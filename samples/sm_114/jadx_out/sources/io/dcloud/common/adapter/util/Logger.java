package io.dcloud.common.adapter.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class Logger {
    public static final java.lang.String ANIMATION_TAG = "Animation_Path";
    public static final java.lang.String AUTO_POP_PUSH_TAG = "Auto_Pop_Push_Path";
    public static final java.lang.String Android_System_TAG = "Android_System_Path";
    public static final java.lang.String AppMgr_TAG = "appmgr";
    public static final java.lang.String AutoGC_TAG = "AutoGC_Path";
    public static final java.lang.String Capture_TAG = "Capture_Tag";
    protected static java.lang.String D = "D";
    protected static java.lang.String E = "E";
    private static final java.lang.String EXCEPTION_TAG = "DCloud_Exception";
    public static final java.lang.String Event_TAG = "Event_Tag";
    protected static java.lang.String I = "I";
    public static final java.lang.String LAYOUT_TAG = "Layout_Path";
    private static final java.lang.String LOGTAG = "DCloud_LOG";
    private static java.lang.String LogPath = "";
    public static final java.lang.String MAIN_TAG = "Main_Path";
    public static final java.lang.String MAP_TAG = "Map_Path";
    private static int MAX_CRASH_FILE_COUNT = 3;
    private static final java.lang.String MSC_TAG = "DCloud_";
    private static final java.lang.String STREAMSDKLOGTAG = "DCLOUD_STREAMSDK_LOG";
    public static final java.lang.String StreamApp_TAG = "stream_manager";
    private static long TIMES = 432000000;
    public static final java.lang.String TIMESTAMP_HH_MM_SS_SSS = "HH:mm:ss.SSS";
    public static final java.lang.String TIMESTAMP_YYYY_MM_DD = "yyyyMMdd";
    public static final java.lang.String TIMESTAMP_YYYY_MM_DD_HH_MM_SS_SSS = "yyyyMMdd HH:mm:ss.SSS";
    public static final java.lang.String VIEW_VISIBLE_TAG = "View_Visible_Path";
    protected static java.lang.String W = "W";
    private static boolean isHasDevFile = false;
    private static boolean isOpen = true;
    private static boolean isStoreLog = false;
    private static java.io.File mLogFile = null;
    private static java.util.HashMap<java.lang.String, java.text.SimpleDateFormat> mSimpleDateFormatCache = null;
    private static android.os.HandlerThread mWriteLogToSdCardThread = null;
    private static io.dcloud.common.adapter.util.Logger.WriteLogToSdCardThreadHandler mWriteLogToSdCardThreadHandler = null;
    static java.lang.String pkg = "";

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class WriteLogToSdCardThreadHandler extends android.os.Handler {
        public WriteLogToSdCardThreadHandler(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) throws java.lang.Throwable {
            java.io.FileOutputStream fileOutputStream;
            super.handleMessage(message);
            java.lang.Object obj = message.obj;
            if (obj == null || !(obj instanceof java.lang.String[])) {
                return;
            }
            java.lang.String[] strArr = (java.lang.String[]) obj;
            if (strArr.length < 3) {
                return;
            }
            java.lang.String strGenerateLog = io.dcloud.common.adapter.util.Logger.generateLog(strArr[0], strArr[1], strArr[2]);
            if (io.dcloud.common.adapter.util.Logger.mLogFile == null || !io.dcloud.common.adapter.util.Logger.mLogFile.exists() || strGenerateLog == null) {
                return;
            }
            java.io.FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    try {
                        fileOutputStream = new java.io.FileOutputStream(io.dcloud.common.adapter.util.Logger.mLogFile, true);
                        try {
                            fileOutputStream.write(strGenerateLog.getBytes());
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        } catch (java.lang.Exception e) {
                            e = e;
                            fileOutputStream2 = fileOutputStream;
                            e.printStackTrace();
                            if (fileOutputStream2 != null) {
                                fileOutputStream2.close();
                            }
                        } catch (java.lang.Throwable th) {
                            th = th;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (java.io.IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (java.io.IOException e3) {
                        e3.printStackTrace();
                    }
                } catch (java.lang.Exception e4) {
                    e = e4;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
            }
        }
    }

    private static void WriteExceptionToSDcard(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.Throwable th) {
        if (th != null) {
            WriteLogToSDcard(str, str2, generateLog(str, EXCEPTION_TAG, th.getClass().getName()));
            java.lang.StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null) {
                WriteLogToSDcard(str, str2, str3);
                for (java.lang.StackTraceElement stackTraceElement : stackTrace) {
                    WriteLogToSDcard(str, str2, generateLog(str, EXCEPTION_TAG, "    at " + stackTraceElement.toString()));
                }
            }
        }
    }

    private static void WriteLogToSDcard(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.io.File file;
        if (isOpen && (file = mLogFile) != null && file.exists()) {
            initWriteLogToSdCardThread();
            android.os.Message messageObtain = android.os.Message.obtain();
            messageObtain.obj = new java.lang.String[]{str, str2, str3};
            if (io.dcloud.common.util.PdrUtil.isEmpty(mWriteLogToSdCardThreadHandler)) {
                return;
            }
            mWriteLogToSdCardThreadHandler.sendMessage(messageObtain);
        }
    }

    public static boolean canStoreLogToSDcard() {
        if (isSDcardExists() && isOpen) {
            java.io.File file = new java.io.File(LogPath);
            if (file.exists()) {
                deleteOldLog(file);
            }
            if (file.exists() && file.canWrite()) {
                isStoreLog = true;
            }
        }
        return isStoreLog;
    }

    private static java.lang.String concatString(java.lang.String str, java.lang.String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(str.length() + str2.length());
        stringBuffer.append(str).append(str2);
        return stringBuffer.toString();
    }

    public static void d(java.lang.String str, java.lang.String str2) {
        if (isOpen) {
            if (io.dcloud.common.util.BaseInfo.ISDEBUG) {
                android.util.Log.d(str, str2);
            } else {
                android.util.Log.i(str, str2);
            }
            WriteLogToSDcard(D, str, str2);
        }
    }

    protected static void deleteOldLog(java.io.File file) {
        java.io.File[] fileArrListFiles = file.listFiles();
        java.util.Date date = new java.util.Date();
        if (fileArrListFiles != null) {
            for (java.io.File file2 : fileArrListFiles) {
                if (!file2.isDirectory()) {
                    try {
                        if (date.getTime() - new java.text.SimpleDateFormat(TIMESTAMP_YYYY_MM_DD).parse(file2.getName().substring(0, 8)).getTime() > TIMES) {
                            file2.delete();
                        }
                    } catch (java.text.ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void e(java.lang.String str, java.lang.String str2) {
        if (isOpen) {
            android.util.Log.e(str, str2);
            WriteLogToSDcard(E, str, str2);
        }
    }

    public static void es(java.lang.String str, java.lang.String str2) {
        if (isOpen) {
            android.util.Log.e(str, str2);
            WriteLogToSDcard(E, str, str2);
        }
    }

    protected static java.lang.String generateLog(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(generateTimeStamp(java.lang.Boolean.TRUE)).append(com.taobao.weex.el.parse.Operators.SPACE_STR).append(str).append(" - ").append(str2).append(com.taobao.weex.el.parse.Operators.SPACE_STR).append(str3).append("\n");
        return stringBuffer.toString();
    }

    public static java.lang.String generateTimeStamp(java.lang.Boolean bool) {
        return generateTimeStamp(bool.booleanValue() ? TIMESTAMP_HH_MM_SS_SSS : TIMESTAMP_YYYY_MM_DD, new java.util.Date());
    }

    private static java.text.SimpleDateFormat getDateFormatFromCache(java.lang.String str) {
        if (mSimpleDateFormatCache == null) {
            mSimpleDateFormatCache = new java.util.HashMap<>();
        }
        if (mSimpleDateFormatCache.containsKey(str)) {
            return mSimpleDateFormatCache.get(str);
        }
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(str, java.util.Locale.ENGLISH);
        mSimpleDateFormatCache.put(str, simpleDateFormat);
        return simpleDateFormat;
    }

    public static void i(java.lang.String str, java.lang.String str2) {
        if (!isOpen || str2 == null) {
            return;
        }
        android.util.Log.i(str, str2);
        WriteLogToSDcard(I, str, str2);
    }

    private static void init(final java.lang.String str, final java.lang.String str2) {
        try {
            io.dcloud.common.util.ThreadPool.self().addThreadTask(new java.lang.Runnable() { // from class: io.dcloud.common.adapter.util.Logger.1
                @Override // java.lang.Runnable
                public void run() {
                    java.io.File[] fileArrListFiles = new java.io.File(str).listFiles();
                    if (fileArrListFiles == null || fileArrListFiles.length <= io.dcloud.common.adapter.util.Logger.MAX_CRASH_FILE_COUNT) {
                        return;
                    }
                    if (fileArrListFiles[0].getName().compareTo(fileArrListFiles[1].getName()) < 0) {
                        for (int i = 0; i < fileArrListFiles.length - io.dcloud.common.adapter.util.Logger.MAX_CRASH_FILE_COUNT; i++) {
                            if (!android.text.TextUtils.equals(str2, fileArrListFiles[i].getName())) {
                                fileArrListFiles[i].delete();
                            }
                        }
                        return;
                    }
                    for (int length = fileArrListFiles.length - 1; length >= io.dcloud.common.adapter.util.Logger.MAX_CRASH_FILE_COUNT; length--) {
                        if (!android.text.TextUtils.equals(str2, fileArrListFiles[length].getName())) {
                            fileArrListFiles[length].delete();
                        }
                    }
                }
            });
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void initLogger(android.content.Context context) {
        pkg = context.getPackageName();
        isHasDevFile = io.dcloud.common.adapter.io.DHFile.hasFile();
        boolean z = io.dcloud.common.util.BaseInfo.isBase(context) || isHasDevFile;
        isOpen = z;
        isOpen = z | io.dcloud.common.util.BaseInfo.ISDEBUG;
        if ("mounted".equalsIgnoreCase(android.os.Environment.getExternalStorageState())) {
            LogPath = io.dcloud.common.util.BaseInfo.getCrashLogsPath(context);
        }
        if (isOpen) {
            init(LogPath, io.dcloud.common.DHInterface.IApp.ConfigProperty.CONFIG_CRASH);
            init(LogPath + "crash/", null);
        }
        setOpen(isOpen);
    }

    private static void initWriteLogToSdCardThread() {
        if (mWriteLogToSdCardThread == null) {
            android.os.HandlerThread handlerThread = new android.os.HandlerThread("WriteLogToSdCardThread");
            mWriteLogToSdCardThread = handlerThread;
            handlerThread.start();
            mWriteLogToSdCardThreadHandler = new io.dcloud.common.adapter.util.Logger.WriteLogToSdCardThreadHandler(mWriteLogToSdCardThread.getLooper());
        }
    }

    public static boolean isOpen() {
        return isOpen;
    }

    protected static boolean isSDcardExists() {
        return "mounted".equals(android.os.Environment.getExternalStorageState());
    }

    public static boolean isTurnOn() {
        return isStoreLog;
    }

    public static void p(java.lang.String str, java.lang.String str2) {
        privacyLog(str, str2);
    }

    private static void privacyLog(java.lang.String str, java.lang.String str2) {
        if (isHasDevFile) {
            android.util.Log.e(str, str2);
        }
    }

    public static void setOpen(boolean z) {
        isOpen = z;
        if (z) {
            canStoreLogToSDcard();
            storeLogToSDcard();
        }
    }

    public static void stopWriteLogToSdCardThread() {
        if (mWriteLogToSdCardThread != null) {
            io.dcloud.common.adapter.util.Logger.WriteLogToSdCardThreadHandler writeLogToSdCardThreadHandler = mWriteLogToSdCardThreadHandler;
            if (writeLogToSdCardThreadHandler != null) {
                writeLogToSdCardThreadHandler.removeCallbacksAndMessages(null);
            }
            mWriteLogToSdCardThreadHandler = null;
            mWriteLogToSdCardThread.quitSafely();
            mWriteLogToSdCardThread = null;
        }
    }

    public static void storeLogToSDcard() {
        if (isStoreLog) {
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            stringBuffer.append(LogPath).append(generateTimeStamp(java.lang.Boolean.FALSE) + ".log");
            java.io.File file = new java.io.File(stringBuffer.toString());
            mLogFile = file;
            if (!file.exists()) {
                try {
                    mLogFile.createNewFile();
                } catch (java.io.IOException e) {
                    mLogFile = null;
                    e.printStackTrace();
                }
            }
            WriteLogToSDcard("日志路径:", "Logger", "path=" + stringBuffer.toString());
        }
    }

    public static void turnOff() {
        isStoreLog = false;
    }

    public static void w(java.lang.String str, java.lang.Throwable th) {
        if (isOpen) {
            if (th != null) {
                th.printStackTrace();
            }
            android.util.Log.w(EXCEPTION_TAG, str, th);
            WriteExceptionToSDcard(W, EXCEPTION_TAG, str, th);
        }
    }

    public static void p(java.lang.String str) {
        privacyLog(LOGTAG, str);
    }

    public static void e(java.lang.String str) {
        e(LOGTAG, str);
    }

    public static void es(java.lang.String str) {
        if (isOpen) {
            es(STREAMSDKLOGTAG, str);
        }
    }

    public static void i(java.lang.String str) {
        i(LOGTAG, str);
    }

    public static void w(java.lang.Throwable th) {
        w("", th);
    }

    public static void d(java.lang.String str, java.lang.Object... objArr) {
        if (isOpen) {
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            if (objArr != null) {
                for (java.lang.Object obj : objArr) {
                    stringBuffer.append(obj).append(";");
                }
            }
            if (!io.dcloud.common.util.BaseInfo.ISDEBUG) {
                android.util.Log.i(str, stringBuffer.toString());
            } else {
                android.util.Log.d(str, stringBuffer.toString());
            }
            WriteLogToSDcard(D, str, stringBuffer.toString());
        }
    }

    public static java.lang.String generateTimeStamp(java.lang.String str, java.util.Date date) {
        java.text.SimpleDateFormat dateFormatFromCache = getDateFormatFromCache(str);
        dateFormatFromCache.applyPattern(str);
        return dateFormatFromCache.format(date);
    }

    public static void d(java.lang.String str) {
        d(LOGTAG, str);
    }
}
