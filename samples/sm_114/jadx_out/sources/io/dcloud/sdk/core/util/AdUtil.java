package io.dcloud.sdk.core.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class AdUtil {
    private static io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig a;

    public static java.lang.String getCustomPrivacyConfig(android.content.Context context) {
        return io.dcloud.p.e4.a(context, "dcloud-ads", "CustomPrivacyConfig");
    }

    public static io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig getDCloudPrivacyConfig(android.content.Context context) {
        java.lang.String customPrivacyConfig = getCustomPrivacyConfig(context);
        if (android.text.TextUtils.isEmpty(customPrivacyConfig)) {
            return null;
        }
        try {
            return getPrivacyConfig(new org.json.JSONObject(customPrivacyConfig));
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static <T> T getOrDefault(java.util.Map<java.lang.String, T> map, java.lang.Object obj, T t) {
        T t2;
        return (map != null && ((t2 = map.get(obj)) != null || map.containsKey(obj))) ? t2 : t;
    }

    public static boolean getPersonalAd(android.content.Context context) {
        java.lang.String strA = io.dcloud.p.e4.a(context, "dcloud-ads", "PersonalizedAdEnable");
        if (android.text.TextUtils.isEmpty(strA)) {
            strA = io.dcloud.common.constant.AbsoluteConst.TRUE;
        }
        return java.lang.Boolean.parseBoolean(strA);
    }

    public static io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig getPrivacyConfig(final org.json.JSONObject jSONObject) {
        return new io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig() { // from class: io.dcloud.sdk.core.util.AdUtil.1
            @Override // io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig
            public boolean isAdult() {
                return jSONObject.optBoolean("isAdult", true);
            }

            @Override // io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanGetAndroidId() {
                return jSONObject.optBoolean("isCanGetAndroidId", true);
            }

            @Override // io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanGetBootId() {
                return jSONObject.optBoolean("isCanGetBootId", true);
            }

            @Override // io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanGetIP() {
                return jSONObject.optBoolean("isCanGetIP", true);
            }

            @Override // io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanGetInstallAppList() {
                return jSONObject.optBoolean("isCanGetInstallAppList", true);
            }

            @Override // io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanGetMacAddress() {
                return jSONObject.optBoolean("isCanGetMacAddress", true);
            }

            @Override // io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanGetOAID() {
                return jSONObject.optBoolean("isCanGetOAID", true);
            }

            @Override // io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanGetRunningApps() {
                return jSONObject.optBoolean("isCanGetRunningApps", true);
            }

            @Override // io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanUseLocation() {
                return jSONObject.optBoolean("isCanUseLocation", true);
            }

            @Override // io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanUsePhoneState() {
                return jSONObject.optBoolean("isCanUsePhoneState", true);
            }

            @Override // io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanUseRecordPermission() {
                return jSONObject.optBoolean("isCanUseRecordPermission", true);
            }

            @Override // io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanUseSensor() {
                return jSONObject.optBoolean("isCanUseSensor", true);
            }

            @Override // io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanUseSimOperator() {
                return jSONObject.optBoolean("isCanUseSimOperator", true);
            }

            @Override // io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanUseStorage() {
                return jSONObject.optBoolean("isCanUseStorage", true);
            }

            @Override // io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig
            public boolean isCanUseWifiState() {
                return jSONObject.optBoolean("isCanUseWifiState", true);
            }

            @Override // io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig
            public boolean isGDTAgreeStrategy() {
                return jSONObject.optBoolean("isGDTAgreeStrategy", true);
            }

            @Override // io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig
            public org.json.JSONObject userPrivacyConfig() {
                org.json.JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("userPrivacyConfig");
                return jSONObjectOptJSONObject == null ? new org.json.JSONObject() : jSONObjectOptJSONObject;
            }
        };
    }

    public static void setCustomPrivacyConfig(android.content.Context context, java.lang.String str) {
        io.dcloud.p.e4.a(context, "dcloud-ads", "CustomPrivacyConfig", str);
    }

    public static void setPersonalAd(android.content.Context context, boolean z) {
        io.dcloud.p.e4.a(context, "dcloud-ads", "PersonalizedAdEnable", java.lang.String.valueOf(z));
    }

    public static io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig getCustomPrivacyConfig() {
        return a;
    }

    public static void setCustomPrivacyConfig(io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig privacyConfig) {
        a = privacyConfig;
    }
}
