package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class x3 {
    static java.util.HashMap a(android.content.Context context) {
        java.lang.String str;
        java.util.HashMap map = new java.util.HashMap();
        map.put(com.facebook.common.callercontext.ContextChain.TAG_PRODUCT, "a");
        map.put("appid", io.dcloud.p.r0.d().b().getAppId());
        try {
            map.put("pname", context.getApplicationInfo().loadLabel(context.getPackageManager()));
        } catch (java.lang.Exception unused) {
        }
        map.put("pn", context.getPackageName());
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 1).versionName;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            str = null;
        }
        map.put("pv", str);
        map.put("imei", io.dcloud.p.u4.a(context, true, true));
        map.put("md", android.os.Build.MODEL);
        map.put("vd", android.os.Build.MANUFACTURER);
        map.put(com.taobao.weex.common.WXConfig.os, java.lang.Integer.valueOf(android.os.Build.VERSION.SDK_INT));
        map.put("vb", io.dcloud.p.l0.a());
        map.put("net", io.dcloud.p.n4.d(context));
        map.put("mc", io.dcloud.p.l0.a(context));
        map.put("paid", io.dcloud.p.r0.d().b().getAdId());
        map.put("dw", java.lang.Integer.valueOf(context.getResources().getDisplayMetrics().widthPixels));
        map.put("dh", java.lang.Integer.valueOf(context.getResources().getDisplayMetrics().heightPixels));
        map.put("psap", "dcloud,wanka,youdao,common");
        map.put("psas", "");
        map.put("ps", 0);
        map.put("psd", 0);
        map.put("data", b(context));
        map.put("pap", "1");
        map.put("papi", "1");
        map.put("psp", android.text.TextUtils.join(",", io.dcloud.p.e.b().c()));
        map.put("psaf", com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
        map.put("psdk", java.lang.Integer.valueOf(io.dcloud.p.l0.c()));
        map.put("mpap", "1");
        map.put("dpsp", "1");
        map.put("bm", c(context));
        map.put("um", d(context));
        map.put("aws", a() ? "1" : com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
        map.put("root", io.dcloud.p.q.a() ? "1" : com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
        map.put("ud", io.dcloud.p.q.b(context) ? "1" : com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
        map.put("wp", io.dcloud.p.q.c(context) ? "1" : com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
        map.put("acc", io.dcloud.p.q.a(context) ? "1" : com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
        map.put("emu", io.dcloud.p.d1.i().a(context) ? "1" : com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT);
        while (map.values().remove(null)) {
        }
        while (map.values().remove("null")) {
        }
        return map;
    }

    private static java.lang.String b(android.content.Context context) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("net", io.dcloud.p.n4.c(context));
            jSONObject.put("device", io.dcloud.p.n4.b(context));
            jSONObject.put("gps", io.dcloud.p.b3.a(context));
        } catch (java.lang.Exception unused) {
        }
        return jSONObject.toString();
    }

    private static java.lang.String d(android.content.Context context) {
        if (!io.dcloud.p.c0.a().a(context) || !io.dcloud.sdk.poly.base.utils.PrivacyManager.getInstance().d()) {
            return "";
        }
        try {
            java.lang.Process processExec = java.lang.Runtime.getRuntime().exec("stat -c \"%x\" /data/data");
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(processExec.getInputStream()));
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            char[] cArr = new char[256];
            while (true) {
                int i = bufferedReader.read(cArr);
                if (i <= 0) {
                    break;
                }
                stringBuffer.append(cArr, 0, i);
            }
            bufferedReader.close();
            processExec.waitFor();
            java.lang.String[] strArrSplit = stringBuffer.toString().replace(io.dcloud.common.util.JSUtil.QUOTE, "").split("\\.");
            long time = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(strArrSplit[0]).getTime();
            java.lang.String strSubstring = strArrSplit[1];
            if (strSubstring.contains(com.taobao.weex.el.parse.Operators.PLUS)) {
                strSubstring = strSubstring.substring(0, strSubstring.indexOf(com.taobao.weex.el.parse.Operators.PLUS));
            }
            return (time / 1000) + com.taobao.weex.el.parse.Operators.DOT_STR + java.lang.Long.parseLong(strSubstring.trim());
        } catch (java.lang.Exception unused) {
            return com.taobao.weex.el.parse.Operators.DOT_STR;
        }
    }

    private static java.lang.String c(android.content.Context context) {
        if (!io.dcloud.p.c0.a().a(context) || !io.dcloud.sdk.poly.base.utils.PrivacyManager.getInstance().d()) {
            return "";
        }
        try {
            java.io.File file = new java.io.File("/proc/sys/kernel/random/boot_id");
            if (!file.exists()) {
                return "";
            }
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
            byte[] bArr = new byte[37];
            fileInputStream.read(bArr);
            java.lang.String str = new java.lang.String(bArr);
            try {
                fileInputStream.close();
                return str;
            } catch (java.lang.Exception unused) {
                return str;
            }
        } catch (java.lang.Exception unused2) {
            return "";
        }
    }

    private static boolean a() {
        try {
            java.lang.Class.forName("com.tencent.mm.opensdk.openapi.IWXAPI");
            return true;
        } catch (java.lang.ClassNotFoundException unused) {
            return false;
        }
    }
}
