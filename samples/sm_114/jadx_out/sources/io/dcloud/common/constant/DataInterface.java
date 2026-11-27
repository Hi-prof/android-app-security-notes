package io.dcloud.common.constant;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class DataInterface {
    public static java.lang.String getRomVersion() {
        java.lang.String str;
        if (!android.os.Build.MANUFACTURER.equals(io.dcloud.common.adapter.util.MobilePhoneModel.XIAOMI)) {
            return android.os.Build.VERSION.INCREMENTAL;
        }
        java.lang.String buildValue = io.dcloud.common.adapter.util.DeviceInfo.getBuildValue("ro.miui.ui.version.name");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(android.os.Build.VERSION.INCREMENTAL);
        if (android.text.TextUtils.isEmpty(buildValue)) {
            str = "";
        } else {
            str = com.taobao.weex.el.parse.Operators.SUB + buildValue;
        }
        sb.append(str);
        return sb.toString();
    }

    public static java.util.HashMap getStartupUrlBaseData(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z) throws java.lang.Throwable {
        java.lang.String bundleData = io.dcloud.common.adapter.util.SP.getBundleData(context, "pdr", io.dcloud.common.adapter.util.SP.STARTUP_DEVICE_ID);
        if (io.dcloud.common.util.PdrUtil.isEmpty(bundleData)) {
            bundleData = io.dcloud.common.util.TelephonyUtil.getSBBS(context, true, true, false);
        }
        int networkType = io.dcloud.common.util.NetworkTypeUtil.getNetworkType(context);
        java.lang.String str4 = android.os.Build.MODEL;
        int i = android.os.Build.VERSION.SDK_INT;
        java.lang.String str5 = io.dcloud.common.adapter.util.DeviceInfo.sPackageName;
        if (str5 == null) {
            str5 = io.dcloud.common.adapter.util.AndroidResources.packageName;
        }
        java.util.HashMap map = new java.util.HashMap();
        map.put("appid", str);
        if (!z) {
            map.put("net", java.lang.Integer.valueOf(networkType));
        }
        map.put("imei", bundleData);
        map.put("md", str4);
        map.put(com.taobao.weex.common.WXConfig.os, java.lang.Integer.valueOf(i));
        map.put("vb", "1.9.9.82680");
        map.put(io.dcloud.common.util.CreateShortResultReceiver.KEY_SF, java.lang.Integer.valueOf(io.dcloud.common.constant.StringConst.getIntSF(str2)));
        map.put(com.facebook.common.callercontext.ContextChain.TAG_PRODUCT, "a");
        map.put("d1", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
        map.put(io.dcloud.common.util.CreateShortResultReceiver.KEY_SFD, str3);
        map.put("vd", android.os.Build.MANUFACTURER);
        map.put("pn", str5);
        return map;
    }

    public static java.lang.String getStreamappFrom(android.content.Intent intent) {
        if (intent == null || !intent.hasExtra(io.dcloud.common.constant.IntentConst.RUNING_STREAPP_LAUNCHER)) {
            return null;
        }
        java.lang.String stringExtra = intent.getStringExtra(io.dcloud.common.constant.IntentConst.RUNING_STREAPP_LAUNCHER);
        if (stringExtra.indexOf("third:") == 0) {
            return stringExtra.substring(6, stringExtra.length());
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0068: MOVE (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:24:0x0068 */
    public static java.lang.String getSystemProperty() throws java.lang.Throwable {
        java.io.BufferedReader bufferedReader;
        java.io.BufferedReader bufferedReader2;
        java.io.BufferedReader bufferedReader3 = null;
        try {
            try {
                bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(java.lang.Runtime.getRuntime().exec("getprop ro.miui.ui.version.name").getInputStream()), 1024);
                try {
                    java.lang.String line = bufferedReader.readLine();
                    bufferedReader.close();
                    try {
                        bufferedReader.close();
                        return line;
                    } catch (java.io.IOException e) {
                        io.dcloud.common.adapter.util.Logger.i("Exception while closing InputStream" + e);
                        return line;
                    }
                } catch (java.io.IOException e2) {
                    e = e2;
                    io.dcloud.common.adapter.util.Logger.i("Unable to read sysprop ro.miui.ui.version.name" + e);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (java.io.IOException e3) {
                            io.dcloud.common.adapter.util.Logger.i("Exception while closing InputStream" + e3);
                        }
                    }
                    return null;
                }
            } catch (java.lang.Throwable th) {
                th = th;
                bufferedReader3 = bufferedReader2;
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                    } catch (java.io.IOException e4) {
                        io.dcloud.common.adapter.util.Logger.i("Exception while closing InputStream" + e4);
                    }
                }
                throw th;
            }
        } catch (java.io.IOException e5) {
            e = e5;
            bufferedReader = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (bufferedReader3 != null) {
                bufferedReader3.close();
            }
            throw th;
        }
    }

    public static java.lang.String getTestParam(java.lang.String str) {
        return "&__am=".concat((android.text.TextUtils.isEmpty(str) || !io.dcloud.common.util.BaseInfo.isTest(str)) ? "r" : "t");
    }
}
