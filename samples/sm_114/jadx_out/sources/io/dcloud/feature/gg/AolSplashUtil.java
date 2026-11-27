package io.dcloud.feature.gg;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class AolSplashUtil {
    static final float Main_View_Weight = 0.8f;
    public static final java.lang.String SP_AD_LIST_TYPE = "ad_list_order";
    public static final java.lang.String showCountADReward = "_s_c_a_r";
    static java.lang.String[] adTypes = {"adpid", io.dcloud.sdk.core.util.Const.TYPE_CSJ, io.dcloud.sdk.core.util.Const.TYPE_GDT};
    private static java.lang.String DC_AD_TYPE_KEY = "dc_ad_type_key";
    private static boolean isShowInterstitialAd = false;

    public static java.lang.String da(java.lang.String str, java.lang.String str2) {
        org.json.JSONObject jSONObjectOptJSONObject;
        io.dcloud.p.h4 h4Var = io.dcloud.common.adapter.util.SP.getsOrCreateBundle(io.dcloud.feature.gg.dcloud.ADHandler.AdTag);
        java.lang.String strA = h4Var.a("cgk") ? h4Var.a("cgk", "") : h4Var.a("uniad", "");
        if (android.text.TextUtils.isEmpty(strA)) {
            java.lang.String metaValue = io.dcloud.common.adapter.util.AndroidResources.getMetaValue(str);
            if (io.dcloud.common.util.PdrUtil.isEmpty(metaValue) || !metaValue.contains("_")) {
                return metaValue;
            }
            return java.util.Arrays.binarySearch(adTypes, metaValue.substring(0, metaValue.indexOf("_"))) != -1 ? metaValue.substring(metaValue.indexOf("_") + 1) : metaValue;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(strA);
            if (jSONObject.has("appid") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("appid")) != null && jSONObjectOptJSONObject.has(str2)) {
                return jSONObjectOptJSONObject.optString(str2);
            }
            return null;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static org.json.JSONArray dah(java.lang.String str) {
        org.json.JSONObject jSONObjectOptJSONObject;
        java.lang.String str2 = io.dcloud.common.adapter.util.SP.getsBundleData(io.dcloud.feature.gg.dcloud.ADHandler.AdTag, "uniad");
        if (android.text.TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str2);
            if (jSONObject.has("appid_h") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("appid_h")) != null && jSONObjectOptJSONObject.has(str)) {
                return jSONObjectOptJSONObject.getJSONArray(str);
            }
            return null;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static void decodeChannel(org.json.JSONObject jSONObject) {
        org.json.JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null) {
            return;
        }
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        org.json.JSONObject jSONObject3 = new org.json.JSONObject();
        org.json.JSONObject jSONObjectOptJSONObject2 = null;
        if (jSONObject.has("uniad")) {
            jSONObjectOptJSONObject = jSONObject.optJSONObject("uniad");
            if (jSONObjectOptJSONObject != null) {
                jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(io.dcloud.common.constant.AbsoluteConst.XML_CHANNEL);
            }
        } else {
            jSONObjectOptJSONObject = null;
        }
        if (jSONObjectOptJSONObject2 == null) {
            return;
        }
        java.util.Iterator<java.lang.String> itKeys = jSONObjectOptJSONObject2.keys();
        while (itKeys.hasNext()) {
            java.lang.String next = itKeys.next();
            org.json.JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject(next);
            try {
                jSONObject2.put(next, jSONObjectOptJSONObject3.optString("appid"));
                jSONObject3.put(next, jSONObjectOptJSONObject3.optJSONArray("appidh"));
            } catch (java.lang.Exception unused) {
            }
        }
        try {
            jSONObjectOptJSONObject.put("appid", jSONObject2);
            jSONObjectOptJSONObject.put("appid_h", jSONObject3);
        } catch (org.json.JSONException unused2) {
        }
    }

    public static int dh(android.content.Context context) {
        return (int) (context.getResources().getDisplayMetrics().heightPixels * Main_View_Weight);
    }

    public static int dw(android.content.Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static java.lang.String getAL(android.content.Context context) {
        java.lang.String str = io.dcloud.common.adapter.util.SP.getsBundleData(context, io.dcloud.feature.gg.dcloud.ADHandler.AdTag, "al");
        if (io.dcloud.common.util.PdrUtil.isEmpty(str)) {
            return "";
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            if (jSONObject.length() == 0) {
                return "";
            }
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            java.util.Iterator<java.lang.String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                java.lang.String next = itKeys.next();
                java.lang.String strOptString = jSONObject.optString(next);
                try {
                    if (io.dcloud.common.util.PdrUtil.isEmpty(strOptString)) {
                        jSONObject2.put(next, 0);
                    } else if (context.getPackageManager().getLaunchIntentForPackage(strOptString) != null) {
                        jSONObject2.put(next, 1);
                    } else {
                        jSONObject2.put(next, 0);
                    }
                } catch (java.lang.Exception unused) {
                }
            }
            return jSONObject2.length() > 0 ? jSONObject2.toString() : "";
        } catch (java.lang.Exception unused2) {
            return "";
        }
    }

    public static java.util.List<java.lang.String> getAdOrder() {
        java.util.ArrayList arrayList = new java.util.ArrayList(java.util.Arrays.asList(io.dcloud.common.adapter.util.SP.getBundleData(io.dcloud.feature.gg.dcloud.ADHandler.AdTag, SP_AD_LIST_TYPE).split(",")));
        arrayList.remove("");
        return arrayList;
    }

    public static java.lang.String getAdpId(io.dcloud.common.DHInterface.IApp iApp, java.lang.String str) {
        org.json.JSONObject jSONObjectOptJSONObject;
        java.lang.String str2 = io.dcloud.common.adapter.util.SP.getsBundleData(io.dcloud.feature.gg.dcloud.ADHandler.AdTag, "uniad");
        if (android.text.TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str2);
            if (jSONObject.has("adpids") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("adpids")) != null && jSONObjectOptJSONObject.has(str)) {
                return jSONObjectOptJSONObject.optString(str);
            }
        } catch (java.lang.Exception unused) {
        }
        return null;
    }

    public static java.lang.String getAppKey(java.lang.String str, java.lang.String str2) {
        org.json.JSONObject jSONObjectOptJSONObject;
        java.lang.String str3 = io.dcloud.common.adapter.util.SP.getsBundleData(io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext, io.dcloud.feature.gg.dcloud.ADHandler.AdTag, "uniad");
        if (android.text.TextUtils.isEmpty(str3)) {
            java.lang.String metaValue = io.dcloud.common.adapter.util.AndroidResources.getMetaValue(str);
            if (io.dcloud.common.util.PdrUtil.isEmpty(metaValue) || !metaValue.contains("_")) {
                return metaValue;
            }
            return java.util.Arrays.binarySearch(adTypes, metaValue.substring(0, metaValue.indexOf("_"))) != -1 ? metaValue.substring(metaValue.indexOf("_") + 1) : metaValue;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str3);
            if (jSONObject.has("appid") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("appid")) != null && jSONObjectOptJSONObject.has(str2)) {
                return jSONObjectOptJSONObject.optString(str2);
            }
            return null;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static java.lang.String getAppKey2(java.lang.String str, java.lang.String str2) {
        org.json.JSONObject jSONObjectOptJSONObject;
        java.lang.String str3 = io.dcloud.common.adapter.util.SP.getsBundleData(io.dcloud.common.adapter.util.DeviceInfo.sApplicationContext, io.dcloud.feature.gg.dcloud.ADHandler.AdTag, "uniad");
        if (android.text.TextUtils.isEmpty(str3)) {
            java.lang.String metaValue = io.dcloud.common.adapter.util.AndroidResources.getMetaValue(str);
            if (io.dcloud.common.util.PdrUtil.isEmpty(metaValue) || !metaValue.contains("_")) {
                return metaValue;
            }
            return java.util.Arrays.binarySearch(adTypes, metaValue.substring(0, metaValue.indexOf("_"))) != -1 ? metaValue.substring(metaValue.indexOf("_") + 1) : metaValue;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str3);
            if (jSONObject.has("appKey") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("appKey")) != null && jSONObjectOptJSONObject.has(str2)) {
                return jSONObjectOptJSONObject.optString(str2);
            }
            return null;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static android.graphics.drawable.Drawable getApplicationIcon(android.content.Context context) {
        try {
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            return packageManager.getApplicationIcon(packageManager.getApplicationInfo(context.getPackageName(), 0));
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static java.lang.String getApplicationName(android.content.Context context) {
        try {
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            return (java.lang.String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static java.lang.String getPlashType() {
        android.content.SharedPreferences orCreateBundle = io.dcloud.common.adapter.util.SP.getOrCreateBundle(DC_AD_TYPE_KEY);
        return orCreateBundle != null ? orCreateBundle.getString("type", "dcloud") : "dcloud";
    }

    public static java.lang.String getSplashAdpId(java.lang.String str, java.lang.String str2) {
        org.json.JSONObject jSONObjectOptJSONObject;
        java.lang.String str3 = io.dcloud.common.adapter.util.SP.getsBundleData(io.dcloud.feature.gg.dcloud.ADHandler.AdTag, "uniad");
        if (!android.text.TextUtils.isEmpty(str3)) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str3);
                if (jSONObject.has("splash") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("splash")) != null && jSONObjectOptJSONObject.has(str)) {
                    return jSONObjectOptJSONObject.optString(str);
                }
            } catch (java.lang.Exception unused) {
            }
            return null;
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            return null;
        }
        java.lang.String metaValue = io.dcloud.common.adapter.util.AndroidResources.getMetaValue(str2);
        if (!io.dcloud.common.util.PdrUtil.isEmpty(metaValue) && metaValue.contains("_")) {
            if (java.util.Arrays.binarySearch(adTypes, metaValue.substring(0, metaValue.indexOf("_"))) != -1) {
                metaValue = metaValue.substring(metaValue.indexOf("_") + 1);
            }
        }
        if ("UNIAD_FULL_SPLASH".equals(str2)) {
            return java.lang.Boolean.parseBoolean(metaValue) ? "1" : com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT;
        }
        return metaValue;
    }

    public static org.json.JSONObject getUniad() {
        java.lang.String str = io.dcloud.common.adapter.util.SP.getsBundleData(io.dcloud.feature.gg.dcloud.ADHandler.AdTag, "uniad");
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            if (jSONObject.has("adpids")) {
                return jSONObject.optJSONObject("adpids");
            }
        } catch (java.lang.Exception unused) {
        }
        return null;
    }

    public static boolean isShowingInterstitialAd() {
        return isShowInterstitialAd;
    }

    public static void saveADShowCount(java.lang.String str, java.lang.String str2) {
        org.json.JSONObject jSONObject;
        android.content.SharedPreferences orCreateBundle = io.dcloud.common.adapter.util.SP.getOrCreateBundle(showCountADReward);
        int iOptInt = 0;
        try {
            jSONObject = new org.json.JSONObject(io.dcloud.common.adapter.util.SP.getBundleData(orCreateBundle, str));
            try {
                iOptInt = jSONObject.optInt(str2) + 1;
                jSONObject.put(str2, iOptInt);
            } catch (java.lang.Exception unused) {
            }
        } catch (java.lang.Exception unused2) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put(str2, iOptInt + 1);
            } catch (java.lang.Exception unused3) {
            }
        }
        io.dcloud.common.adapter.util.SP.setBundleData(orCreateBundle, str, jSONObject.toString());
    }

    public static void saveOperate(android.content.Context context, java.lang.String str, java.util.HashMap<java.lang.String, java.lang.String> map) {
        try {
            android.content.SharedPreferences.Editor editorEdit = io.dcloud.common.adapter.util.SP.getOrCreateBundle(context, io.dcloud.feature.gg.dcloud.ADHandler.AdTag).edit();
            for (java.lang.String str2 : map.keySet()) {
                editorEdit.putString(str2, map.get(str2));
            }
            editorEdit.commit();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void setShowInterstitialAd(boolean z) {
        isShowInterstitialAd = z;
    }

    public static void saveOperate(java.util.HashMap<java.lang.String, java.lang.String> map) {
        saveOperate(null, null, map);
    }
}
