package io.dcloud.common.util.emulator;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class EmulatorCheckUtil {
    public static final int RESULT_EMULATOR = 1;
    public static final int RESULT_MAYBE_EMULATOR = 0;
    public static final int RESULT_UNKNOWN = 2;
    private static java.lang.String[] known_pkgNames = {"sdcard/Android/data/com.bluestacks.home", "sdcard/Android/data/com.bluestacks.settings", "sdcard/Android/data/com.microvirt.guide", "sdcard/Android/data/com.microvirt.launcher2"};

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    private static class SingletonHolder {
        private static final io.dcloud.common.util.emulator.EmulatorCheckUtil INSTANCE = new io.dcloud.common.util.emulator.EmulatorCheckUtil();

        private SingletonHolder() {
        }
    }

    private io.dcloud.common.util.emulator.CheckResult checkFeaturesByBaseBand() {
        java.lang.String property = getProperty("gsm.version.baseband");
        if (property == null) {
            return new io.dcloud.common.util.emulator.CheckResult(0, null);
        }
        return new io.dcloud.common.util.emulator.CheckResult(property.contains("1.0.0.0") ? 1 : 2, property);
    }

    private io.dcloud.common.util.emulator.CheckResult checkFeaturesByBoard() {
        java.lang.String property = getProperty("ro.product.board");
        if (property == null) {
            return new io.dcloud.common.util.emulator.CheckResult(0, null);
        }
        java.lang.String lowerCase = property.toLowerCase(java.util.Locale.ENGLISH);
        return new io.dcloud.common.util.emulator.CheckResult((lowerCase.contains(com.taobao.weex.WXEnvironment.OS) || lowerCase.contains("goldfish")) ? 1 : 2, property);
    }

    private io.dcloud.common.util.emulator.CheckResult checkFeaturesByFlavor() {
        java.lang.String property = getProperty("ro.build.flavor");
        if (property == null) {
            return new io.dcloud.common.util.emulator.CheckResult(0, null);
        }
        java.lang.String lowerCase = property.toLowerCase(java.util.Locale.ENGLISH);
        return new io.dcloud.common.util.emulator.CheckResult((lowerCase.contains("vbox") || lowerCase.contains("sdk_gphone")) ? 1 : 2, property);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:8:0x0026  */
    private io.dcloud.common.util.emulator.CheckResult checkFeaturesByHardware() {
        java.lang.String property = getProperty("ro.hardware");
        if (property == null) {
            return new io.dcloud.common.util.emulator.CheckResult(0, null);
        }
        java.lang.String lowerCase = property.toLowerCase(java.util.Locale.ENGLISH);
        lowerCase.getClass();
        lowerCase.hashCode();
        int i = 2;
        switch (lowerCase) {
            case "cancro":
            case "vbox86":
            case "nox":
            case "ttvm":
            case "vbox":
            case "intel":
            case "android_x86":
                i = 1;
                break;
        }
        return new io.dcloud.common.util.emulator.CheckResult(i, property);
    }

    private io.dcloud.common.util.emulator.CheckResult checkFeaturesByManufacturer() {
        java.lang.String property = getProperty("ro.product.manufacturer");
        if (property == null) {
            return new io.dcloud.common.util.emulator.CheckResult(0, null);
        }
        java.lang.String lowerCase = property.toLowerCase(java.util.Locale.ENGLISH);
        return new io.dcloud.common.util.emulator.CheckResult((lowerCase.contains("genymotion") || lowerCase.contains("netease")) ? 1 : 2, property);
    }

    private io.dcloud.common.util.emulator.CheckResult checkFeaturesByModel() {
        java.lang.String property = getProperty("ro.product.model");
        if (property == null) {
            return new io.dcloud.common.util.emulator.CheckResult(0, null);
        }
        java.lang.String lowerCase = property.toLowerCase(java.util.Locale.ENGLISH);
        return new io.dcloud.common.util.emulator.CheckResult((lowerCase.contains("google_sdk") || lowerCase.contains("emulator") || lowerCase.contains("android sdk built for x86")) ? 1 : 2, property);
    }

    private io.dcloud.common.util.emulator.CheckResult checkFeaturesByPlatform() {
        java.lang.String property = getProperty("ro.board.platform");
        if (property == null) {
            return new io.dcloud.common.util.emulator.CheckResult(0, null);
        }
        return new io.dcloud.common.util.emulator.CheckResult(property.toLowerCase(java.util.Locale.ENGLISH).contains(com.taobao.weex.WXEnvironment.OS) ? 1 : 2, property);
    }

    public static io.dcloud.common.util.emulator.CheckResult checkPkgNameForEmulator() {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 2;
        while (true) {
            java.lang.String[] strArr = known_pkgNames;
            if (i2 >= strArr.length) {
                break;
            }
            if (new java.io.File(strArr[i2]).exists()) {
                i3++;
            } else {
                i4 = 0;
            }
            if (i3 > 2) {
                break;
            }
            i2++;
        }
        if (i3 != 1) {
            i = i3 != 2 ? i4 : 1;
        }
        return new io.dcloud.common.util.emulator.CheckResult(i, "PkgName");
    }

    private java.lang.String getProperty(java.lang.String str) {
        java.lang.String property = io.dcloud.common.util.emulator.CommandUtil.getSingleInstance().getProperty(str);
        if (android.text.TextUtils.isEmpty(property)) {
            return null;
        }
        return property;
    }

    private int getSensorNumber(android.content.Context context) {
        return ((android.hardware.SensorManager) context.getSystemService("sensor")).getSensorList(-1).size();
    }

    public static final io.dcloud.common.util.emulator.EmulatorCheckUtil getSingleInstance() {
        return io.dcloud.common.util.emulator.EmulatorCheckUtil.SingletonHolder.INSTANCE;
    }

    private int getUserAppNum(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return 0;
        }
        return str.split("package:").length;
    }

    private boolean hasLightSensor(android.content.Context context) {
        return ((android.hardware.SensorManager) context.getSystemService("sensor")).getDefaultSensor(5) != null;
    }

    private boolean supportBluetooth(android.content.Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.bluetooth");
    }

    private boolean supportCameraFlash(android.content.Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
    }

    public boolean emulatorCheck(android.content.Context context) {
        int i;
        if (context == null) {
            throw new java.lang.IllegalArgumentException("context must not be null");
        }
        int i2 = checkFeaturesByHardware().result;
        if (i2 == 0) {
            i = 1;
        } else {
            if (i2 == 1) {
                return true;
            }
            i = 0;
        }
        int i3 = checkPkgNameForEmulator().result;
        if (i3 == 0) {
            i++;
        } else if (i3 == 1) {
            return true;
        }
        int i4 = checkFeaturesByFlavor().result;
        if (i4 == 0) {
            i++;
        } else if (i4 == 1) {
            return true;
        }
        int i5 = checkFeaturesByModel().result;
        if (i5 == 0) {
            i++;
        } else if (i5 == 1) {
            return true;
        }
        int i6 = checkFeaturesByManufacturer().result;
        if (i6 == 0) {
            i++;
        } else if (i6 == 1) {
            return true;
        }
        int i7 = checkFeaturesByBoard().result;
        if (i7 == 0) {
            i++;
        } else if (i7 == 1) {
            return true;
        }
        int i8 = checkFeaturesByPlatform().result;
        if (i8 == 0) {
            i++;
        } else if (i8 == 1) {
            return true;
        }
        int i9 = checkFeaturesByBaseBand().result;
        if (i9 == 0) {
            i += 2;
        } else if (i9 == 1) {
            return true;
        }
        if (getSensorNumber(context) <= 7) {
            i++;
        }
        if (!supportCameraFlash(context)) {
            i++;
        }
        if (!supportBluetooth(context)) {
            i++;
        }
        if (!hasLightSensor(context)) {
            i++;
        }
        return i > 3;
    }

    private EmulatorCheckUtil() {
    }
}
