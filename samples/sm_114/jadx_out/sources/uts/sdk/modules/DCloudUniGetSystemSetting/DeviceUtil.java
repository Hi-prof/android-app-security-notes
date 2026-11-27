package uts.sdk.modules.DCloudUniGetSystemSetting;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0016\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Luts/sdk/modules/DCloudUniGetSystemSetting/DeviceUtil;", "", "<init>", "()V", "Companion", "uni-getSystemSetting_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class DeviceUtil {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final uts.sdk.modules.DCloudUniGetSystemSetting.DeviceUtil.Companion INSTANCE = new uts.sdk.modules.DCloudUniGetSystemSetting.DeviceUtil.Companion(null);

    /* JADX INFO: compiled from: index.kt */
    @kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\f"}, d2 = {"Luts/sdk/modules/DCloudUniGetSystemSetting/DeviceUtil$Companion;", "", "<init>", "()V", "blueToothEnable", "", "context", "Landroid/content/Context;", "locationEnable", "wifiEnable", "deviceOrientation", "", "uni-getSystemSetting_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean blueToothEnable(android.content.Context context) throws java.lang.Exception {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
            if (android.os.Build.VERSION.SDK_INT >= 23 && context.checkSelfPermission("android.permission.BLUETOOTH") == -1) {
                throw new java.lang.Exception();
            }
            java.lang.Object systemService = context.getSystemService("bluetooth");
            kotlin.jvm.internal.Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
            return ((android.bluetooth.BluetoothManager) systemService).getAdapter().isEnabled();
        }

        public final boolean locationEnable(android.content.Context context) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
            if (android.os.Build.VERSION.SDK_INT < 28) {
                return android.provider.Settings.Secure.getInt(context.getContentResolver(), "location_mode", 0) != 0;
            }
            java.lang.Object systemService = context.getSystemService("location");
            kotlin.jvm.internal.Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
            return ((android.location.LocationManager) systemService).isLocationEnabled();
        }

        public final boolean wifiEnable(android.content.Context context) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
            java.lang.Object systemService = context.getApplicationContext().getSystemService("wifi");
            kotlin.jvm.internal.Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
            return ((android.net.wifi.WifiManager) systemService).getWifiState() == 3;
        }

        public final java.lang.String deviceOrientation(android.content.Context context) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
            int i = context.getResources().getConfiguration().orientation;
            if (i == 1) {
                return "portrait";
            }
            if (i == 2) {
                return "landscape";
            }
            return "";
        }
    }
}
