package io.dcloud.sdk.core;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
@java.lang.Deprecated
public class DCloudAOLManager {
    private static java.lang.String a = "";
    protected static io.dcloud.sdk.core.interfaces.AOLLoader b;
    protected static java.util.concurrent.atomic.AtomicBoolean c = new java.util.concurrent.atomic.AtomicBoolean(false);
    private static java.util.concurrent.atomic.AtomicBoolean d = new java.util.concurrent.atomic.AtomicBoolean(false);

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class InitConfig {
        private java.lang.String a;
        private java.lang.String b;
        private java.lang.String c;
        private java.lang.String d;
        private boolean e = false;

        public java.lang.String getAdId() {
            return this.b;
        }

        public java.lang.String getAppId() {
            return this.a;
        }

        public java.lang.String getName() {
            return this.d;
        }

        public java.lang.String getVersion() {
            return this.c;
        }

        public boolean isDebug() {
            return this.e;
        }

        public io.dcloud.sdk.core.DCloudAOLManager.InitConfig setAdId(java.lang.String str) {
            this.b = str;
            return this;
        }

        public io.dcloud.sdk.core.DCloudAOLManager.InitConfig setAppId(java.lang.String str) {
            this.a = str;
            return this;
        }

        public void setDebug(boolean z) {
            this.e = z;
        }

        public io.dcloud.sdk.core.DCloudAOLManager.InitConfig setName(java.lang.String str) {
            this.d = str;
            return this;
        }

        public io.dcloud.sdk.core.DCloudAOLManager.InitConfig setVersion(java.lang.String str) {
            this.c = str;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static abstract class PrivacyConfig {
        public boolean isAdult() {
            return true;
        }

        public boolean isCanGetAndroidId() {
            return true;
        }

        public boolean isCanGetBootId() {
            return true;
        }

        public boolean isCanGetIP() {
            return true;
        }

        public boolean isCanGetInstallAppList() {
            return true;
        }

        public boolean isCanGetMacAddress() {
            return true;
        }

        public boolean isCanGetOAID() {
            return true;
        }

        public boolean isCanGetRunningApps() {
            return true;
        }

        public boolean isCanUseLocation() {
            return true;
        }

        public boolean isCanUsePhoneState() {
            return true;
        }

        public boolean isCanUseRecordPermission() {
            return true;
        }

        public boolean isCanUseSensor() {
            return true;
        }

        public boolean isCanUseSimOperator() {
            return true;
        }

        public boolean isCanUseStorage() {
            return true;
        }

        public boolean isCanUseWifiState() {
            return true;
        }

        public boolean isGDTAgreeStrategy() {
            return true;
        }

        public org.json.JSONObject userPrivacyConfig() {
            return new org.json.JSONObject();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class a extends java.util.HashMap {
        a() {
            put(com.facebook.common.callercontext.ContextChain.TAG_INFRA, java.lang.Boolean.FALSE);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    class b extends java.util.HashMap {
        b() {
            put(com.facebook.common.callercontext.ContextChain.TAG_INFRA, java.lang.Boolean.FALSE);
        }
    }

    public static boolean getPersonalAd(android.content.Context context) {
        io.dcloud.sdk.core.interfaces.AOLLoader aOLLoader = b;
        if (aOLLoader == null) {
            return false;
        }
        return aOLLoader.getPersonalAOL(context);
    }

    public static java.lang.String getVersion() {
        return a;
    }

    public static void init(android.content.Context context, io.dcloud.sdk.core.DCloudAOLManager.InitConfig initConfig) {
        if (context == null || initConfig == null) {
            throw new java.lang.NullPointerException("context or config is null");
        }
        if (((context instanceof android.app.Activity) || (context instanceof android.app.Application)) && !c.get()) {
            c.set(true);
            if (b == null) {
                io.dcloud.p.r0 r0VarD = io.dcloud.p.r0.d();
                r0VarD.b(context);
                r0VarD.a(initConfig);
                b = r0VarD;
                r0VarD.e();
                r0VarD.a(context);
            }
        }
    }

    public static void initWebViewWithMultiProcess(android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            for (android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((android.app.ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == android.os.Process.myPid()) {
                    if (runningAppProcessInfo.processName.equals(context.getPackageName())) {
                        android.webkit.WebView.setDataDirectorySuffix(runningAppProcessInfo.processName);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public static boolean isInit() {
        return c.get();
    }

    public static void setPersonalAd(android.content.Context context, boolean z) {
        io.dcloud.sdk.core.interfaces.AOLLoader aOLLoader = b;
        if (aOLLoader != null) {
            aOLLoader.setPersonalAOL(context, z);
        }
    }

    public static void setPrivacyConfig(io.dcloud.sdk.core.DCloudAOLManager.PrivacyConfig privacyConfig) {
        io.dcloud.sdk.core.interfaces.AOLLoader aOLLoader = b;
        if (aOLLoader == null) {
            throw new java.lang.RuntimeException("please init first");
        }
        if (privacyConfig == null) {
            throw new java.lang.RuntimeException("config is null");
        }
        aOLLoader.setPrivacyConfig(privacyConfig);
    }

    @java.lang.Deprecated
    public static void start(io.dcloud.sdk.core.interfaces.AOLLoader.AOLStartCallback aOLStartCallback) {
        if (!isInit()) {
            throw new java.lang.RuntimeException("please init first");
        }
        io.dcloud.sdk.core.interfaces.AOLLoader aOLLoader = b;
        if (aOLLoader == null) {
            throw new java.lang.RuntimeException("please init first");
        }
        aOLLoader.start(aOLStartCallback);
    }

    public static void updatePrivacyConfig(android.content.Context context, org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            throw new java.lang.RuntimeException("config is null");
        }
        b.updatePrivacyConfig(context, jSONObject);
    }

    public static java.util.Map<java.lang.String, java.lang.Object> verify(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (!c.get()) {
            return new io.dcloud.sdk.core.DCloudAOLManager.a();
        }
        io.dcloud.sdk.core.interfaces.AOLLoader aOLLoader = b;
        return aOLLoader == null ? new io.dcloud.sdk.core.DCloudAOLManager.b() : aOLLoader.verify(map);
    }
}
