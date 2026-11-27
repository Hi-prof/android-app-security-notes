package uts.sdk.modules.DCloudUniGetAppBaseInfo;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\bI\b\u0016\u0018\u00002\u00020\u0001B×\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b!\u0010\"R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010$\"\u0004\b(\u0010&R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010$\"\u0004\b,\u0010&R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010$\"\u0004\b.\u0010&R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010$\"\u0004\b0\u0010&R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010$\"\u0004\b2\u0010&R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010$\"\u0004\b4\u0010&R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010$\"\u0004\b6\u0010&R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010$\"\u0004\b8\u0010&R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010$\"\u0004\b:\u0010&R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010$\"\u0004\b<\u0010&R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010$\"\u0004\b>\u0010&R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010$\"\u0004\b@\u0010&R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010$\"\u0004\bB\u0010&R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010$\"\u0004\bD\u0010&R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0096\u000e¢\u0006\u0010\n\u0002\u0010H\u001a\u0004\b\u0013\u0010E\"\u0004\bF\u0010GR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010$\"\u0004\bJ\u0010&R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010$\"\u0004\bL\u0010&R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0018X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010N\"\u0004\bR\u0010PR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010$\"\u0004\bT\u0010&R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0018X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010N\"\u0004\bV\u0010PR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010$\"\u0004\bX\u0010&R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010$\"\u0004\bZ\u0010&R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010$\"\u0004\b\\\u0010&R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010$\"\u0004\b^\u0010&R\u001c\u0010 \u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010$\"\u0004\b`\u0010&¨\u0006a"}, d2 = {"Luts/sdk/modules/DCloudUniGetAppBaseInfo/GetAppBaseInfoResult;", "Lio/dcloud/uts/UTSObject;", "appId", "", com.taobao.weex.common.WXConfig.appName, com.taobao.weex.common.WXConfig.appVersion, "appVersionCode", "appLanguage", "appTheme", io.dcloud.common.constant.AbsoluteConst.XML_CHANNEL, "language", "version", "appWgtVersion", "hostLanguage", "hostVersion", "hostName", "hostPackageName", "hostSDKVersion", "hostTheme", "isUniAppX", "", "uniCompileVersion", "uniCompilerVersion", "uniCompileVersionCode", "", "uniCompilerVersionCode", "uniRuntimeVersion", "uniRuntimeVersionCode", "uniPlatform", "packageName", "bundleName", "bundleId", "signature", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "getAppName", "setAppName", "getAppVersion", "setAppVersion", "getAppVersionCode", "setAppVersionCode", "getAppLanguage", "setAppLanguage", "getAppTheme", "setAppTheme", "getChannel", "setChannel", "getLanguage", "setLanguage", "getVersion", "setVersion", "getAppWgtVersion", "setAppWgtVersion", "getHostLanguage", "setHostLanguage", "getHostVersion", "setHostVersion", "getHostName", "setHostName", "getHostPackageName", "setHostPackageName", "getHostSDKVersion", "setHostSDKVersion", "getHostTheme", "setHostTheme", "()Ljava/lang/Boolean;", "setUniAppX", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getUniCompileVersion", "setUniCompileVersion", "getUniCompilerVersion", "setUniCompilerVersion", "getUniCompileVersionCode", "()Ljava/lang/Number;", "setUniCompileVersionCode", "(Ljava/lang/Number;)V", "getUniCompilerVersionCode", "setUniCompilerVersionCode", "getUniRuntimeVersion", "setUniRuntimeVersion", "getUniRuntimeVersionCode", "setUniRuntimeVersionCode", "getUniPlatform", "setUniPlatform", "getPackageName", "setPackageName", "getBundleName", "setBundleName", "getBundleId", "setBundleId", "getSignature", "setSignature", "uni-getAppBaseInfo_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class GetAppBaseInfoResult extends io.dcloud.uts.UTSObject {
    private java.lang.String appId;
    private java.lang.String appLanguage;
    private java.lang.String appName;
    private java.lang.String appTheme;
    private java.lang.String appVersion;
    private java.lang.String appVersionCode;
    private java.lang.String appWgtVersion;
    private java.lang.String bundleId;
    private java.lang.String bundleName;
    private java.lang.String channel;
    private java.lang.String hostLanguage;
    private java.lang.String hostName;
    private java.lang.String hostPackageName;
    private java.lang.String hostSDKVersion;
    private java.lang.String hostTheme;
    private java.lang.String hostVersion;
    private java.lang.Boolean isUniAppX;
    private java.lang.String language;
    private java.lang.String packageName;
    private java.lang.String signature;
    private java.lang.String uniCompileVersion;
    private java.lang.Number uniCompileVersionCode;
    private java.lang.String uniCompilerVersion;
    private java.lang.Number uniCompilerVersionCode;
    private java.lang.String uniPlatform;
    private java.lang.String uniRuntimeVersion;
    private java.lang.Number uniRuntimeVersionCode;
    private java.lang.String version;

    public GetAppBaseInfoResult() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 268435455, null);
    }

    public /* synthetic */ GetAppBaseInfoResult(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.String str9, java.lang.String str10, java.lang.String str11, java.lang.String str12, java.lang.String str13, java.lang.String str14, java.lang.String str15, java.lang.String str16, java.lang.Boolean bool, java.lang.String str17, java.lang.String str18, java.lang.Number number, java.lang.Number number2, java.lang.String str19, java.lang.Number number3, java.lang.String str20, java.lang.String str21, java.lang.String str22, java.lang.String str23, java.lang.String str24, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? null : str10, (i & 1024) != 0 ? null : str11, (i & 2048) != 0 ? null : str12, (i & 4096) != 0 ? null : str13, (i & 8192) != 0 ? null : str14, (i & 16384) != 0 ? null : str15, (i & 32768) != 0 ? null : str16, (i & 65536) != 0 ? null : bool, (i & 131072) != 0 ? null : str17, (i & 262144) != 0 ? null : str18, (i & 524288) != 0 ? null : number, (i & 1048576) != 0 ? null : number2, (i & 2097152) != 0 ? null : str19, (i & 4194304) != 0 ? null : number3, (i & 8388608) != 0 ? null : str20, (i & 16777216) != 0 ? null : str21, (i & 33554432) != 0 ? null : str22, (i & androidx.core.view.accessibility.AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? null : str23, (i & 134217728) != 0 ? null : str24);
    }

    public java.lang.String getAppId() {
        return this.appId;
    }

    public void setAppId(java.lang.String str) {
        this.appId = str;
    }

    public java.lang.String getAppName() {
        return this.appName;
    }

    public void setAppName(java.lang.String str) {
        this.appName = str;
    }

    public java.lang.String getAppVersion() {
        return this.appVersion;
    }

    public void setAppVersion(java.lang.String str) {
        this.appVersion = str;
    }

    public java.lang.String getAppVersionCode() {
        return this.appVersionCode;
    }

    public void setAppVersionCode(java.lang.String str) {
        this.appVersionCode = str;
    }

    public java.lang.String getAppLanguage() {
        return this.appLanguage;
    }

    public void setAppLanguage(java.lang.String str) {
        this.appLanguage = str;
    }

    public java.lang.String getAppTheme() {
        return this.appTheme;
    }

    public void setAppTheme(java.lang.String str) {
        this.appTheme = str;
    }

    public java.lang.String getChannel() {
        return this.channel;
    }

    public void setChannel(java.lang.String str) {
        this.channel = str;
    }

    public java.lang.String getLanguage() {
        return this.language;
    }

    public void setLanguage(java.lang.String str) {
        this.language = str;
    }

    public java.lang.String getVersion() {
        return this.version;
    }

    public void setVersion(java.lang.String str) {
        this.version = str;
    }

    public java.lang.String getAppWgtVersion() {
        return this.appWgtVersion;
    }

    public void setAppWgtVersion(java.lang.String str) {
        this.appWgtVersion = str;
    }

    public java.lang.String getHostLanguage() {
        return this.hostLanguage;
    }

    public void setHostLanguage(java.lang.String str) {
        this.hostLanguage = str;
    }

    public java.lang.String getHostVersion() {
        return this.hostVersion;
    }

    public void setHostVersion(java.lang.String str) {
        this.hostVersion = str;
    }

    public java.lang.String getHostName() {
        return this.hostName;
    }

    public void setHostName(java.lang.String str) {
        this.hostName = str;
    }

    public java.lang.String getHostPackageName() {
        return this.hostPackageName;
    }

    public void setHostPackageName(java.lang.String str) {
        this.hostPackageName = str;
    }

    public java.lang.String getHostSDKVersion() {
        return this.hostSDKVersion;
    }

    public void setHostSDKVersion(java.lang.String str) {
        this.hostSDKVersion = str;
    }

    public java.lang.String getHostTheme() {
        return this.hostTheme;
    }

    public void setHostTheme(java.lang.String str) {
        this.hostTheme = str;
    }

    /* JADX INFO: renamed from: isUniAppX, reason: from getter */
    public java.lang.Boolean getIsUniAppX() {
        return this.isUniAppX;
    }

    public void setUniAppX(java.lang.Boolean bool) {
        this.isUniAppX = bool;
    }

    public java.lang.String getUniCompileVersion() {
        return this.uniCompileVersion;
    }

    public void setUniCompileVersion(java.lang.String str) {
        this.uniCompileVersion = str;
    }

    public java.lang.String getUniCompilerVersion() {
        return this.uniCompilerVersion;
    }

    public void setUniCompilerVersion(java.lang.String str) {
        this.uniCompilerVersion = str;
    }

    public java.lang.Number getUniCompileVersionCode() {
        return this.uniCompileVersionCode;
    }

    public void setUniCompileVersionCode(java.lang.Number number) {
        this.uniCompileVersionCode = number;
    }

    public java.lang.Number getUniCompilerVersionCode() {
        return this.uniCompilerVersionCode;
    }

    public void setUniCompilerVersionCode(java.lang.Number number) {
        this.uniCompilerVersionCode = number;
    }

    public java.lang.String getUniRuntimeVersion() {
        return this.uniRuntimeVersion;
    }

    public void setUniRuntimeVersion(java.lang.String str) {
        this.uniRuntimeVersion = str;
    }

    public java.lang.Number getUniRuntimeVersionCode() {
        return this.uniRuntimeVersionCode;
    }

    public void setUniRuntimeVersionCode(java.lang.Number number) {
        this.uniRuntimeVersionCode = number;
    }

    public java.lang.String getUniPlatform() {
        return this.uniPlatform;
    }

    public void setUniPlatform(java.lang.String str) {
        this.uniPlatform = str;
    }

    public java.lang.String getPackageName() {
        return this.packageName;
    }

    public void setPackageName(java.lang.String str) {
        this.packageName = str;
    }

    public java.lang.String getBundleName() {
        return this.bundleName;
    }

    public void setBundleName(java.lang.String str) {
        this.bundleName = str;
    }

    public java.lang.String getBundleId() {
        return this.bundleId;
    }

    public void setBundleId(java.lang.String str) {
        this.bundleId = str;
    }

    public java.lang.String getSignature() {
        return this.signature;
    }

    public void setSignature(java.lang.String str) {
        this.signature = str;
    }

    public GetAppBaseInfoResult(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.String str9, java.lang.String str10, java.lang.String str11, java.lang.String str12, java.lang.String str13, java.lang.String str14, java.lang.String str15, java.lang.String str16, java.lang.Boolean bool, java.lang.String str17, java.lang.String str18, java.lang.Number number, java.lang.Number number2, java.lang.String str19, java.lang.Number number3, java.lang.String str20, java.lang.String str21, java.lang.String str22, java.lang.String str23, java.lang.String str24) {
        this.appId = str;
        this.appName = str2;
        this.appVersion = str3;
        this.appVersionCode = str4;
        this.appLanguage = str5;
        this.appTheme = str6;
        this.channel = str7;
        this.language = str8;
        this.version = str9;
        this.appWgtVersion = str10;
        this.hostLanguage = str11;
        this.hostVersion = str12;
        this.hostName = str13;
        this.hostPackageName = str14;
        this.hostSDKVersion = str15;
        this.hostTheme = str16;
        this.isUniAppX = bool;
        this.uniCompileVersion = str17;
        this.uniCompilerVersion = str18;
        this.uniCompileVersionCode = number;
        this.uniCompilerVersionCode = number2;
        this.uniRuntimeVersion = str19;
        this.uniRuntimeVersionCode = number3;
        this.uniPlatform = str20;
        this.packageName = str21;
        this.bundleName = str22;
        this.bundleId = str23;
        this.signature = str24;
    }
}
