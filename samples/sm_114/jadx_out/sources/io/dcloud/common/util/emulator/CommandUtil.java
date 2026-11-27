package io.dcloud.common.util.emulator;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class CommandUtil {

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private static class SingletonHolder {
        private static final io.dcloud.common.util.emulator.CommandUtil INSTANCE = new io.dcloud.common.util.emulator.CommandUtil();

        private SingletonHolder() {
        }
    }

    public static final io.dcloud.common.util.emulator.CommandUtil getSingleInstance() {
        return io.dcloud.common.util.emulator.CommandUtil.SingletonHolder.INSTANCE;
    }

    public java.lang.String getProperty(java.lang.String str) {
        try {
            java.lang.Object objInvoke = java.lang.Class.forName("android.os.SystemProperties").getMethod("get", java.lang.String.class).invoke(null, str);
            if (objInvoke != null) {
                return (java.lang.String) objInvoke;
            }
        } catch (java.lang.Throwable unused) {
        }
        return null;
    }

    private CommandUtil() {
    }
}
