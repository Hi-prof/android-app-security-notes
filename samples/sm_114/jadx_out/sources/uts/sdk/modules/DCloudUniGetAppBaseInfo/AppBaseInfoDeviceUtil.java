package uts.sdk.modules.DCloudUniGetAppBaseInfo;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0016\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Luts/sdk/modules/DCloudUniGetAppBaseInfo/AppBaseInfoDeviceUtil;", "", "<init>", "()V", "Companion", "uni-getAppBaseInfo_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class AppBaseInfoDeviceUtil {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final uts.sdk.modules.DCloudUniGetAppBaseInfo.AppBaseInfoDeviceUtil.Companion INSTANCE = new uts.sdk.modules.DCloudUniGetAppBaseInfo.AppBaseInfoDeviceUtil.Companion(null);

    /* JADX INFO: compiled from: index.kt */
    @kotlin.Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\u0005J\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\u0005J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005H\u0002¨\u0006\u001b"}, d2 = {"Luts/sdk/modules/DCloudUniGetAppBaseInfo/AppBaseInfoDeviceUtil$Companion;", "", "<init>", "()V", "getAppID", "", "getAppName", "context", "Landroid/content/Context;", "getPackageName", "getAppVersionName", "getAppVersionCode", "getHostVersion", "getHostCode", "isSystemNightMode", "", "activity", "Landroid/app/Activity;", "getOsLanguage", "getOsLanguageNormal", "getAppInnerVersion", "getAppSignatureSHA1", "getChannel", "getSignatureString", "sign", "Landroid/content/pm/Signature;", "type", "uni-getAppBaseInfo_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final java.lang.String getAppID() {
            return io.dcloud.uts.UTSAndroid.INSTANCE.getAppId();
        }

        public final java.lang.String getAppName(android.content.Context context) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
            return io.dcloud.uts.NumberKt.toString(context.getPackageManager().getApplicationLabel(context.getApplicationInfo()), (java.lang.Number) 10);
        }

        public final java.lang.String getPackageName(android.content.Context context) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
            java.lang.String packageName = context.getPackageName();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
            return packageName;
        }

        public final java.lang.String getAppVersionName() {
            return io.dcloud.uts.NumberKt.toString_number_nullable$default(io.dcloud.uts.UTSAndroid.INSTANCE.getAppVersion().get("name"), (java.lang.Number) null, 1, (java.lang.Object) null);
        }

        public final java.lang.String getAppVersionCode() {
            return io.dcloud.uts.NumberKt.toString_number_nullable$default(io.dcloud.uts.UTSAndroid.INSTANCE.getAppVersion().get("code"), (java.lang.Number) null, 1, (java.lang.Object) null);
        }

        public final java.lang.String getHostVersion(android.content.Context context) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
            java.lang.String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 1).versionName;
            return str == null ? "" : str;
        }

        public final java.lang.String getHostCode(android.content.Context context) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
            return io.dcloud.uts.NumberKt.plus(java.lang.Integer.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 1).versionCode), "");
        }

        public final boolean isSystemNightMode(android.app.Activity activity) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(activity, "activity");
            java.lang.Object systemService = activity.getSystemService("uimode");
            kotlin.jvm.internal.Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.UiModeManager");
            return ((android.app.UiModeManager) systemService).getNightMode() == 2;
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

        public final java.lang.String getAppSignatureSHA1(android.content.Context context) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
            try {
                android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
                kotlin.jvm.internal.Intrinsics.checkNotNull(packageInfo, "null cannot be cast to non-null type android.content.pm.PackageInfo");
                android.content.pm.Signature[] signatureArr = packageInfo.signatures;
                if (signatureArr != null) {
                    java.lang.String signatureString = "";
                    for (android.content.pm.Signature signature : signatureArr) {
                        uts.sdk.modules.DCloudUniGetAppBaseInfo.AppBaseInfoDeviceUtil.Companion companion = uts.sdk.modules.DCloudUniGetAppBaseInfo.AppBaseInfoDeviceUtil.INSTANCE;
                        kotlin.jvm.internal.Intrinsics.checkNotNull(signature);
                        signatureString = companion.getSignatureString(signature, "SHA1");
                    }
                    return signatureString;
                }
            } catch (java.lang.Exception unused) {
            }
            return "";
        }

        public final java.lang.String getChannel(android.content.Context context) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
            try {
                android.content.pm.ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
                java.lang.String string = applicationInfo.metaData.getString("DCLOUD_CHANNEL");
                return string == null ? "" : string;
            } catch (java.lang.Exception unused) {
                return "";
            }
        }

        private final java.lang.String getSignatureString(android.content.pm.Signature sign, java.lang.String type) {
            byte[] byteArray = sign.toByteArray();
            try {
                java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(type);
                if (messageDigest != null) {
                    byte[] bArrDigest = messageDigest.digest(byteArray);
                    java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
                    kotlin.jvm.internal.Intrinsics.checkNotNull(bArrDigest);
                    for (byte b : bArrDigest) {
                        java.lang.String hexString = java.lang.Integer.toHexString(io.dcloud.uts.NumberKt.or(io.dcloud.uts.NumberKt.and(java.lang.Byte.valueOf(b), (java.lang.Number) 255), (java.lang.Number) 256).intValue());
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(...)");
                        stringBuffer.append(io.dcloud.uts.StringKt.substring(hexString, (java.lang.Number) 1, (java.lang.Number) 3));
                    }
                    java.lang.String string = stringBuffer.toString();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    return string;
                }
                return "error!";
            } catch (java.lang.Exception unused) {
                return "error!";
            }
        }
    }
}
