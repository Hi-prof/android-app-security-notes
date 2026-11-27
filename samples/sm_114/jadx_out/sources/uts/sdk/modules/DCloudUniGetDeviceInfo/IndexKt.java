package uts.sdk.modules.DCloudUniGetDeviceInfo;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u000b\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u001a\u0006\u0010\u000f\u001a\u00020\u0010\u001a\u0010\u0010\u0011\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0012\u001a\u0006\u0010\u0013\u001a\u00020\u0010\"2\u0010\u0007\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n*D\u0010\u0000\"\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u00012\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001¨\u0006\u0014"}, d2 = {"GetDeviceInfo", "Lkotlin/Function1;", "Luts/sdk/modules/DCloudUniGetDeviceInfo/GetDeviceInfoOptions;", "Lkotlin/ParameterName;", "name", "options", "Luts/sdk/modules/DCloudUniGetDeviceInfo/GetDeviceInfoResult;", "getDeviceInfo", "Luts/sdk/modules/DCloudUniGetDeviceInfo/GetDeviceInfo;", "getGetDeviceInfo", "()Lkotlin/jvm/functions/Function1;", "getBaseInfo", "filterArray", "Lio/dcloud/uts/UTSArray;", "", "isSimulator", "", "getDeviceInfoByJs", "Luts/sdk/modules/DCloudUniGetDeviceInfo/GetDeviceInfoOptionsJSONObject;", "isSimulatorByJs", "uni-getDeviceInfo_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IndexKt {
    private static final kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniGetDeviceInfo.GetDeviceInfoOptions, uts.sdk.modules.DCloudUniGetDeviceInfo.GetDeviceInfoResult> getDeviceInfo = new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniGetDeviceInfo.IndexKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final java.lang.Object invoke(java.lang.Object obj) {
            return uts.sdk.modules.DCloudUniGetDeviceInfo.IndexKt.getDeviceInfo$lambda$0((uts.sdk.modules.DCloudUniGetDeviceInfo.GetDeviceInfoOptions) obj);
        }
    };

    public static final kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniGetDeviceInfo.GetDeviceInfoOptions, uts.sdk.modules.DCloudUniGetDeviceInfo.GetDeviceInfoResult> getGetDeviceInfo() {
        return getDeviceInfo;
    }

    public static final uts.sdk.modules.DCloudUniGetDeviceInfo.GetDeviceInfoResult getBaseInfo(io.dcloud.uts.UTSArray<java.lang.String> filterArray) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(filterArray, "filterArray");
        android.app.Activity uniActivity = io.dcloud.uts.UTSAndroid.INSTANCE.getUniActivity();
        kotlin.jvm.internal.Intrinsics.checkNotNull(uniActivity);
        uts.sdk.modules.DCloudUniGetDeviceInfo.GetDeviceInfoResult getDeviceInfoResult = new uts.sdk.modules.DCloudUniGetDeviceInfo.GetDeviceInfoResult(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null);
        if (filterArray.indexOf("brand") != -1) {
            getDeviceInfoResult.setBrand(android.os.Build.MANUFACTURER);
        }
        if (filterArray.indexOf("deviceBrand") != -1) {
            getDeviceInfoResult.setDeviceBrand(android.os.Build.MANUFACTURER);
        }
        if (filterArray.indexOf("model") != -1) {
            getDeviceInfoResult.setModel(android.os.Build.MODEL);
        }
        if (filterArray.indexOf("deviceModel") != -1) {
            getDeviceInfoResult.setDeviceModel(android.os.Build.MODEL);
        }
        if (filterArray.indexOf("deviceType") != -1) {
            getDeviceInfoResult.setDeviceType(uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE.getSystemUIModeType(uniActivity));
        }
        if (filterArray.indexOf("deviceOrientation") != -1) {
            getDeviceInfoResult.setDeviceOrientation(uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE.getOrientation(uniActivity));
        }
        if (filterArray.indexOf("deviceId") != -1) {
            getDeviceInfoResult.setDeviceId(uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE.getDeviceID(uniActivity));
        }
        if (filterArray.indexOf("devicePixelRatio") != -1) {
            getDeviceInfoResult.setDevicePixelRatio(uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE.getScaledDensity(uniActivity));
        }
        if (filterArray.indexOf("system") != -1) {
            getDeviceInfoResult.setSystem("Android " + android.os.Build.VERSION.RELEASE);
        }
        if (filterArray.indexOf(com.taobao.weex.common.RenderTypes.RENDER_TYPE_NATIVE) != -1) {
            getDeviceInfoResult.setPlatform(com.taobao.weex.WXEnvironment.OS);
        }
        if (filterArray.indexOf("isRoot") != -1) {
            getDeviceInfoResult.setRoot(java.lang.Boolean.valueOf(uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE.hasRootPrivilege()));
        }
        if (filterArray.indexOf("isSimulator") != -1) {
            getDeviceInfoResult.setSimulator(java.lang.Boolean.valueOf(uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE.isSimulator(uniActivity, false)));
        }
        if (filterArray.indexOf("isUSBDebugging") != -1) {
            getDeviceInfoResult.setUSBDebugging(java.lang.Boolean.valueOf(uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE.listeningForADB()));
        }
        if (filterArray.indexOf(com.taobao.weex.common.WXConfig.osName) != -1) {
            getDeviceInfoResult.setOsName(com.taobao.weex.WXEnvironment.OS);
        }
        if (filterArray.indexOf("osVersion") != -1) {
            getDeviceInfoResult.setOsVersion(android.os.Build.VERSION.RELEASE);
        }
        if (filterArray.indexOf("osLanguage") != -1) {
            getDeviceInfoResult.setOsLanguage(io.dcloud.uts.NumberKt.toString_number_nullable$default(io.dcloud.uts.UTSAndroid.INSTANCE.getLanguageInfo(uniActivity).get("osLanguage"), (java.lang.Number) null, 1, (java.lang.Object) null));
        }
        if (filterArray.indexOf("osTheme") != -1) {
            getDeviceInfoResult.setOsTheme(io.dcloud.uts.UTSAndroid.INSTANCE.getOsTheme());
        }
        if (filterArray.indexOf("osAndroidAPILevel") != -1) {
            getDeviceInfoResult.setOsAndroidAPILevel(java.lang.Integer.valueOf(android.os.Build.VERSION.SDK_INT));
        }
        if (filterArray.indexOf("romName") != -1) {
            getDeviceInfoResult.setRomName(uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE.getRomName());
        }
        if (filterArray.indexOf("romVersion") != -1) {
            getDeviceInfoResult.setRomVersion(uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE.getRomVersion());
        }
        return getDeviceInfoResult;
    }

    public static final boolean isSimulator() {
        android.app.Activity uniActivity = io.dcloud.uts.UTSAndroid.INSTANCE.getUniActivity();
        kotlin.jvm.internal.Intrinsics.checkNotNull(uniActivity);
        return uts.sdk.modules.DCloudUniGetDeviceInfo.DeviceUtil.INSTANCE.isSimulator(uniActivity, false);
    }

    public static final uts.sdk.modules.DCloudUniGetDeviceInfo.GetDeviceInfoResult getDeviceInfoByJs(uts.sdk.modules.DCloudUniGetDeviceInfo.GetDeviceInfoOptionsJSONObject getDeviceInfoOptionsJSONObject) {
        return getDeviceInfo.invoke(getDeviceInfoOptionsJSONObject != null ? new uts.sdk.modules.DCloudUniGetDeviceInfo.GetDeviceInfoOptions(getDeviceInfoOptionsJSONObject.getFilter()) : null);
    }

    public static final boolean isSimulatorByJs() {
        return isSimulator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final uts.sdk.modules.DCloudUniGetDeviceInfo.GetDeviceInfoResult getDeviceInfo$lambda$0(uts.sdk.modules.DCloudUniGetDeviceInfo.GetDeviceInfoOptions getDeviceInfoOptions) {
        io.dcloud.uts.UTSArray<java.lang.String> uTSArray = new io.dcloud.uts.UTSArray<>();
        if (getDeviceInfoOptions != null && getDeviceInfoOptions.getFilter() != null) {
            uTSArray = getDeviceInfoOptions.getFilter();
        }
        if (getDeviceInfoOptions == null || io.dcloud.uts.NumberKt.numberEquals(uTSArray.getLength(), 0)) {
            uTSArray = io.dcloud.uts.UTSArrayKt._uA("brand", "deviceBrand", "deviceId", "model", "deviceModel", "deviceType", "deviceOrientation", "devicePixelRatio", "system", com.taobao.weex.common.RenderTypes.RENDER_TYPE_NATIVE, "isRoot", "isSimulator", "isUSBDebugging", com.taobao.weex.common.WXConfig.osName, "osVersion", "osLanguage", "osTheme", "osAndroidAPILevel", "romName", "romVersion");
        }
        return getBaseInfo(uTSArray);
    }
}
