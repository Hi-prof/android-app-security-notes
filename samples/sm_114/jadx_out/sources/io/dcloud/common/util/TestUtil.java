package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class TestUtil {
    public static java.lang.String CREATE_NWINDOW = "createNWindow une create";
    public static java.lang.String CREATE_SHOW_WEBVIEW_ANIMATION = "createShowWebviewAnimation";
    public static java.lang.String CREATE_VIEW_OPTIONS = "createViewOptions";
    public static java.lang.String CREATE_WEBVIEW = "createWebview";
    static final boolean DEBUG = true;
    public static java.lang.String SHOW_WEBVIEW = "showWebview";
    public static java.lang.String START_APP_SET_ROOTVIEW = "start_app_set_rootview";
    public static java.lang.String START_SHOW_WEBVIEW_ANIMATION = "startShowWebviewAnimation";
    public static java.lang.String START_STREAM_APP = "start_stream_app";
    public static java.lang.String START_STREAM_APP_RETRY = "r";
    public static java.lang.String STREAM_APP_POINT = "t";
    private static final java.lang.String TAG = "useTime";
    public static java.lang.String WEBVIEW_INIT = "webview_init";
    private static java.util.ArrayList<io.dcloud.common.util.TestUtil.Timer> mTimers = new java.util.ArrayList<>(1);
    private static java.util.HashMap mObjs = new java.util.HashMap(2);

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class DCErrorInfo {
        int ec;
        int et;

        public DCErrorInfo(int i, int i2) {
            this.ec = i;
            this.et = i2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class PointTime {
        public static final int AC_TYPE_1 = 1;
        public static final int AC_TYPE_1_0 = 1000;
        public static final int AC_TYPE_1_1 = 1100;
        public static final int AC_TYPE_1_2 = 1200;
        public static final int AC_TYPE_1_3 = 1300;
        public static final int AC_TYPE_1_4 = 1400;
        public static final int AC_TYPE_2 = 2;
        public static final int AC_TYPE_3 = 3;
        public static final int AC_TYPE_4 = 4;
        public static final int AC_TYPE_5 = 5;
        public static final int AD_CLICK = 41;
        public static final int AD_DL_COMPLETE = 30;
        public static final int AD_DL_FAILED = 32;
        public static final int AD_DL_START = 29;
        public static final int AD_DPLK = 50;
        public static final int AD_INSTALL = 31;
        public static final int AD_SIM_CLICK = 46;
        public static final int AD_SIM_VIEW = 45;
        public static final int AD_VIEW = 40;
        public static final int BEGIN_APK = 29;
        public static final int CLICK_PUSH = 20;
        public static final int CLOSE_WEBVIEW = 10;
        public static final int CONNECT_TIMEOUT_ERROR = 7;
        public static final java.lang.String DATA_CACHE_PAGES = "stream_app_cache_pages";
        public static final java.lang.String DATA_DOWNLOAD_COMPLETED = "stream_app_completed";
        public static final java.lang.String DATA_IN_APP_COMMIT_DATA = "in_app_commit_data";
        public static final java.lang.String DATA_START_TIMES = "stream_app_start_times";
        public static final java.lang.String DATA_START_TIMES_ACTIVATE = "stream_app_start_times_activate";
        public static final int DECOMPRESSION_ERROR = 15;
        public static final int ERROR_TYPE_INDEXS = 3;
        public static final int ERROR_TYPE_INDEX_ZIP = 2;
        public static final int ERROR_TYPE_STREAM = 1;
        public static final int ERROR_TYPE_WAP2APP_INDEX = 4;
        public static final int FILE_CREATION_ERROR = 13;
        public static final int FILE_DELETION_ERROR = 11;
        public static final int FILE_EXIST = 1;
        public static final int FILE_INPUT_READ = 16;
        public static final int FILE_RENAME_ERROR = 12;
        public static final int FINISH_APK = 30;
        public static final int IO_ERROR = 10;
        public static final int NETWORK_ERROR = 2;
        public static final int NOT_NETWORK = 20;
        public static final int OTHER_ERROR = 6;
        public static final int PARSE_ERROR = 14;
        static final java.lang.String PT = "point_time_";
        public static final int QUIT_APP = 1;
        public static final int RESUOURCE_NOT_FOUND = 5;
        public static final int SDCARD_ERROR = 4;
        public static final int SDCARD_SPACE_SHORTAGE = 9;
        public static final int SOCKET_TIMEOUT_ERROR = 8;
        public static final java.lang.String STATUS_DOWNLOAD_COMPLETED = "download_completed";
        public static final java.lang.String STATUS_INSTALLED = "installed";
        public static final int SUCCESS = 0;
        public static final int S_TYPE_0 = 0;
        public static final int S_TYPE_1 = 1;
        public static final int S_TYPE_10 = 10;
        public static final int S_TYPE_2 = 2;
        public static final int S_TYPE_3 = 3;
        public static final int S_TYPE_4 = 4;
        public static final int S_TYPE_5 = 5;
        public static final int S_TYPE_6 = 6;
        public static final int S_TYPE_8 = 8;
        public static final int S_TYPE_9 = 9;
        public static final int T_0 = 0;
        public static final int T_1 = 1;
        public static final int T_2 = 2;
        public static final int T_3 = 3;
        public static final int T_4 = 4;
        public static final int T_5 = 5;
        public static final int T_6 = 6;
        public static final int UNKNOWN_HOST_ERROR = 21;
        public static final int URL_ERROR = 3;
        private static java.util.ArrayList<io.dcloud.common.util.TestUtil.DCErrorInfo> arrayList = new java.util.ArrayList<>();
        public static int mEc = -1;
        public static int mEt = -1;
        static java.util.HashMap<java.lang.String, io.dcloud.common.util.TestUtil.PointTime> sPoinTimes = new java.util.HashMap<>();
        java.lang.String appid;
        java.lang.String name;
        long[] points;
        int index = 0;
        long lastPointTime = java.lang.System.currentTimeMillis();
        long startTime = java.lang.System.currentTimeMillis();

        PointTime(java.lang.String str, int i) {
            this.points = null;
            this.name = str;
            this.points = new long[i];
        }

        public static synchronized void addErrorInfo(io.dcloud.common.util.TestUtil.DCErrorInfo dCErrorInfo) {
            arrayList.add(dCErrorInfo);
            mEc = dCErrorInfo.ec;
            mEt = dCErrorInfo.et;
        }

        public static boolean checkCommitEnv(android.content.Context context, java.lang.String str, java.lang.String str2) {
            return io.dcloud.common.util.AppStatus.getAppStatus(str) != 0 && io.dcloud.common.util.BaseInfo.useStreamAppStatistic(context) && hasPointTime(str2);
        }

        public static void commitRatio(android.content.Context context, java.lang.String str, java.lang.String str2, int i, java.lang.String str3, java.util.HashMap<java.lang.String, java.lang.Object> map) {
            io.dcloud.p.e0.a(context, str, str2, i, str3, map);
        }

        public static void commitTid(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, int i) {
            commitTid(context, str, str2, str3, i, null, null, null, null, null, null);
        }

        public static io.dcloud.common.util.TestUtil.PointTime createPointTime(java.lang.String str, int i) {
            io.dcloud.common.util.TestUtil.PointTime pointTime = new io.dcloud.common.util.TestUtil.PointTime(str, i);
            sPoinTimes.remove(str);
            sPoinTimes.put(str, pointTime);
            return pointTime;
        }

        public static void delData(android.content.Context context, java.lang.String str, java.lang.String str2) {
            context.getSharedPreferences(PT + str, 0).edit().remove(str2).commit();
        }

        public static void delPointData(android.content.Context context, java.lang.String str) {
            android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(PT + str, 0);
            android.content.SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            int i = sharedPreferences.getInt(io.dcloud.common.util.TestUtil.START_STREAM_APP_RETRY, 0);
            for (int i2 = 0; i2 < i; i2++) {
                editorEdit.remove(io.dcloud.common.util.TestUtil.STREAM_APP_POINT + i2);
            }
            editorEdit.remove(io.dcloud.common.util.TestUtil.START_STREAM_APP_RETRY);
            editorEdit.commit();
        }

        public static void deleteStreamAppStatus(android.content.Context context, java.lang.String str, java.lang.String str2) {
            android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences(PT + str, 0).edit();
            editorEdit.remove(str2);
            editorEdit.commit();
        }

        public static io.dcloud.common.util.TestUtil.PointTime destroyPointTime(java.lang.String str) {
            return sPoinTimes.remove(str);
        }

        public static java.lang.String getAllCommitData(android.content.Context context, java.lang.String str) {
            int i = 0;
            android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(PT + str, 0);
            int i2 = sharedPreferences.getInt(io.dcloud.common.util.TestUtil.START_STREAM_APP_RETRY, 0);
            if (i2 == 0) {
                return null;
            }
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            while (i < i2) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(io.dcloud.common.util.TestUtil.STREAM_APP_POINT);
                sb.append(i != 0 ? java.lang.Integer.valueOf(i) : "");
                java.lang.String string = sharedPreferences.getString(sb.toString(), "");
                if (!android.text.TextUtils.isEmpty(string)) {
                    stringBuffer.append(string);
                }
                i++;
            }
            return stringBuffer.toString();
        }

        public static java.lang.String getBaseVer(android.content.Context context) {
            return "1.9.9.82680";
        }

        public static java.lang.String getData(android.content.Context context, java.lang.String str, java.lang.String str2) {
            return context.getSharedPreferences(PT + str, 0).getString(str2, "");
        }

        public static java.lang.String getErrorInfoString() {
            java.util.ArrayList<io.dcloud.common.util.TestUtil.DCErrorInfo> arrayList2 = arrayList;
            if (arrayList2 == null || arrayList2.size() <= 0) {
                return null;
            }
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            java.lang.StringBuffer stringBuffer2 = new java.lang.StringBuffer();
            for (int i = 0; i < arrayList.size(); i++) {
                io.dcloud.common.util.TestUtil.DCErrorInfo dCErrorInfo = arrayList.get(i);
                if (i == 0) {
                    stringBuffer.append(dCErrorInfo.ec);
                    stringBuffer2.append(dCErrorInfo.et);
                } else {
                    stringBuffer.append("%2c").append(dCErrorInfo.ec);
                    stringBuffer2.append("%2c").append(dCErrorInfo.et);
                }
            }
            arrayList.clear();
            return "&ec=" + stringBuffer.toString() + "&et=" + stringBuffer2.toString();
        }

        public static io.dcloud.common.util.TestUtil.PointTime getPointTime(java.lang.String str) {
            return sPoinTimes.get(str);
        }

        public static java.util.HashMap<java.lang.Object, java.lang.Object> gsd(io.dcloud.common.DHInterface.IApp iApp, android.content.SharedPreferences sharedPreferences) {
            return io.dcloud.p.e0.a(iApp, sharedPreferences);
        }

        public static boolean hasPointTime(java.lang.String str) {
            return sPoinTimes.containsKey(str);
        }

        public static boolean hasStreamAppStatus(android.content.Context context, java.lang.String str, java.lang.String str2) {
            return context.getSharedPreferences(PT + str, 0).getBoolean(str2, false);
        }

        public static void pre(io.dcloud.common.DHInterface.IApp iApp, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, org.json.JSONArray jSONArray) {
            io.dcloud.p.e0.a(iApp, str, str2, str3, str4, jSONArray);
        }

        public static void saveData(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
            android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences(PT + str, 0).edit();
            editorEdit.putString(str2, str3);
            editorEdit.commit();
        }

        public static void saveStreamAppStatus(android.content.Context context, java.lang.String str, java.lang.String str2) {
            android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences(PT + str, 0).edit();
            editorEdit.putBoolean(str2, true);
            editorEdit.commit();
        }

        public static io.dcloud.common.util.TestUtil.PointTime updatePointTime(java.lang.String str) {
            io.dcloud.common.util.TestUtil.PointTime pointTime = sPoinTimes.get(str);
            if (pointTime == null) {
                return pointTime;
            }
            sPoinTimes.remove(str);
            io.dcloud.common.util.TestUtil.PointTime pointTime2 = new io.dcloud.common.util.TestUtil.PointTime(str, pointTime.points.length);
            pointTime2.updateData(pointTime);
            sPoinTimes.put(str, pointTime2);
            return pointTime2;
        }

        public int getIndex() {
            return this.index;
        }

        public long getPoint(int i) {
            return this.points[i];
        }

        public java.lang.String getPointsString() {
            return getPointsString("|");
        }

        public long getStartTime() {
            return this.startTime;
        }

        public io.dcloud.common.util.TestUtil.PointTime point() {
            point(this.index, java.lang.System.currentTimeMillis() - this.lastPointTime);
            return this;
        }

        public void updateData(io.dcloud.common.util.TestUtil.PointTime pointTime) {
            this.appid = pointTime.appid;
            this.index = pointTime.index;
            this.startTime = pointTime.startTime;
            long[] jArr = pointTime.points;
            java.lang.System.arraycopy(jArr, 0, this.points, 0, jArr.length);
        }

        public static void commitTid(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, int i, java.lang.String str4, boolean z, java.lang.String str5) {
            io.dcloud.p.e0.a(context, str, str2, str3, i, null, null, null, null, null, str4, str5, null);
        }

        public java.lang.String getPointsString(java.lang.String str) {
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(str);
            int i = 0;
            while (true) {
                long[] jArr = this.points;
                if (i >= jArr.length) {
                    return stringBuffer.toString();
                }
                if (i < this.index) {
                    stringBuffer.append(jArr[i]);
                }
                stringBuffer.append(str);
                i++;
            }
        }

        public static void commitTid(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, int i, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.util.HashMap<java.lang.String, java.lang.Object> map) {
            io.dcloud.p.e0.a(context, str, str2, str3, i, null, null, null, str4, str5, str6, "", map);
        }

        public io.dcloud.common.util.TestUtil.PointTime point(int i) {
            point(i, java.lang.System.currentTimeMillis() - this.lastPointTime);
            return this;
        }

        public static void commitTid(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, int i, java.lang.String str4, java.lang.String str5, org.json.JSONObject jSONObject, java.lang.String str6, java.lang.String str7, java.util.HashMap<java.lang.String, java.lang.Object> map) {
            io.dcloud.p.e0.a(context, str, str2, str3, i, str4, str5, jSONObject, str6, str7, null, "", map);
        }

        public io.dcloud.common.util.TestUtil.PointTime point(int i, long j) {
            if (i < this.points.length) {
                this.lastPointTime = java.lang.System.currentTimeMillis();
                this.points[i] = j;
                this.index++;
            }
            return this;
        }
    }

    public static void clearTimers() {
        mTimers.clear();
    }

    public static void debug(android.view.ViewGroup viewGroup) {
    }

    public static void delete(java.lang.String str) {
        io.dcloud.common.util.TestUtil.Timer timerFindTimer = findTimer(str);
        if (timerFindTimer != null) {
            mTimers.remove(timerFindTimer);
        }
    }

    private static io.dcloud.common.util.TestUtil.Timer findTimer(java.lang.String str) {
        for (int size = mTimers.size() - 1; size >= 0; size--) {
            io.dcloud.common.util.TestUtil.Timer timer = mTimers.get(size);
            if (timer.name.equals(str)) {
                return timer;
            }
        }
        return null;
    }

    public static java.lang.Object getRecord(java.lang.String str) {
        return mObjs.get(str);
    }

    public static long getUseTime(java.lang.String str, java.lang.String str2) {
        io.dcloud.common.util.TestUtil.Timer timerFindTimer = findTimer(str);
        if (timerFindTimer != null) {
            return timerFindTimer.pointTime(str2);
        }
        return 0L;
    }

    public static void mark(java.lang.String str) {
        io.dcloud.common.adapter.util.Logger.d(TAG, str);
    }

    public static void print(java.lang.String str) {
        io.dcloud.common.util.TestUtil.Timer timerFindTimer = findTimer(str);
        if (timerFindTimer != null) {
            timerFindTimer.print();
        }
    }

    public static void record(java.lang.String str, java.lang.Object obj) {
        mObjs.put(str, obj);
    }

    private static void record0(java.lang.String str, java.lang.String str2) {
        io.dcloud.common.util.TestUtil.Timer timerFindTimer = findTimer(str);
        if (timerFindTimer != null) {
            mTimers.remove(timerFindTimer);
        }
        mTimers.add(new io.dcloud.common.util.TestUtil.Timer(str, str2));
    }

    public static void setRecordExtra(java.lang.String str, java.lang.String str2) {
        io.dcloud.common.util.TestUtil.Timer timerFindTimer = findTimer(str);
        if (timerFindTimer != null) {
            timerFindTimer.extra = str2;
        }
    }

    public static void timePoints(java.lang.String str, int i) {
    }

    public static void record(java.lang.String str) {
        record0(str, "");
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    static class Timer {
        long birthTime;
        java.lang.String extra;
        long lastPointTime;
        long lastPrintTime;
        java.lang.String name;
        long wholeUseTime;

        Timer(java.lang.String str) {
            this.name = str;
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            this.birthTime = jCurrentTimeMillis;
            this.lastPrintTime = jCurrentTimeMillis;
            this.lastPointTime = jCurrentTimeMillis;
        }

        long pointTime(java.lang.String str) {
            long j = this.lastPrintTime;
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            this.lastPointTime = jCurrentTimeMillis;
            long j2 = jCurrentTimeMillis - j;
            io.dcloud.common.adapter.util.Logger.i(io.dcloud.common.util.TestUtil.TAG, "name :" + this.name + "; <<-- " + str + " -->> pointTime = " + j2);
            return j2;
        }

        void print() {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            this.lastPrintTime = jCurrentTimeMillis;
            this.wholeUseTime = jCurrentTimeMillis - this.birthTime;
            io.dcloud.common.adapter.util.Logger.i(io.dcloud.common.util.TestUtil.TAG, "name :" + this.name + "; <<-- " + this.extra + " -->> wholeUseTime = " + this.wholeUseTime);
        }

        Timer(java.lang.String str, java.lang.String str2) {
            this(str);
            this.extra = str2;
        }

        void print(java.lang.String str) {
            long j = this.lastPrintTime;
            print();
            io.dcloud.common.adapter.util.Logger.e(io.dcloud.common.util.TestUtil.TAG, "name :" + this.name + "; <<-- " + str + " -->> useTime = " + (this.lastPrintTime - j));
        }
    }

    public static void record(java.lang.String str, java.lang.String str2) {
        record0(str, str2);
    }

    public static void print(java.lang.String str, java.lang.String str2) {
        io.dcloud.common.util.TestUtil.Timer timerFindTimer = findTimer(str);
        if (timerFindTimer != null) {
            timerFindTimer.print(str2);
        }
    }
}
