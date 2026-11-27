package uts.sdk.modules.DCloudUniGetDeviceInfo;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0016\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Luts/sdk/modules/DCloudUniGetDeviceInfo/DeviceUtil;", "", "<init>", "()V", "Companion", "uni-getDeviceInfo_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class DeviceUtil {
    private static java.lang.String customOS;
    private static java.lang.String customOSVersion;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion INSTANCE = new uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion(null);
    private static final io.dcloud.uts.UTSArray<java.lang.String> rootRelatedDirs = io.dcloud.uts.UTSArrayKt._uA("/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb");
    private static java.lang.String KEY_HARMONYOS_VERSION_NAME = "hw_sc.build.platform.version";
    private static java.lang.String KEY_EMUI_VERSION_NAME = "ro.build.version.emui";
    private static java.lang.String KEY_MAGICUI_VERSION = "ro.build.version.magic";
    private static java.lang.String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    private static java.lang.String KEY_COLOROS_VERSION_NAME = "ro.build.version.opporom";
    private static java.lang.String KEY_VIVO_VERSION_NAME = "ro.vivo.os.name";
    private static java.lang.String KEY_VIVO_VERSION = "ro.vivo.os.version";
    private static java.lang.String KEY_ONEPLUS_VERSION_NAME = "ro.rom.version";
    private static java.lang.String KEY_FLYME_VERSION_NAME = "ro.build.display.id";
    private static java.lang.String KEY_NUBIA_VERSION_NAME = "ro.build.nubia.rom.name";
    private static java.lang.String KEY_NUBIA_VERSION_CODE = "ro.build.nubia.rom.code";

    /* JADX INFO: compiled from: index.kt */
    @kotlin.Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001bJ\u000e\u0010 \u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010!\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\"\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010#\u001a\u00020\u0005J\u0006\u0010$\u001a\u00020\u0005J\u0006\u0010%\u001a\u00020\u0005J\u0006\u0010&\u001a\u00020\u0005J\u000e\u0010'\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0005H\u0002J\b\u0010+\u001a\u00020\u001bH\u0002J\u0010\u0010,\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010\u0005J\u0012\u0010.\u001a\u0004\u0018\u00010\u00052\u0006\u0010/\u001a\u00020\u0005H\u0002J\u0006\u00100\u001a\u00020\u001bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Luts/sdk/modules/DCloudUniGetDeviceInfo/DeviceUtil$Companion;", "", "<init>", "()V", "customOS", "", "customOSVersion", "rootRelatedDirs", "Lio/dcloud/uts/UTSArray;", "KEY_HARMONYOS_VERSION_NAME", "KEY_EMUI_VERSION_NAME", "KEY_MAGICUI_VERSION", "KEY_MIUI_VERSION_NAME", "KEY_COLOROS_VERSION_NAME", "KEY_VIVO_VERSION_NAME", "KEY_VIVO_VERSION", "KEY_ONEPLUS_VERSION_NAME", "KEY_FLYME_VERSION_NAME", "KEY_NUBIA_VERSION_NAME", "KEY_NUBIA_VERSION_CODE", "getOrientation", "activity", "Landroid/app/Activity;", "getScaledDensity", "", "getSystemUIModeType", "hasRootPrivilege", "", "isSimulator", "context", "Landroid/content/Context;", "sampleSensor", "getDeviceID", "getOsLanguage", "getOsLanguageNormal", "getAppInnerVersion", "getOaid", "getRomName", "getRomVersion", "isTablet", "setCustomInfo", "", "phoneBrand", "isHarmonyOS", "deleteSpaceAndToUpperCase", "str", "getSystemPropertyValue", "propName", "listeningForADB", "uni-getDeviceInfo_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final java.lang.String getOrientation(android.app.Activity activity) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(activity, "activity");
            if (activity.getResources().getConfiguration().orientation == 2) {
                return "landscape";
            }
            return "portrait";
        }

        public final java.lang.Number getScaledDensity(android.app.Activity activity) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(activity, "activity");
            java.lang.Object systemService = activity.getSystemService("window");
            kotlin.jvm.internal.Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
            ((android.view.WindowManager) systemService).getDefaultDisplay().getRealMetrics(displayMetrics);
            return java.lang.Float.valueOf(displayMetrics.scaledDensity);
        }

        public final java.lang.String getSystemUIModeType(android.app.Activity activity) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(activity, "activity");
            java.lang.Object systemService = activity.getSystemService("uimode");
            kotlin.jvm.internal.Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.UiModeManager");
            switch (((android.app.UiModeManager) systemService).getCurrentModeType()) {
                case 0:
                    return com.taobao.weex.common.Constants.Name.UNDEFINED;
                case 1:
                    if (uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE.isTablet(activity)) {
                        return "pad";
                    }
                    return "phone";
                case 2:
                    return "pc";
                case 3:
                    return "car";
                case 4:
                    return "tv";
                case 5:
                    return "appliance";
                case 6:
                    return "watch";
                case 7:
                    return "vr";
                default:
                    return "unknown";
            }
        }

        /* JADX WARN: Code duplicated, block: B:14:0x0044 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:16:0x0047 A[RETURN] */
        public final boolean hasRootPrivilege() {
            boolean z;
            io.dcloud.uts.UTSArray uTSArray = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.rootRelatedDirs;
            java.lang.Number length = uTSArray.getLength();
            java.lang.Number numberInc = (java.lang.Number) 0;
            while (true) {
                if (io.dcloud.uts.NumberKt.compareTo(numberInc, length) >= 0) {
                    z = false;
                    break;
                }
                if (new java.io.File((java.lang.String) uTSArray.get(numberInc)).exists()) {
                    z = true;
                    break;
                }
                numberInc = io.dcloud.uts.NumberKt.inc(numberInc);
            }
            if (android.os.Build.TAGS != null) {
                java.lang.String TAGS = android.os.Build.TAGS;
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(TAGS, "TAGS");
                if (!io.dcloud.uts.StringKt.includes$default(TAGS, "test-keys", null, 2, null)) {
                    if (z) {
                        return false;
                    }
                }
            } else if (z) {
                return false;
            }
            return true;
        }

        public final boolean isSimulator(android.content.Context context, boolean sampleSensor) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
            return uts.sdk.modules.DCloudUniGetDeviceInfo.EmulatorCheckUtil.INSTANCE.getSingleInstance().emulatorCheck(context, sampleSensor);
        }

        public final java.lang.String getDeviceID(android.content.Context context) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
            return io.dcloud.uts.UTSAndroid.INSTANCE.getDeviceID(context);
        }

        public final java.lang.String getOsLanguage(android.content.Context context) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
            return io.dcloud.uts.NumberKt.toString_number_nullable$default(io.dcloud.uts.UTSAndroid.INSTANCE.getLanguageInfo(context).get("osLanguage"), (java.lang.Number) null, 1, (java.lang.Object) null);
        }

        public final java.lang.String getOsLanguageNormal(android.content.Context context) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
            java.lang.String string_number_nullable$default = io.dcloud.uts.NumberKt.toString_number_nullable$default(io.dcloud.uts.UTSAndroid.INSTANCE.getLanguageInfo(context).get("appLanguage"), (java.lang.Number) null, 1, (java.lang.Object) null);
            if (!io.dcloud.uts.NumberKt.numberEquals(io.dcloud.uts.StringKt.indexOf$default(string_number_nullable$default, "zh", null, 2, null), 0)) {
                return string_number_nullable$default;
            }
            if (io.dcloud.uts.NumberKt.compareTo(io.dcloud.uts.StringKt.indexOf$default(string_number_nullable$default, "-hans", null, 2, null), (java.lang.Number) (-1)) > 0) {
                return "zh-Hans";
            }
            if (io.dcloud.uts.NumberKt.compareTo(io.dcloud.uts.StringKt.indexOf$default(string_number_nullable$default, "-hant", null, 2, null), (java.lang.Number) (-1)) <= 0 && !io.dcloud.uts.StringKt.includes$default(string_number_nullable$default, "-tw", null, 2, null) && !io.dcloud.uts.StringKt.includes$default(string_number_nullable$default, "-hk", null, 2, null) && !io.dcloud.uts.StringKt.includes$default(string_number_nullable$default, "-mo", null, 2, null) && !io.dcloud.uts.StringKt.includes$default(string_number_nullable$default, "-cht", null, 2, null)) {
                return "zh-Hans";
            }
            return "zh-Hant";
        }

        public final java.lang.String getAppInnerVersion() {
            return io.dcloud.uts.UTSAndroid.INSTANCE.getInnerVersion();
        }

        public final java.lang.String getOaid() {
            return io.dcloud.uts.UTSAndroid.INSTANCE.getOAID();
        }

        public final java.lang.String getRomName() {
            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
            java.lang.String MANUFACTURER = android.os.Build.MANUFACTURER;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
            companion.setCustomInfo(MANUFACTURER);
            java.lang.String str = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOS;
            return str == null ? "" : str;
        }

        public final java.lang.String getRomVersion() {
            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
            java.lang.String MANUFACTURER = android.os.Build.MANUFACTURER;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
            companion.setCustomInfo(MANUFACTURER);
            java.lang.String str = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOSVersion;
            return str == null ? "" : str;
        }

        public final boolean isTablet(android.app.Activity activity) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(activity, "activity");
            return (activity.getResources().getConfiguration().screenLayout & 15) >= 3;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        private final void setCustomInfo(java.lang.String phoneBrand) {
            try {
                java.lang.String strDeleteSpaceAndToUpperCase = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE.deleteSpaceAndToUpperCase(phoneBrand);
                switch (strDeleteSpaceAndToUpperCase.hashCode()) {
                    case -1881642058:
                        if (!strDeleteSpaceAndToUpperCase.equals("REALME")) {
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOS = com.taobao.weex.utils.tools.TimeCalculator.PLATFORM_ANDROID;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion2 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOSVersion = android.os.Build.VERSION.RELEASE;
                        }
                        uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion3 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                        uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOS = "ColorOS";
                        uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion4 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                        uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOSVersion = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE.getSystemPropertyValue(uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.KEY_COLOROS_VERSION_NAME);
                        break;
                    case -1706170181:
                        if (!strDeleteSpaceAndToUpperCase.equals("XIAOMI")) {
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion5 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOS = com.taobao.weex.utils.tools.TimeCalculator.PLATFORM_ANDROID;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion6 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOSVersion = android.os.Build.VERSION.RELEASE;
                        }
                        uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion7 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                        uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOS = "MIUI";
                        uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion8 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                        uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOSVersion = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE.getSystemPropertyValue(uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.KEY_MIUI_VERSION_NAME);
                        break;
                    case -602397472:
                        if (!strDeleteSpaceAndToUpperCase.equals("ONEPLUS")) {
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion9 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOS = com.taobao.weex.utils.tools.TimeCalculator.PLATFORM_ANDROID;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion10 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOSVersion = android.os.Build.VERSION.RELEASE;
                        } else {
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion11 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOS = "HydrogenOS";
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion12 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOSVersion = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE.getSystemPropertyValue(uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.KEY_ONEPLUS_VERSION_NAME);
                        }
                        break;
                    case 2432928:
                        if (!strDeleteSpaceAndToUpperCase.equals("OPPO")) {
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion13 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOS = com.taobao.weex.utils.tools.TimeCalculator.PLATFORM_ANDROID;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion14 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOSVersion = android.os.Build.VERSION.RELEASE;
                        }
                        uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion15 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                        uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOS = "ColorOS";
                        uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion16 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                        uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOSVersion = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE.getSystemPropertyValue(uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.KEY_COLOROS_VERSION_NAME);
                        break;
                    case 2634924:
                        if (!strDeleteSpaceAndToUpperCase.equals("VIVO")) {
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion17 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOS = com.taobao.weex.utils.tools.TimeCalculator.PLATFORM_ANDROID;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion18 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOSVersion = android.os.Build.VERSION.RELEASE;
                        } else {
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion19 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOS = "Funtouch";
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion20 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOSVersion = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE.getSystemPropertyValue(uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.KEY_VIVO_VERSION);
                        }
                        break;
                    case 68924490:
                        if (!strDeleteSpaceAndToUpperCase.equals("HONOR")) {
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion110 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOS = com.taobao.weex.utils.tools.TimeCalculator.PLATFORM_ANDROID;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion111 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOSVersion = android.os.Build.VERSION.RELEASE;
                        } else if (uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE.isHarmonyOS()) {
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion21 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOS = "HarmonyOS";
                            if (!android.text.TextUtils.isEmpty(uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE.getSystemPropertyValue(uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.KEY_HARMONYOS_VERSION_NAME))) {
                                uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion22 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                                uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOSVersion = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE.getSystemPropertyValue(uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.KEY_HARMONYOS_VERSION_NAME);
                            } else {
                                uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion23 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                                uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOSVersion = "";
                            }
                        } else if (!android.text.TextUtils.isEmpty(uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE.getSystemPropertyValue(uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.KEY_MAGICUI_VERSION))) {
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion24 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOS = "MagicUI";
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion25 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOSVersion = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE.getSystemPropertyValue(uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.KEY_MAGICUI_VERSION);
                        } else {
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion26 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOS = "EMUI";
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion27 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOSVersion = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE.getSystemPropertyValue(uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.KEY_EMUI_VERSION_NAME);
                        }
                        break;
                    case 73239724:
                        if (!strDeleteSpaceAndToUpperCase.equals("MEIZU")) {
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion112 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOS = com.taobao.weex.utils.tools.TimeCalculator.PLATFORM_ANDROID;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion113 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOSVersion = android.os.Build.VERSION.RELEASE;
                        } else {
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion28 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOS = "Flyme";
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion29 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOSVersion = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE.getSystemPropertyValue(uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.KEY_FLYME_VERSION_NAME);
                        }
                        break;
                    case 74632627:
                        if (!strDeleteSpaceAndToUpperCase.equals("NUBIA")) {
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion114 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOS = com.taobao.weex.utils.tools.TimeCalculator.PLATFORM_ANDROID;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion115 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOSVersion = android.os.Build.VERSION.RELEASE;
                        } else {
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion30 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOS = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE.getSystemPropertyValue(uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.KEY_NUBIA_VERSION_NAME);
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion31 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOSVersion = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE.getSystemPropertyValue(uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.KEY_NUBIA_VERSION_CODE);
                        }
                        break;
                    case 77852109:
                        if (!strDeleteSpaceAndToUpperCase.equals("REDMI")) {
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion116 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOS = com.taobao.weex.utils.tools.TimeCalculator.PLATFORM_ANDROID;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion117 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOSVersion = android.os.Build.VERSION.RELEASE;
                        }
                        uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion32 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                        uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOS = "MIUI";
                        uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion33 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                        uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOSVersion = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE.getSystemPropertyValue(uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.KEY_MIUI_VERSION_NAME);
                        break;
                    case 2141820391:
                        if (!strDeleteSpaceAndToUpperCase.equals("HUAWEI")) {
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion118 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOS = com.taobao.weex.utils.tools.TimeCalculator.PLATFORM_ANDROID;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion119 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOSVersion = android.os.Build.VERSION.RELEASE;
                        } else if (!uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE.isHarmonyOS()) {
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion34 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOS = "EMUI";
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion35 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOSVersion = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE.getSystemPropertyValue(uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.KEY_EMUI_VERSION_NAME);
                        } else {
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion36 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOSVersion = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE.getSystemPropertyValue(uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.KEY_HARMONYOS_VERSION_NAME);
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion37 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                            uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOS = "HarmonyOS";
                        }
                        break;
                    default:
                        uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion1110 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                        uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOS = com.taobao.weex.utils.tools.TimeCalculator.PLATFORM_ANDROID;
                        uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.Companion companion1111 = uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE;
                        uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.customOSVersion = android.os.Build.VERSION.RELEASE;
                        break;
                }
            } catch (java.lang.Exception unused) {
            }
        }

        private final boolean isHarmonyOS() {
            try {
                java.lang.Class<?> cls = java.lang.Class.forName("com.huawei.system.BuildEx");
                java.lang.Object objInvoke = cls.getMethod("getOsBrand", null).invoke(cls, null);
                kotlin.jvm.internal.Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.String");
                return !android.text.TextUtils.isEmpty((java.lang.String) objInvoke);
            } catch (java.lang.Exception unused) {
                return false;
            }
        }

        public final java.lang.String deleteSpaceAndToUpperCase(java.lang.String str) {
            if (android.text.TextUtils.isEmpty(str)) {
                return "";
            }
            kotlin.jvm.internal.Intrinsics.checkNotNull(str);
            return io.dcloud.uts.StringKt.toUpperCase(io.dcloud.uts.StringKt.replace(str, com.taobao.weex.el.parse.Operators.SPACE_STR, ""));
        }

        private final java.lang.String getSystemPropertyValue(java.lang.String propName) {
            try {
                java.lang.Object objInvoke = java.lang.Class.forName("android.os.SystemProperties").getMethod("get", java.lang.Class.forName("java.lang.String")).invoke(null, propName);
                if (objInvoke != null) {
                    return (java.lang.String) objInvoke;
                }
            } catch (java.lang.Exception unused) {
            }
            return null;
        }

        public final boolean listeningForADB() throws java.io.IOException {
            java.lang.Process processExec;
            java.io.BufferedReader bufferedReader;
            char[] cArr;
            boolean zIncludes$default;
            java.lang.String[] strArr = {"/bin/sh", "-c", "getprop | grep init.svc.adbd"};
            try {
                java.lang.Runtime.getRuntime().exec(strArr);
                while (true) {
                    int i = bufferedReader.read(cArr);
                    if (i != -1) {
                        zIncludes$default = io.dcloud.uts.StringKt.includes$default(new java.lang.String(cArr, 0, i), "running", null, 2, null);
                    } else {
                        processExec.getInputStream().close();
                        bufferedReader.close();
                        return zIncludes$default;
                    }
                }
            } catch (java.lang.Exception unused) {
                strArr = new java.lang.String[]{"/system/bin/sh", "-c", "getprop | grep init.svc.adbd"};
                try {
                    java.lang.Runtime.getRuntime().exec(strArr);
                } catch (java.lang.Exception unused2) {
                    return false;
                }
            }
            processExec = java.lang.Runtime.getRuntime().exec(strArr);
            bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(processExec.getInputStream(), "utf-8"));
            cArr = new char[1024];
            zIncludes$default = false;
        }
    }
}
