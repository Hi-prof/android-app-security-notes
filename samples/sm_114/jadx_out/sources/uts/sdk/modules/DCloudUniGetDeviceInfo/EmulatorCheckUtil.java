package uts.sdk.modules.DCloudUniGetDeviceInfo;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\rH\u0002J\b\u0010\u0013\u001a\u00020\rH\u0002J\b\u0010\u0014\u001a\u00020\rH\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\u001b"}, d2 = {"Luts/sdk/modules/DCloudUniGetDeviceInfo/EmulatorCheckUtil;", "", "<init>", "()V", "emulatorCheck", "", "context", "Landroid/content/Context;", "sampleSensor", "getProperty", "", "propName", "checkFeaturesByHardware", "Luts/sdk/modules/DCloudUniGetDeviceInfo/CheckResult;", "checkFeaturesByFlavor", "checkPkgNameForEmulator", "checkFeaturesByModel", "checkFeaturesByManufacturer", "checkFeaturesByBoard", "checkFeaturesByPlatform", "checkFeaturesByBaseBand", "getSensorNumber", "", "supportCameraFlash", "supportBluetooth", "hasLightSensor", "Companion", "uni-getDeviceInfo_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class EmulatorCheckUtil {
    private static uts.sdk.modules.DCloudUniGetDeviceInfo.EmulatorCheckUtil INSTANCE;
    private static final int RESULT_MAYBE_EMULATOR = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final uts.sdk.modules.DCloudUniGetDeviceInfo.EmulatorCheckUtil.Companion INSTANCE = new uts.sdk.modules.DCloudUniGetDeviceInfo.EmulatorCheckUtil.Companion(null);
    private static final int RESULT_EMULATOR = 1;
    private static final int RESULT_UNKNOWN = 2;
    private static io.dcloud.uts.UTSArray<java.lang.String> known_pkgNames = io.dcloud.uts.UTSArrayKt._uA("sdcard/Android/data/com.bluestacks.home", "sdcard/Android/data/com.bluestacks.settings", "sdcard/Android/data/com.microvirt.guide", "sdcard/Android/data/com.microvirt.launcher2");

    public boolean emulatorCheck(android.content.Context context, boolean sampleSensor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        java.lang.Number numberInc = (java.lang.Number) 0;
        int result = checkFeaturesByHardware().getResult();
        int i = RESULT_MAYBE_EMULATOR;
        if (result == i) {
            numberInc = io.dcloud.uts.NumberKt.inc(numberInc);
        } else if (result == RESULT_EMULATOR) {
            return true;
        }
        int result2 = checkPkgNameForEmulator().getResult();
        if (result2 == i) {
            numberInc = io.dcloud.uts.NumberKt.inc(numberInc);
        } else if (result2 == RESULT_EMULATOR) {
            return true;
        }
        int result3 = checkFeaturesByFlavor().getResult();
        if (result3 == i) {
            numberInc = io.dcloud.uts.NumberKt.inc(numberInc);
        } else if (result3 == RESULT_EMULATOR) {
            return true;
        }
        int result4 = checkFeaturesByModel().getResult();
        if (result4 == i) {
            numberInc = io.dcloud.uts.NumberKt.inc(numberInc);
        } else if (result4 == RESULT_EMULATOR) {
            return true;
        }
        int result5 = checkFeaturesByManufacturer().getResult();
        if (result5 == i) {
            numberInc = io.dcloud.uts.NumberKt.inc(numberInc);
        } else if (result5 == RESULT_EMULATOR) {
            return true;
        }
        int result6 = checkFeaturesByBoard().getResult();
        if (result6 == i) {
            numberInc = io.dcloud.uts.NumberKt.inc(numberInc);
        } else if (result6 == RESULT_EMULATOR) {
            return true;
        }
        int result7 = checkFeaturesByPlatform().getResult();
        if (result7 == i) {
            numberInc = io.dcloud.uts.NumberKt.inc(numberInc);
        } else if (result7 == RESULT_EMULATOR) {
            return true;
        }
        int result8 = checkFeaturesByBaseBand().getResult();
        if (result8 == i) {
            numberInc = io.dcloud.uts.NumberKt.plus(numberInc, (java.lang.Number) 2);
        } else if (result8 == RESULT_EMULATOR) {
            return true;
        }
        if (!supportCameraFlash(context)) {
            numberInc = io.dcloud.uts.NumberKt.inc(numberInc);
        }
        if (!supportBluetooth(context)) {
            numberInc = io.dcloud.uts.NumberKt.inc(numberInc);
        }
        if (sampleSensor) {
            if (getSensorNumber(context) <= 7) {
                numberInc = io.dcloud.uts.NumberKt.inc(numberInc);
            }
            if (!hasLightSensor(context)) {
                numberInc = io.dcloud.uts.NumberKt.inc(numberInc);
            }
        }
        return io.dcloud.uts.NumberKt.compareTo(numberInc, (java.lang.Number) 3) > 0;
    }

    private final java.lang.String getProperty(java.lang.String propName) {
        try {
            java.lang.Object objInvoke = java.lang.Class.forName("android.os.SystemProperties").getMethod("get", java.lang.Class.forName("java.lang.String")).invoke(null, propName);
            if (objInvoke != null) {
                return (java.lang.String) objInvoke;
            }
        } catch (java.lang.Exception unused) {
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:30:0x0068  */
    /* JADX WARN: Code duplicated, block: B:31:0x006f  */
    private final uts.sdk.modules.DCloudUniGetDeviceInfo.CheckResult checkFeaturesByHardware() {
        java.lang.Integer numValueOf;
        java.lang.String property = getProperty("ro.hardware");
        if (property == null) {
            return new uts.sdk.modules.DCloudUniGetDeviceInfo.CheckResult(RESULT_MAYBE_EMULATOR, null);
        }
        java.util.Locale ENGLISH = java.util.Locale.ENGLISH;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
        java.lang.String lowerCase = property.toLowerCase(ENGLISH);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        switch (lowerCase) {
            case "cancro":
            case "vbox86":
            case "nox":
            case "ttvm":
            case "vbox":
            case "intel":
            case "android_x86":
                numValueOf = java.lang.Integer.valueOf(RESULT_EMULATOR);
                break;
            default:
                numValueOf = java.lang.Integer.valueOf(RESULT_UNKNOWN);
                break;
        }
        return new uts.sdk.modules.DCloudUniGetDeviceInfo.CheckResult(numValueOf.intValue(), property);
    }

    private final uts.sdk.modules.DCloudUniGetDeviceInfo.CheckResult checkFeaturesByFlavor() {
        java.lang.Integer numValueOf;
        java.lang.String property = getProperty("ro.build.flavor");
        if (property == null) {
            return new uts.sdk.modules.DCloudUniGetDeviceInfo.CheckResult(RESULT_MAYBE_EMULATOR, null);
        }
        java.util.Locale ENGLISH = java.util.Locale.ENGLISH;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
        java.lang.String lowerCase = property.toLowerCase(ENGLISH);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        if (io.dcloud.uts.StringKt.includes$default(lowerCase, "vbox", null, 2, null) || io.dcloud.uts.StringKt.includes$default(lowerCase, "sdk_gphone", null, 2, null)) {
            numValueOf = java.lang.Integer.valueOf(RESULT_EMULATOR);
        } else {
            numValueOf = java.lang.Integer.valueOf(RESULT_UNKNOWN);
        }
        return new uts.sdk.modules.DCloudUniGetDeviceInfo.CheckResult(numValueOf.intValue(), property);
    }

    private final uts.sdk.modules.DCloudUniGetDeviceInfo.CheckResult checkPkgNameForEmulator() {
        int i = RESULT_UNKNOWN;
        java.lang.Number numberInc = 0;
        for (java.lang.Number numberInc2 = numberInc; io.dcloud.uts.NumberKt.compareTo(numberInc2, known_pkgNames.getLength()) < 0; numberInc2 = io.dcloud.uts.NumberKt.inc(numberInc2)) {
            if (new java.io.File(known_pkgNames.get(numberInc2)).exists()) {
                numberInc = io.dcloud.uts.NumberKt.inc(numberInc);
            } else {
                i = RESULT_MAYBE_EMULATOR;
            }
            if (io.dcloud.uts.NumberKt.compareTo(numberInc, (java.lang.Number) 2) > 0) {
                break;
            }
        }
        java.lang.Number number = numberInc;
        if (io.dcloud.uts.NumberKt.numberEquals(number, 1)) {
            i = RESULT_MAYBE_EMULATOR;
        } else if (io.dcloud.uts.NumberKt.numberEquals(number, 2)) {
            i = RESULT_EMULATOR;
        }
        return new uts.sdk.modules.DCloudUniGetDeviceInfo.CheckResult(i, "PkgName");
    }

    private final uts.sdk.modules.DCloudUniGetDeviceInfo.CheckResult checkFeaturesByModel() {
        java.lang.Integer numValueOf;
        java.lang.String property = getProperty("ro.product.model");
        if (property == null) {
            return new uts.sdk.modules.DCloudUniGetDeviceInfo.CheckResult(RESULT_MAYBE_EMULATOR, null);
        }
        java.util.Locale ENGLISH = java.util.Locale.ENGLISH;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
        java.lang.String lowerCase = property.toLowerCase(ENGLISH);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        if (io.dcloud.uts.StringKt.includes$default(lowerCase, "google_sdk", null, 2, null) || io.dcloud.uts.StringKt.includes$default(lowerCase, "emulator", null, 2, null) || io.dcloud.uts.StringKt.includes$default(lowerCase, "android sdk built for x86", null, 2, null)) {
            numValueOf = java.lang.Integer.valueOf(RESULT_EMULATOR);
        } else {
            numValueOf = java.lang.Integer.valueOf(RESULT_UNKNOWN);
        }
        return new uts.sdk.modules.DCloudUniGetDeviceInfo.CheckResult(numValueOf.intValue(), property);
    }

    private final uts.sdk.modules.DCloudUniGetDeviceInfo.CheckResult checkFeaturesByManufacturer() {
        java.lang.Integer numValueOf;
        java.lang.String property = getProperty("ro.product.manufacturer");
        if (property == null) {
            return new uts.sdk.modules.DCloudUniGetDeviceInfo.CheckResult(RESULT_MAYBE_EMULATOR, null);
        }
        java.util.Locale ENGLISH = java.util.Locale.ENGLISH;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
        java.lang.String lowerCase = property.toLowerCase(ENGLISH);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        if (io.dcloud.uts.StringKt.includes$default(lowerCase, "genymotion", null, 2, null) || io.dcloud.uts.StringKt.includes$default(lowerCase, "netease", null, 2, null)) {
            numValueOf = java.lang.Integer.valueOf(RESULT_EMULATOR);
        } else {
            numValueOf = java.lang.Integer.valueOf(RESULT_UNKNOWN);
        }
        return new uts.sdk.modules.DCloudUniGetDeviceInfo.CheckResult(numValueOf.intValue(), property);
    }

    private final uts.sdk.modules.DCloudUniGetDeviceInfo.CheckResult checkFeaturesByBoard() {
        java.lang.Integer numValueOf;
        java.lang.String property = getProperty("ro.product.board");
        if (property == null) {
            return new uts.sdk.modules.DCloudUniGetDeviceInfo.CheckResult(RESULT_MAYBE_EMULATOR, null);
        }
        java.util.Locale ENGLISH = java.util.Locale.ENGLISH;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
        java.lang.String lowerCase = property.toLowerCase(ENGLISH);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        if (io.dcloud.uts.StringKt.includes$default(lowerCase, com.taobao.weex.WXEnvironment.OS, null, 2, null) || io.dcloud.uts.StringKt.includes$default(lowerCase, "goldfish", null, 2, null)) {
            numValueOf = java.lang.Integer.valueOf(RESULT_EMULATOR);
        } else {
            numValueOf = java.lang.Integer.valueOf(RESULT_UNKNOWN);
        }
        return new uts.sdk.modules.DCloudUniGetDeviceInfo.CheckResult(numValueOf.intValue(), property);
    }

    private final uts.sdk.modules.DCloudUniGetDeviceInfo.CheckResult checkFeaturesByPlatform() {
        java.lang.Integer numValueOf;
        java.lang.String property = getProperty("ro.board.platform");
        if (property == null) {
            return new uts.sdk.modules.DCloudUniGetDeviceInfo.CheckResult(RESULT_MAYBE_EMULATOR, null);
        }
        java.util.Locale ENGLISH = java.util.Locale.ENGLISH;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
        java.lang.String lowerCase = property.toLowerCase(ENGLISH);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        if (io.dcloud.uts.StringKt.includes$default(lowerCase, com.taobao.weex.WXEnvironment.OS, null, 2, null)) {
            numValueOf = java.lang.Integer.valueOf(RESULT_EMULATOR);
        } else {
            numValueOf = java.lang.Integer.valueOf(RESULT_UNKNOWN);
        }
        return new uts.sdk.modules.DCloudUniGetDeviceInfo.CheckResult(numValueOf.intValue(), property);
    }

    private final uts.sdk.modules.DCloudUniGetDeviceInfo.CheckResult checkFeaturesByBaseBand() {
        java.lang.Integer numValueOf;
        java.lang.String property = getProperty("gsm.version.baseband");
        if (property == null) {
            return new uts.sdk.modules.DCloudUniGetDeviceInfo.CheckResult(RESULT_MAYBE_EMULATOR, null);
        }
        if (io.dcloud.uts.StringKt.includes$default(property, "1.0.0.0", null, 2, null)) {
            numValueOf = java.lang.Integer.valueOf(RESULT_EMULATOR);
        } else {
            numValueOf = java.lang.Integer.valueOf(RESULT_UNKNOWN);
        }
        return new uts.sdk.modules.DCloudUniGetDeviceInfo.CheckResult(numValueOf.intValue(), property);
    }

    private final int getSensorNumber(android.content.Context context) {
        java.lang.Object systemService = context.getSystemService("sensor");
        kotlin.jvm.internal.Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
        return ((android.hardware.SensorManager) systemService).getSensorList(-1).size();
    }

    private final boolean supportCameraFlash(android.content.Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
    }

    private final boolean supportBluetooth(android.content.Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.bluetooth");
    }

    private final boolean hasLightSensor(android.content.Context context) {
        java.lang.Object systemService = context.getSystemService("sensor");
        kotlin.jvm.internal.Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
        return ((android.hardware.SensorManager) systemService).getDefaultSensor(5) != null;
    }

    /* JADX INFO: compiled from: index.kt */
    @kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0011\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Luts/sdk/modules/DCloudUniGetDeviceInfo/EmulatorCheckUtil$Companion;", "", "<init>", "()V", "INSTANCE", "Luts/sdk/modules/DCloudUniGetDeviceInfo/EmulatorCheckUtil;", "RESULT_MAYBE_EMULATOR", "", "getRESULT_MAYBE_EMULATOR", "()I", "RESULT_EMULATOR", "getRESULT_EMULATOR", "RESULT_UNKNOWN", "getRESULT_UNKNOWN", "known_pkgNames", "Lio/dcloud/uts/UTSArray;", "", "getSingleInstance", "uni-getDeviceInfo_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getRESULT_MAYBE_EMULATOR() {
            return uts.sdk.modules.DCloudUniGetDeviceInfo.EmulatorCheckUtil.RESULT_MAYBE_EMULATOR;
        }

        public final int getRESULT_EMULATOR() {
            return uts.sdk.modules.DCloudUniGetDeviceInfo.EmulatorCheckUtil.RESULT_EMULATOR;
        }

        public final int getRESULT_UNKNOWN() {
            return uts.sdk.modules.DCloudUniGetDeviceInfo.EmulatorCheckUtil.RESULT_UNKNOWN;
        }

        public final uts.sdk.modules.DCloudUniGetDeviceInfo.EmulatorCheckUtil getSingleInstance() {
            if (uts.sdk.modules.DCloudUniGetDeviceInfo.EmulatorCheckUtil.INSTANCE == null) {
                uts.sdk.modules.DCloudUniGetDeviceInfo.EmulatorCheckUtil.Companion companion = uts.sdk.modules.DCloudUniGetDeviceInfo.EmulatorCheckUtil.INSTANCE;
                uts.sdk.modules.DCloudUniGetDeviceInfo.EmulatorCheckUtil.INSTANCE = new uts.sdk.modules.DCloudUniGetDeviceInfo.EmulatorCheckUtil();
            }
            uts.sdk.modules.DCloudUniGetDeviceInfo.EmulatorCheckUtil emulatorCheckUtil = uts.sdk.modules.DCloudUniGetDeviceInfo.EmulatorCheckUtil.INSTANCE;
            kotlin.jvm.internal.Intrinsics.checkNotNull(emulatorCheckUtil);
            return emulatorCheckUtil;
        }
    }
}
