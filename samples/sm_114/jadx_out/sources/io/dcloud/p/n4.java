package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public abstract class n4 {
    private static java.lang.String a = "0";
    private static java.lang.String b = "1";
    private static java.lang.String c = "3";
    private static java.lang.String d = "4";
    private static java.lang.String e = "5";
    private static java.lang.String f = "6";
    private static java.lang.String g = "7";
    private static boolean h = false;
    private static java.lang.String i = "1";

    public static org.json.JSONObject a(android.content.Context context) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("device", b(context));
            jSONObject.put("net", c(context));
            jSONObject.put("gps", io.dcloud.p.b3.a(context));
        } catch (java.lang.Exception unused) {
        }
        return jSONObject;
    }

    public static org.json.JSONObject b(android.content.Context context) {
        java.lang.String strC;
        java.lang.String strA;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("type", 1);
            jSONObject.put(com.taobao.weex.common.WXConfig.os, com.taobao.weex.utils.tools.TimeCalculator.PLATFORM_ANDROID);
            jSONObject.put("osv", android.os.Build.VERSION.RELEASE);
            jSONObject.put("vendor", android.os.Build.MANUFACTURER);
            jSONObject.put("model", android.os.Build.MODEL);
            jSONObject.put(com.taobao.weex.ui.component.WXComponent.PROP_FS_WRAP_CONTENT, context.getResources().getDisplayMetrics().widthPixels);
            jSONObject.put("h", context.getResources().getDisplayMetrics().heightPixels);
            try {
                jSONObject.put(tv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, io.dcloud.p.u2.a(context));
            } catch (java.lang.Exception unused) {
            }
            java.lang.String strD = io.dcloud.p.y1.d(context);
            java.lang.String str = "";
            if (android.text.TextUtils.isEmpty(strD)) {
                strD = "";
            }
            jSONObject.put("mac", strD);
            jSONObject.put("dpi", context.getResources().getDisplayMetrics().densityDpi);
            jSONObject.put("density", context.getResources().getDisplayMetrics().density);
            jSONObject.put("lan", java.util.Locale.getDefault().getLanguage());
            jSONObject.put("country", io.dcloud.p.l0.b());
            jSONObject.put("_nl", java.util.Locale.getDefault().getCountry());
            jSONObject.put("tz", java.util.TimeZone.getDefault().getDisplayName(false, 0));
            java.lang.String[] strArrE = io.dcloud.p.y1.e(context);
            jSONObject.put("imei", (strArrE == null || strArrE.length <= 0) ? "" : android.text.TextUtils.join(",", strArrE));
            try {
                strC = io.dcloud.sdk.poly.base.utils.PrivacyManager.getInstance().d() ? io.dcloud.p.m3.a().c(context) : "";
            } catch (java.lang.Exception unused2) {
            }
            jSONObject.put("oaid", strC);
            try {
                strA = io.dcloud.p.o1.a().a(context);
            } catch (java.lang.Exception unused3) {
                strA = "";
            }
            jSONObject.put("gaid", strA);
            java.lang.String strA2 = io.dcloud.p.y1.a(context);
            if (android.text.TextUtils.isEmpty(strA2)) {
                strA2 = "";
            }
            jSONObject.put("aid", strA2);
            java.lang.String strC2 = io.dcloud.p.y1.c(context);
            if (!android.text.TextUtils.isEmpty(strC2)) {
                str = strC2;
            }
            jSONObject.put("imsi", str);
            jSONObject.put("ua", e(context));
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static java.lang.String d(android.content.Context context) {
        if (!io.dcloud.p.c0.a().a(context)) {
            return i;
        }
        if (!io.dcloud.sdk.poly.base.utils.PrivacyManager.getInstance().d()) {
            return i;
        }
        if (androidx.core.content.ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") != 0) {
            return i;
        }
        if (h) {
            return i;
        }
        java.lang.String str = b;
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null && connectivityManager.getActiveNetworkInfo() != null) {
            str = a;
            if (connectivityManager.getActiveNetworkInfo().getType() != 1) {
                if (connectivityManager.getActiveNetworkInfo().getType() == 0) {
                    int subtype = connectivityManager.getActiveNetworkInfo().getSubtype();
                    switch (subtype) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                            str = d;
                            break;
                        case 3:
                        case 8:
                            str = e;
                            break;
                        case 5:
                        case 6:
                        case 12:
                        case 14:
                            str = e;
                            break;
                        case 9:
                        case 10:
                        case 11:
                        case 13:
                        case 15:
                            str = f;
                            break;
                        case 16:
                        case 19:
                        default:
                            str = "" + subtype;
                            break;
                        case 17:
                        case 18:
                            str = e;
                            break;
                        case 20:
                            str = g;
                            break;
                    }
                }
            } else {
                str = c;
            }
        }
        i = str;
        h = true;
        return str;
    }

    public static java.lang.String e(android.content.Context context) {
        java.lang.String strA = io.dcloud.p.e4.a(context, "dcloud-ads", "u-a");
        if (!android.text.TextUtils.isEmpty(strA) || !io.dcloud.p.c0.a().a(context) || !io.dcloud.sdk.poly.base.utils.PrivacyManager.getInstance().d()) {
            return strA;
        }
        try {
            android.webkit.WebView webView = new android.webkit.WebView(context);
            android.webkit.WebSettings settings = webView.getSettings();
            settings.setSavePassword(false);
            strA = settings.getUserAgentString();
            webView.destroy();
            io.dcloud.p.e4.a(context, "dcloud-ads", "u-a", strA);
            return strA;
        } catch (java.lang.Throwable unused) {
            return strA;
        }
    }

    public static org.json.JSONObject c(android.content.Context context) {
        java.lang.String strSubstring = "460";
        java.lang.String strSubstring2 = "10";
        if (io.dcloud.p.c0.a().a(context) && io.dcloud.sdk.poly.base.utils.PrivacyManager.getInstance().d()) {
            try {
                java.lang.String networkOperator = ((android.telephony.TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
                if (!android.text.TextUtils.isEmpty(networkOperator) && networkOperator.length() == 5) {
                    strSubstring = networkOperator.substring(0, 3);
                    strSubstring2 = networkOperator.substring(3);
                }
            } catch (java.lang.Exception unused) {
            }
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject(io.dcloud.p.b3.a(context, strSubstring2));
        try {
            jSONObject.put("type", d(context));
            jSONObject.put("mcc", strSubstring);
            jSONObject.put("mnc", strSubstring2);
        } catch (java.lang.Exception unused2) {
        }
        return jSONObject;
    }
}
