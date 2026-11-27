package uts.sdk.modules.DCloudUniGetSystemSetting;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0016\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0006\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u001e\u0010\t\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014¨\u0006\u001f"}, d2 = {"Luts/sdk/modules/DCloudUniGetSystemSetting/GetSystemSettingResult;", "Lio/dcloud/uts/UTSObject;", "bluetoothEnabled", "", "bluetoothError", "", "locationEnabled", "wifiEnabled", "wifiError", "deviceOrientation", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getBluetoothEnabled", "()Ljava/lang/Boolean;", "setBluetoothEnabled", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getBluetoothError", "()Ljava/lang/String;", "setBluetoothError", "(Ljava/lang/String;)V", "getLocationEnabled", "()Z", "setLocationEnabled", "(Z)V", "getWifiEnabled", "setWifiEnabled", "getWifiError", "setWifiError", "getDeviceOrientation", "setDeviceOrientation", "uni-getSystemSetting_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class GetSystemSettingResult extends io.dcloud.uts.UTSObject {
    private java.lang.Boolean bluetoothEnabled;
    private java.lang.String bluetoothError;

    @io.dcloud.uts.JsonNotNull
    private java.lang.String deviceOrientation;

    @io.dcloud.uts.JsonNotNull
    private boolean locationEnabled;
    private java.lang.Boolean wifiEnabled;
    private java.lang.String wifiError;

    public /* synthetic */ GetSystemSettingResult(java.lang.Boolean bool, java.lang.String str, boolean z, java.lang.Boolean bool2, java.lang.String str2, java.lang.String str3, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : str, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : bool2, (i & 16) != 0 ? null : str2, str3);
    }

    public java.lang.Boolean getBluetoothEnabled() {
        return this.bluetoothEnabled;
    }

    public void setBluetoothEnabled(java.lang.Boolean bool) {
        this.bluetoothEnabled = bool;
    }

    public java.lang.String getBluetoothError() {
        return this.bluetoothError;
    }

    public void setBluetoothError(java.lang.String str) {
        this.bluetoothError = str;
    }

    public boolean getLocationEnabled() {
        return this.locationEnabled;
    }

    public void setLocationEnabled(boolean z) {
        this.locationEnabled = z;
    }

    public java.lang.Boolean getWifiEnabled() {
        return this.wifiEnabled;
    }

    public void setWifiEnabled(java.lang.Boolean bool) {
        this.wifiEnabled = bool;
    }

    public java.lang.String getWifiError() {
        return this.wifiError;
    }

    public void setWifiError(java.lang.String str) {
        this.wifiError = str;
    }

    public java.lang.String getDeviceOrientation() {
        return this.deviceOrientation;
    }

    public void setDeviceOrientation(java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.deviceOrientation = str;
    }

    public GetSystemSettingResult(java.lang.Boolean bool, java.lang.String str, boolean z, java.lang.Boolean bool2, java.lang.String str2, java.lang.String deviceOrientation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(deviceOrientation, "deviceOrientation");
        this.bluetoothEnabled = bool;
        this.bluetoothError = str;
        this.locationEnabled = z;
        this.wifiEnabled = bool2;
        this.wifiError = str2;
        this.deviceOrientation = deviceOrientation;
    }
}
