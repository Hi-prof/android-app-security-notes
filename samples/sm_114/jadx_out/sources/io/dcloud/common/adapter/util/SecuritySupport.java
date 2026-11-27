package io.dcloud.common.adapter.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class SecuritySupport {
    public static java.lang.String getAppId() {
        return io.dcloud.common.util.BaseInfo.sDefaultBootApp;
    }

    public static java.lang.String getDeviceId(android.content.Context context) {
        return io.dcloud.common.util.AppRuntime.getDCloudDeviceID(context);
    }

    public static boolean isRoot() {
        return io.dcloud.common.adapter.util.DeviceInfo.hasRootPrivilege();
    }

    public static boolean isSimulator(android.content.Context context) {
        return io.dcloud.common.util.emulator.EmulatorCheckUtil.getSingleInstance().emulatorCheck(context);
    }
}
