package uts.sdk.modules.DCloudUniGetDeviceInfo;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b>\b\u0016\u0018\u00002\u00020\u0001B\u008f\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001e\"\u0004\b*\u0010 R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001e\"\u0004\b,\u0010 R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001e\"\u0004\b2\u0010 R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001e\"\u0004\b4\u0010 R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0096\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\b\u000e\u00105\"\u0004\b6\u00107R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0096\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\b\u0010\u00105\"\u0004\b9\u00107R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u000fX\u0096\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\b\u0011\u00105\"\u0004\b:\u00107R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001e\"\u0004\b<\u0010 R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001e\"\u0004\b>\u0010 R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u001e\"\u0004\b@\u0010 R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u001e\"\u0004\bB\u0010 R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010.\"\u0004\bD\u00100R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010.\"\u0004\bF\u00100R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u001e\"\u0004\bH\u0010 R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u001e\"\u0004\bJ\u0010 R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u001e\"\u0004\bL\u0010 ¨\u0006M"}, d2 = {"Luts/sdk/modules/DCloudUniGetDeviceInfo/GetDeviceInfoResult;", "Lio/dcloud/uts/UTSObject;", "brand", "", "deviceBrand", "deviceId", "model", "deviceModel", "deviceType", "deviceOrientation", "devicePixelRatio", "", "system", com.taobao.weex.common.RenderTypes.RENDER_TYPE_NATIVE, "isRoot", "", "isSimulator", "isUSBDebugging", com.taobao.weex.common.WXConfig.osName, "osVersion", "osLanguage", "osTheme", "osAndroidAPILevel", "osHarmonySDKAPIVersion", "osHarmonyDisplayVersion", "romName", "romVersion", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Number;Ljava/lang/Number;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBrand", "()Ljava/lang/String;", "setBrand", "(Ljava/lang/String;)V", "getDeviceBrand", "setDeviceBrand", "getDeviceId", "setDeviceId", "getModel", "setModel", "getDeviceModel", "setDeviceModel", "getDeviceType", "setDeviceType", "getDeviceOrientation", "setDeviceOrientation", "getDevicePixelRatio", "()Ljava/lang/Number;", "setDevicePixelRatio", "(Ljava/lang/Number;)V", "getSystem", "setSystem", "getPlatform", "setPlatform", "()Ljava/lang/Boolean;", "setRoot", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "setSimulator", "setUSBDebugging", "getOsName", "setOsName", "getOsVersion", "setOsVersion", "getOsLanguage", "setOsLanguage", "getOsTheme", "setOsTheme", "getOsAndroidAPILevel", "setOsAndroidAPILevel", "getOsHarmonySDKAPIVersion", "setOsHarmonySDKAPIVersion", "getOsHarmonyDisplayVersion", "setOsHarmonyDisplayVersion", "getRomName", "setRomName", "getRomVersion", "setRomVersion", "uni-getDeviceInfo_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class GetDeviceInfoResult extends io.dcloud.uts.UTSObject {
    private java.lang.String brand;
    private java.lang.String deviceBrand;
    private java.lang.String deviceId;
    private java.lang.String deviceModel;
    private java.lang.String deviceOrientation;
    private java.lang.Number devicePixelRatio;
    private java.lang.String deviceType;
    private java.lang.Boolean isRoot;
    private java.lang.Boolean isSimulator;
    private java.lang.Boolean isUSBDebugging;
    private java.lang.String model;
    private java.lang.Number osAndroidAPILevel;
    private java.lang.String osHarmonyDisplayVersion;
    private java.lang.Number osHarmonySDKAPIVersion;
    private java.lang.String osLanguage;
    private java.lang.String osName;
    private java.lang.String osTheme;
    private java.lang.String osVersion;
    private java.lang.String platform;
    private java.lang.String romName;
    private java.lang.String romVersion;
    private java.lang.String system;

    public GetDeviceInfoResult() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null);
    }

    public /* synthetic */ GetDeviceInfoResult(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.Number number, java.lang.String str8, java.lang.String str9, java.lang.Boolean bool, java.lang.Boolean bool2, java.lang.Boolean bool3, java.lang.String str10, java.lang.String str11, java.lang.String str12, java.lang.String str13, java.lang.Number number2, java.lang.Number number3, java.lang.String str14, java.lang.String str15, java.lang.String str16, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : number, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : str9, (i & 1024) != 0 ? null : bool, (i & 2048) != 0 ? null : bool2, (i & 4096) != 0 ? null : bool3, (i & 8192) != 0 ? null : str10, (i & 16384) != 0 ? null : str11, (i & 32768) != 0 ? null : str12, (i & 65536) != 0 ? null : str13, (i & 131072) != 0 ? null : number2, (i & 262144) != 0 ? null : number3, (i & 524288) != 0 ? null : str14, (i & 1048576) != 0 ? null : str15, (i & 2097152) != 0 ? null : str16);
    }

    public java.lang.String getBrand() {
        return this.brand;
    }

    public void setBrand(java.lang.String str) {
        this.brand = str;
    }

    public java.lang.String getDeviceBrand() {
        return this.deviceBrand;
    }

    public void setDeviceBrand(java.lang.String str) {
        this.deviceBrand = str;
    }

    public java.lang.String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(java.lang.String str) {
        this.deviceId = str;
    }

    public java.lang.String getModel() {
        return this.model;
    }

    public void setModel(java.lang.String str) {
        this.model = str;
    }

    public java.lang.String getDeviceModel() {
        return this.deviceModel;
    }

    public void setDeviceModel(java.lang.String str) {
        this.deviceModel = str;
    }

    public java.lang.String getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceType(java.lang.String str) {
        this.deviceType = str;
    }

    public java.lang.String getDeviceOrientation() {
        return this.deviceOrientation;
    }

    public void setDeviceOrientation(java.lang.String str) {
        this.deviceOrientation = str;
    }

    public java.lang.Number getDevicePixelRatio() {
        return this.devicePixelRatio;
    }

    public void setDevicePixelRatio(java.lang.Number number) {
        this.devicePixelRatio = number;
    }

    public java.lang.String getSystem() {
        return this.system;
    }

    public void setSystem(java.lang.String str) {
        this.system = str;
    }

    public java.lang.String getPlatform() {
        return this.platform;
    }

    public void setPlatform(java.lang.String str) {
        this.platform = str;
    }

    /* JADX INFO: renamed from: isRoot, reason: from getter */
    public java.lang.Boolean getIsRoot() {
        return this.isRoot;
    }

    public void setRoot(java.lang.Boolean bool) {
        this.isRoot = bool;
    }

    /* JADX INFO: renamed from: isSimulator, reason: from getter */
    public java.lang.Boolean getIsSimulator() {
        return this.isSimulator;
    }

    public void setSimulator(java.lang.Boolean bool) {
        this.isSimulator = bool;
    }

    /* JADX INFO: renamed from: isUSBDebugging, reason: from getter */
    public java.lang.Boolean getIsUSBDebugging() {
        return this.isUSBDebugging;
    }

    public void setUSBDebugging(java.lang.Boolean bool) {
        this.isUSBDebugging = bool;
    }

    public java.lang.String getOsName() {
        return this.osName;
    }

    public void setOsName(java.lang.String str) {
        this.osName = str;
    }

    public java.lang.String getOsVersion() {
        return this.osVersion;
    }

    public void setOsVersion(java.lang.String str) {
        this.osVersion = str;
    }

    public java.lang.String getOsLanguage() {
        return this.osLanguage;
    }

    public void setOsLanguage(java.lang.String str) {
        this.osLanguage = str;
    }

    public java.lang.String getOsTheme() {
        return this.osTheme;
    }

    public void setOsTheme(java.lang.String str) {
        this.osTheme = str;
    }

    public java.lang.Number getOsAndroidAPILevel() {
        return this.osAndroidAPILevel;
    }

    public void setOsAndroidAPILevel(java.lang.Number number) {
        this.osAndroidAPILevel = number;
    }

    public java.lang.Number getOsHarmonySDKAPIVersion() {
        return this.osHarmonySDKAPIVersion;
    }

    public void setOsHarmonySDKAPIVersion(java.lang.Number number) {
        this.osHarmonySDKAPIVersion = number;
    }

    public java.lang.String getOsHarmonyDisplayVersion() {
        return this.osHarmonyDisplayVersion;
    }

    public void setOsHarmonyDisplayVersion(java.lang.String str) {
        this.osHarmonyDisplayVersion = str;
    }

    public java.lang.String getRomName() {
        return this.romName;
    }

    public void setRomName(java.lang.String str) {
        this.romName = str;
    }

    public java.lang.String getRomVersion() {
        return this.romVersion;
    }

    public void setRomVersion(java.lang.String str) {
        this.romVersion = str;
    }

    public GetDeviceInfoResult(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.Number number, java.lang.String str8, java.lang.String str9, java.lang.Boolean bool, java.lang.Boolean bool2, java.lang.Boolean bool3, java.lang.String str10, java.lang.String str11, java.lang.String str12, java.lang.String str13, java.lang.Number number2, java.lang.Number number3, java.lang.String str14, java.lang.String str15, java.lang.String str16) {
        this.brand = str;
        this.deviceBrand = str2;
        this.deviceId = str3;
        this.model = str4;
        this.deviceModel = str5;
        this.deviceType = str6;
        this.deviceOrientation = str7;
        this.devicePixelRatio = number;
        this.system = str8;
        this.platform = str9;
        this.isRoot = bool;
        this.isSimulator = bool2;
        this.isUSBDebugging = bool3;
        this.osName = str10;
        this.osVersion = str11;
        this.osLanguage = str12;
        this.osTheme = str13;
        this.osAndroidAPILevel = number2;
        this.osHarmonySDKAPIVersion = number3;
        this.osHarmonyDisplayVersion = str14;
        this.romName = str15;
        this.romVersion = str16;
    }
}
