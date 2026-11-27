package io.dcloud.sdk.poly.base.utils;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class PrivacyManager {
    private static volatile io.dcloud.sdk.poly.base.utils.PrivacyManager c;
    private io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig a;
    private final java.util.Map b = new java.util.HashMap();

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class a extends io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig {
        private boolean isAllowPrivacy = true;

        public abstract java.lang.String getAndroidId();

        public abstract java.lang.String[] getImeis();

        public abstract java.lang.String getImsi();

        public java.lang.String getMacAddress() {
            return null;
        }

        public abstract boolean isAllowPrivacy();
    }

    private PrivacyManager() {
    }

    public static io.dcloud.sdk.poly.base.utils.PrivacyManager getInstance() {
        if (c == null) {
            synchronized (io.dcloud.sdk.poly.base.utils.PrivacyManager.class) {
                if (c == null) {
                    c = new io.dcloud.sdk.poly.base.utils.PrivacyManager();
                }
            }
        }
        return c;
    }

    public java.lang.String[] a() {
        io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig privacyConfig = this.a;
        if (privacyConfig instanceof io.dcloud.sdk.poly.base.utils.PrivacyManager.a) {
            return ((io.dcloud.sdk.poly.base.utils.PrivacyManager.a) privacyConfig).getImeis();
        }
        return null;
    }

    public java.lang.String b() {
        io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig privacyConfig = this.a;
        return privacyConfig instanceof io.dcloud.sdk.poly.base.utils.PrivacyManager.a ? ((io.dcloud.sdk.poly.base.utils.PrivacyManager.a) privacyConfig).getImsi() : "";
    }

    public java.lang.String c() {
        io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig privacyConfig = this.a;
        return privacyConfig instanceof io.dcloud.sdk.poly.base.utils.PrivacyManager.a ? ((io.dcloud.sdk.poly.base.utils.PrivacyManager.a) privacyConfig).getAndroidId() : "";
    }

    public boolean d() {
        io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig privacyConfig = this.a;
        if (privacyConfig instanceof io.dcloud.sdk.poly.base.utils.PrivacyManager.a) {
            return ((io.dcloud.sdk.poly.base.utils.PrivacyManager.a) privacyConfig).isAllowPrivacy();
        }
        return true;
    }

    public boolean e() {
        return this.a != null;
    }

    public java.util.Map<java.lang.String, java.lang.Boolean> getPrivacyMap() {
        return this.b;
    }

    public void updateConfig(io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig privacyConfig) {
        this.a = privacyConfig;
        this.b.put(io.dcloud.sdk.core.util.Const.PrivacyType.IS_ADULT, java.lang.Boolean.valueOf(privacyConfig.isAdult()));
        this.b.put(io.dcloud.sdk.core.util.Const.PrivacyType.IS_CAN_USE_PHONE_STATE, java.lang.Boolean.valueOf(privacyConfig.isCanUsePhoneState()));
        this.b.put(io.dcloud.sdk.core.util.Const.PrivacyType.IS_CAN_USE_STORAGE, java.lang.Boolean.valueOf(privacyConfig.isCanUseStorage()));
        this.b.put(io.dcloud.sdk.core.util.Const.PrivacyType.IS_CAN_USE_LOCATION, java.lang.Boolean.valueOf(privacyConfig.isCanUseLocation()));
        this.b.put(io.dcloud.sdk.core.util.Const.PrivacyType.IS_CAN_USE_WIFI_STATE, java.lang.Boolean.valueOf(privacyConfig.isCanUseWifiState()));
        this.b.put(io.dcloud.sdk.core.util.Const.PrivacyType.IS_CAN_GET_INSTALL_APP_LIST, java.lang.Boolean.valueOf(privacyConfig.isCanGetInstallAppList()));
        this.b.put(io.dcloud.sdk.core.util.Const.PrivacyType.IS_CAN_GET_RUNNING_APPS, java.lang.Boolean.valueOf(privacyConfig.isCanGetRunningApps()));
        this.b.put(io.dcloud.sdk.core.util.Const.PrivacyType.IS_CAN_GET_MAC, java.lang.Boolean.valueOf(privacyConfig.isCanGetMacAddress()));
        this.b.put(io.dcloud.sdk.core.util.Const.PrivacyType.IS_CAN_GET_ANDROID_ID, java.lang.Boolean.valueOf(privacyConfig.isCanGetAndroidId()));
    }
}
