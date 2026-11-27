package uts.sdk.modules.DCloudUniGetAppBaseInfo;

/* JADX INFO: compiled from: index.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u000b\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u001a\u0010\u0010\u0012\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0013\"2\u0010\u0007\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\"\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00100\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\n*D\u0010\u0000\"\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u00012\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001¨\u0006\u0014"}, d2 = {"GetAppBaseInfo", "Lkotlin/Function1;", "Luts/sdk/modules/DCloudUniGetAppBaseInfo/GetAppBaseInfoOptions;", "Lkotlin/ParameterName;", "name", "options", "Luts/sdk/modules/DCloudUniGetAppBaseInfo/GetAppBaseInfoResult;", "getAppBaseInfo", "Luts/sdk/modules/DCloudUniGetAppBaseInfo/GetAppBaseInfo;", "getGetAppBaseInfo", "()Lkotlin/jvm/functions/Function1;", "getBaseInfo", "filterArray", "Lio/dcloud/uts/UTSArray;", "", "convertVersionCode", "", "getConvertVersionCode", "getAppBaseInfoByJs", "Luts/sdk/modules/DCloudUniGetAppBaseInfo/GetAppBaseInfoOptionsJSONObject;", "uni-getAppBaseInfo_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IndexKt {
    private static final kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniGetAppBaseInfo.GetAppBaseInfoOptions, uts.sdk.modules.DCloudUniGetAppBaseInfo.GetAppBaseInfoResult> getAppBaseInfo = new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniGetAppBaseInfo.IndexKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final java.lang.Object invoke(java.lang.Object obj) {
            return uts.sdk.modules.DCloudUniGetAppBaseInfo.IndexKt.getAppBaseInfo$lambda$0((uts.sdk.modules.DCloudUniGetAppBaseInfo.GetAppBaseInfoOptions) obj);
        }
    };
    private static final kotlin.jvm.functions.Function1<java.lang.String, java.lang.Number> convertVersionCode = new kotlin.jvm.functions.Function1() { // from class: uts.sdk.modules.DCloudUniGetAppBaseInfo.IndexKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function1
        public final java.lang.Object invoke(java.lang.Object obj) {
            return uts.sdk.modules.DCloudUniGetAppBaseInfo.IndexKt.convertVersionCode$lambda$2((java.lang.String) obj);
        }
    };

    public static final kotlin.jvm.functions.Function1<uts.sdk.modules.DCloudUniGetAppBaseInfo.GetAppBaseInfoOptions, uts.sdk.modules.DCloudUniGetAppBaseInfo.GetAppBaseInfoResult> getGetAppBaseInfo() {
        return getAppBaseInfo;
    }

    public static final uts.sdk.modules.DCloudUniGetAppBaseInfo.GetAppBaseInfoResult getBaseInfo(io.dcloud.uts.UTSArray<java.lang.String> filterArray) {
        java.lang.String str;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(filterArray, "filterArray");
        android.app.Activity uniActivity = io.dcloud.uts.UTSAndroid.INSTANCE.getUniActivity();
        kotlin.jvm.internal.Intrinsics.checkNotNull(uniActivity);
        uts.sdk.modules.DCloudUniGetAppBaseInfo.GetAppBaseInfoResult getAppBaseInfoResult = new uts.sdk.modules.DCloudUniGetAppBaseInfo.GetAppBaseInfoResult(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 268435455, null);
        if (filterArray.indexOf("appId") != -1) {
            getAppBaseInfoResult.setAppId(uts.sdk.modules.DCloudUniGetAppBaseInfo.AppBaseInfoDeviceUtil.INSTANCE.getAppID());
        }
        if (filterArray.indexOf(com.taobao.weex.common.WXConfig.appName) != -1) {
            getAppBaseInfoResult.setAppName(io.dcloud.uts.UTSAndroid.INSTANCE.getAppName());
        }
        if (io.dcloud.uts.UTSAndroid.INSTANCE.isUniMp()) {
            if (filterArray.indexOf("hostPackageName") != -1) {
                getAppBaseInfoResult.setHostPackageName(uts.sdk.modules.DCloudUniGetAppBaseInfo.AppBaseInfoDeviceUtil.INSTANCE.getPackageName(uniActivity));
            }
            if (filterArray.indexOf("hostVersion") != -1) {
                getAppBaseInfoResult.setHostVersion(uts.sdk.modules.DCloudUniGetAppBaseInfo.AppBaseInfoDeviceUtil.INSTANCE.getHostVersion(uniActivity));
            }
            if (filterArray.indexOf("hostName") != -1) {
                getAppBaseInfoResult.setHostName(uts.sdk.modules.DCloudUniGetAppBaseInfo.AppBaseInfoDeviceUtil.INSTANCE.getAppName(uniActivity));
            }
            if (filterArray.indexOf("hostTheme") != -1) {
                if (uts.sdk.modules.DCloudUniGetAppBaseInfo.AppBaseInfoDeviceUtil.INSTANCE.isSystemNightMode(uniActivity)) {
                    str = io.dcloud.common.ui.blur.DCBlurDraweeView.DARK;
                } else {
                    str = io.dcloud.common.ui.blur.DCBlurDraweeView.LIGHT;
                }
                getAppBaseInfoResult.setHostTheme(str);
            }
            if (filterArray.indexOf("hostLanguage") != -1) {
                getAppBaseInfoResult.setHostLanguage(uts.sdk.modules.DCloudUniGetAppBaseInfo.AppBaseInfoDeviceUtil.INSTANCE.getOsLanguage(uniActivity));
            }
            if (filterArray.indexOf(com.taobao.weex.common.WXConfig.appVersion) != -1) {
                getAppBaseInfoResult.setAppVersion(uts.sdk.modules.DCloudUniGetAppBaseInfo.AppBaseInfoDeviceUtil.INSTANCE.getAppVersionName());
            }
            if (filterArray.indexOf("appVersionCode") != -1) {
                getAppBaseInfoResult.setAppVersionCode(uts.sdk.modules.DCloudUniGetAppBaseInfo.AppBaseInfoDeviceUtil.INSTANCE.getAppVersionCode());
            }
        } else {
            if (filterArray.indexOf(com.taobao.weex.common.WXConfig.appVersion) != -1) {
                getAppBaseInfoResult.setAppVersion(io.dcloud.uts.NumberKt.toString_number_nullable$default(io.dcloud.uts.UTSAndroid.INSTANCE.getAppVersion().get("name"), (java.lang.Number) null, 1, (java.lang.Object) null));
            }
            if (filterArray.indexOf("appVersionCode") != -1) {
                getAppBaseInfoResult.setAppVersionCode(io.dcloud.uts.NumberKt.toString_number_nullable$default(io.dcloud.uts.UTSAndroid.INSTANCE.getAppVersion().get("code"), (java.lang.Number) null, 1, (java.lang.Object) null));
            }
        }
        if (filterArray.indexOf("appLanguage") != -1) {
            getAppBaseInfoResult.setAppLanguage(uts.sdk.modules.DCloudUniGetAppBaseInfo.AppBaseInfoDeviceUtil.INSTANCE.getOsLanguageNormal(uniActivity));
        }
        if (filterArray.indexOf("language") != -1) {
            getAppBaseInfoResult.setLanguage(uts.sdk.modules.DCloudUniGetAppBaseInfo.AppBaseInfoDeviceUtil.INSTANCE.getOsLanguage(uniActivity));
        }
        if (filterArray.indexOf("version") != -1) {
            getAppBaseInfoResult.setVersion(uts.sdk.modules.DCloudUniGetAppBaseInfo.AppBaseInfoDeviceUtil.INSTANCE.getAppInnerVersion());
        }
        if (filterArray.indexOf("appWgtVersion") != -1) {
            getAppBaseInfoResult.setAppWgtVersion(uts.sdk.modules.DCloudUniGetAppBaseInfo.AppBaseInfoDeviceUtil.INSTANCE.getAppVersionName());
        }
        if (filterArray.indexOf("isUniAppX") != -1) {
            getAppBaseInfoResult.setUniAppX(java.lang.Boolean.valueOf(io.dcloud.uts.UTSAndroid.INSTANCE.isUniAppX()));
        }
        if (filterArray.indexOf("uniCompileVersion") != -1) {
            getAppBaseInfoResult.setUniCompileVersion(io.dcloud.uts.UTSAndroid.INSTANCE.getUniCompileVersion());
        }
        if (filterArray.indexOf("uniCompilerVersion") != -1) {
            getAppBaseInfoResult.setUniCompilerVersion(io.dcloud.uts.UTSAndroid.INSTANCE.getUniCompileVersion());
        }
        if (filterArray.indexOf("uniPlatform") != -1) {
            getAppBaseInfoResult.setUniPlatform(io.dcloud.common.constant.AbsoluteConst.XML_APP);
        }
        if (filterArray.indexOf("uniRuntimeVersion") != -1) {
            getAppBaseInfoResult.setUniRuntimeVersion(io.dcloud.uts.UTSAndroid.INSTANCE.getUniRuntimeVersion());
        }
        if (filterArray.indexOf("uniCompileVersionCode") != -1) {
            getAppBaseInfoResult.setUniCompileVersionCode(convertVersionCode.invoke(io.dcloud.uts.UTSAndroid.INSTANCE.getUniCompileVersion()));
        }
        if (filterArray.indexOf("uniCompilerVersionCode") != -1) {
            getAppBaseInfoResult.setUniCompilerVersionCode(convertVersionCode.invoke(io.dcloud.uts.UTSAndroid.INSTANCE.getUniCompileVersion()));
        }
        if (filterArray.indexOf("uniRuntimeVersionCode") != -1) {
            getAppBaseInfoResult.setUniRuntimeVersionCode(convertVersionCode.invoke(io.dcloud.uts.UTSAndroid.INSTANCE.getUniRuntimeVersion()));
        }
        if (filterArray.indexOf("packageName") != -1) {
            getAppBaseInfoResult.setPackageName(uts.sdk.modules.DCloudUniGetAppBaseInfo.AppBaseInfoDeviceUtil.INSTANCE.getPackageName(uniActivity));
        }
        if (filterArray.indexOf("signature") != -1) {
            getAppBaseInfoResult.setSignature(uts.sdk.modules.DCloudUniGetAppBaseInfo.AppBaseInfoDeviceUtil.INSTANCE.getAppSignatureSHA1(uniActivity));
        }
        if (filterArray.indexOf("appTheme") != -1) {
            getAppBaseInfoResult.setAppTheme(io.dcloud.uts.UTSAndroid.INSTANCE.getAppTheme());
        }
        if (filterArray.indexOf(io.dcloud.common.constant.AbsoluteConst.XML_CHANNEL) != -1) {
            getAppBaseInfoResult.setChannel(uts.sdk.modules.DCloudUniGetAppBaseInfo.AppBaseInfoDeviceUtil.INSTANCE.getChannel(uniActivity));
        }
        return getAppBaseInfoResult;
    }

    public static final kotlin.jvm.functions.Function1<java.lang.String, java.lang.Number> getConvertVersionCode() {
        return convertVersionCode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Number convertVersionCode$lambda$2(java.lang.String str) {
        java.lang.Number numberDec = 2;
        boolean z = false;
        java.lang.String str2 = "";
        for (java.lang.Number numberInc = (java.lang.Number) 0; io.dcloud.uts.NumberKt.compareTo(numberInc, java.lang.Integer.valueOf(str.length())) < 0; numberInc = io.dcloud.uts.NumberKt.inc(numberInc)) {
            char c = io.dcloud.uts.StringKt.get(str, numberInc);
            if (z) {
                if (java.lang.Character.isDigit(c)) {
                    str2 = str2 + c;
                }
                numberDec = io.dcloud.uts.NumberKt.dec(numberDec);
                if (io.dcloud.uts.NumberKt.numberEquals(numberDec, 0)) {
                    break;
                }
            } else if (java.lang.Character.isDigit(c)) {
                str2 = str2 + c;
            } else if (c == '.') {
                str2 = str2 + c;
                z = true;
            }
        }
        return io.dcloud.uts.NumberKt.parseFloat(str2);
    }

    public static final uts.sdk.modules.DCloudUniGetAppBaseInfo.GetAppBaseInfoResult getAppBaseInfoByJs(uts.sdk.modules.DCloudUniGetAppBaseInfo.GetAppBaseInfoOptionsJSONObject getAppBaseInfoOptionsJSONObject) {
        return getAppBaseInfo.invoke(getAppBaseInfoOptionsJSONObject != null ? new uts.sdk.modules.DCloudUniGetAppBaseInfo.GetAppBaseInfoOptions(getAppBaseInfoOptionsJSONObject.getFilter()) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final uts.sdk.modules.DCloudUniGetAppBaseInfo.GetAppBaseInfoResult getAppBaseInfo$lambda$0(uts.sdk.modules.DCloudUniGetAppBaseInfo.GetAppBaseInfoOptions getAppBaseInfoOptions) {
        io.dcloud.uts.UTSArray<java.lang.String> uTSArray = new io.dcloud.uts.UTSArray<>();
        if (getAppBaseInfoOptions != null && getAppBaseInfoOptions.getFilter() != null) {
            uTSArray = getAppBaseInfoOptions.getFilter();
        }
        if (getAppBaseInfoOptions == null || io.dcloud.uts.NumberKt.numberEquals(uTSArray.getLength(), 0)) {
            uTSArray = io.dcloud.uts.UTSArrayKt._uA("appId", com.taobao.weex.common.WXConfig.appName, com.taobao.weex.common.WXConfig.appVersion, "appVersionCode", "appLanguage", "language", "version", "appWgtVersion", "hostLanguage", "hostVersion", "hostName", "hostPackageName", "hostSDKVersion", "hostTheme", "isUniAppX", "uniCompileVersion", "uniCompilerVersion", "uniPlatform", "uniRuntimeVersion", "uniCompileVersionCode", "uniCompilerVersionCode", "uniRuntimeVersionCode", "packageName", "signature", "appTheme", io.dcloud.common.constant.AbsoluteConst.XML_CHANNEL);
        }
        return getBaseInfo(uTSArray);
    }
}
