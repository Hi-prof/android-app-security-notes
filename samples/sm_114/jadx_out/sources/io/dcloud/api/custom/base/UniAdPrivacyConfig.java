package io.dcloud.api.custom.base;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class UniAdPrivacyConfig {
    private final io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig a;

    public UniAdPrivacyConfig(io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig privacyConfig) {
        this.a = privacyConfig;
    }

    public boolean isAdult() {
        io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig privacyConfig = this.a;
        return privacyConfig == null || privacyConfig.isAdult();
    }

    public boolean isCanGetAndroidId() {
        io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig privacyConfig = this.a;
        return privacyConfig == null || privacyConfig.isCanGetAndroidId();
    }

    public boolean isCanGetBootId() {
        io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig privacyConfig = this.a;
        return privacyConfig == null || privacyConfig.isCanGetBootId();
    }

    public boolean isCanGetIP() {
        io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig privacyConfig = this.a;
        return privacyConfig == null || privacyConfig.isCanGetIP();
    }

    public boolean isCanGetInstallAppList() {
        io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig privacyConfig = this.a;
        return privacyConfig == null || privacyConfig.isCanGetInstallAppList();
    }

    public boolean isCanGetMacAddress() {
        io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig privacyConfig = this.a;
        return privacyConfig == null || privacyConfig.isCanGetMacAddress();
    }

    public boolean isCanGetOAID() {
        io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig privacyConfig = this.a;
        return privacyConfig == null || privacyConfig.isCanGetOAID();
    }

    public boolean isCanGetRunningApps() {
        io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig privacyConfig = this.a;
        return privacyConfig == null || privacyConfig.isCanGetRunningApps();
    }

    public boolean isCanUseLocation() {
        io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig privacyConfig = this.a;
        return privacyConfig == null || privacyConfig.isCanUseLocation();
    }

    public boolean isCanUsePhoneState() {
        io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig privacyConfig = this.a;
        return privacyConfig == null || privacyConfig.isCanUsePhoneState();
    }

    public boolean isCanUseRecordPermission() {
        io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig privacyConfig = this.a;
        return privacyConfig == null || privacyConfig.isCanUseRecordPermission();
    }

    public boolean isCanUseSensor() {
        io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig privacyConfig = this.a;
        return privacyConfig == null || privacyConfig.isCanUseSensor();
    }

    public boolean isCanUseSimOperator() {
        io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig privacyConfig = this.a;
        return privacyConfig == null || privacyConfig.isCanUseSimOperator();
    }

    public boolean isCanUseStorage() {
        io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig privacyConfig = this.a;
        return privacyConfig == null || privacyConfig.isCanUseStorage();
    }

    public boolean isCanUseWifiState() {
        io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig privacyConfig = this.a;
        return privacyConfig == null || privacyConfig.isCanUseWifiState();
    }

    public boolean isGDTAgreeStrategy() {
        io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig privacyConfig = this.a;
        return privacyConfig == null || privacyConfig.isGDTAgreeStrategy();
    }

    public org.json.JSONObject userPrivacyConfig() {
        io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig privacyConfig = this.a;
        org.json.JSONObject jSONObjectUserPrivacyConfig = privacyConfig != null ? privacyConfig.userPrivacyConfig() : null;
        return jSONObjectUserPrivacyConfig == null ? new org.json.JSONObject() : jSONObjectUserPrivacyConfig;
    }
}
