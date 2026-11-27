package com.taobao.weex.bridge;

/* JADX INFO: loaded from: classes.dex */
public class WXParams implements java.io.Serializable {
    private java.lang.String appName;
    private java.lang.String appVersion;
    private java.lang.String cacheDir;
    private java.lang.String crashFilePath;
    private java.lang.String deviceHeight;
    private java.lang.String deviceModel;
    private java.lang.String deviceWidth;
    private java.lang.String layoutDirection;
    private java.lang.String libIcuPath;
    private java.lang.String libJsbPath;
    private java.lang.String libJscPath;
    private java.lang.String libJssPath;
    private java.lang.String libLdPath;
    private java.lang.String logLevel;
    private java.lang.String needInitV8;
    private java.util.Map<java.lang.String, java.lang.String> options;
    private java.lang.String osVersion;
    private java.lang.String platform;
    private java.lang.String shouldInfoCollect;
    private java.lang.String useSingleProcess;
    private java.lang.String weexVersion;

    public java.lang.Object getOptions() {
        return this.options;
    }

    public java.lang.String getLibJsbPath() {
        com.taobao.weex.utils.WXLogUtils.e("getLibJsbPath is running " + this.libJsbPath);
        return this.libJsbPath;
    }

    public void setLibJsbPath(java.lang.String str) {
        this.libJsbPath = str;
    }

    public void setOptions(java.util.Map<java.lang.String, java.lang.String> map) {
        this.options = map;
    }

    public java.lang.String getShouldInfoCollect() {
        return this.shouldInfoCollect;
    }

    public void setShouldInfoCollect(java.lang.String str) {
        this.shouldInfoCollect = str;
    }

    public java.lang.String getPlatform() {
        return this.platform;
    }

    public void setPlatform(java.lang.String str) {
        this.platform = str;
    }

    public void setCacheDir(java.lang.String str) {
        this.cacheDir = str;
    }

    public java.lang.String getCacheDir() {
        return this.cacheDir;
    }

    public java.lang.String getOsVersion() {
        return this.osVersion;
    }

    public void setOsVersion(java.lang.String str) {
        this.osVersion = str;
    }

    public java.lang.String getAppVersion() {
        return this.appVersion;
    }

    public void setAppVersion(java.lang.String str) {
        this.appVersion = str;
    }

    public java.lang.String getWeexVersion() {
        return this.weexVersion;
    }

    public void setWeexVersion(java.lang.String str) {
        this.weexVersion = str;
    }

    public java.lang.String getDeviceModel() {
        return this.deviceModel;
    }

    public void setDeviceModel(java.lang.String str) {
        this.deviceModel = str;
    }

    public java.lang.String getLayoutDirection() {
        return this.layoutDirection;
    }

    public void setLayoutDirection(java.lang.String str) {
        this.layoutDirection = str;
    }

    public java.lang.String getAppName() {
        return this.appName;
    }

    public void setAppName(java.lang.String str) {
        this.appName = str;
    }

    public java.lang.String getDeviceWidth() {
        return this.deviceWidth;
    }

    public boolean getReleaseMap() {
        com.taobao.weex.adapter.IWXConfigAdapter wxConfigAdapter = com.taobao.weex.WXSDKManager.getInstance().getWxConfigAdapter();
        if (wxConfigAdapter == null) {
            return false;
        }
        java.lang.String configWhenInit = wxConfigAdapter.getConfigWhenInit("wxapm", "release_map", io.dcloud.common.constant.AbsoluteConst.TRUE);
        com.taobao.weex.utils.WXLogUtils.e("getReleaseMap:" + configWhenInit);
        return io.dcloud.common.constant.AbsoluteConst.TRUE.equalsIgnoreCase(configWhenInit);
    }

    @java.lang.Deprecated
    public void setDeviceWidth(java.lang.String str) {
        this.deviceWidth = str;
    }

    public java.lang.String getDeviceHeight() {
        return this.deviceHeight;
    }

    public void setDeviceHeight(java.lang.String str) {
        this.deviceHeight = str;
    }

    public java.lang.String getLogLevel() {
        java.lang.String str = this.logLevel;
        return str == null ? "" : str;
    }

    public java.lang.String getUseSingleProcess() {
        com.taobao.weex.utils.WXLogUtils.e("getUseSingleProcess is running " + this.useSingleProcess);
        return this.useSingleProcess;
    }

