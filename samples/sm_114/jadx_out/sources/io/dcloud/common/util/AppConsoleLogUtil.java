package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class AppConsoleLogUtil {
    private static int LOG_MAXLENGTH = 1000;
    private static java.lang.String TAG = "console";
    private static io.dcloud.common.util.AppConsoleLogUtil.DCAPPLogWatcher mWatcher;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public interface DCAPPLogWatcher {
        void i(java.lang.String str, java.lang.String str2);
    }

    public static synchronized void DCLog(java.lang.String str, java.lang.String str2) {
        if (io.dcloud.common.util.BaseInfo.SyncDebug) {
            if (android.text.TextUtils.isEmpty(str)) {
                android.util.Log.i(TAG, str);
                return;
            }
            int length = str.length();
            java.lang.String str3 = com.taobao.weex.el.parse.Operators.ARRAY_START_STR + str2 + com.taobao.weex.el.parse.Operators.ARRAY_END_STR;
            if (length <= LOG_MAXLENGTH) {
                android.util.Log.i(TAG, str3 + str);
                notifyLog(str3, str);
                return;
            }
            int iHashCode = str.hashCode();
            java.lang.String str4 = "[___Connect_" + iHashCode + "___]";
            java.lang.String str5 = "[___Connect_" + iHashCode + "___END]";
            int i = 0;
            while (i < length) {
                int i2 = length - i;
                int i3 = LOG_MAXLENGTH;
                int i4 = i2 >= i3 ? i3 + i : length;
                java.lang.String strSubstring = str.substring(i, i4);
                if (i4 == length) {
                    android.util.Log.i(TAG, str3 + str4 + strSubstring + str5);
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append(str4);
                    sb.append(strSubstring);
                    sb.append(str5);
                    notifyLog(str3, sb.toString());
                } else {
                    android.util.Log.i(TAG, str3 + str4 + strSubstring);
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append(str4);
                    sb2.append(strSubstring);
                    notifyLog(str3, sb2.toString());
                }
                i = i4;
            }
        }
    }

    public static void log(java.lang.String str) {
        android.util.Log.i(TAG, str);
    }

    private static void notifyLog(java.lang.String str, java.lang.String str2) {
        io.dcloud.common.util.AppConsoleLogUtil.DCAPPLogWatcher dCAPPLogWatcher = mWatcher;
        if (dCAPPLogWatcher == null) {
            return;
        }
        dCAPPLogWatcher.i(str, str2);
    }

    public static void setWatcher(io.dcloud.common.util.AppConsoleLogUtil.DCAPPLogWatcher dCAPPLogWatcher) {
        mWatcher = dCAPPLogWatcher;
    }
}