    public void setUseSingleProcess(java.lang.String str) {
        this.useSingleProcess = str;
    }

    public void setLogLevel(java.lang.String str) {
        this.logLevel = str;
    }

    public java.lang.String getNeedInitV8() {
        java.lang.String str = this.needInitV8;
        return str == null ? "" : str;
    }

    public void setNeedInitV8(boolean z) {
        if (z) {
            this.needInitV8 = "1";
        } else {
            this.needInitV8 = com.taobao.weex.performance.WXInstanceApm.VALUE_ERROR_CODE_DEFAULT;
        }
    }

    public void setCrashFilePath(java.lang.String str) {
        com.taobao.weex.utils.WXLogUtils.e("WXParams", "setCrashFilePath: " + str);
        this.crashFilePath = str;
    }

    public java.lang.String getCrashFilePath() {
        com.taobao.weex.utils.WXLogUtils.d("WXParams", "getCrashFilePath:" + this.crashFilePath);
        return this.crashFilePath;
    }

    public java.lang.String getLibJssPath() {
        com.taobao.weex.utils.WXLogUtils.d("getLibJssPath is running " + this.libJssPath);
        return this.libJssPath;
    }

    public java.lang.String getLibJscPath() {
        com.taobao.weex.utils.WXLogUtils.d("getLibJscPath is running " + this.libJscPath);
        return this.libJscPath;
    }

    public void setLibJscPath(java.lang.String str) {
        this.libJscPath = str;
    }

    public void setLibJssPath(java.lang.String str) {
        this.libJssPath = str;
    }

    public java.lang.String getLibIcuPath() {
        com.taobao.weex.utils.WXLogUtils.d("getLibIcuPath is running " + this.libIcuPath);
        return this.libIcuPath;
    }

    public void setLibIcuPath(java.lang.String str) {
        this.libIcuPath = str;
    }

    public java.lang.String getLibLdPath() {
        com.taobao.weex.utils.WXLogUtils.e("getLibLdPath is running " + this.libLdPath);
        return this.libLdPath;
    }

    public void setLibLdPath(java.lang.String str) {
        this.libLdPath = str;
    }

    public java.lang.String getUseRunTimeApi() {
        return java.lang.String.valueOf(com.taobao.weex.WXEnvironment.sUseRunTimeApi);
    }

    public java.util.Map<java.lang.String, java.lang.Object> toMap() {
        java.util.HashMap map = new java.util.HashMap();
        map.put(com.taobao.weex.common.WXConfig.appName, this.appName);
        map.put(com.taobao.weex.common.WXConfig.appVersion, this.appVersion);
        map.put(com.taobao.weex.common.WXConfig.cacheDir, this.cacheDir);
        map.put(com.taobao.weex.common.WXConfig.deviceHeight, this.deviceHeight);
        map.put("deviceModel", this.deviceModel);
        map.put(com.taobao.weex.common.WXConfig.deviceWidth, this.deviceWidth);
        map.put(com.taobao.weex.common.WXConfig.layoutDirection, this.layoutDirection);
        map.put("libJssPath", this.libJssPath);
        map.put(com.taobao.weex.common.WXConfig.logLevel, this.logLevel);
        map.put("needInitV8", this.needInitV8);
        map.put("osVersion", this.osVersion);
        map.put(com.taobao.weex.common.RenderTypes.RENDER_TYPE_NATIVE, this.platform);
        map.put("useSingleProcess", this.useSingleProcess);
        map.put("shouldInfoCollect", this.shouldInfoCollect);
        map.put(com.taobao.weex.common.WXConfig.weexVersion, this.weexVersion);
        map.put("crashFilePath", this.crashFilePath);
        map.put("libJscPath", this.libJscPath);
        map.put("libIcuPath", this.libIcuPath);
        map.put("libLdPath", this.libLdPath);
        map.put("options", this.options);
        map.put("useRunTimeApi", java.lang.Boolean.valueOf(com.taobao.weex.WXEnvironment.sUseRunTimeApi));
        map.put("__enable_native_promise__", java.lang.Boolean.valueOf(!com.taobao.weex.WXEnvironment.sUseRunTimeApi));
        return map;
    }
}
